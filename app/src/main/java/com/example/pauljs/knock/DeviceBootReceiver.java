//package com.example.pauljs.knock;
//
//import android.app.AlarmManager;
//import android.app.NotificationManager;
//import android.app.PendingIntent;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.media.RingtoneManager;
//import android.net.Uri;
//import android.support.v4.app.NotificationCompat;
//import android.util.Log;
//import android.widget.Toast;
//
//import java.util.Calendar;
//
///**
// * Created by pauljs on 10/19/2015.
// */
//public class DeviceBootReceiver extends BroadcastReceiver {
//
//    @Override
//    public void onReceive(Context context, Intent called_intent) {
//        if(Intent.ACTION_BOOT_COMPLETED.equals(called_intent.getAction())) {
//            Calendar calendar = Calendar.getInstance();
//            Log.i("DATE EMERGENCY", calendar.toString());
//            calendar.set(Calendar.HOUR_OF_DAY, 14);
//            calendar.set(Calendar.MINUTE, 55);
//            Intent intent1 = new Intent(context, AlaramReceiver.class);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,intent1, 0);
//            AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
//            am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
//        }
//
//    }
//}
