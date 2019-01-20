package sample;

import com.google.gson.annotations.SerializedName;

public class Bank {

    @SerializedName("id")
    private int id;
    @SerializedName("nazwa")
    private String nazwa;
    @SerializedName("telefon")
    private String telefon;
    @SerializedName("email")
    private String email;
    @SerializedName("adresId")
    private int adresId;
    @SerializedName("adresID")
    private int adresID;
    @SerializedName("adres")
    private Adress adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public int getAdresID() {
        return adresID;
    }

    public void setAdresID(int adresID) {
        this.adresID = adresID;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", adresId=" + adresId +
                ", adresID=" + adresID +
                ", adress=" + adress +
                '}';
    }
}
