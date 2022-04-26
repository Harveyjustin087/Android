/*
 * PROG3210 Final Assignment
 * Card Bidders 2021
 * By: Justin Harvey
 * Notification Class
 * Professor: Pratiksha Mahendrabhai Raval
 * November/December 2021
 * */
package com.example.cardbidders;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
// This class is to set up the Notification to the user's phone after placing a bid.
public class NotificationService extends Service {
    /**
     * This Method builds the Notification presented to the user when placing the bid should they
     * have an SDK version it will run with.
     * @param intent Parameter 1.
     * @param flags Parameter 2.
     * @param startId Parameter 3.
     * @return int
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(5000);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        final String channel_id = "Card Bidders 2021";
        // Ensure SDK version is applicable for Notifications newer than Oreo
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            NotificationChannel notification = new NotificationChannel(channel_id,channel_id, NotificationManager.IMPORTANCE_DEFAULT);

            getSystemService(NotificationManager.class).createNotificationChannel(notification);

            Intent newIntent = new Intent(getApplicationContext(), BidPlacement.class);

            PendingIntent pending = PendingIntent.getActivity(getApplicationContext(),0, newIntent,0);

            Notification.Builder builder = new Notification.Builder(this, channel_id)
                    .setSmallIcon(R.drawable.cardicon)
                    .setContentTitle("Thank You!")
                    .setContentText("Thank you for Bidding with Card Bidders 2021");
            startForeground(555,builder.build());

        }
        return super.onStartCommand(intent,flags,startId);
    }
    /**
     * This Method auto generated binds the notification to the intent
     * @param intent Parameter 1.
     * @return IBinder
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
