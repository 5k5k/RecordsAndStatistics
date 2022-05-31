package com.morladim.recordsandstatistics.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.morladim.recordsandstatistics.daily.DailyFragment
import com.morladim.recordsandstatistics.manage.ManageFragment
import com.morladim.recordsandstatistics.statistics.StatisticsFragment
import kotlin.reflect.KClass

const val DAILY_PAGE_INDEX = 0
const val STATISTICS_PAGE_INDEX = 1
const val MANAGE_PAGE_INDEX = 2

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragments: MutableMap<Int, () -> Fragment> by lazy {
        mutableMapOf(
            DAILY_PAGE_INDEX to { DailyFragment() },
            STATISTICS_PAGE_INDEX to { StatisticsFragment() },
            MANAGE_PAGE_INDEX to { ManageFragment() }
        )
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}