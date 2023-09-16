package com.example.prototype_alpha.utilities;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class BackPressedHandler {
    public static void onBackPressed(final Activity activity) {
        new AlertDialog.Builder(activity)
                //functions if clicked "yes"
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                })
                //functions if clicked "no"
                .setNegativeButton("No", null)
                .show();
    }
}