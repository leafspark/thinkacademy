package com.bonree.sdk.an;

import android.os.Looper;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.common.json.HTTP;
import com.bumptech.glide.load.Key;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private static int a = 100;
    private static int b = 10000;
    private static int c = 6000;
    private static int d = 20;
    private static String e = "main";
    private static Charset f = null;
    private static String g = "BR-";
    private static String h = "BR_";

    static {
        Charset.forName(Key.STRING_CHARSET_NAME);
    }

    public static ThreadDumpInfoBean a(boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        return a(thread, thread.getStackTrace(), z);
    }

    public static ThreadDumpInfoBean a(Map<Thread, StackTraceElement[]> map, boolean z) {
        if (map == null || map.size() == 0) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        return a(thread, map.get(thread), true);
    }

    private static ThreadDumpInfoBean a() {
        Thread currentThread = Thread.currentThread();
        return a(currentThread, currentThread.getStackTrace(), true);
    }

    private static ThreadDumpInfoBean b(long j) {
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            if (next != null && next.getKey() != null && ((Thread) next.getKey()).getId() == j) {
                return a((Thread) next.getKey(), (StackTraceElement[]) next.getValue(), true);
            }
        }
        return null;
    }

    private static ThreadDumpInfoBean d(String str) {
        if (ad.a(str)) {
            return null;
        }
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            if (next != null && next.getKey() != null && str.equals(((Thread) next.getKey()).getName())) {
                return a((Thread) next.getKey(), (StackTraceElement[]) next.getValue(), true);
            }
        }
        return null;
    }

    public static ThreadDumpInfoBean a(Map<Thread, StackTraceElement[]> map, String str) {
        if (!(map == null || map.size() == 0)) {
            for (Map.Entry next : map.entrySet()) {
                if (next != null && next.getKey() != null && str.equals(((Thread) next.getKey()).getName())) {
                    return a((Thread) next.getKey(), (StackTraceElement[]) next.getValue(), true);
                }
            }
        }
        return null;
    }

    public static Map<Thread, StackTraceElement[]> a(long j) {
        int activeCount = Thread.activeCount();
        HashMap hashMap = new HashMap((activeCount / 2) + activeCount);
        try {
            int i = activeCount + (activeCount / 2);
            Thread[] threadArr = new Thread[i];
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            if (threadGroup == null) {
                com.bonree.sdk.be.a.a().e("DumpUtils threadGroup is null", new Object[0]);
                return hashMap;
            }
            ThreadGroup threadGroup2 = (ThreadGroup) z.a((Object) threadGroup, "systemThreadGroup");
            if (threadGroup2 != null) {
                threadGroup2.enumerate(threadArr);
            } else {
                threadGroup.enumerate(threadArr, true);
            }
            for (int i2 = 0; i2 < i; i2++) {
                Thread thread = threadArr[i2];
                if (thread != null && (!thread.getName().startsWith("BR-") || thread.getId() == j)) {
                    hashMap.put(thread, thread.getStackTrace());
                }
            }
            return hashMap;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("DumpUtils getAllStackTraces error:%s", th.toString());
        }
    }

    private static List<ThreadDumpInfoBean> a(String str, int i) {
        return a(-1, str, i);
    }

    private static List<ThreadDumpInfoBean> a(long j, int i) {
        return a(j, (String) null, i);
    }

    private static List<ThreadDumpInfoBean> a(long j, String str, int i) {
        ThreadDumpInfoBean a2;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            if (next != null) {
                if (i > 0 && arrayList.size() >= i) {
                    break;
                }
                Thread thread = (Thread) next.getKey();
                if ((j <= 0 || j != thread.getId()) && ((str == null || !str.equals(thread.getName())) && (a2 = a(thread, (StackTraceElement[]) next.getValue(), true)) != null)) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private static List<ThreadDumpInfoBean> a(Map<Thread, StackTraceElement[]> map, long j, String str, int i) {
        ThreadDumpInfoBean a2;
        ArrayList arrayList = new ArrayList();
        if (map != null && map.size() != 0) {
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    if (i > 0 && arrayList.size() >= i) {
                        break;
                    }
                    Thread thread = (Thread) next.getKey();
                    if ((j <= 0 || j != thread.getId()) && ((str == null || !str.equals(thread.getName())) && (a2 = a(thread, (StackTraceElement[]) next.getValue(), true)) != null)) {
                        arrayList.add(a2);
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<ThreadDumpInfoBean> b(Map<Thread, StackTraceElement[]> map, String str) {
        if ("main".equals(str)) {
            return a(map, -1, str, 19);
        }
        long id = Looper.getMainLooper().getThread().getId();
        ArrayList arrayList = new ArrayList();
        ThreadDumpInfoBean a2 = a(map, true);
        if (a2 != null) {
            arrayList.add(a2);
        }
        arrayList.addAll(a(map, id, str, 18));
        return arrayList;
    }

    private static ThreadDumpInfoBean a(Thread thread, StackTraceElement[] stackTraceElementArr, boolean z) {
        String str;
        if (thread == null || stackTraceElementArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (stackTraceElementArr.length != 0) {
                int i = 0;
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (i >= 100 || sb.length() >= 10000) {
                        break;
                    }
                    if (stackTraceElement != null) {
                        if (z) {
                            sb.append("at ");
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append(HTTP.CRLF);
                        i++;
                    }
                }
            } else {
                sb.append("at dalvik.system.NativeStart.run(Native Method)");
            }
            str = sb.toString();
            try {
                if (str.length() > 10000) {
                    str = str.substring(0, 10000);
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        ThreadDumpInfoBean threadDumpInfoBean = new ThreadDumpInfoBean();
        threadDumpInfoBean.mThreadId = String.valueOf(thread.getId());
        threadDumpInfoBean.mThreadName = thread.getName();
        threadDumpInfoBean.mDumpInfo = str;
        return threadDumpInfoBean;
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        if (ad.a(str)) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new StringReader(str));
            try {
                String readLine = bufferedReader.readLine();
                ad.a((Closeable) bufferedReader);
                return readLine;
            } catch (IOException unused) {
                ad.a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                ad.a((Closeable) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
            ad.a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            ad.a((Closeable) bufferedReader2);
            throw th;
        }
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        if (ad.a(str)) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new StringReader(str));
            try {
                String readLine = bufferedReader.readLine();
                String str2 = readLine;
                while (str2 != null && str2.trim().startsWith("native")) {
                    str2 = bufferedReader.readLine();
                }
                if (str2 != null) {
                    readLine = str2;
                }
                if (readLine.trim().startsWith("at")) {
                    readLine = readLine.trim().replaceFirst("at", "").trim();
                }
                ad.a((Closeable) bufferedReader);
                return readLine;
            } catch (IOException unused) {
                ad.a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                ad.a((Closeable) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
            ad.a((Closeable) bufferedReader);
            return null;
        } catch (Throwable th2) {
            th = th2;
            ad.a((Closeable) bufferedReader2);
            throw th;
        }
    }

    private static String e(String str) {
        InputStreamReader inputStreamReader;
        ByteArrayInputStream byteArrayInputStream;
        if (ad.a(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                inputStreamReader = new InputStreamReader(byteArrayInputStream);
            } catch (IOException unused) {
                inputStreamReader = null;
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                throw th;
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                int i = 0;
                while (i < 100) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(HTTP.CRLF);
                        i++;
                    } catch (IOException unused2) {
                        bufferedReader = bufferedReader2;
                        ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                        throw th;
                    }
                }
                String sb2 = sb.toString();
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                return sb2;
            } catch (IOException unused3) {
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                return "";
            } catch (Throwable th3) {
                th = th3;
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                throw th;
            }
        } catch (IOException unused4) {
            inputStreamReader = null;
            byteArrayInputStream = null;
            ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
            return "";
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            byteArrayInputStream = null;
            ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
            throw th;
        }
    }

    public static String c(String str) {
        InputStreamReader inputStreamReader;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (ad.a(str)) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
            try {
                inputStreamReader = new InputStreamReader(byteArrayInputStream);
            } catch (IOException unused) {
                inputStreamReader = null;
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                return "";
            } catch (Throwable th) {
                th = th;
                inputStreamReader = null;
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                throw th;
            }
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
            } catch (IOException unused2) {
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                return "";
            } catch (Throwable th2) {
                th = th2;
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                throw th;
            }
            try {
                char[] cArr = new char[6001];
                bufferedReader.read(cArr, 0, 6000);
                String str2 = new String(cArr);
                ad.a(bufferedReader, inputStreamReader, byteArrayInputStream);
                return str2;
            } catch (IOException unused3) {
                bufferedReader2 = bufferedReader;
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                return "";
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader;
                ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
                throw th;
            }
        } catch (IOException unused4) {
            inputStreamReader = null;
            byteArrayInputStream = null;
            ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
            return "";
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            byteArrayInputStream = null;
            ad.a(bufferedReader2, inputStreamReader, byteArrayInputStream);
            throw th;
        }
    }
}
