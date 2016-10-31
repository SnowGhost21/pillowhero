package hackaton2016.pillowhero.ui.main;

/**
 * Created by diegocunha on 30/10/16.
 */

public interface DetailAlarmView {

    void showData(String day, String hour, int drawable, String playlist);
    void canPlayMusic();
    void canStopMusic();
}
