package com.tal.app.thinkacademy.business.home.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.ImmersionBar;
import com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding;
import com.tal.app.thinkacademy.common.base.BaseBindFragment;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/DataStationFragment;", "Lcom/tal/app/thinkacademy/common/base/BaseBindFragment;", "Lcom/tal/app/thinkacademy/business/home/databinding/LayoutHomeFragmentBinding;", "()V", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "attach", "", "getLinkUrl", "", "onDestroy", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataStationFragment.kt */
public final class DataStationFragment extends BaseBindFragment<LayoutHomeFragmentBinding> {
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
        DataStationFragment.super.onViewCreated(view, bundle);
        XesTabBottomLayout.clipBottomPadding(getBinding().clContent);
        ImmersionBar.setStatusBarView((Fragment) this, new View[]{getBinding().statusBarView});
        this.mWebAgent = new WebAgent(getmActivity()).applyConfig(new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build()).setWebAgentParent(getBinding().webParent, new ViewGroup.LayoutParams(-1, -1)).loadUrl(getLinkUrl());
        FragmentListener fragmentListener = this.mFragmentListener;
        if (fragmentListener != null) {
            WebAgent webAgent = this.mWebAgent;
            Intrinsics.checkNotNull(webAgent);
            fragmentListener.process(webAgent);
        }
    }

    private final String getLinkUrl() {
        String str = UrlUtils.INSTANCE.getTouchHost() + SchoolConstants.INSTANCE.getStudyDataPath();
        Intrinsics.checkNotNullExpressionValue(str, "urlBuilder.toString()");
        XesLog.dt("DataStationFragment", new Object[]{"getLinkUrl", str});
        return str;
    }

    public void onDestroy() {
        DataStationFragment.super.onDestroy();
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
    }
}
