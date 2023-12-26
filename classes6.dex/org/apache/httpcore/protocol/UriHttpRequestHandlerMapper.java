package org.apache.httpcore.protocol;

import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.util.Args;

public class UriHttpRequestHandlerMapper implements HttpRequestHandlerMapper {
    private final UriPatternMatcher<HttpRequestHandler> matcher;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, org.apache.httpcore.protocol.UriPatternMatcher<org.apache.httpcore.protocol.HttpRequestHandler>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected UriHttpRequestHandlerMapper(org.apache.httpcore.protocol.UriPatternMatcher<org.apache.httpcore.protocol.HttpRequestHandler> r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "Pattern matcher"
            java.lang.Object r2 = org.apache.httpcore.util.Args.notNull(r2, r0)
            org.apache.httpcore.protocol.UriPatternMatcher r2 = (org.apache.httpcore.protocol.UriPatternMatcher) r2
            r1.matcher = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.protocol.UriHttpRequestHandlerMapper.<init>(org.apache.httpcore.protocol.UriPatternMatcher):void");
    }

    public UriHttpRequestHandlerMapper() {
        this(new UriPatternMatcher());
    }

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        Args.notNull(str, "Pattern");
        Args.notNull(httpRequestHandler, "Handler");
        this.matcher.register(str, httpRequestHandler);
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    /* access modifiers changed from: protected */
    public String getRequestPath(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        int indexOf = uri.indexOf(63);
        if (indexOf != -1) {
            return uri.substring(0, indexOf);
        }
        int indexOf2 = uri.indexOf(35);
        return indexOf2 != -1 ? uri.substring(0, indexOf2) : uri;
    }

    public HttpRequestHandler lookup(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return this.matcher.lookup(getRequestPath(httpRequest));
    }
}
