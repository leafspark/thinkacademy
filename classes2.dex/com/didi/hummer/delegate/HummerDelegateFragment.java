package com.didi.hummer.delegate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public class HummerDelegateFragment extends Fragment {
    private IHummerDelegagte mDelegate;

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        HummerDelegateFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        HummerDelegateFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        HummerDelegateFragment.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        HummerDelegateFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        HummerDelegateFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        HummerDelegateFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public static HummerDelegateFragment newInstance(NavPage navPage) {
        HummerDelegateFragment hummerDelegateFragment = new HummerDelegateFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL, navPage);
        hummerDelegateFragment.setArguments(bundle);
        return hummerDelegateFragment;
    }

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        HummerDelegateFragment.super.onCreate(bundle);
        IHummerDelegagte createHummerDelegate = createHummerDelegate(getPageInfo());
        this.mDelegate = createHummerDelegate;
        if (createHummerDelegate != null) {
            createHummerDelegate.initSDK();
            ActivityInfo.endCreateFragment(getActivity(), this);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Delegate cannot be null");
        ActivityInfo.endCreateFragment(getActivity(), this);
        throw runtimeException;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActivityInfo.startTraceFragment(getClass().getName());
        View initViewAndRender = this.mDelegate.initViewAndRender();
        ActivityInfo.endTraceFragment(getClass().getName());
        return initViewAndRender;
    }

    /* access modifiers changed from: protected */
    public IHummerDelegagte createHummerDelegate(NavPage navPage) {
        return new HummerDelegateAdapter((Fragment) this, navPage);
    }

    /* access modifiers changed from: protected */
    public NavPage getPageInfo() {
        if (getArguments() == null) {
            return null;
        }
        return (NavPage) getArguments().getSerializable(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL);
    }

    public boolean onBackPressed() {
        IHummerDelegagte iHummerDelegagte = this.mDelegate;
        if (iHummerDelegagte != null) {
            return iHummerDelegagte.onBackPressed();
        }
        return false;
    }
}
