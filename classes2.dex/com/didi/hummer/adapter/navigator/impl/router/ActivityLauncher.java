package com.didi.hummer.adapter.navigator.impl.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class ActivityLauncher {
    private static final String TAG = "ActivityLauncher";
    private Context mContext;
    private RouterFragment mRouterFragment;
    private RouterFragmentV4 mRouterFragmentV4;

    public interface Callback {
        void onActivityResult(int i, Intent intent);
    }

    public static ActivityLauncher init(Context context) {
        return new ActivityLauncher(context);
    }

    public static ActivityLauncher init(Fragment fragment) {
        return init((Context) fragment.getActivity());
    }

    private ActivityLauncher(Context context) {
        this.mContext = context;
        if (context instanceof FragmentActivity) {
            this.mRouterFragmentV4 = getRouterFragmentV4((FragmentActivity) context);
        } else if (context instanceof Activity) {
            this.mRouterFragment = getRouterFragment((Activity) context);
        }
    }

    private RouterFragmentV4 getRouterFragmentV4(FragmentActivity fragmentActivity) {
        RouterFragmentV4 findRouterFragmentV4 = findRouterFragmentV4(fragmentActivity);
        if (findRouterFragmentV4 != null) {
            return findRouterFragmentV4;
        }
        RouterFragmentV4 newInstance = RouterFragmentV4.newInstance();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(newInstance, TAG).commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return newInstance;
    }

    private RouterFragmentV4 findRouterFragmentV4(FragmentActivity fragmentActivity) {
        return fragmentActivity.getSupportFragmentManager().findFragmentByTag(TAG);
    }

    private RouterFragment getRouterFragment(Activity activity) {
        RouterFragment findRouterFragment = findRouterFragment(activity);
        if (findRouterFragment != null) {
            return findRouterFragment;
        }
        RouterFragment newInstance = RouterFragment.newInstance();
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        fragmentManager.beginTransaction().add(newInstance, TAG).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return newInstance;
    }

    private RouterFragment findRouterFragment(Activity activity) {
        return (RouterFragment) activity.getFragmentManager().findFragmentByTag(TAG);
    }

    public void startActivityForResult(Class<?> cls, Callback callback) {
        startActivityForResult(new Intent(this.mContext, cls), callback);
    }

    public void startActivityForResult(Intent intent, Callback callback) {
        RouterFragmentV4 routerFragmentV4 = this.mRouterFragmentV4;
        if (routerFragmentV4 != null) {
            routerFragmentV4.startActivityForResult(intent, callback);
            return;
        }
        RouterFragment routerFragment = this.mRouterFragment;
        if (routerFragment != null) {
            routerFragment.startActivityForResult(intent, callback);
            return;
        }
        Context context = this.mContext;
        if (context != null) {
            context.startActivity(intent);
            return;
        }
        throw new RuntimeException("please do init first!");
    }
}
