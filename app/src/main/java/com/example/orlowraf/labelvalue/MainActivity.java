package com.example.orlowraf.labelvalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

public class MainActivity extends AppCompatActivity {
    private LabelValueView labelValueView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labelValueView = (LabelValueView) findViewById(R.id.label_value_view);
        //labelValueView.setContent("Hello", "world");
    }
}
