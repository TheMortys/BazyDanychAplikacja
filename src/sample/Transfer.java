package sample;

import com.google.gson.annotations.SerializedName;

public class Transfer {

    @SerializedName("docelowyNrKonta")
    private String dst;
    @SerializedName("tytul")
    private String tytul;
    @SerializedName("kwota")
    private float kwota;
    @SerializedName("data")
    private String data;

    public Transfer(String dst, String tytul, float kwota, String data) {
        this.dst = dst;
        this.tytul = tytul;
        this.kwota = kwota;
        this.data = data;
    }

    public String getDst() {
        return dst;
    }

    public void setDst(String dst) {
        this.dst = dst;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
