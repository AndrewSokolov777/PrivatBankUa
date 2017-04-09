package exp.privatebank.network;

import exp.privatebank.pojo.DevicesPOJO.DevicesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PrivateBankApi {
    @GET("p24api/infrastructure?json&tso&address=&")
    Call<DevicesResponse> getDataTSO(@Query("city") String cityName);

    @GET("p24api/infrastructure?json&atm&address=&")
    Call<DevicesResponse> getDataATM(@Query("city") String cityName);
}
