package org.apache.httpcore.protocol;

import java.io.IOException;
import org.apache.httpcore.ConnectionReuseStrategy;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpResponseFactory;
import org.apache.httpcore.HttpStatus;
import org.apache.httpcore.MethodNotSupportedException;
import org.apache.httpcore.ProtocolException;
import org.apache.httpcore.UnsupportedHttpVersionException;
import org.apache.httpcore.entity.ByteArrayEntity;
import org.apache.httpcore.impl.DefaultConnectionReuseStrategy;
import org.apache.httpcore.impl.DefaultHttpResponseFactory;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.EncodingUtils;

public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, (HttpRequestHandlerMapper) new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, (HttpRequestHandlerMapper) new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleRequest(org.apache.httpcore.HttpServerConnection r9, org.apache.httpcore.protocol.HttpContext r10) throws java.io.IOException, org.apache.httpcore.HttpException {
        /*
            r8 = this;
            java.lang.String r0 = "http.connection"
            r10.setAttribute(r0, r9)
            r0 = 500(0x1f4, float:7.0E-43)
            r1 = 0
            org.apache.httpcore.HttpRequest r2 = r9.receiveRequestHeader()     // Catch:{ HttpException -> 0x0083 }
            boolean r3 = r2 instanceof org.apache.httpcore.HttpEntityEnclosingRequest     // Catch:{ HttpException -> 0x0081 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 == 0) goto L_0x005b
            r3 = r2
            org.apache.httpcore.HttpEntityEnclosingRequest r3 = (org.apache.httpcore.HttpEntityEnclosingRequest) r3     // Catch:{ HttpException -> 0x0081 }
            boolean r3 = r3.expectContinue()     // Catch:{ HttpException -> 0x0081 }
            if (r3 == 0) goto L_0x0055
            org.apache.httpcore.HttpResponseFactory r3 = r8.responseFactory     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpVersion r5 = org.apache.httpcore.HttpVersion.HTTP_1_1     // Catch:{ HttpException -> 0x0081 }
            r6 = 100
            org.apache.httpcore.HttpResponse r3 = r3.newHttpResponse(r5, r6, r10)     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch:{ HttpException -> 0x0081 }
            if (r5 == 0) goto L_0x003c
            org.apache.httpcore.protocol.HttpExpectationVerifier r5 = r8.expectationVerifier     // Catch:{ HttpException -> 0x002f }
            r5.verify(r2, r3, r10)     // Catch:{ HttpException -> 0x002f }
            goto L_0x003c
        L_0x002f:
            r3 = move-exception
            org.apache.httpcore.HttpResponseFactory r5 = r8.responseFactory     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpVersion r6 = org.apache.httpcore.HttpVersion.HTTP_1_0     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpResponse r5 = r5.newHttpResponse(r6, r0, r10)     // Catch:{ HttpException -> 0x0081 }
            r8.handleException(r3, r5)     // Catch:{ HttpException -> 0x0081 }
            r3 = r5
        L_0x003c:
            org.apache.httpcore.StatusLine r5 = r3.getStatusLine()     // Catch:{ HttpException -> 0x0081 }
            int r5 = r5.getStatusCode()     // Catch:{ HttpException -> 0x0081 }
            if (r5 >= r4) goto L_0x0053
            r9.sendResponseHeader(r3)     // Catch:{ HttpException -> 0x0081 }
            r9.flush()     // Catch:{ HttpException -> 0x0081 }
            r3 = r2
            org.apache.httpcore.HttpEntityEnclosingRequest r3 = (org.apache.httpcore.HttpEntityEnclosingRequest) r3     // Catch:{ HttpException -> 0x0081 }
            r9.receiveRequestEntity(r3)     // Catch:{ HttpException -> 0x0081 }
            goto L_0x005b
        L_0x0053:
            r1 = r3
            goto L_0x005b
        L_0x0055:
            r3 = r2
            org.apache.httpcore.HttpEntityEnclosingRequest r3 = (org.apache.httpcore.HttpEntityEnclosingRequest) r3     // Catch:{ HttpException -> 0x0081 }
            r9.receiveRequestEntity(r3)     // Catch:{ HttpException -> 0x0081 }
        L_0x005b:
            java.lang.String r3 = "http.request"
            r10.setAttribute(r3, r2)     // Catch:{ HttpException -> 0x0081 }
            if (r1 != 0) goto L_0x0072
            org.apache.httpcore.HttpResponseFactory r1 = r8.responseFactory     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpVersion r3 = org.apache.httpcore.HttpVersion.HTTP_1_1     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpResponse r1 = r1.newHttpResponse(r3, r4, r10)     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.protocol.HttpProcessor r3 = r8.processor     // Catch:{ HttpException -> 0x0081 }
            r3.process(r2, r10)     // Catch:{ HttpException -> 0x0081 }
            r8.doService(r2, r1, r10)     // Catch:{ HttpException -> 0x0081 }
        L_0x0072:
            boolean r3 = r2 instanceof org.apache.httpcore.HttpEntityEnclosingRequest     // Catch:{ HttpException -> 0x0081 }
            if (r3 == 0) goto L_0x0093
            r3 = r2
            org.apache.httpcore.HttpEntityEnclosingRequest r3 = (org.apache.httpcore.HttpEntityEnclosingRequest) r3     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.HttpEntity r3 = r3.getEntity()     // Catch:{ HttpException -> 0x0081 }
            org.apache.httpcore.util.EntityUtils.consume(r3)     // Catch:{ HttpException -> 0x0081 }
            goto L_0x0093
        L_0x0081:
            r1 = move-exception
            goto L_0x0087
        L_0x0083:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
        L_0x0087:
            org.apache.httpcore.HttpResponseFactory r3 = r8.responseFactory
            org.apache.httpcore.HttpVersion r4 = org.apache.httpcore.HttpVersion.HTTP_1_0
            org.apache.httpcore.HttpResponse r0 = r3.newHttpResponse(r4, r0, r10)
            r8.handleException(r1, r0)
            r1 = r0
        L_0x0093:
            java.lang.String r0 = "http.response"
            r10.setAttribute(r0, r1)
            org.apache.httpcore.protocol.HttpProcessor r0 = r8.processor
            r0.process(r1, r10)
            r9.sendResponseHeader(r1)
            boolean r0 = r8.canResponseHaveBody(r2, r1)
            if (r0 == 0) goto L_0x00a9
            r9.sendResponseEntity(r1)
        L_0x00a9:
            r9.flush()
            org.apache.httpcore.ConnectionReuseStrategy r0 = r8.connStrategy
            boolean r10 = r0.keepAlive(r1, r10)
            if (r10 != 0) goto L_0x00b7
            r9.close()
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.protocol.HttpService.handleRequest(org.apache.httpcore.HttpServerConnection, org.apache.httpcore.protocol.HttpContext):void");
    }

    private boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        int statusCode;
        if ((httpRequest != null && "HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) || (statusCode = httpResponse.getStatusLine().getStatusCode()) < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* access modifiers changed from: protected */
    public void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler lookup = this.handlerMapper != null ? this.handlerMapper.lookup(httpRequest) : null;
        if (lookup != null) {
            lookup.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        }
    }

    @Deprecated
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }
}
