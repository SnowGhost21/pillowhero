package hackaton2016.pillowhero.ui.main;

import android.content.Context;
import android.util.Log;

import hackaton2016.pillowhero.commom.DateHelper;
import hackaton2016.pillowhero.commom.ResponseCallBack;
import hackaton2016.pillowhero.model.PlayListServer;
import hackaton2016.pillowhero.model.SharedPreferenceModel;

/**
 * Created by diegocunha on 30/10/16.
 */

public class DetailAlarmPresenter {

    private DetailAlarmView view;
    private SharedPreferenceModel model;
    private String uri;
    private String name;
    private String date;
    private int duration;
    private PlayListServer server;
    private boolean canPlay;

    public DetailAlarmPresenter(DetailAlarmView view, Context context) {
        this.view = view;
        model = new SharedPreferenceModel(context);
        server = new PlayListServer();
    }

    public void getData() {
        this.uri = model.getPlayListURI();
        this.duration = model.getTimeSeconds();
        this.date = model.getTimeString();
        this.name = model.getPlayListName();

        view.showData(DateHelper.timeToDay(duration), date, model.getPreferenceImage(), name);
    }

    public void verifyStatus() {
        server.currentPlayList(new ResponseCallBack<String>() {
            @Override
            public void onComplete(String response, boolean hasError) {
                if (hasError) {
                    canPlay = true;
                    view.canPlayMusic();
                } else if (response != null && response.equals(uri)) {
                    view.canStopMusic();
                    canPlay = false;
                } else {
                    view.canPlayMusic();
                    canPlay = true;
                }
            }
        });
    }

    public void canPlayThisMusic() {
        if (canPlay) {
            server.playSpecificPlayList(uri, new ResponseCallBack<Boolean>() {
                @Override
                public void onComplete(Boolean response, boolean hasError) {
                    if (!hasError && response) {
                        view.canStopMusic();
                        canPlay = false;
                        Log.e("Start", "Started the party");
                    } else {
                        canPlay = true;
                        view.canPlayMusic();
                    }
                }
            });
        } else {
            server.stopSpecificPlayList(uri, new ResponseCallBack<Boolean>() {
                @Override
                public void onComplete(Boolean response, boolean hasError) {
                    if (!hasError && response) {
                        view.canPlayMusic();
                        canPlay = true;
                        Log.e("End", "Ended the party");
                    } else {
                        canPlay = false;
                        Log.e("Start", "Started the party");
                        view.canStopMusic();
                    }
                }
            });
        }
    }
}
