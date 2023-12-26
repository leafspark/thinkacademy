package com.tal.app.thinkacademy.common.business.browser.view;

import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.aws.MultiTransfer;
import com.tal.app.thinkacademy.common.business.browser.view.WebFileSelectModel;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryCallbackBean;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryParam;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¨\u0006\u0013"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$startUpload$2", "Lcom/tal/app/thinkacademy/common/aws/MultiTransfer;", "onError", "", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onUploadSuccess", "names", "", "", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFileSelectModel.kt */
public final class WebFileSelectModel$startUpload$2 extends MultiTransfer {
    final /* synthetic */ WebFileSelectModel this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebFileSelectModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WebFileSelectModel.SelectType.values().length];
            iArr[WebFileSelectModel.SelectType.CHOOSE_PHOTO.ordinal()] = 1;
            iArr[WebFileSelectModel.SelectType.TAKE_PHOTO.ordinal()] = 2;
            iArr[WebFileSelectModel.SelectType.TAKE_VIDEO.ordinal()] = 3;
            iArr[WebFileSelectModel.SelectType.CHOOSE_VIDEO.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    WebFileSelectModel$startUpload$2(WebFileSelectModel webFileSelectModel) {
        this.this$0 = webFileSelectModel;
    }

    public void onUploadSuccess(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "names");
        Intrinsics.checkNotNullParameter(list2, "result");
        WebFileSelectModel webFileSelectModel = this.this$0;
        webFileSelectModel.runOnUiThread(new WebFileSelectModel$startUpload$2$$ExternalSyntheticLambda2(webFileSelectModel, list, list2));
    }

    /* access modifiers changed from: private */
    /* renamed from: onUploadSuccess$lambda-4  reason: not valid java name */
    public static final void m36onUploadSuccess$lambda4(WebFileSelectModel webFileSelectModel, List list, List list2) {
        String queId;
        List list3 = list;
        List list4 = list2;
        Intrinsics.checkNotNullParameter(webFileSelectModel, "this$0");
        Intrinsics.checkNotNullParameter(list3, "$names");
        Intrinsics.checkNotNullParameter(list4, "$result");
        if (((FragmentActivity) webFileSelectModel.mActivityWeak.get()) != null) {
            XesLog.dt("WebFileSelectModel", "onUploadSuccess names = " + list.size() + ",result=" + list2.size() + ",ThreadName=" + Thread.currentThread().getName());
            int i = 0;
            for (Object next : list3) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                XesLog.dt("WebFileSelectModel", "onUploadSuccess names[" + i + "] = " + ((String) next));
                i = i2;
            }
            H5PhotoLibraryCallbackBean h5PhotoLibraryCallbackBean = new H5PhotoLibraryCallbackBean((String) null, (String) null, (String) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
            h5PhotoLibraryCallbackBean.setStatus(WebFileSelectModel.SelectCallBackStatus.SUCCESS.getValue());
            H5PhotoLibraryParam access$getMH5Param$p = webFileSelectModel.mH5Param;
            String str = "";
            if (!(access$getMH5Param$p == null || (queId = access$getMH5Param$p.getQueId()) == null)) {
                str = queId;
            }
            h5PhotoLibraryCallbackBean.setQueId(str);
            int i3 = WhenMappings.$EnumSwitchMapping$0[webFileSelectModel.mSelectType.ordinal()];
            if (i3 == 1 || i3 == 2) {
                h5PhotoLibraryCallbackBean.setPhotoList(new ArrayList());
                int i4 = 0;
                for (Object next2 : list4) {
                    int i5 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) next2;
                    List<String> photoList = h5PhotoLibraryCallbackBean.getPhotoList();
                    if (photoList != null) {
                        photoList.add(str2);
                    }
                    XesLog.dt("WebFileSelectModel", "onUploadSuccess result[" + i4 + "] = " + str2);
                    i4 = i5;
                }
            } else if (i3 == 3 || i3 == 4) {
                h5PhotoLibraryCallbackBean.setVideoList(new ArrayList());
                int i6 = 0;
                for (Object next3 : list4) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String str3 = (String) next3;
                    List<String> videoList = h5PhotoLibraryCallbackBean.getVideoList();
                    if (videoList != null) {
                        videoList.add(str3);
                    }
                    XesLog.dt("WebFileSelectModel", "onUploadSuccess result[" + i6 + "] = " + str3);
                    i6 = i7;
                }
            }
            if (!webFileSelectModel.mIsCancelUpload) {
                try {
                    WebFileSelectModel.WebFileSelectModelCallBack access$getMWebFileSelectListen$p = webFileSelectModel.mWebFileSelectListen;
                    if (access$getMWebFileSelectListen$p != null) {
                        String json = GsonUtils.toJson(h5PhotoLibraryCallbackBean);
                        Intrinsics.checkNotNullExpressionValue(json, "toJson(callBackBean)");
                        access$getMWebFileSelectListen$p.jsCall(json);
                    }
                } catch (Exception e) {
                    XesLog.dt("WebFileSelectModel", Intrinsics.stringPlus("onUploadSuccess mWebFileSelectListen jsCall error=", e));
                }
            } else {
                XesLog.dt("WebFileSelectModel", "已经取消上传了。。。。");
            }
            webFileSelectModel.hideLoading();
            VideoUploadLoadingDialog access$getLoading = webFileSelectModel.getLoading();
            if (access$getLoading != null) {
                access$getLoading.setProgress(100);
            }
            AwsS3Util.INSTANCE.reset();
            if (!webFileSelectModel.mIsCancelUpload) {
                ToastUtils.showLong(R.string.file_upload_success);
            }
        }
    }

    public void onProgressChanged(int i, int i2, long j, long j2) {
        WebFileSelectModel webFileSelectModel = this.this$0;
        webFileSelectModel.runOnUiThread(new WebFileSelectModel$startUpload$2$$ExternalSyntheticLambda0(webFileSelectModel, i, j, j2));
    }

    /* access modifiers changed from: private */
    /* renamed from: onProgressChanged$lambda-6  reason: not valid java name */
    public static final void m35onProgressChanged$lambda6(WebFileSelectModel webFileSelectModel, int i, long j, long j2) {
        Intrinsics.checkNotNullParameter(webFileSelectModel, "this$0");
        if (((FragmentActivity) webFileSelectModel.mActivityWeak.get()) != null) {
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                XesLog.dt("WebFileSelectModel", " onProgressChanged startUpload 子线程");
            }
            webFileSelectModel.setProgress(i, j, j2);
        }
    }

    public void onError(int i, int i2, Exception exc) {
        XesLog.dt("WebFileSelectModel", "上传出错，currentIndex=" + i + ",id=" + i2 + ",exception=" + exc + ",threadName=" + Thread.currentThread().getName());
        WebFileSelectModel webFileSelectModel = this.this$0;
        webFileSelectModel.runOnUiThread(new WebFileSelectModel$startUpload$2$$ExternalSyntheticLambda1(webFileSelectModel, exc));
    }

    /* access modifiers changed from: private */
    /* renamed from: onError$lambda-8  reason: not valid java name */
    public static final void m34onError$lambda8(WebFileSelectModel webFileSelectModel, Exception exc) {
        Intrinsics.checkNotNullParameter(webFileSelectModel, "this$0");
        FragmentActivity fragmentActivity = (FragmentActivity) webFileSelectModel.mActivityWeak.get();
        if (fragmentActivity != null) {
            webFileSelectModel.sendJsFailed();
            webFileSelectModel.hideLoading();
            if (!webFileSelectModel.mIsCancelUpload) {
                ToastUtils.showLong(fragmentActivity.getString(R.string.file_upload_failed) + ':' + exc, new Object[0]);
            }
            AwsS3Util.INSTANCE.reset();
        }
    }
}
