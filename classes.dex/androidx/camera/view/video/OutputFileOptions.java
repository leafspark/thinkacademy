package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.VideoCapture;
import androidx.camera.view.video.AutoValue_OutputFileOptions;
import androidx.core.util.Preconditions;
import java.io.File;

public abstract class OutputFileOptions {
    private static final Metadata EMPTY_METADATA = Metadata.builder().build();

    /* access modifiers changed from: package-private */
    public abstract ContentResolver getContentResolver();

    /* access modifiers changed from: package-private */
    public abstract ContentValues getContentValues();

    /* access modifiers changed from: package-private */
    public abstract File getFile();

    /* access modifiers changed from: package-private */
    public abstract ParcelFileDescriptor getFileDescriptor();

    public abstract Metadata getMetadata();

    /* access modifiers changed from: package-private */
    public abstract Uri getSaveCollection();

    OutputFileOptions() {
    }

    public static Builder builder(File file) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFile(file);
    }

    public static Builder builder(ParcelFileDescriptor parcelFileDescriptor) {
        Preconditions.checkArgument(Build.VERSION.SDK_INT >= 26, "Using a ParcelFileDescriptor to record a video is only supported for Android 8.0 or above.");
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setFileDescriptor(parcelFileDescriptor);
    }

    public static Builder builder(ContentResolver contentResolver, Uri uri, ContentValues contentValues) {
        return new AutoValue_OutputFileOptions.Builder().setMetadata(EMPTY_METADATA).setContentResolver(contentResolver).setSaveCollection(uri).setContentValues(contentValues);
    }

    private boolean isSavingToMediaStore() {
        return (getSaveCollection() == null || getContentResolver() == null || getContentValues() == null) ? false : true;
    }

    private boolean isSavingToFile() {
        return getFile() != null;
    }

    private boolean isSavingToFileDescriptor() {
        return getFileDescriptor() != null;
    }

    public VideoCapture.OutputFileOptions toVideoCaptureOutputFileOptions() {
        VideoCapture.OutputFileOptions.Builder builder;
        if (isSavingToFile()) {
            builder = new VideoCapture.OutputFileOptions.Builder((File) Preconditions.checkNotNull(getFile()));
        } else if (isSavingToFileDescriptor()) {
            builder = new VideoCapture.OutputFileOptions.Builder(((ParcelFileDescriptor) Preconditions.checkNotNull(getFileDescriptor())).getFileDescriptor());
        } else {
            Preconditions.checkState(isSavingToMediaStore());
            builder = new VideoCapture.OutputFileOptions.Builder((ContentResolver) Preconditions.checkNotNull(getContentResolver()), (Uri) Preconditions.checkNotNull(getSaveCollection()), (ContentValues) Preconditions.checkNotNull(getContentValues()));
        }
        VideoCapture.Metadata metadata = new VideoCapture.Metadata();
        metadata.location = getMetadata().getLocation();
        builder.setMetadata(metadata);
        return builder.build();
    }

    public static abstract class Builder {
        public abstract OutputFileOptions build();

        /* access modifiers changed from: package-private */
        public abstract Builder setContentResolver(ContentResolver contentResolver);

        /* access modifiers changed from: package-private */
        public abstract Builder setContentValues(ContentValues contentValues);

        /* access modifiers changed from: package-private */
        public abstract Builder setFile(File file);

        /* access modifiers changed from: package-private */
        public abstract Builder setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor);

        public abstract Builder setMetadata(Metadata metadata);

        /* access modifiers changed from: package-private */
        public abstract Builder setSaveCollection(Uri uri);

        Builder() {
        }
    }
}
