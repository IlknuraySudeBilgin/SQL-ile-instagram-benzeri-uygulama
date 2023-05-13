package com.example.uygulamayapmaodevim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img1;
    EditText kAdi,sifre,email;

    Button btn;
    TextView tvKayit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kAdi=findViewById(R.id.kullaniciadi);
        sifre=findViewById(R.id.sifre);
        tvKayit=findViewById(R.id.tvKayit);
        btn=findViewById(R.id.btngir);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullad=kAdi.getText().toString();
                String kullsifre=sifre.getText().toString();
                Database db= new Database(getApplicationContext(),"Uygulama",null,1);

                if(kullad.length()==0 || kullsifre.length()==0)
                {
                    Toast.makeText(MainActivity.this, "Kullanıcı adı veya şifre boş bırakılamaz!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(db.giris(kullad,kullsifre)==1)
                    {
                        Toast.makeText(MainActivity.this, "Giriş Yapıldı", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,MainActivity2.class));
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Geçersiz Kullanıcı Adı vey Şifre", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });


        tvKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,KayitActivity.class);
                startActivity(intent);
            }
        });






    }
}