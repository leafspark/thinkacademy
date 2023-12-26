package androidx.camera.view.video;

import android.location.Location;
import androidx.camera.view.video.AutoValue_Metadata;

public abstract class Metadata {
    public abstract Location getLocation();

    public static Builder builder() {
        return new AutoValue_Metadata.Builder();
    }

    Metadata() {
    }

    public static abstract class Builder {
        public abstract Metadata build();

        public abstract Builder setLocation(Location location);

        Builder() {
        }
    }
}
