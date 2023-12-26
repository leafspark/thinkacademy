package org.libpag;

import android.content.res.AssetManager;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.httpcore.HttpStatus;
import org.xmlpull.v1.XmlPullParser;
import tv.danmaku.ijk.media.psplayer.PSMediaPlayer;

public class PAGFont {
    private static final Pattern a = Pattern.compile("^[ \\n\\r\\t]+|[ \\n\\r\\t]+$");
    private static boolean b = false;
    public String fontFamily;
    public String fontStyle;

    private static class b {
        String a;
        String b;
        int c;
        int d;

        private b() {
            this.a = "";
            this.b = "";
            this.c = 0;
            this.d = HttpStatus.SC_BAD_REQUEST;
        }
    }

    static {
        org.extra.tools.a.b("pag");
    }

    public PAGFont() {
        this.fontFamily = "";
        this.fontStyle = "";
    }

    private static void RegisterFallbackFonts() {
        if (!b) {
            b = true;
            int i = 0;
            b[] bVarArr = new b[0];
            if (new File("/system/etc/fonts.xml").exists()) {
                try {
                    bVarArr = b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    bVarArr = a();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            b a2 = a(bVarArr, "zh-Hans");
            if (a2 != null) {
                a(a2, arrayList, arrayList2);
            }
            for (b a3 : bVarArr) {
                a(a3, arrayList, arrayList2);
            }
            if (!arrayList.isEmpty()) {
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                int[] iArr = new int[arrayList2.size()];
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    iArr[i] = ((Integer) it.next()).intValue();
                    i++;
                }
                SetFallbackFontPaths(strArr, iArr);
            }
        }
    }

    public static native PAGFont RegisterFont(AssetManager assetManager, String str, int i, String str2, String str3);

    public static PAGFont RegisterFont(String str) {
        return RegisterFont(str, 0);
    }

    public static native PAGFont RegisterFont(String str, int i, String str2, String str3);

    private static native PAGFont RegisterFontBytes(byte[] bArr, int i, int i2, String str, String str2);

    private static native void SetFallbackFontPaths(String[] strArr, int[] iArr);

    private static native void UnregisterFont(String str, String str2);

    public static void UnregisterFont(PAGFont pAGFont) {
        UnregisterFont(pAGFont.fontFamily, pAGFont.fontStyle);
    }

    private static b[] a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, (String) null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(PSMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    a(xmlPullParser, arrayList);
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    private static b c(XmlPullParser xmlPullParser) {
        int i;
        int i2;
        b bVar = new b();
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "index");
        if (attributeValue == null) {
            i = 0;
        } else {
            i = Integer.parseInt(attributeValue);
        }
        bVar.c = i;
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "weight");
        if (attributeValue2 == null) {
            i2 = HttpStatus.SC_BAD_REQUEST;
        } else {
            i2 = Integer.parseInt(attributeValue2);
        }
        bVar.d = i2;
        StringBuilder sb = new StringBuilder();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 4) {
                sb.append(xmlPullParser.getText());
            }
            if (xmlPullParser.getEventType() == 2) {
                d(xmlPullParser);
            }
        }
        bVar.b = "/system/fonts/" + a.matcher(sb).replaceAll("");
        return bVar;
    }

    private static void d(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str) {
        return RegisterFont(assetManager, str, 0);
    }

    public static PAGFont RegisterFont(AssetManager assetManager, String str, int i) {
        return RegisterFont(assetManager, str, i, "", "");
    }

    private static b[] b() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, (String) null);
                newPullParser.nextTag();
                return a(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    public static PAGFont RegisterFont(String str, int i) {
        return RegisterFont(str, i, "", "");
    }

    private static b[] b(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        xmlPullParser.require(2, (String) null, "familyset");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals(PSMediaPlayer.OnNativeInvokeListener.ARG_FAMILIY)) {
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("fileset")) {
                                b(xmlPullParser, arrayList);
                            } else {
                                d(xmlPullParser);
                            }
                        }
                    }
                } else {
                    d(xmlPullParser);
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return bVarArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: org.libpag.PAGFont$b} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(org.xmlpull.v1.XmlPullParser r6, java.util.ArrayList r7) {
        /*
            r0 = 0
            java.lang.String r1 = "name"
            r6.getAttributeValue(r0, r1)
            java.lang.String r1 = "lang"
            java.lang.String r1 = r6.getAttributeValue(r0, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0011:
            int r3 = r6.next()
            r4 = 3
            if (r3 == r4) goto L_0x0038
            int r3 = r6.getEventType()
            r4 = 2
            if (r3 == r4) goto L_0x0020
            goto L_0x0011
        L_0x0020:
            java.lang.String r3 = r6.getName()
            java.lang.String r4 = "font"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0034
            org.libpag.PAGFont$b r3 = c(r6)
            r2.add(r3)
            goto L_0x0011
        L_0x0034:
            d(r6)
            goto L_0x0011
        L_0x0038:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x003f
            return
        L_0x003f:
            java.util.Iterator r6 = r2.iterator()
        L_0x0043:
            boolean r3 = r6.hasNext()
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r6.next()
            org.libpag.PAGFont$b r3 = (org.libpag.PAGFont.b) r3
            int r4 = r3.d
            r5 = 400(0x190, float:5.6E-43)
            if (r4 != r5) goto L_0x0043
            r0 = r3
        L_0x0056:
            if (r0 != 0) goto L_0x0060
            r6 = 0
            java.lang.Object r6 = r2.get(r6)
            r0 = r6
            org.libpag.PAGFont$b r0 = (org.libpag.PAGFont.b) r0
        L_0x0060:
            java.lang.String r6 = r0.b
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0071
            if (r1 != 0) goto L_0x006c
            java.lang.String r1 = ""
        L_0x006c:
            r0.a = r1
            r7.add(r0)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGFont.a(org.xmlpull.v1.XmlPullParser, java.util.ArrayList):void");
    }

    public PAGFont(String str, String str2) {
        this.fontFamily = str;
        this.fontStyle = str2;
    }

    private static void b(XmlPullParser xmlPullParser, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("file")) {
                    arrayList2.add(c(xmlPullParser));
                } else {
                    d(xmlPullParser);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            b bVar = null;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b bVar2 = (b) it.next();
                if (bVar2.d == 400) {
                    bVar = bVar2;
                    break;
                }
            }
            if (bVar == null) {
                bVar = (b) arrayList2.get(0);
            }
            if (!bVar.b.isEmpty()) {
                arrayList.add(bVar);
            }
        }
    }

    private static b[] a() {
        b[] bVarArr = new b[0];
        try {
            FileInputStream fileInputStream = new FileInputStream("/system/etc/fallback_fonts.xml");
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(fileInputStream, (String) null);
                newPullParser.nextTag();
                return b(newPullParser);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException unused) {
            return bVarArr;
        }
    }

    private static b a(b[] bVarArr, String str) {
        String lowerCase = str.toLowerCase();
        for (b bVar : bVarArr) {
            if (bVar.a.toLowerCase().equals(lowerCase)) {
                return bVar;
            }
        }
        return null;
    }

    private static void a(b bVar, ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.contains(bVar.b) && new File(bVar.b).exists()) {
            arrayList.add(bVar.b);
            arrayList2.add(Integer.valueOf(bVar.c));
        }
    }
}
