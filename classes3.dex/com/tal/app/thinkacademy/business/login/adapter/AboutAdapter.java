package com.tal.app.thinkacademy.business.login.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.entity.AboutBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/AboutAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/login/entity/AboutBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AboutAdapter.kt */
public final class AboutAdapter extends BaseQuickAdapter<AboutBean, BaseViewHolder> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AboutAdapter(List<AboutBean> list) {
        super(R.layout.layout_item_about, list);
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, AboutBean aboutBean) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(aboutBean, "item");
        baseViewHolder.setText(R.id.item_tv_name, aboutBean.getTitle());
    }
}
