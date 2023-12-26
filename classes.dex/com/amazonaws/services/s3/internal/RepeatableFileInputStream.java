package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RepeatableFileInputStream extends SdkInputStream {
    private static final Log log = LogFactory.getLog("RepeatableFIS");
    private long bytesReadPastMarkPoint = 0;
    private final File file;
    private FileInputStream fis = null;
    private long markPoint = 0;

    public boolean markSupported() {
        return true;
    }

    public RepeatableFileInputStream(File file2) throws FileNotFoundException {
        if (file2 != null) {
            this.fis = new FileInputStream(file2);
            this.file = file2;
            return;
        }
        throw new IllegalArgumentException("File cannot be null");
    }

    public File getFile() {
        return this.file;
    }

    public void reset() throws IOException {
        this.fis.close();
        abortIfNeeded();
        this.fis = new FileInputStream(this.file);
        long j = this.markPoint;
        while (j > 0) {
            j -= this.fis.skip(j);
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Reset to mark point " + this.markPoint + " after returning " + this.bytesReadPastMarkPoint + " bytes");
        }
        this.bytesReadPastMarkPoint = 0;
    }

    public void mark(int i) {
        abortIfNeeded();
        this.markPoint += this.bytesReadPastMarkPoint;
        this.bytesReadPastMarkPoint = 0;
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("Input stream marked at " + this.markPoint + " bytes");
        }
    }

    public int available() throws IOException {
        abortIfNeeded();
        return this.fis.available();
    }

    public void close() throws IOException {
        this.fis.close();
        abortIfNeeded();
    }

    public int read() throws IOException {
        abortIfNeeded();
        int read = this.fis.read();
        if (read == -1) {
            return -1;
        }
        this.bytesReadPastMarkPoint++;
        return read;
    }

    public long skip(long j) throws IOException {
        abortIfNeeded();
        long skip = this.fis.skip(j);
        this.bytesReadPastMarkPoint += skip;
        return skip;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        abortIfNeeded();
        int read = this.fis.read(bArr, i, i2);
        this.bytesReadPastMarkPoint += (long) read;
        return read;
    }

    public InputStream getWrappedInputStream() {
        return this.fis;
    }
}
