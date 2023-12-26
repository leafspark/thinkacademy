package com.tal.app.thinkacademy.live.business.redpackage.driver;

import android.os.Bundle;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.util.LiveStabilityUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.live.business.redpackage.IActionListener;
import com.tal.app.thinkacademy.live.business.redpackage.config.RedPacketConfig;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "红包插件", ircType = {"redPacket", "mode"}, moduleId = "2")
@ViewLevels({@ViewLevel(level = 20, name = "redPacket")})
public class RedPacketLivePluginDriver extends BaseRedPacketPluginDriver implements IActionListener {
    /* access modifiers changed from: protected */
    public IActionListener initIActionListener() {
        return this;
    }

    public RedPacketLivePluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    public void onMessage(String str, String str2) {
        if (RedPacketConfig.REDPACKAGE.equalsIgnoreCase(str)) {
            try {
                XesLog.i(TAG, str2);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(str, str2);
                XesLog.ut((XesLogTag) TAG, jsonObject);
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(RedPacketConfig.REDPACKAGE);
                if (optJSONObject != null) {
                    this.interactId = optJSONObject.optString("interactId", "");
                    this.pub = optJSONObject.optBoolean("pub");
                    if (this.pub && !ShareDataManager.getInstance().getString(ShareDataKey.REDPACKET_INTERACTID, "", ShareDataManager.SHAREDATA_USER).equals(this.interactId)) {
                        ShareDataManager.getInstance().put(ShareDataKey.REDPACKET_INTERACTID, this.interactId, ShareDataManager.SHAREDATA_USER);
                        getRedPacketStatus();
                        track_start_redPacket();
                        LiveStabilityUtils.live_stability_track("Redbag", this.interactId, "start", 1, "");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
