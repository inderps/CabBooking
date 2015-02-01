package com.porter.mobile.ratecard;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.porter.utils.PorterTextView;

import org.porter.R;

public class RateCardItemLayout extends LinearLayout {

  public RateCardItemLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
    ((Activity)getContext()).getLayoutInflater().inflate(R.layout.rate_card_item_layout, this, true);
  }

  public void setText(String title, int fare, String subtitle) {
    PorterTextView titleTextView = (PorterTextView) findViewById(R.id.title);
    titleTextView.setText(title);

    PorterTextView fareTextView = (PorterTextView) findViewById(R.id.price);
    fareTextView.setText(String.valueOf(fare));

    PorterTextView subtitleTextView = (PorterTextView) findViewById(R.id.subtitle);
    if(subtitle != null){
      subtitleTextView.setText(subtitle);
      subtitleTextView.setVisibility(VISIBLE);
    }
  }
}
