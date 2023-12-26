package com.tal.app.thinkacademy.lib.utils;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/TableUtils;", "", "()V", "mIsTable", "", "isTable", "setupTable", "", "context", "Landroid/content/Context;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TableUtils.kt */
public final class TableUtils {
    public static final TableUtils INSTANCE = new TableUtils();
    private static boolean mIsTable;

    private TableUtils() {
    }

    @JvmStatic
    public static final void setupTable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        mIsTable = (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    @JvmStatic
    public static final boolean isTable() {
        return mIsTable;
    }
}
