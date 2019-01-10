package com.example.huynhvinh.kotlin_task1321

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.huynhvinh.kotlin_task1321.Config.MyObject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainView {


    lateinit var presenter:Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         var mainView:MainView = this as MainView
         presenter = Presenter(mainView)
         presenter.getDataURL()

    }

    override fun getData(myObject: MyObject) {
       textView.text = Html.fromHtml(myObject.data)
    }

}