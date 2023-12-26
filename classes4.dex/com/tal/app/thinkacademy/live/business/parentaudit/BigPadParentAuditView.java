package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/BigPadParentAuditView;", "Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "levelIcons", "", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessParentAuditBigPadBinding;", "addSurfaceView", "", "surfaceView", "Landroid/view/SurfaceView;", "layout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initViews", "onSizeChanged", "w", "h", "oldw", "oldh", "showChildInfo", "bean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "showMicVolume", "uid", "", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigPadParentAuditView.kt */
public class BigPadParentAuditView extends BaseParentAuditPluginView {
    private final int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    private LiveBusinessParentAuditBigPadBinding mViewBinding;

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BigPadParentAuditView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
    }

    public int getLayoutId() {
        return R.layout.live_business_parent_audit_big_pad;
    }

    public void initViews() {
        super.initViews();
        LiveBusinessParentAuditBigPadBinding bind = LiveBusinessParentAuditBigPadBinding.bind(getInflateView().findViewById(R.id.root_audit));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(inflateView.findViewById(R.id.root_audit))");
        this.mViewBinding = bind;
    }

    public void showChildInfo(StudentVideoBean.ListBean listBean) {
        int i;
        Intrinsics.checkNotNullParameter(listBean, "bean");
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding = this.mViewBinding;
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding2 = null;
        if (liveBusinessParentAuditBigPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditBigPadBinding = null;
        }
        liveBusinessParentAuditBigPadBinding.studentName.setText(listBean.getNickName());
        Context context = getContext();
        String avatar = listBean.getAvatar();
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditBigPadBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditBigPadBinding3 = null;
        }
        ImageLoaderJ.loadCircle(context, avatar, liveBusinessParentAuditBigPadBinding3.studentHead, R.drawable.common_self_image_user);
        if (listBean.isOnStageAction()) {
            Context context2 = getContext();
            String avatar2 = listBean.getAvatar();
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding4 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding4 = null;
            }
            ImageLoaderJ.loadCircle(context2, avatar2, liveBusinessParentAuditBigPadBinding4.studentHeadStage, R.drawable.common_self_image_user);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding5 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding5 = null;
            }
            liveBusinessParentAuditBigPadBinding5.studentHeadStageParent.setVisibility(0);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding6 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding6 = null;
            }
            liveBusinessParentAuditBigPadBinding6.studentHead.setVisibility(8);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding7 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding7 = null;
            }
            liveBusinessParentAuditBigPadBinding7.studentLevel.setVisibility(8);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding8 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding8 = null;
            }
            liveBusinessParentAuditBigPadBinding8.studentHeadBgParent.setVisibility(0);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding9 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding9 = null;
            }
            liveBusinessParentAuditBigPadBinding9.studentName.setGravity(17);
        } else {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding10 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding10 = null;
            }
            liveBusinessParentAuditBigPadBinding10.studentName.setGravity(16);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding11 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding11 = null;
            }
            liveBusinessParentAuditBigPadBinding11.studentHeadStageParent.setVisibility(8);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding12 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding12 = null;
            }
            liveBusinessParentAuditBigPadBinding12.studentHead.setVisibility(0);
            if (listBean.getLevel() == 0) {
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding13 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding13 = null;
                }
                liveBusinessParentAuditBigPadBinding13.studentLevel.setVisibility(8);
            } else {
                int level = listBean.getLevel();
                int[] iArr = this.levelIcons;
                if (level > iArr.length) {
                    level = iArr.length;
                }
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding14 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding14 = null;
                }
                liveBusinessParentAuditBigPadBinding14.studentLevel.setImageResource(this.levelIcons[level - 1]);
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding15 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding15 = null;
                }
                liveBusinessParentAuditBigPadBinding15.studentLevel.setVisibility(0);
            }
            if (!listBean.isOpenCamera() || getMSurfaceView() == null) {
                i = 0;
            } else {
                SurfaceView mSurfaceView = getMSurfaceView();
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding16 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding16 = null;
                }
                FrameLayout frameLayout = liveBusinessParentAuditBigPadBinding16.studentVideoContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mViewBinding.studentVideoContainer");
                addSurfaceView(mSurfaceView, frameLayout);
                i = 8;
            }
            if (listBean.isDisableTheVideo()) {
                i = 0;
            }
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding17 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding17 = null;
            }
            liveBusinessParentAuditBigPadBinding17.studentHeadBgParent.setVisibility(i);
        }
        if (listBean.isOnStageAction()) {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding18 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding18 = null;
            }
            liveBusinessParentAuditBigPadBinding18.micParentView.setVisibility(8);
        } else {
            if (listBean.isOpenMic()) {
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding19 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding19 = null;
                }
                liveBusinessParentAuditBigPadBinding19.micHide.setVisibility(8);
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding20 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding20 = null;
                }
                liveBusinessParentAuditBigPadBinding20.micShow.setVisibility(0);
            } else {
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding21 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding21 = null;
                }
                liveBusinessParentAuditBigPadBinding21.micHide.setVisibility(0);
                LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding22 = this.mViewBinding;
                if (liveBusinessParentAuditBigPadBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditBigPadBinding22 = null;
                }
                liveBusinessParentAuditBigPadBinding22.micShow.setVisibility(8);
            }
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding23 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding23 = null;
            }
            liveBusinessParentAuditBigPadBinding23.micParentView.setVisibility(0);
        }
        if (!listBean.isRaiseHandUp() || listBean.isOnStageAction()) {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding24 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding24 = null;
            }
            liveBusinessParentAuditBigPadBinding24.handUpImage.setVisibility(8);
        } else {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding25 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding25 = null;
            }
            liveBusinessParentAuditBigPadBinding25.handUpImage.setVisibility(0);
        }
        if (!listBean.isShowEmoji() || listBean.isOnStageAction() || listBean.isHerselfOff()) {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding26 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding26 = null;
            }
            liveBusinessParentAuditBigPadBinding26.emojiView.setVisibility(8);
        } else {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding27 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding27 = null;
            }
            EmojiView emojiView = liveBusinessParentAuditBigPadBinding27.emojiView;
            Intrinsics.checkNotNullExpressionValue(emojiView, "mViewBinding.emojiView");
            EmojiView.setData$default(emojiView, listBean.getEmojiBean(), (Boolean) null, (Function0) null, 6, (Object) null);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding28 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding28 = null;
            }
            liveBusinessParentAuditBigPadBinding28.emojiView.setVisibility(0);
        }
        if (!listBean.isStudentOnline()) {
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding29 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding29 = null;
            }
            liveBusinessParentAuditBigPadBinding29.studentHead.setVisibility(8);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding30 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditBigPadBinding30 = null;
            }
            liveBusinessParentAuditBigPadBinding30.offlineView.setVisibility(0);
            LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding31 = this.mViewBinding;
            if (liveBusinessParentAuditBigPadBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                liveBusinessParentAuditBigPadBinding2 = liveBusinessParentAuditBigPadBinding31;
            }
            liveBusinessParentAuditBigPadBinding2.micParentView.setVisibility(8);
            return;
        }
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding32 = this.mViewBinding;
        if (liveBusinessParentAuditBigPadBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditBigPadBinding32 = null;
        }
        liveBusinessParentAuditBigPadBinding32.offlineView.setVisibility(8);
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding33 = this.mViewBinding;
        if (liveBusinessParentAuditBigPadBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditBigPadBinding2 = liveBusinessParentAuditBigPadBinding33;
        }
        liveBusinessParentAuditBigPadBinding2.micParentView.setVisibility(0);
    }

    public void showMicVolume(long j, int i) {
        LiveBusinessParentAuditBigPadBinding liveBusinessParentAuditBigPadBinding = this.mViewBinding;
        if (liveBusinessParentAuditBigPadBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditBigPadBinding = null;
        }
        liveBusinessParentAuditBigPadBinding.micShow.getDrawable().setLevel((i * 10000) / 255);
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
