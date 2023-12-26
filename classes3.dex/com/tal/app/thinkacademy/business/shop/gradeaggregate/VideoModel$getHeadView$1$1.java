package com.tal.app.thinkacademy.business.shop.gradeaggregate;

import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.common.widget.HwPlayerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/business/shop/gradeaggregate/VideoModel$getHeadView$1$1", "Lcom/tal/app/thinkacademy/common/widget/HwPlayerView$HwPayerViewListen;", "playBtnClick", "", "isPlay", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoModel.kt */
public final class VideoModel$getHeadView$1$1 implements HwPlayerView.HwPayerViewListen {
    final /* synthetic */ VideoModel this$0;

    VideoModel$getHeadView$1$1(VideoModel videoModel) {
        this.this$0 = videoModel;
    }

    public void playBtnClick(boolean z) {
        ShopTrack.INSTANCE.hw_shop_aggregate_video_click(String.valueOf(this.this$0.getMPageId()));
    }
}
