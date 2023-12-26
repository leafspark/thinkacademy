package com.igexin.push.util;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.google.protobuf.CodedOutputStream;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.bean.c;
import com.igexin.push.core.d;
import com.igexin.sdk.GActivity;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.GetuiPushException;
import com.igexin.sdk.PushActivity;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushReceiver;
import com.igexin.sdk.PushService;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    private static final String a = "com.igexin.push.util.a";
    private static Integer b;

    public static void a(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            e(context);
        }
    }

    private static void a(Map<String, c> map, String str) {
        map.remove(str);
        for (String next : map.get(str).b()) {
            c cVar = map.get(next);
            if (cVar != null) {
                cVar.e();
                if (cVar.c() == 0) {
                    a(map, next);
                }
            }
        }
    }

    public static boolean a() {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(l.i)) {
                return false;
            }
            for (String d : l.i.split(",")) {
                if (d(d)) {
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(l.j)) {
                return false;
            }
            String[] split = l.j.split(",");
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", new Class[]{String.class});
            method.setAccessible(true);
            for (String a2 : split) {
                if (a(cls, method, a2)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long r4) {
        /*
            int r0 = com.igexin.push.config.l.b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.util.Date r0 = new java.util.Date
            r0.<init>(r4)
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r4.setTime(r0)
            r5 = 11
            int r4 = r4.get(r5)
            int r5 = com.igexin.push.config.l.a
            int r0 = com.igexin.push.config.l.b
            int r5 = r5 + r0
            r0 = 24
            if (r5 < r0) goto L_0x0023
            int r5 = r5 + -24
        L_0x0023:
            int r2 = com.igexin.push.config.l.a
            r3 = 1
            if (r2 >= r5) goto L_0x002f
            int r0 = com.igexin.push.config.l.a
            if (r4 < r0) goto L_0x003f
            if (r4 >= r5) goto L_0x003f
            return r3
        L_0x002f:
            int r2 = com.igexin.push.config.l.a
            if (r2 <= r5) goto L_0x003f
            if (r4 < 0) goto L_0x0038
            if (r4 >= r5) goto L_0x0038
            return r3
        L_0x0038:
            int r5 = com.igexin.push.config.l.a
            if (r4 < r5) goto L_0x003f
            if (r4 >= r0) goto L_0x003f
            return r3
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.a.a(long):boolean");
    }

    public static boolean a(Context context, Class cls) {
        if (context == null) {
            try {
                Log.e(a, "context can not set null ");
                return false;
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
                return false;
            }
        } else {
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent(context, cls), 0);
            if (queryIntentActivities != null) {
                if (queryIntentActivities.size() > 0) {
                    if (packageManager.getActivityInfo(new ComponentName(context.getPackageName(), cls.getName()), 128).theme == 16973840) {
                        return true;
                    }
                    String str = a;
                    Log.e(str, cls.getName() + " need set theme Theme.Translucent.NoTitleBar");
                    return false;
                }
            }
            String str2 = a;
            Log.e(str2, "not regist " + cls.getName() + "in manifest");
            return false;
        }
    }

    public static boolean a(Intent intent, Context context) {
        if (!(intent == null || context == null)) {
            try {
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                return queryIntentServices != null && queryIntentServices.size() > 0;
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
            }
        }
        return false;
    }

    private static boolean a(Class<?> cls, Method method, String str) {
        try {
            return method.invoke(cls, new Object[]{str}) != null;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(String str) {
        try {
            return d.g.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static <T extends Service> boolean a(String str, Context context, Class<T> cls) {
        if (cls == null) {
            try {
                if (!a(new Intent(context, Class.forName(CoreConsts.p)), context)) {
                    com.igexin.b.a.c.a.c.a().a("call - > initialize, parameter [userServiceName] is null use default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
                    return false;
                }
            } catch (Throwable th) {
                b.a(a + "|" + th.toString(), new Object[0]);
                return false;
            }
        }
        if (cls != null && CoreConsts.p.equals(cls.getName()) && !a(new Intent(context, cls), context)) {
            com.igexin.b.a.c.a.c.a().a("call - > initialize, parameter [userServiceName] is default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
            return false;
        } else if (cls != null && !a(new Intent(context, cls), context)) {
            com.igexin.b.a.c.a.c a2 = com.igexin.b.a.c.a.c.a();
            a2.a("call - > initialize, parameter [userServiceName] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
            return false;
        } else if (cls == null) {
            return true;
        } else {
            Class.forName(cls.getName());
            return true;
        }
    }

    public static boolean a(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String string;
        String str4 = "buttons";
        String str5 = HummerStyleUtils.Hummer.TYPE;
        String str6 = "actionid";
        try {
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            int i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                c cVar = new c();
                if (jSONObject2.has(str6)) {
                    cVar.a(jSONObject2.getString(str6));
                    if (hashMap.containsKey(cVar.a())) {
                        return true;
                    }
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has(str5)) {
                        String string2 = jSONObject2.getString(str5);
                        str3 = str5;
                        str2 = str6;
                        if ("popup".equals(string2)) {
                            if (jSONObject2.has(str4)) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray(str4);
                                str = str4;
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    if (((JSONObject) jSONArray2.get(i2)).has("do")) {
                                        arrayList.add(((JSONObject) jSONArray2.get(i2)).getString("do"));
                                    }
                                }
                            } else {
                                str = str4;
                            }
                            if (jSONObject2.has("do")) {
                                string = jSONObject2.getString("do");
                            }
                            cVar.a((List<String>) arrayList);
                            hashMap.put(cVar.a(), cVar);
                            i++;
                            str5 = str3;
                            str6 = str2;
                            str4 = str;
                        } else {
                            str = str4;
                            if ("startapp".equals(string2)) {
                                if (jSONObject2.has("noinstall_action")) {
                                    arrayList.add(jSONObject2.getString("noinstall_action"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("checkapp".equals(string2)) {
                                if (jSONObject2.has("do_installed")) {
                                    arrayList.add(jSONObject2.getString("do_installed"));
                                }
                                if (jSONObject2.has("do_uninstalled")) {
                                    string = jSONObject2.getString("do_uninstalled");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("checkversions".equals(string2)) {
                                if (jSONObject2.has("do_match")) {
                                    arrayList.add(jSONObject2.getString("do_match"));
                                }
                                if (jSONObject2.has("do_dismatch")) {
                                    arrayList.add(jSONObject2.getString("do_dismatch"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else if ("startintent".equals(string2)) {
                                if (jSONObject2.has("do_failed")) {
                                    arrayList.add(jSONObject2.getString("do_failed"));
                                }
                                if (jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            } else {
                                if (!"null".equals(string2) && jSONObject2.has("do")) {
                                    string = jSONObject2.getString("do");
                                }
                                cVar.a((List<String>) arrayList);
                                hashMap.put(cVar.a(), cVar);
                                i++;
                                str5 = str3;
                                str6 = str2;
                                str4 = str;
                            }
                        }
                        arrayList.add(string);
                        cVar.a((List<String>) arrayList);
                        hashMap.put(cVar.a(), cVar);
                        i++;
                        str5 = str3;
                        str6 = str2;
                        str4 = str;
                    }
                }
                str = str4;
                str3 = str5;
                str2 = str6;
                i++;
                str5 = str3;
                str6 = str2;
                str4 = str;
            }
            ArrayList<c> arrayList2 = new ArrayList<>(hashMap.values());
            for (Map.Entry value : hashMap.entrySet()) {
                List<String> b2 = ((c) value.getValue()).b();
                if (b2 != null) {
                    for (String str7 : b2) {
                        c cVar2 = (c) hashMap.get(str7);
                        if (cVar2 != null) {
                            cVar2.d();
                            if (arrayList2.contains(cVar2)) {
                                arrayList2.remove(cVar2);
                            }
                        }
                    }
                }
            }
            for (c a2 : arrayList2) {
                a((Map<String, c>) hashMap, a2.a());
            }
            if (hashMap.size() <= 0) {
                return false;
            }
            b.a(a + "|action_chains have loop nodeMap not empty", new Object[0]);
            return true;
        } catch (Throwable th) {
            b.a(a + "|isHaveLoop exception :" + th.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean b() {
        return System.currentTimeMillis() > l.c;
    }

    public static boolean b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((Boolean) NotificationManager.class.getDeclaredMethod("areNotificationsEnabled", new Class[0]).invoke((NotificationManager) context.getSystemService("notification"), new Object[0])).booleanValue();
            } else if (Build.VERSION.SDK_INT < 19) {
                return true;
            } else {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName})).intValue() == 0;
            }
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            return queryIntentActivities != null && queryIntentActivities.size() > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        try {
            if (!TextUtils.isEmpty(l.y)) {
                if (!PushBuildConfig.sdk_conf_debug_level.equals(l.y)) {
                    List<String> asList = Arrays.asList(l.y.split(","));
                    if (asList.isEmpty()) {
                        return false;
                    }
                    for (String startsWith : asList) {
                        if (str.startsWith(startsWith)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void c(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if ((applicationContext.getApplicationInfo().flags & 2) != 0) {
                if (e(applicationContext)) {
                    try {
                        ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                        if (applicationInfo == null || applicationInfo.metaData == null) {
                            throw new GetuiPushException("未配置META-DATA");
                        } else if (TextUtils.isEmpty(applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID))) {
                            throw new GetuiPushException("未配置个推APPID");
                        } else if (TextUtils.isEmpty(applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET))) {
                            throw new GetuiPushException("未配置个推APPSECRET");
                        } else if (!TextUtils.isEmpty(applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY))) {
                            List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent(applicationContext, PushService.class), 0);
                            if (queryIntentServices == null || queryIntentServices.size() == 0) {
                                throw new GetuiPushException("未集成com.igexin.sdk.PushService");
                            }
                            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                if (!serviceInfo.processName.endsWith(":pushservice")) {
                                    throw new GetuiPushException("PushService需配置在pushservice进程");
                                } else if (!"android.permission.BIND_JOB_SERVICE".equalsIgnoreCase(serviceInfo.permission)) {
                                    throw new GetuiPushException("PushService需配置BIND_JOB_SERVICE权限");
                                }
                            }
                            List<ResolveInfo> queryIntentActivities = applicationContext.getPackageManager().queryIntentActivities(new Intent(applicationContext, GActivity.class), 0);
                            if (queryIntentActivities == null || queryIntentActivities.size() == 0) {
                                throw new GetuiPushException("未集成com.igexin.sdk.GActivity");
                            }
                            ActivityInfo activityInfo = queryIntentActivities.get(0).activityInfo;
                            if (activityInfo != null) {
                                if (!activityInfo.processName.endsWith(":pushservice")) {
                                    throw new GetuiPushException("GActivity需配置在pushservice进程");
                                } else if (activityInfo.theme != 16973840) {
                                    throw new GetuiPushException("GActivity未配置正确theme");
                                } else if (!activityInfo.exported) {
                                    throw new GetuiPushException("GActivity.exported需配置为true");
                                }
                            }
                            List<ResolveInfo> queryIntentActivities2 = applicationContext.getPackageManager().queryIntentActivities(new Intent(applicationContext, PushActivity.class), 0);
                            if (queryIntentActivities2 == null || queryIntentActivities2.size() == 0) {
                                throw new GetuiPushException("未集成com.igexin.sdk.PushActivity");
                            }
                            ActivityInfo activityInfo2 = queryIntentActivities2.get(0).activityInfo;
                            if (activityInfo2 != null) {
                                if (!activityInfo2.processName.endsWith(":pushservice")) {
                                    throw new GetuiPushException("PushActivity需配置在pushservice进程");
                                } else if (activityInfo2.theme != 16973840) {
                                    throw new GetuiPushException("PushActivity未配置正确theme");
                                }
                            }
                            List<ResolveInfo> queryBroadcastReceivers = applicationContext.getPackageManager().queryBroadcastReceivers(new Intent(applicationContext, PushReceiver.class), 0);
                            if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() == 0) {
                                throw new GetuiPushException("未集成com.igexin.sdk.PushReceiver");
                            }
                            try {
                                PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), CodedOutputStream.DEFAULT_BUFFER_SIZE);
                                if (packageInfo != null) {
                                    String[] strArr = packageInfo.requestedPermissions;
                                    if (strArr == null || strArr.length == 0) {
                                        throw new GetuiPushException("Manifest中无权限配置");
                                    }
                                    List asList = Arrays.asList(strArr);
                                    if (!asList.contains("android.permission.INTERNET")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.INTERNET");
                                    } else if (!asList.contains("android.permission.READ_PHONE_STATE")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.READ_PHONE_STATE");
                                    } else if (!asList.contains("android.permission.ACCESS_NETWORK_STATE")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_NETWORK_STATE");
                                    } else if (!asList.contains("android.permission.ACCESS_WIFI_STATE")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.ACCESS_WIFI_STATE");
                                    } else if (!asList.contains(PermissionConfig.WRITE_EXTERNAL_STORAGE)) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.WRITE_EXTERNAL_STORAGE");
                                    } else if (!asList.contains("android.permission.VIBRATE")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.VIBRATE");
                                    } else if (!asList.contains("android.permission.GET_TASKS")) {
                                        throw new GetuiPushException("未在Manifest中配置所需权限：android.permission.GET_TASKS");
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                            }
                            ServiceInfo serviceInfo2 = (ServiceInfo) b.a(applicationContext, PushService.class).first;
                            if (serviceInfo2 == null) {
                                throw new GetuiPushException("未找到自定义推送服务(Service)");
                            } else if (!serviceInfo2.processName.endsWith(":pushservice")) {
                                throw new GetuiPushException("自定义推送服务(Service)需配置在pushservice进程");
                            } else if (!serviceInfo2.exported) {
                                throw new GetuiPushException("自定义推送服务(Service).exported需配置为true");
                            } else if (TextUtils.isEmpty(serviceInfo2.permission)) {
                                ServiceInfo serviceInfo3 = (ServiceInfo) b.a(applicationContext, GTIntentService.class).first;
                                if (serviceInfo3 == null) {
                                    throw new GetuiPushException("未找到自定义GTIntentService");
                                } else if (!"android.permission.BIND_JOB_SERVICE".equalsIgnoreCase(serviceInfo3.permission)) {
                                    throw new GetuiPushException("自定义GTIntentService需配置BIND_JOB_SERVICE权限");
                                }
                            } else {
                                throw new GetuiPushException("自定义推送服务(Service)不能配置android:permission");
                            }
                        } else {
                            throw new GetuiPushException("未配置个推APPKEY");
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw new GetuiPushException("libgetuiext3.so不存在");
                }
            }
        } else {
            throw new GetuiPushException("传入的context为空");
        }
    }

    public static boolean c() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) d.g.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean c(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(l.A)) {
                if (!PushBuildConfig.sdk_conf_debug_level.equals(l.A)) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(Arrays.asList(l.A.split(",")));
                    if (arrayList.isEmpty()) {
                        return false;
                    }
                    for (String contains : arrayList) {
                        if (str.contains(contains)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void d() {
        NetworkInfo.State state = ((ConnectivityManager) d.g.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            d.r = 1;
        } else {
            d.r = 0;
        }
    }

    public static boolean d(Context context) {
        if (b == null) {
            b = (context.getApplicationInfo().flags & 2) == 0 ? -1 : 1;
        }
        return b.intValue() > 0;
    }

    private static boolean d(String str) {
        try {
            d.g.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e() {
        d.s = ((PowerManager) d.g.getSystemService("power")).isScreenOn() ? 1 : 0;
    }

    private static boolean e(Context context) {
        File file = new File(context.getApplicationInfo().nativeLibraryDir, "libgetuiext3.so");
        if (file.exists()) {
            return true;
        }
        String str = "libgetuiext3.so not found in path: " + file.getAbsolutePath() + " please check!";
        com.igexin.b.a.c.a.c.a().a("[" + a + "] " + str);
        return false;
    }

    public static boolean f() {
        String str = l.L;
        if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            if ("*".equals(str)) {
                return false;
            }
            String lowerCase = m.a().toLowerCase();
            if (TextUtils.isEmpty(lowerCase)) {
                return true;
            }
            for (String lowerCase2 : str.split(",")) {
                if (lowerCase.contains(lowerCase2.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g() {
        try {
            for (String lowerCase : l.x.split(",")) {
                if (Build.MODEL.toLowerCase().contains(lowerCase.toLowerCase())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean h() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.g.getSystemService("connectivity");
            if (connectivityManager == null) {
                b.a(a + "|ConnectivityManager is null", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            StringBuilder sb = new StringBuilder();
            String str = a;
            sb.append(str);
            sb.append("|activeNetworkInfo = ");
            sb.append(activeNetworkInfo);
            b.a(sb.toString(), new Object[0]);
            if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
                b.a(str + "|network available = false", new Object[0]);
                return false;
            }
            String str2 = activeNetworkInfo.getType() == 0 ? "mobile" : activeNetworkInfo.getType() == 1 ? "wifi" : PushBuildConfig.sdk_conf_debug_level;
            b.a(str + str2 + "|connected", new Object[0]);
            return true;
        } catch (Throwable th) {
            b.a(a + "|network available ex =" + th.toString(), new Object[0]);
        }
    }

    public static boolean i() {
        return System.currentTimeMillis() >= 1182566108138L;
    }

    public static boolean j() {
        String str = l.K;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            for (String str2 : str.split(",")) {
                if (str2.contains("|")) {
                    if (str2.contains("~")) {
                        String substring = str2.substring(0, str2.indexOf("|"));
                        String[] split = str2.substring(str2.indexOf("|") + 1).split("~");
                        if (split.length == 2) {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (m.a().equalsIgnoreCase(substring) && Build.VERSION.SDK_INT >= parseInt && Build.VERSION.SDK_INT <= parseInt2) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
