package com.didi.hummer.component.button;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.input.NJTextAlign;
import com.didi.hummer.component.text.FontManager;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerStyleUtils;
import java.util.HashMap;
import java.util.Map;

@Component("Button")
public class Button extends HMBase<android.widget.Button> {
    private Map<Integer, Drawable> bgDrawableMap = new HashMap();
    @JsProperty("disabled")
    private Map<String, Object> disabled;
    private Drawable orgBackground;
    private ColorStateList orgTextColors;
    private float orgTextSize;
    private Typeface orgTypeface;
    @JsProperty("pressed")
    private Map<String, Object> pressed;
    @JsProperty("text")
    private String text;
    private Map<Integer, Integer> textColorMap = new HashMap();

    public Button(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    /* access modifiers changed from: protected */
    public android.widget.Button createViewInstance(Context context) {
        return new android.widget.Button(context);
    }

    public void onCreate() {
        super.onCreate();
        this.orgBackground = ((android.widget.Button) getView()).getBackground();
        this.orgTextColors = ((android.widget.Button) getView()).getTextColors();
        this.orgTextSize = ((android.widget.Button) getView()).getTextSize();
        ((android.widget.Button) getView()).setBackground((Drawable) null);
        ((android.widget.Button) getView()).setAllCaps(false);
        ((android.widget.Button) getView()).setTypeface((Typeface) null, 0);
        setFontFamily(FontManager.DEFAULT_FONT_FAMILY);
        this.orgTypeface = ((android.widget.Button) getView()).getTypeface();
        if (Build.VERSION.SDK_INT >= 21) {
            ((android.widget.Button) getView()).setStateListAnimator((StateListAnimator) null);
        }
    }

    private void requestLayout() {
        getYogaNode().dirty();
        ((android.widget.Button) getView()).requestLayout();
    }

    public void setBackgroundColor(Object obj) {
        super.setBackgroundColor(obj);
        ((android.widget.Button) getView()).setMinWidth(0);
        ((android.widget.Button) getView()).setMinHeight(0);
        ((android.widget.Button) getView()).setMinimumHeight(0);
        ((android.widget.Button) getView()).setMinimumWidth(0);
        ((android.widget.Button) getView()).setPadding(0, 0, 0, 0);
    }

    public void setBackgroundImage(String str) {
        super.setBackgroundImage(str);
        ((android.widget.Button) getView()).setMinWidth(0);
        ((android.widget.Button) getView()).setMinHeight(0);
        ((android.widget.Button) getView()).setMinimumHeight(0);
        ((android.widget.Button) getView()).setMinimumWidth(0);
        ((android.widget.Button) getView()).setPadding(0, 0, 0, 0);
    }

    public void setText(String str) {
        ((android.widget.Button) getView()).setText(str);
        requestLayout();
        getNode().setContent(str);
    }

    public void setPressed(Map<String, Object> map) {
        this.pressed = map;
        mergePressedStyle();
        updateBackground();
    }

    public void setDisabled(Map<String, Object> map) {
        this.disabled = map;
        mergeDisabledStyle();
        updateBackground();
    }

    private void mergePressedStyle() {
        ButtonStyleHelper.fillButtonPressedAndDisabledStyle(this.style, this.pressed);
        Drawable pickButtonBackgroundDrawable = ButtonStyleHelper.pickButtonBackgroundDrawable(this.pressed);
        if (pickButtonBackgroundDrawable != null) {
            this.bgDrawableMap.put(1, pickButtonBackgroundDrawable);
        }
        Integer pickButtonTextColor = ButtonStyleHelper.pickButtonTextColor(this.pressed);
        if (pickButtonTextColor != null) {
            this.textColorMap.put(1, pickButtonTextColor);
        }
    }

    private void mergeDisabledStyle() {
        ButtonStyleHelper.fillButtonPressedAndDisabledStyle(this.style, this.disabled);
        Drawable pickButtonBackgroundDrawable = ButtonStyleHelper.pickButtonBackgroundDrawable(this.disabled);
        if (pickButtonBackgroundDrawable != null) {
            this.bgDrawableMap.put(2, pickButtonBackgroundDrawable);
        }
        Integer pickButtonTextColor = ButtonStyleHelper.pickButtonTextColor(this.disabled);
        if (pickButtonTextColor != null) {
            this.textColorMap.put(2, pickButtonTextColor);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    @com.didi.hummer.annotation.JsAttribute({"textAlign"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setTextAlign(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r5 = r5.toLowerCase()
            int r0 = r5.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r2 = 3
            r3 = 2
            if (r0 == r1) goto L_0x002e
            r1 = 3317767(0x32a007, float:4.649182E-39)
            if (r0 == r1) goto L_0x0024
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0038
            r5 = r2
            goto L_0x0039
        L_0x0024:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0038
            r5 = r3
            goto L_0x0039
        L_0x002e:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0038
            r5 = 0
            goto L_0x0039
        L_0x0038:
            r5 = -1
        L_0x0039:
            if (r5 == r3) goto L_0x0056
            if (r5 == r2) goto L_0x0049
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 17
            r5.setGravity(r0)
            goto L_0x0062
        L_0x0049:
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 8388629(0x800015, float:1.1754973E-38)
            r5.setGravity(r0)
            goto L_0x0062
        L_0x0056:
            android.view.View r5 = r4.getView()
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 8388627(0x800013, float:1.175497E-38)
            r5.setGravity(r0)
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.button.Button.setTextAlign(java.lang.String):void");
    }

    @JsAttribute({"fontFamily"})
    public void setFontFamily(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length != 0) {
                int style = ((android.widget.Button) getView()).getTypeface() != null ? ((android.widget.Button) getView()).getTypeface().getStyle() : 0;
                for (String trim : split) {
                    Typeface typeface = FontManager.getInstance().getTypeface((HummerContext) getContext(), trim.trim(), style);
                    if (typeface != null) {
                        ((android.widget.Button) getView()).setTypeface(typeface);
                        requestLayout();
                        return;
                    }
                }
            }
        }
    }

    @JsAttribute({"fontSize"})
    public void setFontSize(float f) {
        ((android.widget.Button) getView()).setTextSize(0, f);
        requestLayout();
    }

    @JsAttribute({"color"})
    public void setColor(int i) {
        ((android.widget.Button) getView()).setTextColor(i);
    }

    public void onStyleUpdated(Map<String, Object> map) {
        if (map.containsKey("backgroundColor")) {
            this.bgDrawableMap.put(0, this.backgroundHelper.getBackgroundDrawable());
        }
        if (map.containsKey("color")) {
            this.textColorMap.put(0, ButtonStyleHelper.pickButtonTextColor(map));
        }
        mergePressedStyle();
        mergeDisabledStyle();
        updateBackground();
    }

    private void updateBackground() {
        updateBackgroundDrawable();
        updateTextColor();
    }

    private void updateBackgroundDrawable() {
        if (this.bgDrawableMap.containsKey(1) || this.bgDrawableMap.containsKey(2)) {
            this.backgroundHelper.setBackgroundDrawable(ButtonStyleHelper.makeButtonBackgroundColorStateList(this.bgDrawableMap));
        }
    }

    private void updateTextColor() {
        Integer num;
        if (this.textColorMap.containsKey(1) || this.textColorMap.containsKey(2)) {
            if (!this.textColorMap.containsKey(0)) {
                this.textColorMap.put(0, -16777216);
            }
            ColorStateList makeButtonTextColorStateList = ButtonStyleHelper.makeButtonTextColorStateList(this.textColorMap);
            if (makeButtonTextColorStateList != null) {
                ((android.widget.Button) getView()).setTextColor(makeButtonTextColorStateList);
            }
        } else if (this.textColorMap.containsKey(0) && (num = this.textColorMap.get(0)) != null) {
            ((android.widget.Button) getView()).setTextColor(num.intValue());
        }
    }

    public void resetStyle() {
        super.resetStyle();
        ((android.widget.Button) getView()).setBackground(this.orgBackground);
        ((android.widget.Button) getView()).setTextColor(this.orgTextColors);
        ((android.widget.Button) getView()).setTextSize(0, this.orgTextSize);
        ((android.widget.Button) getView()).setTypeface(this.orgTypeface);
        setTextAlign(NJTextAlign.CENTER);
    }

    public boolean setStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1224696685:
                if (str.equals(HummerStyleUtils.Hummer.FONT_FAMILY)) {
                    c = 0;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals(HummerStyleUtils.Hummer.TEXT_ALIGN)) {
                    c = 1;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 2;
                    break;
                }
                break;
            case 365601008:
                if (str.equals(HummerStyleUtils.Hummer.FONT_SIZE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setFontFamily(String.valueOf(obj));
                break;
            case 1:
                setTextAlign(String.valueOf(obj));
                break;
            case 2:
                setColor(((Integer) obj).intValue());
                break;
            case 3:
                setFontSize(((Float) obj).floatValue());
                break;
            default:
                return false;
        }
        return true;
    }
}
