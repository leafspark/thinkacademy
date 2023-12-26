package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriverKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¨\u0006\u0016"}, d2 = {"com/tal/app/thinkacademy/live/business/interactivegames/activity/GameViewModel$uploadPic$1", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiTransferListener;", "onError", "", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "names", "", "", "result", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameViewModel.kt */
public final class GameViewModel$uploadPic$1 implements AwsS3Util.MultiTransferListener {
    final /* synthetic */ GameChannelBean $bean;
    final /* synthetic */ int $classId;
    final /* synthetic */ Context $context;
    final /* synthetic */ GameJsSubmitData $data;
    final /* synthetic */ GameViewModel this$0;

    public void onProgressChanged(int i, int i2, long j, long j2) {
    }

    public void onStateChanged(int i, int i2, TransferState transferState) {
    }

    GameViewModel$uploadPic$1(GameViewModel gameViewModel, Context context, GameJsSubmitData gameJsSubmitData, GameChannelBean gameChannelBean, int i) {
        this.this$0 = gameViewModel;
        this.$context = context;
        this.$data = gameJsSubmitData;
        this.$bean = gameChannelBean;
        this.$classId = i;
    }

    public void onUploadSuccess(List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(list, "names");
        Intrinsics.checkNotNullParameter(list2, "result");
        XesLog.s(this.this$0.TAG, "图片上传成功");
        FileUtils.deleteAllInDir(AppCacheUtil.getPhotosDir(this.$context) + File.separator + GamePluginDriverKt.GAMEPIC);
        this.this$0.packSubmitAsyncGameData(this.$data, this.$bean, this.$classId, list);
    }

    public void onError(int i, int i2, Exception exc) {
        XesLogTag access$getTAG$p = this.this$0.TAG;
        Object[] objArr = new Object[1];
        objArr[0] = Intrinsics.stringPlus("图片上传失败 ---> ", exc == null ? null : exc.getMessage());
        XesLog.e(access$getTAG$p, objArr);
        FileUtils.deleteAllInDir(AppCacheUtil.getPhotosDir(this.$context) + File.separator + GamePluginDriverKt.GAMEPIC);
        GameViewModel.packSubmitAsyncGameData$default(this.this$0, this.$data, this.$bean, this.$classId, (List) null, 8, (Object) null);
    }
}
