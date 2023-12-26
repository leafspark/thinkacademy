package com.didi.hummer.component.input;

import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.hummer.component.text.FontManager;
import com.didi.hummer.context.HummerContext;
import java.lang.reflect.Field;
import java.util.LinkedList;

public class HMInputProperty {
    private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
    private int defaultInputType;
    private boolean isSingleLine;
    private final EditText mView;

    public HMInputProperty(EditText editText, boolean z) {
        this.isSingleLine = z;
        this.mView = editText;
        editText.setPadding(0, 0, 0, 0);
        editText.setSingleLine(z);
        editText.setTextSize(16.0f);
        if (!this.isSingleLine) {
            editText.setGravity(8388611);
        }
        int inputType = editText.getInputType();
        this.defaultInputType = inputType;
        if (inputType == 0) {
            this.defaultInputType = 1;
        }
    }

    public void setText(String str) {
        this.mView.setText(str);
        if (this.mView.getText().length() > 0) {
            EditText editText = this.mView;
            editText.setSelection(editText.getText().length());
        }
    }

    public String getText() {
        return this.mView.getText().toString();
    }

    public void setPlaceholder(String str) {
        this.mView.setHint(str);
    }

    public void setType(String str) {
        this.mView.setInputType(getInputType(str));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getInputType(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 3
            r3 = 2
            switch(r0) {
                case -1034364087: goto L_0x0033;
                case 114715: goto L_0x0029;
                case 96619420: goto L_0x001f;
                case 1216985755: goto L_0x0015;
                case 1544803905: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x003d
        L_0x000b:
            java.lang.String r0 = "default"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003d
            r5 = 4
            goto L_0x003e
        L_0x0015:
            java.lang.String r0 = "password"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003d
            r5 = r2
            goto L_0x003e
        L_0x001f:
            java.lang.String r0 = "email"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003d
            r5 = 0
            goto L_0x003e
        L_0x0029:
            java.lang.String r0 = "tel"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003d
            r5 = r3
            goto L_0x003e
        L_0x0033:
            java.lang.String r0 = "number"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x003d
            r5 = r1
            goto L_0x003e
        L_0x003d:
            r5 = -1
        L_0x003e:
            if (r5 == 0) goto L_0x0056
            if (r5 == r1) goto L_0x0052
            if (r5 == r3) goto L_0x004e
            if (r5 == r2) goto L_0x0049
            int r5 = r4.defaultInputType
            goto L_0x005a
        L_0x0049:
            int r5 = r4.defaultInputType
            r5 = r5 | 128(0x80, float:1.794E-43)
            goto L_0x005a
        L_0x004e:
            int r5 = r4.defaultInputType
            r5 = r5 | r2
            goto L_0x005a
        L_0x0052:
            int r5 = r4.defaultInputType
            r5 = r5 | r3
            goto L_0x005a
        L_0x0056:
            int r5 = r4.defaultInputType
            r5 = r5 | 32
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.input.HMInputProperty.getInputType(java.lang.String):int");
    }

    public void setTextColor(int i) {
        this.mView.setTextColor(i);
    }

    public void setPlaceholderColor(int i) {
        this.mView.setHintTextColor(i);
    }

    public void setCursorColor(int i) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mView.getTextCursorDrawable().mutate().setColorFilter(new BlendModeColorFilter(i, BlendMode.SRC_ATOP));
                return;
            }
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(this.mView);
            if (i2 != 0) {
                Drawable drawable = ContextCompat.getDrawable(this.mView.getContext(), i2);
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(this.mView);
                Class<?> cls = obj.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    Field declaredField3 = cls.getDeclaredField("mDrawableForCursor");
                    declaredField3.setAccessible(true);
                    declaredField3.set(obj, drawable);
                    return;
                }
                Field declaredField4 = cls.getDeclaredField("mCursorDrawable");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, new Drawable[]{drawable, drawable});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetCursorColor() {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                this.mView.getTextCursorDrawable().mutate().setColorFilter((ColorFilter) null);
                return;
            }
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(this.mView);
            if (i != 0) {
                Drawable drawable = ContextCompat.getDrawable(this.mView.getContext(), i);
                Field declaredField2 = TextView.class.getDeclaredField("mEditor");
                declaredField2.setAccessible(true);
                Object obj = declaredField2.get(this.mView);
                Class<?> cls = obj.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    Field declaredField3 = cls.getDeclaredField("mDrawableForCursor");
                    declaredField3.setAccessible(true);
                    declaredField3.set(obj, drawable);
                    return;
                }
                Field declaredField4 = cls.getDeclaredField("mCursorDrawable");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, new Drawable[]{drawable, drawable});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTextAlign(String str) {
        this.mView.setGravity(getGravity(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getGravity(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r2 = 3
            r3 = 2
            if (r0 == r1) goto L_0x002a
            r1 = 3317767(0x32a007, float:4.649182E-39)
            if (r0 == r1) goto L_0x0020
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = 0
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0034
            r5 = r2
            goto L_0x0035
        L_0x0034:
            r5 = -1
        L_0x0035:
            if (r5 == r3) goto L_0x004e
            if (r5 == r2) goto L_0x0045
            boolean r5 = r4.isSingleLine
            if (r5 == 0) goto L_0x0041
            r5 = 8388627(0x800013, float:1.175497E-38)
            goto L_0x0044
        L_0x0041:
            r5 = 8388611(0x800003, float:1.1754948E-38)
        L_0x0044:
            return r5
        L_0x0045:
            boolean r5 = r4.isSingleLine
            if (r5 == 0) goto L_0x004c
            r5 = 17
            goto L_0x004d
        L_0x004c:
            r5 = 1
        L_0x004d:
            return r5
        L_0x004e:
            boolean r5 = r4.isSingleLine
            if (r5 == 0) goto L_0x0056
            r5 = 8388629(0x800015, float:1.1754973E-38)
            goto L_0x0059
        L_0x0056:
            r5 = 8388613(0x800005, float:1.175495E-38)
        L_0x0059:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.input.HMInputProperty.getGravity(java.lang.String):int");
    }

    public void setFontFamily(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length != 0) {
                int style = this.mView.getTypeface() != null ? this.mView.getTypeface().getStyle() : 0;
                for (String trim : split) {
                    Typeface typeface = FontManager.getInstance().getTypeface((HummerContext) context, trim.trim(), style);
                    if (typeface != null) {
                        this.mView.setTypeface(typeface);
                        return;
                    }
                }
            }
        }
    }

    public void setFontSize(float f) {
        this.mView.setTextSize(0, f);
    }

    public void setPlaceholderFontSize(float f) {
        this.mView.setTextSize(0, f);
    }

    public void setMaxLength(int i) {
        InputFilter[] filters = this.mView.getFilters();
        InputFilter[] inputFilterArr = EMPTY_FILTERS;
        if (i == 0) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < filters.length; i2++) {
                    if (!(filters[i2] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i2]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i3 = 0; i3 < filters.length; i3++) {
                if (filters[i3] instanceof InputFilter.LengthFilter) {
                    filters[i3] = new InputFilter.LengthFilter(i);
                    z = true;
                }
            }
            if (!z) {
                InputFilter[] inputFilterArr2 = new InputFilter[(filters.length + 1)];
                System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(i);
                filters = inputFilterArr2;
            }
            inputFilterArr = filters;
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(i)};
        }
        this.mView.setFilters(inputFilterArr);
    }

    public void setReturnKeyType(String str) {
        this.mView.setImeOptions(getImeOption(str));
        InputMethodManager inputMethodManager = (InputMethodManager) this.mView.getContext().getSystemService("input_method");
        if (inputMethodManager != null && inputMethodManager.isActive()) {
            inputMethodManager.restartInput(this.mView);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getImeOption(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 1
            r3 = 3
            r4 = 2
            switch(r0) {
                case -906336856: goto L_0x0034;
                case 3304: goto L_0x002a;
                case 3089282: goto L_0x0020;
                case 3377907: goto L_0x0016;
                case 3526536: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "send"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r4
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "next"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r3
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "done"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r1
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "go"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "search"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x003e
            r6 = r2
            goto L_0x003f
        L_0x003e:
            r6 = -1
        L_0x003f:
            if (r6 == 0) goto L_0x004d
            if (r6 == r2) goto L_0x004c
            if (r6 == r4) goto L_0x004b
            if (r6 == r3) goto L_0x0049
            r6 = 6
            return r6
        L_0x0049:
            r6 = 5
            return r6
        L_0x004b:
            return r1
        L_0x004c:
            return r3
        L_0x004d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.input.HMInputProperty.getImeOption(java.lang.String):int");
    }

    public void setFocused(boolean z) {
        if (z) {
            FocusUtil.requestFocus(this.mView);
        } else {
            FocusUtil.clearFocus((View) this.mView);
        }
    }
}
