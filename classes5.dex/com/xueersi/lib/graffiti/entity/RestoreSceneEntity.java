package com.xueersi.lib.graffiti.entity;

import com.xueersi.lib.graffiti.WXWBAction;
import java.util.List;
import java.util.Map;

public class RestoreSceneEntity {
    private Map<Integer, WXWBAction> canvasInfoMap;
    private Map<Integer, List<DrawActionParams>> graffitiMap;
    private Map<Integer, List<DrawActionParams>> shapeMap;

    public RestoreSceneEntity(Map<Integer, WXWBAction> map, Map<Integer, List<DrawActionParams>> map2, Map<Integer, List<DrawActionParams>> map3) {
        this.canvasInfoMap = map;
        this.graffitiMap = map2;
        this.shapeMap = map3;
    }

    public Map<Integer, WXWBAction> getCanvasInfoMap() {
        return this.canvasInfoMap;
    }

    public Map<Integer, List<DrawActionParams>> getGraffitiMap() {
        return this.graffitiMap;
    }

    public Map<Integer, List<DrawActionParams>> getShapeMap() {
        return this.shapeMap;
    }
}
