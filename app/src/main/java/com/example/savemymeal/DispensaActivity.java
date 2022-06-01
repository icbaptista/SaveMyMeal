package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.net.URISyntaxException;

public class DispensaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispensa_main);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        /*LinearLayout googleforms = findViewById(R.id.FishImageLayout);
        googleforms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/uzVAJMM7w8QDnXqU9"));
                startActivity(browserIntent);
            }
        });*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void lauchVegetablesActivity(View view) {
        Intent intent = new Intent(this, VegetablesActivity.class);
        startActivity(intent);
    }
    public void showLista(View view) {
        Intent seeList = new Intent(DispensaActivity.this, ListaDeCompras.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(DispensaActivity.this, HomePage.class);
        startActivity(seeList);
    }

    public void showRecipes(View view){
        Intent seeList = new Intent(DispensaActivity.this, receipt_selection.class);
        startActivity(seeList);
    }
}