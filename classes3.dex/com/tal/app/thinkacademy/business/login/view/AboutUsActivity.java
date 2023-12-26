package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tal.app.thinkacademy.business.login.BuildConfig;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.adapter.AboutAdapter;
import com.tal.app.thinkacademy.business.login.databinding.ActivityAboutUsBinding;
import com.tal.app.thinkacademy.business.login.entity.AboutBean;
import com.tal.app.thinkacademy.business.login.entity.AboutListEntity;
import com.tal.app.thinkacademy.business.login.presenter.AboutUsViewModel;
import com.tal.app.thinkacademy.business.login.widget.JumpToAgreementUtil;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.base.BaseVmActivity;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.entity.StateData;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J(\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/AboutUsActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseVmActivity;", "Lcom/tal/app/thinkacademy/business/login/presenter/AboutUsViewModel;", "Lcom/tal/app/thinkacademy/business/login/databinding/ActivityAboutUsBinding;", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "()V", "v", "", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "Landroid/view/View;", "position", "", "setListener", "setViewValues", "startObserve", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AboutUsActivity.kt */
public final class AboutUsActivity extends BaseVmActivity<AboutUsViewModel, ActivityAboutUsBinding> implements OnItemClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TYPE_CUSTOMER_SUPPORT = 100;
    private final String v = "V";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AboutUsActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StateData.DataStatus.values().length];
            iArr[StateData.DataStatus.SUCCESS.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/AboutUsActivity$Companion;", "", "()V", "TYPE_CUSTOMER_SUPPORT", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AboutUsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AboutUsActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, -1, false);
        setListener();
        setViewValues();
    }

    private final void setListener() {
        getBinding().aboutTitleBar.setOnTitleBarListener(new AboutUsActivity$setListener$1(this));
    }

    private final void setViewValues() {
        getBinding().tvVersionNumber.setText(TextUtils.concat(new CharSequence[]{this.v, AppUtils.getAppVersionName()}));
        if (Intrinsics.areEqual((Object) SchoolConstants.INSTANCE.getCurrentSchoolCode(), (Object) "8601")) {
            getBinding().tvVersionNumberFlutter.setText(BuildConfig.flutterVersion);
            getBinding().tvVersionNumberFlutter.setVisibility(0);
        }
        showLoading();
        getMViewModel().legalFiles();
    }

    public void startObserve() {
        getMViewModel().getAboutListEntity().observe((LifecycleOwner) this, new AboutUsActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: startObserve$lambda-1  reason: not valid java name */
    public static final void m54startObserve$lambda1(AboutUsActivity aboutUsActivity, StateData stateData) {
        List<AboutBean> list;
        Intrinsics.checkNotNullParameter(aboutUsActivity, "this$0");
        aboutUsActivity.hideLoading();
        if (WhenMappings.$EnumSwitchMapping$0[stateData.getStatus().ordinal()] == 1) {
            AboutListEntity aboutListEntity = (AboutListEntity) stateData.getData();
            if (aboutListEntity != null) {
                if (!(aboutListEntity.getList() == null || (list = aboutListEntity.getList()) == null)) {
                    String string = aboutUsActivity.getString(R.string.customer_support);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.customer_support)");
                    list.add(new AboutBean(string, "", 100));
                }
                RecyclerView.Adapter aboutAdapter = new AboutAdapter(aboutListEntity.getList());
                RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager((Context) aboutUsActivity);
                linearLayoutManager.setOrientation(1);
                aboutUsActivity.getBinding().recyclerView.setLayoutManager(linearLayoutManager);
                aboutUsActivity.getBinding().recyclerView.setAdapter(aboutAdapter);
                aboutAdapter.setOnItemClickListener((OnItemClickListener) aboutUsActivity);
                return;
            }
            return;
        }
        aboutUsActivity.showToast(stateData.getMsg());
    }

    public void onItemClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AboutBean aboutBean = (AboutBean) TypeIntrinsics.asMutableList(baseQuickAdapter.getData()).get(i);
        if (aboutBean.getLocal_type() == 100) {
            JumpToAgreementUtil.INSTANCE.jump2H5(JumpToAgreementUtil.MENU_CUSTOMER_SUPPORT, (Context) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", aboutBean.getUrl());
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).setLocalTitle(aboutBean.getTitle()).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
        bundle.clear();
    }

    /* access modifiers changed from: protected */
    public ActivityAboutUsBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityAboutUsBinding inflate = ActivityAboutUsBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }
}
