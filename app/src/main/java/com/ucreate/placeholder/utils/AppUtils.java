package com.ucreate.placeholder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by admin on 08-08-2017.
 */

public class AppUtils {

    /**
     * @return True if internet is working, Otherwise @return
     * False.
     */
    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    /**
     * Implements this method to call Intent
     * to next Activity.
     *
     * @param context     : Context of Activity
     * @param destination : Name of the destination Activity
     * @param isFinish    : Kill the app if True.
     */
    public static void callIntent(Activity context, Class destination, boolean isFinish) {
        Intent intent = new Intent(context, destination);
        context.startActivity(intent);

        if (isFinish) {
            context.finish();
        }
    }
}
