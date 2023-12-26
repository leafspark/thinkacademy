package com.kwai.koom.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u001aG\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\u0010\t\u001aK\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0002\u0010\u000b\u001a3\u0010\f\u001a\u0004\u0018\u00010\r*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001f\u0010\u0012\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u0013\u001a#\u0010\u0014\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u001a \u0010\u0019\u001a\u00020\u0017*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u001a\u0010\u0010\u001a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007*\u00020\u0004¨\u0006\u001b"}, d2 = {"callMethod", "T", "", "methodName", "", "parameterTypes", "", "Ljava/lang/Class;", "args", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "callStaticMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "getDeclaredMethodQuietly", "Ljava/lang/reflect/Method;", "filedName", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getFiledQuietly", "Ljava/lang/reflect/Field;", "getFiledValue", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "getStaticFiledValue", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "setFiledValue", "", "filedValue", "setStaticFiledValue", "toClass", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_Reflect.kt */
public final class Monitor_ReflectKt {
    public static final Class<?> toClass(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "$this$toClass");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Class.forName(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (Class) obj;
    }

    public static final <T> T getStaticFiledValue(Class<?> cls, String str) {
        T t;
        Intrinsics.checkNotNullParameter(cls, "$this$getStaticFiledValue");
        Intrinsics.checkNotNullParameter(str, "filedName");
        try {
            Result.Companion companion = Result.Companion;
            Field filedQuietly = getFiledQuietly(cls, str);
            t = Result.constructor-impl(filedQuietly != null ? filedQuietly.get((Object) null) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    public static final <T> T getFiledValue(Object obj, String str) {
        T t;
        Intrinsics.checkNotNullParameter(obj, "$this$getFiledValue");
        Intrinsics.checkNotNullParameter(str, "filedName");
        try {
            Result.Companion companion = Result.Companion;
            Field filedQuietly = getFiledQuietly(obj.getClass(), str);
            t = Result.constructor-impl(filedQuietly != null ? filedQuietly.get(obj) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    public static final void setStaticFiledValue(Class<?> cls, String str, Object obj) {
        Intrinsics.checkNotNullParameter(cls, "$this$setStaticFiledValue");
        Intrinsics.checkNotNullParameter(str, "filedName");
        try {
            Result.Companion companion = Result.Companion;
            Field filedQuietly = getFiledQuietly(cls, str);
            Unit unit = null;
            if (filedQuietly != null) {
                filedQuietly.set((Object) null, obj);
                unit = Unit.INSTANCE;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final void setFiledValue(Object obj, String str, Object obj2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(obj, "$this$setFiledValue");
        Intrinsics.checkNotNullParameter(str, "filedName");
        try {
            Result.Companion companion = Result.Companion;
            Field filedQuietly = getFiledQuietly(obj.getClass(), str);
            if (filedQuietly != null) {
                filedQuietly.set(obj, obj2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public static final Field getFiledQuietly(Class<?> cls, String str) {
        Object obj;
        Field field;
        Object obj2;
        Class<? super Object> cls2;
        Intrinsics.checkNotNullParameter(cls, "$this$getFiledQuietly");
        Intrinsics.checkNotNullParameter(str, "filedName");
        Object obj3 = null;
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls3 = cls;
            while (true) {
                if (!(!Intrinsics.areEqual(cls3, Object.class))) {
                    field = null;
                    break;
                }
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(cls3 != null ? cls3.getDeclaredField(str) : null);
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                field = (Field) obj2;
                if (field != null) {
                    field.setAccessible(true);
                    break;
                }
                if (cls3 != null) {
                    cls2 = cls3.getSuperclass();
                } else {
                    cls2 = null;
                }
                cls3 = cls2;
            }
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        obj = Result.constructor-impl(field);
        if (!Result.isFailure-impl(obj)) {
            obj3 = obj;
        }
        return (Field) obj3;
    }

    public static /* synthetic */ Object callMethod$default(Object obj, String str, Class[] clsArr, Object[] objArr, int i, Object obj2) {
        if ((i & 2) != 0) {
            clsArr = null;
        }
        if ((i & 4) != 0) {
            objArr = null;
        }
        return callMethod(obj, str, clsArr, objArr);
    }

    public static final <T> T callMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        T t;
        Object obj2;
        Intrinsics.checkNotNullParameter(obj, "$this$callMethod");
        Intrinsics.checkNotNullParameter(str, "methodName");
        try {
            Result.Companion companion = Result.Companion;
            Method declaredMethodQuietly = getDeclaredMethodQuietly(obj.getClass(), str, clsArr);
            if (declaredMethodQuietly != null) {
                obj2 = objArr == null ? declaredMethodQuietly.invoke(obj, new Object[0]) : declaredMethodQuietly.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } else {
                obj2 = null;
            }
            t = Result.constructor-impl(obj2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    public static /* synthetic */ Object callStaticMethod$default(Class cls, String str, Class[] clsArr, Object[] objArr, int i, Object obj) {
        if ((i & 2) != 0) {
            clsArr = null;
        }
        if ((i & 4) != 0) {
            objArr = null;
        }
        return callStaticMethod(cls, str, clsArr, objArr);
    }

    public static final <T> T callStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        T t;
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "$this$callStaticMethod");
        Intrinsics.checkNotNullParameter(str, "methodName");
        try {
            Result.Companion companion = Result.Companion;
            Method declaredMethodQuietly = getDeclaredMethodQuietly(cls, str, clsArr);
            if (declaredMethodQuietly != null) {
                obj = objArr == null ? declaredMethodQuietly.invoke((Object) null, new Object[0]) : declaredMethodQuietly.invoke((Object) null, Arrays.copyOf(objArr, objArr.length));
            } else {
                obj = null;
            }
            t = Result.constructor-impl(obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    public static /* synthetic */ Method getDeclaredMethodQuietly$default(Class cls, String str, Class[] clsArr, int i, Object obj) {
        if ((i & 2) != 0) {
            clsArr = null;
        }
        return getDeclaredMethodQuietly(cls, str, clsArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a A[Catch:{ all -> 0x0039, all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0053 A[Catch:{ all -> 0x0039, all -> 0x0062 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x004f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.reflect.Method getDeclaredMethodQuietly(java.lang.Class<?> r4, java.lang.String r5, java.lang.Class<?>[] r6) {
        /*
            java.lang.String r0 = "$this$getDeclaredMethodQuietly"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "filedName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0062 }
        L_0x000d:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)     // Catch:{ all -> 0x0062 }
            r2 = 1
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x005c
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0039 }
            if (r6 != 0) goto L_0x0027
            if (r4 == 0) goto L_0x0025
            r1 = 0
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ all -> 0x0039 }
            java.lang.reflect.Method r1 = r4.getDeclaredMethod(r5, r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0034
        L_0x0025:
            r1 = r0
            goto L_0x0034
        L_0x0027:
            if (r4 == 0) goto L_0x0025
            int r1 = r6.length     // Catch:{ all -> 0x0039 }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r6, r1)     // Catch:{ all -> 0x0039 }
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch:{ all -> 0x0039 }
            java.lang.reflect.Method r1 = r4.getDeclaredMethod(r5, r1)     // Catch:{ all -> 0x0039 }
        L_0x0034:
            java.lang.Object r1 = kotlin.Result.constructor-impl(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x0044
        L_0x0039:
            r1 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = kotlin.ResultKt.createFailure(r1)     // Catch:{ all -> 0x0062 }
            java.lang.Object r1 = kotlin.Result.constructor-impl(r1)     // Catch:{ all -> 0x0062 }
        L_0x0044:
            boolean r3 = kotlin.Result.isFailure-impl(r1)     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x004b
            r1 = r0
        L_0x004b:
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x0053
            r1.setAccessible(r2)     // Catch:{ all -> 0x0062 }
            goto L_0x005d
        L_0x0053:
            if (r4 == 0) goto L_0x005a
            java.lang.Class r4 = r4.getSuperclass()     // Catch:{ all -> 0x0062 }
            goto L_0x000d
        L_0x005a:
            r4 = r0
            goto L_0x000d
        L_0x005c:
            r1 = r0
        L_0x005d:
            java.lang.Object r4 = kotlin.Result.constructor-impl(r1)     // Catch:{ all -> 0x0062 }
            goto L_0x006d
        L_0x0062:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.constructor-impl(r4)
        L_0x006d:
            boolean r5 = kotlin.Result.isFailure-impl(r4)
            if (r5 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r0 = r4
        L_0x0075:
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.koom.base.Monitor_ReflectKt.getDeclaredMethodQuietly(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
