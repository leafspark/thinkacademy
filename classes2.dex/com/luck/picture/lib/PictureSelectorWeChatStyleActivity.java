package com.luck.picture.lib;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.tools.AttrsUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.List;

public class PictureSelectorWeChatStyleActivity extends PictureSelectorActivity {
    private RelativeLayout rlAlbum;

    public int getResourceId() {
        return R.layout.picture_wechat_style_selector;
    }

    /* access modifiers changed from: protected */
    public void initWidgets() {
        super.initWidgets();
        this.rlAlbum = (RelativeLayout) findViewById(R.id.rlAlbum);
        this.mTvPictureRight.setOnClickListener(this);
        this.mTvPictureRight.setText(getString(R.string.picture_send));
        this.mTvPicturePreview.setTextSize(16.0f);
        this.mCbOriginal.setTextSize(16.0f);
        int i = 0;
        boolean z = true;
        if (this.config.selectionMode != 1 || !this.config.isSingleDirectReturn) {
            z = false;
        }
        TextView textView = this.mTvPictureRight;
        if (z) {
            i = 8;
        }
        textView.setVisibility(i);
        this.mTvPictureRight.setOnClickListener(this);
        setAlbumLayoutParams(z);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.luck.picture.lib.PictureSelectorWeChatStyleActivity, com.luck.picture.lib.PictureSelectorActivity] */
    public void initPictureSelectorStyle() {
        if (PictureSelectionConfig.uiStyle != null) {
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            if (PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_bottom_barBackgroundColor);
            } else {
                this.mBottomLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_grey));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor.length > 0) {
                ColorStateList colorStateList = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_top_titleRightTextColor);
                if (colorStateList != null) {
                    this.mTvPictureRight.setTextColor(colorStateList);
                }
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float) PictureSelectionConfig.uiStyle.picture_top_titleRightTextSize);
            }
            if (this.config.isOriginalControl) {
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle != 0) {
                    this.mCbOriginal.setButtonDrawable(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureCheckStyle);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor != 0) {
                    this.mCbOriginal.setTextColor(PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextColor);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize != 0) {
                    this.mCbOriginal.setTextSize((float) PictureSelectionConfig.uiStyle.picture_bottom_originalPictureTextSize);
                }
            }
            if (PictureSelectionConfig.uiStyle.picture_container_backgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.uiStyle.picture_container_backgroundColor);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleAlbumBackground != 0) {
                this.rlAlbum.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleAlbumBackground);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            if (PictureSelectionConfig.uiStyle.picture_album_horizontal) {
                setAlbumLayoutParams(true);
            }
            if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                this.mTvPictureRight.setText(getString(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText));
            }
        } else if (PictureSelectionConfig.style != null) {
            if (PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle != 0) {
                this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle);
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            }
            if (PictureSelectionConfig.style.pictureBottomBgColor != 0) {
                this.mBottomLayout.setBackgroundColor(PictureSelectionConfig.style.pictureBottomBgColor);
            } else {
                this.mBottomLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.picture_color_grey));
            }
            if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
            } else if (PictureSelectionConfig.style.pictureCancelTextColor != 0) {
                this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCancelTextColor);
            } else {
                this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
            }
            if (PictureSelectionConfig.style.pictureRightTextSize != 0) {
                this.mTvPictureRight.setTextSize((float) PictureSelectionConfig.style.pictureRightTextSize);
            }
            if (PictureSelectionConfig.style.pictureOriginalFontColor == 0) {
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            }
            if (this.config.isOriginalControl && PictureSelectionConfig.style.pictureOriginalControlStyle == 0) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
            if (PictureSelectionConfig.style.pictureContainerBackgroundColor != 0) {
                this.container.setBackgroundColor(PictureSelectionConfig.style.pictureContainerBackgroundColor);
            }
            if (PictureSelectionConfig.style.pictureWeChatTitleBackgroundStyle != 0) {
                this.rlAlbum.setBackgroundResource(PictureSelectionConfig.style.pictureWeChatTitleBackgroundStyle);
            } else {
                this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            }
            if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
            }
        } else {
            this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
            this.rlAlbum.setBackgroundResource(R.drawable.picture_album_bg);
            this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
            int typeValueColor = AttrsUtils.getTypeValueColor(getContext(), R.attr.picture_bottom_bg);
            RelativeLayout relativeLayout = this.mBottomLayout;
            if (typeValueColor == 0) {
                typeValueColor = ContextCompat.getColor(getContext(), R.color.picture_color_grey);
            }
            relativeLayout.setBackgroundColor(typeValueColor);
            this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_white));
            this.mIvArrow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.picture_icon_wechat_down));
            if (this.config.isOriginalControl) {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_wechat_checkbox));
            }
        }
        super.initPictureSelectorStyle();
        goneParentView();
    }

    private void setAlbumLayoutParams(boolean z) {
        if (this.rlAlbum.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlAlbum.getLayoutParams();
            if (z) {
                layoutParams.addRule(1, -1);
                layoutParams.addRule(14);
                return;
            }
            layoutParams.addRule(14, -1);
            layoutParams.addRule(1, R.id.pictureLeftBack);
        }
    }

    private void goneParentView() {
        this.mTvPictureImgNum.setVisibility(8);
        this.mTvPictureOk.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void changeImageNumber(List<LocalMedia> list) {
        int size = list.size();
        if (size != 0) {
            this.mTvPictureRight.setEnabled(true);
            this.mTvPictureRight.setSelected(true);
            this.mTvPicturePreview.setEnabled(true);
            this.mTvPicturePreview.setSelected(true);
            initCompleteText(list);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextNormalBackground);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor.length > 0) {
                    ColorStateList colorStateList = AttrsUtils.getColorStateList(PictureSelectionConfig.uiStyle.picture_bottom_previewTextColor);
                    if (colorStateList != null) {
                        this.mTvPicturePreview.setTextColor(colorStateList);
                    }
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText == 0) {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(size)}));
                } else if (PictureSelectionConfig.uiStyle.isCompleteReplaceNum) {
                    this.mTvPicturePreview.setText(String.format(getString(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText), new Object[]{Integer.valueOf(size)}));
                } else {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.uiStyle.picture_bottom_previewNormalText);
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureCompleteBackgroundStyle != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureCompleteBackgroundStyle);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                }
                if (PictureSelectionConfig.style.pictureCompleteTextColor != 0) {
                    this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureCompleteTextColor);
                } else {
                    this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                }
                if (PictureSelectionConfig.style.picturePreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.picturePreviewTextColor);
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.picturePreviewText)) {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.style.picturePreviewText);
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(size)}));
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_bg);
                this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_white));
                this.mTvPicturePreview.setText(getString(R.string.picture_preview_num, new Object[]{Integer.valueOf(size)}));
            }
        } else {
            this.mTvPictureRight.setEnabled(false);
            this.mTvPictureRight.setSelected(false);
            this.mTvPicturePreview.setEnabled(false);
            this.mTvPicturePreview.setSelected(false);
            if (PictureSelectionConfig.uiStyle != null) {
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.uiStyle.picture_top_titleRightTextDefaultBackground);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                if (PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText != 0) {
                    this.mTvPictureRight.setText(getString(PictureSelectionConfig.uiStyle.picture_top_titleRightDefaultText));
                } else {
                    this.mTvPictureRight.setText(getString(R.string.picture_send));
                }
                if (PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText != 0) {
                    this.mTvPicturePreview.setText(getString(PictureSelectionConfig.uiStyle.picture_bottom_previewDefaultText));
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                }
            } else if (PictureSelectionConfig.style != null) {
                if (PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle != 0) {
                    this.mTvPictureRight.setBackgroundResource(PictureSelectionConfig.style.pictureUnCompleteBackgroundStyle);
                } else {
                    this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                }
                if (PictureSelectionConfig.style.pictureUnCompleteTextColor != 0) {
                    this.mTvPictureRight.setTextColor(PictureSelectionConfig.style.pictureUnCompleteTextColor);
                } else {
                    this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
                }
                if (PictureSelectionConfig.style.pictureUnPreviewTextColor != 0) {
                    this.mTvPicturePreview.setTextColor(PictureSelectionConfig.style.pictureUnPreviewTextColor);
                } else {
                    this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    this.mTvPictureRight.setText(PictureSelectionConfig.style.pictureUnCompleteText);
                } else {
                    this.mTvPictureRight.setText(getString(R.string.picture_send));
                }
                if (!TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnPreviewText)) {
                    this.mTvPicturePreview.setText(PictureSelectionConfig.style.pictureUnPreviewText);
                } else {
                    this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                }
            } else {
                this.mTvPictureRight.setBackgroundResource(R.drawable.picture_send_button_default_bg);
                this.mTvPictureRight.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_53575e));
                this.mTvPicturePreview.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
                this.mTvPicturePreview.setText(getString(R.string.picture_preview));
                this.mTvPictureRight.setText(getString(R.string.picture_send));
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() != R.id.picture_right) {
            super.onClick(view);
        } else if (this.folderWindow == null || !this.folderWindow.isShowing()) {
            this.mTvPictureOk.performClick();
        } else {
            this.folderWindow.dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: protected */
    public void onChangeData(List<LocalMedia> list) {
        super.onChangeData(list);
        initCompleteText(list);
    }

    /* access modifiers changed from: protected */
    public void initCompleteText(List<LocalMedia> list) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int size = list.size();
        boolean z = PictureSelectionConfig.style != null;
        if (!this.config.isWithVideoImage) {
            int i = (!PictureMimeType.isHasVideo(list.get(0).getMimeType()) || this.config.maxVideoSelectNum <= 0) ? this.config.maxSelectNum : this.config.maxVideoSelectNum;
            if (this.config.selectionMode == 1) {
                if (!(z && PictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                    TextView textView = this.mTvPictureRight;
                    if (!z || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                        str2 = getString(R.string.picture_send);
                    } else {
                        str2 = PictureSelectionConfig.style.pictureCompleteText;
                    }
                    textView.setText(str2);
                    return;
                }
                this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(size), 1}));
                return;
            }
            if (!(z && PictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                TextView textView2 = this.mTvPictureRight;
                if (!z || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    str = getString(R.string.picture_send_num, new Object[]{Integer.valueOf(size), Integer.valueOf(i)});
                } else {
                    str = PictureSelectionConfig.style.pictureUnCompleteText;
                }
                textView2.setText(str);
                return;
            }
            this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(size), Integer.valueOf(i)}));
        } else if (this.config.selectionMode != 1) {
            if (!(z && PictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                TextView textView3 = this.mTvPictureRight;
                if (!z || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                    str3 = getString(R.string.picture_send_num, new Object[]{Integer.valueOf(size), Integer.valueOf(this.config.maxSelectNum)});
                } else {
                    str3 = PictureSelectionConfig.style.pictureUnCompleteText;
                }
                textView3.setText(str3);
                return;
            }
            this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(size), Integer.valueOf(this.config.maxSelectNum)}));
        } else if (size <= 0) {
            TextView textView4 = this.mTvPictureRight;
            if (!z || TextUtils.isEmpty(PictureSelectionConfig.style.pictureUnCompleteText)) {
                str5 = getString(R.string.picture_send);
            } else {
                str5 = PictureSelectionConfig.style.pictureUnCompleteText;
            }
            textView4.setText(str5);
        } else {
            if (!(z && PictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                TextView textView5 = this.mTvPictureRight;
                if (!z || TextUtils.isEmpty(PictureSelectionConfig.style.pictureCompleteText)) {
                    str4 = getString(R.string.picture_send);
                } else {
                    str4 = PictureSelectionConfig.style.pictureCompleteText;
                }
                textView5.setText(str4);
                return;
            }
            this.mTvPictureRight.setText(String.format(PictureSelectionConfig.style.pictureCompleteText, new Object[]{Integer.valueOf(size), 1}));
        }
    }
}
