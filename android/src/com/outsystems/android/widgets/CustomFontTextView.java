package com.outsystems.android.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.outsystems.android.R;

public class CustomFontTextView extends TextView {

    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }
    
    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        String customFontStyle = a.getString(R.styleable.CustomFontTextView_fontStyle);
        setCustomFont(ctx, "MyriadPro-" + customFontStyle + ".ttf");
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String asset) {
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), "fonts/" + asset);
        } catch (Exception e) {
            return false;
        }

        setTypeface(tf);
        return true;
    }
}
