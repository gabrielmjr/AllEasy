package com.mjr.app.alleasy.physics.fragments.kinematics.urm

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

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