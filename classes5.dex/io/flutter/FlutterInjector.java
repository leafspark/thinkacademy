package io.flutter;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class FlutterInjector {
    private static boolean accessed;
    private static FlutterInjector instance;
    private DeferredComponentManager deferredComponentManager;
    private ExecutorService executorService;
    private FlutterJNI.Factory flutterJniFactory;
    private FlutterLoader flutterLoader;

    public static void setInstance(FlutterInjector flutterInjector) {
        if (!accessed) {
            instance = flutterInjector;
            return;
        }
        throw new IllegalStateException("Cannot change the FlutterInjector instance once it's been read. If you're trying to dependency inject, be sure to do so at the beginning of the program");
    }

    public static FlutterInjector instance() {
        accessed = true;
        if (instance == null) {
            instance = new Builder().build();
        }
        return instance;
    }

    public static void reset() {
        accessed = false;
        instance = null;
    }

    private FlutterInjector(FlutterLoader flutterLoader2, DeferredComponentManager deferredComponentManager2, FlutterJNI.Factory factory, ExecutorService executorService2) {
        this.flutterLoader = flutterLoader2;
        this.deferredComponentManager = deferredComponentManager2;
        this.flutterJniFactory = factory;
        this.executorService = executorService2;
    }

    public FlutterLoader flutterLoader() {
        return this.flutterLoader;
    }

    public DeferredComponentManager deferredComponentManager() {
        return this.deferredComponentManager;
    }

    public ExecutorService executorService() {
        return this.executorService;
    }

    public FlutterJNI.Factory getFlutterJNIFactory() {
        return this.flutterJniFactory;
    }

    public static final class Builder {
        private DeferredComponentManager deferredComponentManager;
        private ExecutorService executorService;
        private FlutterJNI.Factory flutterJniFactory;
        private FlutterLoader flutterLoader;

        private class NamedThreadFactory implements ThreadFactory {
            private int threadId;

            private NamedThreadFactory() {
                this.threadId = 0;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                StringBuilder sb = new StringBuilder();
                sb.append("flutter-worker-");
                int i = this.threadId;
                this.threadId = i + 1;
                sb.append(i);
                thread.setName(sb.toString());
                return thread;
            }
        }

        public Builder setFlutterLoader(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
            return this;
        }

        public Builder setDeferredComponentManager(DeferredComponentManager deferredComponentManager2) {
            this.deferredComponentManager = deferredComponentManager2;
            return this;
        }

        public Builder setFlutterJNIFactory(FlutterJNI.Factory factory) {
            this.flutterJniFactory = factory;
            return this;
        }

        public Builder setExecutorService(ExecutorService executorService2) {
            this.executorService = executorService2;
            return this;
        }

        private void fillDefaults() {
            if (this.flutterJniFactory == null) {
                this.flutterJniFactory = new FlutterJNI.Factory();
            }
            if (this.executorService == null) {
                this.executorService = Executors.newCachedThreadPool(new NamedThreadFactory());
            }
            if (this.flutterLoader == null) {
                this.flutterLoader = new FlutterLoader(this.flutterJniFactory.provideFlutterJNI(), this.executorService);
            }
        }

        public FlutterInjector build() {
            fillDefaults();
            return new FlutterInjector(this.flutterLoader, this.deferredComponentManager, this.flutterJniFactory, this.executorService);
        }
    }
}
