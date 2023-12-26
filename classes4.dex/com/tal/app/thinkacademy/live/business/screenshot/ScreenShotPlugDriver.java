package com.tal.app.thinkacademy.live.business.screenshot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

@PluginAnnotation(desc = "截屏插件", launchType = "enter", liveType = 10086, moduleId = "-100")
public class ScreenShotPlugDriver extends BaseLivePluginDriver implements Observer<PluginEventData> {
    private XesLogTag TAG = Tag.SCREEN_SHOT;
    private Context mContext;
    private AtomicReference<ScreenShotToken> screenShotToken = new AtomicReference<>();
    private final AtomicBoolean shoting = new AtomicBoolean(false);

    public void onDestroy() {
    }

    public void onMessage(String str, String str2) {
    }

    public ScreenShotPlugDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
        PluginEventBus.register(this, ScreenShotEventKey.SCREEN_SHOT_EVENT, this);
        PluginEventBus.register(this, "video_bitmap", this);
    }

    /* access modifiers changed from: protected */
    public void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        ScreenShotPlugDriver.super.onLifecycleDestroy(lifecycleOwner);
        this.shoting.compareAndSet(true, false);
        this.screenShotToken.set((Object) null);
        PluginEventBus.unregister(ScreenShotEventKey.SCREEN_SHOT_EVENT, this);
        PluginEventBus.unregister("video_bitmap", this);
    }

    public void onChanged(PluginEventData pluginEventData) {
        String operation = pluginEventData.getOperation();
        operation.hashCode();
        if (operation.equals(ScreenShotEventKey.SCREEN_SHOT_OPERATION_KEY)) {
            XesLog.s(this.TAG, "收到截屏指令");
            Object object = pluginEventData.getObject();
            if (object instanceof ScreenShotToken) {
                this.screenShotToken.set((ScreenShotToken) object);
            }
            getScreenShortBitmap();
            track_click_screenshot();
        } else if (operation.equals("video_bitmap_operation")) {
            XesLog.s(this.TAG, "收到播放器截图");
            if (this.shoting.get()) {
                try {
                    JSONObject jSONObject = new JSONObject(pluginEventData.getData());
                    final String optString = jSONObject.optString("path");
                    final Rect rect = new Rect(jSONObject.optInt("left"), jSONObject.optInt("top"), jSONObject.optInt("right"), jSONObject.optInt("bottom"));
                    ThreadUtils.getCachedPool(5).execute(new Runnable() {
                        public void run() {
                            ScreenShotPlugDriver.this.createFullScreen(optString, rect);
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getScreenShortBitmap() {
        if (this.mContext == null) {
            XesLog.e(this.TAG, "getScreenShortBitmap 上下文空");
            ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.screen_shot_failed));
        } else if (this.shoting.get()) {
            XesLog.e(this.TAG, "getScreenShortBitmap 正在截图。。。");
            ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.screen_shoting));
        } else {
            this.shoting.compareAndSet(false, true);
            PluginEventBus.onEvent("video_shot", PluginEventData.obtainData(ScreenShotPlugDriver.class, "video_shot_operation"));
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap getViewBitmap(View view) {
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* access modifiers changed from: private */
    public void createFullScreen(String str, Rect rect) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            Bitmap viewBitmap = getViewBitmap(decorView);
            Bitmap bitmapFromFile = getBitmapFromFile(str);
            if (viewBitmap != null) {
                Bitmap composeBitmap = composeBitmap(bitmapFromFile, viewBitmap, rect);
                if (composeBitmap == null) {
                    XesLog.e(this.TAG, "createFullScreen 截图失败,shotBitmap=null");
                    ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.screen_shot_failed));
                    this.shoting.compareAndSet(true, false);
                    this.screenShotToken.set((Object) null);
                    return;
                }
                File file = new File(PathUtils.getExternalAppDataPath(), "xueersi/screenshots");
                if (!file.exists()) {
                    file.mkdirs();
                }
                String str2 = "xueersi" + System.currentTimeMillis() + ".jpg";
                File file2 = new File(file, str2);
                ImageUtils.save(composeBitmap, file2, Bitmap.CompressFormat.JPEG);
                XesLog.s(this.TAG, "图片保存本地，通知业务");
                sendScreenShotFile(file2.getPath(), this.screenShotToken.get());
                decorView.destroyDrawingCache();
                if (bitmapFromFile != null) {
                    bitmapFromFile.recycle();
                }
                viewBitmap.recycle();
                boolean saveToGallery = saveToGallery(this.mContext, composeBitmap, file2.getAbsolutePath(), Bitmap.CompressFormat.JPEG, str2, str2);
                composeBitmap.recycle();
                if (saveToGallery) {
                    XesLog.s(this.TAG, "截屏成功");
                } else {
                    ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.screen_shot_save_failed));
                    XesLog.e(this.TAG, "保存图片失败");
                }
            } else {
                XesLog.e(this.TAG, "createFullScreen 截图失败,fullScreenBitmap=null");
                ToastUtils.showShort((CharSequence) StringUtils.getString(R.string.screen_shot_failed));
                this.shoting.compareAndSet(true, false);
                this.screenShotToken.set((Object) null);
                return;
            }
        }
        this.shoting.compareAndSet(true, false);
        this.screenShotToken.set((Object) null);
    }

    private void sendScreenShotFile(String str, ScreenShotToken screenShotToken2) {
        PluginEventBus.onEvent(DataBusKey.LIVE_MEDIA_SCREEN_SHOT, new PluginEventData(ScreenShotPlugDriver.class, DataBusKey.LIVE_MEDIA_SCREEN_SHOT, str, screenShotToken2));
    }

    private Bitmap composeBitmap(Bitmap bitmap, Bitmap bitmap2, Rect rect) {
        if (bitmap == null && bitmap2 == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    private Bitmap getBitmapFromFile(String str) {
        if (!StringUtils.isEmpty(str) && new File(str).exists()) {
            return ImageUtils.getBitmap(str);
        }
        return null;
    }

    private boolean saveToGallery(Context context, Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, String str2, String str3) {
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), str, str2, str3);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile(new File(str)));
            context.sendBroadcast(intent);
            try {
                if (Build.VERSION.SDK_INT < 24) {
                    return true;
                }
                intent.setData(Uri.fromFile(new File(str)));
                context.sendBroadcast(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        return false;
    }

    private Uri fromFile(File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        Context context = this.mContext;
        return FileProvider.getUriForFile(context, this.mContext.getApplicationContext().getPackageName() + ".fileprovider", file);
    }

    public void track_click_screenshot() {
        LeanplumUtil.commonTrack(LeanplumUtil.click_screenshot, LeanplumUtil.trackMap());
    }
}
