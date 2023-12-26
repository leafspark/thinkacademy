package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SADataHelper {
    private static final Pattern KEY_PATTERN = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);
    private static final String TAG = "SA.SADataHelper";
    private static final String[] WHITE_LIST = {"sensorsdata_app_visual_properties"};

    public static void assertPropertyTypes(JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                assertKey(next);
                try {
                    Object obj = jSONObject.get(next);
                    if (obj == JSONObject.NULL) {
                        keys.remove();
                    } else {
                        int i = 0;
                        if (obj instanceof List) {
                            List list = (List) obj;
                            int size = list.size();
                            JSONArray jSONArray = new JSONArray();
                            for (int i2 = 0; i2 < size; i2++) {
                                jSONArray.put(list.get(i2));
                            }
                            jSONObject.put(next, jSONArray);
                            obj = jSONArray;
                        }
                        if (!(obj instanceof CharSequence)) {
                            if (!(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean)) {
                                if (!(obj instanceof Date)) {
                                    throw new InvalidDataException("The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date/List<String>. [key='" + next + "', value='" + obj.toString() + "', class='" + obj.getClass().getCanonicalName() + "']");
                                }
                            }
                        }
                        if (obj instanceof JSONArray) {
                            JSONArray jSONArray2 = (JSONArray) obj;
                            int length = jSONArray2.length();
                            while (i < length) {
                                if (jSONArray2.get(i) instanceof CharSequence) {
                                    i++;
                                } else {
                                    throw new InvalidDataException("The array property value must be an instance of List<String> or JSONArray only contains String. [key='" + next + "', value='" + obj.toString() + "']");
                                }
                            }
                            continue;
                        } else if ("app_crashed_reason".equals(next)) {
                            if ((obj instanceof String) && ((String) obj).length() > 16382) {
                                jSONObject.put(next, ((String) obj).substring(0, 16382) + "$");
                                SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                            }
                        } else if (!Arrays.asList(WHITE_LIST).contains(next) && (obj instanceof String) && ((String) obj).length() > 8191) {
                            jSONObject.put(next, ((String) obj).substring(0, 8191) + "$");
                            SALog.d(TAG, "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                        }
                    }
                } catch (JSONException unused) {
                    throw new InvalidDataException("Unexpected property key. [key='" + next + "']");
                }
            }
        }
    }

    public static void assertKey(String str) throws InvalidDataException {
        if (str == null || str.length() < 1) {
            throw new InvalidDataException("The key is empty.");
        } else if (!KEY_PATTERN.matcher(str).matches()) {
            throw new InvalidDataException("The key '" + str + "' is invalid.");
        }
    }

    public static void assertValue(String str) throws InvalidDataException {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidDataException("The value is empty.");
        } else if (str.length() > 255) {
            throw new InvalidDataException("The " + str + " is too long, max length is 255.");
        }
    }

    public static String assertPropertyLength(String str) {
        if (str == null || str.length() <= 8191) {
            return str;
        }
        String str2 = str.substring(0, 8191) + "$";
        SALog.d(TAG, "The property value is too long. property=" + str2);
        return str2;
    }

    public static JSONObject appendLibMethodAutoTrack(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("$lib_method", "autoTrack");
        } catch (JSONException e) {
            SALog.printStackTrace(e);
        }
        return jSONObject;
    }
}
