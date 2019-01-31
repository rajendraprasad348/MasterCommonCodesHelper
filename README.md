# MasterCommonCodesHelper
This repository makes coding Easy.

# Version
 [![](https://jitpack.io/v/rajendraprasad348/MasterCommonCodesHelper.svg)](https://jitpack.io/#rajendraprasad348/MasterCommonCodesHelper)

# Description

Simple example shown in app section

This Repository contains all the basic codes such as Date conversion , showing alert dialogs , checking network status , show soft keyboard , hide soft keyboard and etc.

# installation

      Step1:  Add it in your root build.gradle at the end of repositories:
           allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}  
	
	Step2:  Add the dependency
         dependencies {
	        implementation 'com.github.rajendraprasad348:MasterCommonCodesHelper:1.0'
	} 
 
  
  
  # Usage
  
   /*Shows Alert dialog */
1.  MastersCommonCodes.Builder(MainActivity.this).showDialogCaller(MainActivity.this, "MasterCommonCodes", "This is an sample alert dialog from MasterCommonCodes....", false, "DONE", "TYPE");


    /*Shows progress dialog */
2.  MastersCommonCodes.Builder(MainActivity.this).showProgressIndicator(MainActivity.this, "MasterCommonCodes", "Loading", true);


    /* Hide progress dialog*/
3.  MastersCommonCodes.Builder(MainActivity.this).hideProgressIndicator(MainActivity.this);


    /* Shows network status availble or not*/
4. if (MastersCommonCodes.Builder(MainActivity.this).isNetworkAvailable(MainActivity.this)) {
     Snackbar.make(linearLayout, "Network available", Snackbar.LENGTH_LONG).show();
     } else {
     Snackbar.make(linearLayout, "Network Un-available", Snackbar.LENGTH_LONG).show(); }
     
     
    /* show keyboard on click of a view*/
5.  MastersCommonCodes.Builder(MainActivity.this).showSoftKeyboard(MainActivity.this);


    /* hide keyboard on click of a view*/
6.  MastersCommonCodes.Builder(MainActivity.this).hideSoftKeyboard(MainActivity.this, view);


    /* refresh current activity */
7.  MastersCommonCodes.Builder(MainActivity.this).currentActivityReload(MainActivity.this);
          
          
    /* next transition animation */
8.  MastersCommonCodes.Builder(MainActivity.this).activityNextSlideAnimation(MainActivity.this, SecondActivity.class);
            
            
    /* previous transition animation */
 9. MastersCommonCodes.Builder(MainActivity.this).activityPreviousSlideAnimation(MainActivity.this, SecondActivity.class);
                
    /* convert any date format into any date format by diving input format and output format*/
10. String date = "Jan 25, 2019 4:12:00 PM";
    String formatedDate = MastersCommonCodes.Builder(MainActivity.this).dateAndTimeConverter(date, "MMM dd, yyyy hh:mm:ss aaa", "dd MMM yyyy hh:mm a");
    MastersCommonCodes.Builder(MainActivity.this).showToast(MainActivity.this, formatedDate, 0);
    Log.d(TAG, "formatedDate: " + formatedDate);
          
          
    /*here duration 0= Toast.LENGTH_SHORT  and 1=Toast.LENGTH_LONG*/
11. MastersCommonCodes.Builder(MainActivity.this).showToast(MainActivity.this, "Hello MasterCommonCodes", 0);
            
            
    /* replace one fragment with any other fragment*/
12. MastersCommonCodes.Builder(MainActivity.this).replaceFragment(MyFragment,R.id.frame_container,true);
            
            
    /* before adding runtime permission for any permission please add uses-permission in manifest file of that specific permission*/
13. MastersCommonCodes.Builder(MainActivity.this).getRunTimePermission(MainActivity.this, Manifest.permission.CAMERA, 100);
               
               
    /* Showing current locations Lattitude ,Longitude and altitude */
14. if (MastersCommonCodes.Builder(MainActivity.this).getRunTimePermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION, 101)) {
    try {
    Snackbar.make(linearLayout, "Lattitude :" + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLatitude() + ",\n"+"Longitude : " + MastersCommonCodes.Builder(MainActivity.this).currentLocation(MainActivity.this).getLongitude(), Snackbar.LENGTH_LONG).show();
    } catch (Exception e) {
    e.printStackTrace();
    }
    

                 
