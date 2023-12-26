package com.linkedin.android.litr.exception;

import android.net.Uri;

public class MediaSourceException extends MediaTransformationException {
    private static final String DATA_SOURCE_ERROR_TEXT = "data source error";
    private static final String MEDIA_EXTRACTOR_CREATION_ERROR_TEXT = "Failed to create media source due to a ";
    private final Error error;
    private final Uri inputUri;

    public MediaSourceException(Error error2, Uri uri, Throwable th) {
        super(th);
        this.error = error2;
        this.inputUri = uri;
    }

    public enum Error {
        DATA_SOURCE(MediaSourceException.DATA_SOURCE_ERROR_TEXT);
        
        /* access modifiers changed from: private */
        public final String text;

        private Error(String str) {
            this.text = str;
        }
    }

    public Error getError() {
        return this.error;
    }

    public String getMessage() {
        return MEDIA_EXTRACTOR_CREATION_ERROR_TEXT + this.error.text;
    }

    public String toString() {
        return super.toString() + 10 + MEDIA_EXTRACTOR_CREATION_ERROR_TEXT + this.error.text + 10 + "Uri: " + this.inputUri;
    }
}
