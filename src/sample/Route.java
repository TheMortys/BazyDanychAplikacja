package sample;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Route {

    @POST("/auth/login/pracownik")
    Observable<Worker> workerLogin(@Body LoginRequest loginRequest);

    @POST("auth/login/klient")
    Observable<Client> clientLogin(@Body LoginRequest loginRequest);

    @POST("/pracownik/konto/dodaj/klient")
    Observable<Client> addClient(@Body Client client);

}
