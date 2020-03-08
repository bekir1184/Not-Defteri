package com.example.notdefteri.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.notdefteri.Model.Not;
import com.example.notdefteri.R;

import java.util.List;

public class NotAdapter  extends PagerAdapter {

    Activity context;
    List<Not> liste;
    private LayoutInflater layoutInflater;


    public NotAdapter(Activity context, List<Not> liste) {
        this.context = context;
        this.liste = liste;
    }

    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater =LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.item,container,false);

        TextView notBaslik,noticerik,tarih;

        notBaslik=view.findViewById(R.id.baslik);
        noticerik=view.findViewById(R.id.icerikYazilacak);
        tarih=view.findViewById(R.id.tarih);

        notBaslik.setText(liste.get(position).getNot_basligi() );
        noticerik.setText(liste.get(position).getNot_icerigi());
        tarih.setText(liste.get(position).getTarih());

        container.addView(view,0);
        return  view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
