package com.mjr.app.alleasy.fragment.physics.kinematics.urm

import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data

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