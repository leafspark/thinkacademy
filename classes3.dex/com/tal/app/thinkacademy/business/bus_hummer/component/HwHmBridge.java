package com.tal.app.thinkacademy.business.bus_hummer.component;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.hummer.annotation.Component;
import com.didi.hummer.annotation.JsMethod;
import com.didi.hummer.context.HummerContext;
import com.tal.app.thinkacademy.business.bus_hummer.HwHummerActivity;
import com.tal.app.thinkacademy.business.bus_hummer.Tag;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.utils.ClipboardUtilKt;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.Map;
import org.json.JSONObject;

@Component("HwHmBridge")
public class HwHmBridge {
    private final Tag TAG = Tag.HUMMER_PAGE;

    @JsMethod("copyString")
    public boolean copyString(HummerContext hummerContext, String str) {
        Tag tag = this.TAG;
        XesLog.i(tag, new Object[]{"copyString 开始拷贝字符串到剪切版,str = " + str});
        ClipboardUtilKt.copyClipboard(hummerContext, str);
        return true;
    }

    @JsMethod("openWechat")
    public boolean openWechat(HummerContext hummerContext) {
        XesLog.i(this.TAG, new Object[]{"openWechat 打开微信失败"});
        try {
            hummerContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("weixin://")));
            return true;
        } catch (Exception e) {
            Tag tag = this.TAG;
            XesLog.e(tag, new Object[]{"openWechat 打开微信失败:" + e});
            return false;
        }
    }

    @JsMethod("setTopBarTitle")
    public void setTopBarTitle(HummerContext hummerContext, String str, String str2) {
        Tag tag = this.TAG;
        XesLog.i(tag, new Object[]{"setTopBarTitle 设置,str=" + str + ",color=" + str2});
        if (hummerContext != null && hummerContext.getContext() != null) {
            Context context = hummerContext.getContext();
            if (context instanceof HwHummerActivity) {
                XesLog.i(this.TAG, new Object[]{"setTopBarTitle 设置hummer页面导航栏"});
                ((HwHummerActivity) context).setTopBarTitle(str, str2);
                return;
            }
            XesLog.i(this.TAG, new Object[]{"setTopBarTitle 不是hummer页面"});
        }
    }

    @JsMethod("track")
    public void track(HummerContext hummerContext, String str, Map<String, Object> map) {
        JSONObject jSONObject;
        if (map == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            jSONObject = new JSONObject(map);
        }
        Tag tag = this.TAG;
        XesLog.i(tag, new Object[]{"eventName=" + str + ",map=" + jSONObject});
        HwTrackUtil.INSTANCE.track(str, jSONObject);
    }
}
