package com.tal.app.thinkacademy.live.business.interactivegames.driver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.interactivegames.activity.GameActivity;
import com.tal.app.thinkacademy.live.business.interactivegames.api.GameApi;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameChannelBean;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.GameStatus;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u001c\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u00152\b\u0010!\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\nH\u0002J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/driver/GameActivityPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mGameChannelBean", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameChannelBean;", "mGameStatus", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameStatus;", "mInteractId", "", "mNotifyClosed", "Landroidx/lifecycle/Observer;", "", "mNotifyUserInfo", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "loadPlugin", "", "gameStatus", "onDestroy", "onMessage", "ircTypeKey", "message", "removePlugin", "submit", "requestGameStatus", "gameChannelBean", "updateUserCoins", "userCoins", "addCoins", "updateUserLevel", "level", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "互动游戏课件插件", ircType = {"game_interact", "game_interact_f", "mode"}, liveType = 0, moduleId = "215")
@ViewLevels({@ViewLevel(level = 140, name = "game_interact")})
/* compiled from: GameActivityPluginDriver.kt */
public final class GameActivityPluginDriver extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final Tag TAG;
    /* access modifiers changed from: private */
    public boolean isOnDestroy;
    private Integer mClassId = 0;
    private Context mContext;
    private GameChannelBean mGameChannelBean;
    /* access modifiers changed from: private */
    public GameStatus mGameStatus;
    private String mInteractId = "";
    private final Observer<Object> mNotifyClosed;
    private final Observer<AnswerBean> mNotifyUserInfo;

    public GameActivityPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Context context;
        DataStorage dataStorage;
        CourseInfoProxy courseInfo;
        WeakReference<Context> weakRefContext;
        Tag tag = Tag.GamePluginDriver;
        this.TAG = tag;
        GameActivityPluginDriver$$ExternalSyntheticLambda0 gameActivityPluginDriver$$ExternalSyntheticLambda0 = new GameActivityPluginDriver$$ExternalSyntheticLambda0(this);
        this.mNotifyUserInfo = gameActivityPluginDriver$$ExternalSyntheticLambda0;
        GameActivityPluginDriver$$ExternalSyntheticLambda1 gameActivityPluginDriver$$ExternalSyntheticLambda1 = new GameActivityPluginDriver$$ExternalSyntheticLambda1(this);
        this.mNotifyClosed = gameActivityPluginDriver$$ExternalSyntheticLambda1;
        XesLog.i(tag, "初始化插件");
        Integer num = null;
        if (iLiveRoomProvider == null || (weakRefContext = iLiveRoomProvider.getWeakRefContext()) == null) {
            context = null;
        } else {
            context = (Context) weakRefContext.get();
        }
        this.mContext = context;
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null || (courseInfo = dataStorage.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getClassId());
        }
        this.mClassId = num;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.GAME_NOTIFY_USERINFO).observe(lifecycleOwner, gameActivityPluginDriver$$ExternalSyntheticLambda0);
        XesDataBus.with(DataBusKey.GAME_NOTIFY_CLOSED).observe(lifecycleOwner, gameActivityPluginDriver$$ExternalSyntheticLambda1);
    }

    /* access modifiers changed from: private */
    /* renamed from: mNotifyUserInfo$lambda-0  reason: not valid java name */
    public static final void m283mNotifyUserInfo$lambda0(GameActivityPluginDriver gameActivityPluginDriver, AnswerBean answerBean) {
        Intrinsics.checkNotNullParameter(gameActivityPluginDriver, "this$0");
        gameActivityPluginDriver.updateUserLevel(answerBean.getLevel());
        gameActivityPluginDriver.updateUserCoins(answerBean.getUserLatestCoin(), answerBean.getRightCoin());
    }

    /* access modifiers changed from: private */
    /* renamed from: mNotifyClosed$lambda-1  reason: not valid java name */
    public static final void m282mNotifyClosed$lambda1(GameActivityPluginDriver gameActivityPluginDriver, Object obj) {
        Intrinsics.checkNotNullParameter(gameActivityPluginDriver, "this$0");
        gameActivityPluginDriver.destroy();
    }

    public void onMessage(String str, String str2) {
        boolean z;
        if (!this.isOnDestroy) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(GamePluginDriverKt.GamePluginKey, str)) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey --> ", str2));
                try {
                    Intrinsics.checkNotNull(str2);
                    JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
                    if (optJSONObject != null) {
                        GameChannelBean gameChannelBean = (GameChannelBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), GameChannelBean.class);
                        this.mGameChannelBean = gameChannelBean;
                        if (gameChannelBean != null) {
                            if (gameChannelBean == null) {
                                z = false;
                            } else {
                                z = Intrinsics.areEqual(gameChannelBean.getPub(), true);
                            }
                            if (z) {
                                GameChannelBean gameChannelBean2 = this.mGameChannelBean;
                                String valueOf = String.valueOf(gameChannelBean2 == null ? null : gameChannelBean2.getInteractId());
                                this.mInteractId = valueOf;
                                InteractReportKt.XesLogReport$default("start", "Game", valueOf, (Integer) null, (String) null, 24, (Object) null);
                                XesLog.i(this.TAG, "教师端 开启 游戏");
                                GameChannelBean gameChannelBean3 = this.mGameChannelBean;
                                Intrinsics.checkNotNull(gameChannelBean3);
                                requestGameStatus(gameChannelBean3);
                                return;
                            }
                            InteractReportKt.XesLogReport$default("end", "Game", this.mInteractId, (Integer) null, (String) null, 24, (Object) null);
                            XesLog.i(this.TAG, "教师端 关闭 游戏");
                            removePlugin(true);
                        }
                    }
                } catch (Exception e) {
                    XesLog.e(this.TAG, Intrinsics.stringPlus("e --> ", e.getMessage()));
                    removePlugin(false);
                }
            }
        }
    }

    private final void requestGameStatus(GameChannelBean gameChannelBean) {
        XesLog.i(this.TAG, "获取学生答题状态");
        if (gameChannelBean != null) {
            GameApi gameApi = (GameApi) Api.create(GameApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/question/student/game/status");
            String planId = gameChannelBean.getPlanId();
            Call<HiResponse<GameStatus>> requestGameStatus = gameApi.requestGameStatus(stringPlus, new OpenStatusBody(planId == null ? null : Long.valueOf(Long.parseLong(planId)), gameChannelBean.getInteractId()));
            Callback gameActivityPluginDriver$requestGameStatus$1 = new GameActivityPluginDriver$requestGameStatus$1(this, new GameActivityPluginDriver$requestGameStatus$2(this));
            if (!(requestGameStatus instanceof Call)) {
                requestGameStatus.enqueue(gameActivityPluginDriver$requestGameStatus$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) requestGameStatus, gameActivityPluginDriver$requestGameStatus$1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void loadPlugin(GameStatus gameStatus) {
        Context context;
        XesLog.i(this.TAG, Intrinsics.stringPlus("开始加载游戏插件, 信令数据=", this.mGameChannelBean));
        GameChannelBean gameChannelBean = this.mGameChannelBean;
        if (gameChannelBean != null && (context = this.mContext) != null) {
            context.startActivity(new Intent(this.mContext, GameActivity.class).putExtra("classId", this.mClassId).putExtra("bean", gameChannelBean).putExtra("data", gameStatus));
        }
    }

    private final void removePlugin(boolean z) {
        XesDataBus.with(DataBusKey.GAME_TO_CLOSE).postStickyData(Boolean.valueOf(z));
        destroy();
    }

    private final void updateUserCoins(int i, int i2) {
        DataStorage dataStorage;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        UserInfoProxy userInfoProxy = null;
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null)) {
            userInfoProxy = dataStorage.getUserInfo();
        }
        if (userInfoProxy != null) {
            userInfoProxy.setGoldNum(i);
        }
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(GameActivityPluginDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(i), new CoinEventData(GoldSource.GAME_GOLD, i2, false, false, 12, (DefaultConstructorMarker) null)));
    }

    private final void updateUserLevel(int i) {
        PluginEventBus.onEvent(DataBusKey.LEVEL_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.LEVEL_KEY, String.valueOf(i)));
    }

    public void onDestroy() {
        XesLog.i(this.TAG, "插件销毁");
        this.isOnDestroy = true;
        this.mGameChannelBean = null;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.destroyPlugin((BaseLivePluginDriver) this);
        }
        this.mContext = null;
        XesDataBus.with(DataBusKey.GAME_NOTIFY_USERINFO).removeObserver(this.mNotifyUserInfo);
        XesDataBus.with(DataBusKey.GAME_NOTIFY_CLOSED).removeObserver(this.mNotifyClosed);
    }
}
