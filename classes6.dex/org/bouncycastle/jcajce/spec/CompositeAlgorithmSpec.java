package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeAlgorithmSpec implements AlgorithmParameterSpec {
    private final List<String> algorithmNames;
    private final List<AlgorithmParameterSpec> parameterSpecs;

    public static class Builder {
        /* access modifiers changed from: private */
        public List<String> algorithmNames = new ArrayList();
        /* access modifiers changed from: private */
        public List<AlgorithmParameterSpec> parameterSpecs = new ArrayList();

        public Builder add(String str) {
            this.algorithmNames.add(str);
            this.parameterSpecs.add((Object) null);
            return this;
        }

        public Builder add(String str, AlgorithmParameterSpec algorithmParameterSpec) {
            this.algorithmNames.add(str);
            this.parameterSpecs.add(algorithmParameterSpec);
            return this;
        }

        public CompositeAlgorithmSpec build() {
            if (!this.algorithmNames.isEmpty()) {
                return new CompositeAlgorithmSpec(this);
            }
            throw new IllegalStateException("cannot call build with no algorithm names added");
        }
    }

    public CompositeAlgorithmSpec(Builder builder) {
        this.algorithmNames = Collections.unmodifiableList(new ArrayList(builder.algorithmNames));
        this.parameterSpecs = Collections.unmodifiableList(new ArrayList(builder.parameterSpecs));
    }

    public List<String> getAlgorithmNames() {
        return this.algorithmNames;
    }

    public List<AlgorithmParameterSpec> getParameterSpecs() {
        return this.parameterSpecs;
    }
}
