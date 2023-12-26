package com.didi.hummer.component.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.input.NJTextAlign;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.render.component.view.HMBase;
import com.igexin.sdk.PushBuildConfig;

@Component("Text")
public class Text extends HMBase<TextView> {
    private String fontStyle;
    private String fontWeight;
    @Deprecated
    @JsProperty("formattedText")
    private String formattedText;
    private ColorStateList orgTextColors;
    private float orgTextSize;
    private Typeface orgTypeface;
    @JsProperty("richText")
    private Object richText;
    @JsProperty("text")
    private String text;
    @JsProperty("textCopyEnable")
    private boolean textCopyEnable;
    private int xGravity = 0;
    private int yGravity = 0;

    public Text(HummerContext hummerContext, JSValue jSValue, String str) {
        super(hummerContext, jSValue, str);
    }

    /* access modifiers changed from: protected */
    public TextView createViewInstance(Context context) {
        return new TextView(context);
    }

    public void onCreate() {
        super.onCreate();
        this.orgTextColors = ((TextView) getView()).getTextColors();
        this.orgTextSize = ((TextView) getView()).getTextSize();
        setFontFamily(FontManager.DEFAULT_FONT_FAMILY);
        this.orgTypeface = ((TextView) getView()).getTypeface();
        ((TextView) getView()).setGravity(8388627);
        ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.END);
    }

    private void requestLayout() {
        getYogaNode().dirty();
        ((TextView) getView()).requestLayout();
    }

    /* access modifiers changed from: private */
    public void setRowText(CharSequence charSequence) {
        ((TextView) getView()).setText(charSequence);
        requestLayout();
    }

    private Spanned fromHtml(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Html.fromHtml(str, 0);
        }
        return Html.fromHtml(str);
    }

    public void setText(String str) {
        setRowText(str);
        getNode().setContent(str);
    }

    public void setRichText(Object obj) {
        if (obj instanceof String) {
            setText((String) obj);
            return;
        }
        RichTextHelper.generateRichText((HMBase) this, obj, (OnRichTextGenerateListener) new Text$$ExternalSyntheticLambda1(this));
        getNode().setContent(HMGsonUtil.toJson(obj));
    }

    public void setFormattedText(String str) {
        setRowText(fromHtml(str));
        getNode().setContent(str);
    }

    public void setTextCopyEnable(boolean z) {
        if (z) {
            ((TextView) getView()).setOnLongClickListener(new Text$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ boolean lambda$setTextCopyEnable$0$Text(View view) {
        ((ClipboardManager) getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copyText", ((TextView) getView()).getText()));
        Toast makeText = Toast.makeText(getContext(), (CharSequence) null, 0);
        makeText.setText("复制成功");
        makeText.setGravity(17, 0, 0);
        makeText.show();
        return false;
    }

    @JsAttribute({"color"})
    public void setColor(int i) {
        ((TextView) getView()).setTextColor(i);
    }

    @JsAttribute({"fontFamily"})
    public void setFontFamily(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            if (split.length != 0) {
                int style = ((TextView) getView()).getTypeface() != null ? ((TextView) getView()).getTypeface().getStyle() : 0;
                for (String trim : split) {
                    Typeface typeface = FontManager.getInstance().getTypeface((HummerContext) getContext(), trim.trim(), style);
                    if (typeface != null) {
                        ((TextView) getView()).setTypeface(typeface);
                        requestLayout();
                        return;
                    }
                }
            }
        }
    }

    @JsAttribute({"fontSize"})
    public void setFontSize(float f) {
        ((TextView) getView()).setTextSize(0, f);
        requestLayout();
    }

    @JsAttribute({"fontWeight"})
    public void setFontWeight(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            this.fontWeight = lowerCase;
            processTextTypeface(lowerCase, this.fontStyle);
            requestLayout();
        }
    }

    @JsAttribute({"fontStyle"})
    public void setFontStyle(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            this.fontStyle = lowerCase;
            processTextTypeface(this.fontWeight, lowerCase);
            requestLayout();
        }
    }

    private void processTextTypeface(String str, String str2) {
        if ("bold".equals(str) && "italic".equals(str2)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 3);
        } else if ("bold".equals(str)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 1);
        } else if ("italic".equals(str2)) {
            ((TextView) getView()).setTypeface(((TextView) getView()).getTypeface(), 2);
        } else {
            ((TextView) getView()).setTypeface((Typeface) null, 0);
        }
    }

    @JsAttribute({"textAlign"})
    public void setTextAlign(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 3317767) {
                    if (hashCode == 108511772 && lowerCase.equals(NJTextAlign.RIGHT)) {
                        c = 3;
                    }
                } else if (lowerCase.equals(NJTextAlign.LEFT)) {
                    c = 1;
                }
            } else if (lowerCase.equals(NJTextAlign.CENTER)) {
                c = 0;
            }
            if (c == 0) {
                ((TextView) getView()).setGravity(17);
                this.xGravity = 17;
            } else if (c != 3) {
                ((TextView) getView()).setGravity(8388627);
                this.xGravity = 8388627;
            } else {
                ((TextView) getView()).setGravity(8388629);
                this.xGravity = 8388629;
            }
            if (this.yGravity != 0) {
                ((TextView) getView()).setGravity(this.xGravity | this.yGravity);
            }
        }
    }

    @JsAttribute({"textVerticalAlign"})
    public void setTextVerticalAlign(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1383228885) {
                if (hashCode != -1364013995) {
                    if (hashCode == 115029 && lowerCase.equals("top")) {
                        c = 2;
                    }
                } else if (lowerCase.equals(NJTextAlign.CENTER)) {
                    c = 0;
                }
            } else if (lowerCase.equals("bottom")) {
                c = 3;
            }
            if (c == 2) {
                ((TextView) getView()).setGravity(48);
                this.yGravity = 48;
            } else if (c != 3) {
                ((TextView) getView()).setGravity(16);
                this.yGravity = 16;
            } else {
                ((TextView) getView()).setGravity(80);
                this.yGravity = 80;
            }
            if (this.xGravity != 0) {
                ((TextView) getView()).setGravity(this.xGravity | this.yGravity);
            }
        }
    }

    @JsAttribute({"textDecoration"})
    public void setTextDecoration(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            lowerCase.hashCode();
            if (lowerCase.equals("line-through")) {
                ((TextView) getView()).getPaint().setFlags(16);
            } else if (!lowerCase.equals("underline")) {
                ((TextView) getView()).getPaint().setFlags(0);
            } else {
                ((TextView) getView()).getPaint().setFlags(8);
            }
        }
    }

    @JsAttribute({"textOverflow"})
    public void setTextOverflow(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != 3056464) {
                if (hashCode == 188702929 && lowerCase.equals("ellipsis")) {
                    c = 1;
                }
            } else if (lowerCase.equals("clip")) {
                c = 0;
            }
            if (c != 0) {
                ((TextView) getView()).setEllipsize(TextUtils.TruncateAt.END);
            } else {
                ((TextView) getView()).setEllipsize((TextUtils.TruncateAt) null);
            }
        }
    }

    @JsAttribute({"textLineClamp"})
    public void setTextLineClamp(int i) {
        TextView textView = (TextView) getView();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        textView.setSingleLine(z);
        TextView textView2 = (TextView) getView();
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        textView2.setMaxLines(i);
        requestLayout();
    }

    @JsAttribute({"letterSpacing"})
    public void setLetterSpacing(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((TextView) getView()).setLetterSpacing(f);
            requestLayout();
        }
    }

    @JsAttribute({"lineSpacingMulti"})
    public void setLineSpacingMulti(float f) {
        ((TextView) getView()).setLineSpacing(0.0f, f);
        requestLayout();
    }

    public void resetStyle() {
        super.resetStyle();
        ((TextView) getView()).setTextColor(this.orgTextColors);
        ((TextView) getView()).setTextSize(0, this.orgTextSize);
        ((TextView) getView()).setTypeface(this.orgTypeface);
        setTextAlign(NJTextAlign.LEFT);
        setTextDecoration(PushBuildConfig.sdk_conf_debug_level);
        setTextOverflow("ellipsis");
        setTextLineClamp(Integer.MAX_VALUE);
        setLetterSpacing(0.0f);
        setLetterSpacing(1.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cf, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setStyle(java.lang.String r5, java.lang.Object r6) {
        /*
            r4 = this;
            r5.hashCode()
            int r0 = r5.hashCode()
            r1 = 1
            r2 = 0
            r3 = -1
            switch(r0) {
                case -1550943582: goto L_0x0094;
                case -1547288966: goto L_0x0089;
                case -1224696685: goto L_0x007e;
                case -1091049270: goto L_0x0073;
                case -1065511464: goto L_0x0068;
                case -879295043: goto L_0x005d;
                case -734428249: goto L_0x0052;
                case -292817662: goto L_0x0047;
                case 94842723: goto L_0x0039;
                case 261414991: goto L_0x002b;
                case 365601008: goto L_0x001d;
                case 2111078717: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x009e
        L_0x000f:
            java.lang.String r0 = "letterSpacing"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0019
            goto L_0x009e
        L_0x0019:
            r3 = 11
            goto L_0x009e
        L_0x001d:
            java.lang.String r0 = "fontSize"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0027
            goto L_0x009e
        L_0x0027:
            r3 = 10
            goto L_0x009e
        L_0x002b:
            java.lang.String r0 = "textOverflow"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0035
            goto L_0x009e
        L_0x0035:
            r3 = 9
            goto L_0x009e
        L_0x0039:
            java.lang.String r0 = "color"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0043
            goto L_0x009e
        L_0x0043:
            r3 = 8
            goto L_0x009e
        L_0x0047:
            java.lang.String r0 = "textVerticalAlign"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0050
            goto L_0x009e
        L_0x0050:
            r3 = 7
            goto L_0x009e
        L_0x0052:
            java.lang.String r0 = "fontWeight"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x005b
            goto L_0x009e
        L_0x005b:
            r3 = 6
            goto L_0x009e
        L_0x005d:
            java.lang.String r0 = "textDecoration"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0066
            goto L_0x009e
        L_0x0066:
            r3 = 5
            goto L_0x009e
        L_0x0068:
            java.lang.String r0 = "textAlign"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0071
            goto L_0x009e
        L_0x0071:
            r3 = 4
            goto L_0x009e
        L_0x0073:
            java.lang.String r0 = "lineSpacingMulti"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x007c
            goto L_0x009e
        L_0x007c:
            r3 = 3
            goto L_0x009e
        L_0x007e:
            java.lang.String r0 = "fontFamily"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0087
            goto L_0x009e
        L_0x0087:
            r3 = 2
            goto L_0x009e
        L_0x0089:
            java.lang.String r0 = "textLineClamp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x0092
            goto L_0x009e
        L_0x0092:
            r3 = r1
            goto L_0x009e
        L_0x0094:
            java.lang.String r0 = "fontStyle"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r3 = r2
        L_0x009e:
            switch(r3) {
                case 0: goto L_0x0105;
                case 1: goto L_0x00fa;
                case 2: goto L_0x00f2;
                case 3: goto L_0x00e8;
                case 4: goto L_0x00e0;
                case 5: goto L_0x00d8;
                case 6: goto L_0x00d0;
                case 7: goto L_0x00c8;
                case 8: goto L_0x00be;
                case 9: goto L_0x00b6;
                case 10: goto L_0x00ac;
                case 11: goto L_0x00a2;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            goto L_0x00cf
        L_0x00a2:
            java.lang.Float r6 = (java.lang.Float) r6
            float r5 = r6.floatValue()
            r4.setLetterSpacing(r5)
            goto L_0x010c
        L_0x00ac:
            java.lang.Float r6 = (java.lang.Float) r6
            float r5 = r6.floatValue()
            r4.setFontSize(r5)
            goto L_0x010c
        L_0x00b6:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setTextOverflow(r5)
            goto L_0x010c
        L_0x00be:
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r5 = r6.intValue()
            r4.setColor(r5)
            goto L_0x010c
        L_0x00c8:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setTextVerticalAlign(r5)
        L_0x00cf:
            return r2
        L_0x00d0:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setFontWeight(r5)
            goto L_0x010c
        L_0x00d8:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setTextDecoration(r5)
            goto L_0x010c
        L_0x00e0:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setTextAlign(r5)
            goto L_0x010c
        L_0x00e8:
            java.lang.Float r6 = (java.lang.Float) r6
            float r5 = r6.floatValue()
            r4.setLineSpacingMulti(r5)
            goto L_0x010c
        L_0x00f2:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setFontFamily(r5)
            goto L_0x010c
        L_0x00fa:
            java.lang.Float r6 = (java.lang.Float) r6
            float r5 = r6.floatValue()
            int r5 = (int) r5
            r4.setTextLineClamp(r5)
            goto L_0x010c
        L_0x0105:
            java.lang.String r5 = java.lang.String.valueOf(r6)
            r4.setFontStyle(r5)
        L_0x010c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.component.text.Text.setStyle(java.lang.String, java.lang.Object):boolean");
    }
}
