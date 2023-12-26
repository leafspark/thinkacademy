package com.tal.app.thinkacademy.business.study.study.vodplayer;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.studycenter.databinding.VideoSpeedSelectDialogLayoutBinding;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0016\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/vodplayer/VideoSpeedSelectDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/VideoSpeedSelectDialogLayoutBinding;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "desc", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/vodplayer/SpeedAdapter;", "mBgAnimator", "Landroid/animation/Animator;", "mCurrentIndex", "mList", "", "mListen", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "startAlphaBgAnimation", "stopAlphaBgAnimation", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSpeedSelectDialog.kt */
public final class VideoSpeedSelectDialog extends BaseBindDialog<VideoSpeedSelectDialogLayoutBinding> {
    /* access modifiers changed from: private */
    public final SpeedAdapter mAdapter;
    private Animator mBgAnimator;
    /* access modifiers changed from: private */
    public int mCurrentIndex;
    /* access modifiers changed from: private */
    public final List<String> mList;
    /* access modifiers changed from: private */
    public Function2<? super Integer, ? super String, Unit> mListen;

    private final void startAlphaBgAnimation() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSpeedSelectDialog(Context context, Function2<? super Integer, ? super String, Unit> function2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mListen = function2;
        RecyclerView.Adapter speedAdapter = new SpeedAdapter();
        this.mAdapter = speedAdapter;
        List<String> mutableListOf = CollectionsKt.mutableListOf("0.5", "0.75", DbParams.GZIP_DATA_EVENT, "1.25", "1.5", "2");
        this.mList = mutableListOf;
        this.mCurrentIndex = 2;
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.binding.speedRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.binding.speedRecyclerView.setAdapter(speedAdapter);
        speedAdapter.setList(mutableListOf);
        speedAdapter.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ VideoSpeedSelectDialog this$0;

            {
                this.this$0 = r1;
            }

            public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
                Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
                Intrinsics.checkNotNullParameter(view, "view");
                XesLog.dt("VideoSpeedSelectDialog", new Object[]{Intrinsics.stringPlus("onItemClick position=", Integer.valueOf(i))});
                this.this$0.mCurrentIndex = i;
                this.this$0.mAdapter.setMCurrentIndex(this.this$0.mCurrentIndex);
                this.this$0.mAdapter.notifyDataSetChanged();
                this.this$0.dismiss();
                Function2 access$getMListen$p = this.this$0.mListen;
                if (access$getMListen$p != null) {
                    access$getMListen$p.invoke(Integer.valueOf(this.this$0.mCurrentIndex), this.this$0.mList.get(this.this$0.mCurrentIndex));
                }
            }
        });
        dimAmount(0.0f);
        setOnShowListener(new VideoSpeedSelectDialog$$ExternalSyntheticLambda1(this));
        setOnDismissListener(new VideoSpeedSelectDialog$$ExternalSyntheticLambda0(this));
        this.binding.getRoot().setOnClickListener(new VideoSpeedSelectDialog$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoSpeedSelectDialog(Context context, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : function2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m503_init_$lambda0(VideoSpeedSelectDialog videoSpeedSelectDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(videoSpeedSelectDialog, "this$0");
        videoSpeedSelectDialog.startAlphaBgAnimation();
        videoSpeedSelectDialog.mAdapter.setMCurrentIndex(videoSpeedSelectDialog.mCurrentIndex);
        videoSpeedSelectDialog.mAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m504_init_$lambda1(VideoSpeedSelectDialog videoSpeedSelectDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(videoSpeedSelectDialog, "this$0");
        videoSpeedSelectDialog.stopAlphaBgAnimation();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m505_init_$lambda2(VideoSpeedSelectDialog videoSpeedSelectDialog, View view) {
        Intrinsics.checkNotNullParameter(videoSpeedSelectDialog, "this$0");
        videoSpeedSelectDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void stopAlphaBgAnimation() {
        Animator animator = this.mBgAnimator;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public VideoSpeedSelectDialogLayoutBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        VideoSpeedSelectDialogLayoutBinding inflate = VideoSpeedSelectDialogLayoutBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }
}
