package exp.privatebank.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import javax.inject.Inject;
import exp.privatebank.App;
import exp.privatebank.R;
import exp.privatebank.common.BaseActivity;
import exp.privatebank.common.IHasComponent;
import exp.privatebank.di.AppComponent;
import exp.privatebank.di.DaggerMainComponent;
import exp.privatebank.di.MainComponent;
import exp.privatebank.presenters.MainPresenter;
import exp.privatebank.util.Util;
import exp.privatebank.view.MainView;

public class MainActivity extends BaseActivity implements MainView, IHasComponent<MainComponent> {

    public static MainComponent mComponent;

    @Inject
    MainPresenter presenter;
    private Button mSearchBtn;
    private EditText mSearchText;
    private View mLoadingCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingCircle = findViewById(R.id.progressCircle);
        mSearchText = (EditText) findViewById(R.id.serchText);
        mSearchBtn = (Button) findViewById(R.id.searchBtn);
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mSearchText.getText().toString().equals("")){
                    try {
                        showLoadingAnimation();
                        mSearchBtn.setEnabled(false);
                        presenter.searchDataByTown(Util.makeCapitalLetter(mSearchText.getText().toString()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        presenter.init(this);
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        mComponent = DaggerMainComponent.builder()
                .appComponent(App.getAppComponent())
                .build();
        mComponent.inject(this);
    }

    @Override
    public void getResultAndStartMap() {
        hideLoadingAnimation();
        mSearchBtn.setEnabled(true);
        Intent intent = new Intent(MainActivity.this, DetailMapsActivity.class);
        startActivity(intent);
    }

    private void hideLoadingAnimation() {
        mLoadingCircle.setAnimation(null);
        mLoadingCircle.setVisibility(View.INVISIBLE);
    }

    private void showLoadingAnimation() {
        Animation progressAnimation = AnimationUtils.loadAnimation(this, R.anim.loading_rotation);
        mLoadingCircle.setVisibility(View.VISIBLE);
        mLoadingCircle.startAnimation(progressAnimation);
    }

    @Override
    public void showErrorMessage(String errorMsg) {
        hideLoadingAnimation();
        mSearchBtn.setEnabled(true);
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();;
    }

    @Override
    public MainComponent getComponent() {
        return mComponent;
    }

    public static MainComponent getMainComponent() {
        return mComponent;
    }
}