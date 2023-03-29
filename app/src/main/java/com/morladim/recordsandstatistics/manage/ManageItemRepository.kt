package com.morladim.recordsandstatistics.manage

import android.content.Context
import com.morladim.recordsandstatistics.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author 5k5k
 * Created at 2022/7/19
 */
@Singleton
class ManageItemRepository @Inject constructor(@ApplicationContext val context: Context) {

    var cacheManageList: Array<String> = getManageListNoCache()

    fun getManageList(): Array<String> {
        return cacheManageList
    }

    private fun getManageListNoCache(): Array<String> {
        return context.resources.getStringArray(R.array.manage_items)
    }
}