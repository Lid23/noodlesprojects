package com.noodles.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.noodles.java8.bean.Transaction;
import static java.util.stream.Collectors.groupingBy;

/**
 * @filename TransactionDemo
 * @description 交易demo
 * @author 巫威
 * @date 2019/8/29 11:20
 */
public class TransactionDemo {

	static List<Transaction> transactions = Arrays
			.asList(new Transaction(100.00, "RMB"), new Transaction(500.00, "USD"), new Transaction(400.00, "HKD"),
					new Transaction(300.00, "EUR"), new Transaction(300.00, "RMB"), new Transaction(200.00, "RMB"));

	public static void main(String... args) {
		/**筛选金额较高的交易，然后按货币分组*/
		Map<String, List<Transaction>> currencyMap = transactions.stream()
				.filter(transaction -> transaction.getPrice() > 100.0).collect(groupingBy(Transaction::getCurrency));
		System.out.println(currencyMap);
	}
}
