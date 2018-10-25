package com.psato.devcamp.presentation.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.psato.devcamp.R
import com.psato.devcamp.infrastructure.bindView
import com.psato.devcamp.infrastructure.onClick
import com.psato.devcamp.presentation.base.BaseFragment
import com.psato.devcamp.presentation.search.QueryActivity

class HomeFragment : BaseFragment() {
    private lateinit var homeFragmentViewModel: HomeFragmentViewModel
    val mvvmButton: Button by bindView(R.id.mvvm_button)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        mvvmButton.onClick {
            homeFragmentViewModel.onMVVMClicked(it)
        }
        homeFragmentViewModel.startSearch.observe(this, Observer {
            startActivity(Intent(activity, QueryActivity::class.java))
        })
    }
}
