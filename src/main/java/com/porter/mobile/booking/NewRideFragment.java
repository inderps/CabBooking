package com.porter.mobile.booking;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.porter.mobile.BaseFragment;
import com.porter.rest.model.AutosuggestedPlace;
import com.porter.rest.model.Ride;
import com.porter.rest.service.GooglePlacesService;
import com.porter.utils.CustomProgress;

import org.porter.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class NewRideFragment extends BaseFragment implements LocationListener,
    GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    AdapterView.OnItemClickListener {

  // A request to connect to Location Services
  private GoogleApiClient mGoogleApiClient;
  private LocationRequest mLocationRequest;
  GoogleMap mGoogleMap;
  private LatLng center;
  private Geocoder geocoder;
  private AutoCompleteTextView addressView;
  private List<android.location.Address> addresses;
  private boolean manuallyChosenPlace;
  private static View view;
  private Ride ride;


  public static NewRideFragment newInstance() {
    NewRideFragment fragment = new NewRideFragment();
    return fragment;
  }

  public NewRideFragment() {}

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    if (view != null) {
      ViewGroup parent = (ViewGroup) view.getParent();
      if (parent != null)
        parent.removeView(view);
    }
    try {
      view = inflater.inflate(R.layout.fragment_new_ride, container, false);
    } catch (InflateException e) {
        /* map is already there, just return view as it is */
    }
    return view;
  }
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ride = new Ride();

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
  public void onViewCreated(View view, Bundle savedInstanceState) {
     super.onViewCreated(view, savedInstanceState);
    initializeMap();
    addressView = (AutoCompleteTextView) view.findViewById(R.id.address);
    bindAutoComplete();
    bindCurrentLocationIcon(view);
    bindBookNowButton(view);

    if(mGoogleApiClient == null){
      mGoogleApiClient = new GoogleApiClient.Builder(getActivity()).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
      mGoogleApiClient.connect();
    }


//    int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity().getApplicationContext());
//
//    if (status != ConnectionResult.SUCCESS) {
//      int requestCode = 10;
//      Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, getActivity(), requestCode);
//      dialog.show();
//    } else { // Google Play Services are available
//
//      // Getting reference to the SupportMapFragment
//      // Create a new global location parameters object
//      mLocationRequest = LocationRequest.create();
//
//            /*
//             * Set the update interval
//             */
//      mLocationRequest.setInterval(PorterConstants.UPDATE_INTERVAL_IN_MILLISECONDS);
//
//      // Use high accuracy
//      mLocationRequest
//          .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//
//      // Set the interval ceiling to one minute
//      mLocationRequest
//          .setFastestInterval(PorterConstants.FAST_INTERVAL_CEILING_IN_MILLISECONDS);
//
//      // Note that location updates are off until the user turns them on
//      mUpdatesRequested = false;
//
//    }
  }

  private void bindBookNowButton(View view) {
    Button bookNow = (Button) view.findViewById(R.id.book_now);
    bookNow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DropLocationFragment fragment = new DropLocationFragment();
        Bundle args = new Bundle();
        args.putParcelable(DropLocationFragment.RIDE, ride);
        fragment.setArguments(args);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
      }
    });
  }

  private void bindAutoComplete() {
    setAutoSuggestAdapter();
    addressView.setOnItemClickListener(this);
    addressView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        addressView.setText("");
      }
    });
  }

  private void unsetAutoSuggestAdapter() {
    ArrayAdapter<String> adapter = null;
    addressView.setAdapter(adapter);
  }

  private void setAutoSuggestAdapter() {
    addressView.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.autocomplete_item));
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
    manuallyChosenPlace = true;
    AutosuggestedPlace place = ((PlacesAutoCompleteAdapter) adapterView.getAdapter()).getPlace(position);
    new GoToSelectedPlaceTask(place).execute();
  }



  private void hideKeyboard() {
    addressView.clearFocus();
    InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(
        Context.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(addressView.getWindowToken(), 0);
  }

  private void moveToThisLocation(LatLng latLng){
    CameraPosition cameraPosition = new CameraPosition.Builder()
        .target(latLng).zoom(16f).build();
    mGoogleMap.setMyLocationEnabled(true);
    mGoogleMap.animateCamera(CameraUpdateFactory
        .newCameraPosition(cameraPosition));
    mGoogleMap.clear();
  }

  @Override
  public void onConnected(Bundle bundle) {
    enableLocation();
    setCurrentLocation();
    bindMarker();
    CustomProgress.removeProgressDialog();
  }

  private void bindMarker() {
    mGoogleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

      @Override
      public void onCameraChange(CameraPosition arg0) {
        hideKeyboard();
        if(manuallyChosenPlace){
          manuallyChosenPlace = false;
          return;
        }

        center = mGoogleMap.getCameraPosition().target;
        mGoogleMap.clear();

        try {
          new GetLocationAsync(center.latitude, center.longitude)
              .execute();

        } catch (Exception e) {
        }
      }
    });
  }

  private void initializeMap() {
    mGoogleMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(
        R.id.map)).getMap();
  }

  private void enableLocation(){
    mGoogleMap.setMyLocationEnabled(true);
  }

  @Override
  public void onConnectionSuspended(int i) {

  }

  @Override
  public void onLocationChanged(Location location) {

  }

  @Override
  public void onConnectionFailed(ConnectionResult connectionResult) {

  }

  private void setCurrentLocation() {
    Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    if (location != null) {
      LatLng latLong = new LatLng(location
          .getLatitude(), location
          .getLongitude());
      moveToThisLocation(latLong);
    }
  }

  private void bindCurrentLocationIcon(View view) {
    ImageView currentLocationIcon = (ImageView)view.findViewById(R.id.current_location_icon);
    currentLocationIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        setCurrentLocation();
      }
    });
  }

  private class GetLocationAsync extends AsyncTask<String, Void, String> {

    double latitude, longitude;
    StringBuilder locationAddress;

    public GetLocationAsync(double latitude, double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
    }

    @Override
    protected void onPreExecute() {
      addressView.setText(" Getting location ");
    }

    @Override
    protected String doInBackground(String... params) {

      try {
        geocoder = new Geocoder(getActivity().getApplicationContext(), Locale.ENGLISH);
        addresses = geocoder.getFromLocation(latitude, longitude, 1);
        locationAddress = new StringBuilder();
        if (geocoder.isPresent()) {
          if(addresses.size() == 0){
            return null;
          }
          Address returnAddress = addresses.get(0);

          locationAddress.append(returnAddress.getAddressLine(0) + ", ");
          locationAddress.append(returnAddress.getLocality() + ", ");
          locationAddress.append(returnAddress.getCountryName());
        } else {
        }
      } catch (IOException e) {
        Log.e("tag", e.getMessage());
      }
      return null;

    }

    @Override
    protected void onPostExecute(String result) {
      try {
        unsetAutoSuggestAdapter();
        addressView.setText(locationAddress);
        setAutoSuggestAdapter();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }
  }

  private class GoToSelectedPlaceTask extends AsyncTask<String, Void, LatLng> {
    private AutosuggestedPlace place;

    public GoToSelectedPlaceTask(AutosuggestedPlace place) {
      this.place = place;
    }

    @Override
    protected LatLng doInBackground(String... urls) {
      LatLng latLng= GooglePlacesService.getLatLng(place);
      return latLng;
    }

    @Override
    protected void onPostExecute(LatLng latLng) {
      moveToThisLocation(latLng);
      try {
        new GetLocationAsync(center.latitude, center.longitude)
            .execute();

      } catch (Exception e) {
      }
    }
  }
}
