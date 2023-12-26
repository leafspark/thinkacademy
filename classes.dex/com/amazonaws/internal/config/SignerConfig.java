package com.amazonaws.internal.config;

public class SignerConfig {
    private final String signerType;

    SignerConfig(String str) {
        this.signerType = str;
    }

    SignerConfig(SignerConfig signerConfig) {
        this.signerType = signerConfig.getSignerType();
    }

    public String getSignerType() {
        return this.signerType;
    }

    public String toString() {
        return this.signerType;
    }
}
