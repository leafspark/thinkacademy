package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import com.tal.app.thinkacademy.live.business.studentvideo.animator.HandUpAnimator;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J(\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0014J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0014H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/SmallPadParentAuditPluginView;", "Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "levelIcons", "", "mHandUpAnimator", "Lcom/tal/app/thinkacademy/live/business/studentvideo/animator/HandUpAnimator;", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessParentAuditSmallPadBinding;", "addSurfaceView", "", "surfaceView", "Landroid/view/SurfaceView;", "layout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initViews", "onSizeChanged", "w", "h", "oldw", "oldh", "reLayoutChildView", "height", "showChildInfo", "bean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "showMicVolume", "uid", "", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmallPadParentAuditPluginView.kt */
public final class SmallPadParentAuditPluginView extends BaseParentAuditPluginView {
    private final int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    private HandUpAnimator mHandUpAnimator;
    private LiveBusinessParentAuditSmallPadBinding mViewBinding;

    public void showMicVolume(long j, int i) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallPadParentAuditPluginView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
    }

    public int getLayoutId() {
        return R.layout.live_business_parent_audit_small_pad;
    }

    public void initViews() {
        super.initViews();
        LiveBusinessParentAuditSmallPadBinding bind = LiveBusinessParentAuditSmallPadBinding.bind(getInflateView().findViewById(R.id.root_audit));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(inflateView.findViewById(R.id.root_audit))");
        this.mViewBinding = bind;
        HandUpAnimator.Companion companion = HandUpAnimator.Companion;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding = this.mViewBinding;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding2 = null;
        if (liveBusinessParentAuditSmallPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding = null;
        }
        ImageView imageView = liveBusinessParentAuditSmallPadBinding.handUpImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "mViewBinding.handUpImage");
        View view = imageView;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditSmallPadBinding2 = liveBusinessParentAuditSmallPadBinding3;
        }
        View view2 = liveBusinessParentAuditSmallPadBinding2.handUpViewBg;
        Intrinsics.checkNotNullExpressionValue(view2, "mViewBinding.handUpViewBg");
        this.mHandUpAnimator = companion.create(view, view2);
    }

    public void showChildInfo(StudentVideoBean.ListBean listBean) {
        int i;
        Intrinsics.checkNotNullParameter(listBean, "bean");
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding = this.mViewBinding;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding2 = null;
        if (liveBusinessParentAuditSmallPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding = null;
        }
        liveBusinessParentAuditSmallPadBinding.studentName.setText(listBean.getNickName());
        Context context = getContext();
        String avatar = listBean.getAvatar();
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding3 = null;
        }
        ImageLoaderJ.loadCircle(context, avatar, liveBusinessParentAuditSmallPadBinding3.studentHead, R.drawable.common_self_image_user);
        if (listBean.isOnStageAction()) {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding4 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding4 = null;
            }
            liveBusinessParentAuditSmallPadBinding4.studentHeadStage.setVisibility(0);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding5 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding5 = null;
            }
            liveBusinessParentAuditSmallPadBinding5.studentHead.setVisibility(8);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding6 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding6 = null;
            }
            liveBusinessParentAuditSmallPadBinding6.studentLevel.setVisibility(8);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding7 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding7 = null;
            }
            liveBusinessParentAuditSmallPadBinding7.studentHeadBgParent.setVisibility(0);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding8 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding8 = null;
            }
            liveBusinessParentAuditSmallPadBinding8.studentName.setGravity(17);
        } else {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding9 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding9 = null;
            }
            liveBusinessParentAuditSmallPadBinding9.studentName.setGravity(16);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding10 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding10 = null;
            }
            liveBusinessParentAuditSmallPadBinding10.studentHeadStage.setVisibility(8);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding11 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding11 = null;
            }
            liveBusinessParentAuditSmallPadBinding11.studentHead.setVisibility(0);
            if (listBean.getLevel() == 0) {
                LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding12 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPadBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPadBinding12 = null;
                }
                liveBusinessParentAuditSmallPadBinding12.studentLevel.setVisibility(8);
            } else {
                int level = listBean.getLevel();
                int[] iArr = this.levelIcons;
                if (level > iArr.length) {
                    level = iArr.length;
                }
                LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding13 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPadBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPadBinding13 = null;
                }
                liveBusinessParentAuditSmallPadBinding13.studentLevel.setImageResource(this.levelIcons[level - 1]);
                LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding14 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPadBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPadBinding14 = null;
                }
                liveBusinessParentAuditSmallPadBinding14.studentLevel.setVisibility(0);
            }
            if (!listBean.isOpenCamera() || getMSurfaceView() == null) {
                i = 0;
            } else {
                SurfaceView mSurfaceView = getMSurfaceView();
                LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding15 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPadBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPadBinding15 = null;
                }
                FrameLayout frameLayout = liveBusinessParentAuditSmallPadBinding15.studentVideoContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mViewBinding.studentVideoContainer");
                addSurfaceView(mSurfaceView, frameLayout);
                i = 8;
            }
            if (listBean.isDisableTheVideo()) {
                i = 0;
            }
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding16 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding16 = null;
            }
            liveBusinessParentAuditSmallPadBinding16.studentHeadBgParent.setVisibility(i);
        }
        if (listBean.isOnStageAction()) {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding17 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding17 = null;
            }
            liveBusinessParentAuditSmallPadBinding17.ivStudentMic.setVisibility(8);
        } else {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding18 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding18 = null;
            }
            liveBusinessParentAuditSmallPadBinding18.ivStudentMic.setEnabled(listBean.isOpenMic());
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding19 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding19 = null;
            }
            liveBusinessParentAuditSmallPadBinding19.ivStudentMic.setVisibility(0);
        }
        if (!listBean.isRaiseHandUp() || listBean.isOnStageAction()) {
            HandUpAnimator handUpAnimator = this.mHandUpAnimator;
            if (handUpAnimator != null) {
                handUpAnimator.hide();
            }
        } else {
            HandUpAnimator handUpAnimator2 = this.mHandUpAnimator;
            if (handUpAnimator2 != null) {
                handUpAnimator2.show();
            }
        }
        if (!listBean.isShowEmoji() || listBean.isOnStageAction() || listBean.isHerselfOff()) {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding20 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding20 = null;
            }
            liveBusinessParentAuditSmallPadBinding20.emojiView.setVisibility(8);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding21 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding21 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding21 = null;
            }
            liveBusinessParentAuditSmallPadBinding21.emojiViewBg.setVisibility(8);
        } else {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding22 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding22 = null;
            }
            EmojiView emojiView = liveBusinessParentAuditSmallPadBinding22.emojiView;
            Intrinsics.checkNotNullExpressionValue(emojiView, "mViewBinding.emojiView");
            EmojiView.setData$default(emojiView, listBean.getEmojiBean(), (Boolean) null, (Function0) null, 6, (Object) null);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding23 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding23 = null;
            }
            liveBusinessParentAuditSmallPadBinding23.emojiView.setVisibility(0);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding24 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding24 = null;
            }
            liveBusinessParentAuditSmallPadBinding24.emojiViewBg.setVisibility(0);
        }
        if (!listBean.isStudentOnline()) {
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding25 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding25 = null;
            }
            liveBusinessParentAuditSmallPadBinding25.studentHead.setVisibility(8);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding26 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPadBinding26 = null;
            }
            liveBusinessParentAuditSmallPadBinding26.offlineView.setVisibility(0);
            LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding27 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPadBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                liveBusinessParentAuditSmallPadBinding2 = liveBusinessParentAuditSmallPadBinding27;
            }
            liveBusinessParentAuditSmallPadBinding2.ivStudentMic.setVisibility(8);
            return;
        }
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding28 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding28 = null;
        }
        liveBusinessParentAuditSmallPadBinding28.offlineView.setVisibility(8);
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding29 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditSmallPadBinding2 = liveBusinessParentAuditSmallPadBinding29;
        }
        liveBusinessParentAuditSmallPadBinding2.ivStudentMic.setVisibility(0);
    }

    private final void addSurfaceView(SurfaceView surfaceView, FrameLayout frameLayout) {
        if (surfaceView != null) {
            boolean z = true;
            if (surfaceView.getParent() != null) {
                if (surfaceView.getParent() != frameLayout) {
                    ViewParent parent = surfaceView.getParent();
                    Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(surfaceView);
                } else {
                    z = false;
                }
            }
            if (z) {
                frameLayout.removeAllViews();
                frameLayout.addView(surfaceView, 0);
            }
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        reLayoutChildView(LiveAreaContext.get().getHeadLp().height);
    }

    public void reLayoutChildView(int i) {
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding = this.mViewBinding;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding2 = null;
        if (liveBusinessParentAuditSmallPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding = null;
        }
        ViewGroup.LayoutParams layoutParams = liveBusinessParentAuditSmallPadBinding.studentHead.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i2 = (i * 64) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams2.height = i2;
        layoutParams2.width = layoutParams2.height;
        int i3 = (i * 30) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams2.topMargin = i3;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding3 = null;
        }
        ViewGroup.LayoutParams layoutParams3 = liveBusinessParentAuditSmallPadBinding3.studentHeadStage.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.width = (i * 54) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams4.height = (i * 62) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding4 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding4 = null;
        }
        ViewGroup.LayoutParams layoutParams5 = liveBusinessParentAuditSmallPadBinding4.studentLevel.getLayoutParams();
        Objects.requireNonNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.width = (i * 40) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams6.height = (i * 18) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        int i4 = (i * 4) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams6.leftMargin = i4;
        layoutParams6.topMargin = i4;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding5 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding5 = null;
        }
        ViewGroup.LayoutParams layoutParams7 = liveBusinessParentAuditSmallPadBinding5.emojiView.getLayoutParams();
        Objects.requireNonNull(layoutParams7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.height = i2;
        layoutParams8.width = layoutParams8.height;
        layoutParams8.topMargin = i3;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding6 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding6 = null;
        }
        ViewGroup.LayoutParams layoutParams9 = liveBusinessParentAuditSmallPadBinding6.handUpImage.getLayoutParams();
        Objects.requireNonNull(layoutParams9, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.width = (i * 78) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams10.height = (i * 117) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding7 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding7 = null;
        }
        ViewGroup.LayoutParams layoutParams11 = liveBusinessParentAuditSmallPadBinding7.bottomLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams11, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams11).height = (i * 28) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding8 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding8 = null;
        }
        ViewGroup.LayoutParams layoutParams12 = liveBusinessParentAuditSmallPadBinding8.ivStudentMic.getLayoutParams();
        Objects.requireNonNull(layoutParams12, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) layoutParams12;
        int i5 = (i * 14) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams13.width = i5;
        layoutParams13.height = i5;
        layoutParams13.rightMargin = i4;
        layoutParams13.bottomMargin = i4;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding9 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPadBinding9 = null;
        }
        ViewGroup.LayoutParams layoutParams14 = liveBusinessParentAuditSmallPadBinding9.studentName.getLayoutParams();
        Objects.requireNonNull(layoutParams14, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) layoutParams14;
        layoutParams15.leftMargin = i4;
        layoutParams15.rightMargin = (i * 6) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN;
        layoutParams15.bottomMargin = i4;
        LiveBusinessParentAuditSmallPadBinding liveBusinessParentAuditSmallPadBinding10 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPadBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditSmallPadBinding2 = liveBusinessParentAuditSmallPadBinding10;
        }
        liveBusinessParentAuditSmallPadBinding2.studentName.setTextSize(0, (float) ((i * 12) / LiveMessageCode.LIVE_BUSINESS_GROUP3V3_GROUP_FORBIDDEN));
    }
}
