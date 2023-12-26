package com.tal.app.thinkacademy.lib.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\u0012J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rR*\u0010\u0003\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0004j\b\u0012\u0004\u0012\u00020\r`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager;", "", "()V", "activityRefs", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "Lkotlin/collections/ArrayList;", "activityStartCount", "", "front", "", "frontBackCallbacks", "Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$FrontBackCallback;", "sCurrentActivityWeakRef", "tag", "", "addFrontBackCallback", "", "callback", "clearFrontBackCallback", "getCurrentActivity", "getSecondTopActivity", "getTopActivity", "onlyAlive", "init", "application", "Landroid/app/Application;", "onFrontBackChanged", "removeFrontBackCallback", "Companion", "FrontBackCallback", "InnerActivityLifecycleCallbacks", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: XesActivityManager.kt */
public final class XesActivityManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<XesActivityManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, XesActivityManager$Companion$instance$2.INSTANCE);
    /* access modifiers changed from: private */
    public final ArrayList<WeakReference<Activity>> activityRefs;
    /* access modifiers changed from: private */
    public int activityStartCount;
    /* access modifiers changed from: private */
    public boolean front;
    private final ArrayList<FrontBackCallback> frontBackCallbacks;
    /* access modifiers changed from: private */
    public WeakReference<Activity> sCurrentActivityWeakRef;
    /* access modifiers changed from: private */
    public String tag;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$FrontBackCallback;", "", "onChanged", "", "front", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: XesActivityManager.kt */
    public interface FrontBackCallback {
        void onChanged(boolean z);
    }

    public /* synthetic */ XesActivityManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final XesActivityManager getInstance() {
        return Companion.getInstance();
    }

    private XesActivityManager() {
        this.activityRefs = new ArrayList<>();
        this.frontBackCallbacks = new ArrayList<>();
        this.front = true;
        this.tag = "XesActivityManager";
    }

    public final void init(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new InnerActivityLifecycleCallbacks(this));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$InnerActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "(Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: XesActivityManager.kt */
    public final class InnerActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        final /* synthetic */ XesActivityManager this$0;

        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "outState");
        }

        public InnerActivityLifecycleCallbacks(XesActivityManager xesActivityManager) {
            Intrinsics.checkNotNullParameter(xesActivityManager, "this$0");
            this.this$0 = xesActivityManager;
        }

        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            XesActivityManager xesActivityManager = this.this$0;
            xesActivityManager.activityStartCount = xesActivityManager.activityStartCount + 1;
            if (!this.this$0.front && this.this$0.activityStartCount > 0) {
                this.this$0.front = true;
                XesActivityManager xesActivityManager2 = this.this$0;
                xesActivityManager2.onFrontBackChanged(xesActivityManager2.front);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Iterator it = this.this$0.activityRefs.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && Intrinsics.areEqual(weakReference.get(), activity)) {
                    this.this$0.activityRefs.remove(weakReference);
                    return;
                }
            }
        }

        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            XesActivityManager xesActivityManager = this.this$0;
            xesActivityManager.activityStartCount = xesActivityManager.activityStartCount - 1;
            if (this.this$0.activityStartCount == 0) {
                LaunchUtil.sAppStartTime = 0;
                XesLog.it(this.this$0.tag, "退到后台");
            }
            if (this.this$0.activityStartCount <= 0 && this.this$0.front) {
                this.this$0.front = false;
                XesActivityManager xesActivityManager2 = this.this$0;
                xesActivityManager2.onFrontBackChanged(xesActivityManager2.front);
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.this$0.activityRefs.add(new WeakReference(activity));
        }

        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.this$0.sCurrentActivityWeakRef = new WeakReference(activity);
        }
    }

    /* access modifiers changed from: private */
    public final void onFrontBackChanged(boolean z) {
        Iterator<FrontBackCallback> it = this.frontBackCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onChanged(z);
        }
    }

    public final Activity getTopActivity(boolean z) {
        if (this.activityRefs.size() <= 0) {
            return null;
        }
        ArrayList<WeakReference<Activity>> arrayList = this.activityRefs;
        WeakReference<Activity> weakReference = arrayList.get(arrayList.size() - 1);
        Intrinsics.checkNotNullExpressionValue(weakReference, "activityRefs[activityRefs.size - 1]");
        WeakReference weakReference2 = weakReference;
        Activity activity = (Activity) weakReference2.get();
        if (!z || (activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()))) {
            return activity;
        }
        this.activityRefs.remove(weakReference2);
        return getTopActivity(z);
    }

    public final Activity getSecondTopActivity() {
        if (this.activityRefs.size() < 2) {
            return null;
        }
        ArrayList<WeakReference<Activity>> arrayList = this.activityRefs;
        WeakReference<Activity> weakReference = arrayList.get(arrayList.size() - 2);
        Intrinsics.checkNotNullExpressionValue(weakReference, "activityRefs[activityRefs.size - 2]");
        return (Activity) weakReference.get();
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.sCurrentActivityWeakRef;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public final void addFrontBackCallback(FrontBackCallback frontBackCallback) {
        Intrinsics.checkNotNullParameter(frontBackCallback, "callback");
        if (!this.frontBackCallbacks.contains(frontBackCallback)) {
            this.frontBackCallbacks.add(frontBackCallback);
        }
    }

    public final void removeFrontBackCallback(FrontBackCallback frontBackCallback) {
        Intrinsics.checkNotNullParameter(frontBackCallback, "callback");
        this.frontBackCallbacks.remove(frontBackCallback);
    }

    public final void clearFrontBackCallback() {
        this.frontBackCallbacks.clear();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager;", "getInstance$annotations", "getInstance", "()Lcom/tal/app/thinkacademy/lib/utils/XesActivityManager;", "instance$delegate", "Lkotlin/Lazy;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: XesActivityManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final XesActivityManager getInstance() {
            return (XesActivityManager) XesActivityManager.instance$delegate.getValue();
        }
    }
}
