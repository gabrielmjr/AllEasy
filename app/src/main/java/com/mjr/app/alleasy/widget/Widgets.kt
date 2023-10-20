package com.mjr.app.alleasy.widget

import android.content.Context
import android.view.View
import androidx.appcompat.app.AlertDialog

object Widgets {
    fun alertDialog(context: Context, view: View): AlertDialog {
        return AlertDialog.Builder(context).apply {

        }.create()
    }
}