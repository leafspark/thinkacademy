package com.tal.app.thinkacademy.live.business.star;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.util.InteractReportKt;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "点赞插件", ircType = {"praise"}, moduleId = "220")
@ViewLevels({@ViewLevel(level = 20, name = "star")})
public class StarPluginDriver extends BaseLivePluginDriver {
    private static final Tag TAG = Tag.StarPluginDriver;
    private final String keyPraise = "praise";
    protected Context mContext;
    private boolean mIsShow;
    private StarPluginView mStarPluginView;

    public void onDestroy() {
    }

    public StarPluginDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        XesLog.i(TAG, "StarPluginDriver init successful");
    }

    public void onMessage(String str, String str2) {
        if (TextUtils.equals(str, "praise")) {
            Tag tag = TAG;
            XesLog.i(tag, "ircTypeKey --> " + str);
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("praise");
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("pub", false);
                    String optString = optJSONObject.optString("type", "");
                    boolean optBoolean2 = optJSONObject.optBoolean("photoWallClose", false);
                    String optString2 = optJSONObject.optString("interactId");
                    ShareDataManager.getInstance().put(ShareDataKey.CURRENT_INTERACT_ID, optString2, ShareDataManager.SHAREDATA_NOT_CLEAR);
                    XesLog.i(tag, "pub --> " + optBoolean);
                    XesLog.i(tag, "photoWallClose --> " + optBoolean2);
                    if (optBoolean) {
                        InteractReportKt.XesLogReport("displayPhotoOnWall", "Photopost", optString2, 1);
                        showStarView();
                    } else {
                        removeStarView();
                    }
                    if (optBoolean2) {
                        InteractReportKt.XesLogReport("end", "Photopost", optString2, 0);
                        if (!TextUtils.isEmpty(optString)) {
                            XesDataBus.with(DataBusKey.TAKE_DRAW_STATE).postStickyData("");
                        }
                        ShareDataManager.getInstance().put(ShareDataKey.CURRENT_INTERACT_ID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
                        ShareDataManager.getInstance().put(ShareDataKey.CURRENT_INTERACT_BG, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
                        ShareDataManager.getInstance().put(ShareDataKey.IS_TAKE_PHOTO, false, ShareDataManager.SHAREDATA_CAN_CLEAR);
                        XesDataBus.with(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL).postStickyData(DataBusKey.PHOTO_ON_THE_WALL_CLOSE_ALL);
                        return;
                    }
                    InteractReportKt.XesLogReport("start", "Photopost", optString2, 0);
                    TextUtils.isEmpty(optString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void showStarView() {
        if (this.mStarPluginView == null) {
            this.mStarPluginView = new StarPluginView(this.mContext);
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            this.mStarPluginView.layoutView();
            this.mLiveRoomProvider.addView(this, this.mStarPluginView, this.mPluginConfData.getViewLevel("star"), newLp);
        }
        this.mStarPluginView.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void removeStarView() {
        StarPluginView starPluginView = this.mStarPluginView;
        if (starPluginView != null) {
            starPluginView.setVisibility(8);
        }
    }
}
