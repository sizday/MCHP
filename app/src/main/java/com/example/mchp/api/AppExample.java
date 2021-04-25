package com.example.mchp.api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mchp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppExample extends AppCompatActivity {

    List<PostModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_example);
        posts = new ArrayList<>();
        TextView textPost = findViewById(R.id.textPost);
        TextView sitePost = findViewById(R.id.sitePost);
        App.getApi().getData("bash.im", "bash", 20).enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<PostModel>> call, @NotNull Response<List<PostModel>> response) {
                posts.addAll(response.body());
                String htmlText = posts.get(1).getElementPureHtml();
                textPost.setText(Html.fromHtml(htmlText));
                sitePost.setText(posts.get(1).getSite());
            }

            @Override
            public void onFailure(@NotNull Call<List<PostModel>> call, @NotNull Throwable t) {
                Toast.makeText(getApplication(), "Запрос не удался", Toast.LENGTH_SHORT).show();
            }
        });
    }
}