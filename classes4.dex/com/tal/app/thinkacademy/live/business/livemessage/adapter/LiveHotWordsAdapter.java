package com.tal.app.thinkacademy.live.business.livemessage.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tal.app.thinkacademy.lib.commui.adapter.BaseRecycleAdapter;
import com.tal.app.thinkacademy.lib.util.RegexUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.livemessage.LiveMessageEmojiParser;
import java.util.List;

public class LiveHotWordsAdapter extends BaseRecycleAdapter<String> {
    /* access modifiers changed from: private */
    public boolean isPad;
    private int mMessageSize = ((int) (ScreenUtils.getScreenDensity() * 12.0f));

    public LiveHotWordsAdapter(Context context, List<String> list, boolean z) {
        super(context, list);
        this.isPad = z;
    }

    /* access modifiers changed from: protected */
    public BaseRecycleAdapter<String>.BaseHolder getViewholder(View view) {
        return new HotWordViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.item_live_hot_word;
    }

    /* access modifiers changed from: protected */
    public void bindItemView(BaseRecycleAdapter<String>.BaseHolder baseHolder, String str, int i) {
        HotWordViewHolder hotWordViewHolder = (HotWordViewHolder) baseHolder;
        FlexboxLayoutManager.LayoutParams layoutParams = hotWordViewHolder.tvHotWord.getLayoutParams();
        if (layoutParams instanceof FlexboxLayoutManager.LayoutParams) {
            layoutParams.setFlexGrow(1.0f);
        }
        hotWordViewHolder.tvHotWord.setText(LiveMessageEmojiParser.convertToHtml(RegexUtils.chatSendContentDeal(str), this.mContext, this.mMessageSize));
    }

    class HotWordViewHolder extends BaseRecycleAdapter<String>.BaseHolder {
        /* access modifiers changed from: private */
        public TextView tvHotWord;

        public HotWordViewHolder(View view) {
            super(view);
            this.tvHotWord = (TextView) view.findViewById(R.id.tv_hotword);
            if (!LiveHotWordsAdapter.this.isPad) {
                this.tvHotWord.setTextSize(1, 12.0f);
            }
        }
    }
}
