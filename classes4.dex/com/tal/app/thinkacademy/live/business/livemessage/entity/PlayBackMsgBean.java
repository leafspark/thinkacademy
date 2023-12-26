package com.tal.app.thinkacademy.live.business.livemessage.entity;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ!\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tHÆ\u0003JT\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\tHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R)\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007j\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgBean;", "", "total", "", "pages", "page", "messages", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgEntity;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getMessages", "()Ljava/util/ArrayList;", "getPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPages", "getTotal", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgBean;", "equals", "", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayBackMsgBean.kt */
public final class PlayBackMsgBean {
    private final ArrayList<PlayBackMsgEntity> messages;
    private final Integer page;
    private final Integer pages;
    private final Integer total;

    public static /* synthetic */ PlayBackMsgBean copy$default(PlayBackMsgBean playBackMsgBean, Integer num, Integer num2, Integer num3, ArrayList<PlayBackMsgEntity> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            num = playBackMsgBean.total;
        }
        if ((i & 2) != 0) {
            num2 = playBackMsgBean.pages;
        }
        if ((i & 4) != 0) {
            num3 = playBackMsgBean.page;
        }
        if ((i & 8) != 0) {
            arrayList = playBackMsgBean.messages;
        }
        return playBackMsgBean.copy(num, num2, num3, arrayList);
    }

    public final Integer component1() {
        return this.total;
    }

    public final Integer component2() {
        return this.pages;
    }

    public final Integer component3() {
        return this.page;
    }

    public final ArrayList<PlayBackMsgEntity> component4() {
        return this.messages;
    }

    public final PlayBackMsgBean copy(Integer num, Integer num2, Integer num3, ArrayList<PlayBackMsgEntity> arrayList) {
        return new PlayBackMsgBean(num, num2, num3, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayBackMsgBean)) {
            return false;
        }
        PlayBackMsgBean playBackMsgBean = (PlayBackMsgBean) obj;
        return Intrinsics.areEqual(this.total, playBackMsgBean.total) && Intrinsics.areEqual(this.pages, playBackMsgBean.pages) && Intrinsics.areEqual(this.page, playBackMsgBean.page) && Intrinsics.areEqual(this.messages, playBackMsgBean.messages);
    }

    public int hashCode() {
        Integer num = this.total;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pages;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.page;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        ArrayList<PlayBackMsgEntity> arrayList = this.messages;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PlayBackMsgBean(total=" + this.total + ", pages=" + this.pages + ", page=" + this.page + ", messages=" + this.messages + ')';
    }

    public PlayBackMsgBean(Integer num, Integer num2, Integer num3, ArrayList<PlayBackMsgEntity> arrayList) {
        this.total = num;
        this.pages = num2;
        this.page = num3;
        this.messages = arrayList;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public final Integer getPages() {
        return this.pages;
    }

    public final Integer getPage() {
        return this.page;
    }

    public final ArrayList<PlayBackMsgEntity> getMessages() {
        return this.messages;
    }
}
