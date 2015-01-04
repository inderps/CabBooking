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
    //    RestClient restClient = new RestClient();
//    Callback callback = new Callback() {
//      @Override
//      public void success(Object o, Response response) {
//        Log.d("IPS", o.toString());
//      }
//
//      @Override
//      public void failure(RetrofitError retrofitError) {
//
//      }
//    };
//
//    restClient.getPorterApiService().getData("35", "139", callback);
//    new User("a", "s").save();
//
//    User user = User.getLoggedInUser();
//    Log.d("IPS", user.getName());
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_new_ride, container, false);
  }
}
