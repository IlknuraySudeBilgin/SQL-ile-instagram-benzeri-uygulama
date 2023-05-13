package com.example.uygulamayapmaodevim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KayitActivity extends AppCompatActivity {

    EditText kayitad,kayitEmail,kayitSifre,kayitSifreOnay;
    Button btnKayit;
    TextView tvHesapvarsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        kayitad=findViewById(R.id.edKayitAd);
        kayitEmail=findViewById(R.id.edKayitEmail);
        kayitSifre=findViewById(R.id.edKayitSifre);
        kayitSifreOnay=findViewById(R.id.edKayitSifreOnay);
        btnKayit=findViewById(R.id.btnKayitOl);
        tvHesapvarsa=findViewById(R.id.tvHesapvarsa);

        tvHesapvarsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(KayitActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad=kayitad.getText().toString();
                String email=kayitEmail.getText().toString();
                String sifre=kayitSifre.getText().toString();
                String sifreonay=kayitSifreOnay.getText().toString();
                Database db= new Database(getApplicationContext(),"Uygulama",null,1);

                if(ad.length()==0 || email.length()==0 || sifre.length()==0 || sifreonay.length()==0)
                {
                    Toast.makeText(KayitActivity.this, "İstenen verilerden herhangi biri boş bırakılamaz!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(sifre.compareTo(sifreonay)==0)
                    {
                        if(gecerliSifre(sifre)){

                            db.kayit(ad,email,sifre);
                            Toast.makeText(KayitActivity.this, "Kayıt Olundu!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(KayitActivity.this,MainActivity.class));

                        }
                        else {
                            Toast.makeText(KayitActivity.this, "Geçersiz Şifre!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else {
                        Toast.makeText(KayitActivity.this, "Şifre ve Şifre Onay eşleşmedi!", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });


    }

    //gecerli sifre icin metot olusturalım
    public static boolean gecerliSifre(String sifrem)
    {
        int f1=0,f2=0,f3=0;
        if(sifrem.length()<8)
        {
            return false;
        }
        else{
            for(int p =0; p<sifrem.length();p++)
            {
                if(Character.isLetter(sifrem.charAt(p)))
                {
                    f1=1;
                }
            }
            for(int r =0; r<sifrem.length();r++)
            {
                if(Character.isDigit(sifrem.charAt(r)))
                {
                    f2=1;
                }
            }
            for(int s =0; s<sifrem.length();s++){
                char c=sifrem.charAt(s);
                if(c>=33&&c<=46||c==64)
                {
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)

                return true;
            return false;




        }
    }

}