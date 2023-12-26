package com.tal.app.thinkacademy.lib.util;

import android.util.Log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public final class BusUtils {
    private static final Object NULL = "nULl";
    private static final String TAG = "BusUtils";
    private final Map<String, Set<Object>> mClassName_BusesMap;
    private final Map<String, Map<String, Object>> mClassName_Tag_Arg4StickyMap;
    private final Map<String, List<String>> mClassName_TagsMap;
    private final Map<String, List<BusInfo>> mTag_BusInfoListMap;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface Bus {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    private void init() {
    }

    private BusUtils() {
        this.mTag_BusInfoListMap = new HashMap();
        this.mClassName_BusesMap = new ConcurrentHashMap();
        this.mClassName_TagsMap = new ConcurrentHashMap();
        this.mClassName_Tag_Arg4StickyMap = new ConcurrentHashMap();
        init();
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        registerBus(str, str2, str3, str4, str5, z, str6, 0);
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        String str7 = str;
        List list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            list = new ArrayList();
            this.mTag_BusInfoListMap.put(str, list);
        }
        list.add(new BusInfo(str2, str3, str4, str5, z, str6, i));
    }

    public static void register(Object obj) {
        getInstance().registerInner(obj);
    }

    public static void unregister(Object obj) {
        getInstance().unregisterInner(obj);
    }

    public static void post(String str) {
        post(str, NULL);
    }

    public static void post(String str, Object obj) {
        getInstance().postInner(str, obj);
    }

    public static void postSticky(String str) {
        postSticky(str, NULL);
    }

    public static void postSticky(String str, Object obj) {
        getInstance().postStickyInner(str, obj);
    }

    public static void removeSticky(String str) {
        getInstance().removeStickyInner(str);
    }

    public static String toString_() {
        return getInstance().toString();
    }

    public String toString() {
        return "BusUtils: " + this.mTag_BusInfoListMap;
    }

    private static BusUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private void registerInner(Object obj) {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            String name = cls.getName();
            synchronized (this.mClassName_BusesMap) {
                Set set = this.mClassName_BusesMap.get(name);
                if (set == null) {
                    set = new CopyOnWriteArraySet();
                    this.mClassName_BusesMap.put(name, set);
                }
                set.add(obj);
            }
            if (this.mClassName_TagsMap.get(name) == null) {
                synchronized (this.mClassName_TagsMap) {
                    if (this.mClassName_TagsMap.get(name) == null) {
                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                        for (Map.Entry next : this.mTag_BusInfoListMap.entrySet()) {
                            for (BusInfo busInfo : (List) next.getValue()) {
                                try {
                                    if (Class.forName(busInfo.className).isAssignableFrom(cls)) {
                                        copyOnWriteArrayList.add((String) next.getKey());
                                        busInfo.subClassNames.add(name);
                                    }
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        this.mClassName_TagsMap.put(name, copyOnWriteArrayList);
                    }
                }
            }
            processSticky(obj);
        }
    }

    private void processSticky(Object obj) {
        Map map = this.mClassName_Tag_Arg4StickyMap.get(obj.getClass().getName());
        if (map != null) {
            synchronized (this.mClassName_Tag_Arg4StickyMap) {
                for (Map.Entry entry : map.entrySet()) {
                    postStickyInner((String) entry.getKey(), entry.getValue(), true);
                }
            }
        }
    }

    private void unregisterInner(Object obj) {
        if (obj != null) {
            String name = obj.getClass().getName();
            synchronized (this.mClassName_BusesMap) {
                Set set = this.mClassName_BusesMap.get(name);
                if (set != null) {
                    if (set.contains(obj)) {
                        set.remove(obj);
                        return;
                    }
                }
                Log.e(TAG, "The bus of <" + obj + "> was not registered before.");
            }
        }
    }

    private void postInner(String str, Object obj) {
        postInner(str, obj, false);
    }

    private void postInner(String str, Object obj, boolean z) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo invokeBus : list) {
            invokeBus(str, obj, invokeBus, z);
        }
    }

    private void invokeBus(String str, Object obj, BusInfo busInfo, boolean z) {
        if (busInfo.method == null) {
            Method methodByBusInfo = getMethodByBusInfo(busInfo);
            if (methodByBusInfo != null) {
                busInfo.method = methodByBusInfo;
            } else {
                return;
            }
        }
        invokeMethod(str, obj, busInfo, z);
    }

    private Method getMethodByBusInfo(BusInfo busInfo) {
        try {
            if ("".equals(busInfo.paramType)) {
                return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[0]);
            }
            return Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[]{getClassName(busInfo.paramType)});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Class getClassName(String str) throws ClassNotFoundException {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c = 0;
                    break;
                }
                break;
            case 104431:
                if (str.equals("int")) {
                    c = 1;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c = 2;
                    break;
                }
                break;
            case 3052374:
                if (str.equals("char")) {
                    c = 3;
                    break;
                }
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 4;
                    break;
                }
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c = 5;
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c = 6;
                    break;
                }
                break;
            case 109413500:
                if (str.equals("short")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Double.TYPE;
            case 1:
                return Integer.TYPE;
            case 2:
                return Byte.TYPE;
            case 3:
                return Character.TYPE;
            case 4:
                return Long.TYPE;
            case 5:
                return Boolean.TYPE;
            case 6:
                return Float.TYPE;
            case 7:
                return Short.TYPE;
            default:
                return Class.forName(str);
        }
    }

    private void invokeMethod(String str, Object obj, BusInfo busInfo, boolean z) {
        final String str2 = str;
        final Object obj2 = obj;
        final BusInfo busInfo2 = busInfo;
        final boolean z2 = z;
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                BusUtils.this.realInvokeMethod(str2, obj2, busInfo2, z2);
            }
        };
        String str3 = busInfo.threadMode;
        str3.hashCode();
        char c = 65535;
        switch (str3.hashCode()) {
            case -1848936376:
                if (str3.equals("SINGLE")) {
                    c = 0;
                    break;
                }
                break;
            case 2342:
                if (str3.equals("IO")) {
                    c = 1;
                    break;
                }
                break;
            case 66952:
                if (str3.equals("CPU")) {
                    c = 2;
                    break;
                }
                break;
            case 2358713:
                if (str3.equals("MAIN")) {
                    c = 3;
                    break;
                }
                break;
            case 1980249378:
                if (str3.equals("CACHED")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ThreadUtils.getSinglePool().execute(r0);
                return;
            case 1:
                ThreadUtils.getIoPool().execute(r0);
                return;
            case 2:
                ThreadUtils.getCpuPool().execute(r0);
                return;
            case 3:
                ThreadUtils.runOnUiThread(r0);
                return;
            case 4:
                ThreadUtils.getCachedPool().execute(r0);
                return;
            default:
                r0.run();
                return;
        }
    }

    /* access modifiers changed from: private */
    public void realInvokeMethod(String str, Object obj, BusInfo busInfo, boolean z) {
        HashSet<Object> hashSet = new HashSet<>();
        for (String str2 : busInfo.subClassNames) {
            Set set = this.mClassName_BusesMap.get(str2);
            if (set != null && !set.isEmpty()) {
                hashSet.addAll(set);
            }
        }
        if (hashSet.size() != 0) {
            try {
                if (obj == NULL) {
                    for (Object invoke : hashSet) {
                        busInfo.method.invoke(invoke, new Object[0]);
                    }
                    return;
                }
                for (Object next : hashSet) {
                    busInfo.method.invoke(next, new Object[]{obj});
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
        } else if (!z) {
            Log.e(TAG, "The bus of tag <" + str + "> was not registered before.");
        }
    }

    private void postStickyInner(String str, Object obj) {
        postStickyInner(str, obj, false);
    }

    private void postStickyInner(String str, Object obj, boolean z) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (busInfo.sticky) {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map == null) {
                        map = new HashMap();
                        this.mClassName_Tag_Arg4StickyMap.put(busInfo.className, map);
                    }
                    map.put(str, obj);
                }
                invokeBus(str, obj, busInfo, true);
            } else if (!z) {
                invokeBus(str, obj, busInfo, false);
            }
        }
    }

    private void removeStickyInner(String str) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (!busInfo.sticky) {
                Log.e(TAG, "The bus of tag <" + str + "> is not sticky.");
                return;
            }
            synchronized (this.mClassName_Tag_Arg4StickyMap) {
                Map map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                if (map != null) {
                    if (map.containsKey(str)) {
                        map.remove(str);
                    }
                }
                Log.e(TAG, "The sticky bus of tag <" + str + "> didn't post.");
                return;
            }
        }
    }

    static void registerBus4Test(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        getInstance().registerBus(str, str2, str3, str4, str5, z, str6, i);
    }

    private static final class BusInfo {
        String className;
        String funName;
        Method method;
        String paramName;
        String paramType;
        int priority;
        boolean sticky;
        List<String> subClassNames = new CopyOnWriteArrayList();
        String threadMode;

        BusInfo(String str, String str2, String str3, String str4, boolean z, String str5, int i) {
            this.className = str;
            this.funName = str2;
            this.paramType = str3;
            this.paramName = str4;
            this.sticky = z;
            this.threadMode = str5;
            this.priority = i;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("BusInfo { desc: ");
            sb.append(this.className);
            sb.append("#");
            sb.append(this.funName);
            if ("".equals(this.paramType)) {
                str = "()";
            } else {
                str = "(" + this.paramType + " " + this.paramName + ")";
            }
            sb.append(str);
            sb.append(", sticky: ");
            sb.append(this.sticky);
            sb.append(", threadMode: ");
            sb.append(this.threadMode);
            sb.append(", method: ");
            sb.append(this.method);
            sb.append(", priority: ");
            sb.append(this.priority);
            sb.append(" }");
            return sb.toString();
        }
    }

    private static class LazyHolder {
        /* access modifiers changed from: private */
        public static final BusUtils INSTANCE = new BusUtils();

        private LazyHolder() {
        }
    }
}
