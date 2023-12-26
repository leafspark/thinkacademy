package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public final class n extends l {
    public static final Parcelable.Creator<n> CREATOR = new a();
    private final String o;
    private final String p;
    private final String q;
    private final String r;

    static class a implements Parcelable.Creator<n> {
        a() {
        }

        /* renamed from: a */
        public n createFromParcel(Parcel parcel) {
            return new n(parcel);
        }

        /* renamed from: a */
        public n[] newArray(int i) {
            return new n[i];
        }
    }

    n(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        this.o = d(jSONObject, atd.s0.a.a(-91962503653952L));
        this.p = d(jSONObject, atd.s0.a.a(-92026928163392L));
        this.q = d(jSONObject, atd.s0.a.a(-92078467770944L));
        try {
            this.r = b(jSONObject, atd.s0.a.a(-91829359667776L));
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-91928143915584L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        n nVar = (n) obj;
        String str = this.o;
        if (str == null ? nVar.o != null : !str.equals(nVar.o)) {
            return false;
        }
        String str2 = this.p;
        if (str2 == null ? nVar.p != null : !str2.equals(nVar.p)) {
            return false;
        }
        String str3 = this.q;
        if (str3 == null ? nVar.q != null : !str3.equals(nVar.q)) {
            return false;
        }
        String str4 = this.r;
        String str5 = nVar.r;
        if (str4 != null) {
            return str4.equals(str5);
        }
        if (str5 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.o;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.p;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.q;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.r;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String n() {
        return this.o;
    }

    public String o() {
        return this.p;
    }

    public String p() {
        return this.q;
    }

    public String q() {
        return this.r;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
    }

    protected n(Parcel parcel) {
        super(parcel);
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
    }
}
