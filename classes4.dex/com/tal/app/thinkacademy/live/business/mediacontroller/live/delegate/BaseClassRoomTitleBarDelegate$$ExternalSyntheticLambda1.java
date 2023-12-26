package com.tal.app.thinkacademy.live.business.mediacontroller.live.delegate;

import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;

public final /* synthetic */ class BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda1 implements BaseDialog.OnDismissListener {
    public static final /* synthetic */ BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda1 INSTANCE = new BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda1();

    private /* synthetic */ BaseClassRoomTitleBarDelegate$$ExternalSyntheticLambda1() {
    }

    public final void dismiss() {
        XesDataBus.with(DataBusKey.EXAM_REPORT_SHOWING).postStickyData(false);
    }
}
