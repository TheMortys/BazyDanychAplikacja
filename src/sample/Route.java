package sample;

import io.reactivex.Observable;
import retrofit2.http.*;

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

    @GET("pracownik/konto/wyszukaj/klient")
    Observable<ClientProfile> findProfile(@Header("Authorization") String header, @Query("imie") String imie, @Query("nazwisko") String nazwisko, @Query("pesel") int pesel);

    @GET("/pracownik/bank/dane")
    Observable<Bank> getBank(@Header("Authorization") String header);
    //Coś nie tak
    @GET ("/pracownik/transakcje/historia/klient/{klientId}")
    Observable<Transfer[]> getHistory(@Header("Authorization") String header, @Path("klientId") String klientId);
    //TO DO
    @POST("/pracownik/transakcje/przelew/klient/{klientId}")
    Observable<DefaultResponse> transferTo(@Header("Authorization") String header, @Path("klientId") String klientId, @Body Transfer transfer);
    //TO DO
    @POST("/pracownik/transakcje/wplata/klient/{klientId}")
    Observable<DefaultResponse> putMoney(@Header("Authorization") String header, @Path("klientId") String klientId, @Body Transfer transfer);
    //TO DO
    @POST("/pracownik/transakcje/wyplata/klient/{klientId}")
    Observable<DefaultResponse> getMoney(@Header("Authorization") String header, @Path("klientId") String klientId, @Body Transfer transfer);
    //TO DO
    @DELETE("/pracownik/konto/usun/klient/{klientId}")
    Observable<DefaultResponse> delAccount(@Header("Authorization") String header, @Path("klientId") String klientId);
    //TO DO
    @POST("/pracownik/pozyczki/dodaj/klient/{klientId}")
    Observable<DefaultResponse> getLoan(@Header("Authorization") String header, @Path("klientId") String klientId, @Body Loan loan);
    //TO DO
    @POST("/pracownik/lokaty/dodaj/klient/{klientId}")
    Observable<DefaultResponse> getInvestment(@Header("Authorization") String header, @Path("klientId") String klientId, @Body Investment investment);
    //TO DO
    @GET ("/pracownik/pozyczki/lista/klient/{klientId}")
    Observable<Loan[]> getLoans(@Header("Authorization") String header, @Path("klientId") String klientId);
    //To DO
    @GET ("/pracownik/lokaty/lista/klient/{klientId}")
    Observable<Investment[]> getInvestments(@Header("Authorization") String header, @Path("klientId") String klientId);
}
