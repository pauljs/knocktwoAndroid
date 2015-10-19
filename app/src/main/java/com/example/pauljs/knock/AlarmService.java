package com.example.pauljs.knock;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by pauljs on 10/19/2015.
 */
public class AlarmService extends IntentService {

    public AlarmService(String name) {
        super("services");
        // TODO Auto-generated constructor stub
    }

    public AlarmService() {
        super("services");
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager notificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        long when = System.currentTimeMillis() + 2000;
        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
                this).setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Knock has a new question from your doctor!")
                .setContentText("Click to answer the question").setSound(alarmSound)
                .setAutoCancel(true).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificationManager.notify(0, mNotifyBuilder.build());
        Toast.makeText(getApplicationContext(),
                "Service started: ", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(getApplicationContext(), "handling intent",
                Toast.LENGTH_LONG).show();


    }
}