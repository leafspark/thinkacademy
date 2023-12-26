package com.bonree.sdk.i;

import android.os.IBinder;
import android.os.WorkSource;
import com.bonree.sdk.be.f;
import com.bonree.sdk.i.k;
import java.lang.reflect.Method;

public class i extends k {
    private static final String c = "BRSDK.PowerHooker";
    private f d = com.bonree.sdk.be.a.a();

    public interface b extends k.a {
        void a(IBinder iBinder);

        void a(IBinder iBinder, String str);
    }

    public i() {
        this.b = new l("power", "android.os.IPowerManager", new j(this));
    }

    /* access modifiers changed from: protected */
    public final void a(Method method, Object[] objArr) {
        a aVar;
        if (method.getName().equals("acquireWakeLock")) {
            a aVar2 = null;
            if (objArr == null) {
                this.d.d("BRSDK.PowerHooker createAcquireWakeLockArgs args null", new Object[0]);
            } else {
                int length = objArr.length;
                f fVar = this.d;
                fVar.c("BRSDK.PowerHooker checkAcquireWakeLockArgs: length:" + length, new Object[0]);
                if (length != 4) {
                    if (length == 7) {
                        aVar = new a((byte) 0);
                        if (!(objArr[0] instanceof IBinder)) {
                            f fVar2 = this.d;
                            fVar2.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
                        } else {
                            aVar.a = objArr[0];
                            if (!(objArr[1] instanceof Integer)) {
                                f fVar3 = this.d;
                                fVar3.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
                            } else {
                                aVar.b = objArr[1].intValue();
                                if (objArr[2] == null || (objArr[2] instanceof String)) {
                                    aVar.c = objArr[2];
                                    if (objArr[3] == null || (objArr[3] instanceof String)) {
                                        aVar.d = objArr[3];
                                        if (objArr[4] == null || (objArr[4] instanceof WorkSource)) {
                                            aVar.e = objArr[4];
                                            if (objArr[5] == null || (objArr[5] instanceof String)) {
                                                aVar.f = objArr[5];
                                            } else {
                                                f fVar4 = this.d;
                                                fVar4.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 5 not String" + objArr[5], new Object[0]);
                                            }
                                        } else {
                                            f fVar5 = this.d;
                                            fVar5.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 4 not WorkSource" + objArr[4], new Object[0]);
                                        }
                                    } else {
                                        f fVar6 = this.d;
                                        fVar6.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
                                    }
                                } else {
                                    f fVar7 = this.d;
                                    fVar7.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
                                }
                            }
                        }
                    } else if (length == 8) {
                        aVar = new a((byte) 0);
                        if (!(objArr[0] instanceof IBinder)) {
                            f fVar8 = this.d;
                            fVar8.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
                        } else {
                            aVar.a = objArr[0];
                            if (!(objArr[1] instanceof Integer)) {
                                f fVar9 = this.d;
                                fVar9.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
                            } else {
                                aVar.b = objArr[1].intValue();
                                if (objArr[2] == null || (objArr[2] instanceof String)) {
                                    aVar.c = objArr[2];
                                    if (objArr[3] == null || (objArr[3] instanceof String)) {
                                        aVar.d = objArr[3];
                                    } else {
                                        f fVar10 = this.d;
                                        fVar10.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
                                    }
                                } else {
                                    f fVar11 = this.d;
                                    fVar11.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
                                }
                            }
                        }
                    } else if (objArr.length == 6 || objArr.length == 5) {
                        aVar = new a((byte) 0);
                        if (!(objArr[0] instanceof IBinder)) {
                            f fVar12 = this.d;
                            fVar12.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
                        } else {
                            aVar.a = objArr[0];
                            if (!(objArr[1] instanceof Integer)) {
                                f fVar13 = this.d;
                                fVar13.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
                            } else {
                                aVar.b = objArr[1].intValue();
                                if (objArr[2] == null || (objArr[2] instanceof String)) {
                                    aVar.c = objArr[2];
                                    if (objArr[3] == null || (objArr[3] instanceof String)) {
                                        aVar.d = objArr[3];
                                        if (objArr[4] == null || (objArr[4] instanceof WorkSource)) {
                                            aVar.e = objArr[4];
                                            if (objArr.length != 5) {
                                                if (objArr[5] == null || (objArr[5] instanceof String)) {
                                                    aVar.f = objArr[5];
                                                } else {
                                                    f fVar14 = this.d;
                                                    fVar14.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 5 not String" + objArr[5], new Object[0]);
                                                }
                                            }
                                        } else {
                                            f fVar15 = this.d;
                                            fVar15.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 4 not WorkSource" + objArr[4], new Object[0]);
                                        }
                                    } else {
                                        f fVar16 = this.d;
                                        fVar16.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
                                    }
                                } else {
                                    f fVar17 = this.d;
                                    fVar17.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
                                }
                            }
                        }
                    } else {
                        f fVar18 = this.d;
                        fVar18.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args length invalid" + objArr.length, new Object[0]);
                    }
                } else if (objArr.length != 4) {
                    f fVar19 = this.d;
                    fVar19.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args length invalid :" + objArr.length, new Object[0]);
                } else {
                    aVar = new a((byte) 0);
                    if (objArr[2] == null || (objArr[2] instanceof String)) {
                        aVar.c = objArr[2];
                        if (objArr[3] == null || (objArr[3] instanceof WorkSource)) {
                            aVar.e = objArr[3];
                            if (objArr[0] instanceof Integer) {
                                aVar.b = objArr[0].intValue();
                                if (!(objArr[1] instanceof IBinder)) {
                                    f fVar20 = this.d;
                                    fVar20.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not IBinder:" + objArr[1], new Object[0]);
                                } else {
                                    aVar.a = objArr[1];
                                }
                            } else if (objArr[0] instanceof IBinder) {
                                aVar.a = objArr[0];
                                if (!(objArr[1] instanceof Integer)) {
                                    f fVar21 = this.d;
                                    fVar21.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args idx 1 not Integer:" + objArr[1], new Object[0]);
                                } else {
                                    aVar.b = objArr[1].intValue();
                                }
                            } else {
                                f fVar22 = this.d;
                                fVar22.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer:" + objArr[0], new Object[0]);
                            }
                        } else {
                            f fVar23 = this.d;
                            fVar23.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not WorkSource:" + objArr[3], new Object[0]);
                        }
                    } else {
                        f fVar24 = this.d;
                        fVar24.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String:" + objArr[2], new Object[0]);
                    }
                }
                aVar2 = aVar;
            }
            if (aVar2 == null) {
                this.d.d("BRSDK.PowerHooker dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
                return;
            }
            synchronized (i.class) {
                for (k.a aVar3 : this.a) {
                    if (aVar3 instanceof b) {
                        ((b) aVar3).a(aVar2.a, aVar2.d);
                    }
                }
            }
        } else if (method.getName().equals("releaseWakeLock")) {
            g(objArr);
        }
    }

    private void a(Object[] objArr) {
        a b2 = b(objArr);
        if (b2 == null) {
            this.d.d("BRSDK.PowerHooker dispatchAcquireWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (i.class) {
            for (k.a aVar : this.a) {
                if (aVar instanceof b) {
                    ((b) aVar).a(b2.a, b2.d);
                }
            }
        }
    }

    static final class a {
        IBinder a;
        int b;
        String c;
        String d;
        WorkSource e;
        String f;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class c {
        IBinder a;
        int b;

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    private a b(Object[] objArr) {
        if (objArr == null) {
            this.d.d("BRSDK.PowerHooker createAcquireWakeLockArgs args null", new Object[0]);
            return null;
        }
        int length = objArr.length;
        f fVar = this.d;
        fVar.c("BRSDK.PowerHooker checkAcquireWakeLockArgs: length:" + length, new Object[0]);
        if (length == 4) {
            return f(objArr);
        }
        if (length == 7) {
            return d(objArr);
        }
        if (length != 8) {
            return e(objArr);
        }
        return c(objArr);
    }

    private a c(Object[] objArr) {
        a aVar = new a((byte) 0);
        if (!(objArr[0] instanceof IBinder)) {
            f fVar = this.d;
            fVar.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
            return null;
        }
        aVar.a = objArr[0];
        if (!(objArr[1] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
            return null;
        }
        aVar.b = objArr[1].intValue();
        if (objArr[2] == null || (objArr[2] instanceof String)) {
            aVar.c = objArr[2];
            if (objArr[3] == null || (objArr[3] instanceof String)) {
                aVar.d = objArr[3];
                return aVar;
            }
            f fVar3 = this.d;
            fVar3.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
            return null;
        }
        f fVar4 = this.d;
        fVar4.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
        return null;
    }

    private a d(Object[] objArr) {
        a aVar = new a((byte) 0);
        if (!(objArr[0] instanceof IBinder)) {
            f fVar = this.d;
            fVar.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
            return null;
        }
        aVar.a = objArr[0];
        if (!(objArr[1] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
            return null;
        }
        aVar.b = objArr[1].intValue();
        if (objArr[2] == null || (objArr[2] instanceof String)) {
            aVar.c = objArr[2];
            if (objArr[3] == null || (objArr[3] instanceof String)) {
                aVar.d = objArr[3];
                if (objArr[4] == null || (objArr[4] instanceof WorkSource)) {
                    aVar.e = objArr[4];
                    if (objArr[5] == null || (objArr[5] instanceof String)) {
                        aVar.f = objArr[5];
                        return aVar;
                    }
                    f fVar3 = this.d;
                    fVar3.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 5 not String" + objArr[5], new Object[0]);
                    return null;
                }
                f fVar4 = this.d;
                fVar4.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 4 not WorkSource" + objArr[4], new Object[0]);
                return null;
            }
            f fVar5 = this.d;
            fVar5.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
            return null;
        }
        f fVar6 = this.d;
        fVar6.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
        return null;
    }

    private a e(Object[] objArr) {
        if (objArr.length == 6 || objArr.length == 5) {
            a aVar = new a((byte) 0);
            if (!(objArr[0] instanceof IBinder)) {
                f fVar = this.d;
                fVar.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 0 not IBinder" + objArr[0], new Object[0]);
                return null;
            }
            aVar.a = objArr[0];
            if (!(objArr[1] instanceof Integer)) {
                f fVar2 = this.d;
                fVar2.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not Integer" + objArr[1], new Object[0]);
                return null;
            }
            aVar.b = objArr[1].intValue();
            if (objArr[2] == null || (objArr[2] instanceof String)) {
                aVar.c = objArr[2];
                if (objArr[3] == null || (objArr[3] instanceof String)) {
                    aVar.d = objArr[3];
                    if (objArr[4] == null || (objArr[4] instanceof WorkSource)) {
                        aVar.e = objArr[4];
                        if (objArr.length == 5) {
                            return aVar;
                        }
                        if (objArr[5] == null || (objArr[5] instanceof String)) {
                            aVar.f = objArr[5];
                            return aVar;
                        }
                        f fVar3 = this.d;
                        fVar3.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 5 not String" + objArr[5], new Object[0]);
                        return null;
                    }
                    f fVar4 = this.d;
                    fVar4.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 4 not WorkSource" + objArr[4], new Object[0]);
                    return null;
                }
                f fVar5 = this.d;
                fVar5.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not String" + objArr[3], new Object[0]);
                return null;
            }
            f fVar6 = this.d;
            fVar6.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String" + objArr[2], new Object[0]);
            return null;
        }
        f fVar7 = this.d;
        fVar7.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args length invalid" + objArr.length, new Object[0]);
        return null;
    }

    private a f(Object[] objArr) {
        if (objArr.length != 4) {
            f fVar = this.d;
            fVar.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args length invalid :" + objArr.length, new Object[0]);
            return null;
        }
        a aVar = new a((byte) 0);
        if (objArr[2] == null || (objArr[2] instanceof String)) {
            aVar.c = objArr[2];
            if (objArr[3] == null || (objArr[3] instanceof WorkSource)) {
                aVar.e = objArr[3];
                if (objArr[0] instanceof Integer) {
                    aVar.b = objArr[0].intValue();
                    if (!(objArr[1] instanceof IBinder)) {
                        f fVar2 = this.d;
                        fVar2.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 1 not IBinder:" + objArr[1], new Object[0]);
                        return null;
                    }
                    aVar.a = objArr[1];
                } else if (objArr[0] instanceof IBinder) {
                    aVar.a = objArr[0];
                    if (!(objArr[1] instanceof Integer)) {
                        f fVar3 = this.d;
                        fVar3.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args idx 1 not Integer:" + objArr[1], new Object[0]);
                        return null;
                    }
                    aVar.b = objArr[1].intValue();
                } else {
                    f fVar4 = this.d;
                    fVar4.d("BRSDK.PowerHooker createAcquireWakeLockArgs4 args idx 0 not IBinder an Integer:" + objArr[0], new Object[0]);
                    return null;
                }
                return aVar;
            }
            f fVar5 = this.d;
            fVar5.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 3 not WorkSource:" + objArr[3], new Object[0]);
            return null;
        }
        f fVar6 = this.d;
        fVar6.d("BRSDK.PowerHooker createAcquireWakeLockArgs6 args idx 2 not String:" + objArr[2], new Object[0]);
        return null;
    }

    private c h(Object[] objArr) {
        if (objArr == null) {
            this.d.d("BRSDK.PowerHooker createReleaseWakeLockArgs args null", new Object[0]);
            return null;
        }
        int length = objArr.length;
        f fVar = this.d;
        fVar.c("BRSDK.PowerHooker checkReleaseWakeLockArgs: length:" + length, new Object[0]);
        return i(objArr);
    }

    private c i(Object[] objArr) {
        if (objArr.length != 2) {
            f fVar = this.d;
            fVar.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args length invalid :" + objArr.length, new Object[0]);
            return null;
        }
        c cVar = new c((byte) 0);
        if (!(objArr[0] instanceof IBinder)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args idx 0 not IBinder:" + objArr[0], new Object[0]);
            return null;
        }
        cVar.a = objArr[0];
        if (!(objArr[1] instanceof Integer)) {
            f fVar3 = this.d;
            fVar3.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args idx 1 not Integer:" + objArr[1], new Object[0]);
            return null;
        }
        cVar.b = objArr[1].intValue();
        return cVar;
    }

    public static i a() {
        return d.a;
    }

    static class d {
        /* access modifiers changed from: private */
        public static final i a = new i();

        private d() {
        }
    }

    private void g(Object[] objArr) {
        c cVar = null;
        if (objArr == null) {
            this.d.d("BRSDK.PowerHooker createReleaseWakeLockArgs args null", new Object[0]);
        } else {
            int length = objArr.length;
            f fVar = this.d;
            fVar.c("BRSDK.PowerHooker checkReleaseWakeLockArgs: length:" + length, new Object[0]);
            if (objArr.length != 2) {
                f fVar2 = this.d;
                fVar2.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args length invalid :" + objArr.length, new Object[0]);
            } else {
                c cVar2 = new c((byte) 0);
                if (!(objArr[0] instanceof IBinder)) {
                    f fVar3 = this.d;
                    fVar3.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args idx 0 not IBinder:" + objArr[0], new Object[0]);
                } else {
                    cVar2.a = objArr[0];
                    if (!(objArr[1] instanceof Integer)) {
                        f fVar4 = this.d;
                        fVar4.d("BRSDK.PowerHooker createReleaseWakeLockArgs2 args idx 1 not Integer:" + objArr[1], new Object[0]);
                    } else {
                        cVar2.b = objArr[1].intValue();
                        cVar = cVar2;
                    }
                }
            }
        }
        if (cVar == null) {
            this.d.d("BRSDK.PowerHooker dispatchReleaseWakeLock AcquireWakeLockArgs null", new Object[0]);
            return;
        }
        synchronized (i.class) {
            for (k.a aVar : this.a) {
                if (aVar instanceof b) {
                    ((b) aVar).a(cVar.a);
                }
            }
        }
    }
}
