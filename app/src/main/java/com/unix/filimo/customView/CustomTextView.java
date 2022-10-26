package com.unix.filimo.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class CustomTextView extends AppCompatTextView {
    public CustomTextView(@NonNull Context context) {
        super(context);
        changeFont(context);
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        changeFont(context);
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        changeFont(context);
    }

    private void changeFont(@NonNull Context context) {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/IRANSans_Bold.ttf");
        setTypeface(typeface);
    }

}
