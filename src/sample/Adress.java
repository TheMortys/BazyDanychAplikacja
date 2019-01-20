package sample;

import com.google.gson.annotations.SerializedName;

public class Adress {

    @SerializedName("id")
    private int id;
    @SerializedName("ulica")
    private String ulica;
    @SerializedName("numerDomu")
    private int numerDomu;
    @SerializedName("numerLokalu")
    private int numerLokalu;
    @SerializedName("kodPocztowy")
    private String kodPocztowy;
    @SerializedName("miejscowosc")
    private String miejscowosc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(int numerDomu) {
        this.numerDomu = numerDomu;
    }

    public int getNumerLokalu() {
        return numerLokalu;
    }

    public void setNumerLokalu(int numerLokalu) {
        this.numerLokalu = numerLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", ulica='" + ulica + '\'' +
                ", numerDomu=" + numerDomu +
                ", numerLokalu=" + numerLokalu +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miejscowosc='" + miejscowosc + '\'' +
                '}';
    }
}
