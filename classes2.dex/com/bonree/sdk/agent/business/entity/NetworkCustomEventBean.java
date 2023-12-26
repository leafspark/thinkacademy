package com.bonree.sdk.agent.business.entity;

import com.didi.hummer.adapter.http.IHttpAdapter;
import java.util.List;
import java.util.Map;

public class NetworkCustomEventBean {
    private List<String> mCNameArray;
    private int mConnectTimeUs = 0;
    private int mDnsTimeUs = 0;
    private int mDownloadSizeByte;
    private int mDownloadTimeUs = 0;
    private Integer mErrorCode;
    private String mErrorMsg;
    private ErrorOccurrentProcess mErrorOccurrentProcess;
    private HttpMethod mMethod;
    private ProtocolType mProtocolType;
    private long mRequestDataSize;
    private Map<String, String> mRequestHeader;
    private int mRequestTimeUs = 0;
    private String mRequestUrl = "";
    private String mResourceType;
    private Map<String, String> mResponseHeader;
    private int mResponseTimeUs = 0;
    private int mSslTimeUs = 0;
    private String mTargetIp;
    private int mTargetPort = 0;

    public NetworkCustomEventBean(String str, HttpMethod httpMethod, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ProtocolType protocolType) {
        this.mRequestUrl = str;
        this.mMethod = httpMethod;
        this.mTargetPort = i;
        this.mDnsTimeUs = i2;
        this.mConnectTimeUs = i3;
        this.mSslTimeUs = i4;
        this.mRequestTimeUs = i5;
        this.mResponseTimeUs = i6;
        this.mDownloadTimeUs = i7;
        this.mDownloadSizeByte = i8;
        this.mProtocolType = protocolType;
    }

    public NetworkCustomEventBean(String str, HttpMethod httpMethod, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, ProtocolType protocolType, Map<String, String> map, Map<String, String> map2, ErrorOccurrentProcess errorOccurrentProcess, Integer num, String str3, String str4, long j, List<String> list) {
        this.mRequestUrl = str;
        this.mMethod = httpMethod;
        this.mTargetIp = str2;
        this.mTargetPort = i;
        this.mDnsTimeUs = i2;
        this.mConnectTimeUs = i3;
        this.mSslTimeUs = i4;
        this.mRequestTimeUs = i5;
        this.mResponseTimeUs = i6;
        this.mDownloadTimeUs = i7;
        this.mDownloadSizeByte = i8;
        this.mProtocolType = protocolType;
        this.mRequestHeader = map;
        this.mResponseHeader = map2;
        this.mErrorOccurrentProcess = errorOccurrentProcess;
        this.mErrorCode = num;
        this.mErrorMsg = str3;
        this.mResourceType = str4;
        this.mRequestDataSize = j;
        this.mCNameArray = list;
    }

    public enum HttpMethod {
        GET(IHttpAdapter.METHOD_GET),
        POST(IHttpAdapter.METHOD_POST),
        HEAD(IHttpAdapter.METHOD_HEAD),
        OPTIONS(IHttpAdapter.METHOD_OPTIONS),
        PUT(IHttpAdapter.METHOD_PUT),
        DELETE(IHttpAdapter.METHOD_DELETE),
        TRACE(IHttpAdapter.METHOD_TRACE),
        CONNECT(IHttpAdapter.METHOD_CONNECT);
        
        private final String value;

        private HttpMethod(String str) {
            this.value = str;
        }

        public final String value() {
            return this.value;
        }
    }

    public enum ProtocolType {
        HTTP(1),
        HTTPS(2),
        HTTP2(3),
        WEBSOCKET(5),
        WEBSOCKETSSL(6),
        TCP(7),
        UDP(10),
        QUIC(11),
        OTHER(0);
        
        private final int value;

        private ProtocolType(int i) {
            this.value = i;
        }

        public final int value() {
            return this.value;
        }
    }

    public enum ErrorOccurrentProcess {
        SSL(1),
        DNS(2),
        TCP(3),
        OTHER(4);
        
        private final int value;

        private ErrorOccurrentProcess(int i) {
            this.value = i;
        }

        public final int value() {
            return this.value;
        }
    }

    public String getmRequestUrl() {
        return this.mRequestUrl;
    }

    public void setmRequestUrl(String str) {
        this.mRequestUrl = str;
    }

    public HttpMethod getmMethod() {
        return this.mMethod;
    }

    public void setmMethod(HttpMethod httpMethod) {
        this.mMethod = httpMethod;
    }

    public String getmTargetIp() {
        return this.mTargetIp;
    }

    public void setmTargetIp(String str) {
        this.mTargetIp = str;
    }

    public int getmTargetPort() {
        return this.mTargetPort;
    }

    public void setmTargetPort(int i) {
        this.mTargetPort = i;
    }

    public int getmDnsTimeUs() {
        return this.mDnsTimeUs;
    }

    public void setmDnsTimeUs(int i) {
        this.mDnsTimeUs = i;
    }

    public int getmConnectTimeUs() {
        return this.mConnectTimeUs;
    }

    public void setmConnectTimeUs(int i) {
        this.mConnectTimeUs = i;
    }

    public int getmSslTimeUs() {
        return this.mSslTimeUs;
    }

    public void setmSslTimeUs(int i) {
        this.mSslTimeUs = i;
    }

    public int getmRequestTimeUs() {
        return this.mRequestTimeUs;
    }

    public void setmRequestTimeUs(int i) {
        this.mRequestTimeUs = i;
    }

    public int getmResponseTimeUs() {
        return this.mResponseTimeUs;
    }

    public void setmResponseTimeUs(int i) {
        this.mResponseTimeUs = i;
    }

    public int getmDownloadTimeUs() {
        return this.mDownloadTimeUs;
    }

    public void setmDownloadTimeUs(int i) {
        this.mDownloadTimeUs = i;
    }

    public int getmDownloadSizeByte() {
        return this.mDownloadSizeByte;
    }

    public void setmDownloadSizeByte(int i) {
        this.mDownloadSizeByte = i;
    }

    public ProtocolType getmProtocolType() {
        return this.mProtocolType;
    }

    public void setmProtocolType(ProtocolType protocolType) {
        this.mProtocolType = protocolType;
    }

    public Map<String, String> getmRequestHeader() {
        return this.mRequestHeader;
    }

    public void setmRequestHeader(Map<String, String> map) {
        this.mRequestHeader = map;
    }

    public Map<String, String> getmResponseHeader() {
        return this.mResponseHeader;
    }

    public void setmResponseHeader(Map<String, String> map) {
        this.mResponseHeader = map;
    }

    public ErrorOccurrentProcess getmErrorOccurrentProcess() {
        return this.mErrorOccurrentProcess;
    }

    public void setmErrorOccurrentProcess(ErrorOccurrentProcess errorOccurrentProcess) {
        this.mErrorOccurrentProcess = errorOccurrentProcess;
    }

    public Integer getmErrorCode() {
        return this.mErrorCode;
    }

    public void setmErrorCode(Integer num) {
        this.mErrorCode = num;
    }

    public String getmErrorMsg() {
        return this.mErrorMsg;
    }

    public void setmErrorMsg(String str) {
        this.mErrorMsg = str;
    }

    public String getmResourceType() {
        return this.mResourceType;
    }

    public void setmResourceType(String str) {
        this.mResourceType = str;
    }

    public long getmRequestDataSize() {
        return this.mRequestDataSize;
    }

    public void setmRequestDataSize(long j) {
        this.mRequestDataSize = j;
    }

    public List<String> getmCNameArray() {
        return this.mCNameArray;
    }

    public void setmCNameArray(List<String> list) {
        this.mCNameArray = list;
    }
}
