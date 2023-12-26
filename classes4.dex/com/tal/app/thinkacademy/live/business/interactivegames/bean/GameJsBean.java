package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsBean;", "", "type", "", "data", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsDataBean;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsDataBean;)V", "getData", "()Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsDataBean;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameJsBean.kt */
public final class GameJsBean {
    private final GameJsDataBean data;
    private final String type;

    public static /* synthetic */ GameJsBean copy$default(GameJsBean gameJsBean, String str, GameJsDataBean gameJsDataBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gameJsBean.type;
        }
        if ((i & 2) != 0) {
            gameJsDataBean = gameJsBean.data;
        }
        return gameJsBean.copy(str, gameJsDataBean);
    }

    public final String component1() {
        return this.type;
    }

    public final GameJsDataBean component2() {
        return this.data;
    }

    public final GameJsBean copy(String str, GameJsDataBean gameJsDataBean) {
        return new GameJsBean(str, gameJsDataBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameJsBean)) {
            return false;
        }
        GameJsBean gameJsBean = (GameJsBean) obj;
        return Intrinsics.areEqual(this.type, gameJsBean.type) && Intrinsics.areEqual(this.data, gameJsBean.data);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        GameJsDataBean gameJsDataBean = this.data;
        if (gameJsDataBean != null) {
            i = gameJsDataBean.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GameJsBean(type=" + this.type + ", data=" + this.data + ')';
    }

    public GameJsBean(String str, GameJsDataBean gameJsDataBean) {
        this.type = str;
        this.data = gameJsDataBean;
    }

    public final GameJsDataBean getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
