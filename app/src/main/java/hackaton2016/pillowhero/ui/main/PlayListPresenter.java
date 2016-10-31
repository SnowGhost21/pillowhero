package hackaton2016.pillowhero.ui.main;

import android.content.Context;
import android.util.Log;

import java.util.List;

import hackaton2016.pillowhero.Object.PlayList;
import hackaton2016.pillowhero.commom.ResponseCallBack;
import hackaton2016.pillowhero.model.PlayListServer;
import hackaton2016.pillowhero.model.SharedPreferenceModel;

/**
 * Created by diegocunha on 29/10/16.
 */

public class PlayListPresenter {

    private PlayListView view;
    private PlayListServer model;
    private SharedPreferenceModel sharedPreferenceModel;

    public PlayListPresenter(PlayListView view, Context context) {
        this.view = view;
        model = new PlayListServer();
        sharedPreferenceModel = new SharedPreferenceModel(context);
    }

    public void loadPlayList() {
        model.requestDataPlayList(new ResponseCallBack<List<PlayList>>() {
            @Override
            public void onComplete(List<PlayList> response, boolean hasError) {
                if (hasError || response == null) {
                    view.onError();
                } else {
                    view.onComplete(response);
                }
            }
        });
    }

    public void saveInformation(PlayList playList, int drawable) {
        sharedPreferenceModel.setPlayListName(playList.getPlayListName());
        sharedPreferenceModel.setPlayListURI(playList.getUri());
        sharedPreferenceModel.setPreferenceImage(drawable);
    }
}
