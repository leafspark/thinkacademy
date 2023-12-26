package com.didi.hummer.render.component.view;

import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMJsonUtil;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.pool.ObjectPool;
import com.didi.hummer.render.component.anim.BasicAnimation;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseInvoker<T> implements Invoker {
    protected HummerContext mHummerContext;
    protected ObjectPool mInstanceManager;

    /* access modifiers changed from: protected */
    public abstract T createInstance(JSValue jSValue, Object... objArr);

    /* access modifiers changed from: protected */
    public abstract Object invoke(T t, String str, Object... objArr);

    public Object onInvoke(HummerContext hummerContext, long j, String str, Object... objArr) {
        this.mHummerContext = hummerContext;
        this.mInstanceManager = hummerContext.getObjectPool();
        Object instance = getInstance(j, str, objArr);
        if (instance instanceof HMBase) {
            return invokeHMBase(instance, str, objArr);
        }
        return invoke(instance, str, objArr);
    }

    private Object invokeHMBase(T t, String str, Object... objArr) {
        HMBase hMBase = (HMBase) t;
        str.hashCode();
        int i = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -2082845794:
                if (str.equals("dbg_highlight")) {
                    c = 0;
                    break;
                }
                break;
            case -1687483998:
                if (str.equals("resetStyle")) {
                    c = 1;
                    break;
                }
                break;
            case -665017928:
                if (str.equals("setAccessible")) {
                    c = 2;
                    break;
                }
                break;
            case -625809843:
                if (str.equals("addEventListener")) {
                    c = 3;
                    break;
                }
                break;
            case -541487286:
                if (str.equals("removeEventListener")) {
                    c = 4;
                    break;
                }
                break;
            case -287092152:
                if (str.equals("setAccessibilityLabel")) {
                    c = 5;
                    break;
                }
                break;
            case -280061979:
                if (str.equals("setAccessibilityState")) {
                    c = 6;
                    break;
                }
                break;
            case -75185574:
                if (str.equals("getRect")) {
                    c = 7;
                    break;
                }
                break;
            case 542438486:
                if (str.equals("removeAnimationForKey")) {
                    c = 8;
                    break;
                }
                break;
            case 550874503:
                if (str.equals("removeAllAnimation")) {
                    c = 9;
                    break;
                }
                break;
            case 683364531:
                if (str.equals("setAccessibilityHint")) {
                    c = 10;
                    break;
                }
                break;
            case 683668130:
                if (str.equals("setAccessibilityRole")) {
                    c = 11;
                    break;
                }
                break;
            case 925617692:
                if (str.equals("dbg_getDescription")) {
                    c = 12;
                    break;
                }
                break;
            case 980608995:
                if (str.equals("addAnimation")) {
                    c = 13;
                    break;
                }
                break;
            case 1082880659:
                if (str.equals("recycle")) {
                    c = 14;
                    break;
                }
                break;
            case 1364071551:
                if (str.equals("setEnabled")) {
                    c = 15;
                    break;
                }
                break;
            case 1404493423:
                if (str.equals("setStyle")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                hMBase.dbg_highlight(objArr.length > 0 ? objArr[0] : null);
                return null;
            case 1:
                hMBase.resetStyle();
                return null;
            case 2:
                hMBase.setAccessible(objArr[0].booleanValue());
                return null;
            case 3:
                hMBase.addEventListener(String.valueOf(objArr[0]), objArr[1]);
                return null;
            case 4:
                hMBase.removeEventListener(String.valueOf(objArr[0]), objArr.length > 1 ? objArr[1] : null);
                return null;
            case 5:
                hMBase.setAccessibilityLabel(String.valueOf(objArr[0]));
                return null;
            case 6:
                hMBase.setAccessibilityState(HMJsonUtil.toMap(String.valueOf(objArr[0])));
                return null;
            case 7:
                hMBase.getRect(objArr[0]);
                return null;
            case 8:
                hMBase.removeAnimationForKey(String.valueOf(objArr[0]));
                return null;
            case 9:
                hMBase.removeAllAnimation();
                return null;
            case 10:
                hMBase.setAccessibilityHint(String.valueOf(objArr[0]));
                return null;
            case 11:
                hMBase.setAccessibilityRole(String.valueOf(objArr[0]));
                return null;
            case 12:
                JSCallback jSCallback = objArr.length > 0 ? objArr[0] : null;
                if (objArr.length > 1) {
                    i = objArr[1].intValue();
                }
                hMBase.dbg_getDescription(jSCallback, i);
                return null;
            case 13:
                hMBase.addAnimation((BasicAnimation) this.mInstanceManager.get(objArr[0].longValue()), objArr[1]);
                return null;
            case 14:
                return null;
            case 15:
                hMBase.setEnabled(objArr[0].booleanValue());
                return null;
            case 16:
                hMBase.setStyle(getSortedMap(HMJsonUtil.toMap(String.valueOf(objArr[0]))));
                return null;
            default:
                return invoke(t, str, objArr);
        }
    }

    private T getInstance(long j, String str, Object... objArr) {
        T t;
        JSValue jSValue = null;
        if (j <= 0) {
            return null;
        }
        T t2 = this.mInstanceManager.get(j);
        if (t2 == null && "constructor".equals(str)) {
            if (objArr.length > 0) {
                jSValue = objArr[0];
            }
            if (jSValue != null) {
                if (objArr.length > 1) {
                    t = createInstance(jSValue, Arrays.copyOfRange(objArr, 1, objArr.length));
                } else {
                    t = createInstance(jSValue, new Object[0]);
                }
                t2 = t;
                if (t2 instanceof ILifeCycle) {
                    ((ILifeCycle) t2).onCreate();
                }
                this.mInstanceManager.put(j, t2);
            }
        }
        return t2;
    }

    private Map<String, Object> getSortedMap(Map<String, Object> map) {
        if (!map.containsKey("position") && !map.containsKey("display")) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object remove = map.remove("position");
        if (remove != null) {
            linkedHashMap.put("position", remove);
        }
        Object remove2 = map.remove("display");
        if (remove2 != null) {
            linkedHashMap.put("display", remove2);
        }
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }
}
