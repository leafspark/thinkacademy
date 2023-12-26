package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;

public interface CameraConfig extends ReadableConfig {
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    public interface Builder<B> {
        B setUseCaseConfigFactory(UseCaseConfigFactory useCaseConfigFactory);
    }

    UseCaseConfigFactory getUseCaseConfigFactory();
}
