package br.com.evjdev.usingsomeapismvvm.presenter.main.view.activity

import android.os.Bundle
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.presenter.view.activity.BaseActivity

class  MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}