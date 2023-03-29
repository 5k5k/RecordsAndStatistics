package com.morladim.recordsandstatistics.manage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author 5k5k
 * Created at 2022/7/19
 */
@HiltViewModel
class ManageViewModel @Inject constructor() : ViewModel() {

//    val loadingViewModel: LoadingViewModel = LoadingViewModel()

    fun getManageList(): List<String> {
        return emptyList()
    }

}