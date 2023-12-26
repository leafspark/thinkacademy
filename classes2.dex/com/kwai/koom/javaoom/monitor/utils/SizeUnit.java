package com.kwai.koom.javaoom.monitor.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H&\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit;", "", "()V", "toByte", "", "value", "", "", "toKB", "toMB", "BYTE", "KB", "MB", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$BYTE;", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$KB;", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$MB;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SizeUnit.kt */
public abstract class SizeUnit {
    public /* synthetic */ SizeUnit(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float toByte(int i);

    public abstract float toByte(long j);

    public abstract float toKB(int i);

    public abstract float toKB(long j);

    public abstract float toMB(int i);

    public abstract float toMB(long j);

    private SizeUnit() {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$BYTE;", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit;", "()V", "toByte", "", "value", "", "", "toKB", "toMB", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SizeUnit.kt */
    public static final class BYTE extends SizeUnit {
        public static final BYTE INSTANCE = new BYTE();

        public float toByte(int i) {
            return (float) i;
        }

        public float toByte(long j) {
            return (float) j;
        }

        public float toKB(int i) {
            return ((float) i) / 1024.0f;
        }

        public float toKB(long j) {
            return ((float) j) / 1024.0f;
        }

        public float toMB(int i) {
            return (((float) i) / 1024.0f) / 1024.0f;
        }

        public float toMB(long j) {
            return (((float) j) / 1024.0f) / 1024.0f;
        }

        private BYTE() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$KB;", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit;", "()V", "toByte", "", "value", "", "", "toKB", "toMB", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SizeUnit.kt */
    public static final class KB extends SizeUnit {
        public static final KB INSTANCE = new KB();

        public float toByte(int i) {
            return ((float) i) * 1024.0f;
        }

        public float toByte(long j) {
            return ((float) j) * 1024.0f;
        }

        public float toKB(int i) {
            return (float) i;
        }

        public float toKB(long j) {
            return (float) j;
        }

        public float toMB(int i) {
            return ((float) i) / 1024.0f;
        }

        public float toMB(long j) {
            return ((float) j) / 1024.0f;
        }

        private KB() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit$MB;", "Lcom/kwai/koom/javaoom/monitor/utils/SizeUnit;", "()V", "toByte", "", "value", "", "", "toKB", "toMB", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SizeUnit.kt */
    public static final class MB extends SizeUnit {
        public static final MB INSTANCE = new MB();

        public float toByte(int i) {
            return ((float) i) * 1024.0f * 1024.0f;
        }

        public float toByte(long j) {
            return ((float) j) * 1024.0f * 1024.0f;
        }

        public float toKB(int i) {
            return ((float) i) * 1024.0f;
        }

        public float toKB(long j) {
            return ((float) j) * 1024.0f;
        }

        public float toMB(int i) {
            return (float) i;
        }

        public float toMB(long j) {
            return (float) j;
        }

        private MB() {
            super((DefaultConstructorMarker) null);
        }
    }
}
