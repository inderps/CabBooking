package com.porter.mobile.my_rides;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.porter.mobile.BaseFragment;
import com.porter.rest.model.Ride;

import org.porter.R;

import java.util.ArrayList;
import java.util.List;

public class MyRidesTabFragment extends BaseFragment {
  private static final String ARG_MYRIDES_TYPE = "my_rides_type";
  private String type;
  private ListView listView;
  private List<Ride> rides;
  private MyRidesListAdapter adapter;

  public static MyRidesTabFragment newInstance(String type) {
    MyRidesTabFragment fragment = new MyRidesTabFragment();
    Bundle args = new Bundle();
    args.putString(ARG_MYRIDES_TYPE, type);
    fragment.setArguments(args);
    return fragment;
  }

  public MyRidesTabFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      type = getArguments().getString(ARG_MYRIDES_TYPE);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_my_rides_tab, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listView = (ListView) view.findViewById(R.id.list);
    rides = new ArrayList<>();
    rides.add(new Ride());
    rides.add(new Ride());
    rides.add(new Ride());
    adapter = new MyRidesListAdapter(this.getActivity(), rides);
    listView.setAdapter(adapter);
  }
}
