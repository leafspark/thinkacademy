package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$Plugin$install$1", f = "HttpSend.kt", i = {0}, l = {104, 105}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
/* compiled from: HttpSend.kt */
final class HttpSend$Plugin$install$1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpSend $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSend$Plugin$install$1(HttpSend httpSend, HttpClient httpClient, Continuation<? super HttpSend$Plugin$install$1> continuation) {
        super(3, continuation);
        this.$plugin = httpSend;
        this.$scope = httpClient;
    }

    public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
        HttpSend$Plugin$install$1 httpSend$Plugin$install$1 = new HttpSend$Plugin$install$1(this.$plugin, this.$scope, continuation);
        httpSend$Plugin$install$1.L$0 = pipelineContext;
        httpSend$Plugin$install$1.L$1 = obj;
        return httpSend$Plugin$install$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0025
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00df
        L_0x0014:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001c:
            java.lang.Object r1 = r10.L$0
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00cf
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            io.ktor.util.pipeline.PipelineContext r1 = (io.ktor.util.pipeline.PipelineContext) r1
            java.lang.Object r11 = r10.L$1
            boolean r5 = r11 instanceof io.ktor.http.content.OutgoingContent
            if (r5 == 0) goto L_0x00e2
            java.lang.Object r6 = r1.getContext()
            io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6
            if (r11 != 0) goto L_0x0044
            io.ktor.client.utils.EmptyContent r11 = io.ktor.client.utils.EmptyContent.INSTANCE
            r6.setBody(r11)
            r6.setBodyType(r4)
            goto L_0x0067
        L_0x0044:
            if (r5 == 0) goto L_0x004d
            r6.setBody(r11)
            r6.setBodyType(r4)
            goto L_0x0067
        L_0x004d:
            r6.setBody(r11)
            java.lang.Class<io.ktor.http.content.OutgoingContent> r11 = io.ktor.http.content.OutgoingContent.class
            kotlin.reflect.KType r11 = kotlin.jvm.internal.Reflection.typeOf(r11)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r11)
            java.lang.Class<io.ktor.http.content.OutgoingContent> r7 = io.ktor.http.content.OutgoingContent.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            io.ktor.util.reflect.TypeInfo r11 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r7, r11)
            r6.setBodyType(r11)
        L_0x0067:
            io.ktor.client.plugins.HttpSend$DefaultSender r11 = new io.ktor.client.plugins.HttpSend$DefaultSender
            io.ktor.client.plugins.HttpSend r5 = r10.$plugin
            int r5 = r5.maxSendCount
            io.ktor.client.HttpClient r6 = r10.$scope
            r11.<init>(r5, r6)
            io.ktor.client.plugins.Sender r11 = (io.ktor.client.plugins.Sender) r11
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r5.element = r11
            io.ktor.client.plugins.HttpSend r11 = r10.$plugin
            java.util.List r11 = r11.interceptors
            int r11 = kotlin.collections.CollectionsKt.getLastIndex(r11)
            r6 = 0
            kotlin.ranges.IntProgression r11 = kotlin.ranges.RangesKt.downTo(r11, r6)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            io.ktor.client.plugins.HttpSend r6 = r10.$plugin
            java.util.Iterator r11 = r11.iterator()
        L_0x0094:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L_0x00b7
            r7 = r11
            kotlin.collections.IntIterator r7 = (kotlin.collections.IntIterator) r7
            int r7 = r7.nextInt()
            java.util.List r8 = r6.interceptors
            java.lang.Object r7 = r8.get(r7)
            kotlin.jvm.functions.Function3 r7 = (kotlin.jvm.functions.Function3) r7
            io.ktor.client.plugins.HttpSend$InterceptedSender r8 = new io.ktor.client.plugins.HttpSend$InterceptedSender
            java.lang.Object r9 = r5.element
            io.ktor.client.plugins.Sender r9 = (io.ktor.client.plugins.Sender) r9
            r8.<init>(r7, r9)
            r5.element = r8
            goto L_0x0094
        L_0x00b7:
            java.lang.Object r11 = r5.element
            io.ktor.client.plugins.Sender r11 = (io.ktor.client.plugins.Sender) r11
            java.lang.Object r5 = r1.getContext()
            io.ktor.client.request.HttpRequestBuilder r5 = (io.ktor.client.request.HttpRequestBuilder) r5
            r6 = r10
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r11.execute(r5, r6)
            if (r11 != r0) goto L_0x00cf
            return r0
        L_0x00cf:
            io.ktor.client.call.HttpClientCall r11 = (io.ktor.client.call.HttpClientCall) r11
            r3 = r10
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r10.L$0 = r4
            r10.label = r2
            java.lang.Object r11 = r1.proceedWith(r11, r3)
            if (r11 != r0) goto L_0x00df
            return r0
        L_0x00df:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00e2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "\n|Fail to prepare request body for sending. \n|The body type is: "
            r0.append(r2)
            java.lang.Class r11 = r11.getClass()
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)
            r0.append(r11)
            java.lang.String r11 = ", with Content-Type: "
            r0.append(r11)
            java.lang.Object r11 = r1.getContext()
            io.ktor.http.HttpMessageBuilder r11 = (io.ktor.http.HttpMessageBuilder) r11
            io.ktor.http.ContentType r11 = io.ktor.http.HttpMessagePropertiesKt.contentType((io.ktor.http.HttpMessageBuilder) r11)
            r0.append(r11)
            java.lang.String r11 = ".\n|\n|If you expect serialized body, please check that you have installed the corresponding plugin(like `ContentNegotiation`) and set `Content-Type` header."
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.String r11 = kotlin.text.StringsKt.trimMargin$default(r11, r4, r3, r4)
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r11 = r11.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpSend$Plugin$install$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
