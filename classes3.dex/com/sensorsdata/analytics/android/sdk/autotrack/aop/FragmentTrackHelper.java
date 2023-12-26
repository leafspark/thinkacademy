package com.sensorsdata.analytics.android.sdk.autotrack.aop;

import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.autotrack.SAFragmentLifecycleCallbacks;
import com.sensorsdata.analytics.android.sdk.util.SAFragmentUtils;
import java.util.HashSet;
import java.util.Set;

public class FragmentTrackHelper {
    private static final Set<SAFragmentLifecycleCallbacks> FRAGMENT_CALLBACKS = new HashSet();

    public static void onFragmentViewCreated(Object obj, View view, Bundle bundle) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onViewCreated : FRAGMENT_CALLBACKS) {
                try {
                    onViewCreated.onViewCreated(obj, view, bundle);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackFragmentResume(Object obj) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onResume : FRAGMENT_CALLBACKS) {
                try {
                    onResume.onResume(obj);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackFragmentPause(Object obj) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onPause : FRAGMENT_CALLBACKS) {
                try {
                    onPause.onPause(obj);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackFragmentSetUserVisibleHint(Object obj, boolean z) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks userVisibleHint : FRAGMENT_CALLBACKS) {
                try {
                    userVisibleHint.setUserVisibleHint(obj, z);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void trackOnHiddenChanged(Object obj, boolean z) {
        if (SAFragmentUtils.isFragment(obj)) {
            for (SAFragmentLifecycleCallbacks onHiddenChanged : FRAGMENT_CALLBACKS) {
                try {
                    onHiddenChanged.onHiddenChanged(obj, z);
                } catch (Exception e) {
                    SALog.printStackTrace(e);
                }
            }
        }
    }

    public static void addFragmentCallbacks(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        FRAGMENT_CALLBACKS.add(sAFragmentLifecycleCallbacks);
    }

    public static void removeFragmentCallbacks(SAFragmentLifecycleCallbacks sAFragmentLifecycleCallbacks) {
        FRAGMENT_CALLBACKS.remove(sAFragmentLifecycleCallbacks);
    }
}
