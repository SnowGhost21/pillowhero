package hackaton2016.pillowhero.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import hackaton2016.pillowhero.Object.PlayList;
import hackaton2016.pillowhero.commom.ResponseCallBack;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diegocunha on 29/10/16.
 */

public class PlayListServer {

    private Gson gson;
    private Retrofit retrofit;
    private PlayListService service;

    public PlayListServer() {

        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(PlayListService.class);
    }

    public static final String BASE_URL = "https://38db908a.ngrok.io/";

    public void requestDataPlayList(final ResponseCallBack<List<PlayList>> callBack) {

        service.getPlayLists().enqueue(new Callback<List<PlayList>>() {
            @Override
            public void onResponse(Call<List<PlayList>> call, Response<List<PlayList>> response) {
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    callBack.onComplete(response.body(), false);
                } else {
                    callBack.onComplete(null, false);
                }
            }

            @Override
            public void onFailure(Call<List<PlayList>> call, Throwable t) {
                callBack.onComplete(null, false);
            }
        });
    }

    public void playSpecificPlayList(String uri, final ResponseCallBack<Boolean> callBack) {
        service.playSpecificPlayList(uri).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body()) {
                    callBack.onComplete(true, false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }

    public void stopSpecificPlayList(String uri, final ResponseCallBack<Boolean> callBack) {
        service.stopSpecificPlayList().enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()) {
                    callBack.onComplete(response.body(), false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }

    public void currentPlayList(final ResponseCallBack<String> callBack) {
        service.getCurrentPlayList().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && !response.body().isEmpty()) {
                    callBack.onComplete(response.body(), false);
                } else {
                    callBack.onComplete(null, true);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callBack.onComplete(null, true);
            }
        });
    }

    public void setSoftAlarm(int duration, final ResponseCallBack<Boolean> callBack) {
        service.setSoftAlarm(duration).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body()) {
                    callBack.onComplete(true, false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }

    public void setHardAlarm(int duration, final ResponseCallBack<Boolean> callBack) {
        service.setHardAlarm(duration).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body()) {
                    callBack.onComplete(true, false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }

    public void setPlay(final ResponseCallBack<Boolean> callBack) {
        service.restartSpecificPlayLit().enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body()) {
                    callBack.onComplete(true, false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }

    public void setStop(final ResponseCallBack<Boolean> callBack) {
        service.stopSpecificPlayList().enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful() && response.body()) {
                    callBack.onComplete(true, false);
                } else {
                    callBack.onComplete(false, true);
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                callBack.onComplete(false, true);
            }
        });
    }
}
