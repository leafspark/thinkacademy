package com.tal.app.thinkacademy.common.logan;

import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/logan/LoganFileParser;", "", "()V", "sDataFormat", "Ljava/text/SimpleDateFormat;", "generateExtra", "", "planId", "planMode", "lessonType", "parse", "Lcom/tal/app/thinkacademy/common/logan/FileParams;", "file", "Ljava/io/File;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoganFileParser.kt */
public final class LoganFileParser {
    public static final LoganFileParser INSTANCE = new LoganFileParser();
    private static final SimpleDateFormat sDataFormat = new SimpleDateFormat("yyyy_MM_dd");

    private LoganFileParser() {
    }

    public final FileParams parse(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "file.name");
        List split$default = StringsKt.split$default(StringsKt.replace$default(name, ".copy", "", false, 4, (Object) null), new String[]{"_"}, false, 0, 6, (Object) null);
        if (split$default.size() > 3) {
            long parseLong = Long.parseLong((String) split$default.get(0));
            FileParams fileParams = new FileParams(sDataFormat.format(new Date(parseLong)) + '_' + ((String) split$default.get(1)), Long.parseLong((String) split$default.get(2)), file.lastModified(), (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
            List split$default2 = StringsKt.split$default((CharSequence) split$default.get(3), new String[]{"-"}, false, 0, 6, (Object) null);
            if (split$default2.size() > 2) {
                Object obj = split$default2.get(0);
                String str = null;
                if (!(!Intrinsics.areEqual((String) obj, EnterRoomMuteData.STATUS_UN_MUTE))) {
                    obj = null;
                }
                String str2 = (String) obj;
                if (str2 != null) {
                    fileParams.setPlanId(str2);
                }
                Object obj2 = split$default2.get(1);
                if (!(!Intrinsics.areEqual((String) obj2, EnterRoomMuteData.STATUS_UN_MUTE))) {
                    obj2 = null;
                }
                String str3 = (String) obj2;
                if (str3 != null) {
                    fileParams.setPlanMode(str3);
                }
                Object obj3 = split$default2.get(2);
                if (!Intrinsics.areEqual((String) obj3, EnterRoomMuteData.STATUS_UN_MUTE)) {
                    str = obj3;
                }
                String str4 = str;
                if (str4 != null) {
                    fileParams.setLessonType(str4);
                }
            }
            return fileParams;
        } else if (split$default.size() > 1) {
            long parseLong2 = Long.parseLong((String) split$default.get(0));
            String str5 = (String) split$default.get(1);
            return new FileParams(sDataFormat.format(new Date(parseLong2)) + '_' + str5, split$default.size() > 2 ? Long.parseLong((String) split$default.get(2)) : parseLong2, file.lastModified(), (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
        } else {
            long parseLong3 = Long.parseLong((String) split$default.get(0));
            String format = sDataFormat.format(new Date(parseLong3));
            Intrinsics.checkNotNullExpressionValue(format, "sDataFormat.format(Date(dayTime))");
            return new FileParams(format, parseLong3, file.lastModified(), (String) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Integer] */
    /* JADX WARNING: Multi-variable type inference failed */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String generateExtra(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            r3 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            if (r1 == 0) goto L_0x0019
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = r3
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            if (r1 == 0) goto L_0x001d
            r5 = r4
        L_0x001d:
            r0.append(r5)
            r5 = 45
            r0.append(r5)
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0033
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r1 = r3
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            if (r1 == 0) goto L_0x0037
            r6 = r4
        L_0x0037:
            r0.append(r6)
            r0.append(r5)
            r5 = r7
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x004a
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r2 = r3
        L_0x004a:
            if (r2 == 0) goto L_0x004d
            r7 = r4
        L_0x004d:
            r0.append(r7)
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.logan.LoganFileParser.generateExtra(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
