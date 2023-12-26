package com.tal.app.thinkacademy.lib.logger;

import android.text.TextUtils;

public abstract class XesLogConfig {
    static int MAX_LEN = 1024;
    public static XesStackTraceFormatter XES_STACK_TRACE_FORMATTER = new XesStackTraceFormatter();
    public static XesThreadFormatter XES_THREAD_FORMATTER = new XesThreadFormatter();
    private boolean enableLog2File = false;
    private String globalTag = "XesLog";
    private String logpatch;
    private long retentionTime;

    public interface JsonParser {
        String toJson(Object obj);
    }

    public boolean enable() {
        return true;
    }

    public boolean includeThread() {
        return true;
    }

    public JsonParser injectJsonParser() {
        return null;
    }

    public XesLogPrinter[] printers() {
        return null;
    }

    public int stackTraceDepth() {
        return 5;
    }

    public String getGlobalTag() {
        return this.globalTag;
    }

    public void setGlobalTag(String str) {
        this.globalTag = str;
    }

    public void setEnableLog2File(boolean z) {
        this.enableLog2File = z;
    }

    public boolean enableLog2File() {
        return this.enableLog2File;
    }

    public void setLogpatch(String str) {
        this.logpatch = str;
    }

    public String getLogpatch() {
        return this.logpatch;
    }

    public long getRetentionTime() {
        return this.retentionTime;
    }

    public void setRetentionTime(long j) {
        this.retentionTime = j;
    }

    public static class Build {
        /* access modifiers changed from: private */
        public boolean enable;
        private boolean enableLog2File;
        private String globalTag;
        /* access modifiers changed from: private */
        public boolean includeThread;
        /* access modifiers changed from: private */
        public JsonParser jsonParser;
        private String logpatch;
        private long retentionTime;

        public static Build newBuild() {
            return new Build();
        }

        public Build enable(boolean z) {
            this.enable = z;
            return this;
        }

        public Build injectJsonParse(JsonParser jsonParser2) {
            this.jsonParser = jsonParser2;
            return this;
        }

        public Build enableLog2File(boolean z) {
            this.enableLog2File = z;
            return this;
        }

        public Build logpatch(String str) {
            this.logpatch = str;
            return this;
        }

        public Build globalTag(String str) {
            this.globalTag = str;
            return this;
        }

        public Build includeThread(boolean z) {
            this.includeThread = z;
            return this;
        }

        public XesLogConfig build() {
            AnonymousClass1 r0 = new XesLogConfig() {
                public JsonParser injectJsonParser() {
                    return Build.this.jsonParser;
                }

                public boolean enable() {
                    return Build.this.enable;
                }

                public boolean includeThread() {
                    return Build.this.includeThread;
                }
            };
            r0.setEnableLog2File(this.enableLog2File);
            r0.setRetentionTime(this.retentionTime);
            r0.setLogpatch(this.logpatch);
            if (!TextUtils.isEmpty(this.globalTag)) {
                r0.setGlobalTag(this.globalTag);
            }
            return r0;
        }

        public Build retentionTime(int i) {
            this.retentionTime = (long) i;
            return this;
        }
    }
}
