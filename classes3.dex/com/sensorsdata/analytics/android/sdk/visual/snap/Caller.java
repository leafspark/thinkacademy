package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Caller {
    private static final String TAG = "SA.Caller";
    private final Object[] mMethodArgs;
    private final String mMethodName;
    private final Class<?> mMethodResultType;
    private final Class<?> mTargetClass;
    private final Method mTargetMethod;

    public Caller(Class<?> cls, String str, Object[] objArr, Class<?> cls2) throws NoSuchMethodException {
        this.mMethodName = str;
        this.mMethodArgs = objArr;
        this.mMethodResultType = cls2;
        Method pickMethod = pickMethod(cls);
        this.mTargetMethod = pickMethod;
        if (pickMethod != null) {
            this.mTargetClass = pickMethod.getDeclaringClass();
            return;
        }
        throw new NoSuchMethodException("Method " + cls.getName() + "." + str + " doesn't exit");
    }

    private static Class<?> assignableArgType(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return cls == Character.class ? Character.TYPE : cls;
    }

    public String toString() {
        return "[Caller " + this.mMethodName + "(" + this.mMethodArgs + ")]";
    }

    public Object[] getArgs() {
        return this.mMethodArgs;
    }

    public Object applyMethod(View view) {
        return applyMethodWithArguments(view, this.mMethodArgs);
    }

    public Object applyMethodWithArguments(View view, Object[] objArr) {
        if (!this.mTargetClass.isAssignableFrom(view.getClass())) {
            return null;
        }
        try {
            return this.mTargetMethod.invoke(view, objArr);
        } catch (IllegalAccessException e) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " appears not to be public", e);
            return null;
        } catch (IllegalArgumentException e2) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " called with arguments of the wrong type", e2);
            return null;
        } catch (InvocationTargetException e3) {
            SALog.i(TAG, "Method " + this.mTargetMethod.getName() + " threw an exception", e3);
            return null;
        }
    }

    public boolean argsAreApplicable(Object[] objArr) {
        Class[] parameterTypes = this.mTargetMethod.getParameterTypes();
        if (objArr.length != parameterTypes.length) {
            return false;
        }
        for (int i = 0; i < objArr.length; i++) {
            Class<?> assignableArgType = assignableArgType(parameterTypes[i]);
            if (objArr[i] == null) {
                if (assignableArgType == Byte.TYPE || assignableArgType == Short.TYPE || assignableArgType == Integer.TYPE || assignableArgType == Long.TYPE || assignableArgType == Float.TYPE || assignableArgType == Double.TYPE || assignableArgType == Boolean.TYPE || assignableArgType == Character.TYPE) {
                    return false;
                }
            } else if (!assignableArgType.isAssignableFrom(assignableArgType(objArr[i].getClass()))) {
                return false;
            }
        }
        return true;
    }

    private Method pickMethod(Class<?> cls) {
        Class[] clsArr = new Class[this.mMethodArgs.length];
        int i = 0;
        while (true) {
            Object[] objArr = this.mMethodArgs;
            if (i >= objArr.length) {
                break;
            }
            clsArr[i] = objArr[i].getClass();
            i++;
        }
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            if (name.equals(this.mMethodName) && parameterTypes.length == this.mMethodArgs.length && assignableArgType(this.mMethodResultType).isAssignableFrom(assignableArgType(method.getReturnType()))) {
                boolean z = true;
                for (int i2 = 0; i2 < parameterTypes.length && z; i2++) {
                    z = assignableArgType(parameterTypes[i2]).isAssignableFrom(assignableArgType(clsArr[i2]));
                }
                if (z) {
                    return method;
                }
            }
        }
        return null;
    }
}
