package com.eaydu.omni.logger;

import java.util.List;

public interface Printer {
    void addAdapter(LogAdapter logAdapter);

    void clearLogAdapters();

    void d(Object obj);

    void d(String str, Object... objArr);

    void e(String str, Object... objArr);

    void e(Throwable th, String str, Object... objArr);

    List<LogAdapter> getLogAdapters();

    void i(String str, Object... objArr);

    void json(String str);

    void log(int i, String str, String str2, Throwable th);

    Printer t(String str);

    void v(String str, Object... objArr);

    void w(String str, Object... objArr);

    void wtf(String str, Object... objArr);

    void xml(String str);
}
