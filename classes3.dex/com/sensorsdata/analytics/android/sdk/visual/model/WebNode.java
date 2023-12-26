package com.sensorsdata.analytics.android.sdk.visual.model;

import java.io.Serializable;
import java.util.List;

public class WebNode implements Serializable {
    private static final long serialVersionUID = -5865016149609340219L;
    private String $element_content;
    private String $element_path;
    private String $element_position;
    private String $element_selector;
    private String $title;
    private String $url;
    private boolean enable_click;
    private float height;
    private String id;
    private boolean isRootView;
    private boolean is_list_view;
    private float left;
    private int level;
    private String lib_version;
    private String list_selector;
    private float originLeft;
    private float originTop;
    private float scale;
    private float scrollX;
    private float scrollY;
    private List<String> subelements;
    private String tagName;
    private float top;
    private boolean visibility;
    private float width;
    private int zIndex;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public String get$element_selector() {
        return this.$element_selector;
    }

    public void set$element_selector(String str) {
        this.$element_selector = str;
    }

    public String get$element_content() {
        return this.$element_content;
    }

    public void set$element_content(String str) {
        this.$element_content = str;
    }

    public String get$element_path() {
        return this.$element_path;
    }

    public void set$element_path(String str) {
        this.$element_path = str;
    }

    public String get$element_position() {
        return this.$element_position;
    }

    public void set$element_position(String str) {
        this.$element_position = str;
    }

    public String getList_selector() {
        return this.list_selector;
    }

    public void setList_selector(String str) {
        this.list_selector = str;
    }

    public String getLib_version() {
        return this.lib_version;
    }

    public void setLib_version(String str) {
        this.lib_version = str;
    }

    public boolean isEnable_click() {
        return this.enable_click;
    }

    public void setEnable_click(boolean z) {
        this.enable_click = z;
    }

    public boolean isIs_list_view() {
        return this.is_list_view;
    }

    public void setIs_list_view(boolean z) {
        this.is_list_view = z;
    }

    public String get$title() {
        return this.$title;
    }

    public void set$title(String str) {
        this.$title = str;
    }

    public float getTop() {
        return this.top;
    }

    public void setTop(float f) {
        this.top = f;
    }

    public float getLeft() {
        return this.left;
    }

    public void setLeft(float f) {
        this.left = f;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public boolean isVisibility() {
        return this.visibility;
    }

    public void setVisibility(boolean z) {
        this.visibility = z;
    }

    public float getScrollX() {
        return this.scrollX;
    }

    public void setScrollX(float f) {
        this.scrollX = f;
    }

    public float getScrollY() {
        return this.scrollY;
    }

    public void setScrollY(float f) {
        this.scrollY = f;
    }

    public float getScale() {
        return this.scale;
    }

    public void setScale(float f) {
        this.scale = f;
    }

    public String get$url() {
        return this.$url;
    }

    public void set$url(String str) {
        this.$url = str;
    }

    public int getzIndex() {
        return this.zIndex;
    }

    public void setzIndex(int i) {
        this.zIndex = i;
    }

    public List<String> getSubelements() {
        return this.subelements;
    }

    public void setSubelements(List<String> list) {
        this.subelements = list;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean isRootView() {
        return this.isRootView;
    }

    public void setRootView(boolean z) {
        this.isRootView = z;
    }

    public float getOriginTop() {
        return this.originTop;
    }

    public void setOriginTop(float f) {
        this.originTop = f;
    }

    public float getOriginLeft() {
        return this.originLeft;
    }

    public void setOriginLeft(float f) {
        this.originLeft = f;
    }
}
