package com.tal.app.thinkacademy.common.business.browser.view;

import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.business.browser.view.WebFileSelectModel;
import com.tal.app.thinkacademy.common.entity.H5PhotoLibraryParam;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/common/business/browser/view/WebFileSelectModel$mOnResultListen$1", "Lcom/luck/picture/lib/listener/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "onCancel", "", "onResult", "result", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebFileSelectModel.kt */
public final class WebFileSelectModel$mOnResultListen$1 implements OnResultCallbackListener<LocalMedia> {
    final /* synthetic */ WebFileSelectModel this$0;

    WebFileSelectModel$mOnResultListen$1(WebFileSelectModel webFileSelectModel) {
        this.this$0 = webFileSelectModel;
    }

    public void onResult(List<LocalMedia> list) {
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("onResult result size = ");
        sb.append(list == null ? null : Integer.valueOf(list.size()));
        sb.append(",ThreadName=");
        sb.append(Thread.currentThread().getName());
        int i = 0;
        objArr[0] = sb.toString();
        XesLog.dt("WebFileSelectModel", objArr);
        H5PhotoLibraryParam access$getMH5Param$p = this.this$0.mH5Param;
        if ((access$getMH5Param$p == null ? 1 : access$getMH5Param$p.isCompress()) == 1 && !this.this$0.isCloseVideoCompress()) {
            if (list != null) {
                i = list.size();
            }
            if (i == 1 && this.this$0.mSelectType == WebFileSelectModel.SelectType.CHOOSE_VIDEO) {
                this.this$0.startVideoCompress(list);
                return;
            }
        }
        this.this$0.startUpload(list);
    }

    public void onCancel() {
        XesLog.dt("WebFileSelectModel", Intrinsics.stringPlus("onCancel 取消选择,ThreadName=", Thread.currentThread().getName()));
        this.this$0.sendJsCancel();
    }
}
