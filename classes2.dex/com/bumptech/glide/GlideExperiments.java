package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GlideExperiments {
    private final Map<Class<?>, Experiment> experiments;

    interface Experiment {
    }

    GlideExperiments(Builder builder) {
        this.experiments = Collections.unmodifiableMap(new HashMap(builder.experiments));
    }

    /* access modifiers changed from: package-private */
    public <T extends Experiment> T get(Class<T> cls) {
        return (Experiment) this.experiments.get(cls);
    }

    public boolean isEnabled(Class<? extends Experiment> cls) {
        return this.experiments.containsKey(cls);
    }

    static final class Builder {
        /* access modifiers changed from: private */
        public final Map<Class<?>, Experiment> experiments = new HashMap();

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder update(Experiment experiment, boolean z) {
            if (z) {
                add(experiment);
            } else {
                this.experiments.remove(experiment.getClass());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder add(Experiment experiment) {
            this.experiments.put(experiment.getClass(), experiment);
            return this;
        }

        /* access modifiers changed from: package-private */
        public GlideExperiments build() {
            return new GlideExperiments(this);
        }
    }
}
