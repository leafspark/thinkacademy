package com.tal.app.thinkacademy.live.business.direction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.SoundPoolUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldSmallClassPadViewBinding;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import com.tal.app.thinkacademy.live.util.LiveMainHandler;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGImageView;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001-B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ \u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0014H\u0014J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\u0012\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010)\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010*\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010+\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010,\u001a\u00020\"H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldSmallClassPadPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessDirectionGoldSmallClassPadViewBinding;", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "context", "Landroid/content/Context;", "directionBean", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "mListener", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;", "type", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;Ljava/lang/String;)V", "getDirectionBean", "()Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "getMListener", "()Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;", "setMListener", "(Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;)V", "needSyncCoin", "", "getNeedSyncCoin", "()Z", "setNeedSyncCoin", "(Z)V", "getType", "()Ljava/lang/String;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "destroy", "", "hide", "initView", "onAnimationCancel", "p0", "Lorg/libpag/PAGImageView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "onAnimationUpdate", "show", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionGoldSmallClassPadPluginView.kt */
public final class DirectionGoldSmallClassPadPluginView extends BaseVBLivePluginView<LiveBusinessDirectionGoldSmallClassPadViewBinding> implements PAGImageView.PAGImageViewListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.DIRECTION_GOLD;
    private final DirectionBean directionBean;
    private DirectionGoldListener mListener;
    private boolean needSyncCoin;
    private final String type;

    public void onAnimationCancel(PAGImageView pAGImageView) {
    }

    public void onAnimationRepeat(PAGImageView pAGImageView) {
    }

    public void onAnimationUpdate(PAGImageView pAGImageView) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DirectionGoldSmallClassPadPluginView(Context context, DirectionBean directionBean2, DirectionGoldListener directionGoldListener, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
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
    public DirectionGoldSmallClassPadPluginView(Context context, DirectionBean directionBean2, DirectionGoldListener directionGoldListener, String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.directionBean = directionBean2;
        this.mListener = directionGoldListener;
        this.type = str;
        initView();
    }

    public final boolean getNeedSyncCoin() {
        return this.needSyncCoin;
    }

    public final void setNeedSyncCoin(boolean z) {
        this.needSyncCoin = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldSmallClassPadPluginView$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DirectionGoldSmallClassPadPluginView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void initView() {
        DirectionBean directionBean2 = this.directionBean;
        if (directionBean2 != null) {
            boolean z = false;
            if (directionBean2.getUsers().size() > 0) {
                Iterator<UsersBean> it = directionBean2.getUsers().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String valueOf = String.valueOf(it.next().getUserId());
                    UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                    if (Intrinsics.areEqual(valueOf, userInfoEntity == null ? null : userInfoEntity.getUid())) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                setNeedSyncCoin(true);
                LiveMainHandler.postDelayed(new DirectionGoldSmallClassPadPluginView$$ExternalSyntheticLambda0(this), 400);
                this.mBinding.layoutCoins.setUp(directionBean2.getRewardCoinNum());
                show();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1$lambda-0  reason: not valid java name */
    public static final void m206initView$lambda1$lambda0(DirectionGoldSmallClassPadPluginView directionGoldSmallClassPadPluginView) {
        Intrinsics.checkNotNullParameter(directionGoldSmallClassPadPluginView, "this$0");
        SoundPoolUtils.play(directionGoldSmallClassPadPluginView.getContext(), R.raw.live_business_interact_new_show, 0);
    }

    private final void show() {
        this.mBinding.pagConis.setPath("assets://direction/coins_turn_around.pag");
        this.mBinding.pagConis.addListener((PAGImageView.PAGImageViewListener) this);
        this.mBinding.pagConis.play();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.mBinding.layout, new PropertyValuesHolder[]{ofFloat, ofFloat2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(m…ayoutTransX, layoutAlpha)");
        Animator animator = ofPropertyValuesHolder;
        animator.setDuration(600);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mBinding.tvName, View.ALPHA, new float[]{1.0f});
        ofFloat3.setDuration(200);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mBinding.layoutCoins, View.ALPHA, new float[]{1.0f});
        ofFloat4.setDuration(200);
        Keyframe ofFloat5 = Keyframe.ofFloat(0.0f, 1.6f);
        Keyframe ofFloat6 = Keyframe.ofFloat(0.4f, 0.94f);
        Keyframe ofFloat7 = Keyframe.ofFloat(0.8f, 1.02f);
        Keyframe ofFloat8 = Keyframe.ofFloat(1.0f, 1.0f);
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[]{ofFloat5, ofFloat6, ofFloat7, ofFloat8});
        PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[]{ofFloat5, ofFloat6, ofFloat7, ofFloat8});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.mBinding.layoutCoins, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(m…coinsScaleX, coinsScaleY)");
        Animator animator2 = ofPropertyValuesHolder2;
        animator2.setDuration(500);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator2).with(ofFloat4).with(ofFloat3).after(animator);
        animatorSet.start();
    }

    private final void hide() {
        ViewPropertyAnimator listener = this.mBinding.layout.animate().alpha(0.0f).setDuration(200).setListener(new DirectionGoldSmallClassPadPluginView$hide$animator$1(this));
        Intrinsics.checkNotNullExpressionValue(listener, "private fun hide() {\n   …   animator.start()\n    }");
        listener.start();
    }

    public final void destroy() {
        this.needSyncCoin = false;
        this.mBinding.pagConis.pause();
        this.mBinding.pagConis.removeListener((PAGImageView.PAGImageViewListener) this);
        this.mListener = null;
    }

    /* access modifiers changed from: protected */
    public LiveBusinessDirectionGoldSmallClassPadViewBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessDirectionGoldSmallClassPadViewBinding inflate = LiveBusinessDirectionGoldSmallClassPadViewBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void onAnimationStart(PAGImageView pAGImageView) {
        DirectionGoldListener directionGoldListener = this.mListener;
        if (directionGoldListener != null) {
            directionGoldListener.updateUserCoins();
        }
    }

    public void onAnimationEnd(PAGImageView pAGImageView) {
        this.needSyncCoin = false;
        hide();
    }
}
