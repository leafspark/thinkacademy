package atd.a0;

import atd.e.c;

public final class a extends Exception {
    private final c a;

    public a(String str, c cVar) {
        super(str);
        this.a = cVar;
    }

    public String a() {
        String str;
        String message = getMessage();
        Throwable cause = getCause();
        if (cause != null) {
            str = atd.s0.a.a(-799914847955520L) + cause.getMessage();
        } else {
            str = atd.s0.a.a(-799940617759296L);
        }
        return message + str;
    }

    public c b() {
        return this.a;
    }

    public a(String str, Throwable th, c cVar) {
        super(str, th);
        this.a = cVar;
    }
}
