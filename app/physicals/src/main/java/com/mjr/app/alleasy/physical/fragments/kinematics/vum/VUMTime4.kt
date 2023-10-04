package com.mjr.app.alleasy.physical.fragments.kinematics.vum

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class VUMTime4 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("tf = ", "s"))
            add(Data("vi = ", "m/s"))
            add(Data("v = ", "m/s"))
            add(Data("a = ", "m/s²"))
        }
    }

    override fun onCalculateClickListener() {}
}