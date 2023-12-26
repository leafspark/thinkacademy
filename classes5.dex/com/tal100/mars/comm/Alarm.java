package com.tal100.mars.comm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal100.mars.xlog.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Alarm extends BroadcastReceiver {
    private static final String KEXTRA_ID = "ID";
    private static final String KEXTRA_PID = "PID";
    private static final String TAG = "MicroMsg.Alarm";
    private static TreeSet<Object[]> alarm_waiting_set = new TreeSet<>(new ComparatorAlarm());
    private static Alarm bc_alarm;
    private static WakerLock wakerlock;

    private enum TSetData {
        ID,
        WAITTIME,
        PENDINGINTENT
    }

    private native void onAlarm(long j);

    private static class ComparatorAlarm implements Comparator<Object[]> {
        private ComparatorAlarm() {
        }

        public int compare(Object[] objArr, Object[] objArr2) {
            return (int) (objArr[TSetData.ID.ordinal()].longValue() - objArr2[TSetData.ID.ordinal()].longValue());
        }
    }

    public static void resetAlarm(Context context) {
        synchronized (alarm_waiting_set) {
            Iterator<Object[]> it = alarm_waiting_set.iterator();
            while (it.hasNext()) {
                cancelAlarmMgr(context, (PendingIntent) it.next()[TSetData.PENDINGINTENT.ordinal()]);
            }
            alarm_waiting_set.clear();
            Alarm alarm = bc_alarm;
            if (alarm != null) {
                context.unregisterReceiver(alarm);
                bc_alarm = null;
            }
        }
    }

    public static boolean start(long j, int i, Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (i < 0) {
            Log.e(TAG, "id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            return false;
        } else if (context == null) {
            Log.e(TAG, "null==context, id:%d, after:%d", Long.valueOf(j), Integer.valueOf(i));
            return false;
        } else {
            synchronized (alarm_waiting_set) {
                if (wakerlock == null) {
                    wakerlock = new WakerLock(context);
                    Log.i(TAG, "start new wakerlock");
                }
                if (bc_alarm == null) {
                    Alarm alarm = new Alarm();
                    bc_alarm = alarm;
                    context.registerReceiver(alarm, new IntentFilter("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")"));
                }
                Iterator<Object[]> it = alarm_waiting_set.iterator();
                while (it.hasNext()) {
                    if (((Long) it.next()[TSetData.ID.ordinal()]).longValue() == j) {
                        Log.e(TAG, "id exist=%d", Long.valueOf(j));
                        return false;
                    }
                }
                if (i >= 0) {
                    elapsedRealtime += (long) i;
                }
                PendingIntent alarmMgr = setAlarmMgr(j, elapsedRealtime, context);
                if (alarmMgr == null) {
                    return false;
                }
                alarm_waiting_set.add(new Object[]{Long.valueOf(j), Long.valueOf(elapsedRealtime), alarmMgr});
                return true;
            }
        }
    }

    public static boolean stop(long j, Context context) {
        if (context == null) {
            Log.e(TAG, "context==null");
            return false;
        }
        synchronized (alarm_waiting_set) {
            if (wakerlock == null) {
                wakerlock = new WakerLock(context);
                Log.i(TAG, "stop new wakerlock");
            }
            if (bc_alarm == null) {
                bc_alarm = new Alarm();
                context.registerReceiver(bc_alarm, new IntentFilter());
                Log.i(TAG, "stop new Alarm");
            }
            Iterator<Object[]> it = alarm_waiting_set.iterator();
            while (it.hasNext()) {
                Object[] next = it.next();
                if (((Long) next[TSetData.ID.ordinal()]).longValue() == j) {
                    cancelAlarmMgr(context, (PendingIntent) next[TSetData.PENDINGINTENT.ordinal()]);
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    private static PendingIntent setAlarmMgr(long j, long j2, Context context) {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "am == null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("ALARM_ACTION(" + String.valueOf(Process.myPid()) + ")");
        intent.putExtra(KEXTRA_ID, j);
        intent.putExtra(KEXTRA_PID, Process.myPid());
        if (Build.VERSION.SDK_INT < 23) {
            int i = (int) j;
            PushAutoTrackHelper.hookIntentGetBroadcast(context, i, intent, 268435456);
            pendingIntent = PendingIntent.getBroadcast(context, i, intent, 268435456);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(pendingIntent, context, i, intent, 268435456);
        } else {
            int i2 = (int) j;
            PushAutoTrackHelper.hookIntentGetBroadcast(context, i2, intent, 335544320);
            pendingIntent = PendingIntent.getBroadcast(context, i2, intent, 335544320);
            PushAutoTrackHelper.hookPendingIntentGetBroadcast(pendingIntent, context, i2, intent, 335544320);
        }
        if (Build.VERSION.SDK_INT < 19) {
            alarmManager.set(2, j2, pendingIntent);
        } else {
            alarmManager.setExact(2, j2, pendingIntent);
        }
        return pendingIntent;
    }

    private static boolean cancelAlarmMgr(Context context, PendingIntent pendingIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            Log.e(TAG, "am == null");
            return false;
        } else if (pendingIntent == null) {
            Log.e(TAG, "pendingIntent == null");
            return false;
        } else {
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
            return true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (context != null && intent != null) {
            Long valueOf = Long.valueOf(intent.getLongExtra(KEXTRA_ID, 0));
            Integer valueOf2 = Integer.valueOf(intent.getIntExtra(KEXTRA_PID, 0));
            if (0 != valueOf.longValue() && valueOf2.intValue() != 0 && valueOf2.intValue() == Process.myPid()) {
                synchronized (alarm_waiting_set) {
                    Iterator<Object[]> it = alarm_waiting_set.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((Long) it.next()[TSetData.ID.ordinal()]).equals(valueOf)) {
                                it.remove();
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        Log.e(TAG, "onReceive not found id:%d, pid:%d, alarm_waiting_set.size:%d", valueOf, valueOf2, Integer.valueOf(alarm_waiting_set.size()));
                    }
                }
                WakerLock wakerLock = wakerlock;
                if (wakerLock != null) {
                    wakerLock.lock(200);
                }
                if (z) {
                    onAlarm(valueOf.longValue());
                }
            }
        }
    }
}
