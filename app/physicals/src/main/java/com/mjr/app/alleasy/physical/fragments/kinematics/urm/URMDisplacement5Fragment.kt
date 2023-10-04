package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class URMDisplacement5Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("S = ", "m"))
            add(Data("Si = ", "m"))
        }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}