package com.tal.app.thinkacademy.live.business.livemessage.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.commui.adapter.BaseRecycleAdapter;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.AchieveLabelUtil;
import com.tal.app.thinkacademy.live.business.livemessage.widget.CenterAlignImageSpan;
import com.tal.app.thinkacademy.live.business.livemessage.widget.RoundBackgroundColorSpan;
import java.util.List;

public class LiveMsgAdapter extends BaseRecycleAdapter<LiveMessageEntity> {
    private Drawable dwSystemIcon;
    private Drawable dwTeacherIcon;
    private int[] msgColors;
    private int[] nameColors;

    public LiveMsgAdapter(Context context, List<LiveMessageEntity> list, int[] iArr, int[] iArr2) {
        super(context, list);
        this.nameColors = iArr;
        this.msgColors = iArr2;
    }

    /* access modifiers changed from: protected */
    public BaseRecycleAdapter<LiveMessageEntity>.BaseHolder getViewholder(View view) {
        return new LiveMsgViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.item_live_msg;
    }

    /* access modifiers changed from: protected */
    public void bindItemView(BaseRecycleAdapter<LiveMessageEntity>.BaseHolder baseHolder, LiveMessageEntity liveMessageEntity, int i) {
        int i2;
        SpannableString spannableString;
        int i3;
        LiveMsgViewHolder liveMsgViewHolder = (LiveMsgViewHolder) baseHolder;
        String sender = liveMessageEntity.getSender();
        int type = liveMessageEntity.getType();
        if (type == 0 || type == 1 || type == 2 || type == 3 || type == 4) {
            i2 = this.nameColors[liveMessageEntity.getType()];
        } else if (type == 8 || type == 9) {
            i2 = this.nameColors[2];
        } else {
            i2 = this.nameColors[0];
        }
        int type2 = liveMessageEntity.getType();
        if (type2 == 1) {
            spannableString = new SpannableString("Assistant " + sender + ": ");
        } else if (type2 == 3) {
            spannableString = new SpannableString("System ");
        } else if (type2 == 8) {
            SpannableString spannableString2 = new SpannableString(sender);
            spannableString2.setSpan(new ForegroundColorSpan(i2), 0, sender.length(), 17);
            spannableString = spannableString2;
        } else if (type2 != 9) {
            Drawable drawable = null;
            if (liveMessageEntity.getType() == 0 || 2 == liveMessageEntity.getType()) {
                drawable = getContiRightDrawable(this.mContext, liveMessageEntity.getEvenNum());
            }
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                spannableString = new SpannableString("# " + sender + ": ");
                spannableString.setSpan(new CenterAlignImageSpan(drawable), 0, 1, 17);
                spannableString.setSpan(foregroundColorSpan, 2, sender.length() + 2, 17);
            } else {
                spannableString = new SpannableString(sender + ": ");
                spannableString.setSpan(foregroundColorSpan, 0, sender.length() + 1, 17);
            }
        } else {
            spannableString = new SpannableString(sender);
            RoundBackgroundColorSpan roundBackgroundColorSpan = new RoundBackgroundColorSpan(Color.parseColor("#EB002A"), Color.parseColor("#EB002A"), 20);
            roundBackgroundColorSpan.setPaddingRight(5);
            spannableString.setSpan(roundBackgroundColorSpan, 0, sender.length(), 17);
            spannableString.setSpan(new RelativeSizeSpan(0.8f), 0, sender.length(), 17);
        }
        int type3 = liveMessageEntity.getType();
        if (type3 == 0 || type3 == 1 || type3 == 2 || type3 == 3 || type3 == 4) {
            i3 = this.msgColors[liveMessageEntity.getType()];
        } else {
            i3 = this.nameColors[1];
        }
        liveMsgViewHolder.tvLiveMsg.setTextColor(i3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(spannableString).append(liveMessageEntity.getCharText());
        liveMsgViewHolder.tvLiveMsg.setText(spannableStringBuilder);
    }

    static Drawable getContiRightDrawable(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if (i < 1) {
            return null;
        }
        Resources resources = context.getResources();
        int rightLabel = AchieveLabelUtil.getRightLabel(i);
        if (rightLabel > 0) {
            return resources.getDrawable(rightLabel);
        }
        return null;
    }

    class LiveMsgViewHolder extends BaseRecycleAdapter<LiveMessageEntity>.BaseHolder {
        /* access modifiers changed from: private */
        public TextView tvLiveMsg;

        public LiveMsgViewHolder(View view) {
            super(view);
            this.tvLiveMsg = (TextView) view.findViewById(R.id.tv_live_business_live_msg);
        }
    }
}
