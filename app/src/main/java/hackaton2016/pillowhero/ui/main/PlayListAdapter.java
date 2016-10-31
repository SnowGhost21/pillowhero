package hackaton2016.pillowhero.ui.main;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import hackaton2016.pillowhero.Object.PlayList;
import hackaton2016.pillowhero.R;
import hackaton2016.pillowhero.commom.DateHelper;

/**
 * Created by diegocunha on 29/10/16.
 */

public class PlayListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PlayList> playLists;
    private PlayListView listener;
    private static final String URL = "http://i0.kym-cdn.com/entries/icons/original/000/000/222/Picture_2.png";
    private Context context;

    public PlayListAdapter(List<PlayList> playLists, PlayListView listener) {
        this.playLists = playLists;
        this.listener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new PlayListHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardname_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final PlayList playList = playLists.get(position);
        PlayListHolder playListHolder = (PlayListHolder) holder;

        playListHolder.namePlayList.setText(playList.getPlayListName().replaceAll("_", " ").toUpperCase());
        final int drawable = DateHelper.drawable(position);
        playListHolder.cardLayout.setBackground(ContextCompat.getDrawable(context, drawable));
        playListHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("PlayListName", playList.getPlayListName());
                listener.onPlayListSelected(playList, drawable);
            }
        });

    }

    @Override
    public int getItemCount() {
        return playLists.size();
    }

    protected static class PlayListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cardView)
        CardView card;
        @BindView(R.id.cardLayout)
        RelativeLayout cardLayout;
        @BindView(R.id.namePlayList)
        TextView namePlayList;

        public PlayListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
