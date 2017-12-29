package com.example.greshkumartharwani.postwithget;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Gresh Kumar Tharwani on 12/29/2017.
 */

public interface apiservice {
    @POST("posts")
    Call<model> gresh(@Body model m);

}
