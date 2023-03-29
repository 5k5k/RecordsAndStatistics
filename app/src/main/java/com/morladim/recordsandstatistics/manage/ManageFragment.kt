package com.morladim.recordsandstatistics.manage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.morladim.recordsandstatistics.R
import com.morladim.recordsandstatistics.common.ui.BaseBindingFragment
import com.morladim.recordsandstatistics.databinding.FragmentManageBinding
import com.morladim.recordsandstatistics.manage.period.PeriodManageRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * @author 5k5k
 * Created at 2022/5/31
 */
@AndroidEntryPoint
class ManageFragment : BaseBindingFragment<FragmentManageBinding>(R.layout.fragment_manage) {
    private val viewModel by viewModels<ManageViewModel>()

    @Inject
    lateinit var adapter: ManageAdapter

    @Inject
    lateinit var r: PeriodManageRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewModel = viewModel
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.listener = object : OnManageItemClickListener {
            override fun onTaskClick() {
                findNavController().navigate(R.id.action_home_view_pager_fragment_to_task_manage_fragment)
            }

            override fun onPeriodClick() {
                findNavController().navigate(R.id.action_home_view_pager_fragment_to_period_manage_fragment)
            }

            override fun onSystemClick() {

            }
        }
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        binding.recyclerView.adapter = adapter

//        withContext( Dispatchers.IO){
//
//        }

//        lifecycleScope.launch {
//            r.init()
////            withContext(Dispatchers.IO) {
////                r.init()
////            }
//        }
//        r.init1()
    }

    interface OnManageItemClickListener {

        fun onTaskClick()

        fun onPeriodClick()

        fun onSystemClick()

    }
}