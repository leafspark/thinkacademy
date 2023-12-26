package com.sensorsdata.analytics.android.sdk.internal.api;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreen;
import com.sensorsdata.analytics.android.sdk.SensorsDataIgnoreTrackAppViewScreenAndAppClick;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FragmentAPI implements IFragmentAPI {
    private static final String TAG = "FragmentAPI";
    private Set<Integer> mAutoTrackFragments;
    private Set<Integer> mAutoTrackIgnoredFragments;
    private boolean mTrackFragmentAppViewScreen;

    public void trackFragmentAppViewScreen() {
        this.mTrackFragmentAppViewScreen = true;
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mTrackFragmentAppViewScreen;
    }

    public void enableAutoTrackFragment(Class<?> cls) {
        if (cls != null) {
            try {
                if (this.mAutoTrackFragments == null) {
                    this.mAutoTrackFragments = new CopyOnWriteArraySet();
                }
                String canonicalName = cls.getCanonicalName();
                if (!TextUtils.isEmpty(canonicalName)) {
                    this.mAutoTrackFragments.add(Integer.valueOf(canonicalName.hashCode()));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void enableAutoTrackFragments(List<Class<?>> list) {
        if (list != null && list.size() != 0) {
            if (this.mAutoTrackFragments == null) {
                this.mAutoTrackFragments = new CopyOnWriteArraySet();
            }
            try {
                for (Class<?> canonicalName : list) {
                    String canonicalName2 = canonicalName.getCanonicalName();
                    if (!TextUtils.isEmpty(canonicalName2)) {
                        this.mAutoTrackFragments.add(Integer.valueOf(canonicalName2.hashCode()));
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public boolean isFragmentAutoTrackAppViewScreen(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        try {
            if (!SensorsDataAPI.sharedInstance().isAutoTrackEventTypeIgnored(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN)) {
                if (this.mTrackFragmentAppViewScreen) {
                    Set<Integer> set = this.mAutoTrackFragments;
                    if (set != null && set.size() > 0) {
                        String canonicalName = cls.getCanonicalName();
                        if (!TextUtils.isEmpty(canonicalName)) {
                            return this.mAutoTrackFragments.contains(Integer.valueOf(canonicalName.hashCode()));
                        }
                    }
                    if (cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreen.class) != null || cls.getAnnotation(SensorsDataIgnoreTrackAppViewScreenAndAppClick.class) != null) {
                        return false;
                    }
                    Set<Integer> set2 = this.mAutoTrackIgnoredFragments;
                    if (set2 != null && set2.size() > 0) {
                        String canonicalName2 = cls.getCanonicalName();
                        if (!TextUtils.isEmpty(canonicalName2)) {
                            return !this.mAutoTrackIgnoredFragments.contains(Integer.valueOf(canonicalName2.hashCode()));
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public void ignoreAutoTrackFragments(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    if (this.mAutoTrackIgnoredFragments == null) {
                        this.mAutoTrackIgnoredFragments = new CopyOnWriteArraySet();
                    }
                    for (Class next : list) {
                        if (next != null) {
                            String canonicalName = next.getCanonicalName();
                            if (!TextUtils.isEmpty(canonicalName)) {
                                this.mAutoTrackIgnoredFragments.add(Integer.valueOf(canonicalName.hashCode()));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void ignoreAutoTrackFragment(Class<?> cls) {
        if (cls != null) {
            try {
                if (this.mAutoTrackIgnoredFragments == null) {
                    this.mAutoTrackIgnoredFragments = new CopyOnWriteArraySet();
                }
                String canonicalName = cls.getCanonicalName();
                if (!TextUtils.isEmpty(canonicalName)) {
                    this.mAutoTrackIgnoredFragments.add(Integer.valueOf(canonicalName.hashCode()));
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void resumeIgnoredAutoTrackFragments(List<Class<?>> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                if (this.mAutoTrackIgnoredFragments != null) {
                    for (Class next : list) {
                        if (next != null) {
                            String canonicalName = next.getCanonicalName();
                            if (!TextUtils.isEmpty(canonicalName)) {
                                this.mAutoTrackIgnoredFragments.remove(Integer.valueOf(canonicalName.hashCode()));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }

    public void resumeIgnoredAutoTrackFragment(Class<?> cls) {
        if (cls != null) {
            try {
                if (this.mAutoTrackIgnoredFragments != null) {
                    String canonicalName = cls.getCanonicalName();
                    if (!TextUtils.isEmpty(canonicalName)) {
                        this.mAutoTrackIgnoredFragments.remove(Integer.valueOf(canonicalName.hashCode()));
                    }
                }
            } catch (Exception e) {
                SALog.printStackTrace(e);
            }
        }
    }
}
