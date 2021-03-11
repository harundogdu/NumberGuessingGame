package com.info.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private TextView textViewHak, textViewDegisim;
    private Button buttonTahminEt;
    private EditText editTextTahmin;
    private int sayac = 7;
    private int rastgeleSayi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        textViewDegisim = findViewById(R.id.textViewDegisim);
        textViewHak = findViewById(R.id.textViewHak);
        buttonTahminEt = findViewById(R.id.buttonTahminEt);
        editTextTahmin = findViewById(R.id.editTextTahmin);

        Random random = new Random();

        rastgeleSayi = random.nextInt(101);
        Log.e("Rastgele Sayı", String.valueOf(rastgeleSayi));


        buttonTahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editTextTahmin.getText().toString().equals("")) {
                    textViewDegisim.setText("Sayı Giriniz !!!");
                } else {
                    sayac -= 1;

                    int tahmin = Integer.parseInt(editTextTahmin.getText().toString());

                    if (rastgeleSayi == tahmin) {
                        Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                        i.putExtra("sonuc", true);
                        startActivity(i);
                        finish();
                        return;
                    }
                    if (tahmin < rastgeleSayi) {
                        textViewDegisim.setText("Son Tahmin : " + tahmin + " \n   Sayıyı Arttır");
                        textViewHak.setText("Kalan Hak : " + sayac);
                    }
                    if (tahmin > rastgeleSayi) {
                        textViewDegisim.setText("Son Tahmin : " + tahmin + " \n   Sayıyı Azalt");
                        textViewHak.setText("Kalan Hak : " + sayac);
                    }
                    if (sayac == 0) {
                        Intent i = new Intent(TahminActivity.this, SonucActivity.class);
                        i.putExtra("sonuc", false);
                        i.putExtra("sayi",rastgeleSayi);
                        startActivity(i);
                        finish();
                    }

                    editTextTahmin.setText("");
                }
            }
        });
    }

}