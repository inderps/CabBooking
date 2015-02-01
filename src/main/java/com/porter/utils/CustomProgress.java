package com.porter.utils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;

import org.porter.R;

public class CustomProgress {

  private static Dialog progressDialog = null;
  public CustomProgress() {
    // do Nothing
  }

  public static void showProgressDialog(Context context, boolean cancellable) {
    removeProgressDialog();
    if (!isCallerFinishing(context)) {
      progressDialog = new Dialog(context, R.style.LightTheme_Translucent_NoTitleBar);
      if (progressDialog != null && !isCallerFinishing(context)) {
        LayoutInflater mInflater = LayoutInflater.from(context);

        View layout = mInflater.inflate(R.layout.loader, null);
        progressDialog.setContentView(layout);
      }

      progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
          switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
              return true;
            case KeyEvent.KEYCODE_SEARCH:
              return true;
          }
          return false;
        }
      });

      progressDialog.setCancelable(false);
      progressDialog.show();
    }
  }

  private static boolean isCallerFinishing(Context context) {
    Activity caller = (Activity) context;
    return caller.isFinishing();
  }

  public static void removeProgressDialog() {
    try {
      if (isShowing()) {
        progressDialog.dismiss();
        progressDialog = null;
      }
    } catch (Exception e) {

    }
  }

  public static boolean isShowing() {
    return progressDialog != null && progressDialog.isShowing();
  }
}
