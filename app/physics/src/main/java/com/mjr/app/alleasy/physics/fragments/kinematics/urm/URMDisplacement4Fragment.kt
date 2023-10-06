package com.mjr.app.alleasy.physics.fragments.kinematics.urm

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class URMDisplacement4Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("Si = ", "m"))
            add(Data("v = ", "m/s"))
            add(Data("∆t = ", "s"))
        }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {
    }
}