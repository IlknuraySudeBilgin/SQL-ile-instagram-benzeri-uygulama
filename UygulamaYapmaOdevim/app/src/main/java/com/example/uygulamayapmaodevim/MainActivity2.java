package com.example.uygulamayapmaodevim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {

    BottomNavigationView bottomnavim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bottomnavim=findViewById(R.id.bnavim);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();//default olarak home gelecek

        bottomnavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new HomeFragment()).commit();
                        break;

                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new SearchFragment()).commit();
                        break;

                    case R.id.person:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new PersonFragment()).commit();
                        break;



                }

                return true;
            }
        });




    }



    //geri gelindiginde bilgileri sıfırlamak icin
    public void onBackPressed(){

        Intent geriintent= new Intent(MainActivity2.this,MainActivity.class);
        finish();
        startActivity(geriintent);

    }
}