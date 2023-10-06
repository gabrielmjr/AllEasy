package com.mjr.app.alleasy

import android.view.Menu
import com.mjr.app.alleasy.activity.BaseActivity
import com.mjr.app.alleasy.core.model.Subtitle
import com.mjr.app.alleasy.fragment.HomeFragment

class MainActivity : BaseActivity() {
    private var homeFragment: HomeFragment? = null


    override fun run() {
        if (isAppInitialized) {
            setContentView(R.layout.activity_main)
            getViews()
            initializeAttributes()
            setListeners()
        } else {
            setContentView(R.layout.splash_screen)
            handler.postDelayed(
                {
                    isAppInitialized = true
                    run()
                }, 3000
            )
        }
    }

    override fun getViews() {
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun initializeAttributes() {
        homeFragment = HomeFragment()
        Subtitle.context = applicationContext
        try {
            supportFragmentManager.beginTransaction()
                    .replace(com.mjr.app.alleasy.core.R.id.view_container, homeFragment!!, homeFragment!!.tag)
                    .commit()
        } catch (e: IllegalStateException) {
            throw e
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    companion object {
        private var isAppInitialized = false
    }
}