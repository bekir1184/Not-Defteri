package com.example.notdefteri.Model;

public class Not {
    private int ID;
    private String not_basligi;
    private String not_icerigi;
    private String tarih;

    public Not( String not_basligi, String not_icerigi, String tarih) {

        this.not_basligi = not_basligi;
        this.not_icerigi = not_icerigi;
        this.tarih = tarih;
    }

    public Not() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNot_basligi() {
        return not_basligi;
    }

    public void setNot_basligi(String not_basligi) {
        this.not_basligi = not_basligi;
    }

    public String getNot_icerigi() {
        return not_icerigi;
    }

    public void setNot_icerigi(String not_icerigi) {
        this.not_icerigi = not_icerigi;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String toString(){
        return not_basligi+" "+not_icerigi+" "+tarih;
    }
}
