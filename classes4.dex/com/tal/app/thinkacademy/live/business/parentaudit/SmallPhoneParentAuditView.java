package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPhoneBinding;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J(\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0014J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0012H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/SmallPhoneParentAuditView;", "Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "levelIcons", "", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessParentAuditSmallPhoneBinding;", "addSurfaceView", "", "surfaceView", "Landroid/view/SurfaceView;", "layout", "Landroid/widget/FrameLayout;", "getLayoutId", "", "initViews", "onSizeChanged", "w", "h", "oldw", "oldh", "showChildInfo", "bean", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "showMicVolume", "uid", "", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmallPhoneParentAuditView.kt */
public final class SmallPhoneParentAuditView extends BaseParentAuditPluginView {
    private final int[] levelIcons = {R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    private LiveBusinessParentAuditSmallPhoneBinding mViewBinding;

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallPhoneParentAuditView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
    }

    public int getLayoutId() {
        return R.layout.live_business_parent_audit_small_phone;
    }

    public void initViews() {
        super.initViews();
        LiveBusinessParentAuditSmallPhoneBinding bind = LiveBusinessParentAuditSmallPhoneBinding.bind(getInflateView().findViewById(R.id.root_audit));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(inflateView.findViewById(R.id.root_audit))");
        this.mViewBinding = bind;
    }

    public void showChildInfo(StudentVideoBean.ListBean listBean) {
        int i;
        Intrinsics.checkNotNullParameter(listBean, "bean");
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding = this.mViewBinding;
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding2 = null;
        if (liveBusinessParentAuditSmallPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPhoneBinding = null;
        }
        liveBusinessParentAuditSmallPhoneBinding.studentName.setText(listBean.getNickName());
        Context context = getContext();
        String avatar = listBean.getAvatar();
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding3 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPhoneBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPhoneBinding3 = null;
        }
        ImageLoaderJ.loadCircle(context, avatar, liveBusinessParentAuditSmallPhoneBinding3.studentHead, R.drawable.common_self_image_user);
        if (listBean.isOnStageAction()) {
            Context context2 = getContext();
            String avatar2 = listBean.getAvatar();
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding4 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding4 = null;
            }
            ImageLoaderJ.loadCircle(context2, avatar2, liveBusinessParentAuditSmallPhoneBinding4.studentHeadStage, R.drawable.common_self_image_user);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding5 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding5 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding5.studentHeadStageParent.setVisibility(0);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding6 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding6 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding6.studentHead.setVisibility(8);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding7 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding7 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding7.studentLevel.setVisibility(8);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding8 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding8 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding8.studentHeadBgParent.setVisibility(0);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding9 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding9 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding9.studentName.setGravity(17);
        } else {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding10 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding10 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding10.studentName.setGravity(16);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding11 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding11 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding11.studentHeadStageParent.setVisibility(8);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding12 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding12 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding12.studentHead.setVisibility(0);
            if (listBean.getLevel() == 0) {
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding13 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding13 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding13.studentLevel.setVisibility(8);
            } else {
                int level = listBean.getLevel();
                int[] iArr = this.levelIcons;
                if (level > iArr.length) {
                    level = iArr.length;
                }
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding14 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding14 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding14.studentLevel.setImageResource(this.levelIcons[level - 1]);
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding15 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding15 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding15.studentLevel.setVisibility(0);
            }
            if (!listBean.isOpenCamera() || getMSurfaceView() == null) {
                i = 0;
            } else {
                SurfaceView mSurfaceView = getMSurfaceView();
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding16 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding16 = null;
                }
                FrameLayout frameLayout = liveBusinessParentAuditSmallPhoneBinding16.studentVideoContainer;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "mViewBinding.studentVideoContainer");
                addSurfaceView(mSurfaceView, frameLayout);
                i = 8;
            }
            if (listBean.isDisableTheVideo()) {
                i = 0;
            }
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding17 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding17 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding17.studentHeadBgParent.setVisibility(i);
        }
        if (listBean.isOnStageAction()) {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding18 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding18 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding18.micParentView.setVisibility(8);
        } else {
            if (listBean.isOpenMic()) {
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding19 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding19 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding19.micHide.setVisibility(8);
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding20 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding20 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding20.micShow.setVisibility(0);
            } else {
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding21 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding21 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding21.micHide.setVisibility(0);
                LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding22 = this.mViewBinding;
                if (liveBusinessParentAuditSmallPhoneBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                    liveBusinessParentAuditSmallPhoneBinding22 = null;
                }
                liveBusinessParentAuditSmallPhoneBinding22.micShow.setVisibility(8);
            }
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding23 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding23 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding23.micParentView.setVisibility(0);
        }
        if (!listBean.isRaiseHandUp() || listBean.isOnStageAction()) {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding24 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding24 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding24.handUpImage.setVisibility(8);
        } else {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding25 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding25 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding25.handUpImage.setVisibility(0);
        }
        if (!listBean.isShowEmoji() || listBean.isOnStageAction() || listBean.isHerselfOff()) {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding26 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding26 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding26.emojiView.setVisibility(8);
        } else {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding27 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding27 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding27 = null;
            }
            EmojiView emojiView = liveBusinessParentAuditSmallPhoneBinding27.emojiView;
            Intrinsics.checkNotNullExpressionValue(emojiView, "mViewBinding.emojiView");
            EmojiView.setData$default(emojiView, listBean.getEmojiBean(), (Boolean) null, (Function0) null, 6, (Object) null);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding28 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding28 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding28.emojiView.setVisibility(0);
        }
        if (!listBean.isStudentOnline()) {
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding29 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding29 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding29.studentHead.setVisibility(8);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding30 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
                liveBusinessParentAuditSmallPhoneBinding30 = null;
            }
            liveBusinessParentAuditSmallPhoneBinding30.offlineView.setVisibility(0);
            LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding31 = this.mViewBinding;
            if (liveBusinessParentAuditSmallPhoneBinding31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            } else {
                liveBusinessParentAuditSmallPhoneBinding2 = liveBusinessParentAuditSmallPhoneBinding31;
            }
            liveBusinessParentAuditSmallPhoneBinding2.micParentView.setVisibility(8);
            return;
        }
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding32 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPhoneBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPhoneBinding32 = null;
        }
        liveBusinessParentAuditSmallPhoneBinding32.offlineView.setVisibility(8);
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding33 = this.mViewBinding;
        if (liveBusinessParentAuditSmallPhoneBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
        } else {
            liveBusinessParentAuditSmallPhoneBinding2 = liveBusinessParentAuditSmallPhoneBinding33;
        }
        liveBusinessParentAuditSmallPhoneBinding2.micParentView.setVisibility(0);
    }

    public void showMicVolume(long j, int i) {
        LiveBusinessParentAuditSmallPhoneBinding liveBusinessParentAuditSmallPhoneBinding = this.mViewBinding;
        if (liveBusinessParentAuditSmallPhoneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewBinding");
            liveBusinessParentAuditSmallPhoneBinding = null;
        }
        liveBusinessParentAuditSmallPhoneBinding.micShow.getDrawable().setLevel((i * 10000) / 255);
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
