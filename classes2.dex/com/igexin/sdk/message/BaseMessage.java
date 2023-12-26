package com.igexin.sdk.message;

import com.igexin.push.core.d;
import java.io.Serializable;

public class BaseMessage implements Serializable {
    private String a = d.a;
    private String b = d.e;
    private String c = d.u;

    public String getAppid() {
        return this.a;
    }

    public String getClientId() {
        return this.c;
    }

    public String getPkgName() {
        return this.b;
    }

    public void setAppid(String str) {
        this.a = str;
    }

    public void setClientId(String str) {
        this.c = str;
    }

    public void setPkgName(String str) {
        this.b = str;
    }
}
