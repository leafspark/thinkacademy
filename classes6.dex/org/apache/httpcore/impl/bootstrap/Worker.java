package org.apache.httpcore.impl.bootstrap;

import java.io.IOException;
import org.apache.httpcore.ExceptionLogger;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.protocol.BasicHttpContext;
import org.apache.httpcore.protocol.HttpCoreContext;
import org.apache.httpcore.protocol.HttpService;

class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionLogger exceptionLogger2) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionLogger = exceptionLogger2;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    public void run() {
        try {
            BasicHttpContext basicHttpContext = new BasicHttpContext();
            HttpCoreContext adapt = HttpCoreContext.adapt(basicHttpContext);
            while (!Thread.interrupted() && this.conn.isOpen()) {
                this.httpservice.handleRequest(this.conn, adapt);
                basicHttpContext.clear();
            }
            this.conn.close();
            try {
                this.conn.shutdown();
            } catch (IOException e) {
                this.exceptionLogger.log(e);
            }
        } catch (Exception e2) {
            this.exceptionLogger.log(e2);
            this.conn.shutdown();
        } catch (Throwable th) {
            try {
                this.conn.shutdown();
            } catch (IOException e3) {
                this.exceptionLogger.log(e3);
            }
            throw th;
        }
    }
}
