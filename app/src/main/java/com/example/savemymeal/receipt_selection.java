package com.example.savemymeal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class receipt_selection extends Activity {
    private Button buttonVegetariano;
    private Button buttonIngredientes;
    private Button buttonDispensa;
    private LinearLayout LL_salada_fruta;
    private LinearLayout LL_ovo_frito;
    private LinearLayout LL_paella_vegetariana;
    private boolean dispensa = false;
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
        //Criação dos botões
        buttonVegetariano = (Button) findViewById(R.id.bvegetariano);
        buttonDispensa = (Button) findViewById(R.id.buttonDispensa);
        LL_ovo_frito = (LinearLayout) findViewById(R.id.ovo_frito);
        LL_salada_fruta = (LinearLayout) findViewById(R.id.Salada_fruta);
        LL_paella_vegetariana = (LinearLayout) findViewById(R.id.paella_vegetariana);
        buttonIngredientes = (Button) findViewById(R.id.select_ingredientes);

        //Esconder as receitas não vegetarianas
        buttonVegetariano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Se já tiverem carregado alguma vez no botão de vegetariano
                if (vegetariano) {
                    vegetariano = false;
                    buttonVegetariano.setTextColor(Color.parseColor("#0EA33C"));
                    buttonVegetariano.setBackgroundResource(R.drawable.buttons_border);
                }
                else {
                    vegetariano = true;
                    buttonVegetariano.setTextColor(Color.parseColor("#f1f1f1"));
                    buttonVegetariano.setBackgroundResource(R.drawable.buttons_border_selected);
                }
                updateReceitas();
            }
        });

        buttonIngredientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(receipt_selection.this, SelectIngredient.class),1);

            }
        });

        //Mostrar todas as informações acerca do ovo frito, ao clicar nele
        LL_ovo_frito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Isto funciona como um botão para o Ovo Frito, o que vou fazer agora é isto abrir um popUp com toda a receita
                startActivity(new Intent(receipt_selection.this, Pop_receita_ovo.class));
            }
        });

        //Mostrar todas as informações acerca da salada de fruta, ao clicar nele
        LL_salada_fruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Isto funciona como um botão para o Ovo Frito, o que vou fazer agora é isto abrir um popUp com toda a receita
                startActivity(new Intent(receipt_selection.this, Pop_receita_salada_fruta.class));
            }
        });
    }

    public void updateReceitas(){
        //Colocar todas as receitas ativas
        LL_ovo_frito.setVisibility(View.VISIBLE);
        LL_salada_fruta.setVisibility(View.VISIBLE);
        //Verificar se o Ovo Frito continua ativo
        for(int i = 0; i < 1; i++){
            if(vegetariano) {
                LL_ovo_frito.setVisibility(View.GONE);
                break;
            }
            //Supostamente if ovos == false tb colocavamos a visibilidade
        }

        //Verificar se a Salada de fruta continua ativo
        for(int i = 0; i < 1; i++){
            //Supostamente if maca == false or banana or laranja tb colocavamos a visibilidade
            if(Maca == false || Banana == false || laranja == false) {
                LL_salada_fruta.setVisibility(View.GONE);
                break;
            }
            if(vegetariano == false) {
                LL_ovo_frito.setVisibility(View.GONE);
                LL_paella_vegetariana.setVisibility(View.GONE);
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
        }
        updateReceitas();
    }


    public void checkDispensa(View view) {
        if (dispensa) {
            dispensa = false;
            buttonDispensa.setTextColor(Color.parseColor("#0EA33C"));
            buttonDispensa.setBackgroundResource(R.drawable.buttons_border);
            LL_ovo_frito.setVisibility(View.VISIBLE);
            LL_paella_vegetariana.setVisibility(View.VISIBLE);
        }
        else {
            dispensa = true;
            buttonDispensa.setTextColor(Color.parseColor("#f1f1f1"));
            buttonDispensa.setBackgroundResource(R.drawable.buttons_border_selected);
            LL_ovo_frito.setVisibility(View.GONE);
            LL_paella_vegetariana.setVisibility(View.GONE);
        }
    }
}
