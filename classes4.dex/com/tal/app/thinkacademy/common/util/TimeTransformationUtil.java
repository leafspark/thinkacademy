package com.tal.app.thinkacademy.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/TimeTransformationUtil;", "", "()V", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeTransformationUtil.kt */
public final class TimeTransformationUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/TimeTransformationUtil$Companion;", "", "()V", "dateToStamp", "", "timeZoneS", "", "dataS", "getDateString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TimeTransformationUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String getDateString$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "GMT+08";
            }
            return companion.getDateString(str);
        }

        public final String getDateString(String str) {
            Intrinsics.checkNotNullParameter(str, "timeZoneS");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str));
            String format = simpleDateFormat.format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy-M…         }.format(Date())");
            return format;
        }

        public static /* synthetic */ long dateToStamp$default(Companion companion, String str, String str2, int i, Object obj) throws ParseException {
            if ((i & 2) != 0) {
                str2 = "GMT+08";
            }
            return companion.dateToStamp(str, str2);
        }

        public final long dateToStamp(String str, String str2) throws ParseException {
            Intrinsics.checkNotNullParameter(str, "dataS");
            Intrinsics.checkNotNullParameter(str2, "timeZoneS");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(str2));
            return simpleDateFormat.parse(str).getTime();
        }

        public static /* synthetic */ long dateToStamp$default(Companion companion, String str, int i, Object obj) throws ParseException {
            if ((i & 1) != 0) {
                str = "GMT+08";
            }
            return companion.dateToStamp(str);
        }

        public final long dateToStamp(String str) throws ParseException {
            Intrinsics.checkNotNullParameter(str, "timeZoneS");
            return dateToStamp(getDateString(str), str);
        }
    }
}
