package com.morladim.recordsandstatistics.common.ui

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.morladim.recordsandstatistics.common.db.base.BaseEntity

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
class DefaultDbComparator<T : BaseEntity> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}