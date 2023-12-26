package com.tal.app.thinkacademy.live.business.livemessage.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tal.app.thinkacademy.lib.commui.adapter.BaseRecycleAdapter;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageEntity;
import com.tal.app.thinkacademy.live.business.livemessage.widget.RoundBackgroundColorSpan;
import java.util.List;

public class LiveMsgImageAdapter extends BaseRecycleAdapter<LiveMessageEntity> {
    private boolean isPrivate;
    private int[] msgColors;
    private int[] nameColors;

    public LiveMsgImageAdapter(Context context, List<LiveMessageEntity> list, int[] iArr, int[] iArr2) {
        super(context, list);
        this.nameColors = iArr;
        this.msgColors = iArr2;
        this.isPrivate = false;
    }

    public LiveMsgImageAdapter(Context context, List<LiveMessageEntity> list, int[] iArr, int[] iArr2, boolean z) {
        super(context, list);
        this.nameColors = iArr;
        this.msgColors = iArr2;
        this.isPrivate = z;
    }

    /* access modifiers changed from: protected */
    public BaseRecycleAdapter.BaseHolder getViewholder(View view) {
        return new MsgViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.live_business_item_live_msg_layout;
    }

    /* access modifiers changed from: protected */
    public void bindItemView(BaseRecycleAdapter.BaseHolder baseHolder, LiveMessageEntity liveMessageEntity, int i) {
        MsgViewHolder msgViewHolder = (MsgViewHolder) baseHolder;
        int nameColor = getNameColor(liveMessageEntity.getType());
        int messageColor = getMessageColor(liveMessageEntity.getType());
        SpannableString senderStyle = getSenderStyle(liveMessageEntity.getType(), liveMessageEntity.getSender(), nameColor, liveMessageEntity.getEvenNum());
        msgViewHolder.tvMessage.setTextColor(messageColor);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!this.isPrivate || !(liveMessageEntity.getType() == 4 || liveMessageEntity.getType() == 1)) {
            spannableStringBuilder.append(senderStyle).append(" ").append(liveMessageEntity.getCharText());
        } else {
            spannableStringBuilder.append(senderStyle).append(getPrivateMessageSpan(liveMessageEntity.getType())).append(" ").append(liveMessageEntity.getCharText());
        }
        msgViewHolder.tvMessage.setText(spannableStringBuilder);
        if (liveMessageEntity.getType() == 4 || liveMessageEntity.getType() == 1) {
            msgViewHolder.ivHeader.setVisibility(0);
            msgViewHolder.viewDiv.setVisibility(0);
            msgViewHolder.ivHeader.setBackgroundResource(R.drawable.live_business_shape_live_msg_header_teacher_bg);
            ImageLoaderJ.loadCircle(this.mContext, liveMessageEntity.getHeadUrl(), msgViewHolder.ivHeader, R.drawable.common_self_image_user);
        } else {
            msgViewHolder.ivHeader.setVisibility(8);
            msgViewHolder.viewDiv.setVisibility(8);
        }
        if (!TextUtils.isEmpty(liveMessageEntity.getEmojiJsonString())) {
            msgViewHolder.emojiView.setData(liveMessageEntity.getEmojiJsonString(), Boolean.valueOf(liveMessageEntity.isLoop()));
            msgViewHolder.emojiView.setVisibility(0);
            return;
        }
        msgViewHolder.emojiView.setVisibility(8);
    }

    private SpannableString getPrivateMessageSpan(int i) {
        String string = this.mContext.getString(R.string.private_message);
        SpannableString spannableString = new SpannableString(string);
        if (i != 1 && i != 4) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(this.nameColors[i]), 0, string.length(), 17);
        return spannableString;
    }

    private int getNameColor(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return this.nameColors[i];
        }
        if (i == 8 || i == 9) {
            return this.nameColors[2];
        }
        return this.nameColors[0];
    }

    private int getMessageColor(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return this.msgColors[i];
        }
        return this.nameColors[1];
    }

    private SpannableString getSenderStyle(int i, String str, int i2, String str2) {
        SpannableString spannableString;
        if (i != 1) {
            if (i != 3) {
                if (i == 4) {
                    spannableString = new SpannableString(str);
                    spannableString.setSpan(new RoundBackgroundColorSpan(1711458954, 438239159, i2, SizeUtils.dp2px(3.0f)), 0, str.length(), 17);
                } else if (!(i == 8 || i == 9)) {
                    SpannableString spannableString2 = new SpannableString(str + " ");
                    spannableString2.setSpan(new ForegroundColorSpan(i2), 0, str.length() + 1, 17);
                    return spannableString2;
                }
            }
            String string = this.mContext.getString(R.string.system_message);
            spannableString = new SpannableString(string);
            spannableString.setSpan(new RoundBackgroundColorSpan(-44993, 452939839, i2, SizeUtils.dp2px(3.0f)), 0, string.length(), 17);
        } else {
            spannableString = new SpannableString(str);
            spannableString.setSpan(new RoundBackgroundColorSpan(1714647295, 859009279, i2, SizeUtils.dp2px(3.0f)), 0, str.length(), 17);
        }
        return spannableString;
    }

    class MsgViewHolder extends BaseRecycleAdapter.BaseHolder {
        /* access modifiers changed from: private */
        public final EmojiView emojiView;
        /* access modifiers changed from: private */
        public final ImageView ivHeader;
        /* access modifiers changed from: private */
        public final TextView tvMessage;
        /* access modifiers changed from: private */
        public final View viewDiv;

        public MsgViewHolder(View view) {
            super(view);
            this.ivHeader = (ImageView) view.findViewById(R.id.iv_live_business_live_msg_header);
            this.tvMessage = (TextView) view.findViewById(R.id.tv_live_business_live_msg_all);
            this.viewDiv = view.findViewById(R.id.view_live_business_live_msg_div);
            this.emojiView = (EmojiView) view.findViewById(R.id.iv_live_business_live_msg_emoji);
        }
    }
}
