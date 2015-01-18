package com.porter.mobile.my_rides;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.porter.rest.model.Ride;
import com.porter.utils.PorterTextView;

import org.porter.R;

import java.util.List;

public class MyRidesListAdapter extends BaseAdapter {
  private Context context;
  private LayoutInflater inflater;
  private List<Ride> rides;

  public MyRidesListAdapter(Context context, List<Ride> rides) {
    this.context = context;
    this.rides = rides;
  }

  @Override
  public int getCount() {
    return rides.size();
  }

  @Override
  public Object getItem(int position) {
    return rides.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (inflater == null)
      inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null)
      convertView = inflater.inflate(R.layout.my_rides_row, null);

    PorterTextView location = (PorterTextView) convertView.findViewById(R.id.ride_date);
    PorterTextView date = (PorterTextView) convertView.findViewById(R.id.ride_location);
    return convertView;
  }
}
