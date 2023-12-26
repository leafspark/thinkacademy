package com.amazonaws.transform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StaxUnmarshallerContext {
    private int currentEventType;
    private final Map<String, String> headers;
    private Map<String, String> metadata;
    private List<MetadataExpression> metadataExpressions;
    public final Deque<String> stack;
    private String stackString;
    private final XmlPullParser xpp;

    public StaxUnmarshallerContext(XmlPullParser xmlPullParser) {
        this(xmlPullParser, (Map<String, String>) null);
    }

    public StaxUnmarshallerContext(XmlPullParser xmlPullParser, Map<String, String> map) {
        this.stack = new LinkedList();
        this.stackString = "";
        this.metadata = new HashMap();
        this.metadataExpressions = new ArrayList();
        this.xpp = xmlPullParser;
        this.headers = map;
    }

    public String getHeader(String str) {
        Map<String, String> map = this.headers;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public String readText() throws XmlPullParserException, IOException {
        String nextText = this.xpp.nextText();
        if (this.xpp.getEventType() != 3) {
            this.xpp.next();
        }
        this.currentEventType = this.xpp.getEventType();
        updateContext();
        return nextText;
    }

    public int getCurrentDepth() {
        return this.stack.size();
    }

    public boolean testExpression(String str) {
        return testExpression(str, getCurrentDepth());
    }

    public boolean testExpression(String str, int i) {
        if (".".equals(str)) {
            return true;
        }
        int i2 = -1;
        while (true) {
            i2 = str.indexOf("/", i2 + 1);
            if (i2 <= -1) {
                break;
            } else if (str.charAt(i2 + 1) != '@') {
                i++;
            }
        }
        if (getCurrentDepth() == i) {
            if (this.stackString.endsWith("/" + str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStartOfDocument() {
        return this.currentEventType == 0;
    }

    public int nextEvent() throws XmlPullParserException, IOException {
        int next = this.xpp.next();
        this.currentEventType = next;
        if (next == 4) {
            this.currentEventType = this.xpp.next();
        }
        updateContext();
        if (this.currentEventType == 2) {
            Iterator<MetadataExpression> it = this.metadataExpressions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MetadataExpression next2 = it.next();
                if (testExpression(next2.expression, next2.targetDepth)) {
                    this.metadata.put(next2.key, readText());
                    break;
                }
            }
        }
        return this.currentEventType;
    }

    public Map<String, String> getMetadata() {
        return this.metadata;
    }

    public void registerMetadataExpression(String str, int i, String str2) {
        this.metadataExpressions.add(new MetadataExpression(str, i, str2));
    }

    private static class MetadataExpression {
        public String expression;
        public String key;
        public int targetDepth;

        public MetadataExpression(String str, int i, String str2) {
            this.expression = str;
            this.targetDepth = i;
            this.key = str2;
        }
    }

    private void updateContext() {
        int i = this.currentEventType;
        if (i == 2) {
            String str = this.stackString + "/" + this.xpp.getName();
            this.stackString = str;
            this.stack.push(str);
        } else if (i == 3) {
            this.stack.pop();
            this.stackString = this.stack.isEmpty() ? "" : this.stack.peek();
        }
    }
}
