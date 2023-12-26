package com.tal.user.global.trade.adapter;

import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.base.TalTradeBaseAdapter;
import com.tal.user.global.trade.base.TalTradeViewHolder;
import com.tal.user.global.trade.config.TalTradeConstant;
import com.tal.user.global.trade.entity.TalTradePayDetailEntity;
import com.tal.user.global.trade.image.TalTradeImageLoader;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001f\u0012\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/user/global/trade/adapter/TalTradePayWayAdapter;", "Lcom/tal/user/global/trade/base/TalTradeBaseAdapter;", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$PayWayConfig;", "data", "", "layoutId", "", "(Ljava/util/List;I)V", "choosePosition", "onItemClickListenerButton", "Lcom/tal/user/global/trade/base/TalTradeBaseAdapter$OnItemClickListener;", "convert", "", "holder", "Lcom/tal/user/global/trade/base/TalTradeViewHolder;", "payWayConfig", "position", "setChoosePosition", "setOnItemClickListenerButton", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradePayWayAdapter.kt */
public final class TalTradePayWayAdapter extends TalTradeBaseAdapter<TalTradePayDetailEntity.PayWayConfig> {
    private int choosePosition;
    /* access modifiers changed from: private */
    public TalTradeBaseAdapter.OnItemClickListener onItemClickListenerButton;

    public TalTradePayWayAdapter(List<TalTradePayDetailEntity.PayWayConfig> list, int i) {
        super(list, i);
    }

    public final void setChoosePosition(int i) {
        this.choosePosition = i;
    }

    /* access modifiers changed from: protected */
    public void convert(TalTradeViewHolder talTradeViewHolder, TalTradePayDetailEntity.PayWayConfig payWayConfig, int i) {
        CheckBox checkBox = null;
        ImageView imageView = talTradeViewHolder != null ? (ImageView) talTradeViewHolder.getView(R.id.ivTalTradePaywayIcon) : null;
        TextView textView = talTradeViewHolder != null ? (TextView) talTradeViewHolder.getView(R.id.tvTalTradePaywayName) : null;
        if (talTradeViewHolder != null) {
            checkBox = (CheckBox) talTradeViewHolder.getView(R.id.cbTalTradePayway);
        }
        if (payWayConfig != null) {
            int payProduct = payWayConfig.getPayProduct();
            if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getWechatAPPCode() || payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getStripeWxH5Code()) {
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.tal_trade_payicon_wechat);
                }
            } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayAPPCode()) {
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.tal_trade_payicon_alipay);
                }
            } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getAlipayHKAPPCode()) {
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.tal_trade_payicon_alipay);
                }
            } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getCardAPPCode()) {
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.tal_trade_payicon_card);
                }
            } else if (payProduct == TalTradeConstant.TalTradePayProductCode.INSTANCE.getGrabpayAPPCode() && imageView != null) {
                imageView.setImageResource(R.drawable.tal_trade_payicon_grabpay);
            }
            boolean z = false;
            if (!TextUtils.isEmpty(payWayConfig.getLogoUrl())) {
                TalTradeImageLoader.newTask(payWayConfig.getLogoUrl()).scale(0, 0).bindImage(imageView);
            }
            if (textView != null) {
                textView.setText(payWayConfig.getPayProductName());
            }
            if (checkBox != null) {
                if (this.choosePosition == i) {
                    z = true;
                }
                checkBox.setChecked(z);
            }
            if (checkBox != null && checkBox.isChecked()) {
                checkBox.setBackgroundResource(R.drawable.tal_trade_shape_range_10_color_primary);
            } else if (checkBox != null) {
                checkBox.setBackgroundResource(R.drawable.tal_trade_shape_range_10_uncheck);
            }
        }
        if (checkBox != null) {
            checkBox.setOnClickListener(new TalTradePayWayAdapter$convert$1(this, talTradeViewHolder));
        }
    }

    public final void setOnItemClickListenerButton(TalTradeBaseAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListenerButton = onItemClickListener;
    }
}
