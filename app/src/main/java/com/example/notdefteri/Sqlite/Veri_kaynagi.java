package com.example.notdefteri.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.notdefteri.Model.Not;

import java.util.ArrayList;
import java.util.List;

public class Veri_kaynagi {
    SQLiteDatabase db;
    Sqlite_katmani benimDb;

    public Veri_kaynagi(Context context) {
        benimDb = new Sqlite_katmani(context);
    }

    public void ac(){
        db=benimDb.getWritableDatabase();
    }
    public void kapat(){
        benimDb.close();
    }
    public void notOlustur(Not not){
        ContentValues deger = new ContentValues();
        deger.put("notBaslik",not.getNot_basligi());
        deger.put("noticerik",not.getNot_icerigi());
        deger.put("tarih",not.getTarih());
        db.insert("NotlarTablo",null,deger);

    }
    public  void notSil(Not n){
        int id =n.getID();
        db.delete("NotlarTablo","id="+id,null);
    }

    public List<Not> listele(){
        String kolonlar[] ={"id","notBaslik","noticerik","tarih"};
        List<Not> donListe = new ArrayList<>();

        db =benimDb.getReadableDatabase();
        Cursor c=db.query("NotlarTablo",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            String notBaslik=c.getString(1);
            System.out.println(notBaslik);
            String notIcerik =c.getString(2);
            System.out.println(notIcerik);
            String notTarih =c.getString(3);
            System.out.println(notTarih);
            Not not=new Not(notBaslik,notIcerik,notTarih);
            donListe.add(not);
            c.moveToNext();

        }
        c.close();
        return donListe;
    }

}
