package com.didi.hummer.render.style;

import android.content.Context;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.component.input.NJTextAlign;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.jsc.jni.HummerException;
import com.didi.hummer.core.util.ExceptionUtil;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.utility.DPUtil;
import com.didi.hummer.render.utility.RTLUtil;
import com.didi.hummer.render.utility.RemUtil;
import com.didi.hummer.render.utility.YogaAttrUtils;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HummerStyleUtils {
    private static final List<String> NON_DP_STYLES = new LinkedList(Arrays.asList(new String[]{"aspectRatio", "flex", "flexGrow", "flexShrink", Hummer.OPACITY, Hummer.TEXT_LINE_CLAMP, Hummer.LETTER_SPACING, Hummer.LINE_SPACING_MULTI, Hummer.MAX_LENGTH, Hummer.COLUMN}));
    private static final List<String> TRANSITION_STYLES = new LinkedList(Arrays.asList(new String[]{"width", "height", "backgroundColor", Hummer.OPACITY, Hummer.TRANSFORM}));
    private static final List<String> YOGA_STYLES = Arrays.asList(new String[]{"justifyContent", "alignContent", "alignItems", "alignSelf", "aspectRatio", "border", "borderAll", "borderLeft", "borderRight", "borderTop", "borderBottom", "borderStart", "borderEnd", "borderHorizontal", "borderVertical", "direction", "display", "flex", "flexBasis", "flexDirection", "flexGrow", "flexShrink", "flexWrap", "width", "height", "maxWidth", "maxHeight", "minWidth", "minHeight", "margin", "marginAll", "marginLeft", "marginRight", "marginTop", "marginBottom", "marginStart", "marginEnd", "marginHorizontal", "marginVertical", "padding", "paddingAll", "paddingLeft", "paddingRight", "paddingTop", "paddingBottom", "paddingStart", "paddingEnd", "paddingHorizontal", "paddingVertical", "position", Hummer.POSITION_TYPE, "positionAll", "positionLeft", "positionRight", "positionTop", "positionBottom", "positionStart", "positionEnd", "positionHorizontal", "positionVertical", NJTextAlign.LEFT, NJTextAlign.RIGHT, "top", "bottom", "start", "end"});
    private static final String[] paramNames = {"x", "y", "z"};

    class Yoga {
        static final String ALIGN_CONTENT = "alignContent";
        static final String ALIGN_ITEMS = "alignItems";
        static final String ALIGN_SELF = "alignSelf";
        static final String ASPECT_RATIO = "aspectRatio";
        static final String BORDER = "border";
        static final String BORDER_ALL = "borderAll";
        static final String BORDER_BOTTOM = "borderBottom";
        static final String BORDER_END = "borderEnd";
        static final String BORDER_HORIZONTAL = "borderHorizontal";
        static final String BORDER_LEFT = "borderLeft";
        static final String BORDER_RIGHT = "borderRight";
        static final String BORDER_START = "borderStart";
        static final String BORDER_TOP = "borderTop";
        static final String BORDER_VERTICAL = "borderVertical";
        static final String BOTTOM = "bottom";
        static final String DIRECTION = "direction";
        static final String DISPLAY = "display";
        static final String END = "end";
        static final String FLEX = "flex";
        static final String FLEX_BASIS = "flexBasis";
        static final String FLEX_DIRECTION = "flexDirection";
        static final String FLEX_GROW = "flexGrow";
        static final String FLEX_SHRINK = "flexShrink";
        static final String FLEX_WRAP = "flexWrap";
        static final String HEIGHT = "height";
        static final String JUSTIFY_CONTENT = "justifyContent";
        static final String LEFT = "left";
        static final String MARGIN = "margin";
        static final String MARGIN_ALL = "marginAll";
        static final String MARGIN_BOTTOM = "marginBottom";
        static final String MARGIN_END = "marginEnd";
        static final String MARGIN_HORIZONTAL = "marginHorizontal";
        static final String MARGIN_LEFT = "marginLeft";
        static final String MARGIN_RIGHT = "marginRight";
        static final String MARGIN_START = "marginStart";
        static final String MARGIN_TOP = "marginTop";
        static final String MARGIN_VERTICAL = "marginVertical";
        static final String MAX_HEIGHT = "maxHeight";
        static final String MAX_WIDTH = "maxWidth";
        static final String MIN_HEIGHT = "minHeight";
        static final String MIN_WIDTH = "minWidth";
        static final String PADDING = "padding";
        static final String PADDING_ALL = "paddingAll";
        static final String PADDING_BOTTOM = "paddingBottom";
        static final String PADDING_END = "paddingEnd";
        static final String PADDING_HORIZONTAL = "paddingHorizontal";
        static final String PADDING_LEFT = "paddingLeft";
        static final String PADDING_RIGHT = "paddingRight";
        static final String PADDING_START = "paddingStart";
        static final String PADDING_TOP = "paddingTop";
        static final String PADDING_VERTICAL = "paddingVertical";
        static final String POSITION = "position";
        static final String POSITION_ALL = "positionAll";
        static final String POSITION_BOTTOM = "positionBottom";
        static final String POSITION_END = "positionEnd";
        static final String POSITION_HORIZONTAL = "positionHorizontal";
        static final String POSITION_LEFT = "positionLeft";
        static final String POSITION_RIGHT = "positionRight";
        static final String POSITION_START = "positionStart";
        static final String POSITION_TOP = "positionTop";
        static final String POSITION_TYPE = "positionType";
        static final String POSITION_VERTICAL = "positionVertical";
        static final String RIGHT = "right";
        static final String START = "start";
        static final String TOP = "top";
        static final String WIDTH = "width";

        Yoga() {
        }
    }

    public class Hummer {
        public static final String BACKGROUND_COLOR = "backgroundColor";
        public static final String BACKGROUND_IMAGE = "backgroundImage";
        public static final String BORDER_COLOR = "borderColor";
        public static final String BORDER_COLOR_B = "borderBottomColor";
        public static final String BORDER_COLOR_L = "borderLeftColor";
        public static final String BORDER_COLOR_R = "borderRightColor";
        public static final String BORDER_COLOR_T = "borderTopColor";
        public static final String BORDER_RADIUS = "borderRadius";
        public static final String BORDER_RADIUS_BL = "borderBottomLeftRadius";
        public static final String BORDER_RADIUS_BR = "borderBottomRightRadius";
        public static final String BORDER_RADIUS_TL = "borderTopLeftRadius";
        public static final String BORDER_RADIUS_TR = "borderTopRightRadius";
        public static final String BORDER_STYLE = "borderStyle";
        public static final String BORDER_STYLE_B = "borderBottomStyle";
        public static final String BORDER_STYLE_L = "borderLeftStyle";
        public static final String BORDER_STYLE_R = "borderRightStyle";
        public static final String BORDER_STYLE_T = "borderTopStyle";
        public static final String BORDER_WIDTH = "borderWidth";
        public static final String BORDER_WIDTH_B = "borderBottomWidth";
        public static final String BORDER_WIDTH_L = "borderLeftWidth";
        public static final String BORDER_WIDTH_R = "borderRightWidth";
        public static final String BORDER_WIDTH_T = "borderTopWidth";
        public static final String BOTTOM_SPACING = "bottomSpacing";
        public static final String BOX_SIZING = "boxSizing";
        public static final String COLOR = "color";
        public static final String COLUMN = "column";
        public static final String CURSOR_COLOR = "cursorColor";
        public static final String DISPLAY = "display";
        public static final String FONT_FAMILY = "fontFamily";
        public static final String FONT_SIZE = "fontSize";
        public static final String FONT_STYLE = "fontStyle";
        public static final String FONT_WEIGHT = "fontWeight";
        public static final String ITEM_SPACING = "itemSpacing";
        public static final String LEFT_SPACING = "leftSpacing";
        public static final String LETTER_SPACING = "letterSpacing";
        public static final String LINE_SPACING = "lineSpacing";
        public static final String LINE_SPACING_MULTI = "lineSpacingMulti";
        public static final String MAX_LENGTH = "maxLength";
        public static final String MODE = "mode";
        public static final String OFF_COLOR = "offColor";
        public static final String ON_COLOR = "onColor";
        public static final String OPACITY = "opacity";
        public static final String OVERFLOW = "overflow";
        public static final String PLACEHOLDER_COLOR = "placeholderColor";
        public static final String PLACEHOLDER_FONT_SIZE = "placeholderFontSize";
        public static final String POSITION = "position";
        public static final String POSITION_TYPE = "positionType";
        public static final String RESIZE = "resize";
        public static final String RETURN_KEY_TYPE = "returnKeyType";
        public static final String RIGHT_SPACING = "rightSpacing";
        public static final String SCROLL_DIRECTION = "scrollDirection";
        public static final String SHADOW = "shadow";
        public static final String TEXT_ALIGN = "textAlign";
        public static final String TEXT_DECORATION = "textDecoration";
        public static final String TEXT_LINE_CLAMP = "textLineClamp";
        public static final String TEXT_OVERFLOW = "textOverflow";
        public static final String TEXT_VERTICAL_ALIGN = "textVerticalAlign";
        public static final String THUMB_COLOR = "thumbColor";
        public static final String TOP_SPACING = "topSpacing";
        public static final String TRANSFORM = "transform";
        public static final String TRANSITION = "transition";
        public static final String TRANSITION_DELAY = "transitionDelay";
        public static final String TRANSITION_DURATION = "transitionDuration";
        public static final String TRANSITION_PROPERTY = "transitionProperty";
        public static final String TRANSITION_TIMING_FUNCTION = "transitionTimingFunction";
        public static final String TYPE = "type";
        public static final String VISIBILITY = "visibility";
        public static final String Z_INDEX = "zIndex";

        public Hummer() {
        }
    }

    public static void addNonDpStyle(String str) {
        List<String> list = NON_DP_STYLES;
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    static void applyStyle(HMBase hMBase, Map map) {
        applyStyle(true, hMBase, map);
    }

    static void applyStyle(boolean z, HMBase hMBase, Map map) {
        if (hMBase != null && map != null) {
            HashMap hashMap = new HashMap();
            for (Object next : map.keySet()) {
                String valueOf = String.valueOf(next);
                Object obj = map.get(next);
                if (!z || !HummerLayoutExtendUtils.interceptDisplayStyle(hMBase, valueOf, obj)) {
                    if ("position".equals(valueOf) || Hummer.POSITION_TYPE.equals(valueOf) || "display".equals(valueOf)) {
                        if (hMBase.setHummerStyle(valueOf, obj)) {
                        }
                    } else if (valueOf.startsWith(Hummer.TRANSITION)) {
                        hashMap.put(valueOf, obj);
                    }
                    try {
                        if (!Hummer.TRANSFORM.equals(valueOf)) {
                            if (isTransitionStyle(valueOf)) {
                                if (!hMBase.supportTransitionStyle("all")) {
                                    if (hMBase.supportTransitionStyle(valueOf)) {
                                    }
                                }
                            }
                            if (isYogaStyle(valueOf)) {
                                applyYogaStyle(hMBase.getYogaNode(), toRTLStyleIfNeed(hMBase.getContext(), valueOf), obj);
                            } else {
                                applyHummerStyle(hMBase, valueOf, obj);
                            }
                        }
                        hMBase.handleTransitionStyle(valueOf, obj);
                    } catch (Exception e) {
                        String jSErrorStack = ExceptionUtil.getJSErrorStack(hMBase.getJSValue().getJSContext());
                        ExceptionUtil.addStackTrace(e, new StackTraceElement("<<JS_Stack>>", "", "\n" + jSErrorStack, -1));
                        ExceptionUtil.addStackTrace(e, new StackTraceElement("<<Style>>", "", String.format("%s: %s", new Object[]{valueOf, obj}), -1));
                        HummerException.nativeException(hMBase.getJSValue().getJSContext(), e);
                    }
                }
            }
            hMBase.getView().requestLayout();
            for (Object next2 : hashMap.keySet()) {
                hMBase.setTransitionStyle(String.valueOf(next2), map.get(next2));
            }
            hMBase.runAnimator();
        }
    }

    public static Object transformValue(Object obj) {
        if (obj == null) {
            return obj;
        }
        String obj2 = obj.toString();
        if (!obj2.contains(",")) {
            return obj;
        }
        String[] split = obj2.split(",");
        HashMap hashMap = new HashMap();
        for (int i = 0; i < split.length; i++) {
            hashMap.put(paramNames[i], split[i]);
        }
        return hashMap;
    }

    static void resetYogaStyle(HMBase hMBase) {
        if (hMBase != null) {
            YogaNode yogaNode = hMBase.getYogaNode();
            yogaNode.setJustifyContent(YogaJustify.FLEX_START);
            yogaNode.setAlignContent(YogaAlign.FLEX_START);
            yogaNode.setAlignContent(YogaAlign.FLEX_START);
            yogaNode.setAlignItems(YogaAlign.STRETCH);
            yogaNode.setAlignSelf(YogaAlign.AUTO);
            yogaNode.setBorder(YogaEdge.ALL, 0.0f);
            yogaNode.setDisplay(YogaDisplay.FLEX);
            yogaNode.setFlexBasisAuto();
            yogaNode.setFlexDirection(YogaFlexDirection.COLUMN);
            yogaNode.setFlexGrow(0.0f);
            yogaNode.setFlexShrink(1.0f);
            yogaNode.setWrap(YogaWrap.NO_WRAP);
            yogaNode.setWidthAuto();
            yogaNode.setHeightAuto();
            yogaNode.setMaxWidth(2.14748365E9f);
            yogaNode.setMaxHeight(2.14748365E9f);
            yogaNode.setMinWidth(0.0f);
            yogaNode.setMinHeight(0.0f);
            yogaNode.setMargin(YogaEdge.ALL, 0.0f);
            yogaNode.setPadding(YogaEdge.ALL, 0.0f);
            yogaNode.setPosition(YogaEdge.ALL, 0.0f);
            yogaNode.setPositionType(YogaPositionType.RELATIVE);
        }
    }

    private static boolean isTransitionStyle(String str) {
        return TRANSITION_STYLES.contains(str);
    }

    private static boolean isYogaStyle(String str) {
        return YOGA_STYLES.contains(str);
    }

    private static boolean isDPStyle(String str) {
        return !NON_DP_STYLES.contains(str);
    }

    static String toRTLStyleIfNeed(Context context, String str) {
        boolean z = true;
        if (!((context instanceof HummerContext) && HummerSDK.isSupportRTL(((HummerContext) context).getNamespace())) || !RTLUtil.isRTL(context)) {
            z = false;
        }
        if (!z) {
            return str;
        }
        if (str.equals(NJTextAlign.LEFT)) {
            return NJTextAlign.RIGHT;
        }
        if (str.equals(NJTextAlign.RIGHT)) {
            return NJTextAlign.LEFT;
        }
        if (str.equals("positionLeft")) {
            return "positionRight";
        }
        if (str.equals("positionRight")) {
            return "positionLeft";
        }
        if (str.equals("marginLeft")) {
            return "marginRight";
        }
        if (str.equals("marginRight")) {
            return "marginLeft";
        }
        if (str.equals("paddingLeft")) {
            return "paddingRight";
        }
        if (str.equals("paddingRight")) {
            return "paddingLeft";
        }
        return str;
    }

    static void applyYogaStyle(YogaNode yogaNode, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2142380876:
                if (str.equals("positionBottom")) {
                    c = 0;
                    break;
                }
                break;
            case -1906103182:
                if (str.equals("marginHorizontal")) {
                    c = 1;
                    break;
                }
                break;
            case -1783760955:
                if (str.equals("flexBasis")) {
                    c = 2;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = 3;
                    break;
                }
                break;
            case -1384764481:
                if (str.equals("positionVertical")) {
                    c = 4;
                    break;
                }
                break;
            case -1383304148:
                if (str.equals("border")) {
                    c = 5;
                    break;
                }
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c = 6;
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c = 7;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 8;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c = 9;
                    break;
                }
                break;
            case -1063257157:
                if (str.equals("alignItems")) {
                    c = 10;
                    break;
                }
                break;
            case -1044810477:
                if (str.equals("marginAll")) {
                    c = 11;
                    break;
                }
                break;
            case -1044806579:
                if (str.equals("marginEnd")) {
                    c = 12;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 13;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c = 14;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c = 15;
                    break;
                }
                break;
            case -906066005:
                if (str.equals("maxHeight")) {
                    c = 16;
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c = 17;
                    break;
                }
                break;
            case -752601676:
                if (str.equals("alignContent")) {
                    c = 18;
                    break;
                }
                break;
            case -359890155:
                if (str.equals("paddingHorizontal")) {
                    c = 19;
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 20;
                    break;
                }
                break;
            case -137466952:
                if (str.equals("positionAll")) {
                    c = 21;
                    break;
                }
                break;
            case -137463054:
                if (str.equals("positionEnd")) {
                    c = 22;
                    break;
                }
                break;
            case -137448596:
                if (str.equals("positionTop")) {
                    c = 23;
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c = 24;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c = 25;
                    break;
                }
                break;
            case 115029:
                if (str.equals("top")) {
                    c = 26;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    c = 27;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(NJTextAlign.LEFT)) {
                    c = 28;
                    break;
                }
                break;
            case 33812688:
                if (str.equals("positionLeft")) {
                    c = 29;
                    break;
                }
                break;
            case 34070531:
                if (str.equals(Hummer.POSITION_TYPE)) {
                    c = 30;
                    break;
                }
                break;
            case 90111952:
                if (str.equals("paddingAll")) {
                    c = 31;
                    break;
                }
                break;
            case 90115850:
                if (str.equals("paddingEnd")) {
                    c = ' ';
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = '!';
                    break;
                }
                break;
            case 108511772:
                if (str.equals(NJTextAlign.RIGHT)) {
                    c = '\"';
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = '#';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = '$';
                    break;
                }
                break;
            case 197397973:
                if (str.equals("borderAll")) {
                    c = '%';
                    break;
                }
                break;
            case 197401871:
                if (str.equals("borderEnd")) {
                    c = '&';
                    break;
                }
                break;
            case 197416329:
                if (str.equals("borderTop")) {
                    c = '\'';
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '(';
                    break;
                }
                break;
            case 400381634:
                if (str.equals("maxWidth")) {
                    c = ')';
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = '*';
                    break;
                }
                break;
            case 715094737:
                if (str.equals("paddingStart")) {
                    c = '+';
                    break;
                }
                break;
            case 736500048:
                if (str.equals("borderRight")) {
                    c = ',';
                    break;
                }
                break;
            case 737745814:
                if (str.equals("borderStart")) {
                    c = '-';
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c = '.';
                    break;
                }
                break;
            case 811701616:
                if (str.equals("borderHorizontal")) {
                    c = '/';
                    break;
                }
                break;
            case 904538487:
                if (str.equals("borderBottom")) {
                    c = '0';
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = '1';
                    break;
                }
                break;
            case 976333652:
                if (str.equals("marginStart")) {
                    c = '2';
                    break;
                }
                break;
            case 1031115618:
                if (str.equals("flexShrink")) {
                    c = '3';
                    break;
                }
                break;
            case 1053854323:
                if (str.equals("positionRight")) {
                    c = '4';
                    break;
                }
                break;
            case 1055100089:
                if (str.equals("positionStart")) {
                    c = '5';
                    break;
                }
                break;
            case 1092174483:
                if (str.equals("aspectRatio")) {
                    c = '6';
                    break;
                }
                break;
            case 1343645351:
                if (str.equals("paddingVertical")) {
                    c = '7';
                    break;
                }
                break;
            case 1431421764:
                if (str.equals("marginVertical")) {
                    c = '8';
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = '9';
                    break;
                }
                break;
            case 1743739820:
                if (str.equals("flexGrow")) {
                    c = ':';
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    c = ';';
                    break;
                }
                break;
            case 1767100401:
                if (str.equals("alignSelf")) {
                    c = '<';
                    break;
                }
                break;
            case 1824690771:
                if (str.equals("borderLeft")) {
                    c = '=';
                    break;
                }
                break;
            case 1832014786:
                if (str.equals("borderVertical")) {
                    c = '>';
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    c = '?';
                    break;
                }
                break;
            case 1863279149:
                if (str.equals("positionHorizontal")) {
                    c = '@';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 'A';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.BOTTOM, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.BOTTOM, toNumber(str, obj));
                    return;
                }
            case 1:
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.HORIZONTAL);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.HORIZONTAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.HORIZONTAL, toNumber(str, obj));
                    return;
                }
            case 2:
                if (isAutoValue(obj)) {
                    yogaNode.setFlexBasisAuto();
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setFlexBasisPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setFlexBasis(toNumber(str, obj));
                    return;
                }
            case 3:
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.LEFT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.LEFT, toNumber(str, obj));
                    return;
                }
            case 4:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.VERTICAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.VERTICAL, toNumber(str, obj));
                    return;
                }
            case 5:
            case '%':
                yogaNode.setBorder(YogaEdge.ALL, toNumber(str, obj));
                return;
            case 7:
                if (isAutoValue(obj)) {
                    yogaNode.setMinWidth(0.0f);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMinWidthPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setMinWidth(toNumber(str, obj));
                    return;
                }
            case 8:
                if (isAutoValue(obj)) {
                    yogaNode.setHeightAuto();
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setHeightPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setHeight(toNumber(str, obj));
                    return;
                }
            case 9:
            case 11:
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.ALL);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.ALL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.ALL, toNumber(str, obj));
                    return;
                }
            case 10:
                yogaNode.setAlignItems(YogaAlign.valueOf(toYogaEnumString(obj)));
                return;
            case 12:
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.END);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.END, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.END, toNumber(str, obj));
                    return;
                }
            case 13:
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.TOP);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.TOP, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.TOP, toNumber(str, obj));
                    return;
                }
            case 14:
                yogaNode.setFlexDirection(YogaFlexDirection.valueOf(toYogaEnumString(obj)));
                return;
            case 15:
                yogaNode.setDirection(YogaDirection.valueOf(toYogaEnumString(obj)));
                return;
            case 16:
                if (isAutoValue(obj)) {
                    yogaNode.setMaxHeight(2.14748365E9f);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMaxHeightPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setMaxHeight(toNumber(str, obj));
                    return;
                }
            case 17:
            case 31:
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.ALL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.ALL, toNumber(str, obj));
                    return;
                }
            case 18:
                yogaNode.setAlignContent(YogaAlign.valueOf(toYogaEnumString(obj)));
                return;
            case 19:
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.HORIZONTAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.HORIZONTAL, toNumber(str, obj));
                    return;
                }
            case 20:
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.BOTTOM);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.BOTTOM, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.BOTTOM, toNumber(str, obj));
                    return;
                }
            case 21:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.ALL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.ALL, toNumber(str, obj));
                    return;
                }
            case 22:
            case 25:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.END, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.END, toNumber(str, obj));
                    return;
                }
            case 23:
            case 26:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.TOP, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.TOP, toNumber(str, obj));
                    return;
                }
            case 24:
                if (isAutoValue(obj)) {
                    yogaNode.setMinHeight(0.0f);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMinHeightPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setMinHeight(toNumber(str, obj));
                    return;
                }
            case 27:
                yogaNode.setFlex(toNumber(str, obj));
                return;
            case 28:
            case 29:
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.LEFT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.LEFT, toNumber(str, obj));
                    return;
                }
            case 30:
            case '.':
                yogaNode.setPositionType(YogaPositionType.valueOf(toYogaEnumString(obj)));
                return;
            case ' ':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.END, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.END, toNumber(str, obj));
                    return;
                }
            case '!':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.TOP, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.TOP, toNumber(str, obj));
                    return;
                }
            case '\"':
            case '4':
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.RIGHT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.RIGHT, toNumber(str, obj));
                    return;
                }
            case '#':
            case '5':
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.START, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.START, toNumber(str, obj));
                    return;
                }
            case '$':
                if (isAutoValue(obj)) {
                    yogaNode.setWidthAuto();
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setWidthPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setWidth(toNumber(str, obj));
                    return;
                }
            case '&':
                yogaNode.setBorder(YogaEdge.END, toNumber(str, obj));
                return;
            case '\'':
                yogaNode.setBorder(YogaEdge.TOP, toNumber(str, obj));
                return;
            case '(':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.BOTTOM, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.BOTTOM, toNumber(str, obj));
                    return;
                }
            case ')':
                if (isAutoValue(obj)) {
                    yogaNode.setMaxWidth(2.14748365E9f);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMaxWidthPercent(toPercent(obj));
                    return;
                } else {
                    yogaNode.setMaxWidth(toNumber(str, obj));
                    return;
                }
            case '*':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.RIGHT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.RIGHT, toNumber(str, obj));
                    return;
                }
            case '+':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.START, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.START, toNumber(str, obj));
                    return;
                }
            case ',':
                yogaNode.setBorder(YogaEdge.RIGHT, toNumber(str, obj));
                return;
            case '-':
                yogaNode.setBorder(YogaEdge.START, toNumber(str, obj));
                return;
            case '/':
                yogaNode.setBorder(YogaEdge.HORIZONTAL, toNumber(str, obj));
                return;
            case '0':
                yogaNode.setBorder(YogaEdge.BOTTOM, toNumber(str, obj));
                return;
            case '1':
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.RIGHT);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.RIGHT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.RIGHT, toNumber(str, obj));
                    return;
                }
            case '2':
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.START);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.START, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.START, toNumber(str, obj));
                    return;
                }
            case '3':
                yogaNode.setFlexShrink(toNumber(str, obj));
                return;
            case '6':
                yogaNode.setAspectRatio(toNumber(str, obj));
                return;
            case '7':
                if (isPercentValue(obj)) {
                    yogaNode.setPaddingPercent(YogaEdge.VERTICAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPadding(YogaEdge.VERTICAL, toNumber(str, obj));
                    return;
                }
            case '8':
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.VERTICAL);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.VERTICAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.VERTICAL, toNumber(str, obj));
                    return;
                }
            case '9':
                yogaNode.setDisplay(YogaDisplay.valueOf(toYogaEnumString(obj)));
                return;
            case ':':
                yogaNode.setFlexGrow(toNumber(str, obj));
                return;
            case ';':
                yogaNode.setWrap(YogaWrap.valueOf(toYogaEnumString(obj)));
                return;
            case '<':
                yogaNode.setAlignSelf(YogaAlign.valueOf(toYogaEnumString(obj)));
                return;
            case '=':
                yogaNode.setBorder(YogaEdge.LEFT, toNumber(str, obj));
                return;
            case '>':
                yogaNode.setBorder(YogaEdge.VERTICAL, toNumber(str, obj));
                return;
            case '?':
                yogaNode.setJustifyContent(YogaJustify.valueOf(toYogaEnumString(obj)));
                return;
            case '@':
                if (isPercentValue(obj)) {
                    yogaNode.setPositionPercent(YogaEdge.HORIZONTAL, toPercent(obj));
                    return;
                } else {
                    yogaNode.setPosition(YogaEdge.HORIZONTAL, toNumber(str, obj));
                    return;
                }
            case 'A':
                if (isAutoValue(obj)) {
                    yogaNode.setMarginAuto(YogaEdge.LEFT);
                    return;
                } else if (isPercentValue(obj)) {
                    yogaNode.setMarginPercent(YogaEdge.LEFT, toPercent(obj));
                    return;
                } else {
                    yogaNode.setMargin(YogaEdge.LEFT, toNumber(str, obj));
                    return;
                }
            default:
                return;
        }
    }

    private static void applyHummerStyle(HMBase hMBase, String str, Object obj) {
        hMBase.setHummerStyle(str, convertValue(str, obj));
    }

    private static float toNumber(String str, Object obj) {
        return convertNumber(obj, isDPStyle(str));
    }

    private static String toYogaEnumString(Object obj) {
        String upperCase = String.valueOf(obj).toUpperCase();
        if (upperCase.equals("NOWRAP")) {
            return "NO_WRAP";
        }
        return upperCase.replace("-", "_");
    }

    public static float toPercent(Object obj) {
        if (!isPercentValue(obj)) {
            return 0.0f;
        }
        String valueOf = String.valueOf(obj);
        return Float.parseFloat(valueOf.substring(0, valueOf.length() - 1));
    }

    public static Object convertValue(String str, Object obj) {
        Object valueOf;
        if (!(obj instanceof String)) {
            return obj instanceof Number ? Float.valueOf(convertNumber(obj, isDPStyle(str))) : obj;
        }
        String str2 = (String) obj;
        if (str2.startsWith("#")) {
            valueOf = Integer.valueOf(YogaAttrUtils.parseColor(str2));
        } else if (str2.startsWith("linear-gradient")) {
            valueOf = YogaAttrUtils.parseLinearGradientColor(str2);
        } else {
            try {
                valueOf = Float.valueOf(convertNumber(obj, isDPStyle(str)));
            } catch (Exception unused) {
                return obj;
            }
        }
        return valueOf;
    }

    public static Object convertColor(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (YogaAttrUtils.isColor(str)) {
                return Integer.valueOf(YogaAttrUtils.parseColor(str));
            }
            if (YogaAttrUtils.isLinearGradientColor(str)) {
                return YogaAttrUtils.parseLinearGradientColor(str);
            }
        }
        return 0;
    }

    public static float convertNumber(Object obj) {
        return convertNumber(obj, true);
    }

    public static float convertNumber(Object obj, boolean z) throws RuntimeException {
        int dp2px;
        if (obj instanceof Number) {
            if (!z) {
                return ((Number) obj).floatValue();
            }
            dp2px = DPUtil.dp2px(HummerSDK.appContext, ((Number) obj).floatValue());
        } else if (!(obj instanceof String)) {
            return 0.0f;
        } else {
            String str = (String) obj;
            boolean z2 = true;
            boolean z3 = false;
            if (str.endsWith("px") || str.endsWith("PX")) {
                str = str.substring(0, str.length() - 2);
                z3 = true;
                z2 = false;
            } else if (str.endsWith("hm") || str.endsWith("HM")) {
                str = str.substring(0, str.length() - 2);
            } else {
                z2 = false;
            }
            float parseFloat = Float.parseFloat(str);
            if (z2) {
                return RemUtil.rem2px(parseFloat);
            }
            if (z3 || !z) {
                return parseFloat;
            }
            dp2px = DPUtil.dp2px(HummerSDK.appContext, parseFloat);
        }
        return (float) dp2px;
    }

    public static boolean isColorValue(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        if (YogaAttrUtils.isColor(str) || YogaAttrUtils.isLinearGradientColor(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNumberValue(Object obj) {
        if (!(obj instanceof String)) {
            return obj instanceof Number;
        }
        String str = (String) obj;
        return YogaAttrUtils.isNumeric(str) || YogaAttrUtils.isPxNumeric(str) || YogaAttrUtils.isHmNumeric(str);
    }

    public static boolean isAutoValue(Object obj) {
        return (obj instanceof String) && ((String) obj).toLowerCase().equals("auto");
    }

    public static boolean isPercentValue(Object obj) {
        return (obj instanceof String) && ((String) obj).endsWith("%");
    }
}
