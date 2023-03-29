package com.morladim.recordsandstatistics.common.db.base

import java.util.*

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
open class BaseEntity {
    open val id: Int? = null
    open val createAt: Date? = null
    open val updateAt: Date? = null
    open val del: Boolean? = false
}