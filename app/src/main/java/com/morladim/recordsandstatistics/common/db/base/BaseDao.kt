package com.morladim.recordsandstatistics.common.db.base

/**
 * @author 5k5k
 * Created at 2023/3/28
 */
interface BaseDao<T : BaseEntity> {

    suspend fun getByPage(limit: Int, offset: Int): Array<T>

}
