package com.tal.app.thinkacademy.lib.logger;

import com.dianping.logan.Logan;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.List;

public class XesLog {
    private static final String DEFAULT_TAG = "通用";
    private static final String DEFAULT_UT_TAG = "通用";
    private static final String XES_LOG_PACKAGE;

    static {
        String name = XesLog.class.getName();
        XES_LOG_PACKAGE = name.substring(0, name.lastIndexOf(46) + 1);
    }

    @Deprecated
    public static void vt(String str, Object... objArr) {
        log(XesLogType.I, false, str, objArr);
    }

    @Deprecated
    public static void dt(String str, Object... objArr) {
        log(XesLogType.I, false, str, objArr);
    }

    @Deprecated
    public static void it(String str, Object... objArr) {
        log(XesLogType.I, false, str, objArr);
    }

    @Deprecated
    public static void wt(String str, Object... objArr) {
        log(XesLogType.W, false, str, objArr);
    }

    @Deprecated
    public static void et(String str, Object... objArr) {
        log(XesLogType.E, false, str, objArr);
    }

    public static void i(XesLogTag xesLogTag, Object... objArr) {
        log(XesLogType.I, true, xesLogTag.get(), objArr);
    }

    public static void w(XesLogTag xesLogTag, Object... objArr) {
        log(XesLogType.W, true, xesLogTag.get(), objArr);
    }

    public static void e(XesLogTag xesLogTag, Object... objArr) {
        log(XesLogType.E, true, xesLogTag.get(), objArr);
    }

    public static void s(XesLogTag xesLogTag, Object... objArr) {
        log(XesLogType.S, true, xesLogTag.get(), objArr);
    }

    public static void a(XesLogTag xesLogTag, Object... objArr) {
        log(XesLogType.A, true, xesLogTag.get(), objArr);
    }

    public static void ut(XesLogTag xesLogTag, JsonObject jsonObject) {
        ut(xesLogTag.get(), jsonObject);
    }

    public static void ut(String str, JsonObject jsonObject) {
        XesLogType xesLogType = XesLogType.I;
        log(xesLogType, true, "通用", str + "--->" + jsonObject.toString());
    }

    private static void log(XesLogType xesLogType, boolean z, String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        log(XesLogManager.getInstance().getConfig(), xesLogType, z, str, objArr);
    }

    private static void log(XesLogConfig xesLogConfig, XesLogType xesLogType, boolean z, String str, Object... objArr) {
        String parseBody = parseBody(objArr, xesLogConfig);
        if (!z) {
            parseBody = str + "--->" + parseBody;
            str = "通用";
        }
        if (xesLogConfig.enable()) {
            StringBuilder sb = new StringBuilder();
            if (xesLogConfig.includeThread()) {
                sb.append(XesLogConfig.XES_THREAD_FORMATTER.format(Thread.currentThread()));
                sb.append("\n");
            }
            sb.append(parseBody);
            List<XesLogPrinter> asList = xesLogConfig.printers() != null ? Arrays.asList(xesLogConfig.printers()) : XesLogManager.getInstance().getPrinterList();
            if (asList != null) {
                for (XesLogPrinter print : asList) {
                    print.print(xesLogConfig, xesLogType.getLogType(), str, sb.toString());
                }
            } else {
                return;
            }
        }
        printIntoLogan(str, parseBody, xesLogType.getLoganType());
    }

    private static void printIntoLogan(String str, String str2, int i) {
        int i2;
        String str3;
        String str4;
        StackTraceElement stackTraceElement = null;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i3 = 3;
            if (stackTrace.length > 3) {
                while (true) {
                    if (i3 >= stackTrace.length) {
                        break;
                    } else if (!stackTrace[i3].getClassName().contains("XesLog")) {
                        stackTraceElement = stackTrace[i3];
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (stackTraceElement != null) {
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            str3 = stackTraceElement.getFileName();
            i2 = lineNumber;
            str4 = methodName;
        } else {
            i2 = -1;
            str4 = "";
            str3 = str4;
        }
        try {
            Logan.w(str2, i, str, str4, str3, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String parseBody(Object[] objArr, XesLogConfig xesLogConfig) {
        StringBuilder sb = new StringBuilder();
        if (objArr != null) {
            for (Exception exc : objArr) {
                if (exc != null) {
                    if (exc instanceof Exception) {
                        Exception exc2 = exc;
                        String format = XesLogConfig.XES_STACK_TRACE_FORMATTER.format(exc2.getStackTrace());
                        sb.append(exc2.getMessage());
                        sb.append("\n");
                        sb.append(format);
                    } else {
                        sb.append(exc.toString());
                        sb.append(";");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
