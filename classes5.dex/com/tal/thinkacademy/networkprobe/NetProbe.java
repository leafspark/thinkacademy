package com.tal.thinkacademy.networkprobe;

import com.tal.thinkacademy.networkprobe.NetProbeConfig;
import com.tal.thinkacademy.networkprobe.data.NetProbeData;
import com.tal.thinkacademy.networkprobe.data.NetProbeResult;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0002,-B \b\u0000\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J!\u0010\u0011\u001a\u00020\u00052\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0002J\u0006\u0010\u0013\u001a\u00020\u0005J7\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002JA\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J]\u0010%\u001a\u00020#2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170'\u0018\u00010\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006J\u001f\u0010(\u001a\u00020\u00002\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006J\u001f\u0010)\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050*H@ø\u0001\u0000¢\u0006\u0002\u0010+R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/tal/thinkacademy/networkprobe/NetProbe;", "", "config", "Lkotlin/Function1;", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "isCanceled", "", "isDoTask", "mConfig", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig;", "mHolder", "Lcom/tal/thinkacademy/networkprobe/NetProbe$CallHolder;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "bindCallHolder", "block", "cancel", "get", "Lio/ktor/client/statement/HttpResponse;", "host", "", "path", "params", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "log", "tag", "msg", "onProbeFinished", "repeatRequest", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;", "repeatCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startProbe", "hostGroup", "", "updateConfig", "withMainContext", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CallHolder", "Companion", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetProbe.kt */
public final class NetProbe {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public boolean isCanceled;
    private boolean isDoTask;
    /* access modifiers changed from: private */
    public NetProbeConfig mConfig;
    /* access modifiers changed from: private */
    public CallHolder mHolder;
    /* access modifiers changed from: private */
    public final Mutex mutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public NetProbe(Function1<? super NetProbeConfig.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "config");
        NetProbeConfig.Builder builder = new NetProbeConfig.Builder();
        function1.invoke(builder);
        this.mConfig = builder.build();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/NetProbe$Companion;", "", "()V", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetProbe.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void cancel() {
        this.isCanceled = true;
    }

    public final NetProbe updateConfig(Function1<? super NetProbeConfig.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        NetProbeConfig.Builder newBuilder = this.mConfig.newBuilder();
        function1.invoke(newBuilder);
        this.mConfig = newBuilder.build();
        return this;
    }

    public static /* synthetic */ int startProbe$default(NetProbe netProbe, Map map, String str, Map map2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            map2 = null;
        }
        return netProbe.startProbe(map, str, map2, function1);
    }

    public final int startProbe(Map<String, ? extends List<String>> map, String str, Map<String, String> map2, Function1<? super CallHolder, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (this.isDoTask) {
            return -1;
        }
        if (map == null || map.isEmpty()) {
            return -2;
        }
        this.isCanceled = false;
        this.isDoTask = true;
        bindCallHolder(function1);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new NetProbe$startProbe$1(this, map, str, map2, (Continuation<? super NetProbe$startProbe$1>) null), 3, (Object) null);
        return 0;
    }

    private final void bindCallHolder(Function1<? super CallHolder, Unit> function1) {
        if (this.mHolder == null) {
            NetProbe netProbe = this;
            this.mHolder = new CallHolder();
        }
        CallHolder callHolder = this.mHolder;
        if (callHolder != null) {
            function1.invoke(callHolder);
        }
    }

    static /* synthetic */ Object repeatRequest$default(NetProbe netProbe, String str, String str2, Map map, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = null;
        }
        return netProbe.repeatRequest(str, str2, map, i, continuation);
    }

    /* access modifiers changed from: private */
    public final Object repeatRequest(String str, String str2, Map<String, String> map, int i, Continuation<? super NetProbeResult> continuation) {
        return SupervisorKt.supervisorScope(new NetProbe$repeatRequest$2(this, i, str, str2, map, (Continuation<? super NetProbe$repeatRequest$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Object get(String str, String str2, Map<String, String> map, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = new Platform().httpClient(this.mConfig);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestKt.headers(httpRequestBuilder, NetProbe$get$2$1.INSTANCE);
        httpRequestBuilder.url(new NetProbe$get$2$2(str2, map, httpRequestBuilder));
        log("NetProbe", Intrinsics.stringPlus("接口拼接：", httpRequestBuilder.getUrl().buildString()));
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    /* access modifiers changed from: private */
    public final void log(String str, String str2) {
        NetProbe netProbe = this;
        if ((this.mConfig.debug() ? this : null) != null) {
            Utils.INSTANCE.log(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final void onProbeFinished() {
        this.isDoTask = false;
        CallHolder callHolder = this.mHolder;
        if (callHolder != null) {
            callHolder.clean$networkprobe_release();
        }
        this.mHolder = null;
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u001d\u001a\u00020\tH\u0000¢\u0006\u0002\b\u001eJ)\u0010\u001f\u001a\u00020\t2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J)\u0010!\u001a\u00020\t2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\u0004JD\u0010\"\u001a\u00020\t2<\u0010 \u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t0\u0014R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rRR\u0010\u0013\u001a:\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/NetProbe$CallHolder;", "", "()V", "mCancelBlock", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msg", "", "getMCancelBlock$networkprobe_release", "()Lkotlin/jvm/functions/Function1;", "setMCancelBlock$networkprobe_release", "(Lkotlin/jvm/functions/Function1;)V", "mRequestBlock", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeData;", "date", "getMRequestBlock$networkprobe_release", "setMRequestBlock$networkprobe_release", "mResultBlock", "Lkotlin/Function2;", "key", "", "Lcom/tal/thinkacademy/networkprobe/data/NetProbeResult;", "list", "getMResultBlock$networkprobe_release", "()Lkotlin/jvm/functions/Function2;", "setMResultBlock$networkprobe_release", "(Lkotlin/jvm/functions/Function2;)V", "clean", "clean$networkprobe_release", "onCancel", "block", "onRequestCall", "onResult", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NetProbe.kt */
    public static final class CallHolder {
        private Function1<? super String, Unit> mCancelBlock;
        private Function1<? super NetProbeData, Unit> mRequestBlock;
        private Function2<? super String, ? super NetProbeResult[], Unit> mResultBlock;

        public final Function1<NetProbeData, Unit> getMRequestBlock$networkprobe_release() {
            return this.mRequestBlock;
        }

        public final void setMRequestBlock$networkprobe_release(Function1<? super NetProbeData, Unit> function1) {
            this.mRequestBlock = function1;
        }

        public final Function2<String, NetProbeResult[], Unit> getMResultBlock$networkprobe_release() {
            return this.mResultBlock;
        }

        public final void setMResultBlock$networkprobe_release(Function2<? super String, ? super NetProbeResult[], Unit> function2) {
            this.mResultBlock = function2;
        }

        public final Function1<String, Unit> getMCancelBlock$networkprobe_release() {
            return this.mCancelBlock;
        }

        public final void setMCancelBlock$networkprobe_release(Function1<? super String, Unit> function1) {
            this.mCancelBlock = function1;
        }

        public final void onRequestCall(Function1<? super NetProbeData, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.mRequestBlock = function1;
        }

        public final void onResult(Function2<? super String, ? super NetProbeResult[], Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.mResultBlock = function2;
        }

        public final void onCancel(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.mCancelBlock = function1;
        }

        public final void clean$networkprobe_release() {
            this.mRequestBlock = null;
            this.mResultBlock = null;
            this.mCancelBlock = null;
        }
    }

    /* access modifiers changed from: private */
    public final Object withMainContext(Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(new Platform().appDispatcher(), new NetProbe$withMainContext$2(function0, (Continuation<? super NetProbe$withMainContext$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
