package androidx.camera.core.impl;

import androidx.camera.core.impl.UseCaseAttachState;

public final /* synthetic */ class UseCaseAttachState$$ExternalSyntheticLambda1 implements UseCaseAttachState.AttachStateFilter {
    public static final /* synthetic */ UseCaseAttachState$$ExternalSyntheticLambda1 INSTANCE = new UseCaseAttachState$$ExternalSyntheticLambda1();

    private /* synthetic */ UseCaseAttachState$$ExternalSyntheticLambda1() {
    }

    public final boolean filter(UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo) {
        return useCaseAttachInfo.getAttached();
    }
}
