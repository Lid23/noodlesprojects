package com.noodles.reflect.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件名：InsFlow.java 
 * 描述： 社保缴费明细 聚信力同步类
 *  作者：kj00064 日期：2018年8月1日下午2:14:25
 */
public class InsFlowBean implements Serializable {

	/** */
	private static final long serialVersionUID = 1L;
	private String id;
	/** 批次号 */
	private String batchNo;
	/** 身份证 */
	private String idCard;
	/** 交易日期 */
	private String payDate;
	/** 缴费开始时间 **/
	private String startDate;
	/** 缴费结束时间 **/
	private String endDate;
	/** 缴费基数 **/
	private String baseRmb;
	/** 单位缴费 */
	private String comRmb;
	/** 个人缴费 */
	private String perRmb;
	/** 个人余额 */
	private String balanceRmb;
	private String monthRmb;
	/** 公司名称 */
	private String comName;
	private String payType;
	/** 缴费类型 1=养老，2=失业，3=工伤，4=生育，5=医疗,7=大病医疗 */
	private String flowType;
	private String createdBy;
	private Date createdDatetime;
	private String source;
	/** 缴费月数 */
	private String payMonths;
	/** 社保编号 */
	private String soinsNum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBaseRmb() {
		return baseRmb;
	}
	public void setBaseRmb(String baseRmb) {
		this.baseRmb = baseRmb;
	}
	public String getComRmb() {
		return comRmb;
	}
	public void setComRmb(String comRmb) {
		this.comRmb = comRmb;
	}
	public String getPerRmb() {
		return perRmb;
	}
	public void setPerRmb(String perRmb) {
		this.perRmb = perRmb;
	}
	public String getBalanceRmb() {
		return balanceRmb;
	}
	public void setBalanceRmb(String balanceRmb) {
		this.balanceRmb = balanceRmb;
	}
	public String getMonthRmb() {
		return monthRmb;
	}
	public void setMonthRmb(String monthRmb) {
		this.monthRmb = monthRmb;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPayMonths() {
		return payMonths;
	}
	public void setPayMonths(String payMonths) {
		this.payMonths = payMonths;
	}
	public String getSoinsNum() {
		return soinsNum;
	}
	public void setSoinsNum(String soinsNum) {
		this.soinsNum = soinsNum;
	}

}
