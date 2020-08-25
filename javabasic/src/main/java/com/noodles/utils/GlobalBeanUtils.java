package com.noodles.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.noodles.gson.JsonUtil;
import com.noodles.utils.bean.NlsQueryRepaymentPlanRespVo;
import com.noodles.utils.bean.NlsRepaymentPlanDetail;
import com.noodles.utils.bean.QueryRepaymentPlanRespVo;
import com.noodles.utils.bean.RepaymentPlanDetail;

/**
 * @filename GlobalBeanUtils
 * @description GlobalBeanUtils
 * @author 巫威
 * @date 2020/8/25 14:09
 */
public class GlobalBeanUtils {

	public static void main(String[] args) {
		NlsQueryRepaymentPlanRespVo nlsQueryRepaymentPlanRespVo = new NlsQueryRepaymentPlanRespVo();
		nlsQueryRepaymentPlanRespVo.setLoan_receipts("jk20202000000");
		nlsQueryRepaymentPlanRespVo.setLoan_amt(145286.0);
		List<NlsRepaymentPlanDetail> list = new ArrayList<>();
		NlsRepaymentPlanDetail nlsRepaymentPlanDetail1 = new NlsRepaymentPlanDetail();
		nlsRepaymentPlanDetail1.setPeriod(1);
		nlsRepaymentPlanDetail1.setPay_status("d");
		list.add(nlsRepaymentPlanDetail1);

		NlsRepaymentPlanDetail nlsRepaymentPlanDetail2 = new NlsRepaymentPlanDetail();
		nlsRepaymentPlanDetail2.setPeriod(2);
		nlsRepaymentPlanDetail2.setPay_amt(1258.0);
		nlsRepaymentPlanDetail2.setPay_status("ddd");
		list.add(nlsRepaymentPlanDetail2);
		nlsQueryRepaymentPlanRespVo.setPay_list(list);

		QueryRepaymentPlanRespVo queryRepaymentPlanRespVo = new QueryRepaymentPlanRespVo();
		copyProperties(nlsQueryRepaymentPlanRespVo, queryRepaymentPlanRespVo, "pay_list",
				(t, r) -> r.setPay_list(copyList(t.getPay_list(), RepaymentPlanDetail::new)));

		/*QueryRepaymentPlanRespVo queryRepaymentPlanRespVo = new QueryRepaymentPlanRespVo();
		copyProperties(nlsQueryRepaymentPlanRespVo, queryRepaymentPlanRespVo, "pay_list",
				(t, r) -> copyList(t.getPay_list(), r.getPay_list(),
						(a) -> copyProperties(a, RepaymentPlanDetail::new)));*/

		System.out.println(JsonUtil.toJson(queryRepaymentPlanRespVo));
	}


	/**
	 * 空构造函数
	 * @return
	 * @author Eric
	 * @date 2019/8/6 10:58
	 */
	private GlobalBeanUtils() {

	}

	/**
	 * 将对象Obj转为Map
	 * @param object 需要初始化的数据
	 * @author Eric
	 * @date 2019/8/6 9:44
	 */
	public static Map<String, Object> objectToMap(Object object) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(object, new Object[0]);
					map.put(propertyName, result);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return map;
	}

	/**
	 * Map转Obj对象
	 * @param map  需要初始化的数据
	 * @param clazz  需要转化成的实体类
	 * @return java.lang.Object
	 * @author Eric
	 * @date 2019/8/6 9:50
	 */
	public static final Object mapToObject(Map<String, ? extends Object> map, Class<?> clazz) throws Exception {
		Object object = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			object = clazz.newInstance();
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (map.containsKey(propertyName)) {
					Object value = map.get(propertyName);
					Object[] args = new Object[] { value };
					descriptor.getWriteMethod().invoke(object, args);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return object;
	}

	/**
	 * 对象复制
	 * @param source 源对象
	 * @param target 目标对象
	 * @return void
	 * @author Eric
	 * @date 2019/8/6 9:54
	 */
	public static void copyProperties(Object source, Object target) {
		try {
			BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 功能描述 获取对象时null的字段名称数组
	 * @param source 源对象
	 * @return java.lang.String[]
	 * @author Eric
	 * @date 2019/12/23 17:20
	 */
	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	/**
	 * 对象复制
	 * @param source 源对象
	 * @param target 目标对象
	 * @param ignore
	 * @param biConsumer
	 * @return void
	 * @author Eric
	 * @date 2020/8/25 13:58
	 */
	public static <T, R> void copyProperties(T source, R target, String ignore, BiConsumer<T, R> biConsumer) {
		BeanUtils.copyProperties(source, target, ignore);
		biConsumer.accept(source, target);
	}

	/**
	 * 对象复制
	 * @param tList
	 * @param supplier
	 * @return java.util.List<R>
	 * @author Eric
	 * @date 2020/8/25 13:58
	 */
	public static <T, R> List<R> copyList(List<T> tList, Supplier<R> supplier) {
		return tList.stream().map(a -> copyObject(a, supplier)).collect(Collectors.toList());
	}

	/**
	 * 对象复制
	 * @param source 源对象
	 * @param supplier
	 * @return R
	 * @author Eric
	 * @date 2020/8/25 14:07
	 */
	public static <R, T> R copyObject(T source, Supplier<R> supplier) {
		R target = supplier.get();
		copyProperties(source, target);
		return target;
	}


}
