package atd.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import atd.a.i;
import atd.d.g;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class h extends a {
    public static final h d = new h();
    private static final Executor e = Executors.newFixedThreadPool(2);

    class a implements Runnable {
        final /* synthetic */ Uri a;
        final /* synthetic */ WeakReference b;

        /* renamed from: atd.a.h$a$a  reason: collision with other inner class name */
        class C0000a implements Runnable {
            final /* synthetic */ ImageView a;
            final /* synthetic */ Bitmap b;

            C0000a(a aVar, ImageView imageView, Bitmap bitmap) {
                this.a = imageView;
                this.b = bitmap;
            }

            public void run() {
                this.a.setImageBitmap(this.b);
            }
        }

        a(Uri uri, WeakReference weakReference) {
            this.a = uri;
            this.b = weakReference;
        }

        public void run() {
            try {
                byte[] a2 = h.this.a(new i.a().a(this.a.toString()).b().a()).a();
                ImageView imageView = (ImageView) this.b.get();
                if (imageView != null && imageView.getTag().equals(this.a)) {
                    imageView.post(new C0000a(this, imageView, BitmapFactoryInstrumentation.decodeByteArray(a2, 0, a2.length)));
                }
            } catch (IOException unused) {
            }
        }
    }

    private h() {
    }

    public void a(ImageView imageView, g gVar) {
        if (imageView != null && gVar != null) {
            int i = Resources.getSystem().getDisplayMetrics().densityDpi;
            if (i > 320) {
                a(imageView, gVar.a(), gVar.b(), gVar.c());
            } else if (i > 240) {
                a(imageView, gVar.b(), gVar.c(), gVar.a());
            } else {
                a(imageView, gVar.c(), gVar.b(), gVar.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public int b() {
        return a.c;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return a.b;
    }

    private void a(ImageView imageView, Uri... uriArr) {
        for (Uri uri : uriArr) {
            if (uri != null) {
                a((WeakReference<ImageView>) new WeakReference(imageView), uri);
                return;
            }
        }
    }

    private void a(WeakReference<ImageView> weakReference, Uri uri) {
        try {
            ((ImageView) weakReference.get()).setTag(uri);
            e.execute(new a(uri, weakReference));
        } catch (NullPointerException unused) {
        }
    }
}
