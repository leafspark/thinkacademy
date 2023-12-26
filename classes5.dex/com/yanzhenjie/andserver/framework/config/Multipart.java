package com.yanzhenjie.andserver.framework.config;

import java.io.File;

public class Multipart {
    private final long allFileMaxSize;
    private final long fileMaxSize;
    private final int maxInMemorySize;
    private final File uploadTempDir;

    public static Builder newBuilder() {
        return new Builder();
    }

    private Multipart(Builder builder) {
        this.allFileMaxSize = builder.allFileMaxSize;
        this.fileMaxSize = builder.fileMaxSize;
        this.maxInMemorySize = builder.maxInMemorySize;
        this.uploadTempDir = builder.uploadTempDir;
    }

    public long getAllFileMaxSize() {
        return this.allFileMaxSize;
    }

    public long getFileMaxSize() {
        return this.fileMaxSize;
    }

    public int getMaxInMemorySize() {
        return this.maxInMemorySize;
    }

    public File getUploadTempDir() {
        return this.uploadTempDir;
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public long allFileMaxSize;
        /* access modifiers changed from: private */
        public long fileMaxSize;
        /* access modifiers changed from: private */
        public int maxInMemorySize;
        /* access modifiers changed from: private */
        public File uploadTempDir;

        private Builder() {
        }

        public Builder allFileMaxSize(long j) {
            this.allFileMaxSize = j;
            return this;
        }

        public Builder fileMaxSize(long j) {
            this.fileMaxSize = j;
            return this;
        }

        public Builder maxInMemorySize(int i) {
            this.maxInMemorySize = i;
            return this;
        }

        public Builder uploadTempDir(File file) {
            this.uploadTempDir = file;
            return this;
        }

        public Multipart build() {
            return new Multipart(this);
        }
    }
}
