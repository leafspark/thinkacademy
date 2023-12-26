package com.tal.app.thinkacademy.live.business.sign;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.sign.entity.BusinessApi;
import com.tal.app.thinkacademy.live.business.sign.entity.SignInEntity;
import com.tal.app.thinkacademy.live.business.sign.entity.SignInExecuteEntity;
import com.tal.app.thinkacademy.live.business.sign.entity.body.SignInBody;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import retrofit2.Call;

public class SignInPluginView extends BaseLivePluginView implements View.OnClickListener {
    public static final int SIGN_IN_MISS = 1;
    public static final int SIGN_IN_NOT = 2;
    public static final int SIGN_IN_SUCESS = 0;
    private final String TAG = "SignInPluginView";
    private int[] drawablesPrimary = {R.drawable.live_business_signin_primary_star, R.drawable.live_business_signin_primary_miss, R.drawable.live_business_signin_primary_not};
    private SignInEntity entity;
    private final String fileName = "live_business_sigin_in";
    /* access modifiers changed from: private */
    public Handler handler;
    private ImageView iv_close;
    private ImageView iv_toast;
    private LinearLayout liveBusinessSigninBackground;
    private SignInPluginBack mSignInPluginBack;
    private SignInPluginView mSignInPluginLayout;
    private String[] resultText = {StringUtils.getString(R.string.sign_success), StringUtils.getString(R.string.sign_missed), StringUtils.getString(R.string.sign_fail)};
    /* access modifiers changed from: private */
    public Runnable runnable;
    private Runnable runnable2;
    /* access modifiers changed from: private */
    public int status = -1;
    private LinearLayout toastView;
    private TextView tv_button;
    private TextView tv_toast;

    public SignInPluginView(Context context) {
        super(context);
    }

    public SignInPluginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SignInPluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getLayoutId() {
        return R.layout.live_business_sign_in_primary;
    }

    public void initViews() {
        SignInPluginView.super.initViews();
        SignInPluginView signInPluginView = (SignInPluginView) getRootView();
        this.mSignInPluginLayout = signInPluginView;
        this.liveBusinessSigninBackground = (LinearLayout) signInPluginView.findViewById(R.id.live_business_signin_background);
        if (PadUtils.isPad(Utils.getApp())) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.liveBusinessSigninBackground.getLayoutParams();
            layoutParams.setMargins(layoutParams.getMarginStart(), 0, 0, SizeUtils.dp2px(170.0f));
        }
        TextView textView = (TextView) this.mSignInPluginLayout.findViewById(R.id.iv_signin_button);
        this.tv_button = textView;
        textView.setOnClickListener(this);
        ImageView imageView = (ImageView) this.mSignInPluginLayout.findViewById(R.id.live_business_signin_close);
        this.iv_close = imageView;
        imageView.setOnClickListener(this);
        this.toastView = (LinearLayout) this.mSignInPluginLayout.findViewById(R.id.live_business_signin_background_result);
        if (PadUtils.isPad(Utils.getApp())) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.toastView.getLayoutParams();
            layoutParams2.setMargins(layoutParams2.getMarginStart(), 0, 0, SizeUtils.dp2px(170.0f));
        }
        this.iv_toast = (ImageView) this.toastView.findViewById(R.id.iv_page_livevideo_sign_in_toast);
        this.tv_toast = (TextView) this.toastView.findViewById(R.id.tv_page_livevideo_sign_in_toast);
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void setSignBack(SignInPluginBack signInPluginBack) {
        this.mSignInPluginBack = signInPluginBack;
    }

    public void onClick(View view) {
        Runnable runnable3;
        MethodInfo.onClickEventEnter(view, SignInPluginView.class);
        if (this.tv_button.getId() == view.getId() && this.status != 1) {
            LeanplumUtil.longTrack(LeanplumUtil.click_checkin, this.entity.getClassId() + "", this.entity.getPlanId() + "");
            this.status = 1;
            signIn();
        } else if (this.iv_close.getId() == view.getId()) {
            this.status = 2;
            Handler handler2 = this.handler;
            if (!(handler2 == null || (runnable3 = this.runnable) == null)) {
                handler2.removeCallbacks(runnable3);
            }
            hideSignInView();
            changeToastTypeAndShow(2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void setData(SignInEntity signInEntity) {
        this.entity = signInEntity;
    }

    /* access modifiers changed from: private */
    public void hideSignInView() {
        LinearLayout linearLayout = this.liveBusinessSigninBackground;
        if (!(linearLayout == null || linearLayout.getVisibility() == 8)) {
            this.liveBusinessSigninBackground.setVisibility(8);
        }
        ImageView imageView = this.iv_close;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.iv_close.setVisibility(8);
        }
    }

    private void signIn() {
        Call<HiResponse<SignInExecuteEntity>> signIn = ((BusinessApi) Api.create(BusinessApi.class)).signIn(this.entity.getSignExecuteURL(), new SignInBody(this.entity.getPlanId(), this.entity.getClassId()));
        AnonymousClass2 r1 = new OmyCallback<HiResponse<SignInExecuteEntity>>(new IError() {
            public void onFail(int i, String str) {
                if (SignInPluginView.this.status == 1) {
                    int unused = SignInPluginView.this.status = -1;
                }
                Handler access$100 = SignInPluginView.this.handler;
                SignInPluginView$1$$ExternalSyntheticLambda1 signInPluginView$1$$ExternalSyntheticLambda1 = new SignInPluginView$1$$ExternalSyntheticLambda1(str);
                if (!(access$100 instanceof Handler)) {
                    access$100.post(signInPluginView$1$$ExternalSyntheticLambda1);
                } else {
                    AsynchronousInstrumentation.handlerPost(access$100, signInPluginView$1$$ExternalSyntheticLambda1);
                }
            }

            public void onError(int i, String str) {
                XesLog.et(str + i, new Object[0]);
                if (SignInPluginView.this.status == 1) {
                    int unused = SignInPluginView.this.status = -1;
                }
                Handler access$100 = SignInPluginView.this.handler;
                SignInPluginView$1$$ExternalSyntheticLambda0 signInPluginView$1$$ExternalSyntheticLambda0 = new SignInPluginView$1$$ExternalSyntheticLambda0(str);
                if (!(access$100 instanceof Handler)) {
                    access$100.post(signInPluginView$1$$ExternalSyntheticLambda0);
                } else {
                    AsynchronousInstrumentation.handlerPost(access$100, signInPluginView$1$$ExternalSyntheticLambda0);
                }
            }
        }) {
            public void onSuccess(HiResponse<SignInExecuteEntity> hiResponse) {
                if (hiResponse.getStat() == 1 && SignInPluginView.this.status == 1) {
                    if (!(SignInPluginView.this.handler == null || SignInPluginView.this.runnable == null)) {
                        SignInPluginView.this.handler.removeCallbacks(SignInPluginView.this.runnable);
                    }
                    SignInPluginView.this.hideSignInView();
                    SignInPluginView.this.changeToastTypeAndShow(0);
                }
            }
        };
        if (!(signIn instanceof Call)) {
            signIn.enqueue(r1);
        } else {
            Retrofit2Instrumentation.enqueue((Call) signIn, r1);
        }
    }

    /* access modifiers changed from: protected */
    public void changeToastTypeAndShow(int i) {
        int[] iArr = this.drawablesPrimary;
        if (iArr != null) {
            if (i > -1 && i < 3) {
                this.iv_toast.setImageResource(iArr[i]);
                this.tv_toast.setText(this.resultText[i]);
                if (i == 0) {
                    LeanplumUtil.longTrack(LeanplumUtil.show_checkin_successful, this.entity.getClassId() + "", this.entity.getPlanId() + "");
                } else {
                    LeanplumUtil.longTrack(LeanplumUtil.show_checkin_failure, this.entity.getClassId() + "", this.entity.getPlanId() + "");
                }
            }
            if (i == 1) {
                ShareDataManager.getInstance().put("live_business_sigin_in", this.entity.getPlanId() + String.valueOf(this.entity.getStuId()), ShareDataManager.SHAREDATA_USER);
                hideSignInView();
            }
            showToast();
        }
    }

    private void showToast() {
        this.toastView.setVisibility(0);
        if (this.handler != null) {
            if (this.runnable2 == null) {
                this.runnable2 = new SignInPluginView$$ExternalSyntheticLambda1(this);
            }
            this.handler.postDelayed(this.runnable2, 3000);
        }
    }

    public /* synthetic */ void lambda$showToast$0$SignInPluginView() {
        if (this.toastView != null) {
            this.mSignInPluginBack.closeSignInView();
        }
    }

    public void showSigngin(long j) {
        this.mSignInPluginBack.openSignInView();
        if (this.handler != null) {
            SignInPluginView$$ExternalSyntheticLambda0 signInPluginView$$ExternalSyntheticLambda0 = new SignInPluginView$$ExternalSyntheticLambda0(this);
            this.runnable = signInPluginView$$ExternalSyntheticLambda0;
            this.handler.postDelayed(signInPluginView$$ExternalSyntheticLambda0, j * 1000);
        }
    }

    public /* synthetic */ void lambda$showSigngin$1$SignInPluginView() {
        hideSignInView();
        changeToastTypeAndShow(1);
    }

    public void onDestroy() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
            this.handler = null;
        }
        this.runnable = null;
        this.runnable2 = null;
    }
}
