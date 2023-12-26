package com.sensorsdata.analytics.android.sdk;

import org.json.JSONException;
import org.json.JSONObject;

public interface SensorsExpandableListViewItemTrackProperties {
    JSONObject getSensorsChildItemTrackProperties(int i, int i2) throws JSONException;

    JSONObject getSensorsGroupItemTrackProperties(int i) throws JSONException;
}
