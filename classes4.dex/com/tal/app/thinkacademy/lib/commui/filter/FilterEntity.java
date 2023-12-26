package com.tal.app.thinkacademy.lib.commui.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterEntity {
    private List<? extends IFilterItem> items;
    private String title;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public List<? extends IFilterItem> getItems() {
        if (this.items == null) {
            this.items = new ArrayList();
        }
        return this.items;
    }

    public void setItems(List<? extends IFilterItem> list) {
        this.items = list;
    }

    public static class CommonFilterItem extends IFilterItem {
        String id;
        String name;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }
    }
}
