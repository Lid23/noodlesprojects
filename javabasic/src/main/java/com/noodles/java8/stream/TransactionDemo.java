package com.noodles.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.noodles.java8.bean.CurrencyTransaction;
import static java.util.stream.Collectors.groupingBy;

/**
 * @filename TransactionDemo
 * @description 交易demo
 * @author 巫威
 * @date 2019/8/29 11:20
 */
public class TransactionDemo {

	static List<CurrencyTransaction> transactions = Arrays
			.asList(new CurrencyTransaction(100.00, "RMB"), new CurrencyTransaction(500.00, "USD"), new CurrencyTransaction(400.00, "HKD"),
					new CurrencyTransaction(300.00, "EUR"), new CurrencyTransaction(300.00, "RMB"), new CurrencyTransaction(200.00, "RMB"));

	public static void main(String... args) {
		/**筛选金额较高的交易，然后按货币分组*/
		Map<String, List<CurrencyTransaction>> currencyMap = transactions.stream()
				.filter(transaction -> transaction.getPrice() > 100.0).collect(groupingBy(CurrencyTransaction::getCurrency));
		System.out.println(currencyMap);
	}
}
