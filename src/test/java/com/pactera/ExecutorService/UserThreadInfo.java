package com.pactera.ExecutorService;

/**
 * Created by kakagrace on 2017/9/14.
 */
public class UserThreadInfo {

    private int creditStatus;//授信状态
    private boolean overdue;//是否有逾期
    private boolean openAccount;//是否已开户
    private boolean auth;//是否已身份认证
    private boolean idCheck;//是否已上传身份影像
    private boolean faceRegister;//是否已通过人脸注册
    private boolean signed;//是否已征信授权
    private boolean extraInfoCompleted;//是否已完成补充信息
    private boolean payPasswordSet;//是否已设置交易密码
    private long totalAmount;//总额度
    private long validAmount;//可用额度

    public int getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(int creditStatus) {
        this.creditStatus = creditStatus;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public boolean isOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(boolean openAccount) {
        this.openAccount = openAccount;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isIdCheck() {
        return idCheck;
    }

    public void setIdCheck(boolean idCheck) {
        this.idCheck = idCheck;
    }

    public boolean isFaceRegister() {
        return faceRegister;
    }

    public void setFaceRegister(boolean faceRegister) {
        this.faceRegister = faceRegister;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    public boolean isExtraInfoCompleted() {
        return extraInfoCompleted;
    }

    public void setExtraInfoCompleted(boolean extraInfoCompleted) {
        this.extraInfoCompleted = extraInfoCompleted;
    }

    public boolean isPayPasswordSet() {
        return payPasswordSet;
    }

    public void setPayPasswordSet(boolean payPasswordSet) {
        this.payPasswordSet = payPasswordSet;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getValidAmount() {
        return validAmount;
    }

    public void setValidAmount(long validAmount) {
        this.validAmount = validAmount;
    }
}
