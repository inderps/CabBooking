package com.porter.rest.model;

public class AutosuggestedPlace {
  private String id;
  private String placeName;

  public AutosuggestedPlace(String id, String placeName){
    this.id = id;
    this.placeName = placeName;
  }

  public String getId() {
    return id;
  }

  public String getPlaceName() {
    return placeName;
  }
}
