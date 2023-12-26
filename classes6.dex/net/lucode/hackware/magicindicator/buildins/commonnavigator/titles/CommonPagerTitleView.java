package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IMeasurablePagerTitleView;

public class CommonPagerTitleView extends FrameLayout implements IMeasurablePagerTitleView {
    private ContentPositionDataProvider mContentPositionDataProvider;
    private OnPagerTitleChangeListener mOnPagerTitleChangeListener;

    public interface ContentPositionDataProvider {
        int getContentBottom();

        int getContentLeft();

        int getContentRight();

        int getContentTop();
    }

    public interface OnPagerTitleChangeListener {
        void onDeselected(int i, int i2);

        void onEnter(int i, int i2, float f, boolean z);

        void onLeave(int i, int i2, float f, boolean z);

        void onSelected(int i, int i2);
    }

    public CommonPagerTitleView(Context context) {
        super(context);
    }

    public void onSelected(int i, int i2) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onSelected(i, i2);
        }
    }

    public void onDeselected(int i, int i2) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onDeselected(i, i2);
        }
    }

    public void onLeave(int i, int i2, float f, boolean z) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onLeave(i, i2, f, z);
        }
    }

    public void onEnter(int i, int i2, float f, boolean z) {
        OnPagerTitleChangeListener onPagerTitleChangeListener = this.mOnPagerTitleChangeListener;
        if (onPagerTitleChangeListener != null) {
            onPagerTitleChangeListener.onEnter(i, i2, f, z);
        }
    }

    public int getContentLeft() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        if (contentPositionDataProvider != null) {
            return contentPositionDataProvider.getContentLeft();
        }
        return getLeft();
    }

    public int getContentTop() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        if (contentPositionDataProvider != null) {
            return contentPositionDataProvider.getContentTop();
        }
        return getTop();
    }

    public int getContentRight() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        if (contentPositionDataProvider != null) {
            return contentPositionDataProvider.getContentRight();
        }
        return getRight();
    }

    public int getContentBottom() {
        ContentPositionDataProvider contentPositionDataProvider = this.mContentPositionDataProvider;
        if (contentPositionDataProvider != null) {
            return contentPositionDataProvider.getContentBottom();
        }
        return getBottom();
    }

    public void setContentView(View view) {
        setContentView(view, (FrameLayout.LayoutParams) null);
    }

    public void setContentView(View view, FrameLayout.LayoutParams layoutParams) {
        removeAllViews();
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            addView(view, layoutParams);
        }
    }

    public void setContentView(int i) {
        LayoutInflater from = LayoutInflater.from(getContext());
        setContentView(!(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null), (FrameLayout.LayoutParams) null);
    }

    public OnPagerTitleChangeListener getOnPagerTitleChangeListener() {
        return this.mOnPagerTitleChangeListener;
    }

    public void setOnPagerTitleChangeListener(OnPagerTitleChangeListener onPagerTitleChangeListener) {
        this.mOnPagerTitleChangeListener = onPagerTitleChangeListener;
    }

    public ContentPositionDataProvider getContentPositionDataProvider() {
        return this.mContentPositionDataProvider;
    }

    public void setContentPositionDataProvider(ContentPositionDataProvider contentPositionDataProvider) {
        this.mContentPositionDataProvider = contentPositionDataProvider;
    }
}
