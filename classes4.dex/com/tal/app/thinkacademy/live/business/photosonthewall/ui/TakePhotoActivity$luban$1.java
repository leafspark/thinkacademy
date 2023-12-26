package com.tal.app.thinkacademy.live.business.photosonthewall.ui;

import android.content.Context;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import top.zibin.luban.OnCompressListener;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/ui/TakePhotoActivity$luban$1", "Ltop/zibin/luban/OnCompressListener;", "onError", "", "e", "", "onStart", "onSuccess", "file", "Ljava/io/File;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoActivity.kt */
public final class TakePhotoActivity$luban$1 implements OnCompressListener {
    final /* synthetic */ String $cacheDir;
    final /* synthetic */ TakePhotoActivity this$0;

    public void onStart() {
    }

    TakePhotoActivity$luban$1(TakePhotoActivity takePhotoActivity, String str) {
        this.this$0 = takePhotoActivity;
        this.$cacheDir = str;
    }

    public void onSuccess(File file) {
        Unit unit;
        if (file == null) {
            unit = null;
        } else {
            TakePhotoActivity takePhotoActivity = this.this$0;
            String str = this.$cacheDir;
            XesLog.i(takePhotoActivity.TAG, "拍照成功，开始预览");
            String stringPlus = Intrinsics.stringPlus(str, file.getName());
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            takePhotoActivity.refreshAlbum(stringPlus, name);
            String name2 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            PreviewActivity.Companion.startActivity((Context) takePhotoActivity, takePhotoActivity.mTotalTime - (System.currentTimeMillis() - takePhotoActivity.mBeginTime), name2, takePhotoActivity.mPhotosMaintainData);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            TakePhotoActivity$luban$1 takePhotoActivity$luban$1 = this;
            XesLog.i(this.this$0.TAG, "luban 文件为空！！");
        }
        this.this$0.finish();
    }

    public void onError(Throwable th) {
        XesLog.i(this.this$0.TAG, "luban ---> onError");
        this.this$0.finish();
    }
}
