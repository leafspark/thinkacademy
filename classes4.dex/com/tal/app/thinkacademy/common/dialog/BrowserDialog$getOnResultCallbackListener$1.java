package com.tal.app.thinkacademy.common.dialog;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/common/dialog/BrowserDialog$getOnResultCallbackListener$1", "Lcom/luck/picture/lib/listener/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "onCancel", "", "onResult", "result", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserDialog.kt */
public final class BrowserDialog$getOnResultCallbackListener$1 implements OnResultCallbackListener<LocalMedia> {
    final /* synthetic */ BrowserDialog this$0;

    BrowserDialog$getOnResultCallbackListener$1(BrowserDialog browserDialog) {
        this.this$0 = browserDialog;
    }

    public void onResult(List<? extends LocalMedia> list) {
        Intrinsics.checkNotNullParameter(list, "result");
        try {
            Uri[] uriArr = new Uri[list.size()];
            int size = list.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                File file = new File(list.get(i).getCompressPath());
                if (file.exists()) {
                    uriArr[i] = Uri.fromFile(file);
                }
                i = i2;
            }
            XesLog.it("BrowserDialog", "拿到照片数据，将数据给到WebView");
            ValueCallback access$getMUploadMsg$p = this.this$0.mUploadMsg;
            if (access$getMUploadMsg$p != null) {
                access$getMUploadMsg$p.onReceiveValue(uriArr);
            }
            if (this.this$0.isTakePhoto) {
                XesLog.it("BrowserDialog", "拍照结束，通知开启自己的推流");
                XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).postStickyData("end");
            }
            BaseDialog access$getMChooseDialog$p = this.this$0.mChooseDialog;
            if (access$getMChooseDialog$p != null && access$getMChooseDialog$p.isShowing()) {
                BaseDialog access$getMChooseDialog$p2 = this.this$0.mChooseDialog;
                if (access$getMChooseDialog$p2 != null) {
                    access$getMChooseDialog$p2.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            XesLog.et("BrowserDialog", Intrinsics.stringPlus("选择照片异常：", e.getMessage()));
        }
    }

    public void onCancel() {
        BaseDialog access$getMChooseDialog$p;
        XesLog.it("BrowserDialog", "取消获取照片");
        BaseDialog access$getMChooseDialog$p2 = this.this$0.mChooseDialog;
        if ((access$getMChooseDialog$p2 != null && access$getMChooseDialog$p2.isShowing()) && (access$getMChooseDialog$p = this.this$0.mChooseDialog) != null) {
            access$getMChooseDialog$p.dismiss();
        }
        this.this$0.clearUploadMessage();
        if (this.this$0.isTakePhoto) {
            XesLog.it("BrowserDialog", "取消拍照，通知开启自己的推流");
            XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).postStickyData("end");
        }
    }
}
