package com.idlefish.flutterboost;

import java.util.Map;

public class FlutterBoostRouteOptions {
    private final Map<String, Object> arguments;
    private final boolean opaque;
    private final String pageName;
    private final int requestCode;
    private final String uniqueId;

    private FlutterBoostRouteOptions(Builder builder) {
        this.pageName = builder.pageName;
        this.arguments = builder.arguments;
        this.requestCode = builder.requestCode;
        this.uniqueId = builder.uniqueId;
        this.opaque = builder.opaque;
    }

    public String pageName() {
        return this.pageName;
    }

    public Map<String, Object> arguments() {
        return this.arguments;
    }

    public int requestCode() {
        return this.requestCode;
    }

    public String uniqueId() {
        return this.uniqueId;
    }

    public boolean opaque() {
        return this.opaque;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Map<String, Object> arguments;
        /* access modifiers changed from: private */
        public boolean opaque = true;
        /* access modifiers changed from: private */
        public String pageName;
        /* access modifiers changed from: private */
        public int requestCode;
        /* access modifiers changed from: private */
        public String uniqueId;

        public Builder pageName(String str) {
            this.pageName = str;
            return this;
        }

        public Builder arguments(Map<String, Object> map) {
            this.arguments = map;
            return this;
        }

        public Builder requestCode(int i) {
            this.requestCode = i;
            return this;
        }

        public Builder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public Builder opaque(boolean z) {
            this.opaque = z;
            return this;
        }

        public FlutterBoostRouteOptions build() {
            return new FlutterBoostRouteOptions(this);
        }
    }
}
