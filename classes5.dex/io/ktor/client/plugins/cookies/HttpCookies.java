package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00060\u0001j\u0002`\u0002:\u0002#$BA\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012-\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000b0\u0006ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0015R8\u0010\u0005\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0002\b\u000b0\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "storage", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "defaults", "", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/util/List;)V", "initializer", "Lkotlinx/coroutines/Job;", "getInitializer$annotations", "()V", "captureHeaderCookies", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "captureHeaderCookies$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "get", "Lio/ktor/http/Cookie;", "requestUrl", "Lio/ktor/http/Url;", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveCookiesFrom", "response", "Lio/ktor/client/statement/HttpResponse;", "saveCookiesFrom$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCookiesWith", "sendCookiesWith$ktor_client_core", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCookies.kt */
public final class HttpCookies implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AttributeKey<HttpCookies> key = new AttributeKey<>("HttpCookies");
    /* access modifiers changed from: private */
    public final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults;
    private final Job initializer = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), (CoroutineStart) null, new HttpCookies$initializer$1(this, (Continuation<? super HttpCookies$initializer$1>) null), 2, (Object) null);
    /* access modifiers changed from: private */
    public final CookiesStorage storage;

    private static /* synthetic */ void getInitializer$annotations() {
    }

    public HttpCookies(CookiesStorage cookiesStorage, List<? extends Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(cookiesStorage, "storage");
        Intrinsics.checkNotNullParameter(list, "defaults");
        this.storage = cookiesStorage;
        this.defaults = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:19:0x0061, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object get(io.ktor.http.Url r6, kotlin.coroutines.Continuation<? super java.util.List<io.ktor.http.Cookie>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.client.plugins.cookies.HttpCookies$get$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$get$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.cookies.HttpCookies$get$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$get$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0064
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r2 = (io.ktor.client.plugins.cookies.HttpCookies) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.Job r7 = r5.initializer
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.join(r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r5
        L_0x0054:
            io.ktor.client.plugins.cookies.CookiesStorage r7 = r2.storage
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r7.get(r6, r0)
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.get(io.ktor.http.Url, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object captureHeaderCookies$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
        /*
            r22 = this;
            r0 = r24
            boolean r1 = r0 instanceof io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1 r1 = (io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r22
            goto L_0x001f
        L_0x0018:
            io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1 r1 = new io.ktor.client.plugins.cookies.HttpCookies$captureHeaderCookies$1
            r2 = r22
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L_0x0045
            if (r4 != r5) goto L_0x003d
            java.lang.Object r4 = r1.L$2
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r6 = r1.L$1
            io.ktor.http.Url r6 = (io.ktor.http.Url) r6
            java.lang.Object r7 = r1.L$0
            io.ktor.client.plugins.cookies.HttpCookies r7 = (io.ktor.client.plugins.cookies.HttpCookies) r7
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00be
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r0)
            io.ktor.http.URLBuilder r0 = r23.getUrl()
            io.ktor.http.URLBuilder r0 = io.ktor.http.URLBuilderKt.clone(r0)
            io.ktor.http.Url r0 = r0.build()
            io.ktor.http.HeadersBuilder r4 = r23.getHeaders()
            io.ktor.http.HttpHeaders r6 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r6 = r6.getCookie()
            java.lang.String r4 = r4.get(r6)
            r6 = 0
            if (r4 == 0) goto L_0x00b4
            r7 = 0
            r8 = 2
            java.util.Map r4 = io.ktor.http.CookieKt.parseClientCookiesHeader$default(r4, r7, r8, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r4.size()
            r6.<init>(r7)
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x007e:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00b2
            java.lang.Object r7 = r4.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            r10 = r8
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r7 = r7.getValue()
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            io.ktor.http.Cookie r7 = new io.ktor.http.Cookie
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 1020(0x3fc, float:1.43E-42)
            r21 = 0
            r9 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r6.add(r7)
            goto L_0x007e
        L_0x00b2:
            java.util.List r6 = (java.util.List) r6
        L_0x00b4:
            if (r6 == 0) goto L_0x00db
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r4 = r6.iterator()
            r6 = r0
            r7 = r2
        L_0x00be:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00db
            java.lang.Object r0 = r4.next()
            io.ktor.http.Cookie r0 = (io.ktor.http.Cookie) r0
            io.ktor.client.plugins.cookies.CookiesStorage r8 = r7.storage
            r1.L$0 = r7
            r1.L$1 = r6
            r1.L$2 = r4
            r1.label = r5
            java.lang.Object r0 = r8.addCookie(r6, r0, r1)
            if (r0 != r3) goto L_0x00be
            return r3
        L_0x00db:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.captureHeaderCookies$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendCookiesWith$ktor_client_core(io.ktor.client.request.HttpRequestBuilder r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$sendCookiesWith$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.http.URLBuilder r6 = r5.getUrl()
            io.ktor.http.URLBuilder r6 = io.ktor.http.URLBuilderKt.clone(r6)
            io.ktor.http.Url r6 = r6.build()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.get(r6, r0)
            if (r6 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.util.List r6 = (java.util.List) r6
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x006e
            io.ktor.http.HeadersBuilder r5 = r5.getHeaders()
            io.ktor.http.HttpHeaders r0 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r0 = r0.getCookie()
            java.lang.String r6 = io.ktor.client.plugins.cookies.HttpCookiesKt.renderClientCookies(r6)
            r5.set(r0, r6)
            goto L_0x007b
        L_0x006e:
            io.ktor.http.HeadersBuilder r5 = r5.getHeaders()
            io.ktor.http.HttpHeaders r6 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r6 = r6.getCookie()
            r5.remove(r6)
        L_0x007b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.sendCookiesWith$ktor_client_core(io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveCookiesFrom$ktor_client_core(io.ktor.client.statement.HttpResponse r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = (io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1 r0 = new io.ktor.client.plugins.cookies.HttpCookies$saveCookiesFrom$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r2 = r0.L$1
            io.ktor.http.Url r2 = (io.ktor.http.Url) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.client.plugins.cookies.HttpCookies r4 = (io.ktor.client.plugins.cookies.HttpCookies) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0057
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.request.HttpRequest r8 = io.ktor.client.statement.HttpResponseKt.getRequest(r7)
            io.ktor.http.Url r8 = r8.getUrl()
            io.ktor.http.HttpMessage r7 = (io.ktor.http.HttpMessage) r7
            java.util.List r7 = io.ktor.http.HttpMessagePropertiesKt.setCookie(r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
            r4 = r6
            r2 = r8
        L_0x0057:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0074
            java.lang.Object r8 = r7.next()
            io.ktor.http.Cookie r8 = (io.ktor.http.Cookie) r8
            io.ktor.client.plugins.cookies.CookiesStorage r5 = r4.storage
            r0.L$0 = r4
            r0.L$1 = r2
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r8 = r5.addCookie(r2, r8, r0)
            if (r8 != r1) goto L_0x0057
            return r1
        L_0x0074:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cookies.HttpCookies.saveCookiesFrom$ktor_client_core(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void close() {
        this.storage.close();
    }

    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J7\u0010\u0012\u001a\u00020\b2'\u0010\u0013\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\u0014R8\u0010\u0003\u001a)\u0012%\u0012#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\b\t0\u0004X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "", "()V", "defaults", "", "Lkotlin/Function2;", "Lio/ktor/client/plugins/cookies/CookiesStorage;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "storage", "getStorage", "()Lio/ktor/client/plugins/cookies/CookiesStorage;", "setStorage", "(Lio/ktor/client/plugins/cookies/CookiesStorage;)V", "build", "Lio/ktor/client/plugins/cookies/HttpCookies;", "build$ktor_client_core", "default", "block", "(Lkotlin/jvm/functions/Function2;)V", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpCookies.kt */
    public static final class Config {
        private final List<Function2<CookiesStorage, Continuation<? super Unit>, Object>> defaults = new ArrayList();
        private CookiesStorage storage = new AcceptAllCookiesStorage();

        public final CookiesStorage getStorage() {
            return this.storage;
        }

        public final void setStorage(CookiesStorage cookiesStorage) {
            Intrinsics.checkNotNullParameter(cookiesStorage, "<set-?>");
            this.storage = cookiesStorage;
        }

        /* renamed from: default  reason: not valid java name */
        public final void m5default(Function2<? super CookiesStorage, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.defaults.add(function2);
        }

        public final HttpCookies build$ktor_client_core() {
            return new HttpCookies(this.storage, this.defaults);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J!\u0010\u000e\u001a\u00020\u00032\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0010¢\u0006\u0002\b\u0011H\u0016R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/cookies/HttpCookies$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cookies/HttpCookies$Config;", "Lio/ktor/client/plugins/cookies/HttpCookies;", "()V", "key", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", "plugin", "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpCookies.kt */
    public static final class Companion implements HttpClientPlugin<Config, HttpCookies> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public HttpCookies prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return config.build$ktor_client_core();
        }

        public AttributeKey<HttpCookies> getKey() {
            return HttpCookies.key;
        }

        public void install(HttpCookies httpCookies, HttpClient httpClient) {
            Intrinsics.checkNotNullParameter(httpCookies, "plugin");
            Intrinsics.checkNotNullParameter(httpClient, "scope");
            httpClient.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getState(), new HttpCookies$Companion$install$1(httpCookies, (Continuation<? super HttpCookies$Companion$install$1>) null));
            httpClient.getSendPipeline().intercept(HttpSendPipeline.Phases.getState(), new HttpCookies$Companion$install$2(httpCookies, (Continuation<? super HttpCookies$Companion$install$2>) null));
            httpClient.getReceivePipeline().intercept(HttpReceivePipeline.Phases.getState(), new HttpCookies$Companion$install$3(httpCookies, (Continuation<? super HttpCookies$Companion$install$3>) null));
        }
    }
}
