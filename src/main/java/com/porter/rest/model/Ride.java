package com.porter.rest.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ride  implements Parcelable {
  private Location dropLocation;

  public Ride() {
    dropLocation = new Location();
  }

  public Location getDropLocation() {
    return dropLocation;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(dropLocation, flags);

  }

  public static final Parcelable.Creator<Ride> CREATOR
      = new Parcelable.Creator<Ride>() {
    public Ride createFromParcel(Parcel in) {
      return new Ride(in);
    }

    public Ride[] newArray(int size) {
      return new Ride[size];
    }
  };

  private Ride(Parcel in) {
    dropLocation = in.readParcelable(Location.class.getClassLoader());
  }
}
