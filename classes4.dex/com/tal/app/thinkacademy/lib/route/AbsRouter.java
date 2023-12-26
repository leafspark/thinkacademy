package com.tal.app.thinkacademy.lib.route;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.launcher.ARouter;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class AbsRouter {
    private static final String TAG = "AbsRouter";

    public void init(Application application, boolean z) {
        if (z) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }

    public void inject(Object obj) {
        if (!checkNoDependenciesARouter()) {
            getRouter().inject(obj);
        }
    }

    public ARouter getRouter() {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return ARouter.getInstance();
    }

    public void navigation(String str) {
        if (!checkNoDependenciesARouter()) {
            getRouter().build(str).navigation();
        }
    }

    public void navigation(Uri uri) {
        if (!checkNoDependenciesARouter()) {
            getRouter().build(uri).navigation();
        }
    }

    public void navigation(String str, Bundle bundle) {
        if (!checkNoDependenciesARouter()) {
            getRouter().build(str).with(bundle).navigation();
        }
    }

    public void navigation(String str, Bundle bundle, int i) {
        if (!checkNoDependenciesARouter()) {
            getRouter().build(str).with(bundle).withFlags(i).navigation();
        }
    }

    public <T> T get(String str) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return get(str, new Bundle());
    }

    public <T> T get(String str, Bundle bundle) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return getRouter().build(str).with(bundle).navigation();
    }

    public <T> T get(Uri uri) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return get(uri, new Bundle());
    }

    public <T> T get(Uri uri, Bundle bundle) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return getRouter().build(uri).with(bundle).navigation();
    }

    public void navigation(String str, FragmentActivity fragmentActivity, int i, int i2, int i3, ResultCallback resultCallback) {
        navigation(str, fragmentActivity, (Bundle) null, i, (ActivityOptionsCompat) null, i2, i3, resultCallback);
    }

    public void navigation(String str, FragmentActivity fragmentActivity, int i, ResultCallback resultCallback) {
        navigation(str, fragmentActivity, (Bundle) null, i, resultCallback);
    }

    public void navigation(String str, FragmentActivity fragmentActivity, Bundle bundle, int i, ResultCallback resultCallback) {
        navigation(str, fragmentActivity, bundle, i, (ActivityOptionsCompat) null, resultCallback);
    }

    public void navigation(String str, FragmentActivity fragmentActivity, Bundle bundle, int i, ActivityOptionsCompat activityOptionsCompat, ResultCallback resultCallback) {
        navigation(str, fragmentActivity, bundle, i, activityOptionsCompat, -1, -1, resultCallback);
    }

    public void navigation(String str, FragmentActivity fragmentActivity, Bundle bundle, int i, int i2, int i3, ResultCallback resultCallback) {
        navigation(str, fragmentActivity, bundle, i, (ActivityOptionsCompat) null, i2, i3, resultCallback);
    }

    public void navigation(String str, Fragment fragment, int i, ResultCallback resultCallback) {
        navigation(str, fragment, (Bundle) null, i, resultCallback);
    }

    public void navigation(String str, Fragment fragment, Bundle bundle, int i, ResultCallback resultCallback) {
        navigation(str, fragment, bundle, i, (ActivityOptionsCompat) null, resultCallback);
    }

    public void navigation(String str, Fragment fragment, Bundle bundle, int i, ActivityOptionsCompat activityOptionsCompat, ResultCallback resultCallback) {
        navigation(str, fragment, bundle, i, activityOptionsCompat, -1, -1, resultCallback);
    }

    public void navigation(String str, Fragment fragment, Bundle bundle, int i, int i2, int i3, ResultCallback resultCallback) {
        navigation(str, fragment, bundle, i, (ActivityOptionsCompat) null, i2, i3, resultCallback);
    }

    private void navigation(String str, Fragment fragment, Bundle bundle, int i, ActivityOptionsCompat activityOptionsCompat, int i2, int i3, ResultCallback resultCallback) {
        if (fragment.getActivity() != null) {
            navigation(str, fragment.getActivity(), bundle, i, activityOptionsCompat, i2, i3, resultCallback);
            return;
        }
        throw new XesRouteException("目标 getActivity() 为空");
    }

    private void navigation(String str, FragmentActivity fragmentActivity, Bundle bundle, int i, ActivityOptionsCompat activityOptionsCompat, int i2, int i3, ResultCallback resultCallback) {
        if (!checkNoDependenciesARouter()) {
            WeakReference weakReference = new WeakReference(fragmentActivity);
            Postcard withTransition = getRouter().build(str).with(bundle).withOptionsCompat(activityOptionsCompat).withTransition(i2, i3);
            withTransition.setType(RouteType.ACTIVITY);
            Fragment findFragmentByTag = ((FragmentActivity) weakReference.get()).getSupportFragmentManager().findFragmentByTag(ProxyFragment.TAG);
            if (findFragmentByTag != null) {
                ((FragmentActivity) weakReference.get()).getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            ((FragmentActivity) weakReference.get()).getSupportFragmentManager().beginTransaction().add(ProxyFragment.newInstance(withTransition, i, resultCallback), ProxyFragment.TAG).commitAllowingStateLoss();
        }
    }

    public void navigation(FragmentActivity fragmentActivity, Intent intent, int i, ResultCallback resultCallback) {
        if (!checkNoDependenciesARouter()) {
            WeakReference weakReference = new WeakReference(fragmentActivity);
            Fragment findFragmentByTag = ((FragmentActivity) weakReference.get()).getSupportFragmentManager().findFragmentByTag(ProxyFragment.TAG);
            if (findFragmentByTag != null) {
                ((FragmentActivity) weakReference.get()).getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
            ((FragmentActivity) weakReference.get()).getSupportFragmentManager().beginTransaction().add(ProxyFragment.newInstance(intent, i, resultCallback), ProxyFragment.TAG).commitAllowingStateLoss();
        }
    }

    public void navigation(Fragment fragment, Intent intent, int i, ResultCallback resultCallback) {
        if (fragment.getActivity() != null) {
            navigation(fragment.getActivity(), intent, i, resultCallback);
            return;
        }
        throw new XesRouteException("目标 getActivity() 为空");
    }

    public <T> T navigation(Class<? extends T> cls) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return getRouter().navigation(cls);
    }

    public Object navigation(Context context, Postcard postcard, int i, NavigationCallback navigationCallback) {
        if (checkNoDependenciesARouter()) {
            return null;
        }
        return getRouter().navigation(context, postcard, i, navigationCallback);
    }

    private static boolean checkNoDependenciesARouter() {
        try {
            Class.forName("com.alibaba.android.arouter.launcher.ARouter");
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static synchronized void openDebug() {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.openDebug();
            }
        }
    }

    public static boolean debuggable() {
        if (checkNoDependenciesARouter()) {
            return false;
        }
        return ARouter.debuggable();
    }

    public static synchronized void openLog() {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.openLog();
            }
        }
    }

    public static synchronized void printStackTrace() {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.printStackTrace();
            }
        }
    }

    public static synchronized void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.setExecutor(threadPoolExecutor);
            }
        }
    }

    public static synchronized void monitorMode() {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.monitorMode();
            }
        }
    }

    public static boolean isMonitorMode() {
        if (checkNoDependenciesARouter()) {
            return false;
        }
        return ARouter.isMonitorMode();
    }

    public static void setLogger(ILogger iLogger) {
        if (!checkNoDependenciesARouter()) {
            ARouter.setLogger(iLogger);
        }
    }

    public static synchronized void destroy() {
        synchronized (AbsRouter.class) {
            if (!checkNoDependenciesARouter()) {
                ARouter.getInstance().destroy();
            }
        }
    }

    public static Fragment getSupportFragment(String str) {
        return (Fragment) ARouter.getInstance().build(str).navigation();
    }
}
