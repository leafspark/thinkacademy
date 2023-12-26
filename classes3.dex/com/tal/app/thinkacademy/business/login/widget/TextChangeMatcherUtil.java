package com.tal.app.thinkacademy.business.login.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001*B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J*\u0010!\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0016J*\u0010&\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0016J\u0014\u0010(\u001a\u00020\u001e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010)\u001a\u00020\u001eH\u0002R\u0014\u0010\f\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\rXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/TextChangeMatcherUtil;", "Landroid/text/TextWatcher;", "textList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/business/login/widget/MatcherType;", "button", "Landroid/widget/Button;", "textView", "Landroid/widget/TextView;", "timeCountUtil", "Lcom/tal/app/thinkacademy/business/login/widget/TimeCountUtil;", "(Ljava/util/ArrayList;Landroid/widget/Button;Landroid/widget/TextView;Lcom/tal/app/thinkacademy/business/login/widget/TimeCountUtil;)V", "CODE", "", "getCODE", "()I", "PHONE_CHINA", "getPHONE_CHINA", "PHONE_HONGKONG", "getPHONE_HONGKONG", "mButton", "mFlagBtn", "", "mFlagTxt", "mItemBtn", "mItemTxt", "mTextList", "mTextView", "mTimeCountUtil", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "setmTextList", "statusChange", "TYPE", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextChangeMatcherUtil.kt */
public final class TextChangeMatcherUtil implements TextWatcher {
    private final int CODE = 2;
    private final int PHONE_CHINA;
    private final int PHONE_HONGKONG = 1;
    private Button mButton;
    private boolean mFlagBtn;
    private boolean mFlagTxt;
    private ArrayList<Boolean> mItemBtn;
    private ArrayList<Boolean> mItemTxt;
    private ArrayList<MatcherType> mTextList;
    private TextView mTextView;
    private TimeCountUtil mTimeCountUtil;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/TextChangeMatcherUtil$TYPE;", "", "(Ljava/lang/String;I)V", "EDIT_VIEW", "MULTI_VIEW", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextChangeMatcherUtil.kt */
    public enum TYPE {
        EDIT_VIEW,
        MULTI_VIEW
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public TextChangeMatcherUtil(ArrayList<MatcherType> arrayList, Button button, TextView textView, TimeCountUtil timeCountUtil) {
        Intrinsics.checkNotNullParameter(arrayList, "textList");
        Intrinsics.checkNotNullParameter(button, "button");
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(timeCountUtil, "timeCountUtil");
        this.mTextList = arrayList;
        this.mItemBtn = new ArrayList<>();
        this.mItemTxt = new ArrayList<>();
        this.mTextView = textView;
        this.mButton = button;
        this.mTimeCountUtil = timeCountUtil;
    }

    public final int getPHONE_CHINA() {
        return this.PHONE_CHINA;
    }

    public final int getPHONE_HONGKONG() {
        return this.PHONE_HONGKONG;
    }

    public final int getCODE() {
        return this.CODE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        r8 = r8.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onTextChanged(java.lang.CharSequence r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            java.util.ArrayList<java.lang.Boolean> r5 = r4.mItemBtn
            r5.clear()
            java.util.ArrayList<java.lang.Boolean> r5 = r4.mItemTxt
            r5.clear()
            java.util.ArrayList<com.tal.app.thinkacademy.business.login.widget.MatcherType> r5 = r4.mTextList
            int r5 = r5.size()
            r6 = 0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r8 = r6
        L_0x0016:
            r0 = 1
            if (r8 >= r5) goto L_0x00d5
            int r1 = r8 + 1
            java.util.ArrayList<com.tal.app.thinkacademy.business.login.widget.MatcherType> r2 = r4.mTextList
            java.lang.Object r8 = r2.get(r8)
            java.lang.String r2 = "mTextList[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.tal.app.thinkacademy.business.login.widget.MatcherType r8 = (com.tal.app.thinkacademy.business.login.widget.MatcherType) r8
            int r2 = r8.getType()
            int r3 = r4.PHONE_CHINA
            if (r2 != r3) goto L_0x006a
            android.widget.EditText r8 = r8.getEditText()
            if (r8 != 0) goto L_0x0038
        L_0x0036:
            r8 = r6
            goto L_0x0048
        L_0x0038:
            android.text.Editable r8 = r8.getText()
            if (r8 != 0) goto L_0x003f
            goto L_0x0036
        L_0x003f:
            int r8 = r8.length()
            r2 = 11
            if (r8 != r2) goto L_0x0036
            r8 = r0
        L_0x0048:
            if (r8 == 0) goto L_0x005e
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            r8.add(r2)
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemTxt
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.add(r0)
            goto L_0x00d2
        L_0x005e:
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            r8.add(r7)
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemTxt
            r8.add(r7)
            goto L_0x00d2
        L_0x006a:
            int r3 = r4.PHONE_HONGKONG
            if (r2 != r3) goto L_0x00a6
            android.widget.EditText r8 = r8.getEditText()
            if (r8 != 0) goto L_0x0076
        L_0x0074:
            r8 = r6
            goto L_0x0086
        L_0x0076:
            android.text.Editable r8 = r8.getText()
            if (r8 != 0) goto L_0x007d
            goto L_0x0074
        L_0x007d:
            int r8 = r8.length()
            r2 = 8
            if (r8 != r2) goto L_0x0074
            r8 = r0
        L_0x0086:
            if (r8 == 0) goto L_0x009b
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
            r8.add(r2)
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemTxt
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.add(r0)
            goto L_0x00d2
        L_0x009b:
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            r8.add(r7)
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemTxt
            r8.add(r7)
            goto L_0x00d2
        L_0x00a6:
            int r3 = r4.CODE
            if (r2 != r3) goto L_0x00d2
            android.widget.EditText r8 = r8.getEditText()
            if (r8 != 0) goto L_0x00b2
        L_0x00b0:
            r8 = r6
            goto L_0x00c1
        L_0x00b2:
            android.text.Editable r8 = r8.getText()
            if (r8 != 0) goto L_0x00b9
            goto L_0x00b0
        L_0x00b9:
            int r8 = r8.length()
            r2 = 6
            if (r8 != r2) goto L_0x00b0
            r8 = r0
        L_0x00c1:
            if (r8 == 0) goto L_0x00cd
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.add(r0)
            goto L_0x00d2
        L_0x00cd:
            java.util.ArrayList<java.lang.Boolean> r8 = r4.mItemBtn
            r8.add(r7)
        L_0x00d2:
            r8 = r1
            goto L_0x0016
        L_0x00d5:
            r4.mFlagBtn = r0
            r4.mFlagTxt = r0
            java.util.ArrayList<java.lang.Boolean> r5 = r4.mItemBtn
            int r5 = r5.size()
            r7 = r6
        L_0x00e0:
            if (r7 >= r5) goto L_0x0102
            int r8 = r7 + 1
            boolean r1 = r4.mFlagBtn
            if (r1 == 0) goto L_0x00fd
            java.util.ArrayList<java.lang.Boolean> r1 = r4.mItemBtn
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r1 = "mItemBtn[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00fd
            r7 = r0
            goto L_0x00fe
        L_0x00fd:
            r7 = r6
        L_0x00fe:
            r4.mFlagBtn = r7
            r7 = r8
            goto L_0x00e0
        L_0x0102:
            java.util.ArrayList<java.lang.Boolean> r5 = r4.mItemTxt
            int r5 = r5.size()
            r7 = r6
        L_0x0109:
            if (r7 >= r5) goto L_0x012b
            int r8 = r7 + 1
            boolean r1 = r4.mFlagTxt
            if (r1 == 0) goto L_0x0126
            java.util.ArrayList<java.lang.Boolean> r1 = r4.mItemTxt
            java.lang.Object r7 = r1.get(r7)
            java.lang.String r1 = "mItemTxt[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0126
            r7 = r0
            goto L_0x0127
        L_0x0126:
            r7 = r6
        L_0x0127:
            r4.mFlagTxt = r7
            r7 = r8
            goto L_0x0109
        L_0x012b:
            r4.statusChange()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.widget.TextChangeMatcherUtil.onTextChanged(java.lang.CharSequence, int, int, int):void");
    }

    private final void statusChange() {
        TextView textView;
        if (this.mFlagBtn) {
            Button button = this.mButton;
            if (button != null) {
                Intrinsics.checkNotNull(button);
                button.setEnabled(true);
                Button button2 = this.mButton;
                Intrinsics.checkNotNull(button2);
                button2.setBackgroundResource(R.drawable.et_underline_selected);
                this.mButton.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
            }
        } else {
            Button button3 = this.mButton;
            if (button3 != null) {
                Intrinsics.checkNotNull(button3);
                button3.setEnabled(false);
                Button button4 = this.mButton;
                Intrinsics.checkNotNull(button4);
                button4.setBackgroundResource(R.drawable.et_underline_selected);
                this.mButton.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
            }
        }
        TimeCountUtil timeCountUtil = this.mTimeCountUtil;
        if (timeCountUtil != null) {
            Intrinsics.checkNotNull(timeCountUtil);
            if (!(timeCountUtil.getTimer() == -1 || (textView = this.mTextView) == null)) {
                Intrinsics.checkNotNull(textView);
                textView.setEnabled(true);
                this.mTextView.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
                return;
            }
        }
        if (this.mFlagTxt) {
            TextView textView2 = this.mTextView;
            if (textView2 != null) {
                Intrinsics.checkNotNull(textView2);
                textView2.setEnabled(true);
                this.mTextView.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
                return;
            }
            return;
        }
        TextView textView3 = this.mTextView;
        if (textView3 != null) {
            Intrinsics.checkNotNull(textView3);
            textView3.setEnabled(true);
            this.mTextView.setTextColor(ContextCompat.getColor(AppUtil.getApplication().getApplicationContext(), R.color.color_ffaa0a));
        }
    }

    public final void setmTextList(ArrayList<MatcherType> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "mTextList");
        this.mTextList = arrayList;
    }
}
