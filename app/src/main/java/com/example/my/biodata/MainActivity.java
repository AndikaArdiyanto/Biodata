package com.example.my.biodata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button) findViewById(R . id . button1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText teksedit = (EditText) findViewById( R . id . editText1);
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+ teksedit.getText()));
                startActivity(intent);
            }
        });
        Intent it = getIntent();
        String teks = it.getStringExtra("data.key");



    }



    public void alamat(View view){
        Uri uri = Uri.parse("geo:-6.963426,110.4044558,15"+Uri.encode("Tanggul Mas Timur VII"));
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }

    public void email (View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"andikardi1209@gmail.com"});
        intent.putExtra(Intent.EXTRA_CC, new String[] {"ardiyanto_andika@yahoo.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Ketik Judul");
        intent.putExtra(Intent.EXTRA_EMAIL, "Ketik Pesan");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim E-mail ?"));

        }catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }
}
