package com.eaydu.omni.net.squareup.moshi;

import java.io.ObjectStreamClass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class ClassFactory<T> {
    /* access modifiers changed from: package-private */
    public abstract T newInstance() throws InvocationTargetException, IllegalAccessException, InstantiationException;

    ClassFactory() {
    }

    public static <T> ClassFactory<T> get(final Class<?> cls) {
        try {
            final Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return new ClassFactory<T>() {
                public T newInstance() throws IllegalAccessException, InvocationTargetException, InstantiationException {
                    return declaredConstructor.newInstance((Object[]) null);
                }

                public String toString() {
                    return cls.getName();
                }
            };
        } catch (NoSuchMethodException unused) {
            try {
                Class<?> cls2 = Class.forName("sun.misc.Unsafe");
                Field declaredField = cls2.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                final Object obj = declaredField.get((Object) null);
                final Method method = cls2.getMethod("allocateInstance", new Class[]{Class.class});
                return new ClassFactory<T>() {
                    public T newInstance() throws InvocationTargetException, IllegalAccessException {
                        return method.invoke(obj, new Object[]{cls});
                    }

                    public String toString() {
                        return cls.getName();
                    }
                };
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused3) {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    declaredMethod2.setAccessible(true);
                    return new ClassFactory<T>() {
                        public T newInstance() throws InvocationTargetException, IllegalAccessException {
                            return declaredMethod2.invoke((Object) null, new Object[]{cls, Integer.valueOf(intValue)});
                        }

                        public String toString() {
                            return cls.getName();
                        }
                    };
                } catch (IllegalAccessException unused4) {
                    throw new AssertionError();
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused5) {
                    throw new IllegalArgumentException("cannot construct instances of " + cls.getName());
                }
            }
        }
    }
}
