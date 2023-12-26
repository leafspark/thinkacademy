package com.tal.app.thinkacademy.lib.utils;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager;", "", "()V", "mCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mOkHttpClient", "Lokhttp3/OkHttpClient;", "mTaskList", "Ljava/util/HashMap;", "", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$Task;", "Lkotlin/collections/HashMap;", "cancelAll", "", "safeCreateTask", "url", "Companion", "ListenerHolder", "Task", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DownloadManager.kt */
public final class DownloadManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<DownloadManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DownloadManager$Companion$instance$2.INSTANCE);
    private final CoroutineScope mCoroutineScope;
    private final OkHttpClient mOkHttpClient;
    private HashMap<String, Task> mTaskList;

    public /* synthetic */ DownloadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DownloadManager() {
        this.mOkHttpClient = OkHttp3Instrumentation.init();
        this.mCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        this.mTaskList = new HashMap<>();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager;", "getInstance", "()Lcom/tal/app/thinkacademy/lib/utils/DownloadManager;", "instance$delegate", "Lkotlin/Lazy;", "get", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final DownloadManager getInstance() {
            return (DownloadManager) DownloadManager.instance$delegate.getValue();
        }

        public final DownloadManager get() {
            return getInstance();
        }
    }

    public final Task safeCreateTask(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Task task = this.mTaskList.get(str);
        if (task != null && !task.isCancel() && !task.isComplete()) {
            return task;
        }
        Task task2 = new Task(str, this.mOkHttpClient, this.mCoroutineScope);
        this.mTaskList.put(str, task2);
        return task2;
    }

    public final void cancelAll() {
        Collection<Task> values = this.mTaskList.values();
        Intrinsics.checkNotNullExpressionValue(values, "mTaskList.values");
        for (Task cancel : values) {
            cancel.cancel();
        }
        this.mTaskList.clear();
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001f\u0010\u001c\u001a\u00020\u00122\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u001e¢\u0006\u0002\b\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$Task;", "", "url", "", "client", "Lokhttp3/OkHttpClient;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/lang/String;Lokhttp3/OkHttpClient;Lkotlinx/coroutines/CoroutineScope;)V", "mComplete", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsCancel", "mListenerData", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "mProgress", "Ljava/util/concurrent/atomic/AtomicInteger;", "mRunning", "cancel", "", "download", "targetFile", "Ljava/io/File;", "isCancel", "", "isComplete", "isRunning", "progress", "", "setCallback", "listener", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadManager.kt */
    public static final class Task {
        /* access modifiers changed from: private */
        public final OkHttpClient client;
        private final CoroutineScope coroutineScope;
        /* access modifiers changed from: private */
        public AtomicBoolean mComplete = new AtomicBoolean(false);
        /* access modifiers changed from: private */
        public AtomicBoolean mIsCancel = new AtomicBoolean(false);
        /* access modifiers changed from: private */
        public ListenerHolder mListenerData = new ListenerHolder();
        /* access modifiers changed from: private */
        public AtomicInteger mProgress = new AtomicInteger(0);
        /* access modifiers changed from: private */
        public AtomicBoolean mRunning = new AtomicBoolean(false);
        /* access modifiers changed from: private */
        public final String url;

        public Task(String str, OkHttpClient okHttpClient, CoroutineScope coroutineScope2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(okHttpClient, "client");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            this.url = str;
            this.client = okHttpClient;
            this.coroutineScope = coroutineScope2;
        }

        public final void download(File file) {
            Intrinsics.checkNotNullParameter(file, "targetFile");
            if (!this.mRunning.get()) {
                this.mRunning.compareAndSet(false, true);
                this.mIsCancel.compareAndSet(true, false);
                this.mComplete.compareAndSet(true, false);
                File file2 = new File(Intrinsics.stringPlus(file.getAbsolutePath(), ".temp"));
                long length = file2.length();
                BuildersKt.launch$default(this.coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new DownloadManager$Task$download$1(this, length, file2, file, (Continuation<? super DownloadManager$Task$download$1>) null), 2, (Object) null);
            }
        }

        public final void setCallback(Function1<? super ListenerHolder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "listener");
            function1.invoke(this.mListenerData);
        }

        public final void cancel() {
            if (!this.mComplete.get()) {
                this.mIsCancel.compareAndSet(false, true);
            }
        }

        public final boolean isRunning() {
            return this.mRunning.get();
        }

        public final boolean isCancel() {
            return this.mIsCancel.get();
        }

        public final boolean isComplete() {
            return this.mComplete.get();
        }

        public final int progress() {
            return this.mProgress.get();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0012J\u001a\u0010\u0013\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J \u0010\u0015\u001a\u00020\u00062\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bJ \u0010\u0016\u001a\u00020\u00062\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\bJ \u0010\u0017\u001a\u00020\u00062\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\bJ\u001a\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "", "()V", "mCancelBlock", "Lkotlin/Function1;", "", "", "mErrorBlock", "Lkotlin/Function2;", "", "mProgressBlock", "", "mStartBlock", "mSuccessBlock", "clear", "clear$lib_library_release", "invoke", "listener", "invoke$lib_library_release", "onCancel", "block", "onError", "onProgress", "onStart", "onSuccess", "DownloadCancel", "DownloadError", "DownloadProgress", "DownloadStart", "DownloadSuccess", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DownloadManager.kt */
    public static class ListenerHolder {
        private Function1<? super String, Unit> mCancelBlock;
        private Function2<? super String, ? super Throwable, Unit> mErrorBlock;
        private Function2<? super String, ? super Integer, Unit> mProgressBlock;
        private Function2<? super String, ? super Integer, Unit> mStartBlock;
        private Function1<? super String, Unit> mSuccessBlock;

        public final void invoke$lib_library_release(ListenerHolder listenerHolder) {
            Function2<? super String, ? super Throwable, Unit> function2;
            Intrinsics.checkNotNullParameter(listenerHolder, "listener");
            if (listenerHolder instanceof DownloadStart) {
                Function2<? super String, ? super Integer, Unit> function22 = this.mStartBlock;
                if (function22 != null) {
                    DownloadStart downloadStart = (DownloadStart) listenerHolder;
                    function22.invoke(downloadStart.getUrl(), Integer.valueOf(downloadStart.getProgress()));
                }
            } else if (listenerHolder instanceof DownloadSuccess) {
                Function1<? super String, Unit> function1 = this.mSuccessBlock;
                if (function1 != null) {
                    function1.invoke(((DownloadSuccess) listenerHolder).getUrl());
                }
            } else if (listenerHolder instanceof DownloadProgress) {
                Function2<? super String, ? super Integer, Unit> function23 = this.mProgressBlock;
                if (function23 != null) {
                    DownloadProgress downloadProgress = (DownloadProgress) listenerHolder;
                    function23.invoke(downloadProgress.getUrl(), Integer.valueOf(downloadProgress.getProgress()));
                }
            } else if (listenerHolder instanceof DownloadCancel) {
                Function1<? super String, Unit> function12 = this.mCancelBlock;
                if (function12 != null) {
                    function12.invoke(((DownloadCancel) listenerHolder).getUrl());
                }
            } else if ((listenerHolder instanceof DownloadError) && (function2 = this.mErrorBlock) != null) {
                DownloadError downloadError = (DownloadError) listenerHolder;
                function2.invoke(downloadError.getUrl(), downloadError.getE());
            }
        }

        public final void onStart(Function2<? super String, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.mStartBlock = function2;
        }

        public final void onSuccess(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.mSuccessBlock = function1;
        }

        public final void onProgress(Function2<? super String, ? super Integer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.mProgressBlock = function2;
        }

        public final void onCancel(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            this.mCancelBlock = function1;
        }

        public final void onError(Function2<? super String, ? super Throwable, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "block");
            this.mErrorBlock = function2;
        }

        public final void clear$lib_library_release() {
            this.mStartBlock = null;
            this.mSuccessBlock = null;
            this.mProgressBlock = null;
            this.mCancelBlock = null;
            this.mErrorBlock = null;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder$DownloadStart;", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "url", "", "progress", "", "(Ljava/lang/String;I)V", "getProgress", "()I", "getUrl", "()Ljava/lang/String;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DownloadManager.kt */
        public static final class DownloadStart extends ListenerHolder {
            private final int progress;
            private final String url;

            public DownloadStart(String str, int i) {
                Intrinsics.checkNotNullParameter(str, "url");
                this.url = str;
                this.progress = i;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder$DownloadSuccess;", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DownloadManager.kt */
        public static final class DownloadSuccess extends ListenerHolder {
            private final String url;

            public DownloadSuccess(String str) {
                Intrinsics.checkNotNullParameter(str, "url");
                this.url = str;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder$DownloadProgress;", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "url", "", "progress", "", "(Ljava/lang/String;I)V", "getProgress", "()I", "getUrl", "()Ljava/lang/String;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DownloadManager.kt */
        public static final class DownloadProgress extends ListenerHolder {
            private final int progress;
            private final String url;

            public DownloadProgress(String str, int i) {
                Intrinsics.checkNotNullParameter(str, "url");
                this.url = str;
                this.progress = i;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder$DownloadCancel;", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DownloadManager.kt */
        public static final class DownloadCancel extends ListenerHolder {
            private final String url;

            public DownloadCancel(String str) {
                Intrinsics.checkNotNullParameter(str, "url");
                this.url = str;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder$DownloadError;", "Lcom/tal/app/thinkacademy/lib/utils/DownloadManager$ListenerHolder;", "url", "", "e", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getE", "()Ljava/lang/Throwable;", "getUrl", "()Ljava/lang/String;", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: DownloadManager.kt */
        public static final class DownloadError extends ListenerHolder {
            private final Throwable e;
            private final String url;

            public DownloadError(String str, Throwable th) {
                Intrinsics.checkNotNullParameter(str, "url");
                Intrinsics.checkNotNullParameter(th, "e");
                this.url = str;
                this.e = th;
            }

            public final Throwable getE() {
                return this.e;
            }

            public final String getUrl() {
                return this.url;
            }
        }
    }
}
