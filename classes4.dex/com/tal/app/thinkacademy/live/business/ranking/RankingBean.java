package com.tal.app.thinkacademy.live.business.ranking;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "Ljava/io/Serializable;", "id", "", "name", "", "coin", "time", "", "ranking", "level", "title", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getCoin", "()Ljava/lang/Integer;", "setCoin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "setId", "getLevel", "setLevel", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRanking", "setRanking", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/ranking/RankingBean;", "equals", "", "other", "", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RankingBean.kt */
public final class RankingBean implements Serializable {
    private Integer coin;
    private Integer id;
    private Integer level;
    private String name;
    private Integer ranking;
    private Long time;
    private String title;

    public static /* synthetic */ RankingBean copy$default(RankingBean rankingBean, Integer num, String str, Integer num2, Long l, Integer num3, Integer num4, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = rankingBean.id;
        }
        if ((i & 2) != 0) {
            str = rankingBean.name;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            num2 = rankingBean.coin;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            l = rankingBean.time;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            num3 = rankingBean.ranking;
        }
        Integer num6 = num3;
        if ((i & 32) != 0) {
            num4 = rankingBean.level;
        }
        Integer num7 = num4;
        if ((i & 64) != 0) {
            str2 = rankingBean.title;
        }
        return rankingBean.copy(num, str3, num5, l2, num6, num7, str2);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final Integer component3() {
        return this.coin;
    }

    public final Long component4() {
        return this.time;
    }

    public final Integer component5() {
        return this.ranking;
    }

    public final Integer component6() {
        return this.level;
    }

    public final String component7() {
        return this.title;
    }

    public final RankingBean copy(Integer num, String str, Integer num2, Long l, Integer num3, Integer num4, String str2) {
        return new RankingBean(num, str, num2, l, num3, num4, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RankingBean)) {
            return false;
        }
        RankingBean rankingBean = (RankingBean) obj;
        return Intrinsics.areEqual(this.id, rankingBean.id) && Intrinsics.areEqual(this.name, rankingBean.name) && Intrinsics.areEqual(this.coin, rankingBean.coin) && Intrinsics.areEqual(this.time, rankingBean.time) && Intrinsics.areEqual(this.ranking, rankingBean.ranking) && Intrinsics.areEqual(this.level, rankingBean.level) && Intrinsics.areEqual(this.title, rankingBean.title);
    }

    public int hashCode() {
        Integer num = this.id;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.coin;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.time;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num3 = this.ranking;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.level;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "RankingBean(id=" + this.id + ", name=" + this.name + ", coin=" + this.coin + ", time=" + this.time + ", ranking=" + this.ranking + ", level=" + this.level + ", title=" + this.title + ')';
    }

    public RankingBean(Integer num, String str, Integer num2, Long l, Integer num3, Integer num4, String str2) {
        this.id = num;
        this.name = str;
        this.coin = num2;
        this.time = l;
        this.ranking = num3;
        this.level = num4;
        this.title = str2;
    }

    public final Integer getCoin() {
        return this.coin;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setCoin(Integer num) {
        this.coin = num;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final Integer getRanking() {
        return this.ranking;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setLevel(Integer num) {
        this.level = num;
    }

    public final void setRanking(Integer num) {
        this.ranking = num;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
