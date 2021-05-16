package com.example.mchp.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UmoriliApi {

    @GET("/api/get")
    Call<List<PostModel>> getData(@Query("site") String siteName, @Query("name") String resourceName, @Query("num") int count);

}
