package com.nainfox.choc2_content01.util;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by yjk on 2017. 6. 27..
 */

public class FragmentUtil {
    private final String TAG = "### FragmentUtil";


    //액티비티 단에서 프래그먼트 교체
    public void changeFragment(Activity activity, Fragment fragment, int layout){
        try {
            FragmentManager fragmentManager = activity.getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(layout, fragment);
            fragmentTransaction.commit();
        }catch (Exception e){
            Log.d(TAG,"changeFragment error : "+e.getMessage());
        }
    }



}
