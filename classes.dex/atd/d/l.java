package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.b;
import atd.e.c;
import com.adyen.threeds2.internal.d;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new a();
    private final String c;
    private final String d;
    private final String e;
    private final atd.e.a f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final g l;
    private final g m;
    private final String n;

    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* renamed from: a */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    l(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            String b = b(jSONObject, atd.s0.a.a(-94329030634048L));
            this.c = b(jSONObject, atd.s0.a.a(-94402045078080L));
            this.d = b(jSONObject, atd.s0.a.a(-93663310703168L));
            if (b.equals(d.V2_1_0.c())) {
                this.e = d(jSONObject, atd.s0.a.a(-93723440245312L));
            } else if (a() == b.OUT_OF_BAND) {
                this.e = d(jSONObject, atd.s0.a.a(-93538756651584L));
            } else {
                this.e = b(jSONObject, atd.s0.a.a(-93903828871744L));
            }
            this.f = atd.e.a.a(d(jSONObject, atd.s0.a.a(-93959663446592L)));
            this.g = d(jSONObject, atd.s0.a.a(-93809339591232L));
            this.h = d(jSONObject, atd.s0.a.a(-93092080052800L));
            this.i = d(jSONObject, atd.s0.a.a(-93139324693056L));
            this.j = d(jSONObject, atd.s0.a.a(-92915986393664L));
            this.k = d(jSONObject, atd.s0.a.a(-92984705870400L));
            this.l = g.g(jSONObject, atd.s0.a.a(-93332598221376L));
            this.m = g.g(jSONObject, atd.s0.a.a(-93384137828928L));
            String d2 = d(jSONObject, atd.s0.a.a(-93418497567296L));
            this.n = d2;
            if (d2 == null) {
                return;
            }
            if (d2.length() > 64) {
                throw new atd.a0.a(atd.s0.a.a(-93225224038976L), c.DATA_ELEMENT_INVALID_FORMAT);
            }
        } catch (JSONException e2) {
            throw new atd.a0.a(atd.s0.a.a(-92611043715648L), e2, c.DATA_ELEMENT_MISSING);
        }
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        l lVar = (l) obj;
        if (atd.r0.d.a(this.c, lVar.c) && atd.r0.d.a(this.d, lVar.d) && atd.r0.d.a(this.e, lVar.e) && this.f == lVar.f) {
            return atd.r0.d.a(this.g, lVar.g);
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public g g() {
        return this.l;
    }

    public g h() {
        return this.m;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.c;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        atd.e.a aVar = this.f;
        int hashCode5 = (hashCode4 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        String str4 = this.g;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode5 + i2;
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.n;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.i;
    }

    public boolean m() {
        return this.f.b();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f.name());
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeParcelable(this.l, i2);
        parcel.writeParcelable(this.m, i2);
        parcel.writeString(this.n);
    }

    protected l(Parcel parcel) {
        super(parcel);
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        try {
            this.f = atd.e.a.a(parcel.readString());
            this.g = parcel.readString();
            this.h = parcel.readString();
            this.i = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = (g) parcel.readParcelable(g.class.getClassLoader());
            this.m = (g) parcel.readParcelable(g.class.getClassLoader());
            this.n = parcel.readString();
        } catch (atd.a0.a e2) {
            throw new RuntimeException(e2.getMessage(), e2);
        }
    }
}
