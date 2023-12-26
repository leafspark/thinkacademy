package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiPackageListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "convert", "", "holder", "item", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiPackageListAdapter.kt */
public final class EmojiPackageListAdapter extends BaseQuickAdapter<EmojiDetailPackage, BaseViewHolder> {
    private List<EmojiDetailPackage> list;

    public final List<EmojiDetailPackage> getList() {
        return this.list;
    }

    public final void setList(List<EmojiDetailPackage> list2) {
        this.list = list2;
    }

    public EmojiPackageListAdapter(List<EmojiDetailPackage> list2) {
        super(R.layout.live_business_item_emoji_package_list, list2);
        this.list = list2;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, EmojiDetailPackage emojiDetailPackage) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(emojiDetailPackage, "item");
        int itemPosition = getItemPosition(emojiDetailPackage);
        ((FrameLayout) baseViewHolder.getView(R.id.llItemView)).setSelected(emojiDetailPackage.isSelected());
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivEmojiView);
        if (itemPosition == 0) {
            imageView.setImageResource(R.drawable.live_business_icon_emoji_normal);
        } else {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, imageView, getContext(), emojiDetailPackage.getPicture(), 0, 0, R.drawable.live_business_icon_emoji_package_placeholder, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        }
    }
}
