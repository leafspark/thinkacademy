package com.didi.hummer.render.component.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.didi.hummer.annotation.JsAttribute;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.annotation.JsProperty;
import com.didi.hummer.component.input.NJTextAlign;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSCallback;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.debug.Highlight;
import com.didi.hummer.lifecycle.ILifeCycle;
import com.didi.hummer.render.component.anim.AnimViewWrapper;
import com.didi.hummer.render.component.anim.BasicAnimation;
import com.didi.hummer.render.component.anim.HummerAnimationUtils;
import com.didi.hummer.render.component.anim.Transition;
import com.didi.hummer.render.event.EventManager;
import com.didi.hummer.render.event.view.InputEvent;
import com.didi.hummer.render.event.view.SwitchEvent;
import com.didi.hummer.render.style.HummerLayoutExtendUtils;
import com.didi.hummer.render.style.HummerNode;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.didi.hummer.render.utility.DPUtil;
import com.didi.hummer.render.utility.YogaAttrUtils;
import com.didi.hummer.sdk.R;
import com.didi.hummer.utils.ScreenUtils;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaPositionType;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class HMBase<T extends View> implements ILifeCycle {
    private static final String BOX_SIZING_BORDER_BOX = "border-box";
    private static final String BOX_SIZING_CONTENT_BOX = "content-box";
    private static final String BOX_SIZING_NONE = "none";
    public static final String VISIBILITY_HIDDEN = "hidden";
    public static final String VISIBILITY_VISIBLE = "visible";
    @JsProperty("accessibilityHint")
    public String accessibilityHint;
    @JsProperty("accessibilityLabel")
    public String accessibilityLabel;
    @JsProperty("accessibilityRole")
    public String accessibilityRole;
    @JsProperty("accessibilityState")
    public Map<String, Object> accessibilityState;
    @JsProperty("accessible")
    public boolean accessible;
    private Map<String, BasicAnimation> animMap = new HashMap();
    private AnimViewWrapper animViewWrapper;
    protected BackgroundHelper backgroundHelper;
    private String boxSizing = "none";
    private HummerContext context;
    private HummerLayoutExtendUtils.Display display = HummerLayoutExtendUtils.Display.YOGA;
    private DisplayChangedListener displayChangedListener;
    List<Double> durationList = new ArrayList();
    @JsProperty("enabled")
    public boolean enabled;
    protected HMGestureEventDetector hmGestureEventDetector;
    protected HummerNode hummerNode;
    private InlineBox inlineBox;
    /* access modifiers changed from: protected */
    public EventManager mEventManager;
    protected JSValue mJSValue;
    private T mTargetView;
    List<ObjectAnimator> objectAnimatorList = new ArrayList();
    private HummerLayoutExtendUtils.Position position = HummerLayoutExtendUtils.Position.YOGA;
    private PositionChangedListener positionChangedListener;
    @JsProperty("style")
    public Map<String, Object> style = new HashMap();
    double transitionDelay = 0.0d;
    String transitionTimingFunction = null;
    private List<Transition> transitions = new ArrayList();

    public interface DisplayChangedListener {
        void dispatchChildDisplayChanged(HMBase hMBase, HummerLayoutExtendUtils.Display display, HummerLayoutExtendUtils.Display display2);
    }

    public interface PositionChangedListener {
        void dispatchChildPositionChanged(HMBase hMBase, HummerLayoutExtendUtils.Position position, HummerLayoutExtendUtils.Position position2);
    }

    /* access modifiers changed from: protected */
    public abstract T createViewInstance(Context context2);

    /* access modifiers changed from: protected */
    public void onStyleUpdated(Map<String, Object> map) {
    }

    public boolean setStyle(String str, Object obj) {
        return false;
    }

    public HMBase(HummerContext hummerContext, JSValue jSValue, String str) {
        this.context = hummerContext;
        this.mJSValue = jSValue;
        this.mTargetView = createView(hummerContext.getContext());
        this.hummerNode = new HummerNode(this, str);
        this.backgroundHelper = new BackgroundHelper(hummerContext, this.mTargetView);
        this.animViewWrapper = new AnimViewWrapper(this);
        ViewCompat.setAccessibilityDelegate(this.mTargetView, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                HMBase.super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                ArrayList arrayList = new ArrayList();
                if (HMBase.this.accessibilityLabel != null) {
                    arrayList.add(HMBase.this.accessibilityLabel);
                }
                if (HMBase.this.accessibilityHint != null) {
                    if (HMBase.this.accessibilityLabel == null && accessibilityNodeInfoCompat.getText() != null) {
                        arrayList.add(accessibilityNodeInfoCompat.getText().toString());
                    }
                    arrayList.add(HMBase.this.accessibilityHint);
                }
                if (!arrayList.isEmpty()) {
                    accessibilityNodeInfoCompat.setContentDescription(TextUtils.join(", ", arrayList));
                }
                if (HMBase.this.accessibilityRole != null) {
                    accessibilityNodeInfoCompat.setRoleDescription(HMBase.this.accessibilityRole);
                }
                if (HMBase.this.accessibilityState != null) {
                    for (String next : HMBase.this.accessibilityState.keySet()) {
                        Object obj = HMBase.this.accessibilityState.get(next);
                        if ("selected".equalsIgnoreCase(next)) {
                            if (obj instanceof Boolean) {
                                accessibilityNodeInfoCompat.setSelected(((Boolean) obj).booleanValue());
                            }
                        } else if ("disabled".equalsIgnoreCase(next) && (obj instanceof Boolean)) {
                            accessibilityNodeInfoCompat.setEnabled(!((Boolean) obj).booleanValue());
                        }
                    }
                }
            }
        });
    }

    public void onCreate() {
        EventManager eventManager = new EventManager();
        this.mEventManager = eventManager;
        eventManager.onCreate();
        this.hmGestureEventDetector = new HMGestureEventDetector(this);
    }

    public void onDestroy() {
        Map<String, BasicAnimation> map = this.animMap;
        if (map != null) {
            map.clear();
            this.animMap = null;
        }
        if (this.mEventManager != null) {
            getView().post(new HMBase$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$onDestroy$0$HMBase() {
        this.mEventManager.onDestroy();
    }

    public JSValue getJSValue() {
        return this.mJSValue;
    }

    public String getViewID() {
        return this.hummerNode.getId();
    }

    public YogaNode getYogaNode() {
        return this.hummerNode.getYogaNode();
    }

    public HummerNode getNode() {
        return this.hummerNode;
    }

    private final T createView(Context context2) {
        T createViewInstance = createViewInstance(context2);
        if (createViewInstance != null) {
            return createViewInstance;
        }
        throw new RuntimeException("createViewInstance must return a view");
    }

    public T getView() {
        return this.mTargetView;
    }

    public AnimViewWrapper getAnimViewWrapper() {
        return this.animViewWrapper;
    }

    public EventManager getEventManager() {
        return this.mEventManager;
    }

    public void setStyle(Map<String, Object> map) {
        this.style = map;
        this.hummerNode.setStyle(map);
        onStyleUpdated(map);
    }

    public BackgroundHelper getBackgroundHelper() {
        return this.backgroundHelper;
    }

    public void setEnabled(boolean z) {
        getView().setEnabled(z);
    }

    public boolean getEnabled() {
        return getView().isEnabled();
    }

    public void setAccessible(boolean z) {
        getView().setImportantForAccessibility(z ? 1 : 2);
    }

    public void setAccessibilityLabel(String str) {
        this.accessibilityLabel = str;
    }

    public void setAccessibilityHint(String str) {
        this.accessibilityHint = str;
    }

    public void setAccessibilityRole(String str) {
        Resources resources = getContext().getResources();
        if ("none".equalsIgnoreCase(str)) {
            this.accessibilityRole = "";
        } else if ("text".equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_text);
        } else if ("button".equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_button);
        } else if (PictureMimeType.MIME_TYPE_PREFIX_IMAGE.equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_image);
        } else if (SwitchEvent.HM_EVENT_TYPE_SWITCH.equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_switch);
        } else if (InputEvent.HM_EVENT_TYPE_INPUT.equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_input);
        } else if ("link".equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_link);
        } else if ("search".equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_search);
        } else if ("key".equalsIgnoreCase(str)) {
            this.accessibilityRole = resources.getString(R.string.accessibility_role_key);
        } else {
            this.accessibilityRole = str;
        }
    }

    public void setAccessibilityState(Map<String, Object> map) {
        this.accessibilityState = map;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.accessibilityState.get(next);
                if ("selected".equalsIgnoreCase(next) && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                    getView().post(new HMBase$$ExternalSyntheticLambda1(this));
                }
            }
        }
    }

    public /* synthetic */ void lambda$setAccessibilityState$1$HMBase() {
        getView().sendAccessibilityEvent(32768);
    }

    @JsMethod("addEventListener")
    public void addEventListener(String str, JSCallback jSCallback) {
        this.mEventManager.addEventListener(str, jSCallback);
        this.hmGestureEventDetector.initClickListener(str);
    }

    @JsMethod("removeEventListener")
    public void removeEventListener(String str, JSCallback jSCallback) {
        if (jSCallback == null) {
            this.mEventManager.clearEventListeners(str);
        } else {
            this.mEventManager.removeEventListener(str, jSCallback);
        }
    }

    @JsMethod("addAnimation")
    public void addAnimation(BasicAnimation basicAnimation, String str) {
        this.animMap.put(str, basicAnimation);
        basicAnimation.start(this);
    }

    @JsMethod("removeAnimationForKey")
    public void removeAnimationForKey(String str) {
        if (this.animMap.containsKey(str)) {
            this.animMap.get(str).stop();
            this.animMap.remove(str);
        }
    }

    @JsMethod("removeAllAnimation")
    public void removeAllAnimation() {
        Iterator<Map.Entry<String, BasicAnimation>> it = this.animMap.entrySet().iterator();
        while (it.hasNext()) {
            ((BasicAnimation) it.next().getValue()).stop();
            it.remove();
        }
    }

    @JsMethod("getRect")
    public void getRect(JSCallback jSCallback) {
        if (jSCallback != null) {
            getView().post(new HMBase$$ExternalSyntheticLambda3(this, jSCallback));
        }
    }

    public /* synthetic */ void lambda$getRect$2$HMBase(JSCallback jSCallback) {
        Rect rect = new Rect();
        int[] viewLocationOnScreen = ScreenUtils.getViewLocationOnScreen(getView());
        getView().getHitRect(rect);
        HashMap hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(DPUtil.px2dpF(this.context, (float) getView().getWidth())));
        hashMap.put("height", Float.valueOf(DPUtil.px2dpF(this.context, (float) getView().getHeight())));
        hashMap.put(NJTextAlign.LEFT, Float.valueOf(DPUtil.px2dpF(this.context, (float) rect.left)));
        hashMap.put(NJTextAlign.RIGHT, Float.valueOf(DPUtil.px2dpF(this.context, (float) rect.right)));
        hashMap.put("top", Float.valueOf(DPUtil.px2dpF(this.context, (float) rect.top)));
        hashMap.put("bottom", Float.valueOf(DPUtil.px2dpF(this.context, (float) rect.bottom)));
        hashMap.put("windowLeft", Float.valueOf(DPUtil.px2dpF(this.context, (float) viewLocationOnScreen[0])));
        hashMap.put("windowRight", Float.valueOf(DPUtil.px2dpF(this.context, (float) (viewLocationOnScreen[0] + getView().getWidth()))));
        hashMap.put("windowTop", Float.valueOf(DPUtil.px2dpF(this.context, (float) viewLocationOnScreen[1])));
        hashMap.put("windowBottom", Float.valueOf(DPUtil.px2dpF(this.context, (float) (viewLocationOnScreen[1] + getView().getHeight()))));
        jSCallback.call(hashMap);
    }

    @JsMethod("resetStyle")
    @Deprecated
    public void resetStyle() {
        this.hummerNode.resetStyle();
        setBackgroundColor(0);
        setBackgroundImage((String) null);
        setBorderWidth(0.0f);
        setBorderColor(0);
        setBorderRadius(0);
        setBorderStyle((String) null);
        setShadow((String) null);
        setOpacity(1.0f);
        setVisibility(VISIBILITY_VISIBLE);
    }

    @JsMethod("dbg_highlight")
    public void dbg_highlight(Object obj) {
        if (obj == null) {
            Highlight.show(getView());
        } else if (!(obj instanceof Boolean)) {
            boolean z = obj instanceof Map;
        } else if (((Boolean) obj).booleanValue()) {
            Highlight.show(getView());
        } else {
            Highlight.clear();
        }
    }

    @JsMethod("dbg_getDescription")
    public void dbg_getDescription(JSCallback jSCallback, int i) {
        if (DebugUtil.isDebuggable() && jSCallback != null) {
            if (i <= 0) {
                i = Integer.MAX_VALUE;
            }
            getView().post(new HMBase$$ExternalSyntheticLambda2(this, i, jSCallback));
        }
    }

    public /* synthetic */ void lambda$dbg_getDescription$3$HMBase(int i, JSCallback jSCallback) {
        jSCallback.call(getNode().getJSNodeTree(i));
    }

    @JsAttribute({"visibility"})
    public void setVisibility(String str) {
        getView().setVisibility(VISIBILITY_HIDDEN.equals(str) ? 4 : 0);
    }

    @JsAttribute({"backgroundColor"})
    public void setBackgroundColor(Object obj) {
        this.backgroundHelper.setBackgroundColor(obj);
    }

    @JsAttribute({"backgroundImage"})
    public void setBackgroundImage(String str) {
        this.backgroundHelper.setBackgroundImage(str);
    }

    @JsAttribute({"borderStyle"})
    public void setBorderStyle(String str) {
        this.backgroundHelper.setBorderStyle(str);
    }

    @JsAttribute({"borderLeftStyle"})
    public void setBorderLeftStyle(String str) {
        this.backgroundHelper.setBorderLeftStyle(str);
    }

    @JsAttribute({"borderTopStyle"})
    public void setBorderTopStyle(String str) {
        this.backgroundHelper.setBorderTopStyle(str);
    }

    @JsAttribute({"borderRightStyle"})
    public void setBorderRightStyle(String str) {
        this.backgroundHelper.setBorderRightStyle(str);
    }

    @JsAttribute({"borderBottomStyle"})
    public void setBorderBottomStyle(String str) {
        this.backgroundHelper.setBorderBottomStyle(str);
    }

    @JsAttribute({"borderWidth"})
    public void setBorderWidth(float f) {
        this.backgroundHelper.setBorderWidth(f);
        refreshBoxSizing();
    }

    @JsAttribute({"borderLeftWidth"})
    public void setBorderLeftWidth(float f) {
        this.backgroundHelper.setBorderLeftWidth(f);
        refreshBoxSizing();
    }

    @JsAttribute({"borderTopWidth"})
    public void setBorderTopWidth(float f) {
        this.backgroundHelper.setBorderTopWidth(f);
        refreshBoxSizing();
    }

    @JsAttribute({"borderRightWidth"})
    public void setBorderRightWidth(float f) {
        this.backgroundHelper.setBorderRightWidth(f);
        refreshBoxSizing();
    }

    @JsAttribute({"borderBottomWidth"})
    public void setBorderBottomWidth(float f) {
        this.backgroundHelper.setBorderBottomWidth(f);
        refreshBoxSizing();
    }

    @JsAttribute({"borderColor"})
    public void setBorderColor(int i) {
        this.backgroundHelper.setBorderColor(i);
    }

    @JsAttribute({"borderLeftColor"})
    public void setBorderLeftColor(int i) {
        this.backgroundHelper.setBorderLeftColor(i);
    }

    @JsAttribute({"borderTopColor"})
    public void setBorderTopColor(int i) {
        this.backgroundHelper.setBorderTopColor(i);
    }

    @JsAttribute({"borderRightColor"})
    public void setBorderRightColor(int i) {
        this.backgroundHelper.setBorderRightColor(i);
    }

    @JsAttribute({"borderBottomColor"})
    public void setBorderBottomColor(int i) {
        this.backgroundHelper.setBorderBottomColor(i);
    }

    @JsAttribute({"borderRadius"})
    public void setBorderRadius(Object obj) {
        if (HummerStyleUtils.isPercentValue(obj)) {
            this.backgroundHelper.setBorderRadiusPercent(HummerStyleUtils.toPercent(obj));
        } else if (obj instanceof Float) {
            this.backgroundHelper.setBorderRadius(((Float) obj).floatValue());
        }
    }

    @JsAttribute({"borderTopLeftRadius"})
    public void setBorderTopLeftRadius(Object obj) {
        if (HummerStyleUtils.isPercentValue(obj)) {
            this.backgroundHelper.setBorderTopLeftRadiusPercent(HummerStyleUtils.toPercent(obj));
        } else if (obj instanceof Float) {
            this.backgroundHelper.setBorderTopLeftRadius(((Float) obj).floatValue());
        }
    }

    @JsAttribute({"borderTopRightRadius"})
    public void setBorderTopRightRadius(Object obj) {
        if (HummerStyleUtils.isPercentValue(obj)) {
            this.backgroundHelper.setBorderTopRightRadiusPercent(HummerStyleUtils.toPercent(obj));
        } else if (obj instanceof Float) {
            this.backgroundHelper.setBorderTopRightRadius(((Float) obj).floatValue());
        }
    }

    @JsAttribute({"borderBottomRightRadius"})
    public void setBorderBottomRightRadius(Object obj) {
        if (HummerStyleUtils.isPercentValue(obj)) {
            this.backgroundHelper.setBorderBottomRightRadiusPercent(HummerStyleUtils.toPercent(obj));
        } else if (obj instanceof Float) {
            this.backgroundHelper.setBorderBottomRightRadius(((Float) obj).floatValue());
        }
    }

    @JsAttribute({"borderBottomLeftRadius"})
    public void setBorderBottomLeftRadius(Object obj) {
        if (HummerStyleUtils.isPercentValue(obj)) {
            this.backgroundHelper.setBorderBottomLeftRadiusPercent(HummerStyleUtils.toPercent(obj));
        } else if (obj instanceof Float) {
            this.backgroundHelper.setBorderBottomLeftRadius(((Float) obj).floatValue());
        }
    }

    @JsAttribute({"boxSizing"})
    public void setBoxSizing(String str) {
        this.boxSizing = str.toLowerCase();
        refreshBoxSizing();
    }

    @JsAttribute({"shadow"})
    public void setShadow(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(" ");
            if (split.length == 4) {
                float[] fArr = new float[3];
                for (int i = 0; i < 3; i++) {
                    fArr[i] = HummerStyleUtils.convertNumber(split[i]);
                }
                this.backgroundHelper.setShadow(fArr[2], fArr[0], fArr[1], YogaAttrUtils.parseColor(split[3]));
            }
        }
    }

    @JsAttribute({"opacity"})
    public void setOpacity(float f) {
        getView().setAlpha(f);
    }

    @JsAttribute({"zIndex"})
    public void setZIndex(int i) {
        ViewCompat.setElevation(getView(), (float) i);
    }

    public HummerLayoutExtendUtils.Position getPosition() {
        return this.position;
    }

    public HummerLayoutExtendUtils.Display getDisplay() {
        return this.display;
    }

    public void setInlineBox(InlineBox inlineBox2) {
        this.inlineBox = inlineBox2;
    }

    public InlineBox getInlineBox() {
        return this.inlineBox;
    }

    public void setPositionChangedListener(PositionChangedListener positionChangedListener2) {
        this.positionChangedListener = positionChangedListener2;
    }

    public void setDisplayChangedListener(DisplayChangedListener displayChangedListener2) {
        this.displayChangedListener = displayChangedListener2;
    }

    public Context getContext() {
        return this.context;
    }

    public final boolean setHummerStyle(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        if (setStyle(str, obj)) {
            return true;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1989576717:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_COLOR_R)) {
                    c = 0;
                    break;
                }
                break;
            case -1974639039:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_STYLE_R)) {
                    c = 1;
                    break;
                }
                break;
            case -1971292586:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_WIDTH_R)) {
                    c = 2;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_COLOR_T)) {
                    c = 3;
                    break;
                }
                break;
            case -1455888984:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_STYLE_T)) {
                    c = 4;
                    break;
                }
                break;
            case -1452542531:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_WIDTH_T)) {
                    c = 5;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_COLOR_B)) {
                    c = 6;
                    break;
                }
                break;
            case -1293920646:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_STYLE_B)) {
                    c = 7;
                    break;
                }
                break;
            case -1290574193:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_WIDTH_B)) {
                    c = 8;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals(HummerStyleUtils.Hummer.OPACITY)) {
                    c = 9;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_RADIUS_TL)) {
                    c = 10;
                    break;
                }
                break;
            case -903579360:
                if (str.equals(HummerStyleUtils.Hummer.SHADOW)) {
                    c = 11;
                    break;
                }
                break;
            case -731417480:
                if (str.equals(HummerStyleUtils.Hummer.Z_INDEX)) {
                    c = 12;
                    break;
                }
                break;
            case -242276144:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_COLOR_L)) {
                    c = 13;
                    break;
                }
                break;
            case -227338466:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_STYLE_L)) {
                    c = 14;
                    break;
                }
                break;
            case -223992013:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_WIDTH_L)) {
                    c = 15;
                    break;
                }
                break;
            case 34070531:
                if (str.equals(HummerStyleUtils.Hummer.POSITION_TYPE)) {
                    c = 16;
                    break;
                }
                break;
            case 333432965:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_RADIUS_TR)) {
                    c = 17;
                    break;
                }
                break;
            case 581268560:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_RADIUS_BL)) {
                    c = 18;
                    break;
                }
                break;
            case 588239831:
                if (str.equals(HummerStyleUtils.Hummer.BORDER_RADIUS_BR)) {
                    c = 19;
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c = 20;
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c = 21;
                    break;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    c = 22;
                    break;
                }
                break;
            case 744728105:
                if (str.equals(HummerStyleUtils.Hummer.BOX_SIZING)) {
                    c = 23;
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c = 24;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c = 25;
                    break;
                }
                break;
            case 1292595405:
                if (str.equals(HummerStyleUtils.Hummer.BACKGROUND_IMAGE)) {
                    c = 26;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c = 27;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = 28;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals(HummerStyleUtils.Hummer.VISIBILITY)) {
                    c = 29;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setBorderRightColor(((Integer) obj).intValue());
                break;
            case 1:
                setBorderRightStyle(String.valueOf(obj));
                break;
            case 2:
                setBorderRightWidth(((Float) obj).floatValue());
                break;
            case 3:
                setBorderTopColor(((Integer) obj).intValue());
                break;
            case 4:
                setBorderTopStyle(String.valueOf(obj));
                break;
            case 5:
                setBorderTopWidth(((Float) obj).floatValue());
                break;
            case 6:
                setBorderBottomColor(((Integer) obj).intValue());
                break;
            case 7:
                setBorderBottomStyle(String.valueOf(obj));
                break;
            case 8:
                setBorderBottomWidth(((Float) obj).floatValue());
                break;
            case 9:
                setOpacity(((Float) obj).floatValue());
                break;
            case 10:
                setBorderTopLeftRadius(obj);
                break;
            case 11:
                setShadow(String.valueOf(obj));
                break;
            case 12:
                setZIndex((int) ((Float) obj).floatValue());
                break;
            case 13:
                setBorderLeftColor(((Integer) obj).intValue());
                break;
            case 14:
                setBorderLeftStyle(String.valueOf(obj));
                break;
            case 15:
                setBorderLeftWidth(((Float) obj).floatValue());
                break;
            case 16:
            case 24:
                if (HummerLayoutExtendUtils.Position.FIXED.value().equals(obj)) {
                    getYogaNode().setPositionType(YogaPositionType.ABSOLUTE);
                }
                return setPosition((String) obj);
            case 17:
                setBorderTopRightRadius(obj);
                break;
            case 18:
                setBorderBottomLeftRadius(obj);
                break;
            case 19:
                setBorderBottomRightRadius(obj);
                break;
            case 20:
                setBorderColor(((Integer) obj).intValue());
                break;
            case 21:
                setBorderStyle(String.valueOf(obj));
                break;
            case 22:
                setBorderWidth(((Float) obj).floatValue());
                break;
            case 23:
                setBoxSizing(String.valueOf(obj));
                break;
            case 25:
                setBackgroundColor(obj);
                break;
            case 26:
                setBackgroundImage(String.valueOf(obj));
                break;
            case 27:
                setBorderRadius(obj);
                break;
            case 28:
                if (HummerLayoutExtendUtils.Display.BLOCK.value().equals(obj) || HummerLayoutExtendUtils.Display.INLINE.value().equals(obj) || HummerLayoutExtendUtils.Display.INLINE_BLOCK.value().equals(obj)) {
                    HummerLayoutExtendUtils.markExtendCssView(this);
                }
                String str2 = (String) obj;
                HummerLayoutExtendUtils.applyDisplayStyle(this, str2);
                return setDisplay(str2);
            case 29:
                setVisibility(String.valueOf(obj));
                break;
            default:
                return false;
        }
        return true;
    }

    private void refreshBoxSizing() {
        if (BOX_SIZING_BORDER_BOX.equals(this.boxSizing)) {
            RectF rectF = this.backgroundHelper.getBorder().width;
            getYogaNode().setBorder(YogaEdge.LEFT, rectF.left);
            getYogaNode().setBorder(YogaEdge.TOP, rectF.top);
            getYogaNode().setBorder(YogaEdge.RIGHT, rectF.right);
            getYogaNode().setBorder(YogaEdge.BOTTOM, rectF.bottom);
            return;
        }
        getYogaNode().setBorder(YogaEdge.LEFT, 0.0f);
        getYogaNode().setBorder(YogaEdge.TOP, 0.0f);
        getYogaNode().setBorder(YogaEdge.RIGHT, 0.0f);
        getYogaNode().setBorder(YogaEdge.BOTTOM, 0.0f);
    }

    public final boolean setTransitionStyle(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1998952146:
                if (str.equals(HummerStyleUtils.Hummer.TRANSITION_DELAY)) {
                    c = 0;
                    break;
                }
                break;
            case -699883785:
                if (str.equals(HummerStyleUtils.Hummer.TRANSITION_TIMING_FUNCTION)) {
                    c = 1;
                    break;
                }
                break;
            case 425064969:
                if (str.equals(HummerStyleUtils.Hummer.TRANSITION_DURATION)) {
                    c = 2;
                    break;
                }
                break;
            case 1423936074:
                if (str.equals(HummerStyleUtils.Hummer.TRANSITION_PROPERTY)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setTransitionDelay(obj);
                break;
            case 1:
                setTransitionTimingFunction((String) obj);
                break;
            case 2:
                setTransitionDuration(obj);
                break;
            case 3:
                setTransitionProperty(obj);
                break;
            default:
                return false;
        }
        return true;
    }

    public void setTransitionDuration(Object obj) {
        ArrayList arrayList = new ArrayList();
        this.durationList = arrayList;
        if (obj instanceof List) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                this.durationList.add(Double.valueOf((double) HummerStyleUtils.convertNumber(it.next(), false)));
            }
        } else if (obj instanceof String) {
            for (String convertNumber : ((String) obj).replace(" ", "").split(",")) {
                this.durationList.add(Double.valueOf((double) HummerStyleUtils.convertNumber(convertNumber, false)));
            }
        } else if (obj instanceof Number) {
            arrayList.add(Double.valueOf((double) HummerStyleUtils.convertNumber(obj, false)));
        }
        if (this.durationList.size() > 0 && this.transitions != null) {
            for (int i = 0; i < this.transitions.size(); i++) {
                List<Double> list = this.durationList;
                this.transitions.get(i).setDuration(list.get(i % list.size()).doubleValue());
            }
        }
    }

    public void setTransitionDelay(Object obj) {
        this.transitionDelay = (double) HummerStyleUtils.convertNumber(obj, false);
        if (this.transitions != null) {
            for (int i = 0; i < this.transitions.size(); i++) {
                this.transitions.get(i).setDelay(this.transitionDelay);
            }
        }
    }

    public void setTransitionTimingFunction(String str) {
        this.transitionTimingFunction = str;
        if (this.transitions != null) {
            for (int i = 0; i < this.transitions.size(); i++) {
                this.transitions.get(i).setTimingFunction(this.transitionTimingFunction);
            }
        }
    }

    public void setTransitionProperty(Object obj) {
        this.transitions = new ArrayList();
        int i = 0;
        if (obj instanceof String) {
            String[] split = ((String) obj).replace(" ", "").split(",");
            while (i < split.length) {
                Transition transition = new Transition(split[i]);
                transition.setDelay(this.transitionDelay);
                transition.setTimingFunction(this.transitionTimingFunction);
                if (this.durationList.size() > 0) {
                    List<Double> list = this.durationList;
                    transition.setDuration(list.get(i % list.size()).doubleValue());
                }
                this.transitions.add(transition);
                i++;
            }
        } else if (obj instanceof List) {
            ArrayList arrayList = (ArrayList) obj;
            if (!arrayList.isEmpty()) {
                while (i < arrayList.size()) {
                    Transition transition2 = new Transition((String) arrayList.get(i));
                    transition2.setDelay(this.transitionDelay);
                    transition2.setTimingFunction(this.transitionTimingFunction);
                    if (this.durationList.size() > 0) {
                        List<Double> list2 = this.durationList;
                        transition2.setDuration(list2.get(i % list2.size()).doubleValue());
                    }
                    this.transitions.add(transition2);
                    i++;
                }
            }
        }
    }

    public Transition getTransition(String str) {
        Iterator<Transition> it = this.transitions.iterator();
        Transition transition = null;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Transition next = it.next();
            if (str.equals(next.getProperty())) {
                transition = next;
            } else if ("all".equals(next.getProperty())) {
                transition = next;
                break;
            }
        }
        return (!HummerStyleUtils.Hummer.TRANSFORM.equals(str) || transition != null) ? transition : new Transition(str);
    }

    public boolean supportTransitionStyle(String str) {
        for (Transition property : this.transitions) {
            if (str.equals(property.getProperty())) {
                return true;
            }
        }
        return false;
    }

    private boolean setPosition(String str) {
        PositionChangedListener positionChangedListener2;
        HummerLayoutExtendUtils.Position position2 = HummerLayoutExtendUtils.Position.YOGA;
        if (HummerLayoutExtendUtils.Position.FIXED.value().equals(str)) {
            position2 = HummerLayoutExtendUtils.Position.FIXED;
        }
        HummerLayoutExtendUtils.Position position3 = this.position;
        if (!(position2 == position3 || (positionChangedListener2 = this.positionChangedListener) == null)) {
            positionChangedListener2.dispatchChildPositionChanged(this, position3, position2);
        }
        this.position = position2;
        return position2 != HummerLayoutExtendUtils.Position.YOGA;
    }

    private boolean setDisplay(String str) {
        DisplayChangedListener displayChangedListener2;
        HummerLayoutExtendUtils.Display display2 = HummerLayoutExtendUtils.Display.YOGA;
        if (HummerLayoutExtendUtils.Display.BLOCK.value().equals(str)) {
            display2 = HummerLayoutExtendUtils.Display.BLOCK;
        }
        if (HummerLayoutExtendUtils.Display.INLINE.value().equals(str)) {
            display2 = HummerLayoutExtendUtils.Display.INLINE;
        }
        if (HummerLayoutExtendUtils.Display.INLINE_BLOCK.value().equals(str)) {
            display2 = HummerLayoutExtendUtils.Display.INLINE_BLOCK;
        }
        HummerLayoutExtendUtils.Display display3 = this.display;
        if (!(display2 == display3 || (displayChangedListener2 = this.displayChangedListener) == null)) {
            displayChangedListener2.dispatchChildDisplayChanged(this, display3, display2);
        }
        this.display = display2;
        return display2 != HummerLayoutExtendUtils.Display.YOGA;
    }

    public void handleTransitionStyle(String str, Object obj) {
        ArrayList arrayList = new ArrayList();
        if (HummerStyleUtils.Hummer.TRANSFORM.equals(str)) {
            String[] split = obj.toString().trim().replace("),", ");").split(";");
            for (String str2 : split) {
                int indexOf = str2.indexOf("(");
                arrayList.addAll(HummerAnimationUtils.parser(str2.substring(0, indexOf).trim(), HummerStyleUtils.transformValue(str2.substring(indexOf + 1, str2.indexOf(")")))));
            }
        } else {
            arrayList.addAll(HummerAnimationUtils.parser(str, obj));
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new AnimViewWrapper(this), (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[arrayList.size()]));
        getTransition(str).warpAnim(ofPropertyValuesHolder);
        if (this.objectAnimatorList == null) {
            this.objectAnimatorList = new ArrayList();
        }
        this.objectAnimatorList.add(ofPropertyValuesHolder);
    }

    public void runAnimator() {
        if (this.objectAnimatorList != null) {
            getView().post(new Runnable() {
                public void run() {
                    for (ObjectAnimator start : HMBase.this.objectAnimatorList) {
                        start.start();
                    }
                    HMBase.this.objectAnimatorList.clear();
                }
            });
        }
    }
}
