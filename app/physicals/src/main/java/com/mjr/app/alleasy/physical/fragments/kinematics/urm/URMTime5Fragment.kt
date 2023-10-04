package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class URMTime5Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("ti = ", "s"))
            add(Data("∆t = ", "s"))
        }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}