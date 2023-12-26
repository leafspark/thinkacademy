package com.coloros.ocs.base.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import com.coloros.ocs.base.a.e;
import com.coloros.ocs.base.common.constant.CommonStatusCodes;

public class ConnectionResult {
    private int mErrorCode;
    private PendingIntent mPendingIntent;

    public ConnectionResult(int i) {
        this(i, (PendingIntent) null);
    }

    protected ConnectionResult(int i, PendingIntent pendingIntent) {
        this.mErrorCode = i;
        this.mPendingIntent = pendingIntent;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return CommonStatusCodes.getStatusCodeString(this.mErrorCode);
    }

    /* access modifiers changed from: protected */
    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    /* access modifiers changed from: protected */
    public boolean hasResolution() {
        return (this.mErrorCode == 0 || this.mPendingIntent == null) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return e.a(this).a("statusCode", CommonStatusCodes.getStatusCodeString(this.mErrorCode)).toString();
    }
}
