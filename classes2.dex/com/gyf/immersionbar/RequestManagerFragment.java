package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public final class RequestManagerFragment extends Fragment {
    private ImmersionDelegate mDelegate;

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        super.onCreate(bundle);
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public ImmersionBar get(Object obj) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(obj);
        }
        return this.mDelegate.get();
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        if (this.mDelegate == null) {
            this.mDelegate = new ImmersionDelegate(activity, dialog);
        }
        return this.mDelegate.get();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        super.onResume();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onDestroy() {
        super.onDestroy();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.mDelegate = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }
}
