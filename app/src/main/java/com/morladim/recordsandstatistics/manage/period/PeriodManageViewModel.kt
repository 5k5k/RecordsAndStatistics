package com.morladim.recordsandstatistics.manage.period

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.morladim.recordsandstatistics.common.db.PeriodEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author 5k5k
 * Created at 2023/3/28
 */
@HiltViewModel
class PeriodManageViewModel @Inject constructor(private val repository: PeriodManageRepository) : ViewModel() {

    fun getPagingData(): Flow<PagingData<PeriodEntity>> {
        return repository.getPagingData().cachedIn(viewModelScope)
    }
}