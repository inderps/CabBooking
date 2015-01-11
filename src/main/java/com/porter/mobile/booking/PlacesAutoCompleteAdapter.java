package com.porter.mobile.booking;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.porter.rest.model.AutosuggestedPlace;
import com.porter.rest.service.GooglePlacesService;

import java.util.ArrayList;

public class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
  private ArrayList<AutosuggestedPlace> resultList;

  public PlacesAutoCompleteAdapter(Context context, int textViewResourceId) {
    super(context, textViewResourceId);
  }

  @Override
  public int getCount() {
    return resultList.size();
  }

  @Override
  public String getItem(int index) {
    return resultList.get(index).getPlaceName();
  }

  public AutosuggestedPlace getPlace(int index){
    return resultList.get(index);
  }

  @Override
  public Filter getFilter() {
    Filter filter = new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if (constraint != null) {
          // Retrieve the autocomplete results.
          resultList = GooglePlacesService.autocomplete(constraint.toString());

          // Assign the data to the FilterResults
          filterResults.values = resultList;
          filterResults.count = resultList.size();
        }
        return filterResults;
      }

      @Override
      protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results != null && results.count > 0) {
          notifyDataSetChanged();
        }
        else {
          notifyDataSetInvalidated();
        }
      }};
    return filter;
  }
}
