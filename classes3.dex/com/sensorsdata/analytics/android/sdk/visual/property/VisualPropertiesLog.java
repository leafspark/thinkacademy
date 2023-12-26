package com.sensorsdata.analytics.android.sdk.visual.property;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.visual.model.ViewNode;
import com.sensorsdata.analytics.android.sdk.visual.model.VisualConfig;
import com.sensorsdata.analytics.android.sdk.visual.property.VisualPropertiesManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VisualPropertiesLog implements VisualPropertiesManager.CollectLogListener {
    private Builder mBuilder;
    private JSONArray mJSONArray;
    private final Object object = new Object();

    public synchronized String getVisualPropertiesLog() {
        synchronized (this.object) {
            JSONArray jSONArray = this.mJSONArray;
            if (jSONArray == null) {
                return null;
            }
            String jSONArray2 = jSONArray.toString();
            return jSONArray2;
        }
    }

    private synchronized void add2JsonArray(JSONObject jSONObject) {
        synchronized (this.object) {
            if (this.mJSONArray == null) {
                this.mJSONArray = new JSONArray();
            }
            this.mJSONArray.put(jSONObject);
        }
    }

    public void onStart(String str, String str2, ViewNode viewNode) {
        String str3;
        String str4;
        String str5;
        if (viewNode != null) {
            String viewPath = viewNode.getViewPath();
            String viewPosition = viewNode.getViewPosition();
            str3 = viewNode.getViewContent();
            str5 = viewPath;
            str4 = viewPosition;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
        }
        this.mBuilder = new Builder(str, str2, str5, str4, str3);
    }

    public void onSwitchClose() {
        this.mBuilder.buildSwitchControl();
        add2JsonArray(this.mBuilder.build());
    }

    public void onCheckVisualConfigFailure(String str) {
        this.mBuilder.buildVisualConfig(str);
        add2JsonArray(this.mBuilder.build());
    }

    public void onCheckEventConfigFailure() {
        this.mBuilder.buildEventConfig();
        add2JsonArray(this.mBuilder.build());
    }

    public void onFindPropertyElementFailure(String str, String str2, String str3) {
        this.mBuilder.buildPropertyElement(String.format("%s 属性未找到属性元素，属性元素路径为 %s，属性元素位置为 %s ", new Object[]{str, str2, str3}));
        add2JsonArray(this.mBuilder.build());
    }

    public void onParsePropertyContentFailure(String str, String str2, String str3, String str4) {
        this.mBuilder.buildPropertyContentParse(String.format("%s 属性正则解析失败，元素内容 %s, 正则表达式为 %s,属性类型为 %s", new Object[]{str, str3, str4, str2}));
        add2JsonArray(this.mBuilder.build());
    }

    public void onOtherError(String str) {
        this.mBuilder.buildOtherError(str);
        add2JsonArray(this.mBuilder.build());
    }

    public static class Builder {
        private String elementContent;
        private String elementPath;
        private String elementPosition;
        private JSONObject eventConfig;
        private String eventType;
        private String localConfig = null;
        private JSONObject otherError;
        private JSONObject propertyContentParse;
        private JSONObject propertyElement;
        private String screenName;
        private JSONObject switchControl;
        private JSONObject visualConfig;

        Builder(String str, String str2, String str3, String str4, String str5) {
            this.eventType = str;
            this.screenName = str2;
            this.elementPath = str3;
            this.elementPosition = str4;
            this.elementContent = str5;
            VisualConfig visualConfig2 = VisualPropertiesManager.getInstance().getVisualConfig();
            if (visualConfig2 != null) {
                this.localConfig = visualConfig2.toString();
            }
        }

        /* access modifiers changed from: private */
        public void buildSwitchControl() {
            try {
                this.switchControl = new JSONObject().put("title", "开关控制").put("message", "自定义属性运维配置开关关闭");
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public void buildVisualConfig(String str) {
            try {
                this.visualConfig = new JSONObject().put("title", "获取配置").put("message", str);
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public void buildEventConfig() {
            try {
                this.eventConfig = new JSONObject().put("title", "事件配置").put("message", "本地缓存不包含该事件配置");
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public void buildPropertyElement(String str) {
            try {
                this.propertyElement = new JSONObject().put("title", "获取属性元素").put("message", str);
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public void buildPropertyContentParse(String str) {
            try {
                this.propertyContentParse = new JSONObject().put("title", "解析属性").put("message", str);
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public void buildOtherError(String str) {
            try {
                this.otherError = new JSONObject().put("title", "其他错误").put("message", str);
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
        }

        /* access modifiers changed from: private */
        public JSONObject build() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("event_type", this.eventType);
                jSONObject.put("element_path", this.elementPath);
                jSONObject.put("element_position", this.elementPosition);
                jSONObject.put("element_content", this.elementContent);
                jSONObject.put("screen_name", this.screenName);
                jSONObject.put("local_config", this.localConfig);
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = this.switchControl;
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
                JSONObject jSONObject3 = this.visualConfig;
                if (jSONObject3 != null) {
                    jSONArray.put(jSONObject3);
                }
                JSONObject jSONObject4 = this.eventConfig;
                if (jSONObject4 != null) {
                    jSONArray.put(jSONObject4);
                }
                JSONObject jSONObject5 = this.propertyElement;
                if (jSONObject5 != null) {
                    jSONArray.put(jSONObject5);
                }
                JSONObject jSONObject6 = this.propertyContentParse;
                if (jSONObject6 != null) {
                    jSONArray.put(jSONObject6);
                }
                JSONObject jSONObject7 = this.otherError;
                if (jSONObject7 != null) {
                    jSONArray.put(jSONObject7);
                }
                jSONObject.put("message", jSONArray);
            } catch (JSONException e) {
                SALog.printStackTrace(e);
            }
            return jSONObject;
        }
    }
}
