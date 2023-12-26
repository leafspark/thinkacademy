package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.manager.CustomGridLayoutManager;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiViewEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BH\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiPackageItemAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "resId", "", "onEmojiSelected", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "Lkotlin/ParameterName;", "name", "item", "", "(Ljava/util/List;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getOnEmojiSelected", "()Lkotlin/jvm/functions/Function1;", "setOnEmojiSelected", "(Lkotlin/jvm/functions/Function1;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "convert", "holder", "getColumns", "count", "line", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiPackageItemAdapter.kt */
public final class EmojiPackageItemAdapter extends BaseMultiItemQuickAdapter<EmojiDetailPackage, BaseViewHolder> {
    private List<EmojiDetailPackage> list;
    private Function1<? super EmojiAssembleBean, Unit> onEmojiSelected;
    private Integer resId;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmojiPackageItemAdapter(List list2, Integer num, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list2, num, (i & 4) != 0 ? null : function1);
    }

    public final List<EmojiDetailPackage> getList() {
        return this.list;
    }

    public final void setList(List<EmojiDetailPackage> list2) {
        this.list = list2;
    }

    public final Integer getResId() {
        return this.resId;
    }

    public final void setResId(Integer num) {
        this.resId = num;
    }

    public final Function1<EmojiAssembleBean, Unit> getOnEmojiSelected() {
        return this.onEmojiSelected;
    }

    public final void setOnEmojiSelected(Function1<? super EmojiAssembleBean, Unit> function1) {
        this.onEmojiSelected = function1;
    }

    public EmojiPackageItemAdapter(List<EmojiDetailPackage> list2, Integer num, Function1<? super EmojiAssembleBean, Unit> function1) {
        super(list2);
        this.list = list2;
        this.resId = num;
        this.onEmojiSelected = function1;
        addItemType(0, R.layout.live_business_item_emoji_package_item);
        addItemType(1, R.layout.live_business_item_emoji_package_item);
        addItemType(2, R.layout.live_business_item_emoji_package_item_overdue);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, EmojiDetailPackage emojiDetailPackage) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(emojiDetailPackage, "item");
        int itemType = emojiDetailPackage.getItemType();
        if (itemType == 0 || itemType == 1) {
            RecyclerView view = baseViewHolder.getView(R.id.emojiItemRecycle);
            Integer resId2 = getResId();
            if (resId2 != null) {
                view.setBackgroundResource(resId2.intValue());
            }
            ArrayList content = emojiDetailPackage.getContent();
            int columns = getColumns(content == null ? 0 : content.size(), emojiDetailPackage.getLineCount());
            RecyclerView recyclerView = view;
            recyclerView.setLayoutManager(new CustomGridLayoutManager(getContext(), columns, 1, false));
            BaseQuickAdapter emojiPayViewAdapter = emojiDetailPackage.getItemType() == 0 ? (BaseQuickAdapter) new EmojiDefaultViewAdapter(TypeIntrinsics.asMutableList(emojiDetailPackage.getContent())) : new EmojiPayViewAdapter(TypeIntrinsics.asMutableList(emojiDetailPackage.getContent()), columns, emojiDetailPackage.getLineCount());
            recyclerView.setAdapter(emojiPayViewAdapter);
            emojiPayViewAdapter.setOnItemClickListener(new EmojiPackageItemAdapter$$ExternalSyntheticLambda0(emojiDetailPackage, this));
        } else if (itemType == 2) {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivHeadPortrait), getContext(), emojiDetailPackage.getPicture(), 0, 0, R.drawable.live_business_icon_emoji_placeholder, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-3$lambda-2  reason: not valid java name */
    public static final void m219convert$lambda3$lambda2(EmojiDetailPackage emojiDetailPackage, EmojiPackageItemAdapter emojiPackageItemAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        EmojiPackageItemAdapter emojiPackageItemAdapter2 = emojiPackageItemAdapter;
        BaseQuickAdapter baseQuickAdapter2 = baseQuickAdapter;
        Intrinsics.checkNotNullParameter(emojiDetailPackage, "$this_run");
        Intrinsics.checkNotNullParameter(emojiPackageItemAdapter2, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter2, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = (emojiDetailPackage.getItemType() == 0 ? (EmojiDefaultViewAdapter) baseQuickAdapter2 : (EmojiPayViewAdapter) baseQuickAdapter2).getItem(i);
        Function1<? super EmojiAssembleBean, Unit> function1 = emojiPackageItemAdapter2.onEmojiSelected;
        if (function1 != null) {
            String emojiPackageName = emojiDetailPackage.getEmojiPackageName();
            String emojiPackageId = emojiDetailPackage.getEmojiPackageId();
            String orderId = emojiDetailPackage.getOrderId();
            Boolean isAnimation = emojiDetailPackage.isAnimation();
            Boolean isOver = emojiDetailPackage.isOver();
            String picture = emojiDetailPackage.getPicture();
            Boolean overShow = emojiDetailPackage.getOverShow();
            EmojiViewEntity emojiViewEntity = (EmojiViewEntity) item;
            String emojiName = emojiViewEntity.getEmojiName();
            String emojiId = emojiViewEntity.getEmojiId();
            String emojiPicture = emojiViewEntity.getEmojiPicture();
            Function1<? super EmojiAssembleBean, Unit> function12 = function1;
            EmojiAssembleBean emojiAssembleBean = r2;
            EmojiAssembleBean emojiAssembleBean2 = new EmojiAssembleBean(emojiPackageName, emojiPackageId, orderId, isAnimation, isOver, picture, overShow, emojiName, emojiId, emojiPicture, emojiViewEntity.getLottieUrl(), emojiViewEntity.getResId(), emojiViewEntity.getType());
            function12.invoke(emojiAssembleBean);
        }
    }

    private final int getColumns(int i, int i2) {
        return (int) Math.ceil(((double) i) / ((double) i2));
    }
}
