package com.sensorsdata.analytics.android.sdk.visual.model;

import java.util.List;

public class WebNodeInfo {
    private List<AlertInfo> alertInfos;
    private Status status;
    private String title;
    private String url;
    private List<WebNode> webNodes;

    public enum Status {
        SUCCESS,
        FAILURE
    }

    private WebNodeInfo(List<WebNode> list, List<AlertInfo> list2, String str, String str2, Status status2) {
        this.webNodes = list;
        this.alertInfos = list2;
        this.title = str;
        this.url = str2;
        this.status = status2;
    }

    public static WebNodeInfo createWebAlertInfo(List<AlertInfo> list) {
        return new Builder().setAlertInfo(list).setStatus(Status.FAILURE).create();
    }

    public static WebNodeInfo createWebNodesInfo(List<WebNode> list) {
        return new Builder().setWebNodes(list).setStatus(Status.SUCCESS).create();
    }

    public static WebNodeInfo createPageInfo(String str, String str2) {
        return new Builder().setTitle(str).setUrl(str2).create();
    }

    public static class Builder {
        private List<AlertInfo> alertInfos;
        private Status status;
        private String title;
        private String url;
        private List<WebNode> webNodes;

        /* access modifiers changed from: package-private */
        public Builder setWebNodes(List<WebNode> list) {
            this.webNodes = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setAlertInfo(List<AlertInfo> list) {
            this.alertInfos = list;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setStatus(Status status2) {
            this.status = status2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public WebNodeInfo create() {
            return new WebNodeInfo(this.webNodes, this.alertInfos, this.title, this.url, this.status);
        }
    }

    public List<WebNode> getWebNodes() {
        return this.webNodes;
    }

    public Status getStatus() {
        return this.status;
    }

    public List<AlertInfo> getAlertInfos() {
        return this.alertInfos;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public static class AlertInfo {
        public String linkText;
        public String linkUrl;
        public String message;
        public String title;

        public AlertInfo(String str, String str2, String str3, String str4) {
            this.title = str;
            this.message = str2;
            this.linkText = str3;
            this.linkUrl = str4;
        }
    }
}
