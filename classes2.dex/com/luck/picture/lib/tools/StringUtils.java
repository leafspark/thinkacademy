package com.luck.picture.lib.tools;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.PictureMimeType;
import java.util.regex.Pattern;

public class StringUtils {
    public static void tempTextFont(TextView textView, int i) {
        String str;
        String trim = textView.getText().toString().trim();
        if (i == PictureMimeType.ofAudio()) {
            str = textView.getContext().getString(R.string.picture_empty_audio_title);
        } else {
            str = textView.getContext().getString(R.string.picture_empty_title);
        }
        String str2 = str + trim;
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), str.length(), str2.length(), 33);
        textView.setText(spannableString);
    }

    public static int stringToInt(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return ValueOf.toInt(str);
        }
        return 0;
    }

    public static String getMsg(Context context, String str, int i) {
        if (PictureMimeType.isHasVideo(str)) {
            return context.getString(R.string.picture_message_video_max_num, new Object[]{Integer.valueOf(i)});
        } else if (PictureMimeType.isHasAudio(str)) {
            return context.getString(R.string.picture_message_audio_max_num, new Object[]{Integer.valueOf(i)});
        } else {
            return context.getString(R.string.picture_message_max_num, new Object[]{Integer.valueOf(i)});
        }
    }

    public static String rename(String str) {
        String substring = str.substring(0, str.lastIndexOf("."));
        String substring2 = str.substring(str.lastIndexOf("."));
        return substring + "_" + DateUtils.getCreateFileName() + substring2;
    }

    public static String renameSuffix(String str, String str2) {
        String substring = str.substring(0, str.lastIndexOf("."));
        return substring + str2;
    }

    public static String getEncryptionValue(long j, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return "";
        }
        return j + "_" + i + i2;
    }
}
