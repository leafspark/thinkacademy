package androidx.camera.core;

import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

abstract class ImmutableImageInfo implements ImageInfo {
    public abstract int getRotationDegrees();

    public abstract TagBundle getTagBundle();

    public abstract long getTimestamp();

    ImmutableImageInfo() {
    }

    public static ImageInfo create(TagBundle tagBundle, long j, int i) {
        return new AutoValue_ImmutableImageInfo(tagBundle, j, i);
    }

    public void populateExifData(ExifData.Builder builder) {
        builder.setOrientationDegrees(getRotationDegrees());
    }
}
