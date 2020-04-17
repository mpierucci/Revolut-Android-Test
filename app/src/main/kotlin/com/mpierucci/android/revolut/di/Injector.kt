package com.mpierucci.android.revolut.di

import androidx.appcompat.app.AppCompatActivity
import com.mpierucci.android.revolut.init.RevolutApp

val AppCompatActivity.appComponent
    get() = (applicationContext as RevolutApp).appComponent