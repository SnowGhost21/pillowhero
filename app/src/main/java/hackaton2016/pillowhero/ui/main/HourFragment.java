package hackaton2016.pillowhero.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.kunzisoft.switchdatetime.SwitchDateTimeDialogFragment;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import hackaton2016.pillowhero.R;
import jp.wasabeef.picasso.transformations.BlurTransformation;

import static hackaton2016.pillowhero.ui.main.PlayListFragment.SELECTED_PLAYLIST;
import static hackaton2016.pillowhero.ui.main.PlayListFragment.SELECTED_PLAYLIST_NAME;

/**
 * Created by diegocunha on 29/10/16.
 */

public class HourFragment extends Fragment implements HourView {


    private SwitchDateTimeDialogFragment dateTimeFragment;

    private HourPresenter presenter;
    @BindView(R.id.openSelectDate)
    protected ImageButton openSelectDate;
    @BindView(R.id.switchHardMode)
    protected SwitchCompat switchHardMode;

    @BindView(R.id.selectedTime)
    protected TextView selectDate;
    @BindView(R.id.sendSelectedDate)
    protected Button selectedDateContinue;
    @BindView(R.id.hourLayout)
    protected ImageView hourLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hour, container, false);
        ButterKnife.bind(this, rootView);
        presenter = new HourPresenter(this, getContext());

        return rootView;
    }

    @Override
    public void onValuesLoaded(Date receivedDate) {

    }

    @Override
    public void enableContinue() {
        selectedDateContinue.setEnabled(true);
        selectedDateContinue.setClickable(true);
    }

    @Override
    public void disableContinue() {

    }

    @Override
    public void sendHours(String value) {
        selectDate.setText(value);
    }

    @Override
    public void setCurrentPosition(String response) {
    }

    @OnClick(R.id.openSelectDate)
    protected void openSelectedDate() {
        dateTimeFragment = SwitchDateTimeDialogFragment.newInstance("Selecione o seu alarme", "Confirmar", "Cancelar");
        dateTimeFragment.setOnButtonClickListener(new SwitchDateTimeDialogFragment.OnButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Date date) {
                presenter.getValues(date);
            }

            @Override
            public void onNegativeButtonClick(Date date) {

            }
        });

        dateTimeFragment.show(getActivity().getSupportFragmentManager(), "DialogAlarm");
    }

    @Override
    public void saveAlarm(int duration) {

    }

    @Optional
    @OnClick(R.id.sendSelectedDate)
    protected void sendHours() {

        presenter.saveHardMode(switchHardMode.isChecked());

        Fragment newFragment = new DetailAlarmFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, newFragment);
        transaction.addToBackStack(DetailAlarmFragment.class.getName());
        transaction.commit();
    }

    @Override
    public void onShowImage(int drawable) {
        Picasso loader = Picasso.with(getContext());
        loader.load(drawable).transform(new BlurTransformation(getContext(), 25)).into(hourLayout);
    }
}
