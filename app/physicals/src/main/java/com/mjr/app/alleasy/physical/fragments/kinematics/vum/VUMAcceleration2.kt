package com.mjr.app.alleasy.physical.fragments.kinematics.vum

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class VUMAcceleration2 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("∆v = ", "m/s"))
            add(Data("ti = ", "s"))
            add(Data("t = ", "s"))
        }
    }

    override fun onCalculateClickListener() {}
}