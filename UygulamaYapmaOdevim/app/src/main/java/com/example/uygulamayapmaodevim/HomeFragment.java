package com.example.uygulamayapmaodevim;

import static com.example.uygulamayapmaodevim.R.drawable.kolye1;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

   // ListView listem;


    RecyclerView recyclerView;
    List<Model> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

       // initData();

        recyclerView.setAdapter(new ItemAdapter(initData()));




        return view;
    }

    private List<Model> initData() {

        itemList= new ArrayList<>();
        itemList.add(new Model(R.drawable.kolye1,"Taşlı çiçek kolye"));
        itemList.add(new Model(R.drawable.kolye2,"Yıldız desenli ikili kolye"));
        itemList.add(new Model(R.drawable.kolye3,"Kırmızı taşlı kalp çoklu kolye"));
        itemList.add(new Model(R.drawable.kolye4,"Anahtar kolye"));
        itemList.add(new Model(R.drawable.kupe1,"Altın rengi desenli halka küpe"));
        itemList.add(new Model(R.drawable.kupe2,"Safir kelebekli küpe"));
        itemList.add(new Model(R.drawable.kupe3,"Altıgen küpe"));
        itemList.add(new Model(R.drawable.kupe4,"Pırlanta taşlı küpe"));
        itemList.add(new Model(R.drawable.b1,"Pandora kelebek bileklik"));
        itemList.add(new Model(R.drawable.b2,"Altın rengi tabanlı su yolu bileklik"));
        itemList.add(new Model(R.drawable.b3,"Üç renk çoklu bileklik"));
        itemList.add(new Model(R.drawable.b4,"Damla taş su yolu bileklik"));
        itemList.add(new Model(R.drawable.y1,"Baget taş pırlanta yüzük"));
        itemList.add(new Model(R.drawable.yy2,"Tek taş pırlanta yüzük"));
        itemList.add(new Model(R.drawable.y4,"Tek taş pırlanta yüzük"));

        return itemList;





    }
}