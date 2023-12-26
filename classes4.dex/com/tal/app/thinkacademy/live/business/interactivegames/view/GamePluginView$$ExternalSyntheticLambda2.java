package com.tal.app.thinkacademy.live.business.interactivegames.view;

import android.view.View;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;

public final /* synthetic */ class GamePluginView$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ GamePluginView f$0;
    public final /* synthetic */ BaseDialog f$1;

    public /* synthetic */ GamePluginView$$ExternalSyntheticLambda2(GamePluginView gamePluginView, BaseDialog baseDialog) {
        this.f$0 = gamePluginView;
        this.f$1 = baseDialog;
    }

    public final void onClick(View view) {
        GamePluginView.m300showErrorDialog$lambda11$lambda10(this.f$0, this.f$1, view);
    }
}
