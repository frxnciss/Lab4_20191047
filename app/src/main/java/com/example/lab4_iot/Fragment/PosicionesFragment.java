package com.example.lab4_iot.Fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_iot.Adapters.PosicionesAdapters;
import com.example.lab4_iot.DTO.ListsDTO;
import com.example.lab4_iot.DTO.Posiciones;
import com.example.lab4_iot.R;
import com.example.lab4_iot.SportsApi;
import com.example.lab4_iot.databinding.FragmentPosicionesBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Se utilizo AI para conccer como estructurar el comportamiento con el if manejando todas las opciones.
public class PosicionesFragment extends Fragment {

    private FragmentPosicionesBinding binding;
    private PosicionesAdapters adapter;
    private List<Posiciones> posicionesList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPosicionesBinding.inflate(inflater, container, false);

        RecyclerView recyclerView = binding.recyclerViewPosiciones;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PosicionesAdapters(posicionesList, getContext());
        recyclerView.setAdapter(adapter);


        binding.buscarButton.setOnClickListener(v -> {
            String idLiga = binding.buscarIdLiga.getText().toString().trim();
            String temporada = binding.season.getText().toString().trim();

            if (TextUtils.isEmpty(idLiga) || TextUtils.isEmpty(temporada)) {
                Toast.makeText(getContext(), "Por favor, ingrese ambos campos", Toast.LENGTH_SHORT).show();
            } else {
                obtenerPosiciones(idLiga, temporada);
            }
        });

        return binding.getRoot();
    }

    private void obtenerPosiciones(String idLiga, String temporada) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsApi sportsApi = retrofit.create(SportsApi.class);
        Call<ListsDTO> call = sportsApi.getPosiciones(idLiga, temporada);
        call.enqueue(new Callback<ListsDTO>() {
            @Override
            public void onResponse(Call<ListsDTO> call, Response<ListsDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    posicionesList.clear();
                    posicionesList.addAll(response.body().getPosiciones());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ListsDTO> call, Throwable t) {
                Toast.makeText(getContext(), "Error al obtener posiciones", Toast.LENGTH_SHORT).show();
            }
        });
    }
}