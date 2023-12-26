package com.tal.app.thinkacademy;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.server.OnServerConnectionListener;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.LinkedList;

public class LocalServerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnStartServer;
    private Button btnStopServer;
    private String mRootUrl;
    private TextView tvMsg;

    public void finish() {
        LocalServerActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        LocalServerActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        LocalServerActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        LocalServerActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        LocalServerActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        LocalServerActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        LocalServerActivity.super.onCreate(bundle);
        setContentView(R.layout.activity_server);
        this.btnStartServer = (Button) findViewById(R.id.btn_start_server);
        this.btnStopServer = (Button) findViewById(R.id.btn_stop_server);
        this.tvMsg = (TextView) findViewById(2131298751);
        this.btnStartServer.setOnClickListener(this);
        this.btnStopServer.setOnClickListener(this);
        initListener();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, this);
        switch (view.getId()) {
            case R.id.btn_start_server /*2131296471*/:
                ServerManager.getInstance().startService(getApplicationContext());
                break;
            case R.id.btn_stop_server /*2131296472*/:
                ServerManager.getInstance().stopService(getApplicationContext());
                break;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ServerManager.getInstance().stopService(getApplicationContext());
        LocalServerActivity.super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void onLocalServerStart(String str) {
        this.btnStartServer.setVisibility(8);
        this.btnStopServer.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        this.mRootUrl = str;
        String str2 = this.mRootUrl + "dist/index.html?localUrl=" + this.mRootUrl + "b88f62e2650e45668de1099db6bfae81/index.html&role=student&itsId=f2c9c8dd3d054effb19a6991539831a9";
        linkedList.add(this.mRootUrl);
        linkedList.add(str2);
        this.tvMsg.setText(TextUtils.join("\n", linkedList));
        Bundle bundle = new Bundle();
        bundle.putString("jump_key", str2);
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setShowTitle(false).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
        bundle.clear();
    }

    /* access modifiers changed from: private */
    public void onLocalServerError(String str) {
        this.mRootUrl = null;
        this.btnStartServer.setVisibility(0);
        this.btnStopServer.setVisibility(8);
        this.tvMsg.setText(str);
    }

    /* access modifiers changed from: private */
    public void onLocalServerStop() {
        this.mRootUrl = null;
        this.btnStartServer.setVisibility(0);
        this.btnStopServer.setVisibility(8);
        this.tvMsg.setText(R.string.server_stop_succeed);
    }

    private void initListener() {
        ServerManager.getInstance().setOnServerConnectionListener(new OnServerConnectionListener() {
            public void onServerRequestError(int i, String str) {
            }

            public void onServerStart(String str) {
                LocalServerActivity.this.onLocalServerStart(ServerManager.getInstance().getServerUrl());
            }

            public void onServerError(String str) {
                LocalServerActivity.this.onLocalServerError(str);
            }

            public void onServerStop() {
                LocalServerActivity.this.onLocalServerStop();
            }
        });
    }
}
