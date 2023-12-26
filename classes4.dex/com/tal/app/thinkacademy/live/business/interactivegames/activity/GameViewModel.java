package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.entity.EmptyBean;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.Base64Util;
import com.tal.app.thinkacademy.lib.util.FileIOUtils;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameJsSubmitData;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.SubmitAsyncGameRequest;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody;
import com.tal.app.thinkacademy.live.business.interactivegames.driver.GamePluginDriverKt;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J4\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J:\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020\u00152\u0006\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020+J0\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/activity/GameViewModel;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mDelayData", "Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "", "getMDelayData", "()Lcom/tal/app/thinkacademy/lib/utils/StickyLiveData;", "mGameCloseState", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "Lcom/tal/app/thinkacademy/common/entity/EmptyBean;", "getMGameCloseState", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "mGameSubmitState", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "getMGameSubmitState", "mRepository", "Lcom/tal/app/thinkacademy/live/business/interactivegames/activity/GameRepository;", "delayDone", "", "delayTime", "", "packSubmitAsyncGameData", "data", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "bean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "classId", "", "names", "", "", "submitAsyncGameData", "gameChannelBean", "gameImages", "userAnswerResult", "submitGameClose", "url", "body", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/OpenStatusBody;", "submitGameData", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitGameDataBody;", "uploadPic", "context", "Landroid/content/Context;", "havePermission", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameViewModel.kt */
public final class GameViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.GamePluginDriver;
    private final StickyLiveData<Boolean> mDelayData = new StickyLiveData<>();
    private final StateLiveData<EmptyBean> mGameCloseState = new StateLiveData<>();
    private final StateLiveData<AnswerBean> mGameSubmitState = new StateLiveData<>();
    /* access modifiers changed from: private */
    public final GameRepository mRepository = new GameRepository();

    public final StateLiveData<AnswerBean> getMGameSubmitState() {
        return this.mGameSubmitState;
    }

    public final StateLiveData<EmptyBean> getMGameCloseState() {
        return this.mGameCloseState;
    }

    public final StickyLiveData<Boolean> getMDelayData() {
        return this.mDelayData;
    }

    public final void submitGameData(String str, SubmitGameDataBody submitGameDataBody) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(submitGameDataBody, "body");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GameViewModel$submitGameData$1(this)), (CoroutineStart) null, new GameViewModel$submitGameData$2(this, str, submitGameDataBody, (Continuation<? super GameViewModel$submitGameData$2>) null), 2, (Object) null);
    }

    public final void submitGameClose(String str, OpenStatusBody openStatusBody) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(openStatusBody, "body");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new GameViewModel$submitGameClose$1(this)), (CoroutineStart) null, new GameViewModel$submitGameClose$2(this, str, openStatusBody, (Continuation<? super GameViewModel$submitGameClose$2>) null), 2, (Object) null);
    }

    public final void delayDone(long j) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new GameViewModel$delayDone$1(j, this, (Continuation<? super GameViewModel$delayDone$1>) null), 3, (Object) null);
    }

    public final void uploadPic(Context context, boolean z, GameJsSubmitData gameJsSubmitData, GameChannelBean gameChannelBean, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameJsSubmitData, "data");
        if (z) {
            Collection userAnswer = gameJsSubmitData.getUserAnswer();
            if (userAnswer == null || userAnswer.isEmpty()) {
                XesLog.e(this.TAG, "上传图片失败，用户未作答");
                packSubmitAsyncGameData$default(this, gameJsSubmitData, gameChannelBean, i, (List) null, 8, (Object) null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<String> userAnswer2 = gameJsSubmitData.getUserAnswer();
            Intrinsics.checkNotNull(userAnswer2);
            for (String next : userAnswer2) {
                String str = System.currentTimeMillis() + ".jpg";
                String str2 = AppCacheUtil.getPhotosDir(context) + File.separator + GamePluginDriverKt.GAMEPIC + str;
                String substring = next.substring(StringsKt.indexOf$default(next, ",", 0, false, 6, (Object) null) + 1, next.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                FileIOUtils.writeFileFromBytesByStream(str2, Base64Util.decryptBASE64ToByte(substring));
                arrayList.add(Intrinsics.stringPlus("game/", str));
                arrayList2.add(str2);
            }
            Context context2 = context;
            AwsS3Util.INSTANCE.uploadFilesWithPaths(context2, AwsS3Util.scene_interaction, arrayList, arrayList2, new GameViewModel$uploadPic$1(this, context2, gameJsSubmitData, gameChannelBean, i));
            return;
        }
        XesLog.e(this.TAG, "上传图片，无内存访问权限");
        packSubmitAsyncGameData$default(this, gameJsSubmitData, gameChannelBean, i, (List) null, 8, (Object) null);
    }

    static /* synthetic */ void packSubmitAsyncGameData$default(GameViewModel gameViewModel, GameJsSubmitData gameJsSubmitData, GameChannelBean gameChannelBean, int i, List list, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list = null;
        }
        gameViewModel.packSubmitAsyncGameData(gameJsSubmitData, gameChannelBean, i, list);
    }

    /* access modifiers changed from: private */
    public final void packSubmitAsyncGameData(GameJsSubmitData gameJsSubmitData, GameChannelBean gameChannelBean, int i, List<String> list) {
        if (list == null) {
            GameViewModel gameViewModel = this;
            ArrayList arrayList = new ArrayList();
            List<Integer> userAnswerResult = gameJsSubmitData.getUserAnswerResult();
            if (userAnswerResult != null) {
                int i2 = 0;
                for (Object next : userAnswerResult) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ((Number) next).intValue();
                    arrayList.add("");
                    i2 = i3;
                }
            }
            list = arrayList;
        }
        submitAsyncGameData(gameChannelBean, list, gameJsSubmitData.getUserAnswerResult(), i);
    }

    private final void submitAsyncGameData(GameChannelBean gameChannelBean, List<String> list, List<Integer> list2, int i) {
        XesLog.i(this.TAG, "提交游戏图片");
        if (gameChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/submitAsync");
            String planId = gameChannelBean.getPlanId();
            Call<HiResponse<EmptyBean>> submitAsyncGameData = gameApi.submitAsyncGameData(stringPlus, new SubmitAsyncGameRequest(planId == null ? null : Long.valueOf(Long.parseLong(planId)), gameChannelBean.getInteractId(), Integer.valueOf(i), list, list2));
            Callback gameViewModel$submitAsyncGameData$1 = new GameViewModel$submitAsyncGameData$1(this, new GameViewModel$submitAsyncGameData$2(this));
            if (!(submitAsyncGameData instanceof Call)) {
                submitAsyncGameData.enqueue(gameViewModel$submitAsyncGameData$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) submitAsyncGameData, gameViewModel$submitAsyncGameData$1);
            }
        }
    }
}
