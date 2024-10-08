package com.example.lab4_iot;
import com.example.lab4_iot.DTO.ListsDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportsApi {
    @GET("all_leagues.php")
    Call<ListsDTO> getAllLeagues();

    @GET("search_all_leagues.php")
    Call<ListsDTO> getLeaguesByCountry(@Query("c") String country);
}
