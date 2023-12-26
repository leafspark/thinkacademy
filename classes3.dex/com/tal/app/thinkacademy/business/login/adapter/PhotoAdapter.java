package com.tal.app.thinkacademy.business.login.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/adapter/PhotoAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotoAdapter.kt */
public final class PhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public PhotoAdapter(List<String> list) {
        super(R.layout.layout_item_photo, list);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(str, "item");
        if (str.length() == 0) {
            baseViewHolder.setGone(R.id.item_iv_del, true);
            baseViewHolder.setImageResource(R.id.item_iv_photo, R.mipmap.feedback_icon_photo);
            return;
        }
        baseViewHolder.setGone(R.id.item_iv_del, false);
        XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.item_iv_photo), getContext(), str, SizeUtils.dp2px(4.0f), 0, R.mipmap.feedback_icon_photo, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
    }
}
