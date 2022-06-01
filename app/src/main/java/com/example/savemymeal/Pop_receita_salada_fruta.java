package com.example.savemymeal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Pop_receita_salada_fruta extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_up_salada_fruta);

        // Modifying toolbar
        Toolbar toolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width),(int)(height));


        VideoView videoView = findViewById(R.id.salada_fruta_video_view);
        String videoPath = "android.resource://" +  getPackageName() + "/" + R.raw.salada_fruta_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
    public void showFridge(View view) {
        Intent seeList = new Intent(Pop_receita_salada_fruta.this, DispensaActivity.class);
        startActivity(seeList);
    }

    public void showHome(View view) {
        Intent seeList = new Intent(Pop_receita_salada_fruta.this, HomePage.class);
        startActivity(seeList);
    }

    public void showLista(View view){
        Intent seeList = new Intent(Pop_receita_salada_fruta.this, ListaDeCompras.class);
        startActivity(seeList);
    }
}
