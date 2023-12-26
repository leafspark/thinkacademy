package com.yanzhenjie.andserver.framework.mapping;

public class Mapping {
    private Mime mConsume;
    private Pair mHeader;
    private Method mMethod;
    private Pair mParam;
    private Path mPath;
    private Mime mProduce;

    public Path getPath() {
        return this.mPath;
    }

    public void setPath(Path path) {
        this.mPath = path;
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public void setMethod(Method method) {
        this.mMethod = method;
    }

    public Pair getParam() {
        return this.mParam;
    }

    public void setParam(Pair pair) {
        this.mParam = pair;
    }

    public Pair getHeader() {
        return this.mHeader;
    }

    public void setHeader(Pair pair) {
        this.mHeader = pair;
    }

    public Mime getConsume() {
        return this.mConsume;
    }

    public void setConsume(Mime mime) {
        this.mConsume = mime;
    }

    public Mime getProduce() {
        return this.mProduce;
    }

    public void setProduce(Mime mime) {
        this.mProduce = mime;
    }
}
