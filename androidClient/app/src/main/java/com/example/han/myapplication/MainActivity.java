package com.example.han.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="myFcm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("notice");
        String token=FirebaseInstanceId.getInstance().getToken();
        Log.e(TAG,token); //user deviceID
    }

    public void click(View v){
        AtomicInteger msgId=new AtomicInteger();
        FirebaseMessaging fm=FirebaseMessaging.getInstance();
        fm.send(new RemoteMessage.Builder("your sender ID" + "@gcm.googleapis.com") //TODO input your FCM senderId
                .setMessageId(Integer.toString(msgId.incrementAndGet()))
                .addData("msg1", "Hello World")
                .addData("msg2","Hello fcm")
                .build());

    }
}
