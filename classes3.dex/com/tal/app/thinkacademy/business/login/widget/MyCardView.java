package com.tal.app.thinkacademy.business.login.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/MyCardView;", "Lcom/flyco/roundview/RoundRelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cardBottomIcon", "Landroid/widget/ImageView;", "cardIcon", "cardName", "Landroid/widget/TextView;", "setData", "", "iconId", "", "name", "", "nameColor", "nameIconResId", "bottomBgResId", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MyCardView.kt */
public final class MyCardView extends RoundRelativeLayout {
    private ImageView cardBottomIcon;
    private ImageView cardIcon;
    private TextView cardName;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MyCardView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        int i = R.layout.login_layout_my_card;
        ViewGroup viewGroup = (ViewGroup) this;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(from, i, viewGroup);
        }
        this.cardIcon = (ImageView) findViewById(R.id.card_icon);
        this.cardName = (TextView) findViewById(R.id.card_name);
        this.cardBottomIcon = (ImageView) findViewById(R.id.card_bottom_bg);
    }

    public final void setData(int i, String str, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (i == 0) {
            ImageView imageView = this.cardIcon;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        } else {
            ImageView imageView2 = this.cardIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.cardIcon;
            if (imageView3 != null) {
                imageView3.setImageResource(i);
            }
        }
        TextView textView = this.cardName;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.cardName;
        if (textView2 != null) {
            textView2.setTextColor(i2);
        }
        Drawable drawable = getContext().getDrawable(i3);
        if (drawable != null) {
            drawable.setBounds(0, 0, SizeUtils.dp2px(8.0f), SizeUtils.dp2px(8.0f));
        }
        TextView textView3 = this.cardName;
        if (textView3 != null) {
            textView3.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        }
        ImageView imageView4 = this.cardBottomIcon;
        if (imageView4 != null) {
            imageView4.setImageResource(i4);
        }
    }
}
