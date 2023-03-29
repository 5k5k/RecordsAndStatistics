package com.morladim.recordsandstatistics.manage.period

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.morladim.recordsandstatistics.common.db.PeriodEntity
import com.morladim.recordsandstatistics.common.ui.DefaultDbComparator
import com.morladim.recordsandstatistics.databinding.ItemPeriodManageBinding
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@Singleton
class PeriodManagePagingDataAdapter @Inject constructor() :
    PagingDataAdapter<PeriodEntity, PeriodManagePagingDataAdapter.ViewHolder>(DefaultDbComparator<PeriodEntity>()) {

    class ViewHolder(val binding: ItemPeriodManageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.binding.name.text = item.displayName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPeriodManageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}