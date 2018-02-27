package com.android.parcelable_vs_serializable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by chentao on 2018/2/27.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.Tv);
        SUser sUser = (SUser) getIntent().getSerializableExtra("SUer");
        PUser pUser = getIntent().getParcelableExtra("PUser");
        String s = sUser.toString() + "\n" + pUser.toString();
        textView.setText(s);
    }
}
