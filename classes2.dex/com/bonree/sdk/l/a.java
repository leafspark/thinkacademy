package com.bonree.sdk.l;

import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import java.util.Set;

public final class a implements SharedPreferences.Editor {
    private final SharedPreferences.Editor a;
    private final String b;

    public a(SharedPreferences.Editor editor, String str) {
        this.a = editor;
        this.b = str;
    }

    public final SharedPreferences.Editor putString(String str, String str2) {
        String a2 = a("putString", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putString(str, str2);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        String a2 = a("putStringSet", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putStringSet(str, set);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor putInt(String str, int i) {
        String a2 = a("putInt", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putInt(str, i);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor putLong(String str, long j) {
        String a2 = a("putLong", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putLong(str, j);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor putFloat(String str, float f) {
        String a2 = a("putFloat", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putFloat(str, f);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        String a2 = a("putBoolean", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.putBoolean(str, z);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor remove(String str) {
        String a2 = a("remove", str);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.remove(str);
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final SharedPreferences.Editor clear() {
        String a2 = a("clear", (String) null);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.clear();
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final boolean commit() {
        String a2 = a("commit", (String) null);
        MethodInfo.beforeMethod(a2, 9);
        try {
            return this.a.commit();
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    public final void apply() {
        String a2 = a("apply", (String) null);
        MethodInfo.beforeMethod(a2, 9);
        try {
            this.a.apply();
        } finally {
            MethodInfo.afterMethod(a2, 9);
        }
    }

    private String a(String str, String str2) {
        if (str2 != null) {
            if (str2.length() > 20) {
                str2 = str2.substring(0, 20);
            }
            return String.format("%s/%s(%s)", new Object[]{this.b, str, str2});
        }
        return String.format("%s/%s", new Object[]{this.b, str});
    }

    private static void a(String str) {
        MethodInfo.beforeMethod(str, 9);
    }

    private static void b(String str) {
        MethodInfo.afterMethod(str, 9);
    }
}
