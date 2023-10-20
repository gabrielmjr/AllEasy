package com.mjr.app.alleasy.model

import android.content.Context
import com.mjr.app.alleasy.fragment.BaseFragment

open class Subtitle {
    lateinit var label: CharSequence
    lateinit var fragment: BaseFragment

    constructor()

    constructor(label: CharSequence, fragment: BaseFragment) {
        this.label = label
        this.fragment = fragment
    }

    companion object {
        lateinit var context: Context
    }
}