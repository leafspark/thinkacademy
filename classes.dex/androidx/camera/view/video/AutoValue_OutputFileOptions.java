package androidx.camera.view.video;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.view.video.OutputFileOptions;
import java.io.File;
import java.util.Objects;

final class AutoValue_OutputFileOptions extends OutputFileOptions {
    private final ContentResolver contentResolver;
    private final ContentValues contentValues;
    private final File file;
    private final ParcelFileDescriptor fileDescriptor;
    private final Metadata metadata;
    private final Uri saveCollection;

    private AutoValue_OutputFileOptions(File file2, ParcelFileDescriptor parcelFileDescriptor, ContentResolver contentResolver2, Uri uri, ContentValues contentValues2, Metadata metadata2) {
        this.file = file2;
        this.fileDescriptor = parcelFileDescriptor;
        this.contentResolver = contentResolver2;
        this.saveCollection = uri;
        this.contentValues = contentValues2;
        this.metadata = metadata2;
    }

    /* access modifiers changed from: package-private */
    public File getFile() {
        return this.file;
    }

    /* access modifiers changed from: package-private */
    public ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    /* access modifiers changed from: package-private */
    public ContentResolver getContentResolver() {
        return this.contentResolver;
    }

    /* access modifiers changed from: package-private */
    public Uri getSaveCollection() {
        return this.saveCollection;
    }

    /* access modifiers changed from: package-private */
    public ContentValues getContentValues() {
        return this.contentValues;
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return "OutputFileOptions{file=" + this.file + ", fileDescriptor=" + this.fileDescriptor + ", contentResolver=" + this.contentResolver + ", saveCollection=" + this.saveCollection + ", contentValues=" + this.contentValues + ", metadata=" + this.metadata + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputFileOptions)) {
            return false;
        }
        OutputFileOptions outputFileOptions = (OutputFileOptions) obj;
        File file2 = this.file;
        if (file2 != null ? file2.equals(outputFileOptions.getFile()) : outputFileOptions.getFile() == null) {
            ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
            if (parcelFileDescriptor != null ? parcelFileDescriptor.equals(outputFileOptions.getFileDescriptor()) : outputFileOptions.getFileDescriptor() == null) {
                ContentResolver contentResolver2 = this.contentResolver;
                if (contentResolver2 != null ? contentResolver2.equals(outputFileOptions.getContentResolver()) : outputFileOptions.getContentResolver() == null) {
                    Uri uri = this.saveCollection;
                    if (uri != null ? uri.equals(outputFileOptions.getSaveCollection()) : outputFileOptions.getSaveCollection() == null) {
                        ContentValues contentValues2 = this.contentValues;
                        if (contentValues2 != null ? contentValues2.equals(outputFileOptions.getContentValues()) : outputFileOptions.getContentValues() == null) {
                            if (this.metadata.equals(outputFileOptions.getMetadata())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        File file2 = this.file;
        int i = 0;
        int hashCode = ((file2 == null ? 0 : file2.hashCode()) ^ 1000003) * 1000003;
        ParcelFileDescriptor parcelFileDescriptor = this.fileDescriptor;
        int hashCode2 = (hashCode ^ (parcelFileDescriptor == null ? 0 : parcelFileDescriptor.hashCode())) * 1000003;
        ContentResolver contentResolver2 = this.contentResolver;
        int hashCode3 = (hashCode2 ^ (contentResolver2 == null ? 0 : contentResolver2.hashCode())) * 1000003;
        Uri uri = this.saveCollection;
        int hashCode4 = (hashCode3 ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        ContentValues contentValues2 = this.contentValues;
        if (contentValues2 != null) {
            i = contentValues2.hashCode();
        }
        return ((hashCode4 ^ i) * 1000003) ^ this.metadata.hashCode();
    }

    static final class Builder extends OutputFileOptions.Builder {
        private ContentResolver contentResolver;
        private ContentValues contentValues;
        private File file;
        private ParcelFileDescriptor fileDescriptor;
        private Metadata metadata;
        private Uri saveCollection;

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public OutputFileOptions.Builder setFile(File file2) {
            this.file = file2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OutputFileOptions.Builder setFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
            this.fileDescriptor = parcelFileDescriptor;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OutputFileOptions.Builder setContentResolver(ContentResolver contentResolver2) {
            this.contentResolver = contentResolver2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OutputFileOptions.Builder setSaveCollection(Uri uri) {
            this.saveCollection = uri;
            return this;
        }

        /* access modifiers changed from: package-private */
        public OutputFileOptions.Builder setContentValues(ContentValues contentValues2) {
            this.contentValues = contentValues2;
            return this;
        }

        public OutputFileOptions.Builder setMetadata(Metadata metadata2) {
            Objects.requireNonNull(metadata2, "Null metadata");
            this.metadata = metadata2;
            return this;
        }

        public OutputFileOptions build() {
            String str = "";
            if (this.metadata == null) {
                str = str + " metadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_OutputFileOptions(this.file, this.fileDescriptor, this.contentResolver, this.saveCollection, this.contentValues, this.metadata);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}
