package com.csf.pocketgithub.module.login.view.ui

import androidx.lifecycle.ViewModelProviders
import com.csf.pocketgithub.R
import com.csf.pocketgithub.base.BaseActivity
import com.csf.pocketgithub.databinding.ActivityLoginBinding
import com.csf.pocketgithub.module.login.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override fun initView() {

    }

    override fun initListener() {

    }

    override fun initData() {
        viewModelClass = LoginViewModel::class.java
        binding.data = viewModel
    }

}