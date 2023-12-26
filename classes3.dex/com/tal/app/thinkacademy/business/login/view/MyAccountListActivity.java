package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.AccountAdapter;
import com.tal.app.thinkacademy.business.login.business.LoginIn;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding;
import com.tal.app.thinkacademy.business.login.entity.AccountListEntity;
import com.tal.app.thinkacademy.business.login.entity.UserAccount;
import com.tal.app.thinkacademy.business.login.presenter.MyAccountListViewModel;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.business.browser.helper.XesWebViewCookieUtils;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.common.user.UserBean;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.common.utils.TextUtil;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J(\u0010\u001c\u001a\u00020\u00122\u000e\u0010\u001d\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0012H\u0016J\u0012\u0010%\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/MyAccountListActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/MyAccountListViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityMyAccountBinding;", "Landroid/view/View$OnClickListener;", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/login/adapter/AccountAdapter;", "tag", "", "kotlin.jvm.PlatformType", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "getData", "", "showLoading", "getStateChange", "init", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "position", "", "showSwitchToast", "success", "startObserve", "updateCard", "account", "Lcom/tal/app/thinkacademy/business/login/entity/UserAccount;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MyAccountListActivity.kt */
public final class MyAccountListActivity extends BaseVmActivity<MyAccountListViewModel, ActivityMyAccountBinding> implements View.OnClickListener, OnItemChildClickListener {
    private AccountAdapter mAdapter;
    private final String tag = "MyAccountListActivity";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MyAccountListActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        MyAccountListActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        init();
    }

    private final void init() {
        getData$default(this, false, 1, (Object) null);
        getBinding().titleBarAccount.setOnTitleBarListener(new MyAccountListActivity$init$1(this));
        View.OnClickListener onClickListener = this;
        getBinding().tvCopy.setOnClickListener(onClickListener);
        getBinding().tvAdd.setOnClickListener(onClickListener);
        getStateChange();
    }

    static /* synthetic */ void getData$default(MyAccountListActivity myAccountListActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        myAccountListActivity.getData(z);
    }

    private final void getData(boolean z) {
        if (z) {
            LoadStatusView loadStatusView = getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
            LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        }
        getMViewModel().getBasicUserInfo();
    }

    private final void getStateChange() {
        XesDataBus.with("add_new_student").observerSticky((LifecycleOwner) this, true, new MyAccountListActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: getStateChange$lambda-0  reason: not valid java name */
    public static final void m91getStateChange$lambda0(MyAccountListActivity myAccountListActivity, Object obj) {
        Intrinsics.checkNotNullParameter(myAccountListActivity, "this$0");
        myAccountListActivity.getData(false);
    }

    public void startObserve() {
        StateLiveData<AccountListEntity> accountList = getMViewModel().getAccountList();
        if (accountList != null) {
            accountList.observe((LifecycleOwner) this, new MyAccountListActivity$$ExternalSyntheticLambda0(this));
        }
        getMViewModel().getLoginData().observe((LifecycleOwner) this, new MyAccountListActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m92startObserve$lambda1(MyAccountListActivity myAccountListActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(myAccountListActivity, "this$0");
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            LoadStatusView loadStatusView = myAccountListActivity.getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.loadStatusView");
            String msg = stateData.getMsg();
            if (msg == null) {
                msg = myAccountListActivity.getString(R.string.login_no_network);
                Intrinsics.checkNotNullExpressionValue(msg, "getString(R.string.login_no_network)");
            }
            LoadStatusView.showErrorView$default(loadStatusView, 0, msg, (String) null, (String) null, new MyAccountListActivity$startObserve$1$2(myAccountListActivity), 13, (Object) null);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else if (stateData.getData() == null) {
            LoadStatusView loadStatusView2 = myAccountListActivity.getBinding().loadStatusView;
            Intrinsics.checkNotNullExpressionValue(loadStatusView2, "binding.loadStatusView");
            String msg2 = stateData.getMsg();
            if (msg2 == null) {
                msg2 = myAccountListActivity.getString(R.string.login_no_network);
                Intrinsics.checkNotNullExpressionValue(msg2, "getString(R.string.login_no_network)");
            }
            LoadStatusView.showErrorView$default(loadStatusView2, 0, msg2, (String) null, (String) null, new MyAccountListActivity$startObserve$1$1(myAccountListActivity), 13, (Object) null);
            ToastUtils.showShort(stateData.getMsg(), new Object[0]);
        } else {
            AccountListEntity accountListEntity = (AccountListEntity) stateData.getData();
            List<UserAccount> list = null;
            myAccountListActivity.updateCard(accountListEntity == null ? null : accountListEntity.getCurrentAccount());
            AccountListEntity accountListEntity2 = (AccountListEntity) stateData.getData();
            if (accountListEntity2 != null) {
                list = accountListEntity2.getAssociatedAccount();
            }
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tal.app.thinkacademy.business.login.entity.UserAccount>");
            List asMutableList = TypeIntrinsics.asMutableList(list);
            AccountAdapter accountAdapter = myAccountListActivity.mAdapter;
            if (accountAdapter == null) {
                AccountAdapter accountAdapter2 = new AccountAdapter(asMutableList);
                myAccountListActivity.mAdapter = accountAdapter2;
                accountAdapter2.addChildClickViewIds(new int[]{R.id.item_iv_switch});
                AccountAdapter accountAdapter3 = myAccountListActivity.mAdapter;
                if (accountAdapter3 != null) {
                    accountAdapter3.setOnItemChildClickListener((OnItemChildClickListener) myAccountListActivity);
                }
                Context context = (Context) myAccountListActivity;
                myAccountListActivity.getBinding().rvAccount.setLayoutManager(new LinearLayoutManager(context));
                RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(context, 1);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.item_divider_account);
                Intrinsics.checkNotNull(drawable);
                dividerItemDecoration.setDrawable(drawable);
                myAccountListActivity.getBinding().rvAccount.addItemDecoration(dividerItemDecoration);
                myAccountListActivity.getBinding().rvAccount.setAdapter(myAccountListActivity.mAdapter);
            } else if (accountAdapter != null) {
                accountAdapter.setNewInstance(asMutableList);
            }
            int size = asMutableList.size();
            if (size == 0) {
                myAccountListActivity.getBinding().tvSubtitle.setVisibility(8);
            } else {
                myAccountListActivity.getBinding().tvSubtitle.setVisibility(0);
            }
            if (size > 4) {
                myAccountListActivity.getBinding().tvAdd.setVisibility(8);
            }
            myAccountListActivity.getBinding().loadStatusView.restoreView();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-2  reason: not valid java name */
    public static final void m93startObserve$lambda2(MyAccountListActivity myAccountListActivity, StateData stateData) {
        Intrinsics.checkNotNullParameter(myAccountListActivity, "this$0");
        myAccountListActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] != 1) {
            myAccountListActivity.showSwitchToast(false);
        } else if (stateData.getData() == null) {
            myAccountListActivity.showToast(myAccountListActivity.getString(R.string.many_attempts_tip));
        } else {
            ShareDataManager.getInstance().remove(ShareDataManager.SHAREDATA_NOT_CLEAR, new String[]{"user_uid"});
            ShareDataManager.getInstance().clearUser_sharedata();
            UserInfoBll.Companion.getInstance().clearUserInfo();
            XesWebViewCookieUtils.clearCookies();
            UserBean userBean = (UserBean) stateData.getData();
            ShareDataManager.getInstance().initUserSP(String.valueOf(userBean == null ? null : userBean.getUid()));
            LoginIn.INSTANCE.loginInfo((UserBean) stateData.getData(), false, (Context) myAccountListActivity, 1);
            XesDataBus.with("user_center_login_bus").setStickyData("switchLogin");
            myAccountListActivity.showSwitchToast(true);
            myAccountListActivity.getData(false);
        }
    }

    private final void showSwitchToast(boolean z) {
        LayoutInflater layoutInflater = getLayoutInflater();
        int i = R.layout.layout_custom_toast;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater, i, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflater.inflate(R…ayout_custom_toast, null)");
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        if (z) {
            imageView.setImageResource(R.drawable.add_account_success);
            textView.setText(getString(R.string.switch_successfully));
        } else {
            imageView.setImageResource(R.drawable.add_account_failed);
            textView.setText(getString(R.string.switch_failed));
        }
        ToastUtils.showCustomShort(inflate);
    }

    private final void updateCard(UserAccount userAccount) {
        String str;
        XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
        ImageView imageView = getBinding().ivAvatar;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.ivAvatar");
        Context context = (Context) this;
        if (userAccount == null) {
            str = null;
        } else {
            str = userAccount.getAvatar();
        }
        XesImageLoader.loadCircleWithBorderImage$default(xesImageLoader, imageView, context, str, 2, ContextCompat.getColor(context, R.color.white), R.drawable.self_image_user, false, 32, (Object) null);
        getBinding().tvNickname.setText(userAccount == null ? null : userAccount.getNickName());
        TextView textView = getBinding().tvCard;
        CharSequence[] charSequenceArr = new CharSequence[2];
        charSequenceArr[0] = getString(R.string.no_with_dot);
        charSequenceArr[1] = TextUtil.addBlankInText$default(TextUtil.INSTANCE, userAccount == null ? null : userAccount.getCard(), 0, 2, (Object) null);
        textView.setText(TextUtils.concat(charSequenceArr));
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, MyAccountListActivity.class);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.tv_copy;
        if (valueOf != null && valueOf.intValue() == i) {
            String obj = StringsKt.trim(getBinding().tvCard.getText().toString()).toString();
            if (obj.length() > 3) {
                TextUtil textUtil = TextUtil.INSTANCE;
                String substring = obj.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                ClipboardUtilKt.copyClipboard((Context) this, textUtil.replaceOldValues(substring, " ", ""));
                showToast(getString(R.string.copied_successfully));
            }
        } else {
            int i2 = R.id.tv_add;
            if (valueOf != null && valueOf.intValue() == i2) {
                startActivity(new Intent((Context) this, AddStudentActivity.class));
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    public void onItemChildClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        UserAccount userAccount = (UserAccount) TypeIntrinsics.asMutableList(baseQuickAdapter.getData()).get(i);
        showLoading();
        getMViewModel().switchLogin(userAccount.getUid());
        LoginTrack.INSTANCE.changeStudentAccountClick(userAccount.getUid());
    }

    /* access modifiers changed from: protected */
    public ActivityMyAccountBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityMyAccountBinding inflate = ActivityMyAccountBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
