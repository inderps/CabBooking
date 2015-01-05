package com.porter.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.widget.TextView;

import java.util.Hashtable;

public class PorterFont {
  private static final String myriadFont = "fonts/myriad-web-pro.ttf";
  private static final Hashtable<String, Typeface> typefaceMap = new Hashtable<String, Typeface>();

  public static void setBoldTypeface(TextView textView) {
    setCustomFont(textView, myriadFont);
  }

  private static void setCustomFont(TextView item, String fontName) {
    Typeface typeface = get(item.getContext().getAssets(), fontName);
    if(typeface != null) item.setTypeface(typeface);
  }

  private static Typeface get(AssetManager assetManager, String path){
    synchronized(typefaceMap){
      if(!typefaceMap.containsKey(path)){
        try {
          Typeface t = Typeface.createFromAsset(assetManager, path);
          typefaceMap.put(path, t);
        } catch (Exception e) {
          return null;
        }
      }
      return typefaceMap.get(path);
    }
  }
}
