package sample;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Route {

    @POST("/auth/login/pracownik")
    Observable<Worker> workerLogin(@Body LoginRequest loginRequest);
}
