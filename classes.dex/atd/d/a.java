package atd.d;

import android.os.Parcel;
import android.os.Parcelable;
import atd.e.c;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends k implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0002a();
    private final atd.e.b a;
    private final atd.e.a b;

    /* renamed from: atd.d.a$a  reason: collision with other inner class name */
    static class C0002a implements Parcelable.Creator<a> {
        C0002a() {
        }

        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                atd.e.b[] r0 = atd.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.e.b r1 = atd.e.b.SINGLE_TEXT_INPUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.e.b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                atd.e.b r1 = atd.e.b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                atd.e.b r1 = atd.e.b.OUT_OF_BAND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                atd.e.b r1 = atd.e.b.HTML_UI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.d.a.b.<clinit>():void");
        }
    }

    a(JSONObject jSONObject) throws atd.a0.a {
        super(jSONObject);
        try {
            this.a = atd.e.b.a(jSONObject.getInt(atd.s0.a.a(-99311192697408L)));
            this.b = atd.e.a.a(b(jSONObject, atd.s0.a.a(-99336962501184L)));
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-98619702962752L), e, c.DATA_ELEMENT_MISSING);
        }
    }

    public static a a(JSONObject jSONObject) throws atd.a0.a {
        try {
            int i = jSONObject.getInt(atd.s0.a.a(-99379912174144L));
            int i2 = b.a[atd.e.b.a(i).ordinal()];
            if (i2 == 1) {
                return new q(jSONObject);
            }
            if (i2 == 2 || i2 == 3) {
                return new o(jSONObject);
            }
            if (i2 == 4) {
                return new n(jSONObject);
            }
            if (i2 == 5) {
                return new f(jSONObject);
            }
            throw new RuntimeException(atd.s0.a.a(-99482991389248L) + i);
        } catch (JSONException e) {
            throw new atd.a0.a(atd.s0.a.a(-99405681977920L), e, c.MESSAGE_RECEIVED_INVALID);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a != aVar.a) {
            return false;
        }
        if (this.b == aVar.b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        atd.e.b bVar = this.a;
        int i = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        atd.e.a aVar = this.b;
        if (aVar != null) {
            i = aVar.hashCode();
        }
        return hashCode + i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.a());
        parcel.writeString(this.b.name());
    }

    protected a(Parcel parcel) {
        super(parcel);
        try {
            this.a = atd.e.b.a(parcel.readInt());
            this.b = atd.e.a.a(parcel.readString());
        } catch (atd.a0.a e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public atd.e.b a() {
        return this.a;
    }
}
