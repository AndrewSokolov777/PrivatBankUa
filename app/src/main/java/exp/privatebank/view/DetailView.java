package exp.privatebank.view;

import com.google.android.gms.maps.model.LatLng;
import java.util.List;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.pojo.RoutePojo.Route_;

public interface DetailView {
    void drawRoute(List<Route_> routeList, Device finish);
    void drawCurrentLocation(LatLng loc);
}
