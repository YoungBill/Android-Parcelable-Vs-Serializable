package com.android.parcelable_vs_serializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        SUser sUser = new SUser(1, "汪", true);
        intent.putExtra("SUer", sUser);
        PUser pUser = new PUser(1, "喵", true);
        intent.putExtra("PUser", pUser);
        startActivity(intent);
    }
}
