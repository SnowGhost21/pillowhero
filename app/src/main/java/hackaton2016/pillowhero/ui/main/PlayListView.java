package hackaton2016.pillowhero.ui.main;

import java.util.List;

import hackaton2016.pillowhero.Object.PlayList;
import hackaton2016.pillowhero.commom.IView;

/**
 * Created by diegocunha on 29/10/16.
 */

public interface PlayListView extends IView {

    void onComplete(List<PlayList> playList);

    void onError();

    void onPlayListSelected(PlayList playList, int drawable);
}
