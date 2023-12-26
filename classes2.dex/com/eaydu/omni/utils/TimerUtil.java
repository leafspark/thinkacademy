package com.eaydu.omni.utils;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUtil {
    private static final String TAG = "TimerUtil";
    /* access modifiers changed from: private */
    public boolean isFinished;
    private Timer mTimer;
    /* access modifiers changed from: private */
    public TimerObserver observer;
    /* access modifiers changed from: private */
    public long time = 0;

    public interface TimerObserver {
        void onTimeUpdate(long j);
    }

    static /* synthetic */ long access$214(TimerUtil timerUtil, long j) {
        long j2 = timerUtil.time + j;
        timerUtil.time = j2;
        return j2;
    }

    static /* synthetic */ long access$222(TimerUtil timerUtil, long j) {
        long j2 = timerUtil.time - j;
        timerUtil.time = j2;
        return j2;
    }

    public TimerUtil() {
    }

    public TimerUtil(TimerObserver timerObserver) {
        this.observer = timerObserver;
        this.isFinished = false;
    }

    public void setTimerObserver(TimerObserver timerObserver) {
        this.observer = timerObserver;
    }

    public void undelayAddLoop(final long j) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        TimerUtil.access$214(TimerUtil.this, j);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undelayAddLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        TimerUtil.access$214(TimerUtil.this, j3);
                        if (j4 == TimerUtil.this.time) {
                            long unused = TimerUtil.this.time = 0;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayAddLoop(final long j) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$214(TimerUtil.this, j);
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayAddLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$214(TimerUtil.this, j3);
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        if (j4 == TimerUtil.this.time) {
                            long unused = TimerUtil.this.time = 0;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayAddUnLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$214(TimerUtil.this, j3);
                        if (j4 < TimerUtil.this.time) {
                            TimerUtil.this.release();
                        } else if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undelayAddUnLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = 0;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$214(TimerUtil.this, j3);
                        if (j4 < TimerUtil.this.time) {
                            TimerUtil.this.release();
                        } else if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayDeleteLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = j2;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$222(TimerUtil.this, j3);
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        if (0 == TimerUtil.this.time) {
                            long unused = TimerUtil.this.time = j4;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void undelayDeleteLoop(long j, long j2) {
        try {
            this.isFinished = false;
            this.time = j2;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            final long j3 = j;
            final long j4 = j2;
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        TimerUtil.access$222(TimerUtil.this, j3);
                        if (0 == TimerUtil.this.time) {
                            long unused = TimerUtil.this.time = j4;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayDeleteUnLoop(long j) {
        try {
            this.isFinished = false;
            this.time = j;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$222(TimerUtil.this, 1000);
                        if (0 > TimerUtil.this.time) {
                            TimerUtil.this.release();
                            return;
                        }
                        if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                        if (0 >= TimerUtil.this.time) {
                            TimerUtil.this.release();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 0, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delayDeleteUnLoop(final long j, long j2) {
        try {
            this.isFinished = false;
            this.time = j2;
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
            }
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                public void run() {
                    try {
                        TimerUtil.access$222(TimerUtil.this, j);
                        if (0 > TimerUtil.this.time) {
                            TimerUtil.this.release();
                        } else if (TimerUtil.this.observer != null && !TimerUtil.this.isFinished) {
                            TimerUtil.this.observer.onTimeUpdate(TimerUtil.this.time);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTime(long j) {
        this.time = j;
    }

    public boolean isFinished() {
        return this.isFinished;
    }

    public void release() {
        this.isFinished = true;
        releaseTimer();
        releaseObserver();
    }

    private void releaseObserver() {
        try {
            if (this.observer != null) {
                this.observer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelTimer() {
        try {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void releaseTimer() {
        try {
            Timer timer = this.mTimer;
            if (timer != null) {
                timer.cancel();
                this.mTimer.purge();
                this.mTimer = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
