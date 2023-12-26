package androidx.camera.core.impl;

import java.util.Objects;

final class AutoValue_DeviceProperties extends DeviceProperties {
    private final String manufacturer;
    private final String model;
    private final int sdkVersion;

    AutoValue_DeviceProperties(String str, String str2, int i) {
        Objects.requireNonNull(str, "Null manufacturer");
        this.manufacturer = str;
        Objects.requireNonNull(str2, "Null model");
        this.model = str2;
        this.sdkVersion = i;
    }

    public String manufacturer() {
        return this.manufacturer;
    }

    public String model() {
        return this.model;
    }

    public int sdkVersion() {
        return this.sdkVersion;
    }

    public String toString() {
        return "DeviceProperties{manufacturer=" + this.manufacturer + ", model=" + this.model + ", sdkVersion=" + this.sdkVersion + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceProperties)) {
            return false;
        }
        DeviceProperties deviceProperties = (DeviceProperties) obj;
        if (!this.manufacturer.equals(deviceProperties.manufacturer()) || !this.model.equals(deviceProperties.model()) || this.sdkVersion != deviceProperties.sdkVersion()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.manufacturer.hashCode() ^ 1000003) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.sdkVersion;
    }
}
