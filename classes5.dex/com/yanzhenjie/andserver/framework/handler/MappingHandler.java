package com.yanzhenjie.andserver.framework.handler;

import com.yanzhenjie.andserver.framework.ETag;
import com.yanzhenjie.andserver.framework.LastModified;
import com.yanzhenjie.andserver.framework.mapping.Addition;
import com.yanzhenjie.andserver.framework.mapping.Mapping;
import com.yanzhenjie.andserver.framework.mapping.Path;
import com.yanzhenjie.andserver.http.HttpRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MappingHandler implements MethodHandler {
    private final boolean isRest;
    private final Addition mAddition;
    private final Object mHost;
    private final Mapping mMapping;

    public MappingHandler(Object obj, Mapping mapping, Addition addition, boolean z) {
        this.mHost = obj;
        this.mMapping = mapping;
        this.mAddition = addition;
        this.isRest = z;
    }

    public String getETag(HttpRequest httpRequest) throws Throwable {
        Object host = getHost();
        if (host instanceof ETag) {
            return ((ETag) host).getETag(httpRequest);
        }
        return null;
    }

    public long getLastModified(HttpRequest httpRequest) throws Throwable {
        Object host = getHost();
        if (host instanceof LastModified) {
            return ((LastModified) host).getLastModified(httpRequest);
        }
        return -1;
    }

    public boolean isRest() {
        return this.isRest;
    }

    public Addition getAddition() {
        return this.mAddition;
    }

    public Mapping getMapping() {
        return this.mMapping;
    }

    /* access modifiers changed from: protected */
    public Object getHost() {
        return this.mHost;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getPathVariable(String str) {
        boolean z;
        List<Path.Segment> pathToList = Path.pathToList(str);
        for (Path.Rule segments : this.mMapping.getPath().getRuleList()) {
            List<Path.Segment> segments2 = segments.getSegments();
            if (pathToList.size() == segments2.size()) {
                if (Path.listToPath(segments2).equals(str)) {
                    return Collections.emptyMap();
                }
                int i = 0;
                boolean z2 = false;
                while (true) {
                    if (i >= segments2.size()) {
                        z = true;
                        break;
                    }
                    Path.Segment segment = segments2.get(i);
                    boolean isBlurred = segment.isBlurred();
                    z2 = z2 || isBlurred;
                    if (!segment.equals(pathToList.get(i)) && !isBlurred) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z && z2) {
                    HashMap hashMap = new HashMap();
                    for (int i2 = 0; i2 < segments2.size(); i2++) {
                        Path.Segment segment2 = segments2.get(i2);
                        if (segment2.isBlurred()) {
                            String value = segment2.getValue();
                            hashMap.put(value.substring(1, value.length() - 1), pathToList.get(i2).getValue());
                        }
                    }
                    return hashMap;
                }
            }
        }
        return Collections.emptyMap();
    }
}
