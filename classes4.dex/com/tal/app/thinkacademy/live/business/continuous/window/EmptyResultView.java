package com.tal.app.thinkacademy.live.business.continuous.window;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/continuous/window/EmptyResultView;", "Lcom/tal/app/thinkacademy/live/business/continuous/window/BaseWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createViewBinding", "", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "hide", "init", "show", "callback", "Lkotlin/Function0;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmptyResultView.kt */
public final class EmptyResultView extends BaseWindow {
    public void createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
    }

    public void hide() {
    }

    public void init() {
    }

    public void show(Function0<Unit> function0) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyResultView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
