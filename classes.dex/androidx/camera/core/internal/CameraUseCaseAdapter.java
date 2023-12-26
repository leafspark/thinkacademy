package androidx.camera.core.internal;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private boolean mAttached = true;
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;
    private CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;
    private Config mInteropConfig = null;
    private final Object mLock = new Object();
    private final UseCaseConfigFactory mUseCaseConfigFactory;
    private final List<UseCase> mUseCases = new ArrayList();
    private ViewPort mViewPort;

    public CameraUseCaseAdapter(LinkedHashSet<CameraInternal> linkedHashSet, CameraDeviceSurfaceManager cameraDeviceSurfaceManager, UseCaseConfigFactory useCaseConfigFactory) {
        this.mCameraInternal = (CameraInternal) linkedHashSet.iterator().next();
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
    }

    public static CameraId generateCameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    public CameraId getCameraId() {
        return this.mId;
    }

    public boolean isEquivalent(CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    public void setViewPort(ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    public void checkAttachUseCases(List<UseCase> list) throws CameraException {
        synchronized (this.mLock) {
            try {
                calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), list, Collections.emptyList(), getConfigs(list, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
            } catch (IllegalArgumentException e) {
                throw new CameraException(e.getMessage());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addUseCases(Collection<UseCase> collection) throws CameraException {
        synchronized (this.mLock) {
            ArrayList<UseCase> arrayList = new ArrayList<>();
            for (UseCase next : collection) {
                if (this.mUseCases.contains(next)) {
                    Logger.d(TAG, "Attempting to attach already attached UseCase");
                } else {
                    arrayList.add(next);
                }
            }
            Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
            try {
                Map<UseCase, Size> calculateSuggestedResolutions = calculateSuggestedResolutions(this.mCameraInternal.getCameraInfoInternal(), arrayList, this.mUseCases, configs);
                updateViewPort(calculateSuggestedResolutions, collection);
                for (UseCase useCase : arrayList) {
                    ConfigPair configPair = configs.get(useCase);
                    useCase.onAttach(this.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                    useCase.updateSuggestedResolution((Size) Preconditions.checkNotNull(calculateSuggestedResolutions.get(useCase)));
                }
                this.mUseCases.addAll(arrayList);
                if (this.mAttached) {
                    notifyAttachedUseCasesChange(this.mUseCases);
                    this.mCameraInternal.attachUseCases(arrayList);
                }
                for (UseCase notifyState : arrayList) {
                    notifyState.notifyState();
                }
            } catch (IllegalArgumentException e) {
                throw new CameraException(e.getMessage());
            }
        }
    }

    public void removeUseCases(Collection<UseCase> collection) {
        synchronized (this.mLock) {
            this.mCameraInternal.detachUseCases(collection);
            for (UseCase next : collection) {
                if (this.mUseCases.contains(next)) {
                    next.onDetach(this.mCameraInternal);
                } else {
                    Logger.e(TAG, "Attempting to detach non-attached UseCase: " + next);
                }
            }
            this.mUseCases.removeAll(collection);
        }
    }

    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mUseCases);
        }
        return arrayList;
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            if (!this.mAttached) {
                this.mCameraInternal.attachUseCases(this.mUseCases);
                notifyAttachedUseCasesChange(this.mUseCases);
                restoreInteropConfig();
                for (UseCase notifyState : this.mUseCases) {
                    notifyState.notifyState();
                }
                this.mAttached = true;
            }
        }
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            if (this.mAttached) {
                this.mCameraInternal.detachUseCases(new ArrayList(this.mUseCases));
                cacheInteropConfig();
                this.mAttached = false;
            }
        }
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            if (this.mInteropConfig != null) {
                this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
            }
        }
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    private Map<UseCase, Size> calculateSuggestedResolutions(CameraInfoInternal cameraInfoInternal, List<UseCase> list, List<UseCase> list2, Map<UseCase, ConfigPair> map) {
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap hashMap = new HashMap();
        for (UseCase next : list2) {
            arrayList.add(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(cameraId, next.getImageFormat(), next.getAttachedSurfaceResolution()));
            hashMap.put(next, next.getAttachedSurfaceResolution());
        }
        if (!list.isEmpty()) {
            HashMap hashMap2 = new HashMap();
            for (UseCase next2 : list) {
                ConfigPair configPair = map.get(next2);
                hashMap2.put(next2.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig), next2);
            }
            Map<UseCaseConfig<?>, Size> suggestedResolutions = this.mCameraDeviceSurfaceManager.getSuggestedResolutions(cameraId, arrayList, new ArrayList(hashMap2.keySet()));
            for (Map.Entry entry : hashMap2.entrySet()) {
                hashMap.put((UseCase) entry.getValue(), suggestedResolutions.get(entry.getKey()));
            }
        }
        return hashMap;
    }

    private void updateViewPort(Map<UseCase, Size> map, Collection<UseCase> collection) {
        synchronized (this.mLock) {
            if (this.mViewPort != null) {
                Map<UseCase, Rect> calculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), this.mCameraInternal.getCameraInfoInternal().getLensFacing().intValue() == 0, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                for (UseCase next : collection) {
                    next.setViewPortCropRect((Rect) Preconditions.checkNotNull(calculateViewPortRects.get(next)));
                }
            }
        }
    }

    private static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    private Map<UseCase, ConfigPair> getConfigs(List<UseCase> list, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap hashMap = new HashMap();
        for (UseCase next : list) {
            hashMap.put(next, new ConfigPair(next.getDefaultConfig(false, useCaseConfigFactory), next.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return hashMap;
    }

    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.mIds.add(((CameraInternal) it.next()).getCameraInfoInternal().getCameraId());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }
    }

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(String str) {
            super(str);
        }

        public CameraException(Throwable th) {
            super(th);
        }
    }

    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControlInternal();
    }

    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfoInternal();
    }

    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    public void setExtendedConfig(CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                this.mCameraConfig = CameraConfigs.emptyConfig();
            } else {
                this.mCameraConfig = cameraConfig;
            }
        }
    }

    private void notifyAttachedUseCasesChange(List<UseCase> list) {
        CameraXExecutors.mainThreadExecutor().execute(new CameraUseCaseAdapter$$ExternalSyntheticLambda0(list));
    }

    static /* synthetic */ void lambda$notifyAttachedUseCasesChange$0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Consumer<Collection<UseCase>> attachedUseCasesUpdateListener = ((UseCase) it.next()).getCurrentConfig().getAttachedUseCasesUpdateListener((Consumer<Collection<UseCase>>) null);
            if (attachedUseCasesUpdateListener != null) {
                attachedUseCasesUpdateListener.accept(Collections.unmodifiableList(list));
            }
        }
    }
}
