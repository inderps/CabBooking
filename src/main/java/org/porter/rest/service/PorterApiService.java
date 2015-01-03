package org.porter.rest.service;

import org.porter.rest.model.Weather;

import java.sql.Wrapper;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface PorterApiService {
  public static String URL = "http://api.openweathermap.org/data/2.5";

  @GET("/weather")
  public void getData(@Query("lat") String lat, @Query("lon") String lon, Callback<Weather> cb);
}
