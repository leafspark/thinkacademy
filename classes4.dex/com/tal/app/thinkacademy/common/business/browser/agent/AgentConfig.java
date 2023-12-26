package com.tal.app.thinkacademy.common.business.browser.agent;

import java.io.Serializable;

public class AgentConfig implements Serializable {
    private boolean isLandscape;
    private String localTitle;
    private boolean showProgressBar;
    private boolean showTitle;

    public boolean isShowProgressBar() {
        return this.showProgressBar;
    }

    public boolean isShowTitle() {
        return this.showTitle;
    }

    public String getLocalTitle() {
        return this.localTitle;
    }

    public boolean isLandscape() {
        return this.isLandscape;
    }

    public AgentConfig(Builder builder) {
        this.showProgressBar = builder.showProgressBar;
        this.showTitle = builder.showTitle;
        this.localTitle = builder.localTitle;
        this.isLandscape = builder.isLandscape;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean isLandscape;
        /* access modifiers changed from: private */
        public String localTitle;
        /* access modifiers changed from: private */
        public boolean showProgressBar;
        /* access modifiers changed from: private */
        public boolean showTitle;

        public Builder setShowProgressBar(boolean z) {
            this.showProgressBar = z;
            return this;
        }

        public Builder setShowTitle(boolean z) {
            this.showTitle = z;
            return this;
        }

        public Builder setLocalTitle(String str) {
            this.localTitle = str;
            return this;
        }

        public Builder setLandscape(boolean z) {
            this.isLandscape = z;
            return this;
        }

        public AgentConfig build() {
            return new AgentConfig(this);
        }
    }
}
