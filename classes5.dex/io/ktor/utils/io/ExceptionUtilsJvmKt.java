package io.ktor.utils.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\b\u001a'\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u00102\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0014\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0015\u001a\u00020\tH\u0010\u001a\u0018\u0010\u0016\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0017\u001a\u00020\tH\u0002\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u001a\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u001b"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lio/ktor/utils/io/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "cause", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "printStack", "", "Ctor", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExceptionUtilsJvm.kt */
public final class ExceptionUtilsJvmKt {
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    public static final void printStack(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        th.printStackTrace();
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E tryCopyException(E r8, java.lang.Throwable r9) {
        /*
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "cause"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof kotlinx.coroutines.CopyableThrowable
            r1 = 0
            if (r0 == 0) goto L_0x0032
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x001c }
            kotlinx.coroutines.CopyableThrowable r8 = (kotlinx.coroutines.CopyableThrowable) r8     // Catch:{ all -> 0x001c }
            java.lang.Throwable r8 = r8.createCopy()     // Catch:{ all -> 0x001c }
            java.lang.Object r8 = kotlin.Result.m320constructorimpl(r8)     // Catch:{ all -> 0x001c }
            goto L_0x0027
        L_0x001c:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m320constructorimpl(r8)
        L_0x0027:
            boolean r9 = kotlin.Result.m326isFailureimpl(r8)
            if (r9 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = r8
        L_0x002f:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0032:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r3 = exceptionCtors     // Catch:{ all -> 0x0137 }
            java.lang.Class r4 = r8.getClass()     // Catch:{ all -> 0x0137 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0137 }
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch:{ all -> 0x0137 }
            r2.unlock()
            if (r3 == 0) goto L_0x0053
            java.lang.Object r8 = r3.invoke(r8)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            return r8
        L_0x0053:
            int r2 = throwableFields
            java.lang.Class r3 = r8.getClass()
            r4 = 0
            int r3 = fieldsCountOrDefault(r3, r4)
            if (r2 == r3) goto L_0x00a8
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r9 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            if (r2 != 0) goto L_0x006f
            int r2 = r0.getReadHoldCount()
            goto L_0x0070
        L_0x006f:
            r2 = r4
        L_0x0070:
            r3 = r4
        L_0x0071:
            if (r3 >= r2) goto L_0x0079
            r9.unlock()
            int r3 = r3 + 1
            goto L_0x0071
        L_0x0079:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r3 = exceptionCtors     // Catch:{ all -> 0x009b }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ all -> 0x009b }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x009b }
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$4$1 r5 = io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$4$1.INSTANCE     // Catch:{ all -> 0x009b }
            r3.put(r8, r5)     // Catch:{ all -> 0x009b }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009b }
        L_0x008f:
            if (r4 >= r2) goto L_0x0097
            r9.lock()
            int r4 = r4 + 1
            goto L_0x008f
        L_0x0097:
            r0.unlock()
            return r1
        L_0x009b:
            r8 = move-exception
        L_0x009c:
            if (r4 >= r2) goto L_0x00a4
            r9.lock()
            int r4 = r4 + 1
            goto L_0x009c
        L_0x00a4:
            r0.unlock()
            throw r8
        L_0x00a8:
            java.lang.Class r0 = r8.getClass()
            java.lang.reflect.Constructor[] r0 = r0.getConstructors()
            java.lang.String r2 = "exception.javaClass.constructors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1 r2 = new io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$$inlined$sortedByDescending$1
            r2.<init>()
            java.util.Comparator r2 = (java.util.Comparator) r2
            java.util.List r0 = kotlin.collections.ArraysKt.sortedWith(r0, r2)
            java.util.Iterator r0 = r0.iterator()
            r2 = r1
        L_0x00c7:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00de
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2
            java.lang.String r3 = "constructor"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            kotlin.jvm.functions.Function1 r2 = createConstructor(r2)
            if (r2 == 0) goto L_0x00c7
        L_0x00de:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = cacheLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r0.readLock()
            int r5 = r0.getWriteHoldCount()
            if (r5 != 0) goto L_0x00ef
            int r5 = r0.getReadHoldCount()
            goto L_0x00f0
        L_0x00ef:
            r5 = r4
        L_0x00f0:
            r6 = r4
        L_0x00f1:
            if (r6 >= r5) goto L_0x00f9
            r3.unlock()
            int r6 = r6 + 1
            goto L_0x00f1
        L_0x00f9:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, kotlin.jvm.functions.Function1<java.lang.Throwable, java.lang.Throwable>> r6 = exceptionCtors     // Catch:{ all -> 0x012a }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x012a }
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x012a }
            if (r2 != 0) goto L_0x010f
            io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$5$1 r7 = io.ktor.utils.io.ExceptionUtilsJvmKt$tryCopyException$5$1.INSTANCE     // Catch:{ all -> 0x012a }
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7     // Catch:{ all -> 0x012a }
            goto L_0x0110
        L_0x010f:
            r7 = r2
        L_0x0110:
            r6.put(r8, r7)     // Catch:{ all -> 0x012a }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x012a }
        L_0x0115:
            if (r4 >= r5) goto L_0x011d
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0115
        L_0x011d:
            r0.unlock()
            if (r2 == 0) goto L_0x0129
            java.lang.Object r8 = r2.invoke(r9)
            r1 = r8
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0129:
            return r1
        L_0x012a:
            r8 = move-exception
        L_0x012b:
            if (r4 >= r5) goto L_0x0133
            r3.lock()
            int r4 = r4 + 1
            goto L_0x012b
        L_0x0133:
            r0.unlock()
            throw r8
        L_0x0137:
            r8 = move-exception
            r2.unlock()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ExceptionUtilsJvmKt.tryCopyException(java.lang.Throwable, java.lang.Throwable):java.lang.Throwable");
    }

    private static final Function1<Throwable, Throwable> createConstructor(Constructor<?> constructor) {
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return (Function1) new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class cls = parameterTypes[0];
            if (Intrinsics.areEqual(cls, Throwable.class)) {
                return (Function1) new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (Intrinsics.areEqual(cls, String.class)) {
                return (Function1) new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
            return (Function1) new ExceptionUtilsJvmKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final Function1<Throwable, Throwable> safeCtor(Function1<? super Throwable, ? extends Throwable> function1) {
        return (Function1) new ExceptionUtilsJvmKt$safeCtor$1(function1);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer num;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            num = Result.m320constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m320constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m326isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
            Object[] objArr = (Object[]) declaredFields;
            int length = objArr.length;
            int i2 = 0;
            Class<? super Object> cls2 = cls;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(((Field) objArr[i3]).getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i;
    }
}
