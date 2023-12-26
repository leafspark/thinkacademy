package com.tal.app.thinkacademy.common.network;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/ENVIRONMENTAL;", "", "title", "", "envName", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getEnvName", "()Ljava/lang/String;", "getTitle", "DEVELOP", "ALPHA", "TEST", "PRE", "ONLINE", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseUrlEx.kt */
public enum ENVIRONMENTAL {
    DEVELOP("开发环境", "dev"),
    ALPHA("测试环境", "alpha"),
    TEST("测试环境", "test"),
    PRE("预发环境", "pre"),
    ONLINE("线上环境", "online");
    
    private final String envName;
    private final String title;

    private ENVIRONMENTAL(String str, String str2) {
        this.title = str;
        this.envName = str2;
    }

    public final String getEnvName() {
        return this.envName;
    }

    public final String getTitle() {
        return this.title;
    }
}
