package br.com.evjdev.usingsomeapismvvm_clean_architeture.resource.utils

import android.content.Context

abstract class MainContext {

    companion object {
        lateinit var context: Context
    }
}