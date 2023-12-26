package com.tal.app.thinkacademy.common.adapter;

import com.tal.app.thinkacademy.common.adapter.BeanEx;
import com.tal.app.thinkacademy.common.adapter.TreeChildBean;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/adapter/TreeBean;", "T", "Lcom/tal/app/thinkacademy/common/adapter/TreeChildBean;", "Lcom/tal/app/thinkacademy/common/adapter/BeanEx;", "()V", "childPosition", "", "getChildPosition", "()Ljava/lang/Integer;", "setChildPosition", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "children", "", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "isParent", "", "()Z", "parentPosition", "getParentPosition", "setParentPosition", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TreeBean.kt */
public abstract class TreeBean<T extends TreeChildBean> implements BeanEx<T> {
    private Integer childPosition = 0;
    private Integer parentPosition = 0;

    public abstract List<T> getChildren();

    public boolean isParent() {
        return true;
    }

    public abstract void setChildren(List<T> list);

    public int getItemType() {
        return BeanEx.DefaultImpls.getItemType(this);
    }

    public Integer getParentPosition() {
        return this.parentPosition;
    }

    public void setParentPosition(Integer num) {
        this.parentPosition = num;
    }

    public Integer getChildPosition() {
        return this.childPosition;
    }

    public void setChildPosition(Integer num) {
        this.childPosition = num;
    }
}
