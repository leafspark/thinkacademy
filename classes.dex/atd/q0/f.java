package atd.q0;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import atd.d.o;
import atd.d.p;
import com.adyen.threeds2.R;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class f extends d<o, atd.p0.d> implements View.OnClickListener {
    private final Set<p> m;
    private final ListView n;
    private final Button o;

    class a extends e {
        a(List list) {
            super(f.this, list);
        }

        /* access modifiers changed from: package-private */
        public h a(ViewGroup viewGroup) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            int i = R.layout.a3ds2_view_single_select_item;
            return new g(!(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false));
        }
    }

    class b extends e {
        b(List list) {
            super(f.this, list);
        }

        /* access modifiers changed from: package-private */
        public h a(ViewGroup viewGroup) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            int i = R.layout.a3ds2_view_multi_select_item;
            return new d(!(from instanceof LayoutInflater) ? from.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(from, i, viewGroup, false));
        }
    }

    static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.b[] r0 = atd.e.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.e.b r1 = atd.e.b.SINGLE_SELECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.b r1 = atd.e.b.MULTI_SELECT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: atd.q0.f.c.<clinit>():void");
        }
    }

    final class d extends h {
        d(View view) {
            super(view);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            p pVar = (p) compoundButton.getTag();
            if (z) {
                f.this.a(pVar);
            } else {
                f.this.d(pVar);
            }
        }

        public void onClick(View view) {
            CompoundButton compoundButton = this.c;
            compoundButton.setChecked(!compoundButton.isChecked());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private abstract class e extends BaseAdapter {
        private final List<p> a;

        e(f fVar, List<p> list) {
            this.a = list;
        }

        /* renamed from: a */
        public p getItem(int i) {
            return this.a.get(i);
        }

        /* access modifiers changed from: package-private */
        public abstract h a(ViewGroup viewGroup);

        public int getCount() {
            return this.a.size();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            h a2 = a(viewGroup);
            a2.a(getItem(i));
            return a2.a;
        }
    }

    /* renamed from: atd.q0.f$f  reason: collision with other inner class name */
    private static final class C0006f extends View.BaseSavedState {
        public static final Parcelable.Creator<C0006f> CREATOR = new a();
        private Set<p> a = new LinkedHashSet();

        /* renamed from: atd.q0.f$f$a */
        static class a implements Parcelable.Creator<C0006f> {
            a() {
            }

            /* renamed from: a */
            public C0006f createFromParcel(Parcel parcel) {
                return new C0006f(parcel);
            }

            /* renamed from: a */
            public C0006f[] newArray(int i) {
                return new C0006f[i];
            }
        }

        C0006f(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: package-private */
        public Set<p> a() {
            return this.a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelableArray((p[]) this.a.toArray(new p[0]), i);
        }

        /* access modifiers changed from: package-private */
        public void a(Set<p> set) {
            this.a = set;
        }

        C0006f(Parcel parcel) {
            super(parcel);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(p.class.getClassLoader());
            if (readParcelableArray != null) {
                for (Parcelable parcelable : readParcelableArray) {
                    this.a.add((p) parcelable);
                }
            }
        }
    }

    final class g extends h {
        g(View view) {
            super(view);
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                p pVar = (p) compoundButton.getTag();
                f.this.b();
                f.this.a(pVar);
                f.this.c();
                f.this.b(pVar);
            }
        }

        public void onClick(View view) {
            if (!this.c.isChecked()) {
                this.c.setChecked(true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private abstract class h implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        final View a;
        final TextView b;
        final CompoundButton c;

        h(View view) {
            this.a = view;
            view.setOnClickListener(this);
            this.b = (TextView) view.findViewById(R.id.textView_value);
            CompoundButton compoundButton = (CompoundButton) view.findViewById(R.id.checkBox_selected);
            this.c = compoundButton;
            compoundButton.setOnCheckedChangeListener(this);
        }

        /* access modifiers changed from: package-private */
        public void a(p pVar) {
            this.b.setText(pVar.b());
            this.c.setTag(pVar);
            this.c.setChecked(f.this.c(pVar));
        }
    }

    public f(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setState(C0006f fVar) {
        b();
        for (p a2 : fVar.a()) {
            a(a2);
        }
        c();
        for (p b2 : this.m) {
            b(b2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(o oVar) {
        int i = c.a[oVar.a().ordinal()];
        if (i == 1) {
            c(oVar);
        } else if (i == 2) {
            b(oVar);
        } else {
            throw new RuntimeException(atd.s0.a.a(-840875951057472L) + oVar.a());
        }
        this.o.setText(oVar.n());
        this.o.setOnClickListener(this);
    }

    /* access modifiers changed from: package-private */
    public boolean c(p pVar) {
        return this.m.contains(pVar);
    }

    /* access modifiers changed from: package-private */
    public void d(p pVar) {
        this.m.remove(pVar);
    }

    /* access modifiers changed from: protected */
    public int getChallengeLayoutId() {
        return R.layout.a3ds2_view_challenge_select;
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, f.class);
        super.onClick(view);
        if (getChallengeListener() != null && view.equals(this.o)) {
            this.o.setEnabled(false);
            List<String> a2 = a(this.m);
            if (a2.isEmpty()) {
                ((atd.p0.d) getChallengeListener()).b();
            } else {
                ((atd.p0.d) getChallengeListener()).a(a2, getWhitelistStatus());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        setState((C0006f) parcelable);
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C0006f fVar = new C0006f(super.onSaveInstanceState());
        fVar.a(this.m);
        return fVar;
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.m.clear();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        for (int i = 0; i < this.n.getChildCount(); i++) {
            CompoundButton compoundButton = (CompoundButton) ((ViewGroup) this.n.getChildAt(i)).findViewById(R.id.checkBox_selected);
            if (compoundButton.isChecked()) {
                compoundButton.setChecked(false);
            }
        }
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new LinkedHashSet();
        setId(R.id.selectChallengeView);
        this.n = (ListView) findViewById(R.id.listView_selectInfoItems);
        this.o = (Button) findViewById(R.id.button_next);
    }

    /* access modifiers changed from: package-private */
    public void b(p pVar) {
        for (int i = 0; i < this.n.getChildCount(); i++) {
            CompoundButton compoundButton = (CompoundButton) ((ViewGroup) this.n.getChildAt(i)).findViewById(R.id.checkBox_selected);
            if (compoundButton.getTag().equals(pVar)) {
                compoundButton.setChecked(true);
            }
        }
    }

    private void c(o oVar) {
        List<p> o2 = oVar.o();
        b();
        a(o2.get(0));
        this.n.setAdapter(new a(o2));
    }

    private void b(o oVar) {
        List<p> o2 = oVar.o();
        b();
        this.n.setAdapter(new b(o2));
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar) {
        this.m.add(pVar);
    }

    private List<String> a(Set<p> set) {
        ArrayList arrayList = new ArrayList();
        for (p a2 : set) {
            arrayList.add(a2.a());
        }
        return arrayList;
    }
}
