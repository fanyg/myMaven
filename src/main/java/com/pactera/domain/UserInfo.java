package com.pactera.domain;

import java.util.Date;

public class UserInfo {
    private Long id;

    private String loginPhoneNumber;

    private String cifId;

    private String clientName;

    private String icardType;

    private String icardId;

    private Integer entryStatus;

    private Integer listType;

    private String creditReq;

    private Integer creditStatus;

    private Integer overdueFlag;

    private Integer openaccountFlag;

    private Integer identityChannel;

    private String bankCard;

    private String bankCode;

    private Integer bankCardType;

    private String cellPhoneNo;

    private Integer vertifyPoliceFlag;

    private Integer uploadIdentityFlag;

    private Integer vertifyIdentityFlag;

    private Integer vertifyPoliceImageFlag;

    private Integer vertifyFaceFlag;

    private Integer signCreditFlag;

    private Integer fillInSuppinfoFlag;

    private Integer setTranpassFlag;

    private Integer sentCreditFlag;

    private Long creditResult;

    private Long validAmount;

    private Integer userStatus;

    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginPhoneNumber() {
        return loginPhoneNumber;
    }

    public void setLoginPhoneNumber(String loginPhoneNumber) {
        this.loginPhoneNumber = loginPhoneNumber == null ? null : loginPhoneNumber.trim();
    }

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId == null ? null : cifId.trim();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    public String getIcardType() {
        return icardType;
    }

    public void setIcardType(String icardType) {
        this.icardType = icardType == null ? null : icardType.trim();
    }

    public String getIcardId() {
        return icardId;
    }

    public void setIcardId(String icardId) {
        this.icardId = icardId == null ? null : icardId.trim();
    }

    public Integer getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(Integer entryStatus) {
        this.entryStatus = entryStatus;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getCreditReq() {
        return creditReq;
    }

    public void setCreditReq(String creditReq) {
        this.creditReq = creditReq == null ? null : creditReq.trim();
    }

    public Integer getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Integer creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Integer getOverdueFlag() {
        return overdueFlag;
    }

    public void setOverdueFlag(Integer overdueFlag) {
        this.overdueFlag = overdueFlag;
    }

    public Integer getOpenaccountFlag() {
        return openaccountFlag;
    }

    public void setOpenaccountFlag(Integer openaccountFlag) {
        this.openaccountFlag = openaccountFlag;
    }

    public Integer getIdentityChannel() {
        return identityChannel;
    }

    public void setIdentityChannel(Integer identityChannel) {
        this.identityChannel = identityChannel;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public Integer getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Integer bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getCellPhoneNo() {
        return cellPhoneNo;
    }

    public void setCellPhoneNo(String cellPhoneNo) {
        this.cellPhoneNo = cellPhoneNo == null ? null : cellPhoneNo.trim();
    }

    public Integer getVertifyPoliceFlag() {
        return vertifyPoliceFlag;
    }

    public void setVertifyPoliceFlag(Integer vertifyPoliceFlag) {
        this.vertifyPoliceFlag = vertifyPoliceFlag;
    }

    public Integer getUploadIdentityFlag() {
        return uploadIdentityFlag;
    }

    public void setUploadIdentityFlag(Integer uploadIdentityFlag) {
        this.uploadIdentityFlag = uploadIdentityFlag;
    }

    public Integer getVertifyIdentityFlag() {
        return vertifyIdentityFlag;
    }

    public void setVertifyIdentityFlag(Integer vertifyIdentityFlag) {
        this.vertifyIdentityFlag = vertifyIdentityFlag;
    }

    public Integer getVertifyPoliceImageFlag() {
        return vertifyPoliceImageFlag;
    }

    public void setVertifyPoliceImageFlag(Integer vertifyPoliceImageFlag) {
        this.vertifyPoliceImageFlag = vertifyPoliceImageFlag;
    }

    public Integer getVertifyFaceFlag() {
        return vertifyFaceFlag;
    }

    public void setVertifyFaceFlag(Integer vertifyFaceFlag) {
        this.vertifyFaceFlag = vertifyFaceFlag;
    }

    public Integer getSignCreditFlag() {
        return signCreditFlag;
    }

    public void setSignCreditFlag(Integer signCreditFlag) {
        this.signCreditFlag = signCreditFlag;
    }

    public Integer getFillInSuppinfoFlag() {
        return fillInSuppinfoFlag;
    }

    public void setFillInSuppinfoFlag(Integer fillInSuppinfoFlag) {
        this.fillInSuppinfoFlag = fillInSuppinfoFlag;
    }

    public Integer getSetTranpassFlag() {
        return setTranpassFlag;
    }

    public void setSetTranpassFlag(Integer setTranpassFlag) {
        this.setTranpassFlag = setTranpassFlag;
    }

    public Integer getSentCreditFlag() {
        return sentCreditFlag;
    }

    public void setSentCreditFlag(Integer sentCreditFlag) {
        this.sentCreditFlag = sentCreditFlag;
    }

    public Long getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(Long creditResult) {
        this.creditResult = creditResult;
    }

    public Long getValidAmount() {
        return validAmount;
    }

    public void setValidAmount(Long validAmount) {
        this.validAmount = validAmount;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}