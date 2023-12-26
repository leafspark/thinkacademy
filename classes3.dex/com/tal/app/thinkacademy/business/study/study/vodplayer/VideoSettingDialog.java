package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B0\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0014R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSettingDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VideoSettingDialogLayoutBinding;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSettingDialog$VideoSettingType;", "Lkotlin/ParameterName;", "name", "type", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mListen", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "VideoSettingType", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingDialog.kt */
public final class VideoSettingDialog extends BaseBindDialog<VideoSettingDialogLayoutBinding> {
    private Function1<? super VideoSettingType, Unit> mListen;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSettingDialog$VideoSettingType;", "", "(Ljava/lang/String;I)V", "LINE_SWITCH", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoSettingDialog.kt */
    public enum VideoSettingType {
        LINE_SWITCH
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSettingDialog(Context context, Function1<? super VideoSettingType, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "listen");
        this.mListen = function1;
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        dimAmount(0.0f);
        this.binding.switchLineBtn.setOnClickListener(new VideoSettingDialog$$ExternalSyntheticLambda0(this));
        this.binding.getRoot().setOnClickListener(new VideoSettingDialog$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m500_init_$lambda0(VideoSettingDialog videoSettingDialog, View view) {
        Intrinsics.checkNotNullParameter(videoSettingDialog, "this$0");
        videoSettingDialog.mListen.invoke(VideoSettingType.LINE_SWITCH);
        videoSettingDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m501_init_$lambda1(VideoSettingDialog videoSettingDialog, View view) {
        Intrinsics.checkNotNullParameter(videoSettingDialog, "this$0");
        videoSettingDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public VideoSettingDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoSettingDialogLayoutBinding inflate = VideoSettingDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
