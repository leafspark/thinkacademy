package com.tal.app.thinkacademy.common.utils;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.tal.app.thinkacademy.common.widget.TextClickSpan;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eJE\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0002\u0010\u0015J0\u0010\u0016\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0014J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014JE\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0002\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/TextHighLightUtil;", "", "()V", "setTextFirstHighLightColorSize", "", "textView", "Landroid/widget/TextView;", "text", "", "keyword", "color", "", "size", "ignoreCase", "", "setTextHighLight", "tv", "", "colors", "listeners", "Landroid/view/View$OnClickListener;", "(Landroid/widget/TextView;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Integer;[Landroid/view/View$OnClickListener;)V", "setTextHighLightColorSize", "setTextHighLightWithClick", "keyWord", "listener", "setTextHighLightWithClicks", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextHighLightUtil.kt */
public final class TextHighLightUtil {
    public static final TextHighLightUtil INSTANCE = new TextHighLightUtil();

    private TextHighLightUtil() {
    }

    public final void setTextHighLightWithClicks(TextView textView, String str, String[] strArr, Integer[] numArr, View.OnClickListener[] onClickListenerArr) {
        TextView textView2 = textView;
        String str2 = str;
        String[] strArr2 = strArr;
        Integer[] numArr2 = numArr;
        View.OnClickListener[] onClickListenerArr2 = onClickListenerArr;
        Intrinsics.checkNotNullParameter(textView2, "tv");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(strArr2, "keyword");
        Intrinsics.checkNotNullParameter(numArr2, "colors");
        Intrinsics.checkNotNullParameter(onClickListenerArr2, "listeners");
        textView2.setClickable(true);
        int i = 0;
        textView2.setHighlightColor(0);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(str2);
        HashMap hashMap = new HashMap();
        int length = strArr2.length;
        while (i < length) {
            int i2 = i + 1;
            String str3 = strArr2[i];
            Pattern compile = Pattern.compile(str3);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(key)");
            Matcher matcher = compile.matcher(spannableString);
            Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(s)");
            while (matcher.find()) {
                if (!hashMap.containsKey(str3)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    spannableString.setSpan(new ForegroundColorSpan(numArr2[i].intValue()), start, end, 33);
                    spannableString.setSpan(new TextClickSpan(numArr2[i].intValue(), onClickListenerArr2[i]), start, end, 33);
                    spannableString.setSpan(new UnderlineSpan(), start, end, 33);
                }
                hashMap.put(str3, true);
                String[] strArr3 = strArr;
            }
            strArr2 = strArr;
            i = i2;
        }
        textView2.setText(spannableString);
    }

    public final void setTextHighLight(TextView textView, String str, String[] strArr, Integer[] numArr, View.OnClickListener[] onClickListenerArr) {
        TextView textView2 = textView;
        String str2 = str;
        String[] strArr2 = strArr;
        Integer[] numArr2 = numArr;
        View.OnClickListener[] onClickListenerArr2 = onClickListenerArr;
        Intrinsics.checkNotNullParameter(textView2, "tv");
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(strArr2, "keyword");
        Intrinsics.checkNotNullParameter(numArr2, "colors");
        Intrinsics.checkNotNullParameter(onClickListenerArr2, "listeners");
        SpannableString spannableString = new SpannableString(str2);
        HashMap hashMap = new HashMap();
        int length = strArr2.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            String str3 = strArr2[i];
            Pattern compile = Pattern.compile(str3);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(key)");
            Matcher matcher = compile.matcher(spannableString);
            Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(s)");
            while (matcher.find()) {
                if (!hashMap.containsKey(str3)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    spannableString.setSpan(new ForegroundColorSpan(numArr2[i].intValue()), start, end, 33);
                    spannableString.setSpan(new TextClickSpan(numArr2[i].intValue(), onClickListenerArr2[i]), start, end, 33);
                    spannableString.setSpan(new UnderlineSpan(), start, end, 33);
                }
                hashMap.put(str3, true);
                String[] strArr3 = strArr;
            }
            strArr2 = strArr;
            i = i2;
        }
        textView2.setText(spannableString);
    }

    public static /* synthetic */ void setTextHighLightWithClick$default(TextHighLightUtil textHighLightUtil, TextView textView, String str, String str2, int i, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            onClickListener = null;
        }
        textHighLightUtil.setTextHighLightWithClick(textView, str, str2, i, onClickListener);
    }

    public final void setTextHighLightWithClick(TextView textView, String str, String str2, int i, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(textView, "tv");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "keyword");
        textView.setClickable(true);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(str);
        CharSequence charSequence = spannableString;
        int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, str2, 0, false, 6, (Object) null);
        int length = str2.length() + lastIndexOf$default;
        if (lastIndexOf$default >= 0 && length <= spannableString.length()) {
            spannableString.setSpan(new ForegroundColorSpan(i), lastIndexOf$default, length, 33);
            if (onClickListener != null) {
                spannableString.setSpan(new TextClickSpan(i, onClickListener), lastIndexOf$default, length, 33);
            }
            spannableString.setSpan(new UnderlineSpan(), lastIndexOf$default, length, 33);
        }
        textView.setText(charSequence);
    }

    public final void setTextHighLightWithClick(TextView textView, String str, String str2, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(textView, "tv");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "keyWord");
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        textView.setClickable(true);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(str);
        Pattern compile = Pattern.compile(str2);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(keyWord)");
        CharSequence charSequence = spannableString;
        Matcher matcher = compile.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(s)");
        while (matcher.find()) {
            spannableString.setSpan(new TextClickSpan(onClickListener), matcher.start(), matcher.end(), 33);
        }
        textView.setText(charSequence);
    }

    public final void setTextHighLightColorSize(TextView textView, String str, String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "keyword");
        if (textView != null) {
            textView.setClickable(true);
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            SpannableString spannableString = new SpannableString(str);
            CharSequence charSequence = spannableString;
            int lastIndexOf$default = StringsKt.lastIndexOf$default(charSequence, str2, 0, false, 6, (Object) null);
            int length = str2.length() + lastIndexOf$default;
            if (lastIndexOf$default >= 0 && length <= spannableString.length()) {
                spannableString.setSpan(new ForegroundColorSpan(i), lastIndexOf$default, length, 33);
                spannableString.setSpan(new AbsoluteSizeSpan(i2), lastIndexOf$default, length, 33);
            }
            textView.setText(charSequence);
        }
    }

    public static /* synthetic */ void setTextFirstHighLightColorSize$default(TextHighLightUtil textHighLightUtil, TextView textView, String str, String str2, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z = false;
        }
        textHighLightUtil.setTextFirstHighLightColorSize(textView, str, str2, i, i2, z);
    }

    public final void setTextFirstHighLightColorSize(TextView textView, String str, String str2, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "keyword");
        if (textView != null) {
            textView.setClickable(true);
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            SpannableString spannableString = new SpannableString(str);
            CharSequence charSequence = spannableString;
            int indexOf$default = StringsKt.indexOf$default(charSequence, str2, 0, z, 2, (Object) null);
            int length = str2.length() + indexOf$default;
            if (indexOf$default >= 0 && length <= spannableString.length()) {
                spannableString.setSpan(new ForegroundColorSpan(i), indexOf$default, length, 33);
                spannableString.setSpan(new AbsoluteSizeSpan(i2), indexOf$default, length, 33);
            }
            textView.setText(charSequence);
        }
    }
}
