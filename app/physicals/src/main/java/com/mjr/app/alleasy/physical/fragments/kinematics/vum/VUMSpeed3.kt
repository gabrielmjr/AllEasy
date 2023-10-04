package com.mjr.app.alleasy.physical.fragments.kinematics.vum

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

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