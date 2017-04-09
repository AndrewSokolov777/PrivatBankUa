package exp.privatebank.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import exp.privatebank.App;
import exp.privatebank.di.AppComponent;

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.getAppComponent());
    }

    public abstract void setupComponent(AppComponent appComponent);
}
