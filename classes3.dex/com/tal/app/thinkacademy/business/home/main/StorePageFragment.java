package com.tal.app.thinkacademy.business.home.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.gyf.immersionbar.ImmersionBar;
import com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding;
import com.tal.app.thinkacademy.common.base.BaseBindFragment;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.StickyLiveData;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/StorePageFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseBindFragment;", "Lcom/tal/app/thinkacademy/business/home/databinding/LayoutHomeFragmentBinding;", "()V", "mShowStore", "", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "getLinkUrl", "", "onDestroy", "", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorePageFragment.kt */
public final class StorePageFragment extends BaseBindFragment<LayoutHomeFragmentBinding> {
    private boolean mShowStore;
    private WebAgent mWebAgent;

    /* access modifiers changed from: protected */
    public LayoutHomeFragmentBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutHomeFragmentBinding inflate = LayoutHomeFragmentBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, attach)");
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        StorePageFragment.super.onViewCreated(view, bundle);
        XesTabBottomLayout.clipBottomPadding(getBinding().clContent);
        ImmersionBar.setStatusBarView((Fragment) this, new View[]{getBinding().statusBarView});
        this.mWebAgent = new WebAgent(getmActivity()).applyConfig(new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build()).setWebAgentParent(getBinding().webParent, new ViewGroup.LayoutParams(-1, -1)).loadUrl(getLinkUrl());
        FragmentListener fragmentListener = this.mFragmentListener;
        if (fragmentListener != null) {
            WebAgent webAgent = this.mWebAgent;
            Intrinsics.checkNotNull(webAgent);
            fragmentListener.process(webAgent);
        }
        StickyLiveData with = XesDataBus.with("user_change_school");
        LifecycleOwner lifecycleOwner = getmActivity();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "getmActivity()");
        with.observe(lifecycleOwner, new StorePageFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m36onViewCreated$lambda0(StorePageFragment storePageFragment, Object obj) {
        Intrinsics.checkNotNullParameter(storePageFragment, "this$0");
        WebAgent webAgent = storePageFragment.mWebAgent;
        Intrinsics.checkNotNull(webAgent);
        webAgent.loadUrl(storePageFragment.getLinkUrl());
    }

    public void onResume() {
        WebAgent webAgent;
        StorePageFragment.super.onResume();
        if (this.mShowStore != UserInfoBll.Companion.getInstance().getShoppingMallReviewed() && (webAgent = this.mWebAgent) != null) {
            webAgent.loadUrl(getLinkUrl());
        }
    }

    private final String getLinkUrl() {
        StringBuilder sb;
        String touchHost = UrlUtils.INSTANCE.getTouchHost();
        boolean shoppingMallReviewed = UserInfoBll.Companion.getInstance().getShoppingMallReviewed();
        this.mShowStore = shoppingMallReviewed;
        if (shoppingMallReviewed) {
            sb = new StringBuilder();
            sb.append(touchHost);
            sb.append("/app-v2/courses");
        } else {
            sb = new StringBuilder();
            sb.append(touchHost);
            sb.append("/app-v2/product-introduce");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "urlBuilder.toString()");
        XesLog.dt("StorePageFragment", new Object[]{"getLinkUrl", sb2});
        return sb2;
    }

    public void onDestroy() {
        StorePageFragment.super.onDestroy();
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
    }
}
