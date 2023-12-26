package com.didi.hummer.render.event.base;

import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

public class TraceEvent {
    public static final String EVENT_NAME = "event_name";
    public static final String TIMESTAMP = "timestamp";
    public static final String VIEW_CONTENT = "view_content";
    public static final String VIEW_ID = "view_id";
    public static final String VIEW_NAME = "view_name";

    public static Map<String, Object> makeTraceGestureEvent(String str, View view, String str2) {
        String str3 = null;
        if (view == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(EVENT_NAME, str);
        hashMap.put(VIEW_NAME, view.getClass().getSimpleName());
        hashMap.put(VIEW_ID, str2);
        if (view instanceof TextView) {
            str3 = ((TextView) view).getText().toString();
        }
        hashMap.put(VIEW_CONTENT, str3);
        hashMap.put(TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }
}
