package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.luck.picture.lib.PicturePreviewActivity;
import com.luck.picture.lib.PictureSelectorPreviewWeChatStyleActivity;
import com.luck.picture.lib.PictureVideoPlayActivity;

public class JumpUtils {
    public static void startPictureVideoPlayActivity(Context context, Bundle bundle, int i) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Intent intent = new Intent();
            intent.setClass(context, PictureVideoPlayActivity.class);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
            ((Activity) context).startActivityForResult(intent, i);
        }
    }

    public static void startPicturePreviewActivity(Context context, boolean z, Bundle bundle, int i) {
        if (!DoubleUtils.isFastDoubleClick()) {
            Intent intent = new Intent();
            intent.setClass(context, z ? PictureSelectorPreviewWeChatStyleActivity.class : PicturePreviewActivity.class);
            intent.putExtras(bundle);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
                context.startActivity(intent);
                return;
            }
            ((Activity) context).startActivityForResult(intent, i);
        }
    }
}
