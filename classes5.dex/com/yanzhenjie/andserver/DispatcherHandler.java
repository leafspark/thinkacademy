package com.yanzhenjie.andserver;

import android.content.Context;
import android.util.Log;
import com.yanzhenjie.andserver.error.NotFoundException;
import com.yanzhenjie.andserver.framework.ExceptionResolver;
import com.yanzhenjie.andserver.framework.HandlerInterceptor;
import com.yanzhenjie.andserver.framework.MessageConverter;
import com.yanzhenjie.andserver.framework.ModifiedInterceptor;
import com.yanzhenjie.andserver.framework.RequestErrorCall;
import com.yanzhenjie.andserver.framework.config.Multipart;
import com.yanzhenjie.andserver.framework.handler.HandlerAdapter;
import com.yanzhenjie.andserver.framework.handler.RequestHandler;
import com.yanzhenjie.andserver.framework.view.ViewResolver;
import com.yanzhenjie.andserver.http.RequestDispatcher;
import com.yanzhenjie.andserver.http.RequestWrapper;
import com.yanzhenjie.andserver.http.StandardContext;
import com.yanzhenjie.andserver.http.StandardRequest;
import com.yanzhenjie.andserver.http.StandardResponse;
import com.yanzhenjie.andserver.http.cookie.Cookie;
import com.yanzhenjie.andserver.http.multipart.MultipartResolver;
import com.yanzhenjie.andserver.http.session.Session;
import com.yanzhenjie.andserver.http.session.SessionManager;
import com.yanzhenjie.andserver.http.session.StandardSessionManager;
import com.yanzhenjie.andserver.register.Register;
import com.yanzhenjie.andserver.util.Assert;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.apache.httpcore.HttpRequest;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.protocol.HttpContext;
import org.apache.httpcore.protocol.HttpRequestHandler;

public class DispatcherHandler implements HttpRequestHandler, Register {
    private List<HandlerAdapter> mAdapterList = new LinkedList();
    private final Context mContext;
    private MessageConverter mConverter;
    private List<HandlerInterceptor> mInterceptorList = new LinkedList();
    private Multipart mMultipart;
    private ExceptionResolver mResolver;
    private SessionManager mSessionManager;
    private ViewResolver mViewResolver;
    private List<RequestErrorCall> onRequestErrorList = new LinkedList();

    public DispatcherHandler(Context context) {
        this.mContext = context;
        this.mSessionManager = new StandardSessionManager(context);
        this.mViewResolver = new ViewResolver();
        this.mResolver = ExceptionResolver.DEFAULT;
        this.mInterceptorList.add(new ModifiedInterceptor());
    }

    public void addAdapter(HandlerAdapter handlerAdapter) {
        Assert.notNull(handlerAdapter, "The adapter cannot be null.");
        if (!this.mAdapterList.contains(handlerAdapter)) {
            this.mAdapterList.add(handlerAdapter);
        }
    }

    public void addErrorCall(RequestErrorCall requestErrorCall) {
        Assert.notNull(requestErrorCall, "The requestErrorCall cannot be null.");
        if (!this.onRequestErrorList.contains(requestErrorCall)) {
            this.onRequestErrorList.add(requestErrorCall);
        }
    }

    public void addInterceptor(HandlerInterceptor handlerInterceptor) {
        Assert.notNull(handlerInterceptor, "The interceptor cannot be null.");
        if (!this.mInterceptorList.contains(handlerInterceptor)) {
            this.mInterceptorList.add(handlerInterceptor);
        }
    }

    public void setConverter(MessageConverter messageConverter) {
        this.mConverter = messageConverter;
        this.mViewResolver = new ViewResolver(messageConverter);
    }

    public void setResolver(ExceptionResolver exceptionResolver) {
        Assert.notNull(exceptionResolver, "The exceptionResolver cannot be null.");
        this.mResolver = exceptionResolver;
    }

    public void setMultipart(Multipart multipart) {
        this.mMultipart = multipart;
    }

    public void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        handle(new StandardRequest(httpRequest, new StandardContext(httpContext), this, this.mSessionManager), new StandardResponse(httpResponse));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:24|25|26|(2:28|(2:31|29))|33|34|38|39|(1:50)) */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r2 = new com.yanzhenjie.andserver.error.ServerInternalException((java.lang.Throwable) r1);
        r7.setStatus(500);
        r7.setBody(new com.yanzhenjie.andserver.framework.body.StringBody(r2.getMessage()));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0085 */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handle(com.yanzhenjie.andserver.http.HttpRequest r6, com.yanzhenjie.andserver.http.HttpResponse r7) {
        /*
            r5 = this;
            com.yanzhenjie.andserver.http.multipart.StandardMultipartResolver r0 = new com.yanzhenjie.andserver.http.multipart.StandardMultipartResolver
            r0.<init>()
            boolean r1 = r0.isMultipart(r6)     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x0012
            r5.configMultipart(r0)     // Catch:{ all -> 0x0061 }
            com.yanzhenjie.andserver.http.multipart.MultipartRequest r6 = r0.resolveMultipart(r6)     // Catch:{ all -> 0x0061 }
        L_0x0012:
            com.yanzhenjie.andserver.framework.handler.HandlerAdapter r1 = r5.getHandlerAdapter(r6)     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x0057
            com.yanzhenjie.andserver.framework.handler.RequestHandler r1 = r1.getHandler(r6)     // Catch:{ all -> 0x0061 }
            if (r1 == 0) goto L_0x004d
            boolean r2 = r5.preHandle(r6, r7, r1)     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x002e
            boolean r7 = r6 instanceof com.yanzhenjie.andserver.http.multipart.MultipartRequest
            if (r7 == 0) goto L_0x002d
            com.yanzhenjie.andserver.http.multipart.MultipartRequest r6 = (com.yanzhenjie.andserver.http.multipart.MultipartRequest) r6
            r0.cleanupMultipart(r6)
        L_0x002d:
            return
        L_0x002e:
            java.lang.String r2 = "android.context"
            android.content.Context r3 = r5.mContext     // Catch:{ all -> 0x0061 }
            r6.setAttribute(r2, r3)     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = "http.message.converter"
            com.yanzhenjie.andserver.framework.MessageConverter r3 = r5.mConverter     // Catch:{ all -> 0x0061 }
            r6.setAttribute(r2, r3)     // Catch:{ all -> 0x0061 }
            com.yanzhenjie.andserver.framework.view.View r1 = r1.handle(r6, r7)     // Catch:{ all -> 0x0061 }
            com.yanzhenjie.andserver.framework.view.ViewResolver r2 = r5.mViewResolver     // Catch:{ all -> 0x0061 }
            r2.resolve(r1, r6, r7)     // Catch:{ all -> 0x0061 }
            r5.processSession(r6, r7)     // Catch:{ all -> 0x0061 }
            boolean r7 = r6 instanceof com.yanzhenjie.andserver.http.multipart.MultipartRequest
            if (r7 == 0) goto L_0x00ae
            goto L_0x00a9
        L_0x004d:
            com.yanzhenjie.andserver.error.NotFoundException r1 = new com.yanzhenjie.andserver.error.NotFoundException     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r6.getPath()     // Catch:{ all -> 0x0061 }
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0061 }
            throw r1     // Catch:{ all -> 0x0061 }
        L_0x0057:
            com.yanzhenjie.andserver.error.NotFoundException r1 = new com.yanzhenjie.andserver.error.NotFoundException     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = r6.getPath()     // Catch:{ all -> 0x0061 }
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0061 }
            throw r1     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r1 = move-exception
            boolean r2 = r1 instanceof com.yanzhenjie.andserver.error.BasicException     // Catch:{ Exception -> 0x0085 }
            if (r2 == 0) goto L_0x0085
            java.util.List<com.yanzhenjie.andserver.framework.RequestErrorCall> r2 = r5.onRequestErrorList     // Catch:{ Exception -> 0x0085 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0085 }
        L_0x006c:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0085 }
            if (r3 == 0) goto L_0x0085
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0085 }
            com.yanzhenjie.andserver.framework.RequestErrorCall r3 = (com.yanzhenjie.andserver.framework.RequestErrorCall) r3     // Catch:{ Exception -> 0x0085 }
            r4 = r1
            com.yanzhenjie.andserver.error.BasicException r4 = (com.yanzhenjie.andserver.error.BasicException) r4     // Catch:{ Exception -> 0x0085 }
            int r4 = r4.getStatusCode()     // Catch:{ Exception -> 0x0085 }
            r3.onRequestError(r4, r6, r7)     // Catch:{ Exception -> 0x0085 }
            goto L_0x006c
        L_0x0083:
            r7 = move-exception
            goto L_0x00af
        L_0x0085:
            com.yanzhenjie.andserver.framework.ExceptionResolver r2 = r5.mResolver     // Catch:{ Exception -> 0x008b }
            r2.onResolve(r6, r7, r1)     // Catch:{ Exception -> 0x008b }
            goto L_0x00a2
        L_0x008b:
            r1 = move-exception
            com.yanzhenjie.andserver.error.ServerInternalException r2 = new com.yanzhenjie.andserver.error.ServerInternalException     // Catch:{ all -> 0x0083 }
            r2.<init>((java.lang.Throwable) r1)     // Catch:{ all -> 0x0083 }
            r1 = 500(0x1f4, float:7.0E-43)
            r7.setStatus(r1)     // Catch:{ all -> 0x0083 }
            com.yanzhenjie.andserver.framework.body.StringBody r1 = new com.yanzhenjie.andserver.framework.body.StringBody     // Catch:{ all -> 0x0083 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0083 }
            r1.<init>(r2)     // Catch:{ all -> 0x0083 }
            r7.setBody(r1)     // Catch:{ all -> 0x0083 }
        L_0x00a2:
            r5.processSession(r6, r7)     // Catch:{ all -> 0x0083 }
            boolean r7 = r6 instanceof com.yanzhenjie.andserver.http.multipart.MultipartRequest
            if (r7 == 0) goto L_0x00ae
        L_0x00a9:
            com.yanzhenjie.andserver.http.multipart.MultipartRequest r6 = (com.yanzhenjie.andserver.http.multipart.MultipartRequest) r6
            r0.cleanupMultipart(r6)
        L_0x00ae:
            return
        L_0x00af:
            boolean r1 = r6 instanceof com.yanzhenjie.andserver.http.multipart.MultipartRequest
            if (r1 == 0) goto L_0x00b8
            com.yanzhenjie.andserver.http.multipart.MultipartRequest r6 = (com.yanzhenjie.andserver.http.multipart.MultipartRequest) r6
            r0.cleanupMultipart(r6)
        L_0x00b8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.andserver.DispatcherHandler.handle(com.yanzhenjie.andserver.http.HttpRequest, com.yanzhenjie.andserver.http.HttpResponse):void");
    }

    private void configMultipart(MultipartResolver multipartResolver) {
        Multipart multipart = this.mMultipart;
        if (multipart != null) {
            long allFileMaxSize = multipart.getAllFileMaxSize();
            if (allFileMaxSize == -1 || allFileMaxSize > 0) {
                multipartResolver.setAllFileMaxSize(allFileMaxSize);
            }
            long fileMaxSize = this.mMultipart.getFileMaxSize();
            if (fileMaxSize == -1 || fileMaxSize > 0) {
                multipartResolver.setFileMaxSize(fileMaxSize);
            }
            int maxInMemorySize = this.mMultipart.getMaxInMemorySize();
            if (maxInMemorySize > 0) {
                multipartResolver.setMaxInMemorySize(maxInMemorySize);
            }
            File uploadTempDir = this.mMultipart.getUploadTempDir();
            if (uploadTempDir != null) {
                multipartResolver.setUploadTempDir(uploadTempDir);
            }
        }
    }

    private HandlerAdapter getHandlerAdapter(com.yanzhenjie.andserver.http.HttpRequest httpRequest) {
        for (HandlerAdapter next : this.mAdapterList) {
            if (next.intercept(httpRequest)) {
                return next;
            }
        }
        return null;
    }

    private boolean preHandle(com.yanzhenjie.andserver.http.HttpRequest httpRequest, com.yanzhenjie.andserver.http.HttpResponse httpResponse, RequestHandler requestHandler) throws Exception {
        for (HandlerInterceptor onIntercept : this.mInterceptorList) {
            if (onIntercept.onIntercept(httpRequest, httpResponse, requestHandler)) {
                return true;
            }
        }
        return false;
    }

    public RequestDispatcher getRequestDispatcher(com.yanzhenjie.andserver.http.HttpRequest httpRequest, String str) {
        com.yanzhenjie.andserver.http.HttpRequest httpRequest2 = httpRequest;
        while (httpRequest2 instanceof RequestWrapper) {
            httpRequest2 = ((RequestWrapper) httpRequest).getRequest();
        }
        ((StandardRequest) httpRequest2).setPath(str);
        if (getHandlerAdapter(httpRequest2) != null) {
            return new RequestDispatcher() {
                public void forward(com.yanzhenjie.andserver.http.HttpRequest httpRequest, com.yanzhenjie.andserver.http.HttpResponse httpResponse) {
                    DispatcherHandler.this.handle(httpRequest, httpResponse);
                }
            };
        }
        throw new NotFoundException(httpRequest.getPath());
    }

    private void processSession(com.yanzhenjie.andserver.http.HttpRequest httpRequest, com.yanzhenjie.andserver.http.HttpResponse httpResponse) {
        Object attribute = httpRequest.getAttribute(com.yanzhenjie.andserver.http.HttpContext.REQUEST_CREATED_SESSION);
        if (attribute instanceof Session) {
            Session session = (Session) attribute;
            try {
                this.mSessionManager.add(session);
            } catch (IOException e) {
                Log.e(AndServer.TAG, "Session persistence failed.", e);
            }
            Cookie cookie = new Cookie(com.yanzhenjie.andserver.http.HttpRequest.SESSION_NAME, session.getId());
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            httpResponse.addCookie(cookie);
        }
    }
}
