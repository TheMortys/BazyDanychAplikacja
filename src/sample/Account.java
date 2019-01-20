package sample;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("id")
    private int id;
    @SerializedName("numer")
    private String numer;
    @SerializedName("saldo")
    private float saldo;
    @SerializedName("dataUtworzenia")
    private String dataUtworzenia;
    @SerializedName("klientId")
    private int klientId;
    @SerializedName("bankId")
    private int bankId;
    @SerializedName("pracownikId")
    private int pracownikId;
    @SerializedName("KlientID")
    private int KlientID;
    @SerializedName("PracownikID")
    private int PracownikID;
    @SerializedName("BankID")
    private int BankID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public int getKlientId() {
        return klientId;
    }

    public void setKlientId(int klientId) {
        this.klientId = klientId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getPracownikId() {
        return pracownikId;
    }

    public void setPracownikId(int pracownikId) {
        this.pracownikId = pracownikId;
    }

    public int getKlientID() {
        return KlientID;
    }

    public void setKlientID(int klientID) {
        KlientID = klientID;
    }

    public int getPracownikID() {
        return PracownikID;
    }

    public void setPracownikID(int pracownikID) {
        PracownikID = pracownikID;
    }

    public int getBankID() {
        return BankID;
    }

    public void setBankID(int bankID) {
        BankID = bankID;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", numer='" + numer + '\'' +
                ", saldo=" + saldo +
                ", dataUtworzenia='" + dataUtworzenia + '\'' +
                ", klientId=" + klientId +
                ", bankId=" + bankId +
                ", pracownikId=" + pracownikId +
                ", KlientID=" + KlientID +
                ", PracownikID=" + PracownikID +
                ", BankID=" + BankID +
                '}';
    }
}
