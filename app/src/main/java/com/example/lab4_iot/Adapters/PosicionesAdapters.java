package com.example.lab4_iot.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_iot.DTO.Posiciones;
import com.example.lab4_iot.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PosicionesAdapters extends RecyclerView.Adapter<PosicionesAdapters.PosicionesViewHolder> {
    private List<Posiciones> posicioneslist;
    private Context context;

    //Constructor
    public PosicionesAdapters(List<Posiciones> posicioneslist, Context context) {
        this.posicioneslist = posicioneslist;
        this.context = context;
    }

    @NonNull
    @Override
    public PosicionesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_posiciones, parent, false);
        return new PosicionesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PosicionesViewHolder holder, int position) {
        Posiciones posiciones = posicioneslist.get(position);
        TextView tvTeam = holder.itemView.findViewById(R.id.tvTeamName);
        tvTeam.setText(holder.posiciones.getStrTeam());
        TextView tvRank = holder.itemView.findViewById(R.id.tvRanking);
        tvRank.setText("Rank: " + holder.posiciones.getIntRank() + " | Puntos: " + holder.posiciones.getIntPoints());
        TextView tvResults = holder.itemView.findViewById(R.id.tvResults);
        tvResults.setText("V: " + holder.posiciones.getIntWin() + " E: " + holder.posiciones.getIntDraw() + " D: " + holder.posiciones.getIntLoss());
        TextView tvGoals = holder.itemView.findViewById(R.id.tvGoals);
        tvGoals.setText("GF: " + holder.posiciones.getIntGoalsFor() + " GC: " + holder.posiciones.getIntGoalsAgainst() + " DG: " + holder.posiciones.getIntGoalDifference());

        Glide.with(context).load(posiciones.getStrBadge()).into(holder.imgBadge);
    }

    @Override
    public int getItemCount() {
        return posicioneslist.size();
    }

    // ViewHolder para gestionar la vista
    public static class PosicionesViewHolder extends RecyclerView.ViewHolder {
        Posiciones posiciones;
        TextView tvTeamName, tvRanking, tvResults, tvGoals;
        ImageView imgBadge;

        public PosicionesViewHolder(View itemView) {
            super(itemView);
            tvTeamName = itemView.findViewById(R.id.tvTeamName);
            tvRanking = itemView.findViewById(R.id.tvRanking);
            tvResults = itemView.findViewById(R.id.tvResults);
            tvGoals = itemView.findViewById(R.id.tvGoals);
            imgBadge = itemView.findViewById(R.id.imgBadge);
        }
    }
}
