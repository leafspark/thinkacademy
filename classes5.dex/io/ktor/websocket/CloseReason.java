package io.ktor.websocket;

import com.tekartik.sqflite.Constant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/ktor/websocket/CloseReason;", "", "code", "Lio/ktor/websocket/CloseReason$Codes;", "message", "", "(Lio/ktor/websocket/CloseReason$Codes;Ljava/lang/String;)V", "", "(SLjava/lang/String;)V", "getCode", "()S", "knownReason", "getKnownReason", "()Lio/ktor/websocket/CloseReason$Codes;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Codes", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CloseReason.kt */
public final class CloseReason {
    private final short code;
    private final String message;

    public static /* synthetic */ CloseReason copy$default(CloseReason closeReason, short s, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            s = closeReason.code;
        }
        if ((i & 2) != 0) {
            str = closeReason.message;
        }
        return closeReason.copy(s, str);
    }

    public final short component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final CloseReason copy(short s, String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
        return new CloseReason(s, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloseReason)) {
            return false;
        }
        CloseReason closeReason = (CloseReason) obj;
        return this.code == closeReason.code && Intrinsics.areEqual(this.message, closeReason.message);
    }

    public int hashCode() {
        return (this.code * 31) + this.message.hashCode();
    }

    public CloseReason(short s, String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
        this.code = s;
        this.message = str;
    }

    public final short getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CloseReason(Codes codes, String str) {
        this(codes.getCode(), str);
        Intrinsics.checkNotNullParameter(codes, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
    }

    public final Codes getKnownReason() {
        return Codes.Companion.byCode(this.code);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CloseReason(reason=");
        Object knownReason = getKnownReason();
        if (knownReason == null) {
            knownReason = Short.valueOf(this.code);
        }
        sb.append(knownReason);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(')');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\n\n\u0002\b\u0011\b\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes;", "", "code", "", "(Ljava/lang/String;IS)V", "getCode", "()S", "NORMAL", "GOING_AWAY", "PROTOCOL_ERROR", "CANNOT_ACCEPT", "CLOSED_ABNORMALLY", "NOT_CONSISTENT", "VIOLATED_POLICY", "TOO_BIG", "NO_EXTENSION", "INTERNAL_ERROR", "SERVICE_RESTART", "TRY_AGAIN_LATER", "Companion", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CloseReason.kt */
    public enum Codes {
        NORMAL(1000),
        GOING_AWAY(1001),
        PROTOCOL_ERROR(1002),
        CANNOT_ACCEPT(1003),
        CLOSED_ABNORMALLY(1006),
        NOT_CONSISTENT(1007),
        VIOLATED_POLICY(1008),
        TOO_BIG(1009),
        NO_EXTENSION(1010),
        INTERNAL_ERROR(1011),
        SERVICE_RESTART(1012),
        TRY_AGAIN_LATER(1013);
        
        public static final Companion Companion = null;
        public static final Codes UNEXPECTED_CONDITION = null;
        /* access modifiers changed from: private */
        public static final Map<Short, Codes> byCodeMap = null;
        private final short code;

        private Codes(short s) {
            this.code = s;
        }

        public final short getCode() {
            return this.code;
        }

        static {
            int i;
            Companion = new Companion((DefaultConstructorMarker) null);
            Codes[] values = values();
            Map<Short, Codes> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (Codes codes : values) {
                linkedHashMap.put(Short.valueOf(codes.code), codes);
            }
            byCodeMap = linkedHashMap;
            UNEXPECTED_CONDITION = INTERNAL_ERROR;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\n\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/ktor/websocket/CloseReason$Codes$Companion;", "", "()V", "UNEXPECTED_CONDITION", "Lio/ktor/websocket/CloseReason$Codes;", "getUNEXPECTED_CONDITION$annotations", "byCodeMap", "", "", "byCode", "code", "ktor-websockets"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: CloseReason.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Deprecated(message = "Use INTERNAL_ERROR instead.", replaceWith = @ReplaceWith(expression = "INTERNAL_ERROR", imports = {"io.ktor.websocket.CloseReason.Codes.INTERNAL_ERROR"}))
            public static /* synthetic */ void getUNEXPECTED_CONDITION$annotations() {
            }

            private Companion() {
            }

            public final Codes byCode(short s) {
                return (Codes) Codes.byCodeMap.get(Short.valueOf(s));
            }
        }
    }
}
