package io.ktor.client.request.forms;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\f\u001aL\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aF\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0019\b\u0006\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a>\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0019\b\u0006\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aD\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\f\u001aL\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aF\u0010\u0018\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a>\u0010\u0018\u001a\u00020\u0017*\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bHHø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"prepareForm", "Lio/ktor/client/statement/HttpStatement;", "Lio/ktor/client/HttpClient;", "formParameters", "Lio/ktor/http/Parameters;", "encodeInQuery", "", "block", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lio/ktor/http/Parameters;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareFormWithBinaryData", "formData", "", "Lio/ktor/http/content/PartData;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitForm", "Lio/ktor/client/statement/HttpResponse;", "submitFormWithBinaryData", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: formBuilders.kt */
public final class FormBuildersKt {
    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.Companion.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = (Function1) FormBuildersKt$submitForm$2.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object submitForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.Companion.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = FormBuildersKt$submitForm$5.INSTANCE;
        }
        return submitForm(httpClient, str, parameters2, z2, function1, continuation);
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) FormBuildersKt$submitFormWithBinaryData$2.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object submitFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = (Function1) FormBuildersKt$submitFormWithBinaryData$5.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            parameters = Parameters.Companion.getEmpty();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function1 = (Function1) FormBuildersKt$prepareForm$2.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareForm$default(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            parameters = Parameters.Companion.getEmpty();
        }
        Parameters parameters2 = parameters;
        if ((i & 4) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            function1 = FormBuildersKt$prepareForm$5.INSTANCE;
        }
        return prepareForm(httpClient, str, parameters2, z2, function1, continuation);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) FormBuildersKt$prepareFormWithBinaryData$2.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareFormWithBinaryData$default(HttpClient httpClient, String str, List list, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = (Function1) FormBuildersKt$prepareFormWithBinaryData$5.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object submitForm(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object submitForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object submitFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object submitFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareForm(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareForm$$forInline(HttpClient httpClient, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareForm(HttpClient httpClient, String str, Parameters parameters, boolean z, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        if (z) {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
            httpRequestBuilder.getUrl().getParameters().appendAll(parameters);
        } else {
            httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
            FormDataContent formDataContent = new FormDataContent(parameters);
            if (formDataContent instanceof OutgoingContent) {
                httpRequestBuilder.setBody(formDataContent);
                httpRequestBuilder.setBodyType((TypeInfo) null);
            } else {
                httpRequestBuilder.setBody(formDataContent);
                KType typeOf = Reflection.typeOf(FormDataContent.class);
                httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(FormDataContent.class), typeOf));
            }
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareFormWithBinaryData(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareFormWithBinaryData$$forInline(HttpClient httpClient, String str, List<? extends PartData> list, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        MultiPartFormDataContent multiPartFormDataContent = new MultiPartFormDataContent(list, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
        if (multiPartFormDataContent instanceof OutgoingContent) {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            httpRequestBuilder.setBodyType((TypeInfo) null);
        } else {
            httpRequestBuilder.setBody(multiPartFormDataContent);
            KType typeOf = Reflection.typeOf(MultiPartFormDataContent.class);
            httpRequestBuilder.setBodyType(TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class), typeOf));
        }
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }
}
