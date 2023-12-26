package io.ktor.util.converters;

import io.ktor.http.LinkHeader;
import io.ktor.util.KtorDsl;
import io.ktor.util.converters.DelegatingConversionService;
import io.ktor.util.reflect.TypeInfo;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\tH\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lio/ktor/util/converters/DataConversion;", "Lio/ktor/util/converters/ConversionService;", "configuration", "Lio/ktor/util/converters/DataConversion$Configuration;", "(Lio/ktor/util/converters/DataConversion$Configuration;)V", "converters", "", "Lkotlin/reflect/KClass;", "fromValues", "", "values", "", "", "type", "Lio/ktor/util/reflect/TypeInfo;", "toValues", "value", "Configuration", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataConversion.kt */
public final class DataConversion implements ConversionService {
    private final Map<KClass<?>, ConversionService> converters;

    public DataConversion(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.converters = MapsKt.toMap(configuration.getConverters$ktor_utils());
    }

    public Object fromValues(List<String> list, TypeInfo typeInfo) {
        Intrinsics.checkNotNullParameter(list, "values");
        Intrinsics.checkNotNullParameter(typeInfo, LinkHeader.Parameters.Type);
        if (list.isEmpty()) {
            return null;
        }
        ConversionService conversionService = this.converters.get(typeInfo.getType());
        if (conversionService == null) {
            conversionService = DefaultConversionService.INSTANCE;
        }
        return conversionService.fromValues(list, typeInfo);
    }

    public List<String> toValues(Object obj) {
        if (obj == null) {
            return CollectionsKt.emptyList();
        }
        ConversionService conversionService = this.converters.get(Reflection.getOrCreateKotlinClass(obj.getClass()));
        if (conversionService == null) {
            conversionService = DefaultConversionService.INSTANCE;
        }
        return conversionService.toValues(obj);
    }

    @KtorDsl
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J9\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00012\u001f\b\b\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000J\u001a\u0010\t\u001a\u00020\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0011\u001a\u00020\u0006J7\u0010\t\u001a\u00020\n\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00122\u001d\u0010\f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0004\u0012\u00020\n0\r¢\u0006\u0002\b\u000fR$\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0013"}, d2 = {"Lio/ktor/util/converters/DataConversion$Configuration;", "", "()V", "converters", "", "Lkotlin/reflect/KClass;", "Lio/ktor/util/converters/ConversionService;", "getConverters$ktor_utils", "()Ljava/util/Map;", "convert", "", "T", "configure", "Lkotlin/Function1;", "Lio/ktor/util/converters/DelegatingConversionService$Configuration;", "Lkotlin/ExtensionFunctionType;", "type", "convertor", "Lkotlin/reflect/KType;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DataConversion.kt */
    public static final class Configuration {
        private final Map<KClass<?>, ConversionService> converters = new LinkedHashMap();

        public final Map<KClass<?>, ConversionService> getConverters$ktor_utils() {
            return this.converters;
        }

        public final void convert(KClass<?> kClass, ConversionService conversionService) {
            Intrinsics.checkNotNullParameter(kClass, LinkHeader.Parameters.Type);
            Intrinsics.checkNotNullParameter(conversionService, "convertor");
            this.converters.put(kClass, conversionService);
        }

        public final <T> void convert(KType kType, Function1<? super DelegatingConversionService.Configuration<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(kType, LinkHeader.Parameters.Type);
            Intrinsics.checkNotNullParameter(function1, "configure");
            KClass classifier = kType.getClassifier();
            Objects.requireNonNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<T of io.ktor.util.converters.DataConversion.Configuration.convert>");
            KClass kClass = classifier;
            DelegatingConversionService.Configuration configuration = new DelegatingConversionService.Configuration(kClass);
            function1.invoke(configuration);
            convert((KClass<?>) kClass, (ConversionService) new DelegatingConversionService(kClass, configuration.getDecoder$ktor_utils(), (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(configuration.getEncoder$ktor_utils(), 1)));
        }

        public final /* synthetic */ <T> void convert(Function1<? super DelegatingConversionService.Configuration<T>, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "configure");
            Intrinsics.reifiedOperationMarker(6, "T");
            convert((KType) null, function1);
        }
    }
}
