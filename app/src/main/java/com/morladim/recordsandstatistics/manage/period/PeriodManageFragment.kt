package com.morladim.recordsandstatistics.manage.period

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.morladim.recordsandstatistics.R
import com.morladim.recordsandstatistics.common.ui.BaseBindingFragment
import com.morladim.recordsandstatistics.databinding.FragmentPeriodManageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author 5k5k
 * Created at 2023/3/27
 */
@AndroidEntryPoint
class PeriodManageFragment : BaseBindingFragment<FragmentPeriodManageBinding>(R.layout.fragment_period_manage) {

    private val viewModel by viewModels<PeriodManageViewModel>()

    @Inject
    lateinit var adapter: PeriodManagePagingDataAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.periodManageRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.periodManageRecyclerView.adapter = adapter
        lifecycleScope.launch {
            viewModel.getPagingData().collect { pagingData ->
                adapter.submitData(pagingData)
            }
        }
    }
}