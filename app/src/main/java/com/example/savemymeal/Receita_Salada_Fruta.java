package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Receita_Salada_Fruta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita_salada_fruta);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public void openYoutube(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=5P3A09yRAe8"));
        startActivity(intent);
    }

    public void showLista(View view) {
        Intent seeList = new Intent(Receita_Salada_Fruta.this, ListaDeCompras.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(Receita_Salada_Fruta.this, HomePage.class);
        startActivity(seeList);
    }

    public void showDispensa(View view){
        Intent seeList = new Intent(Receita_Salada_Fruta.this, DispensaActivity.class);
        startActivity(seeList);
    }
}