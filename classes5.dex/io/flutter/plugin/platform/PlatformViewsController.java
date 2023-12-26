package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PlatformViewsController implements PlatformViewsAccessibilityDelegate {
    private static final String TAG = "PlatformViewsController";
    /* access modifiers changed from: private */
    public static Class[] VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY = {SurfaceView.class};
    /* access modifiers changed from: private */
    public final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    /* access modifiers changed from: private */
    public AndroidTouchProcessor androidTouchProcessor;
    private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsChannel.PlatformViewsHandler() {
        public void createForPlatformViewLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(19);
            ensureValidRequest(platformViewCreationRequest);
            configureForHybridComposition(createPlatformView(platformViewCreationRequest, false), platformViewCreationRequest);
        }

        public long createForTextureLayer(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidRequest(platformViewCreationRequest);
            int i = platformViewCreationRequest.viewId;
            if (PlatformViewsController.this.viewWrappers.get(i) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i);
            } else if (PlatformViewsController.this.textureRegistry == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i);
            } else if (PlatformViewsController.this.flutterView != null) {
                boolean z = true;
                PlatformView createPlatformView = createPlatformView(platformViewCreationRequest, true);
                View view = createPlatformView.getView();
                if (view.getParent() == null) {
                    if (Build.VERSION.SDK_INT < 23 || ViewUtils.hasChildViewOfType(view, PlatformViewsController.VIEW_TYPES_REQUIRE_VIRTUAL_DISPLAY)) {
                        z = false;
                    }
                    if (!z) {
                        if (platformViewCreationRequest.displayMode == PlatformViewsChannel.PlatformViewCreationRequest.RequestedDisplayMode.TEXTURE_WITH_HYBRID_FALLBACK) {
                            configureForHybridComposition(createPlatformView, platformViewCreationRequest);
                            return -2;
                        } else if (!PlatformViewsController.this.usesSoftwareRendering) {
                            return configureForVirtualDisplay(createPlatformView, platformViewCreationRequest);
                        }
                    }
                    return configureForTextureLayerComposition(createPlatformView, platformViewCreationRequest);
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            } else {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i);
            }
        }

        public void dispose(int i) {
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Disposing unknown platform view with id: " + i);
                return;
            }
            PlatformViewsController.this.platformViews.remove(i);
            try {
                platformView.dispose();
            } catch (RuntimeException e) {
                Log.e(PlatformViewsController.TAG, "Disposing platform view threw an exception", e);
            }
            if (PlatformViewsController.this.usesVirtualDisplay(i)) {
                View view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i)).getView();
                if (view != null) {
                    PlatformViewsController.this.contextToEmbeddedView.remove(view.getContext());
                }
                PlatformViewsController.this.vdControllers.remove(Integer.valueOf(i));
                return;
            }
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
            if (platformViewWrapper != null) {
                platformViewWrapper.removeAllViews();
                platformViewWrapper.release();
                platformViewWrapper.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup = (ViewGroup) platformViewWrapper.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(platformViewWrapper);
                }
                PlatformViewsController.this.viewWrappers.remove(i);
                return;
            }
            FlutterMutatorView flutterMutatorView = (FlutterMutatorView) PlatformViewsController.this.platformViewParent.get(i);
            if (flutterMutatorView != null) {
                flutterMutatorView.removeAllViews();
                flutterMutatorView.unsetOnDescendantFocusChangeListener();
                ViewGroup viewGroup2 = (ViewGroup) flutterMutatorView.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(flutterMutatorView);
                }
                PlatformViewsController.this.platformViewParent.remove(i);
            }
        }

        public void offset(int i, double d, double d2) {
            if (!PlatformViewsController.this.usesVirtualDisplay(i)) {
                PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
                if (platformViewWrapper == null) {
                    Log.e(PlatformViewsController.TAG, "Setting offset for unknown platform view with id: " + i);
                    return;
                }
                int access$700 = PlatformViewsController.this.toPhysicalPixels(d);
                int access$7002 = PlatformViewsController.this.toPhysicalPixels(d2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) platformViewWrapper.getLayoutParams();
                layoutParams.topMargin = access$700;
                layoutParams.leftMargin = access$7002;
                platformViewWrapper.setLayoutParams(layoutParams);
            }
        }

        public void resize(PlatformViewsChannel.PlatformViewResizeRequest platformViewResizeRequest, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            int access$700 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalWidth);
            int access$7002 = PlatformViewsController.this.toPhysicalPixels(platformViewResizeRequest.newLogicalHeight);
            int i = platformViewResizeRequest.viewId;
            if (PlatformViewsController.this.usesVirtualDisplay(i)) {
                float access$800 = PlatformViewsController.this.getDisplayDensity();
                VirtualDisplayController virtualDisplayController = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i));
                PlatformViewsController.this.lockInputConnection(virtualDisplayController);
                virtualDisplayController.resize(access$700, access$7002, new PlatformViewsController$1$$ExternalSyntheticLambda2(this, virtualDisplayController, access$800, platformViewBufferResized));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            PlatformViewWrapper platformViewWrapper = (PlatformViewWrapper) PlatformViewsController.this.viewWrappers.get(i);
            if (platformView == null || platformViewWrapper == null) {
                Log.e(PlatformViewsController.TAG, "Resizing unknown platform view with id: " + i);
                return;
            }
            if (access$700 > platformViewWrapper.getBufferWidth() || access$7002 > platformViewWrapper.getBufferHeight()) {
                platformViewWrapper.setBufferSize(access$700, access$7002);
            }
            ViewGroup.LayoutParams layoutParams = platformViewWrapper.getLayoutParams();
            layoutParams.width = access$700;
            layoutParams.height = access$7002;
            platformViewWrapper.setLayoutParams(layoutParams);
            View view = platformView.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = access$700;
                layoutParams2.height = access$7002;
                view.setLayoutParams(layoutParams2);
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels((double) platformViewWrapper.getBufferWidth()), PlatformViewsController.this.toLogicalPixels((double) platformViewWrapper.getBufferHeight())));
        }

        public /* synthetic */ void lambda$resize$0$PlatformViewsController$1(VirtualDisplayController virtualDisplayController, float f, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
            PlatformViewsController.this.unlockInputConnection(virtualDisplayController);
            if (PlatformViewsController.this.context != null) {
                f = PlatformViewsController.this.getDisplayDensity();
            }
            platformViewBufferResized.run(new PlatformViewsChannel.PlatformViewBufferSize(PlatformViewsController.this.toLogicalPixels((double) virtualDisplayController.getBufferWidth(), f), PlatformViewsController.this.toLogicalPixels((double) virtualDisplayController.getBufferHeight(), f)));
        }

        public void onTouch(PlatformViewsChannel.PlatformViewTouch platformViewTouch) {
            int i = platformViewTouch.viewId;
            float f = PlatformViewsController.this.context.getResources().getDisplayMetrics().density;
            if (PlatformViewsController.this.usesVirtualDisplay(i)) {
                PlatformViewsController.this.vdControllers.get(Integer.valueOf(i)).dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f, platformViewTouch, true));
                return;
            }
            PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
            if (platformView == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to an unknown view with id: " + i);
                return;
            }
            View view = platformView.getView();
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Sending touch to a null view with id: " + i);
                return;
            }
            view.dispatchTouchEvent(PlatformViewsController.this.toMotionEvent(f, platformViewTouch, false));
        }

        public void setDirection(int i, int i2) {
            View view;
            if (PlatformViewsController.validateDirection(i2)) {
                if (PlatformViewsController.this.usesVirtualDisplay(i)) {
                    view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i)).getView();
                } else {
                    PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
                    if (platformView == null) {
                        Log.e(PlatformViewsController.TAG, "Setting direction to an unknown view with id: " + i);
                        return;
                    }
                    view = platformView.getView();
                }
                if (view == null) {
                    Log.e(PlatformViewsController.TAG, "Setting direction to a null view with id: " + i);
                    return;
                }
                view.setLayoutDirection(i2);
                return;
            }
            throw new IllegalStateException("Trying to set unknown direction value: " + i2 + "(view id: " + i + ")");
        }

        public void clearFocus(int i) {
            View view;
            if (PlatformViewsController.this.usesVirtualDisplay(i)) {
                view = PlatformViewsController.this.vdControllers.get(Integer.valueOf(i)).getView();
            } else {
                PlatformView platformView = (PlatformView) PlatformViewsController.this.platformViews.get(i);
                if (platformView == null) {
                    Log.e(PlatformViewsController.TAG, "Clearing focus on an unknown view with id: " + i);
                    return;
                }
                view = platformView.getView();
            }
            if (view == null) {
                Log.e(PlatformViewsController.TAG, "Clearing focus on a null view with id: " + i);
                return;
            }
            view.clearFocus();
        }

        private void ensureValidAndroidVersion(int i) {
            if (Build.VERSION.SDK_INT < i) {
                throw new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + i);
            }
        }

        private void ensureValidRequest(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            if (!PlatformViewsController.validateDirection(platformViewCreationRequest.direction)) {
                throw new IllegalStateException("Trying to create a view with unknown direction value: " + platformViewCreationRequest.direction + "(view id: " + platformViewCreationRequest.viewId + ")");
            }
        }

        private PlatformView createPlatformView(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, boolean z) {
            PlatformViewFactory factory = PlatformViewsController.this.registry.getFactory(platformViewCreationRequest.viewType);
            if (factory != null) {
                Object obj = null;
                if (platformViewCreationRequest.params != null) {
                    obj = factory.getCreateArgsCodec().decodeMessage(platformViewCreationRequest.params);
                }
                PlatformView create = factory.create(z ? new MutableContextWrapper(PlatformViewsController.this.context) : PlatformViewsController.this.context, platformViewCreationRequest.viewId, obj);
                View view = create.getView();
                if (view != null) {
                    view.setLayoutDirection(platformViewCreationRequest.direction);
                    PlatformViewsController.this.platformViews.put(platformViewCreationRequest.viewId, create);
                    return create;
                }
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + platformViewCreationRequest.viewType);
        }

        private void configureForHybridComposition(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            Log.i(PlatformViewsController.TAG, "Using hybrid composition for platform view: " + platformViewCreationRequest.viewId);
        }

        private long configureForVirtualDisplay(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            ensureValidAndroidVersion(20);
            Log.i(PlatformViewsController.TAG, "Hosting view in a virtual display for platform view: " + platformViewCreationRequest.viewId);
            TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.textureRegistry.createSurfaceTexture();
            PlatformView platformView2 = platformView;
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = createSurfaceTexture;
            VirtualDisplayController create = VirtualDisplayController.create(PlatformViewsController.this.context, PlatformViewsController.this.accessibilityEventsDelegate, platformView2, surfaceTextureEntry, PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalWidth), PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalHeight), platformViewCreationRequest.viewId, (Object) null, new PlatformViewsController$1$$ExternalSyntheticLambda1(this, platformViewCreationRequest));
            if (create != null) {
                if (PlatformViewsController.this.flutterView != null) {
                    create.onFlutterViewAttached(PlatformViewsController.this.flutterView);
                }
                PlatformViewsController.this.vdControllers.put(Integer.valueOf(platformViewCreationRequest.viewId), create);
                View view = platformView.getView();
                PlatformViewsController.this.contextToEmbeddedView.put(view.getContext(), view);
                return createSurfaceTexture.id();
            }
            throw new IllegalStateException("Failed creating virtual display for a " + platformViewCreationRequest.viewType + " with id: " + platformViewCreationRequest.viewId);
        }

        public /* synthetic */ void lambda$configureForVirtualDisplay$1$PlatformViewsController$1(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            }
        }

        private long configureForTextureLayerComposition(PlatformView platformView, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
            long j;
            PlatformViewWrapper platformViewWrapper;
            ensureValidAndroidVersion(23);
            Log.i(PlatformViewsController.TAG, "Hosting view in view hierarchy for platform view: " + platformViewCreationRequest.viewId);
            int access$700 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalWidth);
            int access$7002 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalHeight);
            if (PlatformViewsController.this.usesSoftwareRendering) {
                platformViewWrapper = new PlatformViewWrapper(PlatformViewsController.this.context);
                j = -1;
            } else {
                TextureRegistry.SurfaceTextureEntry createSurfaceTexture = PlatformViewsController.this.textureRegistry.createSurfaceTexture();
                PlatformViewWrapper platformViewWrapper2 = new PlatformViewWrapper(PlatformViewsController.this.context, createSurfaceTexture);
                long id = createSurfaceTexture.id();
                platformViewWrapper = platformViewWrapper2;
                j = id;
            }
            platformViewWrapper.setTouchProcessor(PlatformViewsController.this.androidTouchProcessor);
            platformViewWrapper.setBufferSize(access$700, access$7002);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(access$700, access$7002);
            int access$7003 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalTop);
            int access$7004 = PlatformViewsController.this.toPhysicalPixels(platformViewCreationRequest.logicalLeft);
            layoutParams.topMargin = access$7003;
            layoutParams.leftMargin = access$7004;
            platformViewWrapper.setLayoutParams(layoutParams);
            View view = platformView.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(access$700, access$7002));
            view.setImportantForAccessibility(4);
            platformViewWrapper.addView(view);
            platformViewWrapper.setOnDescendantFocusChangeListener(new PlatformViewsController$1$$ExternalSyntheticLambda0(this, platformViewCreationRequest));
            PlatformViewsController.this.flutterView.addView(platformViewWrapper);
            PlatformViewsController.this.viewWrappers.append(platformViewCreationRequest.viewId, platformViewWrapper);
            return j;
        }

        public /* synthetic */ void lambda$configureForTextureLayerComposition$2$PlatformViewsController$1(PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest, View view, boolean z) {
            if (z) {
                PlatformViewsController.this.platformViewsChannel.invokeViewFocused(platformViewCreationRequest.viewId);
            } else if (PlatformViewsController.this.textInputPlugin != null) {
                PlatformViewsController.this.textInputPlugin.clearPlatformViewClient(platformViewCreationRequest.viewId);
            }
        }

        public void synchronizeToNativeViewHierarchy(boolean z) {
            boolean unused = PlatformViewsController.this.synchronizeToNativeViewHierarchy = z;
        }
    };
    /* access modifiers changed from: private */
    public Context context;
    final HashMap<Context, View> contextToEmbeddedView = new HashMap<>();
    private final HashSet<Integer> currentFrameUsedOverlayLayerIds = new HashSet<>();
    private final HashSet<Integer> currentFrameUsedPlatformViewIds = new HashSet<>();
    /* access modifiers changed from: private */
    public FlutterView flutterView;
    private boolean flutterViewConvertedToImageView = false;
    private final MotionEventTracker motionEventTracker = MotionEventTracker.getInstance();
    private int nextOverlayLayerId = 0;
    private final SparseArray<PlatformOverlayView> overlayLayerViews = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<FlutterMutatorView> platformViewParent = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<PlatformView> platformViews = new SparseArray<>();
    /* access modifiers changed from: private */
    public PlatformViewsChannel platformViewsChannel;
    /* access modifiers changed from: private */
    public final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
    /* access modifiers changed from: private */
    public boolean synchronizeToNativeViewHierarchy = true;
    /* access modifiers changed from: private */
    public TextInputPlugin textInputPlugin;
    /* access modifiers changed from: private */
    public TextureRegistry textureRegistry;
    /* access modifiers changed from: private */
    public boolean usesSoftwareRendering = false;
    final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap<>();
    /* access modifiers changed from: private */
    public final SparseArray<PlatformViewWrapper> viewWrappers = new SparseArray<>();

    /* access modifiers changed from: private */
    public static boolean validateDirection(int i) {
        return i == 0 || i == 1;
    }

    public void onAttachedToJNI() {
    }

    public MotionEvent toMotionEvent(float f, PlatformViewsChannel.PlatformViewTouch platformViewTouch, boolean z) {
        PlatformViewsChannel.PlatformViewTouch platformViewTouch2 = platformViewTouch;
        MotionEvent pop = this.motionEventTracker.pop(MotionEventTracker.MotionEventId.from(platformViewTouch2.motionEventId));
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) parsePointerPropertiesList(platformViewTouch2.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[platformViewTouch2.pointerCount]);
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) parsePointerCoordsList(platformViewTouch2.rawPointerCoords, f).toArray(new MotionEvent.PointerCoords[platformViewTouch2.pointerCount]);
        if (!z && pop != null) {
            return MotionEvent.obtain(pop.getDownTime(), pop.getEventTime(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, pop.getMetaState(), pop.getButtonState(), pop.getXPrecision(), pop.getYPrecision(), pop.getDeviceId(), pop.getEdgeFlags(), pop.getSource(), pop.getFlags());
        }
        return MotionEvent.obtain(platformViewTouch2.downTime.longValue(), platformViewTouch2.eventTime.longValue(), platformViewTouch2.action, platformViewTouch2.pointerCount, pointerPropertiesArr, pointerCoordsArr, platformViewTouch2.metaState, platformViewTouch2.buttonState, platformViewTouch2.xPrecision, platformViewTouch2.yPrecision, platformViewTouch2.deviceId, platformViewTouch2.edgeFlags, platformViewTouch2.source, platformViewTouch2.flags);
    }

    public void attach(Context context2, TextureRegistry textureRegistry2, DartExecutor dartExecutor) {
        if (this.context == null) {
            this.context = context2;
            this.textureRegistry = textureRegistry2;
            PlatformViewsChannel platformViewsChannel2 = new PlatformViewsChannel(dartExecutor);
            this.platformViewsChannel = platformViewsChannel2;
            platformViewsChannel2.setPlatformViewsHandler(this.channelHandler);
            return;
        }
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }

    public void setSoftwareRendering(boolean z) {
        this.usesSoftwareRendering = z;
    }

    public void detach() {
        PlatformViewsChannel platformViewsChannel2 = this.platformViewsChannel;
        if (platformViewsChannel2 != null) {
            platformViewsChannel2.setPlatformViewsHandler((PlatformViewsChannel.PlatformViewsHandler) null);
        }
        destroyOverlaySurfaces();
        this.platformViewsChannel = null;
        this.context = null;
        this.textureRegistry = null;
    }

    public void attachToView(FlutterView flutterView2) {
        this.flutterView = flutterView2;
        for (int i = 0; i < this.viewWrappers.size(); i++) {
            this.flutterView.addView(this.viewWrappers.valueAt(i));
        }
        for (int i2 = 0; i2 < this.platformViewParent.size(); i2++) {
            this.flutterView.addView(this.platformViewParent.valueAt(i2));
        }
        for (int i3 = 0; i3 < this.platformViews.size(); i3++) {
            this.platformViews.valueAt(i3).onFlutterViewAttached(this.flutterView);
        }
    }

    public void detachFromView() {
        for (int i = 0; i < this.viewWrappers.size(); i++) {
            this.flutterView.removeView(this.viewWrappers.valueAt(i));
        }
        for (int i2 = 0; i2 < this.platformViewParent.size(); i2++) {
            this.flutterView.removeView(this.platformViewParent.valueAt(i2));
        }
        destroyOverlaySurfaces();
        removeOverlaySurfaces();
        this.flutterView = null;
        this.flutterViewConvertedToImageView = false;
        for (int i3 = 0; i3 < this.platformViews.size(); i3++) {
            this.platformViews.valueAt(i3).onFlutterViewDetached();
        }
    }

    public void attachAccessibilityBridge(AccessibilityBridge accessibilityBridge) {
        this.accessibilityEventsDelegate.setAccessibilityBridge(accessibilityBridge);
    }

    public void detachAccessibilityBridge() {
        this.accessibilityEventsDelegate.setAccessibilityBridge((AccessibilityBridge) null);
    }

    public void attachTextInputPlugin(TextInputPlugin textInputPlugin2) {
        this.textInputPlugin = textInputPlugin2;
    }

    public void detachTextInputPlugin() {
        this.textInputPlugin = null;
    }

    public boolean checkInputConnectionProxy(View view) {
        if (view == null || !this.contextToEmbeddedView.containsKey(view.getContext())) {
            return false;
        }
        View view2 = this.contextToEmbeddedView.get(view.getContext());
        if (view2 == view) {
            return true;
        }
        return view2.checkInputConnectionProxy(view);
    }

    public PlatformViewRegistry getRegistry() {
        return this.registry;
    }

    public void onDetachedFromJNI() {
        diposeAllViews();
    }

    public void onPreEngineRestart() {
        diposeAllViews();
    }

    public View getPlatformViewById(int i) {
        if (usesVirtualDisplay(i)) {
            return this.vdControllers.get(Integer.valueOf(i)).getView();
        }
        PlatformView platformView = this.platformViews.get(i);
        if (platformView == null) {
            return null;
        }
        return platformView.getView();
    }

    public boolean usesVirtualDisplay(int i) {
        return this.vdControllers.containsKey(Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    public void lockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.lockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: private */
    public void unlockInputConnection(VirtualDisplayController virtualDisplayController) {
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.unlockPlatformViewInputConnection();
            virtualDisplayController.onInputConnectionUnlocked();
        }
    }

    private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerProperties : (List) obj) {
            arrayList.add(parsePointerProperties(parsePointerProperties));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties parsePointerProperties(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object obj, float f) {
        ArrayList arrayList = new ArrayList();
        for (Object parsePointerCoords : (List) obj) {
            arrayList.add(parsePointerCoords(parsePointerCoords, f));
        }
        return arrayList;
    }

    private static MotionEvent.PointerCoords parsePointerCoords(Object obj, float f) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        pointerCoords.toolMajor = ((float) ((Double) list.get(3)).doubleValue()) * f;
        pointerCoords.toolMinor = ((float) ((Double) list.get(4)).doubleValue()) * f;
        pointerCoords.touchMajor = ((float) ((Double) list.get(5)).doubleValue()) * f;
        pointerCoords.touchMinor = ((float) ((Double) list.get(6)).doubleValue()) * f;
        pointerCoords.x = ((float) ((Double) list.get(7)).doubleValue()) * f;
        pointerCoords.y = ((float) ((Double) list.get(8)).doubleValue()) * f;
        return pointerCoords;
    }

    /* access modifiers changed from: private */
    public float getDisplayDensity() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    public int toPhysicalPixels(double d) {
        return (int) Math.round(d * ((double) getDisplayDensity()));
    }

    /* access modifiers changed from: private */
    public int toLogicalPixels(double d, float f) {
        return (int) Math.round(d / ((double) f));
    }

    /* access modifiers changed from: private */
    public int toLogicalPixels(double d) {
        return toLogicalPixels(d, getDisplayDensity());
    }

    private void diposeAllViews() {
        while (this.platformViews.size() > 0) {
            this.channelHandler.dispose(this.platformViews.keyAt(0));
        }
    }

    private void initializeRootImageViewIfNeeded() {
        if (this.synchronizeToNativeViewHierarchy && !this.flutterViewConvertedToImageView) {
            this.flutterView.convertToImageView();
            this.flutterViewConvertedToImageView = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void initializePlatformViewIfNeeded(int i) {
        PlatformView platformView = this.platformViews.get(i);
        if (platformView == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        } else if (this.platformViewParent.get(i) == null) {
            View view = platformView.getView();
            if (view == null) {
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            } else if (view.getParent() == null) {
                Context context2 = this.context;
                FlutterMutatorView flutterMutatorView = new FlutterMutatorView(context2, context2.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
                flutterMutatorView.setOnDescendantFocusChangeListener(new PlatformViewsController$$ExternalSyntheticLambda0(this, i));
                this.platformViewParent.put(i, flutterMutatorView);
                view.setImportantForAccessibility(4);
                flutterMutatorView.addView(view);
                this.flutterView.addView(flutterMutatorView);
            } else {
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    public /* synthetic */ void lambda$initializePlatformViewIfNeeded$0$PlatformViewsController(int i, View view, boolean z) {
        if (z) {
            this.platformViewsChannel.invokeViewFocused(i);
            return;
        }
        TextInputPlugin textInputPlugin2 = this.textInputPlugin;
        if (textInputPlugin2 != null) {
            textInputPlugin2.clearPlatformViewClient(i);
        }
    }

    public void attachToFlutterRenderer(FlutterRenderer flutterRenderer) {
        this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer, true);
    }

    public void onDisplayPlatformView(int i, int i2, int i3, int i4, int i5, int i6, int i7, FlutterMutatorsStack flutterMutatorsStack) {
        initializeRootImageViewIfNeeded();
        initializePlatformViewIfNeeded(i);
        FlutterMutatorView flutterMutatorView = this.platformViewParent.get(i);
        flutterMutatorView.readyToDisplay(flutterMutatorsStack, i2, i3, i4, i5);
        flutterMutatorView.setVisibility(0);
        flutterMutatorView.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i7);
        View view = this.platformViews.get(i).getView();
        if (view != null) {
            view.setLayoutParams(layoutParams);
            view.bringToFront();
        }
        this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(i));
    }

    public void onDisplayOverlaySurface(int i, int i2, int i3, int i4, int i5) {
        if (this.overlayLayerViews.get(i) != null) {
            initializeRootImageViewIfNeeded();
            PlatformOverlayView platformOverlayView = this.overlayLayerViews.get(i);
            if (platformOverlayView.getParent() == null) {
                this.flutterView.addView(platformOverlayView);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
            layoutParams.leftMargin = i2;
            layoutParams.topMargin = i3;
            platformOverlayView.setLayoutParams(layoutParams);
            platformOverlayView.setVisibility(0);
            platformOverlayView.bringToFront();
            this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(i));
            return;
        }
        throw new IllegalStateException("The overlay surface (id:" + i + ") doesn't exist");
    }

    public void onBeginFrame() {
        this.currentFrameUsedOverlayLayerIds.clear();
        this.currentFrameUsedPlatformViewIds.clear();
    }

    public void onEndFrame() {
        boolean z = false;
        if (!this.flutterViewConvertedToImageView || !this.currentFrameUsedPlatformViewIds.isEmpty()) {
            if (this.flutterViewConvertedToImageView && this.flutterView.acquireLatestImageViewFrame()) {
                z = true;
            }
            finishFrame(z);
            return;
        }
        this.flutterViewConvertedToImageView = false;
        this.flutterView.revertImageView(new PlatformViewsController$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$onEndFrame$1$PlatformViewsController() {
        finishFrame(false);
    }

    private void finishFrame(boolean z) {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            int keyAt = this.overlayLayerViews.keyAt(i);
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i);
            if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(keyAt))) {
                this.flutterView.attachOverlaySurfaceToRender(valueAt);
                z &= valueAt.acquireLatestImage();
            } else {
                if (!this.flutterViewConvertedToImageView) {
                    valueAt.detachFromRenderer();
                }
                valueAt.setVisibility(8);
            }
        }
        for (int i2 = 0; i2 < this.platformViewParent.size(); i2++) {
            int keyAt2 = this.platformViewParent.keyAt(i2);
            View view = this.platformViewParent.get(keyAt2);
            if (!this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(keyAt2)) || (!z && this.synchronizeToNativeViewHierarchy)) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
    }

    public FlutterOverlaySurface createOverlaySurface(PlatformOverlayView platformOverlayView) {
        int i = this.nextOverlayLayerId;
        this.nextOverlayLayerId = i + 1;
        this.overlayLayerViews.put(i, platformOverlayView);
        return new FlutterOverlaySurface(i, platformOverlayView.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface() {
        return createOverlaySurface(new PlatformOverlayView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), this.accessibilityEventsDelegate));
    }

    public void destroyOverlaySurfaces() {
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            PlatformOverlayView valueAt = this.overlayLayerViews.valueAt(i);
            valueAt.detachFromRenderer();
            valueAt.closeImageReader();
        }
    }

    private void removeOverlaySurfaces() {
        if (this.flutterView == null) {
            Log.e(TAG, "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i = 0; i < this.overlayLayerViews.size(); i++) {
            this.flutterView.removeView(this.overlayLayerViews.valueAt(i));
        }
        this.overlayLayerViews.clear();
    }
}
