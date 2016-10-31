package hackaton2016.pillowhero.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import net.danlew.android.joda.JodaTimeAndroid;

import butterknife.ButterKnife;
import hackaton2016.pillowhero.R;


public class MainActivity extends AppCompatActivity {

    private Bundle arguments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        JodaTimeAndroid.init(getApplicationContext());


        replaceFragment();
    }

    private void replaceFragment() {
        Fragment newFragment = new PlayListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, newFragment);
        transaction.commit();

    }

    public void saveMainFragment(Bundle args) {
        this.arguments = args;
    }

    public Bundle getSavedBundle() {
        return arguments;
    }
}
