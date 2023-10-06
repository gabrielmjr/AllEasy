package com.mjr.app.alleasy.physics.fragments.kinematics.vum

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class VUMTime3 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("t = ", "s"))
            add(Data("∆v = ", "m/s"))
            add(Data("a = ", "m/s²"))
        }
    }

    override fun onCalculateClickListener() {}
}