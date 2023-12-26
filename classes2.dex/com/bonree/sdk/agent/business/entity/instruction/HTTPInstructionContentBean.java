package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Map;

public class HTTPInstructionContentBean extends InstructionContentBean {
    @SerializedName("bs")
    private int bodySize;
    @SerializedName("ct")
    private int contentType;
    @SerializedName("h")
    private Map<String, Object> headers;
    @SerializedName("rb")
    private String requestBody;
    @SerializedName("rm")
    private int requestMethod;
    @SerializedName("url")
    private String requestUrl;
    @SerializedName("to")
    private int timeOut;

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public void setTimeOut(int i) {
        this.timeOut = i;
    }

    public int getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestMethod(int i) {
        this.requestMethod = i;
    }

    public Map<String, Object> getHeaders() {
        return this.headers;
    }

    public int getContentType() {
        return this.contentType;
    }

    public void setContentType(int i) {
        this.contentType = i;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public int getBodySize() {
        return this.bodySize;
    }

    public void setBodySize(int i) {
        this.bodySize = i;
    }

    public String toString() {
        return "HTTPInstructionContentBean{requestUrl='" + this.requestUrl + '\'' + ", timeOut=" + this.timeOut + ", requestMethod=" + this.requestMethod + ", headers=" + this.headers + ", contentType=" + this.contentType + ", requestBody='" + this.requestBody + '\'' + ", bodySize=" + this.bodySize + '}';
    }
}
