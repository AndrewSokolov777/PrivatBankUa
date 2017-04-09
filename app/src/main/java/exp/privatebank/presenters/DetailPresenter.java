package exp.privatebank.presenters;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;
import exp.privatebank.common.BasePresenter;
import exp.privatebank.model.NetworkData;
import exp.privatebank.util.LocationUtil;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.view.DetailView;
import retrofit2.Retrofit;

public class DetailPresenter implements BasePresenter<DetailView> {

    private DetailView mView;
    private Context mContext;
    private Retrofit mRetrofit;
    private NetworkData mNetworkData;
    private LocationUtil mLocationUtil;

    @Inject
    public DetailPresenter(Context context, @Named("googleAPI") Retrofit retrofit,
                           NetworkData networkData, LocationUtil locationUtil) {
        mContext = context;
        mRetrofit = retrofit;
        mNetworkData = networkData;
        mLocationUtil = locationUtil;
    }

    @Override
    public void init(DetailView view) {
        this.mView = view;
    }

    public void getRoute(LatLng start, Device finish) throws IOException {
        String currentPositionInString = String.valueOf(start.latitude) + ","
                + String.valueOf(start.longitude);
        String destinationPositionInString = finish.getLatitude() + "," + finish.getLongitude();

        mNetworkData.getRoute(currentPositionInString, destinationPositionInString, mRetrofit)
                .subscribe(routeList ->{
                    mView.drawRoute(routeList, finish);
        });
    }

    public void getCurrentLocation() throws IOException {
        mLocationUtil.getCurrentLocation(mContext).subscribe(currentLocation -> {
            mView.drawCurrentLocation(currentLocation);
        });
    }
}
