package com.eaydu.omni.jwt;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

class JWTPayload {
    final List<String> aud;
    final Date exp;
    final Date iat;
    final String iss;
    final String jti;
    final Date nbf;
    final String sub;
    final Map<String, Claim> tree;

    JWTPayload(String str, String str2, Date date, Date date2, Date date3, String str3, List<String> list, Map<String, Claim> map) {
        this.iss = str;
        this.sub = str2;
        this.exp = date;
        this.nbf = date2;
        this.iat = date3;
        this.jti = str3;
        this.aud = list;
        this.tree = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public Claim claimForName(String str) {
        Claim claim = this.tree.get(str);
        return claim != null ? claim : new BaseClaim();
    }
}
