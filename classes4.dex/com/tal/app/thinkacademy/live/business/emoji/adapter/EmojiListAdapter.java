package com.tal.app.thinkacademy.live.business.emoji.adapter;

import android.view.View;
import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;
import java.util.List;

public class EmojiListAdapter extends BaseQuickAdapter<EmojiBean, ViewHolder> {
    private static final String TAG = "EmojiListAdapter";

    public EmojiListAdapter(List<EmojiBean> list) {
        super(R.layout.item_emoji_list, list);
    }

    /* access modifiers changed from: protected */
    public void convert(ViewHolder viewHolder, EmojiBean emojiBean) {
        if (emojiBean != null) {
            viewHolder.emojiView.setData((EmojiBean<?>) emojiBean);
        }
    }

    /* access modifiers changed from: protected */
    public ViewHolder createBaseViewHolder(View view) {
        return new ViewHolder(view);
    }

    public static class ViewHolder extends BaseViewHolder {
        RelativeLayout emojiListItemRL;
        EmojiView emojiView;

        public ViewHolder(View view) {
            super(view);
            this.emojiView = (EmojiView) view.findViewById(R.id.emojiView);
            this.emojiListItemRL = (RelativeLayout) view.findViewById(R.id.emojiListItemRL);
        }
    }
}
