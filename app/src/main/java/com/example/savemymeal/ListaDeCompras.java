package com.example.savemymeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaDeCompras extends AppCompatActivity {

    static ListView listView;
    static ArrayList<String> items;
    static ArrayList<Integer> quantities;
    static ListViewAdapter adapter;
    Dialog myDialog;
    EditText input;
    EditText input_nr;
    Button add;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_compras);

        // Modifying toolbar
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        // Button to add new ingredients to the list
        input = findViewById(R.id.input_item);
        add = findViewById(R.id.btn_add_ingredient);

        // Putting initial items in the shopping list
        listView = findViewById(R.id.shopping_list);
        items = new ArrayList<>();
        items.add("Laranja");
        items.add("Tomate");
        items.add("Ovo");
        items.add("Leite");

        quantities = new ArrayList<>();
        quantities.add(1);
        quantities.add(1);
        quantities.add(1);
        quantities.add(1);

        adapter = new ListViewAdapter(getApplicationContext(), items, quantities);
        listView.setAdapter(adapter);

        // SetOnItemClick event
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String name = items.get(position);
            makeToast(name);
        });

        // SetOnItemLong event
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            makeToast("Long press: "+ items.get(position));
            return false;
        });


        //Activate 'Adicionar' button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                //int quantity = Integer.parseInt(input.getText().toString());
                if(text == null || text.length() == 0){
                    makeToast("Enter an item.");
                } else {
                    addItem(text);
                    input.setText("");
                    makeToast("Added: " + text);
                }
            }
        });
    }

    public static void addItem(String item) {
        items.add(item);
        listView.setAdapter(adapter);
    }

    public static void removeItem(int remove){
        items.remove(remove);
        listView.setAdapter(adapter);
    }

    Toast t;

    private void makeToast(String s){
        if(t != null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT);
        t.show();
    }

    public void loadContent () {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, "list.txt");
        byte[] content = new byte[(int) readFrom.length()];

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(readFrom);
            stream.read(content);

            String s = new String(content);
            s = s.substring(1, s.length()-1);
            String split[] = s.split(", ");
            items = new ArrayList<>(Arrays.asList(split));
            adapter = new ListViewAdapter(this, items, quantities);
            listView.setAdapter(adapter);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, "list.txt"));
            writer.write(items.toString().getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    public void showFridge(View view) {
        Intent seeList = new Intent(ListaDeCompras.this, DispensaActivity.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(ListaDeCompras.this, HomePage.class);
        startActivity(seeList);
    }

    public void showRecipes(View view){
        Intent seeList = new Intent(ListaDeCompras.this, receipt_selection.class);
        startActivity(seeList);
    }
}