package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.text.TextUtils;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.utils.ListUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J \u0010\t\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent$setBaseListener$1", "Lcom/xueersi/lib/graffiti/WXTGraffitiEngine$Listener$Adapter;", "onFetchedDBActionList", "", "pageId", "", "actionList", "", "Lcom/xueersi/lib/graffiti/WXWBAction;", "onUnSupportActionList", "", "restore", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiAgent.kt */
public final class GraffitiAgent$setBaseListener$1 extends WXTGraffitiEngine.Listener.Adapter {
    final /* synthetic */ Function2<String, Map<String, ? extends List<? extends WXWBAction>>, Unit> $callbackDB;
    final /* synthetic */ GraffitiAgent this$0;

    GraffitiAgent$setBaseListener$1(GraffitiAgent graffitiAgent, Function2<? super String, ? super Map<String, ? extends List<? extends WXWBAction>>, Unit> function2) {
        this.this$0 = graffitiAgent;
        this.$callbackDB = function2;
    }

    public void onFetchedDBActionList(String str, List<? extends WXWBAction> list) {
        Map map;
        Intrinsics.checkNotNullParameter(str, "pageId");
        GraffitiAgent$setBaseListener$1.super.onFetchedDBActionList(str, list);
        String str2 = null;
        if (list == null) {
            map = null;
        } else {
            map = new LinkedHashMap();
            for (Object next : list) {
                String uid = ((WXWBAction) next).getUid();
                Object obj = map.get(uid);
                if (obj == null) {
                    obj = new ArrayList();
                    map.put(uid, obj);
                }
                ((List) obj).add(next);
            }
        }
        CharSequence charSequence = str;
        WXTGraffitiEngineImpl mGraffitiEngine = this.this$0.getMGraffitiEngine();
        if (TextUtils.equals(charSequence, mGraffitiEngine == null ? null : mGraffitiEngine.getPageKey())) {
            this.this$0.log(Intrinsics.stringPlus("涂鸦翻页回调 pageId = ", str));
            this.this$0.setMPageKey(str);
            this.$callbackDB.invoke(str, map);
            return;
        }
        GraffitiAgent graffitiAgent = this.this$0;
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("涂鸦翻页回调,与引擎pageKey不符 pageId = ");
        sb.append(str);
        sb.append("，Engine pageKey = ");
        WXTGraffitiEngineImpl mGraffitiEngine2 = this.this$0.getMGraffitiEngine();
        if (mGraffitiEngine2 != null) {
            str2 = mGraffitiEngine2.getPageKey();
        }
        sb.append(str2);
        objArr[0] = sb.toString();
        graffitiAgent.log(objArr);
    }

    public void onUnSupportActionList(List<WXWBAction> list, boolean z) {
        GraffitiAgent$setBaseListener$1.super.onUnSupportActionList(list, z);
        if (!ListUtil.isEmpty(list)) {
            if (list != null) {
                GraffitiAgent graffitiAgent = this.this$0;
                for (WXWBAction wXWBAction : list) {
                    graffitiAgent.log(Intrinsics.stringPlus("暂不支持的涂鸦数据 ", wXWBAction.getUniqueKey()));
                    graffitiAgent.printAction(wXWBAction);
                }
            }
            GraffitiCallback graffitiCallback = this.this$0.getGraffitiCallback();
            if (graffitiCallback != null) {
                graffitiCallback.onUnSupportActionList(list, z);
            }
        }
    }
}
