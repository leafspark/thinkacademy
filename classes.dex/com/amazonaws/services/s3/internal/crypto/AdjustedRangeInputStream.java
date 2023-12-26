package com.amazonaws.services.s3.internal.crypto;

import androidx.appcompat.widget.ActivityChooserView;
import com.amazonaws.internal.SdkInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AdjustedRangeInputStream extends SdkInputStream {
    private boolean closed = false;
    private InputStream decryptedContents;
    private long virtualAvailable;

    public AdjustedRangeInputStream(InputStream inputStream, long j, long j2) throws IOException {
        this.decryptedContents = inputStream;
        initializeForRead(j, j2);
    }

    private void initializeForRead(long j, long j2) throws IOException {
        int i = j < 16 ? (int) j : ((int) (j % 16)) + 16;
        if (i != 0) {
            while (i > 0) {
                this.decryptedContents.read();
                i--;
            }
        }
        this.virtualAvailable = (j2 - j) + 1;
    }

    public int read() throws IOException {
        int i;
        abortIfNeeded();
        if (this.virtualAvailable <= 0) {
            i = -1;
        } else {
            i = this.decryptedContents.read();
        }
        if (i != -1) {
            this.virtualAvailable--;
        } else {
            close();
            this.virtualAvailable = 0;
        }
        return i;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        abortIfNeeded();
        long j = this.virtualAvailable;
        if (j <= 0) {
            i3 = -1;
        } else {
            if (((long) i2) > j) {
                i2 = j < 2147483647L ? (int) j : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            i3 = this.decryptedContents.read(bArr, i, i2);
        }
        if (i3 != -1) {
            this.virtualAvailable -= (long) i3;
        } else {
            close();
            this.virtualAvailable = 0;
        }
        return i3;
    }

    public int available() throws IOException {
        abortIfNeeded();
        int available = this.decryptedContents.available();
        long j = this.virtualAvailable;
        return ((long) available) < j ? available : (int) j;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.decryptedContents.close();
        }
        abortIfNeeded();
    }

    /* access modifiers changed from: protected */
    public InputStream getWrappedInputStream() {
        return this.decryptedContents;
    }
}
