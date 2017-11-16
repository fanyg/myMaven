package com.pactera.domain;

import java.util.Date;

import org.springframework.stereotype.Component;


public class UserInfo {
    private Long id;
    private String loginPhoneNumber;
    private String cifId;
    private String clientName;
    private String icardType;
    private String icardId;
    private Integer entryStatus;
    private Integer listType;
    private Integer contactFlag;
    private String creditReq;
    private Integer creditStatus;
    private Integer overdueFlag;
    private Integer openAccountFlag;
    private Integer identityChannel;
    private String bankCard;
    private String cellPhoneNo;
    private Integer vertifyIdentityFlag;
    private Integer uploadIdentityFlag;
    private Integer vertifyPoliceImageFlag;
    private Integer vertifyFaceFlag;
    private Integer signCreditFlag;
    private Integer fillInSuppinfoFlag;
    private Integer setTranpassFlag;
    private Long creditResult;
    private Long validAmount;
    private Date created;
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
        this.loginPhoneNumber = loginPhoneNumber;
    }

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIcardType() {
        return icardType;
    }

    public void setIcardType(String icardType) {
        this.icardType = icardType;
    }

    public String getIcardId() {
        return icardId;
    }

    public void setIcardId(String icardId) {
        this.icardId = icardId;
    }

    public Integer getContactFlag() {
        return contactFlag;
    }

    public void setContactFlag(Integer contactFlag) {
        this.contactFlag = contactFlag;
    }

    public String getCreditReq() {
        return creditReq;
    }

    public void setCreditReq(String creditReq) {
        this.creditReq = creditReq;
    }

    public Integer getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Integer creditStatus) {
        this.creditStatus = creditStatus;
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
        this.bankCard = bankCard;
    }

    public String getCellPhoneNo() {
        return cellPhoneNo;
    }

    public void setCellPhoneNo(String cellPhoneNo) {
        this.cellPhoneNo = cellPhoneNo;
    }

    public Integer getVertifyIdentityFlag() {
        return vertifyIdentityFlag;
    }

    public void setVertifyIdentityFlag(Integer vertifyIdentityFlag) {
        this.vertifyIdentityFlag = vertifyIdentityFlag;
    }

    public Integer getUploadIdentityFlag() {
        return uploadIdentityFlag;
    }

    public void setUploadIdentityFlag(Integer uploadIdentityFlag) {
        this.uploadIdentityFlag = uploadIdentityFlag;
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

    public Integer getOverdueFlag() {
        return overdueFlag;
    }

    public void setOverdueFlag(Integer overdueFlag) {
        this.overdueFlag = overdueFlag;
    }

    public Integer getOpenAccountFlag() {
        return openAccountFlag;
    }

    public void setOpenAccountFlag(Integer openAccountFlag) {
        this.openAccountFlag = openAccountFlag;
    }

    public Integer getSetTranpassFlag() {
        return setTranpassFlag;
    }

    public void setSetTranpassFlag(Integer setTranpassFlag) {
        this.setTranpassFlag = setTranpassFlag;
    }
}