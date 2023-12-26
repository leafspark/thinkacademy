package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG = new EmptyCameraConfig();

    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }

    static final class EmptyCameraConfig implements CameraConfig {
        private final UseCaseConfigFactory mUseCaseConfigFactory = new UseCaseConfigFactory() {
            public Config getConfig(UseCaseConfigFactory.CaptureType captureType) {
                return null;
            }
        };

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return ReadableConfig.CC.$default$containsOption(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ReadableConfig.CC.$default$getOptionPriority(this, option);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return ReadableConfig.CC.$default$getPriorities(this, option);
        }

        public /* synthetic */ Set listOptions() {
            return ReadableConfig.CC.$default$listOptions(this);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return ReadableConfig.CC.$default$retrieveOption(this, option);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return ReadableConfig.CC.$default$retrieveOption(this, option, obj);
        }

        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, option, optionPriority);
        }

        EmptyCameraConfig() {
        }

        public UseCaseConfigFactory getUseCaseConfigFactory() {
            return this.mUseCaseConfigFactory;
        }

        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }
    }

    private CameraConfigs() {
    }
}
