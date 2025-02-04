package com.mpierucci.android.revolut.rates.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpierucci.android.revolut.databinding.ActivityRatesBinding
import com.mpierucci.android.revolut.di.appComponent
import com.mpierucci.android.revolut.rates.di.DaggerRatesComponent
import com.mpierucci.android.revolut.rates.domain.Result
import com.mpierucci.android.revolut.rates.presentation.AssistedViewModelProvider
import com.mpierucci.android.revolut.rates.presentation.RatesViewModel
import com.mpierucci.android.revolut.rates.presentation.savedStateVM
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RatesActivity : AppCompatActivity() {

    private val viewModel by savedStateVM { handle -> vmProvider.create(handle) }
    private val disposable = CompositeDisposable()
    private val adapter = RatesAdapter()
    private lateinit var binding: ActivityRatesBinding


    @Inject
    lateinit var vmProvider: AssistedViewModelProvider<RatesViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerRatesComponent.factory().create(appComponent).inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityRatesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRateList()


        viewModel.rates.observe(this, Observer {
            when (it) {
                is Result.Success -> adapter.submitList(it.data)
                is Result.Error -> {
                    binding.rates.visibility = View.GONE
                    binding.errorGroup.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.startPollingRates()
        disposable.add(adapter.rateClicked.throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe { viewModel.handleRateClicked(it) }
        )
        disposable.add(adapter.responderQuantityChanged.debounce(300, TimeUnit.MILLISECONDS)
            .subscribe { viewModel.handleResponderQuantityChanged(it.toString()) }
        )
    }

    override fun onStop() {
        super.onStop()
        viewModel.stopPollingRates()
        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun setUpRateList() {
        binding.rates.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rates.adapter = adapter
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
                binding.rates.scrollToPosition(0)
            }
        })
    }
}
