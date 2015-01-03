package com.porter.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {
  public Coord coord;
  @SerializedName("weather")
  public List<WeatWeather> weatWeathers;
}
