package androidx.camera.core.internal;

import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

public interface UseCaseEventConfig extends ReadableConfig {
    public static final Config.Option<UseCase.EventCallback> OPTION_USE_CASE_EVENT_CALLBACK = Config.Option.create("camerax.core.useCaseEventCallback", UseCase.EventCallback.class);

    public interface Builder<B> {
        B setUseCaseEventCallback(UseCase.EventCallback eventCallback);
    }

    UseCase.EventCallback getUseCaseEventCallback();

    UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback);

    /* renamed from: androidx.camera.core.internal.UseCaseEventConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static UseCase.EventCallback $default$getUseCaseEventCallback(UseCaseEventConfig _this, UseCase.EventCallback eventCallback) {
            return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, eventCallback);
        }

        public static UseCase.EventCallback $default$getUseCaseEventCallback(UseCaseEventConfig _this) {
            return (UseCase.EventCallback) _this.retrieveOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK);
        }
    }
}
