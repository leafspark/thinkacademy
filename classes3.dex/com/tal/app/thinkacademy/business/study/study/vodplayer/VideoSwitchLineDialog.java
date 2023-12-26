package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.databinding.VideoSwitchLineDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSwitchLineDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VideoSwitchLineDialogLayoutBinding;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "index", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/SwitchLineAdapter;", "mCurrentIndex", "mListen", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "selectIndex", "mutableList", "", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSwitchLineDialog.kt */
public final class VideoSwitchLineDialog extends BaseBindDialog<VideoSwitchLineDialogLayoutBinding> {
    private SwitchLineAdapter mAdapter = new SwitchLineAdapter();
    private int mCurrentIndex;
    private Function1<? super Integer, Unit> mListen;

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m508_init_$lambda0(DialogInterface dialogInterface) {
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m509_init_$lambda1(DialogInterface dialogInterface) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSwitchLineDialog(Context context, Function1<? super Integer, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "listen");
        this.mListen = function1;
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        dimAmount(0.0f);
        this.binding.switchLineRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.binding.switchLineRecyclerView.setAdapter(this.mAdapter);
        setOnShowListener(VideoSwitchLineDialog$$ExternalSyntheticLambda1.INSTANCE);
        setOnDismissListener(VideoSwitchLineDialog$$ExternalSyntheticLambda0.INSTANCE);
        this.mAdapter.setOnItemClickListener(new VideoSwitchLineDialog$$ExternalSyntheticLambda3(this));
        this.binding.getRoot().setOnClickListener(new VideoSwitchLineDialog$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m510_init_$lambda2(VideoSwitchLineDialog videoSwitchLineDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(videoSwitchLineDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        videoSwitchLineDialog.mCurrentIndex = i;
        videoSwitchLineDialog.mAdapter.setMLineIndex(i);
        videoSwitchLineDialog.mAdapter.notifyDataSetChanged();
        videoSwitchLineDialog.dismiss();
        videoSwitchLineDialog.mListen.invoke(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m511_init_$lambda3(VideoSwitchLineDialog videoSwitchLineDialog, View view) {
        Intrinsics.checkNotNullParameter(videoSwitchLineDialog, "this$0");
        videoSwitchLineDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setData(int i, List<String> list) {
        Intrinsics.checkNotNullParameter(list, "mutableList");
        this.mCurrentIndex = i;
        if (i >= list.size()) {
            this.mCurrentIndex = 0;
        }
        this.mAdapter.setList(list);
        this.mAdapter.setMLineIndex(this.mCurrentIndex);
        this.mAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public VideoSwitchLineDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoSwitchLineDialogLayoutBinding inflate = VideoSwitchLineDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
