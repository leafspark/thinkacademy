package com.tal.app.thinkacademy.common.business.browser.dispatch;

import java.io.Serializable;
import java.util.Map;

public class JsModel implements Serializable {
    private String className;
    private String methodName;
    private Map<String, Object> params;

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String str) {
        this.methodName = str;
    }

    public Map<String, Object> getParam() {
        return this.params;
    }

    public void setParam(Map<String, Object> map) {
        this.params = map;
    }
}
