package com.yanzhenjie.andserver.http;

import java.util.Locale;

public enum HttpMethod {
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");
    
    private String value;

    private HttpMethod(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    /* renamed from: com.yanzhenjie.andserver.http.HttpMethod$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yanzhenjie$andserver$http$HttpMethod = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.yanzhenjie.andserver.http.HttpMethod[] r0 = com.yanzhenjie.andserver.http.HttpMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$yanzhenjie$andserver$http$HttpMethod = r0
                com.yanzhenjie.andserver.http.HttpMethod r1 = com.yanzhenjie.andserver.http.HttpMethod.POST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$yanzhenjie$andserver$http$HttpMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                com.yanzhenjie.andserver.http.HttpMethod r1 = com.yanzhenjie.andserver.http.HttpMethod.PUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$yanzhenjie$andserver$http$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.yanzhenjie.andserver.http.HttpMethod r1 = com.yanzhenjie.andserver.http.HttpMethod.PATCH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$yanzhenjie$andserver$http$HttpMethod     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.yanzhenjie.andserver.http.HttpMethod r1 = com.yanzhenjie.andserver.http.HttpMethod.DELETE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.andserver.http.HttpMethod.AnonymousClass1.<clinit>():void");
        }
    }

    public boolean allowBody() {
        int i = AnonymousClass1.$SwitchMap$com$yanzhenjie$andserver$http$HttpMethod[ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static HttpMethod reverse(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case -531492226:
                if (upperCase.equals("OPTIONS")) {
                    c = 0;
                    break;
                }
                break;
            case 70454:
                if (upperCase.equals("GET")) {
                    c = 1;
                    break;
                }
                break;
            case 79599:
                if (upperCase.equals("PUT")) {
                    c = 2;
                    break;
                }
                break;
            case 2213344:
                if (upperCase.equals("HEAD")) {
                    c = 3;
                    break;
                }
                break;
            case 2461856:
                if (upperCase.equals("POST")) {
                    c = 4;
                    break;
                }
                break;
            case 75900968:
                if (upperCase.equals("PATCH")) {
                    c = 5;
                    break;
                }
                break;
            case 80083237:
                if (upperCase.equals("TRACE")) {
                    c = 6;
                    break;
                }
                break;
            case 2012838315:
                if (upperCase.equals("DELETE")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return OPTIONS;
            case 1:
                return GET;
            case 2:
                return PUT;
            case 3:
                return HEAD;
            case 4:
                return POST;
            case 5:
                return PATCH;
            case 6:
                return TRACE;
            case 7:
                return DELETE;
            default:
                throw new UnsupportedOperationException(String.format("The value %1$s is not supported.", new Object[]{upperCase}));
        }
    }

    public String toString() {
        return this.value;
    }
}
