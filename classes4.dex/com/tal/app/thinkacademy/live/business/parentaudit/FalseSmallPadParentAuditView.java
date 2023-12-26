package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditFaleSmallPadBinding;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/FalseSmallPadParentAuditView;", "Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "levelIcons", "", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessParentAuditFaleSmallPadBinding;", "addSurfaceView", "", "surfaceView", "Landroid/view/SurfaceView;", "layout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initViews", "onSizeChanged", "w", "h", "oldw", "oldh", "showChildInfo", "bean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "showMicVolume", "uid", "", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FalseSmallPadParentAuditView.kt */
public final class FalseSmallPadParentAuditView extends BaseParentAuditPluginView {
    private final int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    private LiveBusinessParentAuditFaleSmallPadBinding mViewBinding;

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FalseSmallPadParentAuditView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
    }

    public int getLayoutId() {
        return R.layout.live_business_parent_audit_fale_small_pad;
    }

    public void initViews() {
        super.initViews();
        LiveBusinessParentAuditFaleSmallPadBinding bind = LiveBusinessParentAuditFaleSmallPadBinding.bind(getInflateView().findViewById(R.id.root_audit));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(inflateView.findViewById(R.id.root_audit))");
        this.mViewBinding = bind;
    }

    public void showChildInfo(StudentVideoBean.ListBean listBean) {
        int i;
        Intrinsics.checkNotNullParameter(listBean, "bean");
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding = this.mViewBinding;
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding2 = null;
        if (liveBusinessParentAuditFaleSmallPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditFaleSmallPadBinding = null;
        }
        liveBusinessParentAuditFaleSmallPadBinding.studentName.setText(listBean.getNickName());
        Context context = getContext();
        String avatar = listBean.getAvatar();
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditFaleSmallPadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditFaleSmallPadBinding3 = null;
        }
        ImageLoaderJ.loadCircle(context, avatar, liveBusinessParentAuditFaleSmallPadBinding3.studentHead, R.drawable.common_self_image_user);
        if (listBean.isOnStageAction()) {
            Context context2 = getContext();
            String avatar2 = listBean.getAvatar();
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding4 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding4 = null;
            }
            ImageLoaderJ.loadCircle(context2, avatar2, liveBusinessParentAuditFaleSmallPadBinding4.studentHeadStage, R.drawable.common_self_image_user);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding5 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding5 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding5.studentHeadStageParent.setVisibility(0);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding6 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding6 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding6.studentHead.setVisibility(8);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding7 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding7 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding7.studentLevel.setVisibility(8);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding8 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding8 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding8.studentHeadBgParent.setVisibility(0);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding9 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding9 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding9.studentName.setGravity(17);
        } else {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding10 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding10 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding10.studentName.setGravity(16);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding11 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding11 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding11.studentHeadStageParent.setVisibility(8);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding12 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding12 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding12.studentHead.setVisibility(0);
            if (listBean.getLevel() == 0) {
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding13 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding13 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding13.studentLevel.setVisibility(8);
            } else {
                int level = listBean.getLevel();
                int[] iArr = this.levelIcons;
                if (level > iArr.length) {
                    level = iArr.length;
                }
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding14 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding14 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding14.studentLevel.setImageResource(this.levelIcons[level - 1]);
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding15 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding15 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding15.studentLevel.setVisibility(0);
            }
            if (!listBean.isOpenCamera() || getMSurfaceView() == null) {
                i = 0;
            } else {
                SurfaceView mSurfaceView = getMSurfaceView();
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding16 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding16 = null;
                }
                FrameLayout frameLayout = liveBusinessParentAuditFaleSmallPadBinding16.studentVideoContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mViewBinding.studentVideoContainer");
                addSurfaceView(mSurfaceView, frameLayout);
                i = 8;
            }
            if (listBean.isDisableTheVideo()) {
                i = 0;
            }
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding17 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding17 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding17.studentHeadBgParent.setVisibility(i);
        }
        if (listBean.isOnStageAction()) {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding18 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding18 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding18.micParentView.setVisibility(8);
        } else {
            if (listBean.isOpenMic()) {
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding19 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding19 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding19.micHide.setVisibility(8);
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding20 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding20 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding20.micShow.setVisibility(0);
            } else {
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding21 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding21 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding21.micHide.setVisibility(0);
                LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding22 = this.mViewBinding;
                if (liveBusinessParentAuditFaleSmallPadBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditFaleSmallPadBinding22 = null;
                }
                liveBusinessParentAuditFaleSmallPadBinding22.micShow.setVisibility(8);
            }
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding23 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding23 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding23.micParentView.setVisibility(0);
        }
        if (!listBean.isRaiseHandUp() || listBean.isOnStageAction()) {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding24 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding24 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding24.handUpImage.setVisibility(8);
        } else {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding25 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding25 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding25.handUpImage.setVisibility(0);
        }
        if (!listBean.isShowEmoji() || listBean.isOnStageAction() || listBean.isHerselfOff()) {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding26 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding26 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding26.emojiView.setVisibility(8);
        } else {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding27 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding27 = null;
            }
            EmojiView emojiView = liveBusinessParentAuditFaleSmallPadBinding27.emojiView;
            Intrinsics.checkNotNullExpressionValue(emojiView, "mViewBinding.emojiView");
            EmojiView.setData$default(emojiView, listBean.getEmojiBean(), (Boolean) null, (Function0) null, 6, (Object) null);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding28 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding28 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding28.emojiView.setVisibility(0);
        }
        if (!listBean.isStudentOnline()) {
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding29 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding29 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding29.studentHead.setVisibility(8);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding30 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditFaleSmallPadBinding30 = null;
            }
            liveBusinessParentAuditFaleSmallPadBinding30.offlineView.setVisibility(0);
            LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding31 = this.mViewBinding;
            if (liveBusinessParentAuditFaleSmallPadBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                liveBusinessParentAuditFaleSmallPadBinding2 = liveBusinessParentAuditFaleSmallPadBinding31;
            }
            liveBusinessParentAuditFaleSmallPadBinding2.micParentView.setVisibility(8);
            return;
        }
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding32 = this.mViewBinding;
        if (liveBusinessParentAuditFaleSmallPadBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditFaleSmallPadBinding32 = null;
        }
        liveBusinessParentAuditFaleSmallPadBinding32.offlineView.setVisibility(8);
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding33 = this.mViewBinding;
        if (liveBusinessParentAuditFaleSmallPadBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditFaleSmallPadBinding2 = liveBusinessParentAuditFaleSmallPadBinding33;
        }
        liveBusinessParentAuditFaleSmallPadBinding2.micParentView.setVisibility(0);
    }

    public void showMicVolume(long j, int i) {
        LiveBusinessParentAuditFaleSmallPadBinding liveBusinessParentAuditFaleSmallPadBinding = this.mViewBinding;
        if (liveBusinessParentAuditFaleSmallPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditFaleSmallPadBinding = null;
        }
        liveBusinessParentAuditFaleSmallPadBinding.micShow.getDrawable().setLevel((i * 10000) / 255);
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
}
