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

import com.example.lab4_iot.Adapters.LigasAdapters;
import com.example.lab4_iot.DTO.Ligas;
import com.example.lab4_iot.DTO.ListsDTO;
import com.example.lab4_iot.SportsApi;
import com.example.lab4_iot.databinding.FragmentLigasBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class LigasFragment extends Fragment {

    private FragmentLigasBinding binding;
    private LigasAdapters adapter;
    private List<Ligas> ligasList = new ArrayList<>(); // Lista original de ligas
    private TextInputEditText buscarPais;

    // Lista de países válidos
    List<String> paisesValidos = Arrays.asList("Spain", "England", "France", "Brazil", "Germany");

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLigasBinding.inflate(inflater, container, false);


        RecyclerView recyclerView = binding.recyclerViewLigas;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        buscarPais = binding.buscarPais;

        adapter = new LigasAdapters(ligasList, getContext());
        recyclerView.setAdapter(adapter);

        obtenerTodasLasLigas();

        binding.buscarButton.setOnClickListener(v -> {
            String pais = buscarPais.getText().toString().trim();
            if (TextUtils.isEmpty(pais)) {
                obtenerTodasLasLigas();
            } else if (paisesValidos.contains(pais)) {
                obtenerLigasPorPais(pais);
            } else {
                Toast.makeText(getContext(), "País no válido. Intente con: " + paisesValidos, Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

    // Método para obtener todas las ligas de la API
    private void obtenerTodasLasLigas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsApi sportsApi = retrofit.create(SportsApi.class);

        Call<ListsDTO> call = sportsApi.getAllLeagues();
        call.enqueue(new Callback<ListsDTO>() {
            @Override
            public void onResponse(Call<ListsDTO> call, Response<ListsDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ligasList.clear();
                    ligasList.addAll(response.body().getLigas());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ListsDTO> call, Throwable t) {
                Toast.makeText(getContext(), "Error al obtener las ligas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void obtenerLigasPorPais(String pais) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SportsApi sportsApi = retrofit.create(SportsApi.class);

        Call<ListsDTO> call = sportsApi.getLeaguesByCountry(pais);
        call.enqueue(new Callback<ListsDTO>() {
            @Override
            public void onResponse(Call<ListsDTO> call, Response<ListsDTO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ligasList.clear();
                    ligasList.addAll(response.body().getLigas());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(), "No se encontraron ligas para " + pais, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListsDTO> call, Throwable t) {
                Toast.makeText(getContext(), "Error al obtener las ligas por país", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
