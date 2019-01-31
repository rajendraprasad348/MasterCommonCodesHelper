package com.rajendra_prasad.sample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.rajendra_prasad.mastercommoncodeshelper.MastersCommonCodes;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MastersCommonCodes";
    private Button mBtn_show_alert_diaog, mBtn_show_progress_diaolog, mBtn_hide_progress_dialog, mBtn_check_network_status, mBtn_show_soft_keyboard,
            mBtn_hide_soft_keyboard, mBtn_refresh_activity, mBtn_next_tranistion_animation,
            mBtn_previous_transition_animation, mBtn_date_converter, mBtn_show_toast, mBtn_replace_fragment, mBtn_runtime_permission, mBtn_current_location;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.total_layout);

        mBtn_show_alert_diaog = findViewById(R.id.show_dialog);
        mBtn_show_progress_diaolog = findViewById(R.id.show_progress_indicator);
        mBtn_hide_progress_dialog = findViewById(R.id.hide_progress);
        mBtn_check_network_status = findViewById(R.id.check_network);
        mBtn_show_soft_keyboard = findViewById(R.id.show_soft_keyboard);
        mBtn_hide_soft_keyboard = findViewById(R.id.hide_soft_keyboard);
        mBtn_refresh_activity = findViewById(R.id.activity_reload);
        mBtn_next_tranistion_animation = findViewById(R.id.next_transition);
        mBtn_previous_transition_animation = findViewById(R.id.previous_transition);
        mBtn_date_converter = findViewById(R.id.date_converter);
        mBtn_show_toast = findViewById(R.id.show_toast);
        mBtn_replace_fragment = findViewById(R.id.replace_fragment);
        mBtn_runtime_permission = findViewById(R.id.runtime_permission);
        mBtn_current_location = findViewById(R.id.current_location);

        mBtn_show_alert_diaog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Showing alert diaolg */
                MastersCommonCodes.Builder(MainActivity.this).showDialogCaller(MainActivity.this, "MasterCommonCodes", "This is an sample alert dialog from MasterCommonCodes....", false, "DONE", "TYPE");
            }
        });

        mBtn_show_progress_diaolog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Shows progress dialog */
                MastersCommonCodes.Builder(MainActivity.this).showProgressIndicator(MainActivity.this, "MasterCommonCodes", "Loading", true);
            }
        });
        mBtn_hide_progress_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Hide progress dialog*/
                MastersCommonCodes.Builder(MainActivity.this).hideProgressIndicator(MainActivity.this);
            }
        });
        mBtn_check_network_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Shows network status availble or not*/
                if (MastersCommonCodes.Builder(MainActivity.this).isNetworkAvailable(MainActivity.this)) {
                    Snackbar.make(linearLayout, "Network available", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(linearLayout, "Network Un-available", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        mBtn_show_soft_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* show keyboard on click of a view*/
                MastersCommonCodes.Builder(MainActivity.this).showSoftKeyboard(MainActivity.this);
            }
        });
        mBtn_hide_soft_keyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* hide keyboard on click of a view*/
                MastersCommonCodes.Builder(MainActivity.this).hideSoftKeyboard(MainActivity.this, v);
            }
        });


        mBtn_refresh_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* refresh current activity */
                MastersCommonCodes.Builder(MainActivity.this).currentActivityReload(MainActivity.this);
            }
        });

        mBtn_next_tranistion_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* next transition animation */
                MastersCommonCodes.Builder(MainActivity.this).activityNextSlideAnimation(MainActivity.this, SecondActivity.class);
            }
        });
        mBtn_previous_transition_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* previous transition animation */
                MastersCommonCodes.Builder(MainActivity.this).activityPreviousSlideAnimation(MainActivity.this, SecondActivity.class);
            }
        });
        mBtn_date_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* convert any date format into any date format by diving input format and output format*/

                String date = "Jan 25, 2019 4:12:00 PM";

                String formatedDate = MastersCommonCodes.Builder(MainActivity.this).dateAndTimeConverter(date, "MMM dd, yyyy hh:mm:ss aaa", "dd MMM yyyy hh:mm a");

                MastersCommonCodes.Builder(MainActivity.this).showToast(MainActivity.this, formatedDate, 0);
                Log.d(TAG, "formatedDate: " + formatedDate);

            }
        });
        mBtn_show_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*here duration 0= Toast.LENGTH_SHORT  and 1=Toast.LENGTH_LONG*/
                MastersCommonCodes.Builder(MainActivity.this).showToast(MainActivity.this, "Hello MasterCommonCodes", 0);

            }
        });
        mBtn_replace_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* replace one fragment with any other fragment*/
//                MastersCommonCodes.Builder(MainActivity.this).replaceFragment(MyFragment,R.id.frame_container,true);

            }
        });
        mBtn_runtime_permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* before adding runtime permission for any permission please add uses-permission in manifest file of that specific permission*/
                MastersCommonCodes.Builder(MainActivity.this).getRunTimePermission(MainActivity.this, Manifest.permission.CAMERA, 100);
            }
        });


        mBtn_current_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Showing current locations Lattitude ,Longitude and altitude */
                if (MastersCommonCodes.Builder(MainActivity.this).getRunTimePermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION, 101)) {
                    try {
                        Snackbar.make(linearLayout, "Lattitude :" + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLatitude() + ",\n"
                                + "Longitude : " + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLongitude(), Snackbar.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        /* similarly request for all these permissions

        PERMISSION_CAMERA = Manifest.permission.CAMERA;
        PERMISSION_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
        PERMISSION_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
        PERMISSION_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
        PERMISSION_COARCE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
        PERMISSION_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
        PERMISSION_READ_CONTACTS = Manifest.permission.READ_CONTACTS;
        PERMISSION_READ_SMS = Manifest.permission.READ_SMS;
        PERMISSION_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
        PERMISSION_SEND_SMS = Manifest.permission.SEND_SMS;
        PERMISSION_WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
        PERMISSION_GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
        PERMISSION_CALL_PHONE = Manifest.permission.CALL_PHONE;
        PERMISSION_RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
        PERMISSION_BLUETOOTH = Manifest.permission.BLUETOOTH;
        */

        switch (requestCode) {
            case 100: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Camera permission granted.", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    Toast.makeText(MainActivity.this, "Camera permission Denied ", Toast.LENGTH_SHORT)
                            .show();
                }
            }
            break;
            case 101: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Snackbar.make(linearLayout, "Lattitude :" + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLatitude() + ",\n"
                            + "Longitude : " + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLongitude(), Snackbar.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Location permission Denied ", Toast.LENGTH_SHORT)
                            .show();
                }
            }
            break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


}
