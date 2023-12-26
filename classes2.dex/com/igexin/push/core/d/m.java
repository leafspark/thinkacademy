package com.igexin.push.core.d;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;

public class m extends g {
    public m() {
        super("com.meizu.flyme.openidsdk", "");
    }

    public boolean a(Context context) {
        if (!super.a(context)) {
            try {
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), (String[]) null, (String) null, new String[]{"support"}, (String) null);
                if (query == null) {
                    return false;
                }
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = query.getString(columnIndex);
                    if (TextUtils.isEmpty(string)) {
                        return false;
                    }
                    c = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE.equals(string);
                } else {
                    c = false;
                }
            } catch (Throwable unused) {
                c = false;
                return false;
            }
        } else {
            c = true;
        }
        this.d = true;
        return c;
    }

    public String b(Context context) {
        a(new String[]{"oaid"});
        return super.b(context);
    }
}
