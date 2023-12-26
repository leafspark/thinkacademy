package com.yanzhenjie.andserver.http;

import com.yanzhenjie.andserver.DispatcherHandler;
import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.http.cookie.CookieProcessor;
import com.yanzhenjie.andserver.http.cookie.StandardCookieProcessor;
import com.yanzhenjie.andserver.http.session.Session;
import com.yanzhenjie.andserver.http.session.SessionManager;
import com.yanzhenjie.andserver.util.AcceptLanguage;
import com.yanzhenjie.andserver.util.CollectionUtils;
import com.yanzhenjie.andserver.util.HttpDateFormat;
import com.yanzhenjie.andserver.util.HttpHeaders;
import com.yanzhenjie.andserver.util.IOUtils;
import com.yanzhenjie.andserver.util.LinkedMultiValueMap;
import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.MultiValueMap;
import com.yanzhenjie.andserver.util.ObjectUtils;
import com.yanzhenjie.andserver.util.StringUtils;
import com.yanzhenjie.andserver.util.UrlCoder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.Charsets;
import org.apache.httpcore.Header;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpEntityEnclosingRequest;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.RequestLine;

public class StandardRequest implements HttpRequest {
    private static final CookieProcessor COOKIE_PROCESSOR = new StandardCookieProcessor();
    private boolean isParsedAccept;
    private boolean isParsedLocale;
    private boolean isParsedParameter;
    private boolean isParsedQuery;
    private boolean isParsedUri;
    private List<MediaType> mAccepts;
    private HttpContext mContext;
    private DispatcherHandler mHandler;
    private List<Locale> mLocales;
    private MultiValueMap<String, String> mParameter;
    private MultiValueMap<String, String> mQuery;
    private HttpRequest mRequest;
    private RequestLine mRequestLine;
    private SessionManager mSessionManager;
    private Uri mUri;

    public StandardRequest(HttpRequest httpRequest, HttpContext httpContext, DispatcherHandler dispatcherHandler, SessionManager sessionManager) {
        this.mRequest = httpRequest;
        this.mContext = httpContext;
        this.mHandler = dispatcherHandler;
        this.mRequestLine = httpRequest.getRequestLine();
        this.mSessionManager = sessionManager;
    }

    public HttpMethod getMethod() {
        return HttpMethod.reverse(this.mRequestLine.getMethod());
    }

    public String getURI() {
        if (this.isParsedUri) {
            return this.mUri.toString();
        }
        String uri = this.mRequestLine.getUri();
        return StringUtils.isEmpty(uri) ? "/" : uri;
    }

    private void parseUri() {
        if (!this.isParsedUri) {
            this.mUri = Uri.newBuilder(getURI()).build();
            if (!this.isParsedUri) {
                this.isParsedUri = true;
            }
        }
    }

    public void setPath(String str) {
        parseUri();
        this.mUri = this.mUri.builder().setPath(str).build();
    }

    public String getPath() {
        parseUri();
        return this.mUri.getPath();
    }

    public List<String> getQueryNames() {
        parseQuery();
        return new LinkedList(this.mQuery.keySet());
    }

    public String getQuery(String str) {
        parseQuery();
        return this.mQuery.getFirst(str);
    }

    public List<String> getQueries(String str) {
        parseQuery();
        List<String> list = (List) this.mQuery.get(str);
        return ObjectUtils.isEmpty((Object) list) ? Collections.emptyList() : list;
    }

    public MultiValueMap<String, String> getQuery() {
        parseQuery();
        return this.mQuery;
    }

    private void parseQuery() {
        if (!this.isParsedQuery) {
            parseUri();
            this.mQuery = this.mUri.getParams();
            this.isParsedQuery = true;
        }
    }

    public List<String> getHeaderNames() {
        Header[] allHeaders = this.mRequest.getAllHeaders();
        if (ObjectUtils.isEmpty((Object[]) allHeaders)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Header name : allHeaders) {
            arrayList.add(name.getName());
        }
        return arrayList;
    }

    public String getHeader(String str) {
        Header firstHeader = this.mRequest.getFirstHeader(str);
        if (firstHeader == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public List<String> getHeaders(String str) {
        Header[] headers = this.mRequest.getHeaders(str);
        if (ObjectUtils.isEmpty((Object[]) headers)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Header value : headers) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public long getDateHeader(String str) {
        Header firstHeader = this.mRequest.getFirstHeader(str);
        if (firstHeader == null) {
            return -1;
        }
        String value = firstHeader.getValue();
        long parseDate = HttpDateFormat.parseDate(value);
        if (parseDate != -1) {
            return parseDate;
        }
        throw new IllegalStateException(String.format("The %s cannot be converted to date.", new Object[]{value}));
    }

    public int getIntHeader(String str) {
        Header firstHeader = this.mRequest.getFirstHeader(str);
        if (firstHeader == null) {
            return -1;
        }
        try {
            return Integer.parseInt(firstHeader.getValue());
        } catch (NumberFormatException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public MediaType getAccept() {
        List<MediaType> accepts = getAccepts();
        if (accepts.isEmpty()) {
            return null;
        }
        return accepts.get(0);
    }

    public List<MediaType> getAccepts() {
        parseAccept();
        return this.mAccepts;
    }

    private void parseAccept() {
        if (!this.isParsedAccept) {
            this.mAccepts = new ArrayList();
            Header[] headers = this.mRequest.getHeaders(HttpHeaders.ACCEPT);
            if (!ObjectUtils.isEmpty((Object[]) headers)) {
                for (Header value : headers) {
                    this.mAccepts.addAll(MediaType.parseMediaTypes(value.getValue()));
                }
            }
            if (this.mAccepts.isEmpty()) {
                this.mAccepts.add(MediaType.ALL);
            }
            this.isParsedAccept = true;
        }
    }

    public Locale getAcceptLanguage() {
        return getAcceptLanguages().get(0);
    }

    public List<Locale> getAcceptLanguages() {
        parseLocale();
        return this.mLocales;
    }

    private void parseLocale() {
        if (!this.isParsedLocale) {
            this.mLocales = new ArrayList();
            Header[] headers = this.mRequest.getHeaders(HttpHeaders.ACCEPT_LANGUAGE);
            if (!ObjectUtils.isEmpty((Object[]) headers)) {
                for (Header value : headers) {
                    for (AcceptLanguage locale : AcceptLanguage.parse(value.getValue())) {
                        this.mLocales.add(locale.getLocale());
                    }
                }
            }
            if (this.mLocales.isEmpty()) {
                this.mLocales.add(Locale.getDefault());
            }
            this.isParsedLocale = true;
        }
    }

    public String getCookieValue(String str) {
        Cookie cookie = getCookie(str);
        if (cookie != null) {
            return cookie.getValue();
        }
        return null;
    }

    public Cookie getCookie(String str) {
        List<Cookie> cookies = getCookies();
        if (ObjectUtils.isEmpty((Object) cookies)) {
            return null;
        }
        for (Cookie next : cookies) {
            if (str.equalsIgnoreCase(next.getName())) {
                return next;
            }
        }
        return null;
    }

    public List<Cookie> getCookies() {
        return COOKIE_PROCESSOR.parseCookieHeader(this.mRequest.getHeaders(HttpHeaders.COOKIE));
    }

    public long getContentLength() {
        String header = getHeader(HttpHeaders.CONTENT_LENGTH);
        if (StringUtils.isEmpty(header)) {
            return -1;
        }
        try {
            return Long.parseLong(header);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public MediaType getContentType() {
        String header = getHeader(HttpHeaders.CONTENT_TYPE);
        if (StringUtils.isEmpty(header)) {
            return null;
        }
        return MediaType.valueOf(header);
    }

    public List<String> getParameterNames() {
        parseParameter();
        LinkedList linkedList = new LinkedList(this.mParameter.keySet());
        List<String> queryNames = getQueryNames();
        if (!queryNames.isEmpty()) {
            linkedList.addAll(queryNames);
        }
        return linkedList;
    }

    public String getParameter(String str) {
        parseParameter();
        String first = this.mParameter.getFirst(str);
        return StringUtils.isEmpty(first) ? getQuery(str) : first;
    }

    public List<String> getParameters(String str) {
        parseParameter();
        List<String> list = (List) this.mParameter.get(str);
        return CollectionUtils.isEmpty((Collection<?>) list) ? getQueries(str) : list;
    }

    public MultiValueMap<String, String> getParameter() {
        parseParameter();
        return this.mParameter.isEmpty() ? getQuery() : this.mParameter;
    }

    private void parseParameter() {
        String str;
        if (!this.isParsedParameter) {
            if (!getMethod().allowBody()) {
                this.mParameter = new LinkedMultiValueMap();
                return;
            }
            if (MediaType.APPLICATION_FORM_URLENCODED.includes(getContentType())) {
                try {
                    RequestBody body = getBody();
                    if (body == null) {
                        str = "";
                    } else {
                        str = body.string();
                    }
                    this.mParameter = parseParameters(str);
                } catch (Exception unused) {
                }
            }
            if (this.mParameter == null) {
                this.mParameter = new LinkedMultiValueMap();
            }
            this.isParsedParameter = true;
        }
    }

    public RequestBody getBody() {
        HttpEntity entity;
        if (getMethod().allowBody()) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = this.mRequest;
            if (!(httpEntityEnclosingRequest instanceof HttpEntityEnclosingRequest) || (entity = httpEntityEnclosingRequest.getEntity()) == null) {
                return null;
            }
            return new EntityToBody(entity);
        }
        throw new UnsupportedOperationException("This method does not allow body.");
    }

    public Session getValidSession() {
        Session session = getSession();
        if (session == null) {
            session = this.mSessionManager.createSession();
        } else if (session.isValid()) {
            session = this.mSessionManager.createSession();
        }
        setAttribute(HttpContext.REQUEST_CREATED_SESSION, session);
        return session;
    }

    public Session getSession() {
        String str;
        Object attribute = getAttribute(HttpContext.REQUEST_CREATED_SESSION);
        if (attribute instanceof Session) {
            return (Session) attribute;
        }
        List<Cookie> cookies = getCookies();
        if (CollectionUtils.isEmpty((Collection<?>) cookies)) {
            return null;
        }
        Iterator<Cookie> it = cookies.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            Cookie next = it.next();
            if (HttpRequest.SESSION_NAME.equalsIgnoreCase(next.getName())) {
                str = next.getValue();
                break;
            }
        }
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            return this.mSessionManager.findSession(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String changeSessionId() {
        Session session = getSession();
        if (session != null) {
            this.mSessionManager.changeSessionId(session);
            return session.getId();
        }
        throw new IllegalStateException("No session associated with this request.");
    }

    public boolean isSessionValid() {
        Session session = getSession();
        return session != null && session.isValid();
    }

    public RequestDispatcher getRequestDispatcher(String str) {
        return this.mHandler.getRequestDispatcher(this, str);
    }

    public HttpContext getContext() {
        return this.mContext;
    }

    public Object getAttribute(String str) {
        return this.mContext.getAttribute(str);
    }

    public void setAttribute(String str, Object obj) {
        this.mContext.setAttribute(str, obj);
    }

    public Object removeAttribute(String str) {
        return this.mContext.removeAttribute(str);
    }

    private static MultiValueMap<String, String> parseParameters(String str) {
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreElements()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("=");
            if (indexOf > 0 && indexOf < nextToken.length() - 1) {
                linkedMultiValueMap.add(nextToken.substring(0, indexOf), UrlCoder.urlDecode(nextToken.substring(indexOf + 1), Charsets.UTF_8));
            }
        }
        return linkedMultiValueMap;
    }

    private static class EntityToBody implements RequestBody {
        private HttpEntity mEntity;

        private EntityToBody(HttpEntity httpEntity) {
            this.mEntity = httpEntity;
        }

        public String contentEncoding() {
            Header contentType = this.mEntity.getContentType();
            if (contentType == null) {
                return "";
            }
            return contentType.getValue();
        }

        public long length() {
            return this.mEntity.getContentLength();
        }

        public MediaType contentType() {
            Header contentType = this.mEntity.getContentType();
            if (contentType == null) {
                return null;
            }
            return MediaType.valueOf(contentType.getValue());
        }

        public InputStream stream() throws IOException {
            InputStream content = this.mEntity.getContent();
            return contentEncoding().toLowerCase().contains("gzip") ? new GZIPInputStream(content) : content;
        }

        public String string() throws IOException {
            Charset charset;
            MediaType contentType = contentType();
            if (contentType == null) {
                charset = null;
            } else {
                charset = contentType.getCharset();
            }
            if (charset == null) {
                return IOUtils.toString(stream());
            }
            return IOUtils.toString(stream(), charset);
        }
    }
}
