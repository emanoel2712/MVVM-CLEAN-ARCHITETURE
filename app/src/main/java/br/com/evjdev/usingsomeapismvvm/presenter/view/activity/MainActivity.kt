package br.com.evjdev.usingsomeapismvvm.presenter.main.view.activity

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import br.com.evjdev.usingsomeapismvvm.R
import br.com.evjdev.usingsomeapismvvm.databinding.ActivityMainBinding
import br.com.evjdev.usingsomeapismvvm.presenter.view.activity.BaseActivity
import br.com.evjdev.usingsomeapismvvm.presenter.viewmodel.GlobalViewModel
import br.com.evjdev.usingsomeapismvvm.resource.utils.MainContext
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : BaseActivity() {

    companion object {
        const val ID_HOME = 101
        const val ID_NOTI = 102
        const val ID_SETTINGS = 103
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.setupUI()
        this.setupTabBar()
        this.preSetupFragment()
    }

    private fun setupUI() {
        MainContext.context = applicationContext

        this.window.statusBarColor = ContextCompat.getColor(this, R.color.colorMain)
        this.binding.toolbar.root.visibility = View.GONE
    }

    private fun setupTabBar() {
        this.binding.mainTabBar.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        this.binding.mainTabBar.add(MeowBottomNavigation.Model(ID_SETTINGS, R.drawable.ic_settings))
    }

    private fun preSetupFragment() {
        this.binding.mainTabBar.show(ID_HOME)
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.mainMenuFragment, GlobalViewModel.sharedInstance.navHostFragment)
            .setPrimaryNavigationFragment(GlobalViewModel.sharedInstance.navHostFragment).commit()
        this.supportActionBar?.hide()
    }
}