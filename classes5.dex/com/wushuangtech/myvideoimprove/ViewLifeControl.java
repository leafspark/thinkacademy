package com.wushuangtech.myvideoimprove;

import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

class ViewLifeControl implements VideoRenderView.OnVideoRenderViewCallBack {
    private TaskHolder mCacheTaskHolder;
    private TaskHolder mCurrentTaskHolder;
    private VideoRenderViewLifeBean mCurrentVideoRenderViewLifeBean;
    private final WeakReference<LocalVideoRenderModel> mLocalVideoRenderModelRef;
    private final Object mLock = new Object();
    private TaskType mStats = TaskType.IDLE;
    private long mView;

    enum TaskType {
        IDLE,
        AVAILABLE,
        SIZECHANGED,
        DESTORY,
        ATTACH,
        DETACH
    }

    public void onVideoRenderSurfaceAvailable(VideoRenderViewLifeBean videoRenderViewLifeBean) {
    }

    public void onVideoRenderSurfaceDestroyed(VideoRenderViewLifeBean videoRenderViewLifeBean) {
    }

    public void onVideoRenderSurfaceSizeChanged(VideoRenderViewLifeBean videoRenderViewLifeBean) {
    }

    public void onViewRenderDetachedFromWindow(VideoRenderView videoRenderView) {
    }

    public ViewLifeControl(LocalVideoRenderModel localVideoRenderModel) {
        this.mLocalVideoRenderModelRef = new WeakReference<>(localVideoRenderModel);
    }

    public void onViewRenderAttachedToWindow(VideoRenderView videoRenderView) {
        receiveTask(videoRenderView, new Task(videoRenderView, TaskType.ATTACH, (Object) null));
        Task pollNextTask = pollNextTask();
        if (pollNextTask != null) {
            executeingTask(pollNextTask);
        }
    }

    private void receiveTask(VideoRenderView videoRenderView, Task task) {
        synchronized (this.mLock) {
            TaskHolder taskHolder = this.mCurrentTaskHolder;
            TaskHolder taskHolder2 = this.mCacheTaskHolder;
            if (taskHolder == null) {
                this.mCurrentTaskHolder = new TaskHolder(videoRenderView, task);
                return;
            }
            if (taskHolder.mVideoRenderView == videoRenderView) {
                if (taskHolder.mCurrentTask == null) {
                    Task unused = taskHolder.mCurrentTask = task;
                    return;
                } else if (taskHolder.mCurrentTask.mType != task.mType) {
                    if (taskHolder.mCurrentTask.mType != TaskType.IDLE) {
                        taskHolder.addTask(task);
                        return;
                    }
                } else {
                    return;
                }
            }
            if (taskHolder2 == null) {
                TaskHolder taskHolder3 = new TaskHolder(videoRenderView, task);
                this.mCacheTaskHolder = taskHolder3;
                taskHolder3.addTask(task);
            } else if (taskHolder2.mVideoRenderView == videoRenderView) {
                taskHolder2.addTask(task);
            } else {
                taskHolder2.drop();
                TaskHolder taskHolder4 = new TaskHolder(videoRenderView, task);
                this.mCacheTaskHolder = taskHolder4;
                taskHolder4.addTask(task);
            }
        }
    }

    private Task pollNextTask() {
        synchronized (this.mLock) {
            TaskHolder taskHolder = this.mCurrentTaskHolder;
            if (taskHolder == null) {
                return null;
            }
            Task pollNext = taskHolder.pollNext();
            if (pollNext != null) {
                return pollNext;
            }
            TaskHolder taskHolder2 = this.mCacheTaskHolder;
            if (taskHolder2 == null) {
                return null;
            }
            this.mCurrentTaskHolder = taskHolder2;
            this.mCacheTaskHolder = null;
            Task pollNext2 = taskHolder2.pollNext();
            return pollNext2;
        }
    }

    private void executeingTask(Task task) {
        LocalVideoRenderModel localVideoRenderModel = (LocalVideoRenderModel) this.mLocalVideoRenderModelRef.get();
    }

    private static class Task {
        public Object mObj;
        public TaskType mType;
        private final VideoRenderView mVideoRenderView;

        public Task(VideoRenderView videoRenderView, TaskType taskType, Object obj) {
            this.mVideoRenderView = videoRenderView;
            this.mType = taskType;
            this.mObj = obj;
        }
    }

    private static class TaskHolder {
        /* access modifiers changed from: private */
        public Task mCurrentTask;
        private final LinkedList<Task> mTasks = new LinkedList<>();
        /* access modifiers changed from: private */
        public final VideoRenderView mVideoRenderView;

        public TaskHolder(VideoRenderView videoRenderView, Task task) {
            this.mVideoRenderView = videoRenderView;
            this.mCurrentTask = task;
        }

        public void addTask(Task task) {
            addTask(this.mTasks, task);
        }

        private void addTask(LinkedList<Task> linkedList, Task task) {
            boolean z;
            Iterator it = linkedList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Task) it.next()).mType == task.mType) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                linkedList.push(task);
            }
        }

        public void drop() {
            this.mTasks.clear();
        }

        public Task pollNext() {
            return this.mTasks.poll();
        }
    }
}
