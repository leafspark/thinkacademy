package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class p extends k implements Parcelable {
    public static final Parcelable.Creator<p> CREATOR = new a();
    private final String a;
    private final String b;

    static class a implements Parcelable.Creator<p> {
        a() {
        }

        /* renamed from: a */
        public p createFromParcel(Parcel parcel) {
            return new p(parcel);
        }

        /* renamed from: a */
        public p[] newArray(int i) {
            return new p[i];
        }
    }

    p(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        String next = jSONObject.keys().next();
        this.a = next;
        this.b = jSONObject.getString(next);
    }

    static List<p> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new p(jSONArray.getJSONObject(i)));
        }
        return arrayList;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        String str = this.a;
        if (str == null ? pVar.a != null : !str.equals(pVar.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = pVar.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
    }

    protected p(Parcel parcel) {
        super(parcel);
        this.a = parcel.readString();
        this.b = parcel.readString();
    }

    public String a() {
        return this.a;
    }
}
