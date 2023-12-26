package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u001f\u001a\u00020\u00152\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/DDStudentVideoWindowSmallPad;", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/BaseVideoWindow;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "KCloseFace", "KCloseMic", "KUpdateMic", "KVideoGone", "KVideoShow", "levelIcons", "", "mHandler", "Landroid/os/Handler;", "mViewBinding", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessDdstudentVideoSmallPadBinding;", "addCoin", "", "student", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "authPen", "show", "", "release", "remotefirstVideoRecvWithUid", "isShow", "setStudentInform", "setSurfaceView", "surfaceView", "Landroid/view/TextureView;", "showFace", "emojiString", "", "updateLevel", "level", "updateMic", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DDStudentVideoWindowSmallPad.kt */
public final class DDStudentVideoWindowSmallPad extends BaseVideoWindow {
    /* access modifiers changed from: private */
    public final int KCloseFace;
    /* access modifiers changed from: private */
    public final int KCloseMic;
    /* access modifiers changed from: private */
    public final int KUpdateMic;
    /* access modifiers changed from: private */
    public final int KVideoGone;
    /* access modifiers changed from: private */
    public final int KVideoShow;
    private int[] levelIcons;
    private Handler mHandler;
    /* access modifiers changed from: private */
    public LiveBusinessDdstudentVideoSmallPadBinding mViewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DDStudentVideoWindowSmallPad(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DDStudentVideoWindowSmallPad(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DDStudentVideoWindowSmallPad(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DDStudentVideoWindowSmallPad(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.KUpdateMic = 1;
        this.KVideoShow = 2;
        this.KVideoGone = 3;
        this.KCloseFace = 4;
        this.levelIcons = new int[]{R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
        LiveBusinessDdstudentVideoSmallPadBinding inflate = LiveBusinessDdstudentVideoSmallPadBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.from(context), this, true)");
        this.mViewBinding = inflate;
        this.mHandler = new DDStudentVideoWindowSmallPad$mHandler$1(this, Looper.getMainLooper());
    }

    public void setStudentInform(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        ImageLoaderJ.loadCircle(getContext(), videoCallBean.getAvatar(), this.mViewBinding.ivHead, R.drawable.common_self_image_user);
        TextView textView = this.mViewBinding.tvNickName;
        if (textView != null) {
            textView.setText(videoCallBean.getNickName());
        }
        Integer level = videoCallBean.getLevel();
        updateLevel(level == null ? 0 : level.intValue());
    }

    public void setSurfaceView(TextureView textureView) {
        if (textureView != null) {
            ViewGroup viewGroup = (ViewGroup) textureView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(textureView);
            }
            this.mViewBinding.rlSurfaceView.removeAllViews();
            this.mViewBinding.rlSurfaceView.addView(textureView, 0);
            if (textureView.getVisibility() != 0) {
                textureView.setVisibility(0);
            }
            textureView.requestLayout();
        }
    }

    public void updateMic(int i) {
        if (i >= 0) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(this.KCloseMic);
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                Message obtain = Message.obtain();
                obtain.obj = Integer.valueOf(i);
                obtain.what = this.KUpdateMic;
                handler2.sendMessageDelayed(obtain, 0);
                return;
            }
            return;
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null) {
            handler3.removeMessages(this.KUpdateMic);
        }
        Handler handler4 = this.mHandler;
        if (handler4 != null) {
            handler4.sendEmptyMessageDelayed(this.KCloseMic, 0);
        }
    }

    public void updateLevel(int i) {
        if (i <= 0) {
            ImageView imageView = this.mViewBinding.ivLevel;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            }
            return;
        }
        if (i > this.levelIcons.length) {
            ImageView imageView2 = this.mViewBinding.ivLevel;
            if (imageView2 != null) {
                int[] iArr = this.levelIcons;
                imageView2.setImageResource(iArr[iArr.length - 1]);
            }
        } else {
            ImageView imageView3 = this.mViewBinding.ivLevel;
            if (imageView3 != null) {
                imageView3.setImageResource(this.levelIcons[i - 1]);
            }
        }
        ImageView imageView4 = this.mViewBinding.ivLevel;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
    }

    public void remotefirstVideoRecvWithUid(boolean z) {
        if (z) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeMessages(this.KVideoGone);
            }
            Handler handler2 = this.mHandler;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(this.KVideoShow, 0);
                return;
            }
            return;
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null) {
            handler3.removeMessages(this.KVideoShow);
        }
        Handler handler4 = this.mHandler;
        if (handler4 != null) {
            handler4.sendEmptyMessageDelayed(this.KVideoGone, 0);
        }
    }

    public void authPen(boolean z) {
        if (z) {
            this.mViewBinding.ivPen.setVisibility(0);
        } else {
            this.mViewBinding.ivPen.setVisibility(8);
        }
    }

    public void addCoin(VideoCallBean videoCallBean) {
        Intrinsics.checkNotNullParameter(videoCallBean, "student");
        Integer addCoin = videoCallBean.getAddCoin();
        if (addCoin != null) {
            int intValue = addCoin.intValue();
            if (intValue == 5) {
                EmojiView emojiView = this.mViewBinding.emojiView;
                if (emojiView != null) {
                    emojiView.setVisibility(8);
                }
                LinearLayout linearLayout = this.mViewBinding.emojiViewBg;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeMessages(this.KCloseFace);
                }
                LottieAnimationView lottieAnimationView = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(8);
                }
                LottieAnimationView lottieAnimationView2 = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.cancelAnimation();
                }
                LottieAnimationView lottieAnimationView3 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView3 != null) {
                    lottieAnimationView3.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView4 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView4 != null) {
                    lottieAnimationView4.setIgnoreDisabledSystemAnimations(true);
                }
                LottieAnimationView lottieAnimationView5 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView5 != null) {
                    lottieAnimationView5.playAnimation();
                }
                LottieAnimationView lottieAnimationView6 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView6 != null) {
                    lottieAnimationView6.addAnimatorListener(new DDStudentVideoWindowSmallPad$addCoin$1$1(this));
                }
            } else if (intValue == 10) {
                EmojiView emojiView2 = this.mViewBinding.emojiView;
                if (emojiView2 != null) {
                    emojiView2.setVisibility(8);
                }
                LinearLayout linearLayout2 = this.mViewBinding.emojiViewBg;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(8);
                }
                Handler handler2 = this.mHandler;
                if (handler2 != null) {
                    handler2.removeMessages(this.KCloseFace);
                }
                LottieAnimationView lottieAnimationView7 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView7 != null) {
                    lottieAnimationView7.setVisibility(8);
                }
                LottieAnimationView lottieAnimationView8 = this.mViewBinding.lottieAddCoin5;
                if (lottieAnimationView8 != null) {
                    lottieAnimationView8.cancelAnimation();
                }
                LottieAnimationView lottieAnimationView9 = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView9 != null) {
                    lottieAnimationView9.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView10 = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView10 != null) {
                    lottieAnimationView10.setIgnoreDisabledSystemAnimations(true);
                }
                LottieAnimationView lottieAnimationView11 = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView11 != null) {
                    lottieAnimationView11.playAnimation();
                }
                LottieAnimationView lottieAnimationView12 = this.mViewBinding.lottieAddCoin10;
                if (lottieAnimationView12 != null) {
                    lottieAnimationView12.addAnimatorListener(new DDStudentVideoWindowSmallPad$addCoin$1$2(this));
                }
            }
        }
    }

    public void showFace(String str) {
        Handler handler;
        Intrinsics.checkNotNullParameter(str, "emojiString");
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeMessages(this.KCloseFace);
        }
        LottieAnimationView lottieAnimationView = this.mViewBinding.lottieAddCoin5;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.mViewBinding.lottieAddCoin5;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.mViewBinding.lottieAddCoin10;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView4 = this.mViewBinding.lottieAddCoin10;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.cancelAnimation();
        }
        EmojiView emojiView = this.mViewBinding.emojiView;
        if (emojiView != null) {
            EmojiView.setData$default(emojiView, str, (Boolean) null, new DDStudentVideoWindowSmallPad$showFace$1(this), 2, (Object) null);
        }
        EmojiView emojiView2 = this.mViewBinding.emojiView;
        if (emojiView2 != null) {
            emojiView2.setVisibility(0);
        }
        LinearLayout linearLayout = this.mViewBinding.emojiViewBg;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        Object fromJson = GsonUtils.fromJson(str, EmojiBean.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(emojiString, EmojiBean::class.java)");
        int type = ((EmojiBean) fromJson).getType();
        if (type != 2 && type != 4 && (handler = this.mHandler) != null) {
            handler.sendEmptyMessageDelayed(this.KCloseFace, 3000);
        }
    }

    public void release() {
        LottieAnimationView lottieAnimationView = this.mViewBinding.lottieAddCoin5;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.mViewBinding.lottieAddCoin5;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.mViewBinding.lottieAddCoin5;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.removeAllAnimatorListeners();
        }
        LottieAnimationView lottieAnimationView4 = this.mViewBinding.lottieAddCoin10;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView5 = this.mViewBinding.lottieAddCoin10;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView6 = this.mViewBinding.lottieAddCoin10;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.removeAllAnimatorListeners();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler = null;
    }
}
