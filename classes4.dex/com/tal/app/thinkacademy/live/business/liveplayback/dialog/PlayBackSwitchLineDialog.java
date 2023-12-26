package com.tal.app.thinkacademy.live.business.liveplayback.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.entity.AddressBean;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.databinding.PlayBackSwitchLineDialogBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001e\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\tR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/liveplayback/dialog/PlayBackSwitchLineDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/live/business/databinding/PlayBackSwitchLineDialogBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAdapter", "Lcom/tal/app/thinkacademy/live/business/liveplayback/dialog/PlaybackSwitchLineAdapter;", "mOnSwitchListen", "Lcom/tal/app/thinkacademy/live/business/liveplayback/dialog/PlayBackSwitchLineDialog$OnSwitchListen;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "setData", "", "urls", "", "Lcom/tal/app/thinkacademy/common/entity/AddressBean;", "index", "", "setOnSwitchListen", "listen", "OnSwitchListen", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackSwitchLineDialog.kt */
public final class PlayBackSwitchLineDialog extends BaseBindDialog<PlayBackSwitchLineDialogBinding> {
    private final PlaybackSwitchLineAdapter mAdapter;
    private OnSwitchListen mOnSwitchListen;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/liveplayback/dialog/PlayBackSwitchLineDialog$OnSwitchListen;", "", "onSwitch", "", "index", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlayBackSwitchLineDialog.kt */
    public interface OnSwitchListen {
        void onSwitch(int i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayBackSwitchLineDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        RecyclerView.Adapter playbackSwitchLineAdapter = new PlaybackSwitchLineAdapter();
        this.mAdapter = playbackSwitchLineAdapter;
        layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(327.0f), SizeUtils.dp2px(251.0f)));
        this.binding.cancelBtn.setOnClickListener(new PlayBackSwitchLineDialog$$ExternalSyntheticLambda0(this));
        this.binding.confirmBtn.setOnClickListener(new PlayBackSwitchLineDialog$$ExternalSyntheticLambda1(this));
        playbackSwitchLineAdapter.setOnItemClickListener(new PlayBackSwitchLineDialog$$ExternalSyntheticLambda2(this));
        this.binding.switchLineRecyclerview.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.binding.switchLineRecyclerview.setAdapter(playbackSwitchLineAdapter);
    }

    /* access modifiers changed from: protected */
    public PlayBackSwitchLineDialogBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        PlayBackSwitchLineDialogBinding inflate = PlayBackSwitchLineDialogBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m328_init_$lambda0(PlayBackSwitchLineDialog playBackSwitchLineDialog, View view) {
        Intrinsics.checkNotNullParameter(playBackSwitchLineDialog, "this$0");
        playBackSwitchLineDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m329_init_$lambda1(PlayBackSwitchLineDialog playBackSwitchLineDialog, View view) {
        Intrinsics.checkNotNullParameter(playBackSwitchLineDialog, "this$0");
        OnSwitchListen onSwitchListen = playBackSwitchLineDialog.mOnSwitchListen;
        if (onSwitchListen != null) {
            onSwitchListen.onSwitch(playBackSwitchLineDialog.mAdapter.getMSelectIndex());
        }
        playBackSwitchLineDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m330_init_$lambda2(PlayBackSwitchLineDialog playBackSwitchLineDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(playBackSwitchLineDialog, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        playBackSwitchLineDialog.mAdapter.setMSelectIndex(i);
        playBackSwitchLineDialog.mAdapter.notifyDataSetChanged();
    }

    public final void setData(List<AddressBean> list, int i) {
        if (i >= (list == null ? 0 : list.size())) {
            i = 0;
        }
        this.mAdapter.setMSelectIndex(i);
        this.mAdapter.setList(list);
    }

    public final void setOnSwitchListen(OnSwitchListen onSwitchListen) {
        Intrinsics.checkNotNullParameter(onSwitchListen, "listen");
        this.mOnSwitchListen = onSwitchListen;
    }
}
