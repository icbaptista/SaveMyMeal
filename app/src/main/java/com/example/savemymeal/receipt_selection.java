package com.example.savemymeal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.gridlayout.widget.GridLayout;

import java.util.Locale;

public class receipt_selection extends AppCompatActivity {
    private SearchView svpesquisa;



    private LinearLayout llbacalhauNatas;
    private CardView cvbacalhauNatas;

    private CardView cvcaldoVerde;

    private CardView cvchocoFrito;

    private CardView cvcozidoPortuguesa;

    private LinearLayout llSaladaFruta;
    private CardView cvSaladaFruta;

    private CardView cvsopaLegumes;



    private LinearLayout buttonIngredientes;
    private GridLayout grid;
    private boolean vegetariano = false;
    private boolean laranja = true;
    private boolean Alface = true;
    private boolean Azeite = true;
    private boolean Bacalhau = true;
    private boolean Banana = true;
    private boolean Couve = true;
    private boolean Frango = true;
    private boolean Maca = true;
    private boolean Tomate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        setContentView(R.layout.receipts);

        grid = (GridLayout) findViewById(R.id.grid);
        cvcaldoVerde = (CardView) findViewById(R.id.cardView_caldo_verde);
        cvsopaLegumes = (CardView) findViewById(R.id.cardView_sopa_legumes);
        cvSaladaFruta = (CardView) findViewById(R.id.cardView_salada_fruta);
        cvbacalhauNatas = (CardView) findViewById(R.id.cardView_bacalhau_natas);
        cvcozidoPortuguesa = (CardView) findViewById(R.id.cardView_cozido_portuguesa);
        cvchocoFrito = (CardView) findViewById(R.id.cardView_choco_frito);

        // Modifying toolbar
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        //Abrir os filtros
        buttonIngredientes = (LinearLayout) findViewById(R.id.select_ingredientes);
        buttonIngredientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(receipt_selection.this, SelectIngredient.class),1);

            }
        });


        //Criação do botão e Mostrar todas as infos acerca da Salada de Fruta ao clicar
        llSaladaFruta = (LinearLayout) findViewById(R.id.linearLayout_salada_fruta);
        llSaladaFruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(receipt_selection.this, Receita_Salada_Fruta.class));
            }
        });


        llbacalhauNatas = (LinearLayout) findViewById(R.id.linearLayout_bacalhau_natas);
        llbacalhauNatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(receipt_selection.this, Receita_Bacalhau_Natas.class));
            }
        });

        svpesquisa = (SearchView) findViewById(R.id.pesquisa);
        svpesquisa.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(s.compareToIgnoreCase("Salada de Fruta") == 0){
                    //Tudo vai desaparecer, vou só colocar a desaparecer a salada de fruta para testar
                    grid.removeView(cvcaldoVerde);
                    grid.removeView(cvchocoFrito);
                    grid.removeView(cvcozidoPortuguesa);
                    grid.removeView(cvsopaLegumes);
                    grid.removeView(cvbacalhauNatas);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                s = s.toLowerCase();
                if(s.compareTo("") == 0){
                    updateReceitas();
                }
                return false;
            }
        });


    }

    public void updateReceitas(){
        //Colocar todas as receitas ativas
        grid.removeView(cvbacalhauNatas);
        grid.removeView(cvcaldoVerde);
        grid.removeView(cvchocoFrito);
        grid.removeView(cvcozidoPortuguesa);
        grid.removeView(cvSaladaFruta);
        grid.removeView(cvsopaLegumes);
        grid.addView(cvbacalhauNatas);
        grid.addView(cvcaldoVerde);
        grid.addView(cvchocoFrito);
        grid.addView(cvcozidoPortuguesa);
        grid.addView(cvSaladaFruta);
        grid.addView(cvsopaLegumes);


        //Verificar se a Salada de fruta continua ativa
        for(int i = 0; i < 1; i++){
            if(Banana == false || laranja == false || Maca == false){
                grid.removeView(cvSaladaFruta);
                break;
            }
        }

        //Verificar se o bacalhau com natas continua ativo
        for(int i = 0; i < 1; i++){
            if(vegetariano){
                grid.removeView(cvbacalhauNatas);
                break;
            }
            if(Bacalhau == false){
                grid.removeView(cvbacalhauNatas);
                break;
            }
        }

        //Verificar se o caldo verde continua ativo
        for(int i = 0; i < 1; i++){
            if(vegetariano){
                grid.removeView(cvcaldoVerde);
                break;
            }
            if(Couve == false || Azeite == false){
                grid.removeView(cvcaldoVerde);
                break;
            }
        }

        //Verificar se o choco frito continua ativo
        for(int i = 0; i < 1; i++){
            if(vegetariano){
                grid.removeView(cvchocoFrito);
                break;
            }
            if(Alface == false || Banana == false || Couve == false || laranja == false || Maca == false || Tomate == false || Frango == false || Azeite == false || Bacalhau == false){
                grid.removeView(cvchocoFrito);
                break;
            }
        }

        //Verificar se o cozido a portuguesa continua ativo
        for(int i = 0; i < 1; i++){
            if(vegetariano){
                grid.removeView(cvcozidoPortuguesa);
                break;
            }
            if(Alface == false || Banana == false || Couve == false || laranja == false || Maca == false || Tomate == false || Frango == false || Azeite == false || Bacalhau == false){
                grid.removeView(cvcozidoPortuguesa);
                break;
            }
        }

        //Verificar se a sopa legumes continua ativo
        for(int i = 0; i < 1; i++){
            if(Couve == false || Tomate == false || Azeite == false){
                grid.removeView(cvsopaLegumes);
                break;
            }
        }

    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        laranja = false;
        Alface = false;
        Azeite = false;
        Bacalhau = false;
        Banana = false;
        Couve = false;
        Frango = false;
        Maca = false;
        Tomate = false;
        vegetariano = false;
        super.onActivityResult(requestCode, resultCode, data);
        String alimento = data.getStringExtra(SelectIngredient.EXTRA_COUNT);
        String[] alimentosArray = alimento.split(" ");
        for(String i :alimentosArray){
            if(i.compareTo("laranja") == 0){
                laranja = true;
            }
            if(i.compareTo("alface") == 0){
                Alface = true;
            }
            if(i.compareTo("azeite") == 0){
                Azeite = true;
            }
            if(i.compareTo("bacalhau") == 0){
                Bacalhau = true;
            }
            if(i.compareTo("banana") == 0){
                Banana = true;
            }
            if(i.compareTo("couve") == 0){
                Couve = true;
            }
            if(i.compareTo("frango") == 0){
                Frango = true;
            }
            if(i.compareTo("maca") == 0){
                Maca = true;
            }
            if(i.compareTo("tomate") == 0){
                Tomate = true;
            }


            if(i.compareTo("vegetariano") == 0){
                vegetariano = true;
            }

            if(i.compareTo("dispensa") == 0){
                laranja = true;
                Banana = true;
                Maca = true;
            }
        }

        if(alimento.compareTo(" vegetariano") == 0){
            laranja = true;
            Alface = true;
            Azeite = true;
            Bacalhau = true;
            Banana = true;
            Couve = true;
            Frango = true;
            Maca = true;
            Tomate = true;
        }
        updateReceitas();
    }


    public void checkDispensa(View view) {
        /*if (dispensa) {
            dispensa = false;
            LL_ovo_frito.setVisibility(View.VISIBLE);
            LL_paella_vegetariana.setVisibility(View.VISIBLE);
        }
        else {
            dispensa = true;
            LL_ovo_frito.setVisibility(View.GONE);
            LL_paella_vegetariana.setVisibility(View.GONE);
        }*/
    }
    public void showFridge(View view) {
        Intent seeList = new Intent(receipt_selection.this, DispensaActivity.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(receipt_selection.this, HomePage.class);
        startActivity(seeList);
    }

    public void showLista(View view){
        Intent seeList = new Intent(receipt_selection.this, ListaDeCompras.class);
        startActivity(seeList);
    }
}
