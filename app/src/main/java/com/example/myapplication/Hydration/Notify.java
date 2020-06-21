package com.example.myapplication.Hydration;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class Notificatiion extends Application {
    public static final String CHANNEL_1_ID = "channel1";


    public void onCreate(){
        super.onCreate();

        createNotificationChannels();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannels() {
        NotificationChannel channel1 = new NotificationChannel(
                CHANNEL_1_ID,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
        );
        channel1.setDescription("IT'S TIME TO DRINK WATER!");

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel1);
    }

}
