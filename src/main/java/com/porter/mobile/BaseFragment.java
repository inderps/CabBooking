package com.porter.mobile;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.porter.utils.CustomProgress;

public abstract class BaseFragment extends Fragment {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    CustomProgress.showProgressDialog(getActivity(), false);
  }
}