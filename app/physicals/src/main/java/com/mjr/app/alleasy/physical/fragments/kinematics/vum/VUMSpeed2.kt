package com.mjr.app.alleasy.physical.fragments.kinematics.vum

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class VUMSpeed2 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("ti = ", "s"))
            add(Data("t = ", "s"))
            add(Data("a = ", "m/s²"))
        }
    }

    override fun onCalculateClickListener() {}
}