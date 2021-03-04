package br.com.evjdev.usingsomeapismvvm_clean_architeture

import android.app.Application
import br.com.evjdev.usingsomeapismvvm_clean_architeture.resource.koin.mangaModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class UsingSomeAPISMVVM_Application : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@UsingSomeAPISMVVM_Application)
            modules(mangaModule)
        }
    }
}