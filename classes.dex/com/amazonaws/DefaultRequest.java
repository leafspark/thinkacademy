package com.amazonaws;

import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.util.AWSRequestMetrics;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultRequest<T> implements Request<T> {
    private InputStream content;
    private String encodedUriResourcePath;
    private URI endpoint;
    private final Map<String, String> headers;
    private String hostPrefix;
    private HttpMethodName httpMethod;
    private AWSRequestMetrics metrics;
    private final AmazonWebServiceRequest originalRequest;
    private final Map<String, String> parameters;
    private String resourcePath;
    private String serviceName;
    private boolean streaming;
    private long timeOffset;

    public DefaultRequest(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        this.streaming = false;
        this.parameters = new LinkedHashMap();
        this.headers = new HashMap();
        this.httpMethod = HttpMethodName.POST;
        this.serviceName = str;
        this.originalRequest = amazonWebServiceRequest;
    }

    public DefaultRequest(String str) {
        this((AmazonWebServiceRequest) null, str);
    }

    public AmazonWebServiceRequest getOriginalRequest() {
        return this.originalRequest;
    }

    public void addHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setResourcePath(String str) {
        this.resourcePath = str;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public void addParameter(String str, String str2) {
        this.parameters.put(str, str2);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public Request<T> withParameter(String str, String str2) {
        addParameter(str, str2);
        return this;
    }

    public HttpMethodName getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(HttpMethodName httpMethodName) {
        this.httpMethod = httpMethodName;
    }

    public void setEndpoint(URI uri) {
        this.endpoint = uri;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public InputStream getContent() {
        return this.content;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers.clear();
        this.headers.putAll(map);
    }

    public void setParameters(Map<String, String> map) {
        this.parameters.clear();
        this.parameters.putAll(map);
    }

    public String getHostPrefix() {
        return this.hostPrefix;
    }

    public void setHostPrefix(String str) {
        this.hostPrefix = str;
    }

    public long getTimeOffset() {
        return this.timeOffset;
    }

    @Deprecated
    public void setTimeOffset(int i) {
        setTimeOffset((long) i);
    }

    public void setTimeOffset(long j) {
        this.timeOffset = j;
    }

    @Deprecated
    public Request<T> withTimeOffset(int i) {
        return withTimeOffset((long) i);
    }

    public Request<T> withTimeOffset(long j) {
        setTimeOffset(j);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getHttpMethod());
        sb.append(" ");
        sb.append(getEndpoint());
        sb.append(" ");
        String resourcePath2 = getResourcePath();
        if (resourcePath2 == null) {
            sb.append(ExpiryDateInput.SEPARATOR);
        } else {
            if (!resourcePath2.startsWith(ExpiryDateInput.SEPARATOR)) {
                sb.append(ExpiryDateInput.SEPARATOR);
            }
            sb.append(resourcePath2);
        }
        sb.append(" ");
        if (!getParameters().isEmpty()) {
            sb.append("Parameters: (");
            for (String next : getParameters().keySet()) {
                sb.append(next);
                sb.append(": ");
                sb.append(getParameters().get(next));
                sb.append(", ");
            }
            sb.append(") ");
        }
        if (!getHeaders().isEmpty()) {
            sb.append("Headers: (");
            for (String next2 : getHeaders().keySet()) {
                sb.append(next2);
                sb.append(": ");
                sb.append(getHeaders().get(next2));
                sb.append(", ");
            }
            sb.append(") ");
        }
        return sb.toString();
    }

    @Deprecated
    public AWSRequestMetrics getAWSRequestMetrics() {
        return this.metrics;
    }

    @Deprecated
    public void setAWSRequestMetrics(AWSRequestMetrics aWSRequestMetrics) {
        if (this.metrics == null) {
            this.metrics = aWSRequestMetrics;
            return;
        }
        throw new IllegalStateException("AWSRequestMetrics has already been set on this request");
    }

    public boolean isStreaming() {
        return this.streaming;
    }

    public void setStreaming(boolean z) {
        this.streaming = z;
    }

    public String getEncodedUriResourcePath() {
        return this.encodedUriResourcePath;
    }

    public void setEncodedResourcePath(String str) {
        this.encodedUriResourcePath = str;
    }
}
