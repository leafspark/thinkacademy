package org.bouncycastle.crypto;

import org.apache.httpcore.protocol.HTTP;

public enum PasswordConverter implements CharToByteConverter {
    ASCII {
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(cArr);
        }

        public String getType() {
            return HTTP.ASCII;
        }
    },
    UTF8 {
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(cArr);
        }

        public String getType() {
            return "UTF8";
        }
    },
    PKCS12 {
        public byte[] convert(char[] cArr) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        }

        public String getType() {
            return "PKCS12";
        }
    }
}
