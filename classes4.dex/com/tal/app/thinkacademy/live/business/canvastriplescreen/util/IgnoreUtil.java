package com.tal.app.thinkacademy.live.business.canvastriplescreen.util;

import com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/util/IgnoreUtil;", "", "()V", "ignore", "", "path", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IgnoreUtil.kt */
public final class IgnoreUtil {
    public final boolean ignore(String str) {
        List split$default;
        Intrinsics.checkNotNullParameter(str, "path");
        String cloudKeyValue = HwCloudControlHelper.Companion.get().getCloudKeyValue("hw_courseware_file_ignore");
        CharSequence charSequence = cloudKeyValue;
        Object obj = null;
        if (charSequence == null || charSequence.length() == 0) {
            cloudKeyValue = null;
        }
        if (!(cloudKeyValue == null || (split$default = StringsKt.split$default(cloudKeyValue, new String[]{";"}, false, 0, 6, (Object) null)) == null)) {
            Iterator it = split$default.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (StringsKt.endsWith(str, (String) next, true)) {
                    obj = next;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
