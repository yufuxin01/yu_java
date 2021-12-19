package com.yu.case19;

import java.io.Serializable;
import java.util.Date;

/**
 * Filename: InterfaceLogModel.java
 * 
 * @Copyright: Copyright (c)2016
 * @Company: jd
 * @author: huanglaoxie
 * @function:接口日志
 * @version: 1.0
 * @Create at: 2016年9月18日 下午7:18:01
 */
public class InterfaceLogModel implements Serializable {
    
    private static final long serialVersionUID = 8751096133178538657L;

    private Long id;

    private String LogNo;

    private String serverPoolName;

    private String clientPoolName;

    private String clientIp;

    private String serverIp;

    private String serviceName;

    private String methodName;

    private String inputParams;

    private String outputParams;

    private String keyword;

    private Long costTime;

    private String analysisResult;

    private String analysisSummary;

    private String seqId;

    private String excptionPrintInfo;

    private Date createTime;

    private Date updateTime;
    /**方法主动记录的业务日志*/
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogNo() {
        return LogNo;
    }

    public void setLogNo(String logNo) {
        LogNo = logNo;
    }

    public String getServerPoolName() {
        return serverPoolName;
    }

    public void setServerPoolName(String serverPoolName) {
        this.serverPoolName = serverPoolName;
    }

    public String getClientPoolName() {
        return clientPoolName;
    }

    public void setClientPoolName(String clientPoolName) {
        this.clientPoolName = clientPoolName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(String outputParams) {
        this.outputParams = outputParams;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public String getAnalysisResult() {
        return analysisResult;
    }

    public void setAnalysisResult(String analysisResult) {
        this.analysisResult = analysisResult;
    }

    public String getAnalysisSummary() {
        return analysisSummary;
    }

    public void setAnalysisSummary(String analysisSummary) {
        this.analysisSummary = analysisSummary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSeqId() {
        return seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public String getExcptionPrintInfo() {
        return excptionPrintInfo;
    }

    public void setExcptionPrintInfo(String excptionPrintInfo) {
        this.excptionPrintInfo = excptionPrintInfo;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
