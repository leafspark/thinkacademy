package com.tal.app.thinkacademy.business.shop.bean.teachernode;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/teachernode/TeacherVideoNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "videoUrl", "", "childNode", "", "(Ljava/lang/String;Ljava/util/List;)V", "getChildNode", "()Ljava/util/List;", "getVideoUrl", "()Ljava/lang/String;", "setVideoUrl", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherVideoNode.kt */
public final class TeacherVideoNode extends BaseNode {
    private final List<BaseNode> childNode;
    private String videoUrl;

    public static /* synthetic */ TeacherVideoNode copy$default(TeacherVideoNode teacherVideoNode, String str, List<BaseNode> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teacherVideoNode.videoUrl;
        }
        if ((i & 2) != 0) {
            list = teacherVideoNode.getChildNode();
        }
        return teacherVideoNode.copy(str, list);
    }

    public final String component1() {
        return this.videoUrl;
    }

    public final List<BaseNode> component2() {
        return getChildNode();
    }

    public final TeacherVideoNode copy(String str, List<BaseNode> list) {
        return new TeacherVideoNode(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherVideoNode)) {
            return false;
        }
        TeacherVideoNode teacherVideoNode = (TeacherVideoNode) obj;
        return Intrinsics.areEqual((Object) this.videoUrl, (Object) teacherVideoNode.videoUrl) && Intrinsics.areEqual((Object) getChildNode(), (Object) teacherVideoNode.getChildNode());
    }

    public int hashCode() {
        String str = this.videoUrl;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        if (getChildNode() != null) {
            i = getChildNode().hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "TeacherVideoNode(videoUrl=" + this.videoUrl + ", childNode=" + getChildNode() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherVideoNode(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : list);
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public TeacherVideoNode(String str, List<BaseNode> list) {
        this.videoUrl = str;
        this.childNode = list;
    }
}
