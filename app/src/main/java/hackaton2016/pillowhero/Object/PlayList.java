package hackaton2016.pillowhero.Object;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by diegocunha on 29/10/16.
 */

public class PlayList {

    @SerializedName("uri")
    String uri;
    @SerializedName("name")
    String playListName;
    List<Song> songsList;
    String playListImage;

    public PlayList() {
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public List<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Song> songsList) {
        this.songsList = songsList;
    }

    public String getPlayListImage() {
        return playListImage;
    }

    public void setPlayListImage(String playListImage) {
        this.playListImage = playListImage;
    }
}
