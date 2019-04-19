package com.noodles.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author FA00118
 * 实现传入类名，创建对象遍历属性传入默认值
 */
public class ReflectTest {
	public static void main(String args[]) throws Exception {
		//GLApprovalTrackBean bean = (GLApprovalTrackBean) getObject("org.javabasis.reflect.bean.GLApprovalTrackBean");
		
		/*File file = new File("F:/workspace_noodles/study/javabasis/src/main/java/org/javabasis/reflect/bean");
		
		File[] fileArr = file.listFiles();
		
		for(File fileTerm : fileArr){
			String fileName = fileTerm.getName().substring(0, fileTerm.getName().indexOf("."));
			System.out.println("**************************" + fileName + "**************************");
			String filePackage = "org.javabasis.reflect.bean." + fileName;
			
			reflectAppendStr(getObject(filePackage));
			System.out.println();
		}*/
		
		reflectAppendStr(getObject("org.javabasis.reflect.bean.InsFlowBean"), "item.");
		
	}
	
	public static Object getObject(String className) throws Exception, IllegalAccessException, ClassNotFoundException{
		return Class.forName(className).newInstance();
	}
	
	public static void reflectSetValue(Object model) throws Exception {
		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		// 获取属性的名字
		String[] modelName = new String[field.length];
		String[] modelType = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			// 获取属性的名字
			String name = field[i].getName();
			modelName[i] = name;
			// 获取属性类型
			String type = field[i].getGenericType().toString();
			modelType[i] = type;

			// 关键。。。可访问私有变量
			field[i].setAccessible(true);

			// 将属性的首字母大写
			if (type.equals("class java.lang.String")) {
				field[i].set(model, "ss");
			}
			
			if (type.equals("class java.lang.Integer")) {
				System.out.println(name);
				field[i].set(model, 1);
			}
			if (type.equals("class java.lang.Short")) {
				System.out.println(name);
				field[i].set(model, 1);
			}
			if (type.equals("class java.lang.Double")) {
				System.out.println(name);
				field[i].set(model, 1d);
			}
			if (type.equals("class java.lang.Boolean")) {
				System.out.println(name);
				field[i].set(model, true);
			}
			if (type.equals("class java.util.Date")) {
				System.out.println(name);
				field[i].set(model, new Date());
			}
			
		}
	}
	
	public static void relectGetValue(Object model) throws Exception {
		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		// 获取属性的名字
		String[] modelName = new String[field.length];
		String[] modelType = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			// 获取属性的名字
			String name = field[i].getName();
			modelName[i] = name;
			// 获取属性类型
			String type = field[i].getGenericType().toString();
			modelType[i] = type;

			// 关键。。。可访问私有变量
			field[i].setAccessible(true);

			// 将属性的首字母大写
			name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());

			if (type.equals("class java.lang.String")) {
				// 如果type是类类型，则前面包含"class "，后面跟类名
				Method m = model.getClass().getMethod("get" + name);
				// 调用getter方法获取属性值
				String value = (String) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:" + value);
				}

			}
			
			if (type.equals("class java.lang.String")) {
				// 如果type是类类型，则前面包含"class "，后面跟类名
				Method m = model.getClass().getMethod("get" + name);
				// 调用getter方法获取属性值
				String value = (String) m.invoke(model);
				if (value != null) {

					System.out.println("attribute value:" + value);
				}

			}
			if (type.equals("class java.lang.Integer")) {
				Method m = model.getClass().getMethod("get" + name);
				Integer value = (Integer) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:" + value);
				}
			}
			if (type.equals("class java.lang.Short")) {
				Method m = model.getClass().getMethod("get" + name);
				Short value = (Short) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:" + value);
				}
			}
			if (type.equals("class java.lang.Double")) {
				Method m = model.getClass().getMethod("get" + name);
				Double value = (Double) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:" + value);
				}
			}
			if (type.equals("class java.lang.Boolean")) {
				Method m = model.getClass().getMethod("get" + name);
				Boolean value = (Boolean) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:" + value);
				}
			}
			if (type.equals("class java.util.Date")) {
				Method m = model.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(model);
				if (value != null) {
					System.out.println("attribute value:"
							+ value.toLocaleString());
				}
			}
		}
	}
	
	public static void reflectAppendStr(Object model, String item) throws Exception {
		// 获取实体类的所有属性，返回Field数组
		Field[] field = model.getClass().getDeclaredFields();
		// 获取属性的名字
		String[] modelName = new String[field.length];
		String[] modelType = new String[field.length];
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < field.length; i++) {
			// 获取属性的名字
			String name = field[i].getName();
			modelName[i] = name;
			// 获取属性类型
			String type = field[i].getGenericType().toString();
			modelType[i] = type;
			
			String jdbcType = "";
			if (type.equals("class java.lang.String")) {
				jdbcType="VARCHAR";
			}
			
			if (type.equals("class java.lang.Integer")) {
				jdbcType="INTEGER";
			}
			if (type.equals("class java.lang.Short")) {
				jdbcType="INTEGER";
			}
			if (type.equals("class java.lang.Double")) {
				jdbcType="DECIMAL";
			}
			if (type.equals("class java.lang.Boolean")) {
				jdbcType="VARCHAR";
			}
			if (type.equals("class java.util.Date")) {
				jdbcType = "TIMESTAMP";
			}
			
			if(type.equals("class java.math.BigDecimal")){
				jdbcType = "DECIMAL";
			}
			
			//System.out.println(type);

			// 关键。。。可访问私有变量
			field[i].setAccessible(true);

			sb.append("#{" + item);
			sb.append(name + ", ");
			sb.append("jdbcType=" + jdbcType +"},");
			if((i+1)%5 == 0){
				sb.append("\r\n");
			}
		}
		System.out.println(sb.substring(0, sb.length() - 1));
	}
}
