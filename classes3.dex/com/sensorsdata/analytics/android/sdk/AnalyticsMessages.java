package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.exceptions.DebugModeException;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.ConstantsKt;
import org.json.JSONObject;

class AnalyticsMessages {
    private static final int DELETE_ALL = 4;
    private static final int FLUSH_QUEUE = 3;
    private static final int FLUSH_SCHEDULE = 5;
    private static final Map<Context, AnalyticsMessages> S_INSTANCES = new HashMap();
    private static final String TAG = "SA.AnalyticsMessages";
    private final Context mContext;
    /* access modifiers changed from: private */
    public final DbAdapter mDbAdapter = DbAdapter.getInstance();
    private SensorsDataAPI mSensorsDataAPI;
    private final Worker mWorker = new Worker();

    private boolean isDeleteEventsByCode(int i) {
        return (i == 404 || i == 403 || (i >= 500 && i < 600)) ? false : true;
    }

    private AnalyticsMessages(Context context, SensorsDataAPI sensorsDataAPI) {
        this.mContext = context;
        this.mSensorsDataAPI = sensorsDataAPI;
    }

    public static AnalyticsMessages getInstance(Context context, SensorsDataAPI sensorsDataAPI) {
        AnalyticsMessages analyticsMessages;
        Map<Context, AnalyticsMessages> map = S_INSTANCES;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (!map.containsKey(applicationContext)) {
                analyticsMessages = new AnalyticsMessages(applicationContext, sensorsDataAPI);
                map.put(applicationContext, analyticsMessages);
            } else {
                analyticsMessages = map.get(applicationContext);
            }
        }
        return analyticsMessages;
    }

    private static byte[] slurp(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[ConstantsKt.DEFAULT_BUFFER_SIZE];
        while (true) {
            int read = inputStream.read(bArr, 0, ConstantsKt.DEFAULT_BUFFER_SIZE);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void enqueueEventMessage(String str, JSONObject jSONObject) {
        try {
            synchronized (this.mDbAdapter) {
                int addJSON = this.mDbAdapter.addJSON(jSONObject);
                if (addJSON < 0) {
                    String str2 = "Failed to enqueue the event: " + jSONObject;
                    if (!this.mSensorsDataAPI.isDebugMode()) {
                        SALog.i(TAG, str2);
                    } else {
                        throw new DebugModeException(str2);
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = 3;
                if (!this.mSensorsDataAPI.isDebugMode()) {
                    if (addJSON != -2) {
                        if (!str.equals("track_signup")) {
                            if (addJSON <= this.mSensorsDataAPI.getFlushBulkSize()) {
                                this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
                            }
                        }
                        this.mWorker.runMessage(obtain);
                    }
                }
                this.mWorker.runMessage(obtain);
            }
        } catch (Exception e) {
            SALog.i(TAG, "enqueueEventMessage error:" + e);
        }
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mWorker.runMessage(obtain);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void flushScheduled() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.mWorker.runMessageOnce(obtain, (long) this.mSensorsDataAPI.getFlushInterval());
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteAll() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 4;
            this.mWorker.runMessage(obtain);
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x02f4 A[Catch:{ Exception -> 0x0303 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendData() {
        /*
            r12 = this;
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = r12.mSensorsDataAPI     // Catch:{ Exception -> 0x033c }
            boolean r0 = r0.isNetworkRequestEnable()     // Catch:{ Exception -> 0x033c }
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "SA.AnalyticsMessages"
            java.lang.String r1 = "NetworkRequest 已关闭，不发送数据！"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x033c }
            return
        L_0x0010:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r0 = r12.mSensorsDataAPI     // Catch:{ Exception -> 0x033c }
            java.lang.String r0 = r0.getServerUrl()     // Catch:{ Exception -> 0x033c }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x033c }
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = "SA.AnalyticsMessages"
            java.lang.String r1 = "Server url is null or empty."
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x033c }
            return
        L_0x0024:
            android.content.Context r0 = r12.mContext     // Catch:{ Exception -> 0x033c }
            boolean r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isNetworkAvailable((android.content.Context) r0)     // Catch:{ Exception -> 0x033c }
            if (r0 != 0) goto L_0x002d
            return
        L_0x002d:
            android.content.Context r0 = r12.mContext     // Catch:{ Exception -> 0x033c }
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(r0)     // Catch:{ Exception -> 0x033c }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = r12.mSensorsDataAPI     // Catch:{ Exception -> 0x033c }
            int r1 = r1.getFlushNetworkPolicy()     // Catch:{ Exception -> 0x033c }
            boolean r1 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.isShouldFlush(r0, r1)     // Catch:{ Exception -> 0x033c }
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = "SA.AnalyticsMessages"
            java.lang.String r4 = "您当前网络为 %s，无法发送数据，请确认您的网络发送策略！"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x033c }
            r2[r3] = r0     // Catch:{ Exception -> 0x033c }
            java.lang.String r0 = java.lang.String.format(r4, r2)     // Catch:{ Exception -> 0x033c }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ Exception -> 0x033c }
            return
        L_0x0051:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ Exception -> 0x033c }
            boolean r0 = r0.isMultiProcessFlush()     // Catch:{ Exception -> 0x033c }
            if (r0 == 0) goto L_0x006e
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x033c }
            boolean r0 = r0.isSubProcessFlushing()     // Catch:{ Exception -> 0x033c }
            if (r0 == 0) goto L_0x0066
            return
        L_0x0066:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()     // Catch:{ Exception -> 0x033c }
            r0.commitSubProcessFlushState(r2)     // Catch:{ Exception -> 0x033c }
            goto L_0x0073
        L_0x006e:
            boolean r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.mIsMainProcess     // Catch:{ Exception -> 0x033c }
            if (r0 != 0) goto L_0x0073
            return
        L_0x0073:
            r0 = 100
            r1 = 0
            r4 = r1
        L_0x0077:
            if (r0 <= 0) goto L_0x032a
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = r12.mDbAdapter
            monitor-enter(r0)
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r5 = r12.mSensorsDataAPI     // Catch:{ all -> 0x0327 }
            boolean r5 = r5.isDebugMode()     // Catch:{ all -> 0x0327 }
            if (r5 == 0) goto L_0x008d
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter     // Catch:{ all -> 0x0327 }
            java.lang.String r6 = "events"
            java.lang.String[] r5 = r5.generateDataString(r6, r2)     // Catch:{ all -> 0x0327 }
            goto L_0x0097
        L_0x008d:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter     // Catch:{ all -> 0x0327 }
            java.lang.String r6 = "events"
            r7 = 50
            java.lang.String[] r5 = r5.generateDataString(r6, r7)     // Catch:{ all -> 0x0327 }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x0327 }
            if (r5 != 0) goto L_0x00a2
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()
            r0.commitSubProcessFlushState(r3)
            return
        L_0x00a2:
            r0 = r5[r3]
            r10 = r5[r2]
            r6 = 2
            r9 = r5[r6]
            r5 = 25
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r9)     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
            if (r6 == 0) goto L_0x00b9
            java.lang.String r6 = r12.encodeData(r10)     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
            r8 = r6
            goto L_0x00ba
        L_0x00b9:
            r8 = r10
        L_0x00ba:
            boolean r6 = android.text.TextUtils.isEmpty(r8)     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
            if (r6 != 0) goto L_0x00cb
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = r12.mSensorsDataAPI     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
            java.lang.String r7 = r6.getServerUrl()     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
            r11 = 0
            r6 = r12
            r6.sendHttpRequest(r7, r8, r9, r10, r11)     // Catch:{ ConnectErrorException -> 0x0267, InvalidDataException -> 0x0201, ResponseErrorException -> 0x018c, Exception -> 0x0122 }
        L_0x00cb:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r6 = r12.mSensorsDataAPI
            boolean r6 = r6.isDebugMode()
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            if (r7 != 0) goto L_0x0101
            if (r6 != 0) goto L_0x00df
            boolean r7 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r7 == 0) goto L_0x0101
        L_0x00df:
            java.lang.String r7 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r7, (java.lang.String) r1)
            if (r6 == 0) goto L_0x0101
            boolean r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r6 == 0) goto L_0x0101
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00fd }
            if (r6 == r5) goto L_0x0101
            if (r4 == 0) goto L_0x00f3
            r4.cancel()     // Catch:{ Exception -> 0x00fd }
        L_0x00f3:
            android.content.Context r5 = r12.mContext     // Catch:{ Exception -> 0x00fd }
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r1, r3)     // Catch:{ Exception -> 0x00fd }
            r4.show()     // Catch:{ Exception -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x0101:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter
            int r0 = r5.cleanupEvents(r0)
            java.lang.String r5 = "SA.AnalyticsMessages"
            java.util.Locale r6 = java.util.Locale.CHINA
            java.lang.String r7 = "Events flushed. [left = %d]"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r8[r3] = r9
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)
        L_0x0119:
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r6)
            goto L_0x0077
        L_0x011e:
            r6 = move-exception
            r7 = r2
            goto L_0x02d1
        L_0x0122:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02cf }
            r7.<init>()     // Catch:{ all -> 0x02cf }
            java.lang.String r8 = "Exception: "
            r7.append(r8)     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x02cf }
            r7.append(r6)     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x02cf }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = r12.mSensorsDataAPI
            boolean r7 = r7.isDebugMode()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x016e
            if (r7 != 0) goto L_0x014c
            boolean r8 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r8 == 0) goto L_0x016e
        L_0x014c:
            java.lang.String r8 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r6)
            if (r7 == 0) goto L_0x016e
            boolean r8 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r8 == 0) goto L_0x016e
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x016a }
            if (r8 == r5) goto L_0x016e
            if (r4 == 0) goto L_0x0160
            r4.cancel()     // Catch:{ Exception -> 0x016a }
        L_0x0160:
            android.content.Context r5 = r12.mContext     // Catch:{ Exception -> 0x016a }
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r6, r3)     // Catch:{ Exception -> 0x016a }
            r4.show()     // Catch:{ Exception -> 0x016a }
            goto L_0x016e
        L_0x016a:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x016e:
            if (r7 == 0) goto L_0x0189
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter
            int r0 = r5.cleanupEvents(r0)
            java.lang.String r5 = "SA.AnalyticsMessages"
            java.util.Locale r6 = java.util.Locale.CHINA
            java.lang.String r7 = "Events flushed. [left = %d]"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r8[r3] = r9
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)
            goto L_0x0119
        L_0x0189:
            r0 = r3
            goto L_0x0077
        L_0x018c:
            r6 = move-exception
            int r7 = r6.getHttpCode()     // Catch:{ all -> 0x011e }
            boolean r7 = r12.isDeleteEventsByCode(r7)     // Catch:{ all -> 0x011e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fe }
            r8.<init>()     // Catch:{ all -> 0x01fe }
            java.lang.String r9 = "ResponseErrorException: "
            r8.append(r9)     // Catch:{ all -> 0x01fe }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x01fe }
            r8.append(r6)     // Catch:{ all -> 0x01fe }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x01fe }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r8 = r12.mSensorsDataAPI
            boolean r8 = r8.isDebugMode()
            boolean r9 = android.text.TextUtils.isEmpty(r6)
            if (r9 != 0) goto L_0x01e0
            if (r8 != 0) goto L_0x01be
            boolean r9 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r9 == 0) goto L_0x01e0
        L_0x01be:
            java.lang.String r9 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r6)
            if (r8 == 0) goto L_0x01e0
            boolean r9 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r9 == 0) goto L_0x01e0
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x01dc }
            if (r9 == r5) goto L_0x01e0
            if (r4 == 0) goto L_0x01d2
            r4.cancel()     // Catch:{ Exception -> 0x01dc }
        L_0x01d2:
            android.content.Context r5 = r12.mContext     // Catch:{ Exception -> 0x01dc }
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r6, r3)     // Catch:{ Exception -> 0x01dc }
            r4.show()     // Catch:{ Exception -> 0x01dc }
            goto L_0x01e0
        L_0x01dc:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x01e0:
            if (r7 != 0) goto L_0x01e4
            if (r8 == 0) goto L_0x0189
        L_0x01e4:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter
            int r0 = r5.cleanupEvents(r0)
            java.lang.String r5 = "SA.AnalyticsMessages"
            java.util.Locale r6 = java.util.Locale.CHINA
            java.lang.String r7 = "Events flushed. [left = %d]"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r8[r3] = r9
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)
            goto L_0x0119
        L_0x01fe:
            r6 = move-exception
            goto L_0x02d1
        L_0x0201:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x011e }
            r7.<init>()     // Catch:{ all -> 0x011e }
            java.lang.String r8 = "Invalid data: "
            r7.append(r8)     // Catch:{ all -> 0x011e }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x011e }
            r7.append(r6)     // Catch:{ all -> 0x011e }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x011e }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = r12.mSensorsDataAPI
            boolean r7 = r7.isDebugMode()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x024d
            if (r7 != 0) goto L_0x022b
            boolean r8 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r8 == 0) goto L_0x024d
        L_0x022b:
            java.lang.String r8 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r6)
            if (r7 == 0) goto L_0x024d
            boolean r7 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r7 == 0) goto L_0x024d
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0249 }
            if (r7 == r5) goto L_0x024d
            if (r4 == 0) goto L_0x023f
            r4.cancel()     // Catch:{ Exception -> 0x0249 }
        L_0x023f:
            android.content.Context r5 = r12.mContext     // Catch:{ Exception -> 0x0249 }
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r6, r3)     // Catch:{ Exception -> 0x0249 }
            r4.show()     // Catch:{ Exception -> 0x0249 }
            goto L_0x024d
        L_0x0249:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x024d:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter
            int r0 = r5.cleanupEvents(r0)
            java.lang.String r5 = "SA.AnalyticsMessages"
            java.util.Locale r6 = java.util.Locale.CHINA
            java.lang.String r7 = "Events flushed. [left = %d]"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r8[r3] = r9
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)
            goto L_0x0119
        L_0x0267:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02cf }
            r7.<init>()     // Catch:{ all -> 0x02cf }
            java.lang.String r8 = "Connection error: "
            r7.append(r8)     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x02cf }
            r7.append(r6)     // Catch:{ all -> 0x02cf }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x02cf }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r7 = r12.mSensorsDataAPI
            boolean r7 = r7.isDebugMode()
            boolean r8 = android.text.TextUtils.isEmpty(r6)
            if (r8 != 0) goto L_0x02b3
            if (r7 != 0) goto L_0x0291
            boolean r8 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r8 == 0) goto L_0x02b3
        L_0x0291:
            java.lang.String r8 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r8, (java.lang.String) r6)
            if (r7 == 0) goto L_0x02b3
            boolean r8 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r8 == 0) goto L_0x02b3
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x02af }
            if (r8 == r5) goto L_0x02b3
            if (r4 == 0) goto L_0x02a5
            r4.cancel()     // Catch:{ Exception -> 0x02af }
        L_0x02a5:
            android.content.Context r5 = r12.mContext     // Catch:{ Exception -> 0x02af }
            android.widget.Toast r4 = android.widget.Toast.makeText(r5, r6, r3)     // Catch:{ Exception -> 0x02af }
            r4.show()     // Catch:{ Exception -> 0x02af }
            goto L_0x02b3
        L_0x02af:
            r5 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r5)
        L_0x02b3:
            if (r7 == 0) goto L_0x0189
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r5 = r12.mDbAdapter
            int r0 = r5.cleanupEvents(r0)
            java.lang.String r5 = "SA.AnalyticsMessages"
            java.util.Locale r6 = java.util.Locale.CHINA
            java.lang.String r7 = "Events flushed. [left = %d]"
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r8[r3] = r9
            java.lang.String r6 = java.lang.String.format(r6, r7, r8)
            goto L_0x0119
        L_0x02cf:
            r6 = move-exception
            r7 = r3
        L_0x02d1:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r8 = r12.mSensorsDataAPI
            boolean r8 = r8.isDebugMode()
            boolean r9 = android.text.TextUtils.isEmpty(r1)
            if (r9 != 0) goto L_0x0307
            if (r8 != 0) goto L_0x02e5
            boolean r9 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()
            if (r9 == 0) goto L_0x0307
        L_0x02e5:
            java.lang.String r9 = "SA.AnalyticsMessages"
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r9, (java.lang.String) r1)
            if (r8 == 0) goto L_0x0307
            boolean r9 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.SHOW_DEBUG_INFO_VIEW
            if (r9 == 0) goto L_0x0307
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0303 }
            if (r9 == r5) goto L_0x0307
            if (r4 == 0) goto L_0x02f9
            r4.cancel()     // Catch:{ Exception -> 0x0303 }
        L_0x02f9:
            android.content.Context r4 = r12.mContext     // Catch:{ Exception -> 0x0303 }
            android.widget.Toast r1 = android.widget.Toast.makeText(r4, r1, r3)     // Catch:{ Exception -> 0x0303 }
            r1.show()     // Catch:{ Exception -> 0x0303 }
            goto L_0x0307
        L_0x0303:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x0307:
            if (r7 != 0) goto L_0x030b
            if (r8 == 0) goto L_0x0326
        L_0x030b:
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r1 = r12.mDbAdapter
            int r0 = r1.cleanupEvents(r0)
            java.lang.String r1 = "SA.AnalyticsMessages"
            java.util.Locale r4 = java.util.Locale.CHINA
            java.lang.String r5 = "Events flushed. [left = %d]"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r3] = r0
            java.lang.String r0 = java.lang.String.format(r4, r5, r2)
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r0)
        L_0x0326:
            throw r6
        L_0x0327:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0327 }
            throw r1
        L_0x032a:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r0 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()
            boolean r0 = r0.isMultiProcessFlush()
            if (r0 == 0) goto L_0x033b
            com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter r0 = com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter.getInstance()
            r0.commitSubProcessFlushState(r3)
        L_0x033b:
            return
        L_0x033c:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.sendData():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:48|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0 = r9.getErrorStream();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x0110 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendHttpRequest(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21) throws com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException, com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = "UTF-8"
            r8 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x01bd, all -> 0x01b8 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01bd, all -> 0x01b8 }
            java.net.URLConnection r3 = r2.openConnection()     // Catch:{ IOException -> 0x01bd, all -> 0x01b8 }
            r9 = r3
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ IOException -> 0x01bd, all -> 0x01b8 }
            r3 = 1
            r4 = 0
            java.lang.String r5 = "SA.AnalyticsMessages"
            if (r9 != 0) goto L_0x002e
            java.lang.String r0 = "can not connect %s, it shouldn't happen"
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r1[r4] = r2     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            com.sensorsdata.analytics.android.sdk.SALog.i(r5, r0, r8)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r7.closeStream(r8, r8, r8, r9)
            return
        L_0x002e:
            com.sensorsdata.analytics.android.sdk.SAConfigOptions r2 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.getConfigOptions()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r2 == 0) goto L_0x0044
            javax.net.ssl.SSLSocketFactory r6 = r2.mSSLSocketFactory     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r6 == 0) goto L_0x0044
            boolean r6 = r9 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r6 == 0) goto L_0x0044
            r6 = r9
            javax.net.ssl.HttpsURLConnection r6 = (javax.net.ssl.HttpsURLConnection) r6     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            javax.net.ssl.SSLSocketFactory r2 = r2.mSSLSocketFactory     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r6.setSSLSocketFactory(r2)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
        L_0x0044:
            r9.setInstanceFollowRedirects(r4)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r7.mSensorsDataAPI     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r2 = r2.getDebugMode()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI$DebugMode r6 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode.DEBUG_ONLY     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r2 != r6) goto L_0x0058
            java.lang.String r2 = "Dry-Run"
            java.lang.String r6 = "true"
            r9.addRequestProperty(r2, r6)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
        L_0x0058:
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r2 = r7.mSensorsDataAPI     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r2 = r2.getCookie(r4)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r6 != 0) goto L_0x0069
            java.lang.String r6 = "Cookie"
            r9.setRequestProperty(r6, r2)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
        L_0x0069:
            android.net.Uri$Builder r2 = new android.net.Uri$Builder     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r2.<init>()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            boolean r6 = android.text.TextUtils.isEmpty(r18)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r6 != 0) goto L_0x0081
            java.lang.String r6 = "crc"
            int r10 = r18.hashCode()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r2.appendQueryParameter(r6, r10)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
        L_0x0081:
            java.lang.String r6 = "gzip"
            r10 = r19
            r2.appendQueryParameter(r6, r10)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r6 = "data_list"
            r11 = r18
            r2.appendQueryParameter(r6, r11)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            android.net.Uri r2 = r2.build()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r2 = r2.getEncodedQuery()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            if (r6 == 0) goto L_0x00a1
            r7.closeStream(r8, r8, r8, r9)
            return
        L_0x00a1:
            byte[] r6 = r2.getBytes(r1)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            int r6 = r6.length     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r9.setFixedLengthStreamingMode(r6)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r9.setDoOutput(r3)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.lang.String r6 = "POST"
            r9.setRequestMethod(r6)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r6 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r6)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            r9.setReadTimeout(r6)     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.io.OutputStream r12 = r9.getOutputStream()     // Catch:{ IOException -> 0x01b2, all -> 0x01ae }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x01aa, all -> 0x01a7 }
            r13.<init>(r12)     // Catch:{ IOException -> 0x01aa, all -> 0x01a7 }
            byte[] r2 = r2.getBytes(r1)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r13.write(r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r13.flush()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            int r2 = r9.getResponseCode()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r6.<init>()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r14 = "responseCode: "
            r6.append(r14)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r6.append(r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            if (r21 != 0) goto L_0x010a
            boolean r6 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.needRedirects(r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            if (r6 == 0) goto L_0x010a
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.NetworkUtils.getLocation(r9, r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            if (r6 != 0) goto L_0x010a
            r7.closeStream(r13, r12, r8, r9)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r6 = 1
            r1 = r16
            r2 = r0
            r3 = r18
            r4 = r19
            r5 = r20
            r1.sendHttpRequest(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r7.closeStream(r13, r12, r8, r9)
            return
        L_0x010a:
            java.io.InputStream r0 = r9.getInputStream()     // Catch:{ FileNotFoundException -> 0x0110 }
        L_0x010e:
            r6 = r0
            goto L_0x0115
        L_0x0110:
            java.io.InputStream r0 = r9.getErrorStream()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            goto L_0x010e
        L_0x0115:
            byte[] r0 = slurp(r6)     // Catch:{ IOException -> 0x019f, all -> 0x019d }
            r6.close()     // Catch:{ IOException -> 0x019f, all -> 0x019d }
            java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r6.<init>(r0, r1)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            boolean r0 = com.sensorsdata.analytics.android.sdk.SALog.isLogEnabled()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r1 = 300(0x12c, float:4.2E-43)
            r10 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x017e
            java.lang.String r0 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.formatJson(r20)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            if (r2 < r10) goto L_0x0148
            if (r2 >= r1) goto L_0x0148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r11.<init>()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r14 = "valid message: \n"
            r11.append(r14)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r11.append(r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            goto L_0x017e
        L_0x0148:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r11.<init>()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r14 = "invalid message: \n"
            r11.append(r14)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r11.append(r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r0 = r11.toString()     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.util.Locale r0 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r11 = "ret_code: %d"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r14[r4] = r15     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r0 = java.lang.String.format(r0, r11, r14)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.util.Locale r0 = java.util.Locale.CHINA     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r11 = "ret_content: %s"
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r14[r4] = r6     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r0 = java.lang.String.format(r0, r11, r14)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
        L_0x017e:
            if (r2 < r10) goto L_0x0186
            if (r2 >= r1) goto L_0x0186
            r7.closeStream(r13, r12, r8, r9)
            return
        L_0x0186:
            com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.ResponseErrorException     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r1 = "flush failure with response '%s', the response code is '%d'"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r5[r4] = r6     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r5[r3] = r4     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            java.lang.String r1 = java.lang.String.format(r1, r5)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            r0.<init>((java.lang.String) r1, (int) r2)     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
            throw r0     // Catch:{ IOException -> 0x01a4, all -> 0x01a1 }
        L_0x019d:
            r0 = move-exception
            goto L_0x01c9
        L_0x019f:
            r0 = move-exception
            goto L_0x01b6
        L_0x01a1:
            r0 = move-exception
            r6 = r8
            goto L_0x01c9
        L_0x01a4:
            r0 = move-exception
            r6 = r8
            goto L_0x01b6
        L_0x01a7:
            r0 = move-exception
            r6 = r8
            goto L_0x01ca
        L_0x01aa:
            r0 = move-exception
            r6 = r8
            r13 = r6
            goto L_0x01b6
        L_0x01ae:
            r0 = move-exception
            r6 = r8
            r12 = r6
            goto L_0x01ca
        L_0x01b2:
            r0 = move-exception
            r6 = r8
            r12 = r6
            r13 = r12
        L_0x01b6:
            r8 = r9
            goto L_0x01c1
        L_0x01b8:
            r0 = move-exception
            r6 = r8
            r9 = r6
            r12 = r9
            goto L_0x01ca
        L_0x01bd:
            r0 = move-exception
            r6 = r8
            r12 = r6
            r13 = r12
        L_0x01c1:
            com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException r1 = new com.sensorsdata.analytics.android.sdk.exceptions.ConnectErrorException     // Catch:{ all -> 0x01c7 }
            r1.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x01c7 }
            throw r1     // Catch:{ all -> 0x01c7 }
        L_0x01c7:
            r0 = move-exception
            r9 = r8
        L_0x01c9:
            r8 = r13
        L_0x01ca:
            r7.closeStream(r8, r12, r6, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.sendHttpRequest(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void");
    }

    private void closeStream(BufferedOutputStream bufferedOutputStream, OutputStream outputStream, InputStream inputStream, HttpURLConnection httpURLConnection) {
        if (bufferedOutputStream != null) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e) {
                SALog.i(TAG, e.getMessage());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e2) {
                SALog.i(TAG, e2.getMessage());
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e3) {
                SALog.i(TAG, e3.getMessage());
            }
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e4) {
                SALog.i(TAG, e4.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String encodeData(java.lang.String r5) throws com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException {
        /*
            r4 = this;
            java.lang.String r0 = "UTF-8"
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0038 }
            byte[] r3 = r5.getBytes(r0)     // Catch:{ IOException -> 0x0038 }
            int r3 = r3.length     // Catch:{ IOException -> 0x0038 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0038 }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0038 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0038 }
            byte[] r5 = r5.getBytes(r0)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.write(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.close()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r2.close()     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            char[] r5 = com.sensorsdata.analytics.android.sdk.util.Base64Coder.encode(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x0033, all -> 0x0030 }
            r3.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        L_0x0030:
            r5 = move-exception
            r1 = r3
            goto L_0x003f
        L_0x0033:
            r5 = move-exception
            r1 = r3
            goto L_0x0039
        L_0x0036:
            r5 = move-exception
            goto L_0x003f
        L_0x0038:
            r5 = move-exception
        L_0x0039:
            com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException r0 = new com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException     // Catch:{ all -> 0x0036 }
            r0.<init>((java.lang.Throwable) r5)     // Catch:{ all -> 0x0036 }
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x003f:
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ IOException -> 0x0044 }
        L_0x0044:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.AnalyticsMessages.encodeData(java.lang.String):java.lang.String");
    }

    private class Worker {
        private Handler mHandler;
        private final Object mHandlerLock = new Object();

        Worker() {
            HandlerThread handlerThread = new HandlerThread("com.sensorsdata.analytics.android.sdk.AnalyticsMessages.Worker", 1);
            handlerThread.start();
            this.mHandler = new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        /* access modifiers changed from: package-private */
        public void runMessage(Message message) {
            synchronized (this.mHandlerLock) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void runMessageOnce(Message message, long j) {
            synchronized (this.mHandlerLock) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    SALog.i(AnalyticsMessages.TAG, "Dead worker dropping a message: " + message.what);
                } else if (!handler.hasMessages(message.what)) {
                    this.mHandler.sendMessageDelayed(message, j);
                }
            }
        }

        private class AnalyticsMessageHandler extends Handler {
            AnalyticsMessageHandler(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                try {
                    if (message.what == 3) {
                        AnalyticsMessages.this.sendData();
                    } else if (message.what == 4) {
                        try {
                            AnalyticsMessages.this.mDbAdapter.deleteAllEvents();
                        } catch (Exception e) {
                            SALog.printStackTrace(e);
                        }
                    } else if (message.what == 5) {
                        AnalyticsMessages.this.flushScheduled();
                        AnalyticsMessages.this.sendData();
                    } else {
                        SALog.i(AnalyticsMessages.TAG, "Unexpected message received by SensorsData worker: " + message);
                    }
                } catch (RuntimeException e2) {
                    SALog.i(AnalyticsMessages.TAG, "Worker threw an unhandled exception", e2);
                }
            }
        }
    }
}
