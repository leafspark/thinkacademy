package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.idlefish.flutterboost.Assert;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostUtils;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FlutterBoostActivity extends FlutterActivity implements FlutterViewContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlutterBoostActivity";
    private FlutterView flutterView;
    private boolean isAttached = false;
    private PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final FlutterTextureHooker textureHooker = new FlutterTextureHooker();
    private final String who = UUID.randomUUID().toString();

    public void detachFromFlutterEngine() {
    }

    public void finish() {
        FlutterBoostActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.idlefish.flutterboost.containers.FlutterBoostActivity, android.app.Activity] */
    public Activity getContextActivity() {
        return this;
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        FlutterBoostActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return false;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public boolean shouldDispatchAppLifecycleState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        FlutterViewContainer topContainer = FlutterContainerManager.instance().getTopContainer();
        if (!(topContainer == null || topContainer == this)) {
            topContainer.detachFromEngineIfNeeded();
        }
        FlutterBoostActivity.super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
        FlutterView findFlutterView = FlutterBoostUtils.findFlutterView(getWindow().getDecorView());
        this.flutterView = findFlutterView;
        findFlutterView.detachFromFlutterEngine();
        FlutterBoost.instance().getPlugin().onContainerCreated(this);
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    public void onUserLeaveHint() {
        FlutterBoostActivity.super.onUserLeaveHint();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        FlutterBoostActivity.super.onStart();
        this.stage = LifecycleStage.ON_START;
        ActivityInfo.endStartTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        ActivityInfo.stopActivity();
        FlutterBoostActivity.super.onStop();
        this.stage = LifecycleStage.ON_STOP;
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        FlutterBoostActivity.super.onResume();
        FlutterContainerManager instance = FlutterContainerManager.instance();
        if (Build.VERSION.SDK_INT == 29) {
            FlutterViewContainer topActivityContainer = instance.getTopActivityContainer();
            if (instance.isActiveContainer(this) && topActivityContainer != null && topActivityContainer != this && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                ActivityInfo.endResumeTrace(getClass().getName());
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        FlutterViewContainer topContainer = instance.getTopContainer();
        if (!(topContainer == null || topContainer == this)) {
            topContainer.detachFromEngineIfNeeded();
        }
        performAttach();
        this.textureHooker.onFlutterTextureViewRestoreState();
        FlutterBoost.instance().getPlugin().onContainerAppeared(this);
        Assert.assertNotNull(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        FlutterBoostActivity.super.onPause();
        FlutterViewContainer topActivityContainer = FlutterContainerManager.instance().getTopActivityContainer();
        if (Build.VERSION.SDK_INT != 29 || topActivityContainer == null || topActivityContainer == this || topActivityContainer.isOpaque() || !topActivityContainer.isPausing()) {
            this.stage = LifecycleStage.ON_PAUSE;
            FlutterBoost.instance().getPlugin().onContainerDisappeared(this);
            setIsFlutterUiDisplayed(false);
            ActivityInfo.endPauseActivity(getClass().getName());
            return;
        }
        Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        FlutterBoostActivity.super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.hookFlutterTextureView(flutterTextureView);
    }

    private void performAttach() {
        if (!this.isAttached) {
            getFlutterEngine().getActivityControlSurface().attachToActivity(getExclusiveAppComponent(), getLifecycle());
            if (this.platformPlugin == null) {
                this.platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel());
            }
            this.flutterView.attachToFlutterEngine(getFlutterEngine());
            this.isAttached = true;
        }
    }

    private void performDetach() {
        if (this.isAttached) {
            getFlutterEngine().getActivityControlSurface().detachFromActivity();
            releasePlatformChannel();
            this.flutterView.detachFromFlutterEngine();
            this.isAttached = false;
        }
    }

    private void releasePlatformChannel() {
        PlatformPlugin platformPlugin2 = this.platformPlugin;
        if (platformPlugin2 != null) {
            platformPlugin2.destroy();
            this.platformPlugin = null;
        }
    }

    private void setIsFlutterUiDisplayed(boolean z) {
        try {
            FlutterRenderer renderer = getFlutterEngine().getRenderer();
            Field declaredField = FlutterRenderer.class.getDeclaredField("isDisplayingFlutterUi");
            declaredField.setAccessible(true);
            declaredField.setBoolean(renderer, false);
        } catch (Exception e) {
            Log.e(TAG, "You *should* keep fields in io.flutter.embedding.engine.renderer.FlutterRenderer.");
            e.printStackTrace();
        }
    }

    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.stage = LifecycleStage.ON_DESTROY;
        detachFromEngineIfNeeded();
        this.textureHooker.onFlutterTextureViewRelease();
        getFlutterEngine();
        FlutterBoostActivity.super.onDestroy();
        FlutterBoost.instance().getPlugin().onContainerDestroyed(this);
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION)) {
            return getIntent().getBooleanExtra(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION, false);
        }
        return true;
    }

    public void onBackPressed() {
        FlutterBoost.instance().getPlugin().onBackPressed();
    }

    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    public void finishContainer(Map<String, Object> map) {
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY, new HashMap(map));
            setResult(-1, intent);
        }
        finish();
    }

    public String getUrl() {
        if (getIntent().hasExtra("url")) {
            return getIntent().getStringExtra("url");
        }
        Log.e(TAG, "Oops! The activity url are *MISSED*! You should override the |getUrl|, or set url via |CachedEngineIntentBuilder.url|.");
        return null;
    }

    public Map<String, Object> getUrlParams() {
        return (HashMap) getIntent().getSerializableExtra(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM);
    }

    public String getUniqueId() {
        if (!getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID)) {
            return this.who;
        }
        return getIntent().getStringExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID);
    }

    public boolean isOpaque() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    public boolean isPausing() {
        return (this.stage == LifecycleStage.ON_PAUSE || this.stage == LifecycleStage.ON_STOP) && !isFinishing();
    }

    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterBoostActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();
        private boolean destroyEngineWithActivity = false;
        private HashMap<String, Object> params;
        private String uniqueId;
        private String url;

        public CachedEngineIntentBuilder(Class<? extends FlutterBoostActivity> cls) {
            this.activityClass = cls;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z) {
            this.destroyEngineWithActivity = z;
            return this;
        }

        public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public CachedEngineIntentBuilder url(String str) {
            this.url = str;
            return this;
        }

        public CachedEngineIntentBuilder urlParams(Map<String, Object> map) {
            this.params = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }

        public CachedEngineIntentBuilder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public Intent build(Context context) {
            Intent putExtra = new Intent(context, this.activityClass).putExtra(FlutterActivityLaunchConfigs.EXTRA_CACHED_ENGINE_ID, FlutterBoost.ENGINE_ID).putExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, this.destroyEngineWithActivity).putExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE, this.backgroundMode).putExtra("url", this.url).putExtra(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM, this.params);
            String str = this.uniqueId;
            if (str == null) {
                str = FlutterBoostUtils.createUniqueId(this.url);
            }
            return putExtra.putExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, str);
        }
    }
}
