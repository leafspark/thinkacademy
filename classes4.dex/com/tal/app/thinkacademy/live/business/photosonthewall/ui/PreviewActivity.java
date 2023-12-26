package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.pad.NotPadAutoScreen;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.dialog.SubmitDialog;
import com.tal.app.thinkacademy.live.util.DriverTrack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020 H\u0014J\u0010\u0010&\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0014H\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\tH\u0002J\b\u0010/\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessActivityPreviewBinding;", "()V", "KSubmissionFailed", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "isSubmitting", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mFileDir", "", "mFileName", "mFilePath", "mHandler", "Landroid/os/Handler;", "mMillisDuration", "", "mPhotosMaintainData", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosMaintainData;", "mSubmitDialog", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/dialog/SubmitDialog;", "picAbsPath", "resultPath", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "endCountdown", "", "hideSubmitDialog", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "photoSubmit", "setViewValues", "showSubmitDialog", "startCountdown", "millisDuration", "track", "key", "updateSubmitState", "isSubmit", "uploadFile", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@NotPadAutoScreen
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity extends BaseBindActivity<LiveBusinessActivityPreviewBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final int KSubmissionFailed;
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.PreviewActivity;
    /* access modifiers changed from: private */
    public boolean isOnDestroy;
    private boolean isSubmitting;
    private CountDownTimer mCountDownTimer;
    private String mFileDir = "";
    private String mFileName = "";
    private String mFilePath = "";
    /* access modifiers changed from: private */
    public Handler mHandler = new PreviewActivity$mHandler$1(this, Looper.getMainLooper());
    private long mMillisDuration;
    /* access modifiers changed from: private */
    public PhotosMaintainData mPhotosMaintainData;
    /* access modifiers changed from: private */
    public SubmitDialog mSubmitDialog;
    /* access modifiers changed from: private */
    public String picAbsPath = "";
    /* access modifiers changed from: private */
    public String resultPath = "";

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "millisDuration", "", "fileName", "", "data", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosMaintainData;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PreviewActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, long j, String str, PhotosMaintainData photosMaintainData) {
            Intrinsics.checkNotNullParameter(str, "fileName");
            if (context != null) {
                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra(PreviewActivityKt.MillisDuration, j);
                intent.putExtra(PreviewActivityKt.FileName, str);
                intent.putExtra(TakePhotoActivityKt.PhotosMaintainData, photosMaintainData);
                context.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        Window window = getWindow();
        View decorView = window == null ? null : window.getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(2564);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.addFlags(LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.mPhotosMaintainData = (PhotosMaintainData) intent.getParcelableExtra(TakePhotoActivityKt.PhotosMaintainData);
            this.mMillisDuration = intent.getLongExtra(PreviewActivityKt.MillisDuration, 0);
            this.mFileDir = AppCacheUtil.getTakePhotoCacheDir((Context) this);
            String stringExtra = intent.getStringExtra(PreviewActivityKt.FileName);
            this.mFileName = stringExtra;
            this.mFilePath = Intrinsics.stringPlus(this.mFileDir, stringExtra);
            setViewValues();
        }
    }

    private final void setViewValues() {
        PhotosMaintainData photosMaintainData = this.mPhotosMaintainData;
        if (!(photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true))) {
            RoundLinearLayout roundLinearLayout = getBinding().llCountdown;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(0);
            }
            startCountdown(this.mMillisDuration);
        } else {
            RoundLinearLayout roundLinearLayout2 = getBinding().llCountdown;
            if (roundLinearLayout2 != null) {
                roundLinearLayout2.setVisibility(8);
            }
        }
        ImageView imageView = getBinding().cameraPreview;
        if (imageView != null) {
            XesImageLoader.loadImage$default(XesImageLoader.INSTANCE, imageView, (Context) this, this.mFilePath, 0, (OnProgressListener) null, (ImageRequestListener) null, 28, (Object) null);
        }
        ImageView imageView2 = getBinding().ivBack;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new PreviewActivity$$ExternalSyntheticLambda0(this));
        }
        getBinding().llRetake.setOnClickListener(new PreviewActivity$$ExternalSyntheticLambda1(this));
        getBinding().llSubmit.setOnClickListener(new PreviewActivity$$ExternalSyntheticLambda2(this));
        if (this.mSubmitDialog == null) {
            this.mSubmitDialog = new SubmitDialog((Context) this, PreviewActivity$setViewValues$4.INSTANCE);
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE).observe(lifecycleOwner, new PreviewActivity$$ExternalSyntheticLambda4(this));
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL).observe(lifecycleOwner, new PreviewActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-1  reason: not valid java name */
    public static final void m364setViewValues$lambda1(PreviewActivity previewActivity, View view) {
        Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        previewActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-2  reason: not valid java name */
    public static final void m365setViewValues$lambda2(PreviewActivity previewActivity, View view) {
        Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        Context context = (Context) previewActivity;
        SoundPoolUtils.play(context, R.raw.live_business_interact_button_click, 0);
        TakePhotoActivity.Companion.startActivity(context, previewActivity.mPhotosMaintainData);
        previewActivity.finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-3  reason: not valid java name */
    public static final void m366setViewValues$lambda3(PreviewActivity previewActivity, View view) {
        String interactId;
        Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        boolean z = false;
        SoundPoolUtils.play((Context) previewActivity, R.raw.live_business_interact_button_click, 0);
        previewActivity.updateSubmitState(true);
        XesLog.i(previewActivity.TAG, Intrinsics.stringPlus("llSubmit---> setOnClickListener ---> resultPath = ", previewActivity.resultPath));
        CharSequence charSequence = previewActivity.resultPath;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            z = true;
        }
        if (z) {
            previewActivity.uploadFile();
        } else {
            String str = previewActivity.resultPath;
            Intrinsics.checkNotNull(str);
            previewActivity.photoSubmit(str);
        }
        previewActivity.track(LeanplumUtil.submit_photowall);
        DriverTrack driverTrack = DriverTrack.INSTANCE;
        PhotosMaintainData photosMaintainData = previewActivity.mPhotosMaintainData;
        String str2 = "";
        if (!(photosMaintainData == null || (interactId = photosMaintainData.getInteractId()) == null)) {
            str2 = interactId;
        }
        driverTrack.classRoomInteractPhotographSubmit(str2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-4  reason: not valid java name */
    public static final void m367setViewValues$lambda4(PreviewActivity previewActivity, Object obj) {
        Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        if (!previewActivity.isOnDestroy) {
            PhotosMaintainData photosMaintainData = previewActivity.mPhotosMaintainData;
            if (!(photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true))) {
                previewActivity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setViewValues$lambda-5  reason: not valid java name */
    public static final void m368setViewValues$lambda5(PreviewActivity previewActivity, Object obj) {
        Intrinsics.checkNotNullParameter(previewActivity, "this$0");
        if (!previewActivity.isOnDestroy) {
            PhotosMaintainData photosMaintainData = previewActivity.mPhotosMaintainData;
            if (photosMaintainData == null ? false : Intrinsics.areEqual(photosMaintainData.isCorrection(), true)) {
                previewActivity.showToast(previewActivity.getString(R.string.interaction_ended));
            }
            previewActivity.finish();
        }
    }

    private final void startCountdown(long j) {
        CountDownTimer previewActivity$startCountdown$1 = new PreviewActivity$startCountdown$1(RangesKt.coerceAtLeast(j, 0), this);
        this.mCountDownTimer = previewActivity$startCountdown$1;
        previewActivity$startCountdown$1.start();
    }

    private final void endCountdown() {
        CountDownTimer countDownTimer = this.mCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.mCountDownTimer = null;
    }

    private final void uploadFile() {
        CharSequence charSequence = this.mFilePath;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence charSequence2 = this.mFileName;
            if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
                z = true;
            }
            if (!z) {
                String str = this.mFileName;
                Intrinsics.checkNotNull(str);
                String str2 = this.mFilePath;
                Intrinsics.checkNotNull(str2);
                AwsS3Util.INSTANCE.uploadFile((Context) this, AwsS3Util.scene_picture_wall, str, str2, (AwsS3Util.SingleTransferListener) new PreviewActivity$uploadFile$1(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void track(String str) {
        LeanplumUtil leanplumUtil = LeanplumUtil.INSTANCE;
        PhotosMaintainData photosMaintainData = this.mPhotosMaintainData;
        String str2 = null;
        String valueOf = String.valueOf(photosMaintainData == null ? null : photosMaintainData.getPlanId());
        PhotosMaintainData photosMaintainData2 = this.mPhotosMaintainData;
        String valueOf2 = String.valueOf(photosMaintainData2 == null ? null : photosMaintainData2.getClassId());
        PhotosMaintainData photosMaintainData3 = this.mPhotosMaintainData;
        if (photosMaintainData3 != null) {
            str2 = photosMaintainData3.getInteractId();
        }
        LeanplumUtil.longTrack$default(str, valueOf2, valueOf, (String) null, (String) null, (String) null, (String) null, (String) null, String.valueOf(System.currentTimeMillis()), (String) null, (String) null, (String) null, String.valueOf(str2), (String) null, 12024, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r2 = r2.getPlanId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void photoSubmit(java.lang.String r12) {
        /*
            r11 = this;
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r0 = r11.mPhotosMaintainData
            if (r0 == 0) goto L_0x00aa
            java.lang.Class<com.tal.app.thinkacademy.live.business.photosonthewall.api.PhotosOnTheWallApi> r0 = com.tal.app.thinkacademy.live.business.photosonthewall.api.PhotosOnTheWallApi.class
            java.lang.Object r0 = com.tal.app.thinkacademy.lib.network.Api.create(r0)
            com.tal.app.thinkacademy.live.business.photosonthewall.api.PhotosOnTheWallApi r0 = (com.tal.app.thinkacademy.live.business.photosonthewall.api.PhotosOnTheWallApi) r0
            com.tal.app.thinkacademy.common.imconfig.ImConfig r1 = com.tal.app.thinkacademy.common.imconfig.ImConfig.INSTANCE
            java.lang.String r1 = r1.getOverseaApi()
            java.lang.String r2 = "/classroom-hub/wall/student/submit"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r2 = r11.mPhotosMaintainData
            r3 = 0
            if (r2 != 0) goto L_0x001f
        L_0x001d:
            r5 = r3
            goto L_0x0030
        L_0x001f:
            java.lang.Integer r2 = r2.getPlanId()
            if (r2 != 0) goto L_0x0026
            goto L_0x001d
        L_0x0026:
            int r2 = r2.intValue()
            long r4 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r5 = r2
        L_0x0030:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r2 = r11.mPhotosMaintainData
            if (r2 != 0) goto L_0x0036
        L_0x0034:
            r6 = r3
            goto L_0x0047
        L_0x0036:
            java.lang.Integer r2 = r2.getClassId()
            if (r2 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            int r2 = r2.intValue()
            long r6 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            r6 = r2
        L_0x0047:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r2 = r11.mPhotosMaintainData
            if (r2 != 0) goto L_0x004d
        L_0x004b:
            r7 = r3
            goto L_0x005e
        L_0x004d:
            java.lang.Integer r2 = r2.getTutorId()
            if (r2 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            int r2 = r2.intValue()
            long r7 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            r7 = r2
        L_0x005e:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r2 = r11.mPhotosMaintainData
            if (r2 != 0) goto L_0x0064
            r8 = r3
            goto L_0x0069
        L_0x0064:
            java.lang.String r2 = r2.getInteractId()
            r8 = r2
        L_0x0069:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r2 = r11.mPhotosMaintainData     // Catch:{ Exception -> 0x007f }
            if (r2 != 0) goto L_0x006e
            goto L_0x007d
        L_0x006e:
            java.lang.String r2 = r2.getTeacherId()     // Catch:{ Exception -> 0x007f }
            if (r2 != 0) goto L_0x0075
            goto L_0x007d
        L_0x0075:
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x007f }
            java.lang.Long r3 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x007f }
        L_0x007d:
            r10 = r3
            goto L_0x0086
        L_0x007f:
            r2 = 0
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r10 = r2
        L_0x0086:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoOnTheWallBody r2 = new com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoOnTheWallBody
            r4 = r2
            r9 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
            retrofit2.Call r12 = r0.photoSubmit(r1, r2)
            com.tal.app.thinkacademy.live.business.photosonthewall.ui.PreviewActivity$photoSubmit$2 r0 = new com.tal.app.thinkacademy.live.business.photosonthewall.ui.PreviewActivity$photoSubmit$2
            r0.<init>(r11)
            com.tal.app.thinkacademy.live.business.photosonthewall.ui.PreviewActivity$photoSubmit$1 r1 = new com.tal.app.thinkacademy.live.business.photosonthewall.ui.PreviewActivity$photoSubmit$1
            r1.<init>(r11, r0)
            retrofit2.Callback r1 = (retrofit2.Callback) r1
            boolean r0 = r12 instanceof retrofit2.Call
            if (r0 != 0) goto L_0x00a5
            r12.enqueue(r1)
            goto L_0x00aa
        L_0x00a5:
            retrofit2.Call r12 = (retrofit2.Call) r12
            com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation.enqueue(r12, r1)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.photosonthewall.ui.PreviewActivity.photoSubmit(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void updateSubmitState(boolean z) {
        this.isSubmitting = z;
        if (z) {
            showSubmitDialog();
            getBinding().llRetake.setClickable(false);
            getBinding().llSubmit.setClickable(false);
            getBinding().ivRetake.setImageResource(R.drawable.icon_preview_retake_disable);
            getBinding().tvRetake.setSelected(true);
            getBinding().ivSubmit.setImageResource(R.drawable.icon_preview_submit_disable);
            getBinding().tvSubmit.setSelected(true);
            return;
        }
        hideSubmitDialog();
        getBinding().llRetake.setClickable(true);
        getBinding().llSubmit.setClickable(true);
        getBinding().ivRetake.setImageResource(R.drawable.icon_preview_retake);
        getBinding().tvRetake.setSelected(false);
        getBinding().ivSubmit.setImageResource(R.drawable.icon_preview_submit);
        getBinding().tvSubmit.setSelected(false);
    }

    private final void showSubmitDialog() {
        SubmitDialog submitDialog;
        if (!isFinishing() && (submitDialog = this.mSubmitDialog) != null && !submitDialog.isShowing() && !this.isOnDestroy) {
            submitDialog.updateProgress(0);
            submitDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public final void hideSubmitDialog() {
        SubmitDialog submitDialog;
        if (!isFinishing() && (submitDialog = this.mSubmitDialog) != null && submitDialog.isShowing()) {
            submitDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.isOnDestroy = true;
        endCountdown();
        hideSubmitDialog();
        this.mSubmitDialog = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }

    /* access modifiers changed from: protected */
    public LiveBusinessActivityPreviewBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessActivityPreviewBinding inflate = LiveBusinessActivityPreviewBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
