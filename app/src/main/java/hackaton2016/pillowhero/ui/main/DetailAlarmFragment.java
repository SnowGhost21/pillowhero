package hackaton2016.pillowhero.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import de.hdodenhof.circleimageview.CircleImageView;
import hackaton2016.pillowhero.R;
import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * Created by diegocunha on 29/10/16.
 */

public class DetailAlarmFragment extends Fragment implements DetailAlarmView {

    @BindView(R.id.titleHour)
    protected TextView titleHour;
    @BindView(R.id.titleDay)
    protected TextView titleDay;
    @BindView(R.id.imageBackGround)
    protected ImageView background;
    @BindView(R.id.imageAvatar)
    protected ImageView avatar;
    @BindView(R.id.titlePlayList)
    protected TextView playList;
    @BindView(R.id.playPause)
    protected ImageButton playPause;


    private DetailAlarmPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, rootView);

        presenter = new DetailAlarmPresenter(this, getContext());
        presenter.getData();


        return rootView;
    }

    @Override
    public void showData(String day, String hour, int drawable, String name) {
        titleDay.setText(day);
        titleHour.setText(hour);
        Picasso.with(getContext()).load(drawable).transform(new BlurTransformation(getContext(), 25)).into(background);
        avatar.setImageDrawable(ContextCompat.getDrawable(getContext(), drawable));
        playList.setText(name);

        presenter.verifyStatus();
    }

    @Override
    public void canPlayMusic() {
        playPause.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.btn_play_large));
    }

    @Override
    public void canStopMusic() {
        playPause.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.btn_pause));
    }

    @Optional
    @OnClick(R.id.playPause)
    protected void playPauseMusic() {
        presenter.canPlayThisMusic();
    }
}
