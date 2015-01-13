package com.porter.mobile.ratecard;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.porter.mobile.BaseFragment;

import org.porter.R;

public class RateCardFragment extends BaseFragment {

  public static RateCardFragment newInstance() {
    RateCardFragment fragment = new RateCardFragment();
    return fragment;
  }

  public RateCardFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_rate_card, container, false);
  }
}
