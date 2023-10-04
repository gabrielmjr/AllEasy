package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class URMDisplacement6Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("Si = ", "m"))
            add(Data("∆S = ", "m"))
        }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}