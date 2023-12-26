package com.bonree.sdk.bs;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class y {
    private Object a;

    private y(Object obj) {
        if (obj != null) {
            this.a = obj;
            return;
        }
        throw new IllegalArgumentException("Object can not be null.");
    }

    private a a(String str) {
        return new a(this.a, str);
    }

    private b a(String str, Class<?>... clsArr) {
        return new b(this.a, str, clsArr);
    }

    public class a {
        private Class<?> a;
        private Object b;
        private String c;

        public a(Object obj, String str) {
            this.b = obj;
            this.c = str;
        }

        private <T> T a(Class<T> cls) {
            return cls.cast(a(a()));
        }

        private void a(Object obj) {
            try {
                a().set(this.b, obj);
            } catch (IllegalAccessException | IllegalArgumentException unused) {
            }
        }

        private a b(Class<?> cls) {
            this.a = cls;
            return this;
        }

        private Field a() {
            if (this.a == null) {
                this.a = this.b.getClass();
            }
            Field field = null;
            try {
                field = this.a.getDeclaredField(this.c);
                field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException unused) {
                return field;
            }
        }

        private Object a(Field field) {
            if (field == null) {
                return null;
            }
            try {
                return field.get(this.b);
            } catch (IllegalAccessException | IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public class b {
        private Class<?> a;
        private Object b;
        private String c;
        private Class<?>[] d;

        public b(Object obj, String str, Class<?>... clsArr) {
            this.b = obj;
            this.c = str;
            this.d = clsArr;
        }

        private b a(Class<?> cls) {
            this.a = cls;
            return this;
        }

        private <T> T a(Class<T> cls, Object... objArr) {
            Method a2 = a();
            if (a2 == null) {
                return null;
            }
            if (cls != null) {
                try {
                    return cls.cast(a2.invoke(this.b, objArr));
                } catch (Throwable unused) {
                }
            } else {
                a2.invoke(this.b, objArr);
                return null;
            }
        }

        private Method a() {
            if (this.a == null) {
                this.a = this.b.getClass();
            }
            Method method = null;
            Class cls = this.a;
            while (cls != Object.class) {
                try {
                    method = cls.getDeclaredMethod(this.c, this.d);
                    method.setAccessible(true);
                    return method;
                } catch (Throwable unused) {
                    cls = cls.getSuperclass();
                }
            }
            return method;
        }
    }

    private static Map<String, String> a(Map<String, List<String>> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (list != null && list.size() > 0 && !TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) list.get(0))) {
                linkedHashMap.put(next.getKey(), list.get(0));
            }
        }
        return linkedHashMap;
    }
}
