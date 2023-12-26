package org.apache.commons.fileupload;

import java.util.Iterator;

public interface FileItemHeaders {
    String getHeader(String str);

    Iterator<String> getHeaderNames();

    Iterator<String> getHeaders(String str);
}
