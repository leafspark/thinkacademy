package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileIOUtils;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoActivity.kt */
public final class TakePhotoActivity$mHandler$1 extends Handler {
    final /* synthetic */ TakePhotoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TakePhotoActivity$mHandler$1(TakePhotoActivity takePhotoActivity, Looper looper) {
        super(looper);
        this.this$0 = takePhotoActivity;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        int i = message.what;
        if (i == this.this$0.KCreateFile) {
            TakePhotoActivity takePhotoActivity = this.this$0;
            takePhotoActivity.mFileName = System.currentTimeMillis() + ".jpg";
            String takePhotoCacheDir = AppCacheUtil.getTakePhotoCacheDir((Context) this.this$0);
            String stringPlus = Intrinsics.stringPlus(takePhotoCacheDir, this.this$0.mFileName);
            Object obj = message.obj;
            if (obj != null) {
                FileIOUtils.writeFileFromBytesByStream(stringPlus, (byte[]) obj);
                XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("KCreateFile ---> ", stringPlus));
                TakePhotoActivity takePhotoActivity2 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(takePhotoCacheDir, "cacheDir");
                takePhotoActivity2.luban(stringPlus, takePhotoCacheDir, this.this$0.mFileName);
            } else {
                NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                AsynchronousInstrumentation.handlerMessageEnd();
                throw nullPointerException;
            }
        } else if (i == 100) {
            XesLog.i(this.this$0.TAG, "拍照超时");
            TakePhotoActivity takePhotoActivity3 = this.this$0;
            Toast.makeText((Context) takePhotoActivity3, takePhotoActivity3.getString(R.string.take_photo_timeout), 1).show();
            this.this$0.switchCamera();
            this.this$0.safeToTakePicture = true;
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
