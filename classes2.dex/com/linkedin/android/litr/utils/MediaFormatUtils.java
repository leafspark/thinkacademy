package com.linkedin.android.litr.utils;

import android.media.MediaFormat;
import android.os.Build;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/linkedin/android/litr/utils/MediaFormatUtils;", "", "()V", "Companion", "litr_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: MediaFormatUtils.kt */
public final class MediaFormatUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final Number getChannelCount(MediaFormat mediaFormat, Number number) {
        return Companion.getChannelCount(mediaFormat, number);
    }

    @JvmStatic
    public static final Number getFrameRate(MediaFormat mediaFormat, Number number) {
        return Companion.getFrameRate(mediaFormat, number);
    }

    @JvmStatic
    public static final Number getIFrameInterval(MediaFormat mediaFormat, Number number) {
        return Companion.getIFrameInterval(mediaFormat, number);
    }

    @JvmStatic
    public static final Number getNumber(MediaFormat mediaFormat, String str) {
        return Companion.getNumber(mediaFormat, str);
    }

    @JvmStatic
    public static final Number getSampleRate(MediaFormat mediaFormat, Number number) {
        return Companion.getSampleRate(mediaFormat, number);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\u000e"}, d2 = {"Lcom/linkedin/android/litr/utils/MediaFormatUtils$Companion;", "", "()V", "getChannelCount", "", "format", "Landroid/media/MediaFormat;", "defaultValue", "getFrameRate", "getIFrameInterval", "getNumber", "key", "", "getSampleRate", "litr_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MediaFormatUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Number getIFrameInterval(MediaFormat mediaFormat, Number number) {
            Intrinsics.checkNotNullParameter(mediaFormat, "format");
            Intrinsics.checkNotNullParameter(number, "defaultValue");
            Number number2 = getNumber(mediaFormat, "i-frame-interval");
            return number2 != null ? number2 : number;
        }

        @JvmStatic
        public final Number getFrameRate(MediaFormat mediaFormat, Number number) {
            Intrinsics.checkNotNullParameter(mediaFormat, "format");
            Intrinsics.checkNotNullParameter(number, "defaultValue");
            Number number2 = getNumber(mediaFormat, "frame-rate");
            return number2 != null ? number2 : number;
        }

        @JvmStatic
        public final Number getChannelCount(MediaFormat mediaFormat, Number number) {
            Intrinsics.checkNotNullParameter(mediaFormat, "format");
            Intrinsics.checkNotNullParameter(number, "defaultValue");
            Number number2 = getNumber(mediaFormat, "channel-count");
            return number2 != null ? number2 : number;
        }

        @JvmStatic
        public final Number getSampleRate(MediaFormat mediaFormat, Number number) {
            Intrinsics.checkNotNullParameter(mediaFormat, "format");
            Intrinsics.checkNotNullParameter(number, "defaultValue");
            Number number2 = getNumber(mediaFormat, "sample-rate");
            return number2 != null ? number2 : number;
        }

        @JvmStatic
        public final Number getNumber(MediaFormat mediaFormat, String str) {
            Object obj;
            Object obj2;
            Intrinsics.checkNotNullParameter(mediaFormat, "format");
            Intrinsics.checkNotNullParameter(str, "key");
            Number number = null;
            if (!mediaFormat.containsKey(str)) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return mediaFormat.getNumber(str);
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.constructor-impl(Integer.valueOf(mediaFormat.getInteger(str)));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(Float.valueOf(mediaFormat.getFloat(str)));
                } catch (Throwable th2) {
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                obj = obj2;
            }
            if (!Result.isFailure-impl(obj)) {
                number = obj;
            }
            return number;
        }
    }
}
