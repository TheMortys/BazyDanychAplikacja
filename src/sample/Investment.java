package sample;

import com.google.gson.annotations.SerializedName;

public class Investment {

    @SerializedName("kwota")
    private float kwota;
    @SerializedName("oprocentowanie")
    private float oprocentowanie;

    public Investment(float kwota, float oprocentowanie) {
        this.kwota = kwota;
        this.oprocentowanie = oprocentowanie;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public float getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(float oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }
}
