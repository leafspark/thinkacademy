package com.bonree.sdk.i;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.bonree.sdk.be.f;
import com.bonree.sdk.i.k;
import java.lang.reflect.Method;
import java.util.Iterator;

public class a extends k {
    private static final String c = "BRSDK.AlarmHooker";
    private f d = com.bonree.sdk.be.a.a();

    public interface c extends k.a {
        void a();

        void b();
    }

    public a() {
        this.b = new l("alarm", "android.app.IAlarmManager", new b(this));
    }

    /* access modifiers changed from: protected */
    public final void a(Method method, Object[] objArr) {
        b bVar;
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            b bVar2 = null;
            if (objArr == null) {
                this.d.d("BRSDK.AlarmHooker createAlarmSetBean args null", new Object[0]);
            } else {
                int length = objArr.length;
                f fVar = this.d;
                fVar.c("BRSDK.AlarmHooker createAlarmSetBeanAccordingToArgsLength: length:" + length, new Object[0]);
                if (length != 3) {
                    if (length != 4) {
                        if (length == 6 || length == 7) {
                            if (objArr.length == 7 || objArr.length == 6) {
                                bVar = new b((byte) 0);
                                if (!(objArr[0] instanceof Integer)) {
                                    f fVar2 = this.d;
                                    fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
                                } else {
                                    bVar.a = objArr[0].intValue();
                                    if (!(objArr[1] instanceof Long)) {
                                        f fVar3 = this.d;
                                        fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
                                    } else {
                                        bVar.b = objArr[1].longValue();
                                        if (!(objArr[2] instanceof Long)) {
                                            f fVar4 = this.d;
                                            fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
                                        } else {
                                            bVar.c = objArr[2].longValue();
                                            if (!(objArr[3] instanceof Long)) {
                                                f fVar5 = this.d;
                                                fVar5.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
                                            } else {
                                                bVar.d = objArr[3].longValue();
                                                if (objArr[4] == null || (objArr[4] instanceof PendingIntent)) {
                                                    bVar.f = objArr[4];
                                                } else {
                                                    f fVar6 = this.d;
                                                    fVar6.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not PendingIntent:" + objArr[4], new Object[0]);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                f fVar7 = this.d;
                                fVar7.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
                            }
                        } else if (length != 8) {
                            if (objArr.length != 11) {
                                f fVar8 = this.d;
                                fVar8.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
                            } else {
                                bVar = new b((byte) 0);
                                if (!(objArr[1] instanceof Integer)) {
                                    f fVar9 = this.d;
                                    fVar9.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Integer:" + objArr[1], new Object[0]);
                                } else {
                                    bVar.a = objArr[1].intValue();
                                    if (!(objArr[2] instanceof Long)) {
                                        f fVar10 = this.d;
                                        fVar10.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
                                    } else {
                                        bVar.b = objArr[2].longValue();
                                        if (!(objArr[3] instanceof Long)) {
                                            f fVar11 = this.d;
                                            fVar11.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
                                        } else {
                                            bVar.c = objArr[3].longValue();
                                            if (!(objArr[4] instanceof Long)) {
                                                f fVar12 = this.d;
                                                fVar12.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not Long:" + objArr[4], new Object[0]);
                                            } else {
                                                bVar.d = objArr[4].longValue();
                                                if (!(objArr[5] instanceof Integer)) {
                                                    f fVar13 = this.d;
                                                    fVar13.d("BRSDK.AlarmHooker createAlarmSetBean args idx 5 not Integer:" + objArr[5], new Object[0]);
                                                } else {
                                                    bVar.e = objArr[5].intValue();
                                                    if (objArr[6] == null || (objArr[6] instanceof PendingIntent)) {
                                                        bVar.f = objArr[6];
                                                    } else {
                                                        f fVar14 = this.d;
                                                        fVar14.d("BRSDK.AlarmHooker createAlarmSetBean args idx 6 not PendingIntent:" + objArr[6], new Object[0]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (objArr.length != 8) {
                            f fVar15 = this.d;
                            fVar15.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
                        } else {
                            bVar = new b((byte) 0);
                            if (!(objArr[0] instanceof Integer)) {
                                f fVar16 = this.d;
                                fVar16.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
                            } else {
                                bVar.a = objArr[0].intValue();
                                if (!(objArr[1] instanceof Long)) {
                                    f fVar17 = this.d;
                                    fVar17.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
                                } else {
                                    bVar.b = objArr[1].longValue();
                                    if (!(objArr[2] instanceof Long)) {
                                        f fVar18 = this.d;
                                        fVar18.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
                                    } else {
                                        bVar.c = objArr[2].longValue();
                                        if (!(objArr[3] instanceof Long)) {
                                            f fVar19 = this.d;
                                            fVar19.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
                                        } else {
                                            bVar.d = objArr[3].longValue();
                                            if (!(objArr[4] instanceof Integer)) {
                                                f fVar20 = this.d;
                                                fVar20.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not Integer:" + objArr[4], new Object[0]);
                                            } else {
                                                bVar.e = objArr[4].intValue();
                                                if (objArr[5] == null || (objArr[5] instanceof PendingIntent)) {
                                                    bVar.f = objArr[5];
                                                } else {
                                                    f fVar21 = this.d;
                                                    fVar21.d("BRSDK.AlarmHooker createAlarmSetBean args idx 5 not PendingIntent:" + objArr[5], new Object[0]);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (objArr.length != 4) {
                        f fVar22 = this.d;
                        fVar22.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
                    } else {
                        bVar = new b((byte) 0);
                        if (!(objArr[0] instanceof Integer)) {
                            f fVar23 = this.d;
                            fVar23.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
                        } else {
                            bVar.a = objArr[0].intValue();
                            if (!(objArr[1] instanceof Long)) {
                                f fVar24 = this.d;
                                fVar24.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
                            } else {
                                bVar.b = objArr[1].longValue();
                                if (!(objArr[2] instanceof Long)) {
                                    f fVar25 = this.d;
                                    fVar25.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
                                } else {
                                    bVar.d = objArr[2].longValue();
                                    if (objArr[3] == null || (objArr[3] instanceof PendingIntent)) {
                                        bVar.f = objArr[3];
                                    } else {
                                        f fVar26 = this.d;
                                        fVar26.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not PendingIntent:" + objArr[3], new Object[0]);
                                    }
                                }
                            }
                        }
                    }
                } else if (objArr.length != 3) {
                    f fVar27 = this.d;
                    fVar27.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
                } else {
                    bVar = new b((byte) 0);
                    if (!(objArr[0] instanceof Integer)) {
                        f fVar28 = this.d;
                        fVar28.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
                    } else {
                        bVar.a = objArr[0].intValue();
                        if (!(objArr[1] instanceof Long)) {
                            f fVar29 = this.d;
                            fVar29.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
                        } else {
                            bVar.b = objArr[1].longValue();
                            if (objArr[2] == null || (objArr[2] instanceof PendingIntent)) {
                                bVar.f = objArr[2];
                            } else {
                                f fVar30 = this.d;
                                fVar30.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not PendingIntent:" + objArr[2], new Object[0]);
                            }
                        }
                    }
                }
                bVar2 = bVar;
            }
            if (bVar2 == null) {
                this.d.d("BRSDK.AlarmHooker dispatchSet AlarmSetBean null", new Object[0]);
                return;
            }
            synchronized (a.class) {
                for (k.a aVar : this.a) {
                    if (aVar instanceof c) {
                        ((c) aVar).a();
                    }
                }
            }
        } else if (method.getName().equals("remove")) {
            b(objArr);
        }
    }

    private void a(Object[] objArr) {
        if (c(objArr) == null) {
            this.d.d("BRSDK.AlarmHooker dispatchSet AlarmSetBean null", new Object[0]);
            return;
        }
        synchronized (a.class) {
            for (k.a aVar : this.a) {
                if (aVar instanceof c) {
                    ((c) aVar).a();
                }
            }
        }
    }

    /* renamed from: com.bonree.sdk.i.a$a  reason: collision with other inner class name */
    static final class C0021a {
        PendingIntent a;
        AlarmManager.OnAlarmListener b;

        private C0021a() {
        }

        /* synthetic */ C0021a(byte b2) {
            this();
        }
    }

    static final class b {
        int a;
        long b;
        long c;
        long d;
        int e;
        PendingIntent f;
        AlarmManager.OnAlarmListener g;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    private b c(Object[] objArr) {
        if (objArr == null) {
            this.d.d("BRSDK.AlarmHooker createAlarmSetBean args null", new Object[0]);
            return null;
        }
        int length = objArr.length;
        f fVar = this.d;
        fVar.c("BRSDK.AlarmHooker createAlarmSetBeanAccordingToArgsLength: length:" + length, new Object[0]);
        if (length == 3) {
            return h(objArr);
        }
        if (length == 4) {
            return g(objArr);
        }
        if (length == 6 || length == 7) {
            return f(objArr);
        }
        if (length != 8) {
            return d(objArr);
        }
        return e(objArr);
    }

    private b d(Object[] objArr) {
        if (objArr.length != 11) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        b bVar = new b((byte) 0);
        if (!(objArr[1] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Integer:" + objArr[1], new Object[0]);
            return null;
        }
        bVar.a = objArr[1].intValue();
        if (!(objArr[2] instanceof Long)) {
            f fVar3 = this.d;
            fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
            return null;
        }
        bVar.b = objArr[2].longValue();
        if (!(objArr[3] instanceof Long)) {
            f fVar4 = this.d;
            fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
            return null;
        }
        bVar.c = objArr[3].longValue();
        if (!(objArr[4] instanceof Long)) {
            f fVar5 = this.d;
            fVar5.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not Long:" + objArr[4], new Object[0]);
            return null;
        }
        bVar.d = objArr[4].longValue();
        if (!(objArr[5] instanceof Integer)) {
            f fVar6 = this.d;
            fVar6.d("BRSDK.AlarmHooker createAlarmSetBean args idx 5 not Integer:" + objArr[5], new Object[0]);
            return null;
        }
        bVar.e = objArr[5].intValue();
        if (objArr[6] == null || (objArr[6] instanceof PendingIntent)) {
            bVar.f = objArr[6];
            return bVar;
        }
        f fVar7 = this.d;
        fVar7.d("BRSDK.AlarmHooker createAlarmSetBean args idx 6 not PendingIntent:" + objArr[6], new Object[0]);
        return null;
    }

    private b e(Object[] objArr) {
        if (objArr.length != 8) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        b bVar = new b((byte) 0);
        if (!(objArr[0] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
            return null;
        }
        bVar.a = objArr[0].intValue();
        if (!(objArr[1] instanceof Long)) {
            f fVar3 = this.d;
            fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
            return null;
        }
        bVar.b = objArr[1].longValue();
        if (!(objArr[2] instanceof Long)) {
            f fVar4 = this.d;
            fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
            return null;
        }
        bVar.c = objArr[2].longValue();
        if (!(objArr[3] instanceof Long)) {
            f fVar5 = this.d;
            fVar5.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
            return null;
        }
        bVar.d = objArr[3].longValue();
        if (!(objArr[4] instanceof Integer)) {
            f fVar6 = this.d;
            fVar6.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not Integer:" + objArr[4], new Object[0]);
            return null;
        }
        bVar.e = objArr[4].intValue();
        if (objArr[5] == null || (objArr[5] instanceof PendingIntent)) {
            bVar.f = objArr[5];
            return bVar;
        }
        f fVar7 = this.d;
        fVar7.d("BRSDK.AlarmHooker createAlarmSetBean args idx 5 not PendingIntent:" + objArr[5], new Object[0]);
        return null;
    }

    private b f(Object[] objArr) {
        if (objArr.length == 7 || objArr.length == 6) {
            b bVar = new b((byte) 0);
            if (!(objArr[0] instanceof Integer)) {
                f fVar = this.d;
                fVar.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
                return null;
            }
            bVar.a = objArr[0].intValue();
            if (!(objArr[1] instanceof Long)) {
                f fVar2 = this.d;
                fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
                return null;
            }
            bVar.b = objArr[1].longValue();
            if (!(objArr[2] instanceof Long)) {
                f fVar3 = this.d;
                fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
                return null;
            }
            bVar.c = objArr[2].longValue();
            if (!(objArr[3] instanceof Long)) {
                f fVar4 = this.d;
                fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not Long:" + objArr[3], new Object[0]);
                return null;
            }
            bVar.d = objArr[3].longValue();
            if (objArr[4] == null || (objArr[4] instanceof PendingIntent)) {
                bVar.f = objArr[4];
                return bVar;
            }
            f fVar5 = this.d;
            fVar5.d("BRSDK.AlarmHooker createAlarmSetBean args idx 4 not PendingIntent:" + objArr[4], new Object[0]);
            return null;
        }
        f fVar6 = this.d;
        fVar6.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
        return null;
    }

    private b g(Object[] objArr) {
        if (objArr.length != 4) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        b bVar = new b((byte) 0);
        if (!(objArr[0] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
            return null;
        }
        bVar.a = objArr[0].intValue();
        if (!(objArr[1] instanceof Long)) {
            f fVar3 = this.d;
            fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
            return null;
        }
        bVar.b = objArr[1].longValue();
        if (!(objArr[2] instanceof Long)) {
            f fVar4 = this.d;
            fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not Long:" + objArr[2], new Object[0]);
            return null;
        }
        bVar.d = objArr[2].longValue();
        if (objArr[3] == null || (objArr[3] instanceof PendingIntent)) {
            bVar.f = objArr[3];
            return bVar;
        }
        f fVar5 = this.d;
        fVar5.d("BRSDK.AlarmHooker createAlarmSetBean args idx 3 not PendingIntent:" + objArr[3], new Object[0]);
        return null;
    }

    private b h(Object[] objArr) {
        if (objArr.length != 3) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createAlarmSetBean args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        b bVar = new b((byte) 0);
        if (!(objArr[0] instanceof Integer)) {
            f fVar2 = this.d;
            fVar2.d("BRSDK.AlarmHooker createAlarmSetBean args idx 0 not Integer:" + objArr[0], new Object[0]);
            return null;
        }
        bVar.a = objArr[0].intValue();
        if (!(objArr[1] instanceof Long)) {
            f fVar3 = this.d;
            fVar3.d("BRSDK.AlarmHooker createAlarmSetBean args idx 1 not Long:" + objArr[1], new Object[0]);
            return null;
        }
        bVar.b = objArr[1].longValue();
        if (objArr[2] == null || (objArr[2] instanceof PendingIntent)) {
            bVar.f = objArr[2];
            return bVar;
        }
        f fVar4 = this.d;
        fVar4.d("BRSDK.AlarmHooker createAlarmSetBean args idx 2 not PendingIntent:" + objArr[2], new Object[0]);
        return null;
    }

    private C0021a i(Object[] objArr) {
        if (objArr == null) {
            this.d.d("BRSDK.AlarmHooker createCancelArgs args null", new Object[0]);
            return null;
        }
        int length = objArr.length;
        f fVar = this.d;
        fVar.c("BRSDK.AlarmHooker createCancelArgsAccordingToArgsLength: length:" + length, new Object[0]);
        if (length != 1) {
            return j(objArr);
        }
        return k(objArr);
    }

    private C0021a j(Object[] objArr) {
        if (objArr.length != 2) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createCancelArgs2 args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        C0021a aVar = new C0021a((byte) 0);
        if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
            aVar.a = objArr[0];
            return aVar;
        }
        f fVar2 = this.d;
        fVar2.d("BRSDK.AlarmHooker createCancelArgs2 args idx 0 not PendingIntent:" + objArr[0], new Object[0]);
        return null;
    }

    private C0021a k(Object[] objArr) {
        if (objArr.length != 1) {
            f fVar = this.d;
            fVar.d("BRSDK.AlarmHooker createCancelArgs1 args length invalid:" + objArr.length, new Object[0]);
            return null;
        }
        C0021a aVar = new C0021a((byte) 0);
        if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
            aVar.a = objArr[0];
            return aVar;
        }
        f fVar2 = this.d;
        fVar2.d("BRSDK.AlarmHooker createCancelArgs1 args idx 0 not PendingIntent:" + objArr[0], new Object[0]);
        return null;
    }

    public static a a() {
        return d.a;
    }

    static class d {
        /* access modifiers changed from: private */
        public static final a a = new a();

        private d() {
        }
    }

    private void b(Object[] objArr) {
        C0021a aVar;
        C0021a aVar2 = null;
        if (objArr == null) {
            this.d.d("BRSDK.AlarmHooker createCancelArgs args null", new Object[0]);
        } else {
            int length = objArr.length;
            f fVar = this.d;
            fVar.c("BRSDK.AlarmHooker createCancelArgsAccordingToArgsLength: length:" + length, new Object[0]);
            if (length != 1) {
                if (objArr.length != 2) {
                    f fVar2 = this.d;
                    fVar2.d("BRSDK.AlarmHooker createCancelArgs2 args length invalid:" + objArr.length, new Object[0]);
                } else {
                    aVar = new C0021a((byte) 0);
                    if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
                        aVar.a = objArr[0];
                    } else {
                        f fVar3 = this.d;
                        fVar3.d("BRSDK.AlarmHooker createCancelArgs2 args idx 0 not PendingIntent:" + objArr[0], new Object[0]);
                    }
                }
            } else if (objArr.length != 1) {
                f fVar4 = this.d;
                fVar4.d("BRSDK.AlarmHooker createCancelArgs1 args length invalid:" + objArr.length, new Object[0]);
            } else {
                aVar = new C0021a((byte) 0);
                if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
                    aVar.a = objArr[0];
                } else {
                    f fVar5 = this.d;
                    fVar5.d("BRSDK.AlarmHooker createCancelArgs1 args idx 0 not PendingIntent:" + objArr[0], new Object[0]);
                }
            }
            aVar2 = aVar;
        }
        if (aVar2 == null) {
            this.d.d("BRSDK.AlarmHooker dispatchCancel cancelArgs null", new Object[0]);
            return;
        }
        synchronized (a.class) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
