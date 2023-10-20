package com.mjr.app.alleasy.fragment.physics.kinematics.vum

import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data

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