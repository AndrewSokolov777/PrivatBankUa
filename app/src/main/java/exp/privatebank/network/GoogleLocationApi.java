package exp.privatebank.network;

import exp.privatebank.pojo.RoutePojo.Route;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleLocationApi {
    @GET("maps/api/directions/json?")
    Call<Route> getLocationData(@Query("origin") String position, @Query("destination") String destination);
}
