package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

public interface ReadableConfig extends Config {
    boolean containsOption(Config.Option<?> option);

    void findOptions(String str, Config.OptionMatcher optionMatcher);

    Config getConfig();

    Config.OptionPriority getOptionPriority(Config.Option<?> option);

    Set<Config.OptionPriority> getPriorities(Config.Option<?> option);

    Set<Config.Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(Config.Option<ValueT> option);

    <ValueT> ValueT retrieveOption(Config.Option<ValueT> option, ValueT valuet);

    <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> option, Config.OptionPriority optionPriority);

    /* renamed from: androidx.camera.core.impl.ReadableConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$containsOption(ReadableConfig _this, Config.Option option) {
            return _this.getConfig().containsOption(option);
        }

        public static <ValueT> Object $default$retrieveOption(ReadableConfig _this, Config.Option option) {
            return _this.getConfig().retrieveOption(option);
        }

        public static <ValueT> Object $default$retrieveOption(ReadableConfig _this, Config.Option option, Object obj) {
            return _this.getConfig().retrieveOption(option, obj);
        }

        public static void $default$findOptions(ReadableConfig _this, String str, Config.OptionMatcher optionMatcher) {
            _this.getConfig().findOptions(str, optionMatcher);
        }

        public static Set $default$listOptions(ReadableConfig _this) {
            return _this.getConfig().listOptions();
        }

        public static <ValueT> Object $default$retrieveOptionWithPriority(ReadableConfig _this, Config.Option option, Config.OptionPriority optionPriority) {
            return _this.getConfig().retrieveOptionWithPriority(option, optionPriority);
        }

        public static Config.OptionPriority $default$getOptionPriority(ReadableConfig _this, Config.Option option) {
            return _this.getConfig().getOptionPriority(option);
        }

        public static Set $default$getPriorities(ReadableConfig _this, Config.Option option) {
            return _this.getConfig().getPriorities(option);
        }
    }
}
