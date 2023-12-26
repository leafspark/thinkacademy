package com.bonree.sdk.agent.engine.external;

import android.app.Activity;
import com.bonree.sdk.z.b;

public class ActivityInfo {
    public static void endOnDestroyView(Activity activity, Object obj) {
    }

    public static void endTraceFragment(String str) {
    }

    public static void startOnDestroyView(Activity activity, Object obj) {
    }

    public static void startTraceFragment(String str) {
    }

    public static void stopActivity() {
    }

    public static void startTraceActivity(String str) {
        b.a().a(str);
    }

    public static void endTraceActivity(String str) {
        b.a().b(str);
    }

    public static void onStartTrace(String str) {
        b.a().c(str);
    }

    public static void endStartTrace(String str) {
        b.a().d(str);
    }

    public static void resumeActivity(String str) {
        b.a().e(str);
    }

    public static void endResumeTrace(String str) {
        b.a().f(str);
    }

    public static void onReStartTrace(String str) {
        b.a().j(str);
    }

    public static void endReStartTrace(String str) {
        b.a().k(str);
    }

    public static void pauseActivity(String str) {
        b.a().g(str);
    }

    public static void endPauseActivity(String str) {
        b.a().h(str);
    }

    public static void finishActivity(String str) {
        b.a().i(str);
    }

    public static void startCreateFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().a(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endCreateFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().b(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void startOnStartFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().c(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endOnStartFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().d(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void startOnPauseFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().g(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endOnPauseFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().h(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void startOnResumeFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().e(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endOnResumeFragment(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().f(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void startUserVisibleHint(Activity activity, Object obj, boolean z) {
        com.bonree.sdk.aa.b.a().a(activity == null ? null : activity.getClass().getName(), obj, z);
    }

    public static void endUserVisibleHint(Activity activity, Object obj, boolean z) {
        com.bonree.sdk.aa.b.a().b(activity == null ? null : activity.getClass().getName(), obj, z);
    }

    public static void startOnHiddenChanged(Activity activity, Object obj, boolean z) {
        com.bonree.sdk.aa.b.a().c(activity == null ? null : activity.getClass().getName(), obj, z);
    }

    public static void endOnHiddenChanged(Activity activity, Object obj, boolean z) {
        com.bonree.sdk.aa.b.a().d(activity == null ? null : activity.getClass().getName(), obj, z);
    }

    public static void startOnViewCreated(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().i(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endOnViewCreated(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().j(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void startOnActivityCreated(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().k(activity == null ? null : activity.getClass().getName(), obj);
    }

    public static void endOnActivityCreated(Activity activity, Object obj) {
        com.bonree.sdk.aa.b.a().l(activity == null ? null : activity.getClass().getName(), obj);
    }
}
