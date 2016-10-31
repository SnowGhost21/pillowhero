package hackaton2016.pillowhero.ui.main;

import android.content.Context;

import java.util.Date;

import hackaton2016.pillowhero.commom.DateHelper;
import hackaton2016.pillowhero.commom.ResponseCallBack;
import hackaton2016.pillowhero.model.PlayListServer;
import hackaton2016.pillowhero.model.PlayListService;
import hackaton2016.pillowhero.model.SharedPreferenceModel;

/**
 * Created by diegocunha on 29/10/16.
 */

public class HourPresenter {

    private HourView view;
    private SharedPreferenceModel sharedPreferenceModel;
    private PlayListServer service;


    public HourPresenter(HourView view, Context context) {
        this.view = view;
        sharedPreferenceModel = new SharedPreferenceModel(context);
        this.service = new PlayListServer();
        loadImage();

    }

    public void getValues(Date selectedDate) {

        sharedPreferenceModel.setTimeString(DateHelper.timeToString(selectedDate.getTime()));
        sharedPreferenceModel.setTimeSeconds(DateHelper.invervalSeconds(selectedDate));

        view.enableContinue();
        view.sendHours(DateHelper.timeToString(selectedDate.getTime()));
    }

    public void saveHardMode(boolean isHardMode) {

        if (isHardMode) {
            service.setHardAlarm(sharedPreferenceModel.getTimeSeconds(), new ResponseCallBack<Boolean>() {
                @Override
                public void onComplete(Boolean response, boolean hasError) {
                    if (response && !hasError) {
                        view.enableContinue();
                    } else {
                        view.disableContinue();
                    }
                }
            });
        } else {
            service.setSoftAlarm(sharedPreferenceModel.getTimeSeconds(), new ResponseCallBack<Boolean>() {
                @Override
                public void onComplete(Boolean response, boolean hasError) {
                    if (response && !hasError) {
                        view.enableContinue();
                    } else {
                        view.disableContinue();
                    }
                }
            });
        }
        sharedPreferenceModel.setHardMode(isHardMode);
    }

    private void loadImage() {
        view.onShowImage(sharedPreferenceModel.getPreferenceImage());
    }
}
