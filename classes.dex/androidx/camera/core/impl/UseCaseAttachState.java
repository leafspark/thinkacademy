package androidx.camera.core.impl;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.SessionConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class UseCaseAttachState {
    private static final String TAG = "UseCaseAttachState";
    private final Map<String, UseCaseAttachInfo> mAttachedUseCasesToInfoMap = new HashMap();
    private final String mCameraId;

    private interface AttachStateFilter {
        boolean filter(UseCaseAttachInfo useCaseAttachInfo);
    }

    public UseCaseAttachState(String str) {
        this.mCameraId = str;
    }

    public void setUseCaseActive(String str, SessionConfig sessionConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig).setActive(true);
    }

    public void setUseCaseInactive(String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setActive(false);
            if (!useCaseAttachInfo.getAttached()) {
                this.mAttachedUseCasesToInfoMap.remove(str);
            }
        }
    }

    public void setUseCaseAttached(String str, SessionConfig sessionConfig) {
        getOrCreateUseCaseAttachInfo(str, sessionConfig).setAttached(true);
    }

    public void setUseCaseDetached(String str) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(false);
            if (!useCaseAttachInfo.getActive()) {
                this.mAttachedUseCasesToInfoMap.remove(str);
            }
        }
    }

    public boolean isUseCaseAttached(String str) {
        if (!this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            return false;
        }
        return this.mAttachedUseCasesToInfoMap.get(str).getAttached();
    }

    public Collection<SessionConfig> getAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(UseCaseAttachState$$ExternalSyntheticLambda1.INSTANCE));
    }

    public Collection<SessionConfig> getActiveAndAttachedSessionConfigs() {
        return Collections.unmodifiableCollection(getSessionConfigs(UseCaseAttachState$$ExternalSyntheticLambda0.INSTANCE));
    }

    static /* synthetic */ boolean lambda$getActiveAndAttachedSessionConfigs$1(UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached();
    }

    public void updateUseCase(String str, SessionConfig sessionConfig) {
        if (this.mAttachedUseCasesToInfoMap.containsKey(str)) {
            UseCaseAttachInfo useCaseAttachInfo = new UseCaseAttachInfo(sessionConfig);
            UseCaseAttachInfo useCaseAttachInfo2 = this.mAttachedUseCasesToInfoMap.get(str);
            useCaseAttachInfo.setAttached(useCaseAttachInfo2.getAttached());
            useCaseAttachInfo.setActive(useCaseAttachInfo2.getActive());
            this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo);
        }
    }

    public void removeUseCase(String str) {
        this.mAttachedUseCasesToInfoMap.remove(str);
    }

    public SessionConfig.ValidatingBuilder getActiveAndAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo useCaseAttachInfo = (UseCaseAttachInfo) next.getValue();
            if (useCaseAttachInfo.getActive() && useCaseAttachInfo.getAttached()) {
                validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
                arrayList.add((String) next.getKey());
            }
        }
        Logger.d(TAG, "Active and attached use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    public SessionConfig.ValidatingBuilder getAttachedBuilder() {
        SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            UseCaseAttachInfo useCaseAttachInfo = (UseCaseAttachInfo) next.getValue();
            if (useCaseAttachInfo.getAttached()) {
                validatingBuilder.add(useCaseAttachInfo.getSessionConfig());
                arrayList.add((String) next.getKey());
            }
        }
        Logger.d(TAG, "All use case: " + arrayList + " for camera: " + this.mCameraId);
        return validatingBuilder;
    }

    private UseCaseAttachInfo getOrCreateUseCaseAttachInfo(String str, SessionConfig sessionConfig) {
        UseCaseAttachInfo useCaseAttachInfo = this.mAttachedUseCasesToInfoMap.get(str);
        if (useCaseAttachInfo != null) {
            return useCaseAttachInfo;
        }
        UseCaseAttachInfo useCaseAttachInfo2 = new UseCaseAttachInfo(sessionConfig);
        this.mAttachedUseCasesToInfoMap.put(str, useCaseAttachInfo2);
        return useCaseAttachInfo2;
    }

    private Collection<SessionConfig> getSessionConfigs(AttachStateFilter attachStateFilter) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : this.mAttachedUseCasesToInfoMap.entrySet()) {
            if (attachStateFilter == null || attachStateFilter.filter((UseCaseAttachInfo) next.getValue())) {
                arrayList.add(((UseCaseAttachInfo) next.getValue()).getSessionConfig());
            }
        }
        return arrayList;
    }

    private static final class UseCaseAttachInfo {
        private boolean mActive = false;
        private boolean mAttached = false;
        private final SessionConfig mSessionConfig;

        UseCaseAttachInfo(SessionConfig sessionConfig) {
            this.mSessionConfig = sessionConfig;
        }

        /* access modifiers changed from: package-private */
        public SessionConfig getSessionConfig() {
            return this.mSessionConfig;
        }

        /* access modifiers changed from: package-private */
        public boolean getAttached() {
            return this.mAttached;
        }

        /* access modifiers changed from: package-private */
        public void setAttached(boolean z) {
            this.mAttached = z;
        }

        /* access modifiers changed from: package-private */
        public boolean getActive() {
            return this.mActive;
        }

        /* access modifiers changed from: package-private */
        public void setActive(boolean z) {
            this.mActive = z;
        }
    }
}
