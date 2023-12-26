package com.tal.app.thinkacademy.common.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.common.adapter.TreeChildBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0019R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/common/adapter/BeanEx;", "T", "Lcom/tal/app/thinkacademy/common/adapter/TreeChildBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "childPosition", "", "getChildPosition", "()Ljava/lang/Integer;", "setChildPosition", "(Ljava/lang/Integer;)V", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "isParent", "", "()Z", "itemType", "getItemType", "()I", "parentPosition", "getParentPosition", "setParentPosition", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BeanEx.kt */
public interface BeanEx<T extends TreeChildBean> extends MultiItemEntity {
    public static final int CHILD_TYPE = -99;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int PARENT_TYPE = -100;

    Integer getChildPosition();

    List<T> getChildren();

    int getItemType();

    Integer getParentPosition();

    boolean isParent();

    void setChildPosition(Integer num);

    void setChildren(List<T> list);

    void setParentPosition(Integer num);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BeanEx.kt */
    public static final class DefaultImpls {
        public static <T extends TreeChildBean> int getItemType(BeanEx<T> beanEx) {
            Intrinsics.checkNotNullParameter(beanEx, "this");
            return beanEx.isParent() ? -100 : -99;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/common/adapter/BeanEx$Companion;", "", "()V", "CHILD_TYPE", "", "PARENT_TYPE", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BeanEx.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CHILD_TYPE = -99;
        public static final int PARENT_TYPE = -100;

        private Companion() {
        }
    }
}
