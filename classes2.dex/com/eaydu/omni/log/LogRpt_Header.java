package com.eaydu.omni.log;

import android.content.Context;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogRpt_Header implements Cloneable {
    String agent = "";
    String appId = "";
    String arch = "";
    String cip = "";
    float cpu = 0.0f;
    String dev = DeviceInfo.getDeviceName();
    int engineId = 0;
    String lip = "";
    float mem = 0.0f;
    int net = 10;
    String os = "";
    int pri = 320;
    String psId = "";
    int ram = 0;
    int serv = 320;
    String sip = "";
    String tid = "";
    long ts = 0;
    int version = 1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void refuresh(Context context) {
        this.arch = DeviceInfo.getCpuArch();
        this.ram = DeviceInfo.getMemTotal();
        this.dev = DeviceInfo.getDeviceName();
        try {
            this.net = NetUtils.getNetworkType(context);
            float memRatio = (float) (DeviceInfo.getMemRatio() * 100.0d);
            this.mem = memRatio;
            if (memRatio > 100.0f) {
                this.mem = 100.0f;
            }
        } catch (Exception unused) {
        }
    }

    public void flushNet(Context context) {
        try {
            this.net = NetUtils.getNetworkType(context);
        } catch (Exception unused) {
        }
    }

    public String toString(JSONArray jSONArray) {
        this.ts = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serv", this.serv);
            jSONObject.put("pri", this.pri);
            jSONObject.put("ts", this.ts);
            jSONObject.put("appId", this.appId);
            jSONObject.put("psId", this.psId);
            jSONObject.put("agent", this.agent);
            jSONObject.put("os", this.os);
            jSONObject.put("dev", this.dev);
            jSONObject.put("arch", this.arch);
            jSONObject.put("ram", this.ram);
            jSONObject.put("net", this.net);
            jSONObject.put("cpu", (double) this.cpu);
            jSONObject.put("mem", (double) this.mem);
            jSONObject.put("cip", this.cip);
            jSONObject.put("lip", this.lip);
            jSONObject.put("sip", this.sip);
            jSONObject.put("tid", this.tid);
            jSONObject.put("engineid", this.engineId);
            jSONObject.put("pridata", jSONArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString(JSONObject jSONObject) {
        this.ts = System.currentTimeMillis();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("serv", this.serv);
            jSONObject2.put("pri", this.pri);
            jSONObject2.put("ts", this.ts);
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("psId", this.psId);
            jSONObject2.put("agent", this.agent);
            jSONObject2.put("os", "Android" + this.os);
            jSONObject2.put("dev", this.dev);
            jSONObject2.put("arch", this.arch);
            jSONObject2.put("ram", this.ram);
            jSONObject2.put("net", this.net);
            jSONObject2.put("cpu", (double) this.cpu);
            jSONObject2.put("mem", (double) this.mem);
            jSONObject2.put("cip", this.cip);
            jSONObject2.put("lip", this.lip);
            jSONObject2.put("sip", this.sip);
            jSONObject2.put("tid", this.tid);
            jSONObject2.put("engineid", this.engineId);
            if (jSONObject.length() > 0) {
                jSONObject2.put("pridata", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
    }

    public JSONObject toJson(JSONObject jSONObject) {
        this.ts = System.currentTimeMillis();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("serv", this.serv);
            jSONObject2.put("pri", this.pri);
            jSONObject2.put("ts", this.ts);
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("psId", this.psId);
            jSONObject2.put("agent", this.agent);
            jSONObject2.put("os", "Android" + this.os);
            jSONObject2.put("dev", this.dev);
            jSONObject2.put("arch", this.arch);
            jSONObject2.put("ram", this.ram);
            jSONObject2.put("net", this.net);
            jSONObject2.put("cpu", (double) this.cpu);
            jSONObject2.put("mem", (double) this.mem);
            jSONObject2.put("cip", this.cip);
            jSONObject2.put("lip", this.lip);
            jSONObject2.put("sip", this.sip);
            jSONObject2.put("tid", this.tid);
            jSONObject2.put("engineid", this.engineId);
            if (jSONObject.length() > 0) {
                jSONObject2.put("pridata", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject2;
    }
}
