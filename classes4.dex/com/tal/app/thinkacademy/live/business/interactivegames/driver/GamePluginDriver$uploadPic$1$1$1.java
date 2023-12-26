package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.Base64Util;
import com.tal.app.thinkacademy.lib.util.FileIOUtils;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "isHave", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePluginDriver.kt */
final class GamePluginDriver$uploadPic$1$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ GameJsSubmitData $data;
    final /* synthetic */ GameJsSubmitData $it;
    final /* synthetic */ GamePluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GamePluginDriver$uploadPic$1$1$1(GameJsSubmitData gameJsSubmitData, GamePluginDriver gamePluginDriver, GameJsSubmitData gameJsSubmitData2, Context context) {
        super(1);
        this.$data = gameJsSubmitData;
        this.this$0 = gamePluginDriver;
        this.$it = gameJsSubmitData2;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            Collection userAnswer = this.$data.getUserAnswer();
            if (userAnswer == null || userAnswer.isEmpty()) {
                XesLog.e(this.this$0.TAG, "上传图片失败，用户未作答");
                this.this$0.packSubmitAsyncGameData(this.$it);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<String> userAnswer2 = this.$data.getUserAnswer();
            Intrinsics.checkNotNull(userAnswer2);
            for (String next : userAnswer2) {
                String str = System.currentTimeMillis() + ".jpg";
                String str2 = AppCacheUtil.getPhotosDir(this.$context) + File.separator + GamePluginDriverKt.GAMEPIC + str;
                String substring = next.substring(StringsKt.indexOf$default(next, ",", 0, false, 6, (Object) null) + 1, next.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                FileIOUtils.writeFileFromBytesByStream(str2, Base64Util.decryptBASE64ToByte(substring));
                arrayList.add(Intrinsics.stringPlus("game/", str));
                arrayList2.add(str2);
            }
            AwsS3Util awsS3Util = AwsS3Util.INSTANCE;
            final Context context = this.$context;
            final GamePluginDriver gamePluginDriver = this.this$0;
            final GameJsSubmitData gameJsSubmitData = this.$it;
            awsS3Util.uploadFilesWithPaths(context, AwsS3Util.scene_interaction, arrayList, arrayList2, new AwsS3Util.MultiTransferListener() {
                public void onProgressChanged(int i, int i2, long j, long j2) {
                }

                public void onStateChanged(int i, int i2, TransferState transferState) {
                }

                public void onUploadSuccess(List<String> list, List<String> list2) {
                    Intrinsics.checkNotNullParameter(list, "names");
                    Intrinsics.checkNotNullParameter(list2, "result");
                    XesLog.s(gamePluginDriver.TAG, "图片上传成功");
                    FileUtils.deleteAllInDir(AppCacheUtil.getPhotosDir(context) + File.separator + GamePluginDriverKt.GAMEPIC);
                    GamePluginDriver gamePluginDriver = gamePluginDriver;
                    gamePluginDriver.submitAsyncGameData(gamePluginDriver.mGameChannelBean, list, gameJsSubmitData.getUserAnswerResult());
                }

                public void onError(int i, int i2, Exception exc) {
                    XesLogTag access$getTAG$p = gamePluginDriver.TAG;
                    Object[] objArr = new Object[1];
                    objArr[0] = Intrinsics.stringPlus("图片上传失败 ---> ", exc == null ? null : exc.getMessage());
                    XesLog.e(access$getTAG$p, objArr);
                    FileUtils.deleteAllInDir(AppCacheUtil.getPhotosDir(context) + File.separator + GamePluginDriverKt.GAMEPIC);
                    gamePluginDriver.packSubmitAsyncGameData(gameJsSubmitData);
                }
            });
            return;
        }
        XesLog.e(this.this$0.TAG, "上传图片，无内存访问权限");
        this.this$0.packSubmitAsyncGameData(this.$it);
    }
}
