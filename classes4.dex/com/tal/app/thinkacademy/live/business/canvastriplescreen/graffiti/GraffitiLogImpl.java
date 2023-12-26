package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.xueersi.lib.graffiti.LogProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiLogImpl;", "Lcom/xueersi/lib/graffiti/LogProvider;", "()V", "d", "", "message", "", "e", "i", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiLogImpl.kt */
public final class GraffitiLogImpl implements LogProvider {
    public void i(String str) {
        XesLog.i(Tag.GRAFFITI_SDK, str);
    }

    public void d(String str) {
        XesLog.i(Tag.GRAFFITI_SDK, str);
    }

    public void e(String str) {
        XesLog.e(Tag.GRAFFITI_SDK, str);
    }
}
