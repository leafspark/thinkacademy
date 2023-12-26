package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import java.net.InetAddress;
import javax.net.ssl.TrustManager;

public class ClientConfiguration {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 15000;
    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final RetryPolicy DEFAULT_RETRY_POLICY = PredefinedRetryPolicies.DEFAULT;
    public static final int DEFAULT_SOCKET_TIMEOUT = 15000;
    public static final String DEFAULT_USER_AGENT = VersionInfoUtils.getUserAgent();
    private int connectionTimeout = 15000;
    private boolean curlLogging = false;
    private boolean enableGzip = false;
    private InetAddress localAddress;
    private int maxConnections = 10;
    private int maxErrorRetry = -1;
    private boolean preemptiveBasicProxyAuth;
    private Protocol protocol = Protocol.HTTPS;
    @Deprecated
    private String proxyDomain = null;
    private String proxyHost = null;
    private String proxyPassword = null;
    private int proxyPort = -1;
    private String proxyUsername = null;
    @Deprecated
    private String proxyWorkstation = null;
    private RetryPolicy retryPolicy = DEFAULT_RETRY_POLICY;
    private String signerOverride;
    private int socketReceiveBufferSizeHint = 0;
    private int socketSendBufferSizeHint = 0;
    private int socketTimeout = 15000;
    private TrustManager trustManager = null;
    private String userAgent = DEFAULT_USER_AGENT;
    private String userAgentOverride;

    public ClientConfiguration() {
    }

    public ClientConfiguration(ClientConfiguration clientConfiguration) {
        this.connectionTimeout = clientConfiguration.connectionTimeout;
        this.maxConnections = clientConfiguration.maxConnections;
        this.maxErrorRetry = clientConfiguration.maxErrorRetry;
        this.retryPolicy = clientConfiguration.retryPolicy;
        this.localAddress = clientConfiguration.localAddress;
        this.protocol = clientConfiguration.protocol;
        this.proxyDomain = clientConfiguration.proxyDomain;
        this.proxyHost = clientConfiguration.proxyHost;
        this.proxyPassword = clientConfiguration.proxyPassword;
        this.proxyPort = clientConfiguration.proxyPort;
        this.proxyUsername = clientConfiguration.proxyUsername;
        this.proxyWorkstation = clientConfiguration.proxyWorkstation;
        this.preemptiveBasicProxyAuth = clientConfiguration.preemptiveBasicProxyAuth;
        this.socketTimeout = clientConfiguration.socketTimeout;
        this.userAgent = clientConfiguration.userAgent;
        this.userAgentOverride = clientConfiguration.userAgentOverride;
        this.socketReceiveBufferSizeHint = clientConfiguration.socketReceiveBufferSizeHint;
        this.socketSendBufferSizeHint = clientConfiguration.socketSendBufferSizeHint;
        this.signerOverride = clientConfiguration.signerOverride;
        this.trustManager = clientConfiguration.trustManager;
        this.curlLogging = clientConfiguration.curlLogging;
        this.enableGzip = clientConfiguration.enableGzip;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Protocol protocol2) {
        this.protocol = protocol2;
    }

    public ClientConfiguration withProtocol(Protocol protocol2) {
        setProtocol(protocol2);
        return this;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int i) {
        this.maxConnections = i;
    }

    public ClientConfiguration withMaxConnections(int i) {
        setMaxConnections(i);
        return this;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public ClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }

    public String getUserAgentOverride() {
        return this.userAgentOverride;
    }

    public void setUserAgentOverride(String str) {
        this.userAgentOverride = str;
    }

    public ClientConfiguration withUserAgentOverride(String str) {
        setUserAgentOverride(str);
        return this;
    }

    public InetAddress getLocalAddress() {
        return this.localAddress;
    }

    public void setLocalAddress(InetAddress inetAddress) {
        this.localAddress = inetAddress;
    }

    public ClientConfiguration withLocalAddress(InetAddress inetAddress) {
        setLocalAddress(inetAddress);
        return this;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public ClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public ClientConfiguration withProxyPort(int i) {
        setProxyPort(i);
        return this;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public void setProxyUsername(String str) {
        this.proxyUsername = str;
    }

    public ClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public void setProxyPassword(String str) {
        this.proxyPassword = str;
    }

    public ClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    @Deprecated
    public String getProxyDomain() {
        return this.proxyDomain;
    }

    @Deprecated
    public void setProxyDomain(String str) {
        this.proxyDomain = str;
    }

    @Deprecated
    public ClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    public String getProxyWorkstation() {
        return this.proxyWorkstation;
    }

    @Deprecated
    public void setProxyWorkstation(String str) {
        this.proxyWorkstation = str;
    }

    @Deprecated
    public ClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    public RetryPolicy getRetryPolicy() {
        return this.retryPolicy;
    }

    public void setRetryPolicy(RetryPolicy retryPolicy2) {
        this.retryPolicy = retryPolicy2;
    }

    public ClientConfiguration withRetryPolicy(RetryPolicy retryPolicy2) {
        setRetryPolicy(retryPolicy2);
        return this;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public void setMaxErrorRetry(int i) {
        if (i >= 0) {
            this.maxErrorRetry = i;
            return;
        }
        throw new IllegalArgumentException("maxErrorRetry shoud be non-negative");
    }

    public ClientConfiguration withMaxErrorRetry(int i) {
        setMaxErrorRetry(i);
        return this;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public ClientConfiguration withSocketTimeout(int i) {
        setSocketTimeout(i);
        return this;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public ClientConfiguration withConnectionTimeout(int i) {
        setConnectionTimeout(i);
        return this;
    }

    public int[] getSocketBufferSizeHints() {
        return new int[]{this.socketSendBufferSizeHint, this.socketReceiveBufferSizeHint};
    }

    public void setSocketBufferSizeHints(int i, int i2) {
        this.socketSendBufferSizeHint = i;
        this.socketReceiveBufferSizeHint = i2;
    }

    public ClientConfiguration withSocketBufferSizeHints(int i, int i2) {
        setSocketBufferSizeHints(i, i2);
        return this;
    }

    public String getSignerOverride() {
        return this.signerOverride;
    }

    public void setSignerOverride(String str) {
        this.signerOverride = str;
    }

    public ClientConfiguration withSignerOverride(String str) {
        setSignerOverride(str);
        return this;
    }

    public boolean isPreemptiveBasicProxyAuth() {
        return this.preemptiveBasicProxyAuth;
    }

    public void setPreemptiveBasicProxyAuth(Boolean bool) {
        this.preemptiveBasicProxyAuth = bool.booleanValue();
    }

    public ClientConfiguration withPreemptiveBasicProxyAuth(boolean z) {
        setPreemptiveBasicProxyAuth(Boolean.valueOf(z));
        return this;
    }

    public TrustManager getTrustManager() {
        return this.trustManager;
    }

    public void setTrustManager(TrustManager trustManager2) {
        this.trustManager = trustManager2;
    }

    public ClientConfiguration withTrustManager(TrustManager trustManager2) {
        setTrustManager(trustManager2);
        return this;
    }

    public boolean isCurlLogging() {
        return this.curlLogging;
    }

    public void setCurlLogging(boolean z) {
        this.curlLogging = z;
    }

    public ClientConfiguration withCurlLogging(boolean z) {
        this.curlLogging = z;
        return this;
    }

    public boolean isEnableGzip() {
        return this.enableGzip;
    }

    public void setEnableGzip(boolean z) {
        this.enableGzip = z;
    }

    public ClientConfiguration withEnableGzip(boolean z) {
        setEnableGzip(z);
        return this;
    }
}
