package com.tal.app.thinkacademy.lib.commui.refresh;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.tal.app.thinkacademy.lib.commui.R;

public class DefaultHeader extends SimpleComponent implements RefreshHeader {
    private ImageView imageView = ((ImageView) this.mWrappedView.findViewById(R.id.iv_refresh_header));
    private View root;

    public DefaultHeader(View view) {
        super(view);
    }

    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        ((AnimationDrawable) this.imageView.getBackground()).stop();
        this.mWrappedView.setVisibility(8);
        return 0;
    }

    /* renamed from: com.tal.app.thinkacademy.lib.commui.refresh.DefaultHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smart.refresh.layout.constant.RefreshState[] r0 = com.scwang.smart.refresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState = r0
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smart.refresh.layout.constant.RefreshState r1 = com.scwang.smart.refresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.commui.refresh.DefaultHeader.AnonymousClass1.<clinit>():void");
        }
    }

    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        int i = AnonymousClass1.$SwitchMap$com$scwang$smart$refresh$layout$constant$RefreshState[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mWrappedView.setVisibility(0);
        } else if (i == 3 || i == 4) {
            this.imageView.setBackgroundResource(R.drawable.animlst_app_refresh_loading);
            ((AnimationDrawable) this.imageView.getBackground()).start();
        } else if (i == 7) {
            this.imageView.setBackgroundResource(R.drawable.animlst_app_refresh_loading);
            ((AnimationDrawable) this.imageView.getBackground()).start();
        }
    }

    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        DefaultHeader.super.onMoving(z, f, i, i2, i3);
        if (f <= 1.0f) {
            this.imageView.setScaleX(f);
            this.imageView.setScaleY(f);
        }
    }
}
