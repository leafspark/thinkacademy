package com.amazonaws.util;

public enum EncodingSchemeEnum implements EncodingScheme {
    BASE16 {
        public String encodeAsString(byte[] bArr) {
            return Base16.encodeAsString(bArr);
        }

        public byte[] decode(String str) {
            return Base16.decode(str);
        }
    },
    BASE32 {
        public String encodeAsString(byte[] bArr) {
            return Base32.encodeAsString(bArr);
        }

        public byte[] decode(String str) {
            return Base32.decode(str);
        }
    },
    BASE64 {
        public String encodeAsString(byte[] bArr) {
            return Base64.encodeAsString(bArr);
        }

        public byte[] decode(String str) {
            return Base64.decode(str);
        }
    };

    public abstract String encodeAsString(byte[] bArr);
}
