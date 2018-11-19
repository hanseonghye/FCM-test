package com.example.han.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){
        Log.e("click","start send");
        AtomicInteger msgId=new AtomicInteger();
        FirebaseMessaging fm=FirebaseMessaging.getInstance();
        fm.send(new RemoteMessage.Builder("your sender key" + "@gcm.googleapis.com")
                .setMessageId(Integer.toString(msgId.incrementAndGet()))
                .addData("msg1", "Hello World")
                .addData("msg2","Hello fcm")
                .build());

    }
}
