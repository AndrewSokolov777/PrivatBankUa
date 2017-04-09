package exp.privatebank.di;

import android.content.Context;
import dagger.Component;
import exp.privatebank.App;
import exp.privatebank.model.DbHelper;
import exp.privatebank.util.LocationUtil;
import exp.privatebank.model.NetworkData;

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);
    NetworkData getNetworkUtil();
    LocationUtil getLocationUtil();
    Context getContext();
    DbHelper getDbRepository();
}
