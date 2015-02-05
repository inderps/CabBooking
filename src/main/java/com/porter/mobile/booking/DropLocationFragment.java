package com.porter.mobile.booking;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import com.porter.mobile.BaseFragment;
import com.porter.rest.model.AutosuggestedPlace;
import com.porter.rest.model.Ride;
import com.porter.utils.CustomProgress;
import com.porter.utils.PorterTextView;

import org.porter.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DropLocationFragment extends BaseFragment implements AdapterView.OnItemClickListener {
  public static final String RIDE = "ride";
  private Ride ride;
  private AutoCompleteTextView addressView;
  private AutosuggestedPlace place;
  private Button addLocation;

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
    addressView = (AutoCompleteTextView) view.findViewById(R.id.drop_location_finder);
    addLocation = (Button) view.findViewById(R.id.addLocation);
    bindAutoComplete();
    bindAddLocation(view);
    bindTimeChangeButton(view);
    bindDateChangeButton(view);
  }

  private void bindDateChangeButton(final View rootView) {
    Button dateChangeButton = (Button)rootView.findViewById(R.id.date_change_button);

    dateChangeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(getActivity(),
            new DatePickerDialog.OnDateSetListener() {

              @Override
              public void onDateSet(DatePicker view, int year,
                                    int monthOfYear, int dayOfMonth) {
                Date date = new Date(year, monthOfYear, dayOfMonth);
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getActivity().getApplicationContext());
                PorterTextView dateLabel = (PorterTextView)rootView.findViewById(R.id.date_label);
                dateLabel.setText(dateFormat.format(date));
              }
            }, mYear, mMonth, mDay);
        dpd.show();
      }
    });
  }

  private void bindTimeChangeButton(View rootView) {
    Button timeChangeButton = (Button)rootView.findViewById(R.id.time_change_button);

    timeChangeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
            new TimePickerDialog.OnTimeSetListener() {
              @Override
              public void onTimeSet(TimePicker view, int hourOfDay,
                                    int minute) {
//            Date date = new Date(year, monthOfYear, dayOfMonth);
//            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getActivity().getApplicationContext());
//            PorterTextView dateLabel = (PorterTextView)rootView.findViewById(R.id.date_label);
//            dateLabel.setText(dateFormat.format(date));
              }
            }, mHour, mMinute, false);
        tpd.show();
      }
    });
  }

  private void bindAddLocation(final View view) {
    addLocation.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(place!=null){
          LinearLayout dropLocations = (LinearLayout)view.findViewById(R.id.drop_locations);
          DropLocationLayout locationLayout = new DropLocationLayout(getActivity());
          locationLayout.setPlace(place);

          ImageView removeButton = (ImageView)locationLayout.findViewById(R.id.remove_button);
          removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DropLocationLayout layout = (DropLocationLayout)v.getParent().getParent().getParent();
              removeDropLocation(view, layout);
            }
          });

          dropLocations.addView(locationLayout);
          place = null;
          addressView.setText("");
        }
      }
    });
  }

  private void removeDropLocation(View rootView, DropLocationLayout layout){
    LinearLayout dropLocations = (LinearLayout)rootView.findViewById(R.id.drop_locations);
    dropLocations.removeView(layout);
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
    place = ((PlacesAutoCompleteAdapter) adapterView.getAdapter()).getPlace(position);
  }
}
