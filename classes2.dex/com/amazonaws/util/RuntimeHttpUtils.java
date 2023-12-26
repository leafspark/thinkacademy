package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.Request;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class RuntimeHttpUtils {
    private static final String COMMA = ", ";
    private static final String SPACE = " ";

    public static URI toUri(String str, ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return toUri(str, clientConfiguration.getProtocol());
        }
        throw new IllegalArgumentException("ClientConfiguration cannot be null");
    }

    public static URI toUri(String str, Protocol protocol) {
        if (str != null) {
            if (!str.contains("://")) {
                str = protocol.toString() + "://" + str;
            }
            try {
                return new URI(str);
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            throw new IllegalArgumentException("endpoint cannot be null");
        }
    }

    public static URL convertRequestToUrl(Request<?> request, boolean z, boolean z2) {
        String str;
        if (z2) {
            str = HttpUtils.urlEncode(request.getResourcePath(), true);
        } else {
            str = request.getResourcePath();
        }
        if (z && str.startsWith("/")) {
            str = str.substring(1);
        }
        String replaceAll = ("/" + str).replaceAll("(?<=/)/", "%2F");
        StringBuilder sb = new StringBuilder(request.getEndpoint().toString());
        sb.append(replaceAll);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : request.getParameters().entrySet()) {
            sb2.append(sb2.length() > 0 ? "&" : "?");
            sb2.append(HttpUtils.urlEncode((String) entry.getKey(), false));
            sb2.append("=");
            sb2.append(HttpUtils.urlEncode((String) entry.getValue(), false));
        }
        sb.append(sb2.toString());
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }
}
