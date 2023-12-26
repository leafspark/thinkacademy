package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.driver.PhotosUploadResult;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/PreviewActivity$photoSubmit$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewActivity.kt */
public final class PreviewActivity$photoSubmit$1 extends OmyCallback<HiResponse<PhotoSubmitResult>> {
    final /* synthetic */ PreviewActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreviewActivity$photoSubmit$1(PreviewActivity previewActivity, PreviewActivity$photoSubmit$2 previewActivity$photoSubmit$2) {
        super(previewActivity$photoSubmit$2);
        this.this$0 = previewActivity;
    }

    public void onSuccess(HiResponse<PhotoSubmitResult> hiResponse) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        if (!this.this$0.isOnDestroy) {
            SoundPoolUtils.play((Context) this.this$0, R.raw.live_business_take_photo_submit, 0);
            this.this$0.track(LeanplumUtil.success_result_photowall);
            PhotoSubmitResult data = hiResponse.getData();
            if (data != null) {
                PreviewActivity previewActivity = this.this$0;
                data.setPhotoSubmissionResult(PhotosUploadResult.SubmittedSuccessfully);
                PhotosMaintainData access$getMPhotosMaintainData$p = previewActivity.mPhotosMaintainData;
                if (access$getMPhotosMaintainData$p == null || (z = access$getMPhotosMaintainData$p.isCorrection()) == null) {
                    z = false;
                }
                data.setCorrection(z);
                XesDataBus.with(DataBusKey.PHOTO_SUBMISSION_RESULT).postStickyData(data);
            }
            XesLogTag access$getTAG$p = this.this$0.TAG;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("photoSubmit---> onSuccess, userLatestCoin=");
            String str2 = null;
            sb.append(data == null ? null : Integer.valueOf(data.getUserLatestCoin()));
            sb.append(", rightCoin=");
            sb.append(data == null ? null : Integer.valueOf(data.getRightCoin()));
            objArr[0] = sb.toString();
            XesLog.i(access$getTAG$p, objArr);
            PhotosMaintainData access$getMPhotosMaintainData$p2 = this.this$0.mPhotosMaintainData;
            if (access$getMPhotosMaintainData$p2 != null) {
                str2 = access$getMPhotosMaintainData$p2.getInteractId();
            }
            InteractReportKt.XesLogReport$default("uploadImage", "Photopost", str2, 1, (String) null, 16, (Object) null);
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            PhotosMaintainData access$getMPhotosMaintainData$p3 = this.this$0.mPhotosMaintainData;
            String str3 = "";
            if (access$getMPhotosMaintainData$p3 == null || (str = access$getMPhotosMaintainData$p3.getInteractId()) == null) {
                str = str3;
            }
            String access$getPicAbsPath$p = this.this$0.picAbsPath;
            if (access$getPicAbsPath$p != null) {
                str3 = access$getPicAbsPath$p;
            }
            hWEventTracking.ostaIaPhotowallSubmit(str, str3);
            this.this$0.finish();
        }
    }
}
