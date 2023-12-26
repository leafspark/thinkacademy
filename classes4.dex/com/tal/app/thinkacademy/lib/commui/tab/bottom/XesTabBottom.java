package com.tal.app.thinkacademy.lib.commui.tab.bottom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomInfo;
import com.tal.app.thinkacademy.lib.commui.tab.common.IXesTab;

public class XesTabBottom extends RelativeLayout implements IXesTab<XesTabBottomInfo<?>> {
    private View mRedPointView;
    private TextView mTabIconView;
    private ImageView mTabImageView;
    private XesTabBottomInfo<?> mTabInfo;
    private TextView mTabNameView;

    public XesTabBottom(Context context) {
        super(context);
        init();
    }

    public XesTabBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public XesTabBottom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater from = LayoutInflater.from(getContext());
        int i = R.layout.xes_tab_bottom;
        if (!(from instanceof LayoutInflater)) {
            from.inflate(i, this);
        } else {
            XMLParseInstrumentation.inflate(from, i, this);
        }
        this.mTabImageView = (ImageView) findViewById(R.id.iv_image);
        this.mTabIconView = (TextView) findViewById(R.id.tv_icon);
        this.mTabNameView = (TextView) findViewById(R.id.tv_name);
        this.mRedPointView = findViewById(R.id.view_point);
    }

    public void setXesTabInfo(XesTabBottomInfo<?> xesTabBottomInfo) {
        this.mTabInfo = xesTabBottomInfo;
        inflateInfo(false, true);
    }

    public void setXesTabHintPoint(boolean z) {
        this.mRedPointView.setVisibility(z ? 0 : 8);
    }

    private void inflateInfo(boolean z, boolean z2) {
        String string = getContext() != null ? getContext().getString(this.mTabInfo.tabNameStringId) : "";
        if (this.mTabInfo.tabType == XesTabBottomInfo.TabType.ICON) {
            if (z2) {
                this.mTabImageView.setVisibility(8);
                this.mTabIconView.setVisibility(0);
                this.mTabIconView.setTypeface(Typeface.createFromAsset(getContext().getAssets(), this.mTabInfo.iconFont));
                if (!TextUtils.isEmpty(string)) {
                    this.mTabNameView.setText(string);
                }
            }
            if (z) {
                this.mTabIconView.setText(TextUtils.isEmpty(this.mTabInfo.selectedIconName) ? this.mTabInfo.defaultIconName : this.mTabInfo.selectedIconName);
                this.mTabIconView.setTextColor(getTextColor(this.mTabInfo.tintColor));
                this.mTabNameView.setTextColor(getTextColor(this.mTabInfo.tintColor));
                return;
            }
            this.mTabIconView.setText(this.mTabInfo.defaultIconName);
            this.mTabIconView.setTextColor(getTextColor(this.mTabInfo.defaultColor));
            this.mTabNameView.setTextColor(getTextColor(this.mTabInfo.defaultColor));
        } else if (this.mTabInfo.tabType == XesTabBottomInfo.TabType.BITMAP) {
            if (z2) {
                this.mTabImageView.setVisibility(0);
                this.mTabIconView.setVisibility(8);
                if (!TextUtils.isEmpty(string)) {
                    this.mTabNameView.setText(string);
                }
            }
            if (z) {
                this.mTabImageView.setImageBitmap(this.mTabInfo.selectedBitmap);
            } else {
                this.mTabImageView.setImageBitmap(this.mTabInfo.defaultBitmap);
            }
        } else if (this.mTabInfo.tabType == XesTabBottomInfo.TabType.RESINT) {
            if (z2) {
                this.mTabImageView.setVisibility(0);
                this.mTabIconView.setVisibility(8);
                if (!TextUtils.isEmpty(string)) {
                    this.mTabNameView.setText(string);
                }
            }
            if (z) {
                this.mTabNameView.setTextColor(getTextColor(this.mTabInfo.tintColor));
                this.mTabImageView.setImageResource(this.mTabInfo.selectedBitmapRes);
                return;
            }
            this.mTabImageView.setImageResource(this.mTabInfo.defaultBitmapRes);
            this.mTabNameView.setTextColor(getTextColor(this.mTabInfo.defaultColor));
        }
    }

    public void resetHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i;
        setLayoutParams(layoutParams);
        getmTabNameView().setVisibility(8);
    }

    public void onTabSelectedChange(int i, XesTabBottomInfo<?> xesTabBottomInfo, XesTabBottomInfo<?> xesTabBottomInfo2) {
        XesTabBottomInfo<?> xesTabBottomInfo3 = this.mTabInfo;
        if ((xesTabBottomInfo != xesTabBottomInfo3 && xesTabBottomInfo2 != xesTabBottomInfo3) || xesTabBottomInfo == xesTabBottomInfo2) {
            return;
        }
        if (xesTabBottomInfo == xesTabBottomInfo3) {
            inflateInfo(false, false);
        } else {
            inflateInfo(true, false);
        }
    }

    public XesTabBottomInfo<?> getmTabInfo() {
        return this.mTabInfo;
    }

    public ImageView getmTabImageView() {
        return this.mTabImageView;
    }

    public TextView getmTabIconView() {
        return this.mTabIconView;
    }

    public TextView getmTabNameView() {
        return this.mTabNameView;
    }

    private int getTextColor(Object obj) {
        if (obj instanceof String) {
            return Color.parseColor((String) obj);
        }
        return ((Integer) obj).intValue();
    }
}
