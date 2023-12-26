package com.tal.app.thinkacademy.live.business.homework.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.photobox.listenbody.PhotoBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.photowall.PhotoWallViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowNoHomeworkBinding;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowNoHomeworkNewBinding;
import com.tal.app.thinkacademy.live.business.homework.entity.CorrectStatus;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.homework.entity.EmptySource;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEmpty;
import com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity;
import com.tal.app.thinkacademy.live.business.homework.entity.RewardType;
import com.tal.app.thinkacademy.live.business.homework.view.PhotoBoxDetailView;
import com.tal.app.thinkacademy.live.business.homework.view.PhotoBoxListView;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.ui.TakePhotoActivity;
import com.tal.app.thinkacademy.live.business.topic.config.TopicConfig;
import com.tal.app.thinkacademy.live.core.interfaces.IBaseLiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveControllerProvider;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.controller.LiveController;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "作业盒子插件", ircType = {"homework_box_check"}, launchType = "enter", moduleId = "-110")
@ViewLevels({@ViewLevel(level = 140, name = "PhotoBoxListView"), @ViewLevel(level = 140, name = "PhotoBoxDetailView")})
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u001c\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\u0017\u0010)\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u001bH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/driver/PhotoBoxPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/homework/driver/IPhotoBoxPlugin;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "mNoHomeworkPopup", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mPhotoBoxDetailView", "Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxDetailView;", "mPhotoBoxListView", "Lcom/tal/app/thinkacademy/live/business/homework/view/PhotoBoxListView;", "mPlanId", "", "Ljava/lang/Integer;", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/photobox/PhotoBoxViewModel;", "closeHomeworkDetail", "", "observeListener", "onDestroy", "onMessage", "ircTypeKey", "", "message", "resubmitDraw", "item", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEntity;", "resubmitPhoto", "showHomeworkDetail", "source", "Lcom/tal/app/thinkacademy/live/business/homework/entity/DetailSource;", "canCorrect", "", "showNoHomework", "empty", "Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkEmpty;", "syncCoins", "addCoins", "(Ljava/lang/Integer;)V", "wrapperDrawMessage", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoBoxPluginDriver.kt */
public final class PhotoBoxPluginDriver extends BaseLivePluginDriver implements IPhotoBoxPlugin {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.PHOTO_BOX;
    public static final String TARGET = "PhotoBoxPluginDriver.Observer";
    /* access modifiers changed from: private */
    public Context mContext = ((Context) this.mLiveRoomProvider.getWeakRefContext().get());
    private EasyPopup mNoHomeworkPopup;
    /* access modifiers changed from: private */
    public PhotoBoxDetailView mPhotoBoxDetailView;
    /* access modifiers changed from: private */
    public PhotoBoxListView mPhotoBoxListView;
    private Integer mPlanId;
    /* access modifiers changed from: private */
    public PhotoBoxViewModel mViewModel = PhotoBoxViewModelKt.getPhotoBoxViewModel(AbilityPackKt.getAbilityPack());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoBoxPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        CourseInfoProxy courseInfo;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Tag tag = TAG;
        XesLog.i(tag, "插件初始化");
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        Integer num = null;
        if (!(dataStorage == null || (courseInfo = dataStorage.getCourseInfo()) == null)) {
            num = Integer.valueOf(courseInfo.getPlanId());
        }
        this.mPlanId = num;
        int appScreenHeight = ScreenUtils.getAppScreenHeight();
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        float screenDensity = ScreenUtils.getScreenDensity();
        int screenDensityDpi = ScreenUtils.getScreenDensityDpi();
        XesLog.i(tag, "屏幕信息：height=" + appScreenHeight + ",width=" + appScreenWidth + ",density=" + screenDensity + ",dpi=" + screenDensityDpi);
        observeListener();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/driver/PhotoBoxPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PhotoBoxPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void observeListener() {
        ListenerData<PhotoBoxListenerBody> mListenerData;
        PhotoBoxViewModel photoBoxViewModel = this.mViewModel;
        if (photoBoxViewModel != null && (mListenerData = photoBoxViewModel.getMListenerData()) != null) {
            mListenerData.observeListener((LifecycleOwner) this, false, TARGET, new PhotoBoxPluginDriver$observeListener$1(this));
        }
    }

    public void showHomeworkDetail(DetailSource detailSource, HomeworkEntity homeworkEntity, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(detailSource, "source");
        Tag tag = TAG;
        XesLogTag xesLogTag = tag;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("准备打开详情，来源：");
        sb.append(detailSource.getValue());
        sb.append("，批发状态：");
        Integer num = null;
        sb.append(homeworkEntity == null ? null : Integer.valueOf(homeworkEntity.getCorrectStatus()));
        sb.append("，是否可批改：");
        sb.append(z);
        int i2 = 0;
        objArr[0] = sb.toString();
        XesLog.i(xesLogTag, objArr);
        closeHomeworkDetail();
        if (this.mPhotoBoxDetailView == null && this.mContext != null) {
            Context context = this.mContext;
            Intrinsics.checkNotNull(context);
            this.mPhotoBoxDetailView = new PhotoBoxDetailView(context, this);
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPhotoBoxDetailView, PhotoBoxPluginDriverKt.PHOTO_BOX_KEY_DETAIL_VIEW, LiveAreaContext.get().getScreenLp().newLp());
        }
        if (detailSource == DetailSource.IRC) {
            if (homeworkEntity != null) {
                num = Integer.valueOf(homeworkEntity.getRewardType());
            }
            int value = RewardType.NO_REWARD.getValue();
            if (num != null && num.intValue() == value) {
                XesLog.i(tag, "旧逻辑 rewardType = 0，批改后金币展示和数量受插件配置");
                if ((homeworkEntity.getCorrectStatus() == CorrectStatus.RIGHT.getValue() || homeworkEntity.getCorrectStatus() == CorrectStatus.WRONG.getValue() || homeworkEntity.getCorrectStatus() == CorrectStatus.HALF_CORRECT.getValue()) && (Intrinsics.areEqual(TopicConfig.INTERACT, homeworkEntity.getTagType()) || Intrinsics.areEqual("question", homeworkEntity.getTagType()))) {
                    int i3 = ShareDataManager.getInstance().getInt(Intrinsics.stringPlus("interact_correct_count_", homeworkEntity.getInteractId()), 0, ShareDataManager.SHAREDATA_USER);
                    PhotoWallViewModel viewModel = AbilityPackKt.getAbilityPack().getViewModel(PhotoWallViewModel.class);
                    if (!(viewModel != null && viewModel.isAddCoinCorrect()) || homeworkEntity.getCorrectStatus() != CorrectStatus.RIGHT.getValue()) {
                        i = 0;
                    } else {
                        i = i3 > 1 ? viewModel.getReviseCoin() : viewModel.getCorrectCoin();
                    }
                    XesLog.i(tag, "修改次数是 " + i3 + " 次");
                    i2 = i;
                }
            } else {
                int value2 = RewardType.CORRECT_REWARD.getValue();
                if (num != null && num.intValue() == value2) {
                    int rightCoin = homeworkEntity.getRightCoin();
                    XesLog.i(tag, "新逻辑 rewardType = 1，作答正确后金币展示和数量受140信令配置");
                    i2 = rightCoin;
                } else {
                    int value3 = RewardType.SUBMIT_REWARD.getValue();
                    if (num != null && num.intValue() == value3) {
                        XesLog.i(tag, "新逻辑 rewardType = 2，作答正确后不再奖励金币");
                    }
                }
            }
        }
        PhotoBoxDetailView photoBoxDetailView = this.mPhotoBoxDetailView;
        if (photoBoxDetailView != null) {
            photoBoxDetailView.showHomeWorkDetail(detailSource, homeworkEntity, z, i2);
        }
    }

    public void resubmitDraw(HomeworkEntity homeworkEntity) {
        Intrinsics.checkNotNullParameter(homeworkEntity, "item");
        if (!TextUtils.equals(ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR), homeworkEntity.getInteractId())) {
            ToastUtils.showShort(R.string.interaction_ended);
            return;
        }
        LiveController liveController = this.mLiveRoomProvider;
        ILiveControllerProvider iLiveControllerProvider = (LiveController) (liveController instanceof IBaseLiveControllerProvider ? (IBaseLiveControllerProvider) liveController : null);
        if (iLiveControllerProvider != null) {
            iLiveControllerProvider.dispatchIrcMessage("graffiti_board", wrapperDrawMessage());
        }
    }

    private final String wrapperDrawMessage() {
        String string = ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("sendTime", System.currentTimeMillis());
            jSONObject2.put("interactId", string);
            jSONObject2.put("pub", true);
            jSONObject2.put("totalTime", -1);
            jSONObject2.put("beginTime", -1);
            jSONObject2.put("imageUrl", ShareDataManager.getInstance().getString(ShareDataKey.CURRENT_INTERACT_BG, "", ShareDataManager.SHAREDATA_NOT_CLEAR));
            jSONObject2.put("planId", this.mPlanId);
            jSONObject2.put("extra", "graffiti");
            jSONObject.put("graffiti_board", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
        r1 = r1.getDataStorage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resubmitPhoto(com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.String r1 = "item"
            r2 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r3 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r4 = "current_interact_id"
            java.lang.String r5 = ""
            java.lang.String r11 = r1.getString(r4, r5, r3)
            r1 = r11
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = r19.getInteractId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x002d
            int r1 = com.tal.app.thinkacademy.live.business.R.string.interaction_ended
            com.tal.app.thinkacademy.lib.util.ToastUtils.showShort((int) r1)
            goto L_0x00ad
        L_0x002d:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r0.mLiveRoomProvider
            r2 = 0
            if (r1 != 0) goto L_0x0034
        L_0x0032:
            r1 = r2
            goto L_0x003f
        L_0x0034:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x003b
            goto L_0x0032
        L_0x003b:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r1 = r1.getCourseInfo()
        L_0x003f:
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r3 = r0.mLiveRoomProvider
            if (r3 != 0) goto L_0x0045
        L_0x0043:
            r3 = r2
            goto L_0x0050
        L_0x0045:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r3 = r3.getDataStorage()
            if (r3 != 0) goto L_0x004c
            goto L_0x0043
        L_0x004c:
            com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo r3 = r3.getTeacherInfo()
        L_0x0050:
            com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData r4 = new com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData
            if (r1 != 0) goto L_0x0056
            r7 = r2
            goto L_0x005f
        L_0x0056:
            int r5 = r1.getPlanId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7 = r5
        L_0x005f:
            if (r1 != 0) goto L_0x0063
            r8 = r2
            goto L_0x006c
        L_0x0063:
            int r5 = r1.getClassId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8 = r5
        L_0x006c:
            if (r1 != 0) goto L_0x0070
            r9 = r2
            goto L_0x0079
        L_0x0070:
            int r1 = r1.getTutorId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r9 = r1
        L_0x0079:
            if (r3 != 0) goto L_0x007d
            r10 = r2
            goto L_0x0082
        L_0x007d:
            java.lang.String r1 = r3.getId()
            r10 = r1
        L_0x0082:
            r1 = 0
            java.lang.Long r12 = java.lang.Long.valueOf(r1)
            java.lang.Long r13 = java.lang.Long.valueOf(r1)
            r1 = 1
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r1)
            r15 = 0
            r16 = 256(0x100, float:3.59E-43)
            r17 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver$$ExternalSyntheticLambda1 r2 = new com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver$$ExternalSyntheticLambda1
            r2.<init>(r0, r4)
            r3 = 500(0x1f4, double:2.47E-321)
            r1.postDelayed(r2, r3)
        L_0x00ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver.resubmitPhoto(com.tal.app.thinkacademy.live.business.homework.entity.HomeworkEntity):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: resubmitPhoto$lambda-0  reason: not valid java name */
    public static final void m268resubmitPhoto$lambda0(PhotoBoxPluginDriver photoBoxPluginDriver, PhotosMaintainData photosMaintainData) {
        Intrinsics.checkNotNullParameter(photoBoxPluginDriver, "this$0");
        Intrinsics.checkNotNullParameter(photosMaintainData, "$data");
        TakePhotoActivity.Companion.startActivity(photoBoxPluginDriver.mContext, photosMaintainData);
    }

    public void closeHomeworkDetail() {
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mPhotoBoxDetailView);
        }
        this.mPhotoBoxDetailView = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        r11 = (r11 = r11.getDataStorage()).getUserInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void syncCoins(java.lang.Integer r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0005
            goto L_0x007e
        L_0x0005:
            java.lang.Number r11 = (java.lang.Number) r11
            int r3 = r11.intValue()
            com.tal.app.thinkacademy.live.Tag r11 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "同步金币，要加的金币是: "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r4)
            r1[r2] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r1)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r11 = r10.mLiveRoomProvider
            if (r11 != 0) goto L_0x0028
        L_0x0026:
            r11 = r0
            goto L_0x003f
        L_0x0028:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r11 = r11.getDataStorage()
            if (r11 != 0) goto L_0x002f
            goto L_0x0026
        L_0x002f:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r11 = r11.getUserInfo()
            if (r11 != 0) goto L_0x0036
            goto L_0x0026
        L_0x0036:
            int r11 = r11.getGoldNum()
            int r11 = r11 + r3
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
        L_0x003f:
            if (r11 != 0) goto L_0x0042
            goto L_0x007e
        L_0x0042:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r1 = r10.mLiveRoomProvider
            if (r1 != 0) goto L_0x004d
            goto L_0x0058
        L_0x004d:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r1 = r1.getDataStorage()
            if (r1 != 0) goto L_0x0054
            goto L_0x0058
        L_0x0054:
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r0 = r1.getUserInfo()
        L_0x0058:
            if (r0 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r0.setGoldNum(r11)
        L_0x005e:
            com.tal.app.thinkacademy.live.core.plugin.PluginEventData r0 = new com.tal.app.thinkacademy.live.core.plugin.PluginEventData
            java.lang.Class<com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver> r8 = com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver.class
            java.lang.String r11 = java.lang.String.valueOf(r11)
            com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData r9 = new com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            java.lang.String r2 = "拍照上墙"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.lang.String r1 = "usercoins_key"
            r0.<init>(r8, r1, r11, r9)
            com.tal.app.thinkacademy.live.core.plugin.PluginEventBus.onEvent(r1, r0)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            r0 = r11
        L_0x007e:
            if (r0 != 0) goto L_0x008b
            r11 = r10
            com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver r11 = (com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver) r11
            com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel r11 = r10.mViewModel
            if (r11 != 0) goto L_0x0088
            goto L_0x008b
        L_0x0088:
            r11.syncCoins()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.homework.driver.PhotoBoxPluginDriver.syncCoins(java.lang.Integer):void");
    }

    /* access modifiers changed from: private */
    public final void showNoHomework(HomeworkEmpty homeworkEmpty) {
        ViewBinding viewBinding;
        boolean z = true;
        XesLog.i(TAG, "无作业数据，显示空view");
        if (this.mNoHomeworkPopup == null) {
            PhotoBoxPluginDriver photoBoxPluginDriver = this;
            float f = 146.0f;
            float f2 = 130.0f;
            if (homeworkEmpty.getSource() == EmptySource.FUN) {
                LiveBusinessPopupwindowNoHomeworkNewBinding inflate = LiveBusinessPopupwindowNoHomeworkNewBinding.inflate(LayoutInflater.from(this.mContext));
                Intrinsics.checkNotNullExpressionValue(inflate, "{\n                LiveBu…(mContext))\n            }");
                viewBinding = (ViewBinding) inflate;
            } else {
                f = 133.0f;
                f2 = 48.0f;
                LiveBusinessPopupwindowNoHomeworkBinding inflate2 = LiveBusinessPopupwindowNoHomeworkBinding.inflate(LayoutInflater.from(this.mContext));
                Intrinsics.checkNotNullExpressionValue(inflate2, "{\n                width …(mContext))\n            }");
                viewBinding = (ViewBinding) inflate2;
            }
            EasyPopup easyPopup = new EasyPopup(this.mContext);
            easyPopup.setContentView(viewBinding.getRoot()).setWidth(SizeUtils.dp2px(f)).setHeight(SizeUtils.dp2px(f2)).setFocusAndOutsideEnable(true).createPopup();
            this.mNoHomeworkPopup = easyPopup;
        }
        EasyPopup easyPopup2 = this.mNoHomeworkPopup;
        if (easyPopup2 == null || easyPopup2.isShowing()) {
            z = false;
        }
        if (z) {
            EasyPopup easyPopup3 = this.mNoHomeworkPopup;
            if (easyPopup3 != null) {
                easyPopup3.showAsDropDown(homeworkEmpty.getAnchor(), homeworkEmpty.getOffsetX(), homeworkEmpty.getOffsetY(), homeworkEmpty.getGravity());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new PhotoBoxPluginDriver$$ExternalSyntheticLambda0(this), 3000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoHomework$lambda-6  reason: not valid java name */
    public static final void m269showNoHomework$lambda6(PhotoBoxPluginDriver photoBoxPluginDriver) {
        EasyPopup easyPopup;
        Intrinsics.checkNotNullParameter(photoBoxPluginDriver, "this$0");
        EasyPopup easyPopup2 = photoBoxPluginDriver.mNoHomeworkPopup;
        boolean z = false;
        if (easyPopup2 != null && easyPopup2.isShowing()) {
            z = true;
        }
        if (z && (easyPopup = photoBoxPluginDriver.mNoHomeworkPopup) != null) {
            easyPopup.dismiss();
        }
    }

    public void onMessage(String str, String str2) {
        PhotoBoxViewModel photoBoxViewModel;
        if (Intrinsics.areEqual(str, PhotoBoxPluginDriverKt.PHOTO_BOX_KEY_IRC) && str2 != null && (photoBoxViewModel = this.mViewModel) != null) {
            photoBoxViewModel.onReceiveMessage(str2);
        }
    }

    public void onDestroy() {
        XesLog.i(TAG, "插件销毁");
    }
}
