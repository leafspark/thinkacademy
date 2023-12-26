package com.yanzhenjie.andserver.server;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.ProxyHandler;
import com.yanzhenjie.andserver.SSLSocketInitializer;
import com.yanzhenjie.andserver.Server;
import com.yanzhenjie.andserver.server.BasicServer;
import com.yanzhenjie.andserver.util.Executors;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.HttpResponseInterceptor;
import org.apache.httpcore.impl.DefaultBHttpClientConnection;
import org.apache.httpcore.impl.DefaultBHttpServerConnection;
import org.apache.httpcore.protocol.HttpRequestHandler;
import org.apache.httpcore.protocol.HttpService;
import org.apache.httpcore.protocol.ImmutableHttpProcessor;
import org.apache.httpcore.protocol.ResponseConnControl;
import org.apache.httpcore.protocol.ResponseContent;
import org.apache.httpcore.protocol.ResponseDate;
import org.apache.httpcore.protocol.ResponseServer;
import org.apache.httpcore.protocol.UriHttpRequestHandlerMapper;

public class ProxyServer extends BasicServer<Builder> {
    public static final String PROXY_CONN_ALIVE = "http.proxy.conn.alive";
    public static final String PROXY_CONN_CLIENT = "http.proxy.conn.client";
    /* access modifiers changed from: private */
    public boolean isRunning;
    private Map<String, HttpHost> mHostList;
    /* access modifiers changed from: private */
    public HttpServer mHttpServer;
    /* access modifiers changed from: private */
    public final InetAddress mInetAddress;
    /* access modifiers changed from: private */
    public final Server.ServerListener mListener;
    /* access modifiers changed from: private */
    public final int mPort;
    /* access modifiers changed from: private */
    public final SSLContext mSSLContext;
    /* access modifiers changed from: private */
    public final SSLSocketInitializer mSSLSocketInitializer;
    /* access modifiers changed from: private */
    public final ServerSocketFactory mSocketFactory;
    /* access modifiers changed from: private */
    public final int mTimeout;

    public static Builder newBuilder() {
        return new Builder();
    }

    private ProxyServer(Builder builder) {
        super(builder);
        this.mInetAddress = builder.inetAddress;
        this.mPort = builder.port;
        this.mTimeout = builder.timeout;
        this.mSocketFactory = builder.mSocketFactory;
        this.mSSLContext = builder.sslContext;
        this.mSSLSocketInitializer = builder.mSSLSocketInitializer;
        this.mListener = builder.listener;
        this.mHostList = builder.mHostList;
    }

    /* access modifiers changed from: protected */
    public HttpRequestHandler requestHandler() {
        return new ProxyHandler(this.mHostList);
    }

    public void startup() {
        if (!this.isRunning) {
            Executors.getInstance().execute(new Runnable() {
                public void run() {
                    ServerSocketFactory access$100 = ProxyServer.this.mSocketFactory;
                    if (access$100 == null) {
                        if (ProxyServer.this.mSSLContext != null) {
                            access$100 = ProxyServer.this.mSSLContext.getServerSocketFactory();
                        } else {
                            access$100 = ServerSocketFactory.getDefault();
                        }
                    }
                    ServerSocketFactory serverSocketFactory = access$100;
                    ProxyServer proxyServer = ProxyServer.this;
                    HttpServer unused = proxyServer.mHttpServer = new HttpServer(proxyServer.mInetAddress, ProxyServer.this.mPort, ProxyServer.this.mTimeout, serverSocketFactory, ProxyServer.this.mSSLSocketInitializer, ProxyServer.this.requestHandler());
                    try {
                        ProxyServer.this.mHttpServer.startServer();
                        boolean unused2 = ProxyServer.this.isRunning = true;
                        Executors.getInstance().post(new Runnable() {
                            public void run() {
                                if (ProxyServer.this.mListener != null) {
                                    ProxyServer.this.mListener.onStarted();
                                }
                            }
                        });
                        Runtime.getRuntime().addShutdownHook(new Thread() {
                            public void run() {
                                ProxyServer.this.mHttpServer.stopServer();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void shutdown() {
        if (this.isRunning) {
            Executors.getInstance().execute(new Runnable() {
                public void run() {
                    if (ProxyServer.this.mHttpServer != null) {
                        ProxyServer.this.mHttpServer.stopServer();
                        boolean unused = ProxyServer.this.isRunning = false;
                        Executors.getInstance().post(new Runnable() {
                            public void run() {
                                if (ProxyServer.this.mListener != null) {
                                    ProxyServer.this.mListener.onStopped();
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static class Builder extends BasicServer.Builder<Builder, ProxyServer> implements Server.ProxyBuilder<Builder, ProxyServer> {
        /* access modifiers changed from: private */
        public Map<String, HttpHost> mHostList = new HashMap();

        public Builder addProxy(String str, String str2) {
            this.mHostList.put(str.toLowerCase(Locale.ROOT), HttpHost.create(str2));
            return this;
        }

        public ProxyServer build() {
            return new ProxyServer(this);
        }
    }

    private static class HttpServer implements Runnable {
        private final HttpRequestHandler mHandler;
        private HttpService mHttpService;
        private final InetAddress mInetAddress;
        private final int mPort;
        private final SSLSocketInitializer mSSLSocketInitializer;
        private final ThreadPoolExecutor mServerExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-Server-"));
        private ServerSocket mServerSocket;
        private final ServerSocketFactory mSocketFactory;
        private final int mTimeout;
        private final ThreadPoolExecutor mWorkerExecutor;
        /* access modifiers changed from: private */
        public final Map<Worker, Boolean> mWorkerSet;
        private final ThreadGroup mWorkerThreads;

        public HttpServer(InetAddress inetAddress, int i, int i2, ServerSocketFactory serverSocketFactory, SSLSocketInitializer sSLSocketInitializer, HttpRequestHandler httpRequestHandler) {
            HttpRequestHandler httpRequestHandler2 = httpRequestHandler;
            ThreadGroup threadGroup = new ThreadGroup("HTTP-workers");
            this.mWorkerThreads = threadGroup;
            this.mWorkerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-Handlers-", threadGroup)) {
                /* access modifiers changed from: protected */
                public void beforeExecute(Thread thread, Runnable runnable) {
                    if (runnable instanceof Worker) {
                        HttpServer.this.mWorkerSet.put((Worker) runnable, Boolean.TRUE);
                    }
                }

                /* access modifiers changed from: protected */
                public void afterExecute(Runnable runnable, Throwable th) {
                    if (runnable instanceof Worker) {
                        HttpServer.this.mWorkerSet.remove(runnable);
                    }
                }
            };
            this.mWorkerSet = new ConcurrentHashMap();
            this.mInetAddress = inetAddress;
            this.mPort = i;
            this.mTimeout = i2;
            this.mSocketFactory = serverSocketFactory;
            this.mSSLSocketInitializer = sSLSocketInitializer;
            this.mHandler = httpRequestHandler2;
            ImmutableHttpProcessor immutableHttpProcessor = new ImmutableHttpProcessor(new HttpResponseInterceptor[]{new ResponseDate(), new ResponseServer(AndServer.INFO), new ResponseContent(), new ResponseConnControl()});
            UriHttpRequestHandlerMapper uriHttpRequestHandlerMapper = new UriHttpRequestHandlerMapper();
            uriHttpRequestHandlerMapper.register("*", httpRequestHandler2);
            this.mHttpService = new HttpService(immutableHttpProcessor, uriHttpRequestHandlerMapper);
        }

        public void startServer() throws IOException {
            ServerSocket createServerSocket = this.mSocketFactory.createServerSocket();
            this.mServerSocket = createServerSocket;
            createServerSocket.setReuseAddress(true);
            this.mServerSocket.bind(new InetSocketAddress(this.mInetAddress, this.mPort), Marshallable.PROTO_PACKET_SIZE);
            this.mServerSocket.setReceiveBufferSize(Marshallable.PROTO_PACKET_SIZE);
            SSLSocketInitializer sSLSocketInitializer = this.mSSLSocketInitializer;
            if (sSLSocketInitializer != null) {
                ServerSocket serverSocket = this.mServerSocket;
                if (serverSocket instanceof SSLServerSocket) {
                    sSLSocketInitializer.onCreated((SSLServerSocket) serverSocket);
                }
            }
            this.mServerExecutor.execute(this);
        }

        public void stopServer() {
            this.mServerExecutor.shutdown();
            this.mWorkerExecutor.shutdown();
            try {
                this.mServerSocket.close();
            } catch (IOException unused) {
            }
            this.mWorkerThreads.interrupt();
            try {
                this.mWorkerExecutor.awaitTermination(3, TimeUnit.SECONDS);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            for (Worker serverConn : this.mWorkerSet.keySet()) {
                try {
                    serverConn.getServerConn().shutdown();
                } catch (IOException unused3) {
                }
            }
        }

        public void run() {
            while (!Thread.interrupted()) {
                try {
                    Socket accept = this.mServerSocket.accept();
                    accept.setSoTimeout(this.mTimeout);
                    accept.setKeepAlive(true);
                    accept.setTcpNoDelay(true);
                    accept.setReceiveBufferSize(Marshallable.PROTO_PACKET_SIZE);
                    accept.setSendBufferSize(Marshallable.PROTO_PACKET_SIZE);
                    accept.setSoLinger(true, 0);
                    DefaultBHttpServerConnection defaultBHttpServerConnection = new DefaultBHttpServerConnection(Marshallable.PROTO_PACKET_SIZE);
                    defaultBHttpServerConnection.bind(accept);
                    this.mWorkerExecutor.execute(new Worker(this.mHttpService, defaultBHttpServerConnection, new DefaultBHttpClientConnection(Marshallable.PROTO_PACKET_SIZE)));
                } catch (Exception unused) {
                    return;
                }
            }
        }
    }

    private static class Worker implements Runnable {
        private final DefaultBHttpClientConnection mClientConn;
        private final HttpService mHttpService;
        private final DefaultBHttpServerConnection mServerConn;

        public Worker(HttpService httpService, DefaultBHttpServerConnection defaultBHttpServerConnection, DefaultBHttpClientConnection defaultBHttpClientConnection) {
            this.mHttpService = httpService;
            this.mServerConn = defaultBHttpServerConnection;
            this.mClientConn = defaultBHttpClientConnection;
        }

        public DefaultBHttpServerConnection getServerConn() {
            return this.mServerConn;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:14|30|31|32|33|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x004a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x00a7 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                org.apache.httpcore.protocol.BasicHttpContext r0 = new org.apache.httpcore.protocol.BasicHttpContext
                r0.<init>()
                org.apache.httpcore.protocol.HttpCoreContext r0 = org.apache.httpcore.protocol.HttpCoreContext.adapt(r0)
                org.apache.httpcore.impl.DefaultBHttpClientConnection r1 = r4.mClientConn
                java.lang.String r2 = "http.proxy.conn.client"
                r0.setAttribute(r2, r1)
            L_0x0010:
                boolean r1 = java.lang.Thread.interrupted()     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                if (r1 != 0) goto L_0x0045
                org.apache.httpcore.impl.DefaultBHttpServerConnection r1 = r4.mServerConn     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                boolean r1 = r1.isOpen()     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                if (r1 != 0) goto L_0x0024
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.mClientConn     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                r0.close()     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                goto L_0x0045
            L_0x0024:
                org.apache.httpcore.protocol.HttpService r1 = r4.mHttpService     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                org.apache.httpcore.impl.DefaultBHttpServerConnection r2 = r4.mServerConn     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                r1.handleRequest(r2, r0)     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                java.lang.String r1 = "http.proxy.conn.alive"
                java.lang.Object r1 = r0.getAttribute(r1)     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                boolean r1 = r2.equals(r1)     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                if (r1 != 0) goto L_0x0010
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.mClientConn     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                r0.close()     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.mServerConn     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
                r0.close()     // Catch:{ ConnectionClosedException -> 0x0094, IOException -> 0x0073, HttpException -> 0x0052 }
            L_0x0045:
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.mServerConn     // Catch:{ IOException -> 0x004a }
                r0.shutdown()     // Catch:{ IOException -> 0x004a }
            L_0x004a:
                org.apache.httpcore.impl.DefaultBHttpClientConnection r0 = r4.mClientConn     // Catch:{ IOException -> 0x00a1 }
                r0.shutdown()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a1
            L_0x0050:
                r0 = move-exception
                goto L_0x00a2
            L_0x0052:
                r0 = move-exception
                java.io.PrintStream r1 = java.lang.System.err     // Catch:{ all -> 0x0050 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
                r2.<init>()     // Catch:{ all -> 0x0050 }
                java.lang.String r3 = "Unrecoverable HTTP protocol violation: "
                r2.append(r3)     // Catch:{ all -> 0x0050 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0050 }
                r2.append(r0)     // Catch:{ all -> 0x0050 }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0050 }
                r1.println(r0)     // Catch:{ all -> 0x0050 }
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.mServerConn     // Catch:{ IOException -> 0x004a }
                r0.shutdown()     // Catch:{ IOException -> 0x004a }
                goto L_0x004a
            L_0x0073:
                r0 = move-exception
                java.io.PrintStream r1 = java.lang.System.err     // Catch:{ all -> 0x0050 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
                r2.<init>()     // Catch:{ all -> 0x0050 }
                java.lang.String r3 = "I/O error: "
                r2.append(r3)     // Catch:{ all -> 0x0050 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0050 }
                r2.append(r0)     // Catch:{ all -> 0x0050 }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0050 }
                r1.println(r0)     // Catch:{ all -> 0x0050 }
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.mServerConn     // Catch:{ IOException -> 0x004a }
                r0.shutdown()     // Catch:{ IOException -> 0x004a }
                goto L_0x004a
            L_0x0094:
                java.io.PrintStream r0 = java.lang.System.err     // Catch:{ all -> 0x0050 }
                java.lang.String r1 = "Client closed connection."
                r0.println(r1)     // Catch:{ all -> 0x0050 }
                org.apache.httpcore.impl.DefaultBHttpServerConnection r0 = r4.mServerConn     // Catch:{ IOException -> 0x004a }
                r0.shutdown()     // Catch:{ IOException -> 0x004a }
                goto L_0x004a
            L_0x00a1:
                return
            L_0x00a2:
                org.apache.httpcore.impl.DefaultBHttpServerConnection r1 = r4.mServerConn     // Catch:{ IOException -> 0x00a7 }
                r1.shutdown()     // Catch:{ IOException -> 0x00a7 }
            L_0x00a7:
                org.apache.httpcore.impl.DefaultBHttpClientConnection r1 = r4.mClientConn     // Catch:{ IOException -> 0x00ac }
                r1.shutdown()     // Catch:{ IOException -> 0x00ac }
            L_0x00ac:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.andserver.server.ProxyServer.Worker.run():void");
        }
    }

    private static class ThreadFactoryImpl implements ThreadFactory {
        private final AtomicLong mCount;
        private final ThreadGroup mGroup;
        private final String mPrefix;

        ThreadFactoryImpl(String str, ThreadGroup threadGroup) {
            this.mPrefix = str;
            this.mGroup = threadGroup;
            this.mCount = new AtomicLong();
        }

        ThreadFactoryImpl(String str) {
            this(str, (ThreadGroup) null);
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.mGroup;
            return new Thread(threadGroup, runnable, this.mPrefix + "-" + this.mCount.incrementAndGet());
        }
    }
}
