package hackaton2016.pillowhero.ui.main;

import java.util.Date;
import java.util.List;

import hackaton2016.pillowhero.commom.IView;

/**
 * Created by diegocunha on 29/10/16.
 */

public interface HourView extends IView {

    void onValuesLoaded(Date receivedDate);

    void enableContinue();

    void disableContinue();

    void sendHours(String value);

    void setCurrentPosition(String response);

    void saveAlarm(int duration);

    void onShowImage(int drawable);

}
