package com.facebook.yoga;

public interface YogaProps {
    YogaAlign getAlignContent();

    YogaAlign getAlignItems();

    YogaAlign getAlignSelf();

    float getAspectRatio();

    float getBorder(YogaEdge yogaEdge);

    YogaValue getFlexBasis();

    YogaFlexDirection getFlexDirection();

    float getFlexGrow();

    float getFlexShrink();

    YogaValue getHeight();

    YogaJustify getJustifyContent();

    YogaValue getMargin(YogaEdge yogaEdge);

    YogaValue getMaxHeight();

    YogaValue getMaxWidth();

    YogaValue getMinHeight();

    YogaValue getMinWidth();

    YogaValue getPadding(YogaEdge yogaEdge);

    YogaValue getPosition(YogaEdge yogaEdge);

    YogaPositionType getPositionType();

    YogaDirection getStyleDirection();

    YogaValue getWidth();

    void setAlignContent(YogaAlign yogaAlign);

    void setAlignItems(YogaAlign yogaAlign);

    void setAlignSelf(YogaAlign yogaAlign);

    void setAspectRatio(float f);

    void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction);

    void setBorder(YogaEdge yogaEdge, float f);

    void setDirection(YogaDirection yogaDirection);

    void setFlex(float f);

    void setFlexBasis(float f);

    void setFlexBasisAuto();

    void setFlexBasisPercent(float f);

    void setFlexDirection(YogaFlexDirection yogaFlexDirection);

    void setFlexGrow(float f);

    void setFlexShrink(float f);

    void setHeight(float f);

    void setHeightAuto();

    void setHeightPercent(float f);

    void setIsReferenceBaseline(boolean z);

    void setJustifyContent(YogaJustify yogaJustify);

    void setMargin(YogaEdge yogaEdge, float f);

    void setMarginAuto(YogaEdge yogaEdge);

    void setMarginPercent(YogaEdge yogaEdge, float f);

    void setMaxHeight(float f);

    void setMaxHeightPercent(float f);

    void setMaxWidth(float f);

    void setMaxWidthPercent(float f);

    void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction);

    void setMinHeight(float f);

    void setMinHeightPercent(float f);

    void setMinWidth(float f);

    void setMinWidthPercent(float f);

    void setPadding(YogaEdge yogaEdge, float f);

    void setPaddingPercent(YogaEdge yogaEdge, float f);

    void setPosition(YogaEdge yogaEdge, float f);

    void setPositionPercent(YogaEdge yogaEdge, float f);

    void setPositionType(YogaPositionType yogaPositionType);

    void setWidth(float f);

    void setWidthAuto();

    void setWidthPercent(float f);

    void setWrap(YogaWrap yogaWrap);
}
