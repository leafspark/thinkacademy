package com.tal.app.thinkacademy.lib.commui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.listener.TagTextStyle;
import java.util.ArrayList;
import java.util.List;

public class TagTextView extends AppCompatTextView {
    public static int TAGS_INDEX_AT_END = 1;
    public static int TAGS_INDEX_AT_START;
    private StringBuffer content_buffer;
    private LayoutInflater layoutInflater;
    private Context mContext;
    private Rect mTagPadding;
    private Drawable tagBackgroundStyle;
    private int tagTextColor;
    private int tagTextSize;
    private int tagTextStyle;
    private int tagsIndex;
    private TextView tv_tag;

    public TagTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TagTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public TagTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tagTextSize = 36;
        this.tagTextColor = Color.parseColor("#FFFFFFFF");
        this.tagTextStyle = 0;
        this.tagsIndex = 0;
        this.mTagPadding = null;
        this.mContext = context;
        initAttrs(context, attributeSet);
        init();
    }

    public void setTagPadding(Rect rect) {
        this.mTagPadding = rect;
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        this.tagBackgroundStyle = getDrawable(context, R.drawable.common_shape_textview_tags_bg);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagTextView);
        if (obtainStyledAttributes != null) {
            if (obtainStyledAttributes.hasValue(R.styleable.TagTextView_tagTextSize)) {
                this.tagTextSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TagTextView_tagTextSize, 36);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TagTextView_tagTextColor)) {
                this.tagTextColor = obtainStyledAttributes.getColor(R.styleable.TagTextView_tagTextColor, Color.parseColor("#FFFFFFFF"));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TagTextView_tagBackground)) {
                this.tagBackgroundStyle = obtainStyledAttributes.getDrawable(R.styleable.TagTextView_tagBackground);
            }
            if (obtainStyledAttributes.hasValue(R.styleable.TagTextView_tagTextStyle)) {
                this.tagTextStyle = obtainStyledAttributes.getInt(R.styleable.TagTextView_tagTextStyle, 0);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        this.layoutInflater = LayoutInflater.from(this.mContext);
    }

    public TagTextView setTagTextSize(int i) {
        this.tagTextSize = i;
        return this;
    }

    public TagTextView setTagTextColor(int i) {
        this.tagTextColor = i;
        return this;
    }

    public TagTextView setTagBackgroundStyle(int i) {
        this.tagBackgroundStyle = getDrawable(getContext(), i);
        return this;
    }

    public TagTextView setTagBackgroundStyle(Drawable drawable) {
        this.tagBackgroundStyle = drawable;
        return this;
    }

    public TagTextView setTagsTextStyle(@TagTextStyle.TagTextStyles int i) {
        this.tagTextStyle = i;
        return this;
    }

    public TagTextView setTagsIndex(int i) {
        this.tagsIndex = i;
        return this;
    }

    public TagTextView setSingleTagAndContent(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
            setMultiTagAndContent(arrayList, str2);
        }
        return this;
    }

    public TagTextView setMultiTagAndContent(List<String> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.tagsIndex == TAGS_INDEX_AT_START) {
                setTagStart(list, str);
            } else {
                setTagEnd(list, str);
            }
        }
        return this;
    }

    public TagTextView setTagStart(List<String> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.content_buffer = new StringBuffer();
            if (list != null && !list.isEmpty()) {
                for (String append : list) {
                    this.content_buffer.append(append);
                }
            }
            this.content_buffer.append(str);
            SpannableString spannableString = new SpannableString(this.content_buffer);
            if (list != null && !list.isEmpty()) {
                int i = 1;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    String str2 = list.get(i3);
                    i2 += str2.length();
                    LayoutInflater layoutInflater2 = this.layoutInflater;
                    int i4 = R.layout.common_layout_textview_tags;
                    View inflate = !(layoutInflater2 instanceof LayoutInflater) ? layoutInflater2.inflate(i4, (ViewGroup) null) : XMLParseInstrumentation.inflate(layoutInflater2, i4, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.ct_ctcommon_tv_tag);
                    this.tv_tag = textView;
                    textView.setText(str2);
                    this.tv_tag.setTextSize(0, (float) this.tagTextSize);
                    Rect rect = this.mTagPadding;
                    if (rect != null) {
                        this.tv_tag.setPadding(rect.left, this.mTagPadding.top, this.mTagPadding.right, this.mTagPadding.bottom);
                    }
                    this.tv_tag.setTextColor(this.tagTextColor);
                    this.tv_tag.setBackground(this.tagBackgroundStyle);
                    setTagTextStyle(this.tv_tag);
                    Bitmap convertViewToBitmap = convertViewToBitmap(inflate);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(convertViewToBitmap);
                    bitmapDrawable.setBounds(0, 0, convertViewToBitmap.getWidth(), convertViewToBitmap.getHeight());
                    spannableString.setSpan(new CenterImageSpan((Drawable) bitmapDrawable), i - 1, i2, 18);
                    i += str2.length();
                }
            }
            setText(spannableString);
            setGravity(16);
        }
        return this;
    }

    public TagTextView setTagImageStart(Context context, int i, String str, int i2, int i3) {
        this.content_buffer = new StringBuffer("**" + str);
        SpannableString spannableString = new SpannableString(this.content_buffer);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactoryInstrumentation.decodeResource(getResources(), i));
        bitmapDrawable.setBounds(0, 0, dp2px(context, (float) i2), dp2px(context, (float) i3));
        spannableString.setSpan(new CenterImageSpan((Drawable) bitmapDrawable), 0, 2, 18);
        setText(spannableString);
        setGravity(16);
        return this;
    }

    public TagTextView setTagEnd(List<String> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.content_buffer = new StringBuffer(str);
            if (list != null && !list.isEmpty()) {
                for (String append : list) {
                    this.content_buffer.append(append);
                }
            }
            SpannableString spannableString = new SpannableString(this.content_buffer);
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    String str2 = list.get(i);
                    LayoutInflater from = LayoutInflater.from(this.mContext);
                    int i2 = R.layout.common_layout_textview_tags;
                    View inflate = !(from instanceof LayoutInflater) ? from.inflate(i2, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i2, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.ct_ctcommon_tv_tag);
                    this.tv_tag = textView;
                    textView.setText(str2);
                    this.tv_tag.setTextSize(0, (float) this.tagTextSize);
                    this.tv_tag.setTextColor(this.tagTextColor);
                    this.tv_tag.setBackground(this.tagBackgroundStyle);
                    setTagTextStyle(this.tv_tag);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(convertViewToBitmap(inflate));
                    bitmapDrawable.setBounds(0, 0, this.tv_tag.getWidth(), this.tv_tag.getHeight());
                    spannableString.setSpan(new CenterImageSpan((Drawable) bitmapDrawable), this.content_buffer.length() - str2.length(), this.content_buffer.length(), 18);
                }
            }
            setText(spannableString);
            setGravity(16);
        }
        return this;
    }

    public TagTextView setTagAnyway(int i, int i2, String str) {
        SpannableString spannableString = new SpannableString(str);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int i3 = R.layout.common_layout_textview_tags;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i3, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i3, (ViewGroup) null);
        String substring = str.substring(i, i2);
        TextView textView = (TextView) inflate.findViewById(R.id.ct_ctcommon_tv_tag);
        this.tv_tag = textView;
        textView.setText(substring);
        this.tv_tag.setTextSize(0, (float) this.tagTextSize);
        this.tv_tag.setTextColor(this.tagTextColor);
        this.tv_tag.setBackground(this.tagBackgroundStyle);
        setTagTextStyle(this.tv_tag);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(convertViewToBitmap(inflate));
        bitmapDrawable.setBounds(0, 0, this.tv_tag.getWidth(), this.tv_tag.getHeight());
        spannableString.setSpan(new CenterImageSpan((Drawable) bitmapDrawable), i, i2, 18);
        setText(spannableString);
        setGravity(16);
        return this;
    }

    private void setTagTextStyle(TextView textView) {
        int i = this.tagTextStyle;
        if (i == 1) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        } else if (i == 2) {
            textView.setTypeface(Typeface.defaultFromStyle(2));
        } else if (i != 3) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        } else {
            textView.setTypeface(Typeface.defaultFromStyle(3));
        }
    }

    private Drawable getDrawable(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        return context.getResources().getDrawable(i);
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static Bitmap convertViewToBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }
}
