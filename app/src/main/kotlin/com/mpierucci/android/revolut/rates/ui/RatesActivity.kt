package com.mpierucci.android.revolut.rates.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mpierucci.android.revolut.R
import com.mpierucci.android.revolut.di.appComponent
import com.mpierucci.android.revolut.rates.di.DaggerRatesComponent

class RatesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerRatesComponent.factory().create(appComponent).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rates)
    }
}
