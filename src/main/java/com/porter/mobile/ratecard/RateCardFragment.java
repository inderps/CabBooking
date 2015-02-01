package com.porter.mobile.ratecard;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.porter.mobile.BaseFragment;
import com.porter.utils.CustomProgress;
import com.porter.utils.PorterTextView;

import org.porter.R;

public class RateCardFragment extends BaseFragment {
  String[] vehicleTypeValues = { "TATA ACE", "TATA 909"};
  String[] engagementTypeValues = { "DISTANCE BASED"};
  private RateCardItemLayout baseFareLayout;
  private RateCardItemLayout chargepPerKmLayout;
  private RateCardItemLayout extraTimeChargeLayout;
  private RateCardItemLayout extraPointLayout;
  private RateCardItemLayout nightHoldingChargesLayout;

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

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    bindVehicleTypeSpinner(view);
    bindEngagementTypeSpinner(view);

    baseFareLayout = (RateCardItemLayout) view.findViewById(R.id.base_fare);
    baseFareLayout.setText("Base Fare", 200, null);

    chargepPerKmLayout = (RateCardItemLayout) view.findViewById(R.id.charge_per_km);
    chargepPerKmLayout.setText("Charge per km", 30, null);

    extraTimeChargeLayout = (RateCardItemLayout) view.findViewById(R.id.extra_time);
    extraTimeChargeLayout.setText("Extra Time Charge", 75, "(per 30 minutes)");

    extraPointLayout = (RateCardItemLayout) view.findViewById(R.id.extra_point);
    extraPointLayout.setText("Extra Point", 50, null);

    nightHoldingChargesLayout = (RateCardItemLayout) view.findViewById(R.id.night_charges);
    nightHoldingChargesLayout.setText("Night Holding Charges", 800, null);
    CustomProgress.removeProgressDialog();

  }

  private void bindEngagementTypeSpinner(View view) {
    Spinner engagementTypeSpinner = (Spinner) view.findViewById(R.id.engagement_type);
    engagementTypeSpinner.setAdapter(new SpinnerAdapter(this.getActivity(), R.layout.custom_spinner, engagementTypeValues, SpinnerType.ENGAGEMENT_TYPE));
    engagementTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }

  private void bindVehicleTypeSpinner(View view) {
    Spinner vehicleTypeSpinner = (Spinner) view.findViewById(R.id.vehicle_type);
    vehicleTypeSpinner.setAdapter(new SpinnerAdapter(this.getActivity(), R.layout.custom_spinner, vehicleTypeValues, SpinnerType.VEHICLE_TYPE));
  }

  public class SpinnerAdapter extends ArrayAdapter<String> {
    private LayoutInflater inflater;
    private Context context;
    private String[] values;
    private String spinnerType;

    public SpinnerAdapter(Context context, int viewResourceId, String[] objects, String spinnerType) {
      super(context, viewResourceId, objects);
      this.context = context;
      this.values = objects;
      this.spinnerType = spinnerType;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
      if (inflater == null)
        inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      if (convertView == null)
        convertView = inflater.inflate(R.layout.custom_spinner_dropdown, parent, false);

      PorterTextView title = (PorterTextView) convertView.findViewById(R.id.title);
      title.setText(values[position]);

      return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      if (inflater == null)
        inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

      if (convertView == null)
        convertView = inflater.inflate(R.layout.custom_spinner, parent, false);

      PorterTextView title = (PorterTextView) convertView.findViewById(R.id.title);
      title.setText(values[position]);

      PorterTextView subtitle = (PorterTextView) convertView.findViewById(R.id.subtitle);
      subtitle.setText(SpinnerType.text(spinnerType));

      ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
      icon.setImageResource(SpinnerType.icon(spinnerType));

      return convertView;
    }
  }

  private static class SpinnerType {
    public static String VEHICLE_TYPE = "vehicle_type";
    public static String ENGAGEMENT_TYPE = "engagement_type";

    public static String text(String type){
      if(type.equals(VEHICLE_TYPE))
        return "Vehicle Type";
      else
        return "Engagement Type";
    }

    public static int icon(String type){
      if(type.equals(VEHICLE_TYPE))
        return R.drawable.vehicel_type;
      else
        return R.drawable.engagement;
    }
  }
}
