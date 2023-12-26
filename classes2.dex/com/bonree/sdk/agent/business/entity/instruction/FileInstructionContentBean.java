package com.bonree.sdk.agent.business.entity.instruction;

import com.bonree.sdk.common.gson.annotations.SerializedName;

public class FileInstructionContentBean extends InstructionContentBean {
    @SerializedName("fp")
    private String filePath;
    @SerializedName("px")
    private int pathPrefix;
    @SerializedName("s")
    private long size;
    @SerializedName("url")
    private String url;

    public void setPathPrefix(int i) {
        this.pathPrefix = i;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public int getPathPrefix() {
        return this.pathPrefix;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "FileInstructionContentBean{pathPrefix=" + this.pathPrefix + ", filePath='" + this.filePath + '\'' + ", size=" + this.size + ", url='" + this.url + '\'' + '}';
    }
}
