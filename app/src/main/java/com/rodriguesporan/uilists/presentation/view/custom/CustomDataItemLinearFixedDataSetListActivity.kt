package com.rodriguesporan.uilists.presentation.view.custom

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.di.factories.viewmodel.CustomDataViewModelFactory
import com.rodriguesporan.uilists.presentation.adapter.DataViewAdapter
import kotlinx.coroutines.launch

internal class CustomDataItemLinearFixedDataSetListActivity : AppCompatActivity() {

    private val viewModel: CustomDataViewModel by viewModels { CustomDataViewModelFactory.create() }
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_data_item_linear_fixed_data_set_list)
        collectStates()
        viewModel.getItems()
    }

    private fun collectStates() {
        lifecycleScope.launch {
            viewModel.uiState.collect { items ->
                recyclerView.adapter = DataViewAdapter(items)
            }
        }
    }
}
