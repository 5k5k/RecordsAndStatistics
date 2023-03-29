package com.morladim.recordsandstatistics.manage

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.morladim.recordsandstatistics.databinding.ItemManageBinding
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author 5k5k
 * Created at 2022/7/19
 */
@Singleton
class ManageAdapter @Inject constructor() : RecyclerView.Adapter<ManageAdapter.ViewHolder>() {

    @Inject
    lateinit var repository: ManageItemRepository

    var listener: ManageFragment.OnManageItemClickListener? = null

    class ViewHolder(val binding: ItemManageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemManageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = repository.getManageList()[position]
        when (position) {
            0 -> {
                holder.binding.root.setOnClickListener { listener?.onTaskClick() }
            }
            1 -> {
                holder.binding.root.setOnClickListener { listener?.onPeriodClick() }
            }
            2 -> {
                holder.binding.root.setOnClickListener { listener?.onSystemClick() }
            }
        }
    }

    override fun getItemCount(): Int {
        return repository.getManageList().size
    }
}