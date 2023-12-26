package com.tal.app.thinkacademy.common.oss;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.common.aws.UploadFileTrackUtil;
import com.tal.app.thinkacademy.common.aws.UploadFileType;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ArrayUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OSSService {
    /* access modifiers changed from: private */
    public static String BUCKET = "hwliveapp-xesapi";
    /* access modifiers changed from: private */
    public static String CDN_URL = "";
    private static String END_POINT = "https://s3-accelerate.amazonaws.com";
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static OSSAsyncTask task;

    public static void runOnUiThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Handler handler = mHandler;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }

    /* access modifiers changed from: private */
    public static OSS getOSS(final OSSFederationToken oSSFederationToken) {
        AnonymousClass1 r0 = new OSSFederationCredentialProvider() {
            public OSSFederationToken getFederationToken() {
                try {
                    return new OSSFederationToken(oSSFederationToken.getTempAK(), oSSFederationToken.getTempSK(), oSSFederationToken.getSecurityToken(), oSSFederationToken.getExpiration());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setConnectionTimeout(30000);
        clientConfiguration.setSocketTimeout(30000);
        clientConfiguration.setMaxConcurrentRequest(3);
        clientConfiguration.setMaxErrorRetry(2);
        return new OSSClient(AppUtil.getApplication(), END_POINT, r0, clientConfiguration);
    }

    public static void uploadFile(File file, STSToken sTSToken, int i, AwsS3Util.SingleTransferListener singleTransferListener, String str) {
        if (file != null) {
            OSSFederationToken oSSFederationToken = new OSSFederationToken(sTSToken.getAccessKey(), sTSToken.getAccessSecret(), sTSToken.getSessionToken(), (long) sTSToken.getExpireSecond().intValue());
            END_POINT = sTSToken.getEndPoint();
            BUCKET = sTSToken.getBucketName();
            CDN_URL = sTSToken.getAppUrl();
            realUploafFile(file, singleTransferListener, sTSToken.getFilePaths()[i], oSSFederationToken, str);
        }
    }

    public static void uploadFiles(List<File> list, STSToken sTSToken, int i, AwsS3Util.MultiTransferListener multiTransferListener, String str) {
        if (!list.isEmpty()) {
            OSSFederationToken oSSFederationToken = new OSSFederationToken(sTSToken.getAccessKey(), sTSToken.getAccessSecret(), sTSToken.getSessionToken(), (long) sTSToken.getExpireSecond().intValue());
            END_POINT = sTSToken.getEndPoint();
            BUCKET = sTSToken.getBucketName();
            CDN_URL = sTSToken.getAppUrl();
            final List<File> list2 = list;
            final AwsS3Util.MultiTransferListener multiTransferListener2 = multiTransferListener;
            final STSToken sTSToken2 = sTSToken;
            final OSSFederationToken oSSFederationToken2 = oSSFederationToken;
            final String str2 = str;
            realUploafFile(list.get(i), new AwsS3Util.SingleTransferListener() {
                /* access modifiers changed from: private */
                public int index = 0;
                /* access modifiers changed from: private */
                public ArrayList<String> urls = new ArrayList<>();

                public void onStateChanged(int i, TransferState transferState) {
                }

                public void onUploadSuccess(String str, String str2) {
                    this.index++;
                    this.urls.add(str2);
                    if (this.index == list2.size()) {
                        OSSService.runOnUiThread(new Runnable() {
                            public void run() {
                                if (multiTransferListener2 != null) {
                                    multiTransferListener2.onUploadSuccess(ArrayUtils.asArrayList(sTSToken2.getFilePaths()), AnonymousClass2.this.urls);
                                }
                            }
                        });
                    } else {
                        OSSService.realUploafFile((File) list2.get(this.index), this, sTSToken2.getFilePaths()[this.index], oSSFederationToken2, str2);
                    }
                }

                public void onProgressChanged(int i, long j, long j2) {
                    final int i2 = i;
                    final long j3 = j;
                    final long j4 = j2;
                    OSSService.runOnUiThread(new Runnable() {
                        public void run() {
                            if (multiTransferListener2 != null) {
                                multiTransferListener2.onProgressChanged(AnonymousClass2.this.index, i2, j3, j4);
                            }
                        }
                    });
                }

                public void onError(final int i, final Exception exc) {
                    OSSService.runOnUiThread(new Runnable() {
                        public void run() {
                            if (multiTransferListener2 != null) {
                                multiTransferListener2.onError(AnonymousClass2.this.index, i, exc);
                            }
                        }
                    });
                }
            }, sTSToken.getFilePaths()[i], oSSFederationToken, str);
        }
    }

    /* access modifiers changed from: private */
    public static void realUploafFile(File file, AwsS3Util.SingleTransferListener singleTransferListener, String str, OSSFederationToken oSSFederationToken, String str2) {
        final String str3 = str;
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET, str, file.getAbsolutePath());
        AwsS3Util.SingleTransferListener singleTransferListener2 = singleTransferListener;
        putObjectRequest.setProgressCallback(new OSSService$$ExternalSyntheticLambda0(singleTransferListener));
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final OSSFederationToken oSSFederationToken2 = oSSFederationToken;
        final String str4 = str;
        final File file2 = file;
        final String str5 = str2;
        final AwsS3Util.SingleTransferListener singleTransferListener3 = singleTransferListener;
        task = getOSS(oSSFederationToken).asyncPutObject(putObjectRequest, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
                final String str;
                if (TextUtils.isEmpty(OSSService.CDN_URL)) {
                    str = OSSService.getOSS(oSSFederationToken2).presignPublicObjectURL(OSSService.BUCKET, str4);
                } else {
                    str = OSSService.CDN_URL + "/" + str4;
                }
                OSSAsyncTask unused = OSSService.task = null;
                Tag tag = Tag.AwsS3;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("文件上传成功>>>上传方式=oss，文件大小=");
                File file = file2;
                long j = -1;
                sb.append(file != null ? file.length() : -1);
                sb.append("，文件名称=");
                File file2 = file2;
                sb.append(file2 != null ? file2.getName() : "");
                sb.append("，耗时=");
                sb.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                sb.append("毫秒，文件地址=");
                sb.append(str);
                objArr[0] = sb.toString();
                XesLog.i(tag, objArr);
                UploadFileTrackUtil uploadFileTrackUtil = UploadFileTrackUtil.INSTANCE;
                String str2 = str5;
                UploadFileType uploadFileType = UploadFileType.OSS;
                File file3 = file2;
                if (file3 != null) {
                    j = file3.length();
                }
                uploadFileTrackUtil.trackSuccessEvent(str2, uploadFileType, Long.valueOf(j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), str);
                OSSService.runOnUiThread(new Runnable() {
                    public void run() {
                        if (singleTransferListener3 != null) {
                            singleTransferListener3.onUploadSuccess(str3, str);
                        }
                    }
                });
            }

            public void onFailure(PutObjectRequest putObjectRequest, final ClientException clientException, final ServiceException serviceException) {
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    serviceException.printStackTrace();
                    XesLog.dt("OSS_ErrorCode", serviceException.getErrorCode());
                    XesLog.dt("OSS_RequestId", serviceException.getRequestId());
                    XesLog.dt("OSS_HostId", serviceException.getHostId());
                    XesLog.dt("OSS_RawMessage", serviceException.getRawMessage());
                }
                OSSAsyncTask unused = OSSService.task = null;
                Tag tag = Tag.AwsS3;
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("文件上传失败>>>上传方式=oss，文件大小=");
                File file = file2;
                long j = -1;
                sb.append(file != null ? file.length() : -1);
                sb.append("，文件名称=");
                File file2 = file2;
                String str = "";
                sb.append(file2 != null ? file2.getName() : str);
                sb.append("，错误信息=【clientException=");
                sb.append(clientException != null ? clientException.getMessage() : str);
                sb.append("，serviceException=");
                sb.append(GsonUtil.getInstance().objToJson(serviceException));
                sb.append("】");
                objArr[0] = sb.toString();
                XesLog.i(tag, objArr);
                UploadFileTrackUtil uploadFileTrackUtil = UploadFileTrackUtil.INSTANCE;
                String str2 = str5;
                UploadFileType uploadFileType = UploadFileType.OSS;
                File file3 = file2;
                if (file3 != null) {
                    j = file3.length();
                }
                Long valueOf = Long.valueOf(j);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("clientException=");
                if (clientException != null) {
                    str = clientException.getMessage();
                }
                sb2.append(str);
                sb2.append("，serviceException=");
                sb2.append(GsonUtil.getInstance().objToJson(serviceException));
                uploadFileTrackUtil.trackFailEvent(str2, uploadFileType, valueOf, sb2.toString());
                OSSService.runOnUiThread(new Runnable() {
                    public void run() {
                        if (singleTransferListener3 == null) {
                            return;
                        }
                        if (serviceException == null) {
                            singleTransferListener3.onError(-999, clientException);
                        } else {
                            singleTransferListener3.onError(serviceException.getStatusCode(), clientException);
                        }
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$realUploafFile$0(AwsS3Util.SingleTransferListener singleTransferListener, PutObjectRequest putObjectRequest, long j, long j2) {
        XesLog.dt("PutObject", "currentSize: " + j + " totalSize: " + j2);
        singleTransferListener.onProgressChanged(0, j, j2);
    }

    public static void cancelTask() {
        OSSAsyncTask oSSAsyncTask = task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.cancel();
        }
    }

    public static void waitUntilFinished() {
        OSSAsyncTask oSSAsyncTask = task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.waitUntilFinished();
        }
    }

    public static void isCompleted() {
        OSSAsyncTask oSSAsyncTask = task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.isCompleted();
        }
    }

    public static void isCanceled() {
        OSSAsyncTask oSSAsyncTask = task;
        if (oSSAsyncTask != null) {
            oSSAsyncTask.isCanceled();
        }
    }
}
