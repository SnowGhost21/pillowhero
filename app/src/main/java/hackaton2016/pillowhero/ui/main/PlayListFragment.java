package hackaton2016.pillowhero.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hackaton2016.pillowhero.Object.PlayList;
import hackaton2016.pillowhero.R;

/**
 * Created by diegocunha on 29/10/16.
 */

public class PlayListFragment extends Fragment implements PlayListView {

    public static final String SELECTED_PLAYLIST = "playListUri";
    public static final String SELECTED_PLAYLIST_NAME = "playListName";

    @BindView(R.id.playListRecyclerView)
    protected RecyclerView playListRecyclerView;
    private PlayListPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_playlist, container, false);
        ButterKnife.bind(this, rootView);

        presenter = new PlayListPresenter(this, getContext());
        presenter.loadPlayList();

        return rootView;
    }


    @Override
    public void onComplete(List<PlayList> playList) {
        playListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        playListRecyclerView.setAdapter(new PlayListAdapter(playList, this));
    }

    @Override
    public void onError() {

    }

    @Override
    public void onPlayListSelected(PlayList playList, int drawable) {
        presenter.saveInformation(playList, drawable);
        Fragment newFragment = new HourFragment();

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, newFragment);
        transaction.addToBackStack(HourFragment.class.getName());
        transaction.commit();
    }
}
