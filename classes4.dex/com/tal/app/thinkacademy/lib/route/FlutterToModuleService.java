package com.tal.app.thinkacademy.lib.route;

import com.alibaba.android.arouter.facade.template.IProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/route/FlutterToModuleService;", "Lcom/alibaba/android/arouter/facade/template/IProvider;", "onEvent", "", "eventKey", "", "data", "", "onRoute", "routeKey", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlutterToModuleService.kt */
public interface FlutterToModuleService extends IProvider {
    void onEvent(String str, Object obj);

    void onRoute(String str, Object obj);
}
