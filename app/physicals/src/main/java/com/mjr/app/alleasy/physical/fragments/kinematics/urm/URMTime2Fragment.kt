package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class URMTime2Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
       datas.apply {
           add(Data("∆S = ", "m"))
           add(Data("∆v = ", "m/s"))
       }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}