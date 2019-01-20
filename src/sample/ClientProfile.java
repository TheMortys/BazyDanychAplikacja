package sample;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ClientProfile {
    //...

    @SerializedName("id")
    private int id;
    @SerializedName("imie")
    private String name;
    @SerializedName("nazwisko")
    private String lastName;
    @SerializedName("pesel")
    private String pesel;
    @SerializedName("nip")
    private String nip;
    @SerializedName("dataUrodzenia")
    private String date;
    @SerializedName("login")
    private String login;
    @SerializedName("haslo")
    private String password;
    @SerializedName("telefon")
    private int telephone;
    @SerializedName("email")
    private String mail;
    @SerializedName("adresId")
    private int adresId;
    @SerializedName("bankId")
    private int bankId;
    @SerializedName("kontos")
    private ArrayList<Account> accounts;
    @SerializedName("adre")
    private Adress adress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


    @Override
    public String toString() {
        return "ClientProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", nip='" + nip + '\'' +
                ", date='" + date + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", telephone=" + telephone +
                ", mail='" + mail + '\'' +
                ", adresId=" + adresId +
                ", bankId=" + bankId +
                ", accounts=" + accounts +
                ", adress=" + adress +
                '}';
    }
}
