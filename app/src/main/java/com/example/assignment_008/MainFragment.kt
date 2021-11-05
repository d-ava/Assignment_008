package com.example.assignment_008

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment_008.databinding.FragmentMainBinding
import kotlinx.coroutines.flow.collect


class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(FragmentMainBinding::inflate) {
    override fun getViewModel() = MainViewModel::class.java

    override var useSharedViewModel = false
    lateinit var horAdapter: HorizontalAdapter
    lateinit var verAdapter: VerticalAdapter

    override fun start() {
        setHorizontalRecycler()
        setVerticalRecycler()
        loadNewCources()
    }


    private fun setHorizontalRecycler() {

        horAdapter = HorizontalAdapter()
        val horLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHorizontal.adapter=horAdapter
        binding.recyclerHorizontal.layoutManager = horLayoutManager

    }


    private fun setVerticalRecycler() {
        verAdapter = VerticalAdapter()
        val verLayoutManager = LinearLayoutManager(context)
        binding.recyclerVertical.adapter=verAdapter
        binding.recyclerVertical.layoutManager = verLayoutManager


    }

    private fun loadNewCources(){
        viewModel.loadCources()
        lifecycleScope.launchWhenStarted {
            viewModel.cources.collect{
                verAdapter.setData(it)
                horAdapter.setData(it)
            }
        }
    }


}