package com.rodriguesporan.uilists.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.adapter.CardMessageAdapter
import com.rodriguesporan.uilists.data.CardMessageDatasource

class CustomDataItemLinearFixedDataSetListActivity : AppCompatActivity() {

    private val datasource: CardMessageDatasource = CardMessageDatasource()
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_data_item_linear_fixed_data_set_list)
        setViews()
    }

    private fun setViews() {
        recyclerView.adapter = CardMessageAdapter(datasource.listCardsUntil(10))
    }
}
