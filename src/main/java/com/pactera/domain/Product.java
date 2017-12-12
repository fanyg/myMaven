package com.pactera.domain;

import java.util.Date;

public class Product {
    private Long id;

    private Long productId;

    private String productName;

    private String productCode;

    private Integer productStatus;

    private Integer accountType;

    private Long minAmount;

    private Long maxAmount;

    private Date created;

    private Date modified;

    private Integer limitCycle;

    private Integer isDel;

    private Integer isProjectShared;

    private Byte isPublicPay;

    private Byte mannulPay;

    private Byte loanOrderPay;

    private Integer refundPayOverflow;

    private String opOwner;

    private Integer overFlowOrderPay;

    private String productStatusDqm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getLimitCycle() {
        return limitCycle;
    }

    public void setLimitCycle(Integer limitCycle) {
        this.limitCycle = limitCycle;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsProjectShared() {
        return isProjectShared;
    }

    public void setIsProjectShared(Integer isProjectShared) {
        this.isProjectShared = isProjectShared;
    }

    public Byte getIsPublicPay() {
        return isPublicPay;
    }

    public void setIsPublicPay(Byte isPublicPay) {
        this.isPublicPay = isPublicPay;
    }

    public Byte getMannulPay() {
        return mannulPay;
    }

    public void setMannulPay(Byte mannulPay) {
        this.mannulPay = mannulPay;
    }

    public Byte getLoanOrderPay() {
        return loanOrderPay;
    }

    public void setLoanOrderPay(Byte loanOrderPay) {
        this.loanOrderPay = loanOrderPay;
    }

    public Integer getRefundPayOverflow() {
        return refundPayOverflow;
    }

    public void setRefundPayOverflow(Integer refundPayOverflow) {
        this.refundPayOverflow = refundPayOverflow;
    }

    public String getOpOwner() {
        return opOwner;
    }

    public void setOpOwner(String opOwner) {
        this.opOwner = opOwner == null ? null : opOwner.trim();
    }

    public Integer getOverFlowOrderPay() {
        return overFlowOrderPay;
    }

    public void setOverFlowOrderPay(Integer overFlowOrderPay) {
        this.overFlowOrderPay = overFlowOrderPay;
    }

    public String getProductStatusDqm() {
        return productStatusDqm;
    }

    public void setProductStatusDqm(String productStatusDqm) {
        this.productStatusDqm = productStatusDqm == null ? null : productStatusDqm.trim();
    }
}