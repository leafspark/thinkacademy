package com.tal.app.thinkacademy.live.business.emoji.util;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.google.gson.internal.LinkedTreeMap;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/util/EmojiBeanUtil;", "", "()V", "toEmojiBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "message", "", "toEmojiJsonString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiBeanUtil.kt */
public final class EmojiBeanUtil {
    public static final EmojiBeanUtil INSTANCE = new EmojiBeanUtil();

    private EmojiBeanUtil() {
    }

    public final EmojiBean<?> toEmojiBean(String str) {
        EmojiBean<?> emojiBean;
        try {
            MsgBean msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str, new EmojiBeanUtil$toEmojiBean$type$1().getType());
            if (msgBean == null || msgBean.getData() == null || msgBean.getFrom() == null) {
                return null;
            }
            int type = ((EmojiBean) msgBean.getData()).getType();
            if (type == 1) {
                MsgBean msgBean2 = (MsgBean) GsonUtil.getInstance().fromJson(str, new EmojiBeanUtil$toEmojiBean$newType$1().getType());
                if (msgBean2 == null) {
                    return null;
                }
                emojiBean = (EmojiBean) msgBean2.getData();
            } else if (type == 2) {
                MsgBean msgBean3 = (MsgBean) GsonUtil.getInstance().fromJson(str, new EmojiBeanUtil$toEmojiBean$newType$2().getType());
                if (msgBean3 == null) {
                    return null;
                }
                emojiBean = (EmojiBean) msgBean3.getData();
            } else if (type != 3) {
                return null;
            } else {
                MsgBean msgBean4 = (MsgBean) GsonUtil.getInstance().fromJson(str, new EmojiBeanUtil$toEmojiBean$newType$3().getType());
                if (msgBean4 == null) {
                    return null;
                }
                emojiBean = (EmojiBean) msgBean4.getData();
            }
            return emojiBean;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String toEmojiJsonString(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "";
        }
        try {
            MsgBean msgBean = (MsgBean) GsonUtils.fromJson(str, MsgBean.class);
            if (msgBean == null) {
                return "";
            }
            Object data = msgBean.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject((LinkedTreeMap) data);
                String json = GsonUtils.toJson((EmojiBean) GsonUtils.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), EmojiBean.class));
                Intrinsics.checkNotNullExpressionValue(json, "toJson(bean)");
                return json;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.google.gson.internal.LinkedTreeMap<*, *>");
        } catch (Exception unused) {
            return "";
        }
    }
}
