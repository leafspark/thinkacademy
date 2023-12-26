package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.PermissionHelper;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModel;
import com.tal.app.thinkacademy.live.abilitypack.photobox.PhotoBoxViewModelKt;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.homework.entity.DetailSource;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.photosonthewall.api.PhotosOnTheWallApi;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.OpenStatusBody;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotoSubmitResult;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosMaintainData;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallBean;
import com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallView;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallViewState;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J\u001c\u0010;\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\b\u0010?\u001a\u000209H\u0002J\u0010\u0010@\u001a\u0002092\u0006\u0010A\u001a\u00020BH\u0002J\u0012\u0010C\u001a\u0002092\b\u0010D\u001a\u0004\u0018\u00010%H\u0002J\b\u0010E\u001a\u000209H\u0002J\u000e\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006H"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/BasePhotosOnTheWallPlugin;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "KCLOSE", "", "KCLOSESUCCESS", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "isOnDestroy", "", "mClassId", "getMClassId", "()Ljava/lang/Integer;", "setMClassId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mCourseInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "getMCourseInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "setMCourseInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;)V", "mHandler", "Landroid/os/Handler;", "mInteractionEnd", "Landroidx/lifecycle/Observer;", "", "mIsSmallClass", "mPhotoSubmissionResult", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotoSubmitResult;", "mPhotosOnTheWallBean", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallBean;", "mPhotosOnTheWallState", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallState;", "mPhotosOnTheWallView", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/view/PhotosOnTheWallView;", "mPhotosUploadResult", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosUploadResult;", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "getMTeacherInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "setMTeacherInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;)V", "userInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getUserInfoProxy", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "setUserInfoProxy", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;)V", "loadPlugin", "", "onDestroy", "onMessage", "ircTypeKey", "", "message", "registerTakePhotoStateBus", "removePlugin", "delayMillis", "", "requestOpenStatus", "photosOnTheWallBean", "stopAnswer", "updateUserCoins", "addCoins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePhotosOnTheWallPlugin.kt */
public class BasePhotosOnTheWallPlugin extends BaseLivePluginDriver {
    /* access modifiers changed from: private */
    public final int KCLOSE;
    /* access modifiers changed from: private */
    public final int KCLOSESUCCESS = 2;
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.BasePhotosOnTheWallPlugin;
    /* access modifiers changed from: private */
    public boolean isOnDestroy;
    private Integer mClassId = 0;
    private Context mContext;
    private CourseInfoProxy mCourseInfo;
    private Handler mHandler;
    private final Observer<Object> mInteractionEnd;
    private boolean mIsSmallClass;
    private final Observer<PhotoSubmitResult> mPhotoSubmissionResult;
    private PhotosOnTheWallBean mPhotosOnTheWallBean;
    /* access modifiers changed from: private */
    public PhotosOnTheWallState mPhotosOnTheWallState;
    /* access modifiers changed from: private */
    public PhotosOnTheWallView mPhotosOnTheWallView;
    /* access modifiers changed from: private */
    public PhotosUploadResult mPhotosUploadResult = PhotosUploadResult.Unsubmitted;
    private TeacherInfo mTeacherInfo;
    private UserInfoProxy userInfoProxy;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BasePhotosOnTheWallPlugin.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhotosUploadResult.values().length];
            iArr[PhotosUploadResult.SubmittedSuccessfully.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BasePhotosOnTheWallPlugin(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        UserInfoProxy userInfoProxy2;
        CourseInfoProxy courseInfoProxy;
        TeacherInfo teacherInfo;
        DataStorage dataStorage;
        DataStorage dataStorage2;
        DataStorage dataStorage3;
        this.mHandler = new BasePhotosOnTheWallPlugin$mHandler$1(this, iLiveRoomProvider, Looper.getMainLooper());
        BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda0 basePhotosOnTheWallPlugin$$ExternalSyntheticLambda0 = new BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda0(this);
        this.mPhotoSubmissionResult = basePhotosOnTheWallPlugin$$ExternalSyntheticLambda0;
        BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda2 basePhotosOnTheWallPlugin$$ExternalSyntheticLambda2 = new BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda2(this);
        this.mInteractionEnd = basePhotosOnTheWallPlugin$$ExternalSyntheticLambda2;
        String str = null;
        if (iLiveRoomProvider != null) {
            WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
            this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        }
        if (iLiveRoomProvider == null || (dataStorage3 = iLiveRoomProvider.getDataStorage()) == null) {
            userInfoProxy2 = null;
        } else {
            userInfoProxy2 = dataStorage3.getUserInfo();
        }
        this.userInfoProxy = userInfoProxy2;
        if (iLiveRoomProvider == null || (dataStorage2 = iLiveRoomProvider.getDataStorage()) == null) {
            courseInfoProxy = null;
        } else {
            courseInfoProxy = dataStorage2.getCourseInfo();
        }
        this.mCourseInfo = courseInfoProxy;
        if (iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null) {
            teacherInfo = null;
        } else {
            teacherInfo = dataStorage.getTeacherInfo();
        }
        this.mTeacherInfo = teacherInfo;
        CourseInfoProxy courseInfoProxy2 = this.mCourseInfo;
        this.mClassId = courseInfoProxy2 == null ? null : Integer.valueOf(courseInfoProxy2.getClassId());
        this.mIsSmallClass = Intrinsics.areEqual("2", iLiveRoomProvider != null ? iLiveRoomProvider.getClassType() : str);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.PHOTO_SUBMISSION_RESULT).observe(lifecycleOwner, basePhotosOnTheWallPlugin$$ExternalSyntheticLambda0);
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL).observe(lifecycleOwner, basePhotosOnTheWallPlugin$$ExternalSyntheticLambda2);
        registerTakePhotoStateBus();
    }

    /* access modifiers changed from: protected */
    public final UserInfoProxy getUserInfoProxy() {
        return this.userInfoProxy;
    }

    /* access modifiers changed from: protected */
    public final void setUserInfoProxy(UserInfoProxy userInfoProxy2) {
        this.userInfoProxy = userInfoProxy2;
    }

    /* access modifiers changed from: protected */
    public final CourseInfoProxy getMCourseInfo() {
        return this.mCourseInfo;
    }

    /* access modifiers changed from: protected */
    public final void setMCourseInfo(CourseInfoProxy courseInfoProxy) {
        this.mCourseInfo = courseInfoProxy;
    }

    /* access modifiers changed from: protected */
    public final TeacherInfo getMTeacherInfo() {
        return this.mTeacherInfo;
    }

    /* access modifiers changed from: protected */
    public final void setMTeacherInfo(TeacherInfo teacherInfo) {
        this.mTeacherInfo = teacherInfo;
    }

    /* access modifiers changed from: protected */
    public final Integer getMClassId() {
        return this.mClassId;
    }

    /* access modifiers changed from: protected */
    public final void setMClassId(Integer num) {
        this.mClassId = num;
    }

    /* access modifiers changed from: private */
    /* renamed from: mPhotoSubmissionResult$lambda-0  reason: not valid java name */
    public static final void m359mPhotoSubmissionResult$lambda0(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin, PhotoSubmitResult photoSubmitResult) {
        Intrinsics.checkNotNullParameter(basePhotosOnTheWallPlugin, "this$0");
        if (!basePhotosOnTheWallPlugin.isOnDestroy) {
            XesLog.i(basePhotosOnTheWallPlugin.TAG, Intrinsics.stringPlus("mPhotoSubmissionResult --> ", photoSubmitResult));
            PhotosUploadResult photoSubmissionResult = photoSubmitResult.getPhotoSubmissionResult();
            if ((photoSubmissionResult == null ? -1 : WhenMappings.$EnumSwitchMapping$0[photoSubmissionResult.ordinal()]) == 1) {
                basePhotosOnTheWallPlugin.mPhotosUploadResult = PhotosUploadResult.SubmittedSuccessfully;
                PhotosOnTheWallView photosOnTheWallView = basePhotosOnTheWallPlugin.mPhotosOnTheWallView;
                if (photosOnTheWallView != null) {
                    photosOnTheWallView.loadSubmitSuccess(photoSubmitResult.getUserLatestCoin(), photoSubmitResult.getRightCoin());
                }
                PhotosOnTheWallView photosOnTheWallView2 = basePhotosOnTheWallPlugin.mPhotosOnTheWallView;
                if (photosOnTheWallView2 != null) {
                    photosOnTheWallView2.loadView(PhotosOnTheWallViewState.SubmitSuccess);
                }
                Handler handler = basePhotosOnTheWallPlugin.mHandler;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(basePhotosOnTheWallPlugin.KCLOSESUCCESS, 3000);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mInteractionEnd$lambda-1  reason: not valid java name */
    public static final void m358mInteractionEnd$lambda1(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin, Object obj) {
        Intrinsics.checkNotNullParameter(basePhotosOnTheWallPlugin, "this$0");
        if (!basePhotosOnTheWallPlugin.isOnDestroy) {
            XesLog.i(basePhotosOnTheWallPlugin.TAG, "收到点赞的拍照上墙互动线束通知");
            basePhotosOnTheWallPlugin.removePlugin(0);
            PhotoBoxViewModel photoBoxViewModel = PhotoBoxViewModelKt.getPhotoBoxViewModel(AbilityPackKt.getAbilityPack());
            if (photoBoxViewModel != null) {
                photoBoxViewModel.closeBox(DetailSource.IRC);
            }
        }
    }

    public void onMessage(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        CharSequence charSequence = str4;
        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual(BasePhotosOnTheWallPluginKt.PhotosOnTheWallIrcTypeKey, str3)) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("ircTypeKey = ", str4));
            try {
                Intrinsics.checkNotNull(str2);
                JSONObject optJSONObject = new JSONObject(str4).optJSONObject(str3);
                if (optJSONObject != null) {
                    this.mPhotosOnTheWallBean = (PhotosOnTheWallBean) GsonUtils.fromJson(!(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), PhotosOnTheWallBean.class);
                    LeanplumUtil leanplumUtil = LeanplumUtil.INSTANCE;
                    CourseInfoProxy mCourseInfo2 = getMCourseInfo();
                    String str5 = null;
                    String valueOf = String.valueOf(mCourseInfo2 == null ? null : Integer.valueOf(mCourseInfo2.getCourseId()));
                    String valueOf2 = String.valueOf(getMClassId());
                    PhotosOnTheWallBean photosOnTheWallBean = this.mPhotosOnTheWallBean;
                    LeanplumUtil.longTrack$default(LeanplumUtil.show_photowall, valueOf2, valueOf, (String) null, (String) null, (String) null, (String) null, (String) null, String.valueOf(System.currentTimeMillis()), (String) null, (String) null, (String) null, String.valueOf(photosOnTheWallBean == null ? null : photosOnTheWallBean.getInteractId()), EnterRoomMuteData.STATUS_UN_MUTE, 3832, (Object) null);
                    PhotosOnTheWallBean photosOnTheWallBean2 = this.mPhotosOnTheWallBean;
                    if (photosOnTheWallBean2 != null) {
                        if (Intrinsics.areEqual(photosOnTheWallBean2.getPub(), true)) {
                            ShareDataManager instance = ShareDataManager.getInstance();
                            PhotosOnTheWallBean photosOnTheWallBean3 = this.mPhotosOnTheWallBean;
                            instance.put(ShareDataKey.CURRENT_INTERACT_ID, photosOnTheWallBean3 == null ? null : photosOnTheWallBean3.getInteractId(), ShareDataManager.SHAREDATA_NOT_CLEAR);
                            XesLog.i(this.TAG, "拍照上墙 ---> send start");
                            PhotosOnTheWallBean photosOnTheWallBean4 = this.mPhotosOnTheWallBean;
                            if (photosOnTheWallBean4 != null) {
                                str5 = photosOnTheWallBean4.getInteractId();
                            }
                            InteractReportKt.XesLogReport$default("start", "Photopost", String.valueOf(str5), (Integer) null, (String) null, 24, (Object) null);
                            this.mPhotosUploadResult = PhotosUploadResult.Unsubmitted;
                            requestOpenStatus(this.mPhotosOnTheWallBean);
                            SoundPoolUtils.play(this.mContext, R.raw.live_business_take_photo_show, 0);
                            return;
                        }
                        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE).postStickyData(DataBusKey.PHOTO_ON_THE_WALL_CLOSE);
                        XesLog.i(this.TAG, "拍照上墙 ---> send end");
                        PhotosOnTheWallBean photosOnTheWallBean5 = this.mPhotosOnTheWallBean;
                        if (photosOnTheWallBean5 != null) {
                            str5 = photosOnTheWallBean5.getInteractId();
                        }
                        InteractReportKt.XesLogReport$default("end", "Photopost", String.valueOf(str5), (Integer) null, (String) null, 24, (Object) null);
                        PhotosOnTheWallState photosOnTheWallState = this.mPhotosOnTheWallState;
                        if (photosOnTheWallState != null) {
                            Intrinsics.checkNotNull(photosOnTheWallState);
                            Integer interactStatus = photosOnTheWallState.getInteractStatus();
                            if (interactStatus != null) {
                                if (interactStatus.intValue() == 1) {
                                    XesLog.i(this.TAG, "拍照上墙 ---> send end --> interactStatus = 1");
                                    PhotosOnTheWallState photosOnTheWallState2 = this.mPhotosOnTheWallState;
                                    Intrinsics.checkNotNull(photosOnTheWallState2);
                                    if (!Intrinsics.areEqual(photosOnTheWallState2.isSubmit(), false)) {
                                        XesLog.i(this.TAG, "拍照上墙 ---> send end --> isSubmit != false");
                                        stopAnswer();
                                        return;
                                    } else if (this.mPhotosUploadResult == PhotosUploadResult.SubmittedSuccessfully) {
                                        XesLog.i(this.TAG, "拍照上墙 ---> send end --> mPhotosUploadResult = SubmittedSuccessfully");
                                        stopAnswer();
                                        return;
                                    } else {
                                        XesLog.i(this.TAG, "拍照上墙 ---> send end --> mPhotosUploadResult = SubmissionFailed");
                                        this.mPhotosUploadResult = PhotosUploadResult.SubmissionFailed;
                                        stopAnswer();
                                        return;
                                    }
                                }
                            }
                            stopAnswer();
                            return;
                        }
                        stopAnswer();
                    }
                }
            } catch (Exception e) {
                XesLog.e(this.TAG, Intrinsics.stringPlus("e --> ", e.getMessage()));
                onDestroy();
            }
        }
    }

    private final void requestOpenStatus(PhotosOnTheWallBean photosOnTheWallBean) {
        XesLog.i(this.TAG, "requestOpenStatus");
        if (photosOnTheWallBean != null) {
            PhotosOnTheWallApi photosOnTheWallApi = (PhotosOnTheWallApi) Api.create(PhotosOnTheWallApi.class);
            String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/wall/student/status");
            String planId = photosOnTheWallBean.getPlanId();
            Call<HiResponse<PhotosOnTheWallState>> requestOpenStatus = photosOnTheWallApi.requestOpenStatus(stringPlus, new OpenStatusBody(planId == null ? null : Long.valueOf(Long.parseLong(planId)), photosOnTheWallBean.getInteractId()));
            Callback basePhotosOnTheWallPlugin$requestOpenStatus$1 = new BasePhotosOnTheWallPlugin$requestOpenStatus$1(this, new BasePhotosOnTheWallPlugin$requestOpenStatus$2(this));
            if (!(requestOpenStatus instanceof Call)) {
                requestOpenStatus.enqueue(basePhotosOnTheWallPlugin$requestOpenStatus$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) requestOpenStatus, basePhotosOnTheWallPlugin$requestOpenStatus$1);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void loadPlugin() {
        PhotosOnTheWallBean photosOnTheWallBean;
        String planId;
        Handler handler = this.mHandler;
        String str = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        Context context = this.mContext;
        if (context != null && (photosOnTheWallBean = this.mPhotosOnTheWallBean) != null) {
            ShareDataManager.getInstance().put(ShareDataKey.IS_TAKE_PHOTO, true, ShareDataManager.SHAREDATA_CAN_CLEAR);
            if (this.mPhotosOnTheWallView == null) {
                this.mPhotosOnTheWallView = new PhotosOnTheWallView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPhotosOnTheWallView, this.mPluginConfData.getViewLevel(BasePhotosOnTheWallPluginKt.PhotosOnTheWallPluginKey), LiveAreaContext.get().getScreenLp().newLp());
                String interactId = photosOnTheWallBean.getInteractId();
                String planId2 = photosOnTheWallBean.getPlanId();
                int parseInt = planId2 == null ? 0 : Integer.parseInt(planId2);
                Integer mClassId2 = getMClassId();
                InteractLogReport.uploadLog(interactId, parseInt, mClassId2 == null ? 0 : mClassId2.intValue());
            }
            PhotosOnTheWallView photosOnTheWallView = this.mPhotosOnTheWallView;
            if (photosOnTheWallView != null) {
                photosOnTheWallView.setDriver(this);
            }
            PhotosOnTheWallBean photosOnTheWallBean2 = this.mPhotosOnTheWallBean;
            InteractReportKt.XesLogReport$default("showBoard", "Photopost", String.valueOf(photosOnTheWallBean2 == null ? null : photosOnTheWallBean2.getInteractId()), 1, (String) null, 16, (Object) null);
            XesLog.i(this.TAG, "loadPlugin --> 加载成功");
            PhotosOnTheWallView photosOnTheWallView2 = this.mPhotosOnTheWallView;
            if (photosOnTheWallView2 != null) {
                PhotosOnTheWallBean photosOnTheWallBean3 = this.mPhotosOnTheWallBean;
                Integer valueOf = (photosOnTheWallBean3 == null || (planId = photosOnTheWallBean3.getPlanId()) == null) ? null : Integer.valueOf(Integer.parseInt(planId));
                Integer mClassId3 = getMClassId();
                CourseInfoProxy mCourseInfo2 = getMCourseInfo();
                Integer valueOf2 = mCourseInfo2 == null ? null : Integer.valueOf(mCourseInfo2.getTutorId());
                TeacherInfo mTeacherInfo2 = getMTeacherInfo();
                String id = mTeacherInfo2 == null ? null : mTeacherInfo2.getId();
                PhotosOnTheWallBean photosOnTheWallBean4 = this.mPhotosOnTheWallBean;
                if (photosOnTheWallBean4 != null) {
                    str = photosOnTheWallBean4.getInteractId();
                }
                String str2 = str;
                Long valueOf3 = Long.valueOf(photosOnTheWallBean.getTotalTime());
                Long beginTime = photosOnTheWallBean.getBeginTime();
                photosOnTheWallView2.startCountdown(new PhotosMaintainData(valueOf, mClassId3, valueOf2, id, str2, valueOf3, Long.valueOf(beginTime == null ? 0 : beginTime.longValue()), (Boolean) null, photosOnTheWallBean.getRewardType(), LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP, (DefaultConstructorMarker) null));
            }
            PhotosOnTheWallState photosOnTheWallState = this.mPhotosOnTheWallState;
            if (photosOnTheWallState != null) {
                Intrinsics.checkNotNull(photosOnTheWallState);
                Integer interactStatus = photosOnTheWallState.getInteractStatus();
                if (interactStatus != null && interactStatus.intValue() == 1) {
                    PhotosOnTheWallState photosOnTheWallState2 = this.mPhotosOnTheWallState;
                    Intrinsics.checkNotNull(photosOnTheWallState2);
                    if (!Intrinsics.areEqual(photosOnTheWallState2.isSubmit(), false)) {
                        PhotosOnTheWallView photosOnTheWallView3 = this.mPhotosOnTheWallView;
                        if (photosOnTheWallView3 != null) {
                            photosOnTheWallView3.loadView(PhotosOnTheWallViewState.OnlyCountdown);
                            return;
                        }
                        return;
                    }
                    PermissionHelper.INSTANCE.request((FragmentActivity) context, new String[]{"android.permission.CAMERA"}, new BasePhotosOnTheWallPlugin$loadPlugin$1$1$1(this));
                    return;
                }
                PhotosOnTheWallView photosOnTheWallView4 = this.mPhotosOnTheWallView;
                if (photosOnTheWallView4 != null) {
                    photosOnTheWallView4.loadView(PhotosOnTheWallViewState.OnlyCountdown);
                    return;
                }
                return;
            }
            PhotosOnTheWallView photosOnTheWallView5 = this.mPhotosOnTheWallView;
            if (photosOnTheWallView5 != null) {
                photosOnTheWallView5.loadView(PhotosOnTheWallViewState.OnlyCountdown);
            }
        }
    }

    private final void stopAnswer() {
        PhotosOnTheWallView photosOnTheWallView = this.mPhotosOnTheWallView;
        if (photosOnTheWallView != null) {
            photosOnTheWallView.loadView(PhotosOnTheWallViewState.StopAnswer);
        }
    }

    /* access modifiers changed from: private */
    public final void removePlugin(long j) {
        XesLog.i(this.TAG, "loadPlugin --> removePlugin");
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(this.KCLOSE, j);
        }
    }

    public final void updateUserCoins(int i) {
        DataStorage dataStorage;
        UserInfoProxy userInfo;
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        Integer num = null;
        if (!(iLiveRoomProvider == null || (dataStorage = iLiveRoomProvider.getDataStorage()) == null || (userInfo = dataStorage.getUserInfo()) == null)) {
            num = Integer.valueOf(userInfo.getGoldNum() + i);
        }
        XesLog.i(this.TAG, "同步金币 :本次新增 " + i + "，所有金币 " + num);
        PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(BasePhotosOnTheWallPlugin.class, DataBusKey.USERCOINS_KEY, String.valueOf(num), new CoinEventData(GoldSource.PHOTOS_ON_THE_WALL_GOLD, i, false, false, 12, (DefaultConstructorMarker) null)));
    }

    public void onDestroy() {
        this.isOnDestroy = true;
        this.mPhotosUploadResult = PhotosUploadResult.Unsubmitted;
        XesDataBus.with(DataBusKey.PHOTO_SUBMISSION_RESULT).removeObserver(this.mPhotoSubmissionResult);
        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL).removeObserver(this.mInteractionEnd);
        this.mPhotosOnTheWallBean = null;
        this.mPhotosOnTheWallState = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
        PhotosOnTheWallView photosOnTheWallView = this.mPhotosOnTheWallView;
        if (photosOnTheWallView != null) {
            photosOnTheWallView.onDestroy();
        }
        ILiveRoomProvider iLiveRoomProvider = this.mLiveRoomProvider;
        if (iLiveRoomProvider != null) {
            iLiveRoomProvider.removeView((View) this.mPhotosOnTheWallView);
        }
        this.mPhotosOnTheWallView = null;
        ILiveRoomProvider iLiveRoomProvider2 = this.mLiveRoomProvider;
        if (iLiveRoomProvider2 != null) {
            iLiveRoomProvider2.destroyPlugin((BaseLivePluginDriver) this);
        }
        this.mContext = null;
        XesLog.i(this.TAG, "拍照上墙 --> send end");
    }

    private final void registerTakePhotoStateBus() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).observe((LifecycleOwner) this, new BasePhotosOnTheWallPlugin$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067 A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070 A[Catch:{ Exception -> 0x008e }] */
    /* renamed from: registerTakePhotoStateBus$lambda-9  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m360registerTakePhotoStateBus$lambda9(com.tal.app.thinkacademy.live.business.photosonthewall.driver.BasePhotosOnTheWallPlugin r7, java.lang.Object r8) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 1
            boolean r2 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x00a0
            java.lang.String r2 = "end"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r8)     // Catch:{ Exception -> 0x008e }
            if (r8 == 0) goto L_0x0015
            r8 = 2
            goto L_0x0016
        L_0x0015:
            r8 = r1
        L_0x0016:
            boolean r2 = r7.mIsSmallClass     // Catch:{ Exception -> 0x008e }
            if (r2 != 0) goto L_0x00a0
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r7.mLiveRoomProvider     // Catch:{ Exception -> 0x008e }
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x0022
        L_0x0020:
            r2 = r3
            goto L_0x0037
        L_0x0022:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()     // Catch:{ Exception -> 0x008e }
            if (r2 != 0) goto L_0x0029
            goto L_0x0020
        L_0x0029:
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r2 = r2.getEnterConfig()     // Catch:{ Exception -> 0x008e }
            if (r2 != 0) goto L_0x0030
            goto L_0x0020
        L_0x0030:
            java.lang.String r2 = r2.getTutorIrcId()     // Catch:{ Exception -> 0x008e }
            if (r2 != 0) goto L_0x0037
            goto L_0x0020
        L_0x0037:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x008e }
            r4.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "cameraBusy"
            r4.put(r5, r8)     // Catch:{ Exception -> 0x008e }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x008e }
            r8.<init>()     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "type"
            r6 = 170(0xaa, float:2.38E-43)
            r8.put(r5, r6)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "isFunction"
            r8.put(r5, r1)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "msg"
            java.lang.String r6 = "拍照上墙"
            r8.put(r5, r6)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "parameter"
            r8.put(r5, r4)     // Catch:{ Exception -> 0x008e }
            boolean r4 = r8 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x008e }
            if (r4 != 0) goto L_0x0067
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x008e }
            goto L_0x006d
        L_0x0067:
            org.json.JSONObject r8 = (org.json.JSONObject) r8     // Catch:{ Exception -> 0x008e }
            java.lang.String r8 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r8)     // Catch:{ Exception -> 0x008e }
        L_0x006d:
            if (r8 != 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r3 = r8
        L_0x0071:
            com.tal.app.thinkacademy.live.Tag r8 = r7.TAG     // Catch:{ Exception -> 0x008e }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r8 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r8     // Catch:{ Exception -> 0x008e }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "发送辅导,是否正在拍照的状态,消息="
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r3)     // Catch:{ Exception -> 0x008e }
            r4[r0] = r5     // Catch:{ Exception -> 0x008e }
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r8, r4)     // Catch:{ Exception -> 0x008e }
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r8 = r7.mLiveRoomProvider     // Catch:{ Exception -> 0x008e }
            com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider r8 = r8.getIrcControllerProvider()     // Catch:{ Exception -> 0x008e }
            r4 = 99
            r8.sendPeerMessage(r2, r3, r4)     // Catch:{ Exception -> 0x008e }
            goto L_0x00a0
        L_0x008e:
            r8 = move-exception
            com.tal.app.thinkacademy.live.Tag r7 = r7.TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r7 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r7
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "发送辅导,是否正在拍照的状态失败,="
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r8)
            r1[r0] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r7, r1)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.photosonthewall.driver.BasePhotosOnTheWallPlugin.m360registerTakePhotoStateBus$lambda9(com.tal.app.thinkacademy.live.business.photosonthewall.driver.BasePhotosOnTheWallPlugin, java.lang.Object):void");
    }
}
