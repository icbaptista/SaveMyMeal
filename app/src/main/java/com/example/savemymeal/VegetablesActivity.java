package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class VegetablesActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int TEXT_REQUEST = 1;
    private TextView text_count;
    public static final String EXTRA_NAME =
            "com.example.android.savemymeal.extra.MESSAGE";
    private TextView NameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetables_main);

        LinearLayout l1 = (LinearLayout) findViewById(R.id.linearLayout_Laranja);
        l1.setOnClickListener(this);
        LinearLayout l2 = (LinearLayout) findViewById(R.id.linearLayout_Tomate);
        l2.setOnClickListener(this);
        LinearLayout l3 = (LinearLayout) findViewById(R.id.linearLayout_Maca);
        l3.setOnClickListener(this);
        LinearLayout l4 = (LinearLayout) findViewById(R.id.linearLayout_Alface);
        l4.setOnClickListener(this);
        LinearLayout l5 = (LinearLayout) findViewById(R.id.linearLayout_Banana);
        l5.setOnClickListener(this);
        LinearLayout l6 = (LinearLayout) findViewById(R.id.linearLayout_Couve);
        l6.setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String laranja_count = sharedPref.getString("laranja","0 itens");
        TextView laranja = findViewById(R.id.text_laranja_count);
        laranja.setText(laranja_count);

        String tomate_count = sharedPref.getString("tomate","0 itens");
        TextView tomate = findViewById(R.id.text_tomate_count);
        tomate.setText(tomate_count);

        String maca_count = sharedPref.getString("maca","0 itens");
        TextView maca = findViewById(R.id.text_maca_count);
        maca.setText(maca_count);

        String alface_count = sharedPref.getString("alface","0 itens");
        TextView alface = findViewById(R.id.text_alface_count);
        alface.setText(alface_count);

        String banana_count = sharedPref.getString("banana","0 itens");
        TextView banana = findViewById(R.id.text_banana_count);
        banana.setText(banana_count);

        String couve_count = sharedPref.getString("couve","0 itens");
        TextView couve = findViewById(R.id.text_couve_count);
        couve.setText(couve_count);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(VegetablesActivity.this,PopUp.class);
        String message = null;
        switch (v.getId()) {
            case R.id.linearLayout_Laranja:
                NameText = findViewById(R.id.text_laranja_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_laranja_count);
                break;
            case R.id.linearLayout_Tomate:
                NameText = findViewById(R.id.text_tomate_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_tomate_count);
                break;
            case R.id.linearLayout_Maca:
                NameText = findViewById(R.id.text_maca_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_maca_count);
                break;
            case R.id.linearLayout_Alface:
                NameText = findViewById(R.id.text_alface_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_alface_count);
                break;
            case R.id.linearLayout_Banana:
                NameText = findViewById(R.id.text_banana_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_banana_count);
                break;
            case R.id.linearLayout_Couve:
                NameText = findViewById(R.id.text_couve_name);
                message = NameText.getText().toString();
                text_count = findViewById(R.id.text_couve_count);
                break;
            default:
                break;
        }
        intent.putExtra(EXTRA_NAME, message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String j = text_count.getText().toString();
        String[] k = j.split(" ");
        int l = Integer.parseInt(k[0]);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(PopUp.EXTRA_COUNT);
                int r = Integer.parseInt(reply);
                int o = l + r;
                String temp = Integer.toString(o);
                String f;
                if (o == 1){
                    f = temp + " item";
                } else {
                    f = temp + " itens";
                }
                text_count.setText(f);
            }
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TextView laranja = findViewById(R.id.text_laranja_count);
        editor.putString("laranja",laranja.getText().toString());
        TextView tomate = findViewById(R.id.text_tomate_count);
        editor.putString("tomate",tomate.getText().toString());
        TextView maca = findViewById(R.id.text_maca_count);
        editor.putString("maca",maca.getText().toString());
        TextView alface = findViewById(R.id.text_alface_count);
        editor.putString("alface",alface.getText().toString());
        TextView banana = findViewById(R.id.text_banana_count);
        editor.putString("banana",banana.getText().toString());
        TextView couve = findViewById(R.id.text_couve_count);
        editor.putString("couve",couve.getText().toString());
        editor.apply();
    }
    public void showLista(View view) {
        Intent seeList = new Intent(VegetablesActivity.this, ListaDeCompras.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(VegetablesActivity.this, HomePage.class);
        startActivity(seeList);
    }

    public void showRecipes(View view){
        Intent seeList = new Intent(VegetablesActivity.this, receipt_selection.class);
        startActivity(seeList);
    }
}