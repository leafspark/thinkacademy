package com.tal.app.thinkacademy.live.business.nps;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001J\u001a\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/nps/NpsPluginDriver$loadState$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/nps/NpsBean;", "onSuccess", "", "t", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsPluginDriver.kt */
public final class NpsPluginDriver$loadState$1 extends OmyCallback<HiResponse<NpsBean>> {
    final /* synthetic */ NpsPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NpsPluginDriver$loadState$1(NpsPluginDriver npsPluginDriver, NpsPluginDriver$loadState$2 npsPluginDriver$loadState$2) {
        super(npsPluginDriver$loadState$2);
        this.this$0 = npsPluginDriver;
    }

    public void onSuccess(HiResponse<NpsBean> hiResponse) {
        Long l = null;
        NpsBean data = hiResponse == null ? null : hiResponse.getData();
        XesLogTag access$getTAG$p = this.this$0.TAG;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("请求nps接口获取弹窗状态成功 state(1 开，2 关):");
        sb.append(data == null ? null : Integer.valueOf(data.getStatus()));
        sb.append(" 展示NPS时间戳:");
        if (data != null) {
            l = Long.valueOf(data.getNpsTime());
        }
        sb.append(l);
        objArr[0] = sb.toString();
        XesLog.s(access$getTAG$p, objArr);
        if (data != null) {
            this.this$0.status = data.getStatus();
            this.this$0.npsTime = data.getNpsTime();
            this.this$0.tagList = data.getTagList();
        }
    }
}
