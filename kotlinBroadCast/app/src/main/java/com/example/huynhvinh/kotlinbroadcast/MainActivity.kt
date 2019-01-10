@file:Suppress("DEPRECATION")

package com.example.huynhvinh.kotlinbroadcast


import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1.*
import kotlinx.android.synthetic.main.fragment2.*


open class MainActivity : Activity() {

    var broadcastReceiver1: BroadcastReceiver? = null
    var broadcastReceiver2: BroadcastReceiver? = null

    var so1:Int = 0
    var so2:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            so1++
            val intent:Intent = Intent()
            intent.putExtra("key1",so1)
            intent.setAction("com.huynhvinh1")
            sendBroadcast(intent)
        }
        btn2.setOnClickListener {
            so2--
            val intent:Intent = Intent()
            intent.putExtra("key2",so2)
            intent.setAction("com.huynhvinh2")
            sendBroadcast(intent)
        }

    }

    fun initBroadCast(){
        val intentFilter1:IntentFilter = IntentFilter()
        intentFilter1.addAction("com.huynhvinh1")
        broadcastReceiver1 = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                textView1.text = intent.getIntExtra("key1",0).toString()

            }
        }
        registerReceiver(broadcastReceiver1,intentFilter1)
        val intentFilter2:IntentFilter = IntentFilter()
        intentFilter2.addAction("com.huynhvinh2")
        broadcastReceiver2 = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                textView2.text = intent.getIntExtra("key2",0).toString()

            }
        }
        registerReceiver(broadcastReceiver2,intentFilter2)

    }


    override fun onStart() {
        super.onStart()
        initBroadCast()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver1)
        unregisterReceiver(broadcastReceiver2)
    }

}