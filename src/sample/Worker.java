package sample;

import com.google.gson.annotations.SerializedName;

public class Worker {

    @SerializedName("imie")
    private String name;
    @SerializedName("nazwisko")
    private String lastName;
    @SerializedName("authToken")
    private String authToken;

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
