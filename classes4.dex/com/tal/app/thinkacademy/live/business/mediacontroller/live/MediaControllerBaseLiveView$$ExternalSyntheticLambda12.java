package com.tal.app.thinkacademy.live.business.mediacontroller.live;

import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import java.util.HashMap;

public final /* synthetic */ class MediaControllerBaseLiveView$$ExternalSyntheticLambda12 implements BaseDialog.OnDismissListener {
    public static final /* synthetic */ MediaControllerBaseLiveView$$ExternalSyntheticLambda12 INSTANCE = new MediaControllerBaseLiveView$$ExternalSyntheticLambda12();

    private /* synthetic */ MediaControllerBaseLiveView$$ExternalSyntheticLambda12() {
    }

    public final void dismiss() {
        LeanplumUtil.commonTrack(LeanplumUtil.click_exercise_close, new HashMap());
    }
}
