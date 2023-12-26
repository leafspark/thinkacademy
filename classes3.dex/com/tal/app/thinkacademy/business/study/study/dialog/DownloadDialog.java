package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogDownloadBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0014J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/DownloadDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/StudyDialogDownloadBinding;", "cxt", "Landroid/content/Context;", "listener", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "sDownloading", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "updateProgress", "progress", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadDialog.kt */
public final class DownloadDialog extends BaseBindDialog<StudyDialogDownloadBinding> {
    private final Function0<Unit> listener;
    private final String sDownloading;

    public final void updateProgress(int i) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DownloadDialog(Context context, Function0<Unit> function0) {
        super(context);
        String str;
        Intrinsics.checkNotNullParameter(function0, "listener");
        this.listener = function0;
        if (context == null) {
            str = null;
        } else {
            str = context.getString(R.string.downloading);
        }
        this.sDownloading = str;
        dimAmount(0.0f);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    /* access modifiers changed from: protected */
    public StudyDialogDownloadBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        StudyDialogDownloadBinding inflate = StudyDialogDownloadBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        Function0<Unit> function0 = this.listener;
        if (function0 != null) {
            function0.invoke();
        }
        return DownloadDialog.super.onKeyDown(i, keyEvent);
    }
}
