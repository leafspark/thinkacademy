package com.sensorsdata.analytics.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public class SensorsDataGPSLocation {
    private String coordinate;
    private long latitude;
    private long longitude;

    public long getLatitude() {
        return this.latitude;
    }

    public void setLatitude(long j) {
        this.latitude = j;
    }

    public long getLongitude() {
        return this.longitude;
    }

    public void setLongitude(long j) {
        this.longitude = j;
    }

    public String getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(String str) {
        this.coordinate = str;
    }

    public void toJSON(JSONObject jSONObject) {
        try {
            jSONObject.put("$latitude", this.latitude);
            jSONObject.put("$longitude", this.longitude);
            jSONObject.put("$geo_coordinate_system", this.coordinate);
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
    }

    public final class CoordinateType {
        public static final String BD09 = "BD09";
        public static final String GCJ02 = "GCJ02";
        public static final String WGS84 = "WGS84";

        public CoordinateType() {
        }
    }
}
