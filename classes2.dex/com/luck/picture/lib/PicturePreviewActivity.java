package com.luck.picture.lib;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.manager.UCropManager;
import com.luck.picture.lib.model.LocalMediaPageLoader;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.SdkVersionUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.tools.VoiceUtils;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PicturePreviewActivity extends PictureBaseActivity implements View.OnClickListener, PictureSimpleFragmentAdapter.OnCallBackActivity {
    public static final String TAG = "PicturePreviewActivity";
    protected PictureSimpleFragmentAdapter adapter;
    protected Animation animation;
    protected View btnCheck;
    protected TextView check;
    protected String currentDirectory;
    protected String fileSize;
    protected int index;
    protected boolean isBottomPreview;
    protected boolean isChangeSelectedData;
    protected boolean isCompleteOrSelected;
    protected boolean isShowCamera;
    protected CheckBox mCbOriginal;
    protected ImageView mIvArrow;
    private int mPage = 0;
    protected TextView mPictureEditor;
    protected View mPicturePreview;
    protected ViewGroup mTitleBar;
    protected TextView mTvPictureOk;
    protected TextView mTvPictureRight;
    protected ImageView pictureLeftBack;
    protected int position;
    protected boolean refresh;
    protected int screenWidth;
    protected RelativeLayout selectBarLayout;
    protected List<LocalMedia> selectData = new ArrayList();
    private int totalNumber;
    protected TextView tvMediaNum;
    protected TextView tvTitle;
    protected PreviewViewPager viewPager;

    /* access modifiers changed from: protected */
    public void onPageSelectedChange(LocalMedia localMedia) {
    }

    /* access modifiers changed from: protected */
    public void onSelectedChange(boolean z, LocalMedia localMedia) {
    }

    /* access modifiers changed from: protected */
    public void onUpdateGalleryChange(LocalMedia localMedia) {
    }

    /* access modifiers changed from: protected */
    public void onUpdateSelectedChange(LocalMedia localMedia) {
    }

    public int getResourceId() {
        return R.layout.picture_preview;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            List<LocalMedia> obtainSelectorList = PictureSelector.obtainSelectorList(bundle);
            if (obtainSelectorList == null) {
                obtainSelectorList = this.selectData;
            }
            this.selectData = obtainSelectorList;
            this.isCompleteOrSelected = bundle.getBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, false);
            this.isChangeSelectedData = bundle.getBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, false);
            onImageChecked(this.position);
            onSelectNumChange(false);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, android.view.View$OnClickListener, com.luck.picture.lib.PicturePreviewActivity, com.luck.picture.lib.PictureBaseActivity] */
    /* access modifiers changed from: protected */
    public void initWidgets() {
        super.initWidgets();
        this.mTitleBar = (ViewGroup) findViewById(R.id.titleBar);
        this.screenWidth = ScreenUtils.getScreenWidth(this);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        this.pictureLeftBack = (ImageView) findViewById(R.id.pictureLeftBack);
        this.mTvPictureRight = (TextView) findViewById(R.id.picture_right);
        this.mIvArrow = (ImageView) findViewById(R.id.ivArrow);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        this.mPicturePreview = findViewById(R.id.picture_id_preview);
        this.mPictureEditor = (TextView) findViewById(R.id.picture_id_editor);
        this.btnCheck = findViewById(R.id.btnCheck);
        this.check = (TextView) findViewById(R.id.check);
        this.pictureLeftBack.setOnClickListener(this);
        this.mTvPictureOk = (TextView) findViewById(R.id.picture_tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.tvMediaNum = (TextView) findViewById(R.id.tv_media_num);
        this.selectBarLayout = (RelativeLayout) findViewById(R.id.select_bar_layout);
        this.mTvPictureOk.setOnClickListener(this);
        this.tvMediaNum.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.picture_title);
        this.mPicturePreview.setVisibility(8);
        this.mIvArrow.setVisibility(8);
        this.mTvPictureRight.setVisibility(8);
        this.check.setVisibility(0);
        this.btnCheck.setVisibility(0);
        if (this.config.isEditorImage) {
            this.mPictureEditor.setVisibility(0);
            this.mPictureEditor.setOnClickListener(this);
        } else {
            this.mPictureEditor.setVisibility(8);
        }
        this.position = getIntent().getIntExtra("position", 0);
        if (this.numComplete) {
            initCompleteText(0);
        }
        this.tvMediaNum.setSelected(this.config.checkNumMode);
        this.btnCheck.setOnClickListener(this);
        if (getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST) != null) {
            this.selectData = getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
        }
        this.isBottomPreview = getIntent().getBooleanExtra(PictureConfig.EXTRA_BOTTOM_PREVIEW, false);
        this.isShowCamera = getIntent().getBooleanExtra(PictureConfig.EXTRA_SHOW_CAMERA, this.config.isCamera);
        this.currentDirectory = getIntent().getStringExtra(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY);
        if (this.isBottomPreview) {
            initViewPageAdapterData(getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST));
        } else {
            ArrayList arrayList = new ArrayList(ImagesObservable.getInstance().getData());
            ImagesObservable.getInstance().clearData();
            this.totalNumber = getIntent().getIntExtra(PictureConfig.EXTRA_DATA_COUNT, 0);
            if (!this.config.isPageStrategy) {
                initViewPageAdapterData(arrayList);
                if (arrayList.size() == 0) {
                    this.config.isPageStrategy = true;
                    setNewTitle();
                    loadData();
                }
            } else if (arrayList.size() == 0) {
                setNewTitle();
                initViewPageAdapterData(arrayList);
                loadData();
            } else {
                this.mPage = getIntent().getIntExtra(PictureConfig.EXTRA_PAGE, 0);
                setTitle();
                initViewPageAdapterData(arrayList);
            }
        }
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
                PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                picturePreviewActivity.isPreviewEggs(picturePreviewActivity.config.previewEggs, i, i2);
            }

            public void onPageSelected(int i) {
                PicturePreviewActivity.this.position = i;
                PicturePreviewActivity.this.setTitle();
                LocalMedia item = PicturePreviewActivity.this.adapter.getItem(PicturePreviewActivity.this.position);
                if (item != null) {
                    PicturePreviewActivity.this.index = item.getPosition();
                    if (!PicturePreviewActivity.this.config.previewEggs) {
                        if (PicturePreviewActivity.this.config.checkNumMode) {
                            PicturePreviewActivity.this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                            PicturePreviewActivity.this.notifyCheckChanged(item);
                        }
                        PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                        picturePreviewActivity.onImageChecked(picturePreviewActivity.position);
                    }
                    int i2 = 0;
                    if (PicturePreviewActivity.this.config.isOriginalControl) {
                        PicturePreviewActivity.this.mCbOriginal.setChecked(PicturePreviewActivity.this.config.isCheckOriginalImage);
                        if (PicturePreviewActivity.this.config.isDisplayOriginalSize) {
                            PicturePreviewActivity.this.fileSize = PictureFileUtils.formatFileSize(item.getSize(), 2);
                            PicturePreviewActivity.this.mCbOriginal.setText(PicturePreviewActivity.this.getString(R.string.picture_original_image, new Object[]{PicturePreviewActivity.this.fileSize}));
                        } else {
                            PicturePreviewActivity.this.mCbOriginal.setText(PicturePreviewActivity.this.getString(R.string.picture_default_original_image));
                        }
                    }
                    if (PicturePreviewActivity.this.config.isEditorImage) {
                        TextView textView = PicturePreviewActivity.this.mPictureEditor;
                        if (PictureMimeType.isHasVideo(item.getMimeType())) {
                            i2 = 8;
                        }
                        textView.setVisibility(i2);
                    } else {
                        PicturePreviewActivity.this.mPictureEditor.setVisibility(8);
                    }
                    PicturePreviewActivity.this.onPageSelectedChange(item);
                    if (PicturePreviewActivity.this.config.isPageStrategy && !PicturePreviewActivity.this.isBottomPreview && PicturePreviewActivity.this.isHasMore) {
                        if (PicturePreviewActivity.this.position == (PicturePreviewActivity.this.adapter.getSize() - 1) - 10 || PicturePreviewActivity.this.position == PicturePreviewActivity.this.adapter.getSize() - 1) {
                            PicturePreviewActivity.this.loadMoreData();
                        }
                    }
                }
            }
        });
        if (this.config.isOriginalControl) {
            boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            this.mCbOriginal.setVisibility(0);
            this.config.isCheckOriginalImage = booleanExtra;
            this.mCbOriginal.setChecked(this.config.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new PicturePreviewActivity$$ExternalSyntheticLambda0(this));
        }
    }

    public /* synthetic */ void lambda$initWidgets$0$PicturePreviewActivity(CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
        if (this.selectData.size() == 0 && z) {
            onCheckedComplete();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    private void loadData() {
        long longExtra = getIntent().getLongExtra(PictureConfig.EXTRA_BUCKET_ID, -1);
        this.mPage++;
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new PicturePreviewActivity$$ExternalSyntheticLambda1(this));
    }

    public /* synthetic */ void lambda$loadData$1$PicturePreviewActivity(List list, int i, boolean z) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (!isFinishing()) {
            this.isHasMore = z;
            if (!z) {
                return;
            }
            if (list.size() <= 0 || (pictureSimpleFragmentAdapter = this.adapter) == null) {
                loadMoreData();
                return;
            }
            pictureSimpleFragmentAdapter.getData().addAll(list);
            this.adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public void loadMoreData() {
        long longExtra = getIntent().getLongExtra(PictureConfig.EXTRA_BUCKET_ID, -1);
        this.mPage++;
        LocalMediaPageLoader.getInstance(getContext()).loadPageMediaData(longExtra, this.mPage, this.config.pageSize, new PicturePreviewActivity$$ExternalSyntheticLambda2(this));
    }

    public /* synthetic */ void lambda$loadMoreData$2$PicturePreviewActivity(List list, int i, boolean z) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter;
        if (!isFinishing()) {
            this.isHasMore = z;
            if (!z) {
                return;
            }
            if (list.size() <= 0 || (pictureSimpleFragmentAdapter = this.adapter) == null) {
                loadMoreData();
                return;
            }
            pictureSimpleFragmentAdapter.getData().addAll(list);
            this.adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void initCompleteText(int i) {
        String str;
        String str2;
        String str3;
        int i2;
        String str4;
        int i3;
        if (this.config.selectionMode == 1) {
            if (i <= 0) {
                if (PictureSelectionConfig.uiStyle != null) {
                    TextView textView = this.mTvPictureOk;
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                        i3 = PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText;
                    } else {
                        i3 = R.string.picture_please_select;
                    }
                    textView.setText(getString(i3));
                } else if (PictureSelectionConfig.style != null) {
                    TextView textView2 = this.mTvPictureOk;
                    if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                        str4 = PictureSelectionConfig.style.pictureUnCompleteText;
                    } else {
                        str4 = getString(R.string.picture_please_select);
                    }
                    textView2.setText(str4);
                }
            } else if (PictureSelectionConfig.uiStyle != null) {
                if (!PictureSelectionConfig.uiStyle.isCompleteReplaceNum || PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText == 0) {
                    TextView textView3 = this.mTvPictureOk;
                    if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                        i2 = PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText;
                    } else {
                        i2 = R.string.picture_done;
                    }
                    textView3.setText(getString(i2));
                    return;
                }
                this.mTvPictureOk.setText(String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), new Object[]{Integer.valueOf(i), 1}));
            } else if (PictureSelectionConfig.style == null) {
            } else {
                if (!PictureSelectionConfig.style.isCompleteReplaceNum || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                    TextView textView4 = this.mTvPictureOk;
                    if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                        str3 = PictureSelectionConfig.style.pictureCompleteText;
                    } else {
                        str3 = getString(R.string.picture_done);
                    }
                    textView4.setText(str3);
                    return;
                }
                this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(i), 1}));
            }
        } else if (i <= 0) {
            if (PictureSelectionConfig.uiStyle != null) {
                TextView textView5 = this.mTvPictureOk;
                if (!PictureSelectionConfig.uiStyle.isCompleteReplaceNum || PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText == 0) {
                    str2 = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                } else {
                    str2 = String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText), new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                }
                textView5.setText(str2);
            } else if (PictureSelectionConfig.style != null) {
                TextView textView6 = this.mTvPictureOk;
                if (!PictureSelectionConfig.style.isCompleteReplaceNum || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    str = getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)});
                } else {
                    str = PictureSelectionConfig.style.pictureUnCompleteText;
                }
                textView6.setText(str);
            }
        } else if (PictureSelectionConfig.uiStyle != null) {
            if (!PictureSelectionConfig.uiStyle.isCompleteReplaceNum || PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText == 0) {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
                return;
            }
            this.mTvPictureOk.setText(String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText), new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
        } else if (PictureSelectionConfig.style == null) {
        } else {
            if (!PictureSelectionConfig.style.isCompleteReplaceNum || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(getString(R.string.picture_done_front_num, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
                return;
            }
            this.mTvPictureOk.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(i), Integer.valueOf(this.config.maxSelectNum)}));
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PicturePreviewActivity] */
    public void initPictureSelectorStyle() {
        ColorStateList colorStateList;
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.uiStyle.picture_top_titleTextColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleTextSize != 0) {
                this.tvTitle.setTextSize((float) PictureSelectionConfig.uiStyle.picture_top_titleTextSize);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_leftBack != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.uiStyle.picture_top_leftBack);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground != 0) {
                this.tvMediaNum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_bottom_completeRedDotBackground);
            }
            if (PictureSelectionConfig.uiStyle.picture_check_style != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_check_style);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor.length > 0 && (colorStateList = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_bottom_completeTextColor)) != null) {
                this.mTvPictureOk.setTextColor(colorStateList);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_top_titleBarHeight;
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barHeight > 0) {
                this.selectBarLayout.getLayoutParams().height = PictureSelectionConfig.uiStyle.picture_bottom_barHeight;
            }
            if (this.config.isEditorImage) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextSize != 0) {
                    this.mPictureEditor.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextSize);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextColor != 0) {
                    this.mPictureEditor.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_preview_editorTextColor);
                }
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureTitleTextColor != 0) {
                this.tvTitle.setTextColor(PictureSelectionConfig.style.pictureTitleTextColor);
            }
            if (PictureSelectionConfig.style.pictureTitleTextSize != 0) {
                this.tvTitle.setTextSize((float) PictureSelectionConfig.style.pictureTitleTextSize);
            }
            if (PictureSelectionConfig.style.pictureLeftBackIcon != 0) {
                this.pictureLeftBack.setImageResource(PictureSelectionConfig.style.pictureLeftBackIcon);
            }
            if (PictureSelectionConfig.style.picturePreviewBottomBgColor != 0) {
                this.selectBarLayout.setBackgroundColor(PictureSelectionConfig.style.picturePreviewBottomBgColor);
            }
            if (PictureSelectionConfig.style.pictureCheckNumBgStyle != 0) {
                this.tvMediaNum.setBackgroundResource(PictureSelectionConfig.style.pictureCheckNumBgStyle);
            }
            if (PictureSelectionConfig.style.pictureCheckedStyle != 0) {
                this.check.setBackgroundResource(PictureSelectionConfig.style.pictureCheckedStyle);
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
            if (PictureSelectionConfig.style.pictureTitleBarHeight > 0) {
                this.mTitleBar.getLayoutParams().height = PictureSelectionConfig.style.pictureTitleBarHeight;
            }
            if (this.config.isEditorImage) {
                if (PictureSelectionConfig.style.picturePreviewEditorTextSize != 0) {
                    this.mPictureEditor.setTextSize((float) PictureSelectionConfig.style.picturePreviewEditorTextSize);
                }
                if (PictureSelectionConfig.style.picturePreviewEditorTextColor != 0) {
                    this.mPictureEditor.setTextColor(PictureSelectionConfig.style.picturePreviewEditorTextColor);
                }
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.style.pictureOriginalControlStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.style.pictureOriginalControlStyle);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                if (PictureSelectionConfig.style.pictureOriginalFontColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.style.pictureOriginalFontColor);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.style.pictureOriginalTextSize != 0) {
                    this.mCbOriginal.setTextSize((float) PictureSelectionConfig.style.pictureOriginalTextSize);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
            }
        } else {
            this.check.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_checked_style, R.drawable.picture_checkbox_selector));
            ColorStateList typeValueColorStateList = AttrsUtils.getTypeValueColorStateList(getContext(), R.attr.picture_ac_preview_complete_textColor);
            if (typeValueColorStateList != null) {
                this.mTvPictureOk.setTextColor(typeValueColorStateList);
            }
            this.pictureLeftBack.setImageDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_preview_leftBack_icon, R.drawable.picture_icon_back));
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_title_textColor);
            if (typeValueColor != 0) {
                this.tvTitle.setTextColor(typeValueColor);
            }
            this.tvMediaNum.setBackground(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_num_style, R.drawable.picture_num_oval));
            int typeValueColor2 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_ac_preview_bottom_bg);
            if (typeValueColor2 != 0) {
                this.selectBarLayout.setBackgroundColor(typeValueColor2);
            }
            int typeValueSizeForInt = AttrsUtils.getTypeValueSizeForInt(getContext(), R.attr.picture_titleBar_height);
            if (typeValueSizeForInt > 0) {
                this.mTitleBar.getLayoutParams().height = typeValueSizeForInt;
            }
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(AttrsUtils.getTypeValueDrawable(getContext(), R.attr.picture_original_check_style, R.drawable.picture_original_wechat_checkbox));
                int typeValueColor3 = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_original_text_color);
                if (typeValueColor3 != 0) {
                    this.mCbOriginal.setTextColor(typeValueColor3);
                }
            }
        }
        this.mTitleBar.setBackgroundColor(this.colorPrimary);
        onSelectNumChange(false);
    }

    /* access modifiers changed from: private */
    public void isPreviewEggs(boolean z, int i, int i2) {
        if (z && this.adapter.getSize() > 0) {
            if (i2 < this.screenWidth / 2) {
                LocalMedia item = this.adapter.getItem(i);
                if (item != null) {
                    this.check.setSelected(isSelected(item));
                    if (this.config.isWeChatStyle) {
                        onUpdateSelectedChange(item);
                    } else if (this.config.checkNumMode) {
                        this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                        notifyCheckChanged(item);
                        onImageChecked(i);
                    }
                }
            } else {
                int i3 = i + 1;
                LocalMedia item2 = this.adapter.getItem(i3);
                if (item2 != null) {
                    this.check.setSelected(isSelected(item2));
                    if (this.config.isWeChatStyle) {
                        onUpdateSelectedChange(item2);
                    } else if (this.config.checkNumMode) {
                        this.check.setText(ValueOf.toString(Integer.valueOf(item2.getNum())));
                        notifyCheckChanged(item2);
                        onImageChecked(i3);
                    }
                }
            }
        }
    }

    private void initViewPageAdapterData(List<LocalMedia> list) {
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = new PictureSimpleFragmentAdapter(getContext(), this.config, this);
        this.adapter = pictureSimpleFragmentAdapter;
        pictureSimpleFragmentAdapter.bindData(list);
        this.viewPager.setAdapter(this.adapter);
        this.viewPager.setCurrentItem(this.position);
        setTitle();
        onImageChecked(this.position);
        LocalMedia item = this.adapter.getItem(this.position);
        if (item != null) {
            this.index = item.getPosition();
            if (this.config.isOriginalControl) {
                if (this.config.isDisplayOriginalSize) {
                    this.fileSize = PictureFileUtils.formatFileSize(item.getSize(), 2);
                    this.mCbOriginal.setText(getString(R.string.picture_original_image, new Object[]{this.fileSize}));
                } else {
                    this.mCbOriginal.setText(getString(R.string.picture_default_original_image));
                }
            }
            if (this.config.checkNumMode) {
                this.tvMediaNum.setSelected(true);
                this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                notifyCheckChanged(item);
            }
        }
    }

    private void setNewTitle() {
        this.mPage = 0;
        this.position = 0;
        setTitle();
    }

    /* access modifiers changed from: private */
    public void setTitle() {
        if (!this.config.isPageStrategy || this.isBottomPreview) {
            this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.adapter.getSize())}));
            return;
        }
        this.tvTitle.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.totalNumber)}));
    }

    /* access modifiers changed from: private */
    public void notifyCheckChanged(LocalMedia localMedia) {
        if (this.config.checkNumMode) {
            this.check.setText("");
            int size = this.selectData.size();
            for (int i = 0; i < size; i++) {
                LocalMedia localMedia2 = this.selectData.get(i);
                if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    this.check.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                }
            }
        }
    }

    private void subSelectPosition() {
        int size = this.selectData.size();
        int i = 0;
        while (i < size) {
            i++;
            this.selectData.get(i).setNum(i);
        }
    }

    public void onImageChecked(int i) {
        if (this.adapter.getSize() > 0) {
            LocalMedia item = this.adapter.getItem(i);
            if (item != null) {
                this.check.setSelected(isSelected(item));
                return;
            }
            return;
        }
        this.check.setSelected(false);
    }

    /* access modifiers changed from: protected */
    public boolean isSelected(LocalMedia localMedia) {
        int size = this.selectData.size();
        for (int i = 0; i < size; i++) {
            LocalMedia localMedia2 = this.selectData.get(i);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSelectNumChange(boolean z) {
        this.refresh = z;
        if (this.selectData.size() != 0) {
            this.mTvPictureOk.setEnabled(true);
            this.mTvPictureOk.setSelected(true);
            if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                } else {
                    this.mTvPictureOk.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_fa632d));
                }
            }
            if (this.numComplete) {
                initCompleteText(this.selectData.size());
                return;
            }
            if (this.refresh) {
                this.tvMediaNum.startAnimation(this.animation);
            }
            this.tvMediaNum.setVisibility(0);
            this.tvMediaNum.setText(ValueOf.toString(Integer.valueOf(this.selectData.size())));
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText != 0) {
                    this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeNormalText);
                }
            } else if (PictureSelectionConfig.style == null) {
                this.mTvPictureOk.setText(getString(R.string.picture_completed));
            } else if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureCompleteText);
            }
        } else {
            this.mTvPictureOk.setEnabled(false);
            this.mTvPictureOk.setSelected(false);
            if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                    this.mTvPictureOk.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
                } else {
                    this.mTvPictureOk.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
                }
            }
            if (this.numComplete) {
                initCompleteText(0);
                return;
            }
            this.tvMediaNum.setVisibility(4);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText != 0) {
                    this.mTvPictureOk.setText(PictureSelectionConfig.uiStyle.picture_bottom_completeDefaultText);
                }
            } else if (PictureSelectionConfig.style == null) {
                this.mTvPictureOk.setText(getString(R.string.picture_please_select));
            } else if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
        }
    }

    public void onClick(View view) {
        MethodInfo.onClickEventEnter(view, PicturePreviewActivity.class);
        int id = view.getId();
        if (id == R.id.pictureLeftBack) {
            onBackPressed();
        } else if (id == R.id.picture_tv_ok || id == R.id.tv_media_num) {
            onComplete();
        } else if (id == R.id.btnCheck) {
            onCheckedComplete();
        } else if (id == R.id.picture_id_editor) {
            onEditorImage();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
        MethodInfo.onClickEventEnd();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.luck.picture.lib.PicturePreviewActivity, android.app.Activity] */
    /* access modifiers changed from: protected */
    public void onEditorImage() {
        if (this.adapter.getSize() > 0) {
            LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            UCropManager.ofEditorImage(this, (!item.isEditorImage() || TextUtils.isEmpty(item.getCutPath())) ? item.getPath() : item.getCutPath(), item.getMimeType());
        }
    }

    /* access modifiers changed from: protected */
    public void onCheckedComplete() {
        boolean z;
        LocalMedia localMedia;
        if (this.adapter.getSize() > 0) {
            LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
            String realPath = item.getRealPath();
            if (TextUtils.isEmpty(realPath) || new File(realPath).exists()) {
                String mimeType = this.selectData.size() > 0 ? this.selectData.get(0).getMimeType() : "";
                int size = this.selectData.size();
                if (this.config.isWithVideoImage) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        if (PictureMimeType.isHasVideo(this.selectData.get(i2).getMimeType())) {
                            i++;
                        }
                    }
                    if (PictureMimeType.isHasVideo(item.getMimeType())) {
                        if (this.config.maxVideoSelectNum <= 0) {
                            showPromptDialog(getString(R.string.picture_rule));
                            return;
                        } else if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                            showPromptDialog(getString(R.string.picture_message_max_num, new Object[]{Integer.valueOf(this.config.maxSelectNum)}));
                            return;
                        } else if (i >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                            showPromptDialog(StringUtils.getMsg(getContext(), item.getMimeType(), this.config.maxVideoSelectNum));
                            return;
                        } else if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < ((long) this.config.videoMinSecond)) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS)}));
                            return;
                        } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > ((long) this.config.videoMaxSecond)) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
                            return;
                        }
                    } else if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(getString(R.string.picture_message_max_num, new Object[]{Integer.valueOf(this.config.maxSelectNum)}));
                        return;
                    }
                } else if (!TextUtils.isEmpty(mimeType) && !PictureMimeType.isMimeTypeSame(mimeType, item.getMimeType())) {
                    showPromptDialog(getString(R.string.picture_rule));
                    return;
                } else if (!PictureMimeType.isHasVideo(mimeType) || this.config.maxVideoSelectNum <= 0) {
                    if (size >= this.config.maxSelectNum && !this.check.isSelected()) {
                        showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxSelectNum));
                        return;
                    } else if (PictureMimeType.isHasVideo(item.getMimeType())) {
                        if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < ((long) this.config.videoMinSecond)) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS)}));
                            return;
                        } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > ((long) this.config.videoMaxSecond)) {
                            showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
                            return;
                        }
                    }
                } else if (size >= this.config.maxVideoSelectNum && !this.check.isSelected()) {
                    showPromptDialog(StringUtils.getMsg(getContext(), mimeType, this.config.maxVideoSelectNum));
                    return;
                } else if (!this.check.isSelected() && this.config.videoMinSecond > 0 && item.getDuration() < ((long) this.config.videoMinSecond)) {
                    showPromptDialog(getContext().getString(R.string.picture_choose_min_seconds, new Object[]{Integer.valueOf(this.config.videoMinSecond / ResultCode.KARAOKE_SUCCESS)}));
                    return;
                } else if (!this.check.isSelected() && this.config.videoMaxSecond > 0 && item.getDuration() > ((long) this.config.videoMaxSecond)) {
                    showPromptDialog(getContext().getString(R.string.picture_choose_max_seconds, new Object[]{Integer.valueOf(this.config.videoMaxSecond / ResultCode.KARAOKE_SUCCESS)}));
                    return;
                }
                if (!this.check.isSelected()) {
                    this.check.setSelected(true);
                    this.check.startAnimation(this.animation);
                    z = true;
                } else {
                    this.check.setSelected(false);
                    z = false;
                }
                this.isChangeSelectedData = true;
                if (z) {
                    VoiceUtils.getInstance().play();
                    if (this.config.selectionMode == 1) {
                        this.selectData.clear();
                    }
                    this.selectData.add(item);
                    onSelectedChange(true, item);
                    item.setNum(this.selectData.size());
                    if (this.config.checkNumMode) {
                        this.check.setText(ValueOf.toString(Integer.valueOf(item.getNum())));
                    }
                } else {
                    int size2 = this.selectData.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size2) {
                            break;
                        }
                        localMedia = this.selectData.get(i3);
                        if (localMedia.getPath().equals(item.getPath()) || localMedia.getId() == item.getId()) {
                            this.selectData.remove(localMedia);
                            onSelectedChange(false, item);
                            subSelectPosition();
                            notifyCheckChanged(localMedia);
                        } else {
                            i3++;
                        }
                    }
                    this.selectData.remove(localMedia);
                    onSelectedChange(false, item);
                    subSelectPosition();
                    notifyCheckChanged(localMedia);
                }
                onSelectNumChange(true);
                return;
            }
            ToastUtils.s(getContext(), PictureMimeType.s(getContext(), item.getMimeType()));
        }
    }

    /* access modifiers changed from: protected */
    public void onComplete() {
        int size = this.selectData.size();
        LocalMedia localMedia = this.selectData.size() > 0 ? this.selectData.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        if (this.config.isWithVideoImage) {
            int size2 = this.selectData.size();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                if (PictureMimeType.isHasVideo(this.selectData.get(i3).getMimeType())) {
                    i2++;
                } else {
                    i++;
                }
            }
            if (this.config.selectionMode == 2) {
                if (this.config.minSelectNum > 0 && i < this.config.minSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                    return;
                } else if (this.config.minVideoSelectNum > 0 && i2 < this.config.minVideoSelectNum) {
                    showPromptDialog(getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
        } else if (this.config.selectionMode == 2) {
            if (PictureMimeType.isHasImage(mimeType) && this.config.minSelectNum > 0 && size < this.config.minSelectNum) {
                showPromptDialog(getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                return;
            } else if (PictureMimeType.isHasVideo(mimeType) && this.config.minVideoSelectNum > 0 && size < this.config.minVideoSelectNum) {
                showPromptDialog(getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                return;
            }
        }
        this.isCompleteOrSelected = true;
        this.isChangeSelectedData = true;
        if (this.config.chooseMode != PictureMimeType.ofAll() || !this.config.isWithVideoImage) {
            separateMimeTypeWith(mimeType, localMedia);
        } else {
            bothMimeTypeWith(mimeType, localMedia);
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.luck.picture.lib.PicturePreviewActivity, android.app.Activity] */
    private void bothMimeTypeWith(String str, LocalMedia localMedia) {
        if (!this.config.enableCrop || this.config.isCheckOriginalImage) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        boolean isHasImage = PictureMimeType.isHasImage(str);
        if (this.config.selectionMode != 1 || !isHasImage) {
            int size = this.selectData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                LocalMedia localMedia2 = this.selectData.get(i2);
                if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath()) && PictureMimeType.isHasImage(localMedia2.getMimeType())) {
                    i++;
                }
            }
            if (i <= 0) {
                this.isCompleteOrSelected = true;
                onBackPressed();
                return;
            }
            UCropManager.ofCrop(this, (ArrayList) this.selectData);
            return;
        }
        this.config.originalPath = localMedia.getPath();
        UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.luck.picture.lib.PicturePreviewActivity, android.app.Activity] */
    private void separateMimeTypeWith(String str, LocalMedia localMedia) {
        if (!this.config.enableCrop || this.config.isCheckOriginalImage || !PictureMimeType.isHasImage(str)) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        if (this.config.selectionMode == 1) {
            this.config.originalPath = localMedia.getPath();
            UCropManager.ofCrop(this, this.config.originalPath, localMedia.getMimeType());
            return;
        }
        UCropManager.ofCrop(this, (ArrayList) this.selectData);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Throwable th;
        boolean z;
        LocalMedia localMedia;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i != 69) {
                if (i == 609) {
                    intent.putParcelableArrayListExtra("com.yalantis.ucrop.OutputUriList", UCrop.getMultipleOutput(intent));
                    intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
                    setResult(-1, intent);
                    finish();
                }
            } else if (intent == null) {
            } else {
                if (intent.getBooleanExtra("com.yalantis.ucrop.EditorImage", false)) {
                    Uri output = UCrop.getOutput(intent);
                    if (output != null && this.adapter != null) {
                        String path = output.getPath();
                        LocalMedia item = this.adapter.getItem(this.viewPager.getCurrentItem());
                        LocalMedia localMedia2 = null;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= this.selectData.size()) {
                                z = false;
                                break;
                            }
                            localMedia = this.selectData.get(i3);
                            if (TextUtils.equals(item.getPath(), localMedia.getPath()) || item.getId() == localMedia.getId()) {
                                localMedia2 = localMedia;
                                z = true;
                            } else {
                                i3++;
                            }
                        }
                        localMedia2 = localMedia;
                        z = true;
                        item.setCut(!TextUtils.isEmpty(path));
                        item.setCutPath(path);
                        item.setCropOffsetX(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
                        item.setCropOffsetY(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
                        item.setCropResultAspectRatio(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
                        item.setCropImageWidth(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
                        item.setCropImageHeight(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
                        item.setEditorImage(item.isCut());
                        if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(item.getPath())) {
                            item.setAndroidQToPath(path);
                        }
                        if (z) {
                            localMedia2.setCut(!TextUtils.isEmpty(path));
                            localMedia2.setCutPath(path);
                            localMedia2.setCropOffsetX(intent.getIntExtra("com.yalantis.ucrop.OffsetX", 0));
                            localMedia2.setCropOffsetY(intent.getIntExtra("com.yalantis.ucrop.OffsetY", 0));
                            localMedia2.setCropResultAspectRatio(intent.getFloatExtra("com.yalantis.ucrop.CropAspectRatio", 0.0f));
                            localMedia2.setCropImageWidth(intent.getIntExtra("com.yalantis.ucrop.ImageWidth", 0));
                            localMedia2.setCropImageHeight(intent.getIntExtra("com.yalantis.ucrop.ImageHeight", 0));
                            localMedia2.setEditorImage(item.isCut());
                            if (SdkVersionUtils.checkedAndroid_Q() && PictureMimeType.isContent(item.getPath())) {
                                localMedia2.setAndroidQToPath(path);
                            }
                            this.isChangeSelectedData = true;
                            onUpdateGalleryChange(localMedia2);
                        } else {
                            onCheckedComplete();
                        }
                        this.adapter.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
                setResult(-1, intent);
                finish();
            }
        } else if (i2 == 96 && (th = (Throwable) intent.getSerializableExtra("com.yalantis.ucrop.Error")) != null) {
            ToastUtils.s(getContext(), th.getMessage());
        }
    }

    public void onBackPressed() {
        updateResult();
        finish();
        overridePendingTransition(0, PictureSelectionConfig.windowAnimationStyle.activityPreviewExitAnimation);
    }

    private void updateResult() {
        Intent intent = new Intent();
        if (this.isChangeSelectedData) {
            intent.putExtra(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectData);
        }
        if (this.config.isOriginalControl) {
            intent.putExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
        }
        setResult(0, intent);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, this.isChangeSelectedData);
        PictureSelector.saveSelectorList(bundle, this.selectData);
        if (this.adapter != null) {
            ImagesObservable.getInstance().saveData(this.adapter.getData());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Animation animation2 = this.animation;
        if (animation2 != null) {
            animation2.cancel();
        }
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = this.adapter;
        if (pictureSimpleFragmentAdapter != null) {
            pictureSimpleFragmentAdapter.clear();
        }
    }

    public void onActivityBackPressed() {
        onBackPressed();
    }
}
