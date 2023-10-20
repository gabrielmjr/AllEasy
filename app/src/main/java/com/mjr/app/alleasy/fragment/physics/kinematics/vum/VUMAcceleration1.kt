package com.mjr.app.alleasy.fragment.physics.kinematics.vum

import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data

class VUMAcceleration1 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("∆v = ", "m/s"))
            add(Data("∆t = ", "s"))
        }
    }

    override fun onCalculateClickListener() {}
}