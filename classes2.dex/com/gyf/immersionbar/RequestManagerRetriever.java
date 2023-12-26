package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class RequestManagerRetriever implements Handler.Callback {
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private Handler mHandler;
    private final Map<FragmentManager, RequestManagerFragment> mPendingFragments;
    private final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> mPendingSupportFragments;
    private String mTag;

    private static class Holder {
        /* access modifiers changed from: private */
        public static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();

        private Holder() {
        }
    }

    static RequestManagerRetriever getInstance() {
        return Holder.INSTANCE;
    }

    private RequestManagerRetriever() {
        this.mTag = ImmersionBar.class.getName();
        this.mPendingFragments = new HashMap();
        this.mPendingSupportFragments = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    public ImmersionBar get(Activity activity) {
        checkNotNull(activity, "activity is null");
        String str = this.mTag + System.identityHashCode(activity);
        if (activity instanceof FragmentActivity) {
            return getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity);
        }
        return getFragment(activity.getFragmentManager(), str).get(activity);
    }

    public ImmersionBar get(Fragment fragment, boolean z) {
        String str;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            checkNotNull(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.mTag;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return getSupportFragment(fragment.getChildFragmentManager(), str).get(fragment);
    }

    public ImmersionBar get(android.app.Fragment fragment, boolean z) {
        String str;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof android.app.DialogFragment) {
            checkNotNull(((android.app.DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str2 = this.mTag;
        if (z) {
            str = str2 + fragment.getClass().getName();
        } else {
            str = str2 + System.identityHashCode(fragment);
        }
        return getFragment(fragment.getChildFragmentManager(), str).get(fragment);
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        checkNotNull(activity, "activity is null");
        checkNotNull(dialog, "dialog is null");
        String str = this.mTag + System.identityHashCode(dialog);
        if (activity instanceof FragmentActivity) {
            return getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), str).get(activity, dialog);
        }
        return getFragment(activity.getFragmentManager(), str).get(activity, dialog);
    }

    public void destroy(Fragment fragment, boolean z) {
        String str;
        if (fragment != null) {
            String str2 = this.mTag;
            if (z) {
                str = str2 + fragment.getClass().getName();
            } else {
                str = str2 + System.identityHashCode(fragment);
            }
            getSupportFragment(fragment.getChildFragmentManager(), str, true);
        }
    }

    public void destroy(Activity activity, Dialog dialog) {
        if (activity != null && dialog != null) {
            String str = this.mTag + System.identityHashCode(dialog);
            if (activity instanceof FragmentActivity) {
                SupportRequestManagerFragment supportFragment = getSupportFragment(((FragmentActivity) activity).getSupportFragmentManager(), str, true);
                if (supportFragment != null) {
                    supportFragment.get(activity, dialog).onDestroy();
                    return;
                }
                return;
            }
            RequestManagerFragment fragment = getFragment(activity.getFragmentManager(), str, true);
            if (fragment != null) {
                fragment.get(activity, dialog).onDestroy();
            }
        }
    }

    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.mPendingFragments.remove((FragmentManager) message.obj);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.mPendingSupportFragments.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str) {
        return getFragment(fragmentManager, str, false);
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.mPendingFragments.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.mPendingFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.mHandler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    private SupportRequestManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return getSupportFragment(fragmentManager, str, false);
    }

    private SupportRequestManagerFragment getSupportFragment(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z) {
        SupportRequestManagerFragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag == null && (findFragmentByTag = this.mPendingSupportFragments.get(fragmentManager)) == null) {
            if (z) {
                return null;
            }
            findFragmentByTag = new SupportRequestManagerFragment();
            this.mPendingSupportFragments.put(fragmentManager, findFragmentByTag);
            fragmentManager.beginTransaction().add(findFragmentByTag, str).commitAllowingStateLoss();
            this.mHandler.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z) {
            return findFragmentByTag;
        }
        fragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        return null;
    }

    private static <T> void checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
    }
}
