package com.morladim.recordsandstatistics.common.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
open class BaseFragment : Fragment {

    constructor() : super()

    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)
}