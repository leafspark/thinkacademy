package com.tal.app.thinkacademy.lib.download.exception;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class ResumeTransferExceptionEngine {
    private static final int BADREQUEST = 400;
    private static final int BAD_GATEWAY = 502;
    private static final int FORBIDDEN = 403;
    private static final int GATEWAY_TIMEOUT = 504;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int UNAUTHORIZED = 401;

    public static DownloadException handleException(Throwable th) {
        XesLog.et("ResumeTransferExceptionEngine", th.getClass().getSimpleName());
        if (th instanceof DownloadHttpException) {
            DownloadHttpException downloadHttpException = (DownloadHttpException) th;
            downloadHttpException.code();
            return new DownloadException(th, downloadHttpException.code(), "网络异常，请确认网络正常");
        } else if (th instanceof IllegalStateException) {
            return new DownloadException(th, ERROR.NETWORK_SSL, "网络异常，请确认网络正常");
        } else {
            if (th instanceof ConnectException) {
                return new DownloadException(th, ERROR.NETWORK_CONNECT_ERROR, "网络不可用，请检查网络设置");
            }
            if (th instanceof SocketException) {
                return new DownloadException(th, ERROR.NETWORK_SOCKET, "网络不可用，请检查网络设置");
            }
            if (th instanceof SocketTimeoutException) {
                return new DownloadException(th, ERROR.NETWORK_TIMEOUT, "网络超时，请稍后重试");
            }
            if (th instanceof UnknownHostException) {
                return new DownloadException(th, ERROR.NETWORK_UNKNOWN_HOST, "网络异常，请确认网络正常");
            }
            if (th instanceof SSLException) {
                return new DownloadException(th, ERROR.NETWORK_SSL, "网络异常，请确认网络正常");
            }
            if (th instanceof IllegalArgumentException) {
                return new DownloadException(th, ERROR.HTTP_ERROR, "网络异常，请确认网络正常");
            }
            if (th instanceof IOException) {
                return new DownloadException(th, ERROR.NETWORK_SOCKET, "网络超时，请稍后重试");
            }
            return new DownloadException(th, 1000, "网络异常，请确认网络正常");
        }
    }
}
