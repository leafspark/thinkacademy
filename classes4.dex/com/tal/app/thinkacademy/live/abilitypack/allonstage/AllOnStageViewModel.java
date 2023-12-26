package com.tal.app.thinkacademy.live.abilitypack.allonstage;

import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.PhoneUtils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.cloud.DeviceConfig;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.cloud.OnStageData;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.AllOnStageListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.ExitCourse;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.OnStageChanged;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.listenbody.PermissionOpenControl;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.util.EmojiUtil;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ExitLiveRoom;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020)J\b\u0010-\u001a\u0004\u0018\u00010.J\b\u0010/\u001a\u0004\u0018\u00010\u0014J\u0006\u00100\u001a\u00020\u0006J\b\u00101\u001a\u00020)H\u0014J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u000204J\u0012\u00105\u001a\u00020)2\n\u00103\u001a\u0006\u0012\u0002\b\u000306R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mIsOnStage", "", "getMIsOnStage", "()Z", "setMIsOnStage", "(Z)V", "mListenerBody", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/listenbody/AllOnStageListenerBody;", "getMListenerBody", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mOnstageInit", "getMOnstageInit", "setMOnstageInit", "mSelfBean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "getMSelfBean", "()Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "setMSelfBean", "(Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;)V", "mUid", "", "getMUid", "()J", "setMUid", "(J)V", "mUserInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getMUserInfoProxy", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "setMUserInfoProxy", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;)V", "dispatchPermissionOpenControl", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "enableOnStage", "", "enable", "exit", "exitCourse", "getCourseName", "", "getSelfBean", "isOpenStream", "onVmDestroy", "sendPadEmojiMsg", "it", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "sendPhoneEmojiMsg", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageViewModel.kt */
public final class AllOnStageViewModel extends AbilityViewModel {
    public static final String CLOUD_KEY = "hw_allonstage_config";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AllOnStageViewModel";
    private boolean mIsOnStage;
    private final ListenerData<AllOnStageListenerBody> mListenerBody = new ListenerData<>();
    private boolean mOnstageInit;
    private StudentVideoBean.ListBean mSelfBean;
    private long mUid = -1;
    private UserInfoProxy mUserInfoProxy;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllOnStageViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        RoomData roomData;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        UserInfoProxy userInfo = dataStorage == null ? null : dataStorage.getUserInfo();
        this.mUserInfoProxy = userInfo;
        if (userInfo != null) {
            String id = userInfo.getId();
            Intrinsics.checkNotNullExpressionValue(id, "it.id");
            setMUid(Util.toLongOrDefault(id, -1));
        }
        DataStorage dataStorage2 = iLiveRoomProvider.getDataStorage();
        boolean z = false;
        if (!(dataStorage2 == null || (roomData = dataStorage2.getRoomData()) == null)) {
            z = roomData.isIsOnStage();
        }
        this.mIsOnStage = z;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/AllOnStageViewModel$Companion;", "", "()V", "CLOUD_KEY", "", "TAG", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStageViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ListenerData<AllOnStageListenerBody> getMListenerBody() {
        return this.mListenerBody;
    }

    public final UserInfoProxy getMUserInfoProxy() {
        return this.mUserInfoProxy;
    }

    public final void setMUserInfoProxy(UserInfoProxy userInfoProxy) {
        this.mUserInfoProxy = userInfoProxy;
    }

    public final StudentVideoBean.ListBean getMSelfBean() {
        return this.mSelfBean;
    }

    public final void setMSelfBean(StudentVideoBean.ListBean listBean) {
        this.mSelfBean = listBean;
    }

    public final boolean getMOnstageInit() {
        return this.mOnstageInit;
    }

    public final void setMOnstageInit(boolean z) {
        this.mOnstageInit = z;
    }

    public final boolean getMIsOnStage() {
        return this.mIsOnStage;
    }

    public final void setMIsOnStage(boolean z) {
        this.mIsOnStage = z;
    }

    public final long getMUid() {
        return this.mUid;
    }

    public final void setMUid(long j) {
        this.mUid = j;
    }

    public final void enableOnStage(boolean z) {
        this.mOnstageInit = true;
        this.mIsOnStage = z;
        this.mListenerBody.setStickyData(new OnStageChanged(this.mIsOnStage));
    }

    public final String getCourseName() {
        PlanInfoProxy planInfo;
        DataStorage dataStorage = getMLiveRoomProvider().getDataStorage();
        if (dataStorage == null || (planInfo = dataStorage.getPlanInfo()) == null) {
            return null;
        }
        return planInfo.getName();
    }

    public final void sendPhoneEmojiMsg(EmojiBean<?> emojiBean) {
        Intrinsics.checkNotNullParameter(emojiBean, "it");
        EmojiUtil.sendPhoneEmojiMsg(getMLiveRoomProvider(), emojiBean);
    }

    public final void sendPadEmojiMsg(EmojiAssembleBean emojiAssembleBean) {
        Intrinsics.checkNotNullParameter(emojiAssembleBean, "it");
        EmojiUtil.sendPadEmojiMsg(getMLiveRoomProvider(), emojiAssembleBean);
    }

    public final void exit() {
        this.mListenerBody.setStickyData(new ExitCourse());
    }

    public final StudentVideoBean.ListBean getSelfBean() {
        StudentVideoBean.ListBean listBean = this.mSelfBean;
        if (listBean != null) {
            return listBean;
        }
        AllOnStageViewModel allOnStageViewModel = this;
        UserInfoProxy mUserInfoProxy2 = getMUserInfoProxy();
        if (mUserInfoProxy2 == null) {
            return null;
        }
        StudentVideoBean.ListBean listBean2 = new StudentVideoBean.ListBean();
        listBean2.setNickName(mUserInfoProxy2.getNickName());
        listBean2.setAvatar(mUserInfoProxy2.getAvatar());
        listBean2.setLevel(mUserInfoProxy2.getLevel());
        String id = mUserInfoProxy2.getId();
        Intrinsics.checkNotNullExpressionValue(id, "id");
        listBean2.setUserId(Util.toLongOrDefault(id, 0));
        setMSelfBean(listBean2);
        return listBean2;
    }

    public final boolean isOpenStream() {
        OnStageData onStageData;
        boolean valueOf;
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        Boolean bool = null;
        try {
            onStageData = (OnStageData) GsonUtils.fromJson(HwCloudControlHelper.Companion.get().getCloudKeyValue(CLOUD_KEY), OnStageData.class);
        } catch (Exception e) {
            XesLog.it(TAG, "isOpenStream OnStageData 数据解析失败", e);
            onStageData = null;
        }
        if (onStageData != null) {
            ArrayList<String> deviceList = onStageData.getDeviceList();
            if (deviceList != null && deviceList.contains(uniqueDeviceId)) {
                XesLog.it(TAG, "isOpenStream 命中黑名单");
                valueOf = false;
            } else {
                DeviceConfig lowDeviceConfig = onStageData.getLowDeviceConfig();
                if (lowDeviceConfig != null) {
                    boolean z = lowDeviceConfig.getMinRam() == 0 || PhoneUtils.getRamMaxMemoryInt(1024) > ((double) lowDeviceConfig.getMinRam());
                    int sDKVersionCode = DeviceUtils.getSDKVersionCode();
                    boolean z2 = z && (sDKVersionCode == -1 || lowDeviceConfig.getMinSdkVersion() == 0 || lowDeviceConfig.getMinSdkVersion() <= sDKVersionCode);
                    XesLog.it(TAG, Intrinsics.stringPlus("isOpenStream 低设备检测 ", Boolean.valueOf(z2)));
                    valueOf = Boolean.valueOf(z2);
                }
            }
            bool = valueOf;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        AllOnStageViewModel allOnStageViewModel = this;
        XesLog.it(TAG, "isOpenStream 默认开启");
        return true;
    }

    public final boolean dispatchPermissionOpenControl(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!this.mIsOnStage) {
            return false;
        }
        this.mListenerBody.setStickyData(new PermissionOpenControl(type));
        return true;
    }

    public final void exitCourse() {
        XesLog.it("全员上台，退出教室", new Object[0]);
        getMLiveRoomProvider().backLiveRoom(ExitLiveRoom.NORMAL_EXIT);
    }
}
