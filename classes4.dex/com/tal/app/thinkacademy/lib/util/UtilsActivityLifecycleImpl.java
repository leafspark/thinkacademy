package com.tal.app.thinkacademy.lib.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class UtilsActivityLifecycleImpl implements Application.ActivityLifecycleCallbacks {
    static final UtilsActivityLifecycleImpl INSTANCE = new UtilsActivityLifecycleImpl();
    /* access modifiers changed from: private */
    public final Map<Activity, List<Utils.ActivityLifecycleCallbacks>> mActivityLifecycleCallbacksMap = new ConcurrentHashMap();
    private final LinkedList<Activity> mActivityList = new LinkedList<>();
    private int mConfigCount = 0;
    private int mForegroundCount = 0;
    private boolean mIsBackground = false;
    private final List<Utils.OnAppStatusChangedListener> mStatusListeners = new ArrayList();

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    UtilsActivityLifecycleImpl() {
    }

    /* access modifiers changed from: package-private */
    public void init(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    /* access modifiers changed from: package-private */
    public void unInit(Application application) {
        this.mActivityList.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }

    /* access modifiers changed from: package-private */
    public Activity getTopActivity() {
        for (Activity next : getActivityList()) {
            if (UtilsBridge.isActivityAlive(next)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<Activity> getActivityList() {
        if (!this.mActivityList.isEmpty()) {
            return this.mActivityList;
        }
        this.mActivityList.addAll(getActivitiesByReflect());
        return this.mActivityList;
    }

    /* access modifiers changed from: package-private */
    public void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.mStatusListeners.add(onAppStatusChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        this.mStatusListeners.remove(onAppStatusChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void addActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                public void run() {
                    UtilsActivityLifecycleImpl.this.addActivityLifecycleCallbacksInner(activity, activityLifecycleCallbacks);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(getActivityThread(), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void addActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List list = this.mActivityLifecycleCallbacksMap.get(activity);
        if (list == null) {
            list = new ArrayList();
            this.mActivityLifecycleCallbacksMap.put(activity, list);
        } else if (list.contains(activityLifecycleCallbacks)) {
            return;
        }
        list.add(activityLifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    public void removeActivityLifecycleCallbacks(final Activity activity) {
        if (activity != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                public void run() {
                    UtilsActivityLifecycleImpl.this.mActivityLifecycleCallbacksMap.remove(activity);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void removeActivityLifecycleCallbacks(final Activity activity, final Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            UtilsBridge.runOnUiThread(new Runnable() {
                public void run() {
                    UtilsActivityLifecycleImpl.this.removeActivityLifecycleCallbacksInner(activity, activityLifecycleCallbacks);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void removeActivityLifecycleCallbacksInner(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List list = this.mActivityLifecycleCallbacksMap.get(activity);
        if (list != null && !list.isEmpty()) {
            list.remove(activityLifecycleCallbacks);
        }
    }

    private void consumeActivityLifecycleCallbacks(Activity activity, Lifecycle.Event event) {
        List<Utils.ActivityLifecycleCallbacks> list = this.mActivityLifecycleCallbacksMap.get(activity);
        if (list != null) {
            for (Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks : list) {
                activityLifecycleCallbacks.onLifecycleChanged(activity, event);
                if (event.equals(Lifecycle.Event.ON_CREATE)) {
                    activityLifecycleCallbacks.onActivityCreated(activity);
                } else if (event.equals(Lifecycle.Event.ON_START)) {
                    activityLifecycleCallbacks.onActivityStarted(activity);
                } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                    activityLifecycleCallbacks.onActivityResumed(activity);
                } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                    activityLifecycleCallbacks.onActivityPaused(activity);
                } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                    activityLifecycleCallbacks.onActivityStopped(activity);
                } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                    activityLifecycleCallbacks.onActivityDestroyed(activity);
                }
            }
            if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.mActivityLifecycleCallbacksMap.remove(activity);
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        setAnimatorsEnabled();
        setTopActivity(activity);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_CREATE);
    }

    public void onActivityStarted(Activity activity) {
        if (!this.mIsBackground) {
            setTopActivity(activity);
        }
        int i = this.mConfigCount;
        if (i < 0) {
            this.mConfigCount = i + 1;
        } else {
            this.mForegroundCount++;
        }
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_START);
    }

    public void onActivityResumed(Activity activity) {
        setTopActivity(activity);
        if (this.mIsBackground) {
            this.mIsBackground = false;
            postStatus(activity, true);
        }
        processHideSoftInputOnActivityDestroy(activity, false);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_RESUME);
    }

    public void onActivityPaused(Activity activity) {
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_PAUSE);
    }

    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.mConfigCount--;
        } else {
            int i = this.mForegroundCount - 1;
            this.mForegroundCount = i;
            if (i <= 0) {
                this.mIsBackground = true;
                postStatus(activity, false);
            }
        }
        processHideSoftInputOnActivityDestroy(activity, true);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_STOP);
    }

    public void onActivityDestroyed(Activity activity) {
        this.mActivityList.remove(activity);
        UtilsBridge.fixSoftInputLeaks(activity);
        consumeActivityLifecycleCallbacks(activity, Lifecycle.Event.ON_DESTROY);
    }

    private void processHideSoftInputOnActivityDestroy(final Activity activity, boolean z) {
        if (z) {
            activity.getWindow().getDecorView().setTag(-123, Integer.valueOf(activity.getWindow().getAttributes().softInputMode));
            activity.getWindow().setSoftInputMode(3);
            return;
        }
        final Object tag = activity.getWindow().getDecorView().getTag(-123);
        if (tag instanceof Integer) {
            UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    Window window = activity.getWindow();
                    if (window != null) {
                        window.setSoftInputMode(((Integer) tag).intValue());
                    }
                }
            }, 100);
        }
    }

    private void postStatus(Activity activity, boolean z) {
        if (!this.mStatusListeners.isEmpty()) {
            for (Utils.OnAppStatusChangedListener next : this.mStatusListeners) {
                if (z) {
                    next.onForeground(activity);
                } else {
                    next.onBackground(activity);
                }
            }
        }
    }

    private void setTopActivity(Activity activity) {
        if (!this.mActivityList.contains(activity)) {
            this.mActivityList.addFirst(activity);
        } else if (!this.mActivityList.getFirst().equals(activity)) {
            this.mActivityList.remove(activity);
            this.mActivityList.addFirst(activity);
        }
    }

    private List<Activity> getActivitiesByReflect() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object activityThread = getActivityThread();
            Field declaredField = activityThread.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activityThread);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object next : ((Map) obj).values()) {
                Class<?> cls = next.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(next);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (!declaredField3.getBoolean(next)) {
                        activity = activity2;
                    } else {
                        linkedList.add(activity2);
                    }
                } else {
                    linkedList.add(activity2);
                }
            }
            if (activity != null) {
                linkedList.addFirst(activity);
            }
            return linkedList;
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e.getMessage());
        }
    }

    private Object getActivityThread() {
        Object activityThreadInActivityThreadStaticField = getActivityThreadInActivityThreadStaticField();
        if (activityThreadInActivityThreadStaticField != null) {
            return activityThreadInActivityThreadStaticField;
        }
        Object activityThreadInActivityThreadStaticMethod = getActivityThreadInActivityThreadStaticMethod();
        if (activityThreadInActivityThreadStaticMethod != null) {
            return activityThreadInActivityThreadStaticMethod;
        }
        return getActivityThreadInLoadedApkField();
    }

    private Object getActivityThreadInActivityThreadStaticField() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e.getMessage());
            return null;
        }
    }

    private Object getActivityThreadInActivityThreadStaticMethod() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e.getMessage());
            return null;
        }
    }

    private Object getActivityThreadInLoadedApkField() {
        try {
            Field declaredField = Application.class.getDeclaredField("mLoadedApk");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Utils.getApp());
            Field declaredField2 = obj.getClass().getDeclaredField("mActivityThread");
            declaredField2.setAccessible(true);
            return declaredField2.get(obj);
        } catch (Exception e) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInLoadedApkField: " + e.getMessage());
            return null;
        }
    }

    private static void setAnimatorsEnabled() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get((Object) null)).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }
}
