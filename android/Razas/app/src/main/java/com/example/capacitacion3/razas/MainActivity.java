    package com.example.capacitacion3.razas;

    import android.content.Intent;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.view.View;
    import android.widget.AdapterView;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;

    public class MainActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{


        private BreedService service;

        // RecyclerView: Lista de elementos en la vista
        private RecyclerView recyclerViewBreeds;

        // Adaptador de elementos
        private RecyclerView.Adapter adapterBreeds;

        // Manager de la lista, nos permite personalizar la vista y el comportamiento
        // de nuestro RecycerView: división, orientación, etc.
        private RecyclerView.LayoutManager layoutManagerBreeds;

        private String[] breeds;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Referenciamos el recyclerView de nuestra vista
            recyclerViewBreeds = findViewById(R.id.recyclerViewBreeds);

            // Debe ser true si el tamaño de nuestras celdas no serán variables, esto
            // nos ayudará con el rendimiento de la lista
            recyclerViewBreeds.setHasFixedSize(true);

            // Creamos nuestro Layout Manager en base a un LinearLayout. Puede ser
            // RelativeLayout, GridLayout, etc.
            layoutManagerBreeds = new LinearLayoutManager(this);

            // Asignamos nuestro layout manager al recyclerView
            recyclerViewBreeds.setLayoutManager(layoutManagerBreeds);


            initRetroif();
            listBreeds();





        }

        public void initRetroif(){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://dog.ceo/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            service = retrofit.create(BreedService.class);

        }


        public void listBreeds(){
        service.listBreeds().enqueue(new Callback<BreedResponse>() {
        @Override
        public void onResponse(Call<BreedResponse> call, Response<BreedResponse> response) {
            BreedResponse breedResponse = response.body();

            if(breedResponse.getMessage().length == 0 ) return;


            breeds = breedResponse.getMessage();

            // Creamos nuestro adaptador
            adapterBreeds = new BreedAdapter(MainActivity.this , breeds);

            // Asignamos el adaptador al RecyclerView
            recyclerViewBreeds.setAdapter(adapterBreeds);

        }

        @Override
        public void onFailure(Call<BreedResponse> call, Throwable t) {

        }
    });
        }



        @Override public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent= new Intent(this, NextActivity.class);

            intent.putExtra("name", breeds[position]);
            startActivity(intent);

        }

    }
