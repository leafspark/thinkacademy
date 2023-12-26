package com.tal.app.thinkacademy.lib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayDeque;
import java.util.Deque;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J-\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesViewUtil;", "", "()V", "findActivity", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "findTypeView", "T", "group", "Landroid/view/ViewGroup;", "cls", "Ljava/lang/Class;", "(Landroid/view/ViewGroup;Ljava/lang/Class;)Ljava/lang/Object;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesViewUtil.kt */
public final class XesViewUtil {
    public static final XesViewUtil INSTANCE = new XesViewUtil();

    private XesViewUtil() {
    }

    @JvmStatic
    public static final <T> T findTypeView(ViewGroup viewGroup, Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        if (viewGroup == null) {
            return null;
        }
        Deque arrayDeque = new ArrayDeque();
        arrayDeque.add(viewGroup);
        while (!arrayDeque.isEmpty()) {
            View view = (View) arrayDeque.removeFirst();
            if (cls.isInstance(view)) {
                return cls.cast(view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                int childCount = viewGroup2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    arrayDeque.add(viewGroup2.getChildAt(i));
                }
            }
        }
        return null;
    }

    private final Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "context.baseContext");
        return findActivity(baseContext);
    }
}
