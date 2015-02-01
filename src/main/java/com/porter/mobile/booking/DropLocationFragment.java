package com.porter.mobile.booking;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.porter.mobile.BaseFragment;
import com.porter.rest.model.Ride;
import com.porter.utils.CustomProgress;

import org.porter.R;

public class DropLocationFragment extends BaseFragment {
  public static final String RIDE = "ride";
  private Ride ride;

  public DropLocationFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      ride = getArguments().getParcelable(RIDE);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_drop_location, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    CustomProgress.removeProgressDialog();
  }
}
