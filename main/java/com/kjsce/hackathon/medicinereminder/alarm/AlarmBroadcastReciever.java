package com.kjsce.hackathon.medicinereminder.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by anant on 30/9/16.
 */

public class AlarmBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent launchIntent = new Intent(context, ReminderActivity.class);
        context.startActivity(launchIntent);
    }
}
