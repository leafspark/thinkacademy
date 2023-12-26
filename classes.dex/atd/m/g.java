package atd.m;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import atd.i.c;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Tasks;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class g {
    private Location a;

    private abstract class b extends atd.i.d {
        private b(g gVar) {
        }

        /* access modifiers changed from: protected */
        public List<String> b() {
            return Collections.singletonList(atd.s0.a.a(-72678100494912L));
        }
    }

    static final class c implements f {
        c() {
        }

        public Location a(Context context) {
            try {
                return (Location) Tasks.await(LocationServices.getFusedLocationProviderClient(context).getLastLocation(), 500, TimeUnit.MILLISECONDS);
            } catch (NoClassDefFoundError unused) {
                return null;
            } catch (InterruptedException unused2) {
                atd.s0.a.a(-72875668990528L);
                return null;
            } catch (ExecutionException unused3) {
                atd.s0.a.a(-72235718863424L);
                return null;
            } catch (TimeoutException unused4) {
                atd.s0.a.a(-72519186704960L);
                return null;
            }
        }
    }

    static final class d implements f {
        d() {
        }

        public Location a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(atd.s0.a.a(-72420402457152L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(atd.s0.a.a(-71625833507392L));
            }
            return null;
        }
    }

    private final class e extends b {
        e() {
            super();
        }

        public String a() {
            return atd.s0.a.a(-71643013376576L);
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Double c(Context context) throws atd.i.c {
            return Double.valueOf(g.this.a(context).getLatitude());
        }
    }

    private interface f {
        Location a(Context context);
    }

    /* renamed from: atd.m.g$g  reason: collision with other inner class name */
    private final class C0003g extends b {
        C0003g() {
            super();
        }

        public String a() {
            return atd.s0.a.a(-71690258016832L);
        }

        /* renamed from: d */
        public Double c(Context context) throws atd.i.c {
            return Double.valueOf(g.this.a(context).getLongitude());
        }
    }

    static final class h implements f {
        h() {
        }

        public Location a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(atd.s0.a.a(-71703142918720L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(atd.s0.a.a(-71733207689792L));
            }
            return null;
        }
    }

    static final class i implements f {
        i() {
        }

        public Location a(Context context) {
            LocationManager locationManager = (LocationManager) context.getSystemService(atd.s0.a.a(-71492689521216L));
            if (locationManager != null) {
                return locationManager.getLastKnownLocation(atd.s0.a.a(-71522754292288L));
            }
            return null;
        }
    }

    private List<f> b() {
        return Arrays.asList(new f[]{new c(), new d(), new h(), new i()});
    }

    public Collection<? extends atd.i.b> a() {
        return Arrays.asList(new b[]{new e(), new C0003g()});
    }

    /* access modifiers changed from: package-private */
    public synchronized Location a(Context context) throws atd.i.c {
        Location location = this.a;
        if (location != null) {
            return location;
        }
        for (f a2 : b()) {
            Location a3 = a2.a(context);
            this.a = a3;
            if (a3 != null) {
                return a3;
            }
        }
        throw new atd.i.c(c.a.UNSUPPORTED_BY_PLATFORM_OR_DEPRECATED, (Throwable) null);
    }
}
