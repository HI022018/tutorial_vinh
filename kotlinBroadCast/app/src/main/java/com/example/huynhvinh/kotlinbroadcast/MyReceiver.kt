package com.example.huynhvinh.kotlinbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent


@Suppress("DEPRECATION")
class MyReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {

        if(intent.action.equals("com.huynhvinh"))
        {


        }

    }
}