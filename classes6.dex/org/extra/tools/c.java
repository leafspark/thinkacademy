package org.extra.tools;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class c extends Fragment {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());
    private final Object b = new Object();

    public void a(d dVar) {
        synchronized (this.b) {
            this.a.add(dVar);
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        FragmentTrackHelper.trackOnHiddenChanged(this, z);
    }

    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    public void onResume() {
        super.onResume();
        Object obj = this.b;
        synchronized (obj) {
            try {
                for (d dVar : this.a) {
                    if (dVar != null) {
                        dVar.onResume();
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    FragmentTrackHelper.trackFragmentResume(obj);
                    throw th;
                }
            }
        }
        FragmentTrackHelper.trackFragmentResume(obj);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }
}
