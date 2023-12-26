package org.apache.httpcore.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpException;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.HttpServerConnection;
import org.apache.httpcore.config.MessageConstraints;
import org.apache.httpcore.entity.ContentLengthStrategy;
import org.apache.httpcore.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.httpcore.impl.io.DefaultHttpRequestParserFactory;
import org.apache.httpcore.impl.io.DefaultHttpResponseWriterFactory;
import org.apache.httpcore.io.HttpMessageParser;
import org.apache.httpcore.io.HttpMessageParserFactory;
import org.apache.httpcore.io.HttpMessageWriter;
import org.apache.httpcore.io.HttpMessageWriterFactory;
import org.apache.httpcore.util.Args;

public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    /* access modifiers changed from: protected */
    public void onRequestReceived(HttpRequest httpRequest) {
    }

    /* access modifiers changed from: protected */
    public void onResponseSubmitted(HttpResponse httpResponse) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultBHttpServerConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy != null ? contentLengthStrategy : DisallowIdentityContentLengthStrategy.INSTANCE, contentLengthStrategy2);
        HttpMessageParserFactory<HttpRequest> httpMessageParserFactory2;
        HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory2;
        if (httpMessageParserFactory != null) {
            httpMessageParserFactory2 = httpMessageParserFactory;
        } else {
            httpMessageParserFactory2 = DefaultHttpRequestParserFactory.INSTANCE;
        }
        MessageConstraints messageConstraints2 = messageConstraints;
        this.requestParser = httpMessageParserFactory2.create(getSessionInputBuffer(), messageConstraints);
        if (httpMessageWriterFactory != null) {
            httpMessageWriterFactory2 = httpMessageWriterFactory;
        } else {
            httpMessageWriterFactory2 = DefaultHttpResponseWriterFactory.INSTANCE;
        }
        this.responseWriter = httpMessageWriterFactory2.create(getSessionOutputBuffer());
    }

    public DefaultBHttpServerConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageParserFactory<HttpRequest>) null, (HttpMessageWriterFactory<HttpResponse>) null);
    }

    public DefaultBHttpServerConnection(int i) {
        this(i, i, (CharsetDecoder) null, (CharsetEncoder) null, (MessageConstraints) null, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageParserFactory<HttpRequest>) null, (HttpMessageWriterFactory<HttpResponse>) null);
    }

    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        ensureOpen();
        HttpRequest parse = this.requestParser.parse();
        onRequestReceived(parse);
        incrementRequestCount();
        return parse;
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        httpEntityEnclosingRequest.setEntity(prepareInput(httpEntityEnclosingRequest));
    }

    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        this.responseWriter.write(httpResponse);
        onResponseSubmitted(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
    }

    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            OutputStream prepareOutput = prepareOutput(httpResponse);
            entity.writeTo(prepareOutput);
            prepareOutput.close();
        }
    }

    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }
}
