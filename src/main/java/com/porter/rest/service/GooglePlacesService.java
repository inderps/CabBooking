package com.porter.rest.service;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.porter.rest.model.AutosuggestedPlace;
import com.porter.utils.GoogleApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class GooglePlacesService {
  private static final String LOG_TAG = "Google Places Service Logs: ";

  private static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
  private static final String TYPE_AUTOCOMPLETE = "/autocomplete";
  private static final String TYPE_DETAILS= "/details";
  private static final String OUT_JSON = "/json";

  private static final String API_KEY = GoogleApi.SERVER_KEY;

  public static ArrayList<AutosuggestedPlace> autocomplete(String input) {
    ArrayList<AutosuggestedPlace> resultList = null;

    StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_AUTOCOMPLETE + OUT_JSON);
    sb.append("?key=" + API_KEY);
    sb.append("&components=country:in");
    try {
      sb.append("&input=" + URLEncoder.encode(input, "utf8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    StringBuilder jsonResults = makeRequest(sb);

    try {
      // Create a JSON object hierarchy from the results
      JSONObject jsonObj = new JSONObject(jsonResults.toString());
      JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

      // Extract the Place descriptions from the results
      resultList = new ArrayList<AutosuggestedPlace>(predsJsonArray.length());
      for (int i = 0; i < predsJsonArray.length(); i++) {

        resultList.add(new AutosuggestedPlace(predsJsonArray.getJSONObject(i).getString("place_id"),
                        predsJsonArray.getJSONObject(i).getString("description")));
      }
    } catch (JSONException e) {
      Log.e(LOG_TAG, "Cannot process JSON results", e);
    }
    return resultList;
  }

  public static LatLng getLatLng(AutosuggestedPlace place) {
    StringBuilder sb = new StringBuilder(PLACES_API_BASE + TYPE_DETAILS + OUT_JSON);
    sb.append("?key=" + API_KEY);
    sb.append("&placeid=" + place.getId());
    StringBuilder jsonResults = makeRequest(sb);

    try {
      JSONObject jsonObj = new JSONObject(jsonResults.toString());

      JSONObject location = jsonObj.getJSONObject("result").getJSONObject("geometry").getJSONObject("location");
      return new LatLng(location.getDouble("lat"), location.getDouble("lng"));
    } catch (JSONException e) {
      Log.e(LOG_TAG, "Cannot process JSON results", e);
    }
    return null;
  }

  private static StringBuilder makeRequest(StringBuilder urlWithParams){
    HttpURLConnection conn = null;
    StringBuilder jsonResults = new StringBuilder();
    try {
      URL url = new URL(urlWithParams.toString());
      conn = (HttpURLConnection) url.openConnection();
      InputStreamReader in = new InputStreamReader(conn.getInputStream());

      // Load the results into a StringBuilder
      int read;
      char[] buff = new char[1024];
      while ((read = in.read(buff)) != -1) {
        jsonResults.append(buff, 0, read);
      }
    } catch (MalformedURLException e) {
      Log.e(LOG_TAG, "Error processing Places API URL", e);
      return null;
    } catch (IOException e) {
      Log.e(LOG_TAG, "Error connecting to Places API", e);
      return null;
    } finally {
      if (conn != null) {
        conn.disconnect();
      }
    }
    return jsonResults;
  }

}
