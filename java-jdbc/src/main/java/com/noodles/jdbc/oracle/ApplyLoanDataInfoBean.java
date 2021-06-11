/******************************************************************
** 类    名：ApplyLoanInfoBean
** 描    述：贷款资料信息表（申请表）
** 创 建 者：bianj
** 创建时间：2016-06-12 19:17:36
******************************************************************/

package com.noodles.jdbc.oracle;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 贷款资料信息表（申请表）(APPLY_LOAN_INFO)
 * 
 * @author bianj
 * @version 1.0.0 2016-06-12
 */
@Entity
@Table(name = "APPLY_LOAN_INFO")
public class ApplyLoanDataInfoBean implements java.io.Serializable {
	/** 版本号 */
	private static final long serialVersionUID = -3372853414514918439L;

	/** 申请编号 */
	@Id
	@Column(name = "APPLY_CODE", unique = true, nullable = false, length = 32)
	private String applyCode;

	/** 申请贷款金额 */
	@Column(name = "APPLY_LOAN_AMOUNT", nullable = true, length = 12)
	private Integer applyLoanAmount;

	/** 申请期数（暂留） */
	@Column(name = "APPLY_PERIOD", nullable = true, length = 3)
	private Integer applyPeriod;

	/** 贷款产品 */
	@Column(name = "APPLY_LOAN_PRODUCT", nullable = true, length = 2)
	private String applyLoanProduct;

	/** 申请城市 */
	@Column(name = "APPLY_CITY", nullable = true, length = 6)
	private String applyCity;

	/** 申请日期 */
	@Column(name = "APPLY_DATE", nullable = true)
	private Date applyDate;

	/** 渠道 */
	@Column(name = "APPLY_CHANNAL", nullable = true, length = 10)
	private String applyChannal;

	/** 销售组 */
	@Column(name = "SALE_GROUP", nullable = true, length = 10)
	private String saleGroup;

	/** 代理人号码 */
	@Column(name = "AGENT_NUMBER", nullable = true, length = 20)
	private String agentNumber;

	/** 媒体 */
	@Column(name = "MEDIUM", nullable = true, length = 5)
	private String medium;

	/** 来源 */
	@Column(name = "SOURCE", nullable = true, length = 5)
	private String source;

	/** 贷款用途 */
	@Column(name = "LOAN_PURPOSE", nullable = true, length = 5)
	private String loanPurpose;

	/** 合同编号 */
	@Column(name = "ACCT_NO", nullable = true, length = 20)
	private String acctNo;

	/** 分行 */
	@Column(name = "LOAN_BRANCH", nullable = true, length = 20)
	private String loanBranch;

	/** 贷款类型 */
	@Column(name = "LOAN_TYPE", nullable = true, length = 4)
	private String loanType;

	/** 借款人类型 */
	@Column(name = "BORROWER_TYPE", nullable = true, length = 10)
	private String borrowerType;

	/** 推广类别 */
	@Column(name = "EXTEND_TYPE", nullable = true, length = 5)
	private String extendType;

	/** 初审额度（评分模型） */
	@Column(name = "FIRST_LIMIT", nullable = true)
	private BigDecimal firstLimit;

	/** 初审期数 */
	@Column(name = "FIRST_PERIODS", nullable = true, length = 4)
	private Integer firstPeriods;

	/** 客户确认额度 */
	@Column(name = "CONFIRM_LIMIT", nullable = true)
	private BigDecimal confirmLimit;

	/** 客户确认期数 */
	@Column(name = "CONFIRM__PERIODS", nullable = true, length = 4)
	private Integer confirmPeriods;

	/** 最终贷款额度（放款） */
	@Column(name = "FINAL_LIMIT", nullable = true)
	private BigDecimal finalLimit;

	/** 最终贷款期数（放款） */
	@Column(name = "FINAL_PERIODS", nullable = true, length = 4)
	private Integer finalPeriods;

	/** 身份证号码 */
	@Column(name = "CERT_NO", nullable = true, length = 18)
	private String certNo;

	/** 还息方式 */
	@Column(name = "PAY_INT_TYPE_CODE", nullable = true, length = 10)
	private String payIntTypeCode;

	/** 计息方式 */
	@Column(name = "PAY_INT_WAY", nullable = true, length = 10)
	private String payIntWay;

	/** 还款模式 */
	@Column(name = "PAY_MODE_CODE", nullable = true, length = 10)
	private String payModeCode;

	/** 还款日节假日处理（默认为0） */
	@Column(name = "CUTOFF_DATE_DALAY_TYPE", nullable = true, length = 2)
	private String cutoffDateDalayType;

	/** 创建人 */
	@Column(name = "CREATED_BY", nullable = true, length = 20)
	private String createdBy;

	/** 创建时间 */
	@Column(name = "CREATED_DATE", nullable = true)
	private Date createdDate;

	/** 修改人 */
	@Column(name = "UPDATED_BY", nullable = true, length = 20)
	private String updatedBy;

	/** 修改时间 */
	@Column(name = "UPDATE_DATE", nullable = true)
	private Date updateDate;

	/** 出资方编码 */
	@Column(name = "FUNDER_CODE", nullable = true, length = 32)
	private String funderCode;

	/** 担保公司编码 */
	@Column(name = "GUARANTEE_CODE", nullable = true, length = 32)
	private String guaranteeCode;

	/** 客户来源方 */
	@Column(name = "CUST_SOURCE_CODE", nullable = true, length = 32)
	private String custSourceCode;

	/** 管理方 */
	@Column(name = "MANAGER_CODE", nullable = true, length = 32)
	private String managerCode;

	/** 签约日期（初审后客户签约日期） */
	@Column(name = "SIGNING_DATE", nullable = true)
	private Date signingDate;

	/** 审批通过后，发送发放请求日期 */
	@Column(name = "SEND_FOUNDER_DATE", nullable = true)
	private Date sendFounderDate;

	/** 产品费用项版本 */
	@Column(name = "FEE_VERSION_CODE", nullable = true, length = 20)
	private String feeVersionCode;

	/** 信用评分 */
	@Column(name = "CREDIT_SCORE", nullable = true, length = 18)
	private String creditScore;

	/** 被续贷申请编号 */
	@Column(name = "CONTINUE_APPLY_CODE", nullable = true, length = 32)
	private String continueApplyCode;

	/** 续贷金额 */
	@Column(name = "CONTINUE_AMONT", nullable = true)
	private BigDecimal continueAmont;

	/** 续贷结清日期 */
	@Column(name = "CONTINUE_DATE", nullable = true)
	private Date continueDate;

	/** 授信额度编号 */
	@Column(name = "CREDIT_LIMIT_CODE", nullable = true, length = 32)
	private String creditLimitCode;

	/** 借据编号 */
	@Column(name = "IOU_NO", nullable = true, length = 32)
	private String iouNo;

	/** 合作方申请号 */
	@Column(name = "PRANTER_APPLY_CODE", nullable = true, length = 32)
	private String pranterApplyCode;

	/** 贷款支用编号 */
	@Column(name = "LOAN_DISBURSE_CODE", nullable = true, length = 32)
	private String loanDisburseCode;
	/** 合作方支用流水号 */
	@Column(name = "PRANTER_DISBURSE_CODE", nullable = true, length = 32)
	private String pranterDisburseCode;
	/** 利率是否分等级 */
	@Column(name = "IS_RATE_GRADE", nullable = true, length = 2)
	private String isRateGrade;

	/** 推广来源 */
	@Column(name = "EXTEND_SOURCE", nullable = true, length = 20)
	private String extendSource;

	/**计算额度*/
	@Column(name = "CALC_LIMIT", nullable = true)
	private BigDecimal calcLimit;

	/** 是否能续贷  Y  是 N  否 */
	@Column(name = "IS_ALLOW_RELOAN", nullable = true, length = 8)
	private String isAllowReloan;

	/** 是否是域内客户 1域内，0域外 3其他*/
	@Column(name = "IS_INTRA_DOMAIN", nullable = true, length = 2)
	private String isIntraDomain;

	/**  资金模式（OF:自有资金、JF:联合资金）*/
	@Column(name = "FUND_MODE", nullable = true, length = 8)
	private String fundMode;

	/** b卡评分*/
	@Column(name = "SECOND_PART_SCORE", nullable = true, length = 8)
	private String secondPartScore;

	/**
	 * 获取申请编号
	 * 
	 * @return 申请编号
	 */
	public String getApplyCode() {
		return this.applyCode;
	}

	/**
	 * 设置申请编号
	 * 
	 * @param applyCode
	 *          申请编号
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * 获取申请贷款金额
	 * 
	 * @return 申请贷款金额
	 */
	public Integer getApplyLoanAmount() {
		return this.applyLoanAmount;
	}

	/**
	 * 设置申请贷款金额
	 * 
	 * @param applyLoanAmount
	 *          申请贷款金额
	 */
	public void setApplyLoanAmount(Integer applyLoanAmount) {
		this.applyLoanAmount = applyLoanAmount;
	}

	/**
	 * 获取申请期数（暂留）
	 * 
	 * @return 申请期数（暂留）
	 */
	public Integer getApplyPeriod() {
		return this.applyPeriod;
	}

	/**
	 * 设置申请期数（暂留）
	 * 
	 * @param applyPeriod
	 *          申请期数（暂留）
	 */
	public void setApplyPeriod(Integer applyPeriod) {
		this.applyPeriod = applyPeriod;
	}

	/**
	 * 获取贷款产品
	 * 
	 * @return 贷款产品
	 */
	public String getApplyLoanProduct() {
		return this.applyLoanProduct;
	}

	/**
	 * 设置贷款产品
	 * 
	 * @param applyLoanProduct
	 *          贷款产品
	 */
	public void setApplyLoanProduct(String applyLoanProduct) {
		this.applyLoanProduct = applyLoanProduct;
	}

	/**
	 * 获取申请城市
	 * 
	 * @return 申请城市
	 */
	public String getApplyCity() {
		return this.applyCity;
	}

	/**
	 * 设置申请城市
	 * 
	 * @param applyCity
	 *          申请城市
	 */
	public void setApplyCity(String applyCity) {
		this.applyCity = applyCity;
	}

	/**
	 * 获取申请日期
	 * 
	 * @return 申请日期
	 */
	public Date getApplyDate() {
		return this.applyDate;
	}

	/**
	 * 设置申请日期
	 * 
	 * @param applyDate
	 *          申请日期
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * 获取渠道
	 * 
	 * @return 渠道
	 */
	public String getApplyChannal() {
		return this.applyChannal;
	}

	/**
	 * 设置渠道
	 * 
	 * @param applyChannal
	 *          渠道
	 */
	public void setApplyChannal(String applyChannal) {
		this.applyChannal = applyChannal;
	}

	/**
	 * 获取销售组
	 * 
	 * @return 销售组
	 */
	public String getSaleGroup() {
		return this.saleGroup;
	}

	/**
	 * 设置销售组
	 * 
	 * @param saleGroup
	 *          销售组
	 */
	public void setSaleGroup(String saleGroup) {
		this.saleGroup = saleGroup;
	}

	/**
	 * 获取代理人号码
	 * 
	 * @return 代理人号码
	 */
	public String getAgentNumber() {
		return this.agentNumber;
	}

	/**
	 * 设置代理人号码
	 * 
	 * @param agentNumber
	 *          代理人号码
	 */
	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	/**
	 * 获取媒体
	 * 
	 * @return 媒体
	 */
	public String getMedium() {
		return this.medium;
	}

	/**
	 * 设置媒体
	 * 
	 * @param medium
	 *          媒体
	 */
	public void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * 获取来源
	 * 
	 * @return 来源
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * 设置来源
	 * 
	 * @param source
	 *          来源
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 获取贷款用途
	 * 
	 * @return 贷款用途
	 */
	public String getLoanPurpose() {
		return this.loanPurpose;
	}

	/**
	 * 设置贷款用途
	 * 
	 * @param loanPurpose
	 *          贷款用途
	 */
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	/**
	 * 获取合同编号
	 * 
	 * @return 合同编号
	 */
	public String getAcctNo() {
		return this.acctNo;
	}

	/**
	 * 设置合同编号
	 * 
	 * @param acctNo
	 *          合同编号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	/**
	 * 获取分行
	 * 
	 * @return 分行
	 */
	public String getLoanBranch() {
		return this.loanBranch;
	}

	/**
	 * 设置分行
	 * 
	 * @param loanBranch
	 *          分行
	 */
	public void setLoanBranch(String loanBranch) {
		this.loanBranch = loanBranch;
	}

	/**
	 * 获取贷款类型
	 * 
	 * @return 贷款类型
	 */
	public String getLoanType() {
		return this.loanType;
	}

	/**
	 * 设置贷款类型
	 * 
	 * @param loanType
	 *          贷款类型
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * 获取借款人类型
	 * 
	 * @return 借款人类型
	 */
	public String getBorrowerType() {
		return this.borrowerType;
	}

	/**
	 * 设置借款人类型
	 * 
	 * @param borrowerType
	 *          借款人类型
	 */
	public void setBorrowerType(String borrowerType) {
		this.borrowerType = borrowerType;
	}

	/**
	 * 获取推广类别
	 * 
	 * @return 推广类别
	 */
	public String getExtendType() {
		return this.extendType;
	}

	/**
	 * 设置推广类别
	 * 
	 * @param extendType
	 *          推广类别
	 */
	public void setExtendType(String extendType) {
		this.extendType = extendType;
	}

	/**
	 * 获取初审额度（评分模型）
	 * 
	 * @return 初审额度（评分模型）
	 */
	public BigDecimal getFirstLimit() {
		return this.firstLimit;
	}

	/**
	 * 设置初审额度（评分模型）
	 * 
	 * @param firstLimit
	 *          初审额度（评分模型）
	 */
	public void setFirstLimit(BigDecimal firstLimit) {
		this.firstLimit = firstLimit;
	}

	/**
	 * 获取初审期数
	 * 
	 * @return 初审期数
	 */
	public Integer getFirstPeriods() {
		return this.firstPeriods;
	}

	/**
	 * 设置初审期数
	 * 
	 * @param firstPeriods
	 *          初审期数
	 */
	public void setFirstPeriods(Integer firstPeriods) {
		this.firstPeriods = firstPeriods;
	}

	/**
	 * 获取客户确认额度
	 * 
	 * @return 客户确认额度
	 */
	public BigDecimal getConfirmLimit() {
		return this.confirmLimit;
	}

	/**
	 * 设置客户确认额度
	 * 
	 * @param confirmLimit
	 *          客户确认额度
	 */
	public void setConfirmLimit(BigDecimal confirmLimit) {
		this.confirmLimit = confirmLimit;
	}

	/**
	 * 获取客户确认期数
	 * 
	 * @return 客户确认期数
	 */
	public Integer getConfirmPeriods() {
		return this.confirmPeriods;
	}

	/**
	 * 设置客户确认期数
	 * 
	 * @param confirmPeriods
	 *          客户确认期数
	 */
	public void setConfirmPeriods(Integer confirmPeriods) {
		this.confirmPeriods = confirmPeriods;
	}

	/**
	 * 获取最终贷款额度（放款）
	 * 
	 * @return 最终贷款额度（放款）
	 */
	public BigDecimal getFinalLimit() {
		return this.finalLimit;
	}

	/**
	 * 设置最终贷款额度（放款）
	 * 
	 * @param finalLimit
	 *          最终贷款额度（放款）
	 */
	public void setFinalLimit(BigDecimal finalLimit) {
		this.finalLimit = finalLimit;
	}

	/**
	 * 获取最终贷款期数（放款）
	 * 
	 * @return 最终贷款期数（放款）
	 */
	public Integer getFinalPeriods() {
		return this.finalPeriods;
	}

	/**
	 * 设置最终贷款期数（放款）
	 * 
	 * @param finalPeriods
	 *          最终贷款期数（放款）
	 */
	public void setFinalPeriods(Integer finalPeriods) {
		this.finalPeriods = finalPeriods;
	}

	/**
	 * 获取身份证号码
	 * 
	 * @return 身份证号码
	 */
	public String getCertNo() {
		return this.certNo;
	}

	/**
	 * 设置身份证号码
	 * 
	 * @param certNo
	 *          身份证号码
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	/**
	 * 获取还息方式
	 * 
	 * @return 还息方式
	 */
	public String getPayIntTypeCode() {
		return this.payIntTypeCode;
	}

	/**
	 * 设置还息方式
	 * 
	 * @param payIntTypeCode
	 *          还息方式
	 */
	public void setPayIntTypeCode(String payIntTypeCode) {
		this.payIntTypeCode = payIntTypeCode;
	}

	/**
	 * 获取计息方式
	 * 
	 * @return 计息方式
	 */
	public String getPayIntWay() {
		return this.payIntWay;
	}

	/**
	 * 设置计息方式
	 * 
	 * @param payIntWay
	 *          计息方式
	 */
	public void setPayIntWay(String payIntWay) {
		this.payIntWay = payIntWay;
	}

	/**
	 * 获取还款模式
	 * 
	 * @return 还款模式
	 */
	public String getPayModeCode() {
		return this.payModeCode;
	}

	/**
	 * 设置还款模式
	 * 
	 * @param payModeCode
	 *          还款模式
	 */
	public void setPayModeCode(String payModeCode) {
		this.payModeCode = payModeCode;
	}

	/**
	 * 获取还款日节假日处理（默认为0）
	 * 
	 * @return 还款日节假日处理（默认为0）
	 */
	public String getCutoffDateDalayType() {
		return this.cutoffDateDalayType;
	}

	/**
	 * 设置还款日节假日处理（默认为0）
	 * 
	 * @param cutoffDateDalayType
	 *          还款日节假日处理（默认为0）
	 */
	public void setCutoffDateDalayType(String cutoffDateDalayType) {
		this.cutoffDateDalayType = cutoffDateDalayType;
	}

	/**
	 * 获取创建人
	 * 
	 * @return 创建人
	 */
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * 设置创建人
	 * 
	 * @param createdBy
	 *          创建人
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 获取创建时间
	 * 
	 * @return 创建时间
	 */
	public Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * 设置创建时间
	 * 
	 * @param createdDate
	 *          创建时间
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * 获取修改人
	 * 
	 * @return 修改人
	 */
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	/**
	 * 设置修改人
	 * 
	 * @param updatedBy
	 *          修改人
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * 获取修改时间
	 * 
	 * @return 修改时间
	 */
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 设置修改时间
	 * 
	 * @param updateDate
	 *          修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取出资方编码
	 * 
	 * @return 出资方编码
	 */
	public String getFunderCode() {
		return this.funderCode;
	}

	/**
	 * 设置出资方编码
	 * 
	 * @param funderCode
	 *          出资方编码
	 */
	public void setFunderCode(String funderCode) {
		this.funderCode = funderCode;
	}

	/**
	 * 获取担保公司编码
	 * 
	 * @return 担保公司编码
	 */
	public String getGuaranteeCode() {
		return this.guaranteeCode;
	}

	/**
	 * 设置担保公司编码
	 * 
	 * @param guaranteeCode
	 *          担保公司编码
	 */
	public void setGuaranteeCode(String guaranteeCode) {
		this.guaranteeCode = guaranteeCode;
	}

	/**
	 * 获取客户来源方
	 * 
	 * @return 客户来源方
	 */
	public String getCustSourceCode() {
		return this.custSourceCode;
	}

	/**
	 * 设置客户来源方
	 * 
	 * @param custSourceCode
	 *          客户来源方
	 */
	public void setCustSourceCode(String custSourceCode) {
		this.custSourceCode = custSourceCode;
	}

	/**
	 * 获取管理方
	 * 
	 * @return 管理方
	 */
	public String getManagerCode() {
		return this.managerCode;
	}

	/**
	 * 设置管理方
	 * 
	 * @param managerCode
	 *          管理方
	 */
	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	/**
	 * 获取签约日期（初审后客户签约日期）
	 * 
	 * @return 签约日期（初审后客户签约日期）
	 */
	public Date getSigningDate() {
		return this.signingDate;
	}

	/**
	 * 设置签约日期（初审后客户签约日期）
	 * 
	 * @param signingDate
	 *          签约日期（初审后客户签约日期）
	 */
	public void setSigningDate(Date signingDate) {
		this.signingDate = signingDate;
	}

	/**
	 * 获取审批通过后，发送发放请求日期
	 * 
	 * @return 审批通过后
	 */
	public Date getSendFounderDate() {
		return this.sendFounderDate;
	}

	/**
	 * 设置审批通过后，发送发放请求日期
	 * 
	 * @param sendFounderDate
	 *          审批通过后，发送发放请求日期
	 */
	public void setSendFounderDate(Date sendFounderDate) {
		this.sendFounderDate = sendFounderDate;
	}

	/**
	 * 获取产品费用项版本
	 * 
	 * @return 产品费用项版本
	 */
	public String getFeeVersionCode() {
		return this.feeVersionCode;
	}

	/**
	 * 设置产品费用项版本
	 * 
	 * @param feeVersionCode
	 *          产品费用项版本
	 */
	public void setFeeVersionCode(String feeVersionCode) {
		this.feeVersionCode = feeVersionCode;
	}

	/**
	 * @return the creditScore
	 */
	public String getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}

	/**
	* 获取被续贷申请编号
	* 
	* @return 被续贷申请编号
	*/
	public String getContinueApplyCode() {
		return this.continueApplyCode;
	}

	/**
	 * 设置被续贷申请编号
	 * 
	 * @param continueApplyCode
	 *          被续贷申请编号
	 */
	public void setContinueApplyCode(String continueApplyCode) {
		this.continueApplyCode = continueApplyCode;
	}

	/**
	 * 获取续贷金额
	 * 
	 * @return 续贷金额
	 */
	public BigDecimal getContinueAmont() {
		return this.continueAmont;
	}

	/**
	 * 设置续贷金额
	 * 
	 * @param continueAmont
	 *          续贷金额
	 */
	public void setContinueAmont(BigDecimal continueAmont) {
		this.continueAmont = continueAmont;
	}

	/**
	 * 获取续贷结清日期
	 * 
	 * @return 续贷结清日期
	 */
	public Date getContinueDate() {
		return this.continueDate;
	}

	/**
	 * 设置续贷结清日期
	 * 
	 * @param continueDate
	 *          续贷结清日期
	 */
	public void setContinueDate(Date continueDate) {
		this.continueDate = continueDate;
	}

	/**
	 * 获取授信额度编号
	 * 
	 * @return 授信额度编号
	 */
	public String getCreditLimitCode() {
		return this.creditLimitCode;
	}

	/**
	 * 设置授信额度编号
	 * 
	 * @param creditLimitCode
	 *          授信额度编号
	 */
	public void setCreditLimitCode(String creditLimitCode) {
		this.creditLimitCode = creditLimitCode;
	}

	/**
	 * 获取借据编号
	 * 
	 * @return 借据编号
	 */
	public String getIouNo() {
		return this.iouNo;
	}

	/**
	 * 设置借据编号
	 * 
	 * @param iouNo
	 *          借据编号
	 */
	public void setIouNo(String iouNo) {
		this.iouNo = iouNo;
	}

	/**
	 * 获取合作方申请号
	 * 
	 * @return 合作方申请号
	 */
	public String getPranterApplyCode() {
		return this.pranterApplyCode;
	}

	/**
	 * 设置合作方申请号
	 * 
	 * @param pranterApplyCode
	 *          合作方申请号
	 */
	public void setPranterApplyCode(String pranterApplyCode) {
		this.pranterApplyCode = pranterApplyCode;
	}

	/**
	 * 获取贷款支用编号
	 * 
	 * @return 贷款支用编号
	 */
	public String getLoanDisburseCode() {
		return this.loanDisburseCode;
	}

	/**
	 * 设置贷款支用编号
	 * 
	 * @param loanDisburseCode
	 *          贷款支用编号
	 */
	public void setLoanDisburseCode(String loanDisburseCode) {
		this.loanDisburseCode = loanDisburseCode;
	}

	/**
	 * 获取合作方支用流水号
	 * 
	 * @return 合作方支用流水号
	 */
	public String getPranterDisburseCode() {
		return this.pranterDisburseCode;
	}

	/**
	 * 设置合作方支用流水号
	 * 
	 * @param pranterDisburseCode
	 *          合作方支用流水号
	 */
	public void setPranterDisburseCode(String pranterDisburseCode) {
		this.pranterDisburseCode = pranterDisburseCode;
	}

	/**
	 * 获取利率是否分等级
	 * 
	 * @return 利率是否分等级
	 */
	public String getIsRateGrade() {
		return this.isRateGrade;
	}

	/**
	 * 设置利率是否分等级
	 * 
	 * @param isRateGrade
	 *          利率是否分等级
	 */
	public void setIsRateGrade(String isRateGrade) {
		this.isRateGrade = isRateGrade;
	}

	/**
	 * 获取推广来源
	 * 
	 * @return 推广来源
	 */
	public String getExtendSource() {
		return this.extendSource;
	}

	/**
	 * 设置推广来源
	 * 
	 * @param extendSource
	 *          推广来源
	 */
	public void setExtendSource(String extendSource) {
		this.extendSource = extendSource;
	}

	public BigDecimal getCalcLimit() {
		return calcLimit;
	}

	public void setCalcLimit(BigDecimal calcLimit) {
		this.calcLimit = calcLimit;
	}

	public String getIsAllowReloan() {
		return isAllowReloan;
	}

	public void setIsAllowReloan(String isAllowReloan) {
		this.isAllowReloan = isAllowReloan;
	}

	public String getIsIntraDomain() {
		return isIntraDomain;
	}

	public void setIsIntraDomain(String isIntraDomain) {
		this.isIntraDomain = isIntraDomain;
	}

	public String getFundMode() {
		return fundMode;
	}

	public void setFundMode(String fundMode) {
		this.fundMode = fundMode;
	}

	public String getSecondPartScore() {
		return secondPartScore;
	}

	public void setSecondPartScore(String secondPartScore) {
		this.secondPartScore = secondPartScore;
	}
}