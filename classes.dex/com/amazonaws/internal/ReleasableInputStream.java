package com.amazonaws.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.FileInputStream;
import java.io.InputStream;

public class ReleasableInputStream extends SdkFilterInputStream implements Releasable {
    private static final Log log = LogFactory.getLog((Class<?>) ReleasableInputStream.class);
    private boolean closeDisabled;

    protected ReleasableInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public final void close() {
        if (!this.closeDisabled) {
            doRelease();
        }
    }

    public final void release() {
        doRelease();
    }

    private void doRelease() {
        try {
            this.in.close();
        } catch (Exception e) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("FYI", e);
            }
        }
        if (this.in instanceof Releasable) {
            ((Releasable) this.in).release();
        }
        abortIfNeeded();
    }

    public final boolean isCloseDisabled() {
        return this.closeDisabled;
    }

    public final <T extends ReleasableInputStream> T disableClose() {
        this.closeDisabled = true;
        return this;
    }

    public static ReleasableInputStream wrap(InputStream inputStream) {
        if (inputStream instanceof ReleasableInputStream) {
            return (ReleasableInputStream) inputStream;
        }
        if (inputStream instanceof FileInputStream) {
            return ResettableInputStream.newResettableInputStream((FileInputStream) inputStream);
        }
        return new ReleasableInputStream(inputStream);
    }
}
