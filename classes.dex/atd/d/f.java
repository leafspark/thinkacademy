package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new a();
    private final String c;
    private final String d;

    static class a implements Parcelable.Creator<f> {
        a() {
        }

        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    f(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            this.c = b(jSONObject, atd.s0.a.a(-97674810157632L));
            this.d = d(jSONObject, atd.s0.a.a(-97709169896000L));
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-96957550619200L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f) || !super.equals(obj)) {
            return false;
        }
        f fVar = (f) obj;
        String str = this.c;
        if (str == null ? fVar.c != null : !str.equals(fVar.c)) {
            return false;
        }
        String str2 = this.d;
        String str3 = fVar.d;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.c;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
    }

    protected f(Parcel parcel) {
        super(parcel);
        this.c = parcel.readString();
        this.d = parcel.readString();
    }
}
