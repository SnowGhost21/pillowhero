package hackaton2016.pillowhero.model;

import java.util.List;

import hackaton2016.pillowhero.Object.PlayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by diegocunha on 29/10/16.
 */

public interface PlayListService {

    @GET("playlist/all")
    Call<List<PlayList>> getPlayLists();

    @GET("playlist/play/{uri}")
    Call<Boolean> playSpecificPlayList(@Path("uri") String uri);

    @GET("control/play")
    Call<Boolean> restartSpecificPlayLit();

    @GET("control/stop")
    Call<Boolean> stopSpecificPlayList();

    @GET("control/current")
    Call<String> getCurrentPlayList();

    @GET("alarm/set/soft/{duration}")
    Call<Boolean> setSoftAlarm(@Path("duration") int duration);

    @GET("alarm/set/hard/{duration}")
    Call<Boolean> setHardAlarm(@Path("duration") int duration);
}
