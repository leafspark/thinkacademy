package com.tal.app.thinkacademy.live.business.direction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/PlugGoldView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mImages", "", "", "setUp", "", "coins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlugGoldView.kt */
public final class PlugGoldView extends LinearLayout {
    private final List<Integer> mImages;

    public PlugGoldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        List<Integer> arrayList = new ArrayList<>();
        this.mImages = arrayList;
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_0));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_1));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_2));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_3));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_4));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_5));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_6));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_7));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_8));
        arrayList.add(Integer.valueOf(R.drawable.icon_award_coin_num_9));
    }

    public final void setUp(int i) {
        removeAllViews();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.icon_award_coin_num_plus);
        addView(imageView);
        addView(new View(getContext()), new LinearLayout.LayoutParams(SizeUtils.dp2px(4.0f), SizeUtils.dp2px(1.0f)));
        String valueOf = String.valueOf(i);
        int length = valueOf.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = valueOf.charAt(i2);
            i2++;
            ImageView imageView2 = new ImageView(getContext());
            imageView2.setImageResource(this.mImages.get(Character.getNumericValue(charAt)).intValue());
            addView(imageView2);
        }
    }
}
