package com.noodles.utils.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 文件名：QueryRepaymentPlanRespVo.java
 * 描述：还款计划查询-响应
 * 作者：Carl
 * 日期：2018年1月3日下午4:15:47
 */
public class QueryRepaymentPlanRespVo implements Serializable {

	/** */
	private static final long serialVersionUID = 4704401740165511742L;

	/**借据编号*/
	private String loan_receipts;

	/**总记录数*/
	private int total_num;

	/**返回记录数*/
	private int ret_num;

	/**贷款发放日期(YYYYMMDD)*/
	private String db_date;

	/**贷款金额*/
	private double loan_amt;

	/**还款计划列表*/
	private List<RepaymentPlanDetail> pay_list;

	/** 处理状态*/
	private String trans_state;

	/** 错误编码*/
	private String error_code;

	/** 错误信息*/
	private String error_msg;

	/** 签名*/
	private String sign;

	public QueryRepaymentPlanRespVo() {
	}

	public QueryRepaymentPlanRespVo(String trans_state) {
		this.trans_state = trans_state;
	}

	public QueryRepaymentPlanRespVo(String trans_state, String error_code, String error_msg) {
		this.trans_state = trans_state;
		this.error_code = error_code;
		this.error_msg = error_msg;
	}

	public String getLoan_receipts() {
		return loan_receipts;
	}

	public void setLoan_receipts(String loan_receipts) {
		this.loan_receipts = loan_receipts;
	}

	public int getTotal_num() {
		return total_num;
	}

	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}

	public int getRet_num() {
		return ret_num;
	}

	public void setRet_num(int ret_num) {
		this.ret_num = ret_num;
	}

	public String getDb_date() {
		return db_date;
	}

	public void setDb_date(String db_date) {
		this.db_date = db_date;
	}

	public double getLoan_amt() {
		return loan_amt;
	}

	public void setLoan_amt(double loan_amt) {
		this.loan_amt = loan_amt;
	}

	public List<RepaymentPlanDetail> getPay_list() {
		return pay_list;
	}

	public void setPay_list(List<RepaymentPlanDetail> pay_list) {
		this.pay_list = pay_list;
	}

	public String getTrans_state() {
		return trans_state;
	}

	public void setTrans_state(String trans_state) {
		this.trans_state = trans_state;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
