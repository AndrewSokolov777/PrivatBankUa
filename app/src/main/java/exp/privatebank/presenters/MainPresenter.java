package exp.privatebank.presenters;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import exp.privatebank.R;
import exp.privatebank.common.BasePresenter;
import exp.privatebank.model.DbHelper;
import exp.privatebank.model.NetworkData;
import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.storage.DevicesStorage;
import exp.privatebank.pojo.DevicesPOJO.DevicesResponse;
import exp.privatebank.view.MainView;
import retrofit2.Retrofit;
import rx.Subscriber;

public class MainPresenter implements BasePresenter<MainView> {

    private Context mContext;
    private MainView mView;
    private Retrofit mRetrofit;
    private DevicesResponse mATM;
    private DevicesResponse mTSO;
    private NetworkData mNetworkData;
    private DbHelper mDbHelper;

    @Inject
    public MainPresenter(@Named("privateBankAPI") Retrofit retrofit, NetworkData networkData,
                         DbHelper dbHelper, Context context) {
        mRetrofit = retrofit;
        mNetworkData = networkData;
        mDbHelper = dbHelper;
        mContext = context;
    }

    @Override
    public void init(MainView view) {
        this.mView = view;
    }

    public void searchDataByTown(String townName) throws IOException {

//        if no network connection - get data from DB
        DevicesStorage.nullAll();
        if (NetworkData.isNetworkAvailable(mContext)) {
            networkSearch(townName);
        } else {
            mDbHelper.getDevicesByTown(townName).subscribe(bankDevices -> {
                if (bankDevices == null) {
                    mView.showErrorMessage(mContext.getResources().getString(R.string.no_data));
                } else {
                    DevicesStorage.setBankDevices(bankDevices);
                    mView.getResultAndStartMap();
                }
            });
        }
    }

    private void networkSearch(String townName) throws IOException {
        mNetworkData.getPrivateBankTSOInfo(townName, mRetrofit).subscribe(new Subscriber<DevicesResponse>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMessage(mContext.getResources().getString(R.string.something_wrong));
            }

            @Override
            public void onNext(DevicesResponse devicesResponse) {
                mTSO = devicesResponse;
                checkResultAndStart();
            }
        });

        mNetworkData.getPrivateBankATMInfo(townName, mRetrofit).subscribe(new Subscriber<DevicesResponse>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.showErrorMessage(mContext.getResources().getString(R.string.something_wrong));
            }

            @Override
            public void onNext(DevicesResponse devicesResponse) {
                mATM = devicesResponse;
                checkResultAndStart();
            }
        });
    }

    private void checkResultAndStart() {
        if (mTSO != null && mATM != null && !mTSO.getDevices().isEmpty() && !mATM.getDevices().isEmpty()) {
            List<Device> allDevices = mTSO.getDevices();
            allDevices.addAll(mATM.getDevices());
            DevicesStorage.setAllDevices(allDevices);
            mTSO = null;
            mATM = null;
            mDbHelper.addNewDevices(allDevices).subscribe();
            mView.getResultAndStartMap();
        }else if(mTSO != null && mATM != null) {
            mTSO = null;
            mATM = null;
            mView.showErrorMessage(mContext.getResources().getString(R.string.incorrect_input));
        }
    }
}