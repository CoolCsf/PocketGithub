package com.csf.pocketgithub.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseActivity<BD : ViewDataBinding, T : ViewModel>(private val layoutId: Int) : AppCompatActivity() {
    protected lateinit var binding: BD
    protected lateinit var viewModelClass: Class<T>
    protected val viewModel by lazy {
        ViewModelProviders.of(this).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        initView()
        initListener()
        initData()
    }
    abstract fun initView()
    abstract fun initListener()
    abstract fun initData()
}
