package com.tal.app.thinkacademy.live.business.redpackage.driver;

import android.os.Bundle;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.redpackage.IActionListener;
import com.tal.app.thinkacademy.live.business.redpackage.config.RedPacketConfig;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "红包插件", ircType = {"redPacket", "mode"}, liveType = 1, moduleId = "2", noActiveKey = {"mode"})
@ViewLevels({@ViewLevel(level = 20, name = "redPacket")})
public class RedPacketPlayBackPluginDriver extends BaseRedPacketPluginDriver implements IActionListener {
    private static final Tag TAG = Tag.RED_PACKAGE;

    /* access modifiers changed from: protected */
    public IActionListener initIActionListener() {
        return this;
    }

    public RedPacketPlayBackPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    public void onMessage(String str, String str2) {
        if (RedPacketConfig.REDPACKAGE.equalsIgnoreCase(str)) {
            try {
                XesLog.i(TAG, str2);
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject(RedPacketConfig.REDPACKAGE);
                if (optJSONObject != null) {
                    this.interactId = optJSONObject.optString("interactId", "");
                    this.pub = optJSONObject.optBoolean("pub");
                    if (this.pub) {
                        getRedPacketStatus();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
