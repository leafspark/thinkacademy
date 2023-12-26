package com.amazonaws.auth;

import androidx.exifinterface.media.ExifInterface;

public enum SignatureVersion {
    V1("1"),
    V2(ExifInterface.GPS_MEASUREMENT_2D);
    
    private String value;

    private SignatureVersion(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }
}
