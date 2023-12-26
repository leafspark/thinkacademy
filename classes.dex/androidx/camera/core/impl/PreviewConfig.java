package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class PreviewConfig implements UseCaseConfig<Preview>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<ImageInfoProcessor> IMAGE_INFO_PROCESSOR = Config.Option.create("camerax.core.preview.imageInfoProcessor", ImageInfoProcessor.class);
    public static final Config.Option<CaptureProcessor> OPTION_PREVIEW_CAPTURE_PROCESSOR = Config.Option.create("camerax.core.preview.captureProcessor", CaptureProcessor.class);
    private final OptionsBundle mConfig;

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

    public /* synthetic */ Executor getBackgroundExecutor() {
        return ThreadConfig.CC.$default$getBackgroundExecutor(this);
    }

    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return ThreadConfig.CC.$default$getBackgroundExecutor(this, executor);
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

    public /* synthetic */ Size getDefaultResolution() {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this);
    }

    public /* synthetic */ Size getDefaultResolution(Size size) {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this, size);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, sessionConfig);
    }

    public /* synthetic */ Size getMaxResolution() {
        return ImageOutputConfig.CC.$default$getMaxResolution(this);
    }

    public /* synthetic */ Size getMaxResolution(Size size) {
        return ImageOutputConfig.CC.$default$getMaxResolution(this, size);
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

    public /* synthetic */ List getSupportedResolutions() {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this);
    }

    public /* synthetic */ List getSupportedResolutions(List list) {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this, list);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority() {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority(int i) {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, i);
    }

    public /* synthetic */ int getTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$getTargetAspectRatio(this);
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

    public /* synthetic */ Size getTargetResolution() {
        return ImageOutputConfig.CC.$default$getTargetResolution(this);
    }

    public /* synthetic */ Size getTargetResolution(Size size) {
        return ImageOutputConfig.CC.$default$getTargetResolution(this, size);
    }

    public /* synthetic */ int getTargetRotation() {
        return ImageOutputConfig.CC.$default$getTargetRotation(this);
    }

    public /* synthetic */ int getTargetRotation(int i) {
        return ImageOutputConfig.CC.$default$getTargetRotation(this, i);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
        return UseCaseEventConfig.CC.$default$getUseCaseEventCallback(this);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        return UseCaseEventConfig.CC.$default$getUseCaseEventCallback(this, eventCallback);
    }

    public /* synthetic */ boolean hasTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$hasTargetAspectRatio(this);
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

    public PreviewConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public ImageInfoProcessor getImageInfoProcessor(ImageInfoProcessor imageInfoProcessor) {
        return (ImageInfoProcessor) retrieveOption(IMAGE_INFO_PROCESSOR, imageInfoProcessor);
    }

    /* access modifiers changed from: package-private */
    public ImageInfoProcessor getImageInfoProcessor() {
        return (ImageInfoProcessor) retrieveOption(IMAGE_INFO_PROCESSOR);
    }

    public CaptureProcessor getCaptureProcessor(CaptureProcessor captureProcessor) {
        return (CaptureProcessor) retrieveOption(OPTION_PREVIEW_CAPTURE_PROCESSOR, captureProcessor);
    }

    public CaptureProcessor getCaptureProcessor() {
        return (CaptureProcessor) retrieveOption(OPTION_PREVIEW_CAPTURE_PROCESSOR);
    }

    public int getInputFormat() {
        return ((Integer) retrieveOption(OPTION_INPUT_FORMAT)).intValue();
    }
}
