package com.example.orlowraf.labelvalue;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by orlowraf on 2015-12-11.
 */
class LabelValueView extends LinearLayout {
    private final String labelContent;
    private final String valueContent;
    private TextView labelView;
    private TextView valueView;

    public LabelValueView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        TypedArray styledAttributes = context
                .getTheme().obtainStyledAttributes(attrs, R.styleable.LabelValueView, 0, 0);
        labelContent = styledAttributes.getString(R.styleable.LabelValueView_labelText);
        valueContent = styledAttributes.getString(R.styleable.LabelValueView_valueText);
        styledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.label_value, this, true);
        labelView = (TextView) findViewById(R.id.label);
        valueView = (TextView) findViewById(R.id.value);
        labelView.setText(labelContent);
        valueView.setText(valueContent);
    }

    public void setContent(String label, String value) {
        labelView.setText(label);
        valueView.setText(value);
    }

    public void setContent(LabelValueModel model) {
        labelView.setText(model.labelContent);
        valueView.setText(model.valueContent);
    }

    public static class LabelValueModel {
        private final String labelContent;
        private final String valueContent;

        public LabelValueModel(String labelContent, String valueContent) {
            this.labelContent = labelContent;
            this.valueContent = valueContent;
        }
    }
}
