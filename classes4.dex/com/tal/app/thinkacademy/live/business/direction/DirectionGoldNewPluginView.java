package com.tal.app.thinkacademy.live.business.direction;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.airbnb.lottie.LottieAnimationView;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.redpackagerain.RedPackageRainViewModel;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ \u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldNewPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessDirectionGoldNewViewBinding;", "context", "Landroid/content/Context;", "directionBean", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "mListener", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;", "type", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;Ljava/lang/String;)V", "getDirectionBean", "()Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "getMListener", "()Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;", "setMListener", "(Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;)V", "mViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/redpackagerain/RedPackageRainViewModel;", "getType", "()Ljava/lang/String;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "", "hideDirectionGoldView", "isMe", "initEvent", "initView", "nickNameShow", "name", "showDirectionOtherGoldView", "unInitEvent", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionGoldNewPluginView.kt */
public final class DirectionGoldNewPluginView extends BaseVBLivePluginView<LiveBusinessDirectionGoldNewViewBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.DIRECTION_GOLD;
    private final DirectionBean directionBean;
    private DirectionGoldListener mListener;
    private RedPackageRainViewModel mViewModel;
    private final String type;

    private final void initEvent() {
    }

    private final void unInitEvent() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DirectionGoldNewPluginView(Context context, DirectionBean directionBean2, DirectionGoldListener directionGoldListener, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, directionBean2, directionGoldListener, (i & 8) != 0 ? null : str);
    }

    public final DirectionBean getDirectionBean() {
        return this.directionBean;
    }

    public final DirectionGoldListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(DirectionGoldListener directionGoldListener) {
        this.mListener = directionGoldListener;
    }

    public final String getType() {
        return this.type;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DirectionGoldNewPluginView(Context context, DirectionBean directionBean2, DirectionGoldListener directionGoldListener, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.directionBean = directionBean2;
        this.mListener = directionGoldListener;
        this.type = str;
        this.mViewModel = AbilityPackKt.getAbilityPack().getViewModel(RedPackageRainViewModel.class);
        initEvent();
        initView();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldNewPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DirectionGoldNewPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView() {
        /*
            r10 = this;
            com.tal.app.thinkacademy.live.business.direction.DirectionBean r0 = r10.directionBean
            if (r0 != 0) goto L_0x0006
            goto L_0x023d
        L_0x0006:
            java.util.List r1 = r0.getUsers()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0051
            java.util.List r1 = r0.getUsers()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0051
            java.util.List r1 = r0.getUsers()
            java.util.Iterator r1 = r1.iterator()
        L_0x0021:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0051
            java.lang.Object r5 = r1.next()
            com.tal.app.thinkacademy.live.business.direction.UsersBean r5 = (com.tal.app.thinkacademy.live.business.direction.UsersBean) r5
            if (r5 == 0) goto L_0x0021
            int r5 = r5.getUserId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r6 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r6 = r6.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r6 = r6.getUserInfoEntity()
            if (r6 != 0) goto L_0x0045
            r6 = r3
            goto L_0x0049
        L_0x0045:
            java.lang.String r6 = r6.getUid()
        L_0x0049:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x0021
            r1 = r2
            goto L_0x0052
        L_0x0051:
            r1 = r4
        L_0x0052:
            java.lang.String r5 = "+"
            r6 = 8
            if (r1 == 0) goto L_0x0151
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView$$ExternalSyntheticLambda0 r1 = new com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView$$ExternalSyntheticLambda0
            r1.<init>(r10)
            r7 = 400(0x190, double:1.976E-321)
            com.tal.app.thinkacademy.live.util.LiveMainHandler.postDelayed(r1, r7)
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.directionGoldLottie
            r1.setVisibility(r4)
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.directionOtherGoldCL
            r1.setVisibility(r6)
            com.tal.app.thinkacademy.live.core.layout.LiveAreaContext r1 = com.tal.app.thinkacademy.live.core.layout.LiveAreaContext.get()
            com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams r1 = r1.getPptLp()
            android.widget.FrameLayout$LayoutParams r1 = r1.newLp()
            androidx.viewbinding.ViewBinding r2 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r2 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r2
            com.airbnb.lottie.LottieAnimationView r2 = r2.directionGoldLottie
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            boolean r4 = r2 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r4 == 0) goto L_0x0091
            r3 = r2
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r3 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r3
        L_0x0091:
            android.content.Context r2 = r10.mContext
            boolean r2 = com.tal.app.thinkacademy.common.util.PadUtils.isPad(r2)
            if (r2 == 0) goto L_0x00c3
            if (r3 != 0) goto L_0x009c
            goto L_0x00b0
        L_0x009c:
            int r2 = r1.getMarginStart()
            int r4 = r1.width
            android.content.res.Resources r6 = r10.getResources()
            int r7 = com.tal.app.thinkacademy.live.business.R.dimen.size_162dp
            int r6 = r6.getDimensionPixelOffset(r7)
            int r4 = r4 - r6
            int r2 = r2 + r4
            r3.leftMargin = r2
        L_0x00b0:
            if (r3 != 0) goto L_0x00b3
            goto L_0x00ec
        L_0x00b3:
            int r1 = r1.topMargin
            android.content.res.Resources r2 = r10.getResources()
            int r4 = com.tal.app.thinkacademy.live.business.R.dimen.size_21dp
            int r2 = r2.getDimensionPixelOffset(r4)
            int r1 = r1 - r2
            r3.topMargin = r1
            goto L_0x00ec
        L_0x00c3:
            if (r3 != 0) goto L_0x00c6
            goto L_0x00da
        L_0x00c6:
            int r2 = r1.getMarginStart()
            int r4 = r1.width
            android.content.res.Resources r6 = r10.getResources()
            int r7 = com.tal.app.thinkacademy.live.business.R.dimen.size_162dp
            int r6 = r6.getDimensionPixelOffset(r7)
            int r4 = r4 - r6
            int r2 = r2 + r4
            r3.leftMargin = r2
        L_0x00da:
            if (r3 != 0) goto L_0x00dd
            goto L_0x00ec
        L_0x00dd:
            int r1 = r1.topMargin
            android.content.res.Resources r2 = r10.getResources()
            int r4 = com.tal.app.thinkacademy.live.business.R.dimen.size_50dp
            int r2 = r2.getDimensionPixelOffset(r4)
            int r1 = r1 + r2
            r3.topMargin = r1
        L_0x00ec:
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.directionGoldLottie
            java.lang.String r2 = "direction/images"
            r1.setImageAssetsFolder(r2)
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.directionGoldLottie
            java.lang.String r2 = "direction/data.json"
            r1.setAnimation(r2)
            com.airbnb.lottie.TextDelegate r1 = new com.airbnb.lottie.TextDelegate
            androidx.viewbinding.ViewBinding r2 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r2 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r2
            com.airbnb.lottie.LottieAnimationView r2 = r2.directionGoldLottie
            r1.<init>(r2)
            android.content.res.Resources r2 = r10.getResources()
            int r3 = com.tal.app.thinkacademy.live.business.R.string.direction_gold_get_coin
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "${c_desp}"
            r1.setText(r3, r2)
            int r0 = r0.getRewardCoinNum()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r0)
            java.lang.String r2 = "${c_num}"
            r1.setText(r2, r0)
            androidx.viewbinding.ViewBinding r0 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r0
            com.airbnb.lottie.LottieAnimationView r0 = r0.directionGoldLottie
            r0.setTextDelegate(r1)
            androidx.viewbinding.ViewBinding r0 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r0
            com.airbnb.lottie.LottieAnimationView r0 = r0.directionGoldLottie
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView$initView$1$2 r1 = new com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView$initView$1$2
            r1.<init>(r10)
            android.animation.Animator$AnimatorListener r1 = (android.animation.Animator.AnimatorListener) r1
            r0.addAnimatorListener(r1)
            androidx.viewbinding.ViewBinding r0 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r0 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r0
            com.airbnb.lottie.LottieAnimationView r0 = r0.directionGoldLottie
            r0.playAnimation()
            goto L_0x023d
        L_0x0151:
            java.lang.String r1 = r10.getType()
            java.lang.String r7 = "schulteGrid"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
            if (r1 == 0) goto L_0x015e
            return
        L_0x015e:
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            com.airbnb.lottie.LottieAnimationView r1 = r1.directionGoldLottie
            r1.setVisibility(r6)
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            androidx.constraintlayout.widget.ConstraintLayout r1 = r1.directionOtherGoldCL
            r1.setVisibility(r4)
            com.tal.app.thinkacademy.live.core.layout.LiveAreaContext r1 = com.tal.app.thinkacademy.live.core.layout.LiveAreaContext.get()
            com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams r1 = r1.getPptLp()
            androidx.viewbinding.ViewBinding r6 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r6 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r6
            androidx.constraintlayout.widget.ConstraintLayout r6 = r6.directionOtherGoldCL
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            boolean r7 = r6 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r7 == 0) goto L_0x0189
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r6 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r6
            goto L_0x018a
        L_0x0189:
            r6 = r3
        L_0x018a:
            if (r6 != 0) goto L_0x018d
            goto L_0x019c
        L_0x018d:
            int r7 = r1.right
            android.content.res.Resources r8 = r10.getResources()
            int r9 = com.tal.app.thinkacademy.live.business.R.dimen.size_8dp
            int r8 = r8.getDimensionPixelOffset(r9)
            int r7 = r7 + r8
            r6.rightMargin = r7
        L_0x019c:
            android.content.Context r7 = r10.mContext
            boolean r7 = com.tal.app.thinkacademy.common.util.PadUtils.isPad(r7)
            if (r7 == 0) goto L_0x01b7
            if (r6 != 0) goto L_0x01a7
            goto L_0x01c9
        L_0x01a7:
            int r1 = r1.top
            android.content.res.Resources r7 = r10.getResources()
            int r8 = com.tal.app.thinkacademy.live.business.R.dimen.size_13dp
            int r7 = r7.getDimensionPixelOffset(r8)
            int r1 = r1 + r7
            r6.topMargin = r1
            goto L_0x01c9
        L_0x01b7:
            if (r6 != 0) goto L_0x01ba
            goto L_0x01c9
        L_0x01ba:
            int r1 = r1.top
            android.content.res.Resources r7 = r10.getResources()
            int r8 = com.tal.app.thinkacademy.live.business.R.dimen.size_32dp
            int r7 = r7.getDimensionPixelOffset(r8)
            int r1 = r1 + r7
            r6.topMargin = r1
        L_0x01c9:
            java.util.List r1 = r0.getUsers()
            int r6 = r1.size()
            if (r6 <= 0) goto L_0x0215
            int r3 = r1.size()
            if (r3 <= r2) goto L_0x0206
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Object r1 = r1.get(r4)
            com.tal.app.thinkacademy.live.business.direction.UsersBean r1 = (com.tal.app.thinkacademy.live.business.direction.UsersBean) r1
            java.lang.String r1 = r1.getNickName()
            java.lang.String r1 = r10.nickNameShow(r1)
            r2.append(r1)
            r1 = 32
            r2.append(r1)
            android.content.res.Resources r1 = r10.getResources()
            int r3 = com.tal.app.thinkacademy.live.business.R.string.direction_gold_others
            java.lang.String r1 = r1.getString(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x0214
        L_0x0206:
            java.lang.Object r1 = r1.get(r4)
            com.tal.app.thinkacademy.live.business.direction.UsersBean r1 = (com.tal.app.thinkacademy.live.business.direction.UsersBean) r1
            java.lang.String r1 = r1.getNickName()
            java.lang.String r1 = r10.nickNameShow(r1)
        L_0x0214:
            r3 = r1
        L_0x0215:
            if (r3 != 0) goto L_0x0218
            goto L_0x0223
        L_0x0218:
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            android.widget.TextView r1 = r1.directionOtherNameTV
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
        L_0x0223:
            int r0 = r0.getRewardCoinNum()
            androidx.viewbinding.ViewBinding r1 = r10.mBinding
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r1 = (com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding) r1
            android.widget.TextView r1 = r1.directionOtherGoldTV
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1.setText(r0)
            r10.showDirectionOtherGoldView()
        L_0x023d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView.initView():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-4$lambda-0  reason: not valid java name */
    public static final void m202initView$lambda4$lambda0(DirectionGoldNewPluginView directionGoldNewPluginView) {
        Intrinsics.checkNotNullParameter(directionGoldNewPluginView, "this$0");
        SoundPoolUtils.play(directionGoldNewPluginView.getContext(), R.raw.live_business_interact_new_show, 0);
    }

    private final String nickNameShow(String str) {
        if (str.length() <= 20) {
            return str;
        }
        String substring = str.substring(0, 20);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return Intrinsics.stringPlus(substring, "...");
    }

    public final void destroy() {
        unInitEvent();
        this.mListener = null;
    }

    /* access modifiers changed from: private */
    public final void hideDirectionGoldView(boolean z) {
        LottieAnimationView lottieAnimationView;
        String str;
        if (z) {
            lottieAnimationView = this.mBinding.directionGoldLottie;
            str = "mBinding.directionGoldLottie";
        } else {
            lottieAnimationView = this.mBinding.directionOtherGoldCL;
            str = "mBinding.directionOtherGoldCL";
        }
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, str);
        ObjectAnimator duration = ObjectAnimator.ofFloat((View) lottieAnimationView, "alpha", new float[]{1.0f, 0.0f}).setDuration(400);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(\n               …        .setDuration(400)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration);
        animatorSet.addListener(new DirectionGoldNewPluginView$hideDirectionGoldView$1(this));
        animatorSet.start();
    }

    private final void showDirectionOtherGoldView() {
        this.mBinding.directionOtherGoldCL.post(new DirectionGoldNewPluginView$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showDirectionOtherGoldView$lambda-5  reason: not valid java name */
    public static final void m203showDirectionOtherGoldView$lambda5(DirectionGoldNewPluginView directionGoldNewPluginView) {
        Intrinsics.checkNotNullParameter(directionGoldNewPluginView, "this$0");
        directionGoldNewPluginView.mBinding.directionOtherGoldCL.setPivotX(0.0f);
        directionGoldNewPluginView.mBinding.directionOtherGoldCL.setPivotY((float) directionGoldNewPluginView.mBinding.directionOtherGoldCL.getHeight());
        ObjectAnimator duration = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherGoldCL, "scaleX", new float[]{0.0f, 1.1f, 1.0f}).setDuration(800);
        Intrinsics.checkNotNullExpressionValue(duration, "ofFloat(mBinding.directi…        .setDuration(800)");
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherGoldCL, "scaleY", new float[]{0.0f, 1.1f, 1.0f}).setDuration(800);
        Intrinsics.checkNotNullExpressionValue(duration2, "ofFloat(mBinding.directi…        .setDuration(800)");
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherGoldCL, "alpha", new float[]{0.0f, 1.0f}).setDuration(600);
        Intrinsics.checkNotNullExpressionValue(duration3, "ofFloat(mBinding.directi…        .setDuration(600)");
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherNameTV, "alpha", new float[]{0.0f, 1.0f}).setDuration(400);
        Intrinsics.checkNotNullExpressionValue(duration4, "ofFloat(mBinding.directi…        .setDuration(400)");
        ObjectAnimator duration5 = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherGoldIV, "alpha", new float[]{0.0f, 1.0f}).setDuration(400);
        Intrinsics.checkNotNullExpressionValue(duration5, "ofFloat(mBinding.directi…        .setDuration(400)");
        ObjectAnimator duration6 = ObjectAnimator.ofFloat(directionGoldNewPluginView.mBinding.directionOtherGoldTV, "alpha", new float[]{0.0f, 1.0f}).setDuration(400);
        Intrinsics.checkNotNullExpressionValue(duration6, "ofFloat(mBinding.directi…        .setDuration(400)");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).with(duration3);
        animatorSet.play(duration4).after(600);
        animatorSet.play(duration5).after(800);
        animatorSet.play(duration6).after(880);
        animatorSet.addListener(new DirectionGoldNewPluginView$showDirectionOtherGoldView$1$1(directionGoldNewPluginView));
        animatorSet.start();
    }

    /* access modifiers changed from: protected */
    public LiveBusinessDirectionGoldNewViewBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessDirectionGoldNewViewBinding inflate = LiveBusinessDirectionGoldNewViewBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
