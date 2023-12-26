package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;

public final class SupportRequestManagerFragment extends Fragment {
    private ImmersionDelegate mDelegate;

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        SupportRequestManagerFragment.super.onCreate(bundle);
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return SupportRequestManagerFragment.super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        SupportRequestManagerFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        SupportRequestManagerFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        SupportRequestManagerFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        SupportRequestManagerFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        SupportRequestManagerFragment.super.setUserVisibleHint(z);
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
        SupportRequestManagerFragment.super.onActivityCreated(bundle);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onActivityCreated(getResources().getConfiguration());
        }
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        SupportRequestManagerFragment.super.onResume();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onResume();
        }
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onDestroy() {
        SupportRequestManagerFragment.super.onDestroy();
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onDestroy();
            this.mDelegate = null;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        SupportRequestManagerFragment.super.onConfigurationChanged(configuration);
        ImmersionDelegate immersionDelegate = this.mDelegate;
        if (immersionDelegate != null) {
            immersionDelegate.onConfigurationChanged(configuration);
        }
    }
}
