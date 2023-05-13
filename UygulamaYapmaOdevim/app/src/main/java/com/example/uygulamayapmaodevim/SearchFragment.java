package com.example.uygulamayapmaodevim;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.ClipData;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {


    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private SearchView searchView;
    private List<Model> itemList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView=view.findViewById(R.id.recView);
        searchView=view.findViewById(R.id.searchView);
        searchView.clearFocus();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);

                return true;
            }
        });


        itemList=new ArrayList<>();
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



        itemAdapter=new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);
        return view;
    }

    private void filterList(String text) {
        List<Model> filteredList = new ArrayList<>();
        for(Model item : itemList){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        if(filteredList.isEmpty()) {
            Toast.makeText(getActivity(), "Aranan ürün bulunamadı!", LENGTH_SHORT).show();
        }
        else {
           itemAdapter.setFilteredList(filteredList);

        }


    }


}