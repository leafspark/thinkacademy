package atd.d;

import android.net.Uri;
import android.os.Parcel;
import atd.a0.a;
import atd.e.c;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class k {
    k(JSONObject jSONObject) {
    }

    /* access modifiers changed from: package-private */
    public int a(JSONObject jSONObject, String str) throws a, JSONException {
        try {
            return jSONObject.getInt(str);
        } catch (NumberFormatException e) {
            throw new a(atd.s0.a.a(-94895966317120L) + str, e, c.DATA_ELEMENT_MISSING);
        }
    }

    /* access modifiers changed from: package-private */
    public String b(JSONObject jSONObject, String str) throws a, JSONException {
        String string = jSONObject.getString(str);
        a(str, string, c.DATA_ELEMENT_MISSING);
        return string;
    }

    /* access modifiers changed from: package-private */
    public String c(JSONObject jSONObject, String str) throws a, JSONException {
        String string = jSONObject.getString(str);
        a(str, string, c.DATA_ELEMENT_MISSING);
        return a(str, string);
    }

    /* access modifiers changed from: package-private */
    public String d(JSONObject jSONObject, String str) throws a {
        String optString = jSONObject.optString(str, (String) null);
        a(str, optString, c.DATA_ELEMENT_INVALID_FORMAT);
        return optString;
    }

    /* access modifiers changed from: package-private */
    public Uri e(JSONObject jSONObject, String str) throws a {
        String optString = jSONObject.optString(str, (String) null);
        if (optString == null) {
            return null;
        }
        a(str, optString, c.DATA_ELEMENT_INVALID_FORMAT);
        Uri parse = Uri.parse(optString);
        if (parse.toString().equalsIgnoreCase(optString)) {
            return parse;
        }
        throw new a(atd.s0.a.a(-94191591680576L) + str, c.DATA_ELEMENT_INVALID_FORMAT);
    }

    /* access modifiers changed from: package-private */
    public String f(JSONObject jSONObject, String str) throws a {
        String optString = jSONObject.optString(str, (String) null);
        a(str, optString, c.DATA_ELEMENT_INVALID_FORMAT);
        if (optString == null) {
            return null;
        }
        return a(str, optString);
    }

    protected k(Parcel parcel) {
    }

    private String a(String str, String str2) throws a {
        try {
            if (UUID.fromString(str2).toString().equalsIgnoreCase(str2)) {
                return str2;
            }
            throw new a(atd.s0.a.a(-94118577236544L) + str, c.DATA_ELEMENT_INVALID_FORMAT);
        } catch (IllegalArgumentException e) {
            throw new a(atd.s0.a.a(-94019792988736L) + str, e, c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    private void a(String str, String str2, c cVar) throws a {
        if (str2 != null && str2.length() == 0) {
            throw new a(atd.s0.a.a(-94492239391296L) + str, cVar);
        }
    }
}
