package com.porter.mobile.booking;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.porter.R;

public class NewRideFragment extends Fragment {

  public static NewRideFragment newInstance() {
    NewRideFragment fragment = new NewRideFragment();
    return fragment;
  }

  public NewRideFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_new_ride, container, false);
  }
}
