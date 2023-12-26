package com.tal.app.thinkacademy.live.business.allonstage.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0014J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u001a\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00112\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0016\u0010\"\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0007R2\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0006j\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t`\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0006j\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u00060\bj\u0002`\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0007`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/adapter/AllOnStagePhoneAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "mEmojiRunnableMap", "Ljava/util/HashMap;", "", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlin/collections/HashMap;", "mHandler", "Landroid/os/Handler;", "mHighLightRunnableMap", "mSelfMic", "Landroid/widget/ImageView;", "mSelfUid", "", "mStudentUidList", "", "controlMicState", "", "open", "", "convert", "holder", "item", "notifyPos", "pos", "showEmoji", "uid", "emojiBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "showMicLight", "updateMic", "mic", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStagePhoneAdapter.kt */
public final class AllOnStagePhoneAdapter extends BaseQuickAdapter<StudentVideoBean.ListBean, BaseViewHolder> {
    /* access modifiers changed from: private */
    public final HashMap<Integer, Runnable> mEmojiRunnableMap;
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<Integer, Runnable> mHighLightRunnableMap;
    private ImageView mSelfMic;
    private long mSelfUid;
    private final HashMap<String, Integer> mStudentUidList = new HashMap<>();

    public AllOnStagePhoneAdapter() {
        super(R.layout.item_allstage_phone, (List) null, 2, (DefaultConstructorMarker) null);
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper);
        this.mHighLightRunnableMap = new HashMap<>();
        this.mEmojiRunnableMap = new HashMap<>();
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, StudentVideoBean.ListBean listBean) {
        int i;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(listBean, "item");
        int itemPosition = getItemPosition(listBean);
        this.mStudentUidList.put(String.valueOf(listBean.getUserId()), Integer.valueOf(itemPosition));
        if (itemPosition == 0) {
            this.mSelfUid = listBean.getUserId();
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_audio_mute);
            this.mSelfMic = imageView;
            if (imageView != null) {
                imageView.setSelected(!listBean.isOpenMic());
            }
            baseViewHolder.setVisible(R.id.iv_audio_mute, true);
        } else {
            baseViewHolder.setVisible(R.id.iv_audio_mute, false);
        }
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_live_business_avatar);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.bg_live_business_emoji);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_live_business_name);
        ImageView imageView4 = (ImageView) baseViewHolder.getView(R.id.box_live_business_avatar);
        EmojiView emojiView = (EmojiView) baseViewHolder.getView(R.id.iv_live_business_emoji);
        ImageLoaderJ.loadCircle(getContext(), listBean.getAvatar(), imageView2, R.drawable.common_self_image_user);
        textView.setText(listBean.getNickName());
        if (listBean.isShowMicLight()) {
            if (!imageView4.isSelected()) {
                imageView4.setSelected(true);
                Context context = getContext();
                if (itemPosition == 0) {
                    i = R.color.color_FF850A;
                } else {
                    i = R.color.color_02ca8a;
                }
                textView.setTextColor(ContextCompat.getColor(context, i));
                AllOnStagePhoneAdapterKt.setScale(imageView2, 0.91f);
                AllOnStagePhoneAdapterKt.setScale(imageView3, 0.91f);
            }
        } else if (imageView4.isSelected()) {
            imageView4.setSelected(false);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.color_172B4D));
            AllOnStagePhoneAdapterKt.setScale(imageView2, 1.0f);
            AllOnStagePhoneAdapterKt.setScale(imageView3, 1.0f);
        }
        if (listBean.isShowEmoji()) {
            emojiView.setData((EmojiBean<?>) listBean.getEmojiBean(), (Boolean) false, (Function0<Unit>) new AllOnStagePhoneAdapter$convert$1(emojiView, imageView3, listBean));
            emojiView.setVisibility(0);
            imageView3.setVisibility(0);
            return;
        }
        emojiView.setVisibility(8);
        imageView3.setVisibility(8);
    }

    public final void updateMic(long j, int i) {
        ImageView imageView;
        Drawable drawable;
        if (j == 0) {
            j = this.mSelfUid;
        }
        if (this.mSelfUid == j && (imageView = this.mSelfMic) != null && !imageView.isSelected() && (drawable = imageView.getDrawable()) != null) {
            drawable.setLevel((i * 10000) / 255);
        }
        if (i > 100) {
            showMicLight(j);
        }
    }

    public final void controlMicState(boolean z) {
        StudentVideoBean.ListBean listBean = (StudentVideoBean.ListBean) getItemOrNull(0);
        if (listBean != null) {
            listBean.setOpenMic(z);
            notifyPos(0);
        }
    }

    public final void showEmoji(long j, EmojiBean<?> emojiBean) {
        StudentVideoBean.ListBean listBean;
        Intrinsics.checkNotNullParameter(emojiBean, "emojiBean");
        if (j == 0) {
            j = this.mSelfUid;
        }
        Integer num = this.mStudentUidList.get(String.valueOf(j));
        if (num != null && (listBean = (StudentVideoBean.ListBean) getItemOrNull(num.intValue())) != null) {
            listBean.setEmojiBean(emojiBean);
            int type = emojiBean.getType();
            boolean z = false;
            if (type != 1 && (type == 2 || (type != 3 && type == 4))) {
                z = true;
            }
            if (!listBean.isShowEmoji()) {
                listBean.setShowEmoji(true);
                this.mEmojiRunnableMap.put(num, new AllOnStagePhoneAdapter$showEmoji$lambda5$lambda4$$inlined$Runnable$1(listBean, this, num));
            }
            notifyPos(num.intValue());
            Runnable runnable = this.mEmojiRunnableMap.get(num);
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
                if (!z) {
                    this.mHandler.postDelayed(runnable, 3000);
                }
            }
        }
    }

    private final void showMicLight(long j) {
        StudentVideoBean.ListBean listBean;
        Integer num = this.mStudentUidList.get(String.valueOf(j));
        if (num != null && (listBean = (StudentVideoBean.ListBean) getItemOrNull(num.intValue())) != null) {
            if (listBean.isShowMicLight()) {
                Runnable runnable = this.mHighLightRunnableMap.get(num);
                if (runnable != null) {
                    this.mHandler.removeCallbacks(runnable);
                    this.mHandler.postDelayed(runnable, 1000);
                    return;
                }
                return;
            }
            listBean.setShowMicLight(true);
            notifyPos(num.intValue());
            Runnable r0 = new AllOnStagePhoneAdapter$showMicLight$lambda9$lambda8$$inlined$Runnable$1(listBean, this, num);
            this.mHighLightRunnableMap.put(num, r0);
            this.mHandler.postDelayed(r0, 1000);
        }
    }

    /* access modifiers changed from: private */
    public final void notifyPos(int i) {
        notifyItemChanged(i + getHeaderLayoutCount());
    }
}
