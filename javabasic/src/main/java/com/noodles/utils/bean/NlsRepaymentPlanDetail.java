package com.noodles.utils.bean;

import java.io.Serializable;

/**
 * 文件名：RepaymentPlanDetail.java
 * 描述：还款计划
 * 作者：Carl
 * 日期：2018年1月3日下午4:19:45
 */
public class NlsRepaymentPlanDetail implements Serializable {

	/** */
	private static final long serialVersionUID = 298048855736682612L;

	/**本期到期日期*/
	private String loan_end_date;

	/**本期期数*/
	private int period;

	/**计划还款本金金额*/
	private double plan_norm_amt;

	/**计划还款利息金额*/
	private double plan_int_amt;

	/**计划服务费金额*/
	private double plan_adm_amt;

	/**已还金额*/
	private double pay_amt;

	/**还款状态*/
	private String pay_status;

	public String getLoan_end_date() {
		return loan_end_date;
	}

	public void setLoan_end_date(String loan_end_date) {
		this.loan_end_date = loan_end_date;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public double getPlan_norm_amt() {
		return plan_norm_amt;
	}

	public void setPlan_norm_amt(double plan_norm_amt) {
		this.plan_norm_amt = plan_norm_amt;
	}

	public double getPlan_int_amt() {
		return plan_int_amt;
	}

	public void setPlan_int_amt(double plan_int_amt) {
		this.plan_int_amt = plan_int_amt;
	}

	public double getPlan_adm_amt() {
		return plan_adm_amt;
	}

	public void setPlan_adm_amt(double plan_adm_amt) {
		this.plan_adm_amt = plan_adm_amt;
	}

	public double getPay_amt() {
		return pay_amt;
	}

	public void setPay_amt(double pay_amt) {
		this.pay_amt = pay_amt;
	}

	public String getPay_status() {
		return pay_status;
	}

	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}

}
