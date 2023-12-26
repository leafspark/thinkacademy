package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public class m extends l {
    public static final Parcelable.Creator<m> CREATOR = new a();
    private final String o;

    static class a implements Parcelable.Creator<m> {
        a() {
        }

        /* renamed from: a */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        /* renamed from: a */
        public m[] newArray(int i) {
            return new m[i];
        }
    }

    m(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            this.o = b(jSONObject, atd.s0.a.a(-92465014827584L));
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-92868741753408L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        m mVar = (m) obj;
        String str = this.o;
        if (str != null) {
            return str.equals(mVar.o);
        }
        if (mVar.o == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.o;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String n() {
        return this.o;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.o);
    }

    protected m(Parcel parcel) {
        super(parcel);
        this.o = parcel.readString();
    }
}
