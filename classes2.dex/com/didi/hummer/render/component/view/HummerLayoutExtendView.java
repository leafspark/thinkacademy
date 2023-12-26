package com.didi.hummer.render.component.view;

import android.content.Context;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.render.component.view.HMBase;
import com.didi.hummer.render.style.HummerLayout;
import com.didi.hummer.render.style.HummerLayoutExtendUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class HummerLayoutExtendView extends HMBase<HummerLayout> implements HMBase.PositionChangedListener, HMBase.DisplayChangedListener {
    private List<HMBase> children = new LinkedList();
    private Map<HMBase, FixedNoneBox> fixedNoneBoxMap = new HashMap();
    private HummerContext hummerContext;
    private List<InlineBox> inlineBoxes = new ArrayList();

    public HummerLayoutExtendView(HummerContext hummerContext2, JSValue jSValue, String str) {
        super(hummerContext2, jSValue, str);
        this.hummerContext = hummerContext2;
    }

    /* access modifiers changed from: protected */
    public HummerLayout createViewInstance(Context context) {
        return new HummerLayout(context);
    }

    public void onCreate() {
        super.onCreate();
        ((HummerLayout) getView()).setCornerRadiiGetter(new HummerLayoutExtendView$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ float[] lambda$onCreate$0$HummerLayoutExtendView() throws Exception {
        return this.backgroundHelper.getBorderRadii();
    }

    public void onDestroy() {
        super.onDestroy();
        ((HummerLayout) getView()).post(new HummerLayoutExtendView$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$onDestroy$1$HummerLayoutExtendView() {
        if (!this.children.isEmpty()) {
            for (HMBase next : this.children) {
                if (!(next == null || next.getJSValue() == null)) {
                    next.getJSValue().unprotect();
                }
            }
            this.children.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        if (r4.getDisplay() == com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void appendChild(com.didi.hummer.render.component.view.HMBase r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0003
            return
        L_0x0003:
            com.didi.hummer.core.engine.JSValue r0 = r4.getJSValue()
            r0.protect()
            r4.setPositionChangedListener(r3)
            r4.setDisplayChangedListener(r3)
            java.util.List<com.didi.hummer.render.component.view.HMBase> r0 = r3.children
            r0.add(r4)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r0 = r4.getPosition()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r1 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Position.FIXED
            if (r0 != r1) goto L_0x0033
            com.didi.hummer.context.HummerContext r0 = r3.hummerContext
            com.didi.hummer.render.style.HummerLayout r0 = r0.getContainer()
            r0.addView(r4)
            com.didi.hummer.render.component.view.FixedNoneBox r0 = new com.didi.hummer.render.component.view.FixedNoneBox
            com.didi.hummer.context.HummerContext r1 = r3.hummerContext
            r0.<init>(r1)
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r1 = r3.fixedNoneBoxMap
            r1.put(r4, r0)
            goto L_0x0034
        L_0x0033:
            r0 = r4
        L_0x0034:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r3.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r1 != r2) goto L_0x0079
            com.didi.hummer.render.style.HummerLayoutExtendUtils.markExtendCssView(r4)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r4.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE
            if (r1 == r2) goto L_0x004f
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r4.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK
            if (r1 != r2) goto L_0x0079
        L_0x004f:
            android.view.View r0 = r3.getView()
            com.didi.hummer.render.style.HummerLayout r0 = (com.didi.hummer.render.style.HummerLayout) r0
            com.didi.hummer.render.component.view.HMBase r0 = r0.getLastChild()
            boolean r1 = r0 instanceof com.didi.hummer.render.component.view.InlineBox
            if (r1 == 0) goto L_0x0067
            com.didi.hummer.render.component.view.InlineBox r0 = (com.didi.hummer.render.component.view.InlineBox) r0
            r4.setInlineBox(r0)
            r0.add(r4)
            r0 = 0
            goto L_0x0079
        L_0x0067:
            com.didi.hummer.render.component.view.InlineBox r0 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r1 = r3.hummerContext
            r0.<init>(r1)
            r4.setInlineBox(r0)
            r0.add(r4)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r1 = r3.inlineBoxes
            r1.add(r0)
        L_0x0079:
            boolean r1 = com.didi.hummer.render.style.HummerLayoutExtendUtils.isExtendCssView(r4)
            if (r1 == 0) goto L_0x008a
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r3.getDisplay()
            java.lang.String r1 = r1.value()
            com.didi.hummer.render.style.HummerLayoutExtendUtils.applyChildDisplayStyle(r1, r4)
        L_0x008a:
            if (r0 == 0) goto L_0x0095
            android.view.View r4 = r3.getView()
            com.didi.hummer.render.style.HummerLayout r4 = (com.didi.hummer.render.style.HummerLayout) r4
            r4.addView(r0)
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.render.component.view.HummerLayoutExtendView.appendChild(com.didi.hummer.render.component.view.HMBase):void");
    }

    public void removeChild(HMBase hMBase) {
        if (hMBase != null) {
            hMBase.getJSValue().unprotect();
            hMBase.setPositionChangedListener((HMBase.PositionChangedListener) null);
            hMBase.setDisplayChangedListener((HMBase.DisplayChangedListener) null);
            this.children.remove(hMBase);
            if (hMBase.getInlineBox() != null) {
                InlineBox inlineBox = hMBase.getInlineBox();
                inlineBox.remove(hMBase);
                if (inlineBox.isChildrenEmpty()) {
                    this.inlineBoxes.remove(inlineBox);
                    ((HummerLayout) getView()).removeView(inlineBox);
                }
            } else if (this.fixedNoneBoxMap.containsKey(hMBase)) {
                this.hummerContext.getContainer().removeView(hMBase);
                ((HummerLayout) getView()).removeView(this.fixedNoneBoxMap.remove(hMBase));
            } else {
                ((HummerLayout) getView()).removeView(hMBase);
                if (getDisplay() == HummerLayoutExtendUtils.Display.BLOCK) {
                    mergeInlineBox();
                }
            }
        }
    }

    public void removeAll() {
        this.inlineBoxes.clear();
        for (Map.Entry next : this.fixedNoneBoxMap.entrySet()) {
            this.hummerContext.getContainer().removeView((HMBase) next.getKey());
            ((HummerLayout) getView()).removeView((FixedNoneBox) next.getValue());
        }
        this.fixedNoneBoxMap.clear();
        for (HMBase next2 : this.children) {
            next2.getJSValue().unprotect();
            next2.setPositionChangedListener((HMBase.PositionChangedListener) null);
            next2.setDisplayChangedListener((HMBase.DisplayChangedListener) null);
        }
        this.children.clear();
        ((HummerLayout) getView()).removeAllViews();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0062, code lost:
        if (r8.getDisplay() == com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void insertBefore(com.didi.hummer.render.component.view.HMBase r8, com.didi.hummer.render.component.view.HMBase r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0147
            if (r9 != 0) goto L_0x0006
            goto L_0x0147
        L_0x0006:
            com.didi.hummer.core.engine.JSValue r0 = r8.getJSValue()
            r0.protect()
            r8.setPositionChangedListener(r7)
            r8.setDisplayChangedListener(r7)
            java.util.List<com.didi.hummer.render.component.view.HMBase> r0 = r7.children
            r0.add(r8)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r0 = r8.getPosition()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r1 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Position.FIXED
            if (r0 != r1) goto L_0x0036
            com.didi.hummer.context.HummerContext r0 = r7.hummerContext
            com.didi.hummer.render.style.HummerLayout r0 = r0.getContainer()
            r0.addView(r8)
            com.didi.hummer.render.component.view.FixedNoneBox r0 = new com.didi.hummer.render.component.view.FixedNoneBox
            com.didi.hummer.context.HummerContext r1 = r7.hummerContext
            r0.<init>(r1)
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r1 = r7.fixedNoneBoxMap
            r1.put(r8, r0)
            goto L_0x0037
        L_0x0036:
            r0 = r8
        L_0x0037:
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r1 = r7.fixedNoneBoxMap
            boolean r1 = r1.containsKey(r9)
            if (r1 == 0) goto L_0x0048
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r1 = r7.fixedNoneBoxMap
            java.lang.Object r1 = r1.get(r9)
            com.didi.hummer.render.component.view.HMBase r1 = (com.didi.hummer.render.component.view.HMBase) r1
            goto L_0x0049
        L_0x0048:
            r1 = r9
        L_0x0049:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r7.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r2 != r3) goto L_0x008c
            com.didi.hummer.render.style.HummerLayoutExtendUtils.markExtendCssView(r8)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE
            if (r2 == r3) goto L_0x0064
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK
            if (r2 != r3) goto L_0x008c
        L_0x0064:
            com.didi.hummer.render.component.view.InlineBox r0 = r9.getInlineBox()
            if (r0 == 0) goto L_0x007a
            com.didi.hummer.render.component.view.InlineBox r0 = r9.getInlineBox()
            r8.setInlineBox(r0)
            com.didi.hummer.render.component.view.InlineBox r0 = r9.getInlineBox()
            r0.insertBefore(r8, r9)
            r0 = 0
            goto L_0x008c
        L_0x007a:
            com.didi.hummer.render.component.view.InlineBox r0 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r2 = r7.hummerContext
            r0.<init>(r2)
            r8.setInlineBox(r0)
            r0.add(r8)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r2 = r7.inlineBoxes
            r2.add(r0)
        L_0x008c:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r7.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r2 != r3) goto L_0x0120
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE
            if (r2 == r3) goto L_0x0120
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r2 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK
            if (r2 == r3) goto L_0x0120
            com.didi.hummer.render.component.view.InlineBox r2 = r9.getInlineBox()
            if (r2 == 0) goto L_0x0120
            com.didi.hummer.render.component.view.InlineBox r1 = r9.getInlineBox()
            java.util.List r2 = r1.getChildren()
            int r9 = r2.indexOf(r9)
            com.didi.hummer.render.component.view.InlineBox r2 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r3 = r7.hummerContext
            r2.<init>(r3)
            com.didi.hummer.render.component.view.InlineBox r3 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r4 = r7.hummerContext
            r3.<init>(r4)
            r4 = 0
            r5 = r4
        L_0x00c6:
            boolean r6 = r1.isChildrenEmpty()
            if (r6 != 0) goto L_0x00ee
            java.util.List r6 = r1.getChildren()
            java.lang.Object r6 = r6.get(r4)
            com.didi.hummer.render.component.view.HMBase r6 = (com.didi.hummer.render.component.view.HMBase) r6
            if (r5 >= r9) goto L_0x00e2
            r1.remove(r6)
            r2.add(r6)
            r6.setInlineBox(r2)
            goto L_0x00eb
        L_0x00e2:
            r1.remove(r6)
            r3.add(r6)
            r6.setInlineBox(r3)
        L_0x00eb:
            int r5 = r5 + 1
            goto L_0x00c6
        L_0x00ee:
            com.facebook.yoga.YogaNode r9 = r7.getYogaNode()
            com.facebook.yoga.YogaNode r4 = r1.getYogaNode()
            int r9 = r9.indexOf(r4)
            android.view.View r4 = r7.getView()
            com.didi.hummer.render.style.HummerLayout r4 = (com.didi.hummer.render.style.HummerLayout) r4
            r4.removeView(r1)
            android.view.View r1 = r7.getView()
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            r1.addView(r3, r9)
            android.view.View r1 = r7.getView()
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            r1.addView(r2, r9)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r9 = r7.inlineBoxes
            r9.add(r2)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r9 = r7.inlineBoxes
            r9.add(r3)
            r1 = r3
        L_0x0120:
            boolean r9 = com.didi.hummer.render.style.HummerLayoutExtendUtils.isExtendCssView(r8)
            if (r9 == 0) goto L_0x0131
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r9 = r7.getDisplay()
            java.lang.String r9 = r9.value()
            com.didi.hummer.render.style.HummerLayoutExtendUtils.applyChildDisplayStyle(r9, r8)
        L_0x0131:
            if (r0 == 0) goto L_0x013c
            android.view.View r8 = r7.getView()
            com.didi.hummer.render.style.HummerLayout r8 = (com.didi.hummer.render.style.HummerLayout) r8
            r8.insertBefore(r0, r1)
        L_0x013c:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r8 = r7.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r9 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r8 != r9) goto L_0x0147
            r7.mergeInlineBox()
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.render.component.view.HummerLayoutExtendView.insertBefore(com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.HMBase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void replaceChild(com.didi.hummer.render.component.view.HMBase r9, com.didi.hummer.render.component.view.HMBase r10) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x016c
            if (r10 != 0) goto L_0x0006
            goto L_0x016c
        L_0x0006:
            com.didi.hummer.core.engine.JSValue r0 = r9.getJSValue()
            r0.protect()
            r9.setPositionChangedListener(r8)
            r9.setDisplayChangedListener(r8)
            com.didi.hummer.core.engine.JSValue r0 = r10.getJSValue()
            r0.unprotect()
            r0 = 0
            r10.setPositionChangedListener(r0)
            r10.setDisplayChangedListener(r0)
            java.util.List<com.didi.hummer.render.component.view.HMBase> r1 = r8.children
            r1.add(r9)
            java.util.List<com.didi.hummer.render.component.view.HMBase> r1 = r8.children
            r1.remove(r10)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r1 = r9.getPosition()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Position r2 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Position.FIXED
            if (r1 != r2) goto L_0x0049
            com.didi.hummer.context.HummerContext r1 = r8.hummerContext
            com.didi.hummer.render.style.HummerLayout r1 = r1.getContainer()
            r1.addView(r9)
            com.didi.hummer.render.component.view.FixedNoneBox r1 = new com.didi.hummer.render.component.view.FixedNoneBox
            com.didi.hummer.context.HummerContext r2 = r8.hummerContext
            r1.<init>(r2)
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r2 = r8.fixedNoneBoxMap
            r2.put(r9, r1)
            goto L_0x004a
        L_0x0049:
            r1 = r9
        L_0x004a:
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r2 = r8.fixedNoneBoxMap
            boolean r2 = r2.containsKey(r10)
            if (r2 == 0) goto L_0x0064
            com.didi.hummer.context.HummerContext r2 = r8.hummerContext
            com.didi.hummer.render.style.HummerLayout r2 = r2.getContainer()
            r2.removeView(r10)
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r2 = r8.fixedNoneBoxMap
            java.lang.Object r2 = r2.get(r10)
            com.didi.hummer.render.component.view.HMBase r2 = (com.didi.hummer.render.component.view.HMBase) r2
            goto L_0x0065
        L_0x0064:
            r2 = r10
        L_0x0065:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r4 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r3 != r4) goto L_0x00a8
            com.didi.hummer.render.style.HummerLayoutExtendUtils.markExtendCssView(r9)
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = r9.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r4 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE
            if (r3 == r4) goto L_0x0080
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = r9.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r4 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK
            if (r3 != r4) goto L_0x00a8
        L_0x0080:
            com.didi.hummer.render.component.view.InlineBox r1 = r10.getInlineBox()
            if (r1 == 0) goto L_0x0095
            com.didi.hummer.render.component.view.InlineBox r1 = r10.getInlineBox()
            r9.setInlineBox(r1)
            com.didi.hummer.render.component.view.InlineBox r1 = r10.getInlineBox()
            r1.replace(r9, r10)
            goto L_0x00a9
        L_0x0095:
            com.didi.hummer.render.component.view.InlineBox r0 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r1 = r8.hummerContext
            r0.<init>(r1)
            r9.setInlineBox(r0)
            r0.add(r9)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r1 = r8.inlineBoxes
            r1.add(r0)
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r9.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE
            if (r1 == r3) goto L_0x0144
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r9.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r3 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.INLINE_BLOCK
            if (r1 == r3) goto L_0x0144
            com.didi.hummer.render.component.view.InlineBox r1 = r10.getInlineBox()
            if (r1 == 0) goto L_0x0144
            com.didi.hummer.render.component.view.InlineBox r1 = r10.getInlineBox()
            java.util.List r2 = r1.getChildren()
            int r2 = r2.indexOf(r10)
            com.didi.hummer.render.component.view.InlineBox r3 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r4 = r8.hummerContext
            r3.<init>(r4)
            com.didi.hummer.render.component.view.InlineBox r4 = new com.didi.hummer.render.component.view.InlineBox
            com.didi.hummer.context.HummerContext r5 = r8.hummerContext
            r4.<init>(r5)
            r5 = 0
            r6 = r5
        L_0x00db:
            boolean r7 = r1.isChildrenEmpty()
            if (r7 != 0) goto L_0x0109
            java.util.List r7 = r1.getChildren()
            java.lang.Object r7 = r7.get(r5)
            com.didi.hummer.render.component.view.HMBase r7 = (com.didi.hummer.render.component.view.HMBase) r7
            if (r6 >= r2) goto L_0x00f7
            r1.remove(r7)
            r3.add(r7)
            r7.setInlineBox(r3)
            goto L_0x0106
        L_0x00f7:
            if (r6 <= r2) goto L_0x0103
            r1.remove(r7)
            r4.add(r7)
            r7.setInlineBox(r4)
            goto L_0x0106
        L_0x0103:
            r1.remove(r7)
        L_0x0106:
            int r6 = r6 + 1
            goto L_0x00db
        L_0x0109:
            com.facebook.yoga.YogaNode r2 = r8.getYogaNode()
            com.facebook.yoga.YogaNode r5 = r1.getYogaNode()
            int r2 = r2.indexOf(r5)
            android.view.View r5 = r8.getView()
            com.didi.hummer.render.style.HummerLayout r5 = (com.didi.hummer.render.style.HummerLayout) r5
            r5.removeView(r1)
            android.view.View r1 = r8.getView()
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            r1.addView(r4, r2)
            android.view.View r1 = r8.getView()
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            r1.addView(r10, r2)
            android.view.View r1 = r8.getView()
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            r1.addView(r3, r2)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r1 = r8.inlineBoxes
            r1.add(r3)
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r1 = r8.inlineBoxes
            r1.add(r4)
            goto L_0x0145
        L_0x0144:
            r10 = r2
        L_0x0145:
            boolean r1 = com.didi.hummer.render.style.HummerLayoutExtendUtils.isExtendCssView(r9)
            if (r1 == 0) goto L_0x0156
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r1 = r8.getDisplay()
            java.lang.String r1 = r1.value()
            com.didi.hummer.render.style.HummerLayoutExtendUtils.applyChildDisplayStyle(r1, r9)
        L_0x0156:
            if (r0 == 0) goto L_0x0161
            android.view.View r9 = r8.getView()
            com.didi.hummer.render.style.HummerLayout r9 = (com.didi.hummer.render.style.HummerLayout) r9
            r9.replaceView(r0, r10)
        L_0x0161:
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r9 = r8.getDisplay()
            com.didi.hummer.render.style.HummerLayoutExtendUtils$Display r10 = com.didi.hummer.render.style.HummerLayoutExtendUtils.Display.BLOCK
            if (r9 != r10) goto L_0x016c
            r8.mergeInlineBox()
        L_0x016c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.render.component.view.HummerLayoutExtendView.replaceChild(com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.HMBase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0012 A[LOOP:0: B:3:0x0012->B:6:0x0022, LOOP_START, PHI: r0 
      PHI: (r0v6 com.didi.hummer.render.component.view.HMBase) = (r0v2 com.didi.hummer.render.component.view.HMBase), (r0v9 com.didi.hummer.render.component.view.HMBase) binds: [B:2:0x000c, B:6:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.hummer.render.component.view.HMBase getElementById(java.lang.String r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.getView()
            com.didi.hummer.render.style.HummerLayout r0 = (com.didi.hummer.render.style.HummerLayout) r0
            com.didi.hummer.render.component.view.HMBase r0 = r0.getViewById(r5)
            if (r0 != 0) goto L_0x0024
            java.util.List<com.didi.hummer.render.component.view.InlineBox> r1 = r4.inlineBoxes
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0024
            java.lang.Object r0 = r1.next()
            com.didi.hummer.render.component.view.InlineBox r0 = (com.didi.hummer.render.component.view.InlineBox) r0
            com.didi.hummer.render.component.view.HMBase r0 = r0.getSubview(r5)
            if (r0 == 0) goto L_0x0012
        L_0x0024:
            if (r0 != 0) goto L_0x004d
            java.util.Map<com.didi.hummer.render.component.view.HMBase, com.didi.hummer.render.component.view.FixedNoneBox> r1 = r4.fixedNoneBoxMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0030:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getKey()
            com.didi.hummer.render.component.view.HMBase r2 = (com.didi.hummer.render.component.view.HMBase) r2
            java.lang.String r3 = r2.getViewID()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0030
            r0 = r2
        L_0x004d:
            if (r0 == 0) goto L_0x0056
            com.didi.hummer.core.engine.JSValue r5 = r0.getJSValue()
            r5.protect()
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hummer.render.component.view.HummerLayoutExtendView.getElementById(java.lang.String):com.didi.hummer.render.component.view.HMBase");
    }

    public void dispatchChildPositionChanged(HMBase hMBase, HummerLayoutExtendUtils.Position position, HummerLayoutExtendUtils.Position position2) {
        if (position == HummerLayoutExtendUtils.Position.FIXED && position2 == HummerLayoutExtendUtils.Position.YOGA && this.fixedNoneBoxMap.containsKey(hMBase)) {
            this.hummerContext.getContainer().removeView(hMBase);
            ((HummerLayout) getView()).replaceView(hMBase, this.fixedNoneBoxMap.remove(hMBase));
        }
        if (position == HummerLayoutExtendUtils.Position.YOGA && position2 == HummerLayoutExtendUtils.Position.FIXED) {
            FixedNoneBox fixedNoneBox = new FixedNoneBox(this.hummerContext);
            this.fixedNoneBoxMap.put(hMBase, fixedNoneBox);
            ((HummerLayout) getView()).replaceView(fixedNoneBox, hMBase);
            this.hummerContext.getContainer().addView(hMBase);
        }
        if (getDisplay() == HummerLayoutExtendUtils.Display.BLOCK) {
            mergeInlineBox();
        }
    }

    public void dispatchChildDisplayChanged(HMBase hMBase, HummerLayoutExtendUtils.Display display, HummerLayoutExtendUtils.Display display2) {
        if (getDisplay() == HummerLayoutExtendUtils.Display.BLOCK) {
            if ((display == HummerLayoutExtendUtils.Display.BLOCK || display == HummerLayoutExtendUtils.Display.YOGA) && (display2 == HummerLayoutExtendUtils.Display.INLINE || display2 == HummerLayoutExtendUtils.Display.INLINE_BLOCK)) {
                InlineBox inlineBox = new InlineBox(this.hummerContext);
                this.inlineBoxes.add(inlineBox);
                ((HummerLayout) getView()).replaceView(inlineBox, hMBase);
                hMBase.setInlineBox(inlineBox);
                inlineBox.add(hMBase);
            } else if ((display == HummerLayoutExtendUtils.Display.INLINE || display == HummerLayoutExtendUtils.Display.INLINE_BLOCK) && ((display2 == HummerLayoutExtendUtils.Display.BLOCK || display2 == HummerLayoutExtendUtils.Display.YOGA) && hMBase.getInlineBox() != null)) {
                InlineBox inlineBox2 = hMBase.getInlineBox();
                int indexOf = inlineBox2.getChildren().indexOf(hMBase);
                InlineBox inlineBox3 = new InlineBox(this.hummerContext);
                InlineBox inlineBox4 = new InlineBox(this.hummerContext);
                int i = 0;
                while (!inlineBox2.isChildrenEmpty()) {
                    HMBase hMBase2 = inlineBox2.getChildren().get(0);
                    if (i < indexOf) {
                        inlineBox2.remove(hMBase2);
                        inlineBox3.add(hMBase2);
                        hMBase2.setInlineBox(inlineBox3);
                    } else if (i > indexOf) {
                        inlineBox2.remove(hMBase2);
                        inlineBox4.add(hMBase2);
                        hMBase2.setInlineBox(inlineBox4);
                    } else {
                        inlineBox2.remove(hMBase2);
                    }
                    i++;
                }
                int indexOf2 = getYogaNode().indexOf(inlineBox2.getYogaNode());
                ((HummerLayout) getView()).removeView(inlineBox2);
                ((HummerLayout) getView()).addView(inlineBox4, indexOf2);
                ((HummerLayout) getView()).addView(hMBase, indexOf2);
                ((HummerLayout) getView()).addView(inlineBox3, indexOf2);
                this.inlineBoxes.add(inlineBox3);
                this.inlineBoxes.add(inlineBox4);
            }
        }
        if (getDisplay() == HummerLayoutExtendUtils.Display.BLOCK) {
            mergeInlineBox();
        }
    }

    public List<HMBase> getChildren() {
        return this.children;
    }

    private void mergeInlineBox() {
        Collections.sort(this.inlineBoxes, new Comparator<InlineBox>() {
            public int compare(InlineBox inlineBox, InlineBox inlineBox2) {
                return HummerLayoutExtendView.this.getYogaNode().indexOf(inlineBox.getYogaNode()) - HummerLayoutExtendView.this.getYogaNode().indexOf(inlineBox2.getYogaNode());
            }
        });
        Iterator<InlineBox> it = this.inlineBoxes.iterator();
        while (it.hasNext()) {
            InlineBox next = it.next();
            if (next.isChildrenEmpty()) {
                ((HummerLayout) getView()).removeView(next);
                it.remove();
            }
        }
        ArrayList<List> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(arrayList2);
        int i = 1073741823;
        for (InlineBox next2 : this.inlineBoxes) {
            int indexOf = getYogaNode().indexOf(next2.getYogaNode());
            if (indexOf - i == 1) {
                arrayList2.add(next2);
            } else {
                arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                arrayList2.add(next2);
            }
            i = indexOf;
        }
        for (List list : arrayList) {
            if (list.size() >= 2) {
                InlineBox inlineBox = new InlineBox(this.hummerContext);
                this.inlineBoxes.add(inlineBox);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    InlineBox inlineBox2 = (InlineBox) list.get(i2);
                    if (i2 == 0) {
                        ((HummerLayout) getView()).insertBefore(inlineBox, inlineBox2);
                    }
                    while (!inlineBox2.isChildrenEmpty()) {
                        HMBase hMBase = inlineBox2.getChildren().get(0);
                        inlineBox2.remove(hMBase);
                        inlineBox.add(hMBase);
                        hMBase.setInlineBox(inlineBox);
                    }
                    this.inlineBoxes.remove(inlineBox2);
                    ((HummerLayout) getView()).removeView(inlineBox2);
                }
            }
        }
    }
}
