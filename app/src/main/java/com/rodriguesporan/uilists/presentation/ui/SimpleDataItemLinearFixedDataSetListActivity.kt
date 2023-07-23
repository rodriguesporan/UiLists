package com.rodriguesporan.uilists.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.rodriguesporan.uilists.R
import com.rodriguesporan.uilists.adapter.AffirmationAdapter
import com.rodriguesporan.uilists.data.AffirmationDatasource

internal class TextDataItemLinearFixedDataSetListActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }
    private val datasource: AffirmationDatasource = AffirmationDatasource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_data_item_linear_fixed_data_set_list)
        setViews()
    }

    private fun setViews() {
        recyclerView.adapter = AffirmationAdapter(datasource.listAffirmationsUntil(100))
    }
}
