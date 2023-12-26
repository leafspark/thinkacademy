package atd.n0;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import atd.s0.a;

public final class b implements LayoutInflater.Factory2 {
    private static final String[] c = {a.a(-842808686340672L), a.a(-842851636013632L), a.a(-843195233397312L), a.a(-843263952874048L)};
    private final Window a;
    private final a b;

    public b(Window window, a aVar) {
        this.a = window;
        this.b = aVar;
        aVar.a(window);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        LayoutInflater layoutInflater = this.a.getLayoutInflater();
        View view2 = null;
        if (str.contains(a.a(-843723514374720L))) {
            try {
                view2 = layoutInflater.createView(str, (String) null, attributeSet);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(a.a(-842924650457664L) + str + a.a(-842787211504192L), e);
            } catch (InflateException unused) {
            }
        } else {
            String[] strArr = c;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                try {
                    view2 = layoutInflater.createView(str, strArr[i], attributeSet);
                    if (view2 != null) {
                        break;
                    }
                    i++;
                } catch (InflateException | ClassNotFoundException unused2) {
                }
            }
        }
        if (view2 != null) {
            this.b.a(view2, attributeSet);
        }
        return view2;
    }
}
