package org.apache.commons.fileupload;

import java.io.PrintStream;
import java.io.PrintWriter;

public class FileUploadException extends Exception {
    private static final long serialVersionUID = 8881893724388807504L;
    private final Throwable cause;

    public FileUploadException() {
        this((String) null, (Throwable) null);
    }

    public FileUploadException(String str) {
        this(str, (Throwable) null);
    }

    public FileUploadException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.cause != null) {
            printStream.println("Caused by:");
            this.cause.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.cause != null) {
            printWriter.println("Caused by:");
            this.cause.printStackTrace(printWriter);
        }
    }

    public Throwable getCause() {
        return this.cause;
    }
}
