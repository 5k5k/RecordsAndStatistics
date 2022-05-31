package com.morladim.recordsandstatistics.daily

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.morladim.recordsandstatistics.R
import com.morladim.recordsandstatistics.common.ui.BaseFragment

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
class DailyFragment : BaseFragment(R.layout.fragment_test) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tv = view.findViewById<TextView>(R.id.testText)
        tv.text = "1"
    }
}