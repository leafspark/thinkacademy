package com.tal.app.thinkacademy.common.track;

import android.os.Build;
import android.text.TextUtils;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002Jp\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eJ*\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004J\u0006\u0010#\u001a\u00020\u0017J\u0013\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040%¢\u0006\u0002\u0010&¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/common/track/CommonTrack;", "", "()V", "getFileSize", "", "fileSize", "", "hwReportMemInfo", "", "java_heap_max", "", "java_Heap_rate", "", "proc_self_staus_VmSize", "proc_self_staus_VmRss", "threadCount", "proc_meminfo_MemTotal", "proc_meminfo_memFree", "proc_meminfo_memAvailable", "proc_meminfo_memAvailableRation", "proc_meminfo_cmaTotal", "fdCount", "isHitOomRule", "", "hitOomRuleReason", "hw_armabi_so_collect", "hw_flutter_engine_init", "costTime", "hw_school_info_get_error_track", "errorType", "Lcom/tal/app/thinkacademy/common/track/CommonTrack$SchoolInfoErrorType;", "hw_video_compress_state", "isSuccess", "millsTime", "errorMsg", "isArm64V8A", "supportedAbis", "", "()[Ljava/lang/String;", "SchoolInfoErrorType", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonTrack.kt */
public final class CommonTrack {
    public static final CommonTrack INSTANCE = new CommonTrack();

    private CommonTrack() {
    }

    public static /* synthetic */ void hw_video_compress_state$default(CommonTrack commonTrack, boolean z, long j, long j2, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = null;
        }
        commonTrack.hw_video_compress_state(z, j, j2, str);
    }

    public final void hw_video_compress_state(boolean z, long j, long j2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("compress_success", z);
            jSONObject.put("compress_cost_time", Float.valueOf((((float) j) * 1.0f) / ((float) 1000)));
            jSONObject.put("compress_origin_file_size", getFileSize(j2));
            jSONObject.put("compress_error_msg", str);
            HwTrackUtil.INSTANCE.track("hw_video_compress_state", jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void hw_flutter_engine_init(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("engine_init_cost_time", j);
            HwTrackUtil.INSTANCE.track("hw_flutter_engine_init", jSONObject);
        } catch (Exception unused) {
        }
    }

    public final boolean isArm64V8A() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                if (Intrinsics.areEqual(str, "arm64-v8a")) {
                    return true;
                }
            }
            return false;
        }
        String str2 = Build.CPU_ABI;
        Intrinsics.checkNotNullExpressionValue(str2, "CPU_ABI");
        return Intrinsics.areEqual(str2, "arm64-v8a");
    }

    public final String[] supportedAbis() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr, "SUPPORTED_ABIS");
            if (!(((Object[]) strArr).length == 0)) {
                String[] strArr2 = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(strArr2, "{\n            Build.SUPPORTED_ABIS\n        }");
                return strArr2;
            }
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }

    public final void hw_armabi_so_collect() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hw_isArm64V8A", isArm64V8A());
            String arrays = Arrays.toString(supportedAbis());
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            jSONObject.put("hw_supportedAbis", arrays);
            HwTrackUtil.INSTANCE.track("hw_armabi_so_collect", jSONObject);
        } catch (Exception unused) {
        }
    }

    private final String getFileSize(long j) {
        if (j <= 0) {
            return "0 B";
        }
        if (j >= 1048576) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            long j2 = (long) 1024;
            String format = String.format("%.2f MB", Arrays.copyOf(new Object[]{Long.valueOf((j / j2) / j2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } else if (j >= 1024) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1f KB", Arrays.copyOf(new Object[]{Long.valueOf(j / ((long) 1024))}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%d B", Arrays.copyOf(new Object[]{Long.valueOf(j)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/track/CommonTrack$SchoolInfoErrorType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "SchoolInfoError", "SchoolInfoNotFound", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CommonTrack.kt */
    public enum SchoolInfoErrorType {
        SchoolInfoError("分校信息错误:schoolcode或者h5为空"),
        SchoolInfoNotFound("本地存储的分校已下线:在分校信息列表中无法找到");
        
        private final String type;

        private SchoolInfoErrorType(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }
    }

    public final void hw_school_info_get_error_track(SchoolInfoErrorType schoolInfoErrorType) {
        Intrinsics.checkNotNullParameter(schoolInfoErrorType, "errorType");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("school_info_error_type", schoolInfoErrorType.getType());
            HwTrackUtil.INSTANCE.track("hw_school_info_get_error_track", jSONObject);
        } catch (Exception unused) {
        }
    }

    public final void hwReportMemInfo(float f, int i, float f2, float f3, int i2, float f4, float f5, float f6, int i3, float f7, int i4, boolean z, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("hwmem_java_heap_max", Float.valueOf(f));
            jSONObject.put("hwmem_java_Heap_rate", i);
            jSONObject.put("hwmem_proc_self_staus_vmsize", Float.valueOf(f2));
            jSONObject.put("hwmem_proc_self_staus_vmrss", Float.valueOf(f3));
            jSONObject.put("hwmem_thread_count", i2);
            jSONObject.put("hwmem_proc_meminfo_mem_total", Float.valueOf(f4));
            jSONObject.put("hwmem_proc_meminfo_mem_free", Float.valueOf(f5));
            jSONObject.put("hwmem_proc_meminfo_mem_available", Float.valueOf(f6));
            jSONObject.put("hwmem_proc_meminfo_mem_available_rate", i3);
            jSONObject.put("hwmem_proc_meminfo_cma_total", Float.valueOf(f7));
            jSONObject.put("hwmem_fd_count", i4);
            jSONObject.put("hwmem_is_hit_oom_rule", z);
            jSONObject.put("hwmem_hit_oom_rule_reason", str);
            HwTrackUtil.INSTANCE.track("hw_performance_monitor_base_data_event_android", jSONObject);
        } catch (Exception unused) {
        }
    }
}
