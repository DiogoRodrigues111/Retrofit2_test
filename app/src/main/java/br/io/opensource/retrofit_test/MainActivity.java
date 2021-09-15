package br.io.opensource.retrofit_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RepositoryWeb service = retrofit.create(RepositoryWeb.class);

        Call<List<API_GitHub>> repos = service.listRepositoryWeb("events");
        repos.enqueue(new Callback<List<API_GitHub>>() {
            @Override
            public void onResponse(Call<List<API_GitHub>> call, Response<List<API_GitHub>> response) {
                if(call.isExecuted())
                    Log.d("GitHub - Events: \n", getMessage(response.body()));
            }

            @Override
            public void onFailure(Call<List<API_GitHub>> call, Throwable t) {
                Log.d("GitHub - Events / 1: ", t.getLocalizedMessage());
            }
        });
    }

    private String getMessage(List<API_GitHub> api) {
        Log.i("TAG", String.valueOf(api));
        return api.toString();
    }
}