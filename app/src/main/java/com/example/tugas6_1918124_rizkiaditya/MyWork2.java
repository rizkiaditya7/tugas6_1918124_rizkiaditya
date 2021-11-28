package com.example.tugas6_1918124_rizkiaditya;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWork2 extends Worker {

    public MyWork2(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        displayNotification("Ini adalah Task Anda", "Anda Memilih Basket");
        return Result.success();
    }

    private void displayNotification(String task, String desc) {

        NotificationManager manager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel("mw2",
                "test123", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                "mw2")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE);


        manager.notify(1, builder.build());
    }
}