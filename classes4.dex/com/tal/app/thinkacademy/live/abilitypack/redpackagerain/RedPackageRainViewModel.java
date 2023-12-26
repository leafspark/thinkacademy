package com.tal.app.thinkacademy.live.abilitypack.redpackagerain;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PhoneUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesActivityManager;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.cloud.DeviceConfig;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.cloud.RedPackageRainData;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.listenbody.RedPackageRainListenerBody;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.redpackagerain.api.RedPackageRainApi;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainAction;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainDowngradeStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainGameStatus;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainMsgBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainResBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainStatusBean;
import com.tal.app.thinkacademy.live.business.redpackagerain.bean.RedPackageRainStatusBody;
import com.tal.app.thinkacademy.live.business.redpackagerain.listener.RedPackageRainStatusListener;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.GameResUtil;
import com.tal.app.thinkacademy.live.business.redpackagerain.util.RedPackageRainTrackUtil;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.yy.mobile.rollingtextview.RollingTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u000f\u0018\u0000 _2\u00020\u0001:\u0001_B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020\u0013H\u0002J\u0006\u0010$\u001a\u00020\u0013J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001d2\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u00020/H\u0002J\b\u00104\u001a\u0004\u0018\u00010\tJ\b\u00105\u001a\u0004\u0018\u00010\u000bJ\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u0006J\u0006\u00109\u001a\u00020\u0013J\u0018\u0010:\u001a\u00020/2\b\u0010;\u001a\u0004\u0018\u00010\u001d2\u0006\u0010<\u001a\u00020\u0013J\b\u0010=\u001a\u00020/H\u0014J\b\u0010>\u001a\u00020\u0013H\u0002J\u0010\u0010?\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001dJ?\u0010@\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001d2\b\u0010A\u001a\u0004\u0018\u00010\u00062\u000e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010C2\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010C¢\u0006\u0002\u0010EJ\u001f\u0010F\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u001d2\b\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u00020/J\u0006\u0010I\u001a\u00020/J\b\u0010J\u001a\u00020/H\u0002J\u001a\u0010K\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010N\u001a\u0004\u0018\u00010OJ\u001c\u0010P\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002J\b\u0010R\u001a\u00020/H\u0002J\u0010\u0010S\u001a\u00020/2\b\u0010T\u001a\u0004\u0018\u00010\tJ\u0010\u0010U\u001a\u00020/2\b\u0010V\u001a\u0004\u0018\u00010\u000bJ\u0015\u0010W\u001a\u00020/2\b\u0010X\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010YJ\u0015\u0010Z\u001a\u00020/2\b\u0010[\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\\J\u0010\u0010]\u001a\u00020/2\b\u0010T\u001a\u0004\u0018\u00010\tJ\u0010\u0010^\u001a\u00020/2\b\u0010V\u001a\u0004\u0018\u00010\u000bR\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006`"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "classId", "", "Ljava/lang/Integer;", "mCoinImageView", "Landroid/widget/ImageView;", "mCoinTextView", "Lcom/yy/mobile/rollingtextview/RollingTextView;", "mContext", "Landroid/content/Context;", "mFrontBackCallback", "com/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$mFrontBackCallback$1", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$mFrontBackCallback$1;", "mGameStatus", "mIsCloseVideo", "", "Ljava/lang/Boolean;", "mIsFront", "mIsLowDevice", "mListenerBody", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/listenbody/RedPackageRainListenerBody;", "getMListenerBody", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mMsg", "", "mSecondCoinImageView", "mSecondCoinTextView", "planId", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "checkGameStatusIsFailed", "checkGameStatusIsLoading", "checkGameStatusIsPlaying", "checkGameStatusIsSuccess", "checkGameStatusIsTimeout", "checkMsgTime", "sendTime", "", "checkRedPackageRainData", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "name", "checkRedPackageRainStatus", "", "interactId", "listener", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/listener/RedPackageRainStatusListener;", "doRedPackageRainMessage", "getCoinImageView", "getCoinTextView", "getDowngradeCoinRatio", "", "getTimeout", "isLowDevice", "onReceiveRedPackageRainMessage", "message", "isBackForeground", "onVmDestroy", "parseRedPackageRainCloudConfig", "reportExposure", "reportRedPackageRainCoin", "coin", "grabRedbagQueue", "", "grabBombQueue", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "sendCoinSettlementEvent", "(Ljava/lang/String;Ljava/lang/Integer;)V", "sendDestroyDowngradeEvent", "sendGameEndEvent", "sendGetGameCoinEvent", "sendLoadDowngradeEvent", "redPackageRainMsgBean", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainMsgBean;", "redPackageRainDowngradeStatus", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainDowngradeStatus;", "sendLoadGameEvent", "redPackageRainResBean", "sendPlayGameEvent", "setCoinImageView", "coinImageView", "setCoinTextView", "coinTextView", "setGameStatus", "status", "(Ljava/lang/Integer;)V", "setIsCloseVideo", "isCloseVideo", "(Ljava/lang/Boolean;)V", "setSecondCoinImageView", "setSecondCoinTextView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainViewModel.kt */
public final class RedPackageRainViewModel extends AbilityViewModel {
    public static final String CLOUD_KEY = "hw_red_package_rain_config";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.RED_PACKAGE_RAIN;
    private Integer classId;
    private ImageView mCoinImageView;
    private RollingTextView mCoinTextView;
    private Context mContext;
    private RedPackageRainViewModel$mFrontBackCallback$1 mFrontBackCallback = new RedPackageRainViewModel$mFrontBackCallback$1(this);
    private int mGameStatus = RedPackageRainGameStatus.GAME_STATUS_UN_KNOW.getStatus();
    private Boolean mIsCloseVideo;
    /* access modifiers changed from: private */
    public Boolean mIsFront;
    private boolean mIsLowDevice;
    private final ListenerData<RedPackageRainListenerBody> mListenerBody = new ListenerData<>();
    /* access modifiers changed from: private */
    public String mMsg;
    private ImageView mSecondCoinImageView;
    private RollingTextView mSecondCoinTextView;
    private Integer planId;
    private final ILiveRoomProvider provider;

    private final void doRedPackageRainMessage() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel$Companion;", "", "()V", "CLOUD_KEY", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RedPackageRainViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPackageRainViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        CourseInfoProxy courseInfo;
        CourseInfoProxy courseInfo2;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        Integer num = null;
        this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        this.planId = (dataStorage == null || (courseInfo2 = dataStorage.getCourseInfo()) == null) ? null : Integer.valueOf(courseInfo2.getPlanId());
        DataStorage dataStorage2 = iLiveRoomProvider.getDataStorage();
        if (!(dataStorage2 == null || (courseInfo = dataStorage2.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getClassId());
        }
        this.classId = num;
        this.mIsLowDevice = parseRedPackageRainCloudConfig();
        XesActivityManager.Companion.getInstance().addFrontBackCallback(this.mFrontBackCallback);
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final ListenerData<RedPackageRainListenerBody> getMListenerBody() {
        return this.mListenerBody;
    }

    public final void onReceiveRedPackageRainMessage(String str, boolean z) {
        String str2;
        if (z) {
            XesLog.i(TAG, Intrinsics.stringPlus("从后台回到前台恢复红包雨信令=", str));
        } else {
            XesLog.i(TAG, Intrinsics.stringPlus("收到红包雨信令=", str));
        }
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                long optLong = jSONObject.optLong("sendTime");
                GsonUtil instance = GsonUtil.getInstance();
                String str3 = null;
                if (optJSONObject == null) {
                    str2 = null;
                } else {
                    str2 = !(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject);
                }
                RedPackageRainMsgBean redPackageRainMsgBean = (RedPackageRainMsgBean) instance.fromJson(str2, RedPackageRainMsgBean.class);
                if (redPackageRainMsgBean != null) {
                    if (Intrinsics.areEqual(redPackageRainMsgBean.getPub(), true)) {
                        if (Intrinsics.areEqual(this.mIsFront, false)) {
                            XesLog.i(TAG, "应用在后台，不加载游戏");
                            this.mMsg = str;
                        } else if (Intrinsics.areEqual(RedPackageRainAction.START.getValue(), redPackageRainMsgBean.getAction())) {
                            if (z) {
                                XesLog.i(TAG, "从后台回到前台恢复红包雨互动开始信令");
                            } else {
                                XesLog.i(TAG, "收到红包雨互动开始信令");
                            }
                            if (isLowDevice()) {
                                XesLog.i(TAG, "低端机，显示降级view低端机提示效果");
                                RedPackageRainTrackUtil.INSTANCE.redPackageRainDeviceLevel(1);
                                sendLoadDowngradeEvent(redPackageRainMsgBean, RedPackageRainDowngradeStatus.STATUS_DEVICE_LOW_ALERT);
                                return;
                            }
                            RedPackageRainTrackUtil.INSTANCE.redPackageRainDeviceLevel(2);
                            RedPackageRainResBean checkRedPackageRainData = checkRedPackageRainData(redPackageRainMsgBean.getName());
                            if (checkRedPackageRainData != null) {
                                Tag tag = TAG;
                                XesLog.i(tag, Intrinsics.stringPlus("游戏包信息=", GsonUtil.getInstance().objToJson(checkRedPackageRainData)));
                                XesLog.i(tag, "有本地缓存游戏包数据，加载游戏");
                                sendLoadGameEvent(redPackageRainMsgBean, checkRedPackageRainData);
                                XesLog.i(tag, "显示降级view loading效果");
                                sendLoadDowngradeEvent(redPackageRainMsgBean, RedPackageRainDowngradeStatus.STATUS_LOADING);
                                return;
                            }
                            XesLog.i(TAG, "无本地缓存游戏包数据，请求游戏包数据接口");
                            GameResUtil.Companion.get().requestGamePackage(new RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$1(checkRedPackageRainData, this, redPackageRainMsgBean));
                        } else if (Intrinsics.areEqual(RedPackageRainAction.PLAY.getValue(), redPackageRainMsgBean.getAction())) {
                            if (z) {
                                XesLog.i(TAG, "从后台回到前台恢复红包雨开始游戏信令");
                            } else {
                                XesLog.i(TAG, "收到红包雨开始游戏信令");
                            }
                            if (isLowDevice()) {
                                XesLog.i(TAG, "低端机，显示降级view领金币效果");
                                RedPackageRainTrackUtil.INSTANCE.redPackageRainDeviceLevel(1);
                                sendLoadDowngradeEvent(redPackageRainMsgBean, RedPackageRainDowngradeStatus.STATUS_GET_COIN);
                                return;
                            }
                            RedPackageRainTrackUtil.INSTANCE.redPackageRainDeviceLevel(2);
                            if (checkGameStatusIsSuccess()) {
                                XesLog.i(TAG, "游戏已加载完成，直接开始游戏");
                                sendPlayGameEvent();
                                return;
                            }
                            if (!checkGameStatusIsFailed()) {
                                if (!checkGameStatusIsTimeout()) {
                                    boolean checkMsgTime = checkMsgTime(optLong);
                                    Tag tag2 = TAG;
                                    XesLog.i(tag2, Intrinsics.stringPlus("游戏未加载，判断信令是否过期=", Boolean.valueOf(checkMsgTime)));
                                    if (!checkMsgTime) {
                                        XesLog.i(tag2, "信令未过期，请求是否已上报过金币");
                                        checkRedPackageRainStatus(redPackageRainMsgBean.getInteractId(), new RedPackageRainViewModel$onReceiveRedPackageRainMessage$1$1$2(this, redPackageRainMsgBean));
                                        return;
                                    }
                                    return;
                                }
                            }
                            XesLog.i(TAG, "游戏加载失败或加载超时，显示降级view领金币效果");
                            sendLoadDowngradeEvent(redPackageRainMsgBean, RedPackageRainDowngradeStatus.STATUS_GET_COIN);
                        }
                    } else if (Intrinsics.areEqual(redPackageRainMsgBean.getPub(), false)) {
                        XesLog.i(TAG, Intrinsics.stringPlus("收到红包雨互动结束信令，当前游戏状态（-1：未知，0：加载失败，1：加载成功，2：游戏结束，3：游戏中，4：游戏loading，5：加载超时）=", Integer.valueOf(this.mGameStatus)));
                        if (checkGameStatusIsSuccess()) {
                            Context context = this.mContext;
                            if (context != null) {
                                Resources resources = context.getResources();
                                if (resources != null) {
                                    str3 = resources.getString(R.string.red_package_rain_game_end);
                                }
                            }
                            ToastUtils.showShort(str3, new Object[0]);
                            sendGameEndEvent();
                        } else if (checkGameStatusIsPlaying()) {
                            Context context2 = this.mContext;
                            if (context2 != null) {
                                Resources resources2 = context2.getResources();
                                if (resources2 != null) {
                                    str3 = resources2.getString(R.string.red_package_rain_game_end);
                                }
                            }
                            ToastUtils.showShort(str3, new Object[0]);
                            sendGetGameCoinEvent();
                        } else {
                            sendGameEndEvent();
                        }
                        setGameStatus(Integer.valueOf(RedPackageRainGameStatus.GAME_STATUS_END.getStatus()));
                        sendDestroyDowngradeEvent();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final boolean checkMsgTime(long j) {
        boolean z;
        int optInt;
        if (j > 0) {
            try {
                Map<String, String> initModuleMap = this.provider.getInitModuleMap();
                if (initModuleMap != null) {
                    String str = initModuleMap.get("3011");
                    if (!TextUtils.isEmpty(str) && (optInt = new JSONObject(str).optInt("expiredTime")) > 0) {
                        DataStorage dataStorage = getProvider().getDataStorage();
                        Long l = null;
                        if (dataStorage != null) {
                            RoomData roomData = dataStorage.getRoomData();
                            if (roomData != null) {
                                l = Long.valueOf(roomData.getServeNowTime() * ((long) 1000));
                            }
                        }
                        XesLog.i(TAG, "红包雨配置过期时长=" + optInt + "，信令时间戳=" + j + ",当前服务器时间戳" + l);
                        if (l != null) {
                            if (l.longValue() >= j + ((long) (optInt * 1000))) {
                                z = true;
                                XesLog.i(TAG, Intrinsics.stringPlus("play信令是否过期=", Boolean.valueOf(z)));
                                return z;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        z = false;
        XesLog.i(TAG, Intrinsics.stringPlus("play信令是否过期=", Boolean.valueOf(z)));
        return z;
    }

    public final double getDowngradeCoinRatio() {
        try {
            Map<String, String> initModuleMap = this.provider.getInitModuleMap();
            if (initModuleMap != null) {
                String str = initModuleMap.get("3011");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("ratio")) {
                        double optDouble = jSONObject.optDouble("ratio");
                        XesLog.i(TAG, Intrinsics.stringPlus("降级积分比率=", Double.valueOf(optDouble)));
                        return optDouble;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XesLog.i(TAG, "默认降级积分比率=0.5");
        return 0.5d;
    }

    public final int getTimeout() {
        try {
            Map<String, String> initModuleMap = this.provider.getInitModuleMap();
            if (initModuleMap != null) {
                String str = initModuleMap.get("3011");
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("timeout")) {
                        int optInt = jSONObject.optInt("timeout");
                        XesLog.i(TAG, "超时配置=" + optInt + 31186);
                        return optInt;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XesLog.i(TAG, "默认超时配置5秒");
        return 5;
    }

    /* access modifiers changed from: private */
    public final RedPackageRainResBean checkRedPackageRainData(String str) {
        if (str == null) {
            return null;
        }
        return GameResUtil.Companion.get().getRedPackageRainRes(str);
    }

    /* access modifiers changed from: private */
    public final void sendLoadGameEvent(RedPackageRainMsgBean redPackageRainMsgBean, RedPackageRainResBean redPackageRainResBean) {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.LoadGameMessage(redPackageRainMsgBean, redPackageRainResBean));
    }

    public final void sendLoadDowngradeEvent(RedPackageRainMsgBean redPackageRainMsgBean, RedPackageRainDowngradeStatus redPackageRainDowngradeStatus) {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.LoadDowngradeMessage(redPackageRainMsgBean, redPackageRainDowngradeStatus));
    }

    public final void sendDestroyDowngradeEvent() {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.DestroyDowngradeMessage());
    }

    private final void sendGetGameCoinEvent() {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.GetGameCoinMessage());
    }

    public final void sendGameEndEvent() {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.GameEndMessage());
    }

    public final void sendCoinSettlementEvent(String str, Integer num) {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.CoinSettlementMessage(str, num));
    }

    private final void sendPlayGameEvent() {
        this.mListenerBody.setStickyData(new RedPackageRainListenerBody.PlayGameMessage());
    }

    public final void setGameStatus(Integer num) {
        if (num != null) {
            this.mGameStatus = num.intValue();
        }
    }

    private final boolean checkGameStatusIsSuccess() {
        return this.mGameStatus == RedPackageRainGameStatus.GAME_STATUS_SUCCESS.getStatus();
    }

    private final boolean checkGameStatusIsFailed() {
        return this.mGameStatus == RedPackageRainGameStatus.GAME_STATUS_FAILED.getStatus();
    }

    private final boolean checkGameStatusIsTimeout() {
        return this.mGameStatus == RedPackageRainGameStatus.GAME_STATUS_TIME_OUT.getStatus();
    }

    private final boolean checkGameStatusIsPlaying() {
        return this.mGameStatus == RedPackageRainGameStatus.GAME_STATUS_PLAYING.getStatus();
    }

    public final boolean checkGameStatusIsLoading() {
        return this.mGameStatus == RedPackageRainGameStatus.GAME_STATUS_START_LOAD.getStatus();
    }

    private final void checkRedPackageRainStatus(String str, RedPackageRainStatusListener redPackageRainStatusListener) {
        Call<HiResponse<RedPackageRainStatusBean>> redPackageRainStatus = ((RedPackageRainApi) Api.create(RedPackageRainApi.class)).getRedPackageRainStatus(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/api/redbagrain/student/status"), new RedPackageRainStatusBody(this.planId, str));
        Callback redPackageRainViewModel$checkRedPackageRainStatus$1 = new RedPackageRainViewModel$checkRedPackageRainStatus$1(redPackageRainStatusListener, new RedPackageRainViewModel$checkRedPackageRainStatus$2(redPackageRainStatusListener));
        if (!(redPackageRainStatus instanceof Call)) {
            redPackageRainStatus.enqueue(redPackageRainViewModel$checkRedPackageRainStatus$1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) redPackageRainStatus, redPackageRainViewModel$checkRedPackageRainStatus$1);
        }
    }

    public final ImageView getCoinImageView() {
        if (Intrinsics.areEqual(this.mIsCloseVideo, true)) {
            return this.mSecondCoinImageView;
        }
        return this.mCoinImageView;
    }

    public final void setCoinImageView(ImageView imageView) {
        this.mCoinImageView = imageView;
    }

    public final void setSecondCoinImageView(ImageView imageView) {
        this.mSecondCoinImageView = imageView;
    }

    public final RollingTextView getCoinTextView() {
        if (Intrinsics.areEqual(this.mIsCloseVideo, true)) {
            return this.mSecondCoinTextView;
        }
        return this.mCoinTextView;
    }

    public final void setCoinTextView(RollingTextView rollingTextView) {
        this.mCoinTextView = rollingTextView;
    }

    public final void setSecondCoinTextView(RollingTextView rollingTextView) {
        this.mSecondCoinTextView = rollingTextView;
    }

    public final void setIsCloseVideo(Boolean bool) {
        this.mIsCloseVideo = bool;
    }

    public final void reportRedPackageRainCoin(String str, Integer num, List<Integer> list, List<Integer> list2) {
        ReportCoinUtil.reportRedPackageRainCoin(this.classId, this.planId, str, num, list, list2, 1);
    }

    public final void reportExposure(String str) {
        Integer num;
        if (str != null && (num = this.planId) != null) {
            int intValue = num.intValue();
            Integer num2 = this.classId;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                XesLog.i(TAG, "上报曝光,interact_id=" + str + ",plan_id=" + intValue + ",class_id=" + intValue2);
                InteractLogReport.uploadLog(str, intValue, intValue2);
            }
        }
    }

    public final boolean isLowDevice() {
        return this.mIsLowDevice;
    }

    private final boolean parseRedPackageRainCloudConfig() {
        RedPackageRainData redPackageRainData;
        boolean valueOf;
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue(CLOUD_KEY);
        Boolean bool = null;
        try {
            XesLog.i(TAG, Intrinsics.stringPlus("红包雨云控配置", cloudKeyValue));
            redPackageRainData = (RedPackageRainData) GsonUtils.fromJson(cloudKeyValue, RedPackageRainData.class);
        } catch (Exception unused) {
            XesLog.i(TAG, "红包雨云控数据解析失败");
            redPackageRainData = null;
        }
        if (redPackageRainData != null) {
            ArrayList<String> deviceList = redPackageRainData.getDeviceList();
            if (deviceList != null && deviceList.contains(uniqueDeviceId)) {
                XesLog.i(TAG, "红包雨低端设备检测命中黑名单，按照低端机处理");
                valueOf = true;
            } else {
                DeviceConfig lowDeviceConfig = redPackageRainData.getLowDeviceConfig();
                if (lowDeviceConfig != null) {
                    double ramMaxMemoryInt = PhoneUtils.getRamMaxMemoryInt(1024);
                    Tag tag = TAG;
                    XesLog.i(tag, "红包雨低端设备检测运行内存=" + ramMaxMemoryInt + 'M');
                    boolean z = lowDeviceConfig.getMinRam() > 0 && ramMaxMemoryInt <= ((double) lowDeviceConfig.getMinRam());
                    int sDKVersionCode = DeviceUtils.getSDKVersionCode();
                    XesLog.i(tag, Intrinsics.stringPlus("红包雨低端设备检测系统版本=", Integer.valueOf(sDKVersionCode)));
                    boolean z2 = z || (lowDeviceConfig.getMinSdkVersion() > 0 && lowDeviceConfig.getMinSdkVersion() > sDKVersionCode);
                    XesLog.i(tag, Intrinsics.stringPlus("红包雨低端设备检测结果，是否是低端机", Boolean.valueOf(z2)));
                    valueOf = Boolean.valueOf(z2);
                }
            }
            bool = valueOf;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        RedPackageRainViewModel redPackageRainViewModel = this;
        XesLog.i(TAG, "红包雨低端设备检测默认认为不是低端机");
        return false;
    }

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
        XesActivityManager.Companion.getInstance().removeFrontBackCallback(this.mFrontBackCallback);
    }
}
