package com.didi.hummer.render.style;

import android.text.TextUtils;
import android.view.View;
import com.didi.hummer.core.engine.JSContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.core.util.DebugUtil;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.utility.YogaNodeUtil;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HummerNode implements Serializable {
    @SerializedName("alias")
    private String alias;
    @SerializedName("children")
    private List<HummerNode> children = new LinkedList();
    @SerializedName("content")
    private String content;
    @SerializedName("id")
    private String id;
    private transient HMBase linkView;
    @SerializedName("tagName")
    private String name;
    @SerializedName("objId")
    private long objId;
    @SerializedName("style")
    private Map<String, Object> style = new HashMap();
    private transient YogaNode yogaNode;

    public HummerNode(HMBase hMBase, String str) {
        this.linkView = hMBase;
        this.id = TextUtils.isEmpty(str) ? createNodeId() : str;
        this.yogaNode = getYogaNode(hMBase);
        if (DebugUtil.isDebuggable() && hMBase.getJSValue() != null) {
            this.name = hMBase.getJSValue().getString("className");
            this.objId = hMBase.getJSValue().getLong("objID");
        }
    }

    private String createNodeId() {
        return "hm_node_" + System.currentTimeMillis();
    }

    private YogaNode getYogaNode(HMBase hMBase) {
        View view = hMBase.getView();
        if (view instanceof YogaLayout) {
            return ((YogaLayout) view).getYogaNode();
        }
        YogaNode createYogaNode = YogaNodeUtil.createYogaNode();
        createYogaNode.setData(view);
        createYogaNode.setMeasureFunction(new YogaLayout.ViewMeasureFunction());
        return createYogaNode;
    }

    public void setStyle(Map<String, Object> map) {
        this.style.putAll(map);
        HummerStyleUtils.applyStyle(this.linkView, map);
    }

    public void resetStyle() {
        HummerStyleUtils.resetYogaStyle(this.linkView);
    }

    public HMBase getLinkView() {
        return this.linkView;
    }

    public YogaNode getYogaNode() {
        return this.yogaNode;
    }

    public String getId() {
        return this.id;
    }

    public long getObjId() {
        return this.objId;
    }

    public Map<String, Object> getStyle() {
        return this.style;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getContent() {
        return this.content;
    }

    public List<HummerNode> getChildren() {
        return this.children;
    }

    public void appendChild(HummerNode hummerNode) {
        this.children.add(hummerNode);
    }

    public void removeChild(HummerNode hummerNode) {
        this.children.remove(hummerNode);
    }

    public void removeAll() {
        this.children.clear();
    }

    public void insertBefore(HummerNode hummerNode, HummerNode hummerNode2) {
        int lastIndexOf = this.children.lastIndexOf(hummerNode2);
        if (lastIndexOf > 0) {
            this.children.add(lastIndexOf, hummerNode);
        }
    }

    public void replaceChild(HummerNode hummerNode, HummerNode hummerNode2) {
        int lastIndexOf = this.children.lastIndexOf(hummerNode2);
        if (lastIndexOf > 0) {
            this.children.remove(hummerNode2);
            this.children.add(lastIndexOf, hummerNode);
        }
    }

    public JSValue getJSNodeTree(int i) {
        HMBase hMBase = this.linkView;
        if (hMBase == null || hMBase.getJSValue() == null) {
            return null;
        }
        JSContext jSContext = this.linkView.getJSValue().getJSContext();
        JSValue jSValue = (JSValue) jSContext.evaluateJavaScript("new Object();");
        jSValue.set("id", (Number) Long.valueOf(this.objId));
        jSValue.set("tagName", this.name);
        jSValue.set("alias", this.alias);
        jSValue.set(FirebaseAnalytics.Param.CONTENT, this.content);
        jSValue.set("element", this.linkView.getJSValue());
        if (i > 0 && !this.children.isEmpty()) {
            JSValue jSValue2 = (JSValue) jSContext.evaluateJavaScript("new Array();");
            for (HummerNode jSNodeTree : this.children) {
                i--;
                jSValue2.callFunction("push", jSNodeTree.getJSNodeTree(i));
            }
            jSValue.set("children", jSValue2);
        }
        return jSValue;
    }
}
