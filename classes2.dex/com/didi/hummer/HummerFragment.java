package com.didi.hummer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.didi.hummer.HummerRender;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.didi.hummer.component.input.FocusUtil;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.devtools.DevToolsConfig;
import com.didi.hummer.render.style.HummerLayout;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class HummerFragment extends Fragment {
    protected Context context;
    protected HummerLayout hmContainer;
    protected HummerRender hmRender;
    protected NavPage page;

    /* access modifiers changed from: protected */
    public DevToolsConfig getDevToolsConfig() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getNamespace() {
        return HummerSDK.NAMESPACE_DEFAULT;
    }

    /* access modifiers changed from: protected */
    public void initHummerRegister(HummerContext hummerContext) {
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        HummerFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    /* access modifiers changed from: protected */
    public void onPageRenderFailed(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void onPageRenderSucceed(HummerContext hummerContext, JSValue jSValue) {
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        HummerFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        HummerFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        HummerFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public void onAttach(Context context2) {
        HummerFragment.super.onAttach(context2);
        this.context = context2;
    }

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        HummerFragment.super.onCreate(bundle);
        HummerSDK.init(this.context);
        initData();
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActivityInfo.startTraceFragment(getClass().getName());
        initView();
        NavPage navPage = this.page;
        if (navPage == null || TextUtils.isEmpty(navPage.url)) {
            onPageRenderFailed(new RuntimeException("page url is empty"));
            Toast.makeText(this.context, "page url is empty", 0).show();
        } else {
            initHummer();
            renderHummer();
        }
        HummerLayout hummerLayout = this.hmContainer;
        ActivityInfo.endTraceFragment(getClass().getName());
        return hummerLayout;
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        HummerFragment.super.onResume();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onResume();
        }
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        HummerFragment.super.onPause();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onPause();
        }
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onDestroy() {
        HummerFragment.super.onDestroy();
        HummerRender hummerRender = this.hmRender;
        if (hummerRender != null) {
            hummerRender.onDestroy();
        }
    }

    public boolean onBackPressed() {
        HummerRender hummerRender = this.hmRender;
        return hummerRender != null && hummerRender.onBack();
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.page = getPageInfo();
    }

    /* access modifiers changed from: protected */
    public NavPage getPageInfo() {
        if (getArguments() == null) {
            return null;
        }
        return (NavPage) getArguments().getSerializable(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        HummerLayout hummerLayout = new HummerLayout(this.context);
        this.hmContainer = hummerLayout;
        hummerLayout.setOnTouchListener(new HummerFragment$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ boolean lambda$initView$0$HummerFragment(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        FocusUtil.clearFocus(this.context);
        return false;
    }

    /* access modifiers changed from: protected */
    public void initHummer() {
        HummerRender hummerRender = new HummerRender(this.hmContainer, getNamespace(), getDevToolsConfig());
        this.hmRender = hummerRender;
        initHummerRegister(hummerRender.getHummerContext());
        this.hmRender.setJsPageInfo(this.page);
        this.hmRender.setRenderCallback(new HummerRender.HummerRenderCallback() {
            public void onSucceed(HummerContext hummerContext, JSValue jSValue) {
                HummerFragment.this.onPageRenderSucceed(hummerContext, jSValue);
            }

            public void onFailed(Exception exc) {
                HummerFragment.this.onPageRenderFailed(exc);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void renderHummer() {
        if (this.page.isHttpUrl()) {
            this.hmRender.renderWithUrl(this.page.url);
        } else if (this.page.url.startsWith("/")) {
            this.hmRender.renderWithFile(this.page.url);
        } else {
            this.hmRender.renderWithAssets(this.page.url);
        }
    }
}
