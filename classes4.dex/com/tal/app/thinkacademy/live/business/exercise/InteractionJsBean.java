package com.tal.app.thinkacademy.live.business.exercise;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/InteractionJsBean;", "", "type", "", "data", "Lcom/tal/app/thinkacademy/live/business/exercise/InteractionData;", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/exercise/InteractionData;)V", "getData", "()Lcom/tal/app/thinkacademy/live/business/exercise/InteractionData;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionJsBean.kt */
public final class InteractionJsBean {
    private final InteractionData data;
    private final String type;

    public static /* synthetic */ InteractionJsBean copy$default(InteractionJsBean interactionJsBean, String str, InteractionData interactionData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = interactionJsBean.type;
        }
        if ((i & 2) != 0) {
            interactionData = interactionJsBean.data;
        }
        return interactionJsBean.copy(str, interactionData);
    }

    public final String component1() {
        return this.type;
    }

    public final InteractionData component2() {
        return this.data;
    }

    public final InteractionJsBean copy(String str, InteractionData interactionData) {
        return new InteractionJsBean(str, interactionData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InteractionJsBean)) {
            return false;
        }
        InteractionJsBean interactionJsBean = (InteractionJsBean) obj;
        return Intrinsics.areEqual(this.type, interactionJsBean.type) && Intrinsics.areEqual(this.data, interactionJsBean.data);
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        InteractionData interactionData = this.data;
        if (interactionData != null) {
            i = interactionData.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "InteractionJsBean(type=" + this.type + ", data=" + this.data + ')';
    }

    public InteractionJsBean(String str, InteractionData interactionData) {
        this.type = str;
        this.data = interactionData;
    }

    public final InteractionData getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }
}
