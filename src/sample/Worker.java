package sample;

import com.google.gson.annotations.SerializedName;

public class Worker {

    @SerializedName("imie")
    private String name;
    @SerializedName("nazwisko")
    private String lastName;
    @SerializedName("authToken")
    private String authToken;
    @SerializedName("login")
    private String login;
    @SerializedName("haslo")
    private String haslo;
    @SerializedName("email")
    private String email;
    @SerializedName("stanowisko")
    private String stanowisko;
    @SerializedName("telefon")
    private String telefon;

    public Worker(String name, String lastName, String login, String haslo, String email, String stanowisko, String telefon) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.stanowisko = stanowisko;
        this.telefon = telefon;
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
