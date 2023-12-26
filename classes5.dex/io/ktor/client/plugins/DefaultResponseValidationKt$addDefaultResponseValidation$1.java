package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/HttpCallValidator$Config;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultResponseValidation.kt */
final class DefaultResponseValidationKt$addDefaultResponseValidation$1 extends Lambda implements Function1<HttpCallValidator.Config, Unit> {
    final /* synthetic */ HttpClientConfig<?> $this_addDefaultResponseValidation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultResponseValidationKt$addDefaultResponseValidation$1(HttpClientConfig<?> httpClientConfig) {
        super(1);
        this.$this_addDefaultResponseValidation = httpClientConfig;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpCallValidator.Config) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(HttpCallValidator.Config config) {
        Intrinsics.checkNotNullParameter(config, "$this$HttpResponseValidator");
        config.setExpectSuccess(this.$this_addDefaultResponseValidation.getExpectSuccess());
        config.validateResponse(new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", i = {0, 1, 1}, l = {38, 43}, m = "invokeSuspend", n = {"statusCode", "exceptionResponse", "statusCode"}, s = {"I$0", "L$0", "I$0"})
    /* renamed from: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1  reason: invalid class name */
    /* compiled from: DefaultResponseValidation.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
        int I$0;
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> r0 = new AnonymousClass1(continuation);
            r0.L$0 = obj;
            return (Continuation) r0;
        }

        public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
            return create(httpResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.label
                r2 = 300(0x12c, float:4.2E-43)
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0029
                if (r1 == r4) goto L_0x0023
                if (r1 != r3) goto L_0x001b
                int r0 = r8.I$0
                java.lang.Object r1 = r8.L$0
                io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x009e
            L_0x001b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0023:
                int r1 = r8.I$0
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x0077
            L_0x0029:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.L$0
                io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
                io.ktor.client.call.HttpClientCall r1 = r9.getCall()
                io.ktor.util.Attributes r1 = r1.getAttributes()
                io.ktor.util.AttributeKey r5 = io.ktor.client.plugins.HttpCallValidatorKt.getExpectSuccessAttributeKey()
                java.lang.Object r1 = r1.get(r5)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r1 = r1.booleanValue()
                if (r1 != 0) goto L_0x004b
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            L_0x004b:
                io.ktor.http.HttpStatusCode r1 = r9.getStatus()
                int r1 = r1.getValue()
                io.ktor.client.call.HttpClientCall r9 = r9.getCall()
                if (r1 < r2) goto L_0x00d9
                io.ktor.util.Attributes r5 = r9.getAttributes()
                io.ktor.util.AttributeKey r6 = io.ktor.client.plugins.DefaultResponseValidationKt.ValidateMark
                boolean r5 = r5.contains(r6)
                if (r5 == 0) goto L_0x0069
                goto L_0x00d9
            L_0x0069:
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r8.I$0 = r1
                r8.label = r4
                java.lang.Object r9 = io.ktor.client.call.SavedCallKt.save(r9, r5)
                if (r9 != r0) goto L_0x0077
                return r0
            L_0x0077:
                io.ktor.client.call.HttpClientCall r9 = (io.ktor.client.call.HttpClientCall) r9
                io.ktor.util.Attributes r5 = r9.getAttributes()
                io.ktor.util.AttributeKey r6 = io.ktor.client.plugins.DefaultResponseValidationKt.ValidateMark
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                r5.put(r6, r7)
                io.ktor.client.statement.HttpResponse r9 = r9.getResponse()
                r5 = r8
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r8.L$0 = r9
                r8.I$0 = r1
                r8.label = r3
                r3 = 0
                java.lang.Object r3 = io.ktor.client.statement.HttpResponseKt.bodyAsText$default(r9, r3, r5, r4, r3)
                if (r3 != r0) goto L_0x009b
                return r0
            L_0x009b:
                r0 = r1
                r1 = r9
                r9 = r3
            L_0x009e:
                java.lang.String r9 = (java.lang.String) r9
                r3 = 400(0x190, float:5.6E-43)
                r5 = 0
                if (r2 > r0) goto L_0x00a9
                if (r0 >= r3) goto L_0x00a9
                r2 = r4
                goto L_0x00aa
            L_0x00a9:
                r2 = r5
            L_0x00aa:
                if (r2 != 0) goto L_0x00d3
                r2 = 500(0x1f4, float:7.0E-43)
                if (r3 > r0) goto L_0x00b4
                if (r0 >= r2) goto L_0x00b4
                r3 = r4
                goto L_0x00b5
            L_0x00b4:
                r3 = r5
            L_0x00b5:
                if (r3 != 0) goto L_0x00cd
                if (r2 > r0) goto L_0x00be
                r2 = 600(0x258, float:8.41E-43)
                if (r0 >= r2) goto L_0x00be
                goto L_0x00bf
            L_0x00be:
                r4 = r5
            L_0x00bf:
                if (r4 == 0) goto L_0x00c7
                io.ktor.client.plugins.ServerResponseException r0 = new io.ktor.client.plugins.ServerResponseException
                r0.<init>(r1, r9)
                throw r0
            L_0x00c7:
                io.ktor.client.plugins.ResponseException r0 = new io.ktor.client.plugins.ResponseException
                r0.<init>(r1, r9)
                throw r0
            L_0x00cd:
                io.ktor.client.plugins.ClientRequestException r0 = new io.ktor.client.plugins.ClientRequestException
                r0.<init>(r1, r9)
                throw r0
            L_0x00d3:
                io.ktor.client.plugins.RedirectResponseException r0 = new io.ktor.client.plugins.RedirectResponseException
                r0.<init>(r1, r9)
                throw r0
            L_0x00d9:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
