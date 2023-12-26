package org.apache.commons.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public interface FileItem extends FileItemHeadersSupport {
    void delete();

    byte[] get();

    String getContentType();

    String getFieldName();

    InputStream getInputStream() throws IOException;

    String getName();

    OutputStream getOutputStream() throws IOException;

    long getSize();

    String getString();

    String getString(String str) throws UnsupportedEncodingException;

    boolean isFormField();

    boolean isInMemory();

    void setFieldName(String str);

    void setFormField(boolean z);

    void write(File file) throws Exception;
}
