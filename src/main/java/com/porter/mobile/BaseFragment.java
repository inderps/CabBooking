package com.porter.mobile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.porter.R;

public abstract class BaseFragment extends Fragment {
  private static View view;
  protected abstract int viewId();


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if (view != null) {
      ViewGroup parent = (ViewGroup) view.getParent();
      if (parent != null)
        parent.removeView(view);
    }
    try {
      view = inflater.inflate(viewId(), container, false);
    } catch (InflateException e) {}
    return view;
  }
}