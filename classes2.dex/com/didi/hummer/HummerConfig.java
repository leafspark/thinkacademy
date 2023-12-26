package com.didi.hummer;

import com.didi.hummer.adapter.font.IFontAdapter;
import com.didi.hummer.adapter.font.impl.DefaultFontAdapter;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.didi.hummer.adapter.http.impl.DefaultHttpAdapter;
import com.didi.hummer.adapter.imageloader.IImageLoaderAdapter;
import com.didi.hummer.adapter.imageloader.impl.DefaultImageLoaderAdapter;
import com.didi.hummer.adapter.navigator.INavigatorAdapter;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import com.didi.hummer.adapter.scriptloader.IScriptLoaderAdapter;
import com.didi.hummer.adapter.scriptloader.impl.DefaultScriptLoaderAdapter;
import com.didi.hummer.adapter.storage.IStorageAdapter;
import com.didi.hummer.adapter.storage.impl.DefaultStorageAdapter;
import com.didi.hummer.adapter.tracker.ITrackerAdapter;
import com.didi.hummer.adapter.tracker.impl.EmptyTrackerAdapter;
import com.didi.hummer.core.exception.ExceptionCallback;
import com.didi.hummer.meta.ComponentInvokerIndex;
import com.didi.hummer.tools.EventTracer;
import com.didi.hummer.tools.JSLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HummerConfig {
    private List<ComponentInvokerIndex> componentInvokerIndexes;
    private EventTracer.Trace eventTracer;
    private ExceptionCallback exceptionCallback;
    private IFontAdapter fontAdapter;
    private String fontsAssetsPath;
    private IHttpAdapter httpAdapter;
    private IImageLoaderAdapter imageLoaderAdapter;
    private boolean isSupportBytecode;
    private boolean isSupportRTL;
    private JSLogger.Logger jsLogger;
    private String namespace;
    private INavigatorAdapter navAdapter;
    private IScriptLoaderAdapter scriptLoaderAdapter;
    private IStorageAdapter storageAdapter;
    private ITrackerAdapter trackerAdapter;

    static /* synthetic */ void lambda$getEventTracer$1(String str, Map map) {
    }

    static /* synthetic */ void lambda$getExceptionCallback$2(Exception exc) {
    }

    static /* synthetic */ void lambda$getJsLogger$0(int i, String str) {
    }

    private HummerConfig(Builder builder) {
        this.namespace = builder.namespace;
        this.jsLogger = builder.jsLogger;
        this.eventTracer = builder.eventTracer;
        this.exceptionCallback = builder.exceptionCallback;
        this.isSupportRTL = builder.isSupportRTL;
        this.isSupportBytecode = builder.isSupportBytecode;
        this.fontsAssetsPath = builder.fontsAssetsPath;
        this.httpAdapter = builder.httpAdapter;
        this.fontAdapter = builder.fontAdapter;
        this.imageLoaderAdapter = builder.imageLoaderAdapter;
        this.storageAdapter = builder.storageAdapter;
        this.navAdapter = builder.navAdapter;
        this.scriptLoaderAdapter = builder.scriptLoaderAdapter;
        this.trackerAdapter = builder.trackerAdapter;
        this.componentInvokerIndexes = builder.componentInvokerIndexes;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public JSLogger.Logger getJsLogger() {
        if (this.jsLogger == null) {
            this.jsLogger = HummerConfig$$ExternalSyntheticLambda2.INSTANCE;
        }
        return this.jsLogger;
    }

    public EventTracer.Trace getEventTracer() {
        if (this.eventTracer == null) {
            this.eventTracer = HummerConfig$$ExternalSyntheticLambda1.INSTANCE;
        }
        return this.eventTracer;
    }

    public ExceptionCallback getExceptionCallback() {
        if (this.exceptionCallback == null) {
            this.exceptionCallback = HummerConfig$$ExternalSyntheticLambda0.INSTANCE;
        }
        return this.exceptionCallback;
    }

    public boolean isSupportRTL() {
        return this.isSupportRTL;
    }

    public boolean isSupportBytecode() {
        return this.isSupportBytecode;
    }

    @Deprecated
    public String getFontsAssetsPath() {
        return this.fontsAssetsPath;
    }

    public IHttpAdapter getHttpAdapter() {
        if (this.httpAdapter == null) {
            this.httpAdapter = new DefaultHttpAdapter();
        }
        return this.httpAdapter;
    }

    public IFontAdapter getFontAdapter() {
        if (this.fontAdapter == null) {
            this.fontAdapter = new DefaultFontAdapter(this.fontsAssetsPath);
        }
        return this.fontAdapter;
    }

    public IImageLoaderAdapter getImageLoaderAdapter() {
        if (this.imageLoaderAdapter == null) {
            this.imageLoaderAdapter = new DefaultImageLoaderAdapter();
        }
        return this.imageLoaderAdapter;
    }

    public IStorageAdapter getStorageAdapter() {
        if (this.storageAdapter == null) {
            this.storageAdapter = new DefaultStorageAdapter();
        }
        this.storageAdapter.setNamespace(this.namespace);
        return this.storageAdapter;
    }

    public INavigatorAdapter getNavAdapter() {
        if (this.navAdapter == null) {
            this.navAdapter = new DefaultNavigatorAdapter();
        }
        return this.navAdapter;
    }

    public IScriptLoaderAdapter getScriptLoaderAdapter() {
        if (this.scriptLoaderAdapter == null) {
            this.scriptLoaderAdapter = new DefaultScriptLoaderAdapter();
        }
        return this.scriptLoaderAdapter;
    }

    public ITrackerAdapter getTrackerAdapter() {
        if (this.trackerAdapter == null) {
            this.trackerAdapter = new EmptyTrackerAdapter();
        }
        return this.trackerAdapter;
    }

    public List<ComponentInvokerIndex> getComponentInvokerIndexes() {
        return this.componentInvokerIndexes;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public List<ComponentInvokerIndex> componentInvokerIndexes;
        /* access modifiers changed from: private */
        public EventTracer.Trace eventTracer;
        /* access modifiers changed from: private */
        public ExceptionCallback exceptionCallback;
        /* access modifiers changed from: private */
        public IFontAdapter fontAdapter;
        /* access modifiers changed from: private */
        public String fontsAssetsPath;
        /* access modifiers changed from: private */
        public IHttpAdapter httpAdapter;
        /* access modifiers changed from: private */
        public IImageLoaderAdapter imageLoaderAdapter;
        /* access modifiers changed from: private */
        public boolean isSupportBytecode;
        /* access modifiers changed from: private */
        public boolean isSupportRTL;
        /* access modifiers changed from: private */
        public JSLogger.Logger jsLogger;
        /* access modifiers changed from: private */
        public String namespace = HummerSDK.NAMESPACE_DEFAULT;
        /* access modifiers changed from: private */
        public INavigatorAdapter navAdapter;
        /* access modifiers changed from: private */
        public IScriptLoaderAdapter scriptLoaderAdapter;
        /* access modifiers changed from: private */
        public IStorageAdapter storageAdapter;
        /* access modifiers changed from: private */
        public ITrackerAdapter trackerAdapter;

        public Builder setNamespace(String str) {
            this.namespace = str;
            return this;
        }

        public Builder setJSLogger(JSLogger.Logger logger) {
            this.jsLogger = logger;
            return this;
        }

        @Deprecated
        public Builder setEventTracer(EventTracer.Trace trace) {
            this.eventTracer = trace;
            return this;
        }

        public Builder setExceptionCallback(ExceptionCallback exceptionCallback2) {
            this.exceptionCallback = exceptionCallback2;
            return this;
        }

        public Builder setSupportRTL(boolean z) {
            this.isSupportRTL = z;
            return this;
        }

        public Builder setSupportBytecode(boolean z) {
            this.isSupportBytecode = z;
            return this;
        }

        @Deprecated
        public Builder setFontsAssetsPath(String str) {
            this.fontsAssetsPath = str;
            return this;
        }

        public Builder setHttpAdapter(IHttpAdapter iHttpAdapter) {
            this.httpAdapter = iHttpAdapter;
            return this;
        }

        public Builder setFontAdapter(IFontAdapter iFontAdapter) {
            this.fontAdapter = iFontAdapter;
            return this;
        }

        public Builder setImageLoaderAdapter(IImageLoaderAdapter iImageLoaderAdapter) {
            this.imageLoaderAdapter = iImageLoaderAdapter;
            return this;
        }

        public Builder setStorageAdapter(IStorageAdapter iStorageAdapter) {
            this.storageAdapter = iStorageAdapter;
            return this;
        }

        public Builder setNavigatorAdapter(INavigatorAdapter iNavigatorAdapter) {
            this.navAdapter = iNavigatorAdapter;
            return this;
        }

        public Builder setScriptLoaderAdapter(IScriptLoaderAdapter iScriptLoaderAdapter) {
            this.scriptLoaderAdapter = iScriptLoaderAdapter;
            return this;
        }

        public Builder setTrackerAdapter(ITrackerAdapter iTrackerAdapter) {
            this.trackerAdapter = iTrackerAdapter;
            return this;
        }

        public Builder addIndex(ComponentInvokerIndex componentInvokerIndex) {
            if (this.componentInvokerIndexes == null) {
                this.componentInvokerIndexes = new ArrayList();
            }
            this.componentInvokerIndexes.add(componentInvokerIndex);
            return this;
        }

        public HummerConfig builder() {
            return new HummerConfig(this);
        }
    }
}
