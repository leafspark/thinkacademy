package com.tal.app.thinkacademy.live.core.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat;", "", "()V", "computeCourseArea", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaLayoutParams;", "rate", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "getStudentStreamRate", "", "isSmallPad", "", "isSmallPhone", "pptCenterLp", "onlyPad", "CourseRate", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveAreaCompat.kt */
public final class LiveAreaCompat {
    public static final LiveAreaCompat INSTANCE = new LiveAreaCompat();

    private LiveAreaCompat() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaCompat$CourseRate;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "RATE_4_3", "RATE_16_9", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveAreaCompat.kt */
    public enum CourseRate {
        RATE_4_3(1),
        RATE_16_9(2);
        
        private final int value;

        private CourseRate(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @JvmStatic
    public static final boolean isSmallPad() {
        return LiveAreaContext.get().getCurrentType() == LiveAreaType.LIVE_SMALL_PAD;
    }

    @JvmStatic
    public static final boolean isSmallPhone() {
        return LiveAreaContext.get().getCurrentType() == LiveAreaType.LIVE_SMALL_PHONE;
    }

    @JvmStatic
    public static final LiveAreaLayoutParams pptCenterLp() {
        return pptCenterLp(CourseRate.RATE_4_3);
    }

    @JvmStatic
    public static final LiveAreaLayoutParams pptCenterLp(CourseRate courseRate) {
        Intrinsics.checkNotNullParameter(courseRate, "rate");
        return pptCenterLp(courseRate, true);
    }

    @JvmStatic
    public static final LiveAreaLayoutParams pptCenterLp(CourseRate courseRate, boolean z) {
        Intrinsics.checkNotNullParameter(courseRate, "rate");
        if (!z) {
            LiveAreaCompat liveAreaCompat = INSTANCE;
            if (isSmallPhone()) {
                return liveAreaCompat.computeCourseArea(courseRate);
            }
        }
        LiveAreaCompat liveAreaCompat2 = INSTANCE;
        if (isSmallPad()) {
            return liveAreaCompat2.computeCourseArea(courseRate);
        }
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        Intrinsics.checkNotNullExpressionValue(pptLp, "{\n            LiveAreaCo…ext.get().pptLp\n        }");
        return pptLp;
    }

    private final LiveAreaLayoutParams computeCourseArea(CourseRate courseRate) {
        LiveAreaLayoutParams pptLp = LiveAreaContext.get().getPptLp();
        float f = courseRate == CourseRate.RATE_16_9 ? 1.7777778f : 1.3333334f;
        LiveAreaLayoutParams liveAreaLayoutParams = new LiveAreaLayoutParams();
        if ((((float) pptLp.width) * 1.0f) / ((float) pptLp.height) > f) {
            int i = (int) (((float) pptLp.height) * f);
            liveAreaLayoutParams.left = pptLp.left + ((pptLp.width - i) / 2);
            liveAreaLayoutParams.top = pptLp.top;
            liveAreaLayoutParams.width = i;
            liveAreaLayoutParams.height = pptLp.height;
            liveAreaLayoutParams.right = liveAreaLayoutParams.left;
            liveAreaLayoutParams.bottom = 0;
        } else {
            int i2 = (int) (((float) pptLp.width) / f);
            liveAreaLayoutParams.top = pptLp.top + ((pptLp.height - i2) / 2);
            liveAreaLayoutParams.left = pptLp.left;
            liveAreaLayoutParams.width = pptLp.width;
            liveAreaLayoutParams.height = i2;
            liveAreaLayoutParams.right = liveAreaLayoutParams.left;
            liveAreaLayoutParams.bottom = (pptLp.height - i2) / 2;
        }
        return liveAreaLayoutParams;
    }

    @JvmStatic
    public static final float getStudentStreamRate() {
        LiveAreaLayoutParams screenLp = LiveAreaContext.get().getScreenLp();
        double d = (double) ((((float) screenLp.width) * 1.0f) / ((float) screenLp.height));
        if (d <= 1.4d) {
            return 1.0f;
        }
        return d <= 1.6d ? 1.1f : 1.2f;
    }
}
