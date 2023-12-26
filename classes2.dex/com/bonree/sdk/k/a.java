package com.bonree.sdk.k;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bonree.sdk.bs.q;
import java.lang.reflect.Method;
import java.util.Stack;
import ohos.agp.components.Component;
import ohos.agp.components.ComponentContainer;
import ohos.agp.components.Text;

public class a {
    private static String a = "onClick";
    private static String b = "onItemClicked";
    private static String c = "onItemSelected";
    private static String d = "onMenuItemClick";
    private static String e = "onOptionsItemSelected";
    private static String f = "onPageSelected";
    private static String g = "onPageScroll";
    private Method h;
    private final Stack<Object> i = new Stack<>();
    private final Stack<Object> j = new Stack<>();

    /* access modifiers changed from: package-private */
    public final Object a() {
        if (this.i.isEmpty()) {
            return null;
        }
        return this.i.pop();
    }

    /* access modifiers changed from: package-private */
    public final a a(Object obj) {
        this.i.push(obj);
        return this;
    }

    /* access modifiers changed from: package-private */
    public final Object b() {
        if (this.j.isEmpty()) {
            return null;
        }
        return this.j.pop();
    }

    /* access modifiers changed from: package-private */
    public final a b(Object obj) {
        this.j.push(obj);
        return this;
    }

    protected static String c(Object obj) {
        if (obj == null) {
            return null;
        }
        String str = "";
        if (!com.bonree.sdk.d.a.L()) {
            try {
                if (obj instanceof View) {
                    View view = (View) obj;
                    str = "0x" + Integer.toHexString(view.getId());
                    Context a2 = com.bonree.sdk.bs.a.a();
                    if (a2 == null) {
                        return str;
                    }
                    if (!(view.getId() == -1 || a2.getResources() == null)) {
                        return a2.getResources().getResourceEntryName(view.getId());
                    }
                }
            } catch (Exception unused) {
            }
        } else if (obj instanceof Component) {
            Component component = (Component) obj;
            str = component.getName();
            if (TextUtils.isEmpty(str)) {
                str = "0x" + Integer.toHexString(component.getId());
            }
            if (q.a() == null) {
            }
        }
        return str;
    }

    protected static String d(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof View) {
                View view = (View) obj;
                Context a2 = com.bonree.sdk.bs.a.a();
                if (!(a2 == null || view.getId() == -1 || a2.getResources() == null)) {
                    return a2.getResources().getResourceEntryName(view.getId());
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String a(View view) {
        if (view == null) {
            return null;
        }
        return Integer.toHexString(view.getId());
    }

    private String f(Object obj) {
        if (obj != null) {
            if (!com.bonree.sdk.d.a.L()) {
                if (obj instanceof View) {
                    String a2 = a(((View) obj).getContentDescription());
                    if (a2 != null || !(obj instanceof TextView)) {
                        return a2;
                    }
                    return a(((TextView) obj).getText());
                }
            } else if (obj instanceof Component) {
                String a3 = a(((Component) obj).getComponentDescription());
                return (a3 != null || !(obj instanceof Text)) ? a3 : a((CharSequence) ((Text) obj).getText());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String e(Object obj) {
        if (obj == null) {
            return null;
        }
        String g2 = g(obj);
        if (g2 == null) {
            int i2 = 0;
            if (!com.bonree.sdk.d.a.L()) {
                if (obj == null || !(obj instanceof ViewGroup)) {
                    return null;
                }
                ViewGroup viewGroup = (ViewGroup) obj;
                while (i2 < viewGroup.getChildCount()) {
                    g2 = g(viewGroup.getChildAt(i2));
                    if (g2 == null) {
                        i2++;
                    }
                }
                return null;
            } else if (obj == null || !(obj instanceof ComponentContainer)) {
                return null;
            } else {
                ComponentContainer componentContainer = (ComponentContainer) obj;
                while (i2 < componentContainer.getChildCount()) {
                    g2 = g(componentContainer.getComponentAt(i2));
                    if (g2 == null) {
                        i2++;
                    }
                }
                return null;
            }
        }
        return g2;
    }

    private String g(Object obj) {
        if (obj != null) {
            if (!com.bonree.sdk.d.a.L()) {
                if (obj instanceof TextView) {
                    return a(((TextView) obj).getText());
                }
            } else if (obj instanceof Text) {
                return a((CharSequence) ((Text) obj).getText());
            }
        }
        return null;
    }

    private String h(Object obj) {
        int i2 = 0;
        if (!com.bonree.sdk.d.a.L()) {
            if (obj == null || !(obj instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            while (i2 < viewGroup.getChildCount()) {
                String g2 = g(viewGroup.getChildAt(i2));
                if (g2 != null) {
                    return g2;
                }
                i2++;
            }
            return null;
        } else if (obj == null || !(obj instanceof ComponentContainer)) {
            return null;
        } else {
            ComponentContainer componentContainer = (ComponentContainer) obj;
            while (i2 < componentContainer.getChildCount()) {
                String g3 = g(componentContainer.getComponentAt(i2));
                if (g3 != null) {
                    return g3;
                }
                i2++;
            }
            return null;
        }
    }

    private String i(Object obj) {
        int i2 = 0;
        if (!com.bonree.sdk.d.a.L()) {
            if (obj == null || !(obj instanceof ViewGroup)) {
                return null;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            while (i2 < viewGroup.getChildCount()) {
                String f2 = f(viewGroup.getChildAt(i2));
                if (f2 != null) {
                    return f2;
                }
                i2++;
            }
            return null;
        } else if (obj == null || !(obj instanceof ComponentContainer)) {
            return null;
        } else {
            ComponentContainer componentContainer = (ComponentContainer) obj;
            while (i2 < componentContainer.getChildCount()) {
                String f3 = f(componentContainer.getComponentAt(i2));
                if (f3 != null) {
                    return f3;
                }
                i2++;
            }
            return null;
        }
    }

    private static String a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return null;
        }
        String charSequence2 = charSequence.toString();
        return charSequence2.length() > 50 ? charSequence2.substring(0, 50) : charSequence2;
    }

    /* access modifiers changed from: protected */
    public final String a(Object obj, String str) {
        String str2;
        if (obj != null) {
            String f2 = f(obj);
            if (f2 == null) {
                int i2 = 0;
                if (!com.bonree.sdk.d.a.L()) {
                    if (obj != null && (obj instanceof ViewGroup)) {
                        ViewGroup viewGroup = (ViewGroup) obj;
                        while (true) {
                            if (i2 >= viewGroup.getChildCount()) {
                                break;
                            }
                            str2 = f(viewGroup.getChildAt(i2));
                            if (str2 != null) {
                                break;
                            }
                            i2++;
                        }
                    }
                    f2 = null;
                } else {
                    if (obj != null && (obj instanceof ComponentContainer)) {
                        ComponentContainer componentContainer = (ComponentContainer) obj;
                        while (true) {
                            if (i2 >= componentContainer.getChildCount()) {
                                break;
                            }
                            str2 = f(componentContainer.getComponentAt(i2));
                            if (str2 != null) {
                                break;
                            }
                            i2++;
                        }
                    }
                    f2 = null;
                }
                f2 = str2;
            }
            if (f2 == null) {
                String j2 = j(obj);
                if (j2 == null) {
                    return "Touch on " + obj.getClass().getSimpleName();
                }
                f2 = "resource Id is " + j2;
            }
            return f2;
        }
        return "Initiate " + str;
    }

    private static String j(Object obj) {
        CharSequence charSequence;
        Resources resources;
        String str;
        if (obj != null) {
            if (!com.bonree.sdk.d.a.L()) {
                try {
                    View view = (View) obj;
                    Context a2 = com.bonree.sdk.bs.a.a();
                    if (a2 != null) {
                        resources = a2.getResources();
                        try {
                            str = resources.getResourceEntryName(view.getId());
                        } catch (Throwable unused) {
                            charSequence = resources;
                            return "0x" + charSequence;
                        }
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        return str;
                    }
                    charSequence = Integer.toHexString(view.getId());
                } catch (Throwable unused2) {
                    resources = null;
                    charSequence = resources;
                    return "0x" + charSequence;
                }
            } else {
                charSequence = obj instanceof Component ? Integer.toHexString(((Component) obj).getId()) : null;
            }
            if ((charSequence instanceof CharSequence) && TextUtils.isEmpty(charSequence)) {
                return "0x" + charSequence;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final View a(Object obj, Context context) {
        String str;
        CharSequence charSequence;
        if (obj == null || context == null) {
            return null;
        }
        if (obj instanceof MenuItem) {
            str = obj.toString();
        } else {
            try {
                if (this.h == null) {
                    this.h = obj.getClass().getMethod("getTitle", new Class[0]);
                }
                Method method = this.h;
                if (!(method == null || (charSequence = (CharSequence) method.invoke(obj, new Object[0])) == null)) {
                    str = charSequence.toString();
                }
            } catch (Throwable unused) {
            }
            str = null;
        }
        if (str == null) {
            return null;
        }
        View view = new View(context);
        view.setContentDescription(str);
        return view;
    }

    private static String b(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getLocalClassName();
            }
        }
        return null;
    }
}
