package com.tal.app.thinkacademy.common.business.browser.view;

import com.linkedin.android.litr.TransformationListener;
import com.linkedin.android.litr.analytics.TrackTransformationInfo;
import com.luck.picture.lib.entity.LocalMedia;
import com.tal.app.thinkacademy.common.track.CommonTrack;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$startVideoCompress$1$1$1", "Lcom/linkedin/android/litr/TransformationListener;", "onCancelled", "", "id", "", "trackTransformationInfos", "", "Lcom/linkedin/android/litr/analytics/TrackTransformationInfo;", "onCompleted", "onError", "cause", "", "onProgress", "progress", "", "onStarted", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFileSelectModel.kt */
public final class WebFileSelectModel$startVideoCompress$1$1$1 implements TransformationListener {
    final /* synthetic */ String $cacheVideo;
    final /* synthetic */ LocalMedia $localMedia;
    final /* synthetic */ File $originFile;
    final /* synthetic */ List<LocalMedia> $result;
    final /* synthetic */ WebFileSelectModel this$0;

    WebFileSelectModel$startVideoCompress$1$1$1(WebFileSelectModel webFileSelectModel, String str, LocalMedia localMedia, File file, List<LocalMedia> list) {
        this.this$0 = webFileSelectModel;
        this.$cacheVideo = str;
        this.$localMedia = localMedia;
        this.$originFile = file;
        this.$result = list;
    }

    public void onStarted(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        XesLog.it("WebFileSelectModel", Intrinsics.stringPlus("开始压缩： id = ", str));
    }

    public void onProgress(String str, float f) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (Intrinsics.areEqual(this.this$0.mTransCodeRequestId, str)) {
            XesLog.it("WebFileSelectModel", Intrinsics.stringPlus("压缩进度： ", Float.valueOf(f)));
            this.this$0.setCompressProgress((int) (f * ((float) 100)));
        }
    }

    public void onCompleted(String str, List<TrackTransformationInfo> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        XesLog.it("WebFileSelectModel", Intrinsics.stringPlus("视频压缩成功 id = ", str));
        if (Intrinsics.areEqual(this.this$0.mTransCodeRequestId, str)) {
            this.this$0.setCompressProgress(100);
            this.this$0.hideCompressLoading();
            XesLog.it("WebFileSelectModel", "视频压缩成功 onSuccess");
            if (FileUtils.isFileExists(this.$cacheVideo)) {
                CommonTrack.hw_video_compress_state$default(CommonTrack.INSTANCE, true, System.currentTimeMillis() - this.this$0.mTranscodeStartTime, this.$localMedia.getSize(), (String) null, 8, (Object) null);
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                XesLog.it("WebFileSelectModel", Intrinsics.stringPlus("视频压缩成功 videoPath=", this.$cacheVideo));
                arrayList2.add(this.$cacheVideo);
                arrayList.add("cacheVideo_" + System.currentTimeMillis() + '_' + this.$originFile.getName());
                this.this$0.startUpload(arrayList, arrayList2);
                return;
            }
            CommonTrack.INSTANCE.hw_video_compress_state(false, System.currentTimeMillis() - this.this$0.mTranscodeStartTime, this.$localMedia.getSize(), "压缩成功，但是文件不存在");
            XesLog.it("WebFileSelectModel", "视频压缩后的文件不存在，直接上传");
            this.this$0.startUpload(this.$result);
        }
    }

    public void onCancelled(String str, List<TrackTransformationInfo> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        XesLog.it("WebFileSelectModel", Intrinsics.stringPlus("压缩取消了,id=", str));
        Intrinsics.areEqual(this.this$0.mTransCodeRequestId, str);
    }

    public void onError(String str, Throwable th, List<TrackTransformationInfo> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        XesLog.it("WebFileSelectModel", "压缩失败,id = " + str + ", onFail:=" + th);
        if (Intrinsics.areEqual(this.this$0.mTransCodeRequestId, str)) {
            CommonTrack.INSTANCE.hw_video_compress_state(false, System.currentTimeMillis() - this.this$0.mTranscodeStartTime, this.$localMedia.getSize(), String.valueOf(th));
            this.this$0.hideCompressLoading();
            this.this$0.startUpload(this.$result);
        }
    }
}
