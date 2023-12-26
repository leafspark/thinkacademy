package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.RestorationChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SpellCheckChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterEngine {
    private static final String TAG = "FlutterEngine";
    private final AccessibilityChannel accessibilityChannel;
    private final DartExecutor dartExecutor;
    private final DeferredComponentChannel deferredComponentChannel;
    private final EngineLifecycleListener engineLifecycleListener;
    /* access modifiers changed from: private */
    public final Set<EngineLifecycleListener> engineLifecycleListeners;
    private final FlutterJNI flutterJNI;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private final LocalizationPlugin localizationPlugin;
    private final MouseCursorChannel mouseCursorChannel;
    private final NavigationChannel navigationChannel;
    private final PlatformChannel platformChannel;
    /* access modifiers changed from: private */
    public final PlatformViewsController platformViewsController;
    private final FlutterEngineConnectionRegistry pluginRegistry;
    private final FlutterRenderer renderer;
    /* access modifiers changed from: private */
    public final RestorationChannel restorationChannel;
    private final SettingsChannel settingsChannel;
    private final SpellCheckChannel spellCheckChannel;
    private final SystemChannel systemChannel;
    private final TextInputChannel textInputChannel;

    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine(Context context, String[] strArr) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, true);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, z);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, new PlatformViewsController(), strArr, z, z2);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2) {
        this(context, flutterLoader, flutterJNI2, (String[]) null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, PlatformViewsController platformViewsController2, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI2, platformViewsController2, strArr, z, false);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI2, PlatformViewsController platformViewsController2, String[] strArr, boolean z, boolean z2) {
        AssetManager assetManager;
        this.engineLifecycleListeners = new HashSet();
        this.engineLifecycleListener = new EngineLifecycleListener() {
            public void onEngineWillDestroy() {
            }

            public void onPreEngineRestart() {
                Log.v(FlutterEngine.TAG, "onPreEngineRestart()");
                for (EngineLifecycleListener onPreEngineRestart : FlutterEngine.this.engineLifecycleListeners) {
                    onPreEngineRestart.onPreEngineRestart();
                }
                FlutterEngine.this.platformViewsController.onPreEngineRestart();
                FlutterEngine.this.restorationChannel.clearData();
            }
        };
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assetManager = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI2 = flutterJNI2 == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI2;
        this.flutterJNI = flutterJNI2;
        DartExecutor dartExecutor2 = new DartExecutor(flutterJNI2, assetManager);
        this.dartExecutor = dartExecutor2;
        dartExecutor2.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.accessibilityChannel = new AccessibilityChannel(dartExecutor2, flutterJNI2);
        DeferredComponentChannel deferredComponentChannel2 = new DeferredComponentChannel(dartExecutor2);
        this.deferredComponentChannel = deferredComponentChannel2;
        this.lifecycleChannel = new LifecycleChannel(dartExecutor2);
        LocalizationChannel localizationChannel2 = new LocalizationChannel(dartExecutor2);
        this.localizationChannel = localizationChannel2;
        this.mouseCursorChannel = new MouseCursorChannel(dartExecutor2);
        this.navigationChannel = new NavigationChannel(dartExecutor2);
        this.platformChannel = new PlatformChannel(dartExecutor2);
        this.restorationChannel = new RestorationChannel(dartExecutor2, z2);
        this.settingsChannel = new SettingsChannel(dartExecutor2);
        this.spellCheckChannel = new SpellCheckChannel(dartExecutor2);
        this.systemChannel = new SystemChannel(dartExecutor2);
        this.textInputChannel = new TextInputChannel(dartExecutor2);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(deferredComponentChannel2);
        }
        LocalizationPlugin localizationPlugin2 = new LocalizationPlugin(context, localizationChannel2);
        this.localizationPlugin = localizationPlugin2;
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI2.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI2.addEngineLifecycleListener(this.engineLifecycleListener);
        flutterJNI2.setPlatformViewsController(platformViewsController2);
        flutterJNI2.setLocalizationPlugin(localizationPlugin2);
        flutterJNI2.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI2.isAttached()) {
            attachToJni();
        }
        this.renderer = new FlutterRenderer(flutterJNI2);
        this.platformViewsController = platformViewsController2;
        platformViewsController2.onAttachedToJNI();
        this.pluginRegistry = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader);
        localizationPlugin2.sendLocalesToFlutter(context.getResources().getConfiguration());
        if (z && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
    }

    private void attachToJni() {
        Log.v(TAG, "Attaching to JNI.");
        this.flutterJNI.attachToNative();
        if (!isAttachedToJni()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean isAttachedToJni() {
        return this.flutterJNI.isAttached();
    }

    /* access modifiers changed from: package-private */
    public FlutterEngine spawn(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String str, List<String> list, PlatformViewsController platformViewsController2, boolean z, boolean z2) {
        DartExecutor.DartEntrypoint dartEntrypoint2 = dartEntrypoint;
        if (isAttachedToJni()) {
            String str2 = str;
            return new FlutterEngine(context, (FlutterLoader) null, this.flutterJNI.spawn(dartEntrypoint2.dartEntrypointFunctionName, dartEntrypoint2.dartEntrypointLibrary, str, list), platformViewsController2, (String[]) null, z, z2);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public void destroy() {
        Log.v(TAG, "Destroying.");
        for (EngineLifecycleListener onEngineWillDestroy : this.engineLifecycleListeners) {
            onEngineWillDestroy.onEngineWillDestroy();
        }
        this.pluginRegistry.destroy();
        this.platformViewsController.onDetachedFromJNI();
        this.dartExecutor.onDetachedFromJNI();
        this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
        this.flutterJNI.setDeferredComponentManager((DeferredComponentManager) null);
        this.flutterJNI.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.deferredComponentChannel.setDeferredComponentManager((DeferredComponentManager) null);
        }
    }

    public void addEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.add(engineLifecycleListener2);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener2) {
        this.engineLifecycleListeners.remove(engineLifecycleListener2);
    }

    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public FlutterRenderer getRenderer() {
        return this.renderer;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.accessibilityChannel;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.lifecycleChannel;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.localizationChannel;
    }

    public NavigationChannel getNavigationChannel() {
        return this.navigationChannel;
    }

    public PlatformChannel getPlatformChannel() {
        return this.platformChannel;
    }

    public RestorationChannel getRestorationChannel() {
        return this.restorationChannel;
    }

    public SettingsChannel getSettingsChannel() {
        return this.settingsChannel;
    }

    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.deferredComponentChannel;
    }

    public SystemChannel getSystemChannel() {
        return this.systemChannel;
    }

    public MouseCursorChannel getMouseCursorChannel() {
        return this.mouseCursorChannel;
    }

    public TextInputChannel getTextInputChannel() {
        return this.textInputChannel;
    }

    public SpellCheckChannel getSpellCheckChannel() {
        return this.spellCheckChannel;
    }

    public PluginRegistry getPlugins() {
        return this.pluginRegistry;
    }

    public LocalizationPlugin getLocalizationPlugin() {
        return this.localizationPlugin;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.platformViewsController;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.pluginRegistry;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.pluginRegistry;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.pluginRegistry;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.pluginRegistry;
    }
}
