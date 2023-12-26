package com.amazonaws.auth.policy;

@Deprecated
public enum STSActions implements Action {
    AssumeRole("sts:AssumeRole"),
    AssumeRoleWithWebIdentity("sts:AssumeRoleWithWebIdentity");
    
    private final String action;

    private STSActions(String str) {
        this.action = str;
    }

    public String getActionName() {
        return this.action;
    }
}
