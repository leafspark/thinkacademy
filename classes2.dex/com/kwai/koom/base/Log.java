package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/kwai/koom/base/Log;", "", "d", "", "tag", "", "msg", "e", "i", "v", "w", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorLog.kt */
public interface Log {
    int d(String str, String str2);

    int e(String str, String str2);

    int i(String str, String str2);

    int v(String str, String str2);

    int w(String str, String str2);

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* compiled from: MonitorLog.kt */
    public static final class DefaultImpls {
        public static int v(Log log, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            if (MonitorBuildConfig.getDEBUG()) {
                return android.util.Log.v(str, str2);
            }
            return -1;
        }

        public static int i(Log log, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            if (MonitorBuildConfig.getDEBUG()) {
                return android.util.Log.i(str, str2);
            }
            return -1;
        }

        public static int d(Log log, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            if (MonitorBuildConfig.getDEBUG()) {
                return android.util.Log.d(str, str2);
            }
            return -1;
        }

        public static int w(Log log, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            if (MonitorBuildConfig.getDEBUG()) {
                return android.util.Log.w(str, str2);
            }
            return -1;
        }

        public static int e(Log log, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "msg");
            if (MonitorBuildConfig.getDEBUG()) {
                return android.util.Log.e(str, str2);
            }
            return -1;
        }
    }
}
