package com.bonree.sdk.agent.engine.external;

import android.view.View;
import com.bonree.sdk.d.a;
import com.bonree.sdk.k.d;
import com.bonree.sdk.x.b;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;

public class MethodInfo {
    public static void beforeMethod(String str, int i) {
        String str2;
        if (a.L()) {
            str2 = b.a().b();
        } else {
            str2 = com.bonree.sdk.z.b.a().b();
        }
        d.a().a(str2, str, i);
    }

    public static void beforeMethod(String str, int i, String str2, String str3) {
        String str4;
        if (a.L()) {
            str4 = b.a().b();
        } else {
            str4 = com.bonree.sdk.z.b.a().b();
        }
        d.a().a(str4, str, i, str2, str3);
    }

    public static void beforeMethod(String str, int i, String str2, String str3, int i2) {
        String str4;
        if (a.L()) {
            str4 = b.a().b();
        } else {
            str4 = com.bonree.sdk.z.b.a().b();
        }
        d.a().a(str4, str, i, str2, str3, i2);
    }

    public static void afterMethod(String str, int i) {
        String str2;
        if (a.L()) {
            str2 = b.a().b();
        } else {
            str2 = com.bonree.sdk.z.b.a().b();
        }
        d.a().b(str2, str, i);
    }

    public static void afterMethod(String str, int i, String str2, String str3) {
        String str4;
        if (a.L()) {
            str4 = b.a().b();
        } else {
            str4 = com.bonree.sdk.z.b.a().b();
        }
        d.a().b(str4, str, i, str2, str3);
    }

    public static void afterMethod(String str, int i, String str2, String str3, int i2) {
        String str4;
        if (a.L()) {
            str4 = b.a().b();
        } else {
            str4 = com.bonree.sdk.z.b.a().b();
        }
        d.a().b(str4, str, i, str2, str3, i2);
    }

    public static void onClickEventEnter(View view, Object obj) {
        d.a().a((Object) view, obj);
    }

    public static void onClickEventEnd() {
        d.a().b();
    }

    public static void onItemClickEnter(View view, int i, Object obj) {
        d.a().b((Object) view, obj);
    }

    public static void onItemClickEnd() {
        d.a().c();
    }

    public static void onItemSelectedEnter(View view, int i, Object obj) {
        d.a().a(view, i, obj);
    }

    public static void onItemSelectedEnd() {
        d.a().d();
    }

    public static void onPageSelectedEnter(int i, Object obj) {
        d.a().b(i, obj);
    }

    public static void onPageSelectedEnd() {
        d.a().e();
    }

    public static void onPageScrollStateChanged(int i, Object obj) {
        d.a();
        d.a(i, obj);
    }

    public static void onMenuItemClickEnter(Object obj, Object obj2) {
        d.a().c(obj, obj2);
    }

    public static void onMenuItemClickEnd() {
        d.a().f();
    }

    public static void onOptionsItemSelectedEnter(Object obj, Object obj2) {
        d.a().d(obj, obj2);
    }

    public static void onOptionsItemSelectedEnd() {
        d.a().g();
    }

    public static void onCustomMethodStart(String str, String str2) {
        d.a().a(str, str2);
    }

    public static void onCustomMethodEnd(String str, String str2) {
        d.a().b(str, str2);
    }

    public static void onClickEventEnterOhos(Component component, Object obj) {
        d.a().a((Object) component, obj);
    }

    public static void onClickEventEndOhos() {
        d.a().b();
    }

    public static void onItemClickedEnterOhos(ListContainer listContainer, Component component, int i, long j, Object obj) {
        d.a().b((Object) component, obj);
    }

    public static void onItemClickedEndOhos() {
        d.a().c();
    }

    public static void onPageChosenEnter(int i, Object obj) {
        d.a().b(i, obj);
    }

    public static void onPageChosenEnd() {
        d.a().e();
    }
}
