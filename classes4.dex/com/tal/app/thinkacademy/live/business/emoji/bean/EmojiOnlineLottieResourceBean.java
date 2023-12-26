package com.tal.app.thinkacademy.live.business.emoji.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiOnlineLottieResourceBean;", "Ljava/io/Serializable;", "jsonUrl", "", "(Ljava/lang/String;)V", "getJsonUrl", "()Ljava/lang/String;", "setJsonUrl", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiOnlineLottieResourceBean.kt */
public final class EmojiOnlineLottieResourceBean implements Serializable {
    @SerializedName("lottieUrl")
    private String jsonUrl;

    public EmojiOnlineLottieResourceBean() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EmojiOnlineLottieResourceBean copy$default(EmojiOnlineLottieResourceBean emojiOnlineLottieResourceBean, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiOnlineLottieResourceBean.jsonUrl;
        }
        return emojiOnlineLottieResourceBean.copy(str);
    }

    public final String component1() {
        return this.jsonUrl;
    }

    public final EmojiOnlineLottieResourceBean copy(String str) {
        return new EmojiOnlineLottieResourceBean(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmojiOnlineLottieResourceBean) && Intrinsics.areEqual(this.jsonUrl, ((EmojiOnlineLottieResourceBean) obj).jsonUrl);
    }

    public int hashCode() {
        String str = this.jsonUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "EmojiOnlineLottieResourceBean(jsonUrl=" + this.jsonUrl + ')';
    }

    public EmojiOnlineLottieResourceBean(String str) {
        this.jsonUrl = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmojiOnlineLottieResourceBean(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getJsonUrl() {
        return this.jsonUrl;
    }

    public final void setJsonUrl(String str) {
        this.jsonUrl = str;
    }
}
