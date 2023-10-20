package com.mjr.app.alleasy.widget

import android.content.Context
import android.view.View
import android.widget.RadioGroup
import androidx.core.view.get
import java.util.ArrayList

class CustomRadioGroup(private var context: Context) {
    var radioGroup: RadioGroup = RadioGroup(context)

    fun setTouchables(touchables: ArrayList<View>) {
        radioGroup.addTouchables(touchables)
    }

    fun setChecked(index: Int) {
        radioGroup.check(radioGroup[index].id)
    }
}