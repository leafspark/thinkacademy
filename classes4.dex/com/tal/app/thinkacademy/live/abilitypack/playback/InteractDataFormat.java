package com.tal.app.thinkacademy.live.abilitypack.playback;

import com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/InteractDataFormat;", "", "()V", "KEY_FILL_BLANK", "", "KEY_GAME_INTERACT", "KEY_INTERACT", "format", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/InteractData;", "ircType", "ircMsg", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractDataFormat.kt */
public final class InteractDataFormat {
    public static final InteractDataFormat INSTANCE = new InteractDataFormat();
    private static final String KEY_FILL_BLANK = "fill_blank";
    private static final String KEY_GAME_INTERACT = "game_interact";
    private static final String KEY_INTERACT = "interact";

    private InteractDataFormat() {
    }

    public final InteractData format(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "ircMsg");
        int hashCode = str.hashCode();
        if (hashCode == -825898013 ? !str.equals("game_interact") : !(hashCode == -249005160 ? str.equals(KEY_FILL_BLANK) : hashCode == 570398262 && str.equals("interact"))) {
            return null;
        }
        JSONObject optJSONObject = new JSONObject(str2).optJSONObject(str);
        if (optJSONObject == null) {
            return null;
        }
        String optString = optJSONObject.optString("interactId");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"interactId\")");
        return new InteractData(str, optString, optJSONObject.optBoolean("publishTopic") || optJSONObject.optBoolean("pub"));
    }
}
