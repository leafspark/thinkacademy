package com.tal.app.thinkacademy.live.core.live.http.bean;

public class ProgramQuestionConfig {
    private String exeName;
    private String md5;
    private String size;
    private String url;
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public String getExeName() {
        return this.exeName;
    }

    public void setExeName(String str) {
        this.exeName = str;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String str) {
        this.size = str;
    }

    public String toString() {
        return "ProgramQuestionConfig{version='" + this.version + '\'' + ", url='" + this.url + '\'' + ", md5='" + this.md5 + '\'' + ", exeName='" + this.exeName + '\'' + ", size='" + this.size + '\'' + '}';
    }
}
