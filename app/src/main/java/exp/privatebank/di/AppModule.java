package exp.privatebank.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import exp.privatebank.App;
import exp.privatebank.model.DbHelper;
import exp.privatebank.model.NetworkData;
import exp.privatebank.util.LocationUtil;

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    Context providesContext() {
        return app.getApplicationContext();
    }

    @Provides
    NetworkData providesNetworkUtil() {
        return new NetworkData();
    }

    @Provides
    LocationUtil providesLocationUtil() {
        return new LocationUtil();
    }

    @Provides
    DbHelper providesDbRepository() {
        return new DbHelper(app.getApplicationContext());
    }
}
