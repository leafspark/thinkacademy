package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;

public interface TargetConfig<T> extends ReadableConfig {
    public static final Config.Option<Class<?>> OPTION_TARGET_CLASS = Config.Option.create("camerax.core.target.class", Class.class);
    public static final Config.Option<String> OPTION_TARGET_NAME = Config.Option.create("camerax.core.target.name", String.class);

    public interface Builder<T, B> {
        B setTargetClass(Class<T> cls);

        B setTargetName(String str);
    }

    Class<T> getTargetClass();

    Class<T> getTargetClass(Class<T> cls);

    String getTargetName();

    String getTargetName(String str);

    /* renamed from: androidx.camera.core.internal.TargetConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getTargetClass(TargetConfig _this, Class cls) {
            return (Class) _this.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, cls);
        }

        public static Class $default$getTargetClass(TargetConfig _this) {
            return (Class) _this.retrieveOption(TargetConfig.OPTION_TARGET_CLASS);
        }

        public static String $default$getTargetName(TargetConfig _this, String str) {
            return (String) _this.retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
        }

        public static String $default$getTargetName(TargetConfig _this) {
            return (String) _this.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
        }
    }
}
