package org.apache.httpcore.impl.bootstrap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpConnectionFactory;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.impl.DefaultBHttpServerConnection;
import org.apache.httpcore.protocol.HttpService;

public class HttpServer {
    private final HttpConnectionFactory<? extends DefaultBHttpServerConnection> connectionFactory;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpService;
    private final InetAddress ifAddress;
    private final ThreadPoolExecutor listenerExecutorService;
    private final int port;
    private volatile RequestListener requestListener;
    private volatile ServerSocket serverSocket;
    private final ServerSocketFactory serverSocketFactory;
    private final SocketConfig socketConfig;
    private final SSLServerSetupHandler sslSetupHandler;
    private final AtomicReference<Status> status = new AtomicReference<>(Status.READY);
    private final WorkerPoolExecutor workerExecutorService;
    private final ThreadGroup workerThreads;

    enum Status {
        READY,
        ACTIVE,
        STOPPING
    }

    HttpServer(int i, InetAddress inetAddress, SocketConfig socketConfig2, ServerSocketFactory serverSocketFactory2, HttpService httpService2, HttpConnectionFactory<? extends DefaultBHttpServerConnection> httpConnectionFactory, SSLServerSetupHandler sSLServerSetupHandler, ExceptionLogger exceptionLogger2) {
        this.port = i;
        this.ifAddress = inetAddress;
        this.socketConfig = socketConfig2;
        this.serverSocketFactory = serverSocketFactory2;
        this.httpService = httpService2;
        this.connectionFactory = httpConnectionFactory;
        this.sslSetupHandler = sSLServerSetupHandler;
        this.exceptionLogger = exceptionLogger2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        this.listenerExecutorService = new ThreadPoolExecutor(1, 1, 0, timeUnit, synchronousQueue, new ThreadFactoryImpl("HTTP-listener-" + i));
        ThreadGroup threadGroup = new ThreadGroup("HTTP-workers");
        this.workerThreads = threadGroup;
        this.workerExecutorService = new WorkerPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryImpl("HTTP-worker", threadGroup));
    }

    public InetAddress getInetAddress() {
        ServerSocket serverSocket2 = this.serverSocket;
        if (serverSocket2 != null) {
            return serverSocket2.getInetAddress();
        }
        return null;
    }

    public int getLocalPort() {
        ServerSocket serverSocket2 = this.serverSocket;
        if (serverSocket2 != null) {
            return serverSocket2.getLocalPort();
        }
        return -1;
    }

    public void start() throws IOException {
        if (this.status.compareAndSet(Status.READY, Status.ACTIVE)) {
            this.serverSocket = this.serverSocketFactory.createServerSocket();
            this.serverSocket.setReuseAddress(this.socketConfig.isSoReuseAddress());
            this.serverSocket.bind(new InetSocketAddress(this.ifAddress, this.port), this.socketConfig.getBacklogSize());
            if (this.socketConfig.getRcvBufSize() > 0) {
                this.serverSocket.setReceiveBufferSize(this.socketConfig.getRcvBufSize());
            }
            if (this.sslSetupHandler != null && (this.serverSocket instanceof SSLServerSocket)) {
                this.sslSetupHandler.initialize((SSLServerSocket) this.serverSocket);
            }
            this.requestListener = new RequestListener(this.socketConfig, this.serverSocket, this.httpService, this.connectionFactory, this.exceptionLogger, this.workerExecutorService);
            this.listenerExecutorService.execute(this.requestListener);
        }
    }

    public void stop() {
        if (this.status.compareAndSet(Status.ACTIVE, Status.STOPPING)) {
            this.listenerExecutorService.shutdown();
            this.workerExecutorService.shutdown();
            RequestListener requestListener2 = this.requestListener;
            if (requestListener2 != null) {
                try {
                    requestListener2.terminate();
                } catch (IOException e) {
                    this.exceptionLogger.log(e);
                }
            }
            this.workerThreads.interrupt();
        }
    }

    public void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        this.workerExecutorService.awaitTermination(j, timeUnit);
    }

    public void shutdown(long j, TimeUnit timeUnit) {
        stop();
        if (j > 0) {
            try {
                awaitTermination(j, timeUnit);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        for (Worker connection : this.workerExecutorService.getWorkers()) {
            try {
                connection.getConnection().shutdown();
            } catch (IOException e) {
                this.exceptionLogger.log(e);
            }
        }
    }
}
