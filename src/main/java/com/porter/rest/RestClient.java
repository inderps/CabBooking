package com.porter.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.porter.rest.service.PorterApiService;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class RestClient {
  private PorterApiService porterApiService;

  public RestClient()
  {
    initializePorterApiService();
  }

  private void initializePorterApiService(){
    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
        .create();

    RestAdapter restAdapter = new RestAdapter.Builder()
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .setEndpoint(PorterApiService.URL)
        .setConverter(new GsonConverter(gson))
        .build();

    porterApiService = restAdapter.create(PorterApiService.class);
  }

  public PorterApiService getPorterApiService()
  {
    return porterApiService;
  }
}
