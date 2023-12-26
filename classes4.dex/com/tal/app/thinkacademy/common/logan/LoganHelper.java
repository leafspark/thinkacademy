package com.tal.app.thinkacademy.common.logan;

import android.content.Context;
import com.dianping.logan.Logan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/logan/LoganHelper;", "", "()V", "newFileWithUpload", "", "context", "Landroid/content/Context;", "extra", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoganHelper.kt */
public final class LoganHelper {
    public static final LoganHelper INSTANCE = new LoganHelper();

    @JvmStatic
    public static final void newFileWithUpload(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        newFileWithUpload$default(context, (String) null, 2, (Object) null);
    }

    private LoganHelper() {
    }

    public static /* synthetic */ void newFileWithUpload$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        newFileWithUpload(context, str);
    }

    @JvmStatic
    public static final void newFileWithUpload(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logan.o(str);
        Map allFilesInfo = Logan.getAllFilesInfo();
        if (allFilesInfo != null && !allFilesInfo.isEmpty()) {
            Object[] array = allFilesInfo.keySet().toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            Logan.s((String[]) array, new RealSendLogRunnable(applicationContext));
        }
    }
}
