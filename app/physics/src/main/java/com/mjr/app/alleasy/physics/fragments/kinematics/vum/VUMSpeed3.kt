package com.mjr.app.alleasy.physics.fragments.kinematics.vum

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class VUMSpeed3 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("v = ", "m/s"))
            add(Data("a = ", "m/s2"))
            add(Data("∆t = ", "s"))
        }
    }

    override fun onCalculateClickListener() {}
}