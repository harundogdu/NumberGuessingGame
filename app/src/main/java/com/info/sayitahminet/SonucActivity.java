package com.info.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;
    private Boolean sonuc;
    private int rastgeleSayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);

        buttonTekrar = findViewById(R.id.buttonTekrar);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        imageViewSonuc = findViewById(R.id.imageViewSonuc);

        sonuc = getIntent().getBooleanExtra("sonuc",false);
        rastgeleSayi = getIntent().getIntExtra("sayi",0);

        if(sonuc){
            imageViewSonuc.setImageResource(R.drawable.gulen_resim);
            textViewSonuc.setText("KAZANDINIZ !");
        }else{
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim);
            textViewSonuc.setText("Kaybettiniz ! Sayı : " + rastgeleSayi);
        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this, TahminActivity.class));
                finish();
            }
        });

    }

}