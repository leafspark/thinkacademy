package atd.m0;

import android.content.Context;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Debug;
import atd.r0.e;
import atd.s0.a;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public final class g implements a, b, c, f, d {
    static {
        a.a(-844341989665344L);
        a.a(-844170190973504L);
    }

    private boolean c() {
        String str = Build.TAGS;
        return str != null && str.contains(a.a(-776352657369664L));
    }

    private boolean d() {
        for (File exists : e()) {
            if (exists.exists()) {
                return true;
            }
        }
        return false;
    }

    private List<File> e() {
        return Arrays.asList(new File[]{new File(a(a.a(-776378427173440L))), new File(a(a.a(-775978995214912L))), new File(a(a.a(-775841556261440L))), new File(a(a.a(-776060599593536L))), new File(a(a.a(-775201606134336L))), new File(a(a.a(-775510843779648L))), new File(a(a.a(-774707684895296L))), new File(a(a.a(-774969677900352L))), new File(a(a.a(-774535886203456L))), new File(a(a.a(-844024162085440L)))});
    }

    public boolean a() {
        return Build.FINGERPRINT.startsWith(a.a(-777301845142080L)) || Build.FINGERPRINT.startsWith(a.a(-777336204880448L)) || Build.MODEL.contains(a.a(-777095686711872L)) || Build.MODEL.contains(a.a(-777125751482944L)) || Build.MODEL.contains(a.a(-776395607042624L)) || Build.MANUFACTURER.contains(a.a(-776451441617472L)) || (Build.BRAND.startsWith(a.a(-776507276192320L)) && Build.DEVICE.startsWith(a.a(-776266758023744L))) || a.a(-776301117762112L).equals(Build.PRODUCT);
    }

    public boolean b(Context context) {
        return b() || Debug.isDebuggerConnected() || (context.getApplicationInfo().flags & 2) != 0;
    }

    public boolean b(Context context, Collection<String> collection) {
        return false;
    }

    private boolean b() {
        try {
            throw new Exception(a.a(-776356952336960L));
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                for (String startsWith : e.a()) {
                    if (stackTraceElement.getClassName().startsWith(startsWith)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private String b(String str) {
        return str.replaceAll(a(a.a(-844299039992384L)), a.a(-844333399730752L)).toLowerCase(Locale.US);
    }

    public boolean a(Context context) {
        return b() || c() || d();
    }

    public boolean a(Context context, String str) {
        Signature[] a;
        if (str == null || (a = e.a(context)) == null) {
            return false;
        }
        return a(a, str);
    }

    public boolean a(Context context, Collection<String> collection) {
        HashSet hashSet = collection != null ? new HashSet(collection) : new HashSet();
        hashSet.addAll(h.a());
        return e.a(context, hashSet);
    }

    public boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    private boolean a(Signature[] signatureArr, String str) {
        for (Signature a : signatureArr) {
            if (a(a, str)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Signature signature, String str) {
        String b = b(str);
        try {
            MessageDigest instance = MessageDigest.getInstance(a(a.a(-843921082870336L)));
            instance.update(signature.toByteArray());
            return a(instance.digest()).equals(b);
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    private String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte valueOf : bArr) {
            sb.append(String.format(a.a(-844329104763456L), new Object[]{Byte.valueOf(valueOf)}));
        }
        return sb.toString();
    }

    private String a(String str) {
        return atd.r0.g.a(str);
    }
}
