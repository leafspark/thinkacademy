package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import io.flutter.FlutterInjector;

public class FlutterApplication extends Application {
    private Activity mCurrentActivity = null;

    public void attachBaseContext(Context context) {
        AppStateInfo.attachBaseContextBegin(this, context);
        super.attachBaseContext(context);
        AppStateInfo.attachBaseContextEnd();
    }

    public void onCreate() {
        AppStateInfo.onCreateAppBegin(getClass().getName());
        super.onCreate();
        FlutterInjector.instance().flutterLoader().startInitialization(this);
        AppStateInfo.onCreateAppEnd(getClass().getName());
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }
}
