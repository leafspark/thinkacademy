package atd.d;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import atd.e.c;
import org.json.JSONObject;

public final class g extends k implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();
    private final Uri a;
    private final Uri b;
    private final Uri c;

    static class a implements Parcelable.Creator<g> {
        a() {
        }

        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* renamed from: a */
        public g[] newArray(int i) {
            return new g[i];
        }
    }

    g(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        Uri e = e(jSONObject, atd.s0.a.a(-97189478853184L));
        this.a = e;
        Uri e2 = e(jSONObject, atd.s0.a.a(-97228133558848L));
        this.b = e2;
        Uri e3 = e(jSONObject, atd.s0.a.a(-97241018460736L));
        this.c = e3;
        if (e == null && e2 == null && e3 == null) {
            throw new atd.a0.a(atd.s0.a.a(-97301148002880L), c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    public static g g(JSONObject jSONObject, String str) throws atd.a0.a {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        try {
            return new g(optJSONObject);
        } catch (atd.a0.a e) {
            throw new atd.a0.a(atd.s0.a.a(-96820111665728L) + str, e, c.DATA_ELEMENT_INVALID_FORMAT);
        }
    }

    public Uri a() {
        return this.c;
    }

    public Uri b() {
        return this.b;
    }

    public Uri c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        Uri uri = this.a;
        if (uri == null ? gVar.a != null : !uri.equals(gVar.a)) {
            return false;
        }
        Uri uri2 = this.b;
        if (uri2 == null ? gVar.b != null : !uri2.equals(gVar.b)) {
            return false;
        }
        Uri uri3 = this.c;
        Uri uri4 = gVar.c;
        if (uri3 != null) {
            return uri3.equals(uri4);
        }
        if (uri4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Uri uri = this.a;
        int i = 0;
        int hashCode = (uri != null ? uri.hashCode() : 0) * 31;
        Uri uri2 = this.b;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Uri uri3 = this.c;
        if (uri3 != null) {
            i = uri3.hashCode();
        }
        return hashCode2 + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a(parcel, this.a);
        a(parcel, this.b);
        a(parcel, this.c);
    }

    private Uri a(Parcel parcel) {
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            return Uri.parse(readString);
        }
        return null;
    }

    private void a(Parcel parcel, Uri uri) {
        if (uri != null) {
            parcel.writeString(uri.toString());
        } else {
            parcel.writeString((String) null);
        }
    }

    protected g(Parcel parcel) {
        super(parcel);
        this.a = a(parcel);
        this.b = a(parcel);
        this.c = a(parcel);
    }
}
