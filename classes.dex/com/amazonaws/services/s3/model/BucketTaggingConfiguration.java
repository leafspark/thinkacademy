package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BucketTaggingConfiguration implements Serializable {
    private List<TagSet> tagSets;

    public BucketTaggingConfiguration() {
        this.tagSets = null;
        this.tagSets = new ArrayList(1);
    }

    public BucketTaggingConfiguration(Collection<TagSet> collection) {
        this.tagSets = null;
        ArrayList arrayList = new ArrayList(1);
        this.tagSets = arrayList;
        arrayList.addAll(collection);
    }

    public BucketTaggingConfiguration withTagSets(TagSet... tagSetArr) {
        this.tagSets.clear();
        for (TagSet add : tagSetArr) {
            this.tagSets.add(add);
        }
        return this;
    }

    public void setTagSets(Collection<TagSet> collection) {
        this.tagSets.clear();
        this.tagSets.addAll(collection);
    }

    public List<TagSet> getAllTagSets() {
        return this.tagSets;
    }

    public TagSet getTagSet() {
        return this.tagSets.get(0);
    }

    public TagSet getTagSetAtIndex(int i) {
        return this.tagSets.get(i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("TagSets: " + getAllTagSets());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
