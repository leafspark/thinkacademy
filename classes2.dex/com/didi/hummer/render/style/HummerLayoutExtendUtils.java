package com.didi.hummer.render.style;

import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.component.view.HummerLayoutExtendView;
import com.didi.hummer.render.style.HummerStyleUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class HummerLayoutExtendUtils {
    private static final List<String> BLOCK_INTERCEPT_STYLES = Arrays.asList(new String[]{"flexDirection", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap"});
    private static final List<String> INLINE_BLOCK_INTERCEPT_STYLES = Arrays.asList(new String[]{"flexDirection", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap"});
    private static final List<String> INLINE_INTERCEPT_STYLES = Arrays.asList(new String[]{"border", "borderAll", "borderLeft", "borderRight", "borderTop", "borderBottom", "borderStart", "borderEnd", "borderHorizontal", "borderVertical", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "width", "height", "maxWidth", "maxHeight", "minWidth", "minHeight", "margin", "marginAll", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "marginHorizontal", "marginVertical", "padding", "paddingAll", "paddingBottom", "paddingEnd", "paddingLeft", "paddingRight", "paddingStart", "paddingTop", "paddingHorizontal", "paddingVertical"});
    public static Map<HMBase, Map<String, Object>> hmBaseCssStyleMap = new WeakHashMap();

    public static void markExtendCssView(HMBase hMBase) {
        if (!hmBaseCssStyleMap.containsKey(hMBase)) {
            hmBaseCssStyleMap.put(hMBase, new HashMap());
        }
    }

    public static boolean isExtendCssView(HMBase hMBase) {
        return hmBaseCssStyleMap.containsKey(hMBase);
    }

    public static Map<String, Object> getExtendCssViewStyle(HMBase hMBase) {
        return hmBaseCssStyleMap.get(hMBase);
    }

    public static void applyChildDisplayStyle(String str, HMBase hMBase) {
        if (isExtendCssView(hMBase)) {
            Map<String, Object> extendCssViewStyle = getExtendCssViewStyle(hMBase);
            if (Display.BLOCK.value().equals(str)) {
                if (hMBase.getDisplay() == Display.BLOCK) {
                    HashMap hashMap = new HashMap();
                    if (!extendCssViewStyle.containsKey("width") && !extendCssViewStyle.containsKey("maxWidth") && !extendCssViewStyle.containsKey("minWidth")) {
                        hashMap.put("width", "100%");
                    }
                    HummerStyleUtils.applyStyle(false, hMBase, hashMap);
                }
                HummerStyleUtils.applyStyle(false, hMBase, extendCssViewStyle);
            } else if (Display.YOGA.value().equals(str)) {
                if (hMBase.getDisplay() == Display.BLOCK) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("width", "auto");
                    HummerStyleUtils.applyStyle(false, hMBase, hashMap2);
                }
                HummerStyleUtils.applyStyle(false, hMBase, extendCssViewStyle);
            }
        }
    }

    public static void applyDisplayStyle(HMBase hMBase, String str) {
        if (isExtendCssView(hMBase)) {
            HummerStyleUtils.applyStyle(false, hMBase, getExtendCssViewStyle(hMBase));
        }
        HashMap hashMap = new HashMap();
        if (Display.BLOCK.value().equals(str)) {
            hashMap.put("flexDirection", HummerStyleUtils.Hummer.COLUMN);
        }
        if (Display.INLINE.value().equals(str)) {
            hashMap.put("width", "auto");
            hashMap.put("maxWidth", "auto");
            hashMap.put("minWidth", "auto");
            hashMap.put("height", "auto");
            hashMap.put("maxHeight", "auto");
            hashMap.put("minHeight", "auto");
            hashMap.put("marginAll", "0%");
            hashMap.put("marginLeft", "0%");
            hashMap.put("marginRight", "0%");
            hashMap.put("marginTop", "0%");
            hashMap.put("marginBottom", "0%");
            hashMap.put("marginStart", "0%");
            hashMap.put("marginEnd", "0%");
            hashMap.put("marginHorizontal", "0%");
            hashMap.put("marginVertical", "0%");
            hashMap.put("paddingAll", "0%");
            hashMap.put("paddingBottom", "0%");
            hashMap.put("paddingEnd", "0%");
            hashMap.put("paddingLeft", "0%");
            hashMap.put("paddingRight", "0%");
            hashMap.put("paddingStart", "0%");
            hashMap.put("paddingTop", "0%");
            hashMap.put("paddingHorizontal", "0%");
            hashMap.put("paddingVertical", "0%");
        }
        if (Display.INLINE_BLOCK.value().equals(str)) {
            hashMap.put("flexDirection", HummerStyleUtils.Hummer.COLUMN);
        }
        HummerStyleUtils.applyStyle(false, hMBase, hashMap);
        if (hMBase instanceof HummerLayoutExtendView) {
            for (HMBase applyChildDisplayStyle : ((HummerLayoutExtendView) hMBase).getChildren()) {
                applyChildDisplayStyle(str, applyChildDisplayStyle);
            }
        }
    }

    public static boolean interceptDisplayStyle(HMBase hMBase, String str, Object obj) {
        if (!"display".equals(str) && isExtendCssView(hMBase)) {
            getExtendCssViewStyle(hMBase).put(str, obj);
        }
        if (hMBase.getDisplay() == Display.INLINE) {
            return INLINE_INTERCEPT_STYLES.contains(str);
        }
        if (hMBase.getDisplay() == Display.BLOCK) {
            return BLOCK_INTERCEPT_STYLES.contains(str);
        }
        if (hMBase.getDisplay() == Display.INLINE_BLOCK) {
            return INLINE_BLOCK_INTERCEPT_STYLES.contains(str);
        }
        return false;
    }

    public enum Position {
        YOGA("flex"),
        FIXED("fixed");
        
        private String value;

        private Position(String str) {
            this.value = str;
        }

        public String value() {
            return this.value;
        }
    }

    public enum Display {
        YOGA("flex"),
        BLOCK("block"),
        INLINE("inline"),
        INLINE_BLOCK("inline-block");
        
        private String value;

        private Display(String str) {
            this.value = str;
        }

        public String value() {
            return this.value;
        }
    }
}
