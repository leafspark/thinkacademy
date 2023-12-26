package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

public class HttpRequest {
    private final InputStream content;
    private final Map<String, String> headers;
    private boolean isStreaming;
    private final String method;
    private URI uri;

    public HttpRequest(String str, URI uri2) {
        this(str, uri2, (Map<String, String>) null, (InputStream) null);
    }

    public HttpRequest(String str, URI uri2, Map<String, String> map, InputStream inputStream) {
        Map<String, String> map2;
        this.method = StringUtils.upperCase(str);
        this.uri = uri2;
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        } else {
            map2 = Collections.unmodifiableMap(map);
        }
        this.headers = map2;
        this.content = inputStream;
    }

    public String getMethod() {
        return this.method;
    }

    public URI getUri() {
        return this.uri;
    }

    /* access modifiers changed from: package-private */
    public void setUri(URI uri2) {
        this.uri = uri2;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        String str;
        Map<String, String> map = this.headers;
        if (map == null || (str = map.get("Content-Length")) == null || str.isEmpty()) {
            return 0;
        }
        return Long.valueOf(str).longValue();
    }

    public boolean isStreaming() {
        return this.isStreaming;
    }

    public void setStreaming(boolean z) {
        this.isStreaming = z;
    }
}
