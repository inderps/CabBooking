package com.porter.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
  private double latitude;
  private double longitude;

  public Location() {}

  public double getLatitude() {
    return latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeDouble(latitude);
    dest.writeDouble(longitude);
  }

  public static final Parcelable.Creator<Location> CREATOR
      = new Parcelable.Creator<Location>() {
    public Location createFromParcel(Parcel in) {
      return new Location(in);
    }

    public Location[] newArray(int size) {
      return new Location[size];
    }
  };

  private Location(Parcel in) {
    latitude = in.readDouble();
    longitude = in.readDouble();
  }
}
