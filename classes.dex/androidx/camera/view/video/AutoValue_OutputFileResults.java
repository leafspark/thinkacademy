package androidx.camera.view.video;

import android.net.Uri;

final class AutoValue_OutputFileResults extends OutputFileResults {
    private final Uri savedUri;

    AutoValue_OutputFileResults(Uri uri) {
        this.savedUri = uri;
    }

    public Uri getSavedUri() {
        return this.savedUri;
    }

    public String toString() {
        return "OutputFileResults{savedUri=" + this.savedUri + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OutputFileResults)) {
            return false;
        }
        Uri uri = this.savedUri;
        Uri savedUri2 = ((OutputFileResults) obj).getSavedUri();
        if (uri != null) {
            return uri.equals(savedUri2);
        }
        if (savedUri2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Uri uri = this.savedUri;
        return (uri == null ? 0 : uri.hashCode()) ^ 1000003;
    }
}
