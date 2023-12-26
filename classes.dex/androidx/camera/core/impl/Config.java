package androidx.camera.core.impl;

import java.util.Set;

public interface Config {

    public interface OptionMatcher {
        boolean onOptionMatched(Option<?> option);
    }

    public enum OptionPriority {
        ALWAYS_OVERRIDE,
        REQUIRED,
        OPTIONAL
    }

    boolean containsOption(Option<?> option);

    void findOptions(String str, OptionMatcher optionMatcher);

    OptionPriority getOptionPriority(Option<?> option);

    Set<OptionPriority> getPriorities(Option<?> option);

    Set<Option<?>> listOptions();

    <ValueT> ValueT retrieveOption(Option<ValueT> option);

    <ValueT> ValueT retrieveOption(Option<ValueT> option, ValueT valuet);

    <ValueT> ValueT retrieveOptionWithPriority(Option<ValueT> option, OptionPriority optionPriority);

    public static abstract class Option<T> {
        public abstract String getId();

        public abstract Object getToken();

        public abstract Class<T> getValueClass();

        Option() {
        }

        public static <T> Option<T> create(String str, Class<?> cls) {
            return create(str, cls, (Object) null);
        }

        public static <T> Option<T> create(String str, Class<?> cls, Object obj) {
            return new AutoValue_Config_Option(str, cls, obj);
        }
    }

    /* renamed from: androidx.camera.core.impl.Config$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean hasConflict(OptionPriority optionPriority, OptionPriority optionPriority2) {
            if (optionPriority == OptionPriority.ALWAYS_OVERRIDE && optionPriority2 == OptionPriority.ALWAYS_OVERRIDE) {
                return true;
            }
            if (optionPriority == OptionPriority.REQUIRED && optionPriority2 == OptionPriority.REQUIRED) {
                return true;
            }
            return false;
        }

        public static Config mergeConfigs(Config config, Config config2) {
            MutableOptionsBundle mutableOptionsBundle;
            if (config == null && config2 == null) {
                return OptionsBundle.emptyBundle();
            }
            if (config2 != null) {
                mutableOptionsBundle = MutableOptionsBundle.from(config2);
            } else {
                mutableOptionsBundle = MutableOptionsBundle.create();
            }
            if (config != null) {
                for (Option next : config.listOptions()) {
                    mutableOptionsBundle.insertOption(next, config.getOptionPriority(next), config.retrieveOption(next));
                }
            }
            return OptionsBundle.from(mutableOptionsBundle);
        }
    }
}
