package com.tal.app.thinkacademy.live.business.randomcallnew.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundFrameLayout;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.live.abilitypack.randomcall.RandomCallViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModel;
import com.tal.app.thinkacademy.live.abilitypack.rtc.RtcViewModelKt;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.randomcallnew.bean.RandomCallUserBean;
import com.tal.app.thinkacademy.live.business.randomcallnew.view.BaseRandomCallPhotoWallPluginView;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPackKt;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001e\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/adapter/RandomCallPhotoWallAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "view", "Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView;", "context", "Landroid/content/Context;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tal/app/thinkacademy/live/business/randomcallnew/view/BaseRandomCallPhotoWallPluginView;Landroid/content/Context;Ljava/util/ArrayList;)V", "mItemHeight", "", "Ljava/lang/Integer;", "mItemWidth", "mParentView", "mRandomCallViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/randomcall/RandomCallViewModel;", "mRtcModel", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel;", "convert", "", "holder", "item", "getTextureView", "Landroid/view/TextureView;", "uid", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallPhotoWallAdapter.kt */
public final class RandomCallPhotoWallAdapter extends BaseQuickAdapter<RandomCallUserBean, BaseViewHolder> {
    private Integer mItemHeight;
    private Integer mItemWidth;
    private BaseRandomCallPhotoWallPluginView mParentView;
    private RandomCallViewModel mRandomCallViewModel;
    private RtcViewModel mRtcModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RandomCallPhotoWallAdapter(BaseRandomCallPhotoWallPluginView baseRandomCallPhotoWallPluginView, Context context, ArrayList<RandomCallUserBean> arrayList) {
        super(PadUtils.isPad(context) ? R.layout.live_business_item_random_call_photo_wall : R.layout.live_business_item_random_call_photo_wall_phone, arrayList);
        Intrinsics.checkNotNullParameter(baseRandomCallPhotoWallPluginView, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mParentView = baseRandomCallPhotoWallPluginView;
        this.mRtcModel = RtcViewModelKt.getRtcViewModel(AbilityPackKt.getAbilityPack());
        this.mRandomCallViewModel = AbilityPackKt.getAbilityPack().getViewModel(RandomCallViewModel.class);
        if (PadUtils.isPad(context)) {
            this.mItemWidth = Integer.valueOf(context.getResources().getDimensionPixelOffset(R.dimen.size_132dp));
            this.mItemHeight = Integer.valueOf(context.getResources().getDimensionPixelOffset(R.dimen.size_100dp));
            return;
        }
        FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
        if (newLp != null) {
            int dimensionPixelOffset = (newLp.width - context.getResources().getDimensionPixelOffset(R.dimen.size_32dp)) / 4;
            this.mItemWidth = Integer.valueOf(dimensionPixelOffset);
            this.mItemHeight = Integer.valueOf(((dimensionPixelOffset - context.getResources().getDimensionPixelOffset(R.dimen.size_4dp)) * 3) / 4);
            context.getResources().getDimensionPixelOffset(R.dimen.size_4dp);
        }
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, RandomCallUserBean randomCallUserBean) {
        RtcViewModel rtcViewModel;
        String uid;
        boolean z;
        RtcUserState remoteState;
        String uid2;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Integer num = this.mItemWidth;
        Long l = null;
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = this.mItemHeight;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                RoundFrameLayout view = baseViewHolder.getView(R.id.root_view);
                RoundFrameLayout roundFrameLayout = view instanceof RoundFrameLayout ? view : null;
                if (!(roundFrameLayout == null || (layoutParams = roundFrameLayout.getLayoutParams()) == null)) {
                    layoutParams.width = intValue;
                    layoutParams.height = intValue2;
                }
            }
        }
        if (randomCallUserBean != null) {
            ImageLoaderJ.loadCircle(getContext(), randomCallUserBean.getAvatar(), (ImageView) baseViewHolder.getView(R.id.iv_user_avatar), R.drawable.default_image_user);
            baseViewHolder.setText(R.id.iv_user_name, randomCallUserBean.getNickName());
            ((RelativeLayout) baseViewHolder.getView(R.id.rl_student_root)).setOutlineProvider(new RandomCallPhotoWallAdapter$convert$2$1(this));
            ((RelativeLayout) baseViewHolder.getView(R.id.rl_student_root)).setClipToOutline(true);
            if (randomCallUserBean.isSelected()) {
                baseViewHolder.getView(R.id.root_view).getDelegate().setBackgroundColor(Color.parseColor("#FF1F6CFF"));
            } else {
                baseViewHolder.getView(R.id.root_view).getDelegate().setBackgroundColor(Color.parseColor("#00000000"));
            }
            RandomCallViewModel randomCallViewModel = this.mRandomCallViewModel;
            if (randomCallViewModel != null && randomCallViewModel.isOpenStream()) {
                Long userId = randomCallUserBean.getUserId();
                UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                if (Intrinsics.areEqual(userId, (userInfoEntity == null || (uid2 = userInfoEntity.getUid()) == null) ? null : Long.valueOf(Long.parseLong(uid2)))) {
                    RtcViewModel rtcViewModel2 = this.mRtcModel;
                    if (rtcViewModel2 != null && rtcViewModel2.getMLocalVideoEnable()) {
                        baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    } else {
                        baseViewHolder.setGone(R.id.rl_user_avatar, false);
                    }
                } else {
                    Long userId2 = randomCallUserBean.getUserId();
                    if (userId2 == null) {
                        z = false;
                    } else {
                        long longValue = userId2.longValue();
                        RtcViewModel rtcViewModel3 = this.mRtcModel;
                        z = Intrinsics.areEqual((rtcViewModel3 == null || (remoteState = rtcViewModel3.getRemoteState(longValue)) == null) ? null : Boolean.valueOf(remoteState.getMIsOpenCamera()), true);
                    }
                    if (z) {
                        baseViewHolder.setGone(R.id.rl_user_avatar, true);
                    } else {
                        baseViewHolder.setGone(R.id.rl_user_avatar, false);
                    }
                }
                Long userId3 = randomCallUserBean.getUserId();
                if (userId3 != null) {
                    long longValue2 = userId3.longValue();
                    TextureView textureView = getTextureView(longValue2);
                    if (textureView != null) {
                        if (textureView.getParent() == null) {
                            ((ViewGroup) baseViewHolder.getView(R.id.student_video_container)).addView(textureView);
                        } else if (!Intrinsics.areEqual(textureView.getParent(), baseViewHolder.getView(R.id.student_video_container))) {
                            ViewParent parent = textureView.getParent();
                            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                            View view2 = textureView;
                            ((ViewGroup) parent).removeView(view2);
                            ((ViewGroup) baseViewHolder.getView(R.id.student_video_container)).addView(view2);
                        }
                        Long userId4 = randomCallUserBean.getUserId();
                        UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
                        if (!(userInfoEntity2 == null || (uid = userInfoEntity2.getUid()) == null)) {
                            l = Long.valueOf(Long.parseLong(uid));
                        }
                        if (Intrinsics.areEqual(userId4, l)) {
                            RtcViewModel rtcViewModel4 = this.mRtcModel;
                            if (rtcViewModel4 != null) {
                                rtcViewModel4.setUpLocalVideo(textureView);
                            }
                        } else {
                            RtcViewModel rtcViewModel5 = this.mRtcModel;
                            if (rtcViewModel5 != null) {
                                rtcViewModel5.setUpRemoteVideo(textureView, longValue2);
                            }
                        }
                    }
                    if (randomCallUserBean.getPullStreamState() == 0 && (rtcViewModel = this.mRtcModel) != null) {
                        rtcViewModel.startRemoteVideo(longValue2);
                        return;
                    }
                    return;
                }
                return;
            }
            baseViewHolder.setGone(R.id.rl_user_avatar, false);
        }
    }

    private final TextureView getTextureView(long j) {
        return this.mParentView.getTextureView(j);
    }
}
