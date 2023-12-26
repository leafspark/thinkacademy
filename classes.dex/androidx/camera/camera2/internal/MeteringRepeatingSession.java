package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

class MeteringRepeatingSession {
    private static final String TAG = "MeteringRepeating";
    private DeferrableSurface mDeferrableSurface;
    private final SessionConfig mSessionConfig;

    /* access modifiers changed from: package-private */
    public String getName() {
        return TAG;
    }

    MeteringRepeatingSession(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        MeteringRepeatingConfig meteringRepeatingConfig = new MeteringRepeatingConfig();
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size minimumPreviewSize = getMinimumPreviewSize(cameraCharacteristicsCompat);
        Logger.d(TAG, "MerteringSession SurfaceTexture size: " + minimumPreviewSize);
        surfaceTexture.setDefaultBufferSize(minimumPreviewSize.getWidth(), minimumPreviewSize.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(meteringRepeatingConfig);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.mDeferrableSurface = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
                surface.release();
                surfaceTexture.release();
            }

            public void onFailure(Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }
        }, CameraXExecutors.directExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        this.mSessionConfig = createFrom.build();
    }

    /* access modifiers changed from: package-private */
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    private static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        private final Config mConfig;

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return ReadableConfig.CC.$default$containsOption(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
        }

        public /* synthetic */ Consumer getAttachedUseCasesUpdateListener() {
            return UseCaseConfig.CC.$default$getAttachedUseCasesUpdateListener(this);
        }

        public /* synthetic */ Consumer getAttachedUseCasesUpdateListener(Consumer consumer) {
            return UseCaseConfig.CC.$default$getAttachedUseCasesUpdateListener(this, consumer);
        }

        public /* synthetic */ CameraSelector getCameraSelector() {
            return UseCaseConfig.CC.$default$getCameraSelector(this);
        }

        public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
            return UseCaseConfig.CC.$default$getCameraSelector(this, cameraSelector);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, optionUnpacker);
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, captureConfig);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, sessionConfig);
        }

        public /* synthetic */ int getInputFormat() {
            return ImageInputConfig.CC.$default$getInputFormat(this);
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ReadableConfig.CC.$default$getOptionPriority(this, option);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return ReadableConfig.CC.$default$getPriorities(this, option);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, optionUnpacker);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority() {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority(int i) {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, i);
        }

        public /* synthetic */ Class getTargetClass() {
            return TargetConfig.CC.$default$getTargetClass(this);
        }

        public /* synthetic */ Class getTargetClass(Class cls) {
            return TargetConfig.CC.$default$getTargetClass(this, cls);
        }

        public /* synthetic */ String getTargetName() {
            return TargetConfig.CC.$default$getTargetName(this);
        }

        public /* synthetic */ String getTargetName(String str) {
            return TargetConfig.CC.$default$getTargetName(this, str);
        }

        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
            return UseCaseEventConfig.CC.$default$getUseCaseEventCallback(this);
        }

        public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
            return UseCaseEventConfig.CC.$default$getUseCaseEventCallback(this, eventCallback);
        }

        public /* synthetic */ Set listOptions() {
            return ReadableConfig.CC.$default$listOptions(this);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return ReadableConfig.CC.$default$retrieveOption(this, option);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return ReadableConfig.CC.$default$retrieveOption(this, option, obj);
        }

        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, option, optionPriority);
        }

        MeteringRepeatingConfig() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            this.mConfig = create;
        }

        public Config getConfig() {
            return this.mConfig;
        }
    }

    private Size getMinimumPreviewSize(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Size[] sizeArr;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            Logger.e(TAG, "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
            return new Size(0, 0);
        }
        if (Build.VERSION.SDK_INT < 23) {
            sizeArr = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
        } else {
            sizeArr = streamConfigurationMap.getOutputSizes(34);
        }
        if (sizeArr != null) {
            return (Size) Collections.min(Arrays.asList(sizeArr), MeteringRepeatingSession$$ExternalSyntheticLambda0.INSTANCE);
        }
        Logger.e(TAG, "Can not get output size list.");
        return new Size(0, 0);
    }
}
