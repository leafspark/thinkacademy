package com.luck.picture.lib.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.List;

public class FolderPopWindow extends PopupWindow {
    private PictureAlbumDirectoryAdapter adapter;
    private int chooseMode;
    private PictureSelectionConfig config;
    private Context context;
    private Drawable drawableDown;
    private Drawable drawableUp;
    private boolean isDismiss = false;
    private ImageView ivArrowView;
    private RecyclerView mRecyclerView;
    private int maxHeight;
    private View rootViewBg;
    private View window;

    public FolderPopWindow(Context context2) {
        this.context = context2;
        PictureSelectionConfig instance = PictureSelectionConfig.getInstance();
        this.config = instance;
        this.chooseMode = instance.chooseMode;
        LayoutInflater from = LayoutInflater.from(context2);
        int i = R.layout.picture_window_folder;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
        this.window = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable != 0) {
                this.drawableUp = ContextCompat.getDrawable(context2, PictureSelectionConfig.uiStyle.picture_top_titleArrowUpDrawable);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable != 0) {
                this.drawableDown = ContextCompat.getDrawable(context2, PictureSelectionConfig.uiStyle.picture_top_titleArrowDownDrawable);
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleUpResId != 0) {
                this.drawableUp = ContextCompat.getDrawable(context2, PictureSelectionConfig.style.pictureTitleUpResId);
            }
            if (PictureSelectionConfig.style.pictureTitleDownResId != 0) {
                this.drawableDown = ContextCompat.getDrawable(context2, PictureSelectionConfig.style.pictureTitleDownResId);
            }
        } else if (this.config.isWeChatStyle) {
            this.drawableUp = ContextCompat.getDrawable(context2, R.drawable.picture_icon_wechat_up);
            this.drawableDown = ContextCompat.getDrawable(context2, R.drawable.picture_icon_wechat_down);
        } else {
            if (this.config.upResId != 0) {
                this.drawableUp = ContextCompat.getDrawable(context2, this.config.upResId);
            } else {
                this.drawableUp = AttrsUtils.getTypeValueDrawable(context2, R.attr.picture_arrow_up_icon, R.drawable.picture_icon_arrow_up);
            }
            if (this.config.downResId != 0) {
                this.drawableDown = ContextCompat.getDrawable(context2, this.config.downResId);
            } else {
                this.drawableDown = AttrsUtils.getTypeValueDrawable(context2, R.attr.picture_arrow_down_icon, R.drawable.picture_icon_arrow_down);
            }
        }
        this.maxHeight = (int) (((double) ScreenUtils.getScreenHeight(context2)) * 0.6d);
        initView();
    }

    public void initView() {
        this.rootViewBg = this.window.findViewById(R.id.rootViewBg);
        this.adapter = new PictureAlbumDirectoryAdapter(this.config);
        RecyclerView findViewById = this.window.findViewById(R.id.folder_list);
        this.mRecyclerView = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.context));
        this.mRecyclerView.setAdapter(this.adapter);
        View findViewById2 = this.window.findViewById(R.id.rootView);
        this.rootViewBg.setOnClickListener(new FolderPopWindow$$ExternalSyntheticLambda0(this));
        if (Build.VERSION.SDK_INT < 21) {
            findViewById2.setOnClickListener(new FolderPopWindow$$ExternalSyntheticLambda1(this));
        }
    }

    public /* synthetic */ void lambda$initView$0$FolderPopWindow(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void lambda$initView$1$FolderPopWindow(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void bindFolder(List<LocalMediaFolder> list) {
        this.adapter.setChooseMode(this.chooseMode);
        this.adapter.bindFolderData(list);
        this.mRecyclerView.getLayoutParams().height = (list == null || list.size() <= 8) ? -2 : this.maxHeight;
    }

    public List<LocalMediaFolder> getFolderData() {
        return this.adapter.getFolderData();
    }

    public boolean isEmpty() {
        return this.adapter.getFolderData().size() == 0;
    }

    public LocalMediaFolder getFolder(int i) {
        if (this.adapter.getFolderData().size() <= 0 || i >= this.adapter.getFolderData().size()) {
            return null;
        }
        return this.adapter.getFolderData().get(i);
    }

    public void setArrowImageView(ImageView imageView) {
        this.ivArrowView = imageView;
    }

    public void showAsDropDown(View view) {
        try {
            if (Build.VERSION.SDK_INT == 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.isDismiss = false;
            this.ivArrowView.setImageDrawable(this.drawableUp);
            AnimUtils.rotateArrow(this.ivArrowView, true);
            this.rootViewBg.animate().alpha(1.0f).setDuration(250).setStartDelay(250).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.adapter.setOnAlbumItemClickListener(onAlbumItemClickListener);
    }

    public void dismiss() {
        if (!this.isDismiss) {
            this.rootViewBg.animate().alpha(0.0f).setDuration(50).start();
            this.ivArrowView.setImageDrawable(this.drawableDown);
            AnimUtils.rotateArrow(this.ivArrowView, false);
            this.isDismiss = true;
            super.dismiss();
            this.isDismiss = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r5.setCheckedNum(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateFolderCheckStatus(java.util.List<com.luck.picture.lib.entity.LocalMedia> r12) {
        /*
            r11 = this;
            com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter r0 = r11.adapter     // Catch:{ Exception -> 0x004d }
            java.util.List r0 = r0.getFolderData()     // Catch:{ Exception -> 0x004d }
            int r1 = r0.size()     // Catch:{ Exception -> 0x004d }
            int r2 = r12.size()     // Catch:{ Exception -> 0x004d }
            r3 = 0
            r4 = r3
        L_0x0010:
            if (r4 >= r1) goto L_0x0047
            java.lang.Object r5 = r0.get(r4)     // Catch:{ Exception -> 0x004d }
            com.luck.picture.lib.entity.LocalMediaFolder r5 = (com.luck.picture.lib.entity.LocalMediaFolder) r5     // Catch:{ Exception -> 0x004d }
            r5.setCheckedNum(r3)     // Catch:{ Exception -> 0x004d }
            r6 = r3
        L_0x001c:
            if (r6 >= r2) goto L_0x0044
            java.lang.Object r7 = r12.get(r6)     // Catch:{ Exception -> 0x004d }
            com.luck.picture.lib.entity.LocalMedia r7 = (com.luck.picture.lib.entity.LocalMedia) r7     // Catch:{ Exception -> 0x004d }
            java.lang.String r8 = r5.getName()     // Catch:{ Exception -> 0x004d }
            java.lang.String r7 = r7.getParentFolderName()     // Catch:{ Exception -> 0x004d }
            boolean r7 = r8.equals(r7)     // Catch:{ Exception -> 0x004d }
            if (r7 != 0) goto L_0x0040
            long r7 = r5.getBucketId()     // Catch:{ Exception -> 0x004d }
            r9 = -1
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            int r6 = r6 + 1
            goto L_0x001c
        L_0x0040:
            r6 = 1
            r5.setCheckedNum(r6)     // Catch:{ Exception -> 0x004d }
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x0010
        L_0x0047:
            com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter r12 = r11.adapter     // Catch:{ Exception -> 0x004d }
            r12.bindFolderData(r0)     // Catch:{ Exception -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.widget.FolderPopWindow.updateFolderCheckStatus(java.util.List):void");
    }
}
