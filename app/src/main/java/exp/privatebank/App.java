package exp.privatebank;

import android.app.Application;
import org.greenrobot.greendao.database.Database;
import exp.privatebank.di.AppComponent;
import exp.privatebank.di.AppModule;
import exp.privatebank.di.DaggerAppComponent;
import exp.privatebank.model.DaoMaster;
import exp.privatebank.model.DaoSession;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        buildGraphAndInject();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "private_bank_devices", null);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public void buildGraphAndInject() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }
}
