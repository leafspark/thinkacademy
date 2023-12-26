package com.amazonaws.mobile.client;

import android.app.Activity;

public class SignInUIOptions {
    private final Builder builder;

    SignInUIOptions(Builder builder2) {
        this.builder = builder2;
    }

    public String getBrowserPackage() {
        return this.builder.browserPackage;
    }

    public Integer getLogo() {
        return this.builder.logo;
    }

    public Integer getBackgroundColor() {
        return this.builder.backgroundColor;
    }

    public boolean canCancel() {
        return this.builder.canCancel;
    }

    public Class<? extends Activity> nextActivity() {
        return this.builder.nextActivityClass;
    }

    public HostedUIOptions getHostedUIOptions() {
        return this.builder.hostedUIOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Integer backgroundColor;
        /* access modifiers changed from: private */
        public String browserPackage;
        /* access modifiers changed from: private */
        public boolean canCancel;
        /* access modifiers changed from: private */
        public HostedUIOptions hostedUIOptions;
        /* access modifiers changed from: private */
        public Integer logo;
        /* access modifiers changed from: private */
        public Class<? extends Activity> nextActivityClass;

        public Builder logo(Integer num) {
            this.logo = num;
            return this;
        }

        public Builder browserPackage(String str) {
            this.browserPackage = str;
            return this;
        }

        public Builder backgroundColor(Integer num) {
            this.backgroundColor = num;
            return this;
        }

        public Builder canCancel(boolean z) {
            this.canCancel = z;
            return this;
        }

        public Builder nextActivity(Class<? extends Activity> cls) {
            this.nextActivityClass = cls;
            return this;
        }

        public Builder hostedUIOptions(HostedUIOptions hostedUIOptions2) {
            this.hostedUIOptions = hostedUIOptions2;
            return this;
        }

        public SignInUIOptions build() {
            return new SignInUIOptions(this);
        }
    }
}
