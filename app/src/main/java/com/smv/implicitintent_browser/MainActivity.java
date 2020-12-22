package com.smv.implicitintent_browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    Button odpriBrskalnik;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = findViewById(R.id.editTextURL);
        odpriBrskalnik = findViewById(R.id.buttonBrowser);

        odpriBrskalnik.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //potrebno je vpisati celoten naslov, npr. http://www.arnes.si
                String webpage = url.getText().toString();

                //seznam vgrajenih implicitnih intentov: v iskalnik vpiši "common intents"
                //https://developer.android.com/guide/components/intents-common
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webpage));
                //program se sesuje, če uporabnik nima ustreznega programa, potrebno je preverjanje
                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });
    }
}