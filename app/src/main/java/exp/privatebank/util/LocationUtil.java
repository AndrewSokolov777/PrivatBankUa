package exp.privatebank.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import com.google.android.gms.maps.model.LatLng;
import java.io.IOException;
import rx.Observable;
import rx.Subscriber;

public class LocationUtil {

    private LocationManager mLocationManager;

    public Observable<LatLng> getCurrentLocation(Context context) throws IOException {
        return Observable.create(new Observable.OnSubscribe<LatLng>() {
            @Override
            public void call(Subscriber<? super LatLng> subscriber) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, 100, new LocationListener() {

                        @Override
                    public void onLocationChanged(Location location) {
                        LatLng result = new LatLng(location.getLatitude(), location.getLongitude());
                        subscriber.onNext(result);
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {}

                    @Override
                    public void onProviderEnabled(String s) {}

                    @Override
                    public void onProviderDisabled(String s) {}
                });
            }
        }});
    }
}
