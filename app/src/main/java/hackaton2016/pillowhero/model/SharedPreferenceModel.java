package hackaton2016.pillowhero.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by diegocunha on 30/10/16.
 */

public class SharedPreferenceModel {

    private SharedPreferences preferences;
    private static final String PREFERENCES = "preferences";
    private static final String PREFERENCE_URI = "Uri";
    private static final String PREFERENCE_PLAYLIST_NAME = "PlayListName";
    private static final String PREFERENCE_TIME_SECONDS = "Seconds";
    private static final String PREFERENCE_TIME_STRING = "TimeString";
    private static final String PREFERENCE_HARD_MODE = "HardMode";
    private static final String PREFERENCE_IMAGE = "image";

    public SharedPreferenceModel(Context context) {
        preferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setPlayListURI(String uri) {
        preferences.edit().putString(PREFERENCE_URI, uri).apply();
    }

    public String getPlayListURI() {
        return preferences.getString(PREFERENCE_URI, "");
    }

    public void setPlayListName(String name) {
        preferences.edit().putString(PREFERENCE_PLAYLIST_NAME, name).apply();
    }

    public String getPlayListName() {
        return preferences.getString(PREFERENCE_PLAYLIST_NAME, "");
    }

    public void setTimeSeconds(int duration) {
        preferences.edit().putInt(PREFERENCE_TIME_SECONDS, duration).apply();
    }

    public int getTimeSeconds() {
        return preferences.getInt(PREFERENCE_TIME_SECONDS, 0);
    }

    public void setTimeString(String time) {
        preferences.edit().putString(PREFERENCE_TIME_STRING, time).apply();
    }

    public String getTimeString() {
        return preferences.getString(PREFERENCE_TIME_STRING, "");
    }

    public void setHardMode(boolean hardMode) {
        preferences.edit().putBoolean(PREFERENCE_HARD_MODE, hardMode).apply();
    }

    public boolean getHardMode() {
        return preferences.getBoolean(PREFERENCE_HARD_MODE, false);
    }

    public void setPreferenceImage(int drawable) {
        preferences.edit().putInt(PREFERENCE_IMAGE, drawable).apply();
    }

    public int getPreferenceImage() {
        return preferences.getInt(PREFERENCE_IMAGE, 0);
    }
}
