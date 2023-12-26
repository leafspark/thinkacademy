package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONObject;

public final class q extends m implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    static class a implements Parcelable.Creator<q> {
        a() {
        }

        /* renamed from: a */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        /* renamed from: a */
        public q[] newArray(int i) {
            return new q[i];
        }
    }

    q(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
    }

    protected q(Parcel parcel) {
        super(parcel);
    }
}
