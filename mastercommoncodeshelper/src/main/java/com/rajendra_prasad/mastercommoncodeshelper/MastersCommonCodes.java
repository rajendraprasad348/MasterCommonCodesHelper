package com.rajendra_prasad.mastercommoncodeshelper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MastersCommonCodes {
    private static final String TAG = "MastersCommonCodes";
    private ProgressDialog pd;
    private FragmentManager fragmentManager;
    private Activity activity;
    private GPSTracker gps;

    private MastersCommonCodes(Activity activity) {
        this.activity = activity;
    }

    public static MastersCommonCodes Builder(Activity activity) {
        return new MastersCommonCodes(activity);
    }


    // show alert dialog with positive button
    public void showDialogCaller(Context context, String Title, String Message, boolean IsCancelable, String PositiveButtonText, String Type) {
        try {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
            builder1.setTitle(Title);
            builder1.setMessage(Message);
            builder1.setCancelable(IsCancelable);

            builder1.setPositiveButton(
                    PositiveButtonText,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();
        } catch (Exception e) {
            Log.d(TAG, "ShowAlertDialog: " + e);
        }
    }

    // show progress dialog
    public void showProgressIndicator(Context context, String Title, String Message, boolean isCancelable) {
        try {
            pd = new ProgressDialog(context);
            pd.setMessage(Message);
            pd.setTitle(Title);
            pd.setCancelable(isCancelable);
            pd.show();
        } catch (Exception e) {
            Log.d(TAG, "ShowProgressIndicator: " + e);
        }
    }

    // hide progress dialog
    public void hideProgressIndicator(Context context) {
        if (pd != null) {
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
    }

    // check internet state
    public boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = null;
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            Log.d(TAG, "isNetworkAvailable: " + e);
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    // hide keyboard
    public void hideSoftKeyboard(Context context, View view) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            Log.d(TAG, "HideSoftKeyboard: " + e);
        }
    }

    // show keyboard
    public void showSoftKeyboard(Activity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        } catch (Exception e) {
            Log.d(TAG, "ShowSoftKeyboard: " + e);
        }
    }

    // reload current activity without animation
    public void currentActivityReload(Activity activity) {
        try {
            activity.finish();
            activity.overridePendingTransition(0, 0);
            activity.startActivity(activity.getIntent());
            activity.getIntent().addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            activity.overridePendingTransition(0, 0);
        } catch (Exception e) {
            Log.d(TAG, "ActivityReload: " + e);
        }
    }

    // Activity slide animation for next click page
    public void activityNextSlideAnimation(Activity context, Class<?> nextActivity) {
        try {
            Intent intent = new Intent(context, nextActivity);
            context.startActivity(intent);
            context.overridePendingTransition(R.anim.right_in, R.anim.left_out);
        } catch (Exception e) {
            Log.d(TAG, "activityNextSlideAnimation: " + e);
        }
    }

    // Activity slide animation for back click page
    public void activityPreviousSlideAnimation(Activity context, Class<?> previousActivity) {
        try {
            Intent intent = new Intent(context, previousActivity);
            context.startActivity(intent);
            context.overridePendingTransition(R.anim.left_in, R.anim.right_out);
        } catch (Exception e) {
            Log.d(TAG, "activityPreviousSlideAnimation: " + e);
        }
    }

    // Convert one date format to another date format
    public String dateAndTimeConverter(String date, String inputFormat, String outputFormat) {
        String newFormat = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
            Date testDate = null;
            try {
                testDate = sdf.parse(date);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
            newFormat = formatter.format(testDate);
        } catch (Exception e) {
            Log.d(TAG, "dateConverter: " + e);
        }
        return newFormat;
    }

    // Replace fragment with other fragment
    public void replaceFragment(Fragment fragment, int frameContainer, Boolean addToBackStack) {
        try {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(frameContainer, fragment);
            if (addToBackStack) {
                Log.d("COFFEE", TAG + "Added to Stack");
                fragmentTransaction.addToBackStack(TAG);
            }
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.commit();
        } catch (Exception e) {
            Log.d(TAG, "changeFragment: " + e);
        }
    }

    // show toast message
    public void showToast(Context context, String message, int duration) {
        try {
            Toast.makeText(context, message, duration).show();
        } catch (Exception e) {
            Log.d(TAG, "showToast: " + e);
        }
    }

    // get Current Location
    public Location currentLocation(Context context) {
        Double lattitude = null, longitude = null;
        Location location = null;

        try {
            gps = new GPSTracker(context);
            if (gps.canGetLocation()) {

                lattitude = gps.getLatitude();
                location = gps.getLocation();
                longitude = gps.getLongitude();

            } else {
                gps.showSettingsAlert();
            }
        } catch (Exception e) {
            Log.d(TAG, "currentLocation: " + e);
        }
        return location;
    }


    /* Runtime permisions
    override onRequestpermissionsforresult method in activity or fragment to get the result
    */
    public boolean getRunTimePermission(Context context, String permision, int RequestCode) {
        try {
            int MyVersion = Build.VERSION.SDK_INT;
            if (MyVersion > Build.VERSION_CODES.LOLLIPOP_MR1) {
                if (!checkIfAlreadyhavePermission(context, permision)) {
                    requestForSpecificPermission(context, permision, RequestCode);
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "getRunTimePermission: " + e);
        }
        return true;
    }

    private void requestForSpecificPermission(Context context, final String permission, int RequestCode) {
        try {
            ActivityCompat.requestPermissions((Activity) context, new String[]{permission}, RequestCode);
        } catch (Exception e) {
            Log.d(TAG, "requestForSpecificPermission: " + e);
        }
    }

    private boolean checkIfAlreadyhavePermission(Context context, String permission) {
        int result = 0;
        if (context != null)
            result = ContextCompat.checkSelfPermission(context, permission);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
}
