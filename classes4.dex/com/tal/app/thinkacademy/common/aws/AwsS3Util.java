package com.tal.app.thinkacademy.common.aws;

import android.content.Context;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferType;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.entity.STSToken;
import com.tal.app.thinkacademy.common.oss.OSSService;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u00046789B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0006\u0010\u001b\u001a\u00020\u0017J\"\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0006\u0010'\u001a\u00020\u0017J.\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ4\u0010(\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010,J2\u0010(\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010,J$\u0010(\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002J>\u0010.\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n002\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f002\n\b\u0002\u0010 \u001a\u0004\u0018\u000102J8\u00103\u001a\b\u0012\u0004\u0012\u0002040)2\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n00J>\u00103\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010+\u001a\u00020\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n002\n\b\u0002\u0010 \u001a\u0004\u0018\u000102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util;", "", "()V", "mRepository", "Lcom/tal/app/thinkacademy/common/aws/AwsRepository;", "mS3Job", "Lkotlinx/coroutines/Job;", "mTransferUtility", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "scene_agoralog", "", "scene_avatar", "scene_class_feedback", "scene_feedback", "scene_homework", "scene_interaction", "scene_logan", "scene_material", "scene_picture_wall", "scene_video_work", "tag", "Lcom/tal/app/thinkacademy/common/Tag;", "cancel", "", "id", "", "cancelAll", "cancelAndReset", "downloadFile", "key", "file", "Ljava/io/File;", "listener", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "initAws", "context", "Landroid/content/Context;", "info", "Lcom/tal/app/thinkacademy/common/entity/STSToken;", "reset", "uploadFile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "scene", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$SingleTransferListener;", "path", "uploadFiles", "keys", "", "files", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiTransferListener;", "uploadFilesWithPaths", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "paths", "Event", "MultiEvent", "MultiTransferListener", "SingleTransferListener", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AwsS3Util.kt */
public final class AwsS3Util {
    public static final AwsS3Util INSTANCE = new AwsS3Util();
    /* access modifiers changed from: private */
    public static final AwsRepository mRepository = new AwsRepository();
    private static Job mS3Job = null;
    private static TransferUtility mTransferUtility = null;
    public static final String scene_agoralog = "agoralog/*";
    public static final String scene_avatar = "avatar";
    public static final String scene_class_feedback = "classFeedback";
    public static final String scene_feedback = "feedback";
    public static final String scene_homework = "homework";
    public static final String scene_interaction = "interaction/*";
    public static final String scene_logan = "logan/*";
    public static final String scene_material = "material";
    public static final String scene_picture_wall = "pictureWall";
    public static final String scene_video_work = "videoWork";
    /* access modifiers changed from: private */
    public static final Tag tag = Tag.AwsS3;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tH&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J$\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H&¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiTransferListener;", "", "onError", "", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "names", "", "", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AwsS3Util.kt */
    public interface MultiTransferListener {
        void onError(int i, int i2, Exception exc);

        void onProgressChanged(int i, int i2, long j, long j2);

        void onStateChanged(int i, int i2, TransferState transferState);

        void onUploadSuccess(List<String> list, List<String> list2);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$SingleTransferListener;", "", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "onUploadSuccess", "name", "", "result", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AwsS3Util.kt */
    public interface SingleTransferListener {
        void onError(int i, Exception exc);

        void onProgressChanged(int i, long j, long j2);

        void onStateChanged(int i, TransferState transferState);

        void onUploadSuccess(String str, String str2);
    }

    private AwsS3Util() {
    }

    /* access modifiers changed from: private */
    public final void initAws(Context context, STSToken sTSToken) {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        Long l = null;
        if (sTSToken == null) {
            str = null;
        } else {
            str = sTSToken.getRegion();
        }
        jSONObject.put("Region", str);
        if (sTSToken == null) {
            str2 = null;
        } else {
            str2 = sTSToken.getBucketName();
        }
        jSONObject.put("Bucket", str2);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt("S3TransferUtility", jSONObject);
        TransferNetworkLossHandler.getInstance(context);
        AWSConfiguration aWSConfiguration = new AWSConfiguration(jSONObject2);
        AmazonS3 amazonS3Client = new AmazonS3Client((AWSSessionCredentials) new AwsS3Util$initAws$credentials$1(sTSToken), Region.getRegion(sTSToken == null ? null : sTSToken.getRegion()));
        amazonS3Client.setS3ClientOptions(S3ClientOptions.builder().setAccelerateModeEnabled(true).build());
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        if (sTSToken != null) {
            l = sTSToken.getTimestamp();
        }
        Tag tag2 = tag;
        XesLog.i(tag2, "system = " + currentTimeMillis + "  server = " + l);
        mTransferUtility = TransferUtility.builder().context(context).s3Client(amazonS3Client).awsConfiguration(aWSConfiguration).build();
        XesLog.i(tag2, "asw-s3 init successful");
    }

    /* access modifiers changed from: private */
    public final void uploadFile(String str, File file, TransferListener transferListener) {
        if (mTransferUtility != null) {
            XesLog.i(tag, "start upload file");
            TransferUtility transferUtility = mTransferUtility;
            TransferObserver upload = transferUtility == null ? null : transferUtility.upload(str, file, CannedAccessControlList.PublicReadWrite);
            if (upload != null) {
                upload.setTransferListener(transferListener);
                return;
            }
            return;
        }
        transferListener.onError(9999, new Exception("TransferUtility is null"));
    }

    public static /* synthetic */ void uploadFile$default(AwsS3Util awsS3Util, Context context, String str, String str2, File file, SingleTransferListener singleTransferListener, int i, Object obj) {
        if ((i & 16) != 0) {
            singleTransferListener = null;
        }
        awsS3Util.uploadFile(context, str, str2, file, singleTransferListener);
    }

    public final void uploadFile(Context context, String str, String str2, File file, SingleTransferListener singleTransferListener) {
        SingleTransferListener singleTransferListener2 = singleTransferListener;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str2, "key");
        if (str.length() == 0) {
            if (singleTransferListener2 != null) {
                singleTransferListener2.onError(9999, new Exception("scene can not be null or empty"));
            }
        } else if (file != null && file.exists()) {
            mS3Job = BuildersKt.launch$default(GlobalScope.INSTANCE, new HandlerException(new AwsS3Util$uploadFile$1(singleTransferListener2)), (CoroutineStart) null, new AwsS3Util$uploadFile$2(str2, str, singleTransferListener, file, context, (Continuation<? super AwsS3Util$uploadFile$2>) null), 2, (Object) null);
        } else if (singleTransferListener2 != null) {
            singleTransferListener2.onError(9999, new Exception("file does not exist"));
        }
    }

    public static /* synthetic */ void uploadFile$default(AwsS3Util awsS3Util, Context context, String str, String str2, String str3, SingleTransferListener singleTransferListener, int i, Object obj) {
        if ((i & 16) != 0) {
            singleTransferListener = null;
        }
        awsS3Util.uploadFile(context, str, str2, str3, singleTransferListener);
    }

    public final void uploadFile(Context context, String str, String str2, String str3, SingleTransferListener singleTransferListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(str3, "path");
        uploadFile(context, str, str2, new File(str3), singleTransferListener);
    }

    public static /* synthetic */ void uploadFiles$default(AwsS3Util awsS3Util, Context context, String str, List list, List list2, MultiTransferListener multiTransferListener, int i, Object obj) {
        if ((i & 16) != 0) {
            multiTransferListener = null;
        }
        awsS3Util.uploadFiles(context, str, list, list2, multiTransferListener);
    }

    public final void uploadFiles(Context context, String str, List<String> list, List<? extends File> list2, MultiTransferListener multiTransferListener) {
        MultiTransferListener multiTransferListener2 = multiTransferListener;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        List<String> list3 = list;
        Intrinsics.checkNotNullParameter(list, "keys");
        List<? extends File> list4 = list2;
        Intrinsics.checkNotNullParameter(list2, "files");
        if (!(str.length() == 0)) {
            mS3Job = BuildersKt.launch$default(GlobalScope.INSTANCE, new HandlerException(new AwsS3Util$uploadFiles$1(multiTransferListener2)), (CoroutineStart) null, new AwsS3Util$uploadFiles$2(list, str, multiTransferListener, context, list2, (Continuation<? super AwsS3Util$uploadFiles$2>) null), 2, (Object) null);
        } else if (multiTransferListener2 != null) {
            multiTransferListener2.onError(0, 9999, new Exception("scene can not be null or empty"));
        }
    }

    public static /* synthetic */ void uploadFilesWithPaths$default(AwsS3Util awsS3Util, Context context, String str, List list, List list2, MultiTransferListener multiTransferListener, int i, Object obj) {
        if ((i & 16) != 0) {
            multiTransferListener = null;
        }
        awsS3Util.uploadFilesWithPaths(context, str, list, list2, multiTransferListener);
    }

    public final void uploadFilesWithPaths(Context context, String str, List<String> list, List<String> list2, MultiTransferListener multiTransferListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(list, "keys");
        Intrinsics.checkNotNullParameter(list2, "paths");
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new File(list2.get(i)));
        }
        uploadFiles(context, str, list, arrayList, multiTransferListener);
    }

    public final void downloadFile(String str, File file, TransferListener transferListener) {
        TransferObserver transferObserver;
        Intrinsics.checkNotNullParameter(transferListener, "listener");
        TransferUtility transferUtility = mTransferUtility;
        if (transferUtility != null) {
            if (transferUtility == null) {
                transferObserver = null;
            } else {
                transferObserver = transferUtility.download(str, file);
            }
            if (transferObserver != null) {
                transferObserver.setTransferListener(transferListener);
            }
        }
    }

    public final void cancel(int i) {
        Job job = mS3Job;
        if (!(job == null || job == null)) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        TransferUtility transferUtility = mTransferUtility;
        if (!(transferUtility == null || transferUtility == null)) {
            transferUtility.cancel(i);
        }
        OSSService.cancelTask();
    }

    private final void cancelAll() {
        Job job = mS3Job;
        if (!(job == null || job == null)) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        TransferUtility transferUtility = mTransferUtility;
        if (!(transferUtility == null || transferUtility == null)) {
            transferUtility.cancelAllWithType(TransferType.ANY);
        }
        OSSService.cancelTask();
    }

    public final void reset() {
        if (mS3Job != null) {
            mS3Job = null;
        }
        if (mTransferUtility != null) {
            mTransferUtility = null;
        }
    }

    public final void cancelAndReset() {
        cancelAll();
        reset();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "", "()V", "OnError", "OnProgressChanged", "OnStateChanged", "OnUploadSuccess", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnUploadSuccess;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnStateChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnProgressChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnError;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AwsS3Util.kt */
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnUploadSuccess;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "name", "", "result", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getResult", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnUploadSuccess extends Event {
            private final String name;
            private final String result;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OnUploadSuccess(String str, String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "result");
                this.name = str;
                this.result = str2;
            }

            public final String getName() {
                return this.name;
            }

            public final String getResult() {
                return this.result;
            }
        }

        private Event() {
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnStateChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "id", "", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "(ILcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;)V", "getId", "()I", "getState", "()Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnStateChanged extends Event {
            private final int id;
            private final TransferState state;

            public OnStateChanged(int i, TransferState transferState) {
                super((DefaultConstructorMarker) null);
                this.id = i;
                this.state = transferState;
            }

            public final int getId() {
                return this.id;
            }

            public final TransferState getState() {
                return this.state;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnProgressChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "id", "", "bytesCurrent", "", "bytesTotal", "(IJJ)V", "getBytesCurrent", "()J", "getBytesTotal", "getId", "()I", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnProgressChanged extends Event {
            private final long bytesCurrent;
            private final long bytesTotal;
            private final int id;

            public OnProgressChanged(int i, long j, long j2) {
                super((DefaultConstructorMarker) null);
                this.id = i;
                this.bytesCurrent = j;
                this.bytesTotal = j2;
            }

            public final long getBytesCurrent() {
                return this.bytesCurrent;
            }

            public final long getBytesTotal() {
                return this.bytesTotal;
            }

            public final int getId() {
                return this.id;
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event$OnError;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$Event;", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ILjava/lang/Exception;)V", "getEx", "()Ljava/lang/Exception;", "getId", "()I", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnError extends Event {
            private final Exception ex;
            private final int id;

            public OnError(int i, Exception exc) {
                super((DefaultConstructorMarker) null);
                this.id = i;
                this.ex = exc;
            }

            public final Exception getEx() {
                return this.ex;
            }

            public final int getId() {
                return this.id;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "", "()V", "OnError", "OnProgressChanged", "OnStateChanged", "OnUploadSuccess", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnUploadSuccess;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnStateChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnProgressChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnError;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AwsS3Util.kt */
    public static abstract class MultiEvent {
        public /* synthetic */ MultiEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnUploadSuccess;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "names", "", "", "result", "(Ljava/util/List;Ljava/util/List;)V", "getNames", "()Ljava/util/List;", "getResult", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnUploadSuccess extends MultiEvent {
            private final List<String> names;
            private final List<String> result;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public OnUploadSuccess(List<String> list, List<String> list2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "names");
                Intrinsics.checkNotNullParameter(list2, "result");
                this.names = list;
                this.result = list2;
            }

            public final List<String> getNames() {
                return this.names;
            }

            public final List<String> getResult() {
                return this.result;
            }
        }

        private MultiEvent() {
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnStateChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "currentIndex", "", "id", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "(IILcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;)V", "getCurrentIndex", "()I", "getId", "getState", "()Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnStateChanged extends MultiEvent {
            private final int currentIndex;
            private final int id;
            private final TransferState state;

            public final int getCurrentIndex() {
                return this.currentIndex;
            }

            public final int getId() {
                return this.id;
            }

            public final TransferState getState() {
                return this.state;
            }

            public OnStateChanged(int i, int i2, TransferState transferState) {
                super((DefaultConstructorMarker) null);
                this.currentIndex = i;
                this.id = i2;
                this.state = transferState;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnProgressChanged;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "currentIndex", "", "id", "bytesCurrent", "", "bytesTotal", "(IIJJ)V", "getBytesCurrent", "()J", "getBytesTotal", "getCurrentIndex", "()I", "getId", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnProgressChanged extends MultiEvent {
            private final long bytesCurrent;
            private final long bytesTotal;
            private final int currentIndex;
            private final int id;

            public final long getBytesCurrent() {
                return this.bytesCurrent;
            }

            public final long getBytesTotal() {
                return this.bytesTotal;
            }

            public final int getCurrentIndex() {
                return this.currentIndex;
            }

            public final int getId() {
                return this.id;
            }

            public OnProgressChanged(int i, int i2, long j, long j2) {
                super((DefaultConstructorMarker) null);
                this.currentIndex = i;
                this.id = i2;
                this.bytesCurrent = j;
                this.bytesTotal = j2;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent$OnError;", "Lcom/tal/app/thinkacademy/common/aws/AwsS3Util$MultiEvent;", "currentIndex", "", "id", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(IILjava/lang/Exception;)V", "getCurrentIndex", "()I", "getEx", "()Ljava/lang/Exception;", "getId", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AwsS3Util.kt */
        public static final class OnError extends MultiEvent {
            private final int currentIndex;
            private final Exception ex;
            private final int id;

            public OnError(int i, int i2, Exception exc) {
                super((DefaultConstructorMarker) null);
                this.currentIndex = i;
                this.id = i2;
                this.ex = exc;
            }

            public final int getCurrentIndex() {
                return this.currentIndex;
            }

            public final Exception getEx() {
                return this.ex;
            }

            public final int getId() {
                return this.id;
            }
        }
    }

    public final Flow<Event> uploadFile(Context context, String str, String str2, File file) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "key");
        return FlowKt.conflate(FlowKt.callbackFlow(new AwsS3Util$uploadFile$3(context, str, str2, file, (Continuation<? super AwsS3Util$uploadFile$3>) null)));
    }

    public final Flow<MultiEvent> uploadFilesWithPaths(Context context, String str, List<String> list, List<String> list2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(list, "keys");
        Intrinsics.checkNotNullParameter(list2, "paths");
        return FlowKt.conflate(FlowKt.callbackFlow(new AwsS3Util$uploadFilesWithPaths$1(context, str, list, list2, (Continuation<? super AwsS3Util$uploadFilesWithPaths$1>) null)));
    }
}
