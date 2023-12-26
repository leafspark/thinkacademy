package com.idlefish.flutterboost;

import io.flutter.embedding.android.FlutterEngineProvider;

public class FlutterBoostSetupOptions {
    private final String dartEntrypoint;
    private FlutterEngineProvider flutterEngineProvider;
    private final String initialRoute;
    private final String[] shellArgs;
    private final boolean shouldOverrideBackForegroundEvent;

    private FlutterBoostSetupOptions(Builder builder) {
        this.initialRoute = builder.initialRoute;
        this.dartEntrypoint = builder.dartEntrypoint;
        this.shellArgs = builder.shellArgs;
        this.shouldOverrideBackForegroundEvent = builder.shouldOverrideBackForegroundEvent;
        this.flutterEngineProvider = builder.flutterEngineProvider;
    }

    public static FlutterBoostSetupOptions createDefault() {
        return new Builder().build();
    }

    public String initialRoute() {
        return this.initialRoute;
    }

    public String dartEntrypoint() {
        return this.dartEntrypoint;
    }

    public String[] shellArgs() {
        return this.shellArgs;
    }

    public FlutterEngineProvider flutterEngineProvider() {
        return this.flutterEngineProvider;
    }

    public boolean shouldOverrideBackForegroundEvent() {
        return this.shouldOverrideBackForegroundEvent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        String[] strArr = this.shellArgs;
        if (strArr == null || strArr.length == 0) {
            sb.append(']');
        } else {
            int i = 0;
            while (true) {
                sb.append(String.valueOf(this.shellArgs[i]));
                if (i == this.shellArgs.length - 1) {
                    break;
                }
                sb.append(", ");
                i++;
            }
            sb.append(']');
        }
        return "initialRoute:" + this.initialRoute + ", dartEntrypoint:" + this.dartEntrypoint + ", shouldOverrideBackForegroundEvent:" + this.shouldOverrideBackForegroundEvent + ", shellArgs:" + sb.toString();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String dartEntrypoint = "main";
        /* access modifiers changed from: private */
        public FlutterEngineProvider flutterEngineProvider;
        /* access modifiers changed from: private */
        public String initialRoute = "/";
        /* access modifiers changed from: private */
        public String[] shellArgs;
        /* access modifiers changed from: private */
        public boolean shouldOverrideBackForegroundEvent = false;

        public Builder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public Builder dartEntrypoint(String str) {
            this.dartEntrypoint = str;
            return this;
        }

        public Builder shellArgs(String[] strArr) {
            this.shellArgs = strArr;
            return this;
        }

        public Builder flutterEngineProvider(FlutterEngineProvider flutterEngineProvider2) {
            this.flutterEngineProvider = flutterEngineProvider2;
            return this;
        }

        public Builder shouldOverrideBackForegroundEvent(boolean z) {
            this.shouldOverrideBackForegroundEvent = z;
            return this;
        }

        public FlutterBoostSetupOptions build() {
            return new FlutterBoostSetupOptions(this);
        }
    }
}
