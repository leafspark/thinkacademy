package com.yanzhenjie.andserver;

import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.server.ProxyServer;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.IOUtils;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderIterator;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.entity.StringEntity;
import org.apache.httpcore.impl.DefaultBHttpClientConnection;
import org.apache.httpcore.impl.DefaultConnectionReuseStrategy;
import org.apache.httpcore.protocol.HttpContext;
import org.apache.httpcore.protocol.HttpProcessor;
import org.apache.httpcore.protocol.HttpRequestExecutor;
import org.apache.httpcore.protocol.HttpRequestHandler;
import org.apache.httpcore.protocol.ImmutableHttpProcessor;
import org.apache.httpcore.protocol.RequestConnControl;
import org.apache.httpcore.protocol.RequestContent;
import org.apache.httpcore.protocol.RequestExpectContinue;
import org.apache.httpcore.protocol.RequestTargetHost;
import org.apache.httpcore.protocol.RequestUserAgent;

public class ProxyHandler implements HttpRequestHandler {
    private static final int BUFFER = 8192;
    private static final Set<String> HOP_BY_HOP = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{HttpHeaders.HOST.toLowerCase(Locale.ROOT), HttpHeaders.CONTENT_LENGTH.toLowerCase(Locale.ROOT), HttpHeaders.TRANSFER_ENCODING.toLowerCase(Locale.ROOT), HttpHeaders.CONNECTION.toLowerCase(Locale.ROOT), HttpHeaders.PROXY_AUTHENTICATE.toLowerCase(Locale.ROOT), HttpHeaders.TE.toLowerCase(Locale.ROOT), HttpHeaders.TRAILER.toLowerCase(Locale.ROOT), HttpHeaders.UPGRADE.toLowerCase(Locale.ROOT)})));
    private final Map<String, HttpHost> mHostList;
    private final HttpRequestExecutor mHttpExecutor = new HttpRequestExecutor();
    private final HttpProcessor mRequestProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestContent(), new RequestTargetHost(), new RequestConnControl(), new RequestUserAgent(AndServer.INFO), new RequestExpectContinue(true)});
    private final SSLSocketFactory mSocketFactory = ((SSLSocketFactory) SSLSocketFactory.getDefault());

    public ProxyHandler(Map<String, HttpHost> map) {
        this.mHostList = map;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpHost httpHost = this.mHostList.get(HttpHost.create(httpRequest.getFirstHeader(HttpHeaders.HOST).getValue()).getHostName().toLowerCase(Locale.ROOT));
        if (httpHost == null) {
            NotFoundException notFoundException = new NotFoundException(httpRequest.getRequestLine().getUri());
            httpResponse.setStatusCode(notFoundException.getStatusCode());
            httpResponse.setEntity(new StringEntity(notFoundException.getMessage()));
            return;
        }
        HeaderIterator headerIterator = httpRequest.headerIterator();
        while (headerIterator.hasNext()) {
            String name = ((Header) headerIterator.next()).getName();
            if (HOP_BY_HOP.contains(name.toLowerCase(Locale.ROOT))) {
                httpRequest.removeHeaders(name);
            }
        }
        DefaultBHttpClientConnection defaultBHttpClientConnection = (DefaultBHttpClientConnection) httpContext.getAttribute(ProxyServer.PROXY_CONN_CLIENT);
        if (!defaultBHttpClientConnection.isOpen() || defaultBHttpClientConnection.isStale()) {
            defaultBHttpClientConnection.bind(createSocket(httpHost));
        }
        httpContext.setAttribute("http.connection", defaultBHttpClientConnection);
        httpContext.setAttribute("http.target_host", httpHost);
        this.mHttpExecutor.preProcess(httpRequest, this.mRequestProcessor, httpContext);
        HttpResponse execute = this.mHttpExecutor.execute(httpRequest, defaultBHttpClientConnection, httpContext);
        this.mHttpExecutor.postProcess(httpResponse, this.mRequestProcessor, httpContext);
        HeaderIterator headerIterator2 = execute.headerIterator();
        while (headerIterator2.hasNext()) {
            String name2 = ((Header) headerIterator2.next()).getName();
            if (HOP_BY_HOP.contains(name2.toLowerCase(Locale.ROOT))) {
                execute.removeHeaders(name2);
            }
        }
        httpResponse.setStatusLine(execute.getStatusLine());
        httpResponse.setHeaders(execute.getAllHeaders());
        httpResponse.setEntity(execute.getEntity());
        httpContext.setAttribute(ProxyServer.PROXY_CONN_ALIVE, Boolean.valueOf(DefaultConnectionReuseStrategy.INSTANCE.keepAlive(httpResponse, httpContext)));
    }

    private Socket createSocket(HttpHost httpHost) throws IOException {
        Socket socket = new Socket();
        socket.setSoTimeout(60000);
        socket.setReuseAddress(true);
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        socket.setReceiveBufferSize(8192);
        socket.setSendBufferSize(8192);
        socket.setSoLinger(true, 0);
        String schemeName = httpHost.getSchemeName();
        String hostName = httpHost.getHostName();
        int port = httpHost.getPort();
        socket.connect(resolveAddress(schemeName, hostName, port), 10000);
        if (!"https".equalsIgnoreCase(schemeName)) {
            return socket;
        }
        SSLSocket sSLSocket = (SSLSocket) this.mSocketFactory.createSocket(socket, hostName, port, true);
        try {
            sSLSocket.startHandshake();
            if (sSLSocket.getSession() != null) {
                return sSLSocket;
            }
            throw new SSLHandshakeException("SSL session not available.");
        } catch (IOException e) {
            IOUtils.closeQuietly(sSLSocket);
            throw e;
        }
    }

    private InetSocketAddress resolveAddress(String str, String str2, int i) {
        if (i < 0) {
            if ("http".equalsIgnoreCase(str)) {
                i = 80;
            } else if ("https".equalsIgnoreCase(str)) {
                i = 443;
            }
        }
        return new InetSocketAddress(str2, i);
    }
}
