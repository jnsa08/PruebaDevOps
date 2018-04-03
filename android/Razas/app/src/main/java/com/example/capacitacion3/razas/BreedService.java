package com.example.capacitacion3.razas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by capacitacion3 on 16-03-18.
 */

public interface BreedService {


    @GET("api/breeds/list")
    Call<BreedResponse> listBreeds();


    @GET("api/breed/{breedName}/images")
    Call<BreedResponse> listImages(@Path("breedName") String breedName);
}