package com.noodles.file;

import java.io.Serializable;

/**
 * 文件名：LoanConfirmCallbackRespVo.java
 * 描述：放款通知-响应
 * 作者：Carl
 * 日期：2018年1月3日下午2:40:14
 */
public class LoanConfirmCallbackRespVo implements Serializable {

	/** */
	private static final long serialVersionUID = -7582665359906756536L;

	/**借款流水号*/
	private String loan_receipts;

	public String getLoan_receipts() {
		return loan_receipts;
	}

	public void setLoan_receipts(String loan_receipts) {
		this.loan_receipts = loan_receipts;
	}

}
