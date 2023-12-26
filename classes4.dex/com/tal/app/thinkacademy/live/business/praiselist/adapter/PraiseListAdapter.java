package com.tal.app.thinkacademy.live.business.praiselist.adapter;

import android.animation.ValueAnimator;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.praiselist.bean.PraiseListUserData;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0014J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0014J\u0018\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000fH\u0014J\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000fJ\u0010\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u0017J \u0010-\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0015H\u0002J\u0016\u00100\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u000fJ \u00103\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00172\u0006\u00104\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0003H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/adapter/PraiseListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListUserData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "list", "", "(Ljava/util/List;)V", "layouts", "Landroid/util/SparseIntArray;", "getLayouts", "()Landroid/util/SparseIntArray;", "layouts$delegate", "Lkotlin/Lazy;", "mCloseBg", "", "", "[Ljava/lang/Integer;", "mItemType", "mMySelfBg", "mNormalBg", "mOpenShowAnim", "", "mSelfUid", "", "mShownStuNum", "convert", "", "holder", "item", "payloads", "", "", "getDefItemViewType", "position", "onCreateDefViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "openShowAnim", "anim", "shownNum", "setAllType", "allType", "setSelfId", "userId", "setupAnim", "uid", "open", "updateShowStuNum", "isForward", "showStudentNum", "updateViewState", "close", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListAdapter.kt */
public final class PraiseListAdapter extends BaseQuickAdapter<PraiseListUserData, BaseViewHolder> {
    private final Lazy layouts$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, PraiseListAdapter$layouts$2.INSTANCE);
    private final Integer[] mCloseBg = {Integer.valueOf(R.drawable.bg_live_business_praise_list_close_1), Integer.valueOf(R.drawable.bg_live_business_praise_list_close_2), Integer.valueOf(R.drawable.bg_live_business_praise_list_close_3), Integer.valueOf(R.drawable.bg_live_business_praise_list_close_4)};
    private int mItemType;
    private final Integer[] mMySelfBg = {Integer.valueOf(R.drawable.bg_live_business_praise_list_star_1), Integer.valueOf(R.drawable.bg_live_business_praise_list_star_1), Integer.valueOf(R.drawable.bg_live_business_praise_list_star_3), Integer.valueOf(R.drawable.bg_live_business_praise_list_star_4)};
    private final Integer[] mNormalBg = {Integer.valueOf(R.drawable.shape_live_business_praise_list_normal_1), Integer.valueOf(R.drawable.shape_live_business_praise_list_normal_2), Integer.valueOf(R.drawable.shape_live_business_praise_list_normal_2), Integer.valueOf(R.drawable.shape_live_business_praise_list_normal_2)};
    private boolean mOpenShowAnim;
    private String mSelfUid;
    private int mShownStuNum;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PraiseListAdapter(List<PraiseListUserData> list) {
        super(0, list);
        Intrinsics.checkNotNullParameter(list, "list");
        getLayouts().put(0, R.layout.item_praise_list_stu_list_1);
        getLayouts().put(1, R.layout.item_praise_list_stu_list_2);
        getLayouts().put(2, R.layout.item_praise_list_stu_list_3);
        getLayouts().put(3, R.layout.item_praise_list_stu_list_4);
    }

    private final SparseIntArray getLayouts() {
        return (SparseIntArray) this.layouts$delegate.getValue();
    }

    public final void setAllType(int i) {
        this.mItemType = i;
    }

    /* access modifiers changed from: protected */
    public int getDefItemViewType(int i) {
        return this.mItemType;
    }

    /* access modifiers changed from: protected */
    public BaseViewHolder onCreateDefViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int i2 = getLayouts().get(i);
        if (i2 != 0) {
            return createBaseViewHolder(viewGroup, i2);
        }
        throw new IllegalArgumentException(("ViewType: " + i + " found layoutResId，please use addItemType() first!").toString());
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, PraiseListUserData praiseListUserData) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(praiseListUserData, "item");
        XesImageLoader.loadCircleImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.ivAvatar), getContext(), praiseListUserData.getAvatar(), 0, 4, (Object) null);
        baseViewHolder.setText(R.id.tvUserName, praiseListUserData.getNickname());
        String studentId = praiseListUserData.getStudentId();
        boolean z = true;
        if (!this.mOpenShowAnim || getItemPosition(praiseListUserData) <= this.mShownStuNum - 1) {
            z = false;
        }
        updateViewState(studentId, z, baseViewHolder);
    }

    /* access modifiers changed from: private */
    public final void updateViewState(String str, boolean z, BaseViewHolder baseViewHolder) {
        if (z) {
            baseViewHolder.setImageResource(R.id.bgItem, this.mCloseBg[this.mItemType].intValue());
            baseViewHolder.setVisible(R.id.ivAvatar, false);
            baseViewHolder.setVisible(R.id.tvUserName, false);
            baseViewHolder.setVisible(R.id.iv_owner_tag, false);
            return;
        }
        baseViewHolder.setVisible(R.id.ivAvatar, true);
        baseViewHolder.setVisible(R.id.tvUserName, true);
        if (Intrinsics.areEqual(this.mSelfUid, str)) {
            baseViewHolder.setVisible(R.id.iv_owner_tag, true);
            baseViewHolder.setImageResource(R.id.bgItem, this.mMySelfBg[this.mItemType].intValue());
            return;
        }
        baseViewHolder.setVisible(R.id.iv_owner_tag, false);
        baseViewHolder.setImageResource(R.id.bgItem, this.mNormalBg[this.mItemType].intValue());
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, PraiseListUserData praiseListUserData, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(praiseListUserData, "item");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (!list.isEmpty()) {
            setupAnim(baseViewHolder, praiseListUserData.getStudentId(), ((Boolean) list.get(0)).booleanValue());
        }
    }

    private final void setupAnim(BaseViewHolder baseViewHolder, String str, boolean z) {
        View view = baseViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        Object tag = view.getTag();
        ValueAnimator valueAnimator = tag instanceof ValueAnimator ? (ValueAnimator) tag : null;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        updateViewState(str, z, baseViewHolder);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(new PraiseListAdapter$$ExternalSyntheticLambda0(view));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.addListener(new PraiseListAdapter$setupAnim$$inlined$addListener$default$1(this, str, z, baseViewHolder));
        ofFloat.setDuration(100);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(1);
        ofFloat.setRepeatMode(2);
        view.setTag(ofFloat);
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupAnim$lambda-1  reason: not valid java name */
    public static final void m386setupAnim$lambda1(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setScaleX(((Float) animatedValue).floatValue());
    }

    public final void setSelfId(String str) {
        this.mSelfUid = str;
    }

    public final void openShowAnim(boolean z, int i) {
        this.mOpenShowAnim = z;
        this.mShownStuNum = i;
    }

    public final void updateShowStuNum(boolean z, int i) {
        int i2 = z ? i - 1 : i;
        if (i2 >= 0 && i2 < getItemCount()) {
            this.mShownStuNum = i;
            notifyItemChanged(i2, Boolean.valueOf(z));
        }
    }
}
