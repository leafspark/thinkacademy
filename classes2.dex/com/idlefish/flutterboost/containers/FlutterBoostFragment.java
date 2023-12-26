package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.Assert;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostUtils;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FlutterBoostFragment extends FlutterFragment implements FlutterViewContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "FlutterBoostFragment";
    private FlutterView flutterView;
    private boolean isAttached = false;
    private boolean isFinishing = false;
    private PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final FlutterTextureHooker textureHooker = new FlutterTextureHooker();
    private final String who = UUID.randomUUID().toString();

    public void detachFromFlutterEngine() {
    }

    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public boolean shouldDispatchAppLifecycleState() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        FlutterBoostFragment.super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
    }

    public void onStart() {
        FlutterBoostFragment.super.onStart();
    }

    public void onDestroy() {
        FlutterBoostFragment.super.onDestroy();
        this.stage = LifecycleStage.ON_DESTROY;
        this.textureHooker.onFlutterTextureViewRelease();
        detachFromEngineIfNeeded();
    }

    public void onAttach(Context context) {
        FlutterBoostFragment.super.onAttach(context);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FlutterBoost.instance().getPlugin().onContainerCreated(this);
        FlutterView onCreateView = FlutterBoostFragment.super.onCreateView(layoutInflater, viewGroup, bundle);
        FlutterView findFlutterView = FlutterBoostUtils.findFlutterView(onCreateView);
        this.flutterView = findFlutterView;
        findFlutterView.detachFromFlutterEngine();
        if (onCreateView != this.flutterView) {
            return onCreateView;
        }
        FrameLayout frameLayout = new FrameLayout(onCreateView.getContext());
        frameLayout.addView(onCreateView);
        return frameLayout;
    }

    public void onHiddenChanged(boolean z) {
        FlutterBoostFragment.super.onHiddenChanged(z);
        if (this.flutterView != null) {
            if (z) {
                didFragmentHide();
            } else {
                didFragmentShow();
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        FlutterBoostFragment.super.setUserVisibleHint(z);
        if (this.flutterView != null) {
            if (z) {
                didFragmentShow();
            } else {
                didFragmentHide();
            }
        }
    }

    public void onResume() {
        FlutterBoostFragment.super.onResume();
        if (Build.VERSION.SDK_INT == 29) {
            FlutterContainerManager instance = FlutterContainerManager.instance();
            FlutterViewContainer topActivityContainer = instance.getTopActivityContainer();
            if (instance.isActiveContainer(this) && topActivityContainer != null && topActivityContainer != getContextActivity() && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        if (!isHidden()) {
            didFragmentShow();
            onUpdateSystemUiOverlays();
        }
    }

    /* access modifiers changed from: protected */
    public void onUpdateSystemUiOverlays() {
        Assert.assertNotNull(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    public void onPause() {
        FlutterViewContainer topActivityContainer;
        FlutterBoostFragment.super.onPause();
        if (Build.VERSION.SDK_INT != 29 || (topActivityContainer = FlutterContainerManager.instance().getTopActivityContainer()) == null || topActivityContainer == getContextActivity() || topActivityContainer.isOpaque() || !topActivityContainer.isPausing()) {
            this.stage = LifecycleStage.ON_PAUSE;
            didFragmentHide();
            return;
        }
        Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
    }

    public void onStop() {
        FlutterBoostFragment.super.onStop();
        this.stage = LifecycleStage.ON_STOP;
    }

    public void onDestroyView() {
        FlutterBoostFragment.super.onDestroyView();
        FlutterBoost.instance().getPlugin().onContainerDestroyed(this);
    }

    public void onDetach() {
        getFlutterEngine();
        FlutterBoostFragment.super.onDetach();
    }

    public void onUserLeaveHint() {
        FlutterBoostFragment.super.onUserLeaveHint();
    }

    public void onBackPressed() {
        FlutterBoost.instance().getPlugin().onBackPressed();
    }

    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION)) {
            return getArguments().getBoolean(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION);
        }
        return true;
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        FlutterBoostFragment.super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.hookFlutterTextureView(flutterTextureView);
    }

    public Activity getContextActivity() {
        return getActivity();
    }

    public void finishContainer(Map<String, Object> map) {
        this.isFinishing = true;
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY, new HashMap(map));
            getActivity().setResult(-1, intent);
        }
        onFinishContainer();
    }

    /* access modifiers changed from: protected */
    public void onFinishContainer() {
        getActivity().finish();
    }

    public String getUrl() {
        if (getArguments().containsKey("url")) {
            return getArguments().getString("url");
        }
        throw new RuntimeException("Oops! The fragment url are *MISSED*! You should override the |getUrl|, or set url via CachedEngineFragmentBuilder.");
    }

    public Map<String, Object> getUrlParams() {
        return (HashMap) getArguments().getSerializable(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM);
    }

    public String getUniqueId() {
        return getArguments().getString(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, this.who);
    }

    public boolean isPausing() {
        return (this.stage == LifecycleStage.ON_PAUSE || this.stage == LifecycleStage.ON_STOP) && !this.isFinishing;
    }

    /* access modifiers changed from: protected */
    public void didFragmentShow() {
        FlutterViewContainer topContainer = FlutterContainerManager.instance().getTopContainer();
        if (!(topContainer == null || topContainer == this)) {
            topContainer.detachFromEngineIfNeeded();
        }
        FlutterBoost.instance().getPlugin().onContainerAppeared(this);
        performAttach();
        this.textureHooker.onFlutterTextureViewRestoreState();
    }

    /* access modifiers changed from: protected */
    public void didFragmentHide() {
        FlutterBoost.instance().getPlugin().onContainerDisappeared(this);
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

    public void detachFromEngineIfNeeded() {
        performDetach();
    }

    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.opaque.name()));
    }

    public boolean isOpaque() {
        return getTransparencyMode() == TransparencyMode.opaque;
    }

    public static class CachedEngineFragmentBuilder {
        private boolean destroyEngineWithFragment;
        private final Class<? extends FlutterBoostFragment> fragmentClass;
        private HashMap<String, Object> params;
        private RenderMode renderMode;
        private boolean shouldAttachEngineToActivity;
        private TransparencyMode transparencyMode;
        private String uniqueId;
        private String url;

        public CachedEngineFragmentBuilder() {
            this(FlutterBoostFragment.class);
        }

        public CachedEngineFragmentBuilder(Class<? extends FlutterBoostFragment> cls) {
            this.destroyEngineWithFragment = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.opaque;
            this.shouldAttachEngineToActivity = true;
            this.url = "/";
            this.fragmentClass = cls;
        }

        public CachedEngineFragmentBuilder url(String str) {
            this.url = str;
            return this;
        }

        public CachedEngineFragmentBuilder urlParams(Map<String, Object> map) {
            this.params = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }

        public CachedEngineFragmentBuilder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean z) {
            this.destroyEngineWithFragment = z;
            return this;
        }

        public CachedEngineFragmentBuilder renderMode(RenderMode renderMode2) {
            this.renderMode = renderMode2;
            return this;
        }

        public CachedEngineFragmentBuilder transparencyMode(TransparencyMode transparencyMode2) {
            this.transparencyMode = transparencyMode2;
            return this;
        }

        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean z) {
            this.shouldAttachEngineToActivity = z;
            return this;
        }

        /* access modifiers changed from: protected */
        public Bundle createArgs() {
            Bundle bundle = new Bundle();
            bundle.putString(FlutterActivityLaunchConfigs.EXTRA_CACHED_ENGINE_ID, FlutterBoost.ENGINE_ID);
            bundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
            RenderMode renderMode2 = this.renderMode;
            if (renderMode2 == null) {
                renderMode2 = RenderMode.surface;
            }
            bundle.putString("flutterview_render_mode", renderMode2.name());
            TransparencyMode transparencyMode2 = this.transparencyMode;
            if (transparencyMode2 == null) {
                transparencyMode2 = TransparencyMode.transparent;
            }
            bundle.putString("flutterview_transparency_mode", transparencyMode2.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
            bundle.putString("url", this.url);
            bundle.putSerializable(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM, this.params);
            String str = this.uniqueId;
            if (str == null) {
                str = FlutterBoostUtils.createUniqueId(this.url);
            }
            bundle.putString(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, str);
            return bundle;
        }

        public <T extends FlutterBoostFragment> T build() {
            try {
                T t = (FlutterBoostFragment) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t != null) {
                    t.setArguments(createArgs());
                    return t;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }
    }
}
