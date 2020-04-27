package com.noodles.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.noodles.gson.JsonUtil;
import com.noodles.java8.bean.TxLnTrxBean;
import com.noodles.utils.DateUtils;

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
		txList.add(tx1);
		txList.add(tx2);
		txList.add(tx3);

		Date nowDate = new Date();
		Date yesDate = DateUtils.addDays(nowDate, -1);

		tx1.setTrxRefNo("1");
		tx1.setTrxDate(nowDate);

		tx2.setTrxRefNo("2");
		tx2.setCurrStatus("R");
		tx2.setTrxDate(nowDate);

		tx3.setTrxRefNo("3");
		tx3.setCurrStatus("R");
		tx3.setTrxDate(yesDate);

		TxLnTrxBean min = txList.stream().filter(txLnTrxBean -> "R".equals(txLnTrxBean.getCurrStatus()))
				.min((trx1, trx2) -> trx1.getTrxDate().compareTo(trx2.getTrxDate())).orElse(null);
		System.out.println(JsonUtil.toJson(min));

		System.out.println(yesDate.compareTo(nowDate));

	}
}
