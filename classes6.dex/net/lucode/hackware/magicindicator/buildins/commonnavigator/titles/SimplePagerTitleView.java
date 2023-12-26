package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;
import org.apache.commons.io.IOUtils;

public class SimplePagerTitleView extends TextView implements IMeasurablePagerTitleView {
    protected int mNormalColor;
    protected int mSelectedColor;

    public void onEnter(int i, int i2, float f, boolean z) {
    }

    public void onLeave(int i, int i2, float f, boolean z) {
    }

    public SimplePagerTitleView(Context context) {
        super(context, (AttributeSet) null);
        init(context);
    }

    private void init(Context context) {
        setGravity(17);
        int dip2px = UIUtil.dip2px(context, 10.0d);
        setPadding(dip2px, 0, dip2px, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public void onSelected(int i, int i2) {
        setTextColor(this.mSelectedColor);
    }

    public void onDeselected(int i, int i2) {
        setTextColor(this.mNormalColor);
    }

    public int getContentLeft() {
        String str;
        Rect rect = new Rect();
        if (getText().toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getContentRight() {
        String str;
        Rect rect = new Rect();
        if (getText().toString().contains(IOUtils.LINE_SEPARATOR_UNIX)) {
            str = "";
            for (String str2 : getText().toString().split("\\n")) {
                if (str2.length() > str.length()) {
                    str = str2;
                }
            }
        } else {
            str = getText().toString();
        }
        getPaint().getTextBounds(str, 0, str.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) (((float) (getHeight() / 2)) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getSelectedColor() {
        return this.mSelectedColor;
    }

    public void setSelectedColor(int i) {
        this.mSelectedColor = i;
    }

    public int getNormalColor() {
        return this.mNormalColor;
    }

    public void setNormalColor(int i) {
        this.mNormalColor = i;
    }
}
