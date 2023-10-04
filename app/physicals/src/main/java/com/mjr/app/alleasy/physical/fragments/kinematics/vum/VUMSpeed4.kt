package com.mjr.app.alleasy.physical.fragments.kinematics.vum

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

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