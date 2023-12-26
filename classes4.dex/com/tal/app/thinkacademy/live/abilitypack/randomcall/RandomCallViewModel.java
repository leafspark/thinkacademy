package com.tal.app.thinkacademy.live.abilitypack.randomcall;

import android.content.Context;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PhoneUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.cloud.DeviceConfig;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.cloud.RandomCallData;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.listenbody.RandomCallListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallEndBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallStartBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0018\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u000eJ\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&J\b\u0010'\u001a\u00020$H\u0014J\b\u0010(\u001a\u00020\u000eH\u0002J\u0017\u0010)\u001a\u00020$2\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010*R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/RandomCallViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mContext", "Landroid/content/Context;", "mCurrentRandomCallBean", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "getMCurrentRandomCallBean", "()Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;", "setMCurrentRandomCallBean", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallStartBean;)V", "mIsOpenStream", "", "mListenerBody", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/listenbody/RandomCallListenerBody;", "getMListenerBody", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mRtcViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "getStudentPosition", "Lkotlin/Pair;", "", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "uid", "", "(Ljava/lang/Long;)Lkotlin/Pair;", "isAlsoLoaded", "sendTime", "(Ljava/lang/Long;)Z", "isOpenStream", "onReceiveRandomCallMessage", "", "message", "", "onVmDestroy", "parseRandomCallCloudConfig", "saveRandomCallMsgSendTime", "(Ljava/lang/Long;)V", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallViewModel.kt */
public final class RandomCallViewModel extends AbilityViewModel {
    public static final String CLOUD_KEY = "hw_random_config";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.RANDOM_CALL_NEW;
    private Context mContext;
    private RandomCallStartBean mCurrentRandomCallBean;
    private boolean mIsOpenStream = true;
    private final ListenerData<RandomCallListenerBody> mListenerBody = new ListenerData<>();
    private RtcViewModel mRtcViewModel;
    private final ILiveRoomProvider provider;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/RandomCallViewModel$Companion;", "", "()V", "CLOUD_KEY", "", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RandomCallViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RandomCallViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        this.mRtcViewModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        this.mIsOpenStream = parseRandomCallCloudConfig();
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    public final ListenerData<RandomCallListenerBody> getMListenerBody() {
        return this.mListenerBody;
    }

    public final RandomCallStartBean getMCurrentRandomCallBean() {
        return this.mCurrentRandomCallBean;
    }

    public final void setMCurrentRandomCallBean(RandomCallStartBean randomCallStartBean) {
        this.mCurrentRandomCallBean = randomCallStartBean;
    }

    public final void onReceiveRandomCallMessage(String str) {
        Integer num;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                String str2 = null;
                if (optJSONObject == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(optJSONObject.optInt("pub"));
                }
                if (num != null) {
                    if (num.intValue() == 1) {
                        long optLong = jSONObject.optLong("sendTime");
                        if (isAlsoLoaded(Long.valueOf(optLong))) {
                            XesLog.i(TAG, Intrinsics.stringPlus("收到随机点名开始信令，本地有相同时间戳，说明已经加载过，不做处理=", str));
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        saveRandomCallMsgSendTime(Long.valueOf(optLong));
                        setMCurrentRandomCallBean((RandomCallStartBean) GsonUtil.getInstance().fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), RandomCallStartBean.class));
                        XesLog.i(TAG, Intrinsics.stringPlus("收到随机点名开始信令，本地无相同时间戳，说明未加载过，开始加载=", str));
                        RandomCallStartBean mCurrentRandomCallBean2 = getMCurrentRandomCallBean();
                        if (mCurrentRandomCallBean2 != null) {
                            if (Intrinsics.areEqual(mCurrentRandomCallBean2.getType(), "wheel")) {
                                getMListenerBody().setStickyData(new RandomCallListenerBody.RandomCallLotteryStart(mCurrentRandomCallBean2));
                            } else if (Intrinsics.areEqual(mCurrentRandomCallBean2.getType(), "wall")) {
                                getMListenerBody().setStickyData(new RandomCallListenerBody.RandomCallPhotoWallStart(mCurrentRandomCallBean2));
                            }
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                }
                if (num != null) {
                    if (num.intValue() == 0) {
                        XesLog.i(TAG, Intrinsics.stringPlus("收到随机点名结束信令=", str));
                        RandomCallEndBean randomCallEndBean = (RandomCallEndBean) GsonUtil.getInstance().fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), RandomCallEndBean.class);
                        if (randomCallEndBean != null) {
                            str2 = randomCallEndBean.getType();
                        }
                        if (Intrinsics.areEqual(str2, "wheel")) {
                            ListenerData<RandomCallListenerBody> mListenerBody2 = getMListenerBody();
                            Intrinsics.checkNotNullExpressionValue(randomCallEndBean, "bean");
                            mListenerBody2.setStickyData(new RandomCallListenerBody.RandomCallLotteryEnd(randomCallEndBean));
                        } else if (Intrinsics.areEqual(str2, "wall")) {
                            ListenerData<RandomCallListenerBody> mListenerBody3 = getMListenerBody();
                            Intrinsics.checkNotNullExpressionValue(randomCallEndBean, "bean");
                            mListenerBody3.setStickyData(new RandomCallListenerBody.RandomCallPhotoWallEnd(randomCallEndBean));
                        }
                    }
                }
                Unit unit3 = Unit.INSTANCE;
            } catch (Throwable th) {
                th.printStackTrace();
                XesLog.i(TAG, Intrinsics.stringPlus("解析随机点名信令异常=", str));
                Unit unit4 = Unit.INSTANCE;
            }
        }
    }

    private final boolean isAlsoLoaded(Long l) {
        return l != null && l.longValue() == ShareDataManager.getInstance().getLong(ShareDataKey.RANDOM_CALL_NEW_TIME, 0, ShareDataManager.SHAREDATA_USER);
    }

    private final void saveRandomCallMsgSendTime(Long l) {
        if (l != null) {
            ShareDataManager.getInstance().put(ShareDataKey.RANDOM_CALL_NEW_TIME, l.longValue(), ShareDataManager.SHAREDATA_USER);
        }
    }

    public final Pair<Integer, RandomCallUserBean> getStudentPosition(Long l) {
        ArrayList<RandomCallUserBean> students;
        RandomCallStartBean randomCallStartBean = this.mCurrentRandomCallBean;
        if (!(randomCallStartBean == null || (students = randomCallStartBean.getStudents()) == null || students.size() <= 0)) {
            int i = 0;
            int size = students.size();
            while (i < size) {
                int i2 = i + 1;
                RandomCallUserBean randomCallUserBean = students.get(i);
                if (Intrinsics.areEqual(randomCallUserBean == null ? null : randomCallUserBean.getUserId(), l)) {
                    return new Pair<>(Integer.valueOf(i), students.get(i));
                }
                i = i2;
            }
        }
        return new Pair<>((Object) null, (Object) null);
    }

    public final boolean isOpenStream() {
        return this.mIsOpenStream;
    }

    private final boolean parseRandomCallCloudConfig() {
        RandomCallData randomCallData;
        boolean valueOf;
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue(CLOUD_KEY);
        Boolean bool = null;
        try {
            XesLog.i(TAG, Intrinsics.stringPlus("随机点名云控配置", cloudKeyValue));
            randomCallData = (RandomCallData) GsonUtils.fromJson(cloudKeyValue, RandomCallData.class);
        } catch (Exception unused) {
            XesLog.i(TAG, "随机点名云控数据解析失败");
            randomCallData = null;
        }
        if (randomCallData != null) {
            ArrayList<String> deviceList = randomCallData.getDeviceList();
            if (deviceList != null && deviceList.contains(uniqueDeviceId)) {
                XesLog.i(TAG, "随机点名低端设备检测命中黑名单，不开启拉流");
                valueOf = false;
            } else {
                DeviceConfig lowDeviceConfig = randomCallData.getLowDeviceConfig();
                if (lowDeviceConfig != null) {
                    double ramMaxMemoryInt = PhoneUtils.getRamMaxMemoryInt(1024);
                    Tag tag = TAG;
                    XesLog.i(tag, "随机点名低端设备检测运行内存=" + ramMaxMemoryInt + 'M');
                    boolean z = lowDeviceConfig.getMinRam() == 0 || ramMaxMemoryInt > ((double) lowDeviceConfig.getMinRam());
                    int sDKVersionCode = DeviceUtils.getSDKVersionCode();
                    XesLog.i(tag, Intrinsics.stringPlus("随机点名低端设备检测系统版本=", Integer.valueOf(sDKVersionCode)));
                    boolean z2 = z && (sDKVersionCode == -1 || lowDeviceConfig.getMinSdkVersion() == 0 || lowDeviceConfig.getMinSdkVersion() <= sDKVersionCode);
                    XesLog.i(tag, Intrinsics.stringPlus("随机点名低端设备检测结果是否开启拉流 ", Boolean.valueOf(z2)));
                    valueOf = Boolean.valueOf(z2);
                }
            }
            bool = valueOf;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        RandomCallViewModel randomCallViewModel = this;
        XesLog.i(TAG, "随机点名低端设备检测默认开启拉流");
        return true;
    }
}
