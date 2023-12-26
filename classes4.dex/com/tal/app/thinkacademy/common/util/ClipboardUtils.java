package com.tal.app.thinkacademy.common.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class ClipboardUtils {
    Handler handler = new Handler(Looper.getMainLooper());

    public static String getClipboardContent(Context context) {
        ClipData.Item itemAt;
        ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || itemAt.getText() == null) {
            return "";
        }
        return itemAt.getText().toString();
    }

    public static void clearClipboardContent(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
                clipboardManager.setText((CharSequence) null);
            } catch (Exception unused) {
            }
        }
    }
}
