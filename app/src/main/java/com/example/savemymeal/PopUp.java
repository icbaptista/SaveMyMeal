package com.example.savemymeal;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class PopUp extends AppCompatActivity {
    private int Count = 0;
    private TextView ShowCount;
    public static final String EXTRA_COUNT =
            "com.example.android.savemymeal.extra.Itens";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow_vegetables);
        ShowCount = (TextView) findViewById(R.id.count);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        getWindow().setLayout((int) (width*0.9),(int) (height*0.45));

        Intent intent = getIntent();
        String message = intent.getStringExtra(VegetablesActivity.EXTRA_NAME);
        TextView name = findViewById(R.id.Text_PopUp);
        name.setText(message);
    }

    public void plus(View view) {
        if (ShowCount != null)  {
            Count++;
            ShowCount.setText(Integer.toString(Count));
        }
    }

    public void minus(View view) {
        if (ShowCount != null)  {
            if(Count <= 0){
                Snackbar mySnackbar = Snackbar.make(view, "Tem de ser mais de 0",  Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            } else {
                Count--;
                ShowCount.setText(Integer.toString(Count));
            }
        }
    }

    public void Adicionar(View view) {
        String Count = ShowCount.getText().toString();
        Intent AdicionarIntent = new Intent();
        AdicionarIntent.putExtra(EXTRA_COUNT, Count);
        setResult(RESULT_OK, AdicionarIntent);
        finish();
    }
}
