package exp.privatebank.view.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import exp.privatebank.R;
import exp.privatebank.common.BaseActivity;
import exp.privatebank.di.AppComponent;
import exp.privatebank.model.BankDevice;
import exp.privatebank.model.NetworkData;
import exp.privatebank.storage.DevicesStorage;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.pojo.RoutePojo.Route_;
import exp.privatebank.presenters.DetailPresenter;
import exp.privatebank.view.DetailView;
import exp.privatebank.view.fragment.InfoDialogFragment;

public class DetailMapsActivity extends BaseActivity implements OnMapReadyCallback, DetailView {

    private final String TARGET_DEVICE = "targetDevice";
    private final String CURRENT_LOCATION = "currentLocation";
    private final String TSO_TYPE = "TSO";

    private InfoDialogFragment mInfoDialogFragment;
    private List<Device> mAllDevices;
    private List<BankDevice> mBankDevices;
    private GoogleMap mMap;
    private LatLng mCurrentLocation;
    private List<Route_> mRouteList;
    private Device mTargetDevice;

    @Inject
    DetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mInfoDialogFragment = new InfoDialogFragment();
        mInfoDialogFragment.setListener(new InfoDetailListener());

        if(savedInstanceState!= null) {
            mCurrentLocation = savedInstanceState.getParcelable(CURRENT_LOCATION);
            mTargetDevice = savedInstanceState.getParcelable(TARGET_DEVICE);
        }

        if(DevicesStorage.getAllDevices() != null){
            mAllDevices = DevicesStorage.getAllDevices();
        }else {
            mBankDevices = DevicesStorage.getBankDevices();
        }
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        MainActivity.getMainComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.init(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if(mCurrentLocation == null) {
            try {
                mPresenter.getCurrentLocation();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        focusAndDrawDevices();

        if(mCurrentLocation != null){
            drawCurrentLocation(mCurrentLocation);
            if(mTargetDevice != null && DevicesStorage.getRouteList() != null){
                drawRoute(DevicesStorage.getRouteList(), mTargetDevice);
            }
        }
    }

     private void focusAndDrawDevices() {
         if(mAllDevices != null) {
             mMap.moveCamera(CameraUpdateFactory.newLatLng(
                     new LatLng(Double.parseDouble(mAllDevices.get(0).getLatitude()),
                             Double.parseDouble(mAllDevices.get(0).getLongitude()))));
         }else {
             mMap.moveCamera(CameraUpdateFactory.newLatLng(
                     new LatLng(Double.parseDouble(mBankDevices.get(0).getLatitude()),
                             Double.parseDouble(mBankDevices.get(0).getLongitude()))));
         }
         mMap.animateCamera(CameraUpdateFactory.zoomTo(12), 2000, null);
         drawDevices();
    }

    private void drawDevices(){
        if(mAllDevices != null) {
            for (Device item : mAllDevices) {
                LatLng position = new LatLng(Double.parseDouble(item.getLatitude()),
                        Double.parseDouble(item.getLongitude()));
                if (item.getType().equals(TSO_TYPE)) {
                    mMap.addMarker(new MarkerOptions().position(position)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                } else {
                    mMap.addMarker(new MarkerOptions().position(position));
                }
            }

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    LatLng pos = marker.getPosition();

                    for (Device item : mAllDevices) {
                        if (Double.parseDouble(item.getLatitude()) == pos.latitude
                                && Double.parseDouble(item.getLongitude()) == pos.longitude) {
                            mTargetDevice = item;
                            showDialogInfo();
                            break;
                        }
                    }
                    return false;
                }
            });
        }else {
            drawAllBankDevices();
        }
    }

    private void drawAllBankDevices() {
        for(BankDevice item: mBankDevices){
            LatLng position = new LatLng(Double.parseDouble(item.getLatitude()),
                    Double.parseDouble(item.getLongitude()));
            if (item.getType().equals(TSO_TYPE)) {
                mMap.addMarker(new MarkerOptions().position(position)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
            } else {
                mMap.addMarker(new MarkerOptions().position(position));
            }
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng pos = marker.getPosition();
                for (BankDevice item : mBankDevices) {
                    if (Double.parseDouble(item.getLatitude()) == pos.latitude
                            && Double.parseDouble(item.getLongitude()) == pos.longitude) {
                        mTargetDevice = new Device(item.getType(), item.getCityRu(), item.getCityUa(),
                                item.getCityEn(), item.getAddressRu(), item.getAddressUa(), item.getAddressEn(),
                                item.getPlaceRu(), item.getPlaceUa(), item.getLatitude(), item.getLongitude(), null);
                        showDialogInfo();
                        break;
                    }
                }
                return false;
            }
        });
    }

    private void showDialogInfo(){
        Dialog dialog = mInfoDialogFragment.getDialog();
        if(dialog != null && dialog.isShowing()){
        }else {
            Bundle bundle = new Bundle();
            bundle.putParcelable(InfoDialogFragment.DEVICE, mTargetDevice);
            mInfoDialogFragment.setArguments(bundle);
            mInfoDialogFragment.show(getSupportFragmentManager(), InfoDialogFragment.INFO_TAG);
        }
    }

    @Override
    public void drawRoute(List<Route_> routeList, Device finish) {
        DevicesStorage.setRouteList(routeList);
        mMap.clear();
        drawDevices();
        mRouteList = routeList;
        mMap.addMarker(new MarkerOptions().position(mCurrentLocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .title(getResources().getString(R.string.current_position_title)));

        for (Route_ item: mRouteList) {
            String encodedString = item.getOverview_polyline().getPoints();
            List<LatLng> list = PolyUtil.decode(encodedString);
            mMap.addPolyline(new PolylineOptions()
                    .addAll(list)
                    .width(5)
                    .color(Color.BLUE)
                    .geodesic(true)
            );
        }
    }

    @Override
    public void drawCurrentLocation(LatLng currentLocation) {
            mCurrentLocation = currentLocation;
            mMap.addMarker(new MarkerOptions().position(currentLocation)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    .title(getResources().getString(R.string.current_position_title)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
    }

    public class InfoDetailListener {
        public void routeConfirm(Device device) throws IOException {
            if(mCurrentLocation == null){
                showErrorMsg(getResources().getString(R.string.no_current_position));

            }else if(!NetworkData.isNetworkAvailable(DetailMapsActivity.this)){
                    showErrorMsg(getResources().getString(R.string.no_internet_connection));
            }else {
                mTargetDevice = device;
                mPresenter.getRoute(mCurrentLocation, mTargetDevice);
            }
        }
    }

    public void showErrorMsg(String errorMsg) {
        Toast.makeText(DetailMapsActivity.this,
                errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(TARGET_DEVICE, mTargetDevice);
        outState.putParcelable(CURRENT_LOCATION, mCurrentLocation);
    }
}
