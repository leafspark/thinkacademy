package com.adyen.checkout.card.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import com.adyen.checkout.card.data.ExpiryDate;
import com.adyen.checkout.components.ui.view.AdyenTextInputEditText;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.core.util.StringUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ExpiryDateInput extends AdyenTextInputEditText {
    private static final String DATE_FORMAT = "MM/yy";
    private static final int MAX_LENGTH = 5;
    private static final int MAX_SECOND_DIGIT_MONTH = 1;
    public static final String SEPARATOR = "/";
    private static final String TAG = LogUtil.getTag();
    private final SimpleDateFormat mDateFormat;

    public ExpiryDateInput(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExpiryDateInput(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpiryDateInput(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.ROOT);
        this.mDateFormat = simpleDateFormat;
        enforceMaxInputLength(5);
        simpleDateFormat.setLenient(false);
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        String replaceAll = obj.replaceAll("\\D", "").replaceAll("(\\d{2})(?=\\d)", "$1/");
        if (replaceAll.length() == 1 && isStringInt(replaceAll) && Integer.parseInt(replaceAll) > 1) {
            replaceAll = "0" + replaceAll;
        }
        if (!obj.equals(replaceAll)) {
            editable.replace(0, obj.length(), replaceAll);
        }
        super.afterTextChanged(editable);
    }

    public ExpiryDate getDate() {
        String normalize = StringUtil.normalize(getRawValue(), new char[0]);
        String str = TAG;
        Logger.v(str, "getDate - " + normalize);
        try {
            Date parse = this.mDateFormat.parse(normalize);
            Calendar instance = GregorianCalendar.getInstance();
            instance.setTime(parse);
            fixCalendarYear(instance);
            return new ExpiryDate(instance.get(2) + 1, instance.get(1), true);
        } catch (ParseException e) {
            String str2 = TAG;
            Logger.d(str2, "getDate - value does not match expected pattern. " + e.getLocalizedMessage());
            return getRawValue().isEmpty() ? ExpiryDate.EMPTY_DATE : ExpiryDate.INVALID_DATE;
        }
    }

    private void fixCalendarYear(Calendar calendar) {
        if (calendar.get(1) / 100 < GregorianCalendar.getInstance().get(1) / 100) {
            calendar.add(1, 100);
        }
    }

    public void setDate(ExpiryDate expiryDate) {
        if (expiryDate == null || expiryDate == ExpiryDate.EMPTY_DATE) {
            setText("");
            return;
        }
        String str = TAG;
        Logger.v(str, "setDate - " + expiryDate.getExpiryYear() + " " + expiryDate.getExpiryMonth());
        Calendar instance = GregorianCalendar.getInstance();
        instance.clear();
        instance.set(expiryDate.getExpiryYear(), expiryDate.getExpiryMonth() - 1, 1);
        setText(this.mDateFormat.format(instance.getTime()));
    }

    private boolean isStringInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
