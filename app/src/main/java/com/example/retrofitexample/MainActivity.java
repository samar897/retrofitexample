package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
  private TextView textViewResult;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textViewResult = findViewById(R.id.text_view_result);

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl("http://127.0.0.1:3000/api/logins/")
      .addConverterFactory(GsonConverterFactory.create())
      .build();

    JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

    Call<List<post>> call = jsonPlaceHolderApi.getPosts();

    call.enqueue(new Callback<List<post>>() {
      @Override
      public void onResponse(Call<List<post>> call, Response<List<post>> response) {

        if (!response.isSuccessful()) {
          textViewResult.setText("Code: " + response.code());
          return;
        }

        List<post> logins = response.body();

        for (post post :logins) {
          String content = "";
          content += "FName: " + post.getFName() + "\n";
          content += "LName ID: " + post.getLName() + "\n";
          content += "Email: " + post.getEmail() + "\n";
          content += "Password: " + post.getPassword() + "\n\n";

          textViewResult.append(content);
        }
      }

      @Override
      public void onFailure(Call<List<post>> call, Throwable t) {
        textViewResult.setText(t.getMessage());
      }
    });
  }
}
