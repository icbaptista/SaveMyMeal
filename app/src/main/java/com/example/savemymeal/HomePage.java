package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button btnRecipes;
    Button btnFridge;
    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Activating buttons
        btnRecipes = findViewById(R.id.btnReceitas);
        btnFridge = findViewById(R.id.btnDispena);
        btnList = findViewById(R.id.btnLista);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeList = new Intent(HomePage.this, ListaDeCompras.class);
                startActivity(seeList);
            }
        });

    }

}