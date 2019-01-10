package com.example.huynhvinh.kotlin_task1321

import android.text.Html
import android.util.Log
import com.example.huynhvinh.kotlin_task1321.Config.ApiService
import com.example.huynhvinh.kotlin_task1321.Config.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Presenter(private var mainView: MainView) {

    fun getDataURL(){

        Repository.createService(ApiService::class.java).getAndroidVersion("1.0")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        //cú pháp của rxjava trong kotlin
                        { result ->
                            mainView.getData(result)
                        },
                        { error ->
                            //request thất bai
                        }
                )
    }

}