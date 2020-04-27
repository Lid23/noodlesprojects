/******************************************************************
** 类    名：TxLnTrxBean
** 描    述：交易表
** 创 建 者：bianj
** 创建时间：2016-06-12 18:51:52
******************************************************************/

package com.noodles.java8.bean;

import java.util.Date;

/**
 * 交易表(TX_LN_TRX)
 * 
 * @author bianj
 * @version 1.0.0 2016-06-12
 */
public class TxLnTrxBean implements java.io.Serializable, Comparable {
	/** 版本号 */
	private static final long serialVersionUID = -9115919496010853996L;

	/** 还款编号(每笔扣款ID) */
	private String repaymentCode;

	/** 申请号 */
	private String applyCode;

	/** 交易编号 */
	private String trxRefNo;

	/** 初始交易编号 */
	private String initTrxRefNo;

	/** 关联交易编号 */
	private String srcTrxRefNo;

	/** 源交易编号 */
	private String refTrxRefNo;

	/** 合作方 */
	private String partnerCode;

	/** 城市编码 */
	private String cityCode;

	/** 产品编码 */
	private String productCode;

	/** 支付方 */
	private String payer;

	/** 收款方 */
	private String payee;

	/** 交易日期 */
	private Date trxDate;

	/** 操作时间 */
	private Date operateDatetime;

	/** 初始交易金额 */
	private Double enterTtlAmt;

	/** 交易金额 */
	private Double ttlAmt;

	/** 交易类别 */
	private String trxCate;

	/** 还款方式 */
	private String payMethod;

	/** 拆帐方式 */
	private String splitMethod;

	/** 调帐状态 */
	private String correctStatus;

	/** 调帐人 */
	private String correctUserId;

	/** 调账时间 */
	private Date correctDatetime;

	/** 当前状态 */
	private String currStatus;

	/** 退款状态 */
	private String rfStatus;

	/** 操作人 */
	private String operator;

	/**  */
	private String operatorOrgCode;

	/** 创建人 */
	private String creator;

	/** 创建时间 */
	private Date createDate;

	/** 更新人 */
	private String updator;

	/** 更新时间 */
	private Date updateDate;

	/** 账户还款前状态 */
	private String acctStatusCode;

	/** 同一笔交易 */
	private String adeal;

	private String tranType;

	/**
	* 获取还款编号(每笔扣款ID)
	* 
	* @return 还款编号(每笔扣款ID)
	*/
	public String getRepaymentCode() {
		return this.repaymentCode;
	}

	/**
	 * 设置还款编号(每笔扣款ID)
	 * 
	 * @param repaymentCode
	 *          还款编号(每笔扣款ID)
	 */
	public void setRepaymentCode(String repaymentCode) {
		this.repaymentCode = repaymentCode;
	}

	/**
	 * 获取申请号
	 * 
	 * @return 申请号
	 */
	public String getApplyCode() {
		return this.applyCode;
	}

	/**
	 * 设置申请号
	 * 
	 * @param applyCode
	 *          申请号
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * 获取交易编号
	 * 
	 * @return 交易编号
	 */
	public String getTrxRefNo() {
		return this.trxRefNo;
	}

	/**
	 * 设置交易编号
	 * 
	 * @param trxRefNo
	 *          交易编号
	 */
	public void setTrxRefNo(String trxRefNo) {
		this.trxRefNo = trxRefNo;
	}

	/**
	 * 获取初始交易编号
	 * 
	 * @return 初始交易编号
	 */
	public String getInitTrxRefNo() {
		return this.initTrxRefNo;
	}

	/**
	 * 设置初始交易编号
	 * 
	 * @param initTrxRefNo
	 *          初始交易编号
	 */
	public void setInitTrxRefNo(String initTrxRefNo) {
		this.initTrxRefNo = initTrxRefNo;
	}

	/**
	 * 获取关联交易编号
	 * 
	 * @return 关联交易编号
	 */
	public String getSrcTrxRefNo() {
		return this.srcTrxRefNo;
	}

	/**
	 * 设置关联交易编号
	 * 
	 * @param srcTrxRefNo
	 *          关联交易编号
	 */
	public void setSrcTrxRefNo(String srcTrxRefNo) {
		this.srcTrxRefNo = srcTrxRefNo;
	}

	/**
	 * 获取源交易编号
	 * 
	 * @return 源交易编号
	 */
	public String getRefTrxRefNo() {
		return this.refTrxRefNo;
	}

	/**
	 * 设置源交易编号
	 * 
	 * @param refTrxRefNo
	 *          源交易编号
	 */
	public void setRefTrxRefNo(String refTrxRefNo) {
		this.refTrxRefNo = refTrxRefNo;
	}

	/**
	 * 获取合作方
	 * 
	 * @return 合作方
	 */
	public String getPartnerCode() {
		return this.partnerCode;
	}

	/**
	 * 设置合作方
	 * 
	 * @param partnerCode
	 *          合作方
	 */
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	/**
	 * 获取城市编码
	 * 
	 * @return 城市编码
	 */
	public String getCityCode() {
		return this.cityCode;
	}

	/**
	 * 设置城市编码
	 * 
	 * @param cityCode
	 *          城市编码
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * 获取产品编码
	 * 
	 * @return 产品编码
	 */
	public String getProductCode() {
		return this.productCode;
	}

	/**
	 * 设置产品编码
	 * 
	 * @param productCode
	 *          产品编码
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * 获取支付方
	 * 
	 * @return 支付方
	 */
	public String getPayer() {
		return this.payer;
	}

	/**
	 * 设置支付方
	 * 
	 * @param payer
	 *          支付方
	 */
	public void setPayer(String payer) {
		this.payer = payer;
	}

	/**
	 * 获取收款方
	 * 
	 * @return 收款方
	 */
	public String getPayee() {
		return this.payee;
	}

	/**
	 * 设置收款方
	 * 
	 * @param payee
	 *          收款方
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * 获取交易日期
	 * 
	 * @return 交易日期
	 */
	public Date getTrxDate() {
		return this.trxDate;
	}

	/**
	 * 设置交易日期
	 * 
	 * @param trxDate
	 *          交易日期
	 */
	public void setTrxDate(Date trxDate) {
		this.trxDate = trxDate;
	}

	/**
	 * 获取操作时间
	 * 
	 * @return 操作时间
	 */
	public Date getOperateDatetime() {
		return this.operateDatetime;
	}

	/**
	 * 设置操作时间
	 * 
	 * @param operateDatetime
	 *          操作时间
	 */
	public void setOperateDatetime(Date operateDatetime) {
		this.operateDatetime = operateDatetime;
	}

	/**
	 * 获取初始交易金额
	 * 
	 * @return 初始交易金额
	 */
	public Double getEnterTtlAmt() {
		return this.enterTtlAmt;
	}

	/**
	 * 设置初始交易金额
	 * 
	 * @param enterTtlAmt
	 *          初始交易金额
	 */
	public void setEnterTtlAmt(Double enterTtlAmt) {
		this.enterTtlAmt = enterTtlAmt;
	}

	/**
	 * 获取交易金额
	 * 
	 * @return 交易金额
	 */
	public Double getTtlAmt() {
		return this.ttlAmt;
	}

	/**
	 * 设置交易金额
	 * 
	 * @param ttlAmt
	 *          交易金额
	 */
	public void setTtlAmt(Double ttlAmt) {
		this.ttlAmt = ttlAmt;
	}

	/**
	 * 获取交易类别
	 * 
	 * @return 交易类别
	 */
	public String getTrxCate() {
		return this.trxCate;
	}

	/**
	 * 设置交易类别
	 * 
	 * @param trxCate
	 *          交易类别
	 */
	public void setTrxCate(String trxCate) {
		this.trxCate = trxCate;
	}

	/**
	 * 获取还款方式
	 * 
	 * @return 还款方式
	 */
	public String getPayMethod() {
		return this.payMethod;
	}

	/**
	 * 设置还款方式
	 * 
	 * @param payMethod
	 *          还款方式
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	/**
	 * 获取拆帐方式
	 * 
	 * @return 拆帐方式
	 */
	public String getSplitMethod() {
		return this.splitMethod;
	}

	/**
	 * 设置拆帐方式
	 * 
	 * @param splitMethod
	 *          拆帐方式
	 */
	public void setSplitMethod(String splitMethod) {
		this.splitMethod = splitMethod;
	}

	/**
	 * 获取调帐状态
	 * 
	 * @return 调帐状态
	 */
	public String getCorrectStatus() {
		return this.correctStatus;
	}

	/**
	 * 设置调帐状态
	 * 
	 * @param correctStatus
	 *          调帐状态
	 */
	public void setCorrectStatus(String correctStatus) {
		this.correctStatus = correctStatus;
	}

	/**
	 * 获取调帐人
	 * 
	 * @return 调帐人
	 */
	public String getCorrectUserId() {
		return this.correctUserId;
	}

	/**
	 * 设置调帐人
	 * 
	 * @param correctUserId
	 *          调帐人
	 */
	public void setCorrectUserId(String correctUserId) {
		this.correctUserId = correctUserId;
	}

	/**
	 * 获取调账时间
	 * 
	 * @return 调账时间
	 */
	public Date getCorrectDatetime() {
		return this.correctDatetime;
	}

	/**
	 * 设置调账时间
	 * 
	 * @param correctDatetime
	 *          调账时间
	 */
	public void setCorrectDatetime(Date correctDatetime) {
		this.correctDatetime = correctDatetime;
	}

	/**
	 * 获取当前状态
	 * 
	 * @return 当前状态
	 */
	public String getCurrStatus() {
		return this.currStatus;
	}

	/**
	 * 设置当前状态
	 * 
	 * @param currStatus
	 *          当前状态
	 */
	public void setCurrStatus(String currStatus) {
		this.currStatus = currStatus;
	}

	/**
	 * 获取退款状态
	 * 
	 * @return 退款状态
	 */
	public String getRfStatus() {
		return this.rfStatus;
	}

	/**
	 * 设置退款状态
	 * 
	 * @param rfStatus
	 *          退款状态
	 */
	public void setRfStatus(String rfStatus) {
		this.rfStatus = rfStatus;
	}

	/**
	 * 获取操作人
	 * 
	 * @return 操作人
	 */
	public String getOperator() {
		return this.operator;
	}

	/**
	 * 设置操作人
	 * 
	 * @param operator
	 *          操作人
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * 获取operatorOrgCode
	 * 
	 * @return operatorOrgCode
	 */
	public String getOperatorOrgCode() {
		return this.operatorOrgCode;
	}

	/**
	 * 设置operatorOrgCode
	 * 
	 * @param operatorOrgCode
	 *          operatorOrgCode
	 */
	public void setOperatorOrgCode(String operatorOrgCode) {
		this.operatorOrgCode = operatorOrgCode;
	}

	/**
	 * 获取创建人
	 * 
	 * @return 创建人
	 */
	public String getCreator() {
		return this.creator;
	}

	/**
	 * 设置创建人
	 * 
	 * @param creator
	 *          创建人
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * 获取创建时间
	 * 
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 设置创建时间
	 * 
	 * @param createDate
	 *          创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取更新人
	 * 
	 * @return 更新人
	 */
	public String getUpdator() {
		return this.updator;
	}

	/**
	 * 设置更新人
	 * 
	 * @param updator
	 *          更新人
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	/**
	 * 获取更新时间
	 * 
	 * @return 更新时间
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 设置更新时间
	 * 
	 * @param updateDate
	 *          更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取账户还款前状态
	 * 
	 * @return 账户还款前状态
	 */
	public String getAcctStatusCode() {
		return this.acctStatusCode;
	}

	/**
	 * 设置账户还款前状态
	 * 
	 * @param acctStatusCode
	 *          账户还款前状态
	 */
	public void setAcctStatusCode(String acctStatusCode) {
		this.acctStatusCode = acctStatusCode;
	}

	/**
	 * 获取同一笔交易
	 * 
	 * @return 同一笔交易
	 */
	public String getAdeal() {
		return this.adeal;
	}

	/**
	 * 设置同一笔交易
	 * @param adeal
	 *  同一笔交易
	 */
	public void setAdeal(String adeal) {
		this.adeal = adeal;
	}

	@Override
	public int compareTo(Object o) {
		TxLnTrxBean t = (TxLnTrxBean) o;
		String trxRefNo2 = t.getTrxRefNo();
		return this.trxRefNo.compareTo(trxRefNo2);
	}

	/**
	 * 获取交易类型 1 代扣 2快捷支付 
	 * @return 交易类型 1 代扣 2快捷支付
	 */
	public String getTranType() {
		return this.tranType;
	}

	/**
	 * 设置交易类型 1 代扣 2快捷支付 
	 * 交易类型 1 代扣 2快捷支付
	 */
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

}