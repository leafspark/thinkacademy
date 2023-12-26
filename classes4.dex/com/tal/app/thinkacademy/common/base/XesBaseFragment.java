package com.tal.app.thinkacademy.common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.tal.app.thinkacademy.common.business.browser.helper.FragmentListener;
import com.tal.app.thinkcademy.lib.commui.dialog.LoadingDialog;
import java.lang.ref.WeakReference;

public abstract class XesBaseFragment extends Fragment {
    protected String TAG = getClass().getSimpleName();
    protected View layoutView;
    private LoadingDialog loadingDialog;
    protected WeakReference<FragmentActivity> mActivityWef;
    protected FragmentListener mFragmentListener;

    public abstract int getLayoutId();

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        XesBaseFragment.super.onCreate(bundle);
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        XesBaseFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        XesBaseFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        XesBaseFragment.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        XesBaseFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        XesBaseFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        XesBaseFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ActivityInfo.startTraceFragment(getClass().getName());
        int layoutId = getLayoutId();
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(layoutId, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, layoutId, viewGroup, false);
        this.layoutView = inflate;
        ActivityInfo.endTraceFragment(getClass().getName());
        return inflate;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        View view = this.layoutView;
        if (view == null || i == -1) {
            return null;
        }
        return view.findViewById(i);
    }

    public boolean isAlive() {
        return !isRemoving() && !isDetached() && getActivity() != null;
    }

    public void showLoading() {
        if (!getmActivity().isFinishing()) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new LoadingDialog(getmActivity());
            }
            if (!this.loadingDialog.isShowing()) {
                this.loadingDialog.show();
            }
        }
    }

    public void hideLoading() {
        if (this.loadingDialog != null && !getmActivity().isFinishing()) {
            this.loadingDialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public FragmentActivity getmActivity() {
        return (FragmentActivity) this.mActivityWef.get();
    }

    public void onAttach(Context context) {
        XesBaseFragment.super.onAttach(context);
        this.mActivityWef = new WeakReference<>(getActivity());
        if (context instanceof FragmentListener) {
            this.mFragmentListener = (FragmentListener) context;
            return;
        }
        throw new IllegalArgumentException("activity must implements FragmentListener ");
    }

    public void onDetach() {
        XesBaseFragment.super.onDetach();
        this.mFragmentListener = null;
    }

    public void onDestroy() {
        XesBaseFragment.super.onDestroy();
        hideLoading();
    }
}
