package sample;

import com.google.gson.annotations.SerializedName;

public class Loan {

    @SerializedName("kwota")
    private float kwota;
    @SerializedName("terminSplaty")
    private String terminSplaty;
    @SerializedName("oprocentowanie")
    private float oprocentowanie;

    public Loan(float kwota, String terminSplaty, float oprocentowanie) {
        this.kwota = kwota;
        this.terminSplaty = terminSplaty;
        this.oprocentowanie = oprocentowanie;
    }

    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    public String getTerminSplaty() {
        return terminSplaty;
    }

    public void setTerminSplaty(String terminSplaty) {
        this.terminSplaty = terminSplaty;
    }

    public float getOprocentowanie() {
        return oprocentowanie;
    }

    public void setOprocentowanie(float oprocentowanie) {
        this.oprocentowanie = oprocentowanie;
    }
}
