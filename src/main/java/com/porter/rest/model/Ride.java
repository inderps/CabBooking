package com.porter.rest.model;

public class Ride {
  private Location dropLocation;

  public Ride() {
    dropLocation = new Location();
  }

  public Location getDropLocation() {
    return dropLocation;
  }
}
