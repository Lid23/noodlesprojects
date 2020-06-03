package com.noodles.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.noodles.gson.JsonUtil;
import com.noodles.java8.bean.TxLnTrxBean;
import com.noodles.utils.DateUtils;
import static java.util.stream.Collectors.toMap;

/**
 * @filename StreamTest
 * @description java8流例子
 * @author 巫威
 * @date 2020/4/26 14:13
 */
public class StreamTest {

	public static void main(String[] args) {
		// 集合中查找交易日期最小的交易

		List<TxLnTrxBean> txList = new ArrayList<>();
		TxLnTrxBean tx1 = new TxLnTrxBean();
		TxLnTrxBean tx2 = new TxLnTrxBean();
		TxLnTrxBean tx3 = new TxLnTrxBean();

		tx1.setTrxRefNo("1");
		tx1.setCurrStatus("S");

		tx2.setTrxRefNo("1");
		tx2.setCurrStatus("R");

		tx3.setTrxRefNo("3");
		tx3.setCurrStatus("R");

		txList.add(tx1);
		txList.add(tx2);
		txList.add(tx3);


		//System.out.println(txList.stream().collect(toMap(TxLnTrxBean::getTrxRefNo, TxLnTrxBean::getCurrStatus)));


		/**v -> v表示选择将原来的对象作为map的value值*/
		//System.out.println(JsonUtil.toJson(txList.stream().collect(toMap(TxLnTrxBean::getTrxRefNo, v -> v))));

		/**(v1, v2) -> v1中，如果v1与v2的key值相同，选择v1作为那个key所对应的value值*/
		System.out.println(JsonUtil.toJson(txList.stream().collect(toMap(TxLnTrxBean::getTrxRefNo, v -> v, (v1, v2) -> v2))));

	}
}
