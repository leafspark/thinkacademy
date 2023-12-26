package com.tal.app.thinkacademy.live.business.sign;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.live.business.sign.entity.BusinessApi;
import com.tal.app.thinkacademy.live.business.sign.entity.SignBean;
import com.tal.app.thinkacademy.live.business.sign.entity.SignInEntity;
import com.tal.app.thinkacademy.live.business.sign.entity.body.SignBody;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import java.lang.ref.WeakReference;
import java.util.Random;
import retrofit2.Call;

@PluginAnnotation(desc = "签到插件", launchType = "initmodule", moduleId = "1", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 30, name = "SignInView")})
public class SignInPluginDriver extends BaseLivePluginDriver implements SignInPluginBack {
    private final int DELAY_BEFORE_COURSE = 900;
    private final String SignedIn = "1";
    /* access modifiers changed from: private */
    public final String TAG = "SignInPluginDriver";
    private final String fileName = "live_business_sigin_in";
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public WeakReference<Context> mContext;
    /* access modifiers changed from: private */
    public CourseInfoProxy mCourseInfoProxy;
    /* access modifiers changed from: private */
    public PlanInfoProxy mPlanInfoProxy;
    /* access modifiers changed from: private */
    public RoomData mRoomData;
    private UserInfoProxy mUserInfoProxy;
    /* access modifiers changed from: private */
    public Runnable runnable;
    /* access modifiers changed from: private */
    public SignInPluginView signView;

    public void onMessage(String str, String str2) {
    }

    public SignInPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mUserInfoProxy = iLiveRoomProvider.getDataStorage().getUserInfo();
        this.mPlanInfoProxy = iLiveRoomProvider.getDataStorage().getPlanInfo();
        this.mCourseInfoProxy = iLiveRoomProvider.getDataStorage().getCourseInfo();
        this.mContext = iLiveRoomProvider.getWeakRefContext();
        this.mRoomData = iLiveRoomProvider.getDataStorage().getRoomData();
        this.handler = new Handler(Looper.getMainLooper());
        showSignInState(this.mPlanInfoProxy.getId(), this.mUserInfoProxy.getId());
    }

    /* access modifiers changed from: protected */
    public void showSignInState(String str, String str2) {
        try {
            final SignInEntity signInEntity = setSignInEntity(str, str2);
            signInEntity.setSignExecuteURL(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/sign/student/arrive");
            Call<HiResponse<SignBean>> sign = ((BusinessApi) Api.create(BusinessApi.class)).getSign(ImConfig.INSTANCE.getOverseaApi() + "/classroom-hub/sign/student/status", new SignBody(signInEntity.getPlanId(), signInEntity.getClassId()));
            final String str3 = str;
            final String str4 = str2;
            AnonymousClass2 r0 = new OmyCallback<HiResponse<SignBean>>(new IError() {
                public void onFail(int i, String str) {
                    String access$000 = SignInPluginDriver.this.TAG;
                    XesLog.et(access$000, "onFailed = " + i + "---" + str);
                }

                public void onError(int i, String str) {
                    String access$000 = SignInPluginDriver.this.TAG;
                    XesLog.et(access$000, "onError = " + i + "---" + str);
                }
            }) {
                public void onSuccess(HiResponse<SignBean> hiResponse) {
                    long serveNowTime = SignInPluginDriver.this.mRoomData.getServeNowTime();
                    long startStampTime = SignInPluginDriver.this.mPlanInfoProxy.getStartStampTime();
                    if ("1".equals(hiResponse.getData().getStatus())) {
                        SignInPluginView unused = SignInPluginDriver.this.signView = new SignInPluginView((Context) SignInPluginDriver.this.mContext.get());
                        SignInPluginDriver.this.signView.setData(signInEntity);
                        SignInPluginDriver.this.signView.setSignBack(SignInPluginDriver.this);
                        if (serveNowTime >= startStampTime) {
                            String string = ShareDataManager.getInstance().getString("live_business_sigin_in", "", ShareDataManager.SHAREDATA_USER);
                            if (string != null) {
                                if (string.equals(str3 + str4)) {
                                    return;
                                }
                            }
                            SignInPluginDriver.this.signView.changeToastTypeAndShow(1);
                            SignInPluginDriver.this.showView();
                            return;
                        }
                        long j = startStampTime - serveNowTime;
                        if (j <= 900) {
                            LeanplumUtil.longTrack(LeanplumUtil.show_checkin, SignInPluginDriver.this.mCourseInfoProxy.getClassId() + "", SignInPluginDriver.this.mPlanInfoProxy.getId());
                            SignInPluginDriver.this.signView.showSigngin(j);
                        } else if (SignInPluginDriver.this.handler != null) {
                            if (SignInPluginDriver.this.runnable == null) {
                                Runnable unused2 = SignInPluginDriver.this.runnable = new SignInPluginDriver$2$$ExternalSyntheticLambda0(this);
                            }
                            SignInPluginDriver.this.handler.postDelayed(SignInPluginDriver.this.runnable, ((j - 900) + ((long) new Random().nextInt(61))) * 1000);
                        }
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$SignInPluginDriver$2() {
                    LeanplumUtil.longTrack(LeanplumUtil.show_checkin, SignInPluginDriver.this.mCourseInfoProxy.getClassId() + "", SignInPluginDriver.this.mPlanInfoProxy.getId());
                    SignInPluginDriver.this.signView.showSigngin(900);
                }
            };
            if (!(sign instanceof Call)) {
                sign.enqueue(r0);
            } else {
                Retrofit2Instrumentation.enqueue((Call) sign, r0);
            }
        } catch (Exception unused) {
        }
    }

    private SignInEntity setSignInEntity(String str, String str2) {
        SignInEntity signInEntity = new SignInEntity();
        signInEntity.setPlanId(ParseUtils.tryParseInt(str, -1));
        signInEntity.setStuId(ParseUtils.tryParseInt(str2, -1));
        signInEntity.setBizId(this.mCourseInfoProxy.getBizId());
        signInEntity.setClassId(this.mCourseInfoProxy.getClassId());
        signInEntity.setStuName(this.mUserInfoProxy.getName());
        signInEntity.setNickname(this.mUserInfoProxy.getNickName());
        signInEntity.setEnglishName(this.mUserInfoProxy.getEnglishName());
        return signInEntity;
    }

    /* access modifiers changed from: private */
    public void showView() {
        this.mLiveRoomProvider.addView(this, this.signView, "SignInView", LiveAreaContext.get().getPptLp().newLp());
    }

    public void onDestroy() {
        SignInPluginView signInPluginView = this.signView;
        if (signInPluginView != null) {
            signInPluginView.onDestroy();
            this.signView = null;
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.runnable = null;
            this.handler = null;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.tal.app.thinkacademy.live.business.sign.SignInPluginView, android.view.View] */
    public void closeSignInView() {
        this.mLiveRoomProvider.removeView(this.signView);
        SignInPluginView signInPluginView = this.signView;
        if (signInPluginView != null) {
            signInPluginView.onDestroy();
            this.signView = null;
        }
    }

    public void openSignInView() {
        showView();
    }
}
