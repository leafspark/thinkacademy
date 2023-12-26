package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.NetTestState;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/business/login/presenter/DeviceTestViewModel$checkDownload$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestViewModel.kt */
public final class DeviceTestViewModel$checkDownload$1 implements Callback {
    final /* synthetic */ long $mStartTimeMillis;
    final /* synthetic */ DeviceTestViewModel this$0;

    DeviceTestViewModel$checkDownload$1(DeviceTestViewModel deviceTestViewModel, long j) {
        this.this$0 = deviceTestViewModel;
        this.$mStartTimeMillis = j;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(iOException, "e");
        XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("checkDownload onFailure ", iOException)});
        if (!this.this$0.mDownloadTesting) {
            XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onFailure-----拦截"});
            return;
        }
        this.this$0.mDownloadTesting = false;
        this.this$0.mHandler.removeCallbacks(this.this$0.mDownloadTimer);
        this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createDownloadBean(-1));
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onResponse fail"});
            if (!this.this$0.mDownloadTesting) {
                XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onResponse fail-----拦截"});
                return;
            }
            this.this$0.mDownloadTesting = false;
            this.this$0.mHandler.removeCallbacks(this.this$0.mDownloadTimer);
            this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createDownloadBean(-1));
            return;
        }
        InputStream inputStream = null;
        byte[] bArr = new byte[2048];
        try {
            ResponseBody body = response.body();
            Intrinsics.checkNotNull(body);
            inputStream = body.byteStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                DeviceTestViewModel deviceTestViewModel = this.this$0;
                deviceTestViewModel.mDownloadCount = deviceTestViewModel.mDownloadCount + ((long) read);
            }
            this.this$0.mHandler.removeCallbacks(this.this$0.mDownloadTimer);
            int access$getMDownloadCount$p = (int) ((((float) this.this$0.mDownloadCount) / 1024.0f) / (((float) (System.currentTimeMillis() - this.$mStartTimeMillis)) / 1000.0f));
            XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onResponse finish speed:" + access$getMDownloadCount$p + " KB/s"});
            if (!this.this$0.mDownloadTesting) {
                XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onResponse finish-----拦截"});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } else {
                this.this$0.mDownloadTesting = false;
                this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createDownloadBean(access$getMDownloadCount$p));
                if (inputStream == null) {
                    return;
                }
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (Exception e) {
            XesLog.it("DeviceTest_VM", new Object[]{Intrinsics.stringPlus("checkDownload onResponse Exception ", e)});
            if (!this.this$0.mDownloadTesting) {
                XesLog.it("DeviceTest_VM", new Object[]{"checkDownload onResponse Exception-----拦截"});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            } else {
                this.this$0.mDownloadTesting = false;
                this.this$0.getMNetTestState().postStickyData(NetTestState.INSTANCE.createDownloadBean(-1));
                if (inputStream == null) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }
}
