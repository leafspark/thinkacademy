package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends m {
    public static final Parcelable.Creator<o> CREATOR = new a();
    private final List<p> p;

    static class a implements Parcelable.Creator<o> {
        a() {
        }

        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* renamed from: a */
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    o(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            List<p> a2 = p.a(jSONObject.getJSONArray(atd.s0.a.a(-92353345677888L)));
            this.p = a2;
            if (a2.isEmpty()) {
                throw new atd.a0.a(atd.s0.a.a(-92164367116864L), c.DATA_ELEMENT_MISSING);
            }
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-91421337774656L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        List<p> list = this.p;
        List<p> list2 = ((o) obj).p;
        if (list != null) {
            return list.equals(list2);
        }
        if (list2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        List<p> list = this.p;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public List<p> o() {
        return this.p;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.p);
    }

    protected o(Parcel parcel) {
        super(parcel);
        this.p = parcel.createTypedArrayList(p.CREATOR);
    }
}
