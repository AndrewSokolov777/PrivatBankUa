package exp.privatebank.model;

import android.content.Context;
import android.util.ArraySet;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.DeleteQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exp.privatebank.pojo.DevicesPOJO.Device;
import exp.privatebank.util.Util;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DbHelper {

    private Database mDb;
    private DaoMaster mDaoMaster;

    public DbHelper(Context context) {
        this.mDb = new DaoMaster.DevOpenHelper(context, "private_bank_devices", null).getWritableDb();
        mDaoMaster = new DaoMaster(mDb);
    }

    public Observable<Boolean> addNewDevices(List<Device> devicesList) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                DaoSession daoSession = mDaoMaster.newSession();
                BankDeviceDao bankdeviceDao = daoSession.getBankDeviceDao();

                List<BankDevice> bankDevices = bankdeviceDao.queryBuilder()
                        .where(BankDeviceDao.Properties.CityRu.eq(devicesList.get(0).getCityRU()))
                        .list();

                if(bankDevices != null){
                    DeleteQuery<BankDevice> deleteQuery = bankdeviceDao.queryBuilder().where(BankDeviceDao.Properties.CityRu
                            .eq(devicesList.get(0).getCityRU())).buildDelete();
                    deleteQuery.executeDeleteWithoutDetachingEntities();
                }

                ArrayList<BankDevice> insertList = new ArrayList<>();
                for(Device item: devicesList) {
                    insertList.add(new BankDevice(null,
                            item.getType(), item.getCityEN(), item.getCityRU(), item.getCityUA(),
                            item.getFullAddressEn(), item.getFullAddressRu(), item.getFullAddressUa(),
                            item.getPlaceRu(), item.getPlaceUa(), item.getLatitude(), item.getLongitude(),
                            item.getTw().getMon(), item.getTw().getTue(), item.getTw().getWed(),
                            item.getTw().getTue(), item.getTw().getFri(), item.getTw().getSat(),
                            item.getTw().getSun()));
                }
                bankdeviceDao.insertInTx(insertList);
                subscriber.onNext(true);
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<BankDevice>> getDevicesByTown(String cityName) {
        return Observable.create(new Observable.OnSubscribe<List<BankDevice>>() {
            @Override
            public void call(Subscriber<? super List<BankDevice>> subscriber) {
                DaoSession daoSession = mDaoMaster.newSession();
                BankDeviceDao bankDeviceDao = daoSession.getBankDeviceDao();

                List<BankDevice> resultRu = bankDeviceDao.queryBuilder()
                        .where(BankDeviceDao.Properties.CityRu.eq(cityName))
                        .list();
                if(!resultRu.isEmpty()){
                    subscriber.onNext(resultRu);
                }else {
                    List<BankDevice> resultUa = bankDeviceDao.queryBuilder()
                            .where(BankDeviceDao.Properties.CityUa.eq(Util.convertToPBStyle(cityName)))
                            .list();
                    if(!resultUa.isEmpty()){
                        subscriber.onNext(resultUa);
                    } else {
                        List<BankDevice> resultEn = bankDeviceDao.queryBuilder()
                                .where(BankDeviceDao.Properties.CityEn.eq(cityName))
                                .list();
                        if(!resultEn.isEmpty()) {
                            subscriber.onNext(resultEn);
                        }else {
                            subscriber.onNext(null);
                        }
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
