package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean;", "Ljava/io/Serializable;", "mateInfoUrl", "", "graffiti", "Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean$Graffiti;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean$Graffiti;)V", "getGraffiti", "()Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean$Graffiti;", "setGraffiti", "(Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean$Graffiti;)V", "getMateInfoUrl", "()Ljava/lang/String;", "setMateInfoUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Graffiti", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaybackOfflineBean.kt */
public final class PlaybackOfflineBean implements Serializable {
    private Graffiti graffiti;
    private String mateInfoUrl;

    public static /* synthetic */ PlaybackOfflineBean copy$default(PlaybackOfflineBean playbackOfflineBean, String str, Graffiti graffiti2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = playbackOfflineBean.mateInfoUrl;
        }
        if ((i & 2) != 0) {
            graffiti2 = playbackOfflineBean.graffiti;
        }
        return playbackOfflineBean.copy(str, graffiti2);
    }

    public final String component1() {
        return this.mateInfoUrl;
    }

    public final Graffiti component2() {
        return this.graffiti;
    }

    public final PlaybackOfflineBean copy(String str, Graffiti graffiti2) {
        return new PlaybackOfflineBean(str, graffiti2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaybackOfflineBean)) {
            return false;
        }
        PlaybackOfflineBean playbackOfflineBean = (PlaybackOfflineBean) obj;
        return Intrinsics.areEqual((Object) this.mateInfoUrl, (Object) playbackOfflineBean.mateInfoUrl) && Intrinsics.areEqual((Object) this.graffiti, (Object) playbackOfflineBean.graffiti);
    }

    public int hashCode() {
        String str = this.mateInfoUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Graffiti graffiti2 = this.graffiti;
        if (graffiti2 != null) {
            i = graffiti2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PlaybackOfflineBean(mateInfoUrl=" + this.mateInfoUrl + ", graffiti=" + this.graffiti + ')';
    }

    public PlaybackOfflineBean(String str, Graffiti graffiti2) {
        this.mateInfoUrl = str;
        this.graffiti = graffiti2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlaybackOfflineBean(String str, Graffiti graffiti2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, graffiti2);
    }

    public final String getMateInfoUrl() {
        return this.mateInfoUrl;
    }

    public final void setMateInfoUrl(String str) {
        this.mateInfoUrl = str;
    }

    public final Graffiti getGraffiti() {
        return this.graffiti;
    }

    public final void setGraffiti(Graffiti graffiti2) {
        this.graffiti = graffiti2;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/PlaybackOfflineBean$Graffiti;", "Ljava/io/Serializable;", "graffitiMd5", "", "graffitiUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getGraffitiMd5", "()Ljava/lang/String;", "setGraffitiMd5", "(Ljava/lang/String;)V", "getGraffitiUrl", "setGraffitiUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackOfflineBean.kt */
    public static final class Graffiti implements Serializable {
        private String graffitiMd5;
        private String graffitiUrl;

        public Graffiti() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Graffiti copy$default(Graffiti graffiti, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = graffiti.graffitiMd5;
            }
            if ((i & 2) != 0) {
                str2 = graffiti.graffitiUrl;
            }
            return graffiti.copy(str, str2);
        }

        public final String component1() {
            return this.graffitiMd5;
        }

        public final String component2() {
            return this.graffitiUrl;
        }

        public final Graffiti copy(String str, String str2) {
            return new Graffiti(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Graffiti)) {
                return false;
            }
            Graffiti graffiti = (Graffiti) obj;
            return Intrinsics.areEqual((Object) this.graffitiMd5, (Object) graffiti.graffitiMd5) && Intrinsics.areEqual((Object) this.graffitiUrl, (Object) graffiti.graffitiUrl);
        }

        public int hashCode() {
            String str = this.graffitiMd5;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.graffitiUrl;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Graffiti(graffitiMd5=" + this.graffitiMd5 + ", graffitiUrl=" + this.graffitiUrl + ')';
        }

        public Graffiti(String str, String str2) {
            this.graffitiMd5 = str;
            this.graffitiUrl = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Graffiti(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getGraffitiMd5() {
            return this.graffitiMd5;
        }

        public final void setGraffitiMd5(String str) {
            this.graffitiMd5 = str;
        }

        public final String getGraffitiUrl() {
            return this.graffitiUrl;
        }

        public final void setGraffitiUrl(String str) {
            this.graffitiUrl = str;
        }
    }
}
