package com.tal.app.thinkacademy.live.business.canvastriplescreen.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp;", "", "code", "", "msg", "", "content", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getContent", "()Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;)Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp;", "equals", "", "other", "hashCode", "toString", "CanvasBinaryBean", "CanvasBinaryEntity", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CanvasBinaryResp.kt */
public final class CanvasBinaryResp {
    private final Integer code;
    private final CanvasBinaryBean content;
    private final String msg;

    public static /* synthetic */ CanvasBinaryResp copy$default(CanvasBinaryResp canvasBinaryResp, Integer num, String str, CanvasBinaryBean canvasBinaryBean, int i, Object obj) {
        if ((i & 1) != 0) {
            num = canvasBinaryResp.code;
        }
        if ((i & 2) != 0) {
            str = canvasBinaryResp.msg;
        }
        if ((i & 4) != 0) {
            canvasBinaryBean = canvasBinaryResp.content;
        }
        return canvasBinaryResp.copy(num, str, canvasBinaryBean);
    }

    public final Integer component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final CanvasBinaryBean component3() {
        return this.content;
    }

    public final CanvasBinaryResp copy(Integer num, String str, CanvasBinaryBean canvasBinaryBean) {
        return new CanvasBinaryResp(num, str, canvasBinaryBean);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CanvasBinaryResp)) {
            return false;
        }
        CanvasBinaryResp canvasBinaryResp = (CanvasBinaryResp) obj;
        return Intrinsics.areEqual(this.code, canvasBinaryResp.code) && Intrinsics.areEqual(this.msg, canvasBinaryResp.msg) && Intrinsics.areEqual(this.content, canvasBinaryResp.content);
    }

    public int hashCode() {
        Integer num = this.code;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CanvasBinaryBean canvasBinaryBean = this.content;
        if (canvasBinaryBean != null) {
            i = canvasBinaryBean.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CanvasBinaryResp(code=" + this.code + ", msg=" + this.msg + ", content=" + this.content + ')';
    }

    public CanvasBinaryResp(Integer num, String str, CanvasBinaryBean canvasBinaryBean) {
        this.code = num;
        this.msg = str;
        this.content = canvasBinaryBean;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final CanvasBinaryBean getContent() {
        return this.content;
    }

    public final String getMsg() {
        return this.msg;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JP\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001f\u001a\u00020\u001dJ\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;", "", "key", "", "order", "", "page", "pages", "msgs", "", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryEntity;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getMsgs", "()Ljava/util/List;", "getOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPage", "getPages", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryBean;", "equals", "", "other", "hasNextPage", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CanvasBinaryResp.kt */
    public static final class CanvasBinaryBean {
        private final String key;
        private final List<CanvasBinaryEntity> msgs;
        private final Integer order;
        private final Integer page;
        private final Integer pages;

        public static /* synthetic */ CanvasBinaryBean copy$default(CanvasBinaryBean canvasBinaryBean, String str, Integer num, Integer num2, Integer num3, List<CanvasBinaryEntity> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = canvasBinaryBean.key;
            }
            if ((i & 2) != 0) {
                num = canvasBinaryBean.order;
            }
            Integer num4 = num;
            if ((i & 4) != 0) {
                num2 = canvasBinaryBean.page;
            }
            Integer num5 = num2;
            if ((i & 8) != 0) {
                num3 = canvasBinaryBean.pages;
            }
            Integer num6 = num3;
            if ((i & 16) != 0) {
                list = canvasBinaryBean.msgs;
            }
            return canvasBinaryBean.copy(str, num4, num5, num6, list);
        }

        public final String component1() {
            return this.key;
        }

        public final Integer component2() {
            return this.order;
        }

        public final Integer component3() {
            return this.page;
        }

        public final Integer component4() {
            return this.pages;
        }

        public final List<CanvasBinaryEntity> component5() {
            return this.msgs;
        }

        public final CanvasBinaryBean copy(String str, Integer num, Integer num2, Integer num3, List<CanvasBinaryEntity> list) {
            return new CanvasBinaryBean(str, num, num2, num3, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CanvasBinaryBean)) {
                return false;
            }
            CanvasBinaryBean canvasBinaryBean = (CanvasBinaryBean) obj;
            return Intrinsics.areEqual(this.key, canvasBinaryBean.key) && Intrinsics.areEqual(this.order, canvasBinaryBean.order) && Intrinsics.areEqual(this.page, canvasBinaryBean.page) && Intrinsics.areEqual(this.pages, canvasBinaryBean.pages) && Intrinsics.areEqual(this.msgs, canvasBinaryBean.msgs);
        }

        public int hashCode() {
            String str = this.key;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.order;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.page;
            int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.pages;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            List<CanvasBinaryEntity> list = this.msgs;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "CanvasBinaryBean(key=" + this.key + ", order=" + this.order + ", page=" + this.page + ", pages=" + this.pages + ", msgs=" + this.msgs + ')';
        }

        public CanvasBinaryBean(String str, Integer num, Integer num2, Integer num3, List<CanvasBinaryEntity> list) {
            this.key = str;
            this.order = num;
            this.page = num2;
            this.pages = num3;
            this.msgs = list;
        }

        public final String getKey() {
            return this.key;
        }

        public final Integer getOrder() {
            return this.order;
        }

        public final Integer getPage() {
            return this.page;
        }

        public final Integer getPages() {
            return this.pages;
        }

        public final List<CanvasBinaryEntity> getMsgs() {
            return this.msgs;
        }

        public final boolean hasNextPage() {
            Integer num;
            if (this.page == null || (num = this.pages) == null || num.intValue() <= this.page.intValue()) {
                return false;
            }
            return true;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/entity/CanvasBinaryResp$CanvasBinaryEntity;", "", "msgId", "", "content", "", "(JLjava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getMsgId", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CanvasBinaryResp.kt */
    public static final class CanvasBinaryEntity {
        private final String content;
        private final long msgId;

        public CanvasBinaryEntity() {
            this(0, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ CanvasBinaryEntity copy$default(CanvasBinaryEntity canvasBinaryEntity, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = canvasBinaryEntity.msgId;
            }
            if ((i & 2) != 0) {
                str = canvasBinaryEntity.content;
            }
            return canvasBinaryEntity.copy(j, str);
        }

        public final long component1() {
            return this.msgId;
        }

        public final String component2() {
            return this.content;
        }

        public final CanvasBinaryEntity copy(long j, String str) {
            return new CanvasBinaryEntity(j, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CanvasBinaryEntity)) {
                return false;
            }
            CanvasBinaryEntity canvasBinaryEntity = (CanvasBinaryEntity) obj;
            return this.msgId == canvasBinaryEntity.msgId && Intrinsics.areEqual(this.content, canvasBinaryEntity.content);
        }

        public int hashCode() {
            int m = SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.msgId) * 31;
            String str = this.content;
            return m + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "CanvasBinaryEntity(msgId=" + this.msgId + ", content=" + this.content + ')';
        }

        public CanvasBinaryEntity(long j, String str) {
            this.msgId = j;
            this.content = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CanvasBinaryEntity(long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0 : j, (i & 2) != 0 ? null : str);
        }

        public final long getMsgId() {
            return this.msgId;
        }

        public final String getContent() {
            return this.content;
        }
    }
}
