package com.example.savemymeal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SelectIngredient extends Activity {
    private CheckBox SelectLaranja;
    private CheckBox SelectAlface;
    private CheckBox SelectAzeite;
    private CheckBox SelectBacalhau;
    private CheckBox SelectBanana;
    private CheckBox SelectCouve;
    private CheckBox SelectFrango;
    private CheckBox SelectMaca;
    private CheckBox SelectTomate;
    private CheckBox SelectVegetariano;
    private CheckBox SelectDispensa;

    private Button botaoLimpar;
    private Button botaoAceitar;
    public static final String EXTRA_COUNT = "com.example.android.savemymeal.extra.Itens";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedSelection = this.getPreferences(Context.MODE_PRIVATE);
        setContentView(R.layout.receipt_ingredient_selection);


        SelectLaranja = (CheckBox) findViewById(R.id.checkBoxLaranja);
        SelectAlface = (CheckBox) findViewById(R.id.checkBoxAlface);
        SelectAzeite = (CheckBox) findViewById(R.id.checkBoxAzeite);
        SelectBacalhau = (CheckBox) findViewById(R.id.checkBoxBacalhau);
        SelectBanana = (CheckBox) findViewById(R.id.checkBoxBanana);
        SelectCouve = (CheckBox) findViewById(R.id.checkBoxCouve);
        SelectFrango = (CheckBox) findViewById(R.id.checkBoxFrango);
        SelectMaca = (CheckBox) findViewById(R.id.checkBoxMaca);
        SelectTomate = (CheckBox) findViewById(R.id.checkBoxTomate);
        SelectVegetariano = (CheckBox) findViewById(R.id.checkBoxVegetariano);
        SelectDispensa = (CheckBox) findViewById(R.id.checkBoxDispensa);



        String laranjaCheck = sharedSelection.getString("laranja", "false");
        String alfaceCheck = sharedSelection.getString("alface", "false");
        String azeiteCheck = sharedSelection.getString("azeite", "false");
        String bacalhauCheck = sharedSelection.getString("bacalhau", "false");
        String bananaCheck = sharedSelection.getString("banana", "false");
        String couveCheck = sharedSelection.getString("couve", "false");
        String frangoCheck = sharedSelection.getString("frango", "false");
        String macaCheck = sharedSelection.getString("maca", "false");
        String tomateCheck = sharedSelection.getString("tomate", "false");
        String vegetarianoCheck = sharedSelection.getString("vegetariano", "false");
        String dispensaCheck = sharedSelection.getString("dispensa", "false");
        if(alfaceCheck.compareTo("true") == 0){
            SelectAlface.setChecked(true);
        }
        if(laranjaCheck.compareTo("true") == 0){
            SelectLaranja.setChecked(true);
        }
        if(azeiteCheck.compareTo("true") == 0){
            SelectAzeite.setChecked(true);
        }
        if(bacalhauCheck.compareTo("true") == 0){
            SelectBacalhau.setChecked(true);
        }
        if(bananaCheck.compareTo("true") == 0){
            SelectBanana.setChecked(true);
        }
        if(couveCheck.compareTo("true") == 0){
            SelectCouve.setChecked(true);
        }
        if(frangoCheck.compareTo("true") == 0){
            SelectFrango.setChecked(true);
        }
        if(macaCheck.compareTo("true") == 0){
            SelectMaca.setChecked(true);
        }
        if(tomateCheck.compareTo("true") == 0){
            SelectTomate.setChecked(true);
        }
        if(vegetarianoCheck.compareTo("true") == 0){
            SelectVegetariano.setChecked(true);
        }
        if(dispensaCheck.compareTo("true") == 0){
            SelectDispensa.setChecked(true);
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.6));


        botaoLimpar = (Button) findViewById(R.id.buttonLimpar);
        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectAlface.setChecked(false);
                SelectVegetariano.setChecked(false);
                SelectDispensa.setChecked(false);
                SelectTomate.setChecked(false);
                SelectMaca.setChecked(false);
                SelectCouve.setChecked(false);
                SelectBanana.setChecked(false);
                SelectBacalhau.setChecked(false);
                SelectAzeite.setChecked(false);
                SelectLaranja.setChecked(false);
                SelectFrango.setChecked(false);
            }
        });



        botaoAceitar = (Button) findViewById(R.id.buttonAceitar);
        botaoAceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedSelection.edit();
                Intent adicionarIntent = new Intent();
                String alimentos = "";
                if(SelectLaranja.isChecked()){
                    alimentos = alimentos + " laranja";
                    editor.putString("laranja", "true");
                }
                else{
                    editor.putString("laranja", "false");
                }

                if(SelectAlface.isChecked()){
                    alimentos = alimentos + " alface";
                    editor.putString("alface", "true");
                }
                else{
                    editor.putString("alface", "false");
                }

                if(SelectAzeite.isChecked()){
                    alimentos = alimentos + " azeite";
                    editor.putString("azeite", "true");
                }
                else{
                    editor.putString("azeite", "false");
                }

                if(SelectBacalhau.isChecked()){
                    alimentos = alimentos + " bacalhau";
                    editor.putString("bacalhau", "true");
                }
                else{
                    editor.putString("bacalhau", "false");
                }

                if(SelectBanana.isChecked()){
                    alimentos = alimentos + " banana";
                    editor.putString("banana", "true");
                }
                else{
                    editor.putString("banana", "false");
                }

                if(SelectCouve.isChecked()){
                    alimentos = alimentos + " couve";
                    editor.putString("couve", "true");
                }
                else{
                    editor.putString("couve", "false");
                }

                if(SelectFrango.isChecked()){
                    alimentos = alimentos + " frango";
                    editor.putString("frango", "true");
                }
                else{
                    editor.putString("frango", "false");
                }

                if(SelectMaca.isChecked()){
                    alimentos = alimentos + " maca";
                    editor.putString("maca", "true");
                }
                else{
                    editor.putString("maca", "false");
                }

                if(SelectTomate.isChecked()){
                    alimentos = alimentos + " tomate";
                    editor.putString("tomate", "true");
                }
                else{
                    editor.putString("tomate", "false");
                }

                if(SelectDispensa.isChecked()){
                    alimentos = alimentos + " dispensa";
                    editor.putString("dispensa", "true");
                }
                else{
                    editor.putString("dispensa", "false");
                }

                if(SelectVegetariano.isChecked()){
                    alimentos = alimentos + " vegetariano";
                    editor.putString("vegetariano", "true");
                }
                else{
                    editor.putString("vegetariano", "false");
                }

                if(!SelectVegetariano.isChecked() && !SelectDispensa.isChecked() && !SelectAlface.isChecked() && !SelectBanana.isChecked() && !SelectCouve.isChecked() && !SelectLaranja.isChecked() && !SelectMaca.isChecked() && !SelectTomate.isChecked() && !SelectFrango.isChecked() && !SelectBacalhau.isChecked() && !SelectAzeite.isChecked()){
                    alimentos = "alface banana couve laranja maca tomate frango bacalhau azeite";
                }

                adicionarIntent.putExtra(EXTRA_COUNT, alimentos);
                setResult(RESULT_OK, adicionarIntent);
                editor.apply();
                finish();
            }
        });

    }

}
