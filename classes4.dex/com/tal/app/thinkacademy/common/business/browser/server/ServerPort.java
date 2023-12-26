package com.tal.app.thinkacademy.common.business.browser.server;

public enum ServerPort {
    ONLINE(1, 8000),
    DEFAULT(2, 8080);
    
    private int port;
    private int type;

    private ServerPort(int i, int i2) {
        this.type = i;
        this.port = i2;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public static int getPort(int i) {
        ServerPort serverPort = ONLINE;
        if (i == serverPort.getType()) {
            return serverPort.getPort();
        }
        return DEFAULT.getPort();
    }
}
