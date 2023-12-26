package com.tal.thinkacademy.networkprobe;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/NetProbeConfig;", "", "()V", "builder", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "(Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;)V", "mConnectTimeoutMillis", "", "mDebug", "", "mErrorTimeMillis", "mRepeatCount", "", "connectTimeout", "debug", "errorTimeMillis", "newBuilder", "repeatCount", "Builder", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbeConfig.kt */
public final class NetProbeConfig {
    private final long mConnectTimeoutMillis;
    private final boolean mDebug;
    private final long mErrorTimeMillis;
    private final int mRepeatCount;

    public NetProbeConfig(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.mDebug = builder.getMDebug$networkprobe_release();
        this.mConnectTimeoutMillis = builder.getMConnectTimeoutMillis$networkprobe_release();
        this.mErrorTimeMillis = builder.getMErrorTimeMillis$networkprobe_release();
        this.mRepeatCount = builder.getMRepeatCount$networkprobe_release();
    }

    public NetProbeConfig() {
        this(new Builder());
    }

    public final boolean debug() {
        return this.mDebug;
    }

    public final long connectTimeout() {
        return this.mConnectTimeoutMillis;
    }

    public final long errorTimeMillis() {
        return this.mErrorTimeMillis;
    }

    public final int repeatCount() {
        return this.mRepeatCount;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u0003J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rJ\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "", "config", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig;", "(Lcom/tal/thinkacademy/networkprobe/NetProbeConfig;)V", "()V", "mConnectTimeoutMillis", "", "getMConnectTimeoutMillis$networkprobe_release", "()J", "setMConnectTimeoutMillis$networkprobe_release", "(J)V", "mDebug", "", "getMDebug$networkprobe_release", "()Z", "setMDebug$networkprobe_release", "(Z)V", "mErrorTimeMillis", "getMErrorTimeMillis$networkprobe_release", "setMErrorTimeMillis$networkprobe_release", "mRepeatCount", "", "getMRepeatCount$networkprobe_release", "()I", "setMRepeatCount$networkprobe_release", "(I)V", "build", "setConnectTimeout", "millis", "setDebug", "debug", "setErrorTimeMillis", "setRepeatCount", "count", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetProbeConfig.kt */
    public static final class Builder {
        private long mConnectTimeoutMillis;
        private boolean mDebug;
        private long mErrorTimeMillis;
        private int mRepeatCount;

        public Builder() {
            this.mConnectTimeoutMillis = 10000;
            this.mErrorTimeMillis = 10000;
            this.mRepeatCount = 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(NetProbeConfig netProbeConfig) {
            this();
            Intrinsics.checkNotNullParameter(netProbeConfig, "config");
            this.mDebug = netProbeConfig.debug();
            this.mConnectTimeoutMillis = netProbeConfig.connectTimeout();
            this.mErrorTimeMillis = netProbeConfig.errorTimeMillis();
            this.mRepeatCount = netProbeConfig.repeatCount();
        }

        public final boolean getMDebug$networkprobe_release() {
            return this.mDebug;
        }

        public final void setMDebug$networkprobe_release(boolean z) {
            this.mDebug = z;
        }

        public final long getMConnectTimeoutMillis$networkprobe_release() {
            return this.mConnectTimeoutMillis;
        }

        public final void setMConnectTimeoutMillis$networkprobe_release(long j) {
            this.mConnectTimeoutMillis = j;
        }

        public final long getMErrorTimeMillis$networkprobe_release() {
            return this.mErrorTimeMillis;
        }

        public final void setMErrorTimeMillis$networkprobe_release(long j) {
            this.mErrorTimeMillis = j;
        }

        public final int getMRepeatCount$networkprobe_release() {
            return this.mRepeatCount;
        }

        public final void setMRepeatCount$networkprobe_release(int i) {
            this.mRepeatCount = i;
        }

        public final Builder setDebug(boolean z) {
            Builder builder = this;
            builder.setMDebug$networkprobe_release(z);
            return builder;
        }

        public final Builder setConnectTimeout(long j) {
            Builder builder = this;
            builder.setMConnectTimeoutMillis$networkprobe_release(j);
            return builder;
        }

        public final Builder setErrorTimeMillis(long j) {
            Builder builder = this;
            builder.setMErrorTimeMillis$networkprobe_release(j);
            return builder;
        }

        public final Builder setRepeatCount(int i) {
            Builder builder = this;
            builder.setMRepeatCount$networkprobe_release(i);
            return builder;
        }

        public final NetProbeConfig build() {
            return new NetProbeConfig(this);
        }
    }
}
