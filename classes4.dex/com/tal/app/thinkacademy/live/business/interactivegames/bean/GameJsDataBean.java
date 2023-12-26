package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsDataBean;", "", "rightCoin", "", "nickName", "(Ljava/lang/String;Ljava/lang/String;)V", "getNickName", "()Ljava/lang/String;", "getRightCoin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameJsBean.kt */
public final class GameJsDataBean {
    private final String nickName;
    private final String rightCoin;

    public static /* synthetic */ GameJsDataBean copy$default(GameJsDataBean gameJsDataBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameJsDataBean.rightCoin;
        }
        if ((i & 2) != 0) {
            str2 = gameJsDataBean.nickName;
        }
        return gameJsDataBean.copy(str, str2);
    }

    public final String component1() {
        return this.rightCoin;
    }

    public final String component2() {
        return this.nickName;
    }

    public final GameJsDataBean copy(String str, String str2) {
        return new GameJsDataBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameJsDataBean)) {
            return false;
        }
        GameJsDataBean gameJsDataBean = (GameJsDataBean) obj;
        return Intrinsics.areEqual(this.rightCoin, gameJsDataBean.rightCoin) && Intrinsics.areEqual(this.nickName, gameJsDataBean.nickName);
    }

    public int hashCode() {
        String str = this.rightCoin;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.nickName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GameJsDataBean(rightCoin=" + this.rightCoin + ", nickName=" + this.nickName + ')';
    }

    public GameJsDataBean(String str, String str2) {
        this.rightCoin = str;
        this.nickName = str2;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getRightCoin() {
        return this.rightCoin;
    }
}
