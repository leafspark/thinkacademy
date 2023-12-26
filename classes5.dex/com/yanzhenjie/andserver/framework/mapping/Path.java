package com.yanzhenjie.andserver.framework.mapping;

import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Path implements Patterns {
    private List<Rule> mRuleList = new LinkedList();

    public List<Rule> getRuleList() {
        return this.mRuleList;
    }

    public void addRule(String str) {
        Rule rule = new Rule();
        rule.setSegments(pathToList(str));
        this.mRuleList.add(rule);
    }

    public static class Rule {
        private List<Segment> mSegments;

        public List<Segment> getSegments() {
            return this.mSegments;
        }

        public void setSegments(List<Segment> list) {
            this.mSegments = list;
        }
    }

    public static class Segment {
        private final boolean isBlurred;
        private final String value;

        public Segment(String str, boolean z) {
            this.value = str;
            this.isBlurred = z;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isBlurred() {
            return this.isBlurred;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Segment)) {
                return false;
            }
            return this.value.equals(((Segment) obj).value);
        }

        public String toString() {
            return this.value;
        }
    }

    public static List<Segment> pathToList(String str) {
        int i;
        LinkedList linkedList = new LinkedList();
        if (!StringUtils.isEmpty(str)) {
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            while (true) {
                if (!str.endsWith("/")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
            for (String str2 : str.split("/")) {
                linkedList.add(new Segment(str2, str2.contains("{")));
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    public static String listToPath(List<Segment> list) {
        StringBuilder sb = new StringBuilder("");
        if (list.isEmpty()) {
            sb.append("/");
        }
        for (Segment value : list) {
            sb.append("/");
            sb.append(value.getValue());
        }
        return sb.toString();
    }

    public static boolean matches(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        List<Segment> pathToList = pathToList(str);
        List<Segment> pathToList2 = pathToList(str2);
        if (pathToList.size() != pathToList2.size()) {
            return false;
        }
        for (int i = 0; i < pathToList.size(); i++) {
            Segment segment = pathToList.get(i);
            if (!segment.equals(pathToList2.get(i)) && !segment.isBlurred()) {
                return false;
            }
        }
        return true;
    }
}
