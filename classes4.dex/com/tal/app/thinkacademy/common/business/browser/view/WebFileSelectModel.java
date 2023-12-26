package com.tal.app.thinkacademy.common.business.browser.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.linkedin.android.litr.MediaTransformer;
import com.linkedin.android.litr.TrackTransform;
import com.linkedin.android.litr.TransformationListener;
import com.linkedin.android.litr.codec.Encoder;
import com.linkedin.android.litr.codec.MediaCodecDecoder;
import com.linkedin.android.litr.codec.MediaCodecEncoder;
import com.linkedin.android.litr.io.MediaExtractorMediaSource;
import com.linkedin.android.litr.io.MediaMuxerMediaTarget;
import com.linkedin.android.litr.io.MediaRange;
import com.linkedin.android.litr.io.MediaSource;
import com.linkedin.android.litr.io.MediaTarget;
import com.linkedin.android.litr.render.AudioRenderer;
import com.linkedin.android.litr.render.GlVideoRenderer;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.model.videodata.AudioTrackFormat;
import com.tal.app.thinkacademy.common.base.model.videodata.MediaTrackFormat;
import com.tal.app.thinkacademy.common.base.model.videodata.VideoTrackFormat;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryCallbackBean;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryParam;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialogItemType;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.commui.widget.pad.PadAutoUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 ^2\u00020\u0001:\u0004^_`aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0010\u00101\u001a\u00020+2\u0006\u0010,\u001a\u000202H\u0002J\n\u00103\u001a\u0004\u0018\u00010\fH\u0002J\n\u00104\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\bH\u0002J \u00105\u001a\u00020$2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020$H\u0002J\n\u00109\u001a\u0004\u0018\u00010\"H\u0002J\u0018\u0010:\u001a\u00020 2\u0006\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\bH\u0002J\b\u0010;\u001a\u00020\bH\u0002J\b\u0010<\u001a\u00020'H\u0002J\b\u0010=\u001a\u00020'H\u0002J\b\u0010>\u001a\u00020\u0014H\u0002J\u0006\u0010?\u001a\u00020'J(\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0002J\u0010\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020$H\u0002J \u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020$2\u0006\u0010N\u001a\u00020 2\u0006\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020'H\u0002J\u000e\u0010Q\u001a\u00020'2\u0006\u0010R\u001a\u00020\u0010J\u0012\u0010Q\u001a\u00020'2\b\b\u0002\u0010S\u001a\u00020TH\u0002J\b\u0010U\u001a\u00020'H\u0002J\u0018\u0010V\u001a\u00020'2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010XH\u0002J$\u0010V\u001a\u00020'2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\b0X2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0XH\u0002J\u0018\u0010[\u001a\u00020'2\u000e\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010XH\u0002J\b\u0010\\\u001a\u00020'H\u0002J\b\u0010]\u001a\u00020'H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "listen", "Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$WebFileSelectModelCallBack;", "(Landroidx/fragment/app/FragmentActivity;Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$WebFileSelectModelCallBack;)V", "KEY_ROTATION", "", "mActivityWeak", "Ljava/lang/ref/WeakReference;", "mChooseDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicDialog;", "mCompressLoading", "Lcom/tal/app/thinkacademy/common/business/browser/view/VideoCompressLoading;", "mH5Param", "Lcom/tal/app/thinkacademy/common/entity/H5PhotoLibraryParam;", "mHandler", "Landroid/os/Handler;", "mIsCancelUpload", "", "mIsDestroy", "mOnResultListen", "Lcom/luck/picture/lib/listener/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "mSelectType", "Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$SelectType;", "mTransCodeRequestId", "mTranscodeFuture", "Ljava/util/concurrent/Future;", "Ljava/lang/Void;", "mTranscodeStartTime", "", "mUploadLoading", "Lcom/tal/app/thinkacademy/common/business/browser/view/VideoUploadLoadingDialog;", "mUploadSize", "", "mWebFileSelectListen", "cancelUpload", "", "choosePhoto", "chooseVideo", "createAudioMediaFormat", "Landroid/media/MediaFormat;", "trackFormat", "Lcom/tal/app/thinkacademy/common/base/model/videodata/AudioTrackFormat;", "createMediaFormat", "format", "Lcom/tal/app/thinkacademy/common/base/model/videodata/MediaTrackFormat;", "createVideoMediaFormat", "Lcom/tal/app/thinkacademy/common/base/model/videodata/VideoTrackFormat;", "getChooseDialog", "getCompressLoadingDialog", "getInt", "mediaFormat", "key", "defaultValue", "getLoading", "getLong", "getVideoCachePath", "hideCompressLoading", "hideLoading", "isCloseVideoCompress", "onDestroy", "realToVideoCompress", "name", "path", "destPath", "Lcom/linkedin/android/litr/TransformationListener;", "runOnUiThread", "runnable", "Ljava/lang/Runnable;", "sendJsCancel", "sendJsFailed", "setCompressProgress", "progress", "setProgress", "index", "bytesCurrent", "bytesTotal", "showCompressLoading", "showFileSelectDialog", "param", "itemType", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/ChoosePicDialogItemType;", "showLoading", "startUpload", "result", "", "arrayKeys", "arrayPaths", "startVideoCompress", "takePhoto", "takeVideo", "Companion", "SelectCallBackStatus", "SelectType", "WebFileSelectModelCallBack", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFileSelectModel.kt */
public final class WebFileSelectModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "WebFileSelectModel";
    private static final String VIDEO_CACHE_DATA_PATH = "tal_video_cache";
    private final String KEY_ROTATION;
    /* access modifiers changed from: private */
    public WeakReference<FragmentActivity> mActivityWeak;
    private ChoosePicDialog mChooseDialog;
    private VideoCompressLoading mCompressLoading;
    /* access modifiers changed from: private */
    public H5PhotoLibraryParam mH5Param;
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public boolean mIsCancelUpload;
    private boolean mIsDestroy;
    private OnResultCallbackListener<LocalMedia> mOnResultListen = ((OnResultCallbackListener) new WebFileSelectModel$mOnResultListen$1(this));
    /* access modifiers changed from: private */
    public SelectType mSelectType = SelectType.UNKNOWN;
    /* access modifiers changed from: private */
    public String mTransCodeRequestId;
    private Future<Void> mTranscodeFuture;
    /* access modifiers changed from: private */
    public long mTranscodeStartTime;
    private VideoUploadLoadingDialog mUploadLoading;
    private int mUploadSize;
    /* access modifiers changed from: private */
    public WebFileSelectModelCallBack mWebFileSelectListen;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$SelectType;", "", "(Ljava/lang/String;I)V", "CHOOSE_PHOTO", "TAKE_PHOTO", "TAKE_VIDEO", "CHOOSE_VIDEO", "UNKNOWN", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    private enum SelectType {
        CHOOSE_PHOTO,
        TAKE_PHOTO,
        TAKE_VIDEO,
        CHOOSE_VIDEO,
        UNKNOWN
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$WebFileSelectModelCallBack;", "", "jsCall", "", "jsStr", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    public interface WebFileSelectModelCallBack {
        void jsCall(String str);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectType.values().length];
            iArr[SelectType.CHOOSE_PHOTO.ordinal()] = 1;
            iArr[SelectType.TAKE_PHOTO.ordinal()] = 2;
            iArr[SelectType.TAKE_VIDEO.ordinal()] = 3;
            iArr[SelectType.CHOOSE_VIDEO.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$Companion;", "", "()V", "TAG", "", "VIDEO_CACHE_DATA_PATH", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public WebFileSelectModel(FragmentActivity fragmentActivity, WebFileSelectModelCallBack webFileSelectModelCallBack) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        this.mActivityWeak = new WeakReference<>(fragmentActivity);
        this.mWebFileSelectListen = webFileSelectModelCallBack;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mTransCodeRequestId = "requestId";
        int i = Build.VERSION.SDK_INT;
        this.KEY_ROTATION = "rotation-degrees";
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$SelectCallBackStatus;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAILED", "CANCEL", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    private enum SelectCallBackStatus {
        SUCCESS("1"),
        FAILED("2"),
        CANCEL(EnterRoomMuteData.STATUS_UN_MUTE);
        
        private final String value;

        private SelectCallBackStatus(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* access modifiers changed from: private */
    public final void runOnUiThread(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
            return;
        }
        Handler handler = this.mHandler;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }

    /* access modifiers changed from: private */
    public final boolean isCloseVideoCompress() {
        boolean areEqual = Intrinsics.areEqual("1", HwCloudControlHelper.Companion.get().getCloudKeyValue("isCloseVideoCompress"));
        XesLog.dt(TAG, Intrinsics.stringPlus("云控是否关闭视频压缩=", Boolean.valueOf(areEqual)));
        return areEqual;
    }

    /* access modifiers changed from: private */
    public final void cancelUpload() {
        this.mIsCancelUpload = true;
        XesLog.dt(TAG, "cancelUpload 手动点击 取消上传");
        sendJsCancel();
        hideLoading();
        AwsS3Util.INSTANCE.reset();
    }

    /* access modifiers changed from: private */
    public final VideoUploadLoadingDialog getLoading() {
        Unit unit = null;
        if (this.mIsDestroy) {
            return null;
        }
        Context context = (FragmentActivity) this.mActivityWeak.get();
        if (context != null) {
            if (this.mUploadLoading == null) {
                this.mUploadLoading = new VideoUploadLoadingDialog(context, new WebFileSelectModel$getLoading$1$1(this));
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "getLoading mActivityWeak.get() is null");
        }
        return this.mUploadLoading;
    }

    private final VideoCompressLoading getCompressLoadingDialog() {
        Unit unit = null;
        if (this.mIsDestroy) {
            return null;
        }
        Context context = (FragmentActivity) this.mActivityWeak.get();
        if (context != null) {
            if (this.mCompressLoading == null) {
                this.mCompressLoading = new VideoCompressLoading(context, WebFileSelectModel$getCompressLoadingDialog$1$1.INSTANCE);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "getLoading mActivityWeak.get() is null");
        }
        return this.mCompressLoading;
    }

    private final void showCompressLoading() {
        if (this.mActivityWeak.get() != null) {
            VideoCompressLoading compressLoadingDialog = getCompressLoadingDialog();
            if (compressLoadingDialog != null) {
                compressLoadingDialog.setProgress(0);
            }
            VideoCompressLoading compressLoadingDialog2 = getCompressLoadingDialog();
            if (compressLoadingDialog2 != null) {
                compressLoadingDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void hideCompressLoading() {
        VideoCompressLoading compressLoadingDialog;
        if (this.mActivityWeak.get() != null && (compressLoadingDialog = getCompressLoadingDialog()) != null) {
            compressLoadingDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void setCompressProgress(int i) {
        VideoCompressLoading compressLoadingDialog;
        if (!this.mIsDestroy && this.mActivityWeak.get() != null && (compressLoadingDialog = getCompressLoadingDialog()) != null) {
            compressLoadingDialog.setProgress(i);
        }
    }

    private final void showLoading() {
        if (this.mActivityWeak.get() != null) {
            this.mIsCancelUpload = false;
            int i = WhenMappings.$EnumSwitchMapping$0[this.mSelectType.ordinal()];
            if (i == 1 || i == 2) {
                VideoUploadLoadingDialog loading = getLoading();
                if (loading != null) {
                    loading.setUploadType(false);
                }
            } else if (i == 3 || i == 4) {
                VideoUploadLoadingDialog loading2 = getLoading();
                if (loading2 != null) {
                    loading2.setUploadType(true);
                }
            } else {
                VideoUploadLoadingDialog loading3 = getLoading();
                if (loading3 != null) {
                    loading3.setUploadType(false);
                }
            }
            VideoUploadLoadingDialog loading4 = getLoading();
            if (loading4 != null) {
                loading4.setProgress(0);
            }
            VideoUploadLoadingDialog loading5 = getLoading();
            if (loading5 != null) {
                loading5.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        VideoUploadLoadingDialog loading;
        if (this.mActivityWeak.get() != null && (loading = getLoading()) != null) {
            loading.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void setProgress(int i, long j, long j2) {
        VideoUploadLoadingDialog loading;
        if (this.mActivityWeak.get() != null && (loading = getLoading()) != null) {
            int i2 = 0;
            int i3 = this.mUploadSize;
            if (i3 > 1) {
                i2 = ((i + 1) * 100) / i3;
            } else if (j2 > 0) {
                i2 = (int) ((j * ((long) 100)) / j2);
            }
            loading.setProgress(i2);
        }
    }

    private final ChoosePicDialog getChooseDialog() {
        Unit unit = null;
        if (this.mIsDestroy) {
            return null;
        }
        Context context = (FragmentActivity) this.mActivityWeak.get();
        if (context != null) {
            if (this.mChooseDialog == null) {
                ChoosePicDialog choosePicDialog = new ChoosePicDialog(context, (Function1<? super ChoosePicType, Unit>) new WebFileSelectModel$getChooseDialog$1$1(this));
                this.mChooseDialog = choosePicDialog;
                choosePicDialog.setDismissListener(new WebFileSelectModel$$ExternalSyntheticLambda0(this));
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "getChooseDialog mActivityWeak.get() is null");
        }
        return this.mChooseDialog;
    }

    /* access modifiers changed from: private */
    /* renamed from: getChooseDialog$lambda-7$lambda-6$lambda-5  reason: not valid java name */
    public static final void m33getChooseDialog$lambda7$lambda6$lambda5(WebFileSelectModel webFileSelectModel) {
        Intrinsics.checkNotNullParameter(webFileSelectModel, "this$0");
        if (webFileSelectModel.mSelectType == SelectType.UNKNOWN) {
            webFileSelectModel.sendJsCancel();
            XesLog.it(TAG, "未选择任何文件，直接取消了。。。");
        }
    }

    public final void showFileSelectDialog(H5PhotoLibraryParam h5PhotoLibraryParam) {
        Intrinsics.checkNotNullParameter(h5PhotoLibraryParam, "param");
        this.mH5Param = h5PhotoLibraryParam;
        if (((FragmentActivity) this.mActivityWeak.get()) != null) {
            if (h5PhotoLibraryParam.getAccept() == 0) {
                showFileSelectDialog(ChoosePicDialogItemType.ALL);
            } else {
                showFileSelectDialog(ChoosePicDialogItemType.IMAGE);
            }
        }
    }

    static /* synthetic */ void showFileSelectDialog$default(WebFileSelectModel webFileSelectModel, ChoosePicDialogItemType choosePicDialogItemType, int i, Object obj) {
        if ((i & 1) != 0) {
            choosePicDialogItemType = ChoosePicDialogItemType.ALL;
        }
        webFileSelectModel.showFileSelectDialog(choosePicDialogItemType);
    }

    private final void showFileSelectDialog(ChoosePicDialogItemType choosePicDialogItemType) {
        Unit unit;
        this.mSelectType = SelectType.UNKNOWN;
        ChoosePicDialog chooseDialog = getChooseDialog();
        if (chooseDialog == null) {
            unit = null;
        } else {
            chooseDialog.setItemType(choosePicDialogItemType);
            chooseDialog.show();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "showFileSelectDialog mActivityWeak.get() is null");
        }
    }

    /* access modifiers changed from: private */
    public final void takePhoto() {
        Unit unit;
        Activity activity = (FragmentActivity) this.mActivityWeak.get();
        if (activity == null) {
            unit = null;
        } else {
            this.mSelectType = SelectType.TAKE_PHOTO;
            PictureSelectorHelper.takePhoto$default(PictureSelectorHelper.Companion.getInstance(), activity, 0, false, false, 0, this.mOnResultListen, 22, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "takePhoto mActivityWeak.get() is null");
        }
    }

    /* access modifiers changed from: private */
    public final void choosePhoto() {
        Unit unit;
        int i = (PadAutoUtil.isCloseScreenLandscape() || !PadUtils.isPad(Utils.getApp())) ? 1 : 0;
        Activity activity = (FragmentActivity) this.mActivityWeak.get();
        if (activity == null) {
            unit = null;
        } else {
            this.mSelectType = SelectType.CHOOSE_PHOTO;
            PictureSelectorHelper instance = PictureSelectorHelper.Companion.getInstance();
            H5PhotoLibraryParam h5PhotoLibraryParam = this.mH5Param;
            PictureSelectorHelper.choosePhoto$default(instance, activity, h5PhotoLibraryParam == null ? 9 : h5PhotoLibraryParam.getPhotosNumber(), false, false, i, this.mOnResultListen, 4, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "takePhoto mActivityWeak.get() is null");
        }
    }

    /* access modifiers changed from: private */
    public final void takeVideo() {
        Unit unit;
        Activity activity = (FragmentActivity) this.mActivityWeak.get();
        if (activity == null) {
            unit = null;
        } else {
            this.mSelectType = SelectType.TAKE_VIDEO;
            PictureSelectorHelper.takeVideo$default(PictureSelectorHelper.Companion.getInstance(), activity, 120, 1, false, false, 0, this.mOnResultListen, 40, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "takeVideo mActivityWeak.get() is null");
        }
    }

    /* access modifiers changed from: private */
    public final void chooseVideo() {
        Unit unit;
        int i = (PadAutoUtil.isCloseScreenLandscape() || !PadUtils.isPad(Utils.getApp())) ? 1 : 0;
        Activity activity = (FragmentActivity) this.mActivityWeak.get();
        if (activity == null) {
            unit = null;
        } else {
            this.mSelectType = SelectType.CHOOSE_VIDEO;
            PictureSelectorHelper instance = PictureSelectorHelper.Companion.getInstance();
            H5PhotoLibraryParam h5PhotoLibraryParam = this.mH5Param;
            PictureSelectorHelper.chooseVideo$default(instance, activity, h5PhotoLibraryParam == null ? 1 : h5PhotoLibraryParam.getVideoNumber(), false, false, i, this.mOnResultListen, 4, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            WebFileSelectModel webFileSelectModel = this;
            XesLog.it(TAG, "chooseVideo mActivityWeak.get() is null");
        }
    }

    private final String getVideoCachePath() {
        File file = new File(PathUtils.getInternalAppFilesPath(), VIDEO_CACHE_DATA_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "mWorkSpaceDir.absolutePath");
        return absolutePath;
    }

    /* access modifiers changed from: private */
    public final void startVideoCompress(List<LocalMedia> list) {
        if (this.mActivityWeak.get() != null) {
            Unit unit = null;
            if (list != null) {
                if (list.size() == 1) {
                    LocalMedia localMedia = list.get(0);
                    String originalPath = localMedia.getOriginalPath();
                    if (TextUtils.isEmpty(originalPath)) {
                        originalPath = localMedia.getRealPath();
                    }
                    if (originalPath != null) {
                        File file = new File(originalPath);
                        String str = getVideoCachePath() + File.separator + "cache_" + System.currentTimeMillis() + '_' + file.getName();
                        showCompressLoading();
                        this.mTranscodeStartTime = System.currentTimeMillis();
                        String name = file.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "originFile.name");
                        realToVideoCompress(name, originalPath, str, new WebFileSelectModel$startVideoCompress$1$1$1(this, str, localMedia, file, list));
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        WebFileSelectModel webFileSelectModel = this;
                        startUpload(list);
                    }
                } else {
                    startUpload(list);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                WebFileSelectModel webFileSelectModel2 = this;
                XesLog.it(TAG, "startVideoCompress result is null");
                sendJsFailed();
            }
        }
    }

    private final void realToVideoCompress(String str, String str2, String str3, TransformationListener transformationListener) {
        int i;
        TransformationListener transformationListener2 = transformationListener;
        if (this.mActivityWeak.get() != null) {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.mTransCodeRequestId = uuid;
            List<MediaTrackFormat> arrayList = new ArrayList<>();
            try {
                MediaExtractor mediaExtractor = new MediaExtractor();
                mediaExtractor.setDataSource(Utils.getApp(), Uri.parse(str2), (Map) null);
                int trackCount = mediaExtractor.getTrackCount();
                int i2 = 0;
                while (i2 < trackCount) {
                    int i3 = i2 + 1;
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
                    Intrinsics.checkNotNullExpressionValue(trackFormat, "mediaExtractor.getTrackFormat(track)");
                    String string = trackFormat.getString("mime");
                    if (string != null) {
                        if (StringsKt.startsWith$default(string, "video", false, 2, (Object) null)) {
                            VideoTrackFormat videoTrackFormat = new VideoTrackFormat(i2, string);
                            videoTrackFormat.width = getInt(trackFormat, "width");
                            videoTrackFormat.height = getInt(trackFormat, "height");
                            videoTrackFormat.duration = getLong(trackFormat, "durationUs");
                            videoTrackFormat.frameRate = 20;
                            videoTrackFormat.keyFrameInterval = 3;
                            videoTrackFormat.rotation = getInt(trackFormat, this.KEY_ROTATION, 0);
                            videoTrackFormat.bitrate = 3145728;
                            arrayList.add(videoTrackFormat);
                        } else if (StringsKt.startsWith$default(string, "audio", false, 2, (Object) null)) {
                            AudioTrackFormat audioTrackFormat = new AudioTrackFormat(i2, string);
                            audioTrackFormat.channelCount = getInt(trackFormat, "channel-count");
                            audioTrackFormat.samplingRate = getInt(trackFormat, "sample-rate");
                            audioTrackFormat.duration = getLong(trackFormat, "durationUs");
                            audioTrackFormat.bitrate = getInt(trackFormat, "bitrate");
                            arrayList.add(audioTrackFormat);
                        }
                    }
                    i2 = i3;
                }
                if (arrayList.size() < 1) {
                    XesLog.dt(TAG, "轨道数为0");
                    transformationListener2.onError(this.mTransCodeRequestId, new Exception("没有合适的轨道"), (List) null);
                    return;
                }
                try {
                    File file = new File(str3);
                    if (file.exists()) {
                        file.delete();
                    }
                    MediaTransformer mediaTransformer = new MediaTransformer(Utils.getApp());
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            i = 0;
                            break;
                        }
                        MediaTrackFormat mediaTrackFormat = (MediaTrackFormat) it.next();
                        String str4 = mediaTrackFormat.mimeType;
                        Intrinsics.checkNotNullExpressionValue(str4, "trackFormat.mimeType");
                        if (StringsKt.startsWith$default(str4, "video", false, 2, (Object) null)) {
                            i = ((VideoTrackFormat) mediaTrackFormat).rotation;
                            break;
                        }
                    }
                    MediaTarget mediaMuxerMediaTarget = new MediaMuxerMediaTarget(Utils.getApp(), Uri.fromFile(file), arrayList.size(), i, 0);
                    List arrayList2 = new ArrayList();
                    MediaSource mediaExtractorMediaSource = new MediaExtractorMediaSource(Utils.getApp(), Uri.parse(str2), new MediaRange(0, Long.MAX_VALUE));
                    for (MediaTrackFormat mediaTrackFormat2 : arrayList) {
                        Encoder mediaCodecEncoder = new MediaCodecEncoder();
                        TrackTransform.Builder decoder = new TrackTransform.Builder(mediaExtractorMediaSource, mediaTrackFormat2.index, mediaMuxerMediaTarget).setTargetTrack(arrayList2.size()).setTargetFormat(createMediaFormat(mediaTrackFormat2)).setEncoder(mediaCodecEncoder).setDecoder(new MediaCodecDecoder());
                        Intrinsics.checkNotNullExpressionValue(decoder, "Builder(mediaSource,\n   …oder(MediaCodecDecoder())");
                        if (mediaTrackFormat2 instanceof VideoTrackFormat) {
                            decoder.setRenderer(new GlVideoRenderer((List) null));
                        } else if (mediaTrackFormat2 instanceof AudioTrackFormat) {
                            decoder.setRenderer(new AudioRenderer(mediaCodecEncoder, (List) null));
                        }
                        TrackTransform build = decoder.build();
                        Intrinsics.checkNotNullExpressionValue(build, "trackTransformBuilder.build()");
                        arrayList2.add(build);
                    }
                    mediaTransformer.transform(this.mTransCodeRequestId, arrayList2, transformationListener2, 100);
                } catch (Exception e) {
                    XesLog.dt(TAG, "启动失败", e);
                    transformationListener2.onError(this.mTransCodeRequestId, e, (List) null);
                }
            } catch (Exception e2) {
                XesLog.dt(TAG, "MediaExtractor解析要压缩的文件失败=", e2);
                transformationListener2.onError(this.mTransCodeRequestId, e2, (List) null);
            }
        }
    }

    private final int getInt(MediaFormat mediaFormat, String str) {
        return getInt(mediaFormat, str, -1);
    }

    private final int getInt(MediaFormat mediaFormat, String str, int i) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
    }

    private final long getLong(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getLong(str);
        }
        return -1;
    }

    private final MediaFormat createMediaFormat(MediaTrackFormat mediaTrackFormat) {
        new MediaFormat();
        MediaFormat mediaFormat = new MediaFormat();
        if (mediaTrackFormat instanceof VideoTrackFormat) {
            return createVideoMediaFormat((VideoTrackFormat) mediaTrackFormat);
        }
        return mediaTrackFormat instanceof AudioTrackFormat ? createAudioMediaFormat((AudioTrackFormat) mediaTrackFormat) : mediaFormat;
    }

    private final MediaFormat createVideoMediaFormat(VideoTrackFormat videoTrackFormat) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "video/avc");
        int i = videoTrackFormat.width;
        int i2 = videoTrackFormat.height;
        if (i >= i2) {
            if (i > 1920) {
                i2 = (i2 * 1920) / i;
                if (i2 % 2 != 0) {
                    i2--;
                }
                i = 1920;
            }
        } else if (i2 > i) {
            i = (i * 1920) / i2;
            if (i % 2 != 0) {
                i--;
            }
            i2 = 1920;
        }
        XesLog.dt(TAG, "目标压缩文件width=" + i + ",height=" + i2);
        mediaFormat.setInteger("width", i);
        mediaFormat.setInteger("height", i2);
        mediaFormat.setInteger("bitrate", videoTrackFormat.bitrate);
        mediaFormat.setInteger("i-frame-interval", videoTrackFormat.keyFrameInterval);
        mediaFormat.setInteger("frame-rate", videoTrackFormat.frameRate);
        mediaFormat.setLong("durationUs", videoTrackFormat.duration);
        mediaFormat.setInteger(this.KEY_ROTATION, videoTrackFormat.rotation);
        return mediaFormat;
    }

    private final MediaFormat createAudioMediaFormat(AudioTrackFormat audioTrackFormat) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", audioTrackFormat.mimeType);
        mediaFormat.setInteger("channel-count", audioTrackFormat.channelCount);
        mediaFormat.setInteger("sample-rate", audioTrackFormat.samplingRate);
        mediaFormat.setInteger("bitrate", audioTrackFormat.bitrate);
        mediaFormat.setLong("durationUs", audioTrackFormat.duration);
        return mediaFormat;
    }

    /* access modifiers changed from: private */
    public final void startUpload(List<LocalMedia> list) {
        boolean z;
        String str;
        if (this.mActivityWeak.get() != null) {
            AwsS3Util.INSTANCE.reset();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            if (list != null) {
                int i = 0;
                for (Object next : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    LocalMedia localMedia = (LocalMedia) next;
                    if (TextUtils.isEmpty(localMedia.getCompressPath())) {
                        if (TextUtils.isEmpty(localMedia.getOriginalPath())) {
                            str = localMedia.getRealPath();
                            Intrinsics.checkNotNullExpressionValue(str, "localMedia.realPath");
                        } else {
                            str = localMedia.getOriginalPath();
                            Intrinsics.checkNotNullExpressionValue(str, "localMedia.originalPath");
                        }
                        z = false;
                    } else {
                        str = localMedia.getCompressPath();
                        Intrinsics.checkNotNullExpressionValue(str, "localMedia.compressPath");
                        z = true;
                    }
                    File file = new File(str);
                    String str2 = i + '_' + System.currentTimeMillis() + '_' + file.getName();
                    arrayList.add(str2);
                    arrayList2.add(str);
                    XesLog.dt(TAG, "startUpload key = " + str2 + ",isCompress=" + z + ",path=" + str);
                    i = i2;
                }
            }
            startUpload(arrayList, arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public final void startUpload(List<String> list, List<String> list2) {
        if (this.mActivityWeak.get() != null) {
            if (list.size() >= 0) {
                this.mUploadSize = list.size();
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    XesLog.dt(TAG, "startUpload 主线程");
                } else {
                    XesLog.dt(TAG, "startUpload 子线程");
                }
                showLoading();
                AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
                Application app = Utils.getApp();
                Intrinsics.checkNotNullExpressionValue(app, "getApp()");
                awsS3Util.uploadFilesWithPaths(app, AwsS3Util.scene_homework, list, list2, new WebFileSelectModel$startUpload$2(this));
                return;
            }
            XesLog.dt(TAG, "返回数据为空，无法上传");
            sendJsFailed();
        }
    }

    /* access modifiers changed from: private */
    public final void sendJsFailed() {
        String queId;
        if (this.mActivityWeak.get() != null) {
            H5PhotoLibraryCallbackBean h5PhotoLibraryCallbackBean = new H5PhotoLibraryCallbackBean((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
            h5PhotoLibraryCallbackBean.setStatus(SelectCallBackStatus.FAILED.getValue());
            H5PhotoLibraryParam h5PhotoLibraryParam = this.mH5Param;
            String str = "";
            if (!(h5PhotoLibraryParam == null || (queId = h5PhotoLibraryParam.getQueId()) == null)) {
                str = queId;
            }
            h5PhotoLibraryCallbackBean.setQueId(str);
            try {
                WebFileSelectModelCallBack webFileSelectModelCallBack = this.mWebFileSelectListen;
                if (webFileSelectModelCallBack != null) {
                    String json = GsonUtils.toJson(h5PhotoLibraryCallbackBean);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(callBackBean)");
                    webFileSelectModelCallBack.jsCall(json);
                }
            } catch (Exception e) {
                XesLog.dt(TAG, Intrinsics.stringPlus("sendJsFailed，error=", e));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void sendJsCancel() {
        String queId;
        if (this.mActivityWeak.get() != null) {
            H5PhotoLibraryCallbackBean h5PhotoLibraryCallbackBean = new H5PhotoLibraryCallbackBean((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
            h5PhotoLibraryCallbackBean.setStatus(SelectCallBackStatus.CANCEL.getValue());
            H5PhotoLibraryParam h5PhotoLibraryParam = this.mH5Param;
            String str = "";
            if (!(h5PhotoLibraryParam == null || (queId = h5PhotoLibraryParam.getQueId()) == null)) {
                str = queId;
            }
            h5PhotoLibraryCallbackBean.setQueId(str);
            try {
                WebFileSelectModelCallBack webFileSelectModelCallBack = this.mWebFileSelectListen;
                if (webFileSelectModelCallBack != null) {
                    String json = GsonUtils.toJson(h5PhotoLibraryCallbackBean);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(callBackBean)");
                    webFileSelectModelCallBack.jsCall(json);
                }
            } catch (Exception e) {
                XesLog.dt(TAG, Intrinsics.stringPlus("sendJsFailed，error=", e));
            }
        }
    }

    public final void onDestroy() {
        this.mIsDestroy = true;
        Future<Void> future = this.mTranscodeFuture;
        if (future != null) {
            future.cancel(true);
        }
        this.mTranscodeFuture = null;
        this.mWebFileSelectListen = null;
        this.mChooseDialog = null;
        this.mCompressLoading = null;
        this.mUploadLoading = null;
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
