package com.didi.hummer.devtools;

import com.didi.hummer.devtools.HummerDevTools;

public class DevToolsConfig {
    private HummerDevTools.IParameterInjector injector;

    private DevToolsConfig(Builder builder) {
        this.injector = builder.injector;
    }

    public HummerDevTools.IParameterInjector getInjector() {
        return this.injector;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public HummerDevTools.IParameterInjector injector;

        public Builder setInjector(HummerDevTools.IParameterInjector iParameterInjector) {
            this.injector = iParameterInjector;
            return this;
        }

        public DevToolsConfig build() {
            return new DevToolsConfig(this);
        }
    }
}
