package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.ArgbEvaluatorHolder;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public void onDeselected(int i, int i2) {
    }

    public void onSelected(int i, int i2) {
    }

    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.eval(f, this.mSelectedColor, this.mNormalColor));
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        setTextColor(ArgbEvaluatorHolder.eval(f, this.mNormalColor, this.mSelectedColor));
    }
}
