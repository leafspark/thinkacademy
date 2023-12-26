package com.tal.app.thinkacademy.live.business.redpackagerain.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/GameResBean;", "", "redbagrainPackage", "Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "(Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;)V", "getRedbagrainPackage", "()Lcom/tal/app/thinkacademy/live/business/redpackagerain/bean/RedPackageRainResBean;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameResBean.kt */
public final class GameResBean {
    private final RedPackageRainResBean redbagrainPackage;

    public static /* synthetic */ GameResBean copy$default(GameResBean gameResBean, RedPackageRainResBean redPackageRainResBean, int i, Object obj) {
        if ((i & 1) != 0) {
            redPackageRainResBean = gameResBean.redbagrainPackage;
        }
        return gameResBean.copy(redPackageRainResBean);
    }

    public final RedPackageRainResBean component1() {
        return this.redbagrainPackage;
    }

    public final GameResBean copy(RedPackageRainResBean redPackageRainResBean) {
        return new GameResBean(redPackageRainResBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GameResBean) && Intrinsics.areEqual(this.redbagrainPackage, ((GameResBean) obj).redbagrainPackage);
    }

    public int hashCode() {
        RedPackageRainResBean redPackageRainResBean = this.redbagrainPackage;
        if (redPackageRainResBean == null) {
            return 0;
        }
        return redPackageRainResBean.hashCode();
    }

    public String toString() {
        return "GameResBean(redbagrainPackage=" + this.redbagrainPackage + ')';
    }

    public GameResBean(RedPackageRainResBean redPackageRainResBean) {
        this.redbagrainPackage = redPackageRainResBean;
    }

    public final RedPackageRainResBean getRedbagrainPackage() {
        return this.redbagrainPackage;
    }
}
