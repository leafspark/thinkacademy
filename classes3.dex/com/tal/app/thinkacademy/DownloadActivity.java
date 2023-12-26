package com.tal.app.thinkacademy;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bonree.sdk.agent.engine.external.ActivityInfo;
import com.google.gson.reflect.TypeToken;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.model.OnlineResFile;
import com.tal.app.thinkacademy.lib.download.operation.DownloadEngine;
import com.tal.app.thinkacademy.lib.download.util.ZipUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.model.ResData;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DownloadActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public double avgSpeed = 0.0d;
    private Button btn_download_start;
    /* access modifiers changed from: private */
    public OnlineResFile.ResourceData data;
    /* access modifiers changed from: private */
    public int i = 0;
    private boolean isCancel = false;
    /* access modifiers changed from: private */
    public boolean isFinish = false;
    private DownloadImpl mDownloadImpl;
    /* access modifiers changed from: private */
    public ProgressBar pb_download_progress;
    /* access modifiers changed from: private */
    public double preAvgSpeed = 0.0d;
    private String res1 = "https://xesapp-xesapi-test.oss-cn-beijing.aliyuncs.com/xes-mobile-package/android/package/7.17.0/1468/2020-07-22-23-31-14/xesappslim.apk";
    private String res2 = "https://kjdsfz-cdn.jiaoyanyun.com/webkjdsfiles/page/3dcafb0530644832af63d823a949f156.zip";
    private OnlineResFile resFile;
    private String res_data = "[\n  {\n    \"timestamp\": 1596010136476,\n    \"catalog\": \"common_web\",\n    \"deleted\": 0,\n    \"modifyTime\": 1595935141000,\n    \"createTime\": 1595935141000,\n    \"urlSpareList\": [\n      \"https://kjds-web-fz.oss-accelerate.aliyuncs.com/webkjdsfiles/9ad29e9cfc264b98b01b8901847594c1.zip\",\n      \"https://kjds-web-fz.oss-accelerate.aliyuncs.com/webkjdsfiles/9ad29e9cfc264b98b01b8901847594c1.zip\",\n      \"https://kjds-web-fz.oss-accelerate.aliyuncs.com/webkjdsfiles/9ad29e9cfc264b98b01b8901847594c1.zip\"\n    ],\n    \"id\": null,\n    \"type\": 2,\n    \"version\": \"14018\",\n    \"url\": \"https://kjdsfz-cdn.thethinkacademy.com/NRY/webkjdsfiles/9ad29e9cfc264b98b01b8901847594c1.zip \",\n    \"zipMd5\": \"c2367f9fb121c7f549df5819935de108\",\n    \"zipSize\": 1895947,\n    \"unzipSize\": 4269084\n  }\n]";
    /* access modifiers changed from: private */
    public double total = 0.0d;
    /* access modifiers changed from: private */
    public TextView tv_download_info;

    public void finish() {
        DownloadActivity.super.finish();
        ActivityInfo.finishActivity(getClass().getName());
    }

    public void onPause() {
        ActivityInfo.pauseActivity(getClass().getName());
        DownloadActivity.super.onPause();
        ActivityInfo.endPauseActivity(getClass().getName());
    }

    public void onRestart() {
        ActivityInfo.onReStartTrace(getClass().getName());
        DownloadActivity.super.onRestart();
        ActivityInfo.endReStartTrace(getClass().getName());
    }

    public void onResume() {
        ActivityInfo.resumeActivity(getClass().getName());
        DownloadActivity.super.onResume();
        ActivityInfo.endResumeTrace(getClass().getName());
    }

    public void onStart() {
        ActivityInfo.onStartTrace(getClass().getName());
        DownloadActivity.super.onStart();
        ActivityInfo.endStartTrace(getClass().getName());
    }

    public void onStop() {
        DownloadActivity.super.onStop();
        ActivityInfo.stopActivity();
    }

    static /* synthetic */ int access$004(DownloadActivity downloadActivity) {
        int i2 = downloadActivity.i + 1;
        downloadActivity.i = i2;
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ActivityInfo.startTraceActivity(getClass().getName());
        DownloadActivity.super.onCreate(bundle);
        setContentView(R.layout.activity_download);
        this.pb_download_progress = (ProgressBar) findViewById(R.id.pb_download_progress);
        this.btn_download_start = (Button) findViewById(R.id.btn_download_start);
        Button button = (Button) findViewById(R.id.btn_download_pause);
        this.tv_download_info = (TextView) findViewById(R.id.tv_download_info);
        String absolutePath = getApplication().getFilesDir().getAbsolutePath();
        List list = (List) GsonUtils.fromJson(this.res_data, new TypeToken<List<ResData>>() {
        }.getType());
        this.mDownloadImpl = new DownloadImpl();
        if (list == null || list.size() == 0) {
            ActivityInfo.endTraceActivity(getClass().getName());
            return;
        }
        this.resFile = new OnlineResFile();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.data = new OnlineResFile.ResourceData();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(((ResData) list.get(i2)).url);
            arrayList3.addAll(((ResData) list.get(i2)).urlSpareList);
            this.data.url = arrayList3;
            OnlineResFile.ResourceData resourceData = this.data;
            resourceData.filePath = absolutePath + "/course_zip/";
            OnlineResFile.ResourceData resourceData2 = this.data;
            resourceData2.unZipPath = absolutePath + "/course_unzip/";
            this.data.fileName = ((ResData) list.get(i2)).url.substring(((ResData) list.get(i2)).url.lastIndexOf("/") + 1);
            this.data.realFileName = ((ResData) list.get(i2)).url.substring(((ResData) list.get(i2)).url.lastIndexOf("/") + 1);
            this.data.md5 = ((ResData) list.get(i2)).zipMd5;
            this.data.isIgnoreSRAVerify = true;
            if (i2 > 0) {
                this.data.isHighPriorityRes = true;
                arrayList.add(this.data);
            } else {
                arrayList2.add(this.data);
            }
        }
        this.resFile.setHighPriorityRes(arrayList);
        this.resFile.setDefaultPriorityRes(arrayList2);
        this.btn_download_start.setOnClickListener(new DownloadActivity$$ExternalSyntheticLambda0(this));
        button.setOnClickListener(DownloadActivity$$ExternalSyntheticLambda1.INSTANCE);
        findViewById(R.id.btn_download_resume).setOnClickListener(DownloadActivity$$ExternalSyntheticLambda2.INSTANCE);
        unzip();
        ActivityInfo.endTraceActivity(getClass().getName());
    }

    public /* synthetic */ void lambda$onCreate$0$DownloadActivity(View view) {
        DownloadEngine.getInstance().addDownloadQueue(this.resFile, this.mDownloadImpl);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    static /* synthetic */ void lambda$onCreate$1(View view) {
        DownloadEngine.getInstance().pauseOnlineAll();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    static /* synthetic */ void lambda$onCreate$2(View view) {
        DownloadEngine.getInstance().resumeOnlineAll();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    class DownloadImpl extends SimpleDownloadListener {
        DownloadImpl() {
        }

        public void onStart(final FilePoint filePoint) {
            int unused = DownloadActivity.this.i = 0;
            double unused2 = DownloadActivity.this.total = 0.0d;
            DownloadActivity downloadActivity = DownloadActivity.this;
            double unused3 = downloadActivity.preAvgSpeed = downloadActivity.avgSpeed;
            double unused4 = DownloadActivity.this.avgSpeed = 0.0d;
            boolean unused5 = DownloadActivity.this.isFinish = false;
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onStart " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onFinished(final FilePoint filePoint) {
            boolean unused = DownloadActivity.this.isFinish = true;
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onFinished " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onProgress(long j, long j2, FilePoint filePoint) {
            DownloadActivity.this.pb_download_progress.setProgress((int) (((((float) j) * 1.0f) * 100.0f) / ((float) j2)));
            double unused = DownloadActivity.this.total = ((double) j) / 1024.0d;
        }

        public void onPause(final FilePoint filePoint) {
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onPause " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onCancel(final FilePoint filePoint) {
            DownloadEngine.getInstance().trySwitchRes(filePoint, false);
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onCancel " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
            final int i2 = i;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final FilePoint filePoint2 = filePoint;
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onFailed  code=" + i2 + " message=" + str4 + " progress=" + str5 + "errorInfo=" + str6 + "  " + filePoint2.toString() + "\n--------------------\n");
                }
            });
        }

        public void onBlockComplete(final FilePoint filePoint) {
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onBlockComplete  " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onVerifyResult(final FilePoint filePoint, final int i) {
            DownloadActivity.super.onVerifyResult(filePoint, i);
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onVerifyResult  state=" + i + "  " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onUnZipResult(final FilePoint filePoint, final int i) {
            DownloadActivity.super.onUnZipResult(filePoint, i);
            DownloadActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    TextView access$500 = DownloadActivity.this.tv_download_info;
                    access$500.append("onUnZipResult  state=" + i + "  " + filePoint.toString() + "\n--------------------\n");
                }
            });
        }

        public void onNetSpeed(String str, double d, long j) {
            DownloadActivity.access$004(DownloadActivity.this);
            if (!DownloadActivity.this.isFinish && DownloadActivity.this.i == 5) {
                XesLog.it("DownloadTask", new Object[]{"total值" + DownloadActivity.this.total});
                DownloadActivity downloadActivity = DownloadActivity.this;
                double unused = downloadActivity.avgSpeed = downloadActivity.total / 10.0d;
                DownloadActivity downloadActivity2 = DownloadActivity.this;
                if (downloadActivity2.compare(downloadActivity2.avgSpeed / 1024.0d, 1.0d) == -1) {
                    DownloadActivity downloadActivity3 = DownloadActivity.this;
                    if (downloadActivity3.compare(downloadActivity3.preAvgSpeed, 0.0d) == 1) {
                        DownloadActivity downloadActivity4 = DownloadActivity.this;
                        if (downloadActivity4.compare(downloadActivity4.preAvgSpeed - DownloadActivity.this.avgSpeed, 300.0d) == 1) {
                            XesLog.it("DownloadTask", new Object[]{"preAvgSpeed > 0preAvgSpeed" + DownloadActivity.this.preAvgSpeed + "avgSpeed" + DownloadActivity.this.avgSpeed});
                            double unused2 = DownloadActivity.this.preAvgSpeed = 0.0d;
                            DownloadEngine.getInstance().cancel(new String[]{DownloadActivity.this.data.realFileName});
                        }
                    }
                    DownloadActivity downloadActivity5 = DownloadActivity.this;
                    if (downloadActivity5.compare(downloadActivity5.preAvgSpeed, 0.0d) == 1) {
                        DownloadActivity downloadActivity6 = DownloadActivity.this;
                        if (downloadActivity6.compare(downloadActivity6.avgSpeed - DownloadActivity.this.preAvgSpeed, 300.0d) == 1) {
                            double unused3 = DownloadActivity.this.preAvgSpeed = 0.0d;
                        }
                    }
                    DownloadActivity downloadActivity7 = DownloadActivity.this;
                    if (downloadActivity7.compare(downloadActivity7.preAvgSpeed, 0.0d) == 0) {
                        XesLog.it("DownloadTask", new Object[]{"preAvgSpeed == 0preAvgSpeed" + DownloadActivity.this.preAvgSpeed + "avgSpeed" + DownloadActivity.this.avgSpeed});
                        DownloadEngine.getInstance().cancel(new String[]{DownloadActivity.this.data.realFileName});
                    }
                }
            }
            XesLog.it("DownloadTask", new Object[]{"当前下载速度" + str});
        }
    }

    private void unzip() {
        String path = Environment.getExternalStorageDirectory().getPath();
        try {
            ZipUtils.decompressFile(path + "/学而思/测试一下.zip", path + "/学而思/unzip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public int compare(double d, double d2) {
        return new BigDecimal(d).compareTo(new BigDecimal(d2));
    }
}
