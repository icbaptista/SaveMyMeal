package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;

public class DispensaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispensa_main);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
    }
}