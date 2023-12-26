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
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding;
import com.tal.app.thinkacademy.business.login.presenter.BindEmailViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.widget.SpaceFilter;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0002J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u001a\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\u0016H\u0016J*\u0010$\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\tH\u0016¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/ChangeEmailActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/BindEmailViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityChangeEmailBinding;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$CustomTextWatcher;", "Lcom/tal/app/thinkcademy/lib/commui/widget/ClearEditText$OnFocusListener;", "Landroid/view/View$OnClickListener;", "()V", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "init", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFocusChange", "view", "hasFocus", "onTextChanged", "saveUserInfo", "setEmailInfo", "startObserve", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChangeEmailActivity.kt */
public final class ChangeEmailActivity extends BaseVmActivity<BindEmailViewModel, ActivityChangeEmailBinding> implements ClearEditText.CustomTextWatcher, ClearEditText.OnFocusListener, View.OnClickListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChangeEmailActivity.kt */
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

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ChangeEmailActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        init();
    }

    private final void init() {
        getBinding().personalTitleBar.setOnTitleBarListener(new ChangeEmailActivity$init$1(this));
        getBinding().etEmail.setFilters(new InputFilter[]{(InputFilter) new SpaceFilter()});
        getBinding().etEmail.addCustomTextWatcher(this);
        getBinding().etEmail.setOnFocusListener(this);
        getBinding().etEmail.requestFocus();
        setEmailInfo();
        RxUnDoubleUtil rxUnDoubleUtil = RxUnDoubleUtil.INSTANCE;
        TextView textView = getBinding().tvSave;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.tvSave");
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(rxUnDoubleUtil, textView, 0, new ChangeEmailActivity$init$2(this), 1, (Object) null);
    }

    private final void setEmailInfo() {
        String str;
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            str = null;
        } else {
            str = userInfoEntity.getEmail();
        }
        getBinding().etEmail.setText(str);
    }

    public void onFocusChange(View view, boolean z) {
        if (z) {
            getBinding().ivWarning.setVisibility(8);
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
        userBean.setNickName(userInfoEntity.getNickName());
        userBean.setCountryCallingCode(userInfoEntity.getCountryCallingCode());
        userBean.setUnifiedAccessToken(userInfoEntity.getUnifiedAccessToken());
        UserInfoBll.Companion.getInstance().saveUserInfo(userBean);
    }

    public void startObserve() {
        ChangeEmailActivity.super.startObserve();
        getMViewModel().getEmailData().observe((LifecycleOwner) this, new ChangeEmailActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-0  reason: not valid java name */
    public static final void m62startObserve$lambda0(ChangeEmailActivity changeEmailActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(changeEmailActivity, "this$0");
        changeEmailActivity.hideLoading();
        int i = WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()];
        if (i == 1) {
            changeEmailActivity.saveUserInfo();
            XesDataBus.with("user_bind_email").setStickyData("bind_email");
            changeEmailActivity.showToast(changeEmailActivity.getString(R.string.edit_successful));
            changeEmailActivity.finish();
        } else if (i == 2) {
            changeEmailActivity.getBinding().ivWarning.setVisibility(0);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        if (motionEvent.getAction() == 0 && KeyboardUtil.hideKeyboard(motionEvent, getCurrentFocus())) {
            getBinding().etEmail.clearFocus();
        }
        return ChangeEmailActivity.super.dispatchTouchEvent(motionEvent);
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, ChangeEmailActivity.class);
        finish();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public ActivityChangeEmailBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityChangeEmailBinding inflate = ActivityChangeEmailBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
