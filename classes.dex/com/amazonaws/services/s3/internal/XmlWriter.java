package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class XmlWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    StringBuilder sb = new StringBuilder();
    List<String> tags = new ArrayList();

    public XmlWriter start(String str) {
        StringBuilder sb2 = this.sb;
        sb2.append("<");
        sb2.append(str);
        sb2.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String str2, String str3) {
        StringBuilder sb2 = this.sb;
        sb2.append("<");
        sb2.append(str);
        writeAttr(str2, str3);
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb2 = this.sb;
        sb2.append("<");
        sb2.append(str);
        for (int i = 0; i < Math.min(strArr.length, strArr2.length); i++) {
            writeAttr(strArr[i], strArr2[i]);
        }
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter end() {
        List<String> list = this.tags;
        StringBuilder sb2 = this.sb;
        sb2.append("</");
        sb2.append(list.remove(list.size() - 1));
        sb2.append(">");
        return this;
    }

    public byte[] getBytes() {
        return toString().getBytes(StringUtils.UTF8);
    }

    public String toString() {
        return this.sb.toString();
    }

    public XmlWriter value(String str) {
        appendEscapedString(str, this.sb);
        return this;
    }

    private void writeAttr(String str, String str2) {
        StringBuilder sb2 = this.sb;
        sb2.append(' ');
        sb2.append(str);
        sb2.append("=\"");
        appendEscapedString(str2, this.sb);
        this.sb.append("\"");
    }

    private void appendEscapedString(String str, StringBuilder sb2) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            String str2 = charAt != 9 ? charAt != 10 ? charAt != 13 ? charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : "&gt;" : "&lt;" : "&amp;" : "&quot;" : "&#13;" : "&#10;" : "&#9;";
            if (str2 != null) {
                if (i2 < i) {
                    sb2.append(str, i2, i);
                }
                this.sb.append(str2);
                i2 = i + 1;
            }
            i++;
        }
        if (i2 < i) {
            this.sb.append(str, i2, i);
        }
    }
}
