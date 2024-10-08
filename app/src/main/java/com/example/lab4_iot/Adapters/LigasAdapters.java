package com.example.lab4_iot.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_iot.DTO.Ligas;
import com.example.lab4_iot.R;

import java.util.List;

public class LigasAdapters extends RecyclerView.Adapter<LigasAdapters.LigasViewHolder> {
    private List<Ligas> ligasList;
    private Context context;

    //Constructor
    public LigasAdapters(List<Ligas> ligasList, Context context) {
        this.ligasList = ligasList;
        this.context = context;
    }

    @NonNull
    @Override
    public LigasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ligas, parent, false);
        return new LigasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LigasViewHolder holder, int position) {
        Ligas liga = ligasList.get(position);
        TextView tvName = holder.itemView.findViewById(R.id.leagueName);
        tvName.setText(holder.ligas.getStrLeague());
        TextView tvAlternate = holder.itemView.findViewById(R.id.leagueAlternateName);
        tvAlternate.setText(holder.ligas.getStrLeagueAlternate());
    }

    @Override
    public int getItemCount() {
        return ligasList.size();
    }

    // ViewHolder para gestionar la vista
    public static class LigasViewHolder extends RecyclerView.ViewHolder {
        Ligas ligas;
        TextView tvName, tvAlternate;

        public LigasViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.leagueName);
            tvAlternate = itemView.findViewById(R.id.leagueAlternateName);
        }
    }
}
