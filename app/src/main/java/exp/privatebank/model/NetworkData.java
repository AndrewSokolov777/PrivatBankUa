package exp.privatebank.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import exp.privatebank.network.GoogleLocationApi;
import exp.privatebank.network.PrivateBankApi;
import exp.privatebank.pojo.DevicesPOJO.DevicesResponse;
import exp.privatebank.pojo.RoutePojo.Route;
import exp.privatebank.pojo.RoutePojo.Route_;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NetworkData {
    
    private DevicesResponse mResponseTSO;
    private DevicesResponse mResponseATM;

    public Observable<DevicesResponse> getPrivateBankTSOInfo(final String townName, final Retrofit retrofit) throws IOException {
        return Observable.create(new Observable.OnSubscribe<DevicesResponse>() {
            @Override
            public void call(Subscriber<? super DevicesResponse> subscriber) {
                PrivateBankApi privateBankApi = retrofit.create(PrivateBankApi.class);
                privateBankApi.getDataTSO(townName).enqueue(new Callback<DevicesResponse>() {
                    @Override
                    public void onResponse(Call<DevicesResponse> call, Response<DevicesResponse> response) {
                        if(response.isSuccessful()) {
                            mResponseTSO = response.body();
                            subscriber.onNext(mResponseTSO);
                        }else {
                            subscriber.onError(new Throwable());
                        }
                    }

                    @Override
                    public void onFailure(Call<DevicesResponse> call, Throwable t) {
                        subscriber.onError(new Throwable());
                    }
                });
            }
        });
    }

    public Observable<DevicesResponse> getPrivateBankATMInfo(final String townName, final Retrofit retrofit) throws IOException {
        return Observable.create(new Observable.OnSubscribe<DevicesResponse>() {
            @Override
            public void call(Subscriber<? super DevicesResponse> subscriber) {
                PrivateBankApi privateBankApi = retrofit.create(PrivateBankApi.class);
                privateBankApi.getDataATM(townName).enqueue(new Callback<DevicesResponse>() {
                    @Override
                    public void onResponse(Call<DevicesResponse> call, Response<DevicesResponse> response) {
                        if(response.isSuccessful()) {
                            mResponseATM = response.body();
                            subscriber.onNext(mResponseATM);
                        }else {
                            subscriber.onError(new Throwable());
                        }
                    }

                    @Override
                    public void onFailure(Call<DevicesResponse> call, Throwable t) {
                        subscriber.onError(new Throwable());
                    }
                });
            }
        });
    }

    public Observable<List<Route_>> getRoute(final String start, final String finish, final Retrofit retrofit) throws IOException {
        return Observable.create(new Observable.OnSubscribe<List<Route_>>() {
            @Override
            public void call(Subscriber<? super List<Route_>> subscriber) {
                GoogleLocationApi locationAPI = retrofit.create(GoogleLocationApi.class);
                Route response = null;
                try {
                    response = locationAPI.getLocationData(start, finish).execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                List<Route_> routeList = response.getRoutes();
                subscriber.onNext(routeList);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
