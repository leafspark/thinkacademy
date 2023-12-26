package com.tal.app.thinkacademy.live.business.collectivespeech.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/collectivespeech/bean/SpeechChannelBean;", "", "pub", "", "planId", "", "interactId", "currentTime", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCurrentTime", "()Ljava/lang/String;", "getInteractId", "getPlanId", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/collectivespeech/bean/SpeechChannelBean;", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeechChannelBean.kt */
public final class SpeechChannelBean {
    private final String currentTime;
    private final String interactId;
    private final String planId;
    private final Boolean pub;

    public SpeechChannelBean() {
        this((Boolean) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SpeechChannelBean copy$default(SpeechChannelBean speechChannelBean, Boolean bool, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = speechChannelBean.pub;
        }
        if ((i & 2) != 0) {
            str = speechChannelBean.planId;
        }
        if ((i & 4) != 0) {
            str2 = speechChannelBean.interactId;
        }
        if ((i & 8) != 0) {
            str3 = speechChannelBean.currentTime;
        }
        return speechChannelBean.copy(bool, str, str2, str3);
    }

    public final Boolean component1() {
        return this.pub;
    }

    public final String component2() {
        return this.planId;
    }

    public final String component3() {
        return this.interactId;
    }

    public final String component4() {
        return this.currentTime;
    }

    public final SpeechChannelBean copy(Boolean bool, String str, String str2, String str3) {
        return new SpeechChannelBean(bool, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeechChannelBean)) {
            return false;
        }
        SpeechChannelBean speechChannelBean = (SpeechChannelBean) obj;
        return Intrinsics.areEqual(this.pub, speechChannelBean.pub) && Intrinsics.areEqual(this.planId, speechChannelBean.planId) && Intrinsics.areEqual(this.interactId, speechChannelBean.interactId) && Intrinsics.areEqual(this.currentTime, speechChannelBean.currentTime);
    }

    public int hashCode() {
        Boolean bool = this.pub;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.planId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.interactId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currentTime;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SpeechChannelBean(pub=" + this.pub + ", planId=" + this.planId + ", interactId=" + this.interactId + ", currentTime=" + this.currentTime + ')';
    }

    public SpeechChannelBean(Boolean bool, String str, String str2, String str3) {
        this.pub = bool;
        this.planId = str;
        this.interactId = str2;
        this.currentTime = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SpeechChannelBean(Boolean bool, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final String getCurrentTime() {
        return this.currentTime;
    }
}
