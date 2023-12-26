package com.tal.app.thinkacademy.live.business.emoji.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding;
import com.tal.app.thinkacademy.live.business.emoji.adapter.EmojiPackageItemAdapter;
import com.tal.app.thinkacademy.live.business.emoji.adapter.EmojiPackageListAdapter;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailEntity;
import com.tal.app.thinkacademy.live.core.live.http.response.EmojiDetailPackage;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001Bj\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f¢\u0006\u0002\u0010\u0012J\u0006\u00105\u001a\u00020\u0011J(\u00106\u001a\u00020\u00112\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020908j\b\u0012\u0004\u0012\u000209`:2\u0006\u0010;\u001a\u00020\u0007H\u0002R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006<"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/emoji/widget/EmojiViewPopupWindow;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mContext", "Landroid/content/Context;", "bean", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "width", "", "topBgResId", "bottomBgColor", "BottomItemBgResId", "onEmojiSelected", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "Lkotlin/ParameterName;", "name", "item", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "getBottomItemBgResId", "()Ljava/lang/Integer;", "setBottomItemBgResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBean", "()Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;", "setBean", "(Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailEntity;)V", "getBottomBgColor", "setBottomBgColor", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mEmojiPackageItemAdapter", "Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiPackageItemAdapter;", "mEmojiPackageItemLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mEmojiPackageListAdapter", "Lcom/tal/app/thinkacademy/live/business/emoji/adapter/EmojiPackageListAdapter;", "mEmojiPackageListLayoutManager", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/CommonLayoutEmojiViewBinding;", "getOnEmojiSelected", "()Lkotlin/jvm/functions/Function1;", "setOnEmojiSelected", "(Lkotlin/jvm/functions/Function1;)V", "getTopBgResId", "setTopBgResId", "getWidth", "()I", "setWidth", "(I)V", "initWindow", "updateEmojiPackageSelected", "list", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/core/live/http/response/EmojiDetailPackage;", "Lkotlin/collections/ArrayList;", "position", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiViewPopupWindow.kt */
public class EmojiViewPopupWindow extends EasyPopup {
    private Integer BottomItemBgResId;
    private EmojiDetailEntity bean;
    private Integer bottomBgColor;
    private Context mContext;
    private EmojiPackageItemAdapter mEmojiPackageItemAdapter;
    /* access modifiers changed from: private */
    public LinearLayoutManager mEmojiPackageItemLayoutManager;
    private EmojiPackageListAdapter mEmojiPackageListAdapter;
    /* access modifiers changed from: private */
    public LinearLayoutManager mEmojiPackageListLayoutManager;
    private final CommonLayoutEmojiViewBinding mViewBinding;
    private Function1<? super EmojiAssembleBean, Unit> onEmojiSelected;
    private Integer topBgResId;
    private int width;

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final EmojiDetailEntity getBean() {
        return this.bean;
    }

    public final void setBean(EmojiDetailEntity emojiDetailEntity) {
        Intrinsics.checkNotNullParameter(emojiDetailEntity, "<set-?>");
        this.bean = emojiDetailEntity;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EmojiViewPopupWindow(Context context, EmojiDetailEntity emojiDetailEntity, int i, Integer num, Integer num2, Integer num3, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, emojiDetailEntity, (i2 & 4) != 0 ? -1 : i, (i2 & 8) != 0 ? Integer.valueOf(R.drawable.live_business_emoji_navigation_bar_bg) : num, (i2 & 16) != 0 ? Integer.valueOf(R.color.color_006CCE) : num2, (i2 & 32) != 0 ? Integer.valueOf(R.drawable.live_business_emoji_box_bg) : num3, (i2 & 64) != 0 ? null : function1);
    }

    public final Integer getTopBgResId() {
        return this.topBgResId;
    }

    public final void setTopBgResId(Integer num) {
        this.topBgResId = num;
    }

    public final Integer getBottomBgColor() {
        return this.bottomBgColor;
    }

    public final void setBottomBgColor(Integer num) {
        this.bottomBgColor = num;
    }

    public final Integer getBottomItemBgResId() {
        return this.BottomItemBgResId;
    }

    public final void setBottomItemBgResId(Integer num) {
        this.BottomItemBgResId = num;
    }

    public final Function1<EmojiAssembleBean, Unit> getOnEmojiSelected() {
        return this.onEmojiSelected;
    }

    public final void setOnEmojiSelected(Function1<? super EmojiAssembleBean, Unit> function1) {
        this.onEmojiSelected = function1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmojiViewPopupWindow(Context context, EmojiDetailEntity emojiDetailEntity, int i, Integer num, Integer num2, Integer num3, Function1<? super EmojiAssembleBean, Unit> function1) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(emojiDetailEntity, "bean");
        this.mContext = context;
        this.bean = emojiDetailEntity;
        this.width = i;
        this.topBgResId = num;
        this.bottomBgColor = num2;
        this.BottomItemBgResId = num3;
        this.onEmojiSelected = function1;
        CommonLayoutEmojiViewBinding inflate = CommonLayoutEmojiViewBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(mContext))");
        this.mViewBinding = inflate;
        ((EmojiViewPopupWindow) ((EmojiViewPopupWindow) ((EmojiViewPopupWindow) ((EmojiViewPopupWindow) ((EmojiViewPopupWindow) ((EmojiViewPopupWindow) setContentView((View) inflate.getRoot())).setFocusAndOutsideEnable(true)).setKeyCodeBack(true)).setBackgroundDimEnable(false)).setWidth(this.width)).setHeight(SizeUtils.dp2px(236.0f))).createPopup();
        View view = this.mContentView;
        if (view != null) {
            RecyclerView recyclerView = inflate.emojiPackageRecycle;
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getMContext(), 0, false);
            this.mEmojiPackageListLayoutManager = linearLayoutManager;
            recyclerView.setLayoutManager(linearLayoutManager);
            Integer topBgResId2 = getTopBgResId();
            if (topBgResId2 != null) {
                recyclerView.setBackgroundResource(topBgResId2.intValue());
            }
            ArrayList list = getBean().getList();
            Intrinsics.checkNotNull(list);
            RecyclerView.Adapter emojiPackageListAdapter = new EmojiPackageListAdapter(list);
            this.mEmojiPackageListAdapter = emojiPackageListAdapter;
            recyclerView.setAdapter(emojiPackageListAdapter);
            recyclerView.addItemDecoration(new EmojiViewPopupWindow$1$1$2(this));
            EmojiPackageListAdapter emojiPackageListAdapter2 = this.mEmojiPackageListAdapter;
            if (emojiPackageListAdapter2 != null) {
                emojiPackageListAdapter2.setOnItemClickListener(new EmojiViewPopupWindow$$ExternalSyntheticLambda0(this));
            }
            RecyclerView recyclerView2 = inflate.emojiChildRecycle;
            RecyclerView.LayoutManager linearLayoutManager2 = new LinearLayoutManager(getMContext(), 0, false);
            this.mEmojiPackageItemLayoutManager = linearLayoutManager2;
            recyclerView2.setLayoutManager(linearLayoutManager2);
            Integer bottomBgColor2 = getBottomBgColor();
            if (bottomBgColor2 != null) {
                recyclerView2.setBackgroundColor(view.getContext().getColor(bottomBgColor2.intValue()));
            }
            ArrayList list2 = getBean().getList();
            Intrinsics.checkNotNull(list2);
            RecyclerView.Adapter emojiPackageItemAdapter = new EmojiPackageItemAdapter(list2, getBottomItemBgResId(), new EmojiViewPopupWindow$1$2$2(this));
            this.mEmojiPackageItemAdapter = emojiPackageItemAdapter;
            recyclerView2.setAdapter(emojiPackageItemAdapter);
            recyclerView2.addOnScrollListener(new EmojiViewPopupWindow$1$2$3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-5$lambda-2$lambda-1  reason: not valid java name */
    public static final void m225lambda5$lambda2$lambda1(EmojiViewPopupWindow emojiViewPopupWindow, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(emojiViewPopupWindow, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayoutManager linearLayoutManager = emojiViewPopupWindow.mEmojiPackageItemLayoutManager;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(i, 0);
        }
        ArrayList list = emojiViewPopupWindow.bean.getList();
        Intrinsics.checkNotNull(list);
        emojiViewPopupWindow.updateEmojiPackageSelected(list, i);
    }

    /* access modifiers changed from: private */
    public final void updateEmojiPackageSelected(ArrayList<EmojiDetailPackage> arrayList, int i) {
        int i2 = 0;
        for (Object next : arrayList) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((EmojiDetailPackage) next).setSelected(i2 == i);
            i2 = i3;
        }
        EmojiPackageListAdapter emojiPackageListAdapter = this.mEmojiPackageListAdapter;
        if (emojiPackageListAdapter != null) {
            emojiPackageListAdapter.setList(arrayList);
        }
    }

    public final void initWindow() {
        LinearLayoutManager linearLayoutManager = this.mEmojiPackageListLayoutManager;
        if (linearLayoutManager != null) {
            linearLayoutManager.scrollToPositionWithOffset(0, 0);
        }
        ArrayList list = this.bean.getList();
        Intrinsics.checkNotNull(list);
        updateEmojiPackageSelected(list, 0);
        LinearLayoutManager linearLayoutManager2 = this.mEmojiPackageItemLayoutManager;
        if (linearLayoutManager2 != null) {
            linearLayoutManager2.scrollToPositionWithOffset(0, 0);
        }
    }
}
