package com.tal.app.thinkacademy.live.core.live.http.response;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ%\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J/\u0010\r\u001a\u00020\u00002$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH\u0016R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/response/ClassroomDataEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "keyValPair", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "getKeyValPair", "()Ljava/util/HashMap;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassroomDataEntity.kt */
public final class ClassroomDataEntity implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private final HashMap<String, String> keyValPair;

    public static /* synthetic */ ClassroomDataEntity copy$default(ClassroomDataEntity classroomDataEntity, HashMap<String, String> hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = classroomDataEntity.keyValPair;
        }
        return classroomDataEntity.copy(hashMap);
    }

    public final HashMap<String, String> component1() {
        return this.keyValPair;
    }

    public final ClassroomDataEntity copy(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "keyValPair");
        return new ClassroomDataEntity(hashMap);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClassroomDataEntity) && Intrinsics.areEqual((Object) this.keyValPair, (Object) ((ClassroomDataEntity) obj).keyValPair);
    }

    public int hashCode() {
        return this.keyValPair.hashCode();
    }

    public String toString() {
        return "ClassroomDataEntity(keyValPair=" + this.keyValPair + ')';
    }

    public ClassroomDataEntity(HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "keyValPair");
        this.keyValPair = hashMap;
    }

    public final HashMap<String, String> getKeyValPair() {
        return this.keyValPair;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassroomDataEntity(final Parcel parcel) {
        this((HashMap<String, String>) (HashMap) new Function0<HashMap<String, String>>() {
            public final HashMap<String, String> invoke() {
                int readInt = parcel.readInt();
                HashMap<String, String> hashMap = new HashMap<>();
                int i = 1;
                if (1 <= readInt) {
                    while (true) {
                        int i2 = i + 1;
                        String readString = parcel.readString();
                        String str = "";
                        if (readString == null) {
                            readString = str;
                        }
                        String readString2 = parcel.readString();
                        if (readString2 != null) {
                            str = readString2;
                        }
                        hashMap.put(readString, str);
                        if (i == readInt) {
                            break;
                        }
                        i = i2;
                    }
                }
                return hashMap;
            }
        });
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.keyValPair.size());
        for (Map.Entry entry : this.keyValPair.entrySet()) {
            parcel.writeString((String) entry.getKey());
            parcel.writeString((String) entry.getValue());
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/http/response/ClassroomDataEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/ClassroomDataEntity;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tal/app/thinkacademy/live/core/live/http/response/ClassroomDataEntity;", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClassroomDataEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<ClassroomDataEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public ClassroomDataEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ClassroomDataEntity(parcel);
        }

        public ClassroomDataEntity[] newArray(int i) {
            return new ClassroomDataEntity[i];
        }
    }
}
