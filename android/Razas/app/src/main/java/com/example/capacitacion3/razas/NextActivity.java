package com.example.capacitacion3.razas;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NextActivity extends AppCompatActivity {

    private BreedService service;
    private String[] urlsBreed;


//    private RecyclerView recyclerViewImages;
//    private RecyclerView.Adapter adapterImages;
//    private RecyclerView.LayoutManager layoutManagerImages;




    private String[] photoArray;
    private Button buttonSearch;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_images_breed);

        buttonSearch = findViewById(R.id.buttonSearch);
        progressBar = findViewById(R.id.progressBar);

        initRetroif();
        searchPhoto(getIntent().getStringExtra("name"));

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                searchPhoto(getIntent().getStringExtra("name"));

            }
        });

        setTitle(getIntent().getStringExtra("name"));





/*
        recyclerViewImages = findViewById(R.id.recyclerViewImagesBreed);
        recyclerViewImages.setHasFixedSize(true);
        layoutManagerImages = new LinearLayoutManager(this);
        recyclerViewImages.setLayoutManager(layoutManagerImages);

        initRetroif();
        listUrlImages(getIntent().getStringExtra("name"));
*/

    }

    public void initRetroif(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BreedService.class);

    }


    public void searchPhoto(String term) {


        service.listImages(term).enqueue(new Callback<BreedResponse>() {

            @Override
            public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {

                BreedResponse breedResponse = response.body();

                photoArray = breedResponse.getMessage();

                int indexRandom = getRandomIndex(0, photoArray.length - 1);

                ImageView imageViewDogg = findViewById(R.id.imageViewDogg);
                Picasso.get().load(photoArray[indexRandom]).into(imageViewDogg, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }

            @Override
            public void onFailure(Call<BreedResponse> call, Throwable t) {

            }
        });
    }

    public int getRandomIndex(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }








}
