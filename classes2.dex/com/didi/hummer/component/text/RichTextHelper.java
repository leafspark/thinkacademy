package com.didi.hummer.component.text;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.YogaAttrUtils;
import com.didi.hummer.render.utility.YogaDrawableUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RichTextHelper {
    private static final String IMAGE_ALIGN_BASELINE = "baseline";
    private static final String IMAGE_ALIGN_BOTTOM = "bottom";
    private static final String IMAGE_ALIGN_CENTER = "center";
    private static final String IMAGE_ALIGN_TOP = "top";
    private static final String RT_BACKGROUND_COLOR = "backgroundColor";
    private static final String RT_COLOR = "color";
    private static final String RT_FONT_FAMILY = "fontFamily";
    private static final String RT_FONT_SIZE = "fontSize";
    private static final String RT_FONT_STYLE = "fontStyle";
    private static final String RT_FONT_WEIGHT = "fontWeight";
    private static final String RT_HREF = "href";
    private static final String RT_HREF_COLOR = "hrefColor";
    private static final String RT_IMAGE = "image";
    private static final String RT_IMAGE_ALIGN = "imageAlign";
    private static final String RT_IMAGE_HEIGHT = "imageHeight";
    private static final String RT_IMAGE_WIDTH = "imageWidth";
    private static final String RT_TEXT = "text";
    private static final String RT_TEXT_DECORATION = "textDecoration";

    public static class RichText {
        public int backgroundColor = 0;
        public int color = 0;
        public String fontFamily;
        public int fontSize;
        public String fontStyle;
        public String fontWeight;
        public String href;
        public int hrefColor = 0;
        public String image;
        public String imageAlign;
        public int imageHeight;
        public int imageWidth;
        public String text = "";
        public String textDecoration;

        public RichText() {
        }

        public RichText(String str) {
            this.text = str;
        }
    }

    public static void generateRichText(HMBase hMBase, Object obj, OnRichTextGenerateListener onRichTextGenerateListener) {
        if (obj instanceof Map) {
            generateRichText(hMBase, parseObjectRichText((Map) obj), onRichTextGenerateListener);
        } else if (obj instanceof List) {
            generateRichText(hMBase, parseArrayRichText((List) obj), onRichTextGenerateListener);
        }
    }

    private static RichText parseObjectRichText(Map map) {
        Object obj = map.get(RT_TEXT);
        Object obj2 = map.get("color");
        Object obj3 = map.get("backgroundColor");
        Object obj4 = map.get("fontFamily");
        Object obj5 = map.get("fontSize");
        Object obj6 = map.get("fontWeight");
        Object obj7 = map.get("fontStyle");
        Object obj8 = map.get("textDecoration");
        Object obj9 = map.get("image");
        Object obj10 = map.get(RT_IMAGE_WIDTH);
        Object obj11 = map.get(RT_IMAGE_HEIGHT);
        Object obj12 = map.get(RT_IMAGE_ALIGN);
        Object obj13 = map.get(RT_HREF);
        Object obj14 = map.get(RT_HREF_COLOR);
        RichText richText = new RichText();
        if (obj instanceof String) {
            richText.text = (String) obj;
        }
        if (obj2 instanceof String) {
            richText.color = YogaAttrUtils.parseColor((String) obj2);
        }
        if (obj3 instanceof String) {
            richText.backgroundColor = YogaAttrUtils.parseColor((String) obj3);
        }
        if (obj4 instanceof String) {
            richText.fontFamily = (String) obj4;
        }
        if (obj6 instanceof String) {
            richText.fontWeight = (String) obj6;
        }
        if (obj7 instanceof String) {
            richText.fontStyle = (String) obj7;
        }
        if (obj8 instanceof String) {
            richText.textDecoration = (String) obj8;
        }
        richText.fontSize = (int) HummerStyleUtils.convertNumber(obj5);
        if (obj9 instanceof String) {
            richText.image = (String) obj9;
        }
        richText.imageWidth = (int) HummerStyleUtils.convertNumber(obj10);
        richText.imageHeight = (int) HummerStyleUtils.convertNumber(obj11);
        if (obj12 instanceof String) {
            richText.imageAlign = (String) obj12;
        }
        if (obj13 instanceof String) {
            richText.href = (String) obj13;
        }
        if (obj14 instanceof String) {
            richText.hrefColor = YogaAttrUtils.parseColor((String) obj14);
        }
        return richText;
    }

    private static List<RichText> parseArrayRichText(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof String) {
                arrayList.add(new RichText((String) next));
            } else if (next instanceof Map) {
                arrayList.add(parseObjectRichText((Map) next));
            }
        }
        return arrayList;
    }

    private static void generateRichText(HMBase hMBase, RichText richText, OnRichTextGenerateListener onRichTextGenerateListener) {
        if (richText != null) {
            if (!TextUtils.isEmpty(richText.image) && TextUtils.isEmpty(richText.text)) {
                richText.text = " ";
            }
            SpannableString spannableString = new SpannableString(richText.text);
            processHrefSpannableString(hMBase, spannableString, richText, 0, spannableString.length());
            if (!TextUtils.isEmpty(richText.image)) {
                processImageSpannableString(hMBase, spannableString, richText, 0, spannableString.length(), onRichTextGenerateListener);
                return;
            }
            processTextStyleSpannableString(hMBase, spannableString, richText, 0, spannableString.length());
            if (onRichTextGenerateListener != null) {
                onRichTextGenerateListener.onGenerated(spannableString);
            }
        } else if (onRichTextGenerateListener != null) {
            onRichTextGenerateListener.onGenerated("");
        }
    }

    private static void generateRichText(HMBase hMBase, List<RichText> list, OnRichTextGenerateListener onRichTextGenerateListener) {
        if (list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (RichText next : list) {
                if (!TextUtils.isEmpty(next.image) && TextUtils.isEmpty(next.text)) {
                    next.text = " ";
                }
                sb.append(next.text);
            }
            int i = 0;
            SpannableString spannableString = new SpannableString(sb);
            Iterator<RichText> it = list.iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                RichText next2 = it.next();
                i = i2 + next2.text.length();
                processHrefSpannableString(hMBase, spannableString, next2, i2, i);
                if (!TextUtils.isEmpty(next2.image)) {
                    processImageSpannableString(hMBase, spannableString, next2, i2, i, onRichTextGenerateListener);
                } else {
                    processTextStyleSpannableString(hMBase, spannableString, next2, i2, i);
                }
            }
            if (onRichTextGenerateListener != null) {
                onRichTextGenerateListener.onGenerated(spannableString);
            }
        } else if (onRichTextGenerateListener != null) {
            onRichTextGenerateListener.onGenerated("");
        }
    }

    private static void processTextStyleSpannableString(HMBase hMBase, SpannableString spannableString, RichText richText, int i, int i2) {
        if (richText.color != 0) {
            spannableString.setSpan(new ForegroundColorSpan(richText.color), i, i2, 17);
        }
        if (richText.backgroundColor != 0) {
            spannableString.setSpan(new BackgroundColorSpan(richText.backgroundColor), i, i2, 17);
        }
        boolean z = false;
        if (!TextUtils.isEmpty(richText.fontFamily)) {
            spannableString.setSpan(new TypefaceSpanEx(FontManager.getInstance().getTypeface((HummerContext) hMBase.getContext(), richText.fontFamily, (!(hMBase.getView() instanceof TextView) || ((TextView) hMBase.getView()).getTypeface() == null) ? 0 : ((TextView) hMBase.getView()).getTypeface().getStyle())), i, i2, 17);
        }
        if (richText.fontSize > 0) {
            spannableString.setSpan(new AbsoluteSizeSpan(richText.fontSize, false), i, i2, 17);
        }
        boolean z2 = !TextUtils.isEmpty(richText.fontWeight) && richText.fontWeight.toLowerCase().equals("bold");
        if (!TextUtils.isEmpty(richText.fontStyle) && richText.fontStyle.toLowerCase().equals("italic")) {
            z = true;
        }
        if (z2 && z) {
            spannableString.setSpan(new StyleSpan(3), i, i2, 17);
        } else if (z2) {
            spannableString.setSpan(new StyleSpan(1), i, i2, 17);
        } else if (z) {
            spannableString.setSpan(new StyleSpan(2), i, i2, 17);
        }
        if (TextUtils.isEmpty(richText.textDecoration)) {
            return;
        }
        if (richText.textDecoration.equals("underline")) {
            spannableString.setSpan(new UnderlineSpan(), i, i2, 17);
        } else if (richText.textDecoration.equals("line-through")) {
            spannableString.setSpan(new StrikethroughSpan(), i, i2, 17);
        }
    }

    private static void processImageSpannableString(HMBase hMBase, SpannableString spannableString, RichText richText, int i, int i2, OnRichTextGenerateListener onRichTextGenerateListener) {
        if (!TextUtils.isEmpty(richText.image)) {
            YogaDrawableUtil.loadDrawable((HummerContext) hMBase.getContext(), richText.image, new RichTextHelper$$ExternalSyntheticLambda0(spannableString, richText, i, i2, onRichTextGenerateListener));
        }
    }

    static /* synthetic */ void lambda$processImageSpannableString$0(SpannableString spannableString, RichText richText, int i, int i2, OnRichTextGenerateListener onRichTextGenerateListener, Drawable drawable) {
        processDrawableSpannableString(spannableString, richText, drawable, i, i2);
        if (onRichTextGenerateListener != null) {
            onRichTextGenerateListener.onGenerated(spannableString);
        }
    }

    private static void processDrawableSpannableString(SpannableString spannableString, RichText richText, Drawable drawable, int i, int i2) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (richText.imageWidth > 0) {
                intrinsicWidth = richText.imageWidth;
            }
            if (richText.imageHeight > 0) {
                intrinsicHeight = richText.imageHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            spannableString.setSpan(new ImageSpanEx(drawable, getImageAlign(richText.imageAlign)), i, i2, 17);
        }
    }

    private static void processHrefSpannableString(HMBase hMBase, SpannableString spannableString, RichText richText, int i, int i2) {
        if (!TextUtils.isEmpty(richText.href)) {
            spannableString.setSpan(new URLSpanEx(richText.href, richText.hrefColor), i, i2, 17);
            if (hMBase.getView() instanceof TextView) {
                ((TextView) hMBase.getView()).setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    private static int getImageAlign(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1720785339:
                if (str.equals(IMAGE_ALIGN_BASELINE)) {
                    c = 0;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals(IMAGE_ALIGN_BOTTOM)) {
                    c = 4;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 3;
                    break;
                }
                break;
            case 115029:
                if (str.equals(IMAGE_ALIGN_TOP)) {
                    c = 2;
                    break;
                }
                break;
        }
        if (c == 2) {
            return 2;
        }
        if (c == 3) {
            return 3;
        }
        if (c != 4) {
            return 1;
        }
        return 0;
    }
}
