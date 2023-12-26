package com.yanzhenjie.andserver.http;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.yanzhenjie.andserver.util.LinkedMultiValueMap;
import com.yanzhenjie.andserver.util.MultiValueMap;
import com.yanzhenjie.andserver.util.ObjectUtils;
import com.yanzhenjie.andserver.util.Patterns;
import com.yanzhenjie.andserver.util.StringUtils;
import com.yanzhenjie.andserver.util.UrlCoder;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.io.Charsets;

public class Uri implements Patterns {
    private final String mFragment;
    private final String mHost;
    private final String mPath;
    private final int mPort;
    private final String mQuery;
    private final String mScheme;

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    private Uri(Builder builder) {
        this.mScheme = builder.mScheme;
        this.mHost = builder.mHost;
        this.mPort = builder.mPort;
        this.mPath = path(builder.mPath);
        this.mQuery = query(builder.mQuery);
        this.mFragment = builder.mFragment;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public String getHost() {
        return this.mHost;
    }

    public int getPort() {
        return this.mPort;
    }

    public String getPath() {
        return this.mPath;
    }

    public List<String> copyPath() {
        return convertPath(this.mPath);
    }

    public String getQuery() {
        return this.mQuery;
    }

    public MultiValueMap<String, String> getParams() {
        return convertQuery(this.mQuery);
    }

    public String getFragment() {
        return this.mFragment;
    }

    public Builder builder() {
        return new Builder(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isEmpty(this.mScheme)) {
            sb.append(this.mScheme);
            sb.append(":");
        }
        if (!StringUtils.isEmpty(this.mHost) && this.mPort > 0) {
            sb.append("//");
            sb.append(this.mHost);
            sb.append(":");
            sb.append(this.mPort);
        }
        if (!StringUtils.isEmpty(this.mPath)) {
            sb.append(this.mPath);
        }
        if (!StringUtils.isEmpty(this.mQuery)) {
            sb.append("?");
            sb.append(this.mQuery);
        }
        if (!StringUtils.isEmpty(this.mFragment)) {
            sb.append("#");
            sb.append(this.mFragment);
        }
        return sb.toString();
    }

    public Uri location(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return newBuilder(str).build();
        }
        URI create = URI.create(str);
        if (str.startsWith("/")) {
            return builder().setPath(create.getPath()).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
        }
        if (str.contains("../")) {
            List<String> convertPath = convertPath(getPath());
            List<String> convertPath2 = convertPath(create.getPath());
            int lastIndexOf = convertPath2.lastIndexOf("..");
            List<String> subList = convertPath2.subList(lastIndexOf + 1, convertPath2.size());
            if (!convertPath.isEmpty()) {
                List<String> subList2 = convertPath.subList(0, (convertPath.size() - lastIndexOf) - 2);
                subList2.addAll(subList);
                return builder().setPath(TextUtils.join("/", subList2)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
            }
            return builder().setPath(TextUtils.join("/", subList)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
        }
        List<String> convertPath3 = convertPath(getPath());
        convertPath3.addAll(convertPath(create.getPath()));
        return builder().setPath(TextUtils.join("/", convertPath3)).setQuery(create.getQuery()).setFragment(create.getFragment()).build();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String mFragment;
        /* access modifiers changed from: private */
        public String mHost;
        /* access modifiers changed from: private */
        public List<String> mPath;
        /* access modifiers changed from: private */
        public int mPort;
        /* access modifiers changed from: private */
        public MultiValueMap<String, String> mQuery;
        /* access modifiers changed from: private */
        public String mScheme;

        private Builder(String str) {
            URI create = URI.create(str);
            this.mScheme = create.getScheme();
            this.mHost = create.getHost();
            this.mPort = create.getPort();
            this.mPath = Uri.convertPath(create.getPath());
            this.mQuery = Uri.convertQuery(create.getQuery());
            this.mFragment = create.getFragment();
        }

        public Builder setScheme(String str) {
            this.mScheme = str;
            return this;
        }

        public Builder setHost(String str) {
            this.mHost = str;
            return this;
        }

        public Builder setPort(int i) {
            this.mPort = i;
            return this;
        }

        public Builder addPath(int i) {
            return addPath(Integer.toString(i));
        }

        public Builder addPath(long j) {
            return addPath(Long.toString(j));
        }

        public Builder addPath(boolean z) {
            return addPath(Boolean.toString(z));
        }

        public Builder addPath(char c) {
            return addPath(String.valueOf(c));
        }

        public Builder addPath(double d) {
            return addPath(Double.toString(d));
        }

        public Builder addPath(float f) {
            return addPath(Float.toString(f));
        }

        public Builder addPath(CharSequence charSequence) {
            this.mPath.add(charSequence.toString());
            return this;
        }

        public Builder addPath(String str) {
            this.mPath.add(str);
            return this;
        }

        public Builder setPath(String str) {
            this.mPath = Uri.convertPath(str);
            return this;
        }

        public Builder clearPath() {
            this.mPath.clear();
            return this;
        }

        public Builder addQuery(String str, int i) {
            return addQuery(str, Integer.toString(i));
        }

        public Builder addQuery(String str, long j) {
            return addQuery(str, Long.toString(j));
        }

        public Builder addQuery(String str, boolean z) {
            return addQuery(str, Boolean.toString(z));
        }

        public Builder addQuery(String str, char c) {
            return addQuery(str, String.valueOf(c));
        }

        public Builder addQuery(String str, double d) {
            return addQuery(str, Double.toString(d));
        }

        public Builder addQuery(String str, float f) {
            return addQuery(str, Float.toString(f));
        }

        public Builder addQuery(String str, short s) {
            return addQuery(str, Integer.toString(s));
        }

        public Builder addQuery(String str, CharSequence charSequence) {
            this.mQuery.add(str, charSequence.toString());
            return this;
        }

        public Builder addQuery(String str, String str2) {
            this.mQuery.add(str, str2);
            return this;
        }

        public Builder addQuery(String str, List<String> list) {
            for (String add : list) {
                this.mQuery.add(str, add);
            }
            return this;
        }

        public Builder setQuery(String str) {
            this.mQuery = Uri.convertQuery(str);
            return this;
        }

        public Builder setQuery(MultiValueMap<String, String> multiValueMap) {
            this.mQuery = multiValueMap;
            return this;
        }

        public Builder removeQuery(String str) {
            this.mQuery.remove(str);
            return this;
        }

        public Builder clearQuery() {
            this.mQuery.clear();
            return this;
        }

        public Builder setFragment(String str) {
            this.mFragment = str;
            return this;
        }

        public Uri build() {
            return new Uri(this);
        }
    }

    /* access modifiers changed from: private */
    public static List<String> convertPath(String str) {
        while (str.startsWith("/")) {
            str = str.substring(1);
        }
        while (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        LinkedList linkedList = new LinkedList();
        if (!StringUtils.isEmpty(str)) {
            while (str.startsWith("/")) {
                str = str.substring(1);
            }
            Collections.addAll(linkedList, str.split("/"));
        }
        return linkedList;
    }

    /* access modifiers changed from: private */
    public static MultiValueMap<String, String> convertQuery(String str) {
        LinkedMultiValueMap linkedMultiValueMap = new LinkedMultiValueMap();
        if (!StringUtils.isEmpty(str)) {
            if (str.startsWith("?")) {
                str = str.substring(1);
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreElements()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf("=");
                if (indexOf > 0 && indexOf < nextToken.length() - 1) {
                    linkedMultiValueMap.add(nextToken.substring(0, indexOf), UrlCoder.urlDecode(nextToken.substring(indexOf + 1), Charsets.UTF_8));
                }
            }
        }
        return linkedMultiValueMap;
    }

    private static String path(List<String> list) {
        if (ObjectUtils.isEmpty((Object) list)) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String append : list) {
            sb.append("/");
            sb.append(append);
        }
        return sb.toString();
    }

    private static String query(MultiValueMap<String, String> multiValueMap) {
        StringBuilder sb = new StringBuilder();
        Iterator it = multiValueMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List<String> list = (List) entry.getValue();
            if (!ObjectUtils.isEmpty((Object) list)) {
                for (String append : list) {
                    sb.append(str);
                    sb.append("=");
                    sb.append(append);
                }
            } else {
                sb.append(str);
                sb.append("=");
            }
        }
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            String str2 = (String) entry2.getKey();
            List<String> list2 = (List) entry2.getValue();
            if (!ObjectUtils.isEmpty((Object) list2)) {
                for (String append2 : list2) {
                    sb.append("&");
                    sb.append(str2);
                    sb.append("=");
                    sb.append(append2);
                }
            } else {
                sb.append("&");
                sb.append(str2);
                sb.append("=");
            }
        }
        return sb.toString();
    }
}
