package com.bonree.sdk.agent.engine.external;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bonree.sdk.d.e;
import com.bonree.sdk.l.b;
import org.xmlpull.v1.XmlPullParser;

public class XMLParseInstrumentation {
    private static final String LAYOUT_INFLATER = "LayoutInflater/inflate";
    private static final String VIEW_INFLATER = "View/inflate";

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup) {
        String methodName = getMethodName(LAYOUT_INFLATER, i, "ViewGroup");
        beforeMethod(methodName);
        try {
            return layoutInflater.inflate(i, viewGroup);
        } finally {
            afterMethod(methodName);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z) {
        String methodName = getMethodName(LAYOUT_INFLATER, i, "ViewGroup,boolean");
        beforeMethod(methodName);
        try {
            return layoutInflater.inflate(i, viewGroup, z);
        } finally {
            afterMethod(methodName);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup) {
        String methodName = getMethodName(LAYOUT_INFLATER, 0, "XmlPullParser,ViewGroup");
        beforeMethod(methodName);
        try {
            return layoutInflater.inflate(xmlPullParser, viewGroup);
        } finally {
            afterMethod(methodName);
        }
    }

    public static View inflate(LayoutInflater layoutInflater, XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean z) {
        String methodName = getMethodName(LAYOUT_INFLATER, 0, "XmlPullParser,ViewGroup,boolean");
        beforeMethod(methodName);
        try {
            return layoutInflater.inflate(xmlPullParser, viewGroup, z);
        } finally {
            afterMethod(methodName);
        }
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        String methodName = getMethodName(VIEW_INFLATER, "Context", i, "ViewGroup");
        beforeMethod(methodName);
        try {
            return View.inflate(context, i, viewGroup);
        } finally {
            afterMethod(methodName);
        }
    }

    private static String getLayoutName(int i) {
        try {
            return e.d().c().getResources().getResourceEntryName(i);
        } catch (Throwable unused) {
            return "int";
        }
    }

    private static String getMethodName(String str, String str2, int i, String str3) {
        if (i != 0) {
            try {
                String layoutName = getLayoutName(i);
                if (str2 != null) {
                    return String.format("%s(%s,%s,%s)", new Object[]{str, str2, layoutName, str3});
                }
                return String.format("%s(%s,%s)", new Object[]{str, layoutName, str3});
            } catch (Throwable unused) {
                return str;
            }
        } else if (str2 != null) {
            return String.format("%s(%s,%s)", new Object[]{str, str2, str3});
        } else {
            return String.format("%s(%s)", new Object[]{str, str3});
        }
    }

    private static String getMethodName(String str, int i, String str2) {
        return getMethodName(str, (String) null, i, str2);
    }

    private static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 7);
    }

    private static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 7);
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        return b.a(context.getSharedPreferences(str, i), str);
    }
}
