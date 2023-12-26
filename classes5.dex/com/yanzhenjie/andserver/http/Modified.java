package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.util.HttpDateFormat;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.StatusCode;
import com.yanzhenjie.andserver.util.StringUtils;
import io.ktor.client.utils.CacheControl;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Modified implements HttpHeaders {
    private static final Pattern ETAG_PATTERN = Pattern.compile("\\*|\\s*((W\\/)?(\"[^\"]*\"))\\s*,?");
    private boolean isNotModified;
    private HttpRequest mRequest;
    private HttpResponse mResponse;

    public Modified(HttpRequest httpRequest, HttpResponse httpResponse) {
        this.mRequest = httpRequest;
        this.mResponse = httpResponse;
    }

    public boolean process(long j) {
        return process((String) null, j);
    }

    public boolean process(String str) {
        return process(str, -1);
    }

    public boolean process(String str, long j) {
        boolean z = true;
        if (this.isNotModified) {
            return true;
        }
        boolean validateIfUnmodifiedSince = validateIfUnmodifiedSince(j);
        int i = StatusCode.SC_LENGTH_REQUIRED;
        if (validateIfUnmodifiedSince) {
            if (!this.isNotModified) {
                this.mResponse.setStatus(StatusCode.SC_LENGTH_REQUIRED);
            }
            return this.isNotModified;
        }
        if (!validateIfNoneMatch(str)) {
            validateIfModifiedSince(j);
        }
        HttpMethod method = this.mRequest.getMethod();
        if (!(method == HttpMethod.GET || method == HttpMethod.HEAD)) {
            z = false;
        }
        if (this.isNotModified) {
            HttpResponse httpResponse = this.mResponse;
            if (z) {
                i = 304;
            }
            httpResponse.setStatus(i);
        }
        if (z) {
            if (j > 0 && this.mResponse.getHeader(HttpHeaders.LAST_MODIFIED) == null) {
                this.mResponse.setDateHeader(HttpHeaders.LAST_MODIFIED, j);
            }
            if (StringUtils.hasLength(str) && this.mResponse.getHeader(HttpHeaders.ETAG) == null) {
                this.mResponse.setHeader(HttpHeaders.ETAG, padETagIfNecessary(str));
            }
            this.mResponse.setHeader(HttpHeaders.CACHE_CONTROL, CacheControl.PRIVATE);
        }
        return this.isNotModified;
    }

    private boolean validateIfNoneMatch(String str) {
        if (!StringUtils.hasLength(str)) {
            return false;
        }
        List<String> headers = this.mRequest.getHeaders(HttpHeaders.IF_NONE_MATCH);
        if (headers.isEmpty()) {
            return false;
        }
        String padETagIfNecessary = padETagIfNecessary(str);
        for (String matcher : headers) {
            Matcher matcher2 = ETAG_PATTERN.matcher(matcher);
            while (true) {
                if (matcher2.find()) {
                    if (StringUtils.hasLength(matcher2.group()) && padETagIfNecessary.replaceFirst("^W/", "").equals(matcher2.group(3))) {
                        this.isNotModified = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return true;
    }

    private String padETagIfNecessary(String str) {
        if (!StringUtils.hasLength(str)) {
            return str;
        }
        if ((str.startsWith("\"") || str.startsWith("W/\"")) && str.endsWith("\"")) {
            return str;
        }
        return "\"" + str + "\"";
    }

    private boolean validateIfModifiedSince(long j) {
        boolean z = false;
        if (j < 0) {
            return false;
        }
        long parseDateHeader = parseDateHeader(HttpHeaders.IF_MODIFIED_SINCE);
        if (parseDateHeader == -1) {
            return false;
        }
        if (parseDateHeader >= j) {
            z = true;
        }
        this.isNotModified = z;
        return true;
    }

    private boolean validateIfUnmodifiedSince(long j) {
        boolean z = false;
        if (j < 0) {
            return false;
        }
        long parseDateHeader = parseDateHeader(HttpHeaders.IF_UNMODIFIED_SINCE);
        if (parseDateHeader == -1) {
            return false;
        }
        if (parseDateHeader >= j) {
            z = true;
        }
        this.isNotModified = z;
        return true;
    }

    private long parseDateHeader(String str) {
        int indexOf;
        try {
            return this.mRequest.getDateHeader(str);
        } catch (IllegalStateException unused) {
            String header = this.mRequest.getHeader(str);
            if (!StringUtils.isEmpty(header) && (indexOf = header.indexOf(59)) != -1) {
                return parseDateValue(header.substring(0, indexOf));
            }
            return -1;
        }
    }

    private long parseDateValue(String str) {
        if (str != null && str.length() >= 3) {
            return HttpDateFormat.parseDate(str);
        }
        return -1;
    }
}
