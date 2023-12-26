package androidx.camera.core;

import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class UseCaseGroup {
    private final List<UseCase> mUseCases;
    private final ViewPort mViewPort;

    UseCaseGroup(ViewPort viewPort, List<UseCase> list) {
        this.mViewPort = viewPort;
        this.mUseCases = list;
    }

    public ViewPort getViewPort() {
        return this.mViewPort;
    }

    public List<UseCase> getUseCases() {
        return this.mUseCases;
    }

    public static final class Builder {
        private final List<UseCase> mUseCases = new ArrayList();
        private ViewPort mViewPort;

        public Builder setViewPort(ViewPort viewPort) {
            this.mViewPort = viewPort;
            return this;
        }

        public Builder addUseCase(UseCase useCase) {
            this.mUseCases.add(useCase);
            return this;
        }

        public UseCaseGroup build() {
            Preconditions.checkArgument(!this.mUseCases.isEmpty(), "UseCase must not be empty.");
            return new UseCaseGroup(this.mViewPort, this.mUseCases);
        }
    }
}
