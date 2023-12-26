package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class NotificationConfiguration {
    private Set<String> events = new HashSet();
    private Filter filter;
    @Deprecated
    private List<String> objectPrefixes = new ArrayList();

    protected NotificationConfiguration() {
    }

    protected NotificationConfiguration(EnumSet<S3Event> enumSet) {
        if (enumSet != null) {
            Iterator it = enumSet.iterator();
            while (it.hasNext()) {
                this.events.add(((S3Event) it.next()).toString());
            }
        }
    }

    protected NotificationConfiguration(String... strArr) {
        if (strArr != null) {
            for (String add : strArr) {
                this.events.add(add);
            }
        }
    }

    public Set<String> getEvents() {
        return this.events;
    }

    public void setEvents(Set<String> set) {
        this.events = set;
    }

    @Deprecated
    public List<String> getObjectPrefixes() {
        return this.objectPrefixes;
    }

    @Deprecated
    public void setObjectPrefixes(List<String> list) {
        this.objectPrefixes = list;
    }

    public NotificationConfiguration withEvents(Set<String> set) {
        this.events.clear();
        this.events.addAll(set);
        return this;
    }

    @Deprecated
    public NotificationConfiguration withObjectPrefixes(String... strArr) {
        this.objectPrefixes.clear();
        if (strArr != null && strArr.length > 0) {
            this.objectPrefixes.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public void addEvent(String str) {
        this.events.add(str);
    }

    public void addEvent(S3Event s3Event) {
        this.events.add(s3Event.toString());
    }

    @Deprecated
    public void addObjectPrefix(String str) {
        this.objectPrefixes.add(str);
    }

    public Filter getFilter() {
        return this.filter;
    }

    public void setFilter(Filter filter2) {
        this.filter = filter2;
    }

    public NotificationConfiguration withFilter(Filter filter2) {
        setFilter(filter2);
        return this;
    }
}
