package com.mjr.app.alleasy.fragment.physics.kinematics.vum

import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data

class VUMTime6 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("ti = ", "s"))
            add(Data("vi = ", "m/s"))
            add(Data("v = ", "m/s"))
            add(Data("a = ", "m/s²"))
        }
    }

    override fun onCalculateClickListener() {}
}