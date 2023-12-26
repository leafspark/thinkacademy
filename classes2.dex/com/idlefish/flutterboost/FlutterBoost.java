package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.containers.FlutterContainerManager;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.view.FlutterMain;
import java.util.Map;

public class FlutterBoost {
    public static final String ENGINE_ID = "flutter_boost_default_engine";
    private boolean isAppInBackground;
    private boolean isBackForegroundEventOverridden;
    private FlutterBoostPlugin plugin;
    /* access modifiers changed from: private */
    public Activity topActivity;

    public interface Callback {
        void onStart(FlutterEngine flutterEngine);
    }

    private FlutterBoost() {
        this.topActivity = null;
        this.isBackForegroundEventOverridden = false;
        this.isAppInBackground = false;
    }

    private static class LazyHolder {
        static final FlutterBoost INSTANCE = new FlutterBoost();

        private LazyHolder() {
        }
    }

    public static FlutterBoost instance() {
        return LazyHolder.INSTANCE;
    }

    public void setup(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback) {
        setup(application, flutterBoostDelegate, callback, FlutterBoostSetupOptions.createDefault());
    }

    public void setup(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback, FlutterBoostSetupOptions flutterBoostSetupOptions) {
        if (flutterBoostSetupOptions == null) {
            flutterBoostSetupOptions = FlutterBoostSetupOptions.createDefault();
        }
        this.isBackForegroundEventOverridden = flutterBoostSetupOptions.shouldOverrideBackForegroundEvent();
        FlutterEngine engine = getEngine();
        if (engine == null) {
            if (flutterBoostSetupOptions.flutterEngineProvider() != null) {
                engine = flutterBoostSetupOptions.flutterEngineProvider().provideFlutterEngine(application);
            }
            if (engine == null) {
                engine = new FlutterEngine(application, flutterBoostSetupOptions.shellArgs());
            }
            FlutterEngineCache.getInstance().put(ENGINE_ID, engine);
        }
        if (!engine.getDartExecutor().isExecutingDart()) {
            engine.getNavigationChannel().setInitialRoute(flutterBoostSetupOptions.initialRoute());
            engine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), flutterBoostSetupOptions.dartEntrypoint()));
        }
        if (callback != null) {
            callback.onStart(engine);
        }
        getPlugin().setDelegate(flutterBoostDelegate);
        setupActivityLifecycleCallback(application, this.isBackForegroundEventOverridden);
    }

    public void tearDown() {
        FlutterEngine engine = getEngine();
        if (engine != null) {
            engine.destroy();
            FlutterEngineCache.getInstance().remove(ENGINE_ID);
        }
        this.topActivity = null;
        this.plugin = null;
        this.isBackForegroundEventOverridden = false;
        this.isAppInBackground = false;
    }

    public FlutterBoostPlugin getPlugin() {
        if (this.plugin == null) {
            FlutterEngine engine = getEngine();
            if (engine != null) {
                this.plugin = FlutterBoostUtils.getPlugin(engine);
            } else {
                throw new RuntimeException("FlutterBoost might *not* have been initialized yet!!!");
            }
        }
        return this.plugin;
    }

    public FlutterEngine getEngine() {
        return FlutterEngineCache.getInstance().get(ENGINE_ID);
    }

    public Activity currentActivity() {
        return this.topActivity;
    }

    public void dispatchBackForegroundEvent(boolean z) {
        if (this.isBackForegroundEventOverridden) {
            if (z) {
                getPlugin().onBackground();
            } else {
                getPlugin().onForeground();
            }
            setAppIsInBackground(z);
            return;
        }
        throw new RuntimeException("Oops! You should set override enable first by FlutterBoostSetupOptions.");
    }

    public FlutterViewContainer findFlutterViewContainerById(String str) {
        return FlutterContainerManager.instance().findContainerById(str);
    }

    public FlutterViewContainer getTopContainer() {
        return FlutterContainerManager.instance().getTopContainer();
    }

    public void open(String str, Map<String, Object> map) {
        getPlugin().getDelegate().pushFlutterRoute(new FlutterBoostRouteOptions.Builder().pageName(str).arguments(map).build());
    }

    public void open(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        getPlugin().getDelegate().pushFlutterRoute(flutterBoostRouteOptions);
    }

    public void close(String str) {
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        getPlugin().popRoute(commonParams, (Messages.Result<Void>) new Messages.Result<Void>() {
            public void error(Throwable th) {
            }

            public void success(Void voidR) {
            }
        });
    }

    public void changeFlutterAppLifecycle(int i) {
        getPlugin().changeFlutterAppLifecycle(i);
    }

    public ListenerRemover addEventListener(String str, EventListener eventListener) {
        return getPlugin().addEventListener(str, eventListener);
    }

    public void sendEventToFlutter(String str, Map<String, Object> map) {
        getPlugin().sendEventToFlutter(str, map);
    }

    public boolean isAppInBackground() {
        return this.isAppInBackground;
    }

    /* access modifiers changed from: package-private */
    public void setAppIsInBackground(boolean z) {
        this.isAppInBackground = z;
    }

    private void setupActivityLifecycleCallback(Application application, boolean z) {
        application.registerActivityLifecycleCallbacks(new BoostActivityLifecycle(z));
    }

    private class BoostActivityLifecycle implements Application.ActivityLifecycleCallbacks {
        private int activityReferences = 0;
        private boolean isActivityChangingConfigurations = false;
        private boolean isBackForegroundEventOverridden = false;

        public void onActivityPaused(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public BoostActivityLifecycle(boolean z) {
            this.isBackForegroundEventOverridden = z;
        }

        private void dispatchForegroundEvent() {
            if (!this.isBackForegroundEventOverridden) {
                FlutterBoost.instance().setAppIsInBackground(false);
                FlutterBoost.instance().getPlugin().onForeground();
            }
        }

        private void dispatchBackgroundEvent() {
            if (!this.isBackForegroundEventOverridden) {
                FlutterBoost.instance().setAppIsInBackground(true);
                FlutterBoost.instance().getPlugin().onBackground();
            }
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            Activity unused = FlutterBoost.this.topActivity = activity;
        }

        public void onActivityStarted(Activity activity) {
            int i = this.activityReferences + 1;
            this.activityReferences = i;
            if (i == 1 && !this.isActivityChangingConfigurations) {
                dispatchForegroundEvent();
            }
        }

        public void onActivityResumed(Activity activity) {
            Activity unused = FlutterBoost.this.topActivity = activity;
        }

        public void onActivityStopped(Activity activity) {
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.isActivityChangingConfigurations = isChangingConfigurations;
            int i = this.activityReferences - 1;
            this.activityReferences = i;
            if (i == 0 && !isChangingConfigurations) {
                dispatchBackgroundEvent();
            }
        }

        public void onActivityDestroyed(Activity activity) {
            if (FlutterBoost.this.topActivity == activity) {
                Activity unused = FlutterBoost.this.topActivity = null;
            }
        }
    }
}
