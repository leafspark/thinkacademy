package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.Objects;

final class AutoValue_SurfaceConfig extends SurfaceConfig {
    private final SurfaceConfig.ConfigSize configSize;
    private final SurfaceConfig.ConfigType configType;

    AutoValue_SurfaceConfig(SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2) {
        Objects.requireNonNull(configType2, "Null configType");
        this.configType = configType2;
        Objects.requireNonNull(configSize2, "Null configSize");
        this.configSize = configSize2;
    }

    public SurfaceConfig.ConfigType getConfigType() {
        return this.configType;
    }

    public SurfaceConfig.ConfigSize getConfigSize() {
        return this.configSize;
    }

    public String toString() {
        return "SurfaceConfig{configType=" + this.configType + ", configSize=" + this.configSize + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceConfig)) {
            return false;
        }
        SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
        if (!this.configType.equals(surfaceConfig.getConfigType()) || !this.configSize.equals(surfaceConfig.getConfigSize())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.configType.hashCode() ^ 1000003) * 1000003) ^ this.configSize.hashCode();
    }
}
