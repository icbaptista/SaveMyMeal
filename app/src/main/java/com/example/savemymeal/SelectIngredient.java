package com.example.savemymeal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SelectIngredient extends Activity {
    CheckBox SelectLaranja;
    CheckBox SelectAlface;
    CheckBox SelectAzeite;
    CheckBox SelectBacalhau;
    CheckBox SelectBanana;
    CheckBox SelectCouve;
    CheckBox SelectFrango;
    CheckBox SelectMaca;
    CheckBox SelectTomate;
    Button botaoAceitar;
    public static final String EXTRA_COUNT = "com.example.android.savemymeal.extra.Itens";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedSelection = this.getPreferences(Context.MODE_PRIVATE);
        setContentView(R.layout.receipt_ingredient_selection);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.6));

        SelectLaranja = (CheckBox) findViewById(R.id.checkBoxLaranja);
        SelectAlface = (CheckBox) findViewById(R.id.checkBoxAlface);
        SelectAzeite = (CheckBox) findViewById(R.id.checkBoxAzeite);
        SelectBacalhau = (CheckBox) findViewById(R.id.checkBoxBacalhau);
        SelectBanana = (CheckBox) findViewById(R.id.checkBoxBanana);
        SelectCouve = (CheckBox) findViewById(R.id.checkBoxCouve);
        SelectFrango = (CheckBox) findViewById(R.id.checkBoxFrango);
        SelectMaca = (CheckBox) findViewById(R.id.checkBoxMaca);
        SelectTomate = (CheckBox) findViewById(R.id.checkBoxTomate);

        botaoAceitar = (Button) findViewById(R.id.buttonAceitar);

        botaoAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adicionarIntent = new Intent();
                String alimentos = "";
                if(SelectLaranja.isChecked()){
                    alimentos = alimentos + " laranja";
                }
                if(SelectAlface.isChecked()){
                    alimentos = alimentos + " alface";
                }
                if(SelectAzeite.isChecked()){
                    alimentos = alimentos + " azeite";
                }
                if(SelectBacalhau.isChecked()){
                    alimentos = alimentos + " bacalhau";
                }
                if(SelectBanana.isChecked()){
                    alimentos = alimentos + " banana";
                }
                if(SelectCouve.isChecked()){
                    alimentos = alimentos + " couve";
                }
                if(SelectFrango.isChecked()){
                    alimentos = alimentos + " frango";
                }
                if(SelectMaca.isChecked()){
                    alimentos = alimentos + " maca";
                }
                if(SelectTomate.isChecked()){
                    alimentos = alimentos + " tomate";
                }
                adicionarIntent.putExtra(EXTRA_COUNT, alimentos);
                setResult(RESULT_OK, adicionarIntent);
                finish();
            }
        });



    }
}
