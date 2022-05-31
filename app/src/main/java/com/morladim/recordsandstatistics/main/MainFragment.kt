package com.morladim.recordsandstatistics.main

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.fragment.app.viewModels
import com.morladim.recordsandstatistics.R
import com.morladim.recordsandstatistics.common.ui.BaseBindingFragment
import com.morladim.recordsandstatistics.common.ui.NavigationViewMediator
import com.morladim.recordsandstatistics.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
@AndroidEntryPoint
class MainFragment : BaseBindingFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val mainViewModel by viewModels<MainFragmentViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = MainViewPagerAdapter(this)
        NavigationViewMediator(binding.tabs, binding.viewPager) { tab, _ ->
            //先写着以后调整
//            viewPager2.isSaveEnabled = false
//                        viewPager2.isUserInputEnabled = false
            //去掉长按toast
            (tab.getChildAt(0) as? ViewGroup)?.children?.forEach { it.setOnLongClickListener { true } }
        }.attach()
    }
}