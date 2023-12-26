package com.xueersi.lib.graffiti;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.xueersi.lib.graffiti.EngineViewInterface;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.lib.graffiti.db.DBOperator;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.img.LoadImageManager;
import com.xueersi.lib.graffiti.process.DrawableOBJFactory;
import com.xueersi.lib.graffiti.process.ExtensionFactoryManager;
import com.xueersi.lib.graffiti.utils.AppUtils;
import com.xueersi.lib.graffiti.utils.CatchHandler;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.MainHandler;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.xueersi.lib.graffiti.view.DrawingExecutorGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WXTGraffitiEngineImpl implements WXTGraffitiEngine {
    private final EngineViewInterface.CallBack drawViewCallback = new EngineViewInterface.CallBack() {
        public void onViewReady(final boolean z, final int i, final int i2) {
            if (XesLog.isEnabled()) {
                XesLog.d("控件是否准备完毕:" + z);
            }
            if (WXTGraffitiEngineImpl.this.mWorkExecutor != null) {
                WXTGraffitiEngineImpl.this.mWorkExecutor.submitTask("onViewReady", new Runnable() {
                    public void run() {
                        if (WXTGraffitiEngineImpl.this.mActionConsumer != null) {
                            WXTGraffitiEngineImpl.this.mActionConsumer.setReady(z);
                        }
                        if (z) {
                            int unused = WXTGraffitiEngineImpl.this.mSetting.height = i2;
                            int unused2 = WXTGraffitiEngineImpl.this.mSetting.width = i;
                        }
                        WXTGraffitiEngineImpl.this.mRunningStatus.viewReady = z;
                        WXTGraffitiEngineImpl.this.mRunningStatus.viewWidth = i;
                        WXTGraffitiEngineImpl.this.mRunningStatus.viewHeight = i2;
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */
    public final DrawableOBJFactory drawableOBJFactory = new DrawableOBJFactory();
    private final DrawingExecutorGroup drawingExecutorGroup = new DrawingExecutorGroup();
    /* access modifiers changed from: private */
    public final ActionConsumer mActionConsumer;
    private final ActionProducer mActionProducer;
    String mCanvasTag;
    WeakReference<Context> mContext;
    String mCourseId;
    private final MyCustomUI mCustomUI;
    private final DBOperator mDBOperator;
    private final ExtensionFactoryManager mExtensionFactoryManager = new ExtensionFactoryManager();
    /* access modifiers changed from: private */
    public final ListenerDispatcher mListenerDispatcher = new ListenerDispatcher();
    /* access modifiers changed from: private */
    public final LoadImageManager mLoadImageManager = new LoadImageManager();
    String mPageId;
    volatile String mPageKey;
    int mRole = 2;
    /* access modifiers changed from: private */
    public final WXTGraffitiEngine.RunningStatus mRunningStatus = new WXTGraffitiEngine.RunningStatus();
    /* access modifiers changed from: private */
    public final SenderListenerWrapper mSenderListener = new SenderListenerWrapper();
    /* access modifiers changed from: private */
    public final MySetting mSetting = new MySetting();
    String mSpecifKey;
    String mTeacherId;
    String mUid;
    WXWBAction.UserInfo mUserInfo;
    WeakReference<Context> mViewContext;
    private WeakReference<EngineViewInterface> mViewRef;
    /* access modifiers changed from: private */
    public final WorkExecutor mWorkExecutor;

    public WXTGraffitiEngineImpl(Context context) {
        this.mCustomUI = new MyCustomUI(context.getApplicationContext());
        this.mContext = new WeakReference<>(context);
        DBOperator dBOperator = new DBOperator(this, context.getApplicationContext());
        this.mDBOperator = dBOperator;
        WorkExecutor workExecutor = new WorkExecutor("WXTGraffitiEngineThread");
        this.mWorkExecutor = workExecutor;
        this.mActionConsumer = new ActionConsumer(this, workExecutor, dBOperator);
        this.mActionProducer = new ActionProducer(this, workExecutor, dBOperator);
        XesLog.setDebugMode(false);
        AppUtils.init(context.getApplicationContext());
    }

    public String getPageKey() {
        return this.mPageKey;
    }

    public String getUid() {
        return this.mUid;
    }

    public void mockUid(String str) {
        this.mUid = str;
    }

    public Context getViewContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null && (weakReference.get() instanceof Activity)) {
            return (Context) this.mContext.get();
        }
        WeakReference<Context> weakReference2 = this.mViewContext;
        if (weakReference2 != null) {
            return (Context) weakReference2.get();
        }
        return null;
    }

    public DrawableOBJFactory getDrawableOBJFactory() {
        return this.drawableOBJFactory;
    }

    public void initWithUid(int i, String str, String str2) {
        this.mDBOperator.setDBSpecifKey(str2);
        this.mRole = i;
        this.mSpecifKey = str2;
        this.mUid = str;
    }

    public View createCanvasView(Context context, String str) {
        this.mCanvasTag = str;
        this.mViewContext = new WeakReference<>(context);
        EngineViewInterface.DefaultViewImp defaultViewImp = new EngineViewInterface.DefaultViewImp(this);
        defaultViewImp.setCallBack(this.drawViewCallback);
        defaultViewImp.setProduceCallBack(this.mActionProducer);
        defaultViewImp.setCanvasTag(str);
        this.mViewRef = new WeakReference<>(defaultViewImp);
        this.mLoadImageManager.setOnLoadListener(defaultViewImp);
        return defaultViewImp.createView(context);
    }

    public void turnPageTo(String str) {
        turnPageTo(str, 1);
    }

    public void turnPageTo(String str, int i) {
        XesLog.d("turnPageTo:" + str);
        LocalCanvasSize.sdkInner().setCurTag(this.mCanvasTag);
        if (!TextUtils.isEmpty(str)) {
            onTurnPageTo(str, i);
        }
    }

    public void addActionList(final List<WXWBAction> list, final int i) {
        runOnWorkThread(new Runnable() {
            public void run() {
                WXTGraffitiEngineImpl.this.mActionConsumer.addActionDataList(ListUtil.filterNullItem(list), i);
            }
        });
    }

    private void onTurnPageTo(final String str, final int i) {
        this.mPageKey = str;
        this.mWorkExecutor.removeSubmitTasks();
        runOnWorkThread(new Runnable() {
            public void run() {
                if (WXTGraffitiEngineImpl.this.mSetting.isTouchable() && WXTGraffitiEngineImpl.this.mListenerDispatcher != null) {
                    WXTGraffitiEngineImpl.this.mListenerDispatcher.onGraffitiStackUpdate(false, false);
                }
                WXTGraffitiEngineImpl.this.mActionConsumer.clear();
                WXTGraffitiEngineImpl.this.mActionConsumer.setCurrentPage(str, i);
                WXTGraffitiEngineImpl.this.mActionConsumer.enableSaveDB();
                WXTGraffitiEngineImpl.this.clearDrawView();
                WXTGraffitiEngineImpl.this.loadHistoryFromDB();
                WXTGraffitiEngineImpl.this.mLoadImageManager.clearAll();
            }
        });
    }

    /* access modifiers changed from: private */
    public void clearDrawView() {
        WeakReference<EngineViewInterface> weakReference = this.mViewRef;
        if (weakReference != null && weakReference.get() != null) {
            ((EngineViewInterface) this.mViewRef.get()).clear();
        }
    }

    /* access modifiers changed from: private */
    public void loadHistoryFromDB() {
        final long uptimeMillis = SystemClock.uptimeMillis();
        this.mDBOperator.query(this.mPageKey, new DBOperator.QueryCallback() {
            public void onResult(String str, List<WXWBAction> list) {
                WXTGraffitiEngineImpl.this.onLoadDBResult(str, list, uptimeMillis);
            }
        });
    }

    /* access modifiers changed from: private */
    public void onLoadDBResult(String str, List<WXWBAction> list, long j) {
        final long j2 = j;
        final List<WXWBAction> list2 = list;
        final String str2 = str;
        runOnWorkThread(new Runnable() {
            public void run() {
                XesLog.d("读取db耗时" + (SystemClock.uptimeMillis() - j2) + "毫秒，总共条数:" + ListUtil.size(list2));
                List list = list2;
                ArrayList arrayList = null;
                if (!WXTGraffitiEngineImpl.isCurrentPageActionData(WXTGraffitiEngineImpl.this.mPageKey, list2)) {
                    list = null;
                } else if (WXTGraffitiEngineImpl.this.mActionConsumer != null) {
                    WXTGraffitiEngineImpl.this.mActionConsumer.addActionDataList(list2, 2);
                }
                ListenerDispatcher access$200 = WXTGraffitiEngineImpl.this.mListenerDispatcher;
                String str = str2;
                if (list != null) {
                    arrayList = new ArrayList(list);
                }
                access$200.onFetchedDBActionList(str, arrayList);
            }
        });
    }

    public void addActionList(List<WXWBAction> list) {
        addActionList(list, 4);
    }

    public void addAction(WXWBAction wXWBAction) {
        addAction(wXWBAction, 3);
    }

    public void addAction(final WXWBAction wXWBAction, final int i) {
        runOnWorkThread(new Runnable() {
            public void run() {
                WXTGraffitiEngineImpl.this.mActionConsumer.addActionData(wXWBAction, i);
            }
        });
    }

    public void beginDrawWithTimestamp(final long j) {
        runOnWorkThread(new Runnable() {
            public void run() {
                WXTGraffitiEngineImpl.this.mActionConsumer.alignTimeStamp(j);
            }
        });
    }

    public void registerExtensionFactory(ExtensionFactory extensionFactory) {
        this.mExtensionFactoryManager.add(extensionFactory);
    }

    public void debugMode(boolean z) {
        XesLog.setDebugMode(z);
    }

    public void useTimeStampAlign(boolean z) {
        this.mActionConsumer.enableAlignTimeStamp(z);
    }

    public void setListener(WXTGraffitiEngine.Listener listener) {
        this.mListenerDispatcher.addListener(listener);
    }

    public void setSenderListener(WXTGraffitiEngine.SenderListener senderListener) {
        this.mSenderListener.setSenderListener(senderListener);
    }

    public void setCourseId(String str) {
        this.mCourseId = str;
    }

    public void setPageId(String str) {
        this.mPageId = str;
    }

    public void setTeacherId(String str) {
        this.mTeacherId = str;
    }

    public String getTeacherId() {
        return this.mTeacherId;
    }

    public void disableSaveDBCurrentPage() {
        this.mActionConsumer.disableSaveDB();
    }

    public void setImageLoader(WXTGraffitiEngine.ImageLoader imageLoader) {
        this.mLoadImageManager.setImageLoader(imageLoader);
    }

    public LoadImageManager getLoadImageManager() {
        return this.mLoadImageManager;
    }

    public ExtensionFactoryManager getExtensionFactoryManager() {
        return this.mExtensionFactoryManager;
    }

    public WXTGraffitiEngine.RunningStatus getRunningStatus() {
        this.mRunningStatus.workExceptions = CatchHandler.takeExceptionRecord();
        this.mRunningStatus.curPage = this.mPageKey;
        ActionConsumer actionConsumer = this.mActionConsumer;
        if (actionConsumer == null || actionConsumer.getLastAction() == null) {
            this.mRunningStatus.lastActionInfo = null;
        } else {
            this.mRunningStatus.lastActionInfo = this.mActionConsumer.getLastAction().getUniqueKey();
        }
        WXTGraffitiEngine.RunningStatus runningStatus = this.mRunningStatus;
        ActionConsumer actionConsumer2 = this.mActionConsumer;
        runningStatus.actionCount = actionConsumer2 != null ? actionConsumer2.getActionCount() : 0;
        return this.mRunningStatus;
    }

    public void destroy() {
        this.mRunningStatus.destroyed = true;
        DBOperator dBOperator = this.mDBOperator;
        if (dBOperator != null) {
            dBOperator.clearAndClose();
        }
        WorkExecutor workExecutor = this.mWorkExecutor;
        if (workExecutor != null) {
            workExecutor.destroy();
        }
        ActionConsumer actionConsumer = this.mActionConsumer;
        if (actionConsumer != null) {
            actionConsumer.destroy();
        }
        ListenerDispatcher listenerDispatcher = this.mListenerDispatcher;
        if (listenerDispatcher != null) {
            listenerDispatcher.destroy();
        }
        SenderListenerWrapper senderListenerWrapper = this.mSenderListener;
        if (senderListenerWrapper != null) {
            senderListenerWrapper.destroy();
        }
        LoadImageManager loadImageManager = this.mLoadImageManager;
        if (loadImageManager != null) {
            loadImageManager.destroy();
        }
        WeakReference<EngineViewInterface> weakReference = this.mViewRef;
        if (weakReference != null) {
            if (weakReference.get() != null) {
                ((EngineViewInterface) this.mViewRef.get()).destroy();
            }
            this.mViewRef.clear();
        }
        DrawingExecutorGroup drawingExecutorGroup2 = this.drawingExecutorGroup;
        if (drawingExecutorGroup2 != null) {
            drawingExecutorGroup2.destroy();
        }
        if (XesLog.isEnabled()) {
            XesLog.d("引擎销毁");
        }
    }

    public WXWBAction actionForActionType(int i) {
        return this.mActionProducer.actionForActionType(i);
    }

    public WXWBAction actionForData(byte[] bArr, String str) throws Exception {
        return new WXWBAction.ReceiveImpl(bArr, str);
    }

    public void addGraphicFactory(int i, DrawableObject.Factory factory) {
        this.drawableOBJFactory.addFactory(i, factory);
    }

    public void setUserInfo(WXWBAction.UserInfo userInfo) {
        this.mUserInfo = userInfo;
    }

    public void setCanvasTag(String str) {
        ((EngineViewInterface) this.mViewRef.get()).setCanvasTag(str);
    }

    public WXTGraffitiEngine.Setting getSetting() {
        return this.mSetting;
    }

    public WXTGraffitiEngine.CustomUI getCustomUI() {
        return this.mCustomUI;
    }

    private class MyCustomUI extends WXTGraffitiEngine.CustomUI {
        public MyCustomUI(Context context) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.graffiti_laser_pointer);
            drawable.setBounds(0, 0, 24, 24);
            setLaserPointerDrawable(new WXTGraffitiEngine.CustomUI.DrawableDesc(drawable));
        }

        public void setHideLaserTail(boolean z) {
            super.setHideLaserTail(z);
            WXTGraffitiEngineImpl.this.drawableOBJFactory.getConfig().setHideLaserTail(z);
        }

        public void setHideShapeCenterDot(boolean z) {
            super.setHideShapeCenterDot(z);
            WXTGraffitiEngineImpl.this.drawableOBJFactory.getConfig().setHideShapeCenterDot(z);
        }
    }

    private class MySetting extends WXTGraffitiEngine.Setting {
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public int width;

        public MySetting() {
            setStrokeColor(-65536);
            setFillColor(-65536);
            setPenWidth(0.01f);
            setLineType(0);
            setPenStyle(0);
            setEraseWidth(0.04f);
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public long getBizTimeStampMillis() {
            return WXTGraffitiEngineImpl.this.mSenderListener.getCurrentTimeStampMillis() - 1577808000000L;
        }
    }

    static class SenderListenerWrapper extends WXTGraffitiEngine.SenderListener.Adapter {
        private WXTGraffitiEngine.SenderListener senderListener;

        SenderListenerWrapper() {
        }

        public void setSenderListener(WXTGraffitiEngine.SenderListener senderListener2) {
            this.senderListener = senderListener2;
        }

        public void onSendActionData(WXWBAction wXWBAction) {
            WXTGraffitiEngine.SenderListener senderListener2 = this.senderListener;
            if (senderListener2 != null) {
                senderListener2.onSendActionData(wXWBAction);
            }
        }

        public long getCurrentTimeStampMillis() {
            WXTGraffitiEngine.SenderListener senderListener2 = this.senderListener;
            if (senderListener2 != null) {
                return senderListener2.getCurrentTimeStampMillis();
            }
            return super.getCurrentTimeStampMillis();
        }

        public long generateUniqueId(WXTGraffitiEngine.UniqueIdType uniqueIdType) {
            WXTGraffitiEngine.SenderListener senderListener2 = this.senderListener;
            if (senderListener2 != null) {
                return senderListener2.generateUniqueId(uniqueIdType);
            }
            return super.generateUniqueId(uniqueIdType);
        }

        public void destroy() {
            this.senderListener = null;
        }
    }

    static class ListenerDispatcher implements WXTGraffitiEngine.Listener {
        private final MainHandler handler = new MainHandler(Looper.getMainLooper());
        /* access modifiers changed from: private */
        public WXTGraffitiEngine.Listener listener;

        public void onUnSupportActionList(List<WXWBAction> list) {
        }

        public void addListener(WXTGraffitiEngine.Listener listener2) {
            this.listener = listener2;
        }

        public void onUnSupportActionList(final List<WXWBAction> list, final boolean z) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        if (ListenerDispatcher.this.listener != null) {
                            ListenerDispatcher.this.listener.onUnSupportActionList(list, z);
                            ListenerDispatcher.this.listener.onUnSupportActionList(list);
                        }
                    }
                });
            }
        }

        public void onFetchedDBActionList(final String str, final List<WXWBAction> list) {
            if (this.listener != null) {
                this.handler.post(new Runnable() {
                    public void run() {
                        if (ListenerDispatcher.this.listener != null) {
                            ListenerDispatcher.this.listener.onFetchedDBActionList(str, list);
                        }
                    }
                });
            }
        }

        public void onGraffitiStackUpdate(final boolean z, final boolean z2) {
            this.handler.post(new Runnable() {
                public void run() {
                    if (ListenerDispatcher.this.listener != null) {
                        ListenerDispatcher.this.listener.onGraffitiStackUpdate(z, z2);
                    }
                }
            });
        }

        public void destroy() {
            this.listener = null;
        }
    }

    static boolean isCurrentPageActionData(String str, List<WXWBAction> list) {
        return ListUtil.isNotEmpty(list) && TextUtils.equals(str, list.get(0).getPageKey());
    }

    private void runOnWorkThread(Runnable runnable) {
        WorkExecutor workExecutor = this.mWorkExecutor;
        if (workExecutor != null) {
            workExecutor.submitTask(runnable);
        }
    }

    public EngineViewInterface getEngineView() {
        WeakReference<EngineViewInterface> weakReference = this.mViewRef;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (EngineViewInterface) this.mViewRef.get();
    }

    public WXTGraffitiEngine.Listener getListener() {
        return this.mListenerDispatcher;
    }

    public WXTGraffitiEngine.SenderListener getSenderListener() {
        return this.mSenderListener;
    }

    public DrawingExecutorGroup getDrawingExecutorGroup() {
        return this.drawingExecutorGroup;
    }
}
