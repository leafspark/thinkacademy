package com.bonree.sdk.bs;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class z {

    public static class a {
    }

    public static class b extends a {
    }

    public static class c extends b {
    }

    public static class d extends c {
    }

    public static Method a(String str, String str2, Class[] clsArr) {
        Method method = null;
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Object[] objArr = {str2, clsArr};
            Method method2 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke((Class) declaredMethod.invoke((Object) null, new Object[]{str}), objArr);
            try {
                method2.setAccessible(true);
                return method2;
            } catch (Throwable unused) {
                method = method2;
            }
        } catch (Throwable unused2) {
            return method;
        }
    }

    public static Object a(Object obj, String str, String str2, Class[] clsArr, Object... objArr) {
        try {
            Method a2 = a(str, str2, clsArr);
            if (a2 != null) {
                return a2.invoke(obj, objArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 28
            if (r0 < r2) goto L_0x0072
            r0 = 0
            java.lang.Class<java.lang.Class> r2 = java.lang.Class.class
            java.lang.String r3 = "forName"
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ all -> 0x0071 }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r3, r4)     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.Class> r3 = java.lang.Class.class
            java.lang.String r4 = "getDeclaredMethod"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r0] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.Class[]> r7 = java.lang.Class[].class
            r6[r1] = r7     // Catch:{ all -> 0x0071 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r6)     // Catch:{ all -> 0x0071 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0071 }
            java.lang.String r6 = "dalvik.system.VMRuntime"
            r4[r0] = r6     // Catch:{ all -> 0x0071 }
            r6 = 0
            java.lang.Object r2 = r2.invoke(r6, r4)     // Catch:{ all -> 0x0071 }
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ all -> 0x0071 }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ all -> 0x0071 }
            java.lang.String r7 = "getRuntime"
            r4[r0] = r7     // Catch:{ all -> 0x0071 }
            r4[r1] = r6     // Catch:{ all -> 0x0071 }
            java.lang.Object r4 = r3.invoke(r2, r4)     // Catch:{ all -> 0x0071 }
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4     // Catch:{ all -> 0x0071 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0071 }
            java.lang.String r7 = "setHiddenApiExemptions"
            r5[r0] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch:{ all -> 0x0071 }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r7[r0] = r8     // Catch:{ all -> 0x0071 }
            r5[r1] = r7     // Catch:{ all -> 0x0071 }
            java.lang.Object r2 = r3.invoke(r2, r5)     // Catch:{ all -> 0x0071 }
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch:{ all -> 0x0071 }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ all -> 0x0071 }
            java.lang.Object r3 = r4.invoke(r6, r3)     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0071
            if (r2 != 0) goto L_0x0063
            goto L_0x0071
        L_0x0063:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0071 }
            java.lang.String r5 = "L"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch:{ all -> 0x0071 }
            r4[r0] = r5     // Catch:{ all -> 0x0071 }
            r2.invoke(r3, r4)     // Catch:{ all -> 0x0071 }
            goto L_0x0072
        L_0x0071:
            return r0
        L_0x0072:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bs.z.a():boolean");
    }

    public static <C, F> F a(Field field, C c2) throws l {
        if (field == null || field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(c2);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
            throw new l("get value fail ", th);
        }
    }

    public static <C, T> void a(String str, C c2, T t) throws l, NoSuchFieldException {
        Field declaredField = c2.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        try {
            declaredField.set(c2, t);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
            throw new l("set field fail ", th);
        }
    }

    private static <Obj, Val> void b(String str, Obj obj, Val val) throws l, NoSuchFieldException {
        if (str != null) {
            try {
                Field a2 = a(obj.getClass(), str);
                a2.setAccessible(true);
                a2.set(obj, val);
            } catch (Exception unused) {
            }
        }
    }

    public static Field a(Class<?> cls, Class<?> cls2) throws l {
        Field[] declaredFields = cls.getDeclaredFields();
        Field field = null;
        for (int i = 0; i < declaredFields.length; i++) {
            if (cls2.isAssignableFrom(declaredFields[i].getType())) {
                if (field == null) {
                    field = declaredFields[i];
                } else {
                    throw new l("field null: " + field.getName() + ", " + declaredFields[i].getName());
                }
            }
        }
        if (field != null) {
            field.setAccessible(true);
            return field;
        }
        throw new l("field mathch fail: " + cls2.getName());
    }

    public static Field a(Class cls, Class cls2, boolean z) throws l {
        Field[] declaredFields = cls.getDeclaredFields();
        Field field = null;
        for (int i = 0; i < declaredFields.length; i++) {
            if (cls2.isAssignableFrom(declaredFields[i].getType())) {
                if (field == null) {
                    field = declaredFields[i];
                } else {
                    throw new l("field null: " + field.getName() + ", " + declaredFields[i].getName());
                }
            }
        }
        if (field != null) {
            field.setAccessible(true);
        }
        return field;
    }

    public static Object b(Field field, Object obj) {
        if (!(field == null || field == null)) {
            field.setAccessible(true);
            try {
                return field.get(obj);
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static void a(Class<?> cls, Object obj, Object obj2) throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            fields[i].set(obj2, fields[i].get(obj));
        }
    }

    public static void a(AccessibleObject accessibleObject, AccessibleObject[] accessibleObjectArr) {
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        a(accessibleObjectArr);
    }

    public static void a(AccessibleObject[] accessibleObjectArr) {
        for (AccessibleObject accessibleObject : accessibleObjectArr) {
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
        }
    }

    public static <T> T a(Object obj, String str) throws Exception {
        Field a2 = a(obj.getClass(), str);
        if (a2 == null) {
            return null;
        }
        a2.setAccessible(true);
        return a2.get(obj);
    }

    private static Field b(Class<?> cls, String str) throws Exception {
        Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
        return (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(declaredMethod.invoke((Object) null, new Object[]{cls.getName()}), new Object[]{str});
    }

    public static Field a(Class<?> cls, String str) throws Exception {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", new Class[]{String.class});
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(declaredMethod.invoke((Object) null, new Object[]{cls.getName()}), new Object[]{str});
        } catch (Throwable unused) {
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null) {
            return a((Class<?>) superclass, str);
        }
        throw e;
    }

    public static <T> T a(Object obj, String str, T t) {
        return a(obj, str, (Object) null, true);
    }

    public static <T> T a(Object obj, String str, T t, boolean z) {
        if (obj == null) {
            return t;
        }
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(obj.getClass(), new Object[]{str});
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception unused) {
            return t;
        }
    }

    public static <T> T a(Object obj, String str, T t, Class<?> cls) {
        return b(obj, str, (Object) null, cls);
    }

    public static <T> T b(Object obj, String str, T t, Class<?> cls) {
        if (obj == null) {
            return t;
        }
        try {
            Field field = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(cls, new Object[]{str});
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception unused) {
            return t;
        }
    }

    public static boolean a(Class<?> cls, List<String> list) {
        boolean contains;
        do {
            boolean contains2 = list.contains(r2.getName());
            Class<? super Object> cls2 = cls;
            if (contains2) {
                return true;
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            if (superclass == Object.class || superclass == null) {
                return false;
            }
            contains = list.contains(superclass.getName());
            cls2 = superclass;
        } while (!contains);
        return true;
    }
}
