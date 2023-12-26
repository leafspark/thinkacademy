package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import cn.dreamtobe.kpswitch.util.KeyboardUtil;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding;
import com.tal.app.thinkacademy.business.login.presenter.BindEmailViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u001a\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u0018H\u0016J*\u0010%\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/BindEmailActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/BindEmailViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityBindEmailBinding;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "Landroid/view/View$OnClickListener;", "()V", "mFromPath", "", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "view", "hasFocus", "onTextChanged", "saveUserInfo", "setListener", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BindEmailActivity.kt */
public final class BindEmailActivity extends BaseVmActivity<BindEmailViewModel, ActivityBindEmailBinding> implements ClearEditText.CustomTextWatcher, ClearEditText.OnFocusListener, View.OnClickListener {
    /* access modifiers changed from: private */
    public String mFromPath;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BindEmailActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            iArr[StateData.DataStatus.ERROR.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void afterTextChanged(Editable editable) {
    }

    /* access modifiers changed from: protected */
    public ActivityBindEmailBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityBindEmailBinding inflate = ActivityBindEmailBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        BindEmailActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, false, 0, true);
        this.mFromPath = getIntent().getStringExtra("link_email_page_path");
        getBinding().etEmail.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter()});
        getBinding().etEmail.addCustomTextWatcher(this);
        getBinding().etEmail.setOnFocusListener(this);
        setListener();
        getBinding().etEmail.requestFocus();
    }

    private final void setListener() {
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().emailNextBt;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.emailNextBt");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new BindEmailActivity$setListener$1(this), 1, (Object) null);
        getBinding().tvSkip.setOnClickListener(this);
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            getBinding().groupWarning.setVisibility(8);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        getBinding().emailPhoneTips.setVisibility(8);
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            getBinding().emailPhoneTips.setVisibility(8);
        }
        TextView textView = getBinding().emailNextBt;
        if (charSequence == null || !StringsKt.contains$default(charSequence, "@", false, 2, (Object) null)) {
            z = false;
        }
        textView.setEnabled(z);
    }

    public void startObserve() {
        BindEmailActivity.super.startObserve();
        getMViewModel().getEmailData().observe((LifecycleOwner) this, new BindEmailActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m61startObserve$lambda0(BindEmailActivity bindEmailActivity, StateData stateData) {
        BindEmailActivity bindEmailActivity2 = bindEmailActivity;
        Intrinsics.checkNotNullParameter(bindEmailActivity2, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        boolean z = false;
        if (i == 1) {
            bindEmailActivity.saveUserInfo();
            CharSequence charSequence = bindEmailActivity2.mFromPath;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            LeanplumUtil.longTrack$default("app_link_email_success", (String) null, (String) null, (String) null, (String) null, (String) null, z ? "others" : bindEmailActivity2.mFromPath, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16318, (Object) null);
            XesDataBus.with("user_bind_email").setStickyData("bind_email");
            bindEmailActivity.finish();
        } else if (i == 2) {
            bindEmailActivity.getBinding().groupWarning.setVisibility(0);
        }
    }

    private final void saveUserInfo() {
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        UserBean userBean = new UserBean((Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, false, 1023, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(userInfoEntity);
        String uid = userInfoEntity.getUid();
        Intrinsics.checkNotNull(uid);
        userBean.setUid(Integer.valueOf(Integer.parseInt(uid)));
        userBean.setAvatar(userInfoEntity.getAvatar());
        userBean.setPhone(userInfoEntity.getPhone());
        userBean.setEmail(String.valueOf(getBinding().etEmail.getText()));
        userBean.setNickName(userBean.getNickName());
        userBean.setCountryCallingCode(userInfoEntity.getCountryCallingCode());
        userBean.setUnifiedAccessToken(userInfoEntity.getUnifiedAccessToken());
        UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etEmail.clearFocus();
        }
        return BindEmailActivity.super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, BindEmailActivity.class);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }
}
