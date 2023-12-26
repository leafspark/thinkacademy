package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;

public class PlayerErrorDialog extends BaseDialog {
    private TextView mBtnExit = ((TextView) findViewById(R.id.player_exit));
    private TextView mBtnRetry = ((TextView) findViewById(R.id.player_retry));
    /* access modifiers changed from: private */
    public PlayerErrorListen mPlayerErrorListen;

    public interface PlayerErrorListen {
        void onExit();

        void onRetry();
    }

    public PlayerErrorDialog(Context context) {
        super(context);
        contentView(R.layout.study_player_error_dialog);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mBtnExit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PlayerErrorDialog.class);
                if (PlayerErrorDialog.this.mPlayerErrorListen != null) {
                    PlayerErrorDialog.this.mPlayerErrorListen.onExit();
                }
                PlayerErrorDialog.this.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
        this.mBtnRetry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MethodInfo.onClickEventEnter(view, PlayerErrorDialog.class);
                if (PlayerErrorDialog.this.mPlayerErrorListen != null) {
                    PlayerErrorDialog.this.mPlayerErrorListen.onRetry();
                }
                PlayerErrorDialog.this.dismiss();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                MethodInfo.onClickEventEnd();
            }
        });
    }

    public void setPlayerErrorListen(PlayerErrorListen playerErrorListen) {
        this.mPlayerErrorListen = playerErrorListen;
    }
}
