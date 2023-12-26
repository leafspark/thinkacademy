package com.tal.app.thinkacademy.common.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0005\"\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a#\u0010\u0007\u001a\u00020\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0005\"\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006\u001a\u0010\u0010\b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a#\u0010\b\u001a\u00020\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0005\"\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006¨\u0006\t"}, d2 = {"goneView", "", "view", "Landroid/view/View;", "views", "", "([Landroid/view/View;)V", "hideView", "showView", "common_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewUtil.kt */
public final class ViewUtilKt {
    public static final void showView(View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public static final void showView(View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            i++;
            showView(view);
        }
    }

    public static final void goneView(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static final void goneView(View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            i++;
            goneView(view);
        }
    }

    public static final void hideView(View view) {
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
    }

    public static final void hideView(View... viewArr) {
        Intrinsics.checkNotNullParameter(viewArr, "views");
        int length = viewArr.length;
        int i = 0;
        while (i < length) {
            View view = viewArr[i];
            i++;
            hideView(view);
        }
    }
}
