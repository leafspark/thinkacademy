package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import android.os.Bundle;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/PhotosOnTheWallPlayBackPlugin;", "Lcom/tal/app/thinkacademy/live/business/photosonthewall/driver/BasePhotosOnTheWallPlugin;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAnnotation(desc = "拍照上墙", ircType = {"take_picture", "take_picture_f"}, liveType = 1, moduleId = "218")
@ViewLevels({@ViewLevel(level = 20, name = "photos_on_the_wall")})
/* compiled from: PhotosOnTheWallPlayBackPlugin.kt */
public final class PhotosOnTheWallPlayBackPlugin extends BasePhotosOnTheWallPlugin {
    public PhotosOnTheWallPlayBackPlugin(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
    }
}
