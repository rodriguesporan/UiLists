package com.rodriguesporan.uilists.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.adapter.SimpleDataItemAdapter
import com.rodriguesporan.uilists.presentation.viewmodel.SimpleDataItemViewModel
import kotlinx.coroutines.launch

internal class SimpleDataItemLinearFixedDataSetListActivity : AppCompatActivity() {

    private val viewModel: SimpleDataItemViewModel by viewModels { SimpleDataItemViewModel.Factory }
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_data_item_linear_fixed_data_set_list)
        collectStates()
        viewModel.getItems()
    }

    private fun collectStates() {
        lifecycleScope.launch {
            viewModel.uiState.collect { items ->
                recyclerView.adapter = SimpleDataItemAdapter(items)
            }
        }
    }
}
