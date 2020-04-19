package com.mpierucci.android.revolut.rates.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpierucci.android.revolut.databinding.ActivityRatesBinding
import com.mpierucci.android.revolut.di.appComponent
import com.mpierucci.android.revolut.rates.di.DaggerRatesComponent
import com.mpierucci.android.revolut.rates.presentation.RatesViewModel
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider

class RatesActivity : AppCompatActivity() {

    private val viewModel by viewModel { vmProvider.get() }
    private val disposable = CompositeDisposable()
    private val adapter = RatesAdapter()
    private lateinit var binding: ActivityRatesBinding


    @Inject
    lateinit var vmProvider: Provider<RatesViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerRatesComponent.factory().create(appComponent).inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityRatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRateList()


        viewModel.rates.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun onStart() {
        super.onStart()
        disposable.add(adapter.rateClicked.throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe { viewModel.handleRateClicked(it) }
        )
        disposable.add(adapter.responderQuantityChanged.debounce(300, TimeUnit.MILLISECONDS)
            .subscribe { viewModel.handleResponderQuantityChanged(it.toString()) }
        )
    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun setUpRateList() {
        binding.rates.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rates.adapter = adapter
    }
}
