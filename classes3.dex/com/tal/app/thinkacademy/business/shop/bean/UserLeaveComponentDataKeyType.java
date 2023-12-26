package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentDataKeyType;", "", "content", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "PHONE", "EMAIL", "NORMAL", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public enum UserLeaveComponentDataKeyType {
    PHONE("phone"),
    EMAIL("email"),
    NORMAL("normal");
    
    private final String content;

    private UserLeaveComponentDataKeyType(String str) {
        this.content = str;
    }

    public final String getContent() {
        return this.content;
    }
}
