package com.bonree.sdk.m;

import android.text.TextUtils;
import com.bonree.sdk.be.g;
import com.bonree.sdk.n.b;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLException;

public final class c {
    private static final String a = "SocketException: Failed host lookup";
    private static final String b = "SocketException: OS Error: Connection timed out";
    private static final String c = "SocketException: HTTP connection timed out afte";
    private static final String d = "HandshakeException: Handshake error in client";
    private static final String e = "ERR_CERT_AUTHORITY_INVALID";
    private static final String f = "ERR_SSL_PROTOCOL_ERROR";
    private static final String g = "ERR_SSL_OBSOLETE_VERSION";
    private static final String h = "ERR_NAME_NOT_RESOLVED";
    private static final String i = "ERR_CONNECTION_REFUSED";
    private static final String j = "ERR_CONNECTION_TIMED_OUT";

    public static void a(b bVar, Exception exc) {
        if (exc != null) {
            int a2 = a((Throwable) exc, (com.bonree.sdk.n.c) bVar);
            bVar.a(a2, a(a2, (Throwable) exc));
            bVar.d(exc.toString());
        }
    }

    public static void a(b bVar, Throwable th) {
        if (th != null) {
            int a2 = a(th, (com.bonree.sdk.n.c) bVar);
            bVar.a(a2, a(a2, th));
            bVar.d(th.toString());
        }
    }

    public static int a(Throwable th, com.bonree.sdk.n.c cVar) {
        String message;
        String message2;
        g.a(" throwle message:" + th, new Object[0]);
        if (th instanceof UnknownHostException) {
            cVar.a = 2;
            return 659;
        } else if (th instanceof SocketTimeoutException) {
            String message3 = th.getMessage();
            if (message3 == null || !message3.contains("SSL handshake")) {
                cVar.a = 3;
                return 652;
            }
            cVar.a = 1;
            return 653;
        } else if (th instanceof ConnectException) {
            cVar.a = 3;
            return 652;
        } else if (th instanceof MalformedURLException) {
            cVar.a = 3;
            return 641;
        } else if (th instanceof SSLException) {
            cVar.a = 1;
            return 653;
        } else if (th instanceof UnknownServiceException) {
            cVar.a = 4;
            return 660;
        } else if ((th instanceof SocketException) && (message2 = th.getMessage()) != null && (message2.contains("Connection reset") || message2.contains("recvfrom failed: ECONNRESET (Connection reset by peer)"))) {
            cVar.a = 3;
            return 652;
        } else if (!(th instanceof IOException) || (message = th.getMessage()) == null || !message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            cVar.a = 4;
            return 600;
        } else {
            cVar.a = 3;
            return 641;
        }
    }

    public static int a(String str) {
        g.a(" throw message:" + str, new Object[0]);
        if (TextUtils.isEmpty(str)) {
            return 4;
        }
        if (str.contains(a)) {
            return 2;
        }
        if (str.contains(b) || str.contains(c)) {
            return 3;
        }
        if (str.contains(d)) {
            return 1;
        }
        return 4;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 4;
        }
        if (str.contains(e) || str.contains(f) || str.contains(g)) {
            return 1;
        }
        if (str.contains(h)) {
            return 2;
        }
        if (!str.contains(j) && !str.contains(i)) {
            return 4;
        }
        return 3;
    }

    public static int a(int i2, Throwable th) {
        int a2 = a(th);
        if (i2 != 652) {
            if (i2 != 653) {
                if (i2 != 659) {
                    if (i2 != 660) {
                        switch (i2) {
                            case 641:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 641;
                            case 642:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 642;
                            case 643:
                                if (a2 != 0) {
                                    return a2;
                                }
                                return 643;
                            default:
                                return 600;
                        }
                    } else if (a2 != 0) {
                        return a2;
                    } else {
                        return 600;
                    }
                } else if (a2 != 0) {
                    return a2;
                } else {
                    return 659;
                }
            } else if (a2 != 0) {
                return a2;
            } else {
                return 653;
            }
        } else if (a2 != 0) {
            return a2;
        } else {
            return 110;
        }
    }

    private static int a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return 110;
        }
        String message = th.getMessage();
        if (message == null) {
            return 0;
        }
        if (message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            return 641;
        }
        if (message.contains("recvfrom failed: ECONNRESET (Connection reset by peer)")) {
            return 104;
        }
        if (message.contains("connect failed: ETIMEDOUT (Connection timed out)")) {
            return 110;
        }
        if (message.contains("Connection to") && message.contains("refused")) {
            return 111;
        }
        if (message.contains("Connection reset")) {
            return 102;
        }
        if (message.contains("dns No address associated with hostname")) {
            return 659;
        }
        if (message.contains("Handshake failed")) {
            return 653;
        }
        if (message.contains("ftruncate failed: ENOENT (No such file or directory)")) {
            return 641;
        }
        return 0;
    }
}
