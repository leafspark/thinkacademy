package cn.dreamtobe.kpswitch.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import cn.dreamtobe.kpswitch.IFSPanelConflictLayout;
import cn.dreamtobe.kpswitch.IPanelHeightTarget;
import cn.dreamtobe.kpswitch.handler.KPSwitchFSPanelLayoutHandler;
import cn.dreamtobe.kpswitch.util.ViewUtil;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.logger.XesLog;

public class KPSwitchFSPanelLinearLayout extends LinearLayout implements IPanelHeightTarget, IFSPanelConflictLayout {
    private int mOrientation;
    private KPSwitchFSPanelLayoutHandler panelHandler;

    public KPSwitchFSPanelLinearLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    public KPSwitchFSPanelLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public KPSwitchFSPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    public KPSwitchFSPanelLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KPSwitchFSPanelLinearLayout, i, 0)) == null)) {
            this.mOrientation = obtainStyledAttributes.getInt(R.styleable.KPSwitchFSPanelLinearLayout_panel_orientation, 0);
            obtainStyledAttributes.recycle();
        }
        this.panelHandler = new KPSwitchFSPanelLayoutHandler(this);
    }

    public void refreshHeight(int i) {
        boolean refreshHeight = ViewUtil.refreshHeight(this, i);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i2 = getContext().getResources().getConfiguration().orientation;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("refreshHeight:refresh=");
        sb.append(refreshHeight);
        sb.append(",panelHeight=");
        sb.append(i);
        sb.append(",");
        sb.append(layoutParams != null ? Integer.valueOf(layoutParams.height) : "未知");
        sb.append(",orientation=");
        sb.append(i2);
        objArr[0] = sb.toString();
        XesLog.it("KeyboardUtil", objArr);
    }

    public void onKeyboardShowing(boolean z) {
        this.panelHandler.onKeyboardShowing(z);
    }

    public void recordKeyboardStatus(Window window) {
        this.panelHandler.recordKeyboardStatus(window);
    }

    public int getOrientation() {
        return this.mOrientation;
    }
}
