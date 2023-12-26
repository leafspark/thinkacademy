package androidx.camera.core.internal;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.concurrent.Executor;

public interface ThreadConfig extends ReadableConfig {
    public static final Config.Option<Executor> OPTION_BACKGROUND_EXECUTOR = Config.Option.create("camerax.core.thread.backgroundExecutor", Executor.class);

    public interface Builder<B> {
        B setBackgroundExecutor(Executor executor);
    }

    Executor getBackgroundExecutor();

    Executor getBackgroundExecutor(Executor executor);

    /* renamed from: androidx.camera.core.internal.ThreadConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Executor $default$getBackgroundExecutor(ThreadConfig _this, Executor executor) {
            return (Executor) _this.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
        }

        public static Executor $default$getBackgroundExecutor(ThreadConfig _this) {
            return (Executor) _this.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
        }
    }
}
