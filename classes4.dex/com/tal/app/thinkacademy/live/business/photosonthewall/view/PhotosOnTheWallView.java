package com.tal.app.thinkacademy.live.business.photosonthewall.view;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.util.TimeTransformationUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.util.PermissionUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.driver.BasePhotosOnTheWallPlugin;
import com.tal.app.thinkacademy.live.business.photosonthewall.ui.TakePhotoActivity;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0013J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0013J\u0006\u0010&\u001a\u00020\u001dJ\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000fJ\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/view/PhotosOnTheWallView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessPhotosOnTheWallBinding;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBeginTime", "", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mDriver", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/BasePhotosOnTheWallPlugin;", "mPhotosMaintainData", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosMaintainData;", "mPhotosOnTheWallViewState", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/view/PhotosOnTheWallViewState;", "mTotalTime", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "endCountdown", "", "getPhotosOnTheWallViewState", "initData", "initViews", "loadSubmitSuccess", "totalCoin", "rightCoin", "loadView", "state", "onDestroy", "refreshLayout", "pptLp", "Landroid/widget/FrameLayout$LayoutParams;", "setDriver", "basePhotosOnTheWallPlugin", "startCountdown", "data", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotosOnTheWallView.kt */
public final class PhotosOnTheWallView extends BaseVBLivePluginView<LiveBusinessPhotosOnTheWallBinding> {
    private long mBeginTime;
    private CountDownTimer mCountDownTimer;
    private BasePhotosOnTheWallPlugin mDriver;
    private PhotosMaintainData mPhotosMaintainData;
    private PhotosOnTheWallViewState mPhotosOnTheWallViewState;
    private long mTotalTime;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotosOnTheWallView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhotosOnTheWallViewState.values().length];
            iArr[PhotosOnTheWallViewState.HavaPermission.ordinal()] = 1;
            iArr[PhotosOnTheWallViewState.NoHavaPermission.ordinal()] = 2;
            iArr[PhotosOnTheWallViewState.TakePhoto.ordinal()] = 3;
            iArr[PhotosOnTheWallViewState.OnlyCountdown.ordinal()] = 4;
            iArr[PhotosOnTheWallViewState.SubmitSuccess.ordinal()] = 5;
            iArr[PhotosOnTheWallViewState.SubmitFailed.ordinal()] = 6;
            iArr[PhotosOnTheWallViewState.StopAnswer.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhotosOnTheWallView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PhotosOnTheWallView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotosOnTheWallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.mPhotosOnTheWallViewState = PhotosOnTheWallViewState.NoHavaPermission;
        this.mContext = context;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotosOnTheWallView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessPhotosOnTheWallBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessPhotosOnTheWallBinding inflate = LiveBusinessPhotosOnTheWallBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void initViews() {
        PhotosOnTheWallView.super.initViews();
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
        Intrinsics.checkNotNullExpressionValue(newLp, "get().pptLp.newLp()");
        refreshLayout(newLp);
    }

    public void initData() {
        PhotosOnTheWallView.super.initData();
        this.mBinding.llCameraSettings.setOnClickListener(new PhotosOnTheWallView$$ExternalSyntheticLambda2(this));
        this.mBinding.ivPromptClose.setOnClickListener(new PhotosOnTheWallView$$ExternalSyntheticLambda1(this));
        this.mBinding.ivCamera.setOnClickListener(new PhotosOnTheWallView$$ExternalSyntheticLambda0(this));
        this.mBinding.layoutAwardView.setLogTag(Tag.BasePhotosOnTheWallPlugin);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-0  reason: not valid java name */
    public static final void m380initData$lambda0(PhotosOnTheWallView photosOnTheWallView, View view) {
        Intrinsics.checkNotNullParameter(photosOnTheWallView, "this$0");
        PermissionUtils.launchAppDetailsSettings();
        Context context = photosOnTheWallView.getContext();
        if (context != null) {
            ((Activity) context).finish();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        throw nullPointerException;
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m381initData$lambda1(PhotosOnTheWallView photosOnTheWallView, View view) {
        Intrinsics.checkNotNullParameter(photosOnTheWallView, "this$0");
        photosOnTheWallView.mBinding.llPrompt.setVisibility(8);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-4  reason: not valid java name */
    public static final void m382initData$lambda4(PhotosOnTheWallView photosOnTheWallView, View view) {
        Context context;
        PhotosOnTheWallView photosOnTheWallView2 = photosOnTheWallView;
        Intrinsics.checkNotNullParameter(photosOnTheWallView2, "this$0");
        if ((photosOnTheWallView2.mPhotosOnTheWallViewState == PhotosOnTheWallViewState.HavaPermission || photosOnTheWallView2.mPhotosOnTheWallViewState == PhotosOnTheWallViewState.TakePhoto) && (context = photosOnTheWallView2.mContext) != null) {
            SoundPoolUtils.play(context, R.raw.live_business_interact_button_click, 0);
            photosOnTheWallView2.loadView(PhotosOnTheWallViewState.TakePhoto);
            LeanplumUtil leanplumUtil = LeanplumUtil.INSTANCE;
            PhotosMaintainData photosMaintainData = photosOnTheWallView2.mPhotosMaintainData;
            String str = null;
            String valueOf = String.valueOf(photosMaintainData == null ? null : photosMaintainData.getPlanId());
            PhotosMaintainData photosMaintainData2 = photosOnTheWallView2.mPhotosMaintainData;
            String valueOf2 = String.valueOf(photosMaintainData2 == null ? null : photosMaintainData2.getClassId());
            PhotosMaintainData photosMaintainData3 = photosOnTheWallView2.mPhotosMaintainData;
            LeanplumUtil.longTrack$default(LeanplumUtil.click_photowall, valueOf2, valueOf, (String) null, (String) null, (String) null, (String) null, (String) null, String.valueOf(System.currentTimeMillis()), (String) null, (String) null, (String) null, String.valueOf(photosMaintainData3 == null ? null : photosMaintainData3.getInteractId()), (String) null, 12024, (Object) null);
            DriverTrack driverTrack = DriverTrack.INSTANCE;
            PhotosMaintainData photosMaintainData4 = photosOnTheWallView2.mPhotosMaintainData;
            if (photosMaintainData4 != null) {
                str = photosMaintainData4.getInteractId();
            }
            driverTrack.classRoomInteractPhotographClick(String.valueOf(str));
            PhotosMaintainData photosMaintainData5 = photosOnTheWallView2.mPhotosMaintainData;
            if (photosMaintainData5 != null) {
                TakePhotoActivity.Companion.startActivity(context, photosMaintainData5);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setDriver(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin) {
        Intrinsics.checkNotNullParameter(basePhotosOnTheWallPlugin, "basePhotosOnTheWallPlugin");
        this.mDriver = basePhotosOnTheWallPlugin;
    }

    public final void loadSubmitSuccess(int i, int i2) {
        this.mBinding.layoutAwardView.setParams(new SubmitResultParams(AwardType.UPLOAD, i, i2, 0, false, 24, (DefaultConstructorMarker) null));
    }

    public final PhotosOnTheWallViewState getPhotosOnTheWallViewState() {
        return this.mPhotosOnTheWallViewState;
    }

    public final void loadView(PhotosOnTheWallViewState photosOnTheWallViewState) {
        Intrinsics.checkNotNullParameter(photosOnTheWallViewState, "state");
        this.mPhotosOnTheWallViewState = photosOnTheWallViewState;
        switch (WhenMappings.$EnumSwitchMapping$0[photosOnTheWallViewState.ordinal()]) {
            case 1:
                this.mBinding.ivCamera.setVisibility(0);
                this.mBinding.ivCamera.setImageResource(R.drawable.icon_camera_hava_permission);
                this.mBinding.llPrompt.setVisibility(0);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                this.mBinding.layoutAwardView.setVisibility(8);
                return;
            case 2:
                this.mBinding.ivCamera.setVisibility(0);
                this.mBinding.ivCamera.setImageResource(R.drawable.icon_camera_no_permission);
                this.mBinding.llPrompt.setVisibility(8);
                this.mBinding.llCameraSettings.setVisibility(0);
                this.mBinding.llResultFaild.setVisibility(8);
                return;
            case 3:
                this.mBinding.ivCamera.setVisibility(0);
                this.mBinding.ivCamera.setImageResource(R.drawable.icon_camera_hava_permission);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                return;
            case 4:
                this.mBinding.ivCamera.setVisibility(8);
                this.mBinding.llPrompt.setVisibility(8);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                return;
            case 5:
                this.mBinding.ivCamera.setVisibility(8);
                this.mBinding.llPrompt.setVisibility(8);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                SubmitResultView submitResultView = this.mBinding.layoutAwardView;
                Intrinsics.checkNotNullExpressionValue(submitResultView, "mBinding.layoutAwardView");
                SubmitResultView.show$default(submitResultView, (Function0) null, 1, (Object) null);
                return;
            case 6:
                this.mBinding.ivCamera.setVisibility(8);
                this.mBinding.llPrompt.setVisibility(8);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                return;
            case 7:
                this.mBinding.llCountdown.setVisibility(8);
                this.mBinding.ivCamera.setVisibility(8);
                this.mBinding.llPrompt.setVisibility(8);
                this.mBinding.llCameraSettings.setVisibility(8);
                this.mBinding.llResultFaild.setVisibility(8);
                return;
            default:
                return;
        }
    }

    public final void startCountdown(PhotosMaintainData photosMaintainData) {
        long j;
        Intrinsics.checkNotNullParameter(photosMaintainData, "data");
        endCountdown();
        this.mPhotosMaintainData = photosMaintainData;
        if (photosMaintainData != null) {
            Long totalTime = photosMaintainData.getTotalTime();
            this.mTotalTime = totalTime == null ? 0 : totalTime.longValue();
            Long beginTime = photosMaintainData.getBeginTime();
            this.mBeginTime = beginTime == null ? 0 : beginTime.longValue();
            try {
                j = this.mTotalTime - (TimeTransformationUtil.Companion.dateToStamp$default(TimeTransformationUtil.Companion, (String) null, 1, (Object) null) - this.mBeginTime);
            } catch (Exception unused) {
                j = this.mTotalTime;
            }
            long j2 = this.mTotalTime;
            if (j > j2) {
                j = j2;
            }
            CountDownTimer photosOnTheWallView$startCountdown$1$1 = new PhotosOnTheWallView$startCountdown$1$1(RangesKt.coerceAtLeast(j, 0), this);
            this.mCountDownTimer = photosOnTheWallView$startCountdown$1$1;
            photosOnTheWallView$startCountdown$1$1.start();
        }
    }

    private final void endCountdown() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mCountDownTimer = null;
    }

    public final void onDestroy() {
        loadView(PhotosOnTheWallViewState.OnlyCountdown);
        endCountdown();
        this.mPhotosMaintainData = null;
        this.mContext = null;
    }

    private final void refreshLayout(FrameLayout.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = this.mBinding.layoutTakePhoto.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
        layoutParams3.topMargin = layoutParams.topMargin;
        layoutParams3.setMarginStart(layoutParams.getMarginStart());
        layoutParams3.width = layoutParams.width;
        layoutParams3.height = layoutParams.height;
        this.mBinding.layoutTakePhoto.setLayoutParams(layoutParams3);
    }
}
