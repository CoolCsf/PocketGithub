package com.csf.pocketgithub.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<BD : ViewDataBinding>(private val layoutId: Int) : AppCompatActivity() {
    lateinit var binding: BD
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
