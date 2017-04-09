package exp.privatebank.di;

import javax.inject.Named;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    @Provides
    @Named("privateBankAPI")
    Retrofit providesPrivateBankAPIRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.privatbank.ua/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides @Named("googleAPI")
    Retrofit providesGoogleAPIRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
