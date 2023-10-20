package com.mjr.app.alleasy

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.mjr.app.alleasy.activity.BaseActivity
import com.mjr.app.alleasy.activity.SettingsActivity
import com.mjr.app.alleasy.model.Subtitle
import com.mjr.app.alleasy.fragment.HomeFragment
import com.mjr.app.alleasy.util.SettingsPreferences

class MainActivity : BaseActivity() {
    private var homeFragment: HomeFragment? = null


    override fun run() {
        if (isAppInitialized) {
            setContentView(R.layout.activity_main)
            SettingsPreferences(applicationContext)
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
                    .replace(R.id.view_container, homeFragment!!, homeFragment!!.tag)
                    .commit()
        } catch (e: IllegalStateException) {
            throw e
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings -> {
                Intent(applicationContext, SettingsActivity::class.java).apply {
                    startActivity(this)
                }
                true
            } else -> false
        }
    }

    companion object {
        private var isAppInitialized = false
    }
}