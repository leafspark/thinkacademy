package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

abstract class AbstractHandler extends DefaultHandler {
    private final LinkedList<String> context = new LinkedList<>();
    private final StringBuilder text = new StringBuilder();

    /* access modifiers changed from: protected */
    public abstract void doEndElement(String str, String str2, String str3);

    /* access modifiers changed from: protected */
    public abstract void doStartElement(String str, String str2, String str3, Attributes attributes);

    AbstractHandler() {
    }

    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.text.setLength(0);
        doStartElement(str, str2, str3, attributes);
        this.context.add(str2);
    }

    public final void endElement(String str, String str2, String str3) {
        this.context.removeLast();
        doEndElement(str, str2, str3);
    }

    public final void characters(char[] cArr, int i, int i2) {
        this.text.append(cArr, i, i2);
    }

    /* access modifiers changed from: protected */
    public final String getText() {
        return this.text.toString();
    }

    /* access modifiers changed from: protected */
    public final boolean atTopLevel() {
        return this.context.isEmpty();
    }

    /* access modifiers changed from: protected */
    public final boolean in(String... strArr) {
        if (strArr.length != this.context.size()) {
            return false;
        }
        Iterator it = this.context.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = strArr[i];
            if (!str2.equals("*") && !str2.equals(str)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
