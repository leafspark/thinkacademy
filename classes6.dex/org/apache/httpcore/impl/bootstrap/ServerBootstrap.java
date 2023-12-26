package org.apache.httpcore.impl.bootstrap;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import org.apache.httpcore.ConnectionReuseStrategy;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.HttpRequestInterceptor;
import org.apache.httpcore.HttpResponseFactory;
import org.apache.httpcore.HttpResponseInterceptor;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.impl.DefaultBHttpServerConnection;
import org.apache.httpcore.impl.DefaultBHttpServerConnectionFactory;
import org.apache.httpcore.impl.DefaultConnectionReuseStrategy;
import org.apache.httpcore.impl.DefaultHttpResponseFactory;
import org.apache.httpcore.protocol.HttpExpectationVerifier;
import org.apache.httpcore.protocol.HttpProcessor;
import org.apache.httpcore.protocol.HttpProcessorBuilder;
import org.apache.httpcore.protocol.HttpRequestHandler;
import org.apache.httpcore.protocol.HttpRequestHandlerMapper;
import org.apache.httpcore.protocol.HttpService;
import org.apache.httpcore.protocol.ResponseConnControl;
import org.apache.httpcore.protocol.ResponseContent;
import org.apache.httpcore.protocol.ResponseDate;
import org.apache.httpcore.protocol.ResponseServer;
import org.apache.httpcore.protocol.UriHttpRequestHandlerMapper;

public class ServerBootstrap {
    private ConnectionReuseStrategy connStrategy;
    private ConnectionConfig connectionConfig;
    private HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private ExceptionLogger exceptionLogger;
    private HttpExpectationVerifier expectationVerifier;
    private Map<String, HttpRequestHandler> handlerMap;
    private HttpRequestHandlerMapper handlerMapper;
    private HttpProcessor httpProcessor;
    private int listenerPort;
    private InetAddress localAddress;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private HttpResponseFactory responseFactory;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private String serverInfo;
    private ServerSocketFactory serverSocketFactory;
    private SocketConfig socketConfig;
    private SSLContext sslContext;
    private SSLServerSetupHandler sslSetupHandler;

    private ServerBootstrap() {
    }

    public static ServerBootstrap bootstrap() {
        return new ServerBootstrap();
    }

    public final ServerBootstrap setListenerPort(int i) {
        this.listenerPort = i;
        return this;
    }

    public final ServerBootstrap setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
        return this;
    }

    public final ServerBootstrap setSocketConfig(SocketConfig socketConfig2) {
        this.socketConfig = socketConfig2;
        return this;
    }

    public final ServerBootstrap setConnectionConfig(ConnectionConfig connectionConfig2) {
        this.connectionConfig = connectionConfig2;
        return this;
    }

    public final ServerBootstrap setHttpProcessor(HttpProcessor httpProcessor2) {
        this.httpProcessor = httpProcessor2;
        return this;
    }

    public final ServerBootstrap addInterceptorFirst(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseFirst == null) {
            this.responseFirst = new LinkedList<>();
        }
        this.responseFirst.addFirst(httpResponseInterceptor);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return this;
        }
        if (this.responseLast == null) {
            this.responseLast = new LinkedList<>();
        }
        this.responseLast.addLast(httpResponseInterceptor);
        return this;
    }

    public final ServerBootstrap addInterceptorFirst(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestFirst == null) {
            this.requestFirst = new LinkedList<>();
        }
        this.requestFirst.addFirst(httpRequestInterceptor);
        return this;
    }

    public final ServerBootstrap addInterceptorLast(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return this;
        }
        if (this.requestLast == null) {
            this.requestLast = new LinkedList<>();
        }
        this.requestLast.addLast(httpRequestInterceptor);
        return this;
    }

    public final ServerBootstrap setServerInfo(String str) {
        this.serverInfo = str;
        return this;
    }

    public final ServerBootstrap setConnectionReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.connStrategy = connectionReuseStrategy;
        return this;
    }

    public final ServerBootstrap setResponseFactory(HttpResponseFactory httpResponseFactory) {
        this.responseFactory = httpResponseFactory;
        return this;
    }

    public final ServerBootstrap setHandlerMapper(HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this.handlerMapper = httpRequestHandlerMapper;
        return this;
    }

    public final ServerBootstrap registerHandler(String str, HttpRequestHandler httpRequestHandler) {
        if (!(str == null || httpRequestHandler == null)) {
            if (this.handlerMap == null) {
                this.handlerMap = new HashMap();
            }
            this.handlerMap.put(str, httpRequestHandler);
        }
        return this;
    }

    public final ServerBootstrap setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
        return this;
    }

    public final ServerBootstrap setConnectionFactory(HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory) {
        this.connectionFactory = httpConnectionFactory;
        return this;
    }

    public final ServerBootstrap setSslSetupHandler(SSLServerSetupHandler sSLServerSetupHandler) {
        this.sslSetupHandler = sSLServerSetupHandler;
        return this;
    }

    public final ServerBootstrap setServerSocketFactory(ServerSocketFactory serverSocketFactory2) {
        this.serverSocketFactory = serverSocketFactory2;
        return this;
    }

    public final ServerBootstrap setSslContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
        return this;
    }

    public final ServerBootstrap setExceptionLogger(ExceptionLogger exceptionLogger2) {
        this.exceptionLogger = exceptionLogger2;
        return this;
    }

    public HttpServer create() {
        HttpProcessor httpProcessor2 = this.httpProcessor;
        if (httpProcessor2 == null) {
            HttpProcessorBuilder create = HttpProcessorBuilder.create();
            LinkedList<HttpRequestInterceptor> linkedList = this.requestFirst;
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    create.addFirst((HttpRequestInterceptor) it.next());
                }
            }
            LinkedList<HttpResponseInterceptor> linkedList2 = this.responseFirst;
            if (linkedList2 != null) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    create.addFirst((HttpResponseInterceptor) it2.next());
                }
            }
            String str = this.serverInfo;
            if (str == null) {
                str = "Apache-HttpCore/1.1";
            }
            create.addAll(new ResponseDate(), new ResponseServer(str), new ResponseContent(), new ResponseConnControl());
            LinkedList<HttpRequestInterceptor> linkedList3 = this.requestLast;
            if (linkedList3 != null) {
                Iterator it3 = linkedList3.iterator();
                while (it3.hasNext()) {
                    create.addLast((HttpRequestInterceptor) it3.next());
                }
            }
            LinkedList<HttpResponseInterceptor> linkedList4 = this.responseLast;
            if (linkedList4 != null) {
                Iterator it4 = linkedList4.iterator();
                while (it4.hasNext()) {
                    create.addLast((HttpResponseInterceptor) it4.next());
                }
            }
            httpProcessor2 = create.build();
        }
        HttpProcessor httpProcessor3 = httpProcessor2;
        HttpRequestHandlerMapper httpRequestHandlerMapper = this.handlerMapper;
        UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper = httpRequestHandlerMapper;
        if (httpRequestHandlerMapper == null) {
            UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper2 = new UriHttpRequestHandlerMapper();
            Map<String, HttpRequestHandler> map = this.handlerMap;
            uriHttpRequestHandlerMapper = uriHttpRequestHandlerMapper2;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    uriHttpRequestHandlerMapper2.register((String) next.getKey(), (HttpRequestHandler) next.getValue());
                }
                uriHttpRequestHandlerMapper = uriHttpRequestHandlerMapper2;
            }
        }
        HttpRequestHandlerMapper httpRequestHandlerMapper2 = uriHttpRequestHandlerMapper;
        ConnectionReuseStrategy connectionReuseStrategy = this.connStrategy;
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        ConnectionReuseStrategy connectionReuseStrategy2 = connectionReuseStrategy;
        HttpResponseFactory httpResponseFactory = this.responseFactory;
        if (httpResponseFactory == null) {
            httpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
        }
        HttpService httpService = new HttpService(httpProcessor3, connectionReuseStrategy2, httpResponseFactory, httpRequestHandlerMapper2, this.expectationVerifier);
        ServerSocketFactory serverSocketFactory2 = this.serverSocketFactory;
        if (serverSocketFactory2 == null) {
            SSLContext sSLContext = this.sslContext;
            if (sSLContext != null) {
                serverSocketFactory2 = sSLContext.getServerSocketFactory();
            } else {
                serverSocketFactory2 = ServerSocketFactory.getDefault();
            }
        }
        ServerSocketFactory serverSocketFactory3 = serverSocketFactory2;
        HttpConnectionFactory httpConnectionFactory = this.connectionFactory;
        if (httpConnectionFactory == null) {
            if (this.connectionConfig != null) {
                httpConnectionFactory = new DefaultBHttpServerConnectionFactory(this.connectionConfig);
            } else {
                httpConnectionFactory = DefaultBHttpServerConnectionFactory.INSTANCE;
            }
        }
        HttpConnectionFactory httpConnectionFactory2 = httpConnectionFactory;
        ExceptionLogger exceptionLogger2 = this.exceptionLogger;
        if (exceptionLogger2 == null) {
            exceptionLogger2 = ExceptionLogger.NO_OP;
        }
        ExceptionLogger exceptionLogger3 = exceptionLogger2;
        int max = Math.max(this.listenerPort, 0);
        InetAddress inetAddress = this.localAddress;
        SocketConfig socketConfig2 = this.socketConfig;
        if (socketConfig2 == null) {
            socketConfig2 = SocketConfig.DEFAULT;
        }
        return new HttpServer(max, inetAddress, socketConfig2, serverSocketFactory3, httpService, httpConnectionFactory2, this.sslSetupHandler, exceptionLogger3);
    }
}
