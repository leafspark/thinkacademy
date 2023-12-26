package com.tal.app.thinkacademy.common.widget.gold;

import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/gold/DefaultFlyCoinConfig;", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinConfig;", "()V", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultFlyCoinConfig.kt */
public final class DefaultFlyCoinConfig extends FlyCoinConfig {
    public DefaultFlyCoinConfig() {
        super(true, true, new FlyCoinLineConfig(FlyCoinLineDirection.DOWN, AppNetWorkConfigRemoteInfo.MAX_TIME_OUT, 1000), new FlyCoinLineConfig(FlyCoinLineDirection.DOWN, 70, 1000), new FlyCoinLineConfig(FlyCoinLineDirection.UP, LiveMessageCode.LIVE_BUSINESS_FEEDBACK_MESSAGE, 1000));
    }
}
