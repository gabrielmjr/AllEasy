package com.mjr.app.alleasy.activity

import android.view.View
import com.mjr.app.alleasy.widget.Widgets.alertDialog
import com.mjr.app.alleasy.databinding.ActivitySettingsBinding
import com.mjr.app.alleasy.util.SettingsPreferences
import com.mjr.app.alleasy.widget.CustomRadioGroup
import java.util.ArrayList

class SettingsActivity: BaseActivity() {
    private lateinit var viewBinding: ActivitySettingsBinding
    private lateinit var settingsPreferences: SettingsPreferences

    override fun initializeActivity() {
        viewBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    override fun initializeAttributes() {
        settingsPreferences = SettingsPreferences(applicationContext)
        onChooseThemeClicked()
    }

    private fun onChooseThemeClicked() {
        viewBinding.themeChanger.root.setOnClickListener{
            val themeRadioGroup = CustomRadioGroup(applicationContext)
            themeRadioGroup.setTouchables(ArrayList<View>())
            val themeAlertDialog = alertDialog(applicationContext, themeRadioGroup.radioGroup)
        }
    }

    companion object {
        const val PT_CODE = "pt"
    }
}