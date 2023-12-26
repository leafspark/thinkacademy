package com.didi.hummer.adapter.navigator;

import android.content.Context;

public interface INavigatorAdapter {
    void openPage(Context context, NavPage navPage, NavCallback navCallback);

    void popBack(Context context, int i, NavPage navPage);

    void popPage(Context context, NavPage navPage);

    void popToPage(Context context, NavPage navPage);

    void popToRootPage(Context context, NavPage navPage);
}
