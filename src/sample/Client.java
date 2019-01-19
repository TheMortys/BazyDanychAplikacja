package sample;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Client {

    public Client(String name, String lastName, String pesel, String nip, String date, String login, String password, String street, String adrNumber1, String adrNumber2, String zipCode, String city, int telephone, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.nip = nip;
        this.date = date;
        this.login = login;
        this.password = password;
        this.street = street;
        this.adrNumber1 = adrNumber1;
        this.adrNumber2 = adrNumber2;
        this.zipCode = zipCode;
        this.city = city;
        this.telephone = telephone;
        this.mail = mail;
    }

    @SerializedName("imie")
    private String name;
    @SerializedName("nazwisko")
    private String lastName;
    @SerializedName("authToken")
    private String authToken;
    @SerializedName("pesel")
    private String pesel;
    @SerializedName("nip")
    private String nip;
    @SerializedName("data")
    private String date;
    @SerializedName("login")
    private String login;
    @SerializedName("haslo")
    private String password;
    @SerializedName("ulica")
    private String street;
    @SerializedName("nrDomu")
    private String adrNumber1;
    @SerializedName("nrLokalu")
    private String adrNumber2;
    @SerializedName("kodPocztowy")
    private String zipCode;
    @SerializedName("miejscowosc")
    private String city;
    @SerializedName("telefon")
    private int telephone;
    @SerializedName("email")
    private String mail;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdrNumber1() {
        return adrNumber1;
    }

    public void setAdrNumber1(String adrNumber1) {
        this.adrNumber1 = adrNumber1;
    }

    public String getAdrNumber2() {
        return adrNumber2;
    }

    public void setAdrNumber2(String adrNumber2) {
        this.adrNumber2 = adrNumber2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
