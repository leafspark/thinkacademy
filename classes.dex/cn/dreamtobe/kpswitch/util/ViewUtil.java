package cn.dreamtobe.kpswitch.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.BarUtils;

public class ViewUtil {
    public static boolean refreshHeight(View view, int i) {
        if (view.isInEditMode()) {
            return false;
        }
        XesLog.dt(String.format("refresh Height %d %d", new Object[]{Integer.valueOf(view.getHeight()), Integer.valueOf(i)}), new Object[0]);
        if (view.getHeight() == i || Math.abs(view.getHeight() - i) == BarUtils.getStatusBarHeight()) {
            return false;
        }
        int validPanelHeight = KeyboardUtil.getValidPanelHeight(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, validPanelHeight));
        } else {
            layoutParams.height = validPanelHeight;
            view.requestLayout();
        }
        return true;
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static boolean isTranslucentStatus(Activity activity) {
        if (Build.VERSION.SDK_INT < 19 || (activity.getWindow().getAttributes().flags & 67108864) == 0) {
            return false;
        }
        return true;
    }

    static boolean isFitsSystemWindows(Activity activity) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT < 16 || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null || viewGroup.getChildCount() == 0) {
            return false;
        }
        return viewGroup.getChildAt(0).getFitsSystemWindows();
    }
}
