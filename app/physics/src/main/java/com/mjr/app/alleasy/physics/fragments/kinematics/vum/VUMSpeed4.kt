package com.mjr.app.alleasy.physics.fragments.kinematics.vum

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class VUMSpeed4 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("vi = ", "m/s"))
            add(Data("a = ", "m/s²"))
            add(Data("∆t = ", "s"))
        }
    }

    override fun onCalculateClickListener() {}
}