package com.tal.app.thinkacademy;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.widget.bar.OnTitleBarListener;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/DemoActivity$onCreate$3", "Lcom/tal/app/thinkacademy/lib/commui/widget/bar/OnTitleBarListener;", "onLeftClick", "", "v", "Landroid/view/View;", "onRightClick", "onTitleClick", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DemoActivity.kt */
public final class DemoActivity$onCreate$3 extends OnTitleBarListener {
    DemoActivity$onCreate$3() {
    }

    public void onLeftClick(View view) {
        ToastUtils.showLong("左项View被点击", new Object[0]);
    }

    public void onTitleClick(View view) {
        ToastUtils.showLong("中间View被点击", new Object[0]);
    }

    public void onRightClick(View view) {
        ToastUtils.showLong("右项View被点击", new Object[0]);
    }
}
