package com.example.notdefteri.Fragmentlar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notdefteri.Model.Not;
import com.example.notdefteri.R;
import com.example.notdefteri.Sqlite.Veri_kaynagi;

import java.text.SimpleDateFormat;
import java.util.Date;


public class NotEkle extends Fragment {
    View v;
    Veri_kaynagi veri_kaynagi;
    Context context;

    EditText notBasligi,notIcerigi;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getContext();

        v=inflater.inflate(R.layout.fragment_not_ekle, container, false);
        veri_kaynagi = new Veri_kaynagi(context);

        veri_kaynagi.ac();

        button =v.findViewById(R.id.ekle_button);
        notBasligi=v.findViewById(R.id.notBaslik);
        notIcerigi=v.findViewById(R.id.not_icerik);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notBasligi.getText().toString() == ""  || notIcerigi.getText().toString() == "" ){

                    Toast.makeText(context,"Not içeriği ve not başlığı boş bırakılamaz",Toast.LENGTH_LONG);

                }


                notEkle();
            }
        });


        return v;
    }
    public void notEkle(){
        String notBaslikStr =notBasligi.getText().toString() ;
        System.out.println(notBaslikStr);
        String notIcerikStr =notIcerigi.getText().toString();
        System.out.println(notIcerikStr);
        Not not = new Not(notBaslikStr,notIcerikStr,sistemSaati());
        veri_kaynagi.notOlustur(not);

        notIcerigi.setText("");
        notBasligi.setText("");

        Toast.makeText(context,"Not eklendi",Toast.LENGTH_LONG);

    }
    public  String sistemSaati(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        return simpleDateFormat.format(new Date());

    }



}
