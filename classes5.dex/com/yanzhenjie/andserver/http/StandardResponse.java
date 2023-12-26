package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.http.cookie.CookieProcessor;
import com.yanzhenjie.andserver.http.cookie.StandardCookieProcessor;
import com.yanzhenjie.andserver.util.HttpDateFormat;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.ObjectUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.message.BasicHeader;

public class StandardResponse implements HttpResponse {
    private static final CookieProcessor COOKIE_PROCESSOR = new StandardCookieProcessor();
    private HttpResponse mResponse;

    public StandardResponse(HttpResponse httpResponse) {
        this.mResponse = httpResponse;
    }

    public void setStatus(int i) {
        this.mResponse.setStatusCode(i);
    }

    public int getStatus() {
        return this.mResponse.getStatusLine().getStatusCode();
    }

    public void setHeader(String str, String str2) {
        this.mResponse.setHeader(str, str2);
    }

    public void addHeader(String str, String str2) {
        this.mResponse.addHeader(str, str2);
    }

    public String getHeader(String str) {
        Header firstHeader = this.mResponse.getFirstHeader(str);
        if (ObjectUtils.isEmpty((Object) firstHeader)) {
            return null;
        }
        return firstHeader.getValue();
    }

    public void setDateHeader(String str, long j) {
        setHeader(str, HttpDateFormat.formatDate(j));
    }

    public void addDateHeader(String str, long j) {
        addHeader(str, HttpDateFormat.formatDate(j));
    }

    public void setIntHeader(String str, int i) {
        setHeader(str, Integer.toString(i));
    }

    public void addIntHeader(String str, int i) {
        addHeader(str, Integer.toString(i));
    }

    public boolean containsHeader(String str) {
        return this.mResponse.containsHeader(str);
    }

    public List<String> getHeaders(String str) {
        Header[] headers = this.mResponse.getHeaders(str);
        if (ObjectUtils.isEmpty((Object[]) headers)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Header value : headers) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public List<String> getHeaderNames() {
        Header[] allHeaders = this.mResponse.getAllHeaders();
        if (ObjectUtils.isEmpty((Object[]) allHeaders)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Header name : allHeaders) {
            arrayList.add(name.getName());
        }
        return arrayList;
    }

    public void addCookie(Cookie cookie) {
        addHeader(HttpHeaders.SET_COOKIE, COOKIE_PROCESSOR.generateHeader(cookie));
    }

    public void sendRedirect(String str) {
        setStatus(302);
        setHeader(HttpHeaders.LOCATION, str);
    }

    public void setBody(ResponseBody responseBody) {
        this.mResponse.setEntity(new BodyToEntity(responseBody));
    }

    private static class BodyToEntity implements HttpEntity {
        private ResponseBody mBody;

        public void consumeContent() {
        }

        public InputStream getContent() throws IOException {
            return null;
        }

        public Header getContentEncoding() {
            return null;
        }

        public boolean isChunked() {
            return false;
        }

        public boolean isRepeatable() {
            return false;
        }

        public boolean isStreaming() {
            return false;
        }

        private BodyToEntity(ResponseBody responseBody) {
            this.mBody = responseBody;
        }

        public long getContentLength() {
            return this.mBody.contentLength();
        }

        public Header getContentType() {
            MediaType contentType = this.mBody.contentType();
            if (contentType == null) {
                return null;
            }
            return new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType.toString());
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            this.mBody.writeTo(outputStream);
        }
    }
}
