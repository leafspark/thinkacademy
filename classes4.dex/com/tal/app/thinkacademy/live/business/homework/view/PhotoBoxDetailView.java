package com.tal.app.thinkacademy.live.business.homework.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding;
import com.tal.app.thinkacademy.live.business.homework.driver.IPhotoBoxPlugin;
import com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import com.tal.app.thinkacademy.live.util.ViewScaleUtil;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\tH\u0002J*\u0010\"\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxDetailView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessHomeworkDetailBinding;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;)V", "mCoins", "", "mSource", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "getMSource", "()Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "setMSource", "(Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;)V", "close", "", "source", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "initViews", "refreshLayout", "pptLp", "Landroid/widget/FrameLayout$LayoutParams;", "setBgLp", "showAwardView", "coin", "showHomeWorkDetail", "item", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "canCorrect", "uncorrectability", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxDetailView.kt */
public final class PhotoBoxDetailView extends BaseVBLivePluginView<LiveBusinessHomeworkDetailBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SUB_TAG = "详情";
    private static final Tag TAG = Tag.PHOTO_BOX;
    private final IPhotoBoxPlugin driver;
    private int mCoins;
    private DetailSource mSource = DetailSource.IRC;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoBoxDetailView(Context context, IPhotoBoxPlugin iPhotoBoxPlugin) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iPhotoBoxPlugin, "driver");
        this.driver = iPhotoBoxPlugin;
    }

    public final DetailSource getMSource() {
        return this.mSource;
    }

    public final void setMSource(DetailSource detailSource) {
        Intrinsics.checkNotNullParameter(detailSource, "<set-?>");
        this.mSource = detailSource;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxDetailView$Companion;", "", "()V", "SUB_TAG", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxDetailView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void initViews() {
        PhotoBoxDetailView.super.initViews();
        setBgLp();
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
        Intrinsics.checkNotNullExpressionValue(newLp, "get().pptLp.newLp()");
        refreshLayout(newLp);
        this.mBinding.ivLiveBusinessHomeworkClose.setOnClickListener(new PhotoBoxDetailView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initViews$lambda-0  reason: not valid java name */
    public static final void m271initViews$lambda0(PhotoBoxDetailView photoBoxDetailView, View view) {
        Intrinsics.checkNotNullParameter(photoBoxDetailView, "this$0");
        photoBoxDetailView.close("点击关闭按钮");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void setBgLp() {
        ConstraintLayout.LayoutParams layoutParams = this.mBinding.bgLiveBusinessHomeworkDetail.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams;
        LiveAreaContext.get().getPptLp().mergeLp(marginLayoutParams);
        this.mBinding.bgLiveBusinessHomeworkDetail.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessHomeworkDetailBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessHomeworkDetailBinding inflate = LiveBusinessHomeworkDetailBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public static /* synthetic */ void showHomeWorkDetail$default(PhotoBoxDetailView photoBoxDetailView, DetailSource detailSource, HomeworkEntity homeworkEntity, boolean z, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        photoBoxDetailView.showHomeWorkDetail(detailSource, homeworkEntity, z, i);
    }

    public final void showHomeWorkDetail(DetailSource detailSource, HomeworkEntity homeworkEntity, boolean z, int i) {
        int i2;
        int i3;
        String str;
        String photoUrl;
        Intrinsics.checkNotNullParameter(detailSource, "source");
        if (homeworkEntity != null) {
            XesLog.i(TAG, SUB_TAG, "展示作业详情: 批改状态：" + homeworkEntity.getCorrectStatus() + ",奖励金币数：" + i + ",来自 " + detailSource);
            this.mSource = detailSource;
            int correctStatus = homeworkEntity.getCorrectStatus();
            if (correctStatus == CorrectStatus.HALF_CORRECT.getValue()) {
                i3 = R.color.color_FFD317;
                i2 = R.drawable.icon_live_business_homework_title_half_correct;
                photoUrl = homeworkEntity.getCorrectUrl();
                Intrinsics.checkNotNullExpressionValue(photoUrl, "item.correctUrl");
            } else if (correctStatus == CorrectStatus.WRONG.getValue()) {
                i3 = R.color.color_FF6C29;
                i2 = R.drawable.icon_live_business_homework_title_incorrect;
                photoUrl = homeworkEntity.getCorrectUrl();
                Intrinsics.checkNotNullExpressionValue(photoUrl, "item.correctUrl");
            } else if (correctStatus == CorrectStatus.UNCHECK.getValue() || correctStatus == CorrectStatus.REUPLOAD.getValue()) {
                i3 = R.color.color_63B5FF;
                i2 = R.drawable.icon_live_business_homework_title_grading;
                photoUrl = homeworkEntity.getPhotoUrl();
                Intrinsics.checkNotNullExpressionValue(photoUrl, "item.photoUrl");
            } else if (correctStatus == CorrectStatus.RIGHT.getValue()) {
                int i4 = R.color.color_0CBD6C;
                int i5 = R.drawable.icon_live_business_homework_title_correct;
                str = homeworkEntity.getCorrectUrl();
                Intrinsics.checkNotNullExpressionValue(str, "item.correctUrl");
                if ((Intrinsics.areEqual(TopicConfig.INTERACT, homeworkEntity.getTagType()) || Intrinsics.areEqual("question", homeworkEntity.getTagType())) && detailSource == DetailSource.IRC) {
                    this.mCoins = i;
                    showAwardView(i);
                }
                i3 = i4;
                i2 = i5;
                if (TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR), homeworkEntity.getInteractId()) || ((correctStatus == CorrectStatus.WRONG.getValue() && correctStatus == CorrectStatus.HALF_CORRECT.getValue()) || !z)) {
                    this.mBinding.ivLiveBusinessHomeworkResubmit.setVisibility(8);
                } else {
                    this.mBinding.ivLiveBusinessHomeworkResubmit.setVisibility(0);
                }
                this.mBinding.ivLiveBusinessHomeworkResubmit.setOnClickListener(new PhotoBoxDetailView$$ExternalSyntheticLambda0(homeworkEntity, this));
                ImageLoaderJ.load(getContext(), str, this.mBinding.ivLiveBusinessHomeworkPhoto, R.drawable.hw_image_loading, R.drawable.hw_image_loading_fail, false);
                this.mBinding.ivLiveBusinessHomeworkTitle.setImageResource(i2);
                this.mBinding.layoutLiveBusinessHomeworkTitle.getDelegate().setBackgroundColor(ContextCompat.getColor(getContext(), i3));
                this.mBinding.getRoot().setVisibility(0);
            } else {
                i3 = R.color.color_63B5FF;
                i2 = R.drawable.icon_live_business_homework_title_grading;
                photoUrl = homeworkEntity.getPhotoUrl();
                Intrinsics.checkNotNullExpressionValue(photoUrl, "item.photoUrl");
            }
            str = photoUrl;
            if (TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR), homeworkEntity.getInteractId()) && (correctStatus == CorrectStatus.WRONG.getValue() || correctStatus == CorrectStatus.HALF_CORRECT.getValue())) {
            }
            this.mBinding.ivLiveBusinessHomeworkResubmit.setVisibility(8);
            this.mBinding.ivLiveBusinessHomeworkResubmit.setOnClickListener(new PhotoBoxDetailView$$ExternalSyntheticLambda0(homeworkEntity, this));
            ImageLoaderJ.load(getContext(), str, this.mBinding.ivLiveBusinessHomeworkPhoto, R.drawable.hw_image_loading, R.drawable.hw_image_loading_fail, false);
            this.mBinding.ivLiveBusinessHomeworkTitle.setImageResource(i2);
            this.mBinding.layoutLiveBusinessHomeworkTitle.getDelegate().setBackgroundColor(ContextCompat.getColor(getContext(), i3));
            this.mBinding.getRoot().setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showHomeWorkDetail$lambda-1  reason: not valid java name */
    public static final void m272showHomeWorkDetail$lambda1(HomeworkEntity homeworkEntity, PhotoBoxDetailView photoBoxDetailView, View view) {
        Intrinsics.checkNotNullParameter(photoBoxDetailView, "this$0");
        if (Intrinsics.areEqual("graffiti", homeworkEntity.getTagType())) {
            photoBoxDetailView.driver.resubmitDraw(homeworkEntity);
        } else {
            photoBoxDetailView.driver.resubmitPhoto(homeworkEntity);
        }
        photoBoxDetailView.close("点击重新提交按钮");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showAwardView(int i) {
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("展示金币奖励弹窗，金币数量是：", Integer.valueOf(i)));
        if (i > 0) {
            this.mBinding.layoutAwardView.setLogTag(Tag.PHOTO_BOX);
            this.mBinding.layoutAwardView.setBackground((Drawable) null);
            this.mBinding.ivLiveBusinessHomeworkPhotoBg.setVisibility(0);
            this.mBinding.layoutAwardView.setParams(new SubmitResultParams(AwardType.RIGHT, -1, i, 0, false, 24, (DefaultConstructorMarker) null));
            this.mBinding.layoutAwardView.show(new PhotoBoxDetailView$showAwardView$1(this));
        }
    }

    private final void refreshLayout(FrameLayout.LayoutParams layoutParams) {
        int dp2px = SizeUtils.dp2px(323.0f);
        float f = (((float) layoutParams.height) * 1.0f) / ((float) dp2px);
        ViewScaleUtil.scale(this.mBinding.layoutLiveBusinessHomeworkDetail, f);
        if (!PadUtils.isPad(this.mContext)) {
            ViewScaleUtil.scale((View) this.mBinding.ivLiveBusinessHomeworkContent, 1.078f);
        }
        XesLog.i(TAG, SUB_TAG, "ppt宽 = " + layoutParams.height + " , 设计稿宽 = " + dp2px + " , 缩放" + f + 20493);
    }

    public final void close(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        XesLog.i(TAG, SUB_TAG, Intrinsics.stringPlus("关闭作业详情弹窗,来自 ", str));
        if (this.mSource == DetailSource.IRC && this.mCoins > 0 && this.mBinding.layoutAwardView.getNeedNotifyCoinsCenter()) {
            this.driver.syncCoins(Integer.valueOf(this.mCoins));
        }
        this.driver.closeHomeworkDetail();
    }

    public final void uncorrectability() {
        XesLog.i(TAG, SUB_TAG, "互动已关闭，作业详情弹窗不可订正");
        this.mBinding.ivLiveBusinessHomeworkResubmit.setVisibility(8);
    }
}
