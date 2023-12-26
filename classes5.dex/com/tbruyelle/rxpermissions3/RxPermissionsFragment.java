package com.tbruyelle.rxpermissions3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

public class RxPermissionsFragment extends Fragment {
    private static final int PERMISSIONS_REQUEST_CODE = 42;
    private boolean mLogging;
    private Map<String, PublishSubject<Permission>> mSubjects = new HashMap();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return RxPermissionsFragment.super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onHiddenChanged(boolean z) {
        ActivityInfo.startOnHiddenChanged(getActivity(), this, z);
        RxPermissionsFragment.super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
        ActivityInfo.endOnHiddenChanged(getActivity(), this, z);
    }

    public void onPause() {
        ActivityInfo.startOnPauseFragment(getActivity(), this);
        RxPermissionsFragment.super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
        ActivityInfo.endOnPauseFragment(getActivity(), this);
    }

    public void onResume() {
        ActivityInfo.startOnResumeFragment(getActivity(), this);
        RxPermissionsFragment.super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
        ActivityInfo.endOnResumeFragment(getActivity(), this);
    }

    public void onStart() {
        ActivityInfo.startOnStartFragment(getActivity(), this);
        RxPermissionsFragment.super.onStart();
        ActivityInfo.endOnStartFragment(getActivity(), this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        RxPermissionsFragment.super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        ActivityInfo.startUserVisibleHint(getActivity(), this, z);
        RxPermissionsFragment.super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        ActivityInfo.endUserVisibleHint(getActivity(), this, z);
    }

    public void onCreate(Bundle bundle) {
        ActivityInfo.startCreateFragment(getActivity(), this);
        RxPermissionsFragment.super.onCreate(bundle);
        setRetainInstance(true);
        ActivityInfo.endCreateFragment(getActivity(), this);
    }

    /* access modifiers changed from: package-private */
    public void requestPermissions(String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        RxPermissionsFragment.super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            onRequestPermissionsResult(strArr, iArr, zArr);
        }
    }

    /* access modifiers changed from: package-private */
    public void onRequestPermissionsResult(String[] strArr, int[] iArr, boolean[] zArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            log("onRequestPermissionsResult  " + strArr[i]);
            PublishSubject publishSubject = this.mSubjects.get(strArr[i]);
            if (publishSubject == null) {
                Log.e(RxPermissions.TAG, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.mSubjects.remove(strArr[i]);
            publishSubject.onNext(new Permission(strArr[i], iArr[i] == 0, zArr[i]));
            publishSubject.onComplete();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isGranted(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.checkSelfPermission(str) == 0;
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    /* access modifiers changed from: package-private */
    public boolean isRevoked(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public void setLogging(boolean z) {
        this.mLogging = z;
    }

    public PublishSubject<Permission> getSubjectByPermission(String str) {
        return this.mSubjects.get(str);
    }

    public boolean containsByPermission(String str) {
        return this.mSubjects.containsKey(str);
    }

    public void setSubjectForPermission(String str, PublishSubject<Permission> publishSubject) {
        this.mSubjects.put(str, publishSubject);
    }

    /* access modifiers changed from: package-private */
    public void log(String str) {
        if (this.mLogging) {
            Log.d(RxPermissions.TAG, str);
        }
    }
}
