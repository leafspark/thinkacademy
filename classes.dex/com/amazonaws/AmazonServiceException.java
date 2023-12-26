package com.amazonaws;

public class AmazonServiceException extends AmazonClientException {
    private static final long serialVersionUID = 1;
    private String errorCode;
    private String errorMessage;
    private ErrorType errorType = ErrorType.Unknown;
    private String requestId;
    private String serviceName;
    private int statusCode;

    public enum ErrorType {
        Client,
        Service,
        Unknown
    }

    public AmazonServiceException(String str) {
        super(str);
        this.errorMessage = str;
    }

    public AmazonServiceException(String str, Exception exc) {
        super((String) null, exc);
        this.errorMessage = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorType(ErrorType errorType2) {
        this.errorType = errorType2;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
