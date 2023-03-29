package com.morladim.recordsandstatistics.common.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.morladim.recordsandstatistics.common.db.base.BaseDao
import com.morladim.recordsandstatistics.common.db.base.BaseEntity
import javax.inject.Inject

/**
 * @author 5k5k
 * Created at 2023/3/28
 */
class DefaultPagingSource<E : BaseEntity, T : BaseDao<E>> @Inject constructor(private val dao: T) : PagingSource<Int, E>() {
    override fun getRefreshKey(state: PagingState<Int, E>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, E> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize
            val offset = (page - 1) * pageSize * 3
            //为了支持协程加入suspend
            val entities = dao.getByPage(pageSize, offset)
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (entities.isNotEmpty()) page + 1 else null
            LoadResult.Page(entities.asList(), prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}