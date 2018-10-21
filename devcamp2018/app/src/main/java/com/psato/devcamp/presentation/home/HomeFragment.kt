package com.psato.devcamp.presentation.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.psato.devcamp.R
import com.psato.devcamp.databinding.FragmentHomeBinding
import com.psato.devcamp.presentation.base.BaseFragment
import com.psato.devcamp.presentation.search.QueryActivity

class HomeFragment : BaseFragment() {
    private var mBinding: FragmentHomeBinding? = null
    private lateinit var homeFragmentViewModel:HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mBinding = DataBindingUtil.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        mBinding?.let {
            it.viewModel = homeFragmentViewModel
            it.setLifecycleOwner(this)
            it.executePendingBindings()
        }
    }

    override fun onResume() {
        super.onResume()
        homeFragmentViewModel.startSearch.setObserve(this, Observer {
            startActivity(Intent(activity, QueryActivity::class.java))
        })
    }

    override fun onDestroyView() {
        mBinding = null
        super.onDestroyView()
    }
}
