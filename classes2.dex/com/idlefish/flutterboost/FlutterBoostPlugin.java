package com.idlefish.flutterboost;

import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.Messages;
import com.idlefish.flutterboost.containers.FlutterContainerManager;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FlutterBoostPlugin implements FlutterPlugin, Messages.NativeRouterApi, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String APP_LIFECYCLE_CHANGED_KEY = "app_lifecycle_changed_key";
    private static final boolean DEBUG = false;
    private static final int FLUTTER_APP_STATE_PAUSED = 2;
    private static final int FLUTTER_APP_STATE_RESUMED = 0;
    private static final String LIFECYCLE_STATE = "lifecycleState";
    private static final String TAG = "FlutterBoostPlugin";
    private Messages.FlutterRouterApi channel;
    private Messages.StackInfo dartStack;
    private FlutterBoostDelegate delegate;
    private FlutterEngine engine;
    private HashMap<String, LinkedList<EventListener>> listenersTable = new HashMap<>();
    private SparseArray<String> pageNames;
    private int requestCode = ResultCode.KARAOKE_SUCCESS;

    static /* synthetic */ void lambda$onAttachedToActivity$12(String str, Void voidR) {
    }

    static /* synthetic */ void lambda$onBackPressed$4(Void voidR) {
    }

    static /* synthetic */ void lambda$onBackground$7(Void voidR) {
    }

    static /* synthetic */ void lambda$onContainerAppeared$10(Void voidR) {
    }

    static /* synthetic */ void lambda$onContainerDestroyed$11(Void voidR) {
    }

    static /* synthetic */ void lambda$onContainerHide$9(Void voidR) {
    }

    static /* synthetic */ void lambda$onContainerShow$8(Void voidR) {
    }

    static /* synthetic */ void lambda$onForeground$6(Void voidR) {
    }

    static /* synthetic */ void lambda$sendEventToFlutter$1(Void voidR) {
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    public Messages.FlutterRouterApi getChannel() {
        return this.channel;
    }

    public void setDelegate(FlutterBoostDelegate flutterBoostDelegate) {
        this.delegate = flutterBoostDelegate;
    }

    public FlutterBoostDelegate getDelegate() {
        return this.delegate;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Messages.NativeRouterApi.CC.setup(flutterPluginBinding.getBinaryMessenger(), this);
        this.engine = flutterPluginBinding.getFlutterEngine();
        this.channel = new Messages.FlutterRouterApi(flutterPluginBinding.getBinaryMessenger());
        this.pageNames = new SparseArray<>();
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.engine = null;
        this.channel = null;
    }

    public void pushNativeRoute(Messages.CommonParams commonParams) {
        if (this.delegate != null) {
            int i = this.requestCode + 1;
            this.requestCode = i;
            SparseArray<String> sparseArray = this.pageNames;
            if (sparseArray != null) {
                sparseArray.put(i, commonParams.getPageName());
            }
            this.delegate.pushNativeRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).arguments(commonParams.getArguments()).requestCode(this.requestCode).build());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    public void pushFlutterRoute(Messages.CommonParams commonParams) {
        if (this.delegate != null) {
            this.delegate.pushFlutterRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).uniqueId(commonParams.getUniqueId()).opaque(commonParams.getOpaque().booleanValue()).arguments(commonParams.getArguments()).build());
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    public void popRoute(Messages.CommonParams commonParams, Messages.Result<Void> result) {
        if (this.delegate != null) {
            if (!this.delegate.popRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).uniqueId(commonParams.getUniqueId()).arguments(commonParams.getArguments()).build())) {
                String uniqueId = commonParams.getUniqueId();
                if (uniqueId != null) {
                    FlutterViewContainer findContainerById = FlutterContainerManager.instance().findContainerById(uniqueId);
                    if (findContainerById != null) {
                        findContainerById.finishContainer(commonParams.getArguments());
                    }
                    result.success(null);
                    return;
                }
                throw new RuntimeException("Oops!! The unique id is null!");
            }
            result.success(null);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
    }

    public Messages.StackInfo getStackFromHost() {
        Messages.StackInfo stackInfo = this.dartStack;
        return stackInfo == null ? Messages.StackInfo.fromMap(new HashMap()) : stackInfo;
    }

    public void saveStackToHost(Messages.StackInfo stackInfo) {
        this.dartStack = stackInfo;
    }

    public void sendEventToNative(Messages.CommonParams commonParams) {
        String key = commonParams.getKey();
        Map arguments = commonParams.getArguments();
        if (arguments == null) {
            arguments = new HashMap();
        }
        List<EventListener> list = this.listenersTable.get(key);
        if (list != null) {
            for (EventListener onEvent : list) {
                onEvent.onEvent(key, arguments);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ListenerRemover addEventListener(String str, EventListener eventListener) {
        LinkedList linkedList = this.listenersTable.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.listenersTable.put(str, linkedList);
        }
        linkedList.add(eventListener);
        return new FlutterBoostPlugin$$ExternalSyntheticLambda0(linkedList, eventListener);
    }

    /* access modifiers changed from: package-private */
    public void sendEventToFlutter(String str, Map<String, Object> map) {
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setKey(str);
        commonParams.setArguments(map);
        getChannel().sendEventToFlutter(commonParams, FlutterBoostPlugin$$ExternalSyntheticLambda3.INSTANCE);
    }

    /* access modifiers changed from: package-private */
    public void changeFlutterAppLifecycle(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LIFECYCLE_STATE, Integer.valueOf(i));
        sendEventToFlutter(APP_LIFECYCLE_CHANGED_KEY, hashMap);
    }

    private void checkEngineState() {
        FlutterEngine flutterEngine = this.engine;
        if (flutterEngine == null || !flutterEngine.getDartExecutor().isExecutingDart()) {
            throw new RuntimeException("The engine is not ready for use. The message may be drop silently by the engine. You should check 'DartExecutor.isExecutingDart()' first!");
        }
    }

    public void pushRoute(String str, String str2, Map<String, Object> map, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            commonParams.setPageName(str2);
            commonParams.setArguments(map);
            this.channel.pushRoute(commonParams, new FlutterBoostPlugin$$ExternalSyntheticLambda6(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    static /* synthetic */ void lambda$pushRoute$2(Messages.FlutterRouterApi.Reply reply, Void voidR) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void popRoute(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            this.channel.popRoute(commonParams, new FlutterBoostPlugin$$ExternalSyntheticLambda5(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    static /* synthetic */ void lambda$popRoute$3(Messages.FlutterRouterApi.Reply reply, Void voidR) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void onBackPressed() {
        if (this.channel != null) {
            checkEngineState();
            this.channel.onBackPressed(FlutterBoostPlugin$$ExternalSyntheticLambda9.INSTANCE);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void removeRoute(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            this.channel.removeRoute(commonParams, new FlutterBoostPlugin$$ExternalSyntheticLambda7(reply));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    static /* synthetic */ void lambda$removeRoute$5(Messages.FlutterRouterApi.Reply reply, Void voidR) {
        if (reply != null) {
            reply.reply(null);
        }
    }

    public void onForeground() {
        if (this.channel != null) {
            checkEngineState();
            this.channel.onForeground(new Messages.CommonParams(), FlutterBoostPlugin$$ExternalSyntheticLambda2.INSTANCE);
            changeFlutterAppLifecycle(0);
            String str = TAG;
            Log.v(str, "## onForeground: " + this.channel);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void onBackground() {
        if (this.channel != null) {
            checkEngineState();
            this.channel.onBackground(new Messages.CommonParams(), FlutterBoostPlugin$$ExternalSyntheticLambda10.INSTANCE);
            changeFlutterAppLifecycle(2);
            String str = TAG;
            Log.v(str, "## onBackground: " + this.channel);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void onContainerShow(String str) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            this.channel.onContainerShow(commonParams, FlutterBoostPlugin$$ExternalSyntheticLambda1.INSTANCE);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void onContainerHide(String str) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            this.channel.onContainerHide(commonParams, FlutterBoostPlugin$$ExternalSyntheticLambda13.INSTANCE);
            String str2 = TAG;
            Log.v(str2, "## onContainerHide: " + str);
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    public void onContainerCreated(FlutterViewContainer flutterViewContainer) {
        FlutterContainerManager.instance().addContainer(flutterViewContainer.getUniqueId(), flutterViewContainer);
        if (FlutterContainerManager.instance().getContainerSize() == 1) {
            changeFlutterAppLifecycle(0);
        }
    }

    public void onContainerAppeared(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        FlutterContainerManager.instance().activateContainer(uniqueId, flutterViewContainer);
        pushRoute(uniqueId, flutterViewContainer.getUrl(), flutterViewContainer.getUrlParams(), FlutterBoostPlugin$$ExternalSyntheticLambda11.INSTANCE);
        onContainerShow(uniqueId);
    }

    public void onContainerDisappeared(FlutterViewContainer flutterViewContainer) {
        onContainerHide(flutterViewContainer.getUniqueId());
    }

    public void onContainerDestroyed(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        removeRoute(uniqueId, FlutterBoostPlugin$$ExternalSyntheticLambda12.INSTANCE);
        FlutterContainerManager.instance().removeContainer(uniqueId);
        if (FlutterContainerManager.instance().getContainerSize() == 0) {
            changeFlutterAppLifecycle(2);
        }
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        activityPluginBinding.addActivityResultListener(new FlutterBoostPlugin$$ExternalSyntheticLambda4(this));
    }

    public /* synthetic */ boolean lambda$onAttachedToActivity$13$FlutterBoostPlugin(int i, int i2, Intent intent) {
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            String str = this.pageNames.get(i);
            this.pageNames.remove(i);
            if (str == null) {
                return true;
            }
            commonParams.setPageName(str);
            if (intent != null) {
                commonParams.setArguments(FlutterBoostUtils.bundleToMap(intent.getExtras()));
            }
            this.channel.onNativeResult(commonParams, new FlutterBoostPlugin$$ExternalSyntheticLambda8(str));
            return true;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }
}
