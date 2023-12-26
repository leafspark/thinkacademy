package com.tal.app.thinkacademy.live.business.roomdata;

import android.os.Bundle;
import android.text.TextUtils;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "课程基础状态存储，更新", ircType = {"mode"}, launchType = "enter", moduleId = "-105")
public class RoomDataDriver extends BaseLivePluginDriver {
    public void onDestroy() {
    }

    public RoomDataDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }

    public void onMessage(String str, String str2) {
        Tag tag = Tag.ROOM_DATA;
        XesLog.i(tag, "ircTypeKey=" + str + "，message=" + str2);
        if ("mode".equals(str) && this.mLiveRoomProvider != null && this.mLiveRoomProvider.getDataStorage() != null) {
            RoomData roomData = this.mLiveRoomProvider.getDataStorage().getRoomData();
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String optString = new JSONObject(str2).optString(str);
                    roomData.setMode(optString);
                    if (VoteNoticeCode.MODE_CLASS.equals(optString)) {
                        roomData.setStreamMode(1);
                    } else if (!"in-training".equals(optString)) {
                    } else {
                        if (roomData.getStreamMode() == 1) {
                            roomData.setStreamMode(2);
                        } else {
                            roomData.setStreamMode(2);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
