package sample;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Route {

    @POST("/auth/login/pracownik")
    Observable<Worker> workerLogin(@Body LoginRequest loginRequest);

    @POST("auth/login/klient")
    Observable<Client> clientLogin(@Body LoginRequest loginRequest);

    @POST("/pracownik/konto/dodaj/klient")
    Observable<DefaultResponse> addClient(@Header("Authorization") String header, @Body Client client);

    @POST("pracownik/konto/dodaj/pracownik")
    Observable<DefaultResponse> addWorker(@Header("Authorization") String header, @Body Worker worker);

    @POST("/klient/transakcje/przelew")
    Observable<DefaultResponse> addTransfer(@Header("Authorization") String header, @Body Transfer transfer);

    @GET("/klient/profil")
    Observable<ClientProfile> getClientProfile(@Header("Authorization") String header);

    @GET("/pracownik/bank/dane")
    Observable<Bank> getBank(@Header("Authorization") String header);

}
