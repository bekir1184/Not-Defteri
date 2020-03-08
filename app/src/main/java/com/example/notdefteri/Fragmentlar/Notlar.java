package com.example.notdefteri.Fragmentlar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.notdefteri.Adapter.NotAdapter;
import com.example.notdefteri.Model.Not;
import com.example.notdefteri.R;
import com.example.notdefteri.Sqlite.Veri_kaynagi;

import java.util.ArrayList;
import java.util.List;

public class Notlar extends Fragment {

    View v;
    Veri_kaynagi veri_kaynagi;
    ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v= inflater.inflate(R.layout.fragment_notlar, container, false);

        veri_kaynagi = new Veri_kaynagi(getContext());

        List<Not> notlar =veri_kaynagi.listele();

        System.out.println("Notlar "+ notlar.get(0));

        NotAdapter notAdapter= new NotAdapter(getActivity(),notlar);
        viewPager=v.findViewById(R.id.notlarView);
        viewPager.setAdapter(notAdapter);

        viewPager.setPadding(130,0,130,20);

        return v;
    }

}
