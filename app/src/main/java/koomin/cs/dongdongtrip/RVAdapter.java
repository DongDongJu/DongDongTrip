package koomin.cs.dongdongtrip;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by grid on 16. 5. 8..
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.StateViewHolder> {

    public static class StateViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView stateName;
        TextView stateAge;
        ImageView statePhoto;

        StateViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            stateName = (TextView)itemView.findViewById(R.id.state_name);
            stateAge = (TextView)itemView.findViewById(R.id.state_age);
            statePhoto = (ImageView)itemView.findViewById(R.id.state_photo);
        }
    }

    List<State> states;

    RVAdapter(List<State> states){
        this.states = states;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        StateViewHolder pvh = new StateViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StateViewHolder stateViewHolder, int i) {
        stateViewHolder.stateName.setText(states.get(i).name);
        stateViewHolder.stateAge.setText(states.get(i).des);
        stateViewHolder.statePhoto.setImageResource(states.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return states.size();
    }
}
