package org.apache.commons.fileupload.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.fileupload.FileItemHeaders;

public class FileItemHeadersImpl implements FileItemHeaders, Serializable {
    private static final long serialVersionUID = -4455695752627032559L;
    private final Map<String, List<String>> headerNameToValueListMap = new LinkedHashMap();

    public String getHeader(String str) {
        List list = this.headerNameToValueListMap.get(str.toLowerCase(Locale.ENGLISH));
        if (list == null) {
            return null;
        }
        return (String) list.get(0);
    }

    public Iterator<String> getHeaderNames() {
        return this.headerNameToValueListMap.keySet().iterator();
    }

    public Iterator<String> getHeaders(String str) {
        List list = this.headerNameToValueListMap.get(str.toLowerCase(Locale.ENGLISH));
        if (list == null) {
            list = Collections.emptyList();
        }
        return list.iterator();
    }

    public synchronized void addHeader(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        List list = this.headerNameToValueListMap.get(lowerCase);
        if (list == null) {
            list = new ArrayList();
            this.headerNameToValueListMap.put(lowerCase, list);
        }
        list.add(str2);
    }
}
