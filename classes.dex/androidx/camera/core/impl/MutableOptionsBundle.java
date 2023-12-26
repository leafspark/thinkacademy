package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.Config;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class MutableOptionsBundle extends OptionsBundle implements MutableConfig {
    private static final Config.OptionPriority DEFAULT_PRIORITY = Config.OptionPriority.OPTIONAL;

    private MutableOptionsBundle(TreeMap<Config.Option<?>, Map<Config.OptionPriority, Object>> treeMap) {
        super(treeMap);
    }

    public static MutableOptionsBundle create() {
        return new MutableOptionsBundle(new TreeMap(ID_COMPARE));
    }

    public static MutableOptionsBundle from(Config config) {
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        for (Config.Option next : config.listOptions()) {
            Set<Config.OptionPriority> priorities = config.getPriorities(next);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority next2 : priorities) {
                arrayMap.put(next2, config.retrieveOptionWithPriority(next, next2));
            }
            treeMap.put(next, arrayMap);
        }
        return new MutableOptionsBundle(treeMap);
    }

    public <ValueT> ValueT removeOption(Config.Option<ValueT> option) {
        return this.mOptions.remove(option);
    }

    public <ValueT> void insertOption(Config.Option<ValueT> option, ValueT valuet) {
        insertOption(option, DEFAULT_PRIORITY, valuet);
    }

    public <ValueT> void insertOption(Config.Option<ValueT> option, Config.OptionPriority optionPriority, ValueT valuet) {
        Map map = (Map) this.mOptions.get(option);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            this.mOptions.put(option, arrayMap);
            arrayMap.put(optionPriority, valuet);
            return;
        }
        Config.OptionPriority optionPriority2 = (Config.OptionPriority) Collections.min(map.keySet());
        if (map.get(optionPriority2).equals(valuet) || !Config.CC.hasConflict(optionPriority2, optionPriority)) {
            map.put(optionPriority, valuet);
            return;
        }
        throw new IllegalArgumentException("Option values conflicts: " + option.getId() + ", existing value (" + optionPriority2 + ")=" + map.get(optionPriority2) + ", conflicting (" + optionPriority + ")=" + valuet);
    }
}
