package exp.privatebank.di;

import dagger.Component;
import exp.privatebank.view.activity.DetailMapsActivity;
import exp.privatebank.view.activity.MainActivity;

@Component(dependencies = {AppComponent.class}, modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
    void inject(DetailMapsActivity detailMapsActivity);
}
