package com.sensorsdata.analytics.android.sdk.visual.snap;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.visual.ViewSnapshot;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditProtocol {
    private static final Class<?>[] NO_PARAMS = new Class[0];
    private static final String TAG = "SA.EProtocol";
    private final ResourceIds mResourceIds;

    public EditProtocol(ResourceIds resourceIds) {
        this.mResourceIds = resourceIds;
    }

    public ViewSnapshot readSnapshotConfig(JSONObject jSONObject) throws BadInstructionsException {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONObject("config").getJSONArray("classes");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                Class<?> cls = Class.forName(jSONObject2.getString("name"));
                JSONArray jSONArray2 = jSONObject2.getJSONArray("properties");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(readPropertyDescription(cls, jSONArray2.getJSONObject(i2)));
                }
            }
            return new ViewSnapshot(arrayList, this.mResourceIds);
        } catch (JSONException e) {
            throw new BadInstructionsException("Can't read snapshot configuration", e);
        } catch (ClassNotFoundException e2) {
            throw new BadInstructionsException("Can't resolve types for snapshot configuration", e2);
        }
    }

    private PropertyDescription readPropertyDescription(Class<?> cls, JSONObject jSONObject) throws BadInstructionsException {
        Caller caller;
        try {
            String string = jSONObject.getString("name");
            String str = null;
            if (jSONObject.has("get")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                caller = new Caller(cls, jSONObject2.getString("selector"), NO_PARAMS, Class.forName(jSONObject2.getJSONObject(DbParams.KEY_CHANNEL_RESULT).getString(ClassParamsKt.TYPE)));
            } else {
                caller = null;
            }
            if (jSONObject.has("set")) {
                str = jSONObject.getJSONObject("set").getString("selector");
            }
            return new PropertyDescription(string, cls, caller, str);
        } catch (NoSuchMethodException e) {
            throw new BadInstructionsException("Can't create property reader", e);
        } catch (JSONException e2) {
            throw new BadInstructionsException("Can't read property JSON", e2);
        } catch (ClassNotFoundException e3) {
            throw new BadInstructionsException("Can't read property JSON, relevant arg/return class not found", e3);
        }
    }

    public static class BadInstructionsException extends Exception {
        private static final long serialVersionUID = -4062004792184145311L;

        public BadInstructionsException(String str) {
            super(str);
        }

        public BadInstructionsException(String str, Throwable th) {
            super(str, th);
        }
    }
}
