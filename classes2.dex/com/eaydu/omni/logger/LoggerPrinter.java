package com.eaydu.omni.logger;

import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class LoggerPrinter implements Printer {
    private static final int JSON_INDENT = 2;
    private final ThreadLocal<String> localTag = new ThreadLocal<>();
    private final Object lock = new Object();
    private final List<LogAdapter> logAdapters = Collections.synchronizedList(new ArrayList());

    LoggerPrinter() {
    }

    public Printer t(String str) {
        if (str != null) {
            this.localTag.set(str);
        }
        return this;
    }

    public void d(String str, Object... objArr) {
        log(3, (Throwable) null, str, objArr);
    }

    public void d(Object obj) {
        log(3, (Throwable) null, Utils.toString(obj), new Object[0]);
    }

    public void e(String str, Object... objArr) {
        e((Throwable) null, str, objArr);
    }

    public void e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }

    public void w(String str, Object... objArr) {
        log(5, (Throwable) null, str, objArr);
    }

    public void i(String str, Object... objArr) {
        log(4, (Throwable) null, str, objArr);
    }

    public void v(String str, Object... objArr) {
        log(2, (Throwable) null, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        log(7, (Throwable) null, str, objArr);
    }

    public void json(String str) {
        if (Utils.isEmpty(str)) {
            d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(trim);
                d(!(jSONObject instanceof JSONObject) ? jSONObject.toString(2) : JSONObjectInstrumentation.toString(jSONObject, 2));
            } else if (trim.startsWith("[")) {
                JSONArray jSONArray = new JSONArray(trim);
                d(!(jSONArray instanceof JSONArray) ? jSONArray.toString(2) : JSONArrayInstrumentation.toString(jSONArray, 2));
            } else {
                e("Invalid Json", new Object[0]);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            e("Invalid Json", new Object[0]);
        }
    }

    public void xml(String str) {
        if (Utils.isEmpty(str)) {
            d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW);
            newTransformer.transform(streamSource, streamResult);
            d(streamResult.getWriter().toString().replaceFirst(">", ">\n"));
        } catch (TransformerException e) {
            e("Invalid xml", new Object[0]);
            e.printStackTrace();
        }
    }

    public synchronized void log(int i, String str, String str2, Throwable th) {
        synchronized (this.lock) {
            if (!(th == null || str2 == null)) {
                try {
                    str2 = str2 + " : " + Utils.getStackTraceString(th);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (th != null && str2 == null) {
                str2 = Utils.getStackTraceString(th);
            }
            if (Utils.isEmpty(str2)) {
                str2 = "Empty/NULL log message";
            }
            for (LogAdapter next : this.logAdapters) {
                if (next.isLoggable(i, str)) {
                    next.log(i, str, str2);
                }
            }
        }
    }

    public void clearLogAdapters() {
        try {
            this.logAdapters.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LogAdapter> getLogAdapters() {
        return this.logAdapters;
    }

    public void addAdapter(LogAdapter logAdapter) {
        try {
            this.logAdapters.add((LogAdapter) Utils.checkNotNull(logAdapter));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void log(int i, Throwable th, String str, Object... objArr) {
        Utils.checkNotNull(str);
        log(i, getTag(), createMessage(str, objArr), th);
    }

    private String getTag() {
        String str = this.localTag.get();
        if (str == null) {
            return null;
        }
        this.localTag.remove();
        return str;
    }

    private String createMessage(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
