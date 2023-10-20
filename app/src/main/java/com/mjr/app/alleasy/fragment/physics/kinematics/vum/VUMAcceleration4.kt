package com.mjr.app.alleasy.fragment.physics.kinematics.vum

import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data

class VUMAcceleration4 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("vi = ", "m/s"))
            add(Data("v = ", "m/s"))
            add(Data("ti =", "s"))
            add(Data("t = ", "s"))
        }
    }

    override fun onCalculateClickListener() {}
}