package com.amazonaws.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.didi.hummer.adapter.navigator.impl.DefaultNavigatorAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils {
    private static final Pattern DECODED_CHARACTERS_PATTERN;
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Pattern ENCODED_CHARACTERS_PATTERN = Pattern.compile(Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote("%7E") + "|" + Pattern.quote("%2F"));
    private static final int HTTP_STATUS_OK = 200;
    private static final int PORT_HTTP = 80;
    private static final int PORT_HTTPS = 443;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote("%2A"));
        sb.append("|");
        sb.append(Pattern.quote("%2B"));
        sb.append("|");
        DECODED_CHARACTERS_PATTERN = Pattern.compile(sb.toString());
    }

    public static String urlEncode(String str, boolean z) {
        if (str == null) {
            return "";
        }
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = ENCODED_CHARACTERS_PATTERN.matcher(encode);
            StringBuffer stringBuffer = new StringBuffer(encode.length());
            while (matcher.find()) {
                String group = matcher.group(0);
                if ("+".equals(group)) {
                    group = "%20";
                } else if ("*".equals(group)) {
                    group = "%2A";
                } else if ("%7E".equals(group)) {
                    group = "~";
                } else if (z && "%2F".equals(group)) {
                    group = "/";
                }
                matcher.appendReplacement(stringBuffer, group);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String lowerCase = StringUtils.lowerCase(uri.getScheme());
        int port = uri.getPort();
        if (port <= 0) {
            return false;
        }
        if ("http".equals(lowerCase) && port == 80) {
            return false;
        }
        if (!DefaultNavigatorAdapter.SCHEME_HTTPS.equals(lowerCase) || port != PORT_HTTPS) {
            return true;
        }
        return false;
    }

    public static boolean usePayloadForQueryParameters(Request<?> request) {
        return HttpMethodName.POST.equals(request.getHttpMethod()) && (request.getContent() == null);
    }

    public static String encodeParameters(Request<?> request) {
        String str;
        if (request.getParameters().isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        try {
            for (Map.Entry entry : request.getParameters().entrySet()) {
                String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
                String str2 = (String) entry.getValue();
                if (str2 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str2, "UTF-8");
                }
                if (!z) {
                    sb.append("&");
                } else {
                    z = false;
                }
                sb.append(encode);
                sb.append("=");
                sb.append(str);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String appendUri(String str, String str2) {
        return appendUri(str, str2, false);
    }

    public static String appendUri(String str, String str2, boolean z) {
        if (str2 != null && str2.length() > 0) {
            if (str2.startsWith("/")) {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } else if (!str.endsWith("/")) {
                str = str + "/";
            }
            String urlEncode = urlEncode(str2, true);
            if (z) {
                urlEncode = urlEncode.replace("//", "/%2F");
            }
            return str + urlEncode;
        } else if (str.endsWith("/")) {
            return str;
        } else {
            return str + "/";
        }
    }

    public static String appendUriEncoded(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + str2;
    }

    public static InputStream fetchFile(URI uri, ClientConfiguration clientConfiguration) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(uri.toURL().openConnection());
        httpURLConnection.setConnectTimeout(getConnectionTimeout(clientConfiguration));
        httpURLConnection.setReadTimeout(getSocketTimeout(clientConfiguration));
        httpURLConnection.addRequestProperty("User-Agent", getUserAgent(clientConfiguration));
        if (httpURLConnection.getResponseCode() == HTTP_STATUS_OK) {
            return httpURLConnection.getInputStream();
        }
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream != null) {
            errorStream.close();
        }
        httpURLConnection.disconnect();
        throw new IOException("Error fetching file from " + uri + ": " + httpURLConnection.getResponseMessage());
    }

    static String getUserAgent(ClientConfiguration clientConfiguration) {
        String userAgent = clientConfiguration != null ? clientConfiguration.getUserAgent() : null;
        if (userAgent == null) {
            return ClientConfiguration.DEFAULT_USER_AGENT;
        }
        if (ClientConfiguration.DEFAULT_USER_AGENT.equals(userAgent)) {
            return userAgent;
        }
        return userAgent + ", " + ClientConfiguration.DEFAULT_USER_AGENT;
    }

    static int getConnectionTimeout(ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return clientConfiguration.getConnectionTimeout();
        }
        return 15000;
    }

    static int getSocketTimeout(ClientConfiguration clientConfiguration) {
        if (clientConfiguration != null) {
            return clientConfiguration.getSocketTimeout();
        }
        return 15000;
    }
}